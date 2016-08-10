Android常用代码片段整理


[TOC]



## 用到的开源库

### butterknife

UI组件注解框架，省去大量繁琐的findViewById()操作。

```java
//butterknife
compile 'com.jakewharton:butterknife:7.0.1'
```

### Logger

既好用，又性感的Log打印框架。

```java
//Logger
compile 'com.orhanobut:logger:1.15'
```

## 项目解释

### app

### rv-library

### utils-library


## 遇到的问题

### 读取手机IMEI权限问题

```java
Process: com.dyx.acf, PID: 24733
java.lang.SecurityException: getDeviceId: Neither user 10241 nor current process has android.permission.READ_PHONE_STATE.
    at android.os.Parcel.readException(Parcel.java:1620)
    at android.os.Parcel.readException(Parcel.java:1573)
    at com.android.internal.telephony.ITelephony$Stub$Proxy.getDeviceId(ITelephony.java:4813)
    at android.telephony.TelephonyManager.getDeviceId(TelephonyManager.java:723)
    at com.dyx.utils.library.common.CommonUtils.getDeviceIMEI(CommonUtils.java:256)
    at com.dyx.acf.view.ui.CommonCodeFragmentAct.onClick(CommonCodeFragmentAct.java:144)
    at com.dyx.acf.view.ui.CommonCodeFragmentAct$$ViewBinder$12.doClick(CommonCodeFragmentAct$$ViewBinder.java:128)
    at butterknife.internal.DebouncingOnClickListener.onClick(DebouncingOnClickListener.java:22)
    at android.view.View.performClick(View.java:5222)
    at android.view.View$PerformClick.run(View.java:21198)
    at android.os.Handler.handleCallback(Handler.java:739)
    at android.os.Handler.dispatchMessage(Handler.java:95)
    at android.os.Looper.loop(Looper.java:148)
    at android.app.ActivityThread.main(ActivityThread.java:5515)

                                                                 at java.lang.reflect.Method.invoke(Native Method)
    at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:764)
    at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:654)
```

- [解决方案](http://stackoverflow.com/questions/32742327/neither-user-10102-nor-current-process-has-android-permission-read-phone-state)
- [推荐阅读](http://droidyue.com/blog/2016/01/17/understanding-marshmallow-runtime-permission/index.html)

### DES3加密算法

```java
如果我们要使用3DES加密，需要以下几个步骤：

① 传入共同约定的密钥（keyBytes）以及算法（Algorithm），来构建SecretKey密钥对象
SecretKey deskey = new SecretKeySpec(keyBytes, Algorithm);

② 根据算法实例化Cipher对象。它负责加密/解密
Cipher c1 = Cipher.getInstance(Algorithm);

③ 传入加密/解密模式以及SecretKey密钥对象，实例化Cipher对象
c1.init(Cipher.ENCRYPT_MODE, deskey);

④ 传入字节数组，调用Cipher.doFinal()方法，实现加密/解密，并返回一个byte字节数组
c1.doFinal(src);
```


