package com.jcohy.study.video;

import com.jcohy.study.core.Encodes;
import com.jcohy.study.file.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class VideoConvertUtils {
	/**
     * 视频转码
     * @param ffmpegPath    转码工具的存放路径
     * @param upFilePath    用于指定要转换格式的文件,要截图的视频源文件
     * @param codcFilePath    格式转换后的的文件保存路径
     * @return
     * @throws Exception
     */
    public static boolean executeCodecs(String ffmpegPath, String upFilePath, String codcFilePath) throws Exception {
	// 创建一个List集合来保存转换视频文件为flv格式的命令
	List<String> convert = new ArrayList<String>();
	
	/*convert.add(FileUtils.path("F:/HSE2/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/HSE/tools/ffmpeg.exe"));*/
	convert.add(FileUtils.path(ffmpegPath));
	convert.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
	convert.add(FileUtils.path(Encodes.urlDecode(upFilePath))); // 添加要转换格式的视频文件的路径"
	convert.add("-y"); // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
	convert.add(FileUtils.path(Encodes.urlDecode(codcFilePath)));
	/*convert.add(ffmpegPath); // 添加转换工具路径
	convert.add("-i"); // 添加参数＂-i＂，该参数指定要转换的文件
	convert.add(upFilePath); // 添加要转换格式的视频文件的路径
	convert.add("-qscale");     //指定转换的质量
	convert.add("6");
	convert.add("-ab");	//设置音频码率
	convert.add("64");
	convert.add("-ac");	//设置声道数
	convert.add("2");
	convert.add("-ar");	//设置声音的采样频率
	convert.add("22050");
	convert.add("-r");	//设置帧频
	convert.add("24");
	convert.add("-y"); // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
	convert.add(codcFilePath);*/


	boolean mark = true;
	ProcessBuilder builder = new ProcessBuilder();
	try {
	    builder.command(convert);
	    // 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
	    //因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易
	    builder.redirectErrorStream(true);
	    builder.start();
	    

	} catch (Exception e) {
	    mark = false;
	    System.out.println(e);
	    e.printStackTrace();
	}
	return mark;
    }
}
