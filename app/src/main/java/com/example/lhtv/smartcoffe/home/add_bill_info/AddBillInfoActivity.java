package com.example.lhtv.smartcoffe.home.add_bill_info;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lhtv.smartcoffe.Instance;
import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.home.SEORecyclerViewAdapter;
import com.example.lhtv.smartcoffe.home.TableSEOActivity;
import com.example.lhtv.smartcoffe.module.BillInfo;
import com.example.lhtv.smartcoffe.module.Drink;
import com.example.lhtv.smartcoffe.module.TableDrink;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddBillInfoActivity extends AppCompatActivity {
    private GridLayoutManager gridLayoutManager;
    @BindView(R.id.recyclerView_add_bill_info)
    RecyclerView recyclerView;
    @BindView(R.id.listView_add_bill_info)
    ListView listView;
    private LinkedList<BillInfo> billInfoList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill_info);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddBillInfoActivity.this, TableSEOActivity.class));
                finish();
            }
        });
        for(int i = 0 ; i<Instance.billInfoList.size();i++){
            if(Instance.tableDrinkItemSelected.id == Instance.billInfoList.get(i).bill_id){
                billInfoList.add(Instance.billInfoList.get(i));
            }
        }
        final AddedBillAdapter listViewAdapter = new AddedBillAdapter(this,billInfoList);
        listView.setAdapter(listViewAdapter);



        gridLayoutManager = new GridLayoutManager(this,3);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(gridLayoutManager);

        AddBillInfoAdapter adapter = new AddBillInfoAdapter(Instance.drinkList,this, new AddBillInfoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Drink item) {
                for(int i = 0; i< Instance.billInfoList.size(); i++){
                    if(Instance.billInfoList.get(i).drink_id == item.id && Instance.billInfoList.get(i).bill_id == Instance.tableDrinkItemSelected.id){
                        Instance.billInfoList.get(i).count ++;
                    }
                }
                billInfoList.clear();
                for(int i = 0 ; i<Instance.billInfoList.size();i++){
                    if(Instance.tableDrinkItemSelected.id == Instance.billInfoList.get(i).bill_id){
                        billInfoList.add(Instance.billInfoList.get(i));
                    }
                }
                listViewAdapter.notifyDataSetChanged();
//                for(int i = 0;i<billInfoList.size();i++){
//                    if(billInfoList.get(i).drink_id == item.id){
//                        billInfoList.get(i).count ++;
//                        Toast.makeText(AddBillInfoActivity.this, ""+billInfoList.get(i).count, Toast.LENGTH_SHORT).show();
//
//                    }
//                }
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
