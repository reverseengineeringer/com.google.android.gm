import java.nio.charset.Charset;

public abstract class grb
  implements grj
{
  grr a;
  private long b = -1L;
  
  protected grb(grr paramgrr)
  {
    a = paramgrr;
  }
  
  public grb(String paramString) {}
  
  public static long a(grj paramgrj)
  {
    if (!paramgrj.d()) {
      return -1L;
    }
    return gue.a(paramgrj);
  }
  
  public final long a()
  {
    if (b == -1L) {
      b = a(this);
    }
    return b;
  }
  
  public final Charset b()
  {
    if ((a == null) || (a.b() == null)) {
      return gtq.a;
    }
    return a.b();
  }
  
  public final String c()
  {
    if (a == null) {
      return null;
    }
    return a.a();
  }
  
  public boolean d()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     grb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */