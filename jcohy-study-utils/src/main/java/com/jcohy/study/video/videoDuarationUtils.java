package com.jcohy.study.video;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class videoDuarationUtils {

	/** 
	 * 获取视频总时间 
	 * @param video_path    视频路径
	 * @param ffmpeg_path   ffmpeg路径 
	 * @return 
	 */  
	public static int getVideoTime(String video_path, String ffmpeg_path) {  
	    List<String> commands = new java.util.ArrayList<String>();  
	    commands.add(ffmpeg_path);  
	    commands.add("-i");  
	    commands.add(video_path);  
	    try {  
	        ProcessBuilder builder = new ProcessBuilder();  
	        builder.command(commands);  
	        final Process p = builder.start();  
	          
	        //从输入流中读取视频信息  
	        BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));  
	        StringBuffer sb = new StringBuffer();  
	        String line = "";  
	        while ((line = br.readLine()) != null) {  
	            sb.append(line);  
	        }  
	        br.close();  
	          
	        //从视频信息中解析时长  
	        String regexDuration = "Duration: (.*?), start: (.*?), bitrate: (\\d*) kb\\/s";  
	        Pattern pattern = Pattern.compile(regexDuration);  
	        Matcher m = pattern.matcher(sb.toString());  
	        if (m.find()) {  
	            int time = getTimelen(m.group(1));  
	         /*   log.info(video_path+",视频时长："+time+", 开始时间："+m.group(2)+",比特率："+m.group(3)+"kb/s");  */
	            return time;  
	        }  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	      
	    return 0;  
	}  
	  
	//格式:"00:00:10.68"  
	private static int getTimelen(String timelen){  
	    int min=0;  
	    String strs[] = timelen.split(":");  
	    if (strs[0].compareTo("0") > 0) {  
	        min+=Integer.valueOf(strs[0])*60*60;//秒  
	    }  
	    if(strs[1].compareTo("0")>0){  
	        min+=Integer.valueOf(strs[1])*60;  
	    }  
	    if(strs[2].compareTo("0")>0){  
	        min+=Math.round(Float.valueOf(strs[2]));  
	    }  
	    return min;  
	}  

}
