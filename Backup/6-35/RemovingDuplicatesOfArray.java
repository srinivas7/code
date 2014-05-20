package com.temp;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class RemovingDuplicatesOfArray {


	public  void  removeDuplicatesInIntArray1(Map<Emp, Integer> m) {

		int array[] = new int[m.size()];
		int i=0;

		Iterator<Map.Entry<Emp, Integer>> it = m.entrySet().iterator();

		//System.out.println("Checking copy of id's");
		while(it.hasNext()){
			Entry<Emp,Integer> ee =it.next();

			array[i]=ee.getKey().getId();
			//System.out.println(array[i]);
			i++;
		}

		/*System.out.println("Array elements are");
		for(i=0;i<array.length;i++){
			System.out.println(array[i]);
		}*/
		int NumberOfEmp= removeDuplicatesInIntArray1(array);
		System.out.println(NumberOfEmp);

	}







	public  int  removeDuplicatesInIntArray1(int[] array) {

	/*	System.out.println("id code "+array.length);
		for(int a=0;a<array.length;a++)
			System.out.println(array[a]);*/

		int[] copy = Arrays.copyOf(array, array.length);
		Arrays.sort(copy);

		
		int count = 0;
		int previous = copy[0];
		for (int i = 1; i < array.length; ++i) {
			if (previous != copy[i]) {
				previous = copy[i];
				copy[++count] = previous;
			}
		}
		/*System.out.println("Elements after loop are");
		for(int k=0;k<copy.length;k++)
			System.out.println(copy[k]);
		System.out.println("size in seperate class"+Arrays.copyOf(copy, count+1).length);*/
		return Arrays.copyOf(copy, count+1).length;

	}








}
