package com.example.ass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username=getIntent().getStringExtra("username");
        User user=getUser(username);
        if(user==null){
            Toast.makeText(this, "No user is logged in!!!", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        ((TextView)findViewById(R.id.header)).setText(user.getFullName());

    }
    private User getUser(String username){
        for(User user:LoginActivity.users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}