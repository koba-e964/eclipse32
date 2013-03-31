package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;



public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        startButton.setOnClickListener(new StartButtonListener());
        stopButton.setOnClickListener(new StopButtonListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    protected void findViews()
    {
    	startButton=(Button)findViewById(R.id.start_button);
    	stopButton=(Button)findViewById(R.id.stop_button);
    }
    Button startButton,stopButton;
    class StartButtonListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v)
    	{
    		MainActivity.this.startService(new Intent(MainActivity.this.getBaseContext(),MyService.class));
    	}
    }
    class StopButtonListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v)
    	{
    		MainActivity.this.stopService(new Intent(MainActivity.this.getBaseContext(),MyService.class));
    	}
    }

}
