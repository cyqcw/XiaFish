package com.xiafish.service.impl;

import com.xiafish.pojo.Result;
import com.xiafish.pojo.User;
import com.xiafish.service.OrderService;
import com.xiafish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.geom.RectangularShape;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;


}
