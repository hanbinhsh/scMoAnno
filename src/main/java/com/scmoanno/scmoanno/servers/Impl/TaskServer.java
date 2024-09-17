package com.scmoanno.scmoanno.servers.Impl;

import com.scmoanno.scmoanno.entity.Scmoannofiles;
import com.scmoanno.scmoanno.entity.Scmoannotask;
import com.scmoanno.scmoanno.mapper.TaskMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TaskServer implements com.scmoanno.scmoanno.servers.TaskServer {
    @Resource
    private TaskMapper taskMapper;

    @Override
    @Transactional
    public List<Scmoannotask> findTasksByUserId(Long id) {
        return taskMapper.findTasksByUserId(id);
    }

    @Override
    @Transactional
    public Scmoannofiles findTaskByTaskName(String taskName) {
        return taskMapper.findTaskByTaskName(taskName);
    }

    @Override
    public void deleteTasksByTaskId(Long id) {
        taskMapper.deleteTasksByTaskId(id);
    }

    @Override
    public void insertTask(Scmoannotask task){taskMapper.insertTask(task); }

    @Override
    public Map<Object,Object> findAllTasksWithUserInformation() {
        return taskMapper.findAllTasksWithUserInformation();
    }

    @Override
    public void updateTaskStatus(Long id, Long status,String details) {
        taskMapper.updateTaskStatus(id, status, details);
        if (status == 0 || status == 1) {
            // 对于未完成的任务，将结束时间设置为 null
            taskMapper.updateTaskEndTime(id, null);
        } else {
            // 对于完成的任务，将当前时间作为结束时间
            Date currentTime = new Date();
            taskMapper.updateTaskEndTime(id, currentTime);
        }
    }
}
