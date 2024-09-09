package com.scmoanno.scmoanno.controller;


import com.scmoanno.scmoanno.entity.Scmoannofiles;
import com.scmoanno.scmoanno.entity.Scmoannotask;
import com.scmoanno.scmoanno.servers.FilesServer;
import com.scmoanno.scmoanno.servers.TaskServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class FileController {

    @Resource
    private FilesServer filesServer;
    private TaskServer taskServer;

    @PostMapping("/uploadOneFile")
    @CrossOrigin(origins = "*")  // 跨域
    public Map<String, Object> uploadOneFile(@RequestParam("file") MultipartFile file,
                                             @RequestParam("userId") long userId,
                                             @RequestParam("taskName") String taskName) throws IOException {
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

        Scmoannotask task = new Scmoannotask();
        task.setTaskName(taskName);
        task.setStartTime(timestamp);
        task.setUploaderId(userId);
        taskServer.insertTask(task);

        Scmoannofiles Files = new Scmoannofiles();
        filesServer.insertFiles(Files);

        if(contentType.equals("h5")){
            Files.setScRna_SeqFile(fileName);
            filesServer.updateFiles1(Files, taskName);
        }
        else if(contentType.equals("h5ad")){
            Files.setScAtac_SeqFile(fileName);
            filesServer.updateFiles2(Files, taskName);
        }
        else if(contentType.equals("csv")){
            Files.setTagFile(fileName);
            filesServer.updateFiles3(Files, taskName);
        }


        // 文件操作
        file.transferTo(new File(realFilePath));  // 移动到目标文件
        // 返回信息
        Map<String, Object> result = new HashMap<>();
        result.put("code",200);
        result.put("filename",fileName);
        result.put("filepath",realFilePath);
        result.put("filetype",contentType);
        return result;
    }


}
