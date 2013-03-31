package com.fc2.web.ncneller.wordbook.gui;


import com.fc2.web.ncneller.wordbook.Exam;
import com.fc2.web.ncneller.wordbook.R;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

/**
 * Activity for examination
 * @author ncneller
 *
 */
public class Activity4 extends Activity {
    private int diff;//1->easy, 2->medium, 3->hard, (4->Lunatic)
    private Button[] select=new Button[4];

    private TextView wordView;
    private TextView timerView;
    private TextView resultView;

    Exam exam=null;
    

    private int count;//time
    private TimerServCon servCon;
    final String TAG=Activity4.class.getName()+", this="+String.format("%x",System.identityHashCode(this));

    private Handler handler=new Handler(new Handler.Callback() {
		@Override
		public boolean handleMessage(Message msg) {
			if(msg.what>0)
				onCount();
			return false;
		}
	});
    @TargetApi(11)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4);
        if(Build.VERSION.SDK_INT>=11)
        	getActionBar().setDisplayHomeAsUpEnabled(true);
        try
        {
        	this.generalInit();
        	this.findViews();
        	this.initViews();
        }
        catch(Exception ex)
        {
      		Log.e(TAG,"Exception in Activity4.onCreate(Bundle)"+ex.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_activity4, menu);
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
    private void generalInit()
    {
    	Log.d(TAG,"generalInit()");
    	Intent intent=super.getIntent();
    	this.diff=intent.getIntExtra("diff", -1);
    	if(diff==-1 || diff <1 || diff>4)
    	{
    		throw new RuntimeException("Unrecognised diff mode");
    	}
    	if(servCon==null)
    		servCon=new TimerServCon(this);
    }
    @Override
    public void onStart()
    {
    	super.onStart();
    	Log.d(TAG,"onStart()");
    	boolean result=super.bindService(new Intent(super.getApplicationContext(),TimerService.class),
    			this.servCon,
    			Context.BIND_AUTO_CREATE);
    	if(!result)
    	{
    		Log.e(TAG,"bindService(Intent,ServiceConnection,int) failed!!");
    	}
    	this.exam=new Exam(this.diff);
    }
    @Override
    public void onStop()
    {
    	super.onStop();
    	Log.d(TAG,"onStop()");
    	try
    	{
    		super.unbindService(servCon);
    	}
    	catch(Exception all)
    	{
    		Log.e(TAG,"onStop() exception" );
    	}
    	this.exam=null;
    }
    @Override
    protected void onDestroy()
    {
    	super.onDestroy();
    	Log.d(TAG,"onDestroy()");
    }
    public void post(Message msg)
    {
    	handler.sendEmptyMessageAtTime(1, 1);
    }
    public void findViews()
    {
    	this.wordView=(TextView)super.findViewById(R.id.act4_word);
    	this.timerView=(TextView)super.findViewById(R.id.act4_timer);
    	this.resultView=(TextView)super.findViewById(R.id.act4_result);
    	final int[] btnIds=new int[]{R.id.act4_button1,R.id.act4_button2,R.id.act4_button3,R.id.act4_button4};
    	for(int i=0;i<btnIds.length;i++)
    	{
    		this.select[i]=(Button)super.findViewById(btnIds[i]);
    	}
    }
    public void initViews()
    {
    	//nothing has to be done for wordView, timerView
    	OnClickListener ocl=new SelectOnClickListener();
    	for(Button b:select)
    	{
    		b.setOnClickListener(ocl);
    	}
    }
    void newQuestion()
    {
		final int delay=new int[]{10000,5000,2000,500}[diff-1];
		this.count=delay;
		if(!exam.hasNext())
		{
			return;
		}
		String word=exam.next();
		wordView.setText(word);
		servCon.startCount();
    }
    private long lastUpdate=-1;
    private static final int REFRESH_RATE_MILLI=20;
    private void updateViews()
    {
    	long tmp=System.currentTimeMillis();
    	if(lastUpdate==-1 || tmp-lastUpdate>=REFRESH_RATE_MILLI)
    	{
    		timerView.setText(String.format("%d:%02d.%02d",count/6000,(count/100)%60,count%100));
    		lastUpdate=tmp;
    	}
    }
    public void onCount()
    {
    	count--;
    	if(count<=0)
    	{
    		onWrongAnswer();
    	}
    	updateViews();
    }
    private void onRightAnswer()
    {
    	Log.d(TAG,"onRightAnswer()");
    	resultView.setText("Correct");
    	newQuestion();
    }
    private void onWrongAnswer()
    {
    	resultView.setText("Wrong");
    	this.newQuestion();
    }
    private class SelectOnClickListener implements OnClickListener
    {
    	@Override
		public void onClick(View v) {
    		try
    		{
    			int number=-1;
    			for(int i=0;i<select.length && number == -1;i++)
    			{
    				if(v==select[i])
    				{
    					number=i;
    				}
    			}
    			int right=1;
    			if(number==right)
    			{
    				onRightAnswer();
    			}
    			else
    			{
    				onWrongAnswer();
    			}
    		}
    		catch(Exception all)
    		{
    			Log.e(TAG,"Exception in SelectOnClickListener.onClick(View)");
    		}
    	}
    }
}
