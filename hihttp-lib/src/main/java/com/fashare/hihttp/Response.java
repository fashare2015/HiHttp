package com.fashare.hihttp;

import com.fashare.hihttp.internal.util.IoUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * <pre>
 *     author : jinliangshan
 *     e-mail :
 *     desc   : copy from Volley
 * </pre>
 */
public class Response {
    private final int mStatusCode;
    //    private final List<Header> mHeaders;
//    private final int mContentLength;
    private final InputStream mContent;
//    private String body;


    public Response(int statusCode, InputStream content) {
        mStatusCode = statusCode;
        mContent = content;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    public InputStream getContent() {
        return mContent;
    }

    public String getBody() {
        try {
            return new String(IoUtil.toBytes(mContent), "UTF-8");
        } catch (IOException e) {
            return "";
        }
    }

    @Override
    public String toString() {
        return "Response{" +
                "mStatusCode=" + mStatusCode +
                ", mBody=" + getBody() +
                '}';
    }
}
