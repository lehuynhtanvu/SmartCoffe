package com.example.lhtv.smartcoffe.category.drinkCategory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.category.CategoryActivity;
import com.example.lhtv.smartcoffe.category.drink.AddDrinkActivity;

import butterknife.ButterKnife;

public class AddDrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink_category);

        ButterKnife.bind(this);Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddDrinkCategoryActivity.this, CategoryActivity.class));
                finish();
            }
        });
    }
}
