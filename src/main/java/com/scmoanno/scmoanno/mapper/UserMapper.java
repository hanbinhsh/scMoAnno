package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Scmoannouser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<Scmoannouser> findUsers();
    public Scmoannouser findUserByUserName(String userName);
    public Scmoannouser findUserByPassword(String password);

    void register(Scmoannouser scmoannouser);
}
