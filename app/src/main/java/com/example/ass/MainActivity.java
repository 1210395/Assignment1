package com.example.ass;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String username;

    @SuppressLint({"ResourceAsColor", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =getIntent().getStringExtra("username");
        System.out.println(username);
        findViewById(R.id.logoutButton).setBackgroundColor(R.color.primaryDarkColor);
        User user=getUser(username);
        if(user==null){
            Toast.makeText(this, "No user is logged in!!!", Toast.LENGTH_SHORT).show();
            returnToLoginAcitivity();
        }
        findViewById(R.id.logoutButton).setOnClickListener(e->{
            returnToLoginAcitivity();
        });
        ((TextView)findViewById(R.id.header)).setText(user.getFullName());
        findViewById(R.id.confirm_button).setOnClickListener(e->{
            RadioButton option1=findViewById(R.id.radioButtonOption1);
            RadioButton option2=findViewById(R.id.radioButtonOption2);
            RadioButton option3=findViewById(R.id.radioButtonOption3);
            if(option1.isChecked()){
                startMethodsActivity(option1.getText().toString().trim());
            }else if(option2.isChecked()){
                startMethodsActivity(option2.getText().toString().trim());
            }else if( option3.isChecked()){
                startMethodsActivity(option3.getText().toString().trim());
            }else{
                Toast.makeText(this,"Nothing selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void returnToLoginAcitivity(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    private void startMethodsActivity(String option){
        Intent intent=new Intent(this,MethodsActivity.class);
        intent.putExtra("option",option);
        intent.putExtra("username",username);

        startActivity(intent);
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