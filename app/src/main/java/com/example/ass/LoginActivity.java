package com.example.ass;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    public static ArrayList<User> users;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        users= new ArrayList<>();
        fillUserList();
        findViewById(R.id.loginButton).setBackgroundColor(R.color.primaryDarkColor);
        findViewById(R.id.loginButton).setOnClickListener(e->{
            String username=((EditText)findViewById(R.id.usernameEditText)).getText().toString().trim();
            String password=((EditText)findViewById(R.id.passwordEditText)).getText().toString().trim();
            if(username.isEmpty() && password.isEmpty()){
                Toast.makeText(this, "Enter your username and password", Toast.LENGTH_SHORT).show();
            }
            else if(username.isEmpty()){
                Toast.makeText(this, "Enter your username", Toast.LENGTH_SHORT).show();
            }else if(password.isEmpty()) {
                Toast.makeText(this, "Enter your password", Toast.LENGTH_SHORT).show();
            }else{
                if(isValid(username,password)){
                    Intent intent=new Intent(this,MainActivity.class);
                    intent.putExtra("username",username);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Password or Username are wrong", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }


private static void fillUserList(){
    users.add(new User("admin","Jadallah Baragitha","123"));
    users.add(new User("adam","Adam khabisa","1234"));
    users.add(new User("osama","Osama ","1234"));
    users.add(new User("fadi","fadi fadi fadi","1234"));

}
private static boolean isValid(String username,String password){
    for(User user: users){
        if(user.getUsername().equals(username)){
            if(user.getPassword().equals(password))
                return true;
        }
    }
    return false;
}
}