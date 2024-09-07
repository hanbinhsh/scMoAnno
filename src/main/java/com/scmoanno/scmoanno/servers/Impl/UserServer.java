package com.scmoanno.scmoanno.servers.Impl;

import com.scmoanno.scmoanno.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServer implements com.scmoanno.scmoanno.servers.UserServer {
    @Resource
    private UserMapper userMapper;


}
