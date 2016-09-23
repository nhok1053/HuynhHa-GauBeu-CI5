package com.example.hasan.contact;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Company> companyList;
    private ListView lvContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        getRefenrences();
        setupUI();
        addListener();

    }

    public void getRefenrences() {
        lvContact = (ListView) findViewById(R.id.lv_contact);
    }

    private void initData() {
        companyList = Company.getListCompany();
    }
    private void setupUI(){
        ArrayAdapter<Company> companyArrayAdapter = new ArrayAdapter<Company>(this,android.R.layout.simple_list_item_1,companyList);
        lvContact.setAdapter(companyArrayAdapter);
    }
    private void addListener(){
    lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Company company = companyList.get(i);
            FrameLayout fl = (FrameLayout) findViewById(R.id.fl_contact_detail);

            CompanyDetailFragment companyDetailFragment = new CompanyDetailFragment();

            companyDetailFragment.setContact(company);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            if(findViewById(R.id.fl_container)==null){
                fragmentTransaction.replace(R.id.fl_contact_detail,companyDetailFragment);
            }
            else{
                fragmentTransaction.replace(R.id.fl_container,companyDetailFragment);

            }
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    });
    }
}
