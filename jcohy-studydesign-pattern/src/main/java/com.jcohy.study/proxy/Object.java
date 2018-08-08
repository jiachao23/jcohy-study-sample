
package com.jcohy.study.proxy;

/**
 * @author admin
 * 定义RealSubject和Proxy的共用接口，这样就在任何使用RealSubject的地方
 * 都可以使用Proxy。

 */
public interface Object {
   void action();
}
