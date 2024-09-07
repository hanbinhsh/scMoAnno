package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Scmoannouser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<Scmoannouser> findUsers();
}
