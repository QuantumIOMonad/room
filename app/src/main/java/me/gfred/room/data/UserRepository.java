package me.gfred.room.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<User>> users;

    public UserRepository(Context context) {
        UserRoomDatabase db = UserRoomDatabase.getDatabase(context);
        userDao = db.userDao();
        users = userDao.getAllUsers();
    }


    public void createNewUser(User user) {
        UserRoomDatabase.
                databaseWriteExecutor.execute(() -> userDao.newUser(user));
    }

    public void deleteUser(User user) {
        UserRoomDatabase.
                databaseWriteExecutor.execute(() -> userDao.removeUser(user));
    }

    public User findUserByEmailAddress(String email) {
        return userDao.findUserByEmail(email);
    }

    public LiveData<List<User>> getUsers() {
        return userDao.getAllUsers();
    }
}
