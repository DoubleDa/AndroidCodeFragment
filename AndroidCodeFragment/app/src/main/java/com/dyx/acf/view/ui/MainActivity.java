package com.dyx.acf.view.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dyx.acf.R;
import com.dyx.acf.view.adapter.MainAdapter;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.rv.library.listener.OnItemClickListener;
import com.dyx.rv.library.view.DividerItemDecoration;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    private static final int REQUEST_READ_PHONE_STATE = 1;
    private static final int REQUEST_WRITE_EXTERNAL_STORAGE = 2;
    @Bind(R.id.rv_main)
    RecyclerView rvMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        MainAdapter adapter = new MainAdapter();
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        rvMain.setAdapter(adapter);

        adapter.setmOnItemClickListener(new OnItemClickListener<String>() {
            @Override
            public void onItemClick(String itemValue, int viewId, int position) {
                switch (position) {
                    case 0:
                        intentTo(CommonCodeFragmentAct.class);
                        break;
                    case 1:
                        intentTo(DES3Act.class);
                        break;
                    case 2:
                        intentTo(FloatingbuttonAct.class);
                        break;
                    case 3:
                        intentTo(SudokuAct.class);
                        break;
                    case 4:
                        intentTo(HeadSetAct.class);
                        break;
                    case 5:
                        intentTo(MD5Act.class);
                        break;
                    case 6:
                        handleCameraStatus();
                        break;
                    case 7:
                        handleFilePermission();
                        break;
                    case 8:
                        intentTo(VibratorAct.class);
                        break;
                    case 9:
                        intentTo(QrAct.class);
                        break;
                    case 10:
                        intentTo(InstallApkBackgroundAct.class);
                        break;
                    case 11:
                        intentTo(showReceiverMsgAct.class);
                        break;
                    case 12:
                        intentTo(ClickSpaceAct.class);
                        break;
                    case 13:
                        intentTo(ClearDataAct.class);
                        break;
                    case 14:
                        intentTo(BreakpointUploadAct.class);
                        break;
                    default:
                        break;
                }
            }
        });

        adapter.refreshData(getData());
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void handleFilePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_WRITE_EXTERNAL_STORAGE);
        } else {
            intentTo(ScreenShotAct.class);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void handleCameraStatus() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_READ_PHONE_STATE);
        } else {
            intentTo(CameraAutoAct.class);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_PHONE_STATE:
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    intentTo(CameraAutoAct.class);
                }
                break;
            case REQUEST_WRITE_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    intentTo(ScreenShotAct.class);
                }
                break;
            default:
                break;
        }
    }

    private List<String> getData() {
        return Arrays.asList(getResources().getStringArray(R.array.main_menu));
    }
}
