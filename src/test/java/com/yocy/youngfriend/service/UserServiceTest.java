package com.yocy.youngfriend.service;

import com.yocy.youngfriend.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 25055
 * @date 2023-8-5 下午 11:50
 * @description
 */
@SpringBootTest
class UserServiceTest {
    
    @Resource
    private UserService userService;

    @Test
    void testSearchUsersByTags() {
        List<String> tagNameList = Arrays.asList("java", "python");
        List<User> users = userService.searchUsersByTags(tagNameList);
        Assert.assertNotNull(users);
    }
}