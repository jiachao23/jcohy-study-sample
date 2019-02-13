
#  Java
> #### PS:�������С�������
> #### ������ҳ��[www.jcohy.com](http://www.jcohy.com)  	

>  �ҵ�ѧϰ�ʼǣ���¼ѧϰ�����еıʼ��Լ�����������,�Լ��ҵ�һЩ�����ܽᡣ�����������ʧЧ,������֪����������ݵ���������ύ Issues �������޸�������ݡ�

## java��������
> * [������������](#javabase-1)
> * [�������η�public,private,protected,�Լ���д��Ĭ�ϣ�ʱ������](#javabase-2)
> * [String �������������������](#javabase-3)
> * [float f=3.4;�Ƿ���ȷ��](#javabase-4)
> * [short s1 = 1; s1 = s1 + 1;�д���?short s1 = 1; s1 += 1;�д���](#javabase-5)
> * [Java��û��goto��](#javabase-6)
> * [int��Integer��ʲô����](#javabase-7)
> * [&��&&������](#javabase-8)
> * [Math.round(11.5) ���ڶ��٣�Math.round(-11.5)���ڶ��٣�](#javabase-9)
> * [������Ч�ʵķ�������2����8��](#javabase-10)
> * [������û��length()������String��û��length()������](#javabase-11)
> * [��Java�У����������ǰ�Ķ���Ƕ��ѭ����](#javabase-12)
> * [��������constructor���Ƿ�ɱ���д��override����](#javabase-13)
> * [��������ֵ��ͬ(x.equals(y) == true)����ȴ���в�ͬ��hash code����仰�Բ��ԣ�](#javabase-14)
> * [�Ƿ���Լ̳�String�ࣿ](#javabase-15)
> * [��һ�����󱻵����������ݵ�һ�������󣬴˷����ɸı������������ԣ����ɷ��ر仯��Ľ������ô���ﵽ����ֵ���ݻ������ô��ݣ�](#javabase-16)
> * [String��StringBuilder��StringBuffer������](#javabase-17)
> * [���أ�Overload������д��Override�����������صķ����ܷ���ݷ������ͽ������֣�](#javabase-18)
>   *  [Ϊʲô���ܸ��ݷ����������������أ�](#18-1)
> * [char �ͱ������ܲ��ܴ���һ�����ĺ��֣�Ϊʲô��](#javabase-19)
> * [�����ࣨabstract class���ͽӿڣ�interface����ʲô��ͬ��](#javabase-20)
> * [��̬Ƕ����(Static Nested Class)���ڲ��ࣨInner Class���Ĳ�ͬ��](#javabase-21)
> * [����ģ�abstract�������Ƿ��ͬʱ�Ǿ�̬�ģ�static��,�Ƿ��ͬʱ�Ǳ��ط�����native�����Ƿ��ͬʱ��synchronized���Σ�](#javabase-22)
> * [������̬������ʵ������������](#javabase-23)
> * [�Ƿ���Դ�һ����̬��static�������ڲ������ԷǾ�̬��non-static�������ĵ��ã�](#javabase-24)
> * [���ʵ�ֶ����¡��](#javabase-25)
> * [String s = new String("xyz");�����˼����ַ�������](#javabase-26)
> * [�ӿ��Ƿ�ɼ̳У�extends���ӿڣ��������Ƿ��ʵ�֣�implements���ӿڣ��������Ƿ�ɼ̳о����ࣨconcrete class����](#javabase-27)
> * [һ��".java"Դ�ļ����Ƿ���԰�������ࣨ�����ڲ��ࣩ����ʲô���ƣ�](#javabase-28)
> * [Anonymous Inner Class(�����ڲ���)�Ƿ���Լ̳������ࣿ�Ƿ����ʵ�ֽӿڣ�](#javabase-29)
> * [�ڲ�������������İ����ࣨ�ⲿ�ࣩ�ĳ�Ա����û��ʲô���ƣ�](#javabase-30)
> * [Java �е�final�ؼ�������Щ�÷���](#javabase-31)
> * [������ִ��˳��Demo��](#javabase-32)
> * [��������֮���ת��](#javabase-33)
> * [���ʵ���ַ����ķ�ת���滻��](#javabase-34)
> * [������GB2312������ַ���ת��ΪISO-8859-1������ַ�����](#javabase-35)
> * [���ں�ʱ��](#javabase-36)
>   *  [���ȡ�������ա�Сʱ�����룿 ](#javabase-36-1)
>   *  [���ȡ�ô�1970��1��1��0ʱ0��0�뵽���ڵĺ�������](#javabase-36-2)
>   *  [���ȡ��ĳ�µ����һ�죿](#javabase-36-3)
>   *  [��θ�ʽ�����ڣ�](#javabase-36-4)
>   *  [��ӡ����ĵ�ǰʱ�̡�](#javabase-36-5)
> * [�Ƚ�һ��Java��JavaSciprt��](#javabase-37)
> * [ʲôʱ���ö��ԣ�assert����](#javabase-38)
> * [Error��Exception��ʲô����](#javabase-39)
> * [try{}����һ��return��䣬��ô���������try���finally{}��Ĵ���᲻�ᱻִ�У�ʲôʱ��ִ�У���returnǰ���Ǻ�?](#javabase-40)
> * [Java������ν����쳣�����ؼ��֣�throws��throw��try��catch��finally�ֱ����ʹ�ã�](#javabase-41)
> * [����ʱ�쳣���ܼ��쳣�к���ͬ��](#javabase-42)
> * [�г�һЩ�㳣��������ʱ�쳣��](#javabase-43)
> * [����final��finally��finalize������](#javabase-44)
> * [�쳣ʾ��](#javabase-45)
> * [����������ʽ������;��](#javabase-46)
> * [Java�������֧��������ʽ�����ģ�](#javabase-47) 
> * [�ڲ�������ⲿ����Ϊʲô��final��](#javabase-48)
> * [this & super��](#javabase-49)

<p id="javabase-1">

#### ������������

  * ���󣺳����ǽ�һ�����Ĺ�ͬ�����ܽ����������Ĺ��̣��������ݳ������Ϊ���������档����ֻ��ע��������Щ���Ժ���Ϊ��������ע��Щ��Ϊ��ϸ����ʲô��
  * �̳У��̳��Ǵ�������õ��̳���Ϣ��������Ĺ��̡��ṩ�̳���Ϣ���౻��Ϊ���ࣨ���ࡢ���ࣩ���õ��̳���Ϣ���౻��Ϊ���ࣨ�����ࣩ���̳��ñ仯�е����ϵͳ����һ���������ԣ�ͬʱ�̳�Ҳ�Ƿ�װ�����пɱ����ص���Ҫ�ֶΣ��������������Ķ��ֺ격ʿ�ġ�Java��ģʽ�������ģʽ���⡷�й�������ģʽ�Ĳ��֣���
  * ��װ��ͨ����Ϊ��װ�ǰ����ݺͲ������ݵķ����������������ݵķ���ֻ��ͨ���Ѷ���Ľӿڡ��������ı��ʾ��ǽ���ʵ��������һϵ����ȫ���Ρ���յĶ������������б�д�ķ������Ƕ�ʵ��ϸ�ڵ�һ�ַ�װ�����Ǳ�дһ������Ƕ����ݺ����ݲ����ķ�װ������˵����װ��������һ�п����صĶ�����ֻ������ṩ��򵥵ı�̽ӿڣ�����������ͨϴ�»���ȫ�Զ�ϴ�»��Ĳ������ȫ�Զ�ϴ�»���װ������˲����������򵥣���������ʹ�õ������ֻ�Ҳ�Ƿ�װ���㹻�õģ���Ϊ���������͸㶨�����е����飩��
  * ��̬����̬����ָ����ͬ�����͵Ķ����ͬһ��Ϣ������ͬ����Ӧ���򵥵�˵������ͬ���Ķ������õ���ͬ���ķ����������˲�ͬ�����顣��̬�Է�Ϊ����ʱ�Ķ�̬�Ժ�����ʱ�Ķ�̬�ԡ����������ķ�����Ϊ����������ṩ�ķ�����ô����ʱ�Ķ�̬�Կ��Խ���Ϊ����Aϵͳ����Bϵͳ�ṩ�ķ���ʱ��Bϵͳ�ж����ṩ����ķ�ʽ����һ�ж�Aϵͳ��˵����͸���ģ�����綯���뵶��Aϵͳ�����Ĺ���ϵͳ��Bϵͳ��Bϵͳ����ʹ�õ�ع�������ý����磬�������п�����̫���ܣ�Aϵͳֻ��ͨ��B�������ù���ķ�����������֪������ϵͳ�ĵײ�ʵ����ʲô������ͨ�����ַ�ʽ����˶��������������أ�overload��ʵ�ֵ��Ǳ���ʱ�Ķ�̬�ԣ�Ҳ��Ϊǰ�󶨣�����������д��override��ʵ�ֵ�������ʱ�Ķ�̬�ԣ�Ҳ��Ϊ��󶨣�������ʱ�Ķ�̬������������Ķ�����Ҫʵ�ֶ�̬��Ҫ�������£�1). ������д������̳и��ಢ��д���������еĻ����ķ�������2). �������ͣ��ø������������������Ͷ�������ͬ�������õ���ͬ���ķ����ͻ�����������Ĳ�ͬ�����ֳ���ͬ����Ϊ���� 

<p id="javabase-2">

#### �������η�public,private,protected,�Լ���д��Ĭ�ϣ�ʱ������


|           | **ͬһ����** | **ͬһ����** | **��ͬ��������** | **��ͬ���ķ�����** |
| --------- | ------------ | ------------ | ---------------- | ------------------ |
| Private   | ?            |              |                  |                    |
| Default   | ?            | ?            |                  |                    |
| Protected | ?            | ?            | ?                |                    |
| Public    | ?            | ?            | ?                | ?                  |

��ĳ�Ա��д��������ʱĬ��Ϊdefault��Ĭ�϶���ͬһ�����е��������൱�ڹ�����public�������ڲ���ͬһ�����е��������൱��˽�У�private�����ܱ�����protected���������൱�ڹ������Բ���ͬһ���е�û�и��ӹ�ϵ�����൱��˽�С�Java�У��ⲿ������η�ֻ����public��Ĭ�ϣ���ĳ�Ա�������ڲ��ࣩ�����η��������������֡�

<p id="javabase-3">

#### String �������������������

���ǡ�Java�еĻ�����������ֻ��8����byte��short��int��long��float��double��char��boolean�����˻������ͣ�primitive type����ʣ�µĶ����������ͣ�reference type����Java 5�Ժ������ö������Ҳ����һ�ֱȽ�������������͡�

<p id="javabase-4">

#### float f=3.4;�Ƿ���ȷ��

����ȷ��3.4��˫����������˫�����ͣ�double����ֵ�������ͣ�float��������ת�ͣ�down-casting��Ҳ��Ϊխ��������ɾ�����ʧ�������Ҫǿ������ת��float f =(float)3.4; ����д��float f =3.4F��

<p id="javabase-5">

#### short s1 = 1; s1 = s1 + 1;�д���?short s1 = 1; s1 += 1;�д���

����short s1 = 1; s1 = s1 + 1;����1��int���ͣ����s1+1������Ҳ��int �ͣ���Ҫǿ��ת�����Ͳ��ܸ�ֵ��short�͡���short s1 = 1; s1 += 1;������ȷ���룬��Ϊs1+= 1;�൱��s1 = (short)(s1 + 1);������������ǿ������ת����

<p id="javabase-6">

#### Java��û��goto��

goto ��Java�еı����֣���Ŀǰ�汾��Java��û��ʹ�á�������James Gosling��Java֮������д�ġ�The Java Programming Language��һ��ĸ�¼�и�����һ��Java�ؼ����б�������goto��const��������������Ŀǰ�޷�ʹ�õĹؼ��֣������Щ�ط������֮Ϊ�����֣���ʵ�����������Ӧ���и��㷺�����壬��Ϊ��ϤC���Եĳ���Ա��֪������ϵͳ�����ʹ�ù�������������ĵ��ʻ򵥴ʵ���϶�����Ϊ�����֣�

<p id="javabase-7">

#### int��Integer��ʲô����

Java��һ�����������������������ԣ�����Ϊ�˱�̵ķ��㻹�������˻����������ͣ�����Ϊ���ܹ�����Щ�����������͵��ɶ��������JavaΪÿһ�������������Ͷ������˶�Ӧ�İ�װ���ͣ�wrapper class����int�İ�װ�����Integer����Java 5��ʼ�������Զ�װ��/������ƣ�ʹ�ö��߿����໥ת����Java Ϊÿ��ԭʼ�����ṩ�˰�װ���ͣ�

- ԭʼ����: boolean��char��byte��short��int��long��float��double

- ��װ���ͣ�Boolean��Character��Byte��Short��Integer��Long��Float��Double

  ����װ�������������ӣ�

  ��һ��

  ```java
  class AutoUnboxingTest {
  	public static void main(String[] args) {
  	Integer a = new Integer(3);
  	Integer b = 3; // ��3�Զ�װ���Integer����
  	int c = 3;
  	System.out.println(a == b); // false ��������û������ͬһ����
  	System.out.println(a == c); // true a�Զ������int�����ٺ�c�Ƚ�
  	}
  }
  ```

  �ڶ�����

  ```java
  public class Test03 {
  	public static void main(String[] args) {
  		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
  		System.out.println(f1 == f2);//true
  		System.out.println(f3 == f4);//false
  	}
  }
  ```

  ������������������Ϊ�������Ҫô����trueҪô����false��������Ҫע�����f1��f2��f3��f4�ĸ���������Integer�������ã����������==����ȽϵĲ���ֵ�������á�װ��ı�����ʲô�أ������Ǹ�һ��Integer����һ��intֵ��ʱ�򣬻����Integer��ľ�̬����valueOf���������valueOf��Դ�����֪��������ʲô��

  ```java
  public static Integer valueOf(int i) {
      if (i >= IntegerCache.low && i <= IntegerCache.high)
          return IntegerCache.cache[i + (-IntegerCache.low)];
      return new Integer(i);
  }
  ```

  IntegerCache��Integer���ڲ��࣬�����������ʾ��

  ```java
  private static class IntegerCache {
      static final int low = -128;
      static final int high;
      static final Integer cache[];
  
      static {
          // high value may be configured by property
          int h = 127;
          String integerCacheHighPropValue =
              sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
          if (integerCacheHighPropValue != null) {
              try {
                  int i = parseInt(integerCacheHighPropValue);
                  i = Math.max(i, 127);
                  // Maximum array size is Integer.MAX_VALUE
                  h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
              } catch( NumberFormatException nfe) {
                  // If the property cannot be parsed into an int, ignore it.
              }
          }
          high = h;
  
          cache = new Integer[(high - low) + 1];
          int j = low;
          for(int k = 0; k < cache.length; k++)
              cache[k] = new Integer(j++);
  
          // range [-128, 127] must be interned (JLS7 5.1.7)
          assert IntegerCache.high >= 127;
      }
  
      private IntegerCache() {}
  }
  ```
  �򵥵�˵�����������������ֵ��-128��127֮�䣬��ô����new�µ�Integer���󣬶���ֱ�����ó������е�Integer���������������������f1==f2�Ľ����true����f3==f4�Ľ����false��

  <p id="javabase-8">

#### &��&&������

  &������������÷���

  * ��λ�롣

  * �߼��롣

  &&������Ƕ�·�����㡣

  �߼������·��Ĳ���Ƿǳ��޴�ģ���Ȼ���߶�Ҫ��������������˵Ĳ���ֵ����true�������ʽ��ֵ����true��&&֮���Գ�Ϊ��·��������Ϊ�����&&��ߵı��ʽ��ֵ��false���ұߵı��ʽ�ᱻֱ�Ӷ�·��������������㡣�ܶ�ʱ�����ǿ��ܶ���Ҫ��&&������&����������֤�û���¼ʱ�ж��û�������null���Ҳ��ǿ��ַ�����Ӧ��дΪ��**username != null &&!username.equals("")**�����ߵ�˳���ܽ�������������&���������Ϊ��һ������������������������ܽ����ַ�����equals�Ƚϣ���������**NullPointerException**�쳣��ע�⣺�߼����������|���Ͷ�·���������||���Ĳ��Ҳ����ˡ�

<p id="javabase-9">

#### Math.round(11.5) ���ڶ��٣�Math.round(-11.5)���ڶ��٣�

Math.round(11.5)�ķ���ֵ��12��Math.round(-11.5)�ķ���ֵ��-11�����������ԭ�����ڲ����ϼ�0.5Ȼ�������ȡ����

<p id="javabase-10">

#### ������Ч�ʵķ�������2����8��

2 << 3������3λ�൱�ڳ���2��3�η�������3λ�൱�ڳ���2��3�η�����

���䣺����Ϊ��д������дhashCode����ʱ�����ܻῴ��������ʾ�Ĵ��룺

```java
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + areaCode;
    result = prime * result + ((lineNumber == null) ? 0 : lineNumber.hashCode());
    result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
    return result;
}
```



��ʵ���ǲ�̫���ΪʲôҪʹ�������ĳ˷�������������ϣ�루ɢ���룩������Ϊʲô������Ǹ�������Ϊʲôͨ��ѡ��31�������ǰ��������Ĵ�������Լ��ٶ�һ�£�ѡ��31����Ϊ��������λ�ͼ�������������˷����Ӷ��õ����õ����ܡ�˵������������Ѿ��뵽�ˣ�31 * num �ȼ���(num << 5) - num������5λ�൱�ڳ���2��5�η��ټ�ȥ������൱�ڳ���31�����ڵ�JVM�����Զ��������Ż���

<p id="javabase-11">

#### ������û��length()������String��û��length()������

����û��length()��������length �����ԡ�String ��length()������JavaScript�У�����ַ����ĳ�����ͨ��length���Եõ��ģ���һ�����׺�Java������

<p id="javabase-12">

#### ��Java�У����������ǰ�Ķ���Ƕ��ѭ����

�������ѭ��ǰ��һ�������A��Ȼ����break A;������������ѭ������Java��֧�ִ���ǩ��break��continue��䣬�����е�������C��C++�е�goto��䣬���Ǿ���Ҫ����ʹ��gotoһ����Ӧ�ñ���ʹ�ô���ǩ��break��continue����Ϊ����������ĳ����ø����ţ��ܶ�ʱ���������෴�����ã����������﷨��ʵ��֪�����ã�

<p id="javabase-13">

#### ��������constructor���Ƿ�ɱ���д��override����

���������ܱ��̳У���˲��ܱ���д�������Ա����ء�

<p id="javabase-14">

#### ��������ֵ��ͬ(x.equals(y) == true)����ȴ���в�ͬ��hash code����仰�Բ��ԣ�

���ԣ������������x��y����x.equals(y) == true�����ǵĹ�ϣ�루hash code��Ӧ����ͬ��Java����eqauls������hashCode�����������涨�ģ�

> 1. �������������ͬ��equals��������true������ô���ǵ�hashCodeֵһ��Ҫ��ͬ��
>
> 2. ������������hashCode��ͬ�����ǲ���һ����ͬ��

��Ȼ����δ��Ҫ����Ҫ��ȥ�������������Υ��������ԭ��ͻᷢ����ʹ������ʱ����ͬ�Ķ�����Գ�����Set�����У�ͬʱ������Ԫ�ص�Ч�ʻ����½�������ʹ�ù�ϣ�洢��ϵͳ�������ϣ��Ƶ���ĳ�ͻ������ɴ�ȡ���ܼ����½�����

���䣺����equals��hashCode�������ܶ�Java����֪�������ܶ���Ҳ���ǽ���֪�����ѣ���Joshua Bloch�Ĵ�����Effective Java�����ܶ������˾����Effective Java������Java���˼�롷�Լ����ع������Ƽ��д�����������Java����Ա�ؿ��鼮������㻹û�������Ǿ͸Ͻ�ȥ����ѷ��һ���ɣ�������������equals�����ģ�

����equals�����������������������ԣ�

>  1. �Է��ԣ�x.equals(x)���뷵��true
>   2. �Գ��ԣ�x.equals(y)����trueʱ��y.equals(x)Ҳ���뷵��true
>  3. �����ԣ�x.equals(y)��y.equals(z)������trueʱ��x.equals(z)Ҳ���뷵��true
>  4. һ���ԣ���x��y���õĶ�����Ϣû�б��޸�ʱ����ε���x.equals(y)Ӧ�õõ�ͬ���ķ���ֵ�������Ҷ����κη�nullֵ������x��x.equals(null)���뷵��false��


ʵ�ָ�������equals�����ľ��ϰ���

> -  ʹ��==���������"�����Ƿ�Ϊ������������"��
>
> - ʹ��instanceof���������"�����Ƿ�Ϊ��ȷ������"��
>
> - �������еĹؼ����ԣ��������������������Ƿ���֮��ƥ�䣻
>
> - ��д��equals���������Լ����Ƿ�����Գ��ԡ������ԡ�һ���ԣ�
>
> - ��дequalsʱ����Ҫ��дhashCode��
>
> - ��Ҫ��equals���������е�Object�����滻Ϊ���������ͣ�����дʱ��Ҫ����@Overrideע�⡣

<p id="javabase-15">

#### �Ƿ���Լ̳�String�ࣿ

String ����final�࣬�����Ա��̳С�
����java�ṩ��һ��ɳ����ƾ���������ɲο�jvm�е�˫��ί�л���
���䣺�̳�String�������һ���������Ϊ����String������õ����÷�ʽ�ǹ�����ϵ��Has-A����������ϵ��Use-A�������Ǽ̳й�ϵ��Is-A����

<p id="javabase-16">

#### ��һ�����󱻵����������ݵ�һ�������󣬴˷����ɸı������������ԣ����ɷ��ر仯��Ľ������ô���ﵽ����ֵ���ݻ������ô��ݣ�

��ֵ���ݡ�Java���Եķ�������ֻ֧�ֲ�����ֵ���ݡ���һ������ʵ����Ϊһ�����������ݵ�������ʱ��������ֵ���ǶԸö�������á���������Կ����ڱ����ù����б��ı䣬���Զ������õĸı��ǲ���Ӱ�쵽�����ߵġ�C++��C#�п���ͨ�������û�����������ı䴫��Ĳ�����ֵ��

<p id="javabase-17">

#### String��StringBuilder��StringBuffer������

Javaƽ̨�ṩ���������͵��ַ�����String��StringBuffer/StringBuilder�����ǿ��Դ���Ͳ����ַ���������String��ֻ���ַ�����Ҳ����ζ��String���õ��ַ��������ǲ��ܱ��ı�ġ���StringBuffer/StringBuilder���ʾ���ַ����������ֱ�ӽ����޸ġ�StringBuilder��Java 5������ģ�����StringBuffer�ķ�����ȫ��ͬ���������������ڵ��̻߳�����ʹ�õģ���Ϊ�������з��涼û�б�synchronized���Σ�Ҳ����˵�������̰߳�ȫ�ģ��������Ч��Ҳ��StringBufferҪ�ߡ�

<p id="javabase-17-1">

##### ʲô�������+����������ַ������ӱȵ���StringBuffer/StringBuilder�����append���������ַ������ܸ��ã�

```
���ʹ���������ַ���������ʹ�� (+�����)�����ַ�����
���Ƶ���ĶԴ����ַ������в�������ʹ��
1��ȫ�ֱ���������Ҫ���߳�֧����ʹ��StringBuffer��
2���ֲ��������ߵ��̲߳��漰�̰߳�ȫ��ʹ��StringBuilder��
```

##### ��˵���������������

```java
class StringEqualTest {
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false
    }
}
```

����������������Ҫ������㣺

> 1. String�����intern������õ��ַ��������ڳ������ж�Ӧ�İ汾�����ã��������������һ���ַ�����String�����equals�����true���������������û�ж�Ӧ���ַ���������ַ���������ӵ��������У�Ȼ�󷵻س��������ַ��������ã�
> 2. �ַ�����+�����䱾���Ǵ�����StringBuilder�������append������Ȼ��ƴ�Ӻ��StringBuilder������toString���������String������һ�������javap -c StringEqualTest.class������class�ļ���Ӧ��JVM�ֽ���ָ��Ϳ��Կ�������

<p id="javabase-18">

#### ���أ�Overload������д��Override�����������صķ����ܷ���ݷ������ͽ������֣�

���������غ���д����ʵ�ֶ�̬�ķ�ʽ����������ǰ��ʵ�ֵ��Ǳ���ʱ�Ķ�̬�ԣ�������ʵ�ֵ�������ʱ�Ķ�̬�ԡ����ط�����һ�����У�ͬ���ķ�������в�ͬ�Ĳ����б�**�������Ͳ�ͬ������������ͬ���߶��߶���ͬ**������Ϊ���أ���д�����������븸��֮�䣬��дҪ�����౻��д�����븸�౻��д��������ͬ�ķ������ͣ��ȸ��౻��д�������÷��ʣ����ܱȸ��౻��д��������������쳣�����ϴ���ԭ�򣩡����ضԷ�������û�������Ҫ��

<p id="javabase-18-1">

##### Ϊʲô���ܸ��ݷ����������������أ�

������˵��**Java���������ֽ�����淽������ǩ��������**

> ��������ǩ������������������ͬ�������﷨���ţ�
>
> 1. Java�����ķ�������ǩ����
>
>    ����ǩ�� = ������ + �������� + ����˳��
>
>     ������ο���http://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.4.2
>
> 2. �ֽ������ķ�������ǩ����
>
>    ����ǩ�� = ������ + �������� + ����˳�� + ����ֵ���ͣ�
>
>     ����������ͱ�������������ͣ����������ͱ�������������ͱ���δ��������ǰ����Ϣ��FormalTypeParametersopt�������׳����쳣��Ϣ��ThrowsSignature������������+ǩ����

      Java�������أ�Overload��һ����������ҪJava���Բ���ķ�������ǩ����ͬ������������������ֵ����Class�ļ���������ͬ��ͬ���������͡�˳����ͬ����������ֵ���Ͳ�һ����Ҳ������ģ������������У���ΪJVM����ķ�������ǩ����������ֵ���͡�
      ͬ���ģ����ֶ���˵��Java���Թ涨�ֶ��޷����أ����Ʊ��벻һ��������Class�ļ���˵��ֻҪ�����ֶ����������ͣ���һ��������һ��Ҳ�ǿ��Եġ�
<p id="javabase-19">

#### char �ͱ������ܲ��ܴ���һ�����ĺ��֣�Ϊʲô��

char���Ϳ��Դ洢һ�����ĺ��֣���ΪJava��ʹ�õı�����Unicode����ѡ���κ��ض��ı��룬ֱ��ʹ���ַ����ַ����еı�ţ�����ͳһ��Ψһ��������һ��char����ռ2���ֽڣ�16���أ������Է�һ��������û����ġ�
���䣺ʹ��Unicode��ζ���ַ���JVM�ڲ����ⲿ�в�ͬ�ı�����ʽ����JVM�ڲ�����Unicode��������ַ�����JVM�ڲ�ת�Ƶ��ⲿʱ����������ļ�ϵͳ�У�����Ҫ���б���ת��������Java�����ֽ������ַ������Լ����ַ������ֽ���֮�����ת����ת��������InputStreamReader��OutputStreamReader�������������ֽ������ַ���֮����������࣬�е��˱���ת�������񣻶���C����Ա��˵��Ҫ��������ı���ת������Ҫ������union��������/�����壩�����ڴ��������ʵ���ˡ�

<p id="javabase-20">

#### �����ࣨabstract class���ͽӿڣ�interface����ʲô��ͬ��

- ������ͽӿڶ����ܹ�ʵ�����������Զ��������ͽӿ����͵����á�

- һ��������̳���ĳ�����������ʵ����ĳ���ӿڶ���Ҫ�����еĳ��󷽷�ȫ������ʵ�֣����������Ȼ��Ҫ������Ϊ�����ࡣ
- �ӿڱȳ�������ӳ�����Ϊ�������п��Զ��幹�����������г��󷽷��;��巽�������ӿ��в��ܶ��幹�����������еķ���ȫ�����ǳ��󷽷���
- �������еĳ�Ա������private��Ĭ�ϡ�protected��public�ģ����ӿ��еĳ�Աȫ����public�ģ�java8�������˽ӿ��е�Ĭ�Ϸ����뾲̬������[����鿴](https://github.com/jiachao23/jcohy-study-sample/blob/master/jcohy-study-java/markdown/java8.md)���Լ�java9������private˽�з�������
- �������п��Զ����Ա���������ӿ��ж���ĳ�Ա����ʵ���϶��ǳ�����
- �г��󷽷�������뱻����Ϊ�����࣬��������δ��Ҫ�г��󷽷���

<p id="javabase-21">

#### ��̬Ƕ����(Static Nested Class)���ڲ��ࣨInner Class���Ĳ�ͬ��

Static Nested Class�Ǳ�����Ϊ��̬��static�����ڲ��࣬�����Բ��������ⲿ��ʵ����ʵ��������ͨ�����ڲ�����Ҫ���ⲿ��ʵ���������ʵ���������﷨������ͦ����ģ�������ʾ��
```java
/**
* �˿��ࣨһ���˿ˣ�
* @author ���
*
*/
public class Poker {
	private static String[] suites = {"����", "����", "�ݻ�", "����"};
	private static int[] faces = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	private Card[] cards;
    /**
    * ������
    *
    */
    public Poker() {
        cards = new Card[52];
        for(int i = 0; i < suites.length; i++) {
        	for(int j = 0; j < faces.length; j++) {
    			cards[i * 13 + j] = new Card(suites[i], faces[j]);
    		}
		}
	}
    /**
    * ϴ�ƣ��������
    *
    */
    public void shuffle() {
    	for(int i = 0, len = cards.length; i < len; i++) {
    		int index = (int) (Math.random() * len);
   		 	Card temp = cards[index];
    		cards[index] = cards[i];
    		cards[i] = temp;
    	}
    }
    /**
    * ����
    * @param index ���Ƶ�λ��
    *
    */
    public Card deal(int index) {
    	return cards[index];
    }
    
    /**
    * ��Ƭ�ࣨһ���˿ˣ�
    * [�ڲ���]
    * @author ���
    *
    */
    public class Card {
        private String suite; // ��ɫ
        private int face; // ����
        public Card(String suite, int face) {
            this.suite = suite;
            this.face = face;
        }
        @Override
        public String toString() {
            String faceStr = "";
            switch(face) {
                case 1: faceStr = "A"; break;
                case 11: faceStr = "J"; break;
                case 12: faceStr = "Q"; break;
                case 13: faceStr = "K"; break;
                default: faceStr = String.valueOf(face);
            }
            return suite + faceStr;
        }
    }
}

//���Դ��룺
class PokerTest {
    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.shuffle(); // ϴ��
        Poker.Card c1 = poker.deal(0); // ����һ����
        // ���ڷǾ�̬�ڲ���Card
        // ֻ��ͨ�����ⲿ��Poker������ܴ���Card����
        Poker.Card c2 = poker.new Card("����", 1); // �Լ�����һ����
        System.out.println(c1); // ϴ�ƺ�ĵ�һ��
        System.out.println(c2); // ��ӡ: ����A
    }
}

```

##### ����Ĵ�����Щ�ط�������������
```java
class Outer {
	class Inner {}
	public static void foo() { 
        new Inner(); 
    }
	public void bar() { 
        new Inner();
    }
	public static void main(String[] args) {
		new Inner();
	}
}
```
Java�зǾ�̬�ڲ������Ĵ���Ҫ�������ⲿ������������������foo��main�������Ǿ�̬��������̬������û��this��Ҳ����˵û����ν���ⲿ���������޷������ڲ���������Ҫ�ھ�̬�����д����ڲ�����󣬿�����������
```java
	new Outer().new Inner();
```

<p id="javabase-22">

#### ����ģ�abstract�������Ƿ��ͬʱ�Ǿ�̬�ģ�static��,�Ƿ��ͬʱ�Ǳ��ط�����native�����Ƿ��ͬʱ��synchronized���Σ�

�����ܡ����󷽷���Ҫ������д������̬�ķ������޷�����д�ģ���˶�����ì�ܵġ����ط������ɱ��ش��루��C���룩ʵ�ֵķ����������󷽷���û��ʵ�ֵģ�Ҳ��ì�ܵġ�synchronized�ͷ�����ʵ��ϸ���йأ����󷽷����漰ʵ��ϸ�ڣ����Ҳ���໥ì�ܵġ�

<p id="javabase-23">

#### ������̬������ʵ������������

��̬�����Ǳ�static���η����εı�����Ҳ��Ϊ��������������࣬����������κ�һ������һ���಻�ܴ������ٸ����󣬾�̬�������ڴ������ҽ���һ��������ʵ����������������ĳһʵ������Ҫ�ȴ�������Ȼ��ͨ��������ܷ��ʵ�������̬��������ʵ���ö���������ڴ档

<p id="javabase-24">

#### �Ƿ���Դ�һ����̬��static�������ڲ������ԷǾ�̬��non-static�������ĵ��ã�

�����ԣ���̬����ֻ�ܷ��ʾ�̬��Ա����Ϊ�Ǿ�̬�����ĵ���Ҫ�ȴ��������ڵ��þ�̬����ʱ���ܶ���û�б���ʼ����

<p id="javabase-25">

#### ���ʵ�ֶ����¡��

�����ַ�ʽ��
1). ʵ��Cloneable�ӿڲ���дObject���е�clone()������ 
2). ʵ��Serializable�ӿڣ�ͨ����������л��ͷ����л�ʵ�ֿ�¡������ʵ����������ȿ�¡���������¡�

```java
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class MyUtil {
    private MyUtil() {
    	throw new AssertionError();
    }
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
        // ˵��������ByteArrayInputStream��ByteArrayOutputStream�����close����û���κ�����
        // �����������ڴ����ֻҪ�������������������ܹ��ͷ���Դ����һ�㲻ͬ�ڶ��ⲿ��Դ�����ļ��������ͷ�
    }
}
```
�����ǲ��Դ��룺
```java
import java.io.Serializable;
/**
* ����
* @author ���
*
*/
class Person implements Serializable {
    private static final long serialVersionUID = -9102017020286042305L;
    private String name; // ����
    private int age; // ����
    private Car car; // ����
    
    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }
    public String getName() {
    	return name;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public int getAge() {
    	return age;
    }
    public void setAge(int age) {
    	this.age = age;
    }
    public Car getCar() {
    	return car;
    }
    public void setCar(Car car) {
    	this.car = car;
    }
    
    @Override
    public String toString() {
    	return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
    }
}
/**
* С������
* @author ���
*
*/
class Car implements Serializable {
    
    private static final long serialVersionUID = -5713945027627603702L;
    private String brand; // Ʒ��
    private int maxSpeed; // ���ʱ��
    
    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }
    public String getBrand() {
    	return brand;
    }
    public void setBrand(String brand) {
    	this.brand = brand;
    }
    public int getMaxSpeed() {
    	return maxSpeed;
    }
    public void setMaxSpeed(int maxSpeed) {
    	this.maxSpeed = maxSpeed;
    }
    @Override
    public String toString() {
    	return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
    }
}
class CloneTest {
    
public static void main(String[] args) {
    try {
        Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
        Person p2 = MyUtil.clone(p1); // ��ȿ�¡
        p2.getCar().setBrand("BYD");
        // �޸Ŀ�¡��Person����p2���������������Ʒ������
        // ԭ����Person����p1���������������ܵ��κ�Ӱ��
        // ��Ϊ�ڿ�¡Person����ʱ���������������Ҳ����¡��
        System.out.println(p1);
        } catch (Exception e) {
        	e.printStackTrace();
        }
    }
}

```
ע�⣺�������л��ͷ����л�ʵ�ֵĿ�¡����������ȿ�¡������Ҫ����ͨ�������޶������Լ���Ҫ��¡�Ķ����Ƿ�֧�����л����������Ǳ�������ɵģ�����������ʱ�׳��쳣�������Ƿ�����������ʹ��Object���clone������¡�����������ڱ����ʱ��¶�������Ǻù���������������ʱ��

<p id="javabase-26">

#### String s = new String("xyz");�����˼����ַ�������

��������һ���Ǿ�̬����"xyz"��һ������new�����ڶ��ϵĶ���

<p id="javabase-27">

#### �ӿ��Ƿ�ɼ̳У�extends���ӿڣ��������Ƿ��ʵ�֣�implements���ӿڣ��������Ƿ�ɼ̳о����ࣨconcrete class����

�ӿڿ��Լ̳нӿڣ�����֧�ֶ��ؼ̳С����������ʵ��(implements)�ӿڣ�������ɼ̳о�����Ҳ���Լ̳г����ࡣ

<p id="javabase-28">

#### һ��".java"Դ�ļ����Ƿ���԰�������ࣨ�����ڲ��ࣩ����ʲô���ƣ�

���ԣ���һ��Դ�ļ������ֻ����һ�������ࣨpublic class�������ļ�������͹������������ȫ����һ�¡�

<p id="javabase-29">

#### Anonymous Inner Class(�����ڲ���)�Ƿ���Լ̳������ࣿ�Ƿ����ʵ�ֽӿڣ�

���Լ̳��������ʵ�������ӿڣ���Swing��̺�Android�����г��ô˷�ʽ��ʵ���¼������ͻص���

<p id="javabase-30">

#### �ڲ�������������İ����ࣨ�ⲿ�ࣩ�ĳ�Ա����û��ʲô���ƣ�

һ���ڲ��������Է��ʴ��������ⲿ�����ĳ�Ա������˽�г�Ա��

<p id="javabase-31">

#### Java �е�final�ؼ�������Щ�÷���

1. �����ࣺ��ʾ���಻�ܱ��̳У�
2. ���η�������ʾ�������ܱ���д��
3. ���α�������ʾ����ֻ��һ�θ�ֵ�Ժ�ֵ���ܱ��޸ģ���������

<p id="javabase-32">

#### ָ�������������н����

```java
class A {
    static {
    	System.out.print("1");
    }
    
    public A() {
    	System.out.print("2");
    }
    
    }
class B extends A{
    static {
        System.out.print("a");
    }
    public B() {
        System.out.print("b");
    }
}

public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}
```

ִ�н����1a2b2b����������ʱ�������ĵ���˳���ǣ��ȳ�ʼ����̬��Ա��Ȼ����ø��๹�������ٳ�ʼ���Ǿ�̬��Ա������������������

<p id="javabase-33">

#### ��������֮���ת����

- ��ν��ַ���ת��Ϊ�����������ͣ� 

  ���û����������Ͷ�Ӧ�İ�װ���еķ���parseXXX(String)��valueOf(String)���ɷ�����Ӧ�������ͣ�

- ��ν�������������ת��Ϊ�ַ�����

   һ�ַ����ǽ�����������������ַ�����""�����ӣ�+�����ɻ��������Ӧ���ַ�������һ�ַ����ǵ���String ���е�valueOf()����������Ӧ�ַ���

<p id="javabase-34">

#### ���ʵ���ַ����ķ�ת���滻��

�����ܶ࣬�����Լ�дʵ��Ҳ����ʹ��String��StringBuffer/StringBuilder�еķ�������һ���ܳ��������������õݹ�ʵ���ַ�����ת������������ʾ��

```java
public static String reverse(String originStr) {
	if(originStr == null || originStr.length() <= 1)
    	return originStr;
	return reverse(originStr.substring(1)) + originStr.charAt(0);
}
```

<p id="javabase-35">

#### ������GB2312������ַ���ת��ΪISO-8859-1������ַ�����

```java
String s1 = "���";
String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
```

<p id="javabase-36">

#### ���ں�ʱ�䣺

<p id="javabase-36-1">

##### ���ȡ�������ա�Сʱ�����룿 


����java.util.Calendar ʵ����������get()�������벻ͬ�Ĳ������ɻ�ò�������Ӧ��ֵ��Java 8�п���ʹ��java.time.LocalDateTimel����ȡ������������ʾ��

```java
public class DateTimeTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR));
        System.out.println(cal.get(Calendar.MONTH)); // 0 - 11
        System.out.println(cal.get(Calendar.DATE));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.MINUTE));
        System.out.println(cal.get(Calendar.SECOND));
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue()); // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
    }
}
```
<p id="javabase-36-2">

##### ���ȡ�ô�1970��1��1��0ʱ0��0�뵽���ڵĺ������� 

```java
Calendar.getInstance().getTimeInMillis();
System.currentTimeMillis();
Clock.systemDefaultZone().millis(); // Java 8
```

<p id="javabase-36-3">

##### ���ȡ��ĳ�µ����һ�죿

```java
Calendar time = Calendar.getInstance();
time.getActualMaximum(Calendar.DAY_OF_MONTH);
```

<p id="javabase-36-4">

##### ��θ�ʽ�����ڣ�

����java.text.DataFormat �����ࣨ��SimpleDateFormat�ࣩ�е�format(Date)�����ɽ����ڸ�ʽ����Java 8�п�����java.time.format.DateTimeFormatter����ʽ��ʱ�����ڣ�����������ʾ:

```java
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
class DateFormatTest {
    public static void main(String[] args) {
        SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date1 = new Date();
        System.out.println(oldFormatter.format(date1));
        // Java 8
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));
    }
}
```


���䣺Java��ʱ������APIһֱ�������Ǳ�ڸ���Ķ�����Ϊ�˽����һ���⣬Java 8���������µ�ʱ������API�����а���LocalDate��LocalTime��LocalDateTime��Clock��Instant���࣬��Щ�������ƶ�ʹ���˲���ģʽ��������̰߳�ȫ����ơ�

<p id="javabase-36-5">

##### ��ӡ����ĵ�ǰʱ�̡�

```java
import java.util.Calendar;
class YesterdayCurrent {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        System.out.println(cal.getTime());
    }
}
��Java 8�У�����������Ĵ���ʵ����ͬ�Ĺ��ܡ�
import java.time.LocalDateTime;
class YesterdayCurrent {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);
        System.out.println(yesterday);
    }
}
```

<p id="javabase-37">

#### �Ƚ�һ��Java��JavaSciprt��

JavaScript ��Java��������˾�����Ĳ�ͬ��������Ʒ��Java ��ԭSun Microsystems��˾�Ƴ����������ĳ���������ԣ��ر��ʺ��ڻ�����Ӧ�ó��򿪷�����JavaScript��Netscape��˾�Ĳ�Ʒ��Ϊ����չNetscape������Ĺ��ܶ�������һ�ֿ���Ƕ��Webҳ�������еĻ��ڶ�����¼������Ľ��������ԡ�

JavaScript��ǰ����LiveScript����Java��ǰ����Oak���ԡ�������������Լ����ͬ�����±Ƚϣ�

- ���ڶ�����������

> Java��һ�������������������ԣ���ʹ�ǿ����򵥵ĳ��򣬱�����ƶ���JavaScript���ֽű����ԣ����������������������޹صģ����û��������õĸ������������һ�ֻ��ڶ���Object-Based�����¼�������Event-Driven���ı�����ԣ�����������ṩ�˷ǳ��ḻ���ڲ����������Աʹ�á�

- ���ͺͱ���

> Java��Դ������ִ��֮ǰ�����뾭�����롣JavaScript��һ�ֽ����Ա�����ԣ���Դ���벻�辭�����룬�����������ִ�С���Ŀǰ�������������ʹ����JIT����ʱ���룩����������JavaScript������Ч�ʣ�

- ǿ���ͱ���������������
> Java����ǿ���ͱ�����飬�����б����ڱ���֮ǰ������������JavaScript�б����������͵ģ�������ʹ�ñ���ǰ���Բ���������JavaScript�Ľ�����������ʱ����ƶ����������͡�
 - �����ʽ��һ����
���䣺�����г����ĵ���������������ν�ı�׼�𰸡���ʵJava��JavaScript����Ҫ��������һ���Ǿ�̬���ԣ�һ���Ƕ�̬���ԡ�Ŀǰ�ı�����Եķ�չ�����Ǻ���ʽ���ԺͶ�̬���ԡ���Java���ࣨclass����һ�ȹ��񣬶�JavaScript�к�����function����һ�ȹ������JavaScript֧�ֺ���ʽ��̣�����ʹ��Lambda�����ͱհ���closure������ȻJava 8Ҳ��ʼ֧�ֺ���ʽ��̣��ṩ�˶�Lambda���ʽ�Լ�����ʽ�ӿڵ�֧�֡������������⣬�����Ե�ʱ����û������Լ������Իش����ӿ��ף���Ҫ��������ν�ı�׼�𰸡�

<p id="javabase-38">

#### ʲôʱ���ö��ԣ�assert����

�����������������һ�ֳ��õĵ��Է�ʽ���ܶ࿪�������ж�֧�����ֻ��ơ�һ����˵���������ڱ�֤������������ؼ�����ȷ�ԡ����Լ��ͨ���ڿ����Ͳ���ʱ������Ϊ�˱�֤�����ִ��Ч�ʣ��������������Լ��ͨ���ǹرյġ�������һ�������������ʽ����䣬��ִ��������ʱ�ٶ��ñ��ʽΪtrue��������ʽ��ֵΪfalse����ôϵͳ�ᱨ��һ��AssertionError�����Ե�ʹ��������Ĵ�����ʾ��

```java
assert(a > 0); // throws an AssertionError if a <= 0
```


���Կ�����������ʽ�� 

```java
assert Expression1; assert Expression1 : Expression2 ;
```

Expression1Ӧ�����ǲ���һ������ֵ��Expression2 �����ǵó�һ��ֵ��������ʽ�����ֵ����������ʾ���������Ϣ���ַ�����Ϣ��
Ҫ������ʱ���ö��ԣ�����������JVMʱʹ��-enableassertions����-ea��ǡ�Ҫ������ʱѡ����ö��ԣ�����������JVMʱʹ��-da����-disableassertions��ǡ�Ҫ��ϵͳ�������û���ö��ԣ���ʹ��-esa��-dsa��ǡ��������ڰ��Ļ��������û��߽��ö��ԡ�
ע�⣺���Բ�Ӧ�����κη�ʽ�ı�����״̬���򵥵�˵�����ϣ���ڲ�����ĳЩ����ʱ��ֹ�����ִ�У��Ϳ��Կ����ö�������ֹ����

<p id="javabase-39">

#### Error��Exception��ʲô����

Error��ʾϵͳ���Ĵ���ͳ��򲻱ش�����쳣���ǻָ����ǲ����ܵ������ѵ�����µ�һ���������⣻�����ڴ������������ָ�������ܴ��������������Exception��ʾ��Ҫ��׽������Ҫ������д�����쳣����һ����ƻ�ʵ�����⣻Ҳ����˵������ʾ������������������Ӳ��ᷢ���������
�����⣺2005��Ħ�������������������ʹ���ôһ�����⡰If a process reports a stack overflow run-time error, what��s the most possible cause?�������������ĸ�ѡ�

> a. lack of memory; 
>
> b. write on an invalid memory space;
>
>  c. recursive function calling;
>
>  d. array index out of boundary. 

Java����������ʱҲ���ܻ�����StackOverflowError������һ���޷��ָ��Ĵ���ֻ�������޸Ĵ����ˣ����������Ĵ���c�����д�˲���Ѹ�������ĵݹ飬����п�������ջ����Ĵ���������ʾ��

```java
class StackOverflowErrorTest {
    public static void main(String[] args) {
        main(null);
    }
}
```

��ʾ���õݹ��д����ʱһ��Ҫ�μ����㣺1. �ݹ鹫ʽ��2. ����������ʲôʱ��Ͳ��ټ����ݹ飩��

<p id="javabase-40">

#### try{}����һ��return��䣬��ô���������try���finally{}��Ĵ���᲻�ᱻִ�У�ʲôʱ��ִ�У���returnǰ���Ǻ�?

��ִ�У��ڷ������ص�����ǰִ�С�
ע�⣺��finally�иı䷵��ֵ�������ǲ��õģ���Ϊ�������finally����飬try�е�return��䲻�������ص����ߣ����Ǽ�¼�·���ֵ��finally�����ִ�����֮����������߷�����ֵ��Ȼ�������finally���޸��˷���ֵ���ͻ᷵���޸ĺ��ֵ����Ȼ����finally�з��ػ����޸ķ���ֵ��Գ�����ɺܴ�����ţ�C#��ֱ���ñ������ķ�ʽ����ֹ����Ա���������������飬Java��Ҳ����ͨ���������������﷨��鼶����������������

<p id="javabase-41">

#### Java������ν����쳣�����ؼ��֣�throws��throw��try��catch��finally�ֱ����ʹ�ã�

Javaͨ���������ķ��������쳣�����Ѹ��ֲ�ͬ���쳣���з��࣬���ṩ�����õĽӿڡ���Java�У�ÿ���쳣����һ����������Throwable����������ʵ������һ�����������쳣����׳�һ���쳣���󣬸ö����а������쳣��Ϣ�������������ķ������Բ�������쳣�����Զ�����д���Java���쳣������ͨ��5���ؼ�����ʵ�ֵģ�try��catch��throw��throws��finally��

һ�����������try��ִ��һ�γ������ϵͳ���׳���throw��һ���쳣���󣬿���ͨ����������������catch��������ͨ������ִ�д���飨finally��������try����ָ��һ��Ԥ�������쳣�ĳ���catch�Ӿ������try����棬����ָ������Ҫ������쳣�����ͣ�

throw���������ȷ���׳�һ���쳣��throws��������һ�����������׳��ĸ����쳣����Ȼ�����쳣ʱ�����޲���������

finallyΪȷ��һ�δ��벻�ܷ���ʲô�쳣״����Ҫ��ִ�У�

try������Ƕ�ף�ÿ������һ��try��䣬�쳣�Ľṹ�ͻᱻ�����쳣ջ�У�ֱ�����е�try��䶼��ɡ������һ����try���û�ж�ĳ���쳣���д����쳣ջ�ͻ�ִ�г�ջ������ֱ�������д��������쳣��try���������ս��쳣�׸�JVM��

<p id="javabase-42">

#### ����ʱ�쳣���ܼ��쳣�к���ͬ��

�쳣��ʾ�������й����п��ܳ��ֵķ�����״̬������ʱ�쳣��ʾ�������ͨ�������п����������쳣����һ�ֳ������д���ֻҪ������Ƶ�û������ͨ���Ͳ��ᷢ�����ܼ��쳣���������е������Ļ����йأ���ʹ�������������Ȼ������ʹ�õ������������

Java������Ҫ�󷽷����������׳����ܷ������ܼ��쳣�����ǲ���Ҫ����������׳�δ�����������ʱ�쳣���쳣�ͼ̳�һ��������������������о��������õĶ�������Effective Java�ж��쳣��ʹ�ø���������ָ��ԭ��

> - ��Ҫ���쳣�������������Ŀ�������������õ�API��Ӧ��ǿ�����ĵ�����Ϊ�������Ŀ�������ʹ���쳣��
> -  �Կ��Իָ������ʹ���ܼ��쳣���Ա�̴���ʹ������ʱ�쳣
> -  ���ⲻ��Ҫ��ʹ���ܼ��쳣������ͨ��һЩ״̬����ֶ��������쳣�ķ����� 
> - ����ʹ�ñ�׼���쳣 - ÿ�������׳����쳣��Ҫ���ĵ� - �����쳣��ԭ���� 
> -  ��Ҫ��catch�к��Ե����񵽵��쳣

<p id="javabase-43">

#### �г�һЩ�㳣��������ʱ�쳣��

- ArithmeticException�������쳣��
- ClassCastException����ת���쳣�� 
- IllegalArgumentException ���Ƿ������쳣�� 
- IndexOutOfBoundsException ���±�Խ���쳣��
-  NullPointerException ����ָ���쳣�� 
- SecurityException ����ȫ�쳣��

<p id="javabase-44">

#### ����final��finally��finalize������

- final�����η����ؼ��֣��������÷������һ���౻����Ϊfinal����ζ�����������������µ����࣬�����ܱ��̳У��������abstract�Ƿ���ʡ�����������Ϊfinal�����Ա�֤������ʹ���в����ı䣬������Ϊfinal�ı�������������ʱ������ֵ�������Ժ��������ֻ�ܶ�ȡ�����޸ġ�������Ϊfinal�ķ���Ҳͬ��ֻ��ʹ�ã������������б���д��
- finally��ͨ������try��catch���ĺ��湹������ִ�д���飬�����ζ�ų�����������ִ�л��Ƿ����쳣������Ĵ���ֻҪJVM���رն���ִ�У����Խ��ͷ��ⲿ��Դ�Ĵ���д��finally���С�
- finalize��Object���ж���ķ�����Java������ʹ��finalize()�����������ռ�����������ڴ��������ȥ֮ǰ����Ҫ��������������������������ռ��������ٶ���ʱ���õģ�ͨ����дfinalize()������������ϵͳ��Դ����ִ��������������

<p id="javabase-45">

#### ˵�������������н����

```java
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
class Human {
    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
```
<p id="javabase-46">

#### ����������ʽ������;��
�ڱ�д�����ַ����ĳ���ʱ���������в��ҷ���ĳЩ���ӹ�����ַ�������Ҫ��������ʽ��������������Щ����Ĺ��ߡ����仰˵��������ʽ���Ǽ�¼�ı�����Ĵ��롣
˵����������������ڴ������Ϣ����������ֵ������ʱ����Ǩ����������ʹ�ü�����������Ϣ�����ʱ������ֵ�����ַ�����������ʽ�����ڽ����ַ���ƥ��ʹ����ʱ����Ϊǿ��Ĺ��ߣ�����������Զ��ṩ�˶�������ʽ��֧�֡�

<p id="javabase-47">

#### Java�������֧��������ʽ�����ģ�
Java�е�String���ṩ��֧��������ʽ�����ķ�����������matches()��replaceAll()��replaceFirst()��split()�����⣬Java�п�����Pattern���ʾ������ʽ�������ṩ�˷ḻ��API���и���������ʽ��������ο�����������Ĵ��롣
�����⣺ - ���Ҫ���ַ����н�ȡ��һ��Ӣ��������֮ǰ���ַ��������磺������(������)(������)(������)����ȡ���Ϊ�������У���ô������ʽ��ôд��

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class RegExpTest {
    public static void main(String[] args) {
        String str = "������(������)(������)(������)";
        Pattern p = Pattern.compile(".*?(?=\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}
```

˵���������������ʽ��ʹ��������ƥ���ǰհ������������Щ���ݣ��Ƽ���һ�����Ϻ������ġ�������ʽ30�������Ž̡̳���

<p id="javabase-48">

#### �ڲ�������ⲿ����Ϊʲô��final?
�ֲ��ڲ����ܷ��ʷ����е����еľֲ�������������������ֲ��ڲ���Ķ�������������ǲ�һ�µġ���β���ʵ�ַ�����?��������finalʱ,ͨ����final�ֲ�����"����"һ��,����Ʒֱ����Ϊ�ֲ��ڲ��е����ݳ�Ա�����������ֲ��ڲ�����ʾֲ�����ʱ,��ʵ�������ʵ�������ֲ�������"����Ʒ������ôʹ��final���Σ���ʾ�临��Ʒ��ԭʼ������һ��

<p id="javabase-49">

####  this & super

1 super�����ڸ���������С������ִ��ڷ�ʽ

1.1. super.xxx(xxxΪ�������������)��˼�ǻ�ȡ������xxx�ı���������
1.2. super.xxx(); (xxxΪ������)��˼��ֱ�ӷ��ʲ����ø����еķ���
1.3. super() ���ø��๹��

ע��superֻ��ָ����ֱ�Ӹ���

2 this() & super()�ڹ��췽���е�����

2.1. ����super()����д�����๹�췽���ĵ�һ��, ������벻ͨ��
2.2. super��������ø��๹��, this��ͬһ���е�����������
2.3. ����Ҫ���ڵ�һ��
2.4. ���ܿ�����this����һ��������, ȴ���ܵ���2��
2.5. this��super���ܳ�����ͬһ����������, ������벻ͨ��
2.6. this()��super()��ָ�Ķ���,��������static������ʹ��
2.7. ����thisָ�򱾶����ָ�롣super��һ���ؼ���