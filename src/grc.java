import java.io.InputStream;
import java.io.OutputStream;

public abstract class grc
  implements grj
{
  public String a;
  public boolean b = true;
  
  public grc(String paramString)
  {
    a(paramString);
  }
  
  public grc a(String paramString)
  {
    a = paramString;
    return this;
  }
  
  public grc a(boolean paramBoolean)
  {
    b = paramBoolean;
    return this;
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    gue.a(b(), paramOutputStream, b);
    paramOutputStream.flush();
  }
  
  public abstract InputStream b();
  
  public final String c()
  {
    return a;
  }
}

/* Location:
 * Qualified Name:     grc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */