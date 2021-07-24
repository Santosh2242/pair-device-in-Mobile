package com.baiju.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText name, address, phone, email, password;
    private Button Signup;
    boolean isAllFieldsChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        Signup = findViewById(R.id.signup);


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // store the returned value of the dedicated function which checks
                // whether the entered data is valid or if any fields are left blank.
                isAllFieldsChecked = CheckAllFields();

                // the boolean variable turns to be true then
                // only the user must be proceed to the activity2
                if (isAllFieldsChecked) {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
            }
        });

    }

        private boolean CheckAllFields() {
            if (name.length() == 0) {
                name.setError("This field is required");
                return false;
            } else if (name.length() < 4) {
                name.setError("Name must be minimum 4 characters");
                return false;
            }

            if (address.length() == 0) {
                address.setError("This field is required");
                return false;
            } else if (address.length() < 10) {
                address.setError("Address must be minimum 10 characters");
                return false;
            }

            if (email.length() == 0) {
                email.setError("Email is required");
                return false;
            }

            if (phone.length() == 0) {
                phone.setError("Phone Number is required");
                return false;
            } else if (phone.length() < 10) {
                phone.setError("Phone must be minimum 10 Number");
                return false;
            }

            if (password.length() == 0) {
                password.setError("Password is required");
                return false;
            } else if (password.length() < 8) {
                password.setError("Password must be minimum 8 characters");
                return false;
            }

            // after all validation return true.
            return true;
        }

}