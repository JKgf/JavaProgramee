package com.gf.serializable3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
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
	int j;
	
	// parameterized constructor
	public B(int i,int j) 
	{
		super(i);
		this.j = j;
	}
	
	// By implementing writeObject method, 
	// we can prevent
	// subclass from serialization
	private void writeObject(ObjectOutputStream out) throws IOException
	{
		throw new NotSerializableException();
	}
	
	// By implementing readObject method, 
	// we can prevent
	// subclass from de-serialization
	private void readObject(ObjectInputStream in) throws IOException
	{
		throw new NotSerializableException();
	}
	
}

public class Demo03 {
	public static void main(String[] args) 
			throws Exception 
	{
		B b1 = new B(10, 20);
		
		System.out.println("i = " + b1.i);
		System.out.println("j = " + b1.j);
		
		// Serializing B's(subclass) object 
		
		//Saving of object in a file
		FileOutputStream fos = new FileOutputStream("abc.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
			
		// Method for serialization of B's class object
		oos.writeObject(b1);
			
		// closing streams
		oos.close();
		fos.close();
			
		System.out.println("Object has been serialized");
		
		// De-Serializing B's(subclass) object 
		
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
 * 如果超类是可序列化的，但我们不希望子类被序列化： 没有直接的方法来阻止java中的子类进行序列化。
 * 程序员可以通过在子类中实现writeObject（）和readObject（）方法来实现这一点，
 * 并且需要从这些方法中抛出NotSerializableException异常。 这些方法分别在序列化和反序列化过程中执行。通过重写这些方法，
 * 我们只是实现了我们自己的定制序列化。
 */
