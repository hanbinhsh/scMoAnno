package com.scmoanno.scmoanno.servers.Impl;

import com.scmoanno.scmoanno.entity.Scmoannouser;
import com.scmoanno.scmoanno.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServer implements com.scmoanno.scmoanno.servers.UserServer {
    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public List<Scmoannouser> findUsers() {
        return userMapper.findUsers();
    }

    @Override
    public Scmoannouser findUserByUserName(String userName) {
        return userMapper.findUserByUserName(userName);
    }

    @Override
    public Scmoannouser findUserByPassword(String password) {
        return userMapper.findUserByPassword(password);
    }

    @Override
    public void register(Scmoannouser scmoannouser) {
        userMapper.register(scmoannouser);
    }
}
