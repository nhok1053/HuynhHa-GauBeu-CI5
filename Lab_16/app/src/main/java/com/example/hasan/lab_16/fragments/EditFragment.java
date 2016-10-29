package com.example.hasan.lab_16.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hasan.lab_16.MainActivity;
import com.example.hasan.lab_16.R;
import com.example.hasan.lab_16.managers.DBHelper;
import com.example.hasan.lab_16.models.Note;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EditFragment extends Fragment {

    @BindView(R.id.btn_save)
    Button btn_save;
    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.et_date)
    EditText et_date;


    public EditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_edit, container, false);
        ButterKnife.bind(this,v);
        addListenner();
        setupUI();
        return  v;

    }

    private void setupUI() {
        Note tempNote = ((MainActivity)getActivity()).getNote();
        et_title.setText(tempNote.getTitle());
        et_content.setText(Html.fromHtml(tempNote.getContent()));
        et_date.setText(tempNote.getDate());

    }
    private void addListenner() {
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Note note = new Note(
                        et_title.getText().toString(),
                        et_content.getText().toString(),
                        et_date.getText().toString()
                );
                DBHelper.getInstance().update(note);
                ((MainActivity)getActivity()).reset();
                getFragmentManager().popBackStack();
            }
        });
    }

}
