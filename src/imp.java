public final class imp
  extends imw
{
  private static final long serialVersionUID = 1811540008806660667L;
  private int a;
  private imj b;
  private imj c;
  
  final imw a()
  {
    return new imp();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = new imj(paramikr);
    c = new imj(paramikr);
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    b.a(paramikt, null, paramBoolean);
    c.a(paramikt, null, paramBoolean);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    localStringBuffer.append(" ");
    localStringBuffer.append(c);
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     imp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */