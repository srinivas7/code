package com.temp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ReadFileExample {

	public static void main(String[] args) throws IOException, ParseException {

		Scanner s = new Scanner(System.in);
		Date date = null;
		
		File file = new File("/home/valuelabs/workspace/Bs/src/com/temp/abc.txt");
		FileInputStream fis = new FileInputStream(file);
		
		FileToObject fto = new FileToObject();
		Map<Emp,Integer> map =fto.filetoobj(file);
		
		System.out.println("Enter your choice: 1.to find number of Emp's  2.to find Emp Time");
		int choice= s.nextInt();
		
		switch(choice){
		case 1:
			//to find number of Emp's on entered date
			s.nextLine();
			System.out.println("Enter Date : ");
			String date1 = s.nextLine();
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			
		 
			try {
		 
				 date = formatter.parse(date1);
				
				//System.out.println(formatter.format(date));
		 
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			CountingEmps ce = new CountingEmps();
			
			System.out.println("Number of Emp's on "+ formatter.format(date) +" are");
			ce.EmpsCount(map,date);

			
			break;
			
		case 2:
			
			//to find Emp Time
			
			break;
		}
		
		//System.out.println("Map object is "+map);
		
			}
	
	}

	
