package com.factory;

// 简单工厂
/**
 * 
 * 简单工厂的问题就在于swich case（或者if else)。每当新增一种产品时，
 * 你都需要去维护工厂中的判断语句，造成该工厂类不断增长，
 * 各种判断挤在一起，给扩展和维护带来麻烦。
 * 产品和工厂没有实现完全解耦，绑定在一起
 *
 */
public class Factory {
	// 定义产品编号
	public int prodNo;
	
	// 构造工厂时告知工厂产品标识
	public Factory(int prodNo) {
		this.prodNo = prodNo;
	}
	
	public IProduct GetProduct() {
		// 根据产品的标识生产产品
		switch(prodNo) 
		{
			case 1:
				return new ProductA();
		    case 2:
				return new ProductB();
			default:
			
		}
		return null;
	}
	
	class ProductA implements IProduct
	{
		// 产品属性
	}
	// 产品B
	class ProductB implements IProduct
	{
		// 产品属性
	}
	
	// 产品接口
	public interface IProduct{
		// 产品方法
	}
	
	
	
}
