package com.itxg.controller;

import com.itxg.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    /**
     * 模拟登录
     * GET /login
     */
    @GetMapping("/login")
    public Result login() {

        Map<String, Object> map = new HashMap<>();

        map.put("token", "admin-token");

        return Result.success(map);
    }
}