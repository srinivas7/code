package com.hint;

public class RWLock {

	public static int readers;
	public static boolean isWriting = false;
	public static int waitingWriters;

	public final Object lock;
	RWLock(){

		readers = 0;
		waitingWriters = 0;
		lock  = new Object();
	}

	

	public   void getReadAccess() throws InterruptedException{
		synchronized (lock) {



			System.out.println("Reading started by "+Thread.currentThread().getName());

			try{
				while((readers ==-1) || (waitingWriters != 0)){
					System.out.println("Waiting by>>>>>>> "+Thread.currentThread().getName());
					lock.wait();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			readers++;


			/*
		while(!isWriting){
		System.out.println("Reading started by "+Thread.currentThread().getName());

		if(isWriting == false){
			readers++;

		}else{
			System.out.println("@@@@@@Waiting by "+Thread.currentThread().getName());
			wait();
		}

			 */
		}
	}


	//}

	public   void getWriteAccess(){
		synchronized (lock) {



			System.out.println("Writing started by------>"+Thread.currentThread().getName());

			waitingWriters++;
			try{
				while(/*readers!=0 || */isWriting == true){
					System.out.println("Waiting by>>>>>>>>> "+Thread.currentThread().getName());
					lock.wait();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			waitingWriters--;
			readers = -1;
			System.out.println("Writing done by-----> "+Thread.currentThread().getName());


			/*//while(true){
			if(readers == 0 ){
				System.out.println("writing...");
				isWriting = true;
				releaseAccess();

			}else{
				try{
					System.out.println("@@@@@@Waiting by "+Thread.currentThread().getName());
					wait();
				}catch(Exception e){
					e.printStackTrace();
				}

			}

		//}

			 */	}
	}

	public  void releaseAccess(){
		synchronized (lock) {


			if(readers == 0){
				return;
			}
			if(readers == -1){
				readers = 0;
			}
			else{
				System.out.println("Reading done by------> "+Thread.currentThread().getName());
				readers--;
			}

			lock.notifyAll();



			/*if(readers>0){
			readers--;
			System.out.println("Reading done by "+Thread.currentThread().getName());
		}
		if(readers == 0)
			notifyAll();

		if(isWriting){
			isWriting = false;
			System.out.println("Writing done by "+Thread.currentThread().getName());
			notifyAll();
		}*/
		}
	}

}
