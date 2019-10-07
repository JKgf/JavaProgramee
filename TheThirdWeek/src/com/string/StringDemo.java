package com.string;

// 在循环中通过 String 拼接字符串

/**
	使用String方式进行拼接，反编译(javap -c filename 反编译)可以看到，
	StringBuilder被创建在循环的内部，
	这意味着每循环一次就会创建一次StringBuilder对象
	
	创建一个字符串，为字符串对象分配内存空间，会耗费掉一定的时间(CPU)与空间(内存)代价，
	作为最基础的数据类型，大量频繁的创建字符串，极大程度地影响程序的性能。
	
	过多无用的中间对象
	每次连接字符串时都会创建一个新的String对象，随着拼接次数的增多，这个对象会越来越大。
	如，进行100次拼接需要创建100个String对象才能够达到目的。
*/


public class StringDemo {
	public static void main(String[] args) {
	       String[] arr = {"Hello ", "World", "!!!"};
	       String s1 = arrayToString(arr);
	       System.out.println(s1);
	       
	   }

	   public static String arrayToString(String[] arr) {
	       String s = "";

	       s += "{";
	       for (int x = 0; x < arr.length; x++) {
	           if (x == arr.length - 1) {
	               s += arr[x];
	           } else {
	               s += arr[x];
	               s += ", ";
	           }
	       }
	       s += "}";
	       return s;
	   }
}
