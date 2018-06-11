package com.awad.noor.noorawadcourses;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogIn;
    private Button btnRegister;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private Button btnGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnGuest = (Button)findViewById(R.id.btnGuest);
        btnGuest.setOnClickListener(this);
        btnLogIn.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

    }

    private void dataHandler() {
        String email = etEmail.getText().toString();
        String passw = etPassword.getText().toString();
        signIn(email, passw);
    }

    private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getBaseContext(), ListofCourses.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "signIn failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }

    public void onClick(View view) {
        if (view == btnLogIn ) {
            dataHandler();
        }

        if (view== btnRegister){
            Intent intent = new Intent(this,RegisterActivity.class);
            startActivity(intent);
        }

        if (view == btnGuest){
            Intent intent2 = new Intent(this,ListOfCoursestoStudents.class);
            startActivity(intent2);
        }
    }
}