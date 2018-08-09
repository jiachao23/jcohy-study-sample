package com.jcohy.study.jcopy;

import com.jcohy.study.file.FileUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResFileByDelFile {
	private static int count = 0;//���Ƽ������Ĳ�� 
	private static int value = 0;
    //�ж��Ƿ����豸����ı��  
    private boolean flag = false; 
    private File[] dirs;
    public static String rootPath;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public ResFileByDelFile(int count) {  
        this.count = count;
        this.value = count;
    }  
    //�ݹ鸴���ļ�  
    public static void copyFileFromDir(String toPath, String fromPath) {  
        File file = new File(fromPath);  
        createFile(toPath, false);// true:�����ļ� false����Ŀ¼  
        if (file.isDirectory()) {// �����Ŀ¼  
            copyFileToDir(toPath, listFile(file));  
        }  
    }  
  
    // ����Ŀ¼��ָ��Ŀ¼,��Ŀ¼�Լ�Ŀ¼�µ��ļ�����Ŀ¼ȫ�����Ƶ�Ŀ��Ŀ¼  
    public static void copyDir(String toPath, String fromPath) { 
//    	System.out.println("---toPath--->"+toPath+"---fromPath--->"+fromPath);
        File targetFile = new File(toPath);// �����ļ�  
        createFile(targetFile, false);// ����Ŀ¼  
        File file = new File(fromPath);// �����ļ�  
        if (targetFile.isDirectory() && file.isDirectory()) {// ���������Ŀ¼ 
//        	System.out.println("targetFileAndFile"+targetFile.getAbsolutePath() + "/" + file.getName());
            copyFileToDir(targetFile.getAbsolutePath() + "/" + file.getName(),  
                    listFile(file));// �����ļ���ָ��Ŀ¼  
        }  
    }  
  
    // ����һ���ļ���ָ��Ŀ¼��targetDir��Ŀ��Ŀ¼��filePath����Ҫ���Ƶ��ļ�·��  
    public static void copyFileToDir(String toDir, String[] filePath) {  
        if (toDir == null || "".equals(toDir)) {// Ŀ¼·��Ϊ��  
//            System.out.println("��������Ŀ��·������Ϊ��");  
        	FileUtils.appendFile(rootPath,
            		sdf.format(new Date())+"��������Ŀ��·������Ϊ��!!");
            return;  
        }  
        File targetFile = new File(toDir);  
        if (!targetFile.exists()) {// ���ָ��Ŀ¼������  
            targetFile.mkdir();// �½�Ŀ¼  
        } else {  
            if (!targetFile.isDirectory()) {// �������Ŀ¼  
//                System.out.println("��������Ŀ��·��ָ��Ĳ���һ��Ŀ¼��");  
            	FileUtils.appendFile(rootPath, 
                		sdf.format(new Date())+"��������Ŀ��·��ָ��Ĳ���һ��Ŀ¼��");
                return;  
            }  
        } 
        if(filePath!=null){
        	for (int i = 0; i < filePath.length; i++) {// ������Ҫ���Ƶ��ļ�·��  
        		File file = new File(filePath[i]);// �����ļ�  
        		if (file.isDirectory()) {// �ж��Ƿ���Ŀ¼  
        			copyFileToDir(toDir + "/" + file.getName(), listFile(file));// �ݹ���÷������Ŀ¼�µ��ļ�  
        			System.out.println("�����ļ� " + file);  
        		} else {  
        			copyFileToDir(toDir, file, "");// �����ļ���ָ��Ŀ¼  
        		}  
        	}  
        }
    }  
  
    public static void copyFileToDir(String toDir, File file, String newName) {// �����ļ���ָ��Ŀ¼  
        String newFile = "";  
        if (newName != null && !"".equals(newName)) {  
            newFile = toDir + "/" + newName;  
        } else {  
            newFile = toDir + "/" + file.getName();  
        }  
        File tFile = new File(newFile);  
        copyFile(tFile, file);// ���÷��������ļ�  
    }  
  
    public static void copyFile(File toFile, File fromFile) {// �����ļ�  
        if (toFile.exists()) {// �ж�Ŀ��Ŀ¼���ļ��Ƿ����  
//            System.out.println("�ļ�" + toFile.getAbsolutePath() + "�Ѿ����ڣ��������ļ���");
            FileUtils.appendFile(rootPath, 
            		sdf.format(new Date())+toFile.getAbsolutePath() + "�Ѿ����ڣ��������ļ���");
            return;  
        } else {  
            createFile(toFile, true);// �����ļ�  
        }  
//        System.out.println("�����ļ�" + fromFile.getAbsolutePath() + "��"  
//                + toFile.getAbsolutePath());
        FileUtils.appendFile(rootPath, 
        		sdf.format(new Date())+fromFile.getAbsolutePath() + "-------->"  
                + toFile.getAbsolutePath());
        try {  
            InputStream is = new FileInputStream(fromFile);// �����ļ�������  
            FileOutputStream fos = new FileOutputStream(toFile);// �ļ������  
            byte[] buffer = new byte[1024];// �ֽ�����  
            while (is.read(buffer) != -1) {// ���ļ�����д���ļ���  
                fos.write(buffer);  
            }  
            is.close();// �������ر�  
            fos.close();// ������ر�  
        } catch (FileNotFoundException e) {// �����ļ��������쳣  
            e.printStackTrace();  
        } catch (IOException e) {// �����쳣  
            e.printStackTrace();  
        }  
    }  
    public static String[] listFile(File dir) {// ��ȡ�ļ�����·��  
        String absolutPath = dir.getAbsolutePath();// �����ַ�����ֵΪ·�����ļ���·��  
        String[] paths = dir.list();// �ļ�������
        String[] files;
        if(paths!=null){
        	
        	files = new String[paths.length];// �����ַ������飬����Ϊ�����ļ��ĸ���  
        	for (int i = 0; i < paths.length; i++) {// ������ʾ�ļ�����·��  
        		files[i] = absolutPath + "/" + paths[i];  
        	}  
        	return files;  
        }
        return null;
    }  
  
    public static void createFile(String path, boolean isFile) {// �����ļ���Ŀ¼  
        createFile(new File(path), isFile);// ���÷����������ļ���Ŀ¼  
    }  
  
    public static void createFile(File file, boolean isFile) {// �����ļ�  
        if (!file.exists()) {// ����ļ�������  
            if (!file.getParentFile().exists()) {// ����ļ���Ŀ¼������  
                createFile(file.getParentFile(), false);  
            } else {// �����ļ���Ŀ¼  
                if (isFile) {// �����ļ�  
                    try {  
                        file.createNewFile();// �������ļ�  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                } else {  
                    file.mkdir();// ����Ŀ¼  
                }  
            }  
        }  
    }  
  
    
    
    //������Դ--������ʹ��  
    public synchronized void searchFile() {  
        //���flagΪtrue��˵���������豸���룬��ȴ���  
        //���flagΪfalse��˵��û���豸����  
        if (flag) {  
            try {  
                wait();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        dirs = File.listRoots();
        //һ�����豸���룬��ǰ�̷��������ϵͳһ��ʼ���̷���  
        if (dirs.length > count) {  
//        	System.out.println("search dirs----->"+dirs.length);
//        	System.out.println("count----->"+count);
//        	System.out.println(dirs.length==count);
            flag = true;  
            notify();
        }if(dirs.length==count){
        	return;
        }if(dirs.length<count){
        	count=dirs.length;
        }
    }  
    //������Դ--������ʹ��  
    public synchronized void copyFile() throws IOException {  
        if (!flag) {  
            try {  
                wait();  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        if (dirs.length > count) {  
        	rootPath = dirs[1].getPath().substring(0,2)+"/log.txt";
//        	copyDir(dirs[value].getPath().toString().substring(0, 2), 
//        			dirs[1].getPath().toString().substring(0, 2));
        	copyDir(dirs[0].getPath(),dirs[dirs.length-1].getPath());
//        	Stem.out.println("count--->"+count+"--value--->"+value);
        	count++;
            flag = false;  
            notify();  
        }  
    }  
}
