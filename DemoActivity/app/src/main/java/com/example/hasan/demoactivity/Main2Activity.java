package com.example.hasan.demoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    int StatusB[] = new int[7];
    Button btnChange;
    TextView tvB;
    protected void setTextView() {
        tvB.setText(String.format("onCreate: %d\n" +
                        "onStart: %d\n" +
                        "onRestart: %d\n" +
                        "onResume: %d\n" +
                        "onPause: %d\n" +
                        "onStop: %d\n" +
                        "onDestroy:  %d\n",
                StatusB[0],
                StatusB[1],
                StatusB[2],
                StatusB[3],
                StatusB[4],
                StatusB[5],
                StatusB[6]
        ));
    }
    private void getRefrences(){
        tvB = (TextView) findViewById(R.id.tv_B);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getRefrences();
        StatusB[0]++;
        Log.d(TAG,"onCreate");
        setTextView();

    }

    @Override
    protected void onStart() {

        super.onStart();
        StatusB[1]++;
        setTextView();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy");

        super.onDestroy();
        StatusB[6]++;
        setTextView();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause");

        super.onPause();
        StatusB[4]++;
        setTextView();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop");

        super.onStop();
        StatusB[5]++;
        setTextView();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");

        super.onResume();
        StatusB[3]++;
        setTextView();
    }

    @Override
    protected void onRestart() {

        Log.d(TAG,"onRestart");
        super.onRestart();
        StatusB[2]++;
        setTextView();
    }

}
