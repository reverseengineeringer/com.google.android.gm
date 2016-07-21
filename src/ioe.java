public final class ioe
  extends imw
{
  private static final long serialVersionUID = 7955422413971804232L;
  private int a;
  private int b;
  private byte[] c = new byte[0];
  
  final imw a()
  {
    return new ioe();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = paramikr.c();
    c = paramikr.f();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    paramikt.b(b);
    paramikt.b(c);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = a;
    localStringBuffer.append(12 + i + " ");
    i = b;
    localStringBuffer.append(12 + i + " ");
    localStringBuffer.append(a(c, true));
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ioe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */