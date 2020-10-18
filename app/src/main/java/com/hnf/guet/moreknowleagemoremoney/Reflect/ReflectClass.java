package com.hnf.guet.moreknowleagemoremoney.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


/**
 * 反射的基本语法
 */
public class ReflectClass {
    public void main(String[] args) {
        /**
         * 获取Class对象的方式
         */

        //第一种
        Persion persion = new Persion();
        Class cls = persion.getClass();

        //第二种
        Class cls2 = Persion.class;

        //第三种
        try {
            Class cls3 = Class.forName("com.hnf.guet.moreknowleagemoremoney.Reflect.ReflectClass.Persion");
        }catch (Exception e){

        }

        /**
         * 获取类的构造方法
         */

        //获取所有构造方法00
        Constructor[] constructors = cls.getDeclaredConstructors();

        //获取所有public类型的构造方法
//        constructors = cls.getConstructors();

        //传参数获取特定参数类型的构造方法
        try {
            Constructor cons = cls.getDeclaredConstructor();//表示获取无参构造器
        }catch (Exception e){ }



        //表示获取两个参数的构造器
        try {
            Class[] p = {int.class,String.class};
            Constructor cons2 = cls.getDeclaredConstructor(p);
        }catch (Exception e){}


        //获取构造方法的类型，是公有还是私有
        for (int i = 0;i<constructors.length;i++){
            int type = constructors[i].getModifiers();
            System.out.println("构造器类型:"+ Modifier.toString(type));

            //获取构造方法的参数类型
            Class[] paramTypes = constructors[i].getParameterTypes();
            System.out.println("构造方法的参数类型:"+paramTypes[i].getName());
        }


        /**
         * 调用构造方法，比如调用有两个参数的构造方法
         */
        Object instance = null;
        try {
            Class[] p = {int.class,String.class};
            Constructor cons3 = cls.getDeclaredConstructor(p);
            instance = cons3.newInstance(25,"hnf");
        }catch (Exception e){}


        //调用私有构造方法
        try {
            Constructor cons4 = cls.getDeclaredConstructor(String.class);
            cons4.setAccessible(true);
            cons4.newInstance("hnf");
        }catch (Exception e){}


        //调用私有方法,第一个参数是方法名，第二个参数是参数类型
        try {
            Method method = cls.getDeclaredMethod("testedemo",String.class);
            method.setAccessible(true);
            method.invoke("hnf");
        }catch (Exception e){}


        /**
         * 获取类的私有字段并修改值
         */
        try {
            Field field = cls.getDeclaredField("weight");
            field.setAccessible(true);
            field.set(instance,"112");
        }catch (Exception e){}


        //获取所有字段
        try {
            Field[] fields = cls.getDeclaredFields();
        }catch (Exception e){

        }


    }

    class Persion{
        int age;
        String name;
        private String weight;

        //无参构造器
        public Persion(){

        }

        //有参构造器
        public Persion(int age, String name) {
            this.age = age;
            this.name = name;
        }

        private Persion(String name) {
            this.name = name;
        }


        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        private void testedemo(String name){
            System.out.println("My name is hnf");
        }
    }
}
