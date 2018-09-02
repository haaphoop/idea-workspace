package com.haaphoop.concurrent.test;


import com.haaphoop.eshop.inventory.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ConcurrentTest {
    // 请求总数
    private static int clientTotal = 5000;
    // 同时并发执行的线程数
    private static int threadTotal = 200;
    public static int count = 0;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
               ////add();
                User user = new User();
                user.setAge(11);
                user.setName("xiaozhang");
                log.info(user.toString());
            });

        }
    }

    /*public static void add() {
        count++;
        log.info(""+count);
    }*/
}
