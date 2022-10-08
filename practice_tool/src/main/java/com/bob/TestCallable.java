package com.bob;

import java.util.concurrent.Callable;

/**
 * @Author wangbo
 * @Date 2022/9/28 19:19
 * @Description: TODO
 * @Version 1.0
 */
public class TestCallable implements Callable<String> {
	@Override
	public String call() throws Exception {
		System.out.println( Thread.currentThread().getName() + "----"+ "4");
		throw new RuntimeException();
	}
}
