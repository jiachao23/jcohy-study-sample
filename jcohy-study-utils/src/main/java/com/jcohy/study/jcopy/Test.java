package com.jcohy.study.jcopy;

public class Test {
	public static void main(String[] args) {// java��������ڴ�  
    	String fromPath="D:";
		String toPath="E:/1";
        System.out.println("����Ŀ¼ " + fromPath + "��ָ��Ŀ¼ " + toPath  
                + " ,��Ŀ¼�Լ�Ŀ¼�µ��ļ�����Ŀ¼ȫ�����Ƶ�Ŀ��Ŀ¼");
     // ���÷���ʵ��Ŀ¼����Ŀ¼�µ��ļ�����Ŀ¼ȫ������  
        ResFileByDelFile.copyDir(toPath, fromPath);
    }  
}
