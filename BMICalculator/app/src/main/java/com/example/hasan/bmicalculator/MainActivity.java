package com.example.hasan.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =MainActivity.class.toString() ;
    private EditText etWeight;
    private EditText etHeight;
    private Button btCalculator;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLayoutReferences();

        btCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float weight = Float.parseFloat(etWeight.getText().toString());
                float height = Float.parseFloat(etHeight.getText().toString());
                height/=100;
                Log.d(TAG, String.format("Tinh hoi ha : %s %s ",
                        weight,height ));
                float bmi = weight /(height*height);
                Log.d(TAG, String.format("Tinh hoi ha : %s %s %s",
                        weight,height,bmi ));
               tvResult.setText(getBMItype(bmi));

            }
        });

    }
String getBMItype(float bmi){
    if(bmi <16){
        return "Mày gầy vcl . Suy duy dưỡng cmnt";
    }else if(bmi< 18.5){
        return "Mày thiếu cân :v Ăn nhiêu vào !!!!";
    }else if(bmi<25){
        return "Chúc mừng bạn có một thân hình chuẩn siêu mẫu !!!";
    }else if(bmi<30){
        return "Mày hơi thừa cân rồi đấy :V Giảm béo đi em !!!";
    }else {
        return "Béo vcl :v Cẩn thận chết sớm";
    }
}
    void getLayoutReferences() {
        etWeight = (EditText) findViewById(R.id.weight);
        etHeight = (EditText) findViewById(R.id.height);
        btCalculator = (Button) findViewById(R.id.button);
        tvResult = (TextView) findViewById(R.id.bmi1);

    }

}
