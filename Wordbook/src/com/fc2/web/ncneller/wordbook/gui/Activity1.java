package com.fc2.web.ncneller.wordbook.gui;


import com.fc2.web.ncneller.wordbook.R;

import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;

public class Activity1 extends Activity implements OnClickListener {
	public static String TAG=Activity1.class.getName();
    @TargetApi(11)
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	try
    	{
    		Log.d(TAG, "onCreate(Bundle) start");
    		super.onCreate(savedInstanceState);
    		setContentView(R.layout.activity_activity1);
    		getActionBar().setDisplayHomeAsUpEnabled(true);
    		Intent intent=getIntent();
    		if(intent != null)
    		{
    			Log.d(TAG,"component="+intent.getComponent());
    		}
    		this.findViews();
    		this.initButtons();
    	}
    	catch(Exception ex)
    	{
    		Log.d(TAG+"Exception",(ex==null)?"null":ex.getMessage());
    	}
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_activity1, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void findViews()
    {
    	word_ind=(EditText)findViewById(R.id.word_ind);
    	dir_ok=(Button)findViewById(R.id.act1_dir_ok);
    	linlay=(LinearLayout)findViewById(R.id.act1_linlay);
    	
    }
    @TargetApi(11)
	public void initButtons()
    {
    	this.wordcount=100;//temporary value

    	int buttoncount=(wordcount+9)/10;
    	this.nums=new Button[buttoncount];
    	for(int i=0;i<buttoncount;i++)
    	{
    		LayoutParams lp=new LayoutParams(200+0*this.linlay.getMeasuredWidth()*3/4,100);
    		this.nums[i]=new Button(this.getBaseContext());
    		this.nums[i].setText(String.format("Number %d",10*i+1));
    		this.nums[i].setOnClickListener(this);
    		this.linlay.addView(this.nums[i],lp);
    	}
    	this.dir_ok.setOnClickListener(this);
    }
    private EditText word_ind;
    private Button dir_ok;
    private LinearLayout linlay;
    private Button[] nums;
    private int wordcount;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//Button
		for(int i=0;i<nums.length;i++)
		{
			if(v==this.nums[i])
			{
				start2(i*10);
			}
		}
		if(v==this.dir_ok)
		{
			if(this.word_ind.getText().toString().length()==0)
			{
				return;
			}
			start2(Integer.parseInt(this.word_ind.getText().toString())-1);
			
		}
	}
	private void start2(int numbre)//the numbre to start
	{
		Intent intent=new Intent(this.getApplicationContext(),Activity2.class);
		intent.putExtra("from", numbre);
		this.startActivity(intent);
	}
}
