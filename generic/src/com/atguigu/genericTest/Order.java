package com.atguigu.genericTest;/**
 * @Author Curry
 * @Create 2020-12-23:59
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Description todo
 * @ClassName Order
 * @Author admin
 * @Date 2020/12/1 23:59
 * @Version 1.0
 */
public class Order<T> {
    String orderName;
    String orderId;
    //类的内部结构就可以使用类的泛型
    T orderT;

    public Order() {
//        编译不通过
//        T[] arr = new T[10];
    }

    public T getOrderT() {
        return orderT;
    }

    public Order(String orderName, String orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderId='" + orderId + '\'' +
                ", orderT=" + orderT +
                '}';
    }

    //静态结构中不能使用类泛型，因为泛型结构是在实例化的时候才知道，静态结构的加载早于对象
//    public static void show(T orderT) {
//        System.out.println(orderId);
//    }

    //编译不通过，异常的处理中不能使用泛型结构
//    public void show(T orderT) {
//        try {
//
//        }catch (T t){
//
//        }
//
//    }

    //泛型方法:在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //话句话说，泛型方法所属的类是不是泛型类都没有关系
    //泛型方法，可以声明成静态的，因为，泛型参数是在调用方法时确定的，并非是类实例化时确定
    public  <E> List<E> copyFromArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : list) {
            list.add(e);
        }
        return list;


    }


}
