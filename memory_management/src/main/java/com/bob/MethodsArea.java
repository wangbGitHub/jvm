package com.bob;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wangbo
 * @Date 2022/9/27 17:42
 * @Description: 方法区元空间是否属于java堆
 * @Version 1.0
 */
public class MethodsArea {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		// 在short范围内足以让6MB的PermSize产生OOM了
		short i = 0;
		while (true) {
			set.add(String.valueOf(i++).intern());
		}
	}
}
