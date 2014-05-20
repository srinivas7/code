package com.syncaccdetails;

import java.io.File;
import java.io.IOException;

public class ThreadClass  extends Thread{

	FileToObject fto;
	File file;

	ThreadClass(FileToObject fto,File file){
		this.fto = fto;
		this.file = file;

	}

	public void run(){
		try {
			//if(){
				//synchronized (EmpAcc.class) {

					

					//System.out.println("sync lock acquired");
					fto.filetoobj(file);
				//}
			//}
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
