package com.bob;

/**
 * @Author wangbo
 * @Date 2022/9/28 16:10
 * @Description: 监控线程
 * @Version 1.0
 * <p>
 * jps 找到pid
 * jstack pid 查看线程之间🔒
 */
public class MonitoringTheadLock {

	private static final Object LOCK_1 = new Object();
	private static final Object LOCK_2 = new Object();

	public static void main(String[] args) {
		Thread thread_1 = new Thread(() -> {
			System.out.println("execute thread_1 start");
			synchronized (LOCK_1) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					throw new RuntimeException("💤时间失败");
				}
				synchronized (LOCK_2) {
					System.out.println("execute thread_1 end");
				}
			}
		});
		Thread thread_2 = new Thread(() -> {
			System.out.println("execute thread_2 start");
			synchronized (LOCK_2) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					throw new RuntimeException("💤时间失败");
				}
				synchronized (LOCK_1) {
					System.out.println("execute thread_2");
				}
			}
		});
		thread_1.start();
		thread_2.start();
		System.out.println("execute main end");

	}
}
