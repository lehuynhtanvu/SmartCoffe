package com.example.lhtv.smartcoffe.home.add_bill_info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.module.BillInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LHTV on 5/15/2018.
 */

public class AddedBillAdapter extends BaseAdapter {
    private LinkedList<BillInfo> billInfoList = new LinkedList<>();
    private Context context;

    public AddedBillAdapter(Context context, LinkedList<BillInfo> billInfoList){
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
        BillInfo item  = billInfoList.get(position);
        View row = null;
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            row = layoutInflater.inflate(R.layout.added_bill_item,null);

        }else {
            row = convertView;
        }
        ((TextView)row.findViewById(R.id.text_drink_name_added)).setText(item.drink_name);
        ((TextView)row.findViewById(R.id.text_drink_count)).setText(String.valueOf(item.count));
        return row;
    }
}
