package com.jcohy.study.jcopy;

/**
 * ЩњВњеп
 * @author jiachao
 *
 */
public class ProducerUSBRootByDelFile implements Runnable{
	private ResFileByDelFile rf = null;  
    public ProducerUSBRootByDelFile(ResFileByDelFile rf) {  
        this.rf = rf;  
    }  
    @Override  
    public void run() {  
        // TODO Auto-generated method stub  
        while (true) {  
            rf.searchFile();  
        }  
    }  
}
