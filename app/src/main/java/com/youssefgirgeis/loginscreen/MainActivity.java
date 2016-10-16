package com.youssefgirgeis.loginscreen;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(onClickLoginButton);
    }

    private View.OnClickListener onClickLoginButton = new View  .OnClickListener(){

        @Override
        public void onClick(View view) {

            EditText userNameEditText = (EditText) findViewById(R.id.usernameEditText);
            EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
            TextView errorTextView = (TextView) findViewById(R.id.errorTextView);

            String userName = userNameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            LoginManager loginManager = new LoginManager(userName, password);

            if(loginManager.hasValidCredentials()){

                errorTextView.setVisibility(View.INVISIBLE);

            } else{
                errorTextView.setText(R.string.invalid_login);
                errorTextView.setVisibility(View.VISIBLE);

            }
        }
    };
}
