public final class ile
  extends imw
{
  private static final long serialVersionUID = -4732870630947452112L;
  private byte[] a;
  private byte[] b;
  
  final imw a()
  {
    return new ile();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.f();
    b = paramikr.f();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    paramikt.b(b);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(a, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(b, true));
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */