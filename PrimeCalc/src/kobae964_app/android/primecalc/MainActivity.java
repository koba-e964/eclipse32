package kobae964_app.android.primecalc;

import java.math.BigInteger;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import static java.math.BigInteger.*;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews();
		init();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private void findViews()
	{
		numView=(TextView)super.findViewById(R.id.numView);
		numView.setFocusable(false);
		int[] ids={R.id.btn0,R.id.btn1,R.id.btn2,
				R.id.btn3,R.id.btn4,R.id.btn5,
				R.id.btn6,R.id.btn7,R.id.btn8,
				R.id.btn9,};
		keys=new Button[ids.length];
		OnClickListener keyListener=new KeyListener();
		for(int i=0;i<ids.length;i++)
		{
			keys[i]=(Button) super.findViewById(ids[i]);
			keys[i].setOnClickListener(keyListener);
		}
		bs=(Button)super.findViewById(R.id.btn_minus);
		bs.setOnClickListener(keyListener);
		go=(Button)super.findViewById(R.id.btn_go);
		go.setOnClickListener(keyListener);
		resultView=(TextView)super.findViewById(R.id.resultView);
		resultView.setFocusable(false);
		fctr=(Button)super.findViewById(R.id.fctr);
		fctr.setOnClickListener(keyListener);
		gen=(Button)super.findViewById(R.id.gen);
		gen.setOnClickListener(keyListener);
		rand=(Button)super.findViewById(R.id.rand);
		rand.setOnClickListener(keyListener);
		incr=(Button)super.findViewById(R.id.incr);
		incr.setOnClickListener(keyListener);
	}
	private void init()
	{
		numView.setText("0");
	}
	private TextView numView,resultView;
	private Button[] keys;
	private Button go,bs;
	private Button fctr,gen,rand,incr;
	private class KeyListener implements OnClickListener
	{

		@Override
		public void onClick(View v) {
			if(!(v instanceof Button))
			{
				return;
			}
			Button btn=(Button)v;
			if(btn==go)
			{
				calcPrime();
				return;
			}
			String old=numView.getText().toString();
			if(btn==bs)
			{
				String neu;
				if(old.equals("0"))
					return;
				if(old.length()==1)
				{
					neu="0";
				}
				else
				{
					neu=old.substring(0,old.length()-1);
				}
				numView.setText(neu);
				return;
			}
			if(btn==fctr)
			{
				calcFctr();
				return;
			}
			if(btn==gen)
			{
				calcGen();
				return;
			}
			if(btn==rand)
			{
				calcRand();
				return;
			}
			if(btn==incr)
			{
				calcIncr();
				return;
			}
			String neu;
			int num = -1;
			try
			{
				String text=btn.getText().toString();
				num=Integer.parseInt(text);
			}
			catch(NumberFormatException nfx)
			{
				Log.e(TAG,nfx.toString());
			}
			if("0".equals(old))
			{
				neu=Integer.toString(num);
			}
			else
			{
				neu=old+num;
			}
			numView.setText(neu);
		}
		
	}
	/*
	 *calculation 
	 */
	private BigInteger getNumber()
	{
		BigInteger target;
		try
		{
			target=new BigInteger(numView.getText().toString());
		}
		catch(NumberFormatException nfx)
		{
			Log.e(TAG,nfx.toString());
			print("Some errors occurred");
			throw nfx;
		}
		return target;
	}
	private void calcPrime()
	{
		BigInteger target;
		try
		{
			target=new BigInteger(numView.getText().toString());
		}
		catch(NumberFormatException nfx)
		{
			Log.e(TAG,nfx.toString());
			print("Some errors occurred");
			return;
		}
		boolean bPrime=target.isProbablePrime(20);
		print("isPrime("+target+")="+bPrime+"\n");
	}
	private void calcFctr()
	{
		BigInteger target=getNumber();
		clean();
		if(target.isProbablePrime(20))
		{
			print(target+":prime\n");
			return;
		}
		BigInteger p=valueOf(2);
		int pow=0;
		int sgn=1;
		int pcount=0;
		if(target.signum()==0)
		{
			print("0:{}\n");
			return;
		}
		if(target.signum()<0)
		{
			sgn=-1;
			target=target.abs();
		}
		StringBuilder ans=new StringBuilder();
		ans.append(target);
		ans.append('=');
		boolean pcache=false;
		while(target.compareTo(ONE)>0 || pow>0)
		{
			if(pow==0 && !pcache)
			{
				if(target.isProbablePrime(20))
				{
					p=target;
					pow=0;
				}
				pcache=true;
				continue;
			}
			if(target.mod(p).signum()!=0)
			{
				if(pow>0)
				{
					if(pcount!=0)
					{
						ans.append('*');
					}
					ans.append(p);
					if(pow>=2)
					{
						ans.append('^');
						ans.append(pow);
					}
					pcount++;
				}
				p=p.add(ONE);
				pow=0;
				pcache=false;
				continue;
			}
			target=target.divide(p);
			pow++;
		}
		if(pcount==0)
		{
			ans.append('1');
		}
		ans.append('\n');
		print(ans.toString());
	}
	private void calcGen()
	{
		BigInteger target=getNumber();
		BigInteger nxt=target.nextProbablePrime();
		numView.setText(nxt.toString());
		print("nextPrime("+target+")="+nxt+"\n");
	}
	private void calcRand()
	{
		
	}
	private void calcIncr()
	{
		BigInteger target;
		try
		{
			target=new BigInteger(numView.getText().toString());
		}
		catch(NumberFormatException nfx)
		{
			Log.e(TAG,nfx.toString());
			print("Some errors occurred");
			return;
		}
		target=target.add(BigInteger.ONE);
		numView.setText(target.toString());
	}
	private void print(String seq)
	{
		resultView.setText(resultView.getText()+seq);
	}
	private void clean()
	{
		resultView.setText("");
	}
	private final String TAG=this.getClass().getName()+this.toString();
}
