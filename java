package Stopwatch;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Stopwatch implements ActionListener{
	
	JFrame frame =new JFrame();
	   JButton startButton =new JButton("START");
	   JButton resetButton =new JButton("RESET");
	   JLabel timeLabel =new JLabel();
	   int elapsedTime =0;
	   int second =0;
	   int minutes =0;
	   int hours =0;
	   boolean started =false;
	   String second_String =String.format("%02d",second);
	   String minutes_String =String.format("%02d",minutes);
	   String hours_String =String.format("%02d",hours);
	   
	   Timer time = new Timer(1000, new ActionListener() {
		   
           public void actionPerformed(ActionEvent e) {
			   
			   elapsedTime=elapsedTime+1000;
			   hours = (elapsedTime/3600000);
			   minutes =(elapsedTime/60000)% 60;
			   second =(elapsedTime/1000)% 60;
			   second_String =String.format("%02d",second);
			   minutes_String =String.format("%02d",minutes);
			   hours_String =String.format("%02d",hours);
			   timeLabel.setText(hours_String+":"+minutes_String+":"+second_String);
		   }
	   });
	   
	   
	Stopwatch(){

        timeLabel.setText(hours_String+":"+minutes_String+":"+second_String);
        timeLabel.setBounds(100,100,200,100);
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(JTextField.CENTER);
        
        startButton.setBounds(100,200,100,50);
        startButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        
        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Ink Free",Font.PLAIN,20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        
        
         frame.add(startButton);
         frame.add(resetButton);
         frame.add(timeLabel);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.setSize(420,420);
	     frame.setLayout(null);
	     frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==startButton) {
			if(started==false) {
				started=true;
				startButton.setText("STOP");
				start();
			}
			else {
				started=false;
				startButton.setText("START");
				stop();
			}
			if(e.getSource()==resetButton) {
				started=false;
				startButton.setText("START");
				reset();
			}
		}
	}
	void start() {
		time.start();
	}
	void stop(){
		time.stop();
	}
	void reset() {
		time.stop();
		elapsedTime=0;
		second=0;
		minutes=0;
		hours=0;
		   second_String =String.format("%02d",  second);
		   minutes_String =String.format("%02d",minutes);
		   hours_String =String.format("%02d",hours);
		   timeLabel.setText(hours_String+":"+minutes_String+":"+second_String);
	   
	}

}
