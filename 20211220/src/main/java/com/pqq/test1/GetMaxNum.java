package com.pqq.test1;

import java.util.Arrays;

/**
 * @author 潘勤强
 * @create 2021-12-21 10:07
 */
public class GetMaxNum {
    public static void main(String[] args) {
        int A[] = {1,2,5,4,3};
        Arrays.sort(A);   //底层是快速排序，时间复杂度为nlogn
        System.out.println(A[A.length-1]);

    }
}
