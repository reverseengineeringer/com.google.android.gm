public final class gqf
{
  public static final Integer a = Integer.valueOf(1);
  public static final Integer b = Integer.valueOf(22);
  public static final Integer c = Integer.valueOf(0);
  public static final String d;
  
  static
  {
    String str1 = String.valueOf(a);
    String str2 = String.valueOf(b);
    String str3 = String.valueOf(c);
    d = (String.valueOf(str1).length() + 11 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + "." + str2 + "." + str3 + "-SNAPSHOT").toString();
  }
}

/* Location:
 * Qualified Name:     gqf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */