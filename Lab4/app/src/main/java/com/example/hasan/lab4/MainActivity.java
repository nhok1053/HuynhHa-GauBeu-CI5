package com.example.hasan.lab4;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter listAdapter;
    @BindView(R.id.lv_item)
    ListView listView;
   @BindView(R.id.flchange)
    FrameLayout frameLayout;
    public String[] main = new String[]{
            "Turn1",
            "Turn2",
            "Turn3",
            "Turn4",
            "Turn5"
    };
    public ArrayList<String> arrayList = new ArrayList<>();
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();
         addListener();
         getSupportActionBar().hide();
    }

    private void addListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                //change scenes
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();


                switch (position) {
                    case 0:
                        Fragment1 detailFragment = new Fragment1();
                        fragmentTransaction.replace(R.id.activity_main, detailFragment);
                        break;
                    case 1:
                        Fragment2 detailFragment2 = new Fragment2();
                        fragmentTransaction.replace(R.id.activity_main, detailFragment2);
                        break;
                    case 2:
                        Fragment3 detailsFrament3 = new Fragment3();
                        fragmentTransaction.replace(R.id.activity_main, detailsFrament3);
                        break;
                    case 3:
                        Fragment4 detailsFrament4 = new Fragment4();
                        fragmentTransaction.replace(R.id.activity_main, detailsFrament4);
                        break;
                    case 4:
                        Fragment5 detailsFragment5 = new Fragment5();
                        fragmentTransaction.replace(R.id.activity_main, detailsFragment5);
                        break;

                }


                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();

            }
        });
    }
    public void add() {
        for (String name : main) {
            arrayList.add(name);
        }
    }

    protected void setupUI() {
        add();
        listAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(listAdapter);
    }

}


///*
//
//
//    private String TAG = this.getClass().getName();
//
//
//
//    protected void addListener() {
//
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d(TAG, String.format("Position in Click list %d", position));
////                //change scenes
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//
//
//                switch (position){
//                    case 0:
//                        Fragment01 detailFragment = new Fragment01();
//                        fragmentTransaction.replace(R.id.activity_main, detailFragment);
//                        break;
//                    case 1:
//                        Fragment02 detailFragment2 = new Fragment02();
//                        fragmentTransaction.replace(R.id.activity_main, detailFragment2);
//                        break;
//                    case 2:
//                        break;
//                    case 3:
//                        break;
//                    case 4:
//                        break;
//
//                }
//
//
//
//                fragmentTransaction.addToBackStack(null);
//
//                fragmentTransaction.commit();
//
//
//
