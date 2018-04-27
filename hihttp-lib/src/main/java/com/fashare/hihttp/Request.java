package com.fashare.hihttp;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * <pre>
 *     author : jinliangshan
 *     e-mail :
 *     desc   :
 * </pre>
 */
public class Request {
    private String method = "GET";
    private URL url;

    {
        try {
            url = new URL("https://api.github.com/repos/fashare2015/HiHttp/branches");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String getMethod() {
        return method;
    }

    public URL getUrl() {
        return url;
    }
}
