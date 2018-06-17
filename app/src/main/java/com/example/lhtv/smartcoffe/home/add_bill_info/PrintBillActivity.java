package com.example.lhtv.smartcoffe.home.add_bill_info;

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
import com.example.lhtv.smartcoffe.home.HomeActivity;
import com.example.lhtv.smartcoffe.home.SQLiteDatabaseHelper;
import com.example.lhtv.smartcoffe.home.TableSEOActivity;
import com.example.lhtv.smartcoffe.home.WaitingBillAdapter;
import com.example.lhtv.smartcoffe.module.BillInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrintBillActivity extends AppCompatActivity {
    @BindView(R.id.listView_print_bill) ListView mListView;
    @BindView(R.id.btn_print_bill) Button buttonPrintBill;
    @BindView(R.id.textView_price) TextView textViewTotalPrice;
    @BindView(R.id.textView_table_name) TextView textViewTableName;
    private SQLiteDatabaseHelper sqLiteDatabaseHelper;
    private LinkedList<BillInfo> billInfoList = new LinkedList<>();
    private Double totalPrice = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_bill);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrintBillActivity.this, TableSEOActivity.class));
                finish();
            }
        });
        sqLiteDatabaseHelper = new SQLiteDatabaseHelper(this);
        for(int i = 0 ; i<Instance.billInfoList.size();i++){
            if(Instance.tableDrinkItemSelected.id == Instance.billInfoList.get(i).bill_id && Instance.billInfoList.get(i).count!=0){
                billInfoList.add(Instance.billInfoList.get(i));
            }
        }
        for (int i = 0 ; i<billInfoList.size();i++){
            if(billInfoList.get(i).count != 0){
                int count = billInfoList.get(i).count;
                Double price = billInfoList.get(i).price;
                totalPrice = totalPrice + price*count;
            }
        }
        textViewTableName.setText(Instance.tableDrinkItemSelected.name);
        textViewTotalPrice.setText(String.valueOf(totalPrice));
        WaitingBillAdapter adapter = new WaitingBillAdapter(this,billInfoList);
        mListView.setAdapter(adapter);
        buttonPrintBill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0 ; i < billInfoList.size() ; i++){
                    sqLiteDatabaseHelper.addInformation(billInfoList.get(i));
                }
                for(int i = 0 ; i<Instance.billInfoList.size();i++){
                    if(Instance.tableDrinkItemSelected.id == Instance.billInfoList.get(i).bill_id && Instance.billInfoList.get(i).count!=0){
                        Instance.billInfoList.get(i).count = 0;
                    }
                }
                Toast.makeText(PrintBillActivity.this, ""+billInfoList.size(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PrintBillActivity.this,TableSEOActivity.class));
                finish();
            }
        });
    }

}
