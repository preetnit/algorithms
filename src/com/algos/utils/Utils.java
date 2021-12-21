package com.algos.utils;

import java.util.List;

public class Utils {

    public static <T> void printListOfList(List<List<T>> result) {
        for (List<T> triplet : result) {
            for (T n : triplet) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
