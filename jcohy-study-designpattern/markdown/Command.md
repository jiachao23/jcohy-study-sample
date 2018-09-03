#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 命令模式模式
> * [概述](#gaishu)
> * [命令模式的角色](#role)
> * [命令模式的应用场景](#sign)
> * [命令模式的实现](#shixian)
> * [Q&A](#qa)
> * [Java语言中命令模式](#java)
> * [扩展](#kuozhan)

<p id="gaishu">

##  概述


>  命令模式：将一个请求封装成一个对象，从而使你可用不同的请求对客户进行参数化，对请求排队或者记录请求日志，以及支持可撤销的操作。

<p id="role">

## 命令模式的角色
>  ![结构图](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/src/main/resources/static/images/command.png)
>  *  Command</br>
>  用来声明 执行操作的接口

>  *  ConcreteCommand</br>
>  将一个接受者对象绑定于一个动作，调用接受者相应的操作，以实现Excute。

>  *  Receiver</br>
>  知道如何实施与执行一个请求相关的操作，任何类都可能作为一个接受者。

>  *  Invoker</br>
>  要求该命令执行这个请求

>  *  Client

<p id="sign">

##  命令模式的应用场景



<p id="shixian">

## 命令模式的实现

                         简单的绘图软件，移动鼠标时自动绘制一个红点，按下clear 清除所有
                         1.表示命令的接口。   
                            public interface Command {
                                public abstract void execute();
                            }
                         2.   
                            public class MacroCommand implements Command{
                                private Stack<Command> commands = new Stack<>();
                                
                                @Override
                                public void execute() {
                                    Iterator<Command> it = commands.iterator();
                                    while(it.hasNext()) {
                                        ((Command)it.next()).execute();
                                    }
                                }
                                public void append(Command cmd) {
                                    if(cmd!=this) {
                                        commands.push(cmd);
                                    }
                                } 
                                //删除最后一个命令
                                public void undo() {
                                    if(!commands.empty())
                                        commands.pop();
                                }
                                
                                public void clear() {
                                    commands.clear();
                                }
                            }
                    
                         3. 
                         
                            public class DrawCommand implements Command{
                                private Drawable drawable;
                                
                                private Point point;
                                
                                public DrawCommand(Drawable drawable,Point point) {
                                    this.drawable = drawable;
                                    this.point = point;
                                }
                            
                                @Override
                                public void execute() {
                                    drawable.draw(point.x, point.y);
                                }
                                
                            }
                            
                         4.
                            public interface Drawable {
                                public abstract void draw(int x,int y);
                            }
                            
                            
                         5.
                         public class DrawCanvas extends Canvas implements Drawable {
                            private static final long serialVersionUID = 1L;
                            private Color color = Color.red;//颜色
                            private int radius = 6;//点的半径
                            private MacroCommand history ;//记录
                            
                            public DrawCanvas(int width,int height,MacroCommand history) {
                                setSize(width,height);
                                setBackground(Color.WHITE);
                                this.history = history;
                            }
                            //再度绘制整个记录
                            public void paint(Graphics g) {
                                history.execute();
                            }
                            //绘制
                            @Override
                            public void draw(int x, int y) {
                                Graphics g = getGraphics();
                                g.setColor(color);
                                g.fillOval(x-radius, y-radius, radius*2, radius*2);
                            }
                         
                         }
                         
                         6.
                         public class Client extends JFrame implements ActionListener,MouseMotionListener,WindowListener{
                            
                            
                            private MacroCommand history = new MacroCommand();//绘制记录
                            
                            private DrawCanvas drawCanvas = new DrawCanvas(400, 400, history);//绘制区域
                            
                            private JButton cleanButton = new JButton("clear");//删除键
                            
                            public Client(String title) {
                                super(title);
                                this.addWindowListener(this);
                                drawCanvas.addMouseMotionListener(this);
                                cleanButton.addActionListener(this);
                                
                                Box buttonBox = new Box(BoxLayout.X_AXIS);
                                buttonBox.add(cleanButton);
                                
                                Box mainBox = new Box(BoxLayout.Y_AXIS);
                                mainBox.add(buttonBox);
                                mainBox.add(drawCanvas);
                                getContentPane().add(mainBox);
                                
                                pack();
                                
                                setVisible(true);
                            }
                            
                            @Override
                            public void windowActivated(WindowEvent e) {
                                // TODO Auto-generated method stub
                                
                            }
                         
                            @Override
                            public void windowClosed(WindowEvent e) {
                                // TODO Auto-generated method stub
                                
                            }
                         
                            @Override
                            public void windowClosing(WindowEvent e) {
                                System.exit(0);
                            }
                         
                            @Override
                            public void windowDeactivated(WindowEvent e) {
                                // TODO Auto-generated method stub
                                
                            }
                         
                            @Override
                            public void windowDeiconified(WindowEvent e) {
                                // TODO Auto-generated method stub
                                
                            }
                         
                            @Override
                            public void windowIconified(WindowEvent e) {
                                // TODO Auto-generated method stub
                                
                            }
                         
                            @Override
                            public void windowOpened(WindowEvent e) {
                                // TODO Auto-generated method stub
                                
                            }
                         
                            @Override
                            public void mouseDragged(MouseEvent e) {
                                Command cmd = new DrawCommand(drawCanvas,e.getPoint());
                                
                                history.append(cmd);
                                
                                cmd.execute();
                                
                            }
                         
                            @Override
                            public void mouseMoved(MouseEvent e) {
                                
                            }
                         
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(e.getSource() == cleanButton) {
                                    history.clear();
                                    drawCanvas.repaint();
                                }
                            }
                            public static void main(String[] args) {
                                new Client("Command Pattern Sample");
                            }
                         }
                         
                         7.result
                         ![result](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-designpattern/src/main/resources/static/images/result.png)
                  
<p id="qa">

##  Q&A

       
<p id="java">
        
##  Java语言中命令模式

>  *  java.lang.Runnable
>  *  javax.swing.Action

<p id="kuozhan">

##  扩展
    
    
    