package com.scmoanno.scmoanno.servers.Impl;

import com.scmoanno.scmoanno.entity.Scmoannofiles;
import com.scmoanno.scmoanno.entity.Scmoannoresult;
import com.scmoanno.scmoanno.mapper.FilesMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FilesServer implements com.scmoanno.scmoanno.servers.FilesServer {

    @Resource
    private FilesMapper filesMapper;

    @Override
    @Transactional
    public void insertResult(Scmoannoresult result) {
        filesMapper.insertResult(result);
    }

    @Override
    @Transactional
    public void insertFiles(Scmoannofiles files) {
        filesMapper.insertFiles(files);
    }

    @Override
    @Transactional
    public void updateFiles1(Scmoannofiles files, String taskName) {
        filesMapper.updateFiles1(files, taskName);
    }

    @Override
    @Transactional
    public void updateFiles2(Scmoannofiles files, String taskName) {
        filesMapper.updateFiles2(files, taskName);
    }

    @Override
    @Transactional
    public void updateFiles3(Scmoannofiles files, String taskName) {
        filesMapper.updateFiles3(files, taskName);
    }

    @Override
    @Transactional
    public void updateResult1(Scmoannoresult result, String taskName) {
        filesMapper.updateResult1(result, taskName);
    }

    @Override
    @Transactional
    public void updateResult2(Scmoannoresult result, String taskName) {
        filesMapper.updateResult2(result, taskName);
    }

    @Override
    @Transactional
    public void updateResult3(Scmoannoresult result, String taskName) {
        filesMapper.updateResult3(result, taskName);
    }

    @Override
    @Transactional
    public Scmoannofiles findFileByTaskName(String taskName) {
        return filesMapper.findFileByTaskName(taskName);
    }
}
