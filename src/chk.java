public final class chk
{
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 19 + "other (" + paramInt + ")";
    case 0: 
      return "success";
    case 1: 
      return "connection_error";
    case 2: 
      return "auth_error";
    case 3: 
      return "security_error";
    case 4: 
      return "storage_error";
    case 6: 
      return "internal_error";
    case 5: 
      return "server_error";
    case 7: 
      return "response_parse_error";
    case 8: 
      return "operation_cancelled_error";
    case 9: 
      return "database_error";
    case 10: 
      return "too_many_redirects";
    case 11: 
      return "hard_data_failure";
    case 12: 
      return "non_existent";
    case 13: 
      return "login_limit_exceeded";
    case 14: 
      return "certificate_validation_error";
    case 15: 
      return "oauth_authentication_failed";
    case 16: 
      return "too_many_syncs";
    case 17: 
      return "ipc_error";
    }
    return "eas_error";
  }
}

/* Location:
 * Qualified Name:     chk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */