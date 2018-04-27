package com.fashare.hihttp.internal.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <pre>
 *     author : jinliangshan
 *     e-mail :
 *     desc   :
 * </pre>
 */
public class IoUtil {
    public static byte[] toBytes(InputStream is) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        try {
            int bytesRead = 0;
            while (-1 != (bytesRead = is.read(buffer))) {
                os.write(buffer, 0, bytesRead);
            }
            return os.toByteArray();
        } finally {
            // 记得 close
            try {
                is.close();
            } catch (IOException e) {
                System.out.println("IoUtil.toBytes(): Error occurred when closing InputStream");
            }

            os.close();
        }
    }
}
