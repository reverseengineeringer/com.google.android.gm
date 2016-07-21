import java.io.InputStream;

public final class gsc
  extends grc
{
  public long c = -1L;
  public boolean d;
  private final InputStream e;
  
  public gsc(String paramString, InputStream paramInputStream)
  {
    super(paramString);
    e = ((InputStream)hbe.a(paramInputStream));
  }
  
  public final long a()
  {
    return c;
  }
  
  public final gsc b(boolean paramBoolean)
  {
    return (gsc)super.a(paramBoolean);
  }
  
  public final InputStream b()
  {
    return e;
  }
  
  public final boolean d()
  {
    return d;
  }
}

/* Location:
 * Qualified Name:     gsc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */