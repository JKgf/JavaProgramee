package com.dynamicproxy;

import java.lang.reflect.*;
public class StarHandler implements InvocationHandler {
	
	Star realStar;
	
	public StarHandler(Star realStar) {
		super();
		this.realStar = realStar;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) 
		throws Throwable {
		// TODO Auto-generated method stub
		Object object = null;
		
		System.out.println("�����ķ���ִ��ǰ");
		System.out.println("��̸, ǩ��ͬ, Ԥ����, ����Ʊ");
		
		if(method.getName().equals("sing")) {
			object = method.invoke(realStar, args);
		}
		
		System.out.println("�����ķ���ִ�к�");
		System.out.println("��β��");
		
		
		return object;
	}
	
}
