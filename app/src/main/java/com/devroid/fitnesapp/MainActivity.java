package com.devroid.fitnesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    EditText edthft, edthin, edtwt;
    TextView txt;
    AppCompatButton btn;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edthft = findViewById(R.id.edthft);
        btn = findViewById(R.id.btn);
        edthin = findViewById(R.id.edthin);
        edtwt = findViewById(R.id.edtwt);
        txt = findViewById(R.id.txt);
        image = findViewById(R.id.imagegif);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ff = edthft.getText().toString();
                String ww = edtwt.getText().toString();
                String ii = edthin.getText().toString();

                if (ff.isEmpty() || ww.isEmpty() || ii.isEmpty()){
                    Toast.makeText(MainActivity.this, "All fields are mandatory !!", Toast.LENGTH_SHORT).show();
                }else{
                    int ft = Integer.parseInt(ff);
                    int in = Integer.parseInt(ii);
                    int wt = Integer.parseInt(ww);

                    int tht = ft*12+in;
                    double totalheightcm= tht*2.53;
                    double totalheightmeter = totalheightcm/100;
                    double bmi= wt /(totalheightmeter*totalheightmeter);
                    if (bmi>25){
                        txt.setText("You're Overweight");
                        txt.setVisibility(View.VISIBLE);
                        Glide.with(MainActivity.this).load(getResources().getDrawable(R.drawable.shockkk)).into(image);
                        image.setVisibility(View.VISIBLE);

                    }else if (bmi<18){
                        txt.setText("You're Underweight");
                        txt.setVisibility(View.VISIBLE);
                        Glide.with(MainActivity.this).load(getResources().getDrawable(R.drawable.weep)).into(image);
                        image.setVisibility(View.VISIBLE);
                    }else {
                        txt.setText("You're Healthy");
                        txt.setVisibility(View.VISIBLE);
                        Glide.with(MainActivity.this).load(getResources().getDrawable(R.drawable.healthy)).into(image);
                        image.setVisibility(View.VISIBLE);
                    }

                }

            }
        });


    }

}