package com.example.lhtv.smartcoffe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lhtv.smartcoffe.home.HomeActivity;
import com.example.lhtv.smartcoffe.module.BillInfo;
import com.example.lhtv.smartcoffe.module.Drink;
import com.example.lhtv.smartcoffe.module.DrinkCategory;
import com.example.lhtv.smartcoffe.module.Table;
import com.example.lhtv.smartcoffe.module.TableDrink;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private String emailBoss = "vule@gmail.com";
    private String passBoss = "123";
    private String emailClient = "quyen@gmail.com";
    private String passClient = "123";

    private EditText lbEmail;
    private EditText lbPassWord;
    private Button mBtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, WelcomeActivity.class));
                finish();
            }
        });
        getTableList();
        getDrinkCategoryList();
        getDrinkList();
//        addDrinkCategoryList();
//        addDrinkList();
//        addTableList();
//        addTableDrinkList();

        mBtnLogin = (Button) findViewById(R.id.btn_login_activity);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });

        lbEmail = (EditText) findViewById(R.id.lb_email);
        lbPassWord = (EditText) findViewById(R.id.lb_password);
        lbEmail.setText("vule@gmail.com");
        lbPassWord.setText("123");
    }

    private void submitForm(){
        String email = lbEmail.getText().toString();
        String password = lbPassWord.getText().toString();

        if(email.equals(emailBoss) && password.equals(passBoss)){
            Toast.makeText(this, "Đăng nhập thành công !", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(LoginActivity.this, HomeActivity.class);
//            Bundle b = new Bundle();
//            b.putInt("position",1);
//            a.putExtra("key",b);
            Instance.userType = 1;
            startActivity(a);
        }else {
            if(email.equals(emailClient) && password.equals(passClient)){
                Toast.makeText(this, "Đăng nhập thành công !", Toast.LENGTH_SHORT).show();
                Intent a = new Intent(LoginActivity.this, HomeActivity.class);
//                Bundle b = new Bundle();
//                b.putInt("position",0);
//                a.putExtra("key",b);
                Instance.userType = 0;
                startActivity(a);
            }else {
                Toast.makeText(this, "Email hoặc Password không đúng !", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void getTableList(){
        DatabaseReference getTableList = FirebaseDatabase.getInstance().getReference("table");
        getTableList.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Instance.tableDrinkList.clear();
                for(DataSnapshot tableSnapshot : dataSnapshot.getChildren()){
                    TableDrink tableDrink = tableSnapshot.getValue(TableDrink.class);
                    Instance.tableDrinkList.add(tableDrink);
                }
                Toast.makeText(LoginActivity.this, "Table"+Instance.tableDrinkList.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void getDrinkCategoryList(){
        DatabaseReference getDrinkCategoryList = FirebaseDatabase.getInstance().getReference("drinkCategory");
        getDrinkCategoryList.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Instance.drinkCategoryList.clear();
                for (DataSnapshot drinkCategorySnapshot : dataSnapshot.getChildren()){
                    DrinkCategory drinkCategory = drinkCategorySnapshot.getValue(DrinkCategory.class);
                    Instance.drinkCategoryList.add(drinkCategory);
                }
                Toast.makeText(LoginActivity.this, "drinkCategory"+Instance.drinkCategoryList.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void getDrinkList(){
        DatabaseReference getDrinkList = FirebaseDatabase.getInstance().getReference("drink");
        getDrinkList.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Instance.drinkList.clear();
                for (DataSnapshot drinkSnapshot : dataSnapshot.getChildren()){
                    Drink drink = drinkSnapshot.getValue(Drink.class);
                    Instance.drinkList.add(drink);
                }
                Toast.makeText(LoginActivity.this, "drink"+Instance.drinkList.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
