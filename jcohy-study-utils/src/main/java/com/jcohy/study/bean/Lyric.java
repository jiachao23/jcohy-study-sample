package com.jcohy.study.bean;

/**
 * ���ã������
 * ����
 * [01:21.35]��������Ѱ��
 */
public class Lyric {
    /**
     * �������
     */
    private String content;

    /**
     * ʱ���
     */
    private long timePoint;

    /**
     * ����ʱ����߸�����ʾ��ʱ��
     */
    private long sleepTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(long timePoint) {
        this.timePoint = timePoint;
    }

    public long getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public String toString() {
        return "Lyric{" +
                "content='" + content + '\'' +
                ", timePoint=" + timePoint +
                ", sleepTime=" + sleepTime +
                '}';
    }
}
