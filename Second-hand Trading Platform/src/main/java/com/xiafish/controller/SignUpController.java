package com.xiafish.controller;

import com.xiafish.pojo.Result;
import com.xiafish.service.SignUpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


@Slf4j
@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;
    @PostMapping("/signup")
    public Result signUp(@RequestBody Map<String, Object> loginBody)
    {
        String username=(String) loginBody.get("username");
        String password=(String) loginBody.get("password");
        try
        {
            signUpService.addUser(username,password);
            return Result.success();
        }
        catch (RuntimeException e)
        {
            log.info(e.getMessage());
            return Result.error("the username has existed");
        }

    }
}
