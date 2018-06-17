package com.example.lhtv.smartcoffe.module;

/**
 * Created by LHTV on 4/17/2018.
 */

public class BillInfo {
    public int id;
    public int bill_id;
    public int drink_id;
    public String drink_name;
    public int count;
    public Double price;
    public int status;
    // status 0 = default, 1 = waiting, 2 = done , 3 = printed;
    public BillInfo(int id,int bill_id,int drink_id,String drink_name,int count,Double price,int status){
        this.id = id;
        this.bill_id = bill_id;
        this.drink_id = drink_id;
        this.drink_name = drink_name;
        this.count = count;
        this.price = price;
        this.status = status;
    }
    public BillInfo(){}

    public int getId(){
        return id;
    }
    public int getBill_id(){
        return bill_id;
    }
    public int getDrink_id(){
        return drink_id;
    }
    public int getCount(){
        return count;
    }
    public int getStatus(){
        return status;
    }
    public Double getPrice(){
        return price;
    }
    public String getDrink_name(){
        return drink_name;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setBill_id(int bill_id){
        this.bill_id = bill_id;
    }
    public void setDrink_id(int drink_id){
        this.drink_id = drink_id;
    }
    public void setDrink_name(String drink_name){
        this.drink_name = drink_name;
    }
    public void setCount(int count){
        this.count = count;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setStatus(int status){
        this.status = status;
    }
}
