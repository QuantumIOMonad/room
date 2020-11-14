package me.gfred.room.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class UserViewModel extends ViewModel {
    private UserRepository repository;

    private LiveData<List<User>> userLiveData;

    public UserViewModel(Context context) {
        repository = new UserRepository(context);
        userLiveData = repository.getUsers();
    }

    public void createNewUser(User user) {
        repository.createNewUser(user);
    }

    public void deleteUser(User user) {
        repository.deleteUser(user);
    }

    public User findUserByEmailAddress(String email) {
        return repository.findUserByEmailAddress(email);
    }

    public LiveData<List<User>> getAllUsers() {
        return userLiveData;
    }

}
