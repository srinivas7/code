package com.hint;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class RW extends  Thread {


	int ch;

	FileReader fr;
	FileWriter fw;
	File file;
	String operation;


	public BufferedReader br;
	public BufferedWriter bw;
	
	RW(File file,String operation){
		this.file = file;
		this.operation = operation;
	}

	RWLock rw = new RWLock();

	public void run() {

		if(operation.equals("read")){

			try {

				rw.getReadAccess();
				fr = new FileReader(file);
				br = new BufferedReader(fr);

				while((ch = br.read()) != -1){

					System.out.print((char)ch);
				}

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}catch (IOException e) {

				e.printStackTrace();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			/*System.out.println(" ");
			System.out.println("reading..." + readers + " reading");*/

			rw.releaseAccess();
		}
		else{
			try {

				bw = new BufferedWriter(new FileWriter(file, true));
				rw.getWriteAccess();
				/*System.out.println("writing...");*/
				bw.write(" .");
				bw.flush();

				rw.releaseAccess();
			} catch (IOException e) {

				e.printStackTrace();
			}

			rw.releaseAccess();


		}

	}




}
