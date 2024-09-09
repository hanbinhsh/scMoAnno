package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Scmoannotask;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    List<Scmoannotask> findTasksByUserId(@Param("id") Long id);
    List<Scmoannotask> findAllTasks();
    void deleteTasksByTaskId(@Param("id") Long id);
    @MapKey("task_id")
    Map<Object,Object> findAllTasksWithUserInformation();
    void updateTaskStatus(@Param("id") Long id, @Param("status") Long status);
    void updateTaskEndTime(@Param("id") Long id, @Param("time") Date time);

}
