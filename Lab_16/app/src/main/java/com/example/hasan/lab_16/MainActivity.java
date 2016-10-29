package com.example.hasan.lab_16;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hasan.lab_16.adapters.Adapter;
import com.example.hasan.lab_16.fragments.AddFragment;
import com.example.hasan.lab_16.fragments.EditFragment;
import com.example.hasan.lab_16.listener.Listener;
import com.example.hasan.lab_16.managers.DBHelper;
import com.example.hasan.lab_16.models.Lists;
import com.example.hasan.lab_16.models.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();
    private List<Note> noteList;
    public static int pos;
    private Adapter adapter;
    @BindView(R.id.btn_add)
    Button btn_add;

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DBHelper.getInstance().init(this);
        reset();
        setupUI();
        notifiDataSetchange();
        addListeners();
        onResume();
    }

    private void addListeners() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new AddFragment(), true);
            }
        });
        rv.addOnItemTouchListener(new Listener(this, rv, new Listener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                pos = position;
                changeFragment(new EditFragment(), true);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                DBHelper.getInstance().delete(noteList.get(position));
                noteList = DBHelper.getInstance().selectAllDB();
                Lists.LISTS.clear();
                for (Note note : noteList) {
                    Lists.LISTS.add(new Lists(note.getTitle()));
                }
                adapter.notifyDataSetChanged();

                Log.d(TAG, "Long Click");
            }
        }));
    }

    private void changeFragment(Fragment fragment, Boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    private void setupUI() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        adapter = new Adapter();
        rv.setAdapter(adapter);
        Lists.LISTS.clear();
        noteList = DBHelper.getInstance().selectAllDB();
        for (Note tempNote : noteList) {
            Lists.LISTS.add(new Lists(tempNote.getTitle()));
        }
        reset();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void notifiDataSetchange() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void reset() {
        noteList = DBHelper.getInstance().selectAllDB();
    }

    public Note getNote() {
        return noteList.get(pos);
    }
}
