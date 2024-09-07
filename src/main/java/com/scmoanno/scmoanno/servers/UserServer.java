package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Scmoannouser;

import java.util.List;

public interface UserServer {
    public List<Scmoannouser> findUsers();
}
