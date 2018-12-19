package com.domain;


import lombok.Getter;
import lombok.Setter;

/**
 * @author: 喜🐑
 * @create: 2018-12-19 10:15
 */
@Getter
@Setter
public class Table1 {
    private String bumen;
    private String mulu;
    private String ku;
    private String tab;
    public Table1(){}
    public Table1(String bumen,String mulu,String ku,String tab){
        this.bumen=bumen;
        this.mulu=mulu;
        this.ku=ku;
        this.tab=tab;
    }
}
