package com.syncaccdetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ThreadClass  extends Thread{

	FileToObject fto;
	File file;

	BufferedReader br;

	int accid;
	String operation;
	int amount;

	String name;

	ThreadClass(FileToObject fto,File file,String name){
		
		this.fto = fto;
		this.file = file;

		this.name = name;
		
		

	}

	public void run(){

		System.out.println("thread "+ name + "started...");
		
		try {
			br = new BufferedReader(new FileReader(file));
			String line;



			System.out.println(this.getName());
			while ((line = br.readLine()) != null) {



				StringTokenizer st = new StringTokenizer(line);




				while (st.hasMoreTokens()) {


					// Id
					String id =st.nextToken();
					accid = Integer.parseInt(id);



					EmpAcc emp = new EmpAcc(accid);

					System.out.println("==="+accid);

					System.out.println("----"+accid);


					// Deposit/Withdraw
					operation =st.nextToken();


					// Amount
					amount =Integer.parseInt(st.nextToken());
					System.out.println(id);

					fto.filetoobj(file,emp,operation, amount);

				} 
			}
		}catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}


	}

}