import java.io.ByteArrayInputStream;
import java.io.InputStream;

public final class axx
  extends axy
{
  private String f;
  
  public axx(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      f = paramString;
      return;
      paramString = "";
    }
  }
  
  public final void c()
  {
    f = null;
    super.c();
  }
  
  public final String e()
  {
    return f;
  }
  
  public final InputStream f()
  {
    String str = f;
    return new ByteArrayInputStream(bhn.a(bhn.b, str));
  }
  
  public final String toString()
  {
    String str = f;
    return String.valueOf(str).length() + 2 + "\"" + str + "\"";
  }
}

/* Location:
 * Qualified Name:     axx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */