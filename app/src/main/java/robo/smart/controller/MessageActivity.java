package robo.smart.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import robo.smart.controller.conectivity.Connector;

public class MessageActivity extends AppCompatActivity {
    private static final String TAG = Activity.class.getName();
    Connector mConnector;
    String url= "192.168.43.199";
    int port = 1883;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
       // String syncConnPref = sharedPref.getString(Preferences.key_url,"");
        //url=
        //Log.d(TAG,)

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_send);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mConnector= new Connector();
            mConnector.setup(getApplicationContext(),url,port);
                Toast.makeText(getApplicationContext(),"setup done",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
