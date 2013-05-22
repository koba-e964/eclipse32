package kobae964_app.gui.timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class KTimer {
	public KTimer()
	{
		frame=new JFrame("Timer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		numbers=new JButton[10];
		listener=new BListener();
		for(int i=0;i<10;i++)
		{
			numbers[i]=new JButton(String.valueOf(i));
			numbers[i].setActionCommand(String.valueOf(i));
			numbers[i].addActionListener(listener);
		}
		GridLayout layout=new GridLayout(4, 3);
		JPanel btnPanel=new JPanel(layout);
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				btnPanel.add(numbers[7-3*i+j]);
			}
		}
		btnPanel.add(new JPanel());
		btnPanel.add(numbers[0]);
		this.indicator=new JLabel();
		disp=new TimeDisp();

		onOff=new JButton();
		onOff.setText("Start/Stop");
		onOff.setActionCommand("SS");
		onOff.addActionListener(listener);
		onOff.setSize(40, 60);

		frame.setLayout(new java.awt.BorderLayout(10, 10));
		frame.getContentPane().add(btnPanel,BorderLayout.CENTER);
		frame.getContentPane().add(indicator,BorderLayout.NORTH);
		frame.getContentPane().add(onOff,BorderLayout.EAST);
		frame.setVisible(true);
		running=false;
		setTime();
		timer=new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(running)
				{
					disp.decrement();
					setTime();
				}
			}
		},0, 10);
	}
	void setTime()
	{
		indicator.setText(disp.toString());
	}
	void startStop()
	{
		running=!running;
	}
	public static void main(String[] args) {
		new KTimer();
	}
	private JFrame frame;
	private JButton[] numbers;
	private JLabel indicator;
	private JButton onOff;
	private Timer timer;
	private boolean running;
	private ActionListener listener;
	private TimeDisp disp;
	class BListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			if(cmd.length()==1)
			{
				if(!running)
				{
					disp.push(cmd.charAt(0)-'0');
					setTime();
				}
				
			}
			else if(cmd.equals("SS"))
			{
				startStop();
			}
		}
	}
}