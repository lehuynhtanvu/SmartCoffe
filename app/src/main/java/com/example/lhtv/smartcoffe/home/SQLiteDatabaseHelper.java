package com.example.lhtv.smartcoffe.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.lhtv.smartcoffe.module.Bill;
import com.example.lhtv.smartcoffe.module.BillInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LHTV on 4/24/2018.
 */

public class SQLiteDatabaseHelper extends SQLiteOpenHelper {

    private String TAG = "SQLiteDatabaseManager";

    public static final String DATABASE_NAME ="billList";
    private static final String TABLE_NAME ="billInfo   ";
    private static final String ID ="id";
    private static final String BILL_ID ="bill_id";
    private static final String DRINK_ID ="drink_id";
    private static final String DRINK_NAME ="drink_name";
    private static final String COUNT ="count";
    private static final String PRICE ="price";
    private static final String STATUS ="status";

    private Context context;
    public SQLiteDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        Log.d(TAG,"SQLiteDatabaseManager: ");
        this.context = context;
    }
    public SQLiteDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery = ("create table "+TABLE_NAME+" ("+
                ID+" integer primary key, "+
                BILL_ID+"  integer, "+
                DRINK_ID+" integer, "+
                DRINK_NAME+" TEXT, "+
                COUNT+" integer, "+
                PRICE+" Double, "+
                STATUS+" integer)");
        sqLiteDatabase.execSQL(sqlQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    //Add new a information
    public void addInformation(BillInfo information){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, information.getId());
        values.put(BILL_ID, information.getBill_id());
        values.put(DRINK_ID, information.getDrink_id());
        values.put(DRINK_NAME, information.getDrink_name());
        values.put(COUNT, information.getCount());
        values.put(PRICE, information.getPrice());
        values.put(STATUS, information.getStatus());
        //Neu de null thi khi value bang null thi loi
        db.insert(TABLE_NAME,null,values);
        Toast.makeText(context, "Thanh cong", Toast.LENGTH_SHORT).show();
        db.close();
    }
    /*
     Getting All Information
      */

    public LinkedList<BillInfo> getAllInformation() {
        LinkedList<BillInfo> informationList = new LinkedList<BillInfo>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BillInfo information = new BillInfo();
                information.setId(cursor.getInt(0));
                information.setBill_id(cursor.getInt(1));
                information.setDrink_id(cursor.getInt(2));
                information.setDrink_name(cursor.getString(3));
                information.setCount(cursor.getInt(4));
                information.setPrice(cursor.getDouble(5));
                information.setStatus(cursor.getInt(6));
                informationList.add(information);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return informationList;
    }
}
