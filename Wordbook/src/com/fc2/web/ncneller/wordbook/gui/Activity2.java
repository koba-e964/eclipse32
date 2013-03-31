package com.fc2.web.ncneller.wordbook.gui;



import com.fc2.web.ncneller.wordbook.Data;
import com.fc2.web.ncneller.wordbook.R;
import com.fc2.web.ncneller.wordbook.Usage;
import com.fc2.web.ncneller.wordbook.WordEntry;

import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Activity2 extends Activity implements OnClickListener{
    @TargetApi(11)
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        super.getActionBar().setDisplayHomeAsUpEnabled(true);
        this.findViews();
        this.init();
        this.updateViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_activity2, menu);
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
    private void findViews()
    {
    	this.numbre=(CheckedTextView) findViewById(R.id.act2_numbre);
    	this.itself=(TextView)findViewById(R.id.act2_itself);
    	this.meaning=(Button)findViewById(R.id.act2_meaning);
    	this.meaning_txt=(TextView)findViewById(R.id.act2_meaning_txt);
    	this.usage=(Button)findViewById(R.id.act2_usage);
    	this.usage_txt=(TextView)findViewById(R.id.act2_usage_txt);
    	this.next=(Button)findViewById(R.id.act2_next);
    }
    private void init()
    {
    	this.meaning.setOnClickListener(this);
    	this.usage.setOnClickListener(this);
    	this.next.setOnClickListener(this);
        Data.init(super.getResources().getStringArray(R.array.words));
    	this.size=Data.size();
        Intent intent=super.getIntent();
        int num=intent.getIntExtra("from", -1);
        if(num>=0 && num<this.size)
        	this.current=num;
        else
        	this.current=0;
        this.meaning_txt.setVisibility(View.INVISIBLE);
        this.usage_txt.setVisibility(View.INVISIBLE);
        
    }
    
    private void updateViews()
    {
    	try
    	{
    		this.numbre.setText("Numbre:"+(this.current+1)+'/'+this.size);
    		WordEntry we=Data.get(this.current);
    		this.itself.setText((String)we.get("word"));
    		this.meaning_txt.setText((String)we.get("japanese"));
    		Usage.setText(super.getResources(), this.usage_txt, (String)we.get("usage"), (String)we.get("word"));
    	}
    	catch(RuntimeException rx)
    	{
    		Log.d(TAG,rx.toString());
    	}
    }
    private void nextWord()
    {
    	this.current++;
    	if(this.current>=size)
    	{
    		this.current%=size;
    	}
    	this.meaning_txt.setVisibility(View.INVISIBLE);
    	this.usage_txt.setVisibility(View.INVISIBLE);
    	this.updateViews();
    }
    //widgets
    private CheckedTextView numbre;
    private TextView itself;
    private Button meaning;
    private TextView meaning_txt;
    private Button usage;
    private TextView usage_txt;
    private Button next;
    //states
    private int current=0;//0-indexed
    private int size=100;
    static final String TAG=Activity2.class.getName();
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v==this.next)
		{
			this.nextWord();
			return;
		}
		if(v==this.meaning)
		{
			int newvis=View.VISIBLE+View.INVISIBLE-this.meaning_txt.getVisibility();
			this.meaning_txt.setVisibility(newvis);
			return;
		}
		if(v==this.usage)
		{
			int newvis=View.VISIBLE+View.INVISIBLE-this.usage_txt.getVisibility();
			this.usage_txt.setVisibility(newvis);
			return;
		}
	}
   }
