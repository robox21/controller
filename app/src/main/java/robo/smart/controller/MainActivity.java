package robo.smart.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button cu,cd,cl,cr;
    Button led,connect,goff,gon;
    Button uArmOn,uArmOff;
    Button bArmUp,bArmDown,bArmLeft,bArmRight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cu = (Button) findViewById(R.id.button_car_up);
        cd = (Button) findViewById(R.id.button_car_down);
        cl = (Button) findViewById(R.id.button_car_left);
        cr = (Button) findViewById(R.id.button_car_right);

        led=(Button) findViewById(R.id.button_led);
        connect=(Button) findViewById(R.id.button_connect);

        goff=(Button) findViewById(R.id.button_grip_off);
        gon=(Button) findViewById(R.id.button_grip_on);

        bArmUp=(Button) findViewById(R.id.button_base_up);
        bArmDown=(Button) findViewById(R.id.button_base_down);
        bArmLeft=(Button) findViewById(R.id.button_base_left);
        bArmRight=(Button) findViewById(R.id.button_base_right);




        uArmOff=(Button) findViewById(R.id.button_uArmOff);
        uArmOn=(Button) findViewById(R.id.button_uArmOn);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MessageActivity.class));
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this,Preferences.class));
        }else if(id== R.id.action_exit){
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}
