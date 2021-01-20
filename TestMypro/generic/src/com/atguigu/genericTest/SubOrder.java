package com.atguigu.genericTest;/**
 * @Author Curry
 * @Create 2020-12-0:20
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Description todo
 * @ClassName SubOrder
 * @Author admin
 * @Date 2020/12/2 0:20
 * @Version 1.0
 */
public class SubOrder extends Order<Integer> {//SubOrder不是泛型类

    public static <E> List<E> copyFromArrayToList1(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : list) {
            list.add(e);
        }
        return list;


    }
}
