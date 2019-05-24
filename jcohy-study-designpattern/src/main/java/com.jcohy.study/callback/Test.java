package com.jcohy.study.callback;

/**回调的如何实现的呢????
 * Java的回调是通过接口或者内部类来实现的。
 * Java方法回调是功能定义和功能实现分享的一种手段，是一种耦合设计思想。作为一种架构，必须有自己的运行环境，并且提供用户的实现接口。
 * 1、定义回调接口和回调方法 
 * 2、Client实现回调接口和回调方法，并在Client中包含Service引用，
 * 通过引用调用Servie中的方法并且必须传入一个当前对象Client(因为当前对象实现了CallBack接口所以也属于接口对象) 
 * 3、在Service中定义一个接口对象并在方法中对初始化（将Client传过来的当前对象赋值给接口对象)，
 * 通过接口对象调用接口中方法（调用的Client实现的接口方法） 
 * 
 * 异步+回调的实现：
 * 1.定义一个回调接口包含回调方法（这是接口约定，有答案时电话联系） 
 * 2.我（Me.java）这个类实现回调接口和提供回调方法的实现，并向你注册回调（因为只有向你注册了回调你才能回调我的方法告诉我答案） 
 * 3.你（You.java）这个类提供了接收问题并回答（回答就是我向你注册的回调参数类型为接口对象）的方法 
 * 4.测试类
 * @author jiachao
 *
 */
public class Test {
	public static void main(String[] args) {
		Client client = new Client();
		client.requrst();
		System.out.println();
		//异步方式
		System.out.println("异步+回调方式:");
		Me me = new Me();
		me.askQuestion("世界有多大？");
	}
}