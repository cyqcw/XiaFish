package com.xiafish.controller;

import com.xiafish.pojo.Result;
import com.xiafish.service.UserService;
import com.xiafish.util.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;
    @Autowired
    private UserService userService;
    @PostMapping("/upload")
    public Result uploadHeadImg(Integer userId, MultipartFile image) throws IOException {
        log.info("文件上传{}",image);
        String url= aliOSSUtils.upload(image);
        log.info("文件上传成功，对应的url为:{}",url);
        userService.updateHeadImg(userId,url);
        return Result.success(url);
    }
}
