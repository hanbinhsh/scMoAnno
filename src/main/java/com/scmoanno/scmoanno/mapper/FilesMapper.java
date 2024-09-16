package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Scmoannofiles;
import com.scmoanno.scmoanno.entity.Scmoannoresult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FilesMapper {
    public void insertFiles(Scmoannofiles files);
    public void updateFiles1(Scmoannofiles files, String taskName);
    public void updateFiles2(Scmoannofiles files, String taskName);
    public void updateFiles3(Scmoannofiles files, String taskName);

    Scmoannofiles findFileByTaskName(String taskName);

    public void insertResult(Scmoannoresult result);
    public void updateResult1(Scmoannoresult result, String taskName);
    public void updateResult2(Scmoannoresult result, String taskName);
    public void updateResult3(Scmoannoresult result, String taskName);
}
