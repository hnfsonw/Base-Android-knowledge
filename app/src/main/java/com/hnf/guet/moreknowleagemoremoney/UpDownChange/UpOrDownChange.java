package com.hnf.guet.moreknowleagemoremoney.UpDownChange;

public class UpOrDownChange {
    public static void main(String[] args) {
        //向上转型,失去子类独有的方法
        Father sonUp = new Son();
        sonUp.fatherMethod();

        //向下转型,可以调用父类或者子类的方法
        Father father = new Father();
        Son fatherDown = (Son) father;
        fatherDown.sonMethod();

    }

}
