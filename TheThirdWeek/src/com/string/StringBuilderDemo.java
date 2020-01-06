package com.string;

//��ѭ����ʹ�� StringBuilder ƴ���ַ���
/**
 * ʹ��StringBuilder��ʽ����ƴ�ӣ�
 * �������룬���Կ���������ѭ�����ֵĴ����Ϊ��࣬
 * ������ֻ������һ��StringBuilder����
 * ��ʽ�Ĵ���StringBuilder����������Ԥ��Ϊ��ָ����С��
 * ���Ա��������·��仺��
 
StringBuilder������ʱΪʲôЧ�ʸ��ߣ�
 �ַ���������ݻ���:
 	��ԭStringBuilder������׷���ַ���ʱ��
1.׷�Ӷ���strΪnullʱ׷��'null'�ַ�
2.ȷ���Ƿ���Ҫ�������ݲ���
	2.1 ��С��������minimumCapacity�Ƿ��ԭ���鳤��Ҫ��������ԭ���鳤�Ȳ�������������С����ʱ�������ݲ�����  
	2.2 ��������֮�������newCapacity��newCapacity = (value.length * 2) + 2��  
	2.3 ���ݺ��Ƿ�С���������С���������С����ֱ������������Ϊ��С��������minimumCapacity��  
	2.4 newCapacity�Ƿ������newCapacity�Ƿ���������ܷ����������� MAX_ARRAY_SIZE ��Ҫ������ǵĻ����жϣ���С��������minCapacity����Integer.MAX_VALUEʱ�׳��ڴ�����쳣�����minCapacity����MAX_ARRAY_SIZE��Integer.MAX_VALUE֮�䣬���µ�����ΪminCapacity������ֱ��ʹ��MAX_ARRAY_SIZE��Ϊ�µ�������
3.str.getChars()��str׷�ӵ�value��ĩβ 
 ���ݻ��Ʊ�֤�ˣ�ֻ���������������� minimumCapacity - value.length > 0 
 ʱ�Ż�������������µ����飬���Դ󲿷���������ڶ�ԭ������в�����
 �����˲������������char[]���󣬽�ʡ��ϵͳ��Դ�Ŀ���
 */


public class StringBuilderDemo {
	public static void main(String[] args) {
        String[] arr = {"Hello ", "World", "!!!"};
        String s1 = arrayToString(arr);
        System.out.println(s1);
    }

    public static String arrayToString(String[] arr) {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                s.append(arr[x]);
            } else {
                s.append(arr[x]);
                s.append(", ");
            }
        }
        s.append("}");
        return s.toString();
    }
}
