package com.example.hp.essaieapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    private static ListView list_view;
    private static String[] NAMES = new String[] {"Lionel Messi","Cristiano Ronaldo","Luis Suarez","Arjen Robben","Eden Hazard",
                            "Zlatan Ibrahimovic","Neymar","Andres Iniesta","Robert Lewandowski","David Silva","James Rodriguez",
                            "Luca Modric","Gareth Bale","Mesut Ozil","Toni Kroos","Sergio Ramos","Sergio Aguero","Giorgio Chiellini",
                            "Philipp Lahm","Paul Pogba","Kevin De Bruyne","Thomas Muller","Sergio Busquets","Marco Reus","Alexis Sanchez",
                            "Arturo Vidal","Diego Costa","Karim Benzema","Carlos Tevez"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setLogo(R.mipmap.player);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        listView();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void listView(){
        list_view = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.player_list,NAMES);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value = (String)list_view.getItemAtPosition(position);
                        Toast.makeText(Main4Activity.this,"La positin de "+value+" est :"+position,Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    
}
