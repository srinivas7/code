package com.syncaccdetails;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ListFiles 
{

	public static void main(String[] args) throws InterruptedException 
	{

		boolean flag= true;

		String path = "/home/valuelabs/Desktop/Input"; 

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles(); 

		System.out.println("Number of files " + listOfFiles.length);

		FileToObject fto = new FileToObject();
		



		ThreadClass[] t = new ThreadClass[listOfFiles.length];

		for(int i=0;i<listOfFiles.length;i++){

			t[i] = new ThreadClass(fto,listOfFiles[i]);
			System.out.println(t[i].getName()+ " is created");
			t[i].start();

		}
		
		//group all threads
		
		for(int i=0;i<listOfFiles.length;i++){
			
			t[i].join();
		}
		

	
				Map<String, ChangedAmount> mm = fto.m;

				Iterator<Entry<String, ChangedAmount>> it = mm.entrySet().iterator();

				System.out.println("final values are");
				System.out.println(mm.isEmpty());
				while(it.hasNext()){

					Entry<String,ChangedAmount> e =it.next();
					System.out.println(e.getKey()+"      "+e.getValue().amount);

				}
			}
		
	}

