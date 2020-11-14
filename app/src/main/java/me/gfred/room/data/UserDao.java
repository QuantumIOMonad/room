package me.gfred.room.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void newUser(User user);

    @Delete
    void removeUser(User user);

    @Query("SELECT * FROM users WHERE email=:email LIMIT 1")
    User findUserByEmail(String email);

    @Query("SELECT * from users ORDER BY id DESC")
    LiveData<List<User>> getAllUsers();
}
