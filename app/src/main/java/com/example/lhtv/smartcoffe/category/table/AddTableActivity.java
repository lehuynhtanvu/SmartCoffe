package com.example.lhtv.smartcoffe.category.table;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.category.CategoryActivity;
import com.example.lhtv.smartcoffe.category.drink.AddDrinkActivity;

import butterknife.ButterKnife;

public class AddTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_table);
        ButterKnife.bind(this);Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddTableActivity.this, CategoryActivity.class));
                finish();
            }
        });
    }
}
