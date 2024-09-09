package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Scmoannotask;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TaskServer {
    void insertTask(Scmoannotask task);
    List<Scmoannotask> findTasksByUserId(Long id);
    void deleteTasksByTaskId(Long id);
    List<Scmoannotask> findAllTasks();
    Map<Object,Object> findAllTasksWithUserInformation();
    void updateTaskStatus(Long id, Long status);
}
