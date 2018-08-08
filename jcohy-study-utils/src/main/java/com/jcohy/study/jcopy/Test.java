package com.jcohy.study.jcopy;

public class Test {
	public static void main(String[] args) {// java程序主入口处  
    	String fromPath="D:";
		String toPath="E:/1";
        System.out.println("复制目录 " + fromPath + "到指定目录 " + toPath  
                + " ,将目录以及目录下的文件和子目录全部复制到目标目录");
     // 调用方法实现目录以用目录下的文件和子目录全部复制  
        ResFileByDelFile.copyDir(toPath, fromPath);
    }  
}
