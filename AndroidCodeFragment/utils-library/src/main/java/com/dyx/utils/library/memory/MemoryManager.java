package com.dyx.utils.library.memory;

import android.os.Environment;
import android.os.StatFs;

import java.io.File;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class MemoryManager {
    /**
     * 获取最大内存
     *
     * @return
     */
    public static int getMaxMemory() {
        int maxMemory = ((int) Runtime.getRuntime().maxMemory()) / 1024 / 1024;
        return maxMemory;
    }


    /**
     * 应用已经获取的内存
     *
     * @return
     */
    public static int getTotalMemory() {
        int totalMemory = ((int) Runtime.getRuntime().totalMemory()) / 1024 / 1024;
        return totalMemory;
    }

    /**
     * 获取内存中闲置内存
     *
     * @return
     */
    public static int getFreeMemory() {
        int freeMemory = ((int) Runtime.getRuntime().freeMemory()) / 1024 / 1024;
        return freeMemory;
    }

    /**
     * 判断应用是否在低内存条件下运行
     *
     * @return
     */
    public static boolean isRunLowMemory() {
        long memory = getMemmorySize();
        if (memory < getMaxMemory()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 获取手机内部可用空间大小
     *
     * @return
     */
    private static long getMemmorySize() {
        //获取android/data/目录
        File dataPath = Environment.getDataDirectory();
        //获取StatFs对象
        StatFs statFs = new StatFs(dataPath.getPath());
        //获取BlockSize
        long blockSize = statFs.getBlockSize();
        //获取AvailableBlocks
        long availableBlocks = statFs.getAvailableBlocks();
        return blockSize * availableBlocks;
    }

    /**
     * 获取手机内部空间大小
     *
     * @return
     */
    public static long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();// 获取该区域可用的文件系统数
        return totalBlocks * blockSize;
    }

    /**
     * 获取手机外部可用空间大小
     *
     * @return
     */
    public static long getAvailableExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long availableBlocks = stat.getAvailableBlocks();
            return availableBlocks * blockSize;
        } else {
            throw new RuntimeException("Don't have sdcard.");
        }
    }

    /**
     * 获取手机外部空间大小
     *
     * @return
     */
    public static long getTotalExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();// 获取外部存储目录即 SDCard
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long totalBlocks = stat.getBlockCount();
            return totalBlocks * blockSize;
        } else {
            throw new RuntimeException("Don't have sdcard.");
        }
    }

    /**
     * 外部存储是否可用
     *
     * @return
     */
    public static boolean externalMemoryAvailable() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }
}
