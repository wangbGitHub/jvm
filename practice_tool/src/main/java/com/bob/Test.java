package com.bob;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author wangbo
 * @Date 2022/9/28 19:19
 * @Description: TODO
 * @Version 1.0
 */
public class Test {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		List<Future<String>> list = new ArrayList<>();
		int i = 10;
		while (true){
			if (i< 1){
				break;
			}
			i--;
			Future<String> submit = service.submit(new TestCallable());
			list.add(submit);
		}

		for (Future<String> future : list){
			try {
				future.get();
				System.out.println("3");
			} catch (InterruptedException e) {
				System.out.println("1");
			} catch (ExecutionException e) {
				System.out.println("2");
			}
		}
		System.out.println("main end");

	}
}
