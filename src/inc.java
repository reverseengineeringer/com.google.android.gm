import java.util.Date;

abstract class inc
  extends imw
{
  private static final long serialVersionUID = -3738444391533812369L;
  public int a;
  public int b;
  public int c;
  public long d;
  public Date e;
  public Date f;
  public int k;
  public imj l;
  public byte[] m;
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = paramikr.b();
    c = paramikr.b();
    d = paramikr.d();
    e = new Date(paramikr.d() * 1000L);
    f = new Date(paramikr.d() * 1000L);
    k = paramikr.c();
    l = new imj(paramikr);
    m = paramikr.e();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    paramikt.a(b);
    paramikt.a(c);
    paramikt.a(d);
    paramikt.a(e.getTime() / 1000L);
    paramikt.a(f.getTime() / 1000L);
    paramikt.b(k);
    l.a(paramikt, null, paramBoolean);
    paramikt.a(m);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = a;
    localStringBuffer.append(inx.a.c(i));
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    localStringBuffer.append(" ");
    localStringBuffer.append(c);
    localStringBuffer.append(" ");
    localStringBuffer.append(d);
    localStringBuffer.append(" ");
    if (imn.a("multiline")) {
      localStringBuffer.append("(\n\t");
    }
    localStringBuffer.append(ilb.a(e));
    localStringBuffer.append(" ");
    localStringBuffer.append(ilb.a(f));
    localStringBuffer.append(" ");
    localStringBuffer.append(k);
    localStringBuffer.append(" ");
    localStringBuffer.append(l);
    if (imn.a("multiline"))
    {
      localStringBuffer.append("\n");
      localStringBuffer.append(ioq.a(m, "\t", true));
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append(ioq.a(m));
    }
  }
}

/* Location:
 * Qualified Name:     inc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */