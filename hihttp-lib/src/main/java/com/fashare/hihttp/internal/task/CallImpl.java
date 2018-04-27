package com.fashare.hihttp.internal.task;

import com.fashare.hihttp.Call;
import com.fashare.hihttp.Request;
import com.fashare.hihttp.Response;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * <pre>
 *     author : jinliangshan
 *     e-mail :
 *     desc   :
 * </pre>
 */
public class CallImpl implements Call {
    @Override
    public Response execute(Request request) {
        try {
            HttpURLConnection conn = (HttpURLConnection) request.getUrl().openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestMethod(request.getMethod());
            return new Response(conn.getResponseCode(), conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Response(HttpURLConnection.HTTP_BAD_REQUEST, null);
    }


    @Override
    public void enqueue(Request request, CallBack callBack) {
        new Thread(() -> {
            Response response = execute(request);
            if (callBack != null) {
                callBack.onSuccess(response);
            }
        }).start();
    }

    @Override
    public void cancel() {

    }
}
