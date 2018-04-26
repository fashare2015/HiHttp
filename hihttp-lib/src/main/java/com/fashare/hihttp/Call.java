package com.fashare.hihttp;

/**
 * <pre>
 *     author : jinliangshan
 *     e-mail :
 *     desc   :
 * </pre>
 */
public interface Call {
    Response execute(Request request);

    void enqueue(Request request, CallBack callBack);

    void cancel();

    interface CallBack {
        void onSuccess(Response response);

        void onError(Exception e);
    }
}
