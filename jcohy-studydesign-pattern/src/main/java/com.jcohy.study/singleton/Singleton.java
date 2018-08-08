package com.jcohy.study.singleton;

/**
 * ����ǰ���ַ�����������ȱ�㣺
 *1. ��Ҫ����Ĺ�����ʵ�����л�������ÿ�η����л�һ�����л��Ķ���ʱ���ᴴ��һ���µ�ʵ����
 *2.����ʹ�÷���ǿ�е���˽�й����������Ҫ������������������޸Ĺ������������ڴ����ڶ���ʵ����ʱ�����쳣����
 *��ö����ܺõĽ�������������⣬ʹ��ö�ٳ����̰߳�ȫ�ͷ�ֹ������ù�����֮�⣬���ṩ���Զ����л����ƣ���ֹ�����л���ʱ�򴴽��µĶ���
 * ˫��У�����;�̬�ڲ���ķ�ʽ���Խ���󲿷����⣬ƽʱ������ʹ�õ�����Ҳ�������ַ�ʽ��
 * 
 * @author jiachao
 *
 */
public class Singleton {

	/**
	 * 
	 * ��һ�֣�����ģʽ
	 * ����ģʽ������ص�ʱ��Ͷ�ʵ�����д�����ʵ���������������ڶ����ڡ�
	 * ���ĺô���ֻ������ص�ʱ�򴴽�һ��ʵ����������ڶ���̴߳������ʵ��������������˶��߳�ͬ�������⡣
	 * ����ȱ��Ҳ�����ԣ���ʹ�������û���õ�Ҳ�ᱻ�����������������֮��ͱ��������ڴ�ͱ��˷��ˡ�
	 */
	// ����˽�о�̬ʵ������ֹ�����ã��˴���ֵΪ null��Ŀ����ʵ���ӳټ��� 
	private static Singleton instance = new Singleton();  
	//˽�л���̬����
	private Singleton(){
	}
	public static Singleton newInstance(){  
		return instance;  
	}  


	/**
	 * �ڶ��֣�����ģʽ��
	 * ����ģʽ�е���������Ҫ��ʱ���ȥ�����ģ���������Ѿ��������ٴε��û�ȡ�ӿڽ��������´����µĶ���
	 * ����ֱ�ӷ���֮ǰ�����Ķ���
	 * ���ĳ������ʹ�õĴ����٣����Ҵ����������ĵ���Դ�϶࣬��ô����Ҫʵ�ֵ����İ��贴����
	 * ���ʱ��ʹ������ģʽ����һ�������ѡ��
	 * 
	 */
	// ����˽�о�̬ʵ������ֹ�����ã��˴���ֵΪ null��Ŀ����ʵ���ӳټ���
	//	private static Singleton instance = null;  
	//    private Singleton(){}  
	//    public static Singleton newInstance(){  
	//        if(null == instance){  
	//            instance = new Singleton();  
	//        }  
	//        return instance;  
	//    } 
	/**
	 * �������������ģʽ��û�п����̰߳�ȫ���⣬
	 * �ڶ���߳̿��ܻᲢ����������getInstance()���������´������ʵ����
	 * �����Ҫ��������߳�ͬ������
	 */
	//	private static Singleton instance = null;  
	//    private Singleton(){}  
	//    public static synchronized Singleton newInstance(){  
	//        if(null == instance){  
	//            instance = new Singleton();  
	//        }  
	//        return instance;  
	//    } 
	/**
	 * �����֣�˫��У����
	 * ����������ģʽ��������������̲߳������⣬��ʵ�����ӳټ���
	 * Ȼ�����������������⣬��Ȼ����������
	 * synchronized���ε�ͬ��������һ�㷽��Ҫ���ܶ࣬�����ε���getInstance()
	 * �ۻ���������ľͱȽϴ��ˡ���˾�����˫��У����
	 */
	//	private static Singleton instance = null;  
	//    private Singleton(){}  
	//    public static Singleton getInstance() {  
	//        if (instance == null) {  
	//            synchronized (Singleton.class) {  
	//                if (instance == null) {//2  
	//                    instance = new Singleton();  
	//                }  
	//            }  
	//        }  
	//        return instance;  
	//    }
	/**
	 * ����ָ�������Ż��Ĵ��ڣ����³�ʼ��Singleton�ͽ������ַ����instance�ֶε�˳���ǲ�ȷ���ġ�
	 * ��ĳ���̴߳�����������ʱ���ڹ��췽��������֮ǰ����Ϊ�ö���������ڴ�ռ䲢��������ֶ�����ΪĬ��ֵ��
	 * ��ʱ�Ϳ��Խ�������ڴ��ַ��ֵ��instance�ֶ��ˣ�Ȼ���ö�����ܻ�û�г�ʼ����
	 * ������������һ���߳�������getInstance��ȡ���ľ���״̬����ȷ�Ķ��󣬳���ͻ����
	 * volatile��һ�������ǽ�ָֹ���������Ż���
	 * Ҳ�ͱ�֤��instance��������ֵ��ʱ������Ѿ��ǳ�ʼ�����ģ�
	 * �Ӷ�����������˵�������⡣
	 */
	//	private static volatile Singleton instance = null;  
	//    private Singleton(){}  
	//    public static Singleton getInstance() {  
	//        if (instance == null) {  
	//            synchronized (Singleton.class) {  
	//                if (instance == null) {  
	//                    instance = new Singleton();  
	//                }  
	//            }  
	//        }  
	//        return instance;  
	//    }  
	/**
	 * �����֣��ڲ���
	 */
	//	private static class SingletonHolder{  
	//        public static Singleton instance = new Singleton();  
	//    }  
	//    private Singleton(){}  
	//    public static Singleton newInstance(){  
	//        return SingletonHolder.instance;  
	//    }  
	/**
	 * �����֣�ö��
	 * 
	 */
	//	instance;  
	//    public void whateverMethod(){}    
}
