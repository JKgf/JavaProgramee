package com.gf.serializable;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



// superclass A 
// implementing Serializable interface
class A implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int i;
	
	// parameterized constructor
	public A(int i) 
	{
		this.i = i;
	}
	
}

// subclass B 
// B class doesn't implement Serializable
// interface.
class B extends A
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int j;
	
	// parameterized constructor
	public B(int i, int j) 
	{
		super(i);
		this.j = j;
	}
}



public class Demo01 {
	public static void main(String[] args) 
			throws Exception 
	{
		B b1 = new B(10,20);
		
		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);
		
		/* Serializing B's(subclass) object */
		
		//Saving of object in a file
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
			
		// Method for serialization of B's class object
		oos.writeObject(b1);
			
		// closing streams
		oos.close();
		fos.close();
			
		System.out.println("Object has been serialized");
		
		/* De-Serializing B's(subclass) object */
		
		// Reading the object from a file
		FileInputStream fis = new FileInputStream("abc.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
			
		// Method for de-serialization of B's class object
		B b2 = (B)ois.readObject();
			
		// closing streams
		ois.close();
		fis.close();
			
		System.out.println("Object has been deserialized");
		
		System.out.println("i = " + b2.i);
		System.out.println("j = " + b2.j);
	}
}


/*
 * ��������ǿ����л��ģ���ô�����ǿ��Զ����л��ģ� ��������ǿ����л��ģ���ôĬ�������ÿ�����඼�ǿ����л��ġ�
 * ��ˣ���ʹ����û��ʵ��Serializable�ӿ� ��������ĳ���ʵ����Serializable���� ��ô����Ҳ�������л��������
 */
