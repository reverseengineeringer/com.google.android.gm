import java.util.HashMap;

public final class brk
{
  bdm a = new bdm();
  public long b = 0L;
  public String c;
  public String d;
  
  public brk() {}
  
  public brk(long paramLong, String paramString1, String paramString2)
  {
    a("_id", Long.toString(paramLong));
    b = paramLong;
    a("displayName", paramString1);
    c = paramString1;
    a("emailAddress", paramString2);
    d = paramString2;
  }
  
  public final String a(String paramString)
  {
    return (String)a.a.get(paramString);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    a.a(paramString1, paramString2);
  }
}

/* Location:
 * Qualified Name:     brk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */