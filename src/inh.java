public final class inh
  extends imw
{
  private static final long serialVersionUID = -8104701402654687025L;
  private int a;
  private int b;
  private byte[] c;
  
  final imw a()
  {
    return new inh();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.b();
    b = paramikr.b();
    c = paramikr.e();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a);
    paramikt.a(b);
    paramikt.a(c);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    localStringBuffer.append(" ");
    localStringBuffer.append(ioo.a(c));
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     inh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */