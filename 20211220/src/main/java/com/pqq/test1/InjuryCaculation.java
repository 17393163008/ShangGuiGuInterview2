package com.pqq.test1;

/**
 * @author 潘勤强
 * @create 2021-12-21 10:55
 */
public class InjuryCaculation {
    public static void main(String[] args) {

    }

    public int cal(int k1,int k2,int d1,int d2,int t,double x)
    {
        int nowTime = 0;  //当前时间
        int res1 = 0;   //第一种结果，计算两个角色各自的最大伤害和，不靠路合击
        int res2 = 0;   //考虑两个角色一直进行合击

        int r1 = 0;
        int r2 = 0;

        while(nowTime + k1 < t)
        {

            r1+=d1;
            nowTime+=k1;
        }
        while(nowTime + k2 < t)
        {
            r1+=d1;
            nowTime+=k2;
        }

        res1 = r1+r2;

        //时间进行重置
        nowTime = 0;
        while(nowTime + k1 < t || nowTime + k2 < t)
        {
            if(k1 < k2 && k2/k1 < 2){
                res2 += (d1+d2)*(1+x/100);
                nowTime+=k2;
            }else if(k2 < k1 && k1/k2 < 2){
                res2 += (d1+d2)*(1+x/100);
                nowTime+=k1;
            }else if(k2 < k1 && k1/k2 > 2){
                //这种情况。一个角色可以进行多次攻击
                res2 += (d1+d2)*(1+x/100) + (k1/k2-1)*d2;
                nowTime+=k1;
            }else{
                //这种情况。一个角色可以进行多次攻击
                res2 += (d1+d2)*(1+x/100) + (k2/k1-1)*d1;
                nowTime+=k2;
            }
        }

        return res1>res2?res1:res2;
    }

}
