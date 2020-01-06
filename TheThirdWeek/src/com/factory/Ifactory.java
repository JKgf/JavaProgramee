package com.factory;

// ����ģʽ
/**
 * 
 * �ڹ���ģʽ�У��Ѿ���������ֿ������ٽ����в�Ʒ��ͬһ������������
 * ����˼򵥹����в������ӵ�switch case�����⡣��������һ��C��Ʒ��
 * ��ôֻ��дһ��C������C��Ʒ���ڵ���ʱ��C��������C��Ʒ���ɣ�
 * A��B�����Ͳ�Ʒ��ȫ����Ӱ��
 * 
 *
 */
	// �����ӿ�
	interface IFactory 
	{
	    IProduct GetProduct();
	}

	// A������
	class FactoryA implements IFactory
	{
	    IProduct productA;
	    public FactoryA()
	    {
	        this.productA = new ProductA();
	    }

	    public IProduct GetProduct() //A��������A��Ʒ
	    {
	        return this.productA;
	    }
	}

	//B������
	class FactoryB implements IFactory
	{
	    IProduct productB;
	    public FactoryB()
	    {
	        this.productB = new ProductB();
	    }

	    public IProduct GetProduct() //B��������B��Ʒ
	    {
	        return this.productB;
	    }
	}

	//��Ʒ�ӿ�
	interface IProduct
	{
	    //��Ʒ����
	    //......
	}

	//��ƷA
	class ProductA implements IProduct
	{
	    //��Ʒ����
	    //......
	}

	//��ƷB
	class ProductB implements IProduct
	{
	    //��Ʒ����
	    //......
	}

