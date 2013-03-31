package com.fc2.web.ncneller.wordbook.gui;

import java.util.HashMap;
import java.util.Map;

import com.fc2.web.ncneller.wordbook.R;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.support.v4.app.NavUtils;

public class Activity3 extends Activity {
	@TargetApi(11)
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);
        if(Build.VERSION.SDK_INT >=11)
        	getActionBar().setDisplayHomeAsUpEnabled(true);
        this.findViews();
        this.initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_activity3, menu);
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
    	this.mode=(RadioGroup)super.findViewById(R.id.act3_mode);
    	this.ok=(Button)super.findViewById(R.id.act3_ok);
    	this.selected=null;
    	this.easy=(RadioButton) findViewById(R.id.act3_easy);
    	this.medium=(RadioButton) findViewById(R.id.act3_medium);
    	this.hard=(RadioButton) findViewById(R.id.act3_hard);
    }
    private void initViews()
    {
    	this.mode.check(-1);
    	this.mode.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				selected=(RadioButton) group.findViewById(checkedId);
			}
		});
    	this.ok.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getApplicationContext(),Activity4.class);
				if(selected==null)
					return;
				Map<Button,Integer> map=new HashMap<Button,Integer>();
				map.put(easy, 1);
				map.put(medium, 2);
				map.put(hard, 3);
				intent.putExtra("diff", map.get(selected));
				startActivity(intent);
			}
		});
    }
    private RadioGroup mode;
    private RadioButton selected;
    private RadioButton easy,medium,hard;
    private Button ok;
}
