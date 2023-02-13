package com.example.a02viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.a02viewbinding.databinding.ActivityListBinding;

import java.util.Random;

public class List extends AppCompatActivity {
    public ActivityListBinding activityListBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list);
        activityListBinding = ActivityListBinding.inflate(getLayoutInflater());
        View view = activityListBinding.getRoot();
        setContentView(view);
        Bundle bundle = getIntent().getExtras();
        int itemCount = bundle.getInt("itemCount", 0);
        for (int i = 0; i < itemCount; i++) {
            Random random = new Random();
            String color = "#"+Integer.toHexString(random.nextInt(16*16*16*16*16*16));
            Log.d("xxx", color);
            LinearLayout listItem = new LinearLayout(List.this);
            listItem.setBackgroundColor(Color.parseColor(color));
            TextView tv = new TextView(List.this);
            tv.setText("SSS");
            listItem.addView(tv);
            activityListBinding.list.addView(listItem);
        }
    }
}