package com.jcohy.study.jcopy;

/**
 * 生产者
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
