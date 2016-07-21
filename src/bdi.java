public class bdi
  extends Exception
{
  public static final long serialVersionUID = -1L;
  public int d;
  public final Object e;
  public Integer f;
  
  public bdi(int paramInt)
  {
    this(paramInt, null, null);
  }
  
  public bdi(int paramInt, String paramString)
  {
    this(paramInt, paramString, null);
  }
  
  public bdi(int paramInt, String paramString, Object paramObject)
  {
    super(paramString);
    d = paramInt;
    e = paramObject;
  }
  
  public bdi(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    d = paramInt;
    e = null;
  }
  
  public final String a()
  {
    switch (d)
    {
    case 0: 
    case 22: 
    case 23: 
    default: 
      return "unknown_exception";
    case -1: 
      return "no_error";
    case 1: 
      return "io_error";
    case 2: 
      return "tls_required";
    case 3: 
      return "auth_required";
    case 4: 
      return "general_security";
    case 5: 
      return "auth_failed";
    case 6: 
      return "dup_acct";
    case 7: 
      return "sec_policy_req";
    case 8: 
      return "sec_policy_unsupported";
    case 9: 
      return "protocol_version_unsupported";
    case 10: 
      return "cert_validation_error";
    case 11: 
      return "autodiscover_auth_failed";
    case 12: 
      return "autodiscover_auth_result";
    case 13: 
      return "auth_failed_or_server_error";
    case 14: 
      return "access_denied";
    case 15: 
      return "attachment_not_found";
    case 16: 
      return "client_cert_req";
    case 17: 
      return "client_cert_error";
    case 18: 
      return "oauth_not_supported";
    case 19: 
      return "temp_server_error";
    case 20: 
      return "perm_server_error";
    case 21: 
      return "ssl_exception";
    case 24: 
      return "oauth_auth_failed";
    case 25: 
      return "pop3_error";
    case 26: 
      return "imap_error";
    case 27: 
      return "smtp_error";
    case 28: 
      return "data_discrepancy";
    case 29: 
      return "ipc_error";
    }
    return "too_many_redirects";
  }
  
  public String toString()
  {
    String str1 = String.valueOf(super.toString());
    String str2 = String.valueOf(a());
    return String.valueOf(str1).length() + 3 + String.valueOf(str2).length() + str1 + " [" + str2 + "]";
  }
}

/* Location:
 * Qualified Name:     bdi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */