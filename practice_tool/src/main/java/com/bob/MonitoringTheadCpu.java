package com.bob;

/**
 * @Author wangbo
 * @Date 2022/9/28 16:34
 * @Description: TODO
 * @Version 1.0
 */
public class MonitoringTheadCpu {

	public static void main(String[] args) {
		while (true) {
			execute();
		}
	}

	private static int execute() {
		int a = 1;
		int b = 22;
		return (a + b) * 10;
	}
}
