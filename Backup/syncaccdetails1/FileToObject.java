package com.syncaccdetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FileToObject extends Thread {

	public BufferedReader br;
	int final_amount=0;

	Map<String,ChangedAmount> m = new HashMap<String,ChangedAmount>();
	/*EmpAcc emp = new EmpAcc();*/

	public Map<String, ChangedAmount> filetoobj(File file) throws NumberFormatException, IOException {

		/*Map<String,ChangedAmount> m = new HashMap<String,ChangedAmount>();
		 */
		System.out.println("method is called");

		br = new BufferedReader(new FileReader(file));
		String line;

		while ((line = br.readLine()) != null) {

			EmpAcc emp = new EmpAcc();

			StringTokenizer st = new StringTokenizer(line);

			while (st.hasMoreTokens()) {

				//Id
				String id =st.nextToken();
				int accid = Integer.parseInt(id);
				emp.setAccId(id);

				//Deposit/Withdraw
				String operation =st.nextToken();
				emp.setOperation(operation);

				//Amount
				int amount =Integer.parseInt(st.nextToken());
				emp.setAmount(amount);


				ChangedAmount cc =m.get(id);

				if(cc==null){


					ChangedAmount ca  = new ChangedAmount(amount);

					synchronized (ChangedAmount.class) {


						m.put(id,ca);

					}
				}
				else{



					if(operation.equals("dep")){



						System.out.println("dep operation found");

						synchronized (ChangedAmount.class) {
							cc.deposit(amount);
						}
						//System.out.println(ca.amount);


					}

					else if(operation.equals("wit")){

						System.out.println("wit operation found");
						synchronized (ChangedAmount.class) {
							cc.deduct(amount);
						}
						//System.out.println(ca.amount);

					}	

				}
			}
		}
		return m;
	}
}