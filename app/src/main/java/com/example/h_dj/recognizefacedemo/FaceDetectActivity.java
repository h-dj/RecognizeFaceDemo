package com.example.h_dj.recognizefacedemo;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;

/**
 * Created by H_DJ on 2017/4/19.
 */

public class FaceDetectActivity extends BaseActivity {


    private static final int GET_FACE_DETECT_RESULT = 0X1001;
    private Button mButton;
    private final String TAG = "MainActivity";
    private DrawView mDrawView;


    private FaceConfig mFaceConfig;
    private Gson mGson;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == GET_FACE_DETECT_RESULT) {
                String result = (String) msg.obj;
                mFaceConfig = mGson.fromJson(result, FaceConfig.class);
                FaceConfig.ResultBean.LocationBean locationBean = mFaceConfig.getResult().get(0).getLocation();
                mDrawView.setRect(new Rect(((int) (locationBean.getLeft())), ((int) (locationBean.getTop() / 1.50f)), ((int) (locationBean.getWidth() * 1.5f)), ((int) (locationBean.getHeight() * 1.5f))));
                Log.i(TAG, "handleMessage: " + locationBean.getLeft());
                hiddenProgressDialog();
            }
        }
    };


    @Override
    public int getLayoutId() {
        return R.layout.activity_facedetect;
    }

    @Override
    public void init() {
        super.init();
        mGson = new Gson();
        findView();
    }

    private void findView() {
        mDrawView = (DrawView) findViewById(R.id.iv_face);
        mButton = (Button) findViewById(R.id.btn_recongnized);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                faceDetect();
            }
        });

    }

    private void faceDetect() {
        showProgressDialog("人脸识别", "正在识别...");
        // 自定义参数定义
        final HashMap<String, String> options = new HashMap<String, String>();
        options.put("max_face_num", "1");
        options.put("face_fields", "age,beauty,expression,faceshape,gender,glasses,landmark,race,qualities");

        new Thread(new Runnable() {
            @Override
            public void run() {
                mDrawView.setDrawingCacheEnabled(true);
                Bitmap bitmap = mDrawView.getDrawingCache();

                byte[] imgByte = Bitmap2Byte(bitmap);

                String string = client.detect(imgByte, options).toString();

                Message msg = Message.obtain();
                msg.what = GET_FACE_DETECT_RESULT;
                msg.obj = string;
                mHandler.sendMessage(msg);
                Log.i(TAG, "faceDetect: " + string);
            }
        }).start();

    }

    private byte[] Bitmap2Byte(Bitmap bitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        return bos.toByteArray();
    }
}
