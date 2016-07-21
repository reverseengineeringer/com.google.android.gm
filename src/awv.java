public final class awv
{
  public final String a;
  public final String b;
  public final int c;
  
  public awv(String paramString1, String paramString2, int paramInt)
  {
    a = paramString1;
    b = paramString2;
    c = paramInt;
  }
  
  public final String toString()
  {
    String str1;
    if (a == null)
    {
      str1 = "null";
      if (b != null) {
        break label87;
      }
    }
    label87:
    for (String str2 = "null";; str2 = "[REDACTED]")
    {
      int i = c;
      return String.valueOf(str1).length() + 52 + String.valueOf(str2).length() + "result access " + str1 + " refresh " + str2 + " expiresInSeconds " + i;
      str1 = "[REDACTED]";
      break;
    }
  }
}

/* Location:
 * Qualified Name:     awv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */