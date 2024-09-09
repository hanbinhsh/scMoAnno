package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Scmoannofiles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FilesMapper {
    public void insertFiles(@Param("files") Scmoannofiles files);
    public void updateFiles1(@Param("files") Scmoannofiles files, String taskName);
    public void updateFiles2(@Param("files") Scmoannofiles files, String taskName);
    public void updateFiles3(@Param("files") Scmoannofiles files, String taskName);
}
