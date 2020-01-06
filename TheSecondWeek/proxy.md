# java静态代理,动态代理心得体会
## **1. java 静态代理**

    首先,定义接口和接口的实现类,然后定义接口的代理对象,将接口的实例注入到代理对象中,然后通过代理对象去调用真正的实现类，实现过程非常简单也比较容易理解,静态代理的代理关系在编译期间就已经确定了的。它适合于代理类较少且确定的情况。它可实现在不修改委托类代码的情况下做一些额外的处理，比如包装礼盒，实现客户类与委托类的解耦。缺点是只适用委托方法少的情况下,试想一下如果委托类有几百上千个方法,岂不是很难受,要在代理类中写一堆的代理方法。这个需求动态代理可以搞定.

## **2. java 动态代理**
    代理类在程序运行时创建的代理方式被成为动态代理。在了解动态代理之前,我们先简回顾一下 JVM 的类加载机制中的加载阶段要做的三件事情:
    1.通过一个类的全名或其它途径来获取这个类的二进制字节流
    2.将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构
    3.在内存中生成一个代表这个类的 Class 对象,作为方法区中对这个类访问的入口
    
    而动态代理，主要发生在第一个阶段,这个阶段类的二进制字节流的来源可以有很多.所谓的动态代理就是想办法根据接口或者目标对象计算出代理类的字节码然后加载进 JVM 中。实际计算的情况会很复杂，我们借助一些诸如 JDK 动态代理实现、CGLIB第三方库来完成的.另一方面为了让生成的代理类与目标对象(就是委托类)保持一致,我们有2种做法：通过接口的 JDK动态代理 和通过继承类的 CGLIB动态代理。

## **3. JDK动态代理**

在 Java 的动态代理中,主要涉及2个类,java.lang.reflect.Proxy和java.lang.reflect.InvocationHandler

我们需要一个实现 InvocationHandler 接口的中间类,这个接口只有一个方法 invoke 方法,方法的每个参数的注释如下代码。我们对处理类中的所有方法的调用都会变成对 invoke 方法的调用，这样我们可以在 invoke 方法中添加统一的处理逻辑（也可以根据 method 参数判断是哪个方法）。中间类(实现了 InvocationHandler 的类)有一个委托类对象引用,在Invoke方法中调用了委托类对象的相应方法，通过这种聚合的方式持有委托类对象引用，把外部对 invoke 的调用最终都转为对委托类对象的调用。实际上，中间类与委托类构成了静态代理关系，在这个关系中，中间类是代理类，委托类是委托类。然后代理类与中间类也构成一个静态代理关系，在这个关系中，中间类是委托类，代理类是代理类。也就是说，动态代理关系由两组静态代理关系组成，这就是动态代理的原理。

```
public interface InvocationHandler {
    /**

- 调用处理
   @param proxy 代理类对象
  - @param methon 标识具体调用的是代理类的哪个方法
     @param args 代理类方法的参数
         */
        public Object invoke(Object proxy, Method method, Object[] args)
    throws Throwable;
    }

// 委托类接口
public interface IHelloService {

​```
/**
 * 方法1
 * @param userName
 * @return
 */
String sayHello(String userName);

/**
 * 方法2
 * @param userName
 * @return
 */
String sayByeBye(String userName);
​```

}

public class HelloService implements IHelloService {

​```
@Override
public String sayHello(String userName) {
    System.out.println(userName + " hello");
    return userName + " hello";
}

@Override
public String sayByeBye(String userName) {
    System.out.println(userName + " ByeBye");
    return userName + " ByeBye";
}
​```

}
// 中间类
public class JavaProxyInvocationHandler implements InvocationHandler {

​```
/**
 * 中间类持有委托类对象的引用,这里会构成一种静态代理关系
 */
private Object obj ;

/**
 * 有参构造器,传入委托类的对象
 * @param obj 委托类的对象
 */
public JavaProxyInvocationHandler(Object obj){
    this.obj = obj;

}

/**
 * 动态生成代理类对象,Proxy.newProxyInstance
 * @return 返回代理类的实例
 */
public Object newProxyInstance() {
    return Proxy.newProxyInstance(
            //指定代理对象的类加载器
            obj.getClass().getClassLoader(),
            //代理对象需要实现的接口，可以同时指定多个接口
            obj.getClass().getInterfaces(),
            //方法调用的实际处理者，代理对象的方法调用都会转发到这里
            this);
}
​```

​```
/**
 *
 * @param proxy 代理对象
 * @param method 代理方法
 * @param args 方法的参数
 * @return
 * @throws Throwable
 */
@Override
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("invoke before");
    Object result = method.invoke(obj, args);
    System.out.println("invoke after");
    return result;
}
​```

}

// 测试动态代理类
public class MainJavaProxy {
    public static void main(String[] args) {
        JavaProxyInvocationHandler proxyInvocationHandler = new JavaProxyInvocationHandler(new HelloService());
        IHelloService helloService = (IHelloService) proxyInvocationHandler.newProxyInstance();
        helloService.sayByeBye("paopao");
        helloService.sayHello("yupao");
    }

}
```


在上面的测试动态代理类中调用 Proxy 类的 newProxyInstance 方法来获取一个代理类实例。这个代理类实现了我们指定的接口并且会把方法调用分发到指定的调用处理器。

首先通过 newProxyInstance 方法获取代理类的实例,之后就可以通过这个代理类的实例调用代理类的方法，对代理类的方法调用都会调用中间类(实现了 invocationHandle的类)的invoke 方法，在 invoke 方法中我们调用委托类的对应方法，然后加上自己的处理逻辑。

java 动态代理最大的特点就是动态生成的代理类和委托类实现同一个接口。java 动态代理其实内部是通过反射机制实现的，也就是已知的一个对象，在运行的时候动态调用它的方法，并且调用的时候还可以加一些自己的逻辑在里面