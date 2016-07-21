public final class ilz
  extends imw
{
  private static final long serialVersionUID = 5191232392044947002L;
  private int a;
  private int b;
  private byte[] c;
  private byte[] d;
  private byte[] e;
  private imj f;
  
  final imw a()
  {
    return new ilz();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = paramikr.c();
    c = paramikr.f();
    d = paramikr.f();
    e = paramikr.f();
    f = new imj(paramikr);
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    paramikt.b(b);
    paramikt.b(c);
    paramikt.b(d);
    paramikt.b(e);
    f.a(paramikt, null, paramBoolean);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    localStringBuffer.append(" ");
    localStringBuffer.append(a(c, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(d, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(e, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(f);
    return localStringBuffer.toString();
  }
  
  public final imj c()
  {
    return f;
  }
}

/* Location:
 * Qualified Name:     ilz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */