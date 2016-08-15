package com.dyx.acf.view.ui;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dyx.acf.R;
import com.dyx.acf.view.base.BaseActivity;
import com.dyx.utils.library.uploadfile.UploadLogService;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dayongxin on 2016/8/11.
 * TODO 未完成
 */
public class BreakpointUploadAct extends BaseActivity {
    @Bind(R.id.et_file_name)
    EditText etFileName;
    @Bind(R.id.tv_show_result)
    TextView tvShowResult;
    @Bind(R.id.pb_result)
    ProgressBar pbResult;
    @Bind(R.id.btn_start_upload)
    Button btnStartUpload;
    @Bind(R.id.btn_stop_upload)
    Button btnStopUpload;
    //上传服务
    private UploadLogService service;
    //是否开启上传
    private boolean start = true;
    //
    String pathString = Environment.getExternalStorageDirectory().getAbsolutePath();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_breakpoint_uploadlayout);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        service = new UploadLogService(this);
    }

    @OnClick({R.id.btn_start_upload, R.id.btn_stop_upload})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start_upload:
                doUploadTask();
                break;
            case R.id.btn_stop_upload:
                start = false;
                break;
        }
    }

    private void doUploadTask() {
        start = true;
        String filename = etFileName.getText().toString();
        //判断SDCard是否存在
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            //取得SDCard的目录
            //File uploadFile = new File(Environment.getExternalStorageDirectory(), filename);
            //本地测试使用
            File uploadFile = new File(pathString + "/Android/data/com.mapbar.info.collection/files/cache.zip");
            if (uploadFile.exists()) {
                //开始上传文件
                uploadFile(uploadFile);
            } else {
                showSnackbar(btnStartUpload, getString(R.string.file_not_exist));
            }
        } else {
            showSnackbar(btnStartUpload, getString(R.string.sdcard_not_exist));
        }
    }

    private void uploadFile(final File uploadFile) {
    }
}
