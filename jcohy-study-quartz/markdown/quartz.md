## Quartz

### Quartz简介

OpenSymphony提供的强大的开源的任务调度框架

### 特点

- 强大的调度功能

- 灵活的应用方式

- 分布式和集群能力

### 设计模式

- Builder模式
- Factory模式
- 组件模式
- 链式写法

### 三个核心概念

- 调度器
- 任务
- 触发器

### 重要组成部分

- Job



- JobDetail

  - JobDetail为Job实例提供了许多设置属性，以及JobDataMap成员变量属性，它用来存储特定Job实例的状态信息，调度器需要借助JobDetail对象来添加Job实例。

  - 重要属性

    |  属性名    | 描述     |
    | ---- | ---- |
    | name     |   名称   |
    |   group   |  任务所在的组，默认default    |
    |  jobClass    | 任务的实现类     |
  |  JobDataMap    | 传递的参数     |

  

- JobBuilder

- JobStore

- Trigger（SimpleTrigger,CronTrigger）

  

- TriggerBuilder

- ThreadPool

- Scheduler（start,stop,）

- Calendar：一个Trigger可以和多个Calendar关联，以排除或包含某些时间点。

- JobListener

- TriggerListener

- SchedulerListener

  

### Job

Job接口非常容易实现，只有一个execute方法，类似TimerTask的run方法，在里面编写业务逻辑。

  ```java
  public interface Job {
      //当Scheduler调用一个Job，就是将JobExecutionContext传递给Job的execute()方法。Job能通过JobExecutionContext对象访问到Quartz运行时候的环境以及Job本身的明细数据。
      void execute(JobExecutionContext context)
          throws JobExecutionException;
  
  }
  ```
每次执行Job时，它在调用execute方法前会创建一个新的Job实例。当调用完成后，关联的Job对象实例会被释放，释放的实例会被垃圾回收机制回收。

JobDataMap

- 在进行任务调度时JobDataMap存储在JobExecutionContext中，非常方便获取


- JobDataMap可以用来装载任何可序列化的数据对象，当job实例对象被执行时这些参数对象会传递给它


- JobDataMap实现了JDk的Map接口，并且添加了一些非常方便的方法用来存取基本数据类型。


- 获取JobDataMap的两种方式

  1、直接从Map中获取

  2、Job实现类添加setter方法对应JobDataMap的键值。

### Trigger

Quartz中的触发器，用来告诉调度程序任务作业什么时候触发。即Trigger对象是用来出发执行Job的。

- 触发器的通用属性

  1、JobKey：表示Job实例的标识，触发器被触发时，该指定的Job实例会被执行

  2、StartTime：表示触发器的时间表首次被触发的时间，它的值类型时java.util.date

  3、EndTime： 执行触发器的不再被触发的时间，它的值类型时java.util.date

- SimpleTrigger

  在一个指定时间间隔内执行一次任务或在指定时间间隔内执行多次作业任务。

- CronTrigger

  基于日历的作业调度器

  Cron表达式：

  用于配置CronTrigger实例，由七个子表达式组成的字符串，描述了时间表的信息。

  格式：

  ```
  [秒][分][时][日][月][周][年]
  ```

  #### Scheduler

  