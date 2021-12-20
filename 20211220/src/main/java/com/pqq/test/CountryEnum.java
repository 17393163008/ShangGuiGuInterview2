package com.pqq.test;


import lombok.Getter;

/**
 * @author 潘勤强
 * @create 2021-12-19 18:11
 */
public enum  CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");


    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;


    }

    public static CountryEnum forEach_countryEnum(int index)
    {

        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element : myArray) {
            if(index == element.getRetCode())
            {
                return element;
            }
        }

        return null;
    }
}
