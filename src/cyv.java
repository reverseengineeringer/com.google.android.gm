final class cyv
  extends cyx
{
  cyv(String paramString, String[] paramArrayOfString)
  {
    super(paramString, paramArrayOfString, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+,", true);
  }
  
  final byte a()
  {
    return 38;
  }
  
  final boolean a(char paramChar)
  {
    if (paramChar == '&') {}
    while ((paramChar < ' ') || (paramChar > '~')) {
      return false;
    }
    return true;
  }
  
  final byte b()
  {
    return 45;
  }
}

/* Location:
 * Qualified Name:     cyv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */