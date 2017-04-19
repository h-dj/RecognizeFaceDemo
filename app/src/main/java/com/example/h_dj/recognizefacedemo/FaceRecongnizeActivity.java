package com.example.h_dj.recognizefacedemo;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by H_DJ on 2017/4/19.
 */

public class FaceRecongnizeActivity extends BaseActivity implements View.OnClickListener {

    private static final int GET_FACE_RECONGNIZE_RESULT = 0X1001;
    private final String TAG = "FaceRecongnizeActivity";
    private Button mButton;
    private DrawView mDrawView1;
    private DrawView mDrawView2;
    private DrawView mDrawView3;
    private DrawView mDrawView4;

    private View[] face;
    private String[] paths = new String[4];
    private Gson mGson;
    private FaceRecongnize mFaceRecongnize;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == GET_FACE_RECONGNIZE_RESULT) {
                String result = (String) msg.obj;
                mFaceRecongnize = mGson.fromJson(result, FaceRecongnize.class);
                List<FaceRecongnize.ResultsBean> results = mFaceRecongnize.getResults();
                for (int i = 0; i < results.size(); i++) {
                    FaceRecongnize.ResultsBean resultsBean = results.get(i);
                    double score = resultsBean.getScore();
                    if (score >= 80.0) {
                        Log.i(TAG, "handleMessage: " + score);
                        int i0 = Integer.parseInt(resultsBean.getIndex_i());
                        int i1 = Integer.parseInt(resultsBean.getIndex_j());
                        ((DrawView) face[i0]).setText(String.valueOf((int) score));
                        ((DrawView) face[i1]).setText(String.valueOf((int) score));
                    }
                }
            }
            hiddenProgressDialog();
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_facerecongnize;
    }

    @Override
    public void init() {
        super.init();
        mGson = new Gson();
        findView();
        face = new View[]{mDrawView1, mDrawView2, mDrawView3, mDrawView4};

    }

    private void findView() {
        mDrawView1 = (DrawView) findViewById(R.id.iv_picture1);
        mDrawView2 = (DrawView) findViewById(R.id.iv_picture2);
        mDrawView3 = (DrawView) findViewById(R.id.iv_picture3);
        mDrawView4 = (DrawView) findViewById(R.id.iv_picture4);
        mButton = (Button) findViewById(R.id.btn_Contrast);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showProgressDialog("人脸对比", "对比中...");
        pushPictureToSD();
        recongnizeFace();


    }

    /**
     * 人脸检测
     */
    private void recongnizeFace() {
        // 参数为本地图片路径
        final ArrayList<String> pathArray = new ArrayList<String>();
        for (int i = 0; i < paths.length; i++) {
            pathArray.add(paths[i]);
            Log.i(TAG, "recongnizeFace: " + pathArray.get(i));
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (client != null && pathArray.size() > 0) {
                    Log.i(TAG, "recongnizeFace: ");
                    String result = client.match(pathArray).toString();
                    Log.i(TAG, "recongnizeFace: " + result);
                    Message msg = Message.obtain();
                    msg.what = GET_FACE_RECONGNIZE_RESULT;
                    msg.obj = result;
                    mHandler.sendMessage(msg);
                }
            }
        }).start();


    }


    /**
     * 把图片缓存到SD卡
     */
    private void pushPictureToSD() {
        Log.i(TAG, "pushPictureToSD: ");
        for (int i = 0; i < 4; i++) {
            face[i].setDrawingCacheEnabled(true);
            Bitmap bitmap = face[i].getDrawingCache();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
            File file = Environment.getExternalStorageDirectory();
            if (file.exists()) {
                try {
                    String path = file.getAbsolutePath() + File.separator + "picture" + i + ".png";
                    paths[i] = path;
                    FileOutputStream fous = new FileOutputStream(path);
                    bos.writeTo(fous);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
