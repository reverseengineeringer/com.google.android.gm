public final class ilh
  extends imw
{
  private static final long serialVersionUID = -8730801385178968798L;
  private byte[] a;
  private byte[] b;
  
  final imw a()
  {
    return new ilh();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.f();
    if (paramikr.a() > 0) {
      b = paramikr.f();
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    if (b != null) {
      paramikt.b(b);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(a, true));
    if (b != null)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(a(b, true));
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ilh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */