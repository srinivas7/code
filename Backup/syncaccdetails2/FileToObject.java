package com.syncaccdetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FileToObject extends Thread {

	public  BufferedReader br;

	int count = 1;
	static Map<Integer,ChangedAmount> m = Collections.synchronizedMap(new HashMap<Integer,ChangedAmount>());


	public   Map<Integer, ChangedAmount>  filetoobj(File file, EmpAcc emp, String operation,int amount) throws NumberFormatException, IOException, InterruptedException {

	
		/*EmpAcc emp = emp1;
		String operation = operation1;
		int amount = amount1;
		*/
		
		ChangedAmount cc =m.get(emp.AccId);
		
		synchronized (emp){


			System.out.println("Thread entered into block"+count++ +FileToObject.currentThread());
			
			if(cc==null){


			
				ChangedAmount ca  = new ChangedAmount(amount);


				System.out.println("first"+amount);
				
				
				m.put(emp.AccId,ca);

				}
			
			else{
				
				
				if(operation.equals("dep")){
			
					System.out.println("dep operation found");

					cc.deposit(amount);
					}
				


				else if(operation.equals("wit")){
					
					

					System.out.println("wit operation found");

					cc.deduct(amount);
					}
				}	

			}
		
		return m;
	}
}
