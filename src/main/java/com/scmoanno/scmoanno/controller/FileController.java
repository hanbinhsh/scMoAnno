package com.scmoanno.scmoanno.controller;


import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.entity.Scmoannofiles;
import com.scmoanno.scmoanno.entity.Scmoannotask;
import com.scmoanno.scmoanno.servers.FilesServer;
import com.scmoanno.scmoanno.servers.TaskServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
public class FileController {

    @Resource
    private FilesServer filesServer;

    @PostMapping("/uploadOneFile")
    @CrossOrigin(origins = "*")  // 跨域
    public Result uploadOneFile(@RequestParam("file") MultipartFile file,
                                @RequestParam("taskName") String taskName,
                                @RequestParam("fileType") String fileType) throws IOException {
        String fileName = file.getOriginalFilename();  // 文件名
        String contentType = file.getContentType();  // 内容类型
        String name = file.getName();  // 表单域名
        System.out.println(name+" "+fileName+" "+contentType);
        Timestamp timestamp = Timestamp.from(ZonedDateTime.now().toInstant());
        // 支持重复上传，uuid重新命名
        String randomFileName = UUID.randomUUID().toString();
        // 路径获取
        int suffixIndex = fileName.lastIndexOf(".");
        if(suffixIndex > 0){  // 有后缀名
            randomFileName = randomFileName + fileName.substring(suffixIndex);
        }
        String realFilePath = "c:/ScmoannoFiles/"+randomFileName;
        // 数据库包装

        Scmoannofiles files = new Scmoannofiles();

        if(Objects.equals(fileType, "scRNASeqFile")){
            files.setScRna_SeqFile(randomFileName);
            filesServer.updateFiles1(files, taskName);
        }
        else if(Objects.equals(fileType, "scATACSeqFile")){
            files.setScAtac_SeqFile(randomFileName);
            filesServer.updateFiles2(files, taskName);
        }
        else if(Objects.equals(fileType, "tagFile")){
            files.setTagFile(randomFileName);
            filesServer.updateFiles3(files, taskName);
        }
        // 文件操作
        file.transferTo(new File(realFilePath));  // 移动到目标文件
        return Result.success();

    }

    @RequestMapping("/insertFile")
    @CrossOrigin(origins = "*")
    public Result insertFile(@RequestBody Map<String,String> map) {
        Scmoannofiles files = new Scmoannofiles();
        files.setTaskName(map.get("taskName"));
        filesServer.insertFiles(files);
        return Result.success();
    }
}
