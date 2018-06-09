package com.awad.noor.noorawadcourses.data;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.awad.noor.noorawadcourses.R;

/**
 * Created by aodai on 10/06/2018.
 */

public class CourseAdapter extends ArrayAdapter<Course> {


        public CourseAdapter(@NonNull Context context, int resource) {
            super(context, resource);
        }

        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.item_course, parent, false);

            TextView tvPhone = (TextView) view.findViewById(R.id.tvPhone);
            TextView tvLocation = (TextView) view.findViewById(R.id.tvLocation);
            TextView tvSubject = (TextView) view.findViewById(R.id.tvSubject);
            TextView tvDays = (TextView) view.findViewById(R.id.tvDays);
            TextView tvPrice = (TextView) view.findViewById(R.id.tvPrice);

            final Course h = getItem(position);

            tvPhone.setText(h.getPhone() + "");
            tvLocation.setText(h.getLocation() + "");
            tvSubject.setText(h.getSubject() + "");
            tvDays.setText(h.getDays() + "");
            tvPrice.setText(h.getPrice() + "");

            return view;
        }
    }
