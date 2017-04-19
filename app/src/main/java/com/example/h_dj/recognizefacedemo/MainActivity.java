package com.example.h_dj.recognizefacedemo;

import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button mButton_faceDetect;
    private Button mButton_faceContrast;
    private Button mButton_faceSearch;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public void init() {
        super.init();
        findView();
    }

    private void findView() {
        mButton_faceDetect = (Button) findViewById(R.id.btn_facedetect);
        mButton_faceContrast = (Button) findViewById(R.id.btn_facecontrast);
        mButton_faceSearch = (Button) findViewById(R.id.btn_facecsearch);
        mButton_faceDetect.setOnClickListener(this);
        mButton_faceContrast.setOnClickListener(this);
        mButton_faceSearch.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_facedetect:
                goTo(FaceDetectActivity.class);
                break;
            case R.id.btn_facecontrast:
                goTo(FaceRecongnizeActivity.class);
                break;
            case R.id.btn_facecsearch:
                goTo(FaceLoginActivity.class);
                break;


        }
    }
}
