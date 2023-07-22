package com.xiafish;

import com.xiafish.util.EmailSendUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailSend {

    @Autowired
    EmailSendUtils emailSendUtils;
    @Test
    public void sendTemplateMail() {
        //发送邮件
        emailSendUtils.sendMessageToEmail("114514","2436579671@qq.com");
    }

}
