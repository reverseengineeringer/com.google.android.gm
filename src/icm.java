public final class icm
{
  public static int a(String paramString)
  {
    if ((paramString != null) && (paramString.charAt(0) == '+')) {
      return Integer.parseInt(paramString.substring(1));
    }
    return Integer.parseInt(paramString);
  }
}

/* Location:
 * Qualified Name:     icm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */