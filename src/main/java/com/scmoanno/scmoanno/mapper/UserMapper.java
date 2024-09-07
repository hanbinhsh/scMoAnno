package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Scmoannouser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<Scmoannouser> findUsers();
    public Scmoannouser findUserByUserName(String userName);

    void register(Scmoannouser scmoannouser);
    public Scmoannouser findUserByUserNameAndPassword(String userName, String password);
}
