package com.example.hasan.flashlightcontroller;

import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import java.security.Policy;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.toString();
    private ToggleButton tgFlashLight;
    private Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getCamera();
        setContentView(R.layout.activity_main);
        getRefereances();
        addListeners();
        tgFlashLight.setChecked(true);
    }

    private void getCamera() {
        try {
            camera = Camera.open();
        } catch (RuntimeException e) {
            Log.e(TAG, String.format("Could not open camera %s ", e.getMessage()));
        }

    }



    private void addListeners() {
        tgFlashLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
//                Log.d(TAG,String.format("tgbFlashlight check changed : %s", isChecked));

                if (isChecked) {
                    Camera.Parameters params = camera.getParameters();
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(params);
                } else {
                    Camera.Parameters params = camera.getParameters();
                    params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                    camera.setParameters(params);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        tgFlashLight.setChecked(false);
        super.onDestroy();
    }

    void getRefereances() {
        tgFlashLight = (ToggleButton) findViewById(R.id.btnFlash);
    }
}
