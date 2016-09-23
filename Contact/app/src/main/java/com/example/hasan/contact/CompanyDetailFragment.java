package com.example.hasan.contact;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class CompanyDetailFragment extends Fragment {



    private Company company;

    public CompanyDetailFragment() {
        // Required empty public constructor
    }

    private TextView tvName;
    private TextView tvPhone;
    private TextView tvWeb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_company_detail, container, false);
        getRefenren(view);
        setupUI();
        addListener();
        return view;
    }

    private void addListener() {

        tvWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String googleSearch = String.format("%s ",company.getWebsite());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearch));
                startActivity(intent);
            }
        });
        tvPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+company.getPhone()));
                startActivity(intent);
            }
        });
    }

    private void getRefenren(View view) {
        tvName = (TextView) view.findViewById(R.id.tv_name);
        tvPhone = (TextView) view.findViewById(R.id.tv_phone);
        tvWeb = (TextView) view.findViewById(R.id.tv_web);
    }
    private void setupUI() {
        tvWeb.setText(company.getWebsite());
        tvPhone.setText(company.getPhone());
        tvName.setText(company.getName());
    }



    public void setContact(Company company) {
        this.company = company;
    }
}
