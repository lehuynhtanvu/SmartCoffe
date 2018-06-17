package com.example.lhtv.smartcoffe.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lhtv.smartcoffe.Instance;
import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.category.table.TableAdapter;
import com.example.lhtv.smartcoffe.home.add_bill_info.AddedBillAdapter;
import com.example.lhtv.smartcoffe.module.BillInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LHTV on 4/17/2018.
 */

public class FragmentWaiting extends Fragment {
    @BindView(R.id.listView_waiting_drink)
    ListView listViewWaiting;
    private LinkedList<BillInfo> billInfoList = new LinkedList<>();
    private View mView;
    public FragmentWaiting(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.fragment_waiting,container,false);
        try{
            ButterKnife.bind(this,mView);
        }catch (Exception e){
            e.printStackTrace();
        }
        for(int i = 0 ; i<Instance.billInfoList.size();i++){
            if(Instance.billInfoList.get(i).count != 0){
                billInfoList.add(Instance.billInfoList.get(i));
            }
        }
        final WaitingBillAdapter listViewAdapter = new WaitingBillAdapter(getContext(),billInfoList);
        listViewWaiting.setAdapter(listViewAdapter);
        return mView;
    }
}
