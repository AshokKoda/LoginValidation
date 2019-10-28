package com.example.kodaashok.loginvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button btnlogin;
    EditText mail, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail =(EditText)findViewById(R.id.email);
        pass =(EditText)findViewById(R.id.pass);
        btnlogin =(Button)findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String validemail = "[a-zA-Z0-9\\+\\.\\-\\@\\-\\+]{1,256}" +
                        "\\@" +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{1,64}" +
                        "(" +
                        "\\." +
                        "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                        ")+";
                String email = mail.getText().toString();
                Matcher matcher = Pattern.compile(validemail).matcher(email);
                if (matcher.matches()) {
                    Toast.makeText(getApplicationContext(), "Email Verifyed", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Email", Toast.LENGTH_LONG).show();
                }
                if (pass.getText().toString().equals("")) {
                    pass.setError("Enter Password");


                }
            }
        });
    }
    }

