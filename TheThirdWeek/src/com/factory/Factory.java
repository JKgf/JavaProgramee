package com.factory;

// �򵥹���
/**
 * 
 * �򵥹��������������swich case������if else)��ÿ������һ�ֲ�Ʒʱ��
 * �㶼��Ҫȥά�������е��ж���䣬��ɸù����಻��������
 * �����жϼ���һ�𣬸���չ��ά�������鷳��
 * ��Ʒ�͹���û��ʵ����ȫ�������һ��
 *
 */
public class Factory {
	// �����Ʒ���
	public int prodNo;
	
	// ���칤��ʱ��֪������Ʒ��ʶ
	public Factory(int prodNo) {
		this.prodNo = prodNo;
	}
	
	public IProduct GetProduct() {
		// ���ݲ�Ʒ�ı�ʶ������Ʒ
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
		// ��Ʒ����
	}
	// ��ƷB
	class ProductB implements IProduct
	{
		// ��Ʒ����
	}
	
	// ��Ʒ�ӿ�
	public interface IProduct{
		// ��Ʒ����
	}
	
	
	
}
