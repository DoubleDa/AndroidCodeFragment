package com.dyx.utils.library.ormmodel;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by dayongxin on 2016/8/16.
 * 外部存储器
 */
public class ExternalStorageUtil {

    /**
     * 是否可写
     *
     * @return
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * 是否可读
     *
     * @return
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)
                || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * 获取根目录
     *
     * @return
     */
    public static String getExternalStoragePath() {
        if (isExternalStorageWritable())
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        else
            return null;
    }

    /**
     * 获取下载路径
     *
     * @return
     */
    public static String getExternalDownloadPath() {
        return Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    }

    /**
     * 向根目录写文件
     *
     * @param fileName
     * @param content
     * @return
     */
    public static boolean write(String fileName, String content) {
        return write("/", fileName, content);
    }

    /**
     * 向根目录写字节
     *
     * @param fileName
     * @param bytes
     * @return
     */
    public static boolean writeBytes(String fileName, byte[] bytes) {
        return writeBytes("/", fileName, bytes);
    }

    /**
     * 向指定目录的文件写入字节数组,路径以/开始/结尾
     *
     * @param s
     * @param fileName
     * @param bytes
     * @return
     */
    private static boolean writeBytes(String s, String fileName, byte[] bytes) {
        boolean flag = false;
        if (!s.equals("/")) {
            File dir = new File(getExternalStoragePath() + s);
            if (!dir.exists()) {
                if (!(dir.mkdir() || dir.isDirectory())) {
                    // 文件目录创建失败或者不是一个目录
                    return false;
                }
            }
        }
        File file = new File(getExternalStoragePath() + s + fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, false);
            fos.write(bytes);
            flag = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return flag;
    }

    /**
     * 向指定目录的文件中写入字符串,路径以/开始/结尾
     *
     * @param s
     * @param fileName
     * @param content
     * @return
     */
    private static boolean write(String s, String fileName, String content) {
        return writeBytes(s, fileName, content.getBytes());
    }

    /**
     * 从根路径读字节
     *
     * @param fileName
     * @return
     */
    public static byte[] readBytes(String fileName) {
        return readBytes("/", fileName);
    }

    /**
     * 从指定目录读字节,路径以/开始/结尾
     *
     * @param s
     * @param fileName
     * @return
     */
    private static byte[] readBytes(String s, String fileName) {
        File file = new File(getExternalStoragePath() + s + fileName);
        if (!file.isFile()) {
            return null;
        } else {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                int length = fis.available();
                byte[] buffer = new byte[length];
                fis.read(buffer);
                return buffer;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
    }

    /**
     * 从根目录读文本
     *
     * @param fileName
     * @return
     */
    public static String read(String fileName) {
        return read("/", fileName);
    }

    /**
     * 从指定目录读文本,路径以/开始/结尾
     *
     * @param s
     * @param fileName
     * @return
     */
    private static String read(String s, String fileName) {
        try {
            byte[] readBytes = readBytes(s, fileName);
            if (readBytes == null) {
                return null;
            }
            return new String(readBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从根目录删除
     *
     * @param fileName
     * @return
     */
    public static boolean delete(String fileName) {
        return delete("/", fileName);
    }

    /**
     * 从指定目录删除,路径以/开始/结尾
     *
     * @param s
     * @param fileName
     * @return
     */
    private static boolean delete(String s, String fileName) {
        File file = new File(getExternalStoragePath() + s + fileName);
        if (file.exists())
            return file.delete();
        else
            return true;
    }
}
