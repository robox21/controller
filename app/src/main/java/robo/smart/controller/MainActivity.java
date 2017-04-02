package robo.smart.controller;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import robo.smart.controller.conectivity.Connector;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = Activity.class.getName();

    private ImageButton btnGripOn, btnGripOff, btnUArmUp, btnUArmDown, btnBaseUp, btnBaseDown, btnBaseLeft, btnBaseRight;
    private ImageButton btnCarUp, btnCarDown, btnCarLeft, btnCarRight;
    // GRIP : Gripper On: Hold Off: Release
    // UARM : Upper arm UP DOWN
    // BASE : Arm Base UP DOWN LEFT RIGHT
    // CAR :  Car UP DOWN LEFT RIGHT

    private ImageButton btnPower, btnConnect, btnLight;
    // CONNECT : connect to the server / broker
    // POWER : Power on / off arm
    // LIGHT : Control LEDs

    private FloatingActionButton fab;
    private Connector mConnector ;
    private boolean mConnectStatus;
    private SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        mConnector = new Connector();

        setSupportActionBar(toolbar);
        initButtons();



    }

    private void initButtons(){
        // FAB button
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
        // First Row
        btnPower = (ImageButton) findViewById(R.id.button_power);
        btnPower.setOnClickListener(this);
        btnLight = (ImageButton) findViewById(R.id.button_led);
        btnLight.setOnClickListener(this);
        btnConnect = (ImageButton) findViewById(R.id.button_connect);
        btnConnect.setOnClickListener(this);
        // Gripper
        btnGripOn = (ImageButton) findViewById(R.id.button_grip_on);
        btnGripOn.setOnClickListener(this);
        btnGripOff = (ImageButton) findViewById(R.id.button_grip_off);
        btnGripOff.setOnClickListener(this);
        // UPPER ARM
        btnUArmUp = (ImageButton) findViewById(R.id.button_uArmOn);
        btnUArmUp.setOnClickListener(this);
        btnUArmDown = (ImageButton) findViewById(R.id.button_uArmOff);
        btnUArmDown.setOnClickListener(this);
        // ARM BASE
        btnBaseUp = (ImageButton) findViewById(R.id.button_base_up);
        btnBaseUp.setOnClickListener(this);
        btnBaseDown = (ImageButton) findViewById(R.id.button_base_down);
        btnBaseDown.setOnClickListener(this);
        btnBaseLeft = (ImageButton) findViewById(R.id.button_base_left);
        btnBaseLeft.setOnClickListener(this);
        btnBaseRight = (ImageButton) findViewById(R.id.button_base_right);
        btnBaseRight.setOnClickListener(this);
        //CAR
        btnCarUp = (ImageButton) findViewById(R.id.button_car_up);
        btnCarUp.setOnClickListener(this);
        btnCarDown = (ImageButton) findViewById(R.id.button_car_down);
        btnCarDown.setOnClickListener(this);
        btnCarLeft = (ImageButton) findViewById(R.id.button_car_left);
        btnCarLeft.setOnClickListener(this);
        btnCarRight = (ImageButton) findViewById(R.id.button_car_right);
        btnCarRight.setOnClickListener(this);

    }
    private void connect(){
        String url;
        int port=-1;
        url = sharedPref.getString("key_url","");
        Log.d(TAG,"BROKER URL :"+url);
        if(!sharedPref.getString("key_port","").isEmpty())
            port= Integer.parseInt(sharedPref.getString("key_port",""));
        if(!url.isEmpty()||port!=-1){
            mConnector.setup(getApplicationContext(),url,port);
            mConnector.setTopic("test");
            int result=mConnector.Connect();

            //TODO: REDESIGN CONNECT STATUS WITH PROPER RETURN VALUE FROM CONNECTOR CLASS
            if(result==1) {
                Log.d(TAG, "Connected");
                mConnectStatus=true ;
                Toast.makeText(getApplicationContext(),"Connected to "+url,Toast.LENGTH_SHORT).show();
            }
        }else
            Toast.makeText(getApplicationContext(),"check the connection preferences first",Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.grow));

        switch (v.getId()){

            case R.id.button_power:{
                mConnector.Publish("Power On");

                break;
            }
            case R.id.button_led:{
                break;
            }
            case R.id.button_connect:{
                connect();
                break;
            }

            case R.id.button_grip_on:{
                break;
            }
            case R.id.button_grip_off:{
                break;
            }

            case R.id.button_uArmOn:{
                break;
            }
            case R.id.button_uArmOff:{
                break;
            }

            case R.id.button_base_up:{
                break;
            }
            case R.id.button_base_down:{
                break;
            }
            case R.id.button_base_left:{
                break;
            }
            case R.id.button_base_right:{
                break;
            }


            case R.id.button_car_up:{
                break;
            }
            case R.id.button_car_down:{
                break;
            }
            case R.id.button_car_left:{
                break;
            }
            case R.id.button_car_right:{
                break;
            }
            case R.id.fab:{
                startActivity(new Intent(MainActivity.this,MessageActivity.class));
                break;
            }
        }
    }
}
