package com.fashare.hihttp;

import com.fashare.hihttp.internal.task.CallImpl;

/**
 * <pre>
 *     author : jinliangshan
 *     e-mail :
 *     desc   :
 * </pre>
 */
public class HiHttp {
    private static volatile HiHttp sInstance;

    private HiHttp() {
    }

    public static HiHttp getInstance() {
        if (sInstance == null) {
            synchronized (HiHttp.class) {
                if (sInstance == null)
                    sInstance = new HiHttp();
            }
        }
        return sInstance;
    }

    public static Call newCall() {
        return new CallImpl();
    }
}
