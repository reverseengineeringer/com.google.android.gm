import java.io.IOException;

public class gst
  extends gua
  implements Cloneable
{
  gsu a;
  
  public gst a()
  {
    return (gst)super.b();
  }
  
  public gst a(String paramString, Object paramObject)
  {
    return (gst)super.b(paramString, paramObject);
  }
  
  public final String c()
  {
    if (a != null) {
      return a.a(this, true);
    }
    return super.toString();
  }
  
  public String toString()
  {
    if (a != null) {
      try
      {
        String str = a.a(this, false);
        return str;
      }
      catch (IOException localIOException)
      {
        throw hbx.a(localIOException);
      }
    }
    return super.toString();
  }
}

/* Location:
 * Qualified Name:     gst
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */