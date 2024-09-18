package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Scmoannofiles;
import com.scmoanno.scmoanno.entity.Scmoannotask;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TaskServer {
    void insertTask(Scmoannotask task);
    List<Scmoannotask> findTasksByUserId(Long id);
    void deleteTasksByTaskId(Long id);
    Map<Object,Object> findAllTasksWithUserInformation();
    void updateTaskStatus(Long id, Long status,String details);
    Scmoannofiles findTaskByTaskName(String taskName);
}
