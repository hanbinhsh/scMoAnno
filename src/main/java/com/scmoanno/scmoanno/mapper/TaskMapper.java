package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Scmoannotask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper {
    List<Scmoannotask> findTasksByUserId(@Param("id") Long id);
    void deleteTasksByTaskId(@Param("id") Long id);
}
