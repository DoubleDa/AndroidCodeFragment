package com.dyx.utils.library.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * Created by dayongxin on 2016/8/16.
 */
public class GsonUtils {
    private static Gson gson = null;

    static {
        if (gson == null) {
            gson = new Gson();
        }
    }

    private GsonUtils() {

    }

    /**
     * gson->String
     *
     * @param object
     * @return
     */
    public static String gson2String(Object object) {
        String result = null;
        if (result != null) {
            result = gson.toJson(object);
        }
        return result;
    }

    /**
     * gson->bean
     *
     * @param gsonStr
     * @param cla
     * @param <T>
     * @return
     */
    public static <T> T gson2Bean(String gsonStr, Class<T> cla) {
        T t = null;
        if (gson != null) {
            t = gson.fromJson(gsonStr, cla);
        }
        return t;
    }

    /**
     * gson->list
     *
     * @param gsonStr
     * @param cla
     * @param <T>
     * @return
     */
    public static <T> List<T> gson2List(String gsonStr, Class<T> cla) {
        List<T> list = null;
        if (gson != null) {
            list = gson.fromJson(gsonStr, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;
    }

    /**
     * gson->maps
     *
     * @param gsonStr
     * @param <T>
     * @return
     */
    public static <T> List<Map<String, T>> gson2Maps(String gsonStr) {
        List<Map<String, T>> mapList = null;
        if (gson != null) {
            mapList = gson.fromJson(gsonStr, new TypeToken<List<Map<String, T>>>() {
            }.getType());
        }
        return mapList;
    }

    /**
     * gson->map
     *
     * @param gsonStr
     * @param <T>
     * @return
     */
    public static <T> Map<String, T> gson2Map(String gsonStr) {
        Map<String, T> map = null;
        if (gson != null) {
            map = gson.fromJson(gsonStr, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
