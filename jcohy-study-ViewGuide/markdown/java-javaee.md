

#  Java
> #### PS:�������С�������
> #### ������ҳ��[www.jcohy.com](http://www.jcohy.com)  	

>  �ҵ�ѧϰ�ʼǣ���¼ѧϰ�����еıʼ��Լ�����������,�Լ��ҵ�һЩ�����ܽᡣ�����������ʧЧ,������֪����������ݵ���������ύ Issues �������޸�������ݡ�

## JavaEE
> * [ʲô��ORM��](#avaee-1)
> * [�־ò����Ҫ���ǵ���������Щ�����ù��ĳ־ò�������Щ��](#avaee-2)
> * [Hibernate��SessionFactory���̰߳�ȫ����Session���̰߳�ȫ���������߳��ܹ�����ͬһ��Session�𣩣�](#avaee-3)
> * [Hibernate��Session��load��get������������ʲô��](#avaee-4)
> * [Session��save()��update()��merge()��lock()��saveOrUpdate()��persist()�����ֱ�����ʲô�ģ���ʲô����](#avaee-5)
> * [����Session����ʵ�����Ĺ���](#avaee-6)
> * [Query�ӿڵ�list������iterate������ʲô����](#avaee-7)
> * [Hibernate���ʵ�ַ�ҳ��ѯ��](#avaee-8)
> * [��������ʲô�ã�����Hibernate�ı��������ֹ������ơ�](#avaee-9)
> * [����ʵ����������״̬�Լ�ת����ϵ��](#avaee-10)
> * [������Hibernate���ӳټ��ػ��ƣ���ʵ��Ӧ���У��ӳټ�����Session�رյ�ì������δ���ģ�](#avaee-11)
> * [��һ����Զ���������ӣ���˵�����ʵ�ֶ�Զ����ӳ�䡣](#avaee-12)
> * [̸һ����Լ̳�ӳ�����⡣](#avaee-13)
> * [����Hibernate�����Ż����ԡ�](#avaee-14)
> * [̸һ̸Hibernate��һ�����桢��������Ͳ�ѯ���档](#avaee-15)
> * [Hibernate��DetachedCriteria������ʲô�ģ�](#avaee-16)
> * [@OneToManyע���mappedBy������ʲô���ã�](#avaee-17)
> * [MyBatis��ʹ��#��$��дռλ����ʲô����](#avaee-18)
> * [����һ��MyBatis�������ռ䣨namespace�������á�](#avaee-19)
> * [MyBatis�еĶ�̬SQL��ʲô��˼��](#avaee-20)
> * [ʲô��IoC��DI��DI�����ʵ�ֵģ�](#avaee-21)
> * [Spring��Bean������������Щ��](#avaee-22)
> * [����һ��ʲô��AOP�����������̣���](#avaee-23)
> * [����������"���й�ע"�������ģ�](#avaee-24)
> * [��������AOP�е����ӵ㣨Joinpoint�����е㣨Pointcut������ǿ��Advice�������飨Introduction����֯�루Weaving�������棨Aspect����Щ���](#avaee-25)
> * [Spring���Զ�װ��ķ�ʽ����Щ��](#avaee-26)
> * [Spring�����ʹ��ע��������Bean������Щ��ص�ע�⣿ ](#avaee-27)
> * [Spring֧�ֵ����������������Щ��������Ŀ��ʹ�����ַ�ʽ��](#avaee-28)
> * [�����Web��Ŀ������Spring��IoC������](#avaee-29)
> * [�����Web��Ŀ������Spring MVC��](#avaee-30)
> * [Spring MVC�Ĺ���ԭ���������ģ�](#avaee-31)
> * [�����Spring IoC��������������Դ��](#avaee-32)
> * [�����������������ǿ��](#avaee-33)
> * [ѡ��ʹ��Spring��ܵ�ԭ��Spring���Ϊ��ҵ�����������ĺô�����Щ����](#avaee-34)
> * [Spring IoC��������Bean�ķ�ʽ��](#avaee-35)
> * [����Spring�����Bean���������ڣ�](#avaee-36)
> * [����ע��ʱ���ע�뼯�����ԣ�](#avaee-37)
> * [Spring�е��Զ�װ������Щ���ƣ�](#avaee-38)
> * [��Web��Ŀ����λ��Spring��IoC������](#avaee-39)
> * [������վ�ڼܹ���Ӧ��������Щ���⣿](#avaee-40)
> * [���ù�����վǰ���Ż��ļ�������Щ��](#avaee-41)
> * [��ʹ�ù���Ӧ�÷������Ż���������Щ��](#avaee-42)
> * [ʲô��XSS������ʲô��SQLע�빥����ʲô��CSRF������](#avaee-43)
> * [ʲô������ģ��(domain model)��ƶѪģ��(anaemic domain model)�ͳ�Ѫģ��(rich domain model)��ʲô����](#avaee-44)
> * [̸һ̸��������������TDD���ĺô��Լ������⡣](#avaee-45)
> * [Spring����ԭ��](#avaee-46)
> * [Spring��ô����bean](#avaee-47)
> * [SpringMVC����ԭ��(��������)](#avaee-48)
> * [��˵һ��SpringMVC��������ע��](#avaee-49)
> * [SpringMVC��Struts2����](#avaee-50)

<p id="javaee-1">

#### ʲô��ORM��

�����ϵӳ�䣨Object-Relational Mapping�����ORM����һ��Ϊ�˽��������������ģ�������ݿ�Ĺ�ϵģ�ͻ���ƥ������ļ������򵥵�˵��ORM��ͨ��ʹ��������������ݿ�֮��ӳ���Ԫ���ݣ���Java�п�����XML������ע�⣩���������еĶ����Զ��־û�����ϵ���ݿ��л��߽���ϵ���ݿ���е���ת����Java�����䱾���Ͼ��ǽ����ݴ�һ����ʽת��������һ����ʽ��

<p id="javaee-2">

#### �־ò����Ҫ���ǵ���������Щ�����ù��ĳ־ò�������Щ��

��ν"�־�"���ǽ����ݱ��浽�ɵ���ʽ�洢�豸���Ա���ʹ�ã��򵥵�˵�����ǽ��ڴ��е����ݱ��浽��ϵ�����ݿ⡢�ļ�ϵͳ����Ϣ���е��ṩ�־û�֧�ֵ��豸�С��־ò����ϵͳ��רע��ʵ�����ݳ־û�����Զ����Ĳ��档
�־ò���Ƶ�Ŀ������� 

- ���ݴ洢�߼��ķ��룬�ṩ���󻯵����ݷ��ʽӿڡ�
- ���ݷ��ʵײ�ʵ�ֵķ��룬�����ڲ��޸Ĵ����������л��ײ�ʵ�֡�
- ��Դ����͵��ȵķ��룬�����ݷ��ʲ�ʵ��ͳһ����Դ���ȣ��绺����ƣ���
- ���ݳ����ṩ�������������ݲ�����
  �־ò����У�
- Hibernate 
- MyBatis 
- TopLink 
- Guzz
- jOOQ 
- Spring Data
- ActiveJDBC

<p id="javaee-3">

#### Hibernate��SessionFactory���̰߳�ȫ����Session���̰߳�ȫ���������߳��ܹ�����ͬһ��Session�𣩣�

SessionFactory��ӦHibernate��һ�����ݴ洢�ĸ�������̰߳�ȫ�ģ����Ա�����̲߳������ʡ�

SessionFactoryһ��ֻ����������ʱ�򹹽�������Ӧ�ó�����ý�SessionFactoryͨ������ģʽ���з�װ�Ա��ڷ��ʡ�

Session��һ�����������̰߳�ȫ�Ķ����̼߳䲻�ܹ���session��������ʾ�����ݿ���н�����һ��������Ԫ��

Session����SessionFactory�����ģ����������֮�����ᱻ�رա�

Session�ǳ־ò��������ṩ����Ҫ�ӿڡ�

Session���ӳٻ�ȡ���ݿ����ӣ�Ҳ��������Ҫ��ʱ��Ż��ȡ����Ϊ�˱��ⴴ��̫���session������ʹ��ThreadLocal��session�͵�ǰ�̰߳���һ������������ͬһ���̻߳�õ�����ͬһ��session��Hibernate 3��SessionFactory��getCurrentSession()�����Ϳ���������

<p id="javaee-4">

#### Hibernate��Session��load��get������������ʲô��

��Ҫ�������������� 

1.  ���û���ҵ����������ļ�¼��get��������null��load�����׳��쳣��

2. get����ֱ�ӷ���ʵ�������load��������ʵ�������Ĵ���

3.  ��Hibernate 3֮ǰ��get����ֻ��һ�������н������ݲ��ң����û���ҵ���Ӧ��������Խ���������棬ֱ�ӷ���SQL���������ݶ�ȡ��load��������ԴӶ��������л�ȡ���ݣ���Hibernate 3��ʼ��get���������ǶԶ�������ֻд��������Ҳ�ǿ��Է��ʶ�������ġ�

˵��������load()����Hibernate��Ϊ�����������ݿ���һ�����ڿ��Է��ĵ�ʹ�ô�����ʵ���ӳټ��أ����û�����ݾ��׳��쳣����ͨ��get()������ȡ�����ݿ��Բ����ڡ�

<p id="javaee-5">

#### Session��save()��update()��merge()��lock()��saveOrUpdate()��persist()�����ֱ�����ʲô�ģ���ʲô����

Hibernate�Ķ���������״̬��˲ʱ̬��transient�����־�̬��persistent��������̬��detached������[����ʵ����������״̬�Լ�ת����ϵ��](#javaee-10)ͼ��ʾ��

˲ʱ̬��ʵ������ͨ������save()��persist()����saveOrUpdate()������ɳ־�̬��

����̬��ʵ������ͨ������update()��saveOrUpdate()��lock()����replicate()��ɳ־�̬��

save()��persist()��������SQL��INSERT��䣬��update()��merge()������UPDATE��䡣save()��update()����������һ���ǽ�˲ʱ̬�����ɳ־�̬��һ���ǽ�����̬�����Ϊ�־�̬��merge()�����������save()��update()�����Ĺ��ܣ�������ͼ�ǽ��µ�״̬�ϲ������еĳ־û������ϻ򴴽��µĳ־û����󡣶���persist()���������չٷ��ĵ���˵����

1. persist()������һ��˲ʱ̬��ʵ���־û������ǲ�����֤��ʶ�����������뵽�־û�ʵ���У���ʶ����������ܱ��Ƴٵ�flush��ʱ�䣻

2.  persist()������֤������һ�������ⲿ�����õ�ʱ�򲢲�����һ��INSERT��䣬����Ҫ��װһ�����Ự���̵�ʱ��persist()�����Ǻ��б�Ҫ�ģ�

1. save()��������֤�ڶ�������Ҫ���ر�ʶ����������������ִ��INSERT��䣬�������������ڲ������ⲿ������lock()������update()����������update()�����ǰ�һ���Ѿ����Ĺ����ѹ�״̬�Ķ����ɳ־�״̬��lock()�����ǰ�һ��û�и��Ĺ����ѹ�״̬�Ķ����ɳ־�״̬��

<p id="javaee-6">

#### ����Session����ʵ�����Ĺ���

Session����ʵ�����Ĳ����ǣ�

 1�� Session�ڵ������ݿ��ѯ����֮ǰ�����Ȼ���һ��������ͨ��ʵ�����ͺ��������в��ң����һ�������������������״̬�Ϸ�����ֱ�ӷ��أ� 

2�����һ������û�����У�������Session���ڵ�ǰNonExists��¼���൱��һ����ѯ����������������ظ�����Ч��ѯ����Ѹ�������жϣ��Ӷ��������ܣ��н��в��ң����NonExists�д���ͬ���Ĳ�ѯ�������򷵻�null�� 

3�� ���һ�������ѯʧ�����ѯ�������棬�����������������ֱ�ӷ��أ� 

4�����֮ǰ�Ĳ�ѯ��δ���У��򷢳�SQL��䣬�����ѯδ���ֶ�Ӧ��¼�򽫴˴β�ѯ��ӵ�Session��NonExists�м��Լ�¼��������null�� 

5������ӳ�����ú�SQL���õ�ResultSet����������Ӧ��ʵ�����

6�� ����������Session��һ�����棩�Ĺ��� 

7������ж�Ӧ������������ִ����������onLoad������

8�� ���������������Ҫʹ�ö������棬�����ݶ�������������棻 

9�� �������ݶ���

<p id="javaee-7">

#### Query�ӿڵ�list������iterate������ʲô����

1�� list()�����޷�����һ������Ͷ������棨�Ի���ֻд����������ֻ���ڿ�����ѯ�����ǰ����ʹ�ò�ѯ���棻iterate()�������Գ�����û��棬���Ŀ������ֻ�����߶�ȡƵ����ʹ��iterate()�������Լ������ܿ�����

2�� list()������������N+1��ѯ���⣬��iterate()������������N+1��ѯ����

<p id="javaee-8">

#### Hibernate���ʵ�ַ�ҳ��ѯ��

ͨ��Hibernateʵ�ַ�ҳ��ѯ��������Աֻ��Ҫ�ṩHQL��䣨����Session��createQuery()���������ѯ����������Session��createCriteria()�����������ò�ѯ��ʼ����������Query��Criteria�ӿڵ�setFirstResult()������������ѯ����������Query��Criteria�ӿڵ�setMaxResults()��������������Query��Criteria�ӿڵ�list()������Hibernate���Զ����ɷ�ҳ��ѯ��SQL��䡣

<p id="javaee-9">

#### ��������ʲô�ã�����Hibernate�ı��������ֹ������ơ�

��Щҵ���߼���ִ�й�����Ҫ������ݽ��������Եķ��ʣ�������Ҫͨ��һЩ���Ʊ�֤�ڴ˹��������ݱ���ס���ᱻ����޸ģ��������ν�������ơ�
Hibernate֧�ֱ��������ֹ������������ơ�

> ������������˼�屯�۵���Ϊ�����ݴ�������м��п��ܴ����޸����ݵĲ������񣨰�����ϵͳ����������������ⲿϵͳ�����񣩣����ǽ��������������Ϊ����״̬�������������������ݿⱾ��������Ʋ���������֤���ݷ��ʵ������ԣ��������ݿ�������ƺ�������뼶���ڡ�Java�������ȫ���ϣ������Ѿ����۹��ˡ�
>
> �ֹ���������˼�壬�Բ���������ֹ�̬�ȣ���Ϊ�����ݵĲ����������ᾭ���Եķ�������ͨ�����ӿ��ɵ���������������ڱ����������Ե����ݷ��ʶ�ϵͳ������ɵ�����Ӱ�졣������ֹ�����ͨ�����ݰ汾��ʶ��ʵ�ֵģ���ȡ����ʱ������ݵİ汾�ţ���������ʱ���˰汾�ż�1��Ȼ������ݿ���Ӧ��¼�ĵ�ǰ�汾�Ž��бȽϣ�����ύ�����ݰ汾�Ŵ������ݿ��д˼�¼�ĵ�ǰ�汾����������ݣ�������Ϊ�ǹ��������޷����¡�

Hibernate��ͨ��Session��get()��load()���������ݿ��м��ض���ʱ����ͨ������ָ��ʹ�ñ����������ֹ�������ͨ����ʵ��������͵İ汾�ֶ���ͨ��XML��@Versionע��������á�

��ʾ��ʹ���ֹ�����������һ���汾�ֶΣ�����������Ҫ����Ŀռ����洢����汾�ֶΣ��˷��˿ռ䣬�����ֹ�������ϵͳ���и��õĲ����ԣ����Ƕ�ʱ��Ľ�ʡ������ֹ���Ҳ�ǵ��͵Ŀռ任ʱ��Ĳ��ԡ�

<p id="javaee-10">

#### ����ʵ����������״̬�Լ�ת����ϵ��

���µ�Hibernate�ĵ���ΪHibernate������������״̬��ԭ��������״̬�����Ե�ʱ��������ʵ�Ҳ������״̬�����ֱ��ǣ�˲ʱ̬��new, or transient�����־�̬��managed, or persistent������״̬��detached�����Ƴ�̬��removed����ǰHibernate�ĵ��ж��������״̬��û���Ƴ�̬��������ͼ��ʾ������ǰ��Hibernate�ĵ����Ƴ�̬����Ϊ��˲ʱ̬��

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/4.jpg)

- ˲ʱ̬����newһ��ʵ���������������˲ʱ̬�����������ֻ��һ��������ʱ���ݵ��ڴ��������û�б����������������ᱻJVM���������ջ��ƻ��ա������������������������ݿ�û���κι�ϵ������ͨ��Session��save()��saveOrUpdate()��persist()��merge()������˲ʱ̬���������ݿ�������������ݲ�����߸��µ����ݿ⣬��������ת��Ϊ�־�̬����

- �־�̬���־�̬�����ʵ�������ݿ����ж�Ӧ�ļ�¼����ӵ��һ���־û���ʶ��ID�����Գ־�̬�������delete���������ݿ��ж�Ӧ�ļ�¼����ɾ������ô�־�̬���������ݿ��¼���ٴ��ڶ�Ӧ��ϵ���־�̬�������Ƴ�̬��������Ϊ˲ʱ̬�����־�̬�����޸ı���󣬲�������ͬ�������ݿ⣬ֱ�����ݿ������ύ��

- ����̬����Session������close()��clear()��evict()��flush()��ʵ�����ӳ־�̬�������̬��������Ȼӵ�г־ú������ݿ��Ӧ��¼һ�µı�ʶֵ��������Ϊ�����Ѿ��ӻỰ��������������ڳ־û�����֮�ڣ����Դ�������̬��Ҳ���ѹ�̬��������̬�Ķ�������ʱ״̬������ʮ�����Ƶģ�ֻ���������г־û���ʶ��

  ��ʾ������������⣬��Hibernate�Ĺٷ��ĵ����и�Ϊ��ϸ�Ľ��

<p id="javaee-11">

#### ������Hibernate���ӳټ��ػ��ƣ���ʵ��Ӧ���У��ӳټ�����Session�رյ�ì������δ���ģ�

�ӳټ��ؾ��ǲ������ڶ�ȡ��ʱ��Ͱ����ݼ��ؽ��������ǵȵ�ʹ��ʱ�ټ��ء�Hibernateʹ��������������ʵ���ӳټ��أ�����ʹ��Session��load()�����������ݻ���һ�Զ����ӳ����ʹ���ӳټ��ص�����´�һ��һ�����ض��һ�����õ��Ķ�����������򵥵�˵���ظ��û��Ĳ�����ʵ�屾������ʵ�����Ĵ�������������û�����getter����ʱ�Ż�ȥ���ݿ�������ݡ����������ݾ���Ҫ���ݿ����ӡ��������ǰѻỰ�ر�ʱ�����ݿ����Ӿ�ͬʱ�ر��ˡ�
�ӳټ�����session�رյ�ì��һ������������� 

1�� �ر��ӳټ������ԡ����ַ�ʽ���������Ƚϼ򵥣���ΪHibernate���ӳټ��������ǿ���ͨ��ӳ���ļ�����ע��������õģ������ֽ�������������Ե�ȱ�ݡ����ȣ�����"no session or session was closed"ͨ��˵��ϵͳ���Ѿ�������������������ȥ���ӳټ��صĻ���ÿ�β�ѯ�Ŀ��������úܴ�

2����session�ر�֮ǰ�Ȼ�ȡ��Ҫ��ѯ�����ݣ�����ʹ�ù��߷���Hibernate.isInitialized()�ж϶����Ƿ񱻼��أ����û�б����������ʹ��Hibernate.initialize()�������ض���

3�� ʹ����������������ӳ�Session����������ֱ����ͼ������ݡ�Spring����Hibernate�ṩ��OpenSessionInViewFilter��OpenSessionInViewInterceptor��������������

<p id="javaee-12">

#### ��һ����Զ���������ӣ���˵�����ʵ�ֶ�Զ����ӳ�䡣

���磺��Ʒ�Ͷ�����ѧ���Ϳγ̶��ǵ��͵Ķ�Զ��ϵ��������ʵ������ͨ��@ManyToManyע�����ö�Զ��������ͨ��ӳ���ļ��еĺͱ�ǩ���ö�Զ����������ʵ����Ŀ�����У��ܶ�ʱ���ǽ���Զ����ӳ��ת�����������һ����ӳ����ʵ�ֵġ�

<p id="javaee-13">

#### ̸һ����Լ̳�ӳ�����⡣

�̳й�ϵ��ӳ����������֣� 

1�� ÿ���̳нṹһ�ű�table per class hierarchy�������ܶ��ٸ����඼��һ�ű�

2�� ÿ������һ�ű�table per subclass����������Ϣ��һ�ű�������Ϣ�ŵ����ı�

3�� ÿ��������һ�ű�table per concrete class�����ж��ٸ�������ж����ű�

��һ�ַ�ʽ���ڵ�����ԣ����ŵ����ڲ�ѯ��������ʱ����������ӣ���ѯ�ٶȿ죬�ʺ϶�̬��ѯ��ȱ���ǿ��ܵ��±�ܴ󡣺����ַ�ʽ���ڶ����ԣ����ŵ��������ݴ洢���գ���ȱ������Ҫ�������Ӳ�ѯ�����ʺ϶�̬��ѯ��

<p id="javaee-14">

#### ����Hibernate�����Ż����ԡ�

�������Ӧ�����Լ�ʹ�ù����Ż����Իش𣬳��õ��У� 

1�� �ƶ�����Ļ�����ԣ��������桢��ѯ���棩�� 

2�� ���ú����Session������ơ�

3�� ����ʹ���ӳټ������ԡ�

4�� �趨���������������� 

5�� ������ԣ�ѡ��UUID��Ϊ������������

6�� ������ԣ�ѡ�û��ڰ汾�ŵ��ֹ�������������� 

7�� �ڿ���������, ����hibernate.show_sqlѡ��鿴���ɵ�SQL���Ӷ��˽�ײ��״����������ɺ�رմ�ѡ�

8�� �������ݿⱾ����Ż��������������ǡ�������ݷ������Եȶ���Գ־ò�����ܴ����ɹ۵�����������Щ��Ҫרҵ��DBA�����ݿ����Ա���ṩ֧�֡�

<p id="javaee-15">

#### ̸һ̸Hibernate��һ�����桢��������Ͳ�ѯ���档

Hibernate��Session�ṩ��һ������Ĺ��ܣ�Ĭ��������Ч�ģ���Ӧ�ó��򱣴�־û�ʵ�塢�޸ĳ־û�ʵ��ʱ��Session���������������ָı��ύ�����ݿ⣬���ǻ����ڵ�ǰ��Session�У�������ʾ������Session��flush()������ͨ��close()�����ر�Session��ͨ��һ�����棬���Լ��ٳ��������ݿ�Ľ������Ӷ�������ݿ�������ܡ�SessionFactory����Ķ���������ȫ���Եģ����е�Session���Թ�������������档������������Ĭ���ǹرյģ���Ҫ��ʾ������ָ����Ҫʹ�����ֶ�������ʵ���ࣨ����ʹ�õ������ṩ��ʵ�֣���һ�������˶������沢��������Ҫʹ�ö��������ʵ���࣬SessionFactory�ͻỺ����ʹ��ĸ�ʵ�����ÿ�����󣬳��ǻ�������ݳ�����ָ���Ļ���ռ䡣һ������Ͷ������涼�Ƕ�����ʵ����л��棬���Ỻ����ͨ���ԣ����ϣ������ͨ���Խ��л��棬����ʹ�ò�ѯ���档��ѯ�����ǽ�HQL��SQL����Լ����ǵĲ�ѯ�����Ϊ��ֵ�Խ��л��棬����ͬ���Ĳ�ѯ����ֱ�Ӵӻ����л�ȡ���ݡ���ѯ����Ĭ��Ҳ�ǹرյģ���Ҫ��ʾ������

<p id="javaee-16">

#### Hibernate��DetachedCriteria������ʲô�ģ�

DetachedCriteria��Criteria���÷���������һ�µģ���Criteria����Session��createCriteria()���������ģ�Ҳ����ζ���뿪��������Session��Criteria���޷�ʹ���ˡ�DetachedCriteria����ҪSession�Ϳ��Դ�����ʹ��DetachedCriteria.forClass()����������������ͨ��Ҳ����Ϊ���ߵ�Criteria������Ҫ���в�ѯ������ʱ���ٺ�Session�󶨣�������getExecutableCriteria(Session)����������Ҳ����ζ��һ��DetachedCriteria��������Ҫ��ʱ��Ͳ�ͬ��Session���а󶨡�

<p id="javaee-17">

#### @OneToManyע���mappedBy������ʲô���ã�

@OneToMany��������һ�Զ����ӳ�䣬��ͨ������£�һ�Զ����ӳ�䶼�ɶ��һ����ά��������ϵ������ѧ���Ͱ༶��Ӧ����ѧ��������Ӱ༶������ά��ѧ���Ͱ༶�Ĺ�����ϵ�������ݿ�������ѧ�����е�����༶�����ά��ѧ����Ͱ༶��Ķ��һ��ϵ�������Ҫʹ��˫��������ڰ༶�������һ���������������ѧ������ʹ��@OneToManyע�����ӳ�䣬��ʱmappedBy���Ծͷǳ���Ҫ�����ʹ��XML�������ã�������<set>��ǩ��inverse="true"�������ﵽͬ����Ч����

<p id="javaee-18">

#### MyBatis��ʹ��#��$��дռλ����ʲô����

\# ����������ݶ�����һ���ַ�������Դ���������Զ��������ţ�\$�����������ֱ����ʾ������SQL�С�ע�⣺ʹ��\$ռλ�����ܻᵼ��SQLע�乥��������#�ĵط��Ͳ�Ҫʹ��\$��дorder by�Ӿ��ʱ��Ӧ����\$������#��

<p id="javaee-19">

#### ����һ��MyBatis�������ռ䣨namespace�������á�

�ڴ�����Ŀ�У����ܴ��ڴ�����SQL��䣬��ʱ��Ϊÿ��SQL�����һ��Ψһ�ı�ʶ��ID���ͱ�ò��������ˡ�Ϊ�˽��������⣬��MyBatis�У�����Ϊÿ��ӳ���ļ���һ��Ψһ�������ռ䣬�������������ӳ���ļ��е�ÿ��SQL���ͳ��˶�������������ռ��е�һ��ID��
ֻҪ�����ܹ���֤ÿ�������ռ������
ID��Ψһ�ģ���ʹ�ڲ�ͬӳ���ļ��е����ID��ͬ��Ҳ�����ٲ�����ͻ�ˡ�

<p id="javaee-20">

#### MyBatis�еĶ�̬SQL��ʲô��˼��

����һЩ���ӵĲ�ѯ�����ǿ��ܻ�ָ�������ѯ������������Щ�������ܴ���Ҳ���ܲ����ڣ�������58ͬ�������ҷ��ӣ����ǿ��ܻ�ָ�������¥�������λ�������ҷ�Դ��Ҳ���ܻ�ָ��������۸񡢻��ͺ�����λ�������ҷ�Դ����ʱ����Ҫ�����û�ָ����������̬����SQL��䡣�����ʹ�ó־ò������ǿ�����Ҫ�Լ�ƴװSQL��䣬����MyBatis�ṩ�˶�̬SQL�Ĺ��������������⡣MyBatis������ʵ�ֶ�̬SQL��Ԫ����Ҫ�У� 

- if 
- choose / when / otherwise 
- trim 
- where
- set 
-  foreach
  ������ӳ���ļ���Ƭ�Ρ�

```html
<select id="foo" parameterType="Blog" resultType="Blog">
    select * from t_blog where 1 = 1
    <if test="title != null">
        and title = #{title}
    </if>
    <if test="content != null">
        and content = #{content}
    </if>
    <if test="owner != null">
        and owner = #{owner}
    </if>
</select>
```
��ȻҲ������������Щ��д��
```html
<select id="foo" parameterType="Blog" resultType="Blog">
    select * from t_blog where 1 = 1
    <choose>
        <when test="title != null">
            and title = #{title}
        </when>
        <when test="content != null">
            and content = #{content}
        </when>
        <otherwise>
            and owner = "owner1"
        </otherwise>
    </choose>
</select>
```
�ٿ�������������ӡ�
```html
<select id="bar" resultType="Blog">
    select * from t_blog where id in
    <foreach collection="array" index="index"
             item="item" open="(" separator="," close=")">
        #{item}
    </foreach>
</select>
<p id="javaee-21">
```
#### ʲô��IoC��DI��DI�����ʵ�ֵģ�

IoC�п��Ʒ�ת����Inversion of Control����д��DI��Dependency Injection��������ע�룬�Ƕ�IoC���򵥵�ڹ�͡����Ʒ�ת�ǰѴ�ͳ���ɳ������ֱ�ӲٿصĶ���ĵ���Ȩ����������ͨ��������ʵ�ֶ��������װ��͹�����ν��"���Ʒ�ת"���Ƕ�����������Ȩ��ת�ƣ��ӳ�����뱾��ת�Ƶ����ⲿ���������������������󲢹������֮���������ϵ��IoC�����˺�����ԭ��- "Don��t call me, we will call you"������ע��Ļ���ԭ����Ӧ�������Ӧ�ø��������Դ��������������Э���������ö���Ĺ���Ӧ�����������𣬲�����Դ���߼�Ӧ�ô�Ӧ������Ĵ����г�ȡ������������������ɡ�DI�Ƕ�IoC��׼ȷ�������������֮���������ϵ�������������ھ������������˵������������̬�Ľ�ĳ��������ϵע�뵽���֮�С�
�ٸ����ӣ�һ����A��Ҫ�õ��ӿ�B�еķ�������ô����ҪΪ��A�ͽӿ�B����������������ϵ����ԭʼ�ķ���������A�д���һ���ӿ�B��ʵ����C��ʵ���������ַ�����Ҫ������Ա����ά�����ߵ�������ϵ��Ҳ����˵��������ϵ�����䶯��ʱ����Ҫ�޸Ĵ��벢���¹�������ϵͳ�����ͨ��һ��������������Щ�����Լ������������ϵ����ֻ��Ҫ����A�ж�������ڹ����ӿ�B�ķ�������������setter������������A�ͽӿ�B��ʵ����C���������У�ͨ����������������ʵ�ֶ��ߵĹ�����
����ע�����ͨ��setter����ע�루��ֵע�룩��������ע��ͽӿ�ע�����ַ�ʽ��ʵ�֣�Spring֧��setterע��͹�����ע�룬ͨ��ʹ�ù�����ע����ע������������ϵ�����ڿ�ѡ��������ϵ����setterע���Ǹ��õ�ѡ��setterע����Ҫ���ṩ�޲ι����������޲εľ�̬������������������

<p id="javaee-22">

#### Spring��Bean������������Щ��

��Spring�����ڰ汾�У���������������singleton��prototype��ǰ�߱�ʾBean�Ե����ķ�ʽ���ڣ����߱�ʾÿ�δ������е���Beanʱ�����᷵��һ���µ�ʵ����prototypeͨ������Ϊԭ�͡�
���䣺���ģʽ�еĴ�����ģʽ��Ҳ��һ��ԭ��ģʽ��ԭ��ģʽҲ��һ�����õ�ģʽ��������һ�����������������е��زĶ��ڹ������У���ÿ�δӹ�������ȡ���Ķ����زĶ����һ��ԭ�ͣ�����ͨ�������¡��ʵ��ԭ��ģʽ��
Spring 2.x�����WebApplicationContext������3�������򣬷ֱ��ǣ�request��ÿ��HTTP���󶼻ᴴ��һ���µ�Bean����session��ͬһ��HttpSession����ͬһ��Bean����ͬ��HttpSessionʹ�ò�ͬ��Bean����globalSession��ͬһ��ȫ��Session����һ��Bean����
˵��������ģʽ��ԭ��ģʽ������Ҫ�����ģʽ��һ������£���״̬��״̬���ɱ�����ʺ�ʹ�õ���ģʽ���ڴ�ͳ�����У�����DAO����Connection������̰߳�ȫ�������û��ʹ�õ���ģʽ������Spring�����£�����DAO��Կ��Բ��õ���ģʽ����ΪSpring����AOP��Java API�е�ThreadLocal�Է��̰߳�ȫ�Ķ�����������⴦��
ThreadLocalΪ������̳߳���Ĳ��������ṩ��һ���µ�˼·��ThreadLocal������˼�����̵߳�һ�����ػ����󣬵������ڶ��߳��еĶ���ʹ��ThreadLocalά������ʱ��ThreadLocalΪÿ��ʹ�øñ������̷߳���һ�������ı�������������ÿһ���̶߳����Զ����ĸı��Լ��ĸ���������Ӱ�������߳�����Ӧ�ĸ��������̵߳ĽǶȿ�����������������̵߳ı��ر�����
ThreadLocal��ǳ��򵥺��ã�ֻ���ĸ������������ϵ�Ҳ������������������ - void set(T value)�����õ�ǰ�̵߳��ֲ߳̾�������ֵ��- T get()����õ�ǰ�߳�����Ӧ���ֲ߳̾�������ֵ��- void remove()��ɾ����ǰ�߳����ֲ߳̾�������ֵ��
ThreadLocal���������Ϊÿһ���߳�ά��һ�ݶ����ı����������أ���ThreadLocal������һ��Map����Ϊ�̶߳���ֵ�����̶߳�Ӧ�ı����ĸ������Լ�Ҫģ��ʵ��һ��ThreadLocal����ʵ�������ѣ�����������ʾ��

```java
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class MyThreadLocal<T> {
    private Map<Thread, T> map = Collections.synchronizedMap(new HashMap<Thread, T>());
    public void set(T newValue) {
        map.put(Thread.currentThread(), newValue);
    }
    public T get() {
        return map.get(Thread.currentThread());
    }
    public void remove() {
        map.remove(Thread.currentThread());
    }
}
```

<p id="javaee-23">

#### ����һ��ʲô��AOP�����������̣���

AOP��Aspect-Oriented Programming��ָһ�ֳ�����Ʒ��ͣ��÷�����һ�ֳ�Ϊ���棨aspect�������Թ���Ϊ������������һ���µ�ģ�黯���ƣ�����������ɢ�ڶ�����򷽷��еĺ��й�ע�㣨crosscutting concern����

<p id="javaee-24">

#### ����������"���й�ע"�������ģ�

"���й�ע"�ǻ�Ӱ�쵽����Ӧ�ó���Ĺ�ע���ܣ�����������ҵ���߼��������ģ�û�б�Ȼ����ϵ�����Ǽ������е�ҵ���߼������漰����Щ��ע���ܡ�ͨ����������־����ȫ�Եȹ�ע����Ӧ���еĺ��й�ע���ܡ�

<p id="javaee-25">

#### ��������AOP�е����ӵ㣨Joinpoint�����е㣨Pointcut������ǿ��Advice�������飨Introduction����֯�루Weaving�������棨Aspect����Щ���

1�����ӵ㣨Joinpoint��������ִ�е�ĳ���ض�λ�ã��磺ĳ����������ǰ�����ú󣬷����׳��쳣�󣩡�һ�����һ�γ������ӵ��һЩ���б߽����ʵ��ض��㣬��Щ�����е��ض���������ӵ㡣Spring��֧�ַ��������ӵ㡣2�� �е㣨Pointcut����������ӵ��൱�������еļ�¼����ô�е��൱�ڲ�ѯ������һ���е����ƥ�������ӵ㡣Spring AOP�Ĺ���������渺������е����趨�Ĳ�ѯ�������ҵ���Ӧ�����ӵ㡣

3�� ��ǿ��Advice������ǿ��֯�뵽Ŀ�������ӵ��ϵ�һ�γ�����롣Spring�ṩ����ǿ�ӿڶ��Ǵ���λ���ģ��磺BeforeAdvice��AfterReturningAdvice��ThrowsAdvice�ȡ��ܶ������Ͻ���ǿ��Ϊ��֪ͨ�����������Ǹ��ʲ�����ķ��룬�úܶ����Ա��������á�
˵���� Advice�ڹ��ڵĺܶ����������ж��������"֪ͨ"�����Ǻ���Ȼ��������޷�����䱾�ʣ��������Ķ����Ͻ�����ʷ���Ϊ"��ǿ"����������Ƕ�Advice��Ϊ׼ȷ��ڹ�ͣ�����ͨ��AOP�����й�ע���ܼӵ�ԭ�е�ҵ���߼��ϣ�����Ƕ�ԭ��ҵ���߼���һ����ǿ��������ǿ������ǰ����ǿ��������ǿ�����غ���ǿ�����쳣ʱ��ǿ�Ͱ�Χ����ǿ��
4�����飨Introduction����������һ���������ǿ����Ϊ�����һЩ���Ժͷ�������������ʹһ��ҵ����ԭ��û��ʵ��ĳ���ӿڣ�ͨ�����鹦�ܣ����Զ�̬��δ��ҵ������ӽӿڵ�ʵ���߼�����ҵ�����Ϊ����ӿڵ�ʵ���ࡣ5��֯�루Weaving����֯���ǽ���ǿ��ӵ�Ŀ����������ӵ��ϵĹ��̣�AOP������֯�뷽ʽ��

- ������֯�룺��Ҫ�����Java�����ڣ�����AspectJ��ajc����

- װ����֯�룺Ҫ��ʹ������������������װ�����ʱ����������ǿ��

- ����ʱ֯�룺������ʱΪĿ�������ɴ���ʵ����ǿ��

Spring�����˶�̬����ķ�ʽʵ��������ʱ֯�룬��AspectJ�����˱�����֯���װ����֯��ķ�ʽ��f. ���棨Aspect�������������е����ǿ�����飩��ɵģ��������˶Ժ��й�ע���ܵĶ��壬Ҳ�����˶����ӵ�Ķ��塣

���䣺����ģʽ��GoF�����23�����ģʽ����Ϊ�����ģʽ֮һ������ģʽ�Ƕ���Ľṹģʽ������ĳһ�������ṩһ��������󣬲��ɴ��������ƶ�ԭ��������á��򵥵�˵��������������ɱ�ԭ��������ְ�𣬵���ҪΪԭ������Ӻ��й�ע����ʱ���Ϳ���ʹ��ԭ����Ĵ�����������ڴ�Officeϵ�е�Word�ĵ�ʱ������ĵ����в�ͼ�����ĵ��ռ���ʱ���ĵ��еĲ�ͼ��ֻ��һ�����ռλ�������û���������ĳҳҪ�鿴��ͼƬʱ���Ż�������������ͼ������ʵ���ǶԴ���ģʽ��ʹ�ã���������ͼƬ��������һ���������Hibernate��load����Ҳ�Ƿ���һ�����������󣬵��û�������Ҫ���ʶ��������ʱ���������ݿⷢ��SQL�������ʵ����

������һ����ǹ�ִ�����������ʾ����ģʽ��ʹ�ã�

```java
/*
* �ο���Ա�ӿ�
* @author
*
*/
public interface Candidate {
    /**
* ����
*/
    public void answerTheQuestions();
}
/**
* ��ѧ��
* @author ���
*
*/
public class LazyStudent implements Candidate {
    private String name; // ����
    public LazyStudent(String name) {
        this.name = name;
    }
    @Override
    public void answerTheQuestions() {
        // ��ѧ��ֻ��д���Լ������ֲ������
        System.out.println("����: " + name);
    }
}
/**
* ǹ��
* @author ���
*
*/
public class Gunman implements Candidate {
    private Candidate target; // ���������
    public Gunman(Candidate target) {
        this.target = target;
    }
    @Override
    public void answerTheQuestions() {
        // ǹ��Ҫд�ϴ�����ѧ��������
        target.answerTheQuestions();
        // ǹ��Ҫ������ѧ�����Ⲣ����
        System.out.println("�ܱʼ�����ȷ��");
        System.out.println("����");
    }
}
public static void main(String[] args) {
    Candidate c = new Gunman(new LazyStudent("��С��"));
    c.answerTheQuestions();
}
}

```



˵������JDK 1.3��ʼ��Java�ṩ�˶�̬����������������������ʱ�����ӿڵĴ���ʵ������Ҫ����Proxy���InvocationHandler�ӿڡ����������ʹ�ö�̬����ΪArrayList��дһ����������Ӻ�ɾ��Ԫ��ʱ���ڿ���̨��ӡ��ӻ�ɾ����Ԫ���Լ�ArrayList�Ĵ�С��

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
public class ListProxy<T> implements InvocationHandler {
    private List<T> target;
    public ListProxy(List<T> target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable {
        Object retVal = null;
        System.out.println("[" + method.getName() + ": " + args[0] + "]");
        retVal = method.invoke(target, args);
        System.out.println("[size=" + target.size() + "]");
        return retVal;
    }
}
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
public class ProxyTest2 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Class<?> clazz = list.getClass();
        ListProxy<String> myProxy = new ListProxy<String>(list);
        List<String> newList = (List<String>)
            Proxy.newProxyInstance(clazz.getClassLoader(),
                                   clazz.getInterfaces(), myProxy);
        newList.add("apple");
        newList.add("banana");
        newList.add("orange");
        newList.remove("banana");
    }
}
```


˵����ʹ��Java�Ķ�̬������һ�������Ծ��Ǵ���������Ҫʵ�ֽӿڣ���Ȼ����ӿڱ����ÿ�������Java����֪���Ĺ��򣬵���ʵ�������������⣬����û��ʵ�ֽӿڵ������Ϊ�����ɴ����أ��̳У��̳���������չ���д����������ֶΣ���Ȼ�̳г�������ѧ�����ã����̳�Ҳ���������׵ĳ���Ա���ӡ�CGLib���÷ǳ��ײ���ֽ������ɼ�����ͨ��Ϊһ���ഴ�����������ɴ������ֲ���Java��̬����Ĳ��㣬���Spring�ж�̬�����CGLib���Ǵ����������Ҫ�ֶΣ�����ʵ���˽ӿڵ�����ö�̬����Ϊ�����ɴ����࣬��û��ʵ�ֽӿڵ������CGLibͨ���̳еķ�ʽΪ�䴴������

<p id="javaee-26">

#### Spring���Զ�װ��ķ�ʽ����Щ��

- no���������Զ�װ�䣬�ֶ�����Bean��������ϵ��
- byName������Bean�����ֽ����Զ�װ�䡣
- byType������Bean�����ͽ����Զ�װ�䡣
- constructor��������byType��������Ӧ���ڹ������Ĳ��������������һ��Bean�빹�����Ĳ���������ͬ������Զ�װ�䣬����ᵼ�´���
- autodetect�������Ĭ�ϵĹ���������ͨ��constructor�ķ�ʽ�����Զ�װ�䣬����ʹ��byType�ķ�ʽ�����Զ�װ�䡣
  ˵�����Զ�װ��û���Զ���װ�䷽ʽ��ô��ȷ�����Ҳ����Զ�װ������ԣ��������͡��ַ����ȣ�����ʹ��ʱӦע�⡣

<p id="javaee-27">

#### Spring�����ʹ��ע��������Bean������Щ��ص�ע�⣿ 

������Ҫ��Spring�����ļ��������������ã�

```xml
<context:component-scan base-package="org.example"/>
```


Ȼ�������@Component��@Controller��@Service��@Repositoryע������ע��Ҫ��Spring IoC�������ж����йܵ��ࡣ�⼸��ע��û�б�������ֻ����@Controllerͨ�����ڿ�������@Serviceͨ������ҵ���߼��࣬@Repositoryͨ�����ڲִ��ࣨ�������ǵ�DAOʵ���ࣩ����ͨ������@Component����ע��

<p id="javaee-28">

#### Spring֧�ֵ����������������Щ��������Ŀ��ʹ�����ַ�ʽ��

Spring֧�ֱ��ʽ������������ʽ����������Spring��ܵ��û�ѡ������ʽ���������Ϊ���ַ�ʽ��Ӧ�ó���Ĺ������٣���˸��ӷ��������������ĸ������ʽ�������Ҫ���ڱ��ʽ�����������������Է��������ڱ��ʽ���������Ϊ���ʽ����������ͨ���������ҵ��

�����Ϊȫ������;ֲ�����ȫ��������Ӧ�÷�����������Ҫ�ײ������JTA֧�֣���WebLogic��WildFly�ȣ����ֲ�����͵ײ���õĳ־û������йأ�����ʹ��JDBC���г־û�ʱ����Ҫʹ��Connetion�������������񣻶�����Hibernate���г־û�ʱ����Ҫʹ��Session��������������
Spring�ṩ��������ʾ�������������

| ���������ʵ����                    | Ŀ�����            |
| ----------------------------------- | ------------------- |
| DataSourceTransactionManager        | ע��DataSource      |
| HibernateTransactionManager         | ע��SessionFactory  |
| JdoTransactionManager               | ����JDO����         |
| JtaTransactionManager               | ʹ��JTA��������     |
| PersistenceBrokerTransactionManager | ����Apache��OJB���� |

��Щ����ĸ��ӿڶ���PlatformTransactionManager��Spring��������������һ�ֵ��͵Ĳ���ģʽ��PlatformTransactionManager�����������ӿڣ��ýӿڶ����������������ýӿڲ���֪���ײ���ι������񣬵�������ʵ��������ṩgetTransaction()�������������񣩡�commit()�������ύ���񣩡�rollback()�������ع����񣩵Ķ�̬ʵ�֣������Ϳ����ò�ͬ��ʵ�������ͬ�����������ԡ�ʹ��JTAȫ���������ʱ����Ҫ�ײ�Ӧ�÷�����֧�֣�����ͬ��Ӧ�÷��������ṩ��JTAȫ��������ܴ���ϸ���ϵĲ��죬���ʵ������ȫ������������ǿ�����Ҫʹ��JtaTransactionManager�����࣬�磺WebLogicJtaTransactionManager��Oracle��WebLogic�������ṩ����UowJtaTransactionManager��IBM��WebSphere�������ṩ���ȡ�
���ʽ�������������ʾ��

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xmlns:p="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
    <context:component-scan base-package="com.jackfrued"/>
    <bean id="propertyConfig"
          class="org.springframework.beans.factory.config.
                 PropertyPlaceholderConfigurer">
        <property name="location">
            <value>jdbc.properties</value>
        </property>
    </bean>
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
        <property name="driverClassName">
            <value>{db.driver}</value>
        </property>
        <property name="url">
            <value>{db.url}</value>
        </property>
        <property name="username">
            <value>{db.username}</value>
        </property>
        <property name="password">
            <value>{db.password}</value>
        </property>
    </bean>
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource">
            <ref bean="dataSource" />
        </property>
    </bean>
    <!-- JDBC���������-->
    <bean id="transactionManager"
          class="org.springframework.jdbc.datasource.
                 DataSourceTransactionManager" scope="singleton">
        <property name="dataSource">
            <ref bean="dataSource" />
        </property>
    </bean>
    <!-- ��������ģ��-->
    <bean id="transactionTemplate"
          class="org.springframework.transaction.support.
                 TransactionTemplate">
        <property name="transactionManager">
            <ref bean="transactionManager" />
        </property>
    </bean>
</beans>
```



```java
package com.jackfrued.dao.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.jackfrued.dao.EmpDao;
import com.jackfrued.entity.Emp;
@Repository
public class EmpDaoImpl implements EmpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean save(Emp emp) {
        String sql = "insert into emp values (?,?,?)";
        return jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getBirthday()) == 1;
    }
}
package com.jackfrued.biz.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import com.jackfrued.biz.EmpService;
import com.jackfrued.dao.EmpDao;
import com.jackfrued.entity.Emp;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private TransactionTemplate txTemplate;
    @Autowired
    private EmpDao empDao;
    @Override
    public void addEmp(final Emp emp) {
        txTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus txStatus) {
                empDao.save(emp);
            }
        });
    }
}
```


����ʽ��������ͼ��ʾ����Spring����Hibernate 3Ϊ��������������DAO��ҵ���߼����롣

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans-3.2.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context-3.2.xsd
                           http://www.springframework.org/schema/aop
                           http://www.springframework.org/schema/aop/spring-aop-3.2.xsd
                           http://www.springframework.org/schema/tx
                           http://www.springframework.org/schema/tx/spring-tx-3.2.xsd">
    <!-- ������Spring IoC�����йܵĶ����Ӧ�ı�ע��������ڵİ�-->
    <context:component-scan base-package="com.jackfrued" />
    <!-- ����ͨ���Զ����ɴ���ʵ��AOP����-->
    <aop:aspectj-autoproxy />
    <!-- �������ݿ����ӳ�(DBCP) -->
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
          destroy-method="close">
        <!-- ��������������-->
        <property name="driverClassName" value="com.mysql.jdbc.Driver" />
        <!-- �����������ݿ��URL -->
        <property name="url" value="jdbc:mysql://localhost:3306/myweb" />
        <!-- ���÷������ݿ���û���-->
        <property name="username" value="root" />
        <!-- ���÷������ݿ�Ŀ���-->
        <property name="password" value="123456" />
        <!-- �������������-->
        <property name="maxActive" value="150" />
        <!-- ������С����������-->
        <property name="minIdle" value="5" />
        <!-- ����������������-->
        <property name="maxIdle" value="20" />
        <!-- ���ó�ʼ������-->
        <property name="initialSize" value="10" />
        <!-- �������ӱ�й¶ʱ�Ƿ�������־-->
        <property name="logAbandoned" value="true" />
        <!-- �����Ƿ�ɾ����ʱ����-->
        <property name="removeAbandoned" value="true" />
        <!-- ����ɾ����ʱ���ӵĳ�ʱ����ֵ(����Ϊ��λ) -->
        <property name="removeAbandonedTimeout" value="120" />
        <!-- ���ó�ʱ�ȴ�ʱ��(�Ժ���Ϊ��λ) -->
        <property name="maxWait" value="5000" />
        <!-- ���ÿ������ӻ������߳����е�ʱ����(�Ժ���Ϊ��λ) -->
        <property name="timeBetweenEvictionRunsMillis" value="300000" />
        <!-- �������ӿ��ж೤ʱ���(�Ժ���Ϊ��λ)���Ͽ�����-->
        <property name="minEvictableIdleTimeMillis" value="60000" />
    </bean>
    <!-- ����Spring�ṩ��֧��ע��ORMӳ���Hibernate�Ự����-->
    <bean id="sessionFactory"
          class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
        <!-- ͨ��setterע������Դ����-->
        <property name="dataSource" ref="dataSource" />
        <!-- ����ʵ�������ڵİ�-->
        <property name="packagesToScan" value="com.jackfrued.entity" />
        <!-- ����Hibernate���������-->
        <property name="hibernateProperties">
            <!-- ����Ŀ������ɺ�Ҫɾ��show_sql��format_sql���Է��������������Ӱ��-->
            <value>
                hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
            </value>
        </property>
    </bean>
    <!-- ����Spring�ṩ��Hibernate���������-->
    <bean id="transactionManager"
          class="org.springframework.orm.hibernate3.HibernateTransactionManager">
        <!-- ͨ��setterע��Hibernate�Ự����-->
        <property name="sessionFactory" ref="sessionFactory" />
    </bean>
    <!-- ���û���ע����������ʽ����-->
    <tx:annotation-driven />
</beans>
```



```java
package com.jackfrued.dao;
import java.io.Serializable;
import java.util.List;
import com.jackfrued.comm.QueryBean;
import com.jackfrued.comm.QueryResult;
/**

* ���ݷ��ʶ���ӿ�(�Զ���Ϊ��λ��װCRUD����)
* @author ���
*
* @param <E> ʵ������
* @param <K> ʵ���ʶ�ֶε�����
*/
public interface BaseDao <E, K extends Serializable> {
    /**
* ����
* @param entity ҵ��ʵ�����
* @return ���ӳɹ�����ʵ�����ı�ʶ
*/
    public K save(E entity);
    /**
* ɾ��
* @param entity ҵ��ʵ�����
*/
    public void delete(E entity);
    /**
* ����IDɾ��
* @param id ҵ��ʵ�����ı�ʶ
* @return ɾ���ɹ�����true���򷵻�false
*/
    public boolean deleteById(K id);
    /**
* �޸�
* @param entity ҵ��ʵ�����
* @return �޸ĳɹ�����true���򷵻�false
*/
    public void update(E entity);
    /**
* ����ID����ҵ��ʵ�����
* @param id ҵ��ʵ�����ı�ʶ
* @return ҵ��ʵ���������null
*/
    public E findById(K id);
    /**
* ����ID����ҵ��ʵ�����
* @param id ҵ��ʵ�����ı�ʶ
* @param lazy �Ƿ�ʹ���ӳټ���
* @return ҵ��ʵ��������
*/
    public E findById(K id, boolean lazy);
    /**
* ��������ҵ��ʵ�����
* @return װ����ҵ��ʵ�������б�����
*/
    public List<E> findAll();
    /**
* ��ҳ����ҵ��ʵ�����
* @param page ҳ��
* @param size ҳ���С
* @return ��ѯ�������
*/
    public QueryResult<E> findByPage(int page, int size);
    /**
* ��ҳ����ҵ��ʵ�����
* @param queryBean ��ѯ��������
* @param page ҳ��
* @param size ҳ���С
* @return ��ѯ�������
*/
    public QueryResult<E> findByPage(QueryBean queryBean, int page, int size);
}

```



```java
package com.jackfrued.dao;
import java.io.Serializable;
import java.util.List;
import com.jackfrued.comm.QueryBean;
import com.jackfrued.comm.QueryResult;
/**

BaseDao��ȱʡ������

@author ���
*

@param <E> ʵ������

@param <K> ʵ���ʶ�ֶε�����
*/
public abstract class BaseDaoAdapter<E, K extends Serializable> implements
    BaseDao<E, K> {
    @Override
    public K save(E entity) {
        return null;
    }
    @Override
    public void delete(E entity) {
    }
    @Override
    public boolean deleteById(K id) {
        E entity = findById(id);
        if(entity != null) {
            delete(entity);
            return true;
        }
        return false;
    }
    @Override
    public void update(E entity) {
    }
    @Override
    public E findById(K id) {
        return null;
    }
    @Override
    public E findById(K id, boolean lazy) {
        return null;
    }
    @Override
    public List<E> findAll() {
        return null;
    }
    @Override
    public QueryResult<E> findByPage(int page, int size) {
        return null;
    }
    @Override
    public QueryResult<E> findByPage(QueryBean queryBean, int page, int size) {
        return null;
    }
}

```



```java
package com.jackfrued.dao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.jackfrued.comm.HQLQueryBean;
import com.jackfrued.comm.QueryBean;
import com.jackfrued.comm.QueryResult;
/**

����Hibernate��BaseDaoʵ����

@author ���
*

@param <E> ʵ������

@param <K> ��������
/
@SuppressWarnings(value = {"unchecked"})
public abstract class BaseDaoHibernateImpl<E, K extends Serializable> extends BaseDaoAdapter<E, K> {
@Autowired
protected SessionFactory sessionFactory;
private Class<?> entityClass; // ҵ��ʵ��������
private String entityName; // ҵ��ʵ�������
public BaseDaoHibernateImpl() {
ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
entityClass = (Class<?>) pt.getActualTypeArguments()[0];
entityName = entityClass.getSimpleName();
}
@Override
public K save(E entity) {
return (K) sessionFactory.getCurrentSession().save(entity);
}
@Override
public void delete(E entity) {
sessionFactory.getCurrentSession().delete(entity);
}
@Override
public void update(E entity) {
sessionFactory.getCurrentSession().update(entity);
}
@Override
public E findById(K id) {
return findById(id, false);
}
@Override
public E findById(K id, boolean lazy) {
Session session = sessionFactory.getCurrentSession();
return (E) (lazy? session.load(entityClass, id) : session.get(entityClass, id));
}
@Override
public List<E> findAll() {
return sessionFactory.getCurrentSession().createCriteria(entityClass).list();
}
@Override
public QueryResult<E> findByPage(int page, int size) {
return new QueryResult<E>(
findByHQLAndPage("from " + entityName , page, size),
getCountByHQL("select count() from " + entityName)
);
}
@Override
public QueryResult<E> findByPage(QueryBean queryBean, int page, int size) {
if(queryBean instanceof HQLQueryBean) {
HQLQueryBean hqlQueryBean = (HQLQueryBean) queryBean;
return new QueryResult<E>(
findByHQLAndPage(hqlQueryBean.getQueryString(), page, size, hqlQueryBean.getParameters()),
getCountByHQL(hqlQueryBean.getCountString(), hqlQueryBean.getParameters())
);
}
return null;
}
/**

����HQL�Ϳɱ�����б���в�ѯ

@param hql ����HQL�Ĳ�ѯ���

@param params �ɱ�����б�

@return ���в�ѯ������б���������б�����
*/
protected List<E> findByHQL(String hql, Object... params) {
    return this.findByHQL(hql, getParamList(params));
}
/**

����HQL�Ͳ����б���в�ѯ

@param hql ����HQL�Ĳ�ѯ���

@param params ��ѯ�����б�

@return ���в�ѯ������б���������б�����
*/
protected List<E> findByHQL(String hql, List<Object> params) {
    List<E> list = createQuery(hql, params).list();
    return list != null && list.size() > 0 ? list : Collections.EMPTY_LIST;
}
/**

����HQL�Ͳ����б���з�ҳ��ѯ

@param hql ����HQL�Ĳ�ѯ���

@page ҳ��

@size ҳ���С

@param params �ɱ�����б�

@return ���в�ѯ������б���������б�����
*/
protected List<E> findByHQLAndPage(String hql, int page, int size, Object... params) {
    return this.findByHQLAndPage(hql, page, size, getParamList(params));
}
/**

����HQL�Ͳ����б���з�ҳ��ѯ

@param hql ����HQL�Ĳ�ѯ���

@page ҳ��

@size ҳ���С

@param params ��ѯ�����б�

@return ���в�ѯ������б���������б�����
*/
protected List<E> findByHQLAndPage(String hql, int page, int size, List<Object> params) {
    List<E> list = createQuery(hql, params)
        .setFirstResult((page - 1) * size)
        .setMaxResults(size)
        .list();
    return list != null && list.size() > 0 ? list : Collections.EMPTY_LIST;
}
/**

��ѯ���������ļ�¼��

@param hql ����HQL�Ĳ�ѯ���

@param params �ɱ�����б�

@return �����ѯ�������ܼ�¼��
*/
protected long getCountByHQL(String hql, Object... params) {
    return this.getCountByHQL(hql, getParamList(params));
}
/**

��ѯ���������ļ�¼��

@param hql ����HQL�Ĳ�ѯ���

@param params �����б�����

@return �����ѯ�������ܼ�¼��
*/
protected long getCountByHQL(String hql, List<Object> params) {
    return (Long) createQuery(hql, params).uniqueResult();
}
// ����Hibernate��ѯ����(Query)
private Query createQuery(String hql, List<Object> params) {
    Query query = sessionFactory.getCurrentSession().createQuery(hql);
    for(int i = 0; i < params.size(); i++) {
        query.setParameter(i, params.get(i));
    }
    return query;
}
// ���ɱ�����б���װ���б�����
private List<Object> getParamList(Object... params) {
    List<Object> paramList = new ArrayList<>();
    if(params != null) {
        for(int i = 0; i < params.length; i++) {
            paramList.add(params[i]);
        }
    }
    return paramList.size() == 0? Collections.EMPTY_LIST : paramList;
}
}

```



```java
package com.jackfrued.comm;
import java.util.List;
/**

��ѯ�����Ľӿ�

@author ���
*
*/
public interface QueryBean {
    /**

��������ֶ�

@param fieldName ����������ֶ�

@param asc �����ǽ���

@return ��ѯ������������(���㼶�����)
*/
    public QueryBean addOrder(String fieldName, boolean asc);
    /**

��������ֶ�

@param available �Ƿ���Ӵ������ֶ�

@param fieldName ����������ֶ�

@param asc �����ǽ���

@return ��ѯ������������(���㼶�����)
*/
    public QueryBean addOrder(boolean available, String fieldName, boolean asc);
    /**

��Ӳ�ѯ����

@param condition ����

@param params �滻�������в���ռλ���Ĳ���

@return ��ѯ������������(���㼶�����)
*/
    public QueryBean addCondition(String condition, Object... params);
    /**

��Ӳ�ѯ����

@param available �Ƿ���Ҫ��Ӵ�����

@param condition ����

@param params �滻�������в���ռλ���Ĳ���

@return ��ѯ������������(���㼶�����)
*/
    public QueryBean addCondition(boolean available, String condition, Object... params);
    /**

��ò�ѯ���

@return ��ѯ���
*/
    public String getQueryString();
    /**

��ȡ��ѯ��¼���Ĳ�ѯ���

@return ��ѯ��¼���Ĳ�ѯ���
*/
    public String getCountString();
    /**

��ò�ѯ����

@return ��ѯ�������б�����
*/
    public List<Object> getParameters();
}

```



```java
package com.jackfrued.comm;
import java.util.List;
/**

��ѯ���

@author ���
*

@param <T> ���Ͳ���
*/
public class QueryResult<T> {
    private List<T> result; // ���в�ѯ������б�����
    private long totalRecords; // ��ѯ�����ܼ�¼��
    /**

������
*/
    public QueryResult() {
    }
    /**

������

@param result ���в�ѯ������б�����

@param totalRecords ��ѯ�����ܼ�¼��
*/
    public QueryResult(List<T> result, long totalRecords) {
        this.result = result;
        this.totalRecords = totalRecords;
    }
    public List<T> getResult() {
        return result;
    }
    public void setResult(List<T> result) {
        this.result = result;
    }
    public long getTotalRecords() {
        return totalRecords;
    }
    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }
}

```



```java
package com.jackfrued.dao;
import com.jackfrued.comm.QueryResult;
import com.jackfrued.entity.Dept;
/**

�������ݷ��ʶ���ӿ�

@author ���
*
*/
public interface DeptDao extends BaseDao<Dept, Integer> {
    /**

��ҳ��ѯ��������

@param page ҳ��

@param size ҳ���С

@return ��ѯ�������
*/
    public QueryResult<Dept> findTopDeptByPage(int page, int size);
}
package com.jackfrued.dao.impl;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jackfrued.comm.QueryResult;
import com.jackfrued.dao.BaseDaoHibernateImpl;
import com.jackfrued.dao.DeptDao;
import com.jackfrued.entity.Dept;
@Repository
public class DeptDaoImpl extends BaseDaoHibernateImpl<Dept, Integer> implements DeptDao {
    private static final String HQL_FIND_TOP_DEPT = " from Dept as d where d.superiorDept is null ";
    @Override
    public QueryResult<Dept> findTopDeptByPage(int page, int size) {
        List<Dept> list = findByHQLAndPage(HQL_FIND_TOP_DEPT, page, size);
        long totalRecords = getCountByHQL(" select count() " + HQL_FIND_TOP_DEPT);
        return new QueryResult<>(list, totalRecords);
    }
}

```



```java
package com.jackfrued.comm;
import java.util.List;
/**

��ҳ��

@author ���
*

@param <T> ��ҳ���ݶ��������
*/
public class PageBean<T> {
    private static final int DEFAUL_INIT_PAGE = 1;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final int DEFAULT_PAGE_COUNT = 5;
    private List<T> data; // ��ҳ����
    private PageRange pageRange; // ҳ�뷶Χ
    private int totalPage; // ��ҳ��
    private int size; // ҳ���С
    private int currentPage; // ��ǰҳ��
    private int pageCount; // ҳ������
    /**

������

@param currentPage ��ǰҳ��

@param size ҳ���С

@param pageCount ҳ������
*/
    public PageBean(int currentPage, int size, int pageCount) {
        this.currentPage = currentPage > 0 ? currentPage : 1;
        this.size = size > 0 ? size : DEFAULT_PAGE_SIZE;
        this.pageCount = pageCount > 0 ? size : DEFAULT_PAGE_COUNT;
    }
    /**

������

@param currentPage ��ǰҳ��

@param size ҳ���С
*/
    public PageBean(int currentPage, int size) {
        this(currentPage, size, DEFAULT_PAGE_COUNT);
    }
    /**

������

@param currentPage ��ǰҳ��
*/
    public PageBean(int currentPage) {
        this(currentPage, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_COUNT);
    }
    /**

������
*/
    public PageBean() {
        this(DEFAUL_INIT_PAGE, DEFAULT_PAGE_SIZE, DEFAULT_PAGE_COUNT);
    }
    public List<T> getData() {
        return data;
    }
    public int getStartPage() {
        return pageRange != null ? pageRange.getStartPage() : 1;
    }
    public int getEndPage() {
        return pageRange != null ? pageRange.getEndPage() : 1;
    }
    public long getTotalPage() {
        return totalPage;
    }
    public int getSize() {
        return size;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    /**

����ѯ���ת��Ϊ��ҳ����

@param queryResult ��ѯ�������
*/
    public void transferQueryResult(QueryResult<T> queryResult) {
        long totalRecords = queryResult.getTotalRecords();
        data = queryResult.getResult();
        totalPage = (int) ((totalRecords + size - 1) / size);
        totalPage = totalPage >= 0 ? totalPage : Integer.MAX_VALUE;
        this.pageRange = new PageRange(pageCount, currentPage, totalPage);
    }
}

```



```java
package com.jackfrued.comm;
/**

ҳ�뷶Χ

@author ���
*
*/
public class PageRange {
    private int startPage; // ��ʼҳ��
    private int endPage; // ��ֹҳ��
    /**

������

@param pageCount �ܹ���ʾ����ҳ��

@param currentPage ��ǰҳ��

@param totalPage ��ҳ��
*/
    public PageRange(int pageCount, int currentPage, int totalPage) {
        startPage = currentPage - (pageCount - 1) / 2;
        endPage = currentPage + pageCount / 2;
        if(startPage < 1) {
            startPage = 1;
            endPage = totalPage > pageCount ? pageCount : totalPage;
        }
        if (endPage > totalPage) {
            endPage = totalPage;
            startPage = (endPage - pageCount > 0) ? endPage - pageCount + 1 : 1;
        }
    }
    /**

�����ʼҳҳ��

@return ��ʼҳҳ��
*/
    public int getStartPage() {
        return startPage;
    }
    /**

�����ֹҳҳ��

@return ��ֹҳҳ��
*/
    public int getEndPage() {
        return endPage;
    }
}

```



```java
package com.jackfrued.biz;
import com.jackfrued.comm.PageBean;
import com.jackfrued.entity.Dept;
/**

����ҵ���߼��ӿ�

@author ���
*
*/
public interface DeptService {
    /**

�����µĲ���

@param department ���Ŷ���

@return �����ɹ�����true���򷵻�false
*/
    public boolean createNewDepartment(Dept department);
    /**

ɾ��ָ������

@param id Ҫɾ���Ĳ��ŵı��

@return ɾ���ɹ�����true���򷵻�false
*/
    public boolean deleteDepartment(Integer id);
    /**

��ҳ��ȡ��������

@param page ҳ��

@param size ҳ���С

@return ���Ŷ���ķ�ҳ������
*/
    public PageBean<Dept> getTopDeptByPage(int page, int size);
}

```



```java
package com.jackfrued.biz.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jackfrued.biz.DeptService;
import com.jackfrued.comm.PageBean;
import com.jackfrued.comm.QueryResult;
import com.jackfrued.dao.DeptDao;
import com.jackfrued.entity.Dept;
@Service
@Transactional // ����ʽ�����ע��
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptDao deptDao;
    @Override
    public boolean createNewDepartment(Dept department) {
        return deptDao.save(department) != null;
    }
    @Override
    public boolean deleteDepartment(Integer id) {
        return deptDao.deleteById(id);
    }
    @Override
    public PageBean<Dept> getTopDeptByPage(int page, int size) {
        QueryResult<Dept> queryResult = deptDao.findTopDeptByPage(page, size);
        PageBean<Dept> pageBean = new PageBean<>(page, size);
        pageBean.transferQueryResult(queryResult);
        return pageBean;
    }
}
```

<p id="javaee-29">

#### �����Web��Ŀ������Spring��IoC������

�����Ҫ��Web��Ŀ��ʹ��Spring��IoC������������Web��Ŀ�����ļ�web.xml�������������ã�

```xml
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<listener>
    <listener-class>
        org.springframework.web.context.ContextLoaderListener
    </listener-class>
</listener>
```

<p id="javaee-30">

#### �����Web��Ŀ������Spring MVC��

Ҫʹ��Spring MVC��Ҫ��Web��Ŀ�����ļ���������ǰ�˿�����DispatcherServlet��������ʾ��

```xml
<web-app>
    <servlet>
        <servlet-name>example</servlet-name>
        <servlet-class>
            org.springframework.web.servlet.DispatcherServlet
        </servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>example</servlet-name>
        <url-pattern>*.html</url-pattern>
    </servlet-mapping>
</web-app>

```

˵���������������ʹ����*.html�ĺ�׺ӳ�䣬������һ���治�ܹ�ͨ��URL�ƶϲ����˺��ַ������˵ļ�������һ���������ƭ�������棬��Ϊ�������治��������̬ҳ�棬����������Ϊα��̬����

<p id="javaee-31">

#### Spring MVC�Ĺ���ԭ���������ģ�

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/5.jpg)

�� �ͻ��˵��������󶼽���ǰ�˿�����DispatcherServlet���������Ḻ�����ϵͳ������ģ�������������û�������

�� DispatcherServlet�յ�����󣬽������������Ϣ������URL��HTTPЭ�鷽��������ͷ�����������Cookie�ȣ��Լ�HandlerMapping�������ҵ�����������Handler���κ�һ�����󶼿�����Ϊ�����Handler����

��������ط�Spring��ͨ��HandlerAdapter�Ըô��������з�װ��

�� HandlerAdapter��һ��������������ͳһ�ĽӿڶԸ���Handler�еķ������е��á�

�� Handler��ɶ��û�����Ĵ���󣬻᷵��һ��ModelAndView�����DispatcherServlet��ModelAndView����˼�壬����������ģ���Լ���Ӧ����ͼ����Ϣ��

�� ModelAndView����ͼ���߼���ͼ��DispatcherServlet��Ҫ����ViewResolver��ɴ��߼���ͼ����ʵ��ͼ����Ľ���������

�� ���õ���������ͼ�����DispatcherServlet��������ͼ�����ģ�����ݽ�����Ⱦ��

�� �ͻ��˵õ���Ӧ��������һ����ͨ��HTMLҳ�棬Ҳ������XML��JSON�ַ�������������һ��ͼƬ����һ��PDF�ļ���

<p id="javaee-32">

#### �����Spring IoC��������������Դ��

DBCP���ã�

```xml
<bean id="dataSource"
class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
<property name="driverClassName" value="${jdbc.driverClassName}"/>
<property name="url" value="${jdbc.url}"/>
<property name="username" value="${jdbc.username}"/>
<property name="password" value="${jdbc.password}"/>
</bean>
<context:property-placeholder location="jdbc.properties"/>
```

C3P0���ã�

```xml
<bean id="dataSource"
class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
<property name="driverClass" value="${jdbc.driverClassName}"/>
<property name="jdbcUrl" value="${jdbc.url}"/>
<property name="user" value="${jdbc.username}"/>
<property name="password" value="${jdbc.password}"/>
</bean>
<context:property-placeholder location="jdbc.properties"/>
```


��ʾ�� DBCP����ϸ�����ڵ�153�����Ѿ�������չʾ���ˡ�

<p id="javaee-33">

#### �����������������ǿ��

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
                           http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/tx
                           http://www.springframework.org/schema/tx/spring-tx.xsd
                           http://www.springframework.org/schema/aop
                           http://www.springframework.org/schema/aop/spring-aop.xsd">
    <!-- this is the service object that we want to make transactional -->
    <bean id="fooService" class="x.y.service.DefaultFooService"/>
    <!-- the transactional advice -->
    <tx:advice id="txAdvice" transaction-manager="txManager">
        <!-- the transactional semantics... -->
        <tx:attributes>
            <!-- all methods starting with 'get' are read-only -->
            <tx:method name="get*" read-only="true"/>
            <!-- other methods use the default transaction settings (see below) -->
            <tx:method name="*"/>
        </tx:attributes>
    </tx:advice>
    <!-- ensure that the above transactional advice runs for any execution
of an operation defined by the FooService interface -->
    <aop:config>
        <aop:pointcut id="fooServiceOperation"
                      expression="execution(* x.y.service.FooService.*(..))"/>
        <aop:advisor advice-ref="txAdvice" pointcut-ref="fooServiceOperation"/>
    </aop:config>
    <!-- don't forget the DataSource -->
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
          destroy-method="close">
        <property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
        <property name="url" value="jdbc:oracle:thin:@localhost:1521:orcl"/>
        <property name="username" value="scott"/>
        <property name="password" value="tiger"/>
    </bean>
    <!-- similarly, don't forget the PlatformTransactionManager -->
    <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!-- other <bean/> definitions here -->
</beans>
```

<p id="javaee-34">

#### ѡ��ʹ��Spring��ܵ�ԭ��Spring���Ϊ��ҵ�����������ĺô�����Щ����

���Դ����¼����������� 

- ������ʽ��֧�ֻ���POJO�ı��ģʽ����ǿ���Ե�Ҫ��ʵ��Spring����еĽӿڻ�̳�Spring����е��ࡣ
- IoC������IoC��������Ӧ�ó����������Լ�����֮���������ϵ������֮���������ϵ��������˸ı�ֻ��Ҫ�޸������ļ��������޸Ĵ��룬��Ϊ������޸Ŀ�����ζ����Ŀ�����¹����������Ļع���ԡ�����IoC����������Ա��Ҳ����Ҫ�Լ���д��������������һ���ر����Spring�ľ���"��Ҫ�ظ��ķ�������"��
- AOP�����������̣��������еĺ��й�ע���ܷ�װ�����棨aspect���У�ͨ�����õķ�ʽ�����й�ע���ܶ�̬��ӵ�Ŀ������ϣ���һ��ʵ����ҵ���߼���ϵͳ����֮��ķ��롣��һ���棬����AOP����Ա����ʡȥ�ܶ��Լ�д������Ĺ�����
- MVC��Spring��MVC����Ƿǳ�����ģ��Ӹ������涼����˦Struts 2�����֣�ΪWeb��ʾ���ṩ�˸��õĽ��������
- �������Spring�Կ����ػ����ɶ��ֳ־ò㼼��������Ϊ���ṩ������ʽ����������ڲ���Ҫ�κ�һ�д��������¾��ܹ�����������
- ������ѡ��Spring��ܵ�ԭ��Զ��ֹ�ڴˣ�SpringΪJava��ҵ�������ṩ��һվʽѡ�����������Ҫ��ʱ��ʹ�����Ĳ��ֺ�ȫ��������Ҫ���ǣ������������ڸо�����Spring���ڵ�����£��������Ŀ��ʹ��Spring�ṩ�ĸ�������Ĺ��ܡ�

<p id="javaee-35">

#### Spring IoC��������Bean�ķ�ʽ��

- ����XML�ļ��������á�- ����ע��������á� - ����Java����������ã�Spring 3+��

  ```java
  package com.jackfrued.bean;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Component;
  @Component
  public class Person {
      private String name;
      private int age;
      @Autowired
      private Car car;
      public Person(String name, int age) {
          this.name = name;
          this.age = age;
      }
      public void setCar(Car car) {
          this.car = car;
      }
      @Override
      public String toString() {
          return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
      }
  }
  
  
  package com.jackfrued.bean;
  import org.springframework.stereotype.Component;
  @Component
  public class Car {
      private String brand;
      private int maxSpeed;
      public Car(String brand, int maxSpeed) {
          this.brand = brand;
          this.maxSpeed = maxSpeed;
      }
      @Override
      public String toString() {
          return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
      }
  }
  
  package com.jackfrued.config;
  import org.springframework.context.annotation.Bean;
  import org.springframework.context.annotation.Configuration;
  import com.jackfrued.bean.Car;
  import com.jackfrued.bean.Person;
  @Configuration
  public class AppConfig {
      @Bean
      public Car car() {
          return new Car("Benz", 320);
      }
      @Bean
      public Person person() {
          return new Person("���", 34);
      }
  }
  
  
  package com.jackfrued.test;
  import org.springframework.context.ConfigurableApplicationContext;
  import org.springframework.context.annotation.AnnotationConfigApplicationContext;
  import com.jackfrued.bean.Person;
  import com.jackfrued.config.AppConfig;
  class Test {
      public static void main(String[] args) {
          // TWR (Java 7+)
          try(ConfigurableApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class)) {
              Person person = factory.getBean(Person.class);
              System.out.println(person);
          }
      }
  }
  ```


<p id="javaee-36">

#### ����Spring�����Bean���������ڣ�

�� Spring IoC�����ҵ�����Bean�Ķ��岢ʵ������Bean��

�� Spring IoC������Bean��������ע�롣

�� ���Beanʵ����BeanNameAware�ӿڣ��򽫸�Bean��id����setBeanName������

�� ���Beanʵ����BeanFactoryAware�ӿڣ���BeanFactory���󴫸�setBeanFactory������

�� ���Beanʵ����BeanPostProcessor�ӿڣ��������postProcessBeforeInitialization������

�� ���Beanʵ����InitializingBean�ӿڣ��������afterPropertySet������

�� ����к�Bean������BeanPostProcessors��������Щ�����postProcessAfterInitialization���������á�

�� ������Beanʵ��ʱ�����Beanʵ����DisposableBean�ӿڣ��������destroy������

<p id="javaee-37">

#### ����ע��ʱ���ע�뼯�����ԣ�

�����ڶ���Bean����ʱ��ͨ��<list> / <set> / <map> / <props>�ֱ�Ϊ��ע���б����ϡ�ӳ��ͼ�ֵ�����ַ�����ӳ�����ԡ�

<p id="javaee-38">

#### Spring�е��Զ�װ������Щ���ƣ�

- ���ʹ���˹�����ע�����setterע�룬��ô�������Զ�װ���������ϵ��
- �����������͵�ֵ���ַ��������������������޷�ʹ���Զ�װ����ע�롣
- ���ȿ���ʹ����ʽ��װ�������и���ȷ������ע�������ʹ���Զ�װ�䡣

<p id="javaee-39">

#### ��Web��Ŀ����λ��Spring��IoC������

```java
WebApplicationContext ctx =
    WebApplicationContextUtils.getWebApplicationContext(servletContext);
```



<p id="javaee-40">

#### ������վ�ڼܹ���Ӧ��������Щ���⣿

- �ֲ㣺�ֲ��Ǵ����κθ���ϵͳ������ֶ�֮һ����ϵͳ�����зֳ����ɸ����棬ÿ������ֻ�е���һ��ְ��Ȼ��ͨ���²�Ϊ�ϲ��ṩ�Ļ�����ʩ�ͷ����Լ��ϲ���²�ĵ������γ�һ�������ĸ��ӵ�ϵͳ�����������Ŀ���ϵͳ�����ο�ģ�ͣ�OSI/RM����Internet��TCP/IPģ�Ͷ��Ƿֲ�ṹ��������վ�����ϵͳҲ����ʹ�÷ֲ��������Ϊ�־ò㣨�ṩ���ݴ洢�ͷ��ʷ��񣩡�ҵ��㣨����ҵ���߼���ϵͳ������ĵĲ��֣��ͱ�ʾ�㣨ϵͳ��������ͼչʾ������Ҫָ�����ǣ���1���ֲ����߼��ϵĻ��֣��������Ͽ���λ��ͬһ�豸��Ҳ�����ڲ�ͬ���豸�ϲ���ͬ�Ĺ���ģ�飬��������ʹ�ø���ļ�����Դ��Ӧ���û��Ĳ������ʣ���2�������֮��Ӧ���������ı߽磬�����ֲ�������壬�Ÿ���������Ŀ�����ά����
- �ָ�ָ��Ƕ�����������з֡����ǿ��Խ�������վ�Ĳ�ͬ���ܺͷ���ָ���γɸ��ھ۵���ϵĹ���ģ�飨��Ԫ��������Ƴ��ڿ�����һ�������ȵķָ����վ�ָ�Ϊ���ɸ�����ģ�飬���ڻ����Խ�һ����ÿ��ģ�����ϸ���ȵķָ����һ��������������Ŀ�����ά������һ���������ڷֲ�ʽ�Ĳ����ṩ��վ�Ĳ������������͹��ܵ���չ��
- �ֲ�ʽ�����������ᵽ�����ݣ���վ�ľ�̬��Դ��JavaScript��CSS��ͼƬ�ȣ�Ҳ���Բ��ö����ֲ�ʽ���𲢲��ö������������������Լ���Ӧ�÷������ĸ���ѹ����Ҳʹ�����������Դ�ļ��ظ��졣���ݵĴ�ȡҲӦ���Ƿֲ�ʽ�ģ���ͳ����ҵ����ϵ�����ݿ��Ʒ�����϶�֧�ֲַ�ʽ���𣬶�������NoSQL��Ʒ�������Ƿֲ�ʽ�ġ���Ȼ����վ��̨��ҵ����ҲҪʹ�÷ֲ�ʽ�����������ѯ�����Ĺ��������ݷ����ȣ���Щҵ������ģ�Ӵ󣬿���ʹ��Hadoop�Լ�MapReduce�ֲ�ʽ������������
- ��Ⱥ����Ⱥʹ���и���ķ������ṩ��ͬ�ķ��񣬿��Ը��õ��ṩ�Բ�����֧�֡�
- ���棺��ν��������ÿռ任ȡʱ��ļ����������ݾ����ܷ��ھ�����������λ�á�ʹ�û�������վ�Ż��ĵ�һ���ɡ�����ͨ��˵��CDN����������ȵ����ݶ��ǶԻ��漼����ʹ�á�
- �첽���첽��ʵ�����ʵ��֮�����ϵ���һ��Ҫ�ֶΡ��첽�ܹ��ǵ��͵�������������ģʽ������֮��û��ֱ�ӵĵ��ù�ϵ��ֻҪ�������ݽṹ���䣬�˴˹���ʵ�ֿ�������仯��������Ӱ�죬�����վ����չ�ǳ�������ʹ���첽�����������ϵͳ�����ԣ��ӿ���վ����Ӧ�ٶȣ���Ajax�������ݾ���һ���첽��������ͬʱ���������������ã�Ӧ��˲ʱ�߲�������&quot�����Ƴٴ���Ķ�Ҫ�Ƴٴ���"����վ�Ż��ĵڶ����ɣ����첽�Ǽ�����վ�Ż��ڶ����ɵ���Ҫ�ֶΡ�
- ���ࣺ���ַ�������Ҫ�ṩ��Ӧ������������Ա���ĳ̨��ĳЩ������崻�ʱ���ܱ�֤��վ��������������ͬʱҲ�ṩ�����ѻָ��Ŀ����ԡ���������վ�߿����Ե���Ҫ��֤��

<p id="javaee-41">

#### ���ù�����վǰ���Ż��ļ�������Щ��

�� ����������Ż��� 

- ����HTTP�����������ϲ�CSS���ϲ�JavaScript���ϲ�ͼƬ��CSS Sprite��
-  ʹ����������棺ͨ������HTTP��Ӧͷ�е�Cache-Control��Expires���ԣ���CSS��JavaScript��ͼƬ����������л��棬����Щ��̬��Դ��Ҫ����ʱ�����Ը���HTML�ļ��е�����������������������µ���Դ
- ����ѹ�� 
- CSSǰ�ã�JavaScript����
- ����Cookie����

�� CDN���٣�CDN��Content Distribute Network���ı�����Ȼ�ǻ��棬�����ݻ��������û�����ĵط���CDNͨ��������������Ӫ�̵Ļ�������������������Ӧ�ٶȣ������Լ���Ӧ�÷�������ѹ������Ȼ��CDN�����ͨ�����Ǿ�̬��Դ��

�� ���������������൱��Ӧ�÷�������һ�����棬���Ա�����վ�İ�ȫ�ԣ�Ҳ����ʵ�ָ��ؾ���Ĺ��ܣ���Ȼ����Ҫ�������������û����ʵ��ȵ���Դ������ֱ�Ӵӷ������ĳЩ���ݷ��ظ��û��������

<p id="javaee-42">

#### ��ʹ�ù���Ӧ�÷������Ż���������Щ��

�� �ֲ�ʽ���棺����ı��ʾ����ڴ��еĹ�ϣ��������һ�����ʵĹ�ϣ��������ô�����Ϲ�ϣ���д�Ľ���ʱ�临�Ӷ�ΪO(1)��������Ҫ���������Щ��д�Ⱥܸߡ��仯���ٵ����ݣ�����Ӧ�ó����ȡ����ʱ�ȵ������ж�ȡ�����û�л��������Ѿ�ʧЧ��ȥ�������ݿ���ļ�ϵͳ���������ⶨ�Ĺ�������д�뻺�档����վ���ݵķ���Ҳ���϶��˶��ɣ�Pareto�ֲ������ɷֲ�������80%�ķ��ʶ�������20%�������ϣ�����ܹ�����20%�����ݻ�����������ôϵͳ�����ܽ��õ������ĸ��ơ���Ȼ��ʹ�û�����Ҫ������¼������⣺ 

- Ƶ���޸ĵ����ݣ�
- ���ݲ�һ���������
- ����ѩ�������Բ��÷ֲ�ʽ�����������Ⱥ���Խ����memcached�ǹ㷺���õĽ����������
- ����Ԥ�ȣ�
- ���洩͸������������󲻴��ڵ����ݣ��� 

�� �첽����������ʹ����Ϣ���н������첽����ͨ���첽������ʱ��߲����������¼���Ϣ�洢����Ϣ�����У��Ӷ����������á�������վ�ڽ��д����ʱ�����Խ��û��Ķ������������Ϣ���У��������Ե��������Ĳ������������ϵͳ�����ݿ�ĳ����Ŀǰ����������ĵ�����վ���㲻���д����������ϵͳ����������Ϣ����������

�� ʹ�ü�Ⱥ�� 

�� �����Ż���

- ���̣߳�����Java��Web���������϶�ͨ�����̵߳ķ�ʽ��Ӧ�û��Ĳ�������ʹ�ö��̼߳����ڱ����Ҫ����̰߳�ȫ���⣬��Ҫ���Կ������¼������棺

	A. ���������Ϊ��״̬��������������ı�̹۵���ì�ܵģ����������������б���Ϊ������ƣ��������Ͳ�����ڲ�������ʱ����״̬��һ�µ����⡣

	B. �ڷ����ڲ������������������ɽ��뷽�����̴߳�����������ֶ���̷߳���ͬһ��������⡣ʹ��ThreadLocal���������̰߳�Ҳ�Ǻܺõ���������һ����ǰ���Ѿ�̽�ֹ��ˡ�

	C. ����Դ���в�������ʱӦ��ʹ�ú���������ơ�

- ������I/O��ʹ�õ��̺߳ͷ�����I/O��Ŀǰ���ϵıȶ��̵߳ķ�ʽ���ܳ�ַ��ӷ��������ܵ�Ӧ��ģʽ������Node.js�����ķ������Ͳ����������ķ�ʽ��Java��JDK 1.4�о�������NIO��Non-blocking I/O��,��Servlet 3�淶�����������첽Servlet�ĸ����Щ��Ϊ�ڷ������˲��÷�����I/O�ṩ�˱�Ҫ�Ļ�����

- ��Դ���ã���Դ������Ҫ�����ַ�ʽ��һ�ǵ��������Ƕ���أ�����ʹ�õ����ݿ����ӳء��̳߳ض��Ƕ���ػ����������ǵ��͵��ÿռ任ȡʱ��Ĳ��ԣ���һ����Ҳʵ�ֶ���Դ�ĸ��ã��Ӷ������˲���Ҫ�Ĵ������ͷ���Դ�������Ŀ�����

<p id="javaee-43">

#### ʲô��XSS������ʲô��SQLע�빥����ʲô��CSRF������

- XSS��Cross Site Script����վ�ű�������������ҳ��ע�����ű����û������ҳʱ���û��������ִ�ж���ű��Ĺ�����ʽ����վ�ű���������������ʽ�������͹�������ʹ�û����һ��Ƕ�����ű��������Դﵽ������Ŀ�꣬Ŀǰ�кܶ๥����������̳��΢���������ж���ű���URL���������ַ�ʽ���ͳ־��͹�����������ű��ύ����������վ�����ݿ��У��û������ҳʱ������ű������ݿ��б����ص�ҳ��ִ�У�QQ��������ڰ汾��������������Ϊ�־��Ϳ�վ�ű�������ƽ̨����XSS��Ȼ����ʲô�������⣬���ǹ������ַ�ȴ���Ϸ��£�����XSS��Ҫ�������棺��������Σ���ַ�����ת�壩��HttpOnly������XSS��������ȡCookie���ݣ���

- SQLע�빥����ע�빥���������ʽ�����⻹��OSע�빥����Struts 2�ĸ�Σ©������ͨ��OGNLʵʩOSע�빥�����µģ�������������ʹ�������������SQL���ʱ�������SQL��Ƕ�뵽SQL�н������ݿ�ִ�С�SQLע�빥����Ҫ�����߶����ݿ�ṹ�����˽���ܽ��У���������Ҫ��ñ�ṹ�ж��ַ�ʽ��

  - ��1�����ʹ�ÿ�Դϵͳ���վ�����ݿ�ṹҲ�ǹ����ģ�Ŀǰ�кܶ��ֳɵ�ϵͳ����ֱ�Ӵ��̳��������վ����Ȼ�����ݵ��Ƿ����Ǳ���Ҫ���������ģ���
  - ��2��������ԣ�������������Ĵ�����Ϣֱ����ʾ��ҳ���ϣ������߿���ͨ���Ƿ���������ҳ�����Ӷ�ͨ��������Ϣ�˽����ݿ�ṹ��WebӦ��Ӧ�������ѺõĴ���ҳ��һ���������С����ԭ��һ�������ε����ܸ�ϵͳ����Σ�յĴ��������Ϣ����
  - ��3��äע������SQLע�빥��Ҳ���Բ��������ķ�ʽ��ͨ��������ʽ���������������֤�����⣬������Ҳ�Ǻܺõ��ֶΣ����������SQL�ᱻ����SQL�Ĳ������������ִ�У�JDBC�е�PreparedStatement����֧�ֲ����󶨵������󣬴����ܺͰ�ȫ���϶���������Statement��

- CSRF������Cross Site Request Forgery����վ����α�죩�ǹ�����ͨ����վ�����ԺϷ����û���ݽ��зǷ���������ת�˻����ȣ���CSRF��ԭ���������������Cookie���������Session����ȡ�û���ݣ���ԭ������ͼ��ʾ������CSRF����Ҫ�ֶ���ʶ�������ߵ���ݣ���Ҫ�����¼��ַ�ʽ��

  - ��1���ڱ���������ƣ�token����
  - ��2����֤�룻
  - ��3���������ͷ�е�Referer��ǰ���ᵽ��ͼƬ������Ҳ���õ����ַ�ʽ�������ƺ���֤������һ�������Ե������������ԭ����һ�µģ�������֤����һ�������û����飬���Ǳ�Ҫ������²�Ҫ����ʹ����֤�룬Ŀǰ�ܶ���վ������������ڶ�ʱ���ڶ���ύһ����δ��óɹ����Ҫ���ṩ��֤�룬�������ýϺõ��û����顣

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/6.jpg)
  ���䣺����ǽ�ļ�����Web��ȫ����Ҫ���ϣ�ModSecurity�ǿ�Դ��Web����ǽ�е�ٮٮ�ߡ���ҵ������ǽ�ļ���Ӧ������������ǽ��Web�������Ͳ���Ӧ�÷��������Լ�������������ǽ֮���DMZ�������ݺ���Դ������Ӧ�������ڵڶ�������ǽ֮��

<p id="javaee-44">

#### ʲô������ģ��(domain model)��ƶѪģ��(anaemic domain model)�ͳ�Ѫģ��(rich domain model)��ʲô����

����ģ���������ڵĸ��������ʵ�����ж���Ŀ��ӻ���ʾ���ֳ�Ϊ����ģ�ͻ��������ģ�ͣ���רע�ڷ�������������������Ҫ��ҵ��������������ҵ���������֮��Ĺ�ϵ��ƶѪģ����ָʹ�õ����������ֻ��setter��getter������POJO�������е�ҵ���߼�������������������ж��Ƿ���ҵ���߼��㡣���˽���������˵��ƶѪģ�ͽ�һ�����ֳ�ʧѪģ�ͣ����������ȫû��ҵ���߼�����ƶѪģ�ͣ����������������ҵ���߼�������������Ͳ��Դ˼��������ˡ���Ѫģ�ͽ������ҵ���߼��ͳ־û�������������У�ҵ���߼���ҵ�����棩ֻ����ɶ�ҵ���߼��ķ�װ�������Ȩ�޵ȵĴ�����������ͼ�ֱ�չʾ��ƶѪģ�ͺͳ�Ѫģ�͵ķֲ�ܹ���

ƶѪģ��

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/7.jpg)

��Ѫģ��

  ![](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-ViewGuide/src/main/resources/static/images/8.jpg)

ƶѪģ������֯�����߼�ͨ��ʹ������ű�ģʽ����ÿ�����̶�Ӧ�û�����Ҫ����һ��������ÿ��������һ��������������Ҳ����˵�����ҵ���߼��ӿڵ�ʱ��ÿ��������Ӧ���û���һ������������ģʽ�����¼����е㣺 

- ����һ������������߶��ܹ����ļ򵥹���ģ�ͣ��ʺϹ��ڵľ�����������ߣ���

- ���ܹ���һ��ʹ����������ڻ��������ڵļ����ݷ��ʲ�ܺõ�Э����

- ����߽���Զ��׼���һ������ʼ�ڽű��Ŀ�ʼ����ֹ�ڽű��Ľ�����������ͨ��������
  ���棩ʵ������ʽ����

Ȼ��������ű�ģʽ��ȱ��Ҳ�Ǻܶ�ģ����������߼������Ե����ӣ�ϵͳ�ĸ����Խ�Ѹ�����ӣ�����ṹ����ü��Ȼ��ҡ���Դ�й���������һƪ�ܺõ����ġ�ƶѪ����ģ������ε����������������������������˱Ƚ�ϸ�µĲ�����

<p id="javaee-45">

#### ̸һ̸��������������TDD���ĺô��Լ������⡣

TDD��ָ�ڱ�д�����Ĺ���ʵ�ִ���֮ǰ��д���Դ��룬Ȼ�������Ҫ�ع�ʵ�ִ��롣��JUnit������Kent Beck�Ĵ�������������������ʵս��ģʽ��������Test-Driven Development: by Example��һ��������ôһ�����ݣ��������־�Ͳ�ȷ�����Ǳ�д���������������Ҫԭ�򡱡���Ϊ��д����ʱ�Ŀ־������С����̽������رܹ�ͨ���������ڵõ������������ý��겻������TDD�������־塢��Java�����߸������Ÿ������ڹ�ͨ����Ҫ�ֶΡ�TDD������ĺô����ܲ������ϳ��֣���������ĳ��ʱ��һ���ᷢ�֣���Щ�ô������� 

- �������Ĵ��� ? ֻд��Ҫ�Ĵ��� 

- ���õ���� 

- ����ɫ������� ? ��������Ա����ӿڱ��- �����ٵķ��� ? ���ᵽϵͳ����ʱ��֪��bug�Ĵ���

���䣺������������ĸ����Ѿ��кܶ����ˣ�����Ҳ���ֵĸı���������������ҵ��TDDҲ�����ݿ����������ġ�
TDD�����ڶ���㼶��Ӧ�ã�������Ԫ���ԣ�����һ�����еĴ��룩�����ɲ��ԣ�������֮��Ľ�������ϵͳ���ԣ��������е�ϵͳ����ϵͳ���ɲ��ԣ��������е�ϵͳ����ʹ�õĵ������������TDD��ʵʩ�����ǣ��죨ʧ�ܲ��ԣ�- �̣�ͨ�����ԣ� - �ع�������ʵʩTDD����ϸ������ο���һƪ���¡�������������֮�����ž�������ʹ��TDD����ʱ��������������Ҫ���������Ҫ����������ϵͳ�������������ϣ�������Դ������������룬�Ա�֤���Դ��������Ե�ǰ�������򷽷�չ������ʱ������Ҫ���ǲ�����������������Է�Ϊ���ࣺ 

- ��������ֻ���ݵ��ǲ���ʹ�õ��Ķ���һ��������䷽���Ĳ����б�
- ����������Ƿ�����ͬ��Ԥ����Ӧ�����п��ܰ���һЩ����״̬
- αװ��������ȡ����ʵ�汾�Ŀ��ð汾������ʵ�汾���ǻ��ࣩܶ 
- ģ���������Ա�ʾһϵ������ֵ�Ķ��󣬲��ҿ����ṩԤ����Ӧ

Java������ʵ��ģ������ĵ��������߷ǳ��࣬����EasyMock��Mockito��jMock�ȡ�

<p id="javaee-46">

#### Spring����ԭ��

1���ڲ�����ĵľ���IOC�ˣ�֮ǰ��new�������ڿ���ֱ�Ӵ������л�ȡ�� ��̬ע�룬����ʵ��������java��ķ��䡣������ʵ����������ʱ��̬��ȥ���������ö���Spring����������ʱ������xml Spring�������ļ�����̬�Ĵ������󣬺͵��ö�����ķ����ġ�
2��Spring��һ�����ľ���AOP���������̣�����Ϊĳһ����� ���мල�Ϳ��ƣ�Ҳ�����ڵ����������ľ��巽����ǰ��ȥ������ָ���� ģ�飩�Ӷ��ﵽ��һ��ģ������Ĺ��ܡ���Щ����ͨ��������ﵽ�ġ�����־������ȣ�
3��SpringĿ�ģ������ö��������ģ����ģ�飩֮��Ĺ�ϵû��ͨ������������������ͨ��������˵�� ����ģ�Spring������Щ���� �ڲ�ͨ������ȥ��̬����װ����Ҫ��ס��Spring��һ��������������������Ķ���Ż���Spring���ṩ����Щ����͹��ܡ�
4��Spring���õ�������ģʽ��ģ�巽��ģʽ��������Ȥͬѧ�����˽�һ�£� ���������������BeanFactory�����ǹ���ģʽ��ʵ�֡�BeanFactoryʹ�ÿ��Ʒ�ת��IOC��ģʽ��Ӧ�ó�������ú������Թ淶��ʵ�ʵ�Ӧ�ó������ֿ���

<p id="javaee-47">

#### Spring��ô����bean

1��ͨ��ȫ���ķ���/ͨ����������/factoryBean����������bean
2��IOC��bean���������ڣ����� ��ʼ�� ʹ�� ���٣�
3��ͨ���������򹤳���������beanʵ��
4��IOCΪbean�����Ը�ֵ���߶�����bean����
5.1����beanʵ�����ݱ�bean��ǰ�ô����� postProcessBeforeInitalization����
5.2������bean�ĳ�ʼ������
5.3����beanʵ�����ݸ�bean�ĺ��ô����� postProcessBeforeInitalization����
5.4bean����ʹ����
5.5�������ر�ʱ,����bean�����ٷ���

�й�bean����Ĳ���
1���ڹ���IOC����ʱ���Ѿ������������ļ��е���������bean����
2��Bean����Ĭ��������ǵ����ģ���ε���getBean() ��ȡbean����ʱ��ͬһ��bean����
3������scope=��prototy������ÿ�ε���getbean()������ȡbean����ʱ ÿ�ζ���һ���µĶ���
4��ͨ��spring��Ioc��������ʵ��������������ע����IOC��һ�ֵ���ʵ�ַ�ʽ��Spring���֧�ֹ��췽��ע���set����ע�룬��֧�ֽӿ�ע�룬��Ϊ����������

<p id="javaee-48">

#### SpringMVC����ԭ��(��������)

<p id="javaee-49">
#### ��˵һ��SpringMVC��������ע��

| ע��                     | ˵��                                                         |
| ------------------------ | ------------------------------------------------------------ |
| @Controller              | ���������                                                   |
| @RequestMapping          | ע�⽫URLӳ�䵽��������ض��Ĵ������ϣ�������ָ��ƥ�䷽��  |
| @PathVariable            | ע�ⷽ������������󶨵�URIģ�������ֵ��                    |
| @RequestParam            | ������Ĳ����󶨵������еĲ����ϣ�required=false��           |
| @ResponseBody            | ����������ֱ�����뵽HTTP response body�С����JSON��ʽ������ʱ�� |
| @ModelAttribute          | �������һ������ģ�����ԣ�model attributes��               |
| @requestBody;@HttpEntity |                                                              |

<p id="javaee-50">

####  SpringMVC��Struts2����

��. Spring MVC ������� Servlet, �� Struts2 �� Filter
��. Spring MVC ����΢�� Struts2 ��Щ. Spring MVC �ǻ��ڷ������, �� Sturts2 �ǻ�����, ÿ�η�һ�����󶼻�ʵ��һ�� Action.
��. Spring MVC ʹ�ø��Ӽ��, ����Ч��Spring MVC��struts2��: ֧��JSR303, ���� ajax �����������
��. Struts2 �� OGNL ���ʽʹҳ��Ŀ���Ч����� Spring MVC ����Щ.

