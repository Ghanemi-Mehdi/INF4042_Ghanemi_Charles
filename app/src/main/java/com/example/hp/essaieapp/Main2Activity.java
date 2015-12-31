package com.example.hp.essaieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private static Button button_act_3;

    private static ImageView imgView;
    private static Button buttonSwtch;

    private int current_image_index;
    int[] images = {R.mipmap.and_image1,R.mipmap.andr_image2,R.mipmap.andr_image3,R.mipmap.iconefoot2,R.mipmap.iconefoot,R.mipmap.player,
                    R.mipmap.iconefoot3,R.mipmap.foot4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setLogo(R.mipmap.iconeapp);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        swchbutton();
        SwchActivity();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void swchbutton() {
        imgView = (ImageView)findViewById(R.id.imageView);
        buttonSwtch = (Button)findViewById(R.id.button4);
        buttonSwtch.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        current_image_index++ ;
                        current_image_index = current_image_index %images.length;
                        imgView.setImageResource(images[current_image_index]);

                    }
                }
        );
    }

    public void SwchActivity(){
        button_act_3 = (Button)findViewById(R.id.button5);
        button_act_3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.hp.essaieapp.Main3Activity");
                        startActivity(intent);
                    }
                }
        );
    }

}
