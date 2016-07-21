import java.text.ParseException;

public final class ibt
  extends icb
{
  private static final long serialVersionUID = 5049421499261722194L;
  private hst d;
  
  public ibt()
  {
    super("TRIGGER", hug.a);
  }
  
  public final String a()
  {
    if (d != null) {
      return d.toString();
    }
    return super.a();
  }
  
  public final void a(hsq paramhsq)
  {
    super.a(paramhsq);
    d = null;
    b.b(hzm.f);
  }
  
  public final void b(String paramString)
  {
    try
    {
      super.b(paramString);
      d = null;
      return;
    }
    catch (ParseException localParseException)
    {
      d = new hst(paramString);
      super.a(null);
    }
  }
}

/* Location:
 * Qualified Name:     ibt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */