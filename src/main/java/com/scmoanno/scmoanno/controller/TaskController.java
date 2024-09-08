package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.entity.Scmoannotask;
import com.scmoanno.scmoanno.servers.TaskServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
    @Resource
    private TaskServer taskServer;

    @RequestMapping("/findTasksByUserID")
    @CrossOrigin(origins = "*")
    public Result<List<Scmoannotask>> findTasksByUserID(@RequestParam long userID) {
        return Result.success(taskServer.findTasksByUserId(userID));
    }

    @RequestMapping("/deleteTaskByID")
    @CrossOrigin(origins = "*")
    public Result deleteTaskByID(@RequestParam long taskID) {
        taskServer.deleteTasksByTaskId(taskID);
        return Result.success();
    }
}
