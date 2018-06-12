package com.awad.noor.noorawadcourses.data;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.awad.noor.noorawadcourses.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by aodai on 10/06/2018.
 */

public class CourseAdapterSt extends ArrayAdapter<Course> {


        public CourseAdapterSt(@NonNull Context context, int resource) {
            super(context, resource);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_course_st, parent, false);

            TextView tvPhone = (TextView) view.findViewById(R.id.tvPhone);
            TextView tvLocation = (TextView) view.findViewById(R.id.tvLocation);
            TextView tvSubject = (TextView) view.findViewById(R.id.tvSubject);
            TextView tvDays = (TextView) view.findViewById(R.id.tvDays);
            TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);
            final ImageButton btnDel = (ImageButton) view.findViewById(R.id.btnDel);

            final Course h = getItem(position);

            tvPhone.setText(h.getPhone() + "");
            tvLocation.setText(h.getLocation() + "");
            tvSubject.setText(h.getSubject() + "");
            tvDays.setText(h.getDays() + "");
            tvPrice.setText(h.getPrice() + "");


            return view;
        }






}
