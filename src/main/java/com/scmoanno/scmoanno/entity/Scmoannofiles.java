package com.scmoanno.scmoanno.entity;


public class Scmoannofiles {

  private long fileId;
  private String scRna_SeqFile;
  private String scAtac_SeqFile;
  private String tagFile;
  private String taskName;


  public long getFileId() {
    return fileId;
  }

  public void setFileId(long fileId) {
    this.fileId = fileId;
  }


  public String getScRna_SeqFile() {
    return scRna_SeqFile;
  }

  public void setScRna_SeqFile(String scRna_SeqFile) {
    this.scRna_SeqFile = scRna_SeqFile;
  }


  public String getScAtac_SeqFile() {
    return scAtac_SeqFile;
  }

  public void setScAtac_SeqFile(String scAtac_SeqFile) {
    this.scAtac_SeqFile = scAtac_SeqFile;
  }


  public String getTagFile() {
    return tagFile;
  }

  public void setTagFile(String tagFile) {
    this.tagFile = tagFile;
  }


  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

}
