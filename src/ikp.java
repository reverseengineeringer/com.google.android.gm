public final class ikp
  extends imw
{
  private static final long serialVersionUID = 1960742375677534148L;
  private int a;
  private int b;
  private int c;
  private byte[] d;
  
  final imw a()
  {
    return new ikp();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = paramikr.b();
    c = paramikr.b();
    d = paramikr.e();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    paramikt.a(b);
    paramikt.a(c);
    if (d != null) {
      paramikt.a(d);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    localStringBuffer.append(" ");
    localStringBuffer.append(c);
    if (d != null)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(ioo.a(d));
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ikp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */