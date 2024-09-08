package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Scmoannouser;

import java.util.List;

public interface UserServer {
    List<Scmoannouser> findUsers();
    Scmoannouser findUserByUserName(String userName);
    void deleteUserByUserID(long userID);
    void register(Scmoannouser scmoannouser);
    Scmoannouser findUserByUserNameAndPassword(String userName, String password);
    Scmoannouser findUserByEmail(String email);
    Scmoannouser findUserByPhone(String phone);
    void updateUser(Scmoannouser scmoannouser);
}
