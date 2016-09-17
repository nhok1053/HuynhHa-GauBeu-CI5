package com.example.hasan.demoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.toString();
    int StatusA[] = new int[7];
    Button btnChange;
    TextView tvA;
    protected void setTextView() {
        tvA.setText(String.format("onCreate: %d\n" +
                        "onStart: %d\n" +
                        "onRestart: %d\n" +
                        "onResume: %d\n" +
                        "onPause: %d\n" +
                        "onStop: %d\n" +
                        "onDestroy:  %d\n",
                StatusA[0],
                StatusA[1],
                StatusA[2],
                StatusA[3],
                StatusA[4],
                StatusA[5],
                StatusA[6]
        ));
    }
    private void getRefrences(){
        tvA = (TextView) findViewById(R.id.tv_acti1);
        btnChange = (Button) findViewById(R.id.button);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getRefrences();

        StatusA[0]++;
        Log.d(TAG,"onCreate");
        setTextView();
        addListener();
    }

    @Override
    protected void onStart() {

        super.onStart();
        StatusA[1]++;
        setTextView();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");

        super.onDestroy();
        StatusA[6]++;
        setTextView();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause");

        super.onPause();
        StatusA[4]++;
        setTextView();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");

        super.onStop();
        StatusA[5]++;
        setTextView();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");

        super.onResume();
        StatusA[3]++;
        setTextView();
    }

    @Override
    protected void onRestart() {

        Log.d(TAG,"onRestart");
        super.onRestart();
        StatusA[2]++;
        setTextView();
    }
    protected void addListener(){
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
