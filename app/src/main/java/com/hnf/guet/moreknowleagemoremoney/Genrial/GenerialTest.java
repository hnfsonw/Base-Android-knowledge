package com.hnf.guet.moreknowleagemoremoney.Genrial;

/**
 * 泛型
 */

public class GenerialTest {

    /**
     * 定义一个泛型类
     */
    class GenericClass<T>{

    }

    /**
     * 定义一个泛型接口
     */
    public interface GenericInterface<T>{

    }

    /**
     * 实现泛型接口的两种方式
     */

    //第一种
    class GenericImp1 <T> implements GenericInterface<T>{

    }

    //第二种，指定具体类型
    class GenericImp2 implements GenericInterface<String>{

    }


    /**
     * 定义一个泛型方法
     */
    private static <T> T generiMethod(T a,T b){

        return a;
    }

    /**
     * 泛型中的约束和局限性
     * 1：泛型类不能实例化  比如 T a = new T();
     * 2：静态方法或者变量不能引用泛型类型变量  比如 private static T result;
     * 3：不能使用instanceof或者==判断泛型的类型
     * 4：泛型数组可以声明但是不能实例化
     * 5：泛型类不能继承Exception或者Throwable
     */

    //合法写法
    GenericClass[] genericClasses = new GenericClass[10];

    //非法写法
//    GenericClass<String> genericClass2 = new GenericClass<>()[10];


    /**
     * 泛型统配符
     */

    /*
    泛型上界通配符
     * 道理很简单，？ extends X  表示类型的上界，类型参数是X的子类，那么可以肯定的说，
     * get方法返回的一定是个X（不管是X或者X的子类）编译器是可以确定知道的。
     * 但是set方法只知道传入的是个X，至于具体是X的那个子类，不知道，就是向下转型可以但是向上转型不确定。
     * 总结：主要用于安全地访问数据，可以访问X及其子类型，并且不能写入非null的数据。
     */

    private static void printExtends(GenericClass<? extends Fruit> genericClass){

    }


    /*
    泛型下界通配符
     * ？ super  X  表示类型的下界，类型参数是X的超类（包括X本身），
     * 那么可以肯定的说，get方法返回的一定是个X的超类，那么到底是哪个超类？不知道，
     * 但是可以肯定的说，Object一定是它的超类，所以get方法返回Object。
     * 编译器是可以确定知道的。对于set方法来说，编译器不知道它需要的确切类型，但是X和X的子类可以安全的转型为X，
     就是向下转型一定可以转为X，但是向上转型不知道确定要转为哪一个。
     * 总结：主要用于安全地写入数据，可以写入X及其子类型。
     */
    public static void printSuper(GenericClass<? super Fruit> genericClass) {

    }


}
