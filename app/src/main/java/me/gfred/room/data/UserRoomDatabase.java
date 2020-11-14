package me.gfred.room.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class}, version = 1)
public  abstract class UserRoomDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static volatile UserRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static UserRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.
                            databaseBuilder(context, UserRoomDatabase.class, "user_database")
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    UserDao dao = INSTANCE.userDao();
                                    User user1 =
                                            new User(1L, "John Smith", "johnsmith@gmail.co", "password");
                                    User user2 =
                                            new User(2L, "Larry Page", "larry@gmail.co", "password");
                                    User user3 =
                                            new User(3L, "Sergey Brin", "sergey@gmail.co", "password");
                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
