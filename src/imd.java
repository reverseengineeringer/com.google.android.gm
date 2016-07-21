import java.util.TreeSet;

public final class imd
  extends imw
{
  private static final iop k = new iop("0123456789ABCDEFGHIJKLMNOPQRSTUV=");
  private static final long serialVersionUID = -7123504635968932855L;
  private int a;
  private int b;
  private int c;
  private byte[] d;
  private byte[] e;
  private inz f;
  
  final imw a()
  {
    return new imd();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.b();
    b = paramikr.b();
    c = paramikr.c();
    int i = paramikr.b();
    if (i > 0) {}
    for (d = paramikr.b(i);; d = null)
    {
      e = paramikr.b(paramikr.b());
      f = new inz(paramikr);
      return;
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a);
    paramikt.a(b);
    paramikt.b(c);
    if (d != null)
    {
      paramikt.a(d.length);
      paramikt.a(d);
    }
    for (;;)
    {
      paramikt.a(e.length);
      paramikt.a(e);
      f.a(paramikt);
      return;
      paramikt.a(0);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(' ');
    localStringBuffer.append(b);
    localStringBuffer.append(' ');
    localStringBuffer.append(c);
    localStringBuffer.append(' ');
    if (d == null) {
      localStringBuffer.append('-');
    }
    for (;;)
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(k.a(e));
      if (!f.a.isEmpty())
      {
        localStringBuffer.append(' ');
        localStringBuffer.append(f.toString());
      }
      return localStringBuffer.toString();
      localStringBuffer.append(ioo.a(d));
    }
  }
}

/* Location:
 * Qualified Name:     imd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */