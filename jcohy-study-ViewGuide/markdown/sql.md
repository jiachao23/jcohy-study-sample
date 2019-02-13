#  Sql
> #### PS:�������С�������
> #### ������ҳ��[www.jcohy.com](http://www.jcohy.com)  	

>  �ҵ�ѧϰ�ʼǣ���¼ѧϰ�����еıʼ��Լ�����������,�Լ��ҵ�һЩ�����ܽᡣ�����������ʧЧ,������֪����������ݵ���������ύ Issues �������޸�������ݡ�

## Sql
> * [Statement](#sql-1)
> * [�α� ](#sql-2)
> * [�г� 5 ��Ӧ����ѭ�� JDBC ���ʵ��](#sql-3)
> * [���ݿ�������ʵ��](#sql-4)
> * [demo](#sql-5)

<p id="sql-1">

#### Statement

1.1 ��������

- Statement����������÷�, ������, �����ַ���ƴ�ӣ�����ע��©��
- PreparedStatement�����������sql���, ͬʱ���Ϸ���, Ч�ʸ߿�������, ��ֹsqlע��
- CallableStatement�ӿ���չPreparedStatement���������ô洢����
- BatchedStatement���������������ݿ⣬BatchedStatement���Ǳ�׼��Statement��

```java
public interface CallableStatement extends PreparedStatement 
public interface PreparedStatement extends Statement 
```

1.2 Statement��PrepareStatement������

- ����ʱ������
```
Statement statement = conn.createStatement();
PreparedStatement preStatement = conn.prepareStatement(sql);
```
- ִ�е�ʱ��
```
ResultSet rSet = statement.executeQuery(sql);
ResultSet pSet = preStatement.executeQuery();
```
���Ͽ��Կ�����PreparedStatement��Ԥ����Ĺ��̣��Ѿ���sql��֮������ִ�ж��ٱ飬��������ȥ���б��룬�� statement ��ͬ�����ִ�ж�飬����Ӧ�ľ�Ҫ������ٱ�sql�����Դ���㿴��preStatement ��Ч�ʻ�� StatementҪ��һЩ

- ��ȫ��

PreparedStatement��Ԥ����ģ����Կ�����Ч�ķ�ֹSQLע�������

- ����Ŀɶ��ԺͿ�ά����

PreparedStatement��ʤһ��

<p id="sql-2">

#### �α� 

<p id="sql-3">

#### �г� 5 ��Ӧ����ѭ�� JDBC ���ʵ��

�кܶ�����ʵ��������Ը������ϲ�������١�������һЩ��ͨ�õ�ԭ��

a��ʹ�������Ĳ���������͸�������

b��ʹ�� PreparedStatement ������ SQL �쳣�����������

c��ʹ�����ݿ����ӳ�

d��ͨ����������ȡ���������Ҫʹ���е��±�����ȡ

<p id="sql-4">

####  ���ݿ�������ʵ��

���ݿ�ϵͳ��ά���������ض������㷨�����ݽṹ����Щ���ݽṹ��ĳ�ַ�ʽ���ã�ָ�����ݣ������Ϳ�������Щ���ݽṹ��ʵ�ָ߼������㷨���������ݽṹ������������

B����

һ��m��B��(balanced tree of order m)��һ��ƽ���m·���������������ǿ����������������������ʵ�����

1�������������������Ů��
2��ÿ���Ǹ��ڵ��������Ĺؼ��ָ��� j ���㣺��m/2�� - 1 <= j <= m - 1��
3�����������������н�㣨������Ҷ�ӽ�㣩�Ķ��������ǹؼ���������1�����ڲ��������� k ���㣺��m/2�� <= k <= m ��
4�����е�Ҷ�ӽ�㶼λ��ͬһ�㡣

����B-Tree�����ԣ���B-Tree�а�key�������ݵ��㷨�ǳ�ֱ�ۣ����ȴӸ��ڵ���ж��ֲ��ң�����ҵ��򷵻ض�Ӧ�ڵ��data���������Ӧ�����ָ��ָ��Ľڵ�ݹ���в��ң�ֱ���ҵ��ڵ���ҵ�nullָ�룬ǰ�߲��ҳɹ������߲���ʧ�ܡ�

һ����Ϊd��B-Tree����������N��key����������h������Ϊlogd((N+1)/2)������һ��key������ҽڵ�����Ľ������Ӷ�ΪO(logdN)���������Կ�����B-Tree��һ���ǳ���Ч�ʵ��������ݽṹ��

B+����

B-Tree�������֣������������B+Tree������MySQL���ձ�ʹ��B+Treeʵ���������ṹ��

B+����B���ı��Σ��������е�data������Ҷ�ӽ���У�ֻ���ؼ��ֺ���Ůָ�뱣�����ڽ�㣬�ڽ����ȫ�������Ĺ��ܡ�

��B-Tree��ȣ�B+Tree�����²�ͬ�㣺

1��ÿ���ڵ��ָ������Ϊ2d������2d+1��

2���ڽڵ㲻�洢data��ֻ�洢key��Ҷ�ӽڵ�洢data���洢ָ�롣

һ�������ݿ�ϵͳ���ļ�ϵͳ��ʹ�õ�B+Tree�ṹ���ھ���B+Tree�Ļ����Ͻ������Ż���������˳�����ָ�롣

��B+Tree��ÿ��Ҷ�ӽڵ�����һ��ָ������Ҷ�ӽڵ��ָ��

����ͼ4�����Ҫ��ѯkeyΪ��18��49���������ݼ�¼�����ҵ�18��ֻ��˳�Žڵ��ָ��˳������Ϳ���һ���Է��ʵ��������ݽڵ㣬�����ᵽ�������ѯЧ�ʡ�

ΪʲôB����B+������

һ����˵����������Ҳ�ܴ󣬲�����ȫ���洢���ڴ��У�������������������ļ�����ʽ�洢�Ĵ����ϡ������Ļ����������ҹ����о�Ҫ��������I/O���ģ�������ڴ��ȡ��I/O��ȡ������Ҫ�߼�������������������һ�����ݽṹ��Ϊ��������������Ҫ��ָ������ڲ��ҹ����д���I/O���������Ľ������Ӷȡ����仰˵�������Ľṹ��֯Ҫ�������ٲ��ҹ����д���I/O�Ĵ�ȡ������

���漰�����̴�ȡԭ���ֲ���ԭ��ʹ���Ԥ����

�ȴ�B-Tree����������B-Tree�Ķ��壬**��֪����һ�������Ҫ����h���ڵ㡣���ݿ�ϵͳ����������������˴���Ԥ��ԭ����һ���ڵ�Ĵ�С��Ϊ����һ��ҳ������ÿ���ڵ�ֻ��Ҫһ��I/O�Ϳ�����ȫ���롣**Ϊ�˴ﵽ���Ŀ�ģ���ʵ��ʵ��B-Tree����Ҫʹ�����¼��ɣ�

**ÿ���½��ڵ�ʱ��ֱ������һ��ҳ�Ŀռ䣬�����ͱ�֤һ���ڵ�������Ҳ�洢��һ��ҳ���֮������洢���䶼�ǰ�ҳ����ģ���ʵ����һ��nodeֻ��һ��I/O��**

**B-Tree��һ�μ��������Ҫh-1��I/O�����ڵ㳣פ�ڴ棩���������Ӷ�ΪO(h)=O(logdN)��һ��ʵ��Ӧ���У�����d�Ƿǳ�������֣�ͨ������100�����h�ǳ�С��ͨ��������3����**

������������B-Tree��Ϊ�����ṹЧ���Ƿǳ��ߵġ�

����������ֽṹ��h����Ҫ��Ķࡣ�����߼��Ϻܽ��Ľڵ㣨���ӣ������Ͽ��ܺ�Զ���޷����þֲ��ԣ����Ժ������I/O�������Ӷ�ҲΪO(h)��Ч�����Ա�B-Tree��ܶࡣ

����B+TreeΪʲô���ʺ����������ԭ����ڽڵ����d�йء�

����B+Tree�ڽڵ�ȥ����data����˿���ӵ�и���ĳ��ȣ�ӵ�и��õ����ܡ�


#### demo1

Studentѧ����

| ���ֶ�                     | ˵��                                                         |
| ------------------------ | ------------------------------------------------------------ |
| SID              | ����                                                   |
| Sname         | ����  |
| Sage           | ����                    |
| Ssex           | �Ա�                    |
| Sbirth           | ����                    |

Course�γ̱�

| ���ֶ�                     | ˵��                                                         |
| ------------------------ | ------------------------------------------------------------ |
| CID              | ����                                                   |
| Cname         | ����  |
| TID           | ��ʦID                    |

SC�ɼ���

| ���ֶ�                     | ˵��                                                         |
| ------------------------ | ------------------------------------------------------------ |
| SID              | ����                                                   |
| CID         | �γ�ID  |
| score           | ����                    |

Teacher��ʦ��

| ���ֶ�                     | ˵��                                                         |
| ------------------------ | ------------------------------------------------------------ |
| TID              | ����                                                   |
| Tname         | ����  |

1����ѯ201�γ̱�202�γ̳ɼ��ߵ�����ѧ����ѧ��

```sql
select a.SID from (select Sid,score from SC where CID=201) a,(select Sid,score from SC where CID=202) b where a.score>b.score a.score>b.score and a.Sid=b.Sid;
```

2����ѯƽ���ɼ�����60�ֵ�ͬѧ��ѧ�ź�ƽ���ɼ���

```sql
select SID,avg(score) from sc group by SID having avg(score) >60;
```

3����ѯ����ͬѧ��ѧ�š�������ѡ�������ܳɼ���

```sql
select Student.SID,Student.Sname,count(SC.CID),sum(score) from Student left Outer join SC on Student.SID=SC.SID
    group by Student.SID,Sname
```

4����ѯ�ա������ʦ�ĸ�����
```sql
select count(distinct(Tname))
from Teacher
where Tname like '��%';
```

5����ѯûѧ����Ҷƽ����ʦ�ε�ͬѧ��ѧ�š�������

```sql
select Student.SID,Student.Sname
from Student
where SID not in (select distinct(SC.SID) from SC,Course,Teacher
                  where SC.CID=Course.CID and Teacher.TID=Course.TID and Teacher.Tname='Ҷƽ');
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
                     where tname = 'Ҷƽ')
    )
)
```

6����ѯѧ����201������Ҳѧ����š�202���γ̵�ͬѧ��ѧ�š�������

```sql
select Student.SID,Student.Sname
from Student,SC
where Student.SID=SC.SID and SC.CID='001'and exists(
    Select * from SC as SC_2 where SC_2.SID=SC.SID and SC_2.CID='002');
```

7����ѯѧ����Ҷƽ����ʦ���̵����пε�ͬѧ��ѧ�š�������

```sql
select SID,Sname
from Student
where SID in (select SID from SC ,Course ,Teacher
              where SC.CID=Course.CID and Teacher.TID=Course.TID and Teacher.Tname='Ҷƽ'
              group by SID having count(SC.CID)=(select count(CID) from Course,Teacher
                                                 where Teacher.TID=Course.TID and Tname='Ҷƽ'));
```


8����ѯ�γ̱�š�202���ĳɼ��ȿγ̱�š�201���γ̵͵�����ͬѧ��ѧ�š�������

```sql
Select SID,Sname from (select Student.SID,Student.Sname,score ,(select score from SC SC_2 where SC_2.SID=Student.SID and SC_2.CID='002') score2
                       from Student,SC where Student.SID=SC.SID and CID='001') S_2 where score2 <score;
```

9����ѯ���пγ̳ɼ�С��60�ֵ�ͬѧ��ѧ�š�������
��ȡ����������

```sql
select SID,Sname
from Student
where SID not in (select Student.SID from Student,SC where S.SID=SC.SID and score>60);
```

10����ѯû��ѧȫ���пε�ͬѧ��ѧ�š�������

��count(CID)�õ��γ̵���Ŀ��

```sql
select Student.SID,Student.Sname
from Student,SC
where Student.SID=SC.SID group by Student.SID,Student.Sname having count(CID) <(select count(CID) from Course);
```


11����ѯ������һ�ſ���ѧ��Ϊ��1001����ͬѧ��ѧ��ͬ��ͬѧ��ѧ�ź�������

```sql
select SID,Sname from Student,SC where Student.SID=SC.SID and CID in (select CID from SC where SID='1001');
```

12����ѯ����ѧ��ѧ��Ϊ��1001��ͬѧ����һ�ſε�����ͬѧѧ�ź�������

```sql
select distinct SC.SID,Sname
from Student,SC
where Student.SID=SC.SID and CID in (select CID from SC where SID='001')
and Student.SID <> 1001;
```


13���ѡ�SC�����С�Ҷƽ����ʦ�̵Ŀεĳɼ�������Ϊ�˿γ̵�ƽ���ɼ���

```sql
update SC
set score=(select avg(SC_2.score)
           from SC SC_2
           where SC_2.CID=SC.CID )
where cid = (
    select cid
    from Course,Teacher
    where Course.CID=SC.CID and Course.TID=Teacher.TID and Teacher.Tname='Ҷƽ'
)
```


14����ѯ�͡�1002���ŵ�ͬѧѧϰ�Ŀγ���ȫ��ͬ������ͬѧѧ�ź�������

```sql
select SID
from SC
where CID in (select CID from SC where SID='1002')
group by SID having count(*)=(select count(*) from SC where SID='1002');
```

15��ɾ��ѧϰ��Ҷƽ����ʦ�ε�SC���¼��

```sql
Delete from sc
where cid = (
    select cid
    from course ,Teacher
    where Course.CID=SC.CID and Course.TID= Teacher.TID and Tname='Ҷƽ'
)

```

16����SC���в���һЩ��¼����Щ��¼Ҫ���������������û���Ϲ���š�003���γ̵�ͬѧѧ�š�002�ſε�ƽ���ɼ���

```sql
Insert into SC
as select SID,'002',(Select avg(score)
                     from SC where CID='002')
from Student
where SID not in (Select SID from SC where CID='002');
```

17����ѧ��ƽ���ɼ��Ӹߵ�����ʾ����ѧ���ġ����ݿ⡱������ҵ��������Ӣ����ŵĿγ̳ɼ�����������ʽ��ʾ��ѧ��ID,���ݿ�,��ҵ����,Ӣ��,��Ч�γ���,��Чƽ����
��Ĭ�����ݿ���004����ҵ������001��Ӣ����006��

```sql
SELECT SID as ѧ��ID
,(SELECT score FROM SC WHERE SC.SID=t.SID AND CID='004') AS ���ݿ�
,(SELECT score FROM SC WHERE SC.SID=t.SID AND CID='001') AS ��ҵ����
,(SELECT score FROM SC WHERE SC.SID=t.SID AND CID='006') AS Ӣ��
,COUNT(*) AS ��Ч�γ���, AVG(t.score) AS ƽ���ɼ�
FROM SC AS t
GROUP BY SID
ORDER BY avg(t.score)
```

18����ѯ���Ƴɼ���ߺ���͵ķ֣��Լ���Ӧ��ѧ�ţ���������ʽ��ʾ���γ�ID����߷֣�ѧ�ţ���ͷ֣�ѧ��

```sql
SELECT L.CID courseID,L.score ��߷�,L.sid ѧ��,R.score ��ͷ�,R.sid ѧ��
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

19����ѯ�γ̺ţ��γ����ƣ�ƽ���ɼ��ͼ����ʣ���������ƽ���ɼ��ӵ͵��ߺͼ����ʵİٷ����Ӹߵ���˳��

```sql
SELECT t.CID AS �γ̺�,max(course.Cname)AS �γ���,isnull(AVG(score),0) AS ƽ���ɼ�
,100 * SUM(CASE WHEN isnull(score,0)>=60 THEN 1 ELSE 0 END)/COUNT(*) AS ����ٷ���
FROM SC T,Course
where t.CID=course.CID
GROUP BY t.CID
ORDER BY 100 * SUM(CASE WHEN isnull(score,0)>=60 THEN 1 ELSE 0 END)/COUNT(*) DESC
```

20����ѯ���¿γ�ƽ���ɼ��ͼ����ʵİٷ���(��"1��"��ʾ): ��ҵ����001�������˼��002����OO&UML ��003�������ݿ⣨004��

```sql
SELECT SUM(CASE WHEN CID ='001' THEN score ELSE 0 END)/SUM(CASE CID WHEN '001' THEN 1 ELSE 0 END) AS ��ҵ����ƽ����
,100 * SUM(CASE WHEN CID = '001' AND score >= 60 THEN 1 ELSE 0 END)/SUM(CASE WHEN CID = '001' THEN 1 ELSE 0 END) AS ��ҵ������ٷ���
,SUM(CASE WHEN CID = '002' THEN score ELSE 0 END)/SUM(CASE CID WHEN '002' THEN 1 ELSE 0 END) AS ���˼ƽ����
,100 * SUM(CASE WHEN CID = '002' AND score >= 60 THEN 1 ELSE 0 END)/SUM(CASE WHEN CID = '002' THEN 1 ELSE 0 END) AS ���˼����ٷ���
,SUM(CASE WHEN CID = '003' THEN score ELSE 0 END)/SUM(CASE CID WHEN '003' THEN 1 ELSE 0 END) AS UMLƽ����
,100 * SUM(CASE WHEN CID = '003' AND score >= 60 THEN 1 ELSE 0 END)/SUM(CASE WHEN CID = '003' THEN 1 ELSE 0 END) AS UML����ٷ���
,SUM(CASE WHEN CID = '004' THEN score ELSE 0 END)/SUM(CASE CID WHEN '004' THEN 1 ELSE 0 END) AS ���ݿ�ƽ����
,100 * SUM(CASE WHEN CID = '004' AND score >= 60 THEN 1 ELSE 0 END)/SUM(CASE WHEN CID = '004' THEN 1 ELSE 0 END) AS ���ݿ⼰��ٷ���
FROM SC
```

21����ѯ��ͬ��ʦ���̲�ͬ�γ�ƽ���ִӸߵ�����ʾ

```sql
SELECT max(Z.TID) AS ��ʦID,MAX(Z.Tname) AS ��ʦ����,C.CID AS �γ̣ɣ�,MAX(C.Cname) AS �γ�����,AVG(Score) AS ƽ���ɼ�
FROM SC AS T,Course AS C ,Teacher AS Z
where T.CID=C.CID and C.TID=Z.TID
GROUP BY C.CID
ORDER BY AVG(Score) DESC
```

22����ѯ���¿γ̳ɼ��� 3 ������ 6 ����ѧ���ɼ�������ҵ����001�������˼��002����UML ��003�������ݿ⣨004��
[ѧ��ID],[ѧ������],��ҵ����,���˼,UML,���ݿ�,ƽ���ɼ�

```sql
SELECT DISTINCT top 3
SC.SID As ѧ��ѧ��,
Student.Sname AS ѧ������ ,
T1.score AS ��ҵ����,
T2.score AS ���˼,
T3.score AS UML,
T4.score AS ���ݿ�,
ISNULL(T1.score,0) + ISNULL(T2.score,0) + ISNULL(T3.score,0) + ISNULL(T4.score,0) as �ܷ�
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

23��ͳ�Ƹ��Ƴɼ�,������������:�γ�ID,�γ�����,[100-85],[85-70],[70-60],[ <60]

```sql
SELECT SC.CID as �γ�ID, Cname as �γ�����
,SUM(CASE WHEN score BETWEEN 85 AND 100 THEN 1 ELSE 0 END) AS [100 - 85]
,SUM(CASE WHEN score BETWEEN 70 AND 85 THEN 1 ELSE 0 END) AS [85 - 70]
,SUM(CASE WHEN score BETWEEN 60 AND 70 THEN 1 ELSE 0 END) AS [70 - 60]
,SUM(CASE WHEN score < 60 THEN 1 ELSE 0 END) AS [60 -]
FROM SC,Course
where SC.CID=Course.CID
GROUP BY SC.CID,Cname;
```

24����ѯѧ��ƽ���ɼ���������

```sql
SELECT 1+(SELECT COUNT( distinct ƽ���ɼ�)
          FROM (SELECT SID,AVG(score) AS ƽ���ɼ�
                FROM SC
                GROUP BY SID
               ) AS T1
          WHERE ƽ���ɼ�> T2.ƽ���ɼ�) as ����,
SID as ѧ��ѧ��,ƽ���ɼ�
FROM (SELECT SID,AVG(score) ƽ���ɼ�
      FROM SC
      GROUP BY SID
     ) AS T2
ORDER BY ƽ���ɼ�desc;
```

25����ѯ���Ƴɼ�ǰ�����ļ�¼:(�����ǳɼ��������)

```sql
SELECT t1.SID as ѧ��ID,t1.CID as �γ�ID,Score as ����
FROM SC t1
WHERE score IN (SELECT TOP 3 score
                FROM SC
                WHERE t1.CID= CID
                ORDER BY score DESC
               )
ORDER BY t1.CID;
```

26����ѯÿ�ſγ̱�ѡ�޵�ѧ����

```sql
select Cid,count(SID) from sc group by CID;
```

27����ѯ��ֻѡ����һ�ſγ̵�ȫ��ѧ����ѧ�ź�����

```sql
select SC.SID,Student.Sname,count(CID) AS ѡ����
from SC ,Student
where SC.SID=Student.SID group by SC.SID ,Student.Sname having count(CID)=1;
```

28����ѯ������Ů������

```sql
Select count(Ssex) as �������� from Student group by Ssex having Ssex='��';
Select count(Ssex) as Ů������ from Student group by Ssex having Ssex='Ů'��
```


29����ѯ�ա��š���ѧ������

```sql
SELECT Sname FROM Student WHERE Sname like '��%';
```

30����ѯͬ��ѧ����������ͳ��ͬ������

```sql
select Sname,count(*) from Student group by Sname having count(*)>1;
```

31��1981�������ѧ������(ע��Student����Sage�е�������datetime)

```sql
select Sname, CONVERT(char (11),DATEPART(year,Sage)) as age
from student
where CONVERT(char(11),DATEPART(year,Sage))='1981';
```

32����ѯÿ�ſγ̵�ƽ���ɼ��������ƽ���ɼ��������У�ƽ���ɼ���ͬʱ�����γ̺Ž�������

```sql
Select CID,Avg(score) from SC group by CID order by Avg(score),CID DESC ;
```

33����ѯƽ���ɼ�����85������ѧ����ѧ�š�������ƽ���ɼ�

```sql
select Sname,SC.SID ,avg(score)
from Student,SC
where Student.SID=SC.SID group by SC.SID,Sname having avg(score)>85;
```

34����ѯ�γ�����Ϊ�����ݿ⡱���ҷ�������60��ѧ�������ͷ���

```sql
Select Sname,isnull(score,0)
from Student,SC,Course
where SC.SID=Student.SID and SC.CID=Course.CID and Course.Cname='���ݿ�'and score <60;
```

35����ѯ����ѧ����ѡ������� ��ѧ�ţ��������γ̱�ţ��γ����֣�

```sql
SELECT SC.SID,SC.CID,Sname,Cname
FROM SC,Student,Course
where SC.SID=Student.SID and SC.CID=Course.CID ;
```

36����ѯ�κ�һ�ſγ̳ɼ���70�����ϵ�ѧ�š��������γ̱�źͷ�����

```sql
SELECT distinct student.SID,student.Sname,SC.CID,SC.score
FROM student,Sc
WHERE SC.score>=70 AND SC.SID=student.SID;
```

37����ѯѧ��ѧ�ţ��Լ��䲻����Ŀγ̣������γ̺ŴӴ�С����

```sql
select sid,Cid from sc where score <60 order by CID ;
```

38����ѯ�γ̱��Ϊ003�ҿγ̳ɼ���80�����ϵ�ѧ����ѧ�ź�������

```sql
select SC.SID,Student.Sname from SC,Student where SC.SID=Student.SID and Score>80 and CID='003';
```

39����ѡ�˿γ̵�ѧ������

```sql
select count(*) from sc;
```

40����ѯѡ�ޡ�Ҷƽ����ʦ���ڿγ̵�ѧ���У��ɼ���ߵ�ѧ����������ɼ�

```sql
select Student.Sname,score
from Student,SC,CourseC,Teacher
where Student.SID=SC.SID and SC.CID=C.CID and C.TID=Teacher.TID and Teacher.Tname='Ҷƽ' and SC.score=(select max(score)from SC where CID=C.CID );
```

41����ѯ�����γ̼���Ӧ��ѡ������

```sql
select count(*) from sc group by CID;
```

42����ѯ��ͬ�γ̳ɼ���ͬ��ѧ����ѧ�š��γ̺š�ѧ���ɼ�

```sql
select distinct A.SID,B.score from SC A ,SC B where A.Score=B.Score and A.CID <>B.CID ;
```


43����ѯÿ�Ź��ɼ���õ�ǰ����

```sql
SELECT t1.SID as ѧ��ID,t1.CID as �γ�ID,Score as ����
FROM SC t1
WHERE score IN (SELECT TOP 2 score
                FROM SC
                WHERE t1.CID= CID
                ORDER BY score DESC
               )
ORDER BY t1.CID;
```

44��ͳ��ÿ�ſγ̵�ѧ��ѡ������������10�˵Ŀγ̲�ͳ�ƣ���Ҫ������γ̺ź�ѡ����������ѯ����������������У���ѯ����������������У���������ͬ�����γ̺���������

```sql
select CID as �γ̺�,count(*) as ����
from sc
group by CID
order by count(*) desc,Cid
```

45����������ѡ�����ſγ̵�ѧ��ѧ��

```sql
select SID
from sc
group by Sid
having count(*) > = 2
```

46����ѯȫ��ѧ����ѡ�޵Ŀγ̵Ŀγ̺źͿγ���

```sql
select CID,Cname
from Course
where CID in (select Cid from sc group by Cid)
```

47����ѯûѧ����Ҷƽ����ʦ���ڵ���һ�ſγ̵�ѧ������

```sql
select Sname from Student where SID not in (select SID from Course,Teacher,SC where Course.TID=Teacher.TID and SC.CID=course.CID and Tname='Ҷƽ');
```

48����ѯ�������ϲ�����γ̵�ͬѧ��ѧ�ż���ƽ���ɼ�

```sql
select SID,avg(isnull(score,0)) from SC where SID in (select SID from SC where score <60 group by SID having count(*)>2)group by SID;
```
