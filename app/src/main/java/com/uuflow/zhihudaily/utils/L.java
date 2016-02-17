package com.uuflow.zhihudaily.utils;

import android.util.Log;

import com.uuflow.zhihudaily.BuildConfig;


/**
 * @author yelin.wu 15/4/16 下午2:48.
 * @description 日志工具，用所在类simpleName自动生成TAG
 */
public class L {
    private final static int NO_LOG = -1;
    private final static int LOG_V = Log.VERBOSE;
    private final static int LOG_D = Log.DEBUG;
    private final static int LOG_I = Log.INFO;
    private final static int LOG_W = Log.WARN;
    private final static int LOG_E = Log.ERROR;

    private static int logLevel = LOG_E;

    //对签名apk自动屏蔽日志
    static{
        logLevel = BuildConfig.DEBUG ? LOG_E : NO_LOG;
    }

    public static void v(String msg) {
        if (logLevel >= LOG_V) {
            Log.v(generateTAG(msg), msg);
        }
    }

    public static void d(String msg) {
        if (logLevel >= LOG_D) {
            Log.d(generateTAG(msg), msg);
        }
    }

    public static void i(String msg) {
        if (logLevel >= LOG_I) {
            Log.i(generateTAG(msg), msg);
        }
    }

    public static void w(String msg) {
        if (logLevel >= LOG_W) {
            Log.w(generateTAG(msg), msg);
        }
    }

    public static void e(String msg) {
        if (logLevel >= LOG_E) {
            Log.e(generateTAG(msg), msg);
        }
    }

    private static String generateTAG(String msg) {
        StackTraceElement stackTrace = Thread.currentThread().getStackTrace()[4];
        String fullClassName = stackTrace.getClassName();
        if (null == msg ) {
            int lineNumber = stackTrace.getLineNumber();
            throw new IllegalArgumentException(fullClassName + "第 " + lineNumber +" 行方法参数不能为null！" );
        }
        return fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
    }
}
