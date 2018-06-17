package com.example.lhtv.smartcoffe.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lhtv.smartcoffe.Instance;
import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.home.add_bill_info.AddBillInfoActivity;
import com.example.lhtv.smartcoffe.home.add_bill_info.AddedBillAdapter;
import com.example.lhtv.smartcoffe.home.add_bill_info.PrintBillActivity;
import com.example.lhtv.smartcoffe.module.Bill;
import com.example.lhtv.smartcoffe.module.BillInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TableSEOActivity extends AppCompatActivity {

    @BindView(R.id.btn_add_bill_info) Button mBtnAddBillInfo;
    @BindView(R.id.btn_delete_bill_info) Button mBtnDeleteBillInfo;
    @BindView(R.id.btn_print_bill) Button mBtnPrintBill;
    @BindView(R.id.listView_bill)
    ListView mListView;
    @BindView(R.id.textView_table_name)
    TextView textViewTableName;
    private LinkedList<BillInfo> billInfoList = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_seo);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(TableSEOActivity.this, HomeActivity.class));
                    finish();
                }
        });
        for(int i = 0 ; i<Instance.billInfoList.size();i++){
            if(Instance.tableDrinkItemSelected.id == Instance.billInfoList.get(i).bill_id){
                billInfoList.add(Instance.billInfoList.get(i));
            }
        }
        final AddedBillAdapter listViewAdapter = new AddedBillAdapter(this,billInfoList);
        mListView.setAdapter(listViewAdapter);
        textViewTableName.setText(Instance.tableDrinkItemSelected.name);

        Toast.makeText(this, ""+ Instance.tableDrinkItemSelected.name, Toast.LENGTH_SHORT).show();
        mBtnAddBillInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TableSEOActivity.this,AddBillInfoActivity.class));
                finish();
            }
        });
        mBtnPrintBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TableSEOActivity.this, PrintBillActivity.class));
                finish();
            }
        });
    }
}
