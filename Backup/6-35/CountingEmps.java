package com.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CountingEmps {

	public int EmpsCount1(Map<Emp, Integer> m){


		Iterator<Map.Entry<Emp, Integer>> it = m.entrySet().iterator();
		int[] array = new int[m.size()];
		int size=0;

		System.out.println("Details in counting Emp:");
		List<Emp> l = new ArrayList<Emp>();
		while (it.hasNext()) {


			Entry<Emp,Integer> ee =it.next();



			/*while(i.hasNext()){

				Emp e1 =(Emp)i.next();

				if(e1.hashCode()!=ee.getKey().hashCode()){
					l.add(ee.getKey());
				}

	    		if(ee.getKey().compareTo(ee.getKey())==0)
	    		l.add(ee.getKey());
	    		}

				//s.add(ee.getKey());

				System.out.println(ee.getKey().getId());
				System.out.println(ee.getKey().getTime());
				System.out.println(ee.getKey().getDate());

			}*/

			//create array

			for(int j=0;j<array.length;j++){
				array[j]=ee.getKey().hashCode();
			}



		}

		RemovingDuplicatesOfArray rdoa = new RemovingDuplicatesOfArray();
		//size =rdoa.removeDuplicatesInIntArray(array);
		System.out.println("trial "+size);
		System.out.println("Size of list is(Number of Emp's) :"+size);
		return 0;

	}
	public void EmpsCount(Map<Emp, Integer> m){

		/*int array[]=new int[m.size()];
		int i=0;
		int size=0;
		Iterator<Map.Entry<Emp, Integer>> it = m.entrySet().iterator();

		System.out.println("Checking copy of id's");
		while(it.hasNext()){
			Entry<Emp,Integer> ee =it.next();

			array[i]=ee.getKey().getId();
			System.out.println(array[i]);
		}



		RemovingDuplicatesOfArray rdoa = new RemovingDuplicatesOfArray();
		  size =rdoa.removeDuplicatesInIntArray(array);

		  System.out.println("Size of array is "+size);
		return size;


	}
		 */	
		RemovingDuplicatesOfArray rdoa = new RemovingDuplicatesOfArray();
		rdoa.removeDuplicatesInIntArray1(m);
		

		

	}
}