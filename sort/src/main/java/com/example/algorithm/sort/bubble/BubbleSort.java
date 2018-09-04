package com.example.algorithm.sort.bubble;

import com.example.algorithm.sort.uitls.Util;

import java.util.List;

/**
 * FileName: BubbleSort
 * Author:   SunEee
 * Date:     2018/9/4 16:24
 * Description: 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = Util.ints;
        List<Integer> arr = Util.integers;
        int length = arr.size();
        int max = arr.get(0);
        int tem;
        for (int i = 0; i < length; i++) {
            tem = arr.get(i);
            if (max < tem) {
                max = tem;
            }
        }
        System.out.println(max);
    }
}
