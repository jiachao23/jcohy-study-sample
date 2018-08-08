
#  设计模式
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## 工厂模式
> * [概述](#gaishu)
> * [工厂模式的分类](#method)
>   *  [简单工厂模式](#simplefactory)
>   *  [工厂方法模式](#factory)
>   *  [抽象工厂](#abstractfactory)
> * [Q&A](#qa)
> * [Java语言中工厂模式](#java)
> * [扩展](#kuozhan)

<p id ="gaishu" />

## 概述
#### 工厂模式（Factory Pattern）是 Java 中最常用的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。</br>
#### 在工厂模式中，我们在创建对象时不会对客户端暴露创建逻辑，并且是通过使用一个共同的接口来指向新创建的对象。</br>
#### 定义：定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。[DP]。</br>
工厂模式的好处：
> *  可维护性。只需要改要改之处。
> *  可复用性。
> *  可扩展性。
> *  灵活性好，

工厂模式的适应性：
> *  当一个类不知道它所必须创建的类的时候
> *  当一个类希望由它的子类来指定它所创建的对象的时候。
> *  当类将创建对象的职责委托给多个帮助子类中的某一个。并且你希望将那一个帮助子类是代理者这一
信息局部化的时候。

工厂模式的参与者：
> *  Product:定义工厂方法所创建的对象的接口。
> *  ConcreteProduct：实现Product接口。
> *  Creator：声明工厂方法，该方法返回一个Product类型的对象。也可以定义一个工厂方法的缺省实现，它返回一个缺省的ConcretrProduct对象。
> *  CreatorCreator：重定义一个工厂方法，以返回一个ConcreteProduct实例。(在简单工厂模式中没有这一角色)

<p id ="method" />

## 工厂模式的分类
<p id ="simplefactory" />

>  ### 简单工厂模式 </br>
>  #### 简单工厂模式，又称为静态工厂模式。是不同于工厂方法模式的一种特殊实现。
>  在有的地方，简单工厂模式往往作为普通工厂模式的一个特例。</br>
>  就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建。首先看下关系图：</br>
>  模式的核心就是工厂类，这个类含有必要的判断逻辑。
>  ![factory](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-studydesign-pattern/src/main/resources/static/images/factory1.png)

        1.首先，创建二者共同的接口
            public interface Sender {
                public void Send();
            }
            
        2. 创建实现类
            public class MailSender  implements Sender {
                @Override
                public void Send() {
                    System.out.println("this is mailsender!");
                }
            }
         
            public class SmsSender  implements Sender {
                @Override
                public void Send() {
                    System.out.println("this is sms sender!");
                }
            }
            
        3.建工厂类
           public class SendFactory {  
               public Sender produce(String type) {  
                   if ("mail".equals(type)) {  
                       return new MailSender();  
                   } else if ("sms".equals(type)) {  
                       return new SmsSender();  
                   } else {  
                       System.out.println("请输入正确的类型!");  
                       return null;  
                   }  
               }  
           } 
           
           4.测试
           public class FactoryTest {  
               public static void main(String[] args) {  
                   SendFactory factory = new SendFactory();  
                   Sender sender = factory.produce("sms");  
                   sender.Send();  
               }  
           } 
           
           5.结果
           
                   输出：this is sms sender!
                   
&nbsp;&nbsp;&nbsp;&nbsp;在上面的方法中，如果传入的字符串有误，则不能正确的创建对象。简单工厂模式的最大优点就是在于工厂类中包含了必要的逻辑判断。
根据客户端的选择条件动态的实例化相关的类，对客户端来说，去除了与具体产品的依赖。所以说，简单工厂模式适用于业务简单的情况下或者具体产品很少增加的情况。</br>
&nbsp;&nbsp;&nbsp;&nbsp;但是，它也有一个巨大的缺陷，还记得我们说过的设计模式的六大原则吗？如果我们要加一个新的功能，
就要在工厂类的分支条件中加一次判断，这违背了“开闭原则”。那么该怎么做？</br>

<p id ="factory" />

>  ### 工厂方法模式(多态性工厂模式)
>   *  接着上面的讲。工厂方法模式创建一个工厂接口和创建多个工厂实现类，这样一旦需要加入新的功能，直接增加新的
工厂类就可以了。下面看看是怎么实现的。先看一下这个关系图
>   *  简单工厂模式转换成工厂模式。首先我们要知道在简单工厂中，工厂类和分支是耦合的，所以我们可以对它下手。
根据依赖倒转原则，我们把工厂类抽象出一个接口，这个接口只有一个方法，就是创建抽象产品的工厂方法。然后，所有要
生产具体类的工厂去实现这个接口。这样，我们要新加功能的时候，只需要增加相应的功能类和一个工厂类就可以了。

>   *  工厂模式降低了客户端程序与产品对象的耦合度，使用多态。保持了简单工厂的有点，克服了他的缺点。但是由于每增加一个
一个产品，就需要加一个产品工厂的类，增加了额外的开销。

>  ![factory](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-studydesign-pattern/src/main/resources/static/images/factory2.png)

#### 实现
        上面例子的一二步不变，创建共同的接口和实现类。
        3.新建一个接口，提供创建具体工厂类
            public interface Provider {  
                public Sender produce();  
            }  
        4.创建两个工厂类，实现这个接口
            public class SendMailFactory implements Provider {  
                  
                @Override  
                public Sender produce(){  
                    return new MailSender();  
                }  
            } 
        
            public class SendSmsFactory implements Provider{  
              
                @Override  
                public Sender produce() {  
                    return new SmsSender();  
                }  
            }  
            public class Test {  
                public static void main(String[] args) {  
                    Provider provider = new SendMailFactory();  
                    Sender sender = provider.produce();  
                    sender.Send();  
                }  
            }

其实仔细观察就会发现，工厂方法模式实现时，客户端需要决定实现那一个工厂来实现运算类，选择判断的问题还是存在的，
也就是说，工厂方法把简单工厂方法的内部逻辑判断转移到了客户端进行，你想要加功能，本来是修改工厂类的，而现在是修改客户端

<p id ="abstractfactory" />

>  ### 抽象工厂(工具箱模式)
    ![factory](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-studydesign-pattern/src/main/resources/static/images/abstractfactory.png)
>    *  抽象工厂模式（Abstract Factory Pattern）;提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
>    * 优点：当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。
>    * 缺点：产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。

#### 实现
        他是具有多种产品族的。我们就以我们将创建 Shape 和 Color 接口和实现这些接口的实体类。
            1.为形状创建一个接口。
                public interface Shape {
                   void draw();
                }
            2。创建实现接口的实体类。
                public class Rectangle implements Shape {
                   @Override
                   public void draw() {
                      System.out.println("Inside Rectangle::draw() method.");
                   }
                }
                
                public class Square implements Shape {
                   @Override
                   public void draw() {
                      System.out.println("Inside Square::draw() method.");
                   }
                }
                
                public class Circle implements Shape {
                   @Override
                   public void draw() {
                      System.out.println("Inside Circle::draw() method.");
                   }
                }
            3.为颜色创建一个接口。
                public interface Color {
                   void fill();
                }
             
            4.创建实现接口的实体类。
                public class Red implements Color {
                   @Override
                   public void fill() {
                      System.out.println("Inside Red::fill() method.");
                   }
                }
                
                public class Green implements Color {
                   @Override
                   public void fill() {
                      System.out.println("Inside Green::fill() method.");
                   }
                }
                
                public class Blue implements Color {
                   @Override
                   public void fill() {
                      System.out.println("Inside Blue::fill() method.");
                   }
                }
                
            5.为 Color 和 Shape 对象创建抽象类来获取工厂。
            
                public abstract class AbstractFactory {
                   abstract Color getColor(String color);
                   abstract Shape getShape(String shape) ;
                }
                
            6.创建扩展了 AbstractFactory 的工厂类，基于给定的信息生成实体类的对象。
                public class ShapeFactory extends AbstractFactory {
                   @Override
                   public Shape getShape(String shapeType){
                      if(shapeType == null){
                         return null;
                      }		
                      if(shapeType.equalsIgnoreCase("CIRCLE")){
                         return new Circle();
                      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
                         return new Rectangle();
                      } else if(shapeType.equalsIgnoreCase("SQUARE")){
                         return new Square();
                      }
                      return null;
                   }
                   @Override
                   Color getColor(String color) {
                      return null;
                   }
                }
                
                public class ColorFactory extends AbstractFactory {
                	
                   @Override
                   public Shape getShape(String shapeType){
                      return null;
                   }
                   
                   @Override
                   Color getColor(String color) {
                      if(color == null){
                         return null;
                      }		
                      if(color.equalsIgnoreCase("RED")){
                         return new Red();
                      } else if(color.equalsIgnoreCase("GREEN")){
                         return new Green();
                      } else if(color.equalsIgnoreCase("BLUE")){
                         return new Blue();
                      }
                      return null;
                   }
                }
               
            7.创建一个工厂创造器/生成器类，通过传递形状或颜色信息来获取工厂。
            
                public class FactoryProducer {
                   public static AbstractFactory getFactory(String choice){
                      if(choice.equalsIgnoreCase("SHAPE")){
                         return new ShapeFactory();
                      } else if(choice.equalsIgnoreCase("COLOR")){
                         return new ColorFactory();
                      }
                      return null;
                   }
                }
                
            8.使用 FactoryProducer 来获取 AbstractFactory，通过传递类型信息来获取实体类的对象。
                
                ublic class AbstractFactoryPatternDemo {
                   public static void main(String[] args) {
                
                      //获取形状工厂
                      AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
                
                      //获取形状为 Circle 的对象
                      Shape shape1 = shapeFactory.getShape("CIRCLE");
                
                      //调用 Circle 的 draw 方法
                      shape1.draw();
                
                      //获取形状为 Rectangle 的对象
                      Shape shape2 = shapeFactory.getShape("RECTANGLE");
                
                      //调用 Rectangle 的 draw 方法
                      shape2.draw();
                      
                      //获取形状为 Square 的对象
                      Shape shape3 = shapeFactory.getShape("SQUARE");
                
                      //调用 Square 的 draw 方法
                      shape3.draw();
                
                      //获取颜色工厂
                      AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
                
                      //获取颜色为 Red 的对象
                      Color color1 = colorFactory.getColor("RED");
                
                      //调用 Red 的 fill 方法
                      color1.fill();
                
                      //获取颜色为 Green 的对象
                      Color color2 = colorFactory.getColor("Green");
                
                      //调用 Green 的 fill 方法
                      color2.fill();
                
                      //获取颜色为 Blue 的对象
                      Color color3 = colorFactory.getColor("BLUE");
                
                      //调用 Blue 的 fill 方法
                      color3.fill();
                   }
                }
                
            9.结果
                Inside Circle::draw() method.
                Inside Rectangle::draw() method.
                Inside Square::draw() method.
                Inside Red::fill() method.
                Inside Green::fill() method.
                Inside Blue::fill() method.
                
### 总结     
#### 工厂方法模式和抽象工厂模式不好分清楚，他们的区别如下：
> * 工厂方法模式：
>   *  一个抽象产品类，可以派生出多个具体产品类。
>   *  一个抽象工厂类，可以派生出多个具体工厂类。
>   *  每个具体工厂类只能创建一个具体产品类的实例。
> * 抽象工厂模式：
>   *  多个抽象产品类，每个抽象产品类可以派生出多个具体产品类。
>   *  一个抽象工厂类，可以派生出多个具体工厂类。
>   *  每个具体工厂类可以创建多个具体产品类的实例，也就是创建的是一个产品线下的多个产品。
> * 区别：
>   *  工厂方法模式只有一个抽象产品类，而抽象工厂模式有多个。
>   *  工厂方法模式的具体工厂类只能创建一个具体产品类的实例，而抽象工厂模式可以创建多个。
>   *  工厂方法创建 "一种" 产品，他的着重点在于"怎么创建"，也就是说如果你开发，你的大量代码很可能围绕着这种产品的构造，初始化这些细节上面。也因为如此，类似的产品之间有很多可以复用的特征，
所以会和模版方法相随。
>   *  抽象工厂需要创建一些列产品，着重点在于"创建哪些"产品上，也就是说，如果你开发，你的主要任务是划分不同差异的产品线，并且尽量保持每条产品线接口一致，从而可以从同一个抽象工厂继承。
>   *  对于 java 来说，你能见到的大部分抽象工厂模式都是这样的：---它的里面是一堆工厂方法，每个工厂方法返回某种类型的对象。
比如说工厂可以生产鼠标和键盘。那么抽象工厂的实现类（它的某个具体子类）的对象都可以生产鼠标和键盘，但可能工厂 A 生产的是罗技的键盘和鼠标，工厂 B 是微软的。
这样 A 和 B 就是工厂，对应于抽象工厂；每个工厂生产的鼠标和键盘就是产品，对应于工厂方法；用了工厂方法模式，你替换生成键盘的工厂方法，就可以把键盘从罗技换到微软。但是用了抽象工厂模式，你只要换家工厂，就可以同时替换鼠标和键盘一套。如果你要的产品有几十个，当然用抽象工厂模
式一次替换全部最方便（这个工厂会替你用相应的工厂方法）所以说抽象工厂就像工厂，而工厂方法则像是工厂的一种产品生产线。

<p id ="qa" />

## Q&A
> Q:有很多Java语言中的API提供一些返还新的Java对象的方法，能否举出两个这样的例子，请问他们是工厂方法模式吗？</br></br>
> A:toString()方法会返回一个String类型的对象，尔clone()方法会返回与原对象类型相同的对象。但他们
> 不是工厂方法模式，因为他们不能返还一个抽象类型。客户端事先都知道将要得到什么对象类型。</br></br>
> Q:工厂方法可不可以返还在另一个对象里实例化的一个对象</br></br>
> A:不可以，工厂方法是创建型模式。其用意就是对对象创建过程的封装。虽然不一定每一次都返回一个新的对象
，但是工厂方法所返回的都应该是在工厂角色中被实例化的对象</br>

<p id ="java" />

## Java语言中的应用
> * 简单工厂模式
>   *  java.text.DateFormat#getDateInstance()
> * 工厂方法模式
>   *  java.lang.Class#newInstance()
>   *  java.lang.Integer#valueOf(String) (Boolean, Byte, Character,Short, Long,Float 和 Double 与之类似)
>   *  java.lang.Class#forName()
>   *  java.lang.reflect.Array#newInstance()
>   *  java.lang.reflect.Constructor#newInstance()     
> * 抽象工厂模式
>   *  java.util.Calendar#getInstance()
>   *  java.util.Arrays#asList()
>   *  java.util.ResourceBundle#getBundle()
>   *  java.net.URL#openConnection()
>   *  java.sql.DriverManager#getConnection()
>   *  java.sql.Connection#createStatement()
>   *  java.sql.Statement#executeQuery()
>   *  java.text.NumberFormat#getInstance()
>   *  java.lang.management.ManagementFactory (所有 getXXX()方法)
>   *  java.nio.charset.Charset#forName()
>   *  javax.xml.parsers.DocumentBuilderFactory#newInstance()
>   *  javax.xml.transform.TransformerFactory#newInstance()
>   *  javax.xml.xpath.XPathFactory#newInstance()

<p id ="kuozhan" />

## 扩展
> * 利用反射+工厂模式，可以解决避免分支判断的问题。
> * 工厂模式与单例模式，MVC模式，亨元模式，备忘录模式等的关系与其发挥的作用。
****