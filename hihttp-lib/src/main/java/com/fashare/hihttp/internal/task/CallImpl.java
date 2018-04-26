package com.fashare.hihttp.internal.task;

import com.fashare.hihttp.Call;
import com.fashare.hihttp.Request;
import com.fashare.hihttp.Response;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

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
        String path = "http://www.baidu.com";
        String result = "";
        try {
            URL url = new URL(path);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5 * 1000);
            conn.setRequestMethod("GET");
            InputStream inStream = conn.getInputStream();
            byte[] data = toByteArray(inStream);
            result = new String(data, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Response(result);
    }

    private static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

    @Override
    public void enqueue(Request request, CallBack callBack) {
        new Thread(() -> {
            Response response = execute(request);
            if(callBack != null){
                callBack.onSuccess(response);
            }
        }).start();
    }

    @Override
    public void cancel() {

    }
}
