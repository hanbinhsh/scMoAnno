package com.scmoanno.scmoanno.servers.Impl;

import com.scmoanno.scmoanno.entity.Scmoannotask;
import com.scmoanno.scmoanno.mapper.TaskMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void deleteTasksByTaskId(Long id) {
        taskMapper.deleteTasksByTaskId(id);
    }

    @Override
    public void insertTask(Scmoannotask task){taskMapper.insertTask(task); }
}
