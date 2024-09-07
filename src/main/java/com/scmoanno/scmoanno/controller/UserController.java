package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.entity.Scmoannouser;
import com.scmoanno.scmoanno.servers.UserServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Resource
    UserServer userServer;

    @RequestMapping("/findUsers")
    @CrossOrigin(origins = "*")
    public Result<List<Scmoannouser>> findUsers() {
        return Result.success(userServer.findUsers());
    }

    @RequestMapping("/userLogin")
    public Result userLogin(String userName, String password) {
        if(userServer.findUserByUserName(userName) != null && userServer.findUserByPassword(password) != null) {
            return Result.success();
        }
        else
            return Result.error("the username or password is wrong!");
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody Scmoannouser scmoannouser) {
        userServer.register(scmoannouser);
        return Result.success();
    }


}
