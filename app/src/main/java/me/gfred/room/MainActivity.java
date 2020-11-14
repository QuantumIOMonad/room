package me.gfred.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import me.gfred.room.data.UserViewModel;
import me.gfred.room.data.UserViewModelFactory;

public class MainActivity extends AppCompatActivity {

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userViewModel = new ViewModelProvider(this, new UserViewModelFactory(this)).
                get(UserViewModel.class);

        userViewModel.getAllUsers().observe(this, users -> {
           /** TODO: Display all the users in the user table **/
        });

        userViewModel.createNewUser(user);
    }
}