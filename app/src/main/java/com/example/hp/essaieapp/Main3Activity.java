package com.example.hp.essaieapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private static EditText username;
    private static EditText password;
    private static TextView attempt;
    private static Button login_btn;
    int attempt_counter = 5;

    private EditText pass_word;
    private Button button_envy;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setLogo(R.mipmap.player);
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        addListnerOnButton();
        LoginButton();

        btn = (Button)findViewById(R.id.button6);
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent1 = new Intent();
                        PendingIntent pIntent = PendingIntent.getActivity(Main3Activity.this, 0, intent1, 0);
                        Notification noti = new Notification.Builder(Main3Activity.this).setTicker("Notification")
                                .setContentTitle("Nouvelle notification").setContentText("Vous avez une notification").setSmallIcon(R.mipmap.andr_image3)
                                .setContentIntent(pIntent).getNotification();
                        noti.flags = Notification.FLAG_AUTO_CANCEL;
                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                        nm.notify(0, noti);
                    }
                }
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addListnerOnButton(){
        pass_word = (EditText)findViewById(R.id.editText3);
        button_envy = (Button)findViewById(R.id.button7);
        button_envy.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Main3Activity.this, pass_word.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    public void LoginButton(){
        username = (EditText)findViewById(R.id.editText7);
        password = (EditText)findViewById(R.id.editText8);
        attempt = (TextView)findViewById(R.id.textView8);
        login_btn = (Button)findViewById(R.id.button8);

        attempt.setText(Integer.toString(attempt_counter));

        login_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(username.getText().toString().equals("user") &&
                                password.getText().toString().equals("password")){
                            Toast.makeText(Main3Activity.this,"username and password correct",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.hp.essaieapp.Main4Activity");
                            startActivity(intent);

                            Intent intent1 = new Intent();
                            PendingIntent pIntent = PendingIntent.getActivity(Main3Activity.this, 0, intent1, 0);
                            Notification noti = new Notification.Builder(Main3Activity.this).setTicker("Changement d'activité")
                                    .setContentTitle("Activité 4 ouverte!").setContentText("Vous avez une notification").setSmallIcon(R.mipmap.validicom)
                                    .setContentIntent(pIntent).getNotification();
                            noti.flags = Notification.FLAG_AUTO_CANCEL;
                            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                            nm.notify(0, noti);

                        } else {
                            Toast.makeText(Main3Activity.this,"Username and password is not correct",Toast.LENGTH_SHORT).show();
                            attempt_counter-- ;
                            attempt.setText(Integer.toString(attempt_counter));
                            if(attempt_counter==0){
                                login_btn.setEnabled(false);

                                Intent intent1 = new Intent();
                                PendingIntent pIntent = PendingIntent.getActivity(Main3Activity.this, 0, intent1, 0);
                                Notification noti = new Notification.Builder(Main3Activity.this).setTicker("Attention")
                                        .setContentTitle("Nombre d'essai dépassé").setContentText("Nouvelle notification").setSmallIcon(R.mipmap.alerticon)
                                        .setContentIntent(pIntent).getNotification();
                                noti.flags = Notification.FLAG_AUTO_CANCEL;
                                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                nm.notify(0, noti);
                            }
                        }
                    }
                }
        );
    }
}
