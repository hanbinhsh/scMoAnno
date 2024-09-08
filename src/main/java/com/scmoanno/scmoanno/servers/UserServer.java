package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Scmoannouser;

import java.util.List;

public interface UserServer {
    public List<Scmoannouser> findUsers();
    public Scmoannouser findUserByUserName(String userName);
    public void deleteUserByUserID(long userID);
    void register(Scmoannouser scmoannouser);
    public Scmoannouser findUserByUserNameAndPassword(String userName, String password);
    Scmoannouser findUserByEmail(String email);
    Scmoannouser findUserByPhone(String phone);
}
