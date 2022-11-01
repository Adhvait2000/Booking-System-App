package MOBLIMA

public enum LoginStatus
{ SUCCESSFUL("Login Successful"),FAILED("Login Failed, please enter valid credentials");
  private String status;
  
  LoginStatus(String status)
  {
      this.status=status;
  }
  
  public String returningStatus()
  {
     return status;
  }
}
