package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Scmoannouser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<Scmoannouser> findUsers();
    Scmoannouser findUserByUserName(String userName);
    void register(Scmoannouser scmoannouser);
    Scmoannouser findUserByUserNameAndPassword(String userName, String password);
    Scmoannouser findUserByUserEmail(String email);
    Scmoannouser findUserByUserPhone(String phone);
    void deleteUserByUserID(long userID);
    void updateUser(Scmoannouser scmoannouser);
}
