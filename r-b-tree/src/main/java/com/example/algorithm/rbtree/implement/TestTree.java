package com.example.algorithm.rbtree.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * FileName: TestTree
 * Author:   SunEee
 * Date:     2018/9/4 10:04
 * Description: 测试
 */
public class TestTree {
    public static void main(String[] args) {
        int length = 100000;
        RedBlackTree rb = new RedBlackTree();
        String[] arr = new String[length];
        List<String> strings = new ArrayList<>();
        String tmp;
        for (int i = 0; i < length; i++) {
            tmp = String.valueOf(i);
            rb.put(i, tmp);
            arr[i] = tmp;
            strings.add(tmp);
        }

        String key = "65535";

        getTime("数组方式:",() ->arr(arr,key) );
        getTime("集合:",()-> forLoop(strings,key));
        getTime("红黑树:",()-> rb.get(Integer.valueOf(key)));

    }

    private static <T>void getTime(String name, Supplier<T> supplier){
        long start = System.nanoTime();
        System.out.println(supplier.get());
        long end = System.nanoTime() - start;
        System.out.println(name + end +"--长度--" + String.valueOf(end).length() );
    }

    private static String arr(String[] arr, String key) {
        for (String s : arr) {
            if (s.equals(key)) {
                return s;
            }
        }
        return null;
    }

    private static String forLoop(List<String> strings, String key) {
        for (String string : strings) {
            if (string.equals(key)) {
                return string;
            }
        }
        return null;
    }

}
