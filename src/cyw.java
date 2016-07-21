final class cyw
  extends cyx
{
  final String a;
  
  cyw(String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramString, paramArrayOfString, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", false);
    if (paramBoolean)
    {
      a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'(),-./:?!\"#$%&*;<=>@[]^_`{|} \t\r\n";
      return;
    }
    a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789'(),-./:? \t\r\n";
  }
  
  final byte a()
  {
    return 43;
  }
  
  final boolean a(char paramChar)
  {
    return a.indexOf(paramChar) >= 0;
  }
  
  final byte b()
  {
    return 45;
  }
}

/* Location:
 * Qualified Name:     cyw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */