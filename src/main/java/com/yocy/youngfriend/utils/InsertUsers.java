package com.yocy.youngfriend.utils;
import java.util.Date;

import com.yocy.youngfriend.mapper.UserMapper;
import com.yocy.youngfriend.model.domain.User;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * @author YounGCY
 * @date 2023-8-11 下午 9:09
 * @description
 */
@Component
public class InsertUsers {
    
    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     */
//    @Scheduled(initialDelay = 5000, fiexedRate = Long.MAX_VALUE)
    public void doInsertUsers() {
        StopWatch sw = new StopWatch();
        sw.start();
        final int INSERT_NUM = 1000;
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
            
            userMapper.insert(user);
        }
        sw.stop();
        System.out.println(sw.getTotalTimeMillis());
    }
}
