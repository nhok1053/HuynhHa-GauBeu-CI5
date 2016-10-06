package com.example.hasan.lab4;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static com.example.hasan.lab4.R.drawable.view;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

ImageView imageView;
    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);
        imageView = (ImageView) v.findViewById(R.id.check);
        addListener();
        return v;
    }
    private void addListener() {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();

            }
        });
    }
}
