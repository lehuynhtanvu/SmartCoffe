package com.example.lhtv.smartcoffe.module;

/**
 * Created by LHTV on 4/17/2018.
 */

public class TableDrink {
    public int id;
    public int status;
    public String name;
    public int bill_id;
    //status 0: Trống, 1: đang chờ, 2:Có người.
    public TableDrink(int id, int status,String name,int bill_id){
        this.id = id;
        this.status = status;
        this.name = name;
        this.bill_id = bill_id;
    }
    public TableDrink(){
    }
}
