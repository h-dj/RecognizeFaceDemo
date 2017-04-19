package com.example.h_dj.recognizefacedemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by H_DJ on 2017/4/19.
 */

public class FaceLoginActivity extends BaseActivity implements View.OnClickListener {

    private static final int ADD_USER = 0x1001;
    private static final int VERIFY_USER = 0X1002;
    private final String TAG = "FaceLoginActivity";
    private DrawView mDrawView;
    private Button btn_login;
    private Button btn_register;

    private String path_icon = null;
    private boolean flag = false;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String result = msg.obj.toString();
            if (msg.what == ADD_USER) {
                if (!result.contains("error_msg")) {
                    Toast.makeText(FaceLoginActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FaceLoginActivity.this, "注册失败！", Toast.LENGTH_SHORT).show();
                }

            } else if (msg.what == VERIFY_USER) {
                if (!result.contains("error_msg")) {
                    Toast.makeText(FaceLoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FaceLoginActivity.this, "登陆失败！", Toast.LENGTH_SHORT).show();
                }
            }
            hiddenProgressDialog();
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_face_login;
    }

    @Override
    public void init() {
        super.init();
        mDrawView = (DrawView) findViewById(R.id.dv_header);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        mDrawView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                pushToSD();
                facesetAddUser();
                break;
            case R.id.btn_login:
                pushToSD();
                verifyUser();
                break;
            case R.id.dv_header:
                createrDialog();
                break;

        }
    }

    /**
     * 上传图片注册
     */
    public void facesetAddUser() {
        showProgressDialog("人脸注册", "注册中...");
        new Thread() {
            @Override
            public void run() {
                if (flag) {
                    // 参数为本地图片路径
                    ArrayList<String> path = new ArrayList<String>();
                    path.add(path_icon);
                    JSONObject res = client.addUser("uid2", "test_user_info", "group1", path);
                    String string = res.toString();
                    Message msg = Message.obtain();
                    msg.what = ADD_USER;
                    msg.obj = string;
                    mHandler.sendMessage(msg);
                    Log.i(TAG, "run: " + string);
                }

            }
        }.start();

    }

    /**
     * 登陆认证
     */
    public void verifyUser() {
        showProgressDialog("登陆认证", "认证中...");
        new Thread() {
            @Override
            public void run() {
                if (flag) {
                    ArrayList<String> path = new ArrayList<String>();
                    path.add(path_icon);
                    HashMap<String, Object> options = new HashMap<String, Object>(1);
                    options.put("top_num", path.size());
                    JSONObject res = client.verifyUser("uid1", path, options);
                    Message msg = Message.obtain();
                    msg.what = VERIFY_USER;
                    msg.obj = res.toString();
                    mHandler.sendMessage(msg);
                    Log.i(TAG, "run: " + res.toString());
                }
            }
        }.start();
    }

    private void pushToSD() {
        mDrawView.setDrawingCacheEnabled(true);
        Bitmap bitmap = mDrawView.getDrawingCache();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        File file = Environment.getExternalStorageDirectory();
        if (file.exists()) {
            try {
                String path = file.getAbsolutePath() + File.separator + "header.png";
                path_icon = path;
                FileOutputStream fous = new FileOutputStream(path);
                bos.writeTo(fous);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 创建对话框
     */
    private void createrDialog() {
        new AlertDialog.Builder(this).setMessage("选择图片")
                .setCancelable(true)
                .setPositiveButton("拍照", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choseHeadImageFromCameraCapture();
                    }
                })
                .setNegativeButton("图库", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choseHeadImageFromGallery();
                    }
                })
                .create()
                .show();
        Log.i(TAG, "createrDialog: " + path_icon);
    }

    /**
     * 以下代码实现：从本地选择图片，或拍照：
     */

    /* 头像文件 */
    private static final String IMAGE_FILE_NAME = "temp_head_image.jpg";

    /* 请求识别码 */
    private static final int CODE_GALLERY_REQUEST = 0xa0;
    private static final int CODE_CAMERA_REQUEST = 0xa1;
    private static final int CODE_RESULT_REQUEST = 0xa2;

    // 裁剪后图片的宽(X)和高(Y),200 X 200的正方形。
    private static int output_X = 400;
    private static int output_Y = 400;

    // 从本地相册选取图片作为头像
    private void choseHeadImageFromGallery() {
        Intent intentFromGallery = new Intent();
        // 设置文件类型
        intentFromGallery.setType("image/*");
        intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intentFromGallery, CODE_GALLERY_REQUEST);
    }

    // 启动手机相机拍摄照片作为头像
    private void choseHeadImageFromCameraCapture() {
        Intent intentFromCapture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // 判断存储卡是否可用，存储照片文件
        if (hasSdcard()) {
            File file = new File(Environment.getExternalStorageDirectory(), IMAGE_FILE_NAME);
            intentFromCapture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        }

        startActivityForResult(intentFromCapture, CODE_CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        // 用户没有进行有效的设置操作，返回
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getApplication(), "取消", Toast.LENGTH_LONG).show();
            return;
        }
        flag = true;
        switch (requestCode) {
            case CODE_GALLERY_REQUEST:
                cropRawPhoto(intent.getData());
                break;

            case CODE_CAMERA_REQUEST:
                if (hasSdcard()) {
                    File tempFile = new File(
                            Environment.getExternalStorageDirectory(),
                            IMAGE_FILE_NAME);
                    cropRawPhoto(Uri.fromFile(tempFile));
                } else {
                    Toast.makeText(getApplication(), "没有SDCard!", Toast.LENGTH_LONG)
                            .show();
                }

                break;

            case CODE_RESULT_REQUEST:
                if (intent != null) {
                    setImageToHeadView(intent);
                }

                break;
        }

        super.onActivityResult(requestCode, resultCode, intent);
    }

    /**
     * 裁剪原始的图片
     */
    public void cropRawPhoto(Uri uri) {

        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");

        // 设置裁剪
        intent.putExtra("crop", "true");

        // aspectX , aspectY :宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX , outputY : 裁剪图片宽高
        intent.putExtra("outputX", output_X);
        intent.putExtra("outputY", output_Y);
        intent.putExtra("return-data", true);

        startActivityForResult(intent, CODE_RESULT_REQUEST);
    }

    /**
     * 提取保存裁剪之后的图片数据，并设置头像部分的View
     */
    private void setImageToHeadView(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            mDrawView.setImageBitmap(photo);
            return;
        }

    }

    /**
     * 检查设备是否存在SDCard的工具方法
     */
    public static boolean hasSdcard() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            // 有存储的SDCard
            return true;
        } else {
            return false;
        }
    }


}
