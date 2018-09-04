package com.example.algorithm.sort.uitls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * FileName: Util
 * Author:   SunEee
 * Date:     2018/9/4 16:45
 * Description: 数组工具类
 */
public class Util {
    public static Integer[] ints = {1, 6, 44, 1, 8, 52, 78, 9, 54, 6, 5, 4, 7, 531, 66, 51, 98, 15, 6};

    public static List<Integer> integers;

    public static List<Integer> integerList;

    public static List<Integer> randomList;

    static {
        integers = new ArrayList<>(Arrays.asList(ints));
        integerList = new ArrayList<>();
        randomList = new ArrayList<>();
        int length = 100000;
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            integerList.add(i);
            randomList.add(random.nextInt(length));
        }
    }

}
