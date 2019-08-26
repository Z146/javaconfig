package com.zhou.controller;

import com.zhou.service.StudentService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    private RedisTemplate<String,String> redisTemplate;
    private StudentService service;

    public CacheController(RedisTemplate<String, String> redisTemplate, StudentService service) {
        this.redisTemplate = redisTemplate;
        this.service = service;
    }

    @GetMapping("/student/addRedis/{name}")
    public String addRedisMessage(@PathVariable String name){
        redisTemplate.opsForValue().append("name",name);
        return "OK";
    }


    @GetMapping("/cache/{id}")
    public String testCache(@PathVariable Integer id){
        //logger.info("执行了方法 testCache()....");
        return service.testCache(id);
    }
}
