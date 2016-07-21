import java.io.UnsupportedEncodingException;

public final class ikj
  extends ikv
{
  public long a;
  public long b;
  public byte[] c;
  public byte[] d;
  
  public ikj()
  {
    super(20732);
  }
  
  final String a()
  {
    long l1;
    long l2;
    try
    {
      l1 = a;
      l2 = b;
      String str1 = new String(c, "UTF-8");
      String str2 = new String(d, "UTF-8");
      str1 = String.valueOf(str1).length() + 50 + String.valueOf(str2).length() + "{task " + l1 + "/" + l2 + " " + str1 + "/" + str2 + "}";
      return str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      l1 = a;
      l2 = b;
    }
    return 48 + "{task " + l1 + "/" + l2 + "}";
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.d();
    b = paramikr.d();
    c = paramikr.b(paramikr.b());
    d = paramikr.b(paramikr.b());
  }
  
  final void a(ikt paramikt)
  {
    paramikt.a(a);
    paramikt.a(b);
    paramikt.a(c.length);
    paramikt.a(c);
    paramikt.a(d.length);
    paramikt.a(d);
  }
}

/* Location:
 * Qualified Name:     ikj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */