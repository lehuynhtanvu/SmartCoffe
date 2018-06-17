package com.example.lhtv.smartcoffe.home;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.lhtv.smartcoffe.Instance;
import com.example.lhtv.smartcoffe.LoginActivity;
import com.example.lhtv.smartcoffe.R;
import com.example.lhtv.smartcoffe.account.AccountActivity;
import com.example.lhtv.smartcoffe.category.CategoryActivity;
import com.example.lhtv.smartcoffe.module.BillInfo;
import com.example.lhtv.smartcoffe.module.Drink;
import com.example.lhtv.smartcoffe.module.DrinkCategory;
import com.example.lhtv.smartcoffe.module.Table;
import com.example.lhtv.smartcoffe.module.TableDrink;
import com.example.lhtv.smartcoffe.statistic.StatisticActivity;
import com.example.lhtv.smartcoffe.work.WorkActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.home_tabs)
    TabLayout tabLayout;
    @BindView(R.id.container)
    ViewPager viewPager;

    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        navigationView = (NavigationView)findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // Add data
        addDefaultBill();
        addControl();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.nav_tai_khoan:
                        startActivity(new Intent(HomeActivity.this, AccountActivity.class));
                        break;
                    case R.id.nav_danh_muc:
                        startActivity(new Intent(HomeActivity.this, CategoryActivity.class));
                        break;
                    case R.id.nav_nghiep_vu:
                        startActivity(new Intent(HomeActivity.this, WorkActivity.class));
                        break;
                    case R.id.nav_thong_ke:
                        startActivity(new Intent(HomeActivity.this, StatisticActivity.class));
                        break;
                    case R.id.nav_sign_out:
                        Instance.userType = -1;
                        startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                        finish();
                        break;
                }
                return false;
            }
        });

        if(Instance.userType != 1){
            navigationView.setVisibility(View.GONE);
        }
    }

    private void addControl(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        HomePagerAdapter adapter = new HomePagerAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(0xff000000, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
    }

    private void addDefaultBill(){
        for(int i = 0 ; i< Instance.tableDrinkList.size(); i++){
            BillInfo billInfo1 = new BillInfo(0,Instance.tableDrinkList.get(i).id,1,Instance.drinkList.get(0).name,0,Instance.drinkList.get(0).price,0);
            BillInfo billInfo2 = new BillInfo(0,Instance.tableDrinkList.get(i).id,2,Instance.drinkList.get(1).name,0,Instance.drinkList.get(1).price,0);
            BillInfo billInfo3 = new BillInfo(0,Instance.tableDrinkList.get(i).id,3,Instance.drinkList.get(2).name,0,Instance.drinkList.get(2).price,0);
            BillInfo billInfo4 = new BillInfo(0,Instance.tableDrinkList.get(i).id,4,Instance.drinkList.get(3).name,0,Instance.drinkList.get(3).price,0);
            BillInfo billInfo5 = new BillInfo(0,Instance.tableDrinkList.get(i).id,5,Instance.drinkList.get(4).name,0,Instance.drinkList.get(4).price,0);
            BillInfo billInfo6 = new BillInfo(0,Instance.tableDrinkList.get(i).id,6,Instance.drinkList.get(5).name,0,Instance.drinkList.get(5).price,0);
            BillInfo billInfo7 = new BillInfo(0,Instance.tableDrinkList.get(i).id,7,Instance.drinkList.get(6).name,0,Instance.drinkList.get(6).price,0);
            BillInfo billInfo8 = new BillInfo(0,Instance.tableDrinkList.get(i).id,8,Instance.drinkList.get(7).name,0,Instance.drinkList.get(7).price,0);
            BillInfo billInfo9 = new BillInfo(0,Instance.tableDrinkList.get(i).id,9,Instance.drinkList.get(8).name,0,Instance.drinkList.get(8).price,0);
            BillInfo billInfo10 = new BillInfo(0,Instance.tableDrinkList.get(i).id,10,Instance.drinkList.get(9).name,0,Instance.drinkList.get(9).price,0);

            Instance.billInfoList.add(billInfo1);
            Instance.billInfoList.add(billInfo2);
            Instance.billInfoList.add(billInfo3);
            Instance.billInfoList.add(billInfo4);
            Instance.billInfoList.add(billInfo5);
            Instance.billInfoList.add(billInfo6);
            Instance.billInfoList.add(billInfo7);
            Instance.billInfoList.add(billInfo8);
            Instance.billInfoList.add(billInfo9);
            Instance.billInfoList.add(billInfo10);
        }
    }


}
