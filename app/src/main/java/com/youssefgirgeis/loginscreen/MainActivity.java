package com.youssefgirgeis.loginscreen;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LoginApp";
    private int attemptsCounter = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.loginButton);

    }

    public void onBtnClicked(View v){
        EditText userNameEditText = (EditText) findViewById(R.id.usernameEditText);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        TextView errorTextView = (TextView) findViewById(R.id.errorTextView);

        String userName = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        LoginManager loginManager = new LoginManager(userName, password);

        if(loginManager.hasValidCredentials()){

            attemptsCounter = 3;
            errorTextView.setVisibility(View.INVISIBLE);

        } else{
            attemptsCounter--;

            String error = getResources().getString(R.string.invalid_login, attemptsCounter);
            errorTextView.setText(error);
            errorTextView.setVisibility(View.VISIBLE);

            Button loginBtn = (Button) findViewById(R.id.loginButton);
            if(attemptsCounter == 0){
                loginBtn.setBackgroundColor(Color.GRAY);
                loginBtn.setEnabled(false);
            }
        }

    }
}
