package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.servers.TaskServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    @Resource
    private TaskServer taskServer;

    @RequestMapping("/findTasksByUserID")
    @CrossOrigin(origins = "*")
    public Result findTasksByUserID(@RequestParam long userID) {
        Result result = new Result();
        result.setData(taskServer.findTasksByUserId(userID));
        result.setCode(200);
        result.setMsg("success");
        return result;
    }
}
