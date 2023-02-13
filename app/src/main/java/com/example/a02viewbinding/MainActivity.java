package com.example.a02viewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a02viewbinding.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = activityMainBinding.getRoot();
        setContentView(view);
        activityMainBinding.button.setOnClickListener(v->{
            if(String.valueOf(activityMainBinding.editText.getText()).equals("")){
                Snackbar s = Snackbar.make(view, "Nie może być puste", Snackbar.LENGTH_LONG);
                s.setAction("OK", a -> activityMainBinding.editText.setText("5"));
                s.show();
            }else{
                Intent intent = new Intent(MainActivity.this, List.class);
                intent.putExtra("itemCount", Integer.parseInt(String.valueOf(activityMainBinding.editText.getText())));
                startActivity(intent);
            }
        });

    }
}