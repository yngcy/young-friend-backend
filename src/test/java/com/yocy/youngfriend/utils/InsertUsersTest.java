package com.yocy.youngfriend.utils;

import com.yocy.youngfriend.model.domain.User;
import com.yocy.youngfriend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YounGCY
 * @date 2023-8-11 下午 9:29
 * @description
 */
@SpringBootTest
class InsertUsersTest {

    @Resource
    private UserService userService;
    
    // CPU 密集型：建议分配核心线程数 = CPU - 1
    // IO 密集型：分配的核心线程数可以大于 CPU 核数
    private ExecutorService executorService 
            = new ThreadPoolExecutor(60, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    /**
     * 批量插入用户
     */

    @Test
    public void doInsertUsers() {
        StopWatch sw = new StopWatch();
        sw.start();
        final int INSERT_NUM = 100000;
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fakeuser");
            user.setAvatarUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fb4a87154-18b6-4163-ac80-f4dc4bf58d09%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1694351659&t=8cbd6bdb085f35a84ba362bd27249488");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("12334");
            user.setEmail("45645@qq.com");
            user.setTags("[]");
            user.setProfile("哈哈哈哈");
            user.setUserStatus(0);
            user.setIsDelete(0);
            user.setUserRole(0);
            user.setPlanetCode("111111");
            userList.add(user);
        }
        userService.saveBatch(userList, 10000);
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch sw = new StopWatch();
        sw.start();
        
        final int BATCH_NUM = 2500;
        // 分 10 组
        int i = 0;
        List<CompletableFuture> futureList = new ArrayList<CompletableFuture>();
        for (int j = 0; j < 40; j++) {
            List<User> userList = Collections.synchronizedList(new ArrayList<User>());
            
            while(true) {
                i++;
                User user = new User();
                user.setUsername("假用户");
                user.setUserAccount("fakeuser");
                user.setAvatarUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fb4a87154-18b6-4163-ac80-f4dc4bf58d09%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fsafe-img.xhscdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1694351659&t=8cbd6bdb085f35a84ba362bd27249488");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("12334");
                user.setEmail("45645@qq.com");
                user.setTags("[]");
                user.setProfile("哈哈哈哈");
                user.setUserStatus(0);
                user.setIsDelete(0);
                user.setUserRole(0);
                user.setPlanetCode("111111");
                userList.add(user);
                if (i % BATCH_NUM == 0) {
                    break;
                }
            }
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                userService.saveBatch(userList, BATCH_NUM);
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
    }
}