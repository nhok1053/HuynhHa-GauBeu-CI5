package com.example.hasan.lab_16.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hasan.lab_16.MainActivity;
import com.example.hasan.lab_16.R;
import com.example.hasan.lab_16.managers.DBHelper;
import com.example.hasan.lab_16.models.Lists;
import com.example.hasan.lab_16.models.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {
    @BindView(R.id.btn_add)
    Button btnAdd;
    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.et_date)
    EditText et_date;

    public AddFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        ButterKnife.bind(this, v);
        addListener();
        return v;
    }

    private void addListener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note(
                        et_title.getText().toString(),
                        et_content.getText().toString(),
                        et_date.getText().toString()
                );
            DBHelper.getInstance().insert(note);
                Lists.LISTS.add(new Lists(note.getTitle()));
                ((MainActivity)getActivity()).notifiDataSetchange();
                ((MainActivity)getActivity()).reset();

                getFragmentManager().popBackStack();
            }
        });
    }

}
