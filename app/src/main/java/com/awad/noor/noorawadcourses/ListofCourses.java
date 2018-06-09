package com.awad.noor.noorawadcourses;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.awad.noor.noorawadcourses.data.Course;
import com.awad.noor.noorawadcourses.data.CourseAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListofCourses extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private FirebaseAuth mAuth;
    private FirebaseUser user;

    private ListView listview;
    private CourseAdapter courseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_courses);

        listview = (ListView) findViewById(R.id.listview);
        courseAdapter = new CourseAdapter(this, R.layout.item_course);
        mAuth=FirebaseAuth.getInstance();
        listview.setAdapter(courseAdapter);
        readAndListen();
        listview.setOnItemClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnItmAddIem:
                Intent i = new Intent(this, AddCourseActivity.class);
                startActivity(i);
                break;
            case R.id.mnSignOut:
                Intent s = new Intent(this, MainActivity.class);
                startActivity(s);
                break;
        }
        return true;
    }

    private void readAndListen() {

        FirebaseUser user = mAuth.getCurrentUser();
        String email = user.getEmail();
        email = email.replace('.', '*');
        DatabaseReference reference;
        reference = FirebaseDatabase.getInstance().getReference();
        reference.child("mylist").orderByChild("email").equalTo(email).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                courseAdapter.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Course c = ds.getValue(Course.class);
                    Log.d("SL", c.toString());
                    courseAdapter.add(c);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}