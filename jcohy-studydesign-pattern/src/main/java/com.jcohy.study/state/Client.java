package com.jcohy.study.state;

/**
 * 金库安保系统，
 * 有1个金库，金库跟保安中心联机。
 * 金库有警铃和一般通话用的电话。
 * 金库有时钟，监视目前的时间。
 * 白天是 9:00-16:59,晚间是17:00-23:59以及0:00-8:59。
 * 只有白天才能使用金库。
 * 在白天使用金库时，保安中心会保存使用记录。
 * 若晚间使用金库，保安中心会接到发生异常现象的通知。
 * 警铃24小时都可以使用，一旦使用警铃，保安中心会接收到警铃通知。
 * 一般通话用的电话是24小时均可使用（但晚间只有录音机服务）。
 * 在白天使用电话机，会调用保安中心。
 * 在晚间使用电话机，会调用保安中心的录音机。
 * @author jiachao
 *
 */
public class Client {
    public static void main(String[] args) {
        SafeFrame frame = new SafeFrame("state Sample");
        while(true) {
            for(int hour = 0;hour<24;hour++) {
                frame.setClock(hour);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
