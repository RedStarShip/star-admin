package com.star.controller;

import com.star.entity.User;
import com.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 用户列表
     */
    @GetMapping
    public Map<String,Object> users(@RequestParam(value = "page",defaultValue = "1")Integer pageNow,
                                    @RequestParam(value = "per_page",defaultValue = "5")Integer rows,
                                    @RequestParam(required = false)String id,
                                    String name,
                                    String phone
                                    ){
        Map<String, Object> result = new HashMap<>();
        //查询用户 分页查询用户信息  指定条件分页查询用户信息
        List<User> items = userService.findAllByKeywords(pageNow, rows, id, name, phone);
        //查询总条数
        Long totalCounts = userService.findTotalCountsByKeywords(id, name, phone);
        result.put("total_count", totalCounts);
        result.put("items", items);

        return result;

    }

}
