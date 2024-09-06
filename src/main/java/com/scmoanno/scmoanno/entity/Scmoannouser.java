package com.scmoanno.scmoanno.entity;


public class Scmoannouser {

  private long userId;
  private String userName;
  private String psw;
  private String email;
  private long isAdmin;
  private String phone;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getPsw() {
    return psw;
  }

  public void setPsw(String psw) {
    this.psw = psw;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public long getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(long isAdmin) {
    this.isAdmin = isAdmin;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}
