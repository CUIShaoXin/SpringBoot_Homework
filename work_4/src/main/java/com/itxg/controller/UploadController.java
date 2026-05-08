package com.itxg.controller;

import com.itxg.config.AppProperties;
import com.itxg.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UploadController {

    @Autowired
    private AppProperties appProperties;

    /**
     * 文件上传
     * POST /upload
     */
    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            return Result.error("上传文件不能为空");
        }

        String originalFilename = file.getOriginalFilename();

        String suffix = "";
        if (originalFilename != null && originalFilename.contains(".")) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }

        String newFileName = UUID.randomUUID().toString().replace("-", "") + suffix;

        File dir = new File(appProperties.getUploadPath());

        if (!dir.exists()) {
            dir.mkdirs();
        }

        File targetFile = new File(dir, newFileName);

        file.transferTo(targetFile);

        String visitUrl = "/files/" + newFileName;

        Map<String, Object> result = new HashMap<>();
        result.put("originalFilename", originalFilename);
        result.put("newFileName", newFileName);
        result.put("savePath", targetFile.getAbsolutePath());
        result.put("visitUrl", visitUrl);

        return Result.success(result);
    }
}