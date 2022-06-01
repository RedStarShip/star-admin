package com.star.controller;


import com.star.dto.AdminDTO;
import com.star.utils.JSONUtils;
import com.star.entity.Admin;
import com.star.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * (Admin)表控制层
 *
 * @author wyx
 * @since 2022-05-31 21:19:40
 */
@RestController
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    private AdminService adminService;
    private RedisTemplate redisTemplate;


    @Autowired
    public AdminController(AdminService adminService, RedisTemplate redisTemplate) {
        this.adminService = adminService;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/demos")
    public String hello() {
        return "hello";
    }

    @PostMapping("/tokens")
    public Map<String,String> tokens(@RequestBody Admin admin, HttpSession session)  {
        Map<String,String> result = new HashMap<>();
        log.info("接收到的对象是："+ JSONUtils.writerJSON(admin));
//        进行登录
        Admin admindb = adminService.login(admin);
        //登录成功
        String token = session.getId();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(token, admindb,30, TimeUnit.MINUTES);
        result.put("token",token);
        return result;
    }

    @GetMapping("/admin-user")
    public AdminDTO admin(String token){
        log.info("当前的token信息",token);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        Admin admin = (Admin) redisTemplate.opsForValue().get(token);
        AdminDTO adminDTO = new AdminDTO();
        //属性复制
        BeanUtils.copyProperties(admin,adminDTO);
        adminDTO.setName(admin.getUsername());
        return adminDTO;
    }

    //登出接口
    @DeleteMapping("/tokens/{token}")
    public void logout(@PathVariable String  token){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.delete(token);
    }
}

