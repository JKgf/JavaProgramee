package com.string;

// ��ѭ����ͨ�� String ƴ���ַ���

/**
	ʹ��String��ʽ����ƴ�ӣ�������(javap -c filename ������)���Կ�����
	StringBuilder��������ѭ�����ڲ���
	����ζ��ÿѭ��һ�ξͻᴴ��һ��StringBuilder����
	
	����һ���ַ�����Ϊ�ַ�����������ڴ�ռ䣬��ķѵ�һ����ʱ��(CPU)��ռ�(�ڴ�)���ۣ�
	��Ϊ��������������ͣ�����Ƶ���Ĵ����ַ���������̶ȵ�Ӱ���������ܡ�
	
	�������õ��м����
	ÿ�������ַ���ʱ���ᴴ��һ���µ�String��������ƴ�Ӵ��������࣬��������Խ��Խ��
	�磬����100��ƴ����Ҫ����100��String������ܹ��ﵽĿ�ġ�
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
