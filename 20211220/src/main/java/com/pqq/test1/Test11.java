package com.pqq.test1;

import java.util.concurrent.Callable;

/**
 * @author 潘勤强
 * @create 2021-12-21 15:47
 */
public interface Test11 {
    default int add2(int a){
        a = a+2;
        return a;
    }

}


class Test12 implements Test11{

}