package com.awad.noor.noorawadcourses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.awad.noor.noorawadcourses.data.CourseAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListOfCoursestoStudents extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listview;

    FirebaseDatabase db;
    DatabaseReference requests;

    CourseAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_coursesto_students);

        listview = (ListView)findViewById(R.id.listview);
        db= FirebaseDatabase.getInstance();
        requests= db.getReference("mylist");
        adapter = new CourseAdapter(this, R.layout.item_course);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
