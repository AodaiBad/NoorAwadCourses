package com.awad.noor.noorawadcourses;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.awad.noor.noorawadcourses.data.Course;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCourseActivity extends AppCompatActivity{
    private EditText etPhone, etLocation, etSubject, etDays, etPrice;
    private Button btnCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);

        etPhone = (EditText) findViewById(R.id.etPhone);
        etLocation = (EditText) findViewById(R.id.etLocation);
        etSubject = (EditText) findViewById(R.id.etSubject);
        etDays = (EditText) findViewById(R.id.etDays);
        etPrice = (EditText) findViewById(R.id.etPrice);
        btnCourse = (Button) findViewById(R.id.btnCourse);

        btnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }

    private void dataHandler() {
        String stPhone=etPhone.getText().toString();
        String stprice=etPrice.getText().toString();
        String stLocation=etLocation.getText().toString();
        String stSubject=etSubject.getText().toString();
        String stdays=etDays.getText().toString();

        double price=Double.parseDouble(stprice);
        int days=Integer.parseInt(stdays);
        boolean isok=true;
        if(etPhone.length()==8);
        {

        }


        if (isok==true) {
            Course c= new Course();
            c.setPhone(stPhone);
            c.setDays(Integer.parseInt(stdays));
            c.setLocation(stLocation);
            c.setSubject(stSubject);
            c.setPrice(Double.parseDouble(stprice));

            FirebaseAuth auth=FirebaseAuth.getInstance();
            FirebaseUser user=auth.getCurrentUser();
            String email=user.getEmail();
            email=email.replace('.','*');
            DatabaseReference reference;
            reference = FirebaseDatabase.getInstance().getReference();
            c.setEmail(email);
            String key=reference.child("mylist").push().getKey();
            c.setKeyId(key);
            reference.child("mylist").child(key).setValue(c).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(AddCourseActivity.this, "Add Course Successful", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(AddCourseActivity.this, "Add Course Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
