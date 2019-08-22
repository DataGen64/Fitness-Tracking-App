package com.example.calorietrackerapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginActivity1 extends AppCompatActivity {

    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        Button login = (Button) findViewById(R.id.login);
        Button signup = (Button) findViewById(R.id.signup);
       final EditText uname = (EditText) findViewById(R.id.username);
       final EditText pwd = (EditText) findViewById(R.id.password);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                username = uname.getText().toString();
                password = pwd.getText().toString();
                UsernameAsyncTask getCredentials = new UsernameAsyncTask();
                getCredentials.execute(username, password);

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity1.this, SignUpActivity.class);
                startActivity(intent);

            }
        });
    }

    private class UsernameAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground (String...params){
           String password = md5(params[1]);
            return RestClient.findbyUsername(params[0], password); }
        @Override
        protected void onPostExecute (String result){

            if (result == ""){

            TextView resultTextView = (TextView) findViewById(R.id.tvResult);
            resultTextView.setText("wrong password");
            }

            else
                {
                    Intent intent = new Intent(LoginActivity1.this, MainActivity.class);
                    intent.putExtra("fname", result);
                    startActivity(intent);
                }

        }
    }

    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
