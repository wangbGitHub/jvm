package com.bob;

/**
 * @Author wangbo
 * @Date 2022/10/1 17:00
 * @Description: TODO
 * @Version 1.0
 */
public class StringConstantPool {

	public static void main(String[] args) {
//		String a = "a";
//		String b = "a";
//		// true
//		System.out.println(a == b);

//		String a = new String("a1");
//		String b = "a1";
//		// false
//		System.out.println(a == b);
//		// true
//		System.out.println(a.intern() == b);

		String a = "a" + "b";
		String b = "ab";
		String c = "a" + new String("b");
		String d = new String("ab");

		// true
		System.out.println(a == b);
		// false
		System.out.println(a == c);
		// false
		System.out.println(a == d);
		// false
		System.out.println(c == d);
		// true
		System.out.println(a == c.intern());
		// true
		System.out.println(c.intern() == d.intern());
	}
}
