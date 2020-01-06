package com.factory;

// 工厂模式
/**
 * 
 * 在工厂模式中，已经将工厂类分开，不再将所有产品在同一工厂中生产，
 * 解决了简单工厂中不断增加的switch case的问题。如再新增一个C产品，
 * 那么只需写一个C工厂和C产品，在调用时用C工厂生产C产品即可，
 * A和B工厂和产品完全不受影响
 * 
 *
 */
	// 工厂接口
	interface IFactory 
	{
	    IProduct GetProduct();
	}

	// A工厂类
	class FactoryA implements IFactory
	{
	    IProduct productA;
	    public FactoryA()
	    {
	        this.productA = new ProductA();
	    }

	    public IProduct GetProduct() //A工厂生产A产品
	    {
	        return this.productA;
	    }
	}

	//B工厂类
	class FactoryB implements IFactory
	{
	    IProduct productB;
	    public FactoryB()
	    {
	        this.productB = new ProductB();
	    }

	    public IProduct GetProduct() //B工厂生产B产品
	    {
	        return this.productB;
	    }
	}

	//产品接口
	interface IProduct
	{
	    //产品方法
	    //......
	}

	//产品A
	class ProductA implements IProduct
	{
	    //产品属性
	    //......
	}

	//产品B
	class ProductB implements IProduct
	{
	    //产品属性
	    //......
	}

