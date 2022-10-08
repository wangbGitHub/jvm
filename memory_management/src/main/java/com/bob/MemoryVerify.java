package com.bob;

import com.bob.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangbo
 * @Date 2022/9/27 16:44
 * @Description: 内存溢出校验
 * @Version 1.0
 * <p>
 * 场景一:
 * jvm:设置-Xms15m -Xmx15m -XX:+HeapDumpOnOutOfMemoryError -XX:-DoEscapeAnalysis
 * 不开启逃逸分析，使用以下代码，会出现大量YGC
 * jvm:设置-Xms30m -Xmx30m -XX:+HeapDumpOnOutOfMemoryError -XX:+DoEscapeAnalysis
 * 开启逃逸分析，使用以下代码，与上面基本不出现YGC
 * 场景二:
 * jvm: 设置-Xms15m -Xmx15m -XX:+HeapDumpOnOutOfMemoryError
 * 创建数组大对象 虽然jvm内存大小给了15M，但是由于数组会直接移动到堆的老年代中 内存分配时 老年代:年轻代=2:1 故直接heap溢出
 *
 *
 */
public class MemoryVerify {

	private static final List<byte[]> USERS = new ArrayList<>();


	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		Thread thread1 = new Thread(() ->{
			USERS.add(new byte[1024*1024*3]);
		});
		thread1.start();
		Thread.sleep(5000);
		Thread thread = new Thread(() ->{
			for (int i=0;i<100000000;i++){
				insertUser();
			}
		});

		thread.start();
		Thread.sleep(100000);


	}


	private static void insertUser() {
		User user = new User();
		user.setName("bob");
		user.setAge(26);
	}


}
