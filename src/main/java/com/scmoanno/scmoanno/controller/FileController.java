package com.scmoanno.scmoanno.controller;


import com.scmoanno.scmoanno.entity.*;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import com.scmoanno.scmoanno.servers.FilesServer;
import com.scmoanno.scmoanno.servers.TaskServer;
import jakarta.annotation.Resource;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

import java.util.*;

@RestController
public class FileController {

    @Resource
    private FilesServer filesServer;

    @RequestMapping("/findResultByTaskName")
    @CrossOrigin(origins = "*")
    public Result findResultByTaskName(@RequestParam String taskName) {
        if(filesServer.findResultByTaskName(taskName)==null){
            return Result.success();
        }
        return Result.error("the taskName already exists");
    }

    @PostMapping("/uploadResult")
    @CrossOrigin(origins = "*")  // 跨域
    public Result uploadResult(@RequestParam("file") MultipartFile file,
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
        String realFilePath = "c:/ScmoannoResult/"+randomFileName;
        // 数据库包装

        Scmoannoresult result = new Scmoannoresult();
        if(Objects.equals(fileType, "configjsFile")){
            result.setConfigFile(randomFileName);
            filesServer.updateResult1(result, taskName);
        }
        else if(Objects.equals(fileType, "datajsFile")){
            result.setDataFile(randomFileName);
            filesServer.updateResult2(result, taskName);
        }
        else if(Objects.equals(fileType, "lablejsFile")){
            result.setLableFile(randomFileName);
            filesServer.updateResult3(result, taskName);
        }
        // 文件操作
        file.transferTo(new File(realFilePath));  // 移动到目标文件
        return Result.success();

    }

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

    @RequestMapping("/insertResult")
    @CrossOrigin(origins = "*")
    public Result insertResult(@RequestBody Map<String,String> map) {
        Scmoannoresult result = new Scmoannoresult();
        result.setTaskName(map.get("taskName"));
        filesServer.insertResult(result);
        return Result.success();
    }

    @GetMapping("/download")
    @CrossOrigin(origins = "*")
    public ResponseEntity<byte[]> download(@RequestParam String taskName) throws IOException {
        Scmoannofiles file = filesServer.findFileByTaskName(taskName);
        String[] filePaths = new String[3];
        filePaths[0] = "c:\\ScmoannoFiles\\"+file.getScRna_SeqFile();
        filePaths[1] = "c:\\ScmoannoFiles\\"+file.getScAtac_SeqFile();
        filePaths[2] = "c:\\ScmoannoFiles\\"+file.getTagFile();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ZipArchiveOutputStream zaos = new ZipArchiveOutputStream(baos);

            // 添加文件
            for (String filePath : filePaths) {
                try (InputStream is = Files.newInputStream(Paths.get(filePath))) {
                    ZipArchiveEntry ze = new ZipArchiveEntry(filePath);
                    ze.setSize(Files.size(Paths.get(filePath)));
                    zaos.putArchiveEntry(ze);
                    IOUtils.copy(is, zaos);
                    zaos.closeArchiveEntry();
                }
            }

            zaos.close();

            // 创建一个文件资源对象，并设置相应的属性
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "multiple_files.zip");

            // 返回文件内容
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(baos.toByteArray());
        } catch (IOException e) {
            // 处理异常
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
