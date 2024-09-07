package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.entity.Scmoannouser;
import com.scmoanno.scmoanno.servers.UserServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    UserServer userServer;

    @RequestMapping("/findUsers")
    @CrossOrigin(origins = "*")
    public Result<List<Scmoannouser>> findUsers() {
        return Result.success(userServer.findUsers());
    }

    @RequestMapping("/login")
    public Result<Scmoannouser> login(@RequestBody Map<String, String> map) {
        Scmoannouser user = userServer.findUserByUserNameAndPassword(map.get("userName"), map.get("password"));
        if(user != null ) {
            return Result.success(user);
        }
        else
            return Result.error("the username or password is wrong!");
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody Scmoannouser scmoannouser) {
        if(userServer.findUserByUserName(scmoannouser.getUserName())!=null)
        {
            return Result.error("The username already exists!");
        }
        else if(userServer.findUserByEmail(scmoannouser.getEmail())!=null)
        {
            return Result.error("The email address is registered!");
        }
        else if(userServer.findUserByPhone(scmoannouser.getPhone())!=null)
        {
            return Result.error("The phone number is registered!");
        }
        else{
            userServer.register(scmoannouser);
            return Result.success();
        }
    }


}
