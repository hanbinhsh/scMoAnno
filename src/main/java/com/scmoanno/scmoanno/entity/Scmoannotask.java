package com.scmoanno.scmoanno.entity;


public class Scmoannotask {

  private long taskId;
  private String taskName;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private long status;
  private String details;
  private long uploaderId;


  public long getTaskId() {
    return taskId;
  }

  public void setTaskId(long taskId) {
    this.taskId = taskId;
  }


  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }


  public long getUploaderId() {
    return uploaderId;
  }

  public void setUploaderId(long uploaderId) {
    this.uploaderId = uploaderId;
  }

}
