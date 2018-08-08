package com.jcohy.study;

/**
 * @author jiachao
 *
 */
public class TraditionalThreadSynchronized {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new TraditionalThreadSynchronized().init();
	}
	public void init(){
		final Outputer outputer=new Outputer();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.Outputer("jiachao");
				}
			}
		}).start();


		new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.Outputer("hehe");
				}
			}
		}).start();
	}
	class Outputer{
		/**
		 * 
		 */
		private void  Outputer(String name) {
			
			synchronized (Outputer.class) {

				int length=name.length();
				for(int i=0;i<length;i++){
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}
	}
}

