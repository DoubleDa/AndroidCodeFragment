package com.dyx.acf.view.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;

import java.io.IOException;
import java.lang.reflect.Method;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/10.
 */
public class CameraAutoAct extends BaseActivity {
    private static final int REQUEST_READ_PHONE_STATE = 1;
    @Bind(R.id.sv_camera)
    SurfaceView svCamera;
    @Bind(R.id.btn_start)
    Button btnStart;
    private SurfaceHolder surfaceHolder;
    private boolean flag = false;
    private String fileUrl = "";
    private Camera camera;
    private Camera.Parameters parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_camera_auto_layout);
        ButterKnife.bind(this);
        initView();
    }


    private void initView() {
        surfaceHolder = svCamera.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.setKeepScreenOn(true);
        svCamera.setFocusable(true);
        svCamera.setBackgroundColor(TRIM_MEMORY_BACKGROUND);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (null == camera) {
                    camera = Camera.open();
                    try {
                        camera.setPreviewDisplay(surfaceHolder);
                        initCamera();
                        camera.startPreview();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
                camera.autoFocus(new Camera.AutoFocusCallback() {
                    @Override
                    public void onAutoFocus(boolean b, Camera camera) {
                        if (b) {
                            initCamera();
                            camera.cancelAutoFocus();
                        }
                    }
                });
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                camera.stopPreview();
                camera.release();
                camera = null;
            }
        });
    }

    private void initCamera() {
        parameters = camera.getParameters();
        parameters.setPictureFormat(PixelFormat.JPEG);
        // 部分定制手机，无法正常识别该方法。
        //parameters.setPictureSize(surfaceView.getWidth(), surfaceView.getHeight());
        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
        //1连续对焦
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        setDispaly(parameters, camera);
        camera.setParameters(parameters);
        camera.startPreview();
        // 2如果要实现连续的自动对焦，这一句必须加上
        camera.cancelAutoFocus();
    }

    private void setDispaly(Camera.Parameters parameters, Camera camera) {
        if (Integer.parseInt(Build.VERSION.SDK) >= 8) {
            setDisplayOrientation(camera, 90);
        } else {
            parameters.setRotation(90);
        }
    }

    private void setDisplayOrientation(Camera camera, int i) {
        Method downPolymorphic;
        try {
            downPolymorphic = camera.getClass().getMethod("setDisplayOrientation", new Class[]{int.class});
            if (downPolymorphic != null) {
                downPolymorphic.invoke(camera, new Object[]{i});
            }
        } catch (Exception e) {
        }
    }

    @OnClick(R.id.btn_start)
    public void onClick() {
    }
}
