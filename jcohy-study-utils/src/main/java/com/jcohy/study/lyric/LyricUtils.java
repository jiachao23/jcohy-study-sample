package com.jcohy.study.lyric;



import com.jcohy.study.bean.Lyric;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * ���ã�������ʹ�����s
 */
public class LyricUtils {

    /**
     * �õ������õĸ���б�
     * @return
     */
    public ArrayList<Lyric> getLyrics() {
        return lyrics;
    }

    private ArrayList<Lyric> lyrics;

    /**
     * �Ƿ���ڸ��
     * @return
     */
    public boolean isExistsLyric() {
        return isExistsLyric;
    }

    /**
     * �Ƿ���ڸ��

     */
    private boolean isExistsLyric  = false;

    /**
     * ��ȡ����ļ�
     * @param file /mnt/scard/audio/beijingbeijing.txt
     */
    public void readLyricFile(File file){
        if(file == null || !file.exists()){
            //����ļ�������
            lyrics = null;
            isExistsLyric = false;
        }else{
            //����ļ�����
            //1.������� һ�еĶ�ȡ-����
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


            //2.����
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

            //3.����ÿ�������ʾ��ʱ��
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
     * �ж��ļ�����
     * @param file �ļ�
     * @return ���룺GBK,UTF-8,UTF-16LE
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
     * ����һ����
     * @param line [02:04.12][03:37.32][00:59.73]�������ﻶЦ
     * @return
     */
    public String parsedLyric(String line) {
//    	lyrics = new ArrayList<>();
        ////indexOf��һ�γ���[��λ��
        int pos1 = line.indexOf("[");//0,���û�з���-1

        int pos2 = line.indexOf("]");//9,���û�з���-1

        if(pos1 ==0 && pos2 != -1){//�϶�����һ����

            //װʱ��
            long[] times = new long[getCountTag(line)];

            String strTime =line.substring(pos1+1,pos2) ;//02:04.12
            times[0] = strTime2LongTime(strTime);

            String content = line;
            int i = 1;
            while (pos1 ==0 && pos2 != -1){
                content = content.substring(pos2 + 1); //[03:37.32][00:59.73]�������ﻶЦ--->[00:59.73]�������ﻶЦ-->�������ﻶЦ
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
            //��ʱ��������ı��������������Ҽ��뵽������
            for(int j = 0;j < times.length;j++){

                if(times[j] !=0){//��ʱ���

                    lyric.setContent(content);
                    lyric.setTimePoint(times[j]);
                    //��ӵ�������
                    lyrics.add(lyric);
                    lyric = new Lyric();

                }


            }

            return  content;//�������ﻶЦ


        }


        return "";
    }

    /**
     * ��String������ʱ��ת����long����
     * @param strTime 02:04.12
     * @return
     */
    private long strTime2LongTime(String strTime) {
        long result = -1;
        try{

            //1.��02:04.12����:�и��02��04.12
            String[] s1 = strTime.split(":");
            //2.��04.12����.�и��04��12
            String[] s2 = s1[1].split("\\.");

            //1.��
            long min = Long.parseLong(s1[0]);

            //2.��
            long second = Long.parseLong(s2[0]);

            //3.����
            long mil = Long.parseLong(s2[1]);

            result =  min * 60 * 1000 + second * 1000 + mil*10;
        }catch (Exception e){
            e.printStackTrace();
            result = -1;
        }

        return result;
    }
    /**
     * ��long������ʱ��ת����String����
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
     * �ж��ж��پ���
     * @param line [02:04.12][03:37.32][00:59.73]�������ﻶЦ
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
