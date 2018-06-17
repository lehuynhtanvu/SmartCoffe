package com.example.lhtv.smartcoffe.home;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lhtv.smartcoffe.Instance;
import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.module.BillInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LHTV on 5/16/2018.
 */

public class WaitingBillAdapter extends BaseAdapter {
    private Context context;
    private LinkedList<BillInfo> billInfoList = new LinkedList<>();

    public WaitingBillAdapter(Context context,LinkedList<BillInfo> billInfoList){
        this.context = context;
        this.billInfoList = billInfoList;
    }
    @Override
    public int getCount() {
        return billInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return billInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BillInfo item = billInfoList.get(position);
        View row = null;
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            row = layoutInflater.inflate(R.layout.waiting_bill_item,null);
        }else {
            row = convertView;
        }
        for(int i = 0;i< Instance.tableDrinkList.size();i++){
            if(Instance.tableDrinkList.get(i).id == item.bill_id){
                ((TextView)row.findViewById(R.id.waiting_table_name)).setText(Instance.tableDrinkList.get(i).name);
            }
        }
        ((TextView)row.findViewById(R.id.text_drink_name_added)).setText(item.drink_name);
        ((TextView)row.findViewById(R.id.text_drink_count)).setText(String.valueOf(item.count));
        return row;
    }
}
