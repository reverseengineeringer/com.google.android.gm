public final class inp
  extends imw
{
  private static final long serialVersionUID = 356494267028580169L;
  private int a;
  private int b;
  private int c;
  private byte[] d;
  
  final imw a()
  {
    return new inp();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.b();
    b = paramikr.b();
    c = paramikr.b();
    d = paramikr.e();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a);
    paramikt.a(b);
    paramikt.a(c);
    paramikt.a(d);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    localStringBuffer.append(" ");
    localStringBuffer.append(c);
    localStringBuffer.append(" ");
    localStringBuffer.append(ioo.a(d));
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     inp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */