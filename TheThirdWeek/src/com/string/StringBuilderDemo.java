package com.string;

//在循环中使用 StringBuilder 拼接字符串
/**
 * 使用StringBuilder方式进行拼接，
 * 反汇编代码，可以看到，不仅循环部分的代码更为简洁，
 * 而且它只生成了一个StringBuilder对象。
 * 显式的创建StringBuilder对象还允许你预先为其指定大小。
 * 可以避免多次重新分配缓冲
 
StringBuilder在连接时为什么效率更高？
 字符数组的扩容机制:
 	向原StringBuilder对象中追加字符串时：
1.追加对象str为null时追加'null'字符
2.确认是否需要进行扩容操作
	2.1 最小所需容量minimumCapacity是否比原数组长度要长，即当原数组长度不能满足所需最小容量时进行扩容操作。  
	2.2 计算扩容之后的容量newCapacity，newCapacity = (value.length * 2) + 2。  
	2.3 扩容后是否还小于所需的最小容量，如果小于则直接设置新容量为最小所需容量minimumCapacity。  
	2.4 newCapacity是否溢出，newCapacity是否比数组所能分配的最大容量 MAX_ARRAY_SIZE 还要大。如果是的话则判断，最小所需容量minCapacity大于Integer.MAX_VALUE时抛出内存溢出异常，如果minCapacity介于MAX_ARRAY_SIZE和Integer.MAX_VALUE之间，则新的容量为minCapacity，否则直接使用MAX_ARRAY_SIZE作为新的容量。
3.str.getChars()将str追加到value的末尾 
 扩容机制保证了，只有在满足扩容条件 minimumCapacity - value.length > 0 
 时才会进行扩容生成新的数组，所以大部分情况都是在对原数组进行操作，
 避免了产生过多的无用char[]对象，节省了系统资源的开销
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
