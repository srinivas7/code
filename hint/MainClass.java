package com.hint;

import java.io.File;

public class MainClass {
	
	public static File file = new File("/home/valuelabs/workspace/Threads/src/com/hint/hint.txt");
	//public static int readers = 0;
	//public static int writers = 0;

	public static void main(String[] args) {
		
		
		new RW(file,"read").start();
		new RW(file,"read").start();
		new RW(file,"write").start();
		new RW(file,"read").start();
		
		
	}

}
