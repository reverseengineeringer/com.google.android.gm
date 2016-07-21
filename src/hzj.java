import java.net.URI;

public final class hzj
  extends hsy
{
  private static final long serialVersionUID = -1169413145174029391L;
  private URI b;
  
  public hzj(String paramString)
  {
    this(icq.c(ico.a(paramString)));
  }
  
  private hzj(URI paramURI)
  {
    super("SENT-BY", hta.a);
    b = paramURI;
  }
  
  public final String a()
  {
    return icq.b(ico.b(b));
  }
}

/* Location:
 * Qualified Name:     hzj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */