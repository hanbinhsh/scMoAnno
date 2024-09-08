package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Scmoannotask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskServer {
    List<Scmoannotask> findTasksByUserId(@Param("id") Long id);
    public void deleteTasksByTaskId(@Param("id") Long id);
}
