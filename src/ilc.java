public final class ilc
  extends imw
{
  private static final long serialVersionUID = -6349714958085750705L;
  private byte[] a;
  private byte[] b;
  private byte[] c;
  
  final imw a()
  {
    return new ilc();
  }
  
  final void a(ikr paramikr)
  {
    b = paramikr.f();
    a = paramikr.f();
    c = paramikr.f();
    double d2;
    try
    {
      double d1 = Double.parseDouble(a(b, false));
      d2 = Double.parseDouble(a(a, false));
      if ((d1 < -90.0D) || (d1 > 90.0D)) {
        throw new IllegalArgumentException(42 + "illegal longitude " + d1);
      }
    }
    catch (IllegalArgumentException paramikr)
    {
      throw new iog(paramikr.getMessage());
    }
    if ((d2 < -180.0D) || (d2 > 180.0D)) {
      throw new IllegalArgumentException(41 + "illegal latitude " + d2);
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(b);
    paramikt.b(a);
    paramikt.b(c);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(b, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(a, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(c, true));
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ilc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */