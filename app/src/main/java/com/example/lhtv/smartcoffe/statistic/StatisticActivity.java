package com.example.lhtv.smartcoffe.statistic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lhtv.smartcoffe.Instance;
import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.home.SQLiteDatabaseHelper;
import com.example.lhtv.smartcoffe.home.WaitingBillAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticActivity extends AppCompatActivity {

    @BindView(R.id.textView_price)
    TextView textViewTotalPrice;
    @BindView(R.id.listView_statistic)
    ListView mListView;
    private SQLiteDatabaseHelper sqLiteDatabaseHelper;
    private Double totalPrice = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sqLiteDatabaseHelper = new SQLiteDatabaseHelper(this);
        Instance.billPrinted = sqLiteDatabaseHelper.getAllInformation();
        for (int i = 0; i< Instance.billPrinted.size(); i++){
            if(Instance.billPrinted.get(i).count != 0){
                int count = Instance.billPrinted.get(i).count;
                Double price = Instance.billPrinted.get(i).price;
                totalPrice = totalPrice + price*count;
            }
        }
        WaitingBillAdapter adapter = new WaitingBillAdapter(this,Instance.billPrinted);
        mListView.setAdapter(adapter);
        mListView.setSmoothScrollbarEnabled(true);

        textViewTotalPrice.setText(String.valueOf(totalPrice));
    }
}
