public final class ddh
{
  public static int a(String paramString)
  {
    if (paramString.endsWith("@google.com")) {
      return 805306368;
    }
    if ((paramString.endsWith("@gmail.com")) || (paramString.endsWith("@googlemail.com"))) {
      return 268435456;
    }
    return 536870912;
  }
  
  public static boolean b(String paramString)
  {
    return a(paramString) == 268435456;
  }
}

/* Location:
 * Qualified Name:     ddh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */