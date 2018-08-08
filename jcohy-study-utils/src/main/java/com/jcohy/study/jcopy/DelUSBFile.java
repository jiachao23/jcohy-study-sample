package com.jcohy.study.jcopy;

import java.io.File;

public class DelUSBFile {
	 public static int count = 0;  
	    public static void main(String[] args) throws Exception {  
	        // TODO Auto-generated method stub  
	        File[] dirs = File.listRoots();  
	        count = dirs.length;
	        for(File dir:dirs)
	        	System.out.println(dir+":"+count);
	        ResFileByDelFile rf = new ResFileByDelFile(count);  
	        Thread t1 = new Thread(new ProducerUSBRootByDelFile(rf));  
	        Thread t2 = new Thread(new ConsumerUSBRootByDelFile(rf));  
	        t1.start();  
	        t2.start();  
	    }  
}
