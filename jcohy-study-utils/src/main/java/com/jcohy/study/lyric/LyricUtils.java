package com.jcohy.study.lyric;



import com.jcohy.study.bean.Lyric;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 作用：解析歌词工具类s
 */
public class LyricUtils {

    /**
     * 得到解析好的歌词列表
     * @return
     */
    public ArrayList<Lyric> getLyrics() {
        return lyrics;
    }

    private ArrayList<Lyric> lyrics;

    /**
     * 是否存在歌词
     * @return
     */
    public boolean isExistsLyric() {
        return isExistsLyric;
    }

    /**
     * 是否存在歌词

     */
    private boolean isExistsLyric  = false;

    /**
     * 读取歌词文件
     * @param file /mnt/scard/audio/beijingbeijing.txt
     */
    public void readLyricFile(File file){
        if(file == null || !file.exists()){
            //歌词文件不存在
            lyrics = null;
            isExistsLyric = false;
        }else{
            //歌词文件存在
            //1.解析歌词 一行的读取-解析
            lyrics = new ArrayList<>();
            isExistsLyric = true;
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),getCharset(file)));

                String line = "";
                while ((line = reader.readLine())!= null){
                    line = parsedLyric(line);//
                }

                reader.close();


            } catch (Exception e) {
                e.printStackTrace();
            }


            //2.排序
            Collections.sort(lyrics, new Comparator<Lyric>() {
                @Override
                public int compare(Lyric lhs, Lyric rhs) {
                    if(lhs.getTimePoint() < rhs.getTimePoint()){
                        return  -1;
                    }else if(lhs.getTimePoint() > rhs.getTimePoint()){
                        return  1;
                    }else{
                        return 0;
                    }

                }
            });

            //3.计算每句高亮显示的时间
            for(int i=0;i<lyrics.size();i++){
                Lyric oneLyric = lyrics.get(i);
                if(i+1 < lyrics.size()){
                    Lyric twoLyric = lyrics.get(i+1);
                    oneLyric.setSleepTime(twoLyric.getTimePoint()-oneLyric.getTimePoint());
                }
            }
        }

    }


    /**
     * 判断文件编码
     * @param file 文件
     * @return 编码：GBK,UTF-8,UTF-16LE
     */
    public String getCharset(File file) {
        String charset = "GBK";
        byte[] first3Bytes = new byte[3];
        try {
            boolean checked = false;
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream(file));
            bis.mark(0);
            int read = bis.read(first3Bytes, 0, 3);
            if (read == -1)
                return charset;
            if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
                charset = "UTF-16LE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xFE
                    && first3Bytes[1] == (byte) 0xFF) {
                charset = "UTF-16BE";
                checked = true;
            } else if (first3Bytes[0] == (byte) 0xEF
                    && first3Bytes[1] == (byte) 0xBB
                    && first3Bytes[2] == (byte) 0xBF) {
                charset = "UTF-8";
                checked = true;
            }
            bis.reset();
            if (!checked) {
                int loc = 0;
                while ((read = bis.read()) != -1) {
                    loc++;
                    if (read >= 0xF0)
                        break;
                    if (0x80 <= read && read <= 0xBF)
                        break;
                    if (0xC0 <= read && read <= 0xDF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF)
                            continue;
                        else
                            break;
                    } else if (0xE0 <= read && read <= 0xEF) {
                        read = bis.read();
                        if (0x80 <= read && read <= 0xBF) {
                            read = bis.read();
                            if (0x80 <= read && read <= 0xBF) {
                                charset = "UTF-8";
                                break;
                            } else
                                break;
                        } else
                            break;
                    }
                }
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return charset;
    }

    /**
     * 解析一句歌词
     * @param line [02:04.12][03:37.32][00:59.73]我在这里欢笑
     * @return
     */
    public String parsedLyric(String line) {
//    	lyrics = new ArrayList<>();
        ////indexOf第一次出现[的位置
        int pos1 = line.indexOf("[");//0,如果没有返回-1

        int pos2 = line.indexOf("]");//9,如果没有返回-1

        if(pos1 ==0 && pos2 != -1){//肯定是由一句歌词

            //装时间
            long[] times = new long[getCountTag(line)];

            String strTime =line.substring(pos1+1,pos2) ;//02:04.12
            times[0] = strTime2LongTime(strTime);

            String content = line;
            int i = 1;
            while (pos1 ==0 && pos2 != -1){
                content = content.substring(pos2 + 1); //[03:37.32][00:59.73]我在这里欢笑--->[00:59.73]我在这里欢笑-->我在这里欢笑
                pos1 = content.indexOf("[");//0/-1
                pos2 = content.indexOf("]");//9//-1

                if(pos2 != -1 ){
                    strTime = content.substring(pos1 + 1, pos2);//03:37.32-->00:59.73
                    times[i] = strTime2LongTime(strTime);

                    if(times[i] == -1){
                        return  "";
                    }

                    i++;
                }

            }

            Lyric lyric = new Lyric();
            //把时间数组和文本关联起来，并且加入到集合中
            for(int j = 0;j < times.length;j++){

                if(times[j] !=0){//有时间戳

                    lyric.setContent(content);
                    lyric.setTimePoint(times[j]);
                    //添加到集合中
                    lyrics.add(lyric);
                    lyric = new Lyric();

                }


            }

            return  content;//我在这里欢笑


        }


        return "";
    }

    /**
     * 把String类型是时间转换成long类型
     * @param strTime 02:04.12
     * @return
     */
    private long strTime2LongTime(String strTime) {
        long result = -1;
        try{

            //1.把02:04.12按照:切割成02和04.12
            String[] s1 = strTime.split(":");
            //2.把04.12按照.切割成04和12
            String[] s2 = s1[1].split("\\.");

            //1.分
            long min = Long.parseLong(s1[0]);

            //2.秒
            long second = Long.parseLong(s2[0]);

            //3.毫秒
            long mil = Long.parseLong(s2[1]);

            result =  min * 60 * 1000 + second * 1000 + mil*10;
        }catch (Exception e){
            e.printStackTrace();
            result = -1;
        }

        return result;
    }
    /**
     * 把long类型是时间转换成String类型
     * @param time 02:04.12
     * @return
     */
    private String LongTime2StrTime(long time) {
    	int[] agrs = new int[3];
    	
    	agrs[0] = (int) (time/60000);
    	int min = (int) ((time%60000)/1000);
    	agrs[1]=min;
    	int sec = (int) (time%60000%1000/10);
    	agrs[2] = sec;
    	
    	StringBuffer data= new StringBuffer();
    	data.append("[");
    	if(agrs[0]>9){
    		data.append(agrs[0]+":");
    	}else{
    		data.append("0"+agrs[0]+":");
    	}
    	if(agrs[1]>9){
    		data.append(agrs[1]+".");
    	}else{
    		data.append("0"+agrs[1]+".");
    	}
    	if(agrs[2]>9){
    		data.append(agrs[2]);
    	}else{
    		data.append(agrs[2]);
    	}
    	data.append("]");
    	return data.toString();
    }
    
    /**
     * 判断有多少句歌词
     * @param line [02:04.12][03:37.32][00:59.73]我在这里欢笑
     * @return
     */
    public int getCountTag(String line) {
        int result = -1;
        String [] left = line.split("\\[");
        String [] right = line.split("\\]");
        for(int i=0;i<right.length;i++)
        	System.out.println(left[i]);
        System.out.println();
        for(int i=0;i<right.length;i++)
        	System.out.println(right[i]);
        if(left.length==0 && right.length ==0){
            result = 1;
        }else if(left.length > right.length){
            result = left.length;
        }else{
            result = right.length;
        }
        return result;
    }
    public File showLysic(){
    	File file = new File("D://lysic.txt");
    	BufferedWriter out=null;
    	try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
			for(int i=0;i<lyrics.size();i++){
				String content = lyrics.get(i).getContent();
				long time = lyrics.get(i).getTimePoint();
				System.out.println(time);
				String data = LongTime2StrTime(time);
				if(content!=null){
					try {
						out.newLine();
						out.write(data+"   ");
						out.write(content);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {     
            try {     
                if(out != null){  
                    out.close();     
                }  
            } catch (IOException e) { 
                e.printStackTrace();     
            }     
        }     
    	return file;
    }
}
