package com.jcohy.study.jcopy;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiachao
 *
 */
public class FileUtils {
	public static boolean ctrateFile(String path,String content){
		File file  = new File(path);
		try {
			OutputStream out = new FileOutputStream(file);
			out.write(content.getBytes());
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 追加文件：使用RandomAccessFile 
	 * @param fileName:文件名
	 * @param content：内容
	 */
//	public static boolean appendFile(String fileName, String content){
//		 RandomAccessFile randomFile = null;  
//		 try {
//			 // 打开一个随机访问文件流，按读写方式     
//			 randomFile=new RandomAccessFile(fileName, "rw");
//			 long filelength = randomFile.length();
//			 // 将写文件指针移到文件尾。   
//			 System.out.println(filelength);
//			 randomFile.seek(filelength);
//			 randomFile.write(content.getBytes());
//			 return true;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//			// TODO: handle exception
//		}finally{
//			if(randomFile!=null)
//				try {
//					randomFile.close();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
//	
//	}
	public static boolean appendFile(String fileName,String content){
		 BufferedWriter out = null;     
	        try {
	        	File file = new File(fileName);
	            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
	        	if(file.length()>0){
	        		out.newLine();
	        		out.write(content);
	        	}else{
	        		out.write(content);
	        	}
	            return true;
	        } catch (Exception e) {     
	            e.printStackTrace();   
	            return false;
	        } finally {     
	            try {     
	                if(out != null){  
	                    out.close();     
	                }  
	            } catch (IOException e) { 
	                e.printStackTrace();     
	                return false;
	            }     
	        }     
	}
	public static boolean formatFile(String fileName,String content){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		return appendFile(fileName,format.format(new Date())+"\t"+content);
	}
}
