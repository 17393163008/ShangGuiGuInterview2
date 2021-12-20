package com.pqq.test;

import java.util.ArrayList;

import java.util.TreeSet;

/**
 * @author 潘勤强
 * @create 2021-12-20 16:15
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        TreeSet<Integer> treeSet = new TreeSet<>();

        l1.add(1);
        l1.add(4);
        l1.add(6);
        l1.add(7);


        l2.add(2);
        l2.add(4);
        l2.add(6);
        l2.add(7);

        for(int i = 0; i < l1.size();i++){
            for (int j = 0; j < l2.size(); j++) {
                if(l1.get(i).equals(l2.get(j))){
                    treeSet.add(l1.get(i));
                }
            }
        }

        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
    }
}
