package com.dev118.jexample.spring.bean.api;

/**
 * 打印服务接口
 * 
 * @author Wen
 *
 */
public interface PrintService {

	public static final String HELLO = "hello";

	/**
	 * 输出Hello
	 */
	public void print();

	/**
	 * 输出Hello: ${name}
	 * 
	 * @param name
	 */
	public void print(String name);

	/**
	 * 返回 【${name}】
	 * 
	 * @param name
	 * @return
	 */
	public String format(String name);

}
