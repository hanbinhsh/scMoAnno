package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Scmoannofiles;

public interface FilesServer {
    void insertFiles(Scmoannofiles files);
    void updateFiles1(Scmoannofiles files, String taskName);
    void updateFiles2(Scmoannofiles files, String taskName);
    void updateFiles3(Scmoannofiles files, String taskName);
}
