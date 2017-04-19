package com.example.h_dj.recognizefacedemo;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.baidu.aip.face.AipFace;

/**
 * Created by H_DJ on 2017/4/19.
 */

public abstract class BaseActivity extends AppCompatActivity {

    //设置APPID/AK/SK
    public static final String APP_ID = "9534326";
    public static final String API_KEY = "KgCi5AqCgMENB7euHFskBdiY";
    public static final String SECRET_KEY = "luiBCBdV1ZpshEl9MNG1z8YGdoFGsTiB";
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    private static final int REQUEST_READ_EXTERNAL_STORAGE = 3;
    public static AipFace client;
    private final String TAG = "BaseActivity";
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_READ_EXTERNAL_STORAGE);
        }
        init();
    }

    public void init() {
        initAipFace();
        mProgressDialog = new ProgressDialog(this);
    }

    public abstract int getLayoutId();

    private void initAipFace() {
        Log.i(TAG, "initAipFace: ");
        client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
    }

    public void goTo(Class mClass) {
        Intent intent = new Intent(this, mClass);
        startActivity(intent);
    }

    /**
     * 显示对话框
     *
     * @param title
     * @param msg
     */
    public void showProgressDialog(String title, String msg) {
        mProgressDialog = ProgressDialog.show(this, title, msg);
    }

    /**
     * 隐藏对话框
     */
    public void hiddenProgressDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    protected void onDestroy() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
        super.onDestroy();
    }
}
