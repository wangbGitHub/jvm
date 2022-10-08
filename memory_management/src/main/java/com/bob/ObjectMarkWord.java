package com.bob;

import org.openjdk.jol.info.ClassLayout;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wangbo
 * @Date 2022/10/2 00:07
 * @Description: TODO
 * @Version 1.0
 */
public class ObjectMarkWord {

	private static final Object OBJ = new Object();

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.SSS");

	public static void main(String[] args) {
		ExecutorService services = Executors.newFixedThreadPool(100);
		System.out.println(OBJ.hashCode());
		System.out.println(LocalDateTime.now().format(FORMATTER) + ClassLayout.parseInstance(OBJ).toPrintable());
		for (int i=0;i< 2; i++){
			int finalI = i;
			services.submit( () ->{
				System.out.println(LocalDateTime.now().format(FORMATTER)+  Thread.currentThread() +  ClassLayout.parseInstance(OBJ).toPrintable());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (OBJ){
					System.out.println(LocalDateTime.now().format(FORMATTER) + Thread.currentThread() +  "-- start --" + ClassLayout.parseInstance(OBJ).toPrintable());
					System.out.println("execute i:"+ finalI);
				}
				System.out.println(LocalDateTime.now().format(FORMATTER) + Thread.currentThread() +  "-- end --" + ClassLayout.parseInstance(OBJ).toPrintable());
			});
		}

	}
}
