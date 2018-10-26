#### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	
> #### PS:待开发中。。。。

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

> #### PS:我的学习笔记,点击可以跳转到相应分类

## [Volatile]
 #### Ps:Volatile关键字 内存可见性。
 
  * 内存可见性（Memory Visibility）是指当某个线程正在使用对象状态而另一个线程在同时修改该状态，需要确保当一个线程修改了对象状态后，其他线程能够看到发生的状态变化。
  * 可见性错误是指当读操作与写操作在不同的线程中执行时，我们无法确保执行读操作的线程能适时地看到其他线程写入的值，有时甚至是根本不可能的事情。
  * 我们可以通过同步来保证对象被安全地发布。除此之外我们也可以使用一种更加轻量级的volatile 变量。
  * Java提供了一种稍弱的同步机制，即volatile 变量，用来确保将变量的更新操作通知到其他线程。可以将volatile 看做一个轻量级的锁，但是又与锁有些不同：
> 对于多线程，不是一种互斥关系
> 不能保证变量状态的“原子性操作”
  
    public class VolatileTest {
    
        public static void main(String[] args) {
            ThreadDemo td = new ThreadDemo();
            new Thread(td).start();
            while (true){
                if(td.isFlag()){
                    System.out.println("-----------------");
                    break;
                }
            }
        }
    }
    class ThreadDemo implements Runnable{
                //private boolean flag = false;
                //result 
                //flag = true
                private volatile boolean flag = false;
                //result
                //-----------------
                //flag = true
                
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
        
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    flag = true;
                    System.out.println("flag = "+flag);
                }
        
                public boolean isFlag() {
                    return flag;
                }
        
                public void setFlag(boolean flag) {
                    this.flag = flag;
                }
            }