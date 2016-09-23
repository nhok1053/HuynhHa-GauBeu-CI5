package com.example.hasan.contact;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ContactDetailActivity extends AppCompatActivity {
    public static final String EXTRA_COMPANY = "Company";
    private static final String TAG = ContactDetailActivity.class.toString();

    private Company company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        getDataFromIntent();
        openDetailFragment();
        getRefenren();
        setupUI();

    }

    private void setupUI() {

    }

    private void openDetailFragment() {
        CompanyDetailFragment companyDetailFragment = new CompanyDetailFragment();
        companyDetailFragment.setContact(company);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_contact,companyDetailFragment);
        fragmentTransaction.commit();
    }

    public void getRefenren() {

    }
    public void getDataFromIntent() {
        Intent intent = getIntent();
        company = (Company) intent.getSerializableExtra(EXTRA_COMPANY);
        Log.d(TAG, company.getName());
    }


}
