public final class axu
  extends axr
{
  public final boolean e;
  public int f;
  private final String g;
  
  protected axu(String paramString, boolean paramBoolean)
  {
    g = paramString;
    e = paramBoolean;
  }
  
  public final boolean a(int paramInt, String paramString)
  {
    return (!f()) && (c(paramInt).a(paramString));
  }
  
  public final boolean f()
  {
    return g != null;
  }
  
  public final boolean g()
  {
    boolean bool = false;
    String str = c(0).e();
    if (("OK".equalsIgnoreCase(str)) || ("NO".equalsIgnoreCase(str)) || ("BAD".equalsIgnoreCase(str)) || ("PREAUTH".equalsIgnoreCase(str)) || ("BYE".equalsIgnoreCase(str))) {
      bool = true;
    }
    return bool;
  }
  
  public final axy h()
  {
    if (!g()) {
      return axy.d;
    }
    return b(1).c(0);
  }
  
  public final axy i()
  {
    if (!h().a("ALERT")) {
      return axy.d;
    }
    return c(2);
  }
  
  public final axy j()
  {
    int i = 1;
    if (!g()) {
      return axy.d;
    }
    if (a(1).a()) {
      i = 2;
    }
    return c(i);
  }
  
  public final String toString()
  {
    String str1 = g;
    if (e) {
      str1 = "+";
    }
    String str2 = String.valueOf(super.toString());
    return String.valueOf(str1).length() + 3 + String.valueOf(str2).length() + "#" + str1 + "# " + str2;
  }
}

/* Location:
 * Qualified Name:     axu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */