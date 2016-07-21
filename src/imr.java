public final class imr
  extends imw
{
  private static final long serialVersionUID = 8124584364211337460L;
  private imj a;
  private imj b;
  
  final imw a()
  {
    return new imr();
  }
  
  final void a(ikr paramikr)
  {
    a = new imj(paramikr);
    b = new imj(paramikr);
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    a.a(paramikt, null, paramBoolean);
    b.a(paramikt, null, paramBoolean);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     imr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */