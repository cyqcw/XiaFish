package com.xiafish;

import com.aliyun.tea.*;
import com.xiafish.util.MessageSendUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageTest {
    @Autowired
    MessageSendUtil messageSendUtil;
    @Test
    void test() throws Exception {
        messageSendUtil.send("114514","18157646970");
    }

}


