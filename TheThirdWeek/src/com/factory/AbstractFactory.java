package com.factory;
/**
 * 
 * ���󹤳�:
 * �ڹ���ģʽ�У�һ����������һ����Ʒ�����еľ����Ʒ����ͬһ�������Ʒ�����ģ�
 * �����ڲ�Ʒ�ȼ��ṹ�Ͳ�Ʒ��ĸ�����ڳ��󹤳��У�
 * ͬһ���ȼ��Ĳ�Ʒ��������һ�������Ʒ������Ʒ�ӿڣ���
 * һ�����󹤳�������ͬ�ľ��幤����ÿ�����幤�������Լ��Ĳ�Ʒ�壨������ͬ��Ʒ�ȼ���
 *
 */
public class AbstractFactory {
	// �����ӿڣ������󹤳�
	interface IFactory
	{
	    IFridge CreateFridge();
	    IAirCondition CreateAirCondition();
	}

	// ���ǵĹ������������ǵĲ�Ʒ��
	class SamsungFactory implements IFactory
	{
	    public IAirCondition CreateAirCondition()
	    {
	        // ���ǵĹ����������ǵĿյ�
	        return new SamsungAirCondition(); 
	    }
	    public IFridge CreateFridge()
	    {
	        // ���ǵĹ����������ǵı���
	        return new SamsungFridge(); 
	    }
	}

	// �����Ĺ��������������Ĳ�Ʒ��
	class GreeFactry implements IFactory
	{
	    public IAirCondition CreateAirCondition()
	    {
	        // �����Ĺ������������Ŀյ�
	        return new GreeAirCondition(); 
	    }
	    public IFridge CreateFridge()
	    {
	        // �����Ĺ������������ı���
	        return new GreeFridge(); 
	    }
	}

	// �����Ʒ�ӿ�
	interface IFridge
	{
	    // �����Ʒ�ӿ�
	    // �����action
	}

	// �յ��ӿ�
	interface IAirCondition
	{
	    // �յ���Ʒ�ӿ�
	    // �յ���action
	}

	// ���ǵı���
	public class SamsungFridge implements IFridge
	{
	    // ���Ǳ����action��property
	}

	// �����ı���
	public class GreeFridge implements  IFridge
	{
	    // ���������action��property
	}

	// ���ǵĿյ�
	public class SamsungAirCondition implements IAirCondition
	{
	    // ���ǿյ���action��property
	}

	// �����Ŀյ�
	public class GreeAirCondition implements IAirCondition
	{
	    // �����յ���action��property
	}
}


/*
  		���ֹ���ģʽ�ؼ���
���ֹ�����ʵ����Խ��Խ���ӵ�
�򵥹���ͨ������ʱ����ı�ʶ��������Ʒ����ͬ��Ʒ����ͬһ�������������������жϻ����Ų�Ʒ�����Ӷ����ӣ�����չ��ά�������鷳
����ģʽ�޷������Ʒ��Ͳ�Ʒ�ȼ��ṹ������
���󹤳�ģʽ�У�һ���������������Ʒ��������һ����Ʒ�壬��ͬ�Ĳ�Ʒ��Ĳ�Ʒ�����ڲ�ͬ�ĳ����Ʒ�����Ʒ�ӿڣ�
 */
