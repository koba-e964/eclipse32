package com.fc2.web.ncneller.wordbook.gui;

import com.fc2.web.ncneller.wordbook.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {//Screen0

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.findViews();
        this.learning.setOnClickListener(new LOnClickListener());
        this.test.setOnClickListener(new TOnClickListener());
        this.end.setOnClickListener(new EndOnClickListener());
    }
    public void findViews()
    {
    	this.learning=(Button)findViewById(R.id.main_learning);
    	this.test=(Button)findViewById(R.id.main_test);
    	this.end=(Button)findViewById(R.id.main_end);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    private Button learning,test,end;
    private void moveTo(Class <? extends Activity> cls)
    {
		Intent intent;
		intent=new Intent(MainActivity.this.getApplicationContext(),cls);
		intent.putExtra("data", "Activity0");
		try
		{
			startActivity(intent);
		}
		catch(Exception ex)
		{
			Log.d(TAG+" Exception","occurred in MainActivity.moveTo(Class)\n"+ex.getMessage());
		}

    }
    private class LOnClickListener implements OnClickListener
    {
		@Override
		public void onClick(View v) {
			moveTo(Activity1.class);
		}
    	
    }
    private class TOnClickListener implements OnClickListener
    {
    	@Override
    	public void onClick(View v)
    	{
    		moveTo(Activity3.class);
    	}
    }
    
    private class EndOnClickListener implements OnClickListener
    {

		@Override
		public void onClick(View v) {
			//end this activity
			//MainActivity.this.finish();
			MainActivity.this.moveTaskToBack(true);
		}
    	
    }
    private static final String TAG=MainActivity.class.getName();
}
