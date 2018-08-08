package com.jcohy.study.callback;

/**
 * 回调接口
 * @author jiachao
 *
 */
public interface CallBack {
	
	/** 
     * 这就是Service回调Client的方法 
     * @param result 回调时携带的参数（可选） 
     */  
    public void B(String result);
    
    /** 
     * 当你知道答案可以调用该回调函数告诉我答案 
     * @param result 答案 
     */  
    public void solve(String result); 
}
