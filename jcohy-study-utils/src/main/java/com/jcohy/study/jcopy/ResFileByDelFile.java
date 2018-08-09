package com.jcohy.study.jcopy;

import com.jcohy.study.file.FileUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ResFileByDelFile {
	private static int count = 0;//控制检测外设的插拔 
	private static int value = 0;
    //判断是否有设备插入的标记  
    private boolean flag = false; 
    private File[] dirs;
    public static String rootPath;
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public ResFileByDelFile(int count) {  
        this.count = count;
        this.value = count;
    }  
    //递归复制文件  
    public static void copyFileFromDir(String toPath, String fromPath) {  
        File file = new File(fromPath);  
        createFile(toPath, false);// true:创建文件 false创建目录  
        if (file.isDirectory()) {// 如果是目录  
            copyFileToDir(toPath, listFile(file));  
        }  
    }  
  
    // 复制目录到指定目录,将目录以及目录下的文件和子目录全部复制到目标目录  
    public static void copyDir(String toPath, String fromPath) { 
//    	System.out.println("---toPath--->"+toPath+"---fromPath--->"+fromPath);
        File targetFile = new File(toPath);// 创建文件  
        createFile(targetFile, false);// 创建目录  
        File file = new File(fromPath);// 创建文件  
        if (targetFile.isDirectory() && file.isDirectory()) {// 如果传入是目录 
//        	System.out.println("targetFileAndFile"+targetFile.getAbsolutePath() + "/" + file.getName());
            copyFileToDir(targetFile.getAbsolutePath() + "/" + file.getName(),  
                    listFile(file));// 复制文件到指定目录  
        }  
    }  
  
    // 复制一组文件到指定目录。targetDir是目标目录，filePath是需要复制的文件路径  
    public static void copyFileToDir(String toDir, String[] filePath) {  
        if (toDir == null || "".equals(toDir)) {// 目录路径为空  
//            System.out.println("参数错误，目标路径不能为空");  
        	FileUtils.appendFile(rootPath,
            		sdf.format(new Date())+"参数错误，目标路径不能为空!!");
            return;  
        }  
        File targetFile = new File(toDir);  
        if (!targetFile.exists()) {// 如果指定目录不存在  
            targetFile.mkdir();// 新建目录  
        } else {  
            if (!targetFile.isDirectory()) {// 如果不是目录  
//                System.out.println("参数错误，目标路径指向的不是一个目录！");  
            	FileUtils.appendFile(rootPath, 
                		sdf.format(new Date())+"参数错误，目标路径指向的不是一个目录！");
                return;  
            }  
        } 
        if(filePath!=null){
        	for (int i = 0; i < filePath.length; i++) {// 遍历需要复制的文件路径  
        		File file = new File(filePath[i]);// 创建文件  
        		if (file.isDirectory()) {// 判断是否是目录  
        			copyFileToDir(toDir + "/" + file.getName(), listFile(file));// 递归调用方法获得目录下的文件  
        			System.out.println("复制文件 " + file);  
        		} else {  
        			copyFileToDir(toDir, file, "");// 复制文件到指定目录  
        		}  
        	}  
        }
    }  
  
    public static void copyFileToDir(String toDir, File file, String newName) {// 复制文件到指定目录  
        String newFile = "";  
        if (newName != null && !"".equals(newName)) {  
            newFile = toDir + "/" + newName;  
        } else {  
            newFile = toDir + "/" + file.getName();  
        }  
        File tFile = new File(newFile);  
        copyFile(tFile, file);// 调用方法复制文件  
    }  
  
    public static void copyFile(File toFile, File fromFile) {// 复制文件  
        if (toFile.exists()) {// 判断目标目录中文件是否存在  
//            System.out.println("文件" + toFile.getAbsolutePath() + "已经存在，跳过该文件！");
            FileUtils.appendFile(rootPath, 
            		sdf.format(new Date())+toFile.getAbsolutePath() + "已经存在，跳过该文件！");
            return;  
        } else {  
            createFile(toFile, true);// 创建文件  
        }  
//        System.out.println("复制文件" + fromFile.getAbsolutePath() + "到"  
//                + toFile.getAbsolutePath());
        FileUtils.appendFile(rootPath, 
        		sdf.format(new Date())+fromFile.getAbsolutePath() + "-------->"  
                + toFile.getAbsolutePath());
        try {  
            InputStream is = new FileInputStream(fromFile);// 创建文件输入流  
            FileOutputStream fos = new FileOutputStream(toFile);// 文件输出流  
            byte[] buffer = new byte[1024];// 字节数组  
            while (is.read(buffer) != -1) {// 将文件内容写到文件中  
                fos.write(buffer);  
            }  
            is.close();// 输入流关闭  
            fos.close();// 输出流关闭  
        } catch (FileNotFoundException e) {// 捕获文件不存在异常  
            e.printStackTrace();  
        } catch (IOException e) {// 捕获异常  
            e.printStackTrace();  
        }  
    }  
    public static String[] listFile(File dir) {// 获取文件绝对路径  
        String absolutPath = dir.getAbsolutePath();// 声获字符串赋值为路传入文件的路径  
        String[] paths = dir.list();// 文件名数组
        String[] files;
        if(paths!=null){
        	
        	files = new String[paths.length];// 声明字符串数组，长度为传入文件的个数  
        	for (int i = 0; i < paths.length; i++) {// 遍历显示文件绝对路径  
        		files[i] = absolutPath + "/" + paths[i];  
        	}  
        	return files;  
        }
        return null;
    }  
  
    public static void createFile(String path, boolean isFile) {// 创建文件或目录  
        createFile(new File(path), isFile);// 调用方法创建新文件或目录  
    }  
  
    public static void createFile(File file, boolean isFile) {// 创建文件  
        if (!file.exists()) {// 如果文件不存在  
            if (!file.getParentFile().exists()) {// 如果文件父目录不存在  
                createFile(file.getParentFile(), false);  
            } else {// 存在文件父目录  
                if (isFile) {// 创建文件  
                    try {  
                        file.createNewFile();// 创建新文件  
                    } catch (IOException e) {  
                        e.printStackTrace();  
                    }  
                } else {  
                    file.mkdir();// 创建目录  
                }  
            }  
        }  
    }  
  
    
    
    //查找资源--生产者使用  
    public synchronized void searchFile() {  
        //如果flag为true，说明检测出有设备插入，则等待；  
        //如果flag为false，说明没有设备插入  
        if (flag) {  
            try {  
                wait();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        dirs = File.listRoots();
        //一但有设备插入，当前盘符数会大于系统一开始的盘符数  
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
    //消费资源--消费者使用  
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
