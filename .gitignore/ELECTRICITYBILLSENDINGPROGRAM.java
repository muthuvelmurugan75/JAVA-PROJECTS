package com.tricky.www;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class ELECTRICITYBILLSENDINGPROGRAM {
	static String name=null;
	static String ebid=null;
	Main_email_sending_program me=new Main_email_sending_program();
	static  int t=1000;
    static String billpay;
    
    public static void main(String[] args) {
    	name="muthu";
        ebid="987";
        ELECTRICITYBILLSENDINGPROGRAM y = new  ELECTRICITYBILLSENDINGPROGRAM ();
	    y.timeshower();
	    }
    static  int units=88;
    public int timeshower(){
    	Timer timer = new Timer();
	    TimerTask tt = new SchedulerTask();
	    DateFormat df = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
	    Date triggerTime = null;
	    try {
	        triggerTime = df.parse("2016-04-12 12:25:08");
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	   
			   timer.schedule(tt, triggerTime,t);
			return 0;
			
		
	}

	static class SchedulerTask extends TimerTask {
	    @Override
	    public void run() {
	    
	        System.out.println("I am running at " + Calendar.getInstance().getTime());
	        
			
			
			show(units);
			

	    }
	}
	public static void show(int units){

		 
		double billpay=0;
	 
	        	if(units<100)
		 {
		      billpay=units*1.20;
		  }
		else if(units<300)
		 {
		   billpay=100*1.20+(units-100)*2;
		 }
		else if(units>300)
		{
		    billpay=100*1.20+200*2+(units-300)*3;
		}
		        JOptionPane.showMessageDialog(null, "Your Current Bill Is"+billpay);

		

	    String USER_NAME = "huvel75@gmail.com";  // GMail user name (just the part before "@gmail.com")
	      String PASSWORD = "8760751648"; // GMail password
	   // private static String RECIPIENT = "lizard.bill@myschool.edu";

		 String from = USER_NAME;
	     String pass = PASSWORD;
	     String[] to = { "muthuvelmurugan75@gmail.com " }; // list of recipient email addresses
	     String subject = "name:"+name+"Eb number:"+ebid;
	     String body =String.valueOf(billpay);

	         Properties props = System.getProperties();
	         String host = "smtp.gmail.com";
	         props.put("mail.smtp.starttls.enable", "true");
	         props.put("mail.smtp.host", host);
	         props.put("mail.smtp.user", from);
	         props.put("mail.smtp.password", pass);
	         props.put("mail.smtp.port", "587");
	         props.put("mail.smtp.auth", "true");

	         Session session = Session.getDefaultInstance(props);
	         MimeMessage message = new MimeMessage(session);

	         try {
	             message.setFrom(new InternetAddress(from));
	             InternetAddress[] toAddress = new InternetAddress[to.length];

	             // To get the array of addresses
	             for( int i = 0; i < to.length; i++ ) {
	                 toAddress[i] = new InternetAddress(to[i]);
	             }

	                message.addRecipients(Message.RecipientType.TO,InternetAddress.parse("huvel75@gmail.com,muthuvelmurugan75@gmail.com"));
	             

	             message.setSubject(subject);
	             message.setText(body);
	             Transport transport = session.getTransport("smtp");
	             transport.connect(host, from, pass);
	             transport.sendMessage(message, message.getAllRecipients());
	             transport.close();
	         }
	         catch (AddressException ae) {
	             ae.printStackTrace();
	         }
	         catch (MessagingException me) {
	             me.printStackTrace();
	         }
	     }
	 

	}

	

