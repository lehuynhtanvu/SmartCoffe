package com.example.lhtv.smartcoffe.category.drinkCategory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lhtv.smartcoffe.Instance;
import com.example.lhtv.smartcoffe.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LHTV on 4/16/2018.
 */

public class FragmentDrinkCategory extends Fragment {
    @BindView(R.id.listView_drink_category)
    ListView listView;
    @BindView(R.id.btn_add_category)
    FloatingActionButton btnAddCategory;
    private View mView;
    public FragmentDrinkCategory(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.fragment_drink_category,container,false);
        try{
            ButterKnife.bind(this,mView);
        }catch (Exception e){
            e.printStackTrace();
        }

        listView.setAdapter(new DrinkCategoryAdapter(getActivity(), Instance.drinkCategoryList));
        listView.setSmoothScrollbarEnabled(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), ""+Instance.drinkCategoryList.get(position).id, Toast.LENGTH_SHORT).show();
            }
        });

        btnAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),AddDrinkCategoryActivity.class));
                getActivity().finish();
            }
        });

        return mView;
    }

}
