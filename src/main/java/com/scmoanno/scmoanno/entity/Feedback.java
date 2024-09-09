package com.scmoanno.scmoanno.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Feedback {
    private long feedbackId;
    private long userId;
    private String subject;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.sql.Timestamp createTime;
}
