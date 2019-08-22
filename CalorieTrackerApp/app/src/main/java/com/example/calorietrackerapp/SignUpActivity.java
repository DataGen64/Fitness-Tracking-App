package com.example.calorietrackerapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignUpActivity extends AppCompatActivity {
    View vSignUpSreen;

    Calendar c;
    DatePickerDialog dpd;
    String u_firstname;
    String u_lastname;
    String u_email;
    int u_height;
    int u_weight;
    int u_stepsPerMile;
    int u_levelofActivity;

    String u_postcode;
    String u_address;
    String u_username;
    String gender;
    String p;
    String U_password;
    Date u_dob;
    int u_id;
    RadioGroup radioSexGroup;
    EditText fname;
    EditText lname;
    EditText email;
    EditText height;
    EditText weight;
    EditText address;
    EditText postcode;
    EditText stepsPerMile;
    EditText uname;
    EditText pwd;
    Button setDob;
    Button register;
    RadioButton radioSexButton;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        final Spinner loa = (Spinner) findViewById(R.id.levelofactivityspinner);
        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loa.setAdapter(spinnerAdapter);

        register = (Button) findViewById(R.id.register);
        setDob = (Button) findViewById(R.id.setdob);
        tv = (TextView) findViewById(R.id.tv1);
        fname = (EditText) findViewById(R.id.firstName);
        lname = (EditText) findViewById(R.id.surname);
        email = (EditText) findViewById(R.id.email);
        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        address = (EditText) findViewById(R.id.address);
        postcode = (EditText) findViewById(R.id.postcode);
        stepsPerMile = (EditText) findViewById(R.id.stepsPerMile);
        uname = (EditText) findViewById(R.id.setUsername);
        pwd = (EditText) findViewById(R.id.setPassword);
        radioSexGroup = (RadioGroup) findViewById(R.id.radio_button);
        RadioButton radioMaleButton = (RadioButton) findViewById(R.id.radio_male);
        RadioButton radioFemaleButton = (RadioButton) findViewById(R.id.radio_female);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (fname.getText().toString().length() == 0)
                    fname.setError("First name is required!");
                else {
                    try {
                        u_firstname = fname.getText().toString();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    if (lname.getText().toString().length() == 0)
                        lname.setError("Last name is required!");
                    else {
                    }
                    try {
                        u_lastname = lname.getText().toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                if (email.getText().toString().length() == 0)
                    email.setError("Email is required!");
                else {
                    try {
                        u_email = email.getText().toString();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                if (height.getText().toString().length() == 0)
                    height.setError("Height is required!");
                else {
                    String h = " ";
                    h = height.getText().toString();
                    try {
                        u_height = Integer.valueOf(h);
                    } catch (NumberFormatException e) {
                        height.setError("Invalid Input");
                    }
                }


                if (weight.getText().toString().length() == 0)
                    weight.setError("Weight is required!");
                else {
                    String w = "";
                    w = weight.getText().toString();
                    try {
                        u_weight = Integer.valueOf(w);
                    } catch (NumberFormatException e) {
                        weight.setError("Invalid Input");
                    }
                }


                if (stepsPerMile.getText().toString().length() == 0)
                    stepsPerMile.setError("Please enter Step per mile");
                else {
                    String s = "";
                    s = stepsPerMile.getText().toString();
                    try {
                        u_stepsPerMile = Integer.valueOf(s);
                    } catch (NumberFormatException e) {
                        stepsPerMile.setError("First name is required!");
                    }
                }

                gender = radioSexButton.getText().toString();


                if (postcode.getText().toString().length() == 0)
                    postcode.setError("Please enter postcode");
                else {
                    u_postcode = postcode.getText().toString();
                }


                if (address.getText().toString().length() == 0)
                    address.setError("Please enter address");
                else {
                    u_address = address.getText().toString();
                }


                if (uname.getText().toString().length() == 0)
                    uname.setError("Username name is required!");
                else {
                    u_username = uname.getText().toString();
                }


                if (pwd.getText().toString().length() == 0)
                    pwd.setError("Password is required!");
                else {
                    p = pwd.getText().toString();
                    U_password = md5(p);
                }

                SignUpActivity.CountAsyncTask getCount = new SignUpActivity.CountAsyncTask();
                try {
                    getCount.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }

//                String count = RestClient.findCount();
//                int c = Integer.parseInt(count) + 1;
//                u_id = (c);

                User user1 = new User(u_id, u_firstname, u_lastname, u_email, u_height, u_weight, u_address, u_postcode, u_levelofActivity, u_stepsPerMile, u_dob, gender);
                RestClient.createUser(user1);

                Date currentTime = Calendar.getInstance().getTime();

                Credential credential = new Credential(u_username, U_password, currentTime);
                RestClient.createUserCredentials(credential);

                Toast.makeText(getApplicationContext(), "You have been registered", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(SignUpActivity.this, LoginActivity1.class);
                startActivity(intent);

            }
        });

        setDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(SignUpActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int myear, int mmonth, int mdayOfMonth) {
                        TextView dob = (TextView) findViewById(R.id.tvDob);
                        dob.setText(mdayOfMonth + "/" + (mmonth + 1) + "/" + myear);
                        c.set(myear, (mmonth + 1), mdayOfMonth, 0, 0);
                        u_dob = c.getTime();

                    }
                }, day, month, year);

                dpd.show();
            }
        });

        loa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String slected = parent.getItemAtPosition(position).toString();
                u_levelofActivity = Integer.parseInt(slected);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void chechButton(View v) {
        int radioId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = (RadioButton) findViewById(radioId);
    }


    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    //
    private class CountAsyncTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            return RestClient.findCount();
        }

        @Override
        protected void onPostExecute(String result) {

            int i = Integer.valueOf(result);
            i = i + 1;
            u_id = i;


        }
    }

}
//

