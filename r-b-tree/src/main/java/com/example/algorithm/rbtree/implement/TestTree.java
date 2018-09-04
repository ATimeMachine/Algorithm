package com.example.algorithm.rbtree.implement;

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
        String tmp;
        for (int i = 0; i < length; i++) {
            tmp = String.valueOf(i);
            rb.put(i, tmp);
            arr[i] = tmp;
        }

        String key = "99999";
        long start = System.nanoTime();
        for (String s : arr) {
            if (s.equals(key)) {
                System.out.println(s);
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("数组方式:" + (end - start));

        start = System.nanoTime();
        System.out.println(rb.get(Integer.valueOf(key)));
        end = System.nanoTime();
        System.out.println("红黑树:" + (end - start));
    }
}
