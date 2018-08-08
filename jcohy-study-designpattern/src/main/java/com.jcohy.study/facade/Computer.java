package com.jcohy.study.facade;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Computer {
	private Cpu cpu;
	private Memory memory;
	private Disk disk;
	
	public Computer() {
		cpu = new Cpu();
		memory = new Memory();
		disk = new Disk();
	}
	
	public void startup() {
		System.out.println("computer startup");
		cpu.startup();
		memory.startup();
		disk.startup();
		System.out.println("computer startup finished");
		
	}
	
	public void shutdown() {
		System.out.println("computer shutdown");
		cpu.shutdown();
		memory.shutdown();
		disk.shutdown();
		System.out.println("computer shutdown finished");
	}
}
