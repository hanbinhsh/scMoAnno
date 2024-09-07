package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.entity.Scmoannouser;
import com.scmoanno.scmoanno.servers.UserServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
