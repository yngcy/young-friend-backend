package com.yocy.youngfriend.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yocy.youngfriend.mapper.UserMapper;
import com.yocy.youngfriend.model.domain.User;
import com.yocy.youngfriend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author YounGCY
 * @date 2023-8-13 上午 10:27
 * @description 缓存预热
 */
@Component
@Slf4j
public class PreCacheJob {
    
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    
    @Resource
    private RedissonClient redissonClient;
            
    // 重点用户
    private List<Long> mainUserList = Arrays.asList(1L);
    
    /**
     * 每天执行，预热加载推荐用户
     */
    @Scheduled(cron="0 0 0 * * *")
    public void doCacheRecommendUsers() {
        RLock lock = redissonClient.getLock("young-friend:precachejob:docacge:lock");
        try {
            // 只有一个线程能获取到锁
            // tryLock(等待时间，释放时间，时间单位)
            if (lock.tryLock(0, 10000L, TimeUnit.MILLISECONDS)) {
                System.out.println("getLock: " + Thread.currentThread().getId());
                for (Long userId : mainUserList) {
    
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String redisKey = String.format("young-friend:user:recommend:%s", userId);
                    ValueOperations<String, Object> valueOperation = redisTemplate.opsForValue();
    
                    try {
                        valueOperation.set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
               
            }
        } catch (InterruptedException e) {
            log.error("doCacheRecommendUser error", e);
        } finally {
            System.out.println("unLock: " + Thread.currentThread().getId());
            // 只能释放自己的锁
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }


    }
}
