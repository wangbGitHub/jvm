package com.bob;

/**
 * @Author bob
 * @Date 2022/10/2 00:47
 * @Description: 测试栈深溢出
 * @Version 1.0
 * <p>
 * jvm:-Xss2M
 */
public class StackVerify {
	public static void main(String[] args) {
		recursion(0);
	}

	private static int recursion(int data) {
		System.out.println(data++);
		return recursion(data);
	}
}
