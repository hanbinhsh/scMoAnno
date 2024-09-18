package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.entity.Scmoannofiles;
import com.scmoanno.scmoanno.entity.Scmoannoresult;
import com.scmoanno.scmoanno.entity.Scmoannotask;
import com.scmoanno.scmoanno.servers.FilesServer;
import com.scmoanno.scmoanno.servers.TaskServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
public class TaskController {
    @Resource
    private TaskServer taskServer;

    @Resource
    private FilesServer filesServer;

    @RequestMapping("/insertTask")
    @CrossOrigin(origins = "*")
    public Result insertTask(@RequestBody Map<String, String> map) {
        Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
        Scmoannotask task = new Scmoannotask();
        task.setTaskName(map.get("taskName"));
        task.setStartTime(timestamp);
        task.setEndTime(timestamp);
        task.setUploaderId(Long.parseLong(map.get("userId")));
        taskServer.insertTask(task);
        return Result.success();
    }

    @RequestMapping("/findTasksByUserID")
    @CrossOrigin(origins = "*")
    public Result<List<Scmoannotask>> findTasksByUserID(@RequestParam long userID) {
        return Result.success(taskServer.findTasksByUserId(userID));
    }

    @RequestMapping("/findTaskByTaskName")
    @CrossOrigin(origins = "*")
    public Result findTasksByUserID(@RequestParam String taskName) {
        if(taskServer.findTaskByTaskName(taskName) == null) {
            return Result.success();
        }
        else
            return Result.error("the taskName already exists");
    }

    @RequestMapping("/deleteTaskByID")
    @CrossOrigin(origins = "*")
    public Result deleteTaskByID(@RequestParam long taskID,@RequestParam String taskName) {
        Scmoannoresult result=filesServer.findResultByTaskName(taskName);
        if (result.getConfigFile() != null) {
            result.deleteFile("c:\\ScmoannoResult\\" + result.getConfigFile());
        }
        if (result.getDataFile() != null) {
            result.deleteFile("c:\\ScmoannoResult\\" + result.getDataFile());
        }
        if (result.getLableFile() != null) {
            result.deleteFile("c:\\ScmoannoResult\\" + result.getLableFile());
        }
        taskServer.deleteTasksByTaskId(taskID);
        return Result.success();
    }

    @RequestMapping("/findAllTasksWithUserInformation")
    @CrossOrigin(origins = "*")
    public Result<Map<Object,Object>> findAllTasksWithUserInformation(){
        Map<Object, Object> tasksWithUserInfo = taskServer.findAllTasksWithUserInformation();

        // 遍历所有任务并转换用户头像
        for (Object task : tasksWithUserInfo.keySet()) {
            Object userInfo = tasksWithUserInfo.get(task);
            if (userInfo instanceof Map) {
                Map<String, Object> userMap = (Map<String, Object>) userInfo;
                if (userMap.get("avatar") instanceof byte[] avatarBytes) {
                    String base64Avatar = Base64.getEncoder().encodeToString(avatarBytes);
                    userMap.put("avatarBase64", base64Avatar); // 添加 Base64 编码字段
                }
            }
        }

        return Result.success(tasksWithUserInfo);
        //return Result.success(taskServer.findAllTasksWithUserInformation());
    }

    @RequestMapping("/updateTaskStatus")
    @CrossOrigin(origins = "*")
    public Result updateTaskStatus(@RequestParam("taskID") Long taskID, @RequestParam("status") Long status) {
        taskServer.updateTaskStatus(taskID, status);
        return Result.success();
    }
}
