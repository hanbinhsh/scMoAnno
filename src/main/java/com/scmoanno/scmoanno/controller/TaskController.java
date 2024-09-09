package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.entity.Scmoannotask;
import com.scmoanno.scmoanno.servers.TaskServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping("/findAllTasks")
    @CrossOrigin(origins = "*")
    public Result<List<Scmoannotask>> findAllTasks(){
        return Result.success(taskServer.findAllTasks());
    }

    @RequestMapping("/findAllTasksWithUserInformation")
    @CrossOrigin(origins = "*")
    public Result<Map<Object,Object>> findAllTasksWithUserInformation(){
        return Result.success(taskServer.findAllTasksWithUserInformation());
    }

    @RequestMapping("/updateTaskStatus")
    @CrossOrigin(origins = "*")
    public Result updateTaskStatus(@RequestParam("taskID") Long taskID, @RequestParam("status") Long status) {
        taskServer.updateTaskStatus(taskID, status);
        return Result.success();
    }
}
