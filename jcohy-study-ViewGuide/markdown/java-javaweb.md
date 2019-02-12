
#  Java
> #### PS:�������С�������
> #### ������ҳ��[www.jcohy.com](http://www.jcohy.com)  	

>  �ҵ�ѧϰ�ʼǣ���¼ѧϰ�����еıʼ��Լ�����������,�Լ��ҵ�һЩ�����ܽᡣ�����������ʧЧ,������֪����������ݵ���������ύ Issues �������޸�������ݡ�

## javaWeb����
> * [XML�ĵ������м�����ʽ������֮���кα������𣿽���XML�ĵ����ļ��ַ�ʽ��](#javaweb-1)
> * [������Ŀ����Щ�ط��õ���XML��](#javaweb-2)
> * [����JDBC�������ݿ�Ĳ��衣](#javaweb-3)
> * [Statement��PreparedStatement��ʲô�����ĸ����ܸ��ã�](#javaweb-4)
> * [�ڽ������ݿ���ʱ�����ӳ���ʲô���ã�](#javaweb-5)
> * [ʲô��DAOģʽ��](#javaweb-6)
> * [�����ACID��ָʲô��](#javaweb-7)
> * [JDBC����ν���������](#javaweb-8)
> * [JDBC�ܷ���Blob��Clob��](#javaweb-9)
> * [����Servlet��CGI������?](#javaweb-10)
> * [Servlet�ӿ�������Щ������](#javaweb-11)
> * [JSP����Щ���ö������÷ֱ���ʲô��](#javaweb-12)
> * [get��post���������](#javaweb-13)
> * [���õ�Web����������Щ��](#javaweb-14)
> * [JSP��Servlet��ʲô��ϵ��](#javaweb-15)
> * [����JSP�е�����������](#javaweb-16)
> * [���ʵ��JSP��Servlet�ĵ��߳�ģʽ��](#javaweb-17)
> * [ʵ�ֻỰ���ٵļ�������Щ��](#javaweb-18)
> * [����������Щ���ú��÷���](#javaweb-19)
> * [����������Щ���ú��÷���](#javaweb-20)
> * [web.xml�ļ��п���������Щ���ݣ�](#javaweb-21)
> * [�����Ŀ��ʹ�ù���ЩJSTL��ǩ��](#javaweb-22)
> * [ʹ�ñ�ǩ����ʲô�ô�������Զ���JSP��ǩ��](#javaweb-23)
> * [˵һ�±��ʽ���ԣ�EL������ʽ����������](#javaweb-24)
> * [���ʽ���ԣ�EL��֧����Щ�������](#javaweb-25)
> * [Java Web������Model 1��Model 2�ֱ�ָ����ʲô��](#javaweb-26)
> * [Servlet 3�е��첽����ָ����ʲô��](#javaweb-27)
> * [����ڻ���Java��Web��Ŀ��ʵ���ļ��ϴ������أ�](#javaweb-28)
> * [�������յ��û��ύ�ı����ݣ������ǵ���Servlet��doGet()����doPost()������](#javaweb-29)
> * [JSP�еľ�̬�����Ͷ�̬������ʲô����](#javaweb-30)
> * [Servlet����λ�ȡ�û��ύ�Ĳ�ѯ����������ݣ�](#javaweb-31)
> * [Servlet����λ�ȡ�û����õĳ�ʼ�������Լ������������Ĳ�����](#javaweb-32)
> * [�����������ı����Լ���Ӧ���ݵ����ͣ�](#javaweb-33)
> * [����һ������Ӧ�õ�ģʽ�����ص㡣](#javaweb-34)
> * [ʲô��Web Service��Web���񣩣�](#javaweb-35)
> * [������ͣ�SOAP��WSDL��UDDI��](#javaweb-36)
> * [Java�淶�к�Web Service��صĹ淶����Щ��](#javaweb-37)
> * [����һ�����˽��Java�����Web Service��ܡ�](#javaweb-38)
> * [ת�����ض��������](#javaweb-39)
> * [session��cookie������](#javaweb-40)
> * [��η�ֹ���ظ��ύ](#javaweb-41)

<p id="javaweb-1">

#### XML�ĵ������м�����ʽ������֮���кα������𣿽���XML�ĵ����ļ��ַ�ʽ��
XML�ĵ������ΪDTD��Schema������ʽ�����߶��Ƕ�XML�﷨��Լ�����䱾����������Schema����Ҳ��һ��XML�ļ������Ա�XML���������������ҿ���ΪXML���ص����ݶ������ͣ�Լ��������֮DTD��ǿ�󡣶�XML�Ľ�����Ҫ��DOM���ĵ�����ģ�ͣ�Document Object Model����SAX��Simple API for XML����StAX��Java 6��������µĽ���XML�ķ�ʽ��Streaming API for XML��������DOM��������ļ�ʱ�������½��ķǳ������������������DOM���ṹռ�õ��ڴ�϶���ɵģ�����DOM������ʽ�����ڽ����ļ�֮ǰ�������ĵ�װ���ڴ棬�ʺ϶�XML��������ʣ����͵��ÿռ任ȡʱ��Ĳ��ԣ���SAX���¼������͵�XML������ʽ����˳���ȡXML�ļ�������Ҫһ��ȫ��װ�������ļ������������ļ���ͷ���ĵ����������߱�ǩ��ͷ���ǩ����ʱ�����ᴥ��һ���¼����û�ͨ���¼��ص�����������XML�ļ����ʺ϶�XML��˳����ʣ�����˼�壬StAX���ص�������ϣ�ʵ����StAX������������ʽ�ı������������Ӧ�ó����ܹ���XML��Ϊһ���¼�����������XML��Ϊһ���¼���������뷨������ӱ��SAX�����������ģ�������֮ͬ������StAX����Ӧ�ó���������Щ�¼�������������������ṩ�ڽ���������ʱ�ӽ������н����¼��Ĵ������


<p id="javaweb-2">
#### ������Ŀ����Щ�ط��õ���XML��

XML����Ҫ�������������棺���ݽ�������Ϣ���á��������ݽ���ʱ��XML�������ñ�ǩ��װ��������Ȼ��ѹ��������ܺ�ͨ�����紫�͸������ߣ����ս������ѹ�����ٴ�XML�ļ��л�ԭ�����Ϣ���д���
XML�������칹ϵͳ�佻�����ݵ���ʵ��׼��������ܼ����Ѿ���JSON��JavaScript Object Notation��ȡ����֮����Ȼ��Ŀǰ�ܶ������Ȼʹ��XML���洢������Ϣ�������ںܶ���Ŀ��ͨ��Ҳ�Ὣ��Ϊ������Ϣ��Ӳ����д��XML�ļ��У�Java�ĺܶ���Ҳ����ô���ģ�������Щ��ܶ�ѡ����dom4j��Ϊ����XML�Ĺ��ߣ���ΪSun��˾�Ĺٷ�APIʵ�ڲ���ô���á�
���䣺�����кܶ�ʱ�ֵ��������Sublime���Ѿ���ʼ�������ļ���д��JSON��ʽ�������Ѿ�ǿ�ҵĸ��ܵ�XML����һ���Ҳ���𽥱�ҵ��������

<p id="javaweb-3">
#### ����JDBC�������ݿ�Ĳ��衣

����Ĵ��������ӱ�����Oracle���ݿ�Ϊ������ʾJDBC�������ݿ�Ĳ��衣

```java
//1.����������
Class.forName("oracle.jdbc.driver.OracleDriver");

//2.�������ӡ�
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

//3.������䡣
PreparedStatement ps = con.prepareStatement("select * from emp where sal between ? and ?");
ps.setInt(1, 1000);
ps.setInt(2, 3000);

//4. ִ����䡣
ResultSet rs = ps.executeQuery();

//5.��������
while(rs.next()) {
    System.out.println(rs.getInt("empno") + " - " + rs.getString("ename"));
}

//6 �ر���Դ��
finally {
    if(con != null) {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

```

��ʾ���ر��ⲿ��Դ��˳��Ӧ�úʹ򿪵�˳���෴��Ҳ����˵�ȹر�ResultSet���ٹر�Statement���ڹر�Connection������Ĵ���ֻ�ر���Connection�����ӣ�����Ȼͨ��������ڹر�����ʱ�������ϴ��������ʹ򿪵��α�Ҳ��رգ������ܱ�֤������ˣ����Ӧ�ð��ող�˵��˳��ֱ�رա����⣬��һ������������JDBC 4.0���ǿ���ʡ�Եģ��Զ�����·���м������������������ǽ��鱣����

<p id="javaweb-4">
#### Statement��PreparedStatement��ʲô�����ĸ����ܸ��ã�

��Statement��ȣ���PreparedStatement�ӿڴ���Ԥ�������䣬����Ҫ���������ڿ��Լ���SQL�ı����������SQL�İ�ȫ�ԣ�����SQLע�乥���Ŀ����ԣ�����PreparedStatement�е�SQL����ǿ��Դ������ģ����������ַ�������ƴ��SQL�����鷳�Ͳ���ȫ���۵���������SQL��Ƶ��ִ����ͬ�Ĳ�ѯʱ��PreparedStatement�����Ե������ϵ����ƣ��������ݿ���Խ������Ż����SQL��仺���������´�ִ����ͬ�ṹ�����ʱ�ͻ�ܿ죨�����ٴα��������ִ�мƻ�����
���䣺Ϊ���ṩ�Դ洢���̵ĵ��ã�JDBC API�л��ṩ��CallableStatement�ӿڡ��洢���̣�Stored Procedure�������ݿ���һ��Ϊ������ض����ܵ�SQL���ļ��ϣ��������洢�����ݿ��У��û�ͨ��ָ���洢���̵����ֲ���������������ô洢���̴��в�������ִ��������Ȼ���ô洢���̻������翪������ȫ�ԡ������ϻ�úܶ�ô������Ǵ�������ײ����ݿⷢ��Ǩ��ʱ�ͻ��кܶ��鷳����Ϊÿ�����ݿ�Ĵ洢��������д�ϴ��ڲ��ٵĲ��

<p id="javaweb-5">
#### �ڽ������ݿ���ʱ�����ӳ���ʲô���ã�

���ڴ������Ӻ��ͷ����Ӷ��кܴ�Ŀ��������������ݿ���������ڱ���ʱ��ÿ�ν������Ӷ���Ҫ����TCP���������֣��ͷ�������Ҫ����TCP�Ĵ����֣���ɵĿ����ǲ��ɺ��ӵģ���Ϊ������ϵͳ�������ݿ�����ܣ��������ȴ������������������ӳ��У���Ҫʱֱ�Ӵ����ӳػ�ȡ��ʹ�ý���ʱ�黹���ӳض����عر����ӣ��Ӷ�����Ƶ���������ͷ���������ɵĿ��������ǵ��͵��ÿռ任ȡʱ��Ĳ��ԣ��˷��˿ռ�洢���ӣ�����ʡ�˴������ͷ����ӵ�ʱ�䣩���ػ�������Java�������Ǻܳ����ģ���ʹ���߳�ʱ�����̳߳صĵ��������ͬ������Java�Ŀ�Դ���ݿ����ӳ���Ҫ�У�C3P0��Proxool��DBCP��BoneCP��Druid�ȡ�
���䣺�ڼ����ϵͳ��ʱ��Ϳռ��ǲ��ɵ��͵�ì�ܣ������һ��������������Ҫ����㷨��������Ҫ�ġ�������վ�����Ż���һ���ؼ�����ʹ�û��棬����������潲�����ӳص���ǳ����ƣ�Ҳ��ʹ�ÿռ任ʱ��Ĳ��ԡ����Խ��ȵ��������ڻ����У����û���ѯ��Щ����ʱ����ֱ�Ӵӻ����еõ������������Ҳ���ȥ���ݿ��в�ѯ����Ȼ��������û����Ե�Ҳ���ϵͳ���ܲ�����ҪӰ�죬�����������������Ѿ�����������Ҫ�����ķ�Χ��

<p id="javaweb-6">
#### ʲô��DAOģʽ��

DAO��Data Access Object������˼����һ��Ϊ���ݿ�������־û������ṩ�˳���ӿڵĶ����ڲ���¶�ײ�־û�����ʵ��ϸ�ڵ�ǰ�����ṩ�˸������ݷ��ʲ�������ʵ�ʵĿ����У�Ӧ�ý����ж�����Դ�ķ��ʲ������г��󻯺��װ��һ������API�С��ó������������˵�����ǽ���һ���ӿڣ��ӿ��ж����˴�Ӧ�ó����н����õ����������񷽷��������Ӧ�ó����У�����Ҫ������Դ���н�����ʱ����ʹ������ӿڣ����ұ�дһ������������ʵ������ӿڣ����߼��ϸ����Ӧһ���ض������ݴ洢��DAOģʽʵ���ϰ���������ģʽ��һ��Data Accessor�����ݷ�������������Data Object�����ݶ��󣩣�ǰ��Ҫ�����η������ݵ����⣬������Ҫ�����������ö����װ���ݡ�

<p id="javaweb-7">
#### �����ACID��ָʲô��

- ԭ����(Atomic)�������и��������Ҫôȫ��Ҫôȫ�������κ�һ�������ʧ�ܶ��ᵼ�����������ʧ��

- һ����(Consistent)�����������ϵͳ״̬��һ�µģ�

- ������(Isolated)������ִ�е�����˴��޷������Է����м�״̬��

- �־���(Durable)��������ɺ������ĸĶ����ᱻ�־û�����ʹ���������Ե�ʧ�ܡ�ͨ����־��ͬ�����ݿ����ڹ��Ϸ������ؽ����ݡ�
  
���䣺���������������б��ʵ��ĸ����Ǻܸߵģ������ʵ�����Ҳ�Ǻܶ�ġ�������Ҫ֪�����ǣ�ֻ�д��ڲ������ݷ���ʱ����Ҫ���񡣵�����������ͬһ����ʱ�����ܻ����5�����⣬����3�����ݶ�ȡ���⣨����������ظ����ͻö�����2�����ݸ������⣨��1�ඪʧ���º͵�2�ඪʧ���£���

- �����Dirty Read����A�����ȡB������δ�ύ�����ݲ��ڴ˻����ϲ�������B����ִ�лع�����ôA��ȡ�������ݾ��������ݡ�

  | ʱ�� | ת������A                   | ȡ������B                |
  | ---- | --------------------------- | ------------------------ |
  | T1   |                             | ��ʼ����                 |
  | T2   | ��ʼ����                    |                          |
  | T3   |                             | ��ѯ�˻����Ϊ1000Ԫ     |
  | T4   |                             | ȡ��500Ԫ����޸�Ϊ500Ԫ |
  | T5   | ��ѯ�˻����Ϊ500Ԫ������� |                          |
  | T6   |                            | �����������ָ�Ϊ1000Ԫ |
  | T7   | ����100Ԫ������޸�Ϊ600Ԫ |                          |
  | T8   | �ύ����                   |                          |
  
- �����ظ�����Unrepeatable Read��������A���¶�ȡǰ���ȡ�������ݣ����ָ������Ѿ�����һ�����ύ������B�޸Ĺ��ˡ�


| ʱ�� | ת������A                   | ȡ������B                |
| ---- | --------------------------- | ------------------------ |
| T1   |                             | ��ʼ����                 |
| T2   | ��ʼ����                    |                          |
| T3   |                             | ��ѯ�˻����Ϊ1000Ԫ     |
| T4   |       ��ѯ�˻����Ϊ1000Ԫ                      |  |
| T5   |  |        ȡ��100Ԫ�޸����Ϊ900Ԫ                  |
| T6   |  |        �ύ����                  |
| T7   | ��ѯ�˻����Ϊ900Ԫ�������ظ����� |                          |

- �ö���Phantom Read��������A����ִ��һ����ѯ������һϵ�з��ϲ�ѯ�������У��������в����˱�����B�ύ���С�


| ʱ�� | ͳ�ƽ������A                   | ת������B                |
| ---- | --------------------------- | ------------------------ |
| T1   |                             | ��ʼ����                 |
| T2   | ��ʼ����                    |                          |
| T3   |  ͳ���ܴ��Ϊ10000Ԫ                           |     |
| T4   |                         | ����һ������˻�����100Ԫ |
| T5   |  |        �ύ����          |
| T6   |  |       �ٴ�ͳ���ܴ��Ϊ10100Ԫ���ö���                  |

- ��1�ඪʧ���£�����A����ʱ�����Ѿ��ύ������B�ĸ������ݸ����ˡ�


| ʱ�� | ȡ������A              | ת������B                |
| ---- | --------------------------- | ------------------------ |
| T1   |  ��ʼ����                           |                  |
| T2   |                     |    ��ʼ����                      |
| T3   |  ��ѯ�˻����Ϊ1000Ԫ                           |     |
| T4   |                         | ��ѯ�˻����Ϊ1000Ԫ |
| T5   |  |        ����100Ԫ�޸����Ϊ1100Ԫ          |
| T6   |  |       �ύ����                 |
| T7   |  ȡ��100Ԫ������޸�Ϊ900Ԫ|                        |
| T8   |  ��������|                        |
| T9   |  ���ָ�Ϊ1000Ԫ����ʧ���£�|                        |

- ��2�ඪʧ���£�����A��������B�Ѿ��ύ�����ݣ��������B�����Ĳ�����ʧ��


| ʱ�� | ת������A              | ȡ������B                |
| ---- | --------------------------- | ------------------------ |
| T1   |                             |     ��ʼ����             |
| T2   |       ��ʼ����              |                          |
| T3   |                             | ��ѯ�˻����Ϊ1000Ԫ    |
| T4   |         ��ѯ�˻����Ϊ1000Ԫ                |  |
| T5   |  |        ȡ��100Ԫ������޸�Ϊ900Ԫ          |
| T6   |  |       �ύ����                 |
| T7   |  ����100Ԫ������޸�Ϊ1100Ԫ|                        |
| T8   |  �ύ����|                        |
| T9   |  ��ѯ�˻����Ϊ1100Ԫ����ʧ���£�|                        |

���ݲ������������������⣬����Щ�����¿���������ģ�������Щ�����¿��ܾ��������ģ����ݿ�ͨ����ͨ����������������ݲ����������⣬����������ͬ���Է�Ϊ�������м���������������������ϵ���Է�Ϊ�������Ͷ�ռ������������ݴ�ҿ������в������Ͻ����˽⡣ֱ��ʹ�����Ƿǳ��鷳�ģ�Ϊ�����ݿ�Ϊ�û��ṩ���Զ������ƣ�ֻҪ�û�ָ���Ự��������뼶�����ݿ�ͻ�ͨ������SQL���Ȼ��Ϊ������ʵ���Դ���Ϻ��ʵ��������⣬���ݿ⻹��ά����Щ��ͨ�������ֶ����ϵͳ�����ܣ���Щ���û���˵����͸���ģ�����˵�㲻����⣬��ʵ����ȷʵҲ��֪������ANSI/ISO SQL 92��׼������4���ȼ���������뼶�����±���ʾ��

| ���뼶��        | ���   | �����ظ��� | �ö�   | ��һ�ඪʧ���� | �ڶ��ඪʧ���� |
| --------------- | ------ | ---------- | ------ | -------------- | -------------- |
| READ UNCOMMITED | ����   | ����       | ����   | ������         | ����           |
| READ COMMITTED  | ������ | ����       | ����   | ������         | ����           |
| REPEATABLE READ | ������ | ������     | ����   | ������         | ������         |
| SERIALIZABLE    | ������ | ������     | ������ |                | ������         |

��Ҫ˵�����ǣ�������뼶������ݷ��ʵĲ������Ƕ����ģ�������뼶��Խ�߲����Ծ�Խ�����Ҫ���ݾ����Ӧ����ȷ�����ʵ�������뼶������ط�û�����ܵ�ԭ��

<p id="javaweb-8">
#### JDBC����ν���������

Connection�ṩ��������ķ�����ͨ������setAutoCommit(false)���������ֶ��ύ���񣻵�������ɺ���commit()��ʽ�ύ�������������������з����쳣��ͨ��rollback()��������ع�������֮�⣬��JDBC 3.0�л�������Savepoint������㣩�ĸ������ͨ���������ñ���㲢������ع���ָ���ı���㡣
  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/2.jpg)

<p id="javaweb-9">
#### JDBC�ܷ���Blob��Clob��

Blob��ָ�����ƴ����Binary Large Object������Clob��ָ���ַ�����Character Large Objec�����������Blob��Ϊ�洢��Ķ��������ݶ���Ƶģ���Clob��Ϊ�洢����ı����ݶ���Ƶġ�JDBC��PreparedStatement��ResultSet���ṩ����Ӧ�ķ�����֧��Blob��Clob����������Ĵ���չʾ�����ʹ��JDBC����LOB�� 

������MySQL���ݿ�Ϊ��������һ�����������ֶε��û���������ţ�id����������name������Ƭ��photo��������������£�

```sql
create table tb_user
(
id int primary key auto_increment,
name varchar(20) unique not null,
photo longblob
);
```

�����Java���������ݿ��в���һ����¼��

```java
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
class JdbcLobTest {
    public static void main(String[] args) {
        Connection con = null;
        try {
            // 1. ����������Java6���ϰ汾����ʡ�ԣ�
            Class.forName("com.mysql.jdbc.Driver");
            // 2. ��������
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            // 3. ����������
            PreparedStatement ps = con.prepareStatement("insert into tb_user values (default, ?, ?)");
            ps.setString(1, "���"); // ��SQL����е�һ��ռλ�������ַ���
            try (InputStream in = new FileInputStream("test.jpg")) { // Java 7��TWR
                ps.setBinaryStream(2, in); // ��SQL����еڶ���ռλ�����ɶ�������
                // 4. ����SQL�������Ӱ������
                System.out.println(ps.executeUpdate() == 1 ? "����ɹ�" : "����ʧ��");
            } catch(IOException e) {
                System.out.println("��ȡ��Ƭʧ��!");
            }
        } catch (ClassNotFoundException | SQLException e) { // Java 7�Ķ��쳣����
            e.printStackTrace();
        } finally { // �ͷ��ⲿ��Դ�Ĵ��붼Ӧ������finally�б�֤���ܹ��õ�ִ��
            try {
                if(con != null && !con.isClosed()) {
                    con.close(); // 5. �ͷ����ݿ�����
                    con = null; // ָʾ�������������Ի��ոö���
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```

<p id="javaweb-10">

#### ����Servlet��CGI������?

Servlet��CGI����������Servlet���ڷ����������У���ͨ�����̷߳�ʽ������service()������һ��ʵ�����Է����ڶ�����󣬲�����ʵ��һ�㲻�����٣���CGI��ÿ�����󶼲����µĽ��̣�������ɺ�����٣�����Ч���ϵ���Servlet��
���䣺Sun Microsystems��˾��1996�귢��Servlet��������Ϊ�˺�CGI���о�����Servlet��һ�������Java����һ������Java��WebӦ��ͨ������һ������Servlet�ࡣServlet���ܹ����д�����ִ�У�������Servlet���������еģ��������û������󴫵ݸ�Servlet���򣬲���Servlet����Ӧ�ش����û���ͨ��һ��Servlet�����һ������JSPҳ�档��ǰCGI������Ϊ���ܿ����ϵ����ⱻڸ����Ȼ��Fast CGI����Ѿ������CGIЧ���ϵ����⣬�������Ե�ʱ���ɲ����ſڿ��ӵ�ڸ��CGI����ʵ���кܶ�����Ϥ����վ��ʹ����CGI������

<p id="javaweb-11">

#### Servlet�ӿ�������Щ������

Servlet�ӿڶ�����5������������ǰ����������Servlet����������أ� 

- void init(ServletConfig config) throws ServletException 

- void service(ServletRequest req, ServletResponse resp) throws ServletException, java.io.IOException

- void destory() - java.lang.String getServletInfo() - ServletConfig getServletConfig()

Web��������Servlet������ʵ������Servlet�������ڿ�ʼ������������init()��������Servlet�ĳ�ʼ�������󵽴�ʱ����Servlet��service()������service()�����������Ҫ�����������Ӧ��doGet��doPost�ȷ��������������رջ���Ŀ��ж��ʱ�������ὫServletʵ�����٣���ʱ�����Servlet��destroy()������

<p id="javaweb-12">

#### JSP����Щ���ö������÷ֱ���ʲô��
JSP��9�����ö���
- request����װ�ͻ��˵��������а�������GET��POST����Ĳ�����
- response����װ�������Կͻ��˵���Ӧ��
- pageContext��ͨ���ö�����Ի�ȡ��������
- session����װ�û��Ự�Ķ���
- application����װ���������л����Ķ���
- out�������������Ӧ�����������
- config��WebӦ�õ����ö���
- page��JSPҳ�汾���൱��Java�����е�this����
- exception����װҳ���׳��쳣�Ķ���
  ���䣺�����Servlet��������ҳ�еĶ�̬���������Ƿǳ������Ĺ�������һ���棬���е��ı���HTML��ǩ����Ӳ���룬��ʹ����΢С���޸ģ�����Ҫ�������±��롣JSP�����Servlet����Щ���⣬����Servlet�ܺõĲ��䣬����ר������Ϊ�û�������ͼ��View������Servlet��Ϊ��������Controller��ר�Ÿ������û�����ת�����ض���ĳ��ҳ�档����Java��Web�����ܶ඼ͬʱʹ����Servlet��JSP��JSPҳ����ʵ��һ��Servlet���ܹ�����Servlet�ķ�������Servlet������ͨ��Ҳ��JSP�����������ṩJSPҳ������л�����Tomcat����һ��Servlet/JSP��������һ������һ��JSPҳ��ʱ��Servlet/JSP�������Ƚ�JSPҳ��ת����һ��JSPҳ���ʵ���࣬����һ��ʵ����JspPage�ӿڻ����ӽӿ�HttpJspPage��Java�ࡣJspPage�ӿ���Servlet���ӽӿڣ����ÿ��JSPҳ�涼��һ��Servlet��ת���ɹ������������Servlet�֮࣬���������غ�ʵ����Java�ֽ��룬��ִ����ͨ����Servlet�������������ڲ�������ͬһ��JSPҳ��ĺ�������������鿴���JSPҳ���Ƿ��޸Ĺ�������޸Ĺ��ͻ�����ת�������±��벢ִ�С����û����ִ���ڴ����Ѿ����ڵ�Servletʵ�������ǿ��Կ�һ��JSP�����Ӧ��Java�����֪��һ���ˣ�����9�����ö����������ɴҲ�ᱻ�ҿ���
  JSPҳ�棺
```jsp
<%@ page pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>��ҳ</title>
        <style type="text/css">
            * { font-family: "Arial"; }
        </style>
    </head>
    <body>
        <h1>Hello, World!</h1>
        <hr/>
        <h2>Current time is: <%= new java.util.Date().toString() %></h2>
    </body>
</html>
```


��Ӧ��Java���룺
```java
/*
* Generated by the Jasper component of Apache Tomcat
* Version: Apache Tomcat/7.0.52
* Generated at: 2014-10-13 13:28:38 UTC
* Note: The last modified time of this file was set to
* the last modified time of the source file after
* generation to assist with modification tracking.
*/
package org.apache.jsp;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
implements org.apache.jasper.runtime.JspSourceDependent {
private static final javax.servlet.jsp.JspFactory _jspxFactory =javax.servlet.jsp.JspFactory.getDefaultFactory();
private static java.util.Map<java.lang.String, java.lang.Long> _jspx_dependants;
private javax.el.ExpressionFactory _el_expressionfactory;
private org.apache.tomcat.InstanceManager _jsp_instancemanager;
public java.util.Map<java.lang.String, java.lang.Long> getDependants() {
return _jspx_dependants;
}
public void _jspInit() {
_el_expressionfactory = _jspxFactory.getJspApplicationContext(
getServletConfig().getServletContext()).getExpressionFactory();
_jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory
.getInstanceManager(getServletConfig());
}
public void _jspDestroy() {
}
public void _jspService(
final javax.servlet.http.HttpServletRequest request,
final javax.servlet.http.HttpServletResponse response)
throws java.io.IOException, javax.servlet.ServletException {
// ���ö�����������ﶨ���
final javax.servlet.jsp.PageContext pageContext;
javax.servlet.http.HttpSession session = null;
final javax.servlet.ServletContext application;
final javax.servlet.ServletConfig config;
javax.servlet.jsp.JspWriter out = null;
final java.lang.Object page = this;
javax.servlet.jsp.JspWriter _jspx_out = null;
javax.servlet.jsp.PageContext _jspx_page_context = null;
try {
response.setContentType("text/html;charset=UTF-8");
pageContext = _jspxFactory.getPageContext(this, request, response,
null, true, 8192, true);
_jspx_page_context = pageContext;
application = pageContext.getServletContext();
config = pageContext.getServletConfig();
session = pageContext.getSession();
out = pageContext.getOut();
_jspx_out = out;
out.write('\r');
out.write('\n');
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
// ���´���ͨ���������HTML��ǩ������������
out.write("\r\n");
out.write("\r\n");
out.write("<!DOCTYPE html>\r\n");
out.write("<html>\r\n");
out.write(" <head>\r\n");
out.write(" <base href=\"");
out.print(basePath);
out.write("\">\r\n");
out.write(" <title>��ҳ</title>\r\n");
out.write(" <style type=\"text/css\">\r\n");
out.write(" \t* { font-family: \"Arial\"; }\r\n");
out.write(" </style>\r\n");
out.write(" </head>\r\n");
out.write(" \r\n");
out.write(" <body>\r\n");
out.write(" <h1>Hello, World!</h1>\r\n");
out.write(" <hr/>\r\n");
out.write(" <h2>Current time is: ");
out.print(new java.util.Date().toString());
out.write("</h2>\r\n");
out.write(" </body>\r\n");
out.write("</html>\r\n");
} catch (java.lang.Throwable t) {
if (!(t instanceof javax.servlet.jsp.SkipPageException)) {
out = _jspx_out;
if (out != null && out.getBufferSize() != 0)
try {
out.clearBuffer();
} catch (java.io.IOException e) {
}
if (_jspx_page_context != null)
_jspx_page_context.handlePageException(t);
else
throw new ServletException(t);
}
} finally {
_jspxFactory.releasePageContext(_jspx_page_context);
}
}
}
```

<p id="javaweb-13">

#### get��post���������

- get���������ӷ������ϻ����Դ����post��������������ύ���ݣ� 

- get���������ݰ���name=value����ʽ����ӵ�action ��ָ���URL ���棬��������ʹ��"?"���ӣ�����������֮��ʹ��"&"���ӣ�post�ǽ����е����ݷ���HTTPЭ�������ͷ����Ϣ���У����ݵ�action��ָ��URL�� 
- get���������Ҫ�ܵ�URL�������ƣ�1024�ֽڣ�����post���Դ�����������ݣ��ϴ��ļ�ͨ��Ҫʹ��post��ʽ�� 
- ʹ��getʱ��������ʾ�ڵ�ַ���ϣ������Щ���ݲ����������ݣ���ô����ʹ��get�������������ݻ���Ӧ��ʹ��post�� 
- getʹ��MIME����application/x-www-form-urlencoded��URL���루Ҳ�аٷֺű��룩�ı��ĸ�ʽ���ݲ�������֤�����͵Ĳ�������ѭ�淶���ı���ɣ�����һ���ո�ı�����"%20"��

<p id="javaweb-14">

#### ���õ�Web����������Щ��

Unix��Linuxƽ̨��ʹ����㷺�����HTTP��������Apache����������Windowsƽ̨�ķ�����ͨ��ʹ��IIS��ΪWeb��������ѡ��Web������Ӧ���ǵ������У����ܡ���ȫ�ԡ���־��ͳ�ơ�����������������������������ͼ���Ӧ�ó���ȡ������ǶԳ����������ļ�飺

- IIS��Microsoft��Web��������Ʒ��ȫ����Internet Information Services��IIS�������ڹ���Intranet��Internet�Ϸ�����Ϣ��Web��������IIS��Ŀǰ�����е�Web��������Ʒ֮һ���ܶ���������վ���ǽ�����IIS��ƽ̨�ϡ�IIS�ṩ��һ��ͼ�ν���Ĺ����ߣ���ΪInternet����������������ڼ������úͿ���Internet����IIS��һ��Web������������а���Web��������FTP��������NNTP��������SMTP���������ֱ�������ҳ������ļ����䡢���ŷ�����ʼ����͵ȷ��棬��ʹ�������磨�����������;��������Ϸ�����Ϣ����һ�������׵��¡����ṩISAPI(Intranet Server API����Ϊ��չWeb���������ܵı�̽ӿڣ�ͬʱ�������ṩһ��Internet���ݿ�������������ʵ�ֶ����ݿ�Ĳ�ѯ�͸��¡�
- Kangle��Kangle Web��������һ���ƽ̨������ǿ�󡢰�ȫ�ȶ����ײ����ĸ�����Web�������ͷ�������������������⣬KangleҲ��һ��רΪ�����������з���Web��������ʵ�����������������̡�����������С��û�֮�䰲ȫ���룬һ���û������ⲻӰ�������û���֧��PHP��ASP��ASP.NET��Java��Ruby�ȶ��ֶ�̬�������ԡ�- WebSphere��WebSphere Application Server�ǹ������ơ����ŵ�WebӦ�ó������������IBM��������ƻ��ĺ��Ĳ��֣����ǻ���Java��Ӧ�û��������ڽ���������͹���Internet��Intranet WebӦ�ó�����Ӧ����WebӦ�ó������������Ҫ��
- WebLogic��WebLogic Server��һ��๦�ܡ����ڱ�׼��WebӦ�÷�������Ϊ��ҵ������ҵӦ���ṩ�˼�ʵ�Ļ�������Ը���Ӧ�ÿ������ؼ�������Ĳ��𣬸���ϵͳ�����ݿ�ļ��ɡ���InternetЭ����Weblogic���ṩ����Ӧ��֧�֡�����������ȫ��Ĺ��ܡ��Կ��ű�׼������ԡ����ܹ���֧�ֻ�������Ŀ��������ƣ��ܶ๫˾����ҵ��Ӧ�ö�ѡ��������Ϊ�����Ͳ���Ļ�����WebLogic Server��ʹӦ�÷�������Ϊ��ҵӦ�üܹ��Ļ�������һֱ�������ȵ�λ��Ϊ�������ɻ�����ҵ��Ӧ���ṩ���ȹ̵Ļ�����
- Apache��ĿǰApache��Ȼ���������õ�����Web�����������г�ռ���ʺܳ�ʱ�䶼������60%���ϣ�Ŀǰ���г��ݶ�Լ40%���ң��������Ϻܶ���������վ����Apache�Ĳ�����ĳɹ�֮����Ҫ��������Դ���뿪�š���һ֧ǿ��Ŀ����Ŷӡ�֧�ֿ�ƽ̨��Ӧ�ã����������ڼ������е�Unix��Windows��Linuxϵͳƽ̨�ϣ��Լ����Ŀ���ֲ�Եȷ��档
- Tomcat��Tomcat��һ������Դ���롢����Servlet��JSP��������Tomcatʵ����Servlet��JSP�淶�����⣬Tomcat��ʵ����Apache-Jakarta�淶���ұȾ��������ҵӦ�����������Ҫ�ã����ĿǰҲ�в��ٵ�Web��������ѡ����Tomcat��
- Nginx������"engine x"����һ�������ܵ�HTTP�ͷ�������������Ҳ��һ��IMAP/POP3/SMTP�����������Nginx����Igor SysoevΪ����˹�������ڶ���Ramblerվ�㿪���ģ���һ�������汾0.1.0������2004��10��4�ա��佫Դ��������BSD���֤����ʽ�������������ȶ��ԡ��ḻ�Ĺ��ܼ���ʾ�������ļ��͵�ϵͳ��Դ�����Ķ���������2014���°��꣬Nginx���г��ݶ�ﵽ��14%��

<p id="javaweb-15">

#### JSP��Servlet��ʲô��ϵ��

��ʵ��������������Ѿ��������ˣ�Servlet��һ�������Java�����������ڷ�������JVM�У��ܹ�������������֧����������ṩ��ʾ���ݡ�JSP��������Servlet��һ�ּ�����ʽ��JSP�ᱻ�����������һ��������Servlet��Java���򣬿��Լ�ҳ�����ݵ����ɡ�Servlet��JSP����Ҫ�Ĳ�ͬ�����ڣ�Servlet��Ӧ���߼�����Java�ļ��У�������ȫ�ӱ�ʾ���е�HTML���뿪������JSP�������Java��HTML������ϳ�һ����չ��Ϊ.jsp���ļ�������˵��Servlet������Java��дHTML����JSP������HTML��дJava���룬��Ȼ���˵���Ǻ�Ƭ���Ҳ���׼ȷ�ġ�JSP��������ͼ��Servlet�������ڿ����߼�����MVC�ܹ�ģʽ�У�JSP�ʺϳ䵱��ͼ��view����Servlet�ʺϳ䵱��������controller����

<p id="javaweb-16">

#### ����JSP�е�����������

JSP�е��������������page��request��session��application��������˵��

- page������һ��ҳ����صĶ�������ԡ�

- request������Web�ͻ���������һ��������صĶ�������ԡ�һ��������ܿ�Խ���ҳ�棬�漰���Web�������Ҫ��ҳ����ʾ����ʱ���ݿ������ڴ�������

- session������ĳ���û��������������һ�λỰ��صĶ�������ԡ���ĳ���û���ص�����Ӧ�÷����û��Լ���session�С�

- application����������WebӦ�ó�����صĶ�������ԣ���ʵ�����ǿ�Խ����WebӦ�ó��򣬰������ҳ�桢����ͻỰ��һ��ȫ��������

<p id="javaweb-17">

#### ���ʵ��JSP��Servlet�ĵ��߳�ģʽ��

����JSPҳ�棬����ͨ��pageָ��������á�
```jsp
<%@page isThreadSafe=��false��%>
```

����Servlet���������Զ����Servletʵ��SingleThreadModel��ʶ�ӿڡ�
˵���������JSP��Servlet���óɵ��̹߳���ģʽ���ᵼ��ÿ�����󴴽�һ��Servletʵ��������ʵ�����������ص��������⣨���������ڴ�ѹ���ܴ󣬻��ᵼ��Ƶ�����������գ�������ͨ������²�������ô����

<p id="javaweb-18">

#### ʵ�ֻỰ���ٵļ�������Щ��

����HTTPЭ�鱾������״̬�ģ�������Ϊ�����ֲ�ͬ���û�������Ҫ���û��Ự���и��٣��򵥵�˵����Ϊ�û����еǼǣ�Ϊ�û�����Ψһ��ID����һ���û��������а�����ID���������ݴ��жϵ�������һ���û���

- URL ��д����URL������û��Ự����Ϣ��Ϊ����Ĳ��������߽�Ψһ�ĻỰID��ӵ�URL��β�Ա�ʶһ���Ự��

- ���ñ������򣺽��ͻỰ������ص��ֶ���ӵ���ʽ�����У���Щ��Ϣ���������������ʾ�����ύ��ʱ���ύ���������������ַ�ʽ���Ѵ����Խ���ҳ�����Ϣ���ݣ���Ϊ���ÿ�ζ�Ҫ�޸�URL����ҳ���������ʽ�������洢�û��Ự�����Ϣ�����齫��÷ǳ��鷳��

- cookie��cookie�����֣�һ���ǻ��ڴ��ڵģ���������ڹرպ�cookie��û���ˣ���һ���ǽ���Ϣ�洢��һ����ʱ�ļ��У������ô��ڵ�ʱ�䡣���û�ͨ��������ͷ���������һ�λỰ�󣬻ỰID�ͻ�����Ӧ��Ϣ���ش洢�ڻ��ڴ��ڵ�cookie�У��Ǿ���ζ��ֻҪ�����û�йرգ��Ựû�г�ʱ����һ������ʱ����ỰID�ֻ��ύ���������÷�����ʶ���û���ݡ��Ự�п���Ϊ�û�������Ϣ���Ự�������ڷ������ڴ��еģ������ڴ��ڵ�cookie���ڿͻ����ڴ��еġ���������������cookie����ô����Ҫͨ���������ַ�ʽ���лỰ���١���Ȼ����ʹ��cookieʱҪע�⼸�㣺���Ȳ�Ҫ��cookie�д��������Ϣ�����cookie�洢�����������ޣ�4k�������ܽ���������ݴ洢cookie�У����������ͨ��ֻ����һ��վ�������20��cookie����Ȼ�����û��Ự��ص�������Ϣ�����˻ỰID��Ҳ���Դ���cookie������лỰ���١�

- HttpSession�������лỰ���ټ����У�HttpSession��������ǿ��Ҳ�ǹ������ġ���һ���û���һ�η���ĳ����վʱ���Զ�����HttpSession��ÿ���û����Է������Լ���HttpSession������ͨ��HttpServletRequest�����getSession�������HttpSession��ͨ��HttpSession��setAttribute�������Խ�һ��ֵ����HttpSession�У�ͨ������HttpSession�����getAttribute������ͬʱ�����������Ϳ��Ի�ȡ������HttpSession�еĶ������������ַ�ʽ��ͬ���ǣ�HttpSession���ڷ��������ڴ��У���˲�Ҫ������Ķ���������棬��ʹĿǰ��Servlet�����������ڴ潫��ʱ��HttpSession�еĶ����Ƶ������洢�豸�У����������Ʊ�Ӱ�����ܡ���ӵ�HttpSession�е�ֵ����������Java��������������ʵ����Serializable�ӿڣ�����Servlet�����ڱ�Ҫ��ʱ����Խ������л����ļ��У����������л�ʱ�ͻ�����쳣��

  **���䣺**HTML5�п���ʹ��Web Storage����ͨ��JavaScript���������ݣ��������ʹ��localStorage��sessionStorage�������û��Ự����Ϣ��Ҳ�ܹ�ʵ�ֻỰ����

<p id="javaweb-19">

#### ����������Щ���ú��÷���

Java Web�����еĹ�������filter���Ǵ�Servlet 2.3�淶��ʼ���ӵĹ��ܣ�����Servlet 2.4�淶�еõ���ǿ����WebӦ����˵����������һ��פ���ڷ������˵�Web����������Խ�ȡ�ͻ��˺ͷ�����֮�����������Ӧ��Ϣ��������Щ��Ϣ���й��ˡ���Web�������ܵ�һ������Դ������ʱ�������ж��Ƿ��й������������Դ�����������У���ô�����������󽻸����������д����ڹ������У�����Ըı���������ݣ�����������������ı�ͷ��Ϣ��Ȼ���ٽ������͸�Ŀ����Դ����Ŀ����Դ������������Ӧʱ������ͬ���Ὣ��Ӧ��ת�������������ڹ�����������Զ���Ӧ�����ݽ���ת����Ȼ���ٽ���Ӧ���͵��ͻ��ˡ�
�����Ĺ�������;��Ҫ���������û��������ͳһ��֤�����û��ķ���������м�¼����ˡ����û����͵����ݽ��й��˻��滻��ת��ͼ���ʽ������Ӧ���ݽ���ѹ���Լ��ٴ����������������Ӧ���мӽ��ܴ���������Դ�����¼�����XML�����Ӧ��XSLT�ȡ�
�͹�������صĽӿ���Ҫ�У�Filter��FilterConfig��FilterChain��
��������������ӣ�
```java
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(urlPatterns = { "*" },
           initParams = {@WebInitParam(name="encoding", value="utf-8")})
public class CodingFilter implements Filter {
    private String defaultEncoding = "utf-8";
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding(defaultEncoding);
        resp.setCharacterEncoding(defaultEncoding);
        chain.doFilter(req, resp);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        String encoding = config.getInitParameter("encoding");
        if (encoding != null) {
            defaultEncoding = encoding;
        }
    }
}
```

���ؼ��������������ӣ�
```java
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
@WebFilter(urlPatterns = {"/*"})
public class DownloadCounterFilter implements Filter {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Properties downloadLog;
    private File logFile;
    @Override
    public void destroy() {
        executorService.shutdown();
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        final String uri = request.getRequestURI();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String value = downloadLog.getProperty(uri);
                if(value == null) {
                    downloadLog.setProperty(uri, "1");
                }
                else {
                    int count = Integer.parseInt(value);
                    downloadLog.setProperty(uri, String.valueOf(++count));
                }
                try {
                    downloadLog.store(new FileWriter(logFile), "");
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        chain.doFilter(req, resp);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        String appPath = config.getServletContext().getRealPath("/");
        logFile = new File(appPath, "downloadLog.txt");
        if(!logFile.exists()) {
            try {
                logFile.createNewFile();
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
        downloadLog = new Properties();
        try {
            downloadLog.load(new FileReader(logFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

˵��������ʹ����Servlet 3�淶�е�ע�����������������ȻҲ������web.xml��ʹ��<filter>��<filter-mapping>��ǩ�����������

<p id="javaweb-20">

#### ����������Щ���ú��÷���

Java Web�����еļ�������listener������application��session��request�������󴴽������ٻ�������������޸�ɾ������ʱ�Զ�ִ�д���Ĺ��������������ʾ��

1. ServletContextListener����Servlet�����ĵĴ��������ٽ��м�����

2. ServletContextAttributeListener������Servlet���������Ե���ӡ�ɾ�����滻��

3. HttpSessionListener����Session�Ĵ��������ٽ��м�����
  ���䣺session�����������������

    -  session��ʱ��������web.xml��ͨ��<session-config>/<session-timeout>��ǩ���ó�ʱʱ�䣩��

    -  ͨ������session�����invalidate()����ʹsessionʧЧ��

4. HttpSessionAttributeListener����Session���������Ե���ӡ�ɾ�����滻���м�����

5. ServletRequestListener�����������ĳ�ʼ�������ٽ��м�����

6. ServletRequestAttributeListener��������������Ե���ӡ�ɾ�����滻���м�����

   ������һ��ͳ����վ����������������������ӣ�

```java
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/** �����ļ��������ڷ���������ʱ��ʼ��onLineCount��maxOnLineCount�����������������ڷ����������ģ�ServletContext���У����ʼֵ����0
*/
@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent evt) {
    }
    @Override
    public void contextInitialized(ServletContextEvent evt) {
        evt.getServletContext().setAttribute("onLineCount", 0);
        evt.getServletContext().setAttribute("maxOnLineCount", 0);
    }
}
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
�Ự�����������û��Ự���������ٵ�ʱ���������޸�onLineCount��maxOnLineCount��ֵ
*/
@WebListener
public class MaxCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        ServletContext ctx = event.getSession().getServletContext();
        int count = Integer.parseInt(ctx.getAttribute("onLineCount").toString());
        count++;
        ctx.setAttribute("onLineCount", count);
        int maxOnLineCount = Integer.parseInt(ctx.getAttribute("maxOnLineCount").toString());
        if (count > maxOnLineCount) {
            ctx.setAttribute("maxOnLineCount", count);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ctx.setAttribute("date", df.format(new Date()));
        }
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        ServletContext app = event.getSession().getServletContext();
        int count = Integer.parseInt(app.getAttribute("onLineCount").toString());
        count--;
        app.setAttribute("onLineCount", count);
    }
}
```

˵��������ʹ����Servlet 3�淶�е�@WebListenerע�����ü���������Ȼ�������web.xml�ļ�����<listener>��ǩ���ü�������

<p id="javaweb-21">

#### web.xml�ļ��п���������Щ���ݣ�

web.xml��������WebӦ�õ������Ϣ���磺��������listener������������filter����Servlet����ز������Ự��ʱʱ�䡢��ȫ��֤��ʽ������ҳ��ȣ�������һЩ�����г��������ã�

```xml
<--����Spring�����ļ��ؼ���������Spring�����ļ�������IoC������-->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<listener>
    <listener-class>
        org.springframework.web.context.ContextLoaderListener
    </listener-class>
</listener>
    
<--����Spring��OpenSessionInView������������ӳټ��غ�Hibernate�Ự�رյ�ì�ܣ�-->
<filter>
    <filter-name>openSessionInView</filter-name>
    <filter-class>
        org.springframework.orm.hibernate3.support.OpenSessionInViewFilter
    </filter-class>
</filter>
<filter-mapping>
    <filter-name>openSessionInView</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
    
<--���ûỰ��ʱʱ��Ϊ10���ӣ�-->
<session-config>
    <session-timeout>10</session-timeout>
</session-config>
    
<--����404��Exception�Ĵ���ҳ�棺-->
<error-page>
    <error-code>404</error-code>
    <location>/error.jsp</location>
</error-page>
<error-page>
    <exception-type>java.lang.Exception</exception-type>
    <location>/error.jsp</location>
</error-page>
    
<--���ð�ȫ��֤��ʽ��-->
<security-constraint>
    <web-resource-collection>
        <web-resource-name>ProtectedArea</web-resource-name>
        <url-pattern>/admin/*</url-pattern>
        <http-method>GET</http-method>
        <http-method>POST</http-method>
    </web-resource-collection>
    <auth-constraint>
        <role-name>admin</role-name>
    </auth-constraint>
</security-constraint>
<login-config>
    <auth-method>BASIC</auth-method>
</login-config>
<security-role>
    <role-name>admin</role-name>
</security-role>
```

˵������Servlet��С���񣩡�Listener������������Filter������������Web��������ã�Servlet 3�淶�ṩ�˻���ע������÷�ʽ�����Էֱ�ʹ��@WebServlet��@WebListener��@WebFilterע��������á����䣺���Web�ṩ���м�ֵ����ҵ��Ϣ�������������ݣ���ôվ��İ�ȫ�Ծ��Ǳ��뿼�ǵ����⡣��ȫ��֤��ʵ�ְ�ȫ�Ե���Ҫ�ֶΣ���֤����Ҫ�����Are you who you say you are?�������⡣��֤�ķ�ʽ�ǳ��࣬��˵�����Է�Ϊ���ࣺ

 A. What you know? ? ���� 

B. What you have? ? ����֤�飨U�ܡ��ܱ�����

C. Who you are? ?ָ��ʶ�𡢺�Ĥʶ�� ��Tomcat�п���ͨ��������ȫ�׽��ֲ㣨Secure Socket Layer, SSL���Լ�ͨ��������֤�����֤��ʵ�ֶ԰�ȫ�Ե�֧�֡�

<p id="javaweb-22">

#### �����Ŀ��ʹ�ù���ЩJSTL��ǩ��

��Ŀ����Ҫʹ����JSTL�ĺ��ı�ǩ�⣬����<c:if>��<c:choose>��<c: when>��<c: otherwise>��<c:forEach>�ȣ���Ҫ���ڹ���ѭ���ͷ�֧�ṹ�Կ�����ʾ�߼���
˵������ȻJSTL��ǩ���ṩ��core��sql��fmt��xml�ȱ�ǩ�⣬����ʵ�ʿ����н���ֻʹ�ú��ı�ǩ�⣨core�����������ֻʹ�÷�֧��ѭ����ǩ�����Ա��ʽ���ԣ�EL��������������������������ʾ��ҵ���߼��ķ��룬��������ʵ����

<p id="javaweb-23">

#### ʹ�ñ�ǩ����ʲô�ô�������Զ���JSP��ǩ��

- ����JSPҳ������ݺ��߼�������Web������

- �����߿��Դ����Զ����ǩ����װҵ���߼�����ʾ�߼���

- ��ǩ���кܺõĿ���ֲ�ԡ���ά���ԺͿ������ԣ� 

- �����˶�Scriptlet��С�ű�����ʹ�ã��ܶ๫˾����Ŀ��������������JSP����дС�ű���

�Զ���JSP��ǩ�������¼������裺

1. ��дһ��Java��ʵ��ʵ��Tag/BodyTag/IterationTag�ӿڣ�������ͨ����ֱ��ʵ����Щ�ӿڶ��Ǽ̳�TagSupport/BodyTagSupport/SimpleTagSupport�࣬���Ƕ�ȱʡ����ģʽ��Ӧ�ã�

2. ��дdoStartTag()��doEndTag()�ȷ����������ǩҪ��ɵĹ���

3. ��д��չ��Ϊtld�ı�ǩ�����ļ����Զ����ǩ���в���tld�ļ�ͨ������WEB-INF�ļ����»�����Ŀ¼��- ��JSPҳ����ʹ��taglibָ�����øñ�ǩ�⡣


������һ���Զ����ǩ������ӡ�
����1 - ��ǩ��Դ����TimeTag.java��

```java
package com.jackfrued.tags;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
public class TimeTag extends TagSupport {
    private static final long serialVersionUID = 1L;
    private String format = "yyyy-MM-dd hh:mm:ss";
    private String foreColor = "black";
    private String backColor = "white";
    public int doStartTag() throws JspException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        JspWriter writer = pageContext.getOut();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<span style='color:%s;background-color:%s'>%s</span>",
                                foreColor, backColor, sdf.format(new Date())));
        try {
            writer.print(sb.toString());
        } catch(IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public void setForeColor(String foreColor) {
        this.foreColor = foreColor;
    }
    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }
}
```
����2 - ��д��ǩ�������ļ�my.tld��

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<taglib xmlns="http://java.sun.com/xml/ns/j2ee"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
                            http://java.sun.com/xml/ns/j2ee/web-jsptaglibrary_2_0.xsd"
        version="2.0">
    <description>�����ǩ��</description>
    <tlib-version>1.0</tlib-version>
    <short-name>MyTag</short-name>
    <tag>
        <name>time</name>
        <tag-class>com.jackfrued.tags.TimeTag</tag-class>
        <body-content>empty</body-content>
        <attribute>
            <name>format</name>
            <required>false</required>
        </attribute>
        <attribute>
            <name>foreColor</name>
        </attribute>
        <attribute>
            <name>backColor</name>
        </attribute>
    </tag>
</taglib>
```
����3 - ��JSPҳ����ʹ���Զ����ǩ��
```jsp
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="my" uri="/WEB-INF/tld/my.tld" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
    <head>
        <base href="<%=basePath%>">
        <title>��ҳ</title>
        <style type="text/css">
            * { font-family: "Arial"; font-size:72px; }
        </style>
    </head>
    <body>
        <my:time format="yyyy-MM-dd" backColor="blue" foreColor="yellow"/>
    </body>
</html>
```

��ʾ�����Ҫ���Զ���ı�ǩ�ⷢ����JAR�ļ�����Ҫ����ǩ�������ļ���tld�ļ�������JAR�ļ���META-INFĿ¼�£�����JDK�е�jar�������JAR�ļ������ɡ�

<p id="javaweb-24">

#### ˵һ�±��ʽ���ԣ�EL������ʽ����������

EL����ʽ���������pageContext��initParam�����������Ĳ�������param�����������������paramValues��header����������ͷ����headerValues��cookie������cookie����applicationScope������application�����򣩡�sessionScope������session�����򣩡�requestScope������request�����򣩡�pageScope������page�����򣩡�
�÷�������ʾ��
${pageContext.request.method}
${pageContext["request"]["method"]}
${pageContext.request["method"]}
${pageContext["request"].method}
${initParam.defaultEncoding}
${header["accept-language"]}
${headerValues["accept-language"][0]}
${cookie.jsessionid.value}
${sessionScope.loginUser.username}
���䣺���ʽ���Ե�.��[]����������һ�µģ�Ψһ�Ĳ������������ʵ�������������Java��ʶ�������������������accept-language�Ͳ���һ����Ч��Java��ʶ������ô��ʱ���ֻ����[]�����������ʹ��.�������ȡ����ֵ

<p id="javaweb-25">

#### ���ʽ���ԣ�EL��֧����Щ�������

����.��[]�������EL���ṩ�ˣ�

- �����������+��-��*��/��div��%��mod

- ��ϵ�������==��eq��!=��ne��>��gt��>=��ge��<��lt��<=��le 

- �߼��������&&��and��||��or��!��not

- �����������${statement? A : B}����Java��������������ƣ�

- empty����������һ��ֵ�Ƿ�Ϊnull���߿գ����鳤��Ϊ0�򼯺���û��Ԫ��Ҳ����true��

<p id="javaweb-26">

#### Java Web������Model 1��Model 2�ֱ�ָ����ʲô��

Model 1����ҳ��Ϊ���ĵ�Java Web������ʹ��JSP+JavaBean������ҳ����ʾ�߼���ҵ���߼�����ֿ���JSPʵ��ҳ����ʾ��JavaBean���������������ݺ�ʵ��ҵ���߼���Model 2�ǻ���MVC��ģ��-��ͼ-��������Model-View-Controller���ܹ�ģʽ�Ŀ���ģ�ͣ�ʵ����ģ�ͺ���ͼ�ĳ��׷��룬�����Ŷӿ����ʹ��븴�ã�����ͼ��ʾ��

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/3.jpg)

<p id="javaweb-27">

#### Servlet 3�е��첽����ָ����ʲô��

��Servlet 3��������һ���µļ���������Servlet�첽�����������˿��ܻ����ɣ���Ȼ���ж��߳��ˣ�����Ҫ�첽���������𣿴��ǿ϶��ģ���Ϊ���һ��������ʱ���൱������ôServlet��Filter��һֱռ�����������߳�ֱ��������������Ų����û������ӣ��������������̳߳����ķ��գ�����������ºܶ�����󽫻ᱻ�ѻ�������������������ܻ������ܾ�����ֱ������Դ���Դ�������Ϊֹ���첽���Կ��԰���Ӧ�ý�ʡ�����е��̣߳��ر��ʺ�ִ��ʱ�䳤�����û���Ҫ�õ��������������û�����Ҫ�õ������ֱ�ӽ�һ��Runnable���󽻸�Executor���������ؼ��ɡ�
���䣺���߳���Java��������������һ�����㣬��Servlet��ʵ�����̵߳Ĺ�����ʽҲ��Ϊ��Ӯ��������Ȼ�������ķ�չ������߸����Ǻܶ����֪������ͬ���갮��˹̹������۵߸���ţ�ٵľ�����ѧһ�㡣��ʵ�ϣ��첽���������Serlvet 3�״���������˽�Node.js�Ļ�����Servlet 3�������Ҫ�Ľ��Ͳ���Ϊ���ˡ�
������һ��֧���첽���������Servlet�����ӡ�

```java
import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/async"}, asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        // ����Tomcat�첽Servlet֧��
        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
        final AsyncContext ctx = req.startAsync(); // �����첽�����������
        // ctx.setTimeout(30000);
        ctx.start(new Runnable() {
            @Override
            public void run() {
                // �ڴ˴�����첽����Ĵ���
                ctx.complete();
            }
        });
    }
}
```

<p id="javaweb-28">

#### ����ڻ���Java��Web��Ŀ��ʵ���ļ��ϴ������أ�

��Sevlet 3 ��ǰ��Servlet API��û��֧���ϴ����ܵ�API�����Ҫʵ���ϴ�������Ҫ������������ߴ�POST�����л���ϴ��ĸ�������ͨ�����д���������������ϴ����ļ��������Ƽ�ʹ��Apache��commons-fileupload����Servlet 3��ʼ���ļ��ϴ�����ޱȼ򵥣����ſ������������һ�ж�����ˡ�
�ϴ�ҳ��index.jsp��

```jsp
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photo Upload</title>
    </head>
    <body>
        <h1>Select your photo and upload</h1>
        <hr/>
        <div style="color:red;font-size:14px;">${hint}</div>
        <form action="UploadServlet" method="post" enctype="multipart/form-data">
            Photo file: <input type="file" name="photo" />
            <input type="submit" value="Upload" />
        </form>
    </body>
</html>
```
֧���ϴ���Servlet��
```java
package com.jackfrued.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // ������request.getPart()���������Ϊphoto���ϴ�����
        // Ҳ������request.getParts()��������ϴ����������ļ��ϴ���
        // Ȼ��ͨ��ѭ���ֱ���ÿһ���ϴ����ļ�
        Part part = request.getPart("photo");
        if (part != null && part.getSubmittedFileName().length() > 0) {
            // ��ServletContext�����getRealPath()��������ϴ��ļ��еľ���·��
            String savePath = request.getServletContext().getRealPath("/upload");
            // Servlet 3.1�淶�п�����Part�����getSubmittedFileName()��������ϴ����ļ���
            // ���õ�������Ϊ�ϴ����ļ�����������������ͬ���ļ����໥���ǣ�
            part.write(savePath + "/" + part.getSubmittedFileName());
            request.setAttribute("hint", "Upload Successfully!");
        } else {
            request.setAttribute("hint", "Upload failed!");
        }
        // ��ת�ص��ϴ�ҳ��
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
```

<p id="javaweb-29">

#### �������յ��û��ύ�ı����ݣ������ǵ���Servlet��doGet()����doPost()������
HTML��<form>Ԫ����һ��method���ԣ�����ָ���ύ���ķ�ʽ����ֵ������get��post�������Զ����Servletһ������»���дdoGet()��doPost()��������֮һ��ȫ���������GET����͵���doGet()�����������POST����͵���doPost()��������ΪʲôΪʲô�����أ������Զ����Servletͨ���̳���HttpServlet��HttpServlet�̳���GenericServlet����д�����е�service()���������������Servlet�ӿ��ж���ġ�HttpServlet��д��service()�������Ȼ�ȡ�û�����ķ�����Ȼ��������󷽷�����doGet()��doPost()��doPut()��doDelete()�ȷ�����������Զ���Servlet����д����Щ��������ô��Ȼ�������д���ģ��Զ���ģ�����������Ȼ�Ƕ�ģ�巽��ģʽ��Ӧ�ã��������⣬��ο��ֺ격ʿ�ġ�Java��ģʽ��һ��ĵ�37�£�����Ȼ���Զ���Servlet��Ҳ����ֱ����дservice()��������ô���������ַ�ʽ�����󣬶�����ͨ���Լ��Ĵ�����д�������ڲ��������󷽷��ĳ����ȽϺ��ʡ�

<p id="javaweb-30">

#### JSP�еľ�̬�����Ͷ�̬������ʲô����

��̬������ͨ��JSP��includeָ�����ҳ�棬��̬������ͨ��JSP��׼����<jsp:forward>����ҳ�档��̬�����Ǳ���ʱ���������������ҳ�治����������������󣬶�������ҳ���"contentType"����Ӧ����һ�£���Ϊ����ҳ���϶�Ϊһ��ֻ����һ��class�ļ�����˱�����ҳ�淢���ı䶯�ٰ�������ҳ�����ǰ����õ����¡���̬����������ʱ�����������򱻰�����ҳ�洫�ݲ���������ҳ��ͱ�����ҳ���Ƕ����ģ�����������class�ļ��������������ҳ�治���ڣ���������������Ҳ��Ӱ��ҳ���������ֵ�ִ�С�����������ʾ��

```jsp
<%-- ��̬����--%>
<%@ include file="..." %>
<%-- ��̬����--%>
<jsp:include page="...">
    <jsp:param name="..." value="..." />
</jsp:include>
```

<p id="javaweb-31">

#### Servlet����λ�ȡ�û��ύ�Ĳ�ѯ����������ݣ�
����ͨ���������HttpServletRequest����getParameter()����ͨ����������ò���ֵ������а������ֵ�Ĳ��������縴ѡ�򣩣�����ͨ����������getParameterValues()������á���ȻҲ����ͨ����������getParameterMap()���һ���������Ͳ���ֵ��ӳ�䣨Map����

<p id="javaweb-32">

#### Servlet����λ�ȡ�û����õĳ�ʼ�������Լ������������Ĳ�����

����ͨ����дServlet�ӿڵ�init(ServletConfig)������ͨ��ServletConfig�����getInitParameter()��������ȡServlet�ĳ�ʼ������������ͨ��ServletConfig�����getServletContext()������ȡServletContext���󣬲�ͨ���ö����getInitParameter()��������ȡ�����������Ĳ�������Ȼ��ServletContext����Ҳ�ڴ����û�����ķ�������doGet()��������ͨ����������getServletContext()��������á�

<p id="javaweb-33">

#### �����������ı����Լ���Ӧ���ݵ����ͣ�

ͨ���������ServletRequest����setCharacterEncoding(String)����������������ı��룬��ʵҪ���׽�����������Ӧ����ҳ�桢���������������Ӧ��Java����ʹ��ͳһ�ı��룬��õ�ѡ��Ȼ��UTF-8��ͨ����Ӧ����ServletResponse����setContentType(String)��������������Ӧ���ݵ����ͣ���ȻҲ����ͨ��HttpServletResponsed�����setHeader(String, String)���������á�
˵��������������й�˾�����Ե�ʱ����JSP��������ǡ����ʽ��ǡ�С�ű������Щ���ݵĻ��������Ĺ�˾Ҳ����ȥ�ˣ���ʵJSP���ö���JSPָ����Щ���������϶�������ȴ�ˣ�����Java Web���������֪ʶ�����Կ�һ�¡�Servlet&JSP˼ά��ͼ����������������֪ʶ������С����˽����ʵ���Զ���MVC��ܵģ����Կ�һ�¡�Java Web�Զ���MVC�����⡷��

<p id="javaweb-34">

#### ����һ������Ӧ�õ�ģʽ�����ص㡣

���͵�����Ӧ��ģʽ���������ࣺB/S��C/S��P2P������B�����������Browser����C����ͻ��ˣ�Client����S�����������Server����P2P�ǶԵ�ģʽ�������ֿͻ��˺ͷ�������B/SӦ��ģʽ�п�����Ϊ�����C/SӦ��ģʽ��ֻ�ǽ�C/SӦ��ģʽ�е�����Ŀͻ��˻��������������Ϊ�������е�ϵͳ�϶������������ôֻҪ��������Ϳ���ʹ��Ӧ�ã�û�а�װ�����á������ͻ����������ĸ��ֿ�����P2PӦ��ģʽ�У���ǧ����̨�˴����ӵļ���������ڶԵȵĵ�λ����������һ����˵������ר�õļ��з������������е�ÿһ̨��������ܳ䵱�������������ߣ��ֶ����������������������Ӧ���ṩ��Դ�ͷ���ͨ����Щ��Դ�ͷ����������Ϣ�Ĺ���ͽ�����������Դ����CPU�Ĺ������洢�����绺��ʹ��̿ռ��ʹ�ã��ȣ�����Ӧ��ģʽ����������ȫ�ԡ��汾�����⣬Ŀǰ�кܶ�Ӧ�ö����ʹ���˶���Ӧ��ģ�ͣ������������ƵӦ�ã�������������ģʽ�������ˡ�
���䣺����Ҫ��"��������ģʽ"���ֿ�����Ϊ�кܶ��˱��ʵ���������ʱ�������뵽����B2B���簢��Ͱͣ���B2C���統��������ѷ����������C2C�����Ա������ģ���C2B�������ͣ���O2O�������š�����ô���������������⣬����ȥ�ٶ��������һ�¡�

<p id="javaweb-35">

#### ʲô��Web Service��Web���񣩣�

�ӱ����Ͽ���Web Service����һ��Ӧ�ó���������籩¶��һ���ܹ�ͨ��Web���е��õ�API�������˵�����ܹ��ñ�̵ķ���͸���ĵ������Ӧ�ó��򣬲���Ҫ�˽������κ�ϸ�ڣ�����ʹ�õı������Ҳû�й�ϵ��������Դ���һ���ṩ����Ԥ����Web Service����ô�����������ֱ�����Կ�����Ӧ�ö�����ͨ����������API�����������Ϣ����øó��е�����Ԥ����֮���Գ�֮ΪWeb Service������Ϊ������HTTPЭ�鴫�����ݣ���ʹ�������ڲ�ͬ�����ϵĲ�ͬӦ������������ӵġ�ר�ŵĵ����������Ӳ�����Ϳ��໥�������ݻ򼯳ɡ�
���䣺�������Ҫ�ἰ��һ��������SOA��Service-Oriented Architecture���������ļܹ�����SOA��һ��˼�룬����Ӧ�ó���Ĳ�ͬ���ܵ�Ԫͨ����������Լ��ϵ������������Ӳ��ƽ̨������ϵͳ�ͱ�����ԣ�ʹ�ø�����ʽ�Ĺ��ܵ�Ԫ�ܹ����õļ��ɡ���Ȼ��Web Service��SOA��һ�ֽϺõĽ�����������������һ�ֱ�׼��������һ�־���ļ�����

<p id="javaweb-36">

#### ������ͣ�SOAP��WSDL��UDDI��

- SOAP���򵥶������Э�飨Simple Object Access Protocol������Web Service�н������ݵ�һ��Э��淶��
- WSDL��Web�����������ԣ�Web Service Description Language������������Web����Ĺ����ӿڡ�����һ������XML�Ĺ��������Web����ͨѶ��ʹ�õķ���������Ҳ����������Ŀ¼���г���Web������н���ʱ��Ҫ�󶨵�Э�����Ϣ��ʽ��ͨ�����ó������������÷���֧�ֵĲ�������Ϣ��ʹ�õ�ʱ���ٽ�ʵ�ʵ�����Э�����Ϣ��ʽ�󶨸��÷���
- UDDI��ͳһ���������ֺͼ��ɣ�Universal Description, Discovery and Integration��������һ������XML�Ŀ�ƽ̨�������淶������ʹ���緶Χ�ڵ���ҵ�ڻ������Ϸ����Լ����ṩ�ķ��񡣼򵥵�˵��UDDI�Ƿ��ʸ���WSDL��һ�����棨���Բο����ģʽ�е�����ģʽ����
  ��ʾ������Web Service����ظ����֪ʶ������W3CSchool���ҵ���ص����ϡ�

<p id="javaweb-37">

#### Java�淶�к�Web Service��صĹ淶����Щ��

Java�淶�к�Web Service��ص���������

- JAX-WS(JSR 224)������淶�����ڵĻ���SOAP��Web Service�淶JAX-RPC������汾���������ṩ���¼����ԣ���ΪRPC��ʽ��WSDL�Լ���ص�API�Ѿ���Java EE5�б��Ƴ��ˡ�WS-MetaData��JAX-WS�������淶���ṩ�˻���ע������Web Service��SOAP��Ϣ�����API��

- JAXM(JSR 67)�������˷��ͺͽ�����Ϣ�����API,�൱��Web Service�ķ������ˡ�

- JAX-RS(JSR 311 & JSR 339 & JSR 370)����Java���REST��Representation State Transfer���ܹ�����ƶ���һ��Web Service�淶��

  REST��һ������ܹ�ģʽ����һ�ַ��������SOAP�������������һ����ϢЭ�飬 (���ַ���Web Service��������HTTP������Э�飬��ΪHTTPЭ���ܴ�Խ����ǽ��Java��Զ�̷������ã�RMI������������Э�飬ͨ�����ܴ�Խ����ǽ������˿��Խ�REST��Ϊ����HTTPЭ�������ܹ���REST������Ҫ��������������Դ��λ����Դ��������HTTPЭ��ǡ���������ṩ���������㡣HTTPЭ���е�URI���������Դ��λ����GET��POST��OPTION��DELETE�������������Դ���������REST��ȫ����HTTPЭ��Ϳ������Web Service��������SOAPЭ������ֻ������HTTP�Ĵ������ԣ���λ�Ͳ���������SOAPЭ��������ɵģ�Ҳ��������SOAP��Ϣ�Ĵ���ʹ�û���SOAP��Web Service�Եñ��ض��𽥱���̭��

<p id="javaweb-38">

#### ����һ�����˽��Java�����Web Service��ܡ�

Java�����Web Service��ܺܶ࣬����Axis2��Axis�������汾����Jersey��RESTful��Web Service��ܣ���CXF��XFire�������汾����Hessian��Turmeric��JBoss SOA�ȣ����о���������ǿ�Դ��ܡ�
��ʾ�����Ա��ʵ����������ʱ��һ��ѡ���Լ��ù�������Ϥ���������֮ǰû���˽����Ӧ��������ǰ��һЩʱ���˽����е����������Ƚ�����ȱ�㣬��������������ʱ����һ��Ư���Ĵ𰸡�

<p id="javaweb-39">

#### ת�����ض��������

ת����Servlet�յ������Ժ�ȥ�����������ȥ���÷������ڲ���������Դ��������
�ض���Servlet���͸������һ���������Ӧ�������Ӧ����������ٴ�����һ����ַ��������

|                | ת��   | �ض��� |
| -------------- | ------ | ------ |
| ����Ĵ���     | 1      | 2      |
| �����λ��     | ������ | ����� |
| ��ַ���ĸı�   | ���ı� | �ı�   |
| ������Ƿ��֪ | ��     | ��     |

�����ݹ����ϣ����𣩣�forword��һ����������������Թ���request����������ݡ�redirect����һ���µ����󣬲����Թ���request����������ݣ�������ͨ��URL��ʽ�������ݷ��͡�
�������ϣ����𣩣�forword����Ҫ����redirect������Ϊ�������������ڱ�ϵͳ��������ת����ʹ��forword������ǿ�����ʣ�����ʹ��redirect����

<p id="javaweb-40">

#### session��cookie������

1. session�Ǵ洢�ڷ������ˣ�cookie�Ǵ洢�ڿͻ��˵ģ����ԴӰ�ȫ����session�İ�ȫ��Ҫ��cookie�ߡ�

2. ����cookie��������ݲ��ܳ���4K���ܶ������������һ��վ����ౣ��20��cookie����session�Ǵ���ڷ��������ڴ��У�����session��Ķ����������ӻ���ɷ������ĸ���������һ��Ѻ���Ҫ����Ϣ�Ŵ洢��session�У�����һЩ��Ҫ�����洢�ڿͻ��˵�cookie��(���罫��½��Ϣ����Ҫ��Ϣ���Ϊsession��������Ϣ�����Ҫ���������Է���cookie)

- cookie��Ϊ�������Ϊ�Ựcookie�ͳ־û�cookie���Ựcookie������ڿͻ�����������ڴ���,�����������ں��������һ�µģ���������˻ỰcookieҲ����ʧ�ˣ����־û�cookie�Ǵ���ڿͻ���Ӳ���У����־û�cookie���������ھ�������������cookieʱ�����õ��Ǹ�����ʱ��


- ��������ر�ʱsession�᲻�ᶪʧ��session����Ϣ��ͨ���Ựcookie��sessionid��ȡ�ģ���������رյ�ʱ��Ựcookie��ʧ���������ǵ�sessionidҲ����ʧ�ˣ�����session����Ϣ�����ڷ������ˣ���ʱ����ֻ�ǲ鲻����ν��session���������ǲ����ڡ�


- session��ʲô����¶�ʧ�������ڷ������رյ�ʱ��Ҳ����˵˵session�Ļ�Ͷۻ�����������session����(Ĭ��ʱ����30����)���ٻ��ߵ�����invalidate()�Ļ�����������Ҫsession�е�ĳһ��������ʧ����session.removeAttribute()����


- session��ʲôʱ�򱻴����أ�ȷ�е�˵��ͨ������getsession()������������HTMLҳ���ǲ��ᴴ��session�����Ƿ���index.JSPʱ�ᴴ��session(JSPʵ������һ��Servlet��Servlet����getSession����)��


<p id="javaweb-41">

#### ��η�ֹ���ظ��ύ

������ظ��ύ��������������

1. ��redirect���ض���������ظ��ύ������
2. ���һ��֮�󣬰�ťʧЧ
3. ͨ��loading(Loadingԭ�����ڵ���ύʱ������Loading��ʽ�����ύ���֮�����ظ���ʽ)
4. �Զ����ظ��ύ������