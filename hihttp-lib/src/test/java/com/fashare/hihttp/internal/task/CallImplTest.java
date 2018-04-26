package com.fashare.hihttp.internal.task;

import com.fashare.hihttp.Call;
import com.fashare.hihttp.Request;
import com.fashare.hihttp.Response;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * <pre>
 *     author : jinliangshan
 *     e-mail : 
 *     desc   :
 * </pre>
 */
public class CallImplTest {
    @Test
    public void call_execute() throws Exception {
        Call call = new CallImpl();
        Response response = call.execute(new Request());

        System.out.println(response.getBody());
    }

    @Test
    public void call_enqueue_onSuccess() throws Exception {
        Call call = new CallImpl();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        call.enqueue(new Request(), new Call.CallBack() {
            @Override
            public void onSuccess(Response response) {
                System.out.println(response.getBody());
                countDownLatch.countDown();
            }

            @Override
            public void onError(Exception e) {}
        });

        // 为了多线程测试
        countDownLatch.await();
    }
}
