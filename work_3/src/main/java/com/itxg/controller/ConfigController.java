package com.itxg.controller;

import com.itxg.result.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigController {

    @Value("${app.name}")
    private String appName;

    @Value("${app.upload-path}")
    private String uploadPath;

    @GetMapping("/config")
    public Result config() {
        Map<String, Object> map = new HashMap<>();
        map.put("appName", appName);
        map.put("uploadPath", uploadPath);

        return Result.success(map);
    }
}