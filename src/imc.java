public final class imc
  extends imw
{
  private static final long serialVersionUID = -8689038598776316533L;
  private int a;
  private int b;
  private int c;
  private byte[] d;
  
  final imw a()
  {
    return new imc();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.b();
    b = paramikr.b();
    c = paramikr.c();
    int i = paramikr.b();
    if (i > 0)
    {
      d = paramikr.b(i);
      return;
    }
    d = null;
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
      return;
    }
    paramikt.a(0);
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
      return localStringBuffer.toString();
      localStringBuffer.append(ioo.a(d));
    }
  }
}

/* Location:
 * Qualified Name:     imc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */