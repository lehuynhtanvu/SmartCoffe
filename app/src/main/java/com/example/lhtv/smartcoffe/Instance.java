package com.example.lhtv.smartcoffe;

import com.example.lhtv.smartcoffe.module.BillInfo;
import com.example.lhtv.smartcoffe.module.Drink;
import com.example.lhtv.smartcoffe.module.DrinkCategory;
import com.example.lhtv.smartcoffe.module.Table;
import com.example.lhtv.smartcoffe.module.TableDrink;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LHTV on 3/13/2018.
 */

public class Instance {
    public static int userType = -1;
    public static LinkedList<Table> tableList = new LinkedList<>();
    public static LinkedList<DrinkCategory> drinkCategoryList = new LinkedList<>();
    public static LinkedList<Drink> drinkList = new LinkedList<>();
    public static LinkedList<TableDrink> tableDrinkList = new LinkedList<>();
    public static TableDrink tableDrinkItemSelected = null;
    public static LinkedList<BillInfo> billInfoList = new LinkedList<>();
    public static LinkedList<BillInfo> billPrinted = new LinkedList<>();

}
