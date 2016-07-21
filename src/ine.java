public final class ine
  extends imw
{
  private static final long serialVersionUID = 1049740098229303931L;
  long a;
  long b;
  private imj c;
  private imj d;
  private long e;
  private long f;
  private long k;
  
  ine() {}
  
  public ine(imj paramimj1, int paramInt, imj paramimj2, imj paramimj3, long paramLong)
  {
    super(paramimj1, 6, paramInt, 0L);
    c = a(paramimj2);
    d = a(paramimj3);
    a = a("serial", paramLong);
    e = a("refresh", 0L);
    f = a("retry", 0L);
    k = a("expire", 0L);
    b = a("minimum", 0L);
  }
  
  final imw a()
  {
    return new ine();
  }
  
  final void a(ikr paramikr)
  {
    c = new imj(paramikr);
    d = new imj(paramikr);
    a = paramikr.d();
    e = paramikr.d();
    f = paramikr.d();
    k = paramikr.d();
    b = paramikr.d();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    c.a(paramikt, paramikk, paramBoolean);
    d.a(paramikt, paramikk, paramBoolean);
    paramikt.a(a);
    paramikt.a(e);
    paramikt.a(f);
    paramikt.a(k);
    paramikt.a(b);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(c);
    localStringBuffer.append(" ");
    localStringBuffer.append(d);
    if (imn.a("multiline"))
    {
      localStringBuffer.append(" (\n\t\t\t\t\t");
      localStringBuffer.append(a);
      localStringBuffer.append("\t; serial\n\t\t\t\t\t");
      localStringBuffer.append(e);
      localStringBuffer.append("\t; refresh\n\t\t\t\t\t");
      localStringBuffer.append(f);
      localStringBuffer.append("\t; retry\n\t\t\t\t\t");
      localStringBuffer.append(k);
      localStringBuffer.append("\t; expire\n\t\t\t\t\t");
      localStringBuffer.append(b);
      localStringBuffer.append(" )\t; minimum");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append(a);
      localStringBuffer.append(" ");
      localStringBuffer.append(e);
      localStringBuffer.append(" ");
      localStringBuffer.append(f);
      localStringBuffer.append(" ");
      localStringBuffer.append(k);
      localStringBuffer.append(" ");
      localStringBuffer.append(b);
    }
  }
}

/* Location:
 * Qualified Name:     ine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */