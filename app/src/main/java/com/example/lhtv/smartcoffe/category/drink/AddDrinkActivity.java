package com.example.lhtv.smartcoffe.category.drink;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.lhtv.smartcoffe.LoginActivity;
import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.WelcomeActivity;
import com.example.lhtv.smartcoffe.category.CategoryActivity;

import butterknife.ButterKnife;

public class AddDrinkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddDrinkActivity.this, CategoryActivity.class));
                finish();
            }
        });
    }
}
