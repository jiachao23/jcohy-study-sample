#  Sql
> #### PS:待开发中。。。。
> #### 作者网页：[www.jcohy.com](http://www.jcohy.com)  	

>  我的学习笔记，记录学习过程中的笔记以及遇到的问题,以及我的一些经验总结。如果出现链接失效,或者想知道更多的内容等情况可以提交 Issues 提醒我修改相关内容。

## Sql
> * [Statement](#sql-1)
> * [游标 ](#sql-2)
> * [列出 5 个应该遵循的 JDBC 最佳实践](#sql-3)
> * [数据库索引的实现](#sql-4)
> * [demo](#sql-5)

<p id="sql-1">

#### Statement

1.1 基本内容

- Statement是最基本的用法, 不传参, 采用字符串拼接，存在注入漏洞
- PreparedStatement传入参数化的sql语句, 同时检查合法性, 效率高可以重用, 防止sql注入
- CallableStatement接口扩展PreparedStatement，用来调用存储过程
- BatchedStatement用于批量操作数据库，BatchedStatement不是标准的Statement类

```java
public interface CallableStatement extends PreparedStatement 
public interface PreparedStatement extends Statement 
```

1.2 Statement与PrepareStatement的区别

- 创建时的区别
```
Statement statement = conn.createStatement();
PreparedStatement preStatement = conn.prepareStatement(sql);
```
- 执行的时候
```
ResultSet rSet = statement.executeQuery(sql);
ResultSet pSet = preStatement.executeQuery();
```
由上可以看出，PreparedStatement有预编译的过程，已经绑定sql，之后无论执行多少遍，都不会再去进行编译，而 statement 不同，如果执行多遍，则相应的就要编译多少遍sql，所以从这点看，preStatement 的效率会比 Statement要高一些

- 安全性

PreparedStatement是预编译的，所以可以有效的防止SQL注入等问题

- 代码的可读性和可维护性

PreparedStatement更胜一筹

<p id="sql-2">

#### 游标 

<p id="sql-3">

#### 列出 5 个应该遵循的 JDBC 最佳实践

有很多的最佳实践，你可以根据你的喜好来例举。下面是一些更通用的原则：

a）使用批量的操作来插入和更新数据

b）使用 PreparedStatement 来避免 SQL 异常，并提高性能

c）使用数据库连接池

d）通过列名来获取结果集，不要使用列的下标来获取

<p id="sql-4">

####  数据库索引的实现

数据库系统还维护着满足特定查找算法的数据结构，这些数据结构以某种方式引用（指向）数据，这样就可以在这些数据结构上实现高级查找算法。这种数据结构，就是索引。

B树：

一棵m阶B树(balanced tree of order m)是一棵平衡的m路搜索树。它或者是空树，或者是满足下列性质的树：

1、根结点至少有两个子女；
2、每个非根节点所包含的关键字个数 j 满足：┌m/2┐ - 1 <= j <= m - 1；
3、除根结点以外的所有结点（不包括叶子结点）的度数正好是关键字总数加1，故内部子树个数 k 满足：┌m/2┐ <= k <= m ；
4、所有的叶子结点都位于同一层。

由于B-Tree的特性，在B-Tree中按key检索数据的算法非常直观：首先从根节点进行二分查找，如果找到则返回对应节点的data，否则对相应区间的指针指向的节点递归进行查找，直到找到节点或找到null指针，前者查找成功，后者查找失败。

一个度为d的B-Tree，设其索引N个key，则其树高h的上限为logd((N+1)/2)，检索一个key，其查找节点个数的渐进复杂度为O(logdN)。从这点可以看出，B-Tree是一个非常有效率的索引数据结构。

B+树：

B-Tree有许多变种，其中最常见的是B+Tree，例如MySQL就普遍使用B+Tree实现其索引结构。

B+树是B树的变形，它把所有的data都放在叶子结点中，只将关键字和子女指针保存于内结点，内结点完全是索引的功能。

与B-Tree相比，B+Tree有以下不同点：

1、每个节点的指针上限为2d而不是2d+1。

2、内节点不存储data，只存储key；叶子节点存储data不存储指针。

一般在数据库系统或文件系统中使用的B+Tree结构都在经典B+Tree的基础上进行了优化，增加了顺序访问指针。

在B+Tree的每个叶子节点增加一个指向相邻叶子节点的指针

例如图4中如果要查询key为从18到49的所有数据记录，当找到18后，只需顺着节点和指针顺序遍历就可以一次性访问到所有数据节点，极大提到了区间查询效率。

为什么B树（B+树）？

一般来说，索引本身也很大，不可能全部存储在内存中，因此索引往往以索引文件的形式存储的磁盘上。这样的话，索引查找过程中就要产生磁盘I/O消耗，相对于内存存取，I/O存取的消耗要高几个数量级，所以评价一个数据结构作为索引的优劣最重要的指标就是在查找过程中磁盘I/O操作次数的渐进复杂度。换句话说，索引的结构组织要尽量减少查找过程中磁盘I/O的存取次数。

这涉及到磁盘存取原理、局部性原理和磁盘预读。

先从B-Tree分析，根据B-Tree的定义，**可知检索一次最多需要访问h个节点。数据库系统的设计者巧妙利用了磁盘预读原理，将一个节点的大小设为等于一个页，这样每个节点只需要一次I/O就可以完全载入。**为了达到这个目的，在实际实现B-Tree还需要使用如下技巧：

**每次新建节点时，直接申请一个页的空间，这样就保证一个节点物理上也存储在一个页里，加之计算机存储分配都是按页对齐的，就实现了一个node只需一次I/O。**

**B-Tree中一次检索最多需要h-1次I/O（根节点常驻内存），渐进复杂度为O(h)=O(logdN)。一般实际应用中，出度d是非常大的数字，通常超过100，因此h非常小（通常不超过3）。**

综上所述，用B-Tree作为索引结构效率是非常高的。

而红黑树这种结构，h明显要深的多。由于逻辑上很近的节点（父子）物理上可能很远，无法利用局部性，所以红黑树的I/O渐进复杂度也为O(h)，效率明显比B-Tree差很多。

至于B+Tree为什么更适合外存索引，原因和内节点出度d有关。

由于B+Tree内节点去掉了data域，因此可以拥有更大的出度，拥有更好的性能。


#### demo1

Student学生表

| 表字段                     | 说明                                                         |
| ------------------------ | ------------------------------------------------------------ |
| SID              | 主键                                                   |
| Sname         | 名字  |
| Sage           | 年龄                    |
| Ssex           | 性别                    |
| Sbirth           | 生日                    |

Course课程表：

| 表字段                     | 说明                                                         |
| ------------------------ | ------------------------------------------------------------ |
| CID              | 主键                                                   |
| Cname         | 名字  |
| TID           | 教师ID                    |

SC成绩表：

| 表字段                     | 说明                                                         |
| ------------------------ | ------------------------------------------------------------ |
| SID              | 主键                                                   |
| CID         | 课程ID  |
| score           | 分数                    |

Teacher教师表：

| 表字段                     | 说明                                                         |
| ------------------------ | ------------------------------------------------------------ |
| TID              | 主键                                                   |
| Tname         | 名字  |

1、查询201课程比202课程成绩高的所有学生的学号

```sql
select a.SID from (select Sid,score from SC where CID=201) a,(select Sid,score from SC where CID=202) b where a.score>b.score a.score>b.score and a.Sid=b.Sid;
```

2、查询平均成绩大于60分的同学的学号和平均成绩；

```sql
select SID,avg(score) from sc group by SID having avg(score) >60;
```

3、查询所有同学的学号、姓名、选课数、总成绩；

```sql
select Student.SID,Student.Sname,count(SC.CID),sum(score) from Student left Outer join SC on Student.SID=SC.SID
    group by Student.SID,Sname
```

4、查询姓“李”的老师的个数；
```sql
select count(distinct(Tname))
from Teacher
where Tname like '李%';
```

5、查询没学过“叶平”老师课的同学的学号、姓名；

```sql
select Student.SID,Student.Sname
from Student
where SID not in (select distinct(SC.SID) from SC,Course,Teacher
                  where SC.CID=Course.CID and Teacher.TID=Course.TID and Teacher.Tname='叶平');
select student.sid,student.sname
from student
where sid not in (
    select sid
    from sc
    where cid in (
        select cid
        from course
        where tid = (select tid
                     from teacher
                     where tname = '叶平')
    )
)
```

6、查询学过“201”并且也学过编号“202”课程的同学的学号、姓名；

```sql
select Student.SID,Student.Sname
from Student,SC
where Student.SID=SC.SID and SC.CID='001'and exists(
    Select * from SC as SC_2 where SC_2.SID=SC.SID and SC_2.CID='002');
```

7、查询学过“叶平”老师所教的所有课的同学的学号、姓名；

```sql
select SID,Sname
from Student
where SID in (select SID from SC ,Course ,Teacher
              where SC.CID=Course.CID and Teacher.TID=Course.TID and Teacher.Tname='叶平'
              group by SID having count(SC.CID)=(select count(CID) from Course,Teacher
                                                 where Teacher.TID=Course.TID and Tname='叶平'));
```


8、查询课程编号“202”的成绩比课程编号“201”课程低的所有同学的学号、姓名；

```sql
Select SID,Sname from (select Student.SID,Student.Sname,score ,(select score from SC SC_2 where SC_2.SID=Student.SID and SC_2.CID='002') score2
                       from Student,SC where Student.SID=SC.SID and CID='001') S_2 where score2 <score;
```

9、查询所有课程成绩小于60分的同学的学号、姓名；
（取反操作处理）

```sql
select SID,Sname
from Student
where SID not in (select Student.SID from Student,SC where S.SID=SC.SID and score>60);
```

10、查询没有学全所有课的同学的学号、姓名；

（count(CID)得到课程的数目）

```sql
select Student.SID,Student.Sname
from Student,SC
where Student.SID=SC.SID group by Student.SID,Student.Sname having count(CID) <(select count(CID) from Course);
```


11、查询至少有一门课与学号为“1001”的同学所学相同的同学的学号和姓名；

```sql
select SID,Sname from Student,SC where Student.SID=SC.SID and CID in (select CID from SC where SID='1001');
```

12、查询至少学过学号为“1001”同学所有一门课的其他同学学号和姓名；

```sql
select distinct SC.SID,Sname
from Student,SC
where Student.SID=SC.SID and CID in (select CID from SC where SID='001')
and Student.SID <> 1001;
```


13、把“SC”表中“叶平”老师教的课的成绩都更改为此课程的平均成绩；

```sql
update SC
set score=(select avg(SC_2.score)
           from SC SC_2
           where SC_2.CID=SC.CID )
where cid = (
    select cid
    from Course,Teacher
    where Course.CID=SC.CID and Course.TID=Teacher.TID and Teacher.Tname='叶平'
)
```


14、查询和“1002”号的同学学习的课程完全相同的其他同学学号和姓名；

```sql
select SID
from SC
where CID in (select CID from SC where SID='1002')
group by SID having count(*)=(select count(*) from SC where SID='1002');
```

15、删除学习“叶平”老师课的SC表记录；

```sql
Delete from sc
where cid = (
    select cid
    from course ,Teacher
    where Course.CID=SC.CID and Course.TID= Teacher.TID and Tname='叶平'
)

```

16、向SC表中插入一些记录，这些记录要求符合以下条件：没有上过编号“003”课程的同学学号、002号课的平均成绩；

```sql
Insert into SC
as select SID,'002',(Select avg(score)
                     from SC where CID='002')
from Student
where SID not in (Select SID from SC where CID='002');
```

17、按学生平均成绩从高到低显示所有学生的“数据库”、“企业管理”、“英语”三门的课程成绩，按如下形式显示：学生ID,数据库,企业管理,英语,有效课程数,有效平均分
（默认数据库是004，企业管理是001，英语是006）

```sql
SELECT SID as 学生ID
,(SELECT score FROM SC WHERE SC.SID=t.SID AND CID='004') AS 数据库
,(SELECT score FROM SC WHERE SC.SID=t.SID AND CID='001') AS 企业管理
,(SELECT score FROM SC WHERE SC.SID=t.SID AND CID='006') AS 英语
,COUNT(*) AS 有效课程数, AVG(t.score) AS 平均成绩
FROM SC AS t
GROUP BY SID
ORDER BY avg(t.score)
```

18、查询各科成绩最高和最低的分，以及对应的学号：以如下形式显示：课程ID，最高分，学号，最低分，学号

```sql
SELECT L.CID courseID,L.score 最高分,L.sid 学号,R.score 最低分,R.sid 学号
FROM SC L ,SC R
WHERE L.CID = R.CID and
L.score = (SELECT MAX(IL.score)
           FROM SC IL,Student IM
           WHERE L.CID = IL.CID and IM.SID=IL.SID
           GROUP BY IL.CID)
AND
R.Score = (SELECT MIN(IR.score)
           FROM SC IR
           WHERE R.CID = IR.CID
           GROUP BY IR.CID)
```

19、查询课程号，课程名称，平均成绩和及格率，并按各科平均成绩从低到高和及格率的百分数从高到低顺序

```sql
SELECT t.CID AS 课程号,max(course.Cname)AS 课程名,isnull(AVG(score),0) AS 平均成绩
,100 * SUM(CASE WHEN isnull(score,0)>=60 THEN 1 ELSE 0 END)/COUNT(*) AS 及格百分数
FROM SC T,Course
where t.CID=course.CID
GROUP BY t.CID
ORDER BY 100 * SUM(CASE WHEN isnull(score,0)>=60 THEN 1 ELSE 0 END)/COUNT(*) DESC
```

20、查询如下课程平均成绩和及格率的百分数(用"1行"显示): 企业管理（001），马克思（002），OO&UML （003），数据库（004）

```sql
SELECT SUM(CASE WHEN CID ='001' THEN score ELSE 0 END)/SUM(CASE CID WHEN '001' THEN 1 ELSE 0 END) AS 企业管理平均分
,100 * SUM(CASE WHEN CID = '001' AND score >= 60 THEN 1 ELSE 0 END)/SUM(CASE WHEN CID = '001' THEN 1 ELSE 0 END) AS 企业管理及格百分数
,SUM(CASE WHEN CID = '002' THEN score ELSE 0 END)/SUM(CASE CID WHEN '002' THEN 1 ELSE 0 END) AS 马克思平均分
,100 * SUM(CASE WHEN CID = '002' AND score >= 60 THEN 1 ELSE 0 END)/SUM(CASE WHEN CID = '002' THEN 1 ELSE 0 END) AS 马克思及格百分数
,SUM(CASE WHEN CID = '003' THEN score ELSE 0 END)/SUM(CASE CID WHEN '003' THEN 1 ELSE 0 END) AS UML平均分
,100 * SUM(CASE WHEN CID = '003' AND score >= 60 THEN 1 ELSE 0 END)/SUM(CASE WHEN CID = '003' THEN 1 ELSE 0 END) AS UML及格百分数
,SUM(CASE WHEN CID = '004' THEN score ELSE 0 END)/SUM(CASE CID WHEN '004' THEN 1 ELSE 0 END) AS 数据库平均分
,100 * SUM(CASE WHEN CID = '004' AND score >= 60 THEN 1 ELSE 0 END)/SUM(CASE WHEN CID = '004' THEN 1 ELSE 0 END) AS 数据库及格百分数
FROM SC
```

21、查询不同老师所教不同课程平均分从高到低显示

```sql
SELECT max(Z.TID) AS 教师ID,MAX(Z.Tname) AS 教师姓名,C.CID AS 课程ＩＤ,MAX(C.Cname) AS 课程名称,AVG(Score) AS 平均成绩
FROM SC AS T,Course AS C ,Teacher AS Z
where T.CID=C.CID and C.TID=Z.TID
GROUP BY C.CID
ORDER BY AVG(Score) DESC
```

22、查询如下课程成绩第 3 名到第 6 名的学生成绩单：企业管理（001），马克思（002），UML （003），数据库（004）
[学生ID],[学生姓名],企业管理,马克思,UML,数据库,平均成绩

```sql
SELECT DISTINCT top 3
SC.SID As 学生学号,
Student.Sname AS 学生姓名 ,
T1.score AS 企业管理,
T2.score AS 马克思,
T3.score AS UML,
T4.score AS 数据库,
ISNULL(T1.score,0) + ISNULL(T2.score,0) + ISNULL(T3.score,0) + ISNULL(T4.score,0) as 总分
FROM Student,SC LEFT JOIN SC AS T1
ON SC.SID = T1.SID AND T1.CID = '001'
LEFT JOIN SC AS T2
ON SC.SID = T2.SID AND T2.CID = '002'
LEFT JOIN SC AS T3
ON SC.SID = T3.SID AND T3.CID = '003'
LEFT JOIN SC AS T4
ON SC.SID = T4.SID AND T4.CID = '004'
WHERE student.SID=SC.SID and
ISNULL(T1.score,0) + ISNULL(T2.score,0) + ISNULL(T3.score,0) + ISNULL(T4.score,0)
NOT IN
(SELECT
 DISTINCT
 TOP 15 WITH TIES
 ISNULL(T1.score,0) + ISNULL(T2.score,0) + ISNULL(T3.score,0) + ISNULL(T4.score,0)
 FROM sc
 LEFT JOIN sc AS T1
 ON sc.SID = T1.SID AND T1.CID = 'k1'
 LEFT JOIN sc AS T2
 ON sc.SID = T2.SID AND T2.CID = 'k2'
 LEFT JOIN sc AS T3
 ON sc.SID = T3.SID AND T3.CID = 'k3'
 LEFT JOIN sc AS T4
 ON sc.SID = T4.SID AND T4.CID = 'k4'
 ORDER BY ISNULL(T1.score,0) + ISNULL(T2.score,0) + ISNULL(T3.score,0) + ISNULL(T4.score,0) DESC);
```

23、统计各科成绩,各分数段人数:课程ID,课程名称,[100-85],[85-70],[70-60],[ <60]

```sql
SELECT SC.CID as 课程ID, Cname as 课程名称
,SUM(CASE WHEN score BETWEEN 85 AND 100 THEN 1 ELSE 0 END) AS [100 - 85]
,SUM(CASE WHEN score BETWEEN 70 AND 85 THEN 1 ELSE 0 END) AS [85 - 70]
,SUM(CASE WHEN score BETWEEN 60 AND 70 THEN 1 ELSE 0 END) AS [70 - 60]
,SUM(CASE WHEN score < 60 THEN 1 ELSE 0 END) AS [60 -]
FROM SC,Course
where SC.CID=Course.CID
GROUP BY SC.CID,Cname;
```

24、查询学生平均成绩及其名次

```sql
SELECT 1+(SELECT COUNT( distinct 平均成绩)
          FROM (SELECT SID,AVG(score) AS 平均成绩
                FROM SC
                GROUP BY SID
               ) AS T1
          WHERE 平均成绩> T2.平均成绩) as 名次,
SID as 学生学号,平均成绩
FROM (SELECT SID,AVG(score) 平均成绩
      FROM SC
      GROUP BY SID
     ) AS T2
ORDER BY 平均成绩desc;
```

25、查询各科成绩前三名的记录:(不考虑成绩并列情况)

```sql
SELECT t1.SID as 学生ID,t1.CID as 课程ID,Score as 分数
FROM SC t1
WHERE score IN (SELECT TOP 3 score
                FROM SC
                WHERE t1.CID= CID
                ORDER BY score DESC
               )
ORDER BY t1.CID;
```

26、查询每门课程被选修的学生数

```sql
select Cid,count(SID) from sc group by CID;
```

27、查询出只选修了一门课程的全部学生的学号和姓名

```sql
select SC.SID,Student.Sname,count(CID) AS 选课数
from SC ,Student
where SC.SID=Student.SID group by SC.SID ,Student.Sname having count(CID)=1;
```

28、查询男生、女生人数

```sql
Select count(Ssex) as 男生人数 from Student group by Ssex having Ssex='男';
Select count(Ssex) as 女生人数 from Student group by Ssex having Ssex='女'；
```


29、查询姓“张”的学生名单

```sql
SELECT Sname FROM Student WHERE Sname like '张%';
```

30、查询同名学生名单，并统计同名人数

```sql
select Sname,count(*) from Student group by Sname having count(*)>1;
```

31、1981年出生的学生名单(注：Student表中Sage列的类型是datetime)

```sql
select Sname, CONVERT(char (11),DATEPART(year,Sage)) as age
from student
where CONVERT(char(11),DATEPART(year,Sage))='1981';
```

32、查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列

```sql
Select CID,Avg(score) from SC group by CID order by Avg(score),CID DESC ;
```

33、查询平均成绩大于85的所有学生的学号、姓名和平均成绩

```sql
select Sname,SC.SID ,avg(score)
from Student,SC
where Student.SID=SC.SID group by SC.SID,Sname having avg(score)>85;
```

34、查询课程名称为“数据库”，且分数低于60的学生姓名和分数

```sql
Select Sname,isnull(score,0)
from Student,SC,Course
where SC.SID=Student.SID and SC.CID=Course.CID and Course.Cname='数据库'and score <60;
```

35、查询所有学生的选课情况； （学号，姓名，课程编号，课程名字）

```sql
SELECT SC.SID,SC.CID,Sname,Cname
FROM SC,Student,Course
where SC.SID=Student.SID and SC.CID=Course.CID ;
```

36、查询任何一门课程成绩在70分以上的学号、姓名、课程编号和分数；

```sql
SELECT distinct student.SID,student.Sname,SC.CID,SC.score
FROM student,Sc
WHERE SC.score>=70 AND SC.SID=student.SID;
```

37、查询学生学号，以及其不及格的课程，并按课程号从大到小排列

```sql
select sid,Cid from sc where score <60 order by CID ;
```

38、查询课程编号为003且课程成绩在80分以上的学生的学号和姓名；

```sql
select SC.SID,Student.Sname from SC,Student where SC.SID=Student.SID and Score>80 and CID='003';
```

39、求选了课程的学生人数

```sql
select count(*) from sc;
```

40、查询选修“叶平”老师所授课程的学生中，成绩最高的学生姓名及其成绩

```sql
select Student.Sname,score
from Student,SC,CourseC,Teacher
where Student.SID=SC.SID and SC.CID=C.CID and C.TID=Teacher.TID and Teacher.Tname='叶平' and SC.score=(select max(score)from SC where CID=C.CID );
```

41、查询各个课程及相应的选修人数

```sql
select count(*) from sc group by CID;
```

42、查询不同课程成绩相同的学生的学号、课程号、学生成绩

```sql
select distinct A.SID,B.score from SC A ,SC B where A.Score=B.Score and A.CID <>B.CID ;
```


43、查询每门功成绩最好的前两名

```sql
SELECT t1.SID as 学生ID,t1.CID as 课程ID,Score as 分数
FROM SC t1
WHERE score IN (SELECT TOP 2 score
                FROM SC
                WHERE t1.CID= CID
                ORDER BY score DESC
               )
ORDER BY t1.CID;
```

44、统计每门课程的学生选修人数（超过10人的课程才统计）。要求输出课程号和选修人数，查询结果按人数降序排列，查询结果按人数降序排列，若人数相同，按课程号升序排列

```sql
select CID as 课程号,count(*) as 人数
from sc
group by CID
order by count(*) desc,Cid
```

45、检索至少选修两门课程的学生学号

```sql
select SID
from sc
group by Sid
having count(*) > = 2
```

46、查询全部学生都选修的课程的课程号和课程名

```sql
select CID,Cname
from Course
where CID in (select Cid from sc group by Cid)
```

47、查询没学过“叶平”老师讲授的任一门课程的学生姓名

```sql
select Sname from Student where SID not in (select SID from Course,Teacher,SC where Course.TID=Teacher.TID and SC.CID=course.CID and Tname='叶平');
```

48、查询两门以上不及格课程的同学的学号及其平均成绩

```sql
select SID,avg(isnull(score,0)) from SC where SID in (select SID from SC where score <60 group by SID having count(*)>2)group by SID;
```
