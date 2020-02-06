package com.example.studygroup.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.studygroup.R;

import android.os.Bundle;
import android.widget.Button;

public class Login extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btn_login_login);


    }
}
