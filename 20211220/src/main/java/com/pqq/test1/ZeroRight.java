package com.pqq.test1;

/**
 * @author 潘勤强
 * @create 2021-12-21 10:12
 */
public class ZeroRight {
    public static void main(String[] args) {
        int arr[] = {1,0,2,3,0,4,5,0};

        int num = 0;
        int arr1[] = new int[arr.length*2];

        for(int i = 0; i < arr.length-1; i++)
        {
            if(arr[i] == 0)
            {
                arr1[num++] = 0;
                arr1[num++] = 0;
            }else{
                arr1[num++] = arr[i];
            }
        }

        //将值全部赋给arr[i]
        for(int i = 0; i < arr.length;i++)
        {
            arr[i] = arr1[i];
        }

        //验证结果
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}
