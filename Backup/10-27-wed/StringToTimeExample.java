package com.temp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToTimeExample
{
	 public static void main(String[] args)
	    {	
	    	String string = "9:15:12";
	    	DateFormat inFormat = new SimpleDateFormat( "hh:mm:ss");

	    	
	    	DateFormat outFormat = new SimpleDateFormat( "HH:mm:ss");
	    	Date date = null;
	    	try
	    	{
	    	    date = inFormat.parse(string);
	    	    
	    	}
	    	catch ( ParseException e )
	    	{
	    	        e.printStackTrace();
	    	}
	    	if( date != null )
	    	{
	    		
	    	    String myDate = outFormat.format(date);
	    	    System.out.println(myDate);
	    	}
	    }
}

