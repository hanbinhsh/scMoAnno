package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Scmoannofiles;
import com.scmoanno.scmoanno.entity.Scmoannoresult;
import org.apache.ibatis.annotations.Param;

public interface FilesServer {
    void insertFiles(Scmoannofiles files);
    void updateFiles1(Scmoannofiles files, String taskName);
    void updateFiles2(Scmoannofiles files, String taskName);
    void updateFiles3(Scmoannofiles files, String taskName);

    Scmoannofiles findFileByTaskName(String taskName);

    void insertResult(Scmoannoresult result);
    void updateResult1(Scmoannoresult result, String taskName);
    void updateResult2(Scmoannoresult result, String taskName);
    void updateResult3(Scmoannoresult result, String taskName);
    Scmoannoresult findResultByTaskName(String taskName);
}
