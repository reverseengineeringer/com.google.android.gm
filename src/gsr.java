import java.io.OutputStream;

public final class gsr
  extends grb
{
  public String b;
  private final Object c;
  private final gsu d;
  
  public gsr(gsu paramgsu, Object paramObject)
  {
    super("application/json; charset=UTF-8");
    d = ((gsu)hbe.a(paramgsu));
    c = hbe.a(paramObject);
  }
  
  public final void a(OutputStream paramOutputStream)
  {
    paramOutputStream = d.a(paramOutputStream, b());
    if (b != null)
    {
      paramOutputStream.f();
      paramOutputStream.a(b);
    }
    paramOutputStream.a(false, c);
    if (b != null) {
      paramOutputStream.c();
    }
    paramOutputStream.a();
  }
}

/* Location:
 * Qualified Name:     gsr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */