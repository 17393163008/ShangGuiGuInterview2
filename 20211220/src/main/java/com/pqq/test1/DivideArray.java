package com.pqq.test1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * @author 潘勤强
 * @create 2021-12-21 10:24
 */
public class DivideArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strs = scanner.nextLine().split(" ");
        int nums[] = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }

        int k = Integer.parseInt(scanner.next());

        Arrays.sort(nums);

        if(nums.length < k){
            System.out.println("数组长度不够！");
            return;
        }


        if(nums.length%k == 1){
            int block = nums.length/k+1;
            int i = 0;
            int j = nums.length-1;
            if(nums[j] == nums[j-1]+nums[i]){
                i++;
                j--;
                j--;
            }else{
                System.out.println("不能分成总和相等的"+k+"个子集");
            }
            while(i < j){
                if(nums[i]+nums[j] == nums[i+1] +  nums[j-1]){
                    i++;
                    i++;
                    j--;
                    j--;
                }else{
                    break;
                }
            }
            if(i > j){
                System.out.println("可以分成总和相同的"+k+"个子集");
            }else{
                System.out.println("不能分成总和相同的k的子集");
            }

        }else{
            int block = nums.length/k;
            int i = 0;
            int j = nums.length-1;
            while(i < j){
                if(nums[i]+nums[j] == nums[i+1] +  nums[j-1]){
                    i++;
                    i++;
                    j--;
                    j--;
                }else{
                    break;
                }
            }
            if(i > j){
                System.out.println("可以分成总和相同的"+k+"个子集");
            }else{
                System.out.println("不能分成总和相同的k的子集");
            }
        }

    }


}
