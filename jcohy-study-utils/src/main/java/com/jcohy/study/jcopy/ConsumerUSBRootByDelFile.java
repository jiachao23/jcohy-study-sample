package com.jcohy.study.jcopy;

import java.io.IOException;

/**
 * Ïû·ÑÕß
 * 
 * @author jiachao
 *
 * 
 */
public class ConsumerUSBRootByDelFile implements Runnable {
	private ResFileByDelFile rf = null;

	public ConsumerUSBRootByDelFile(ResFileByDelFile rf) {
		this.rf = rf;
	}

	@Override
	public void run() {
		while (true) {
			try {
				rf.copyFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
