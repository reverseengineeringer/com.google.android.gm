abstract class ioa
  extends imw
{
  private static final long serialVersionUID = -8315884183112502995L;
  public int a;
  public imj b;
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = new imj(paramikr);
  }
  
  void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
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
 * Qualified Name:     ioa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */