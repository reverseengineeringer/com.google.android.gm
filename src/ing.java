public class ing
  extends imw
{
  private static final long serialVersionUID = -3886460132387522052L;
  public int a;
  public int b;
  public imj c;
  private int d;
  
  final imw a()
  {
    return new ing();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = paramikr.c();
    d = paramikr.c();
    c = new imj(paramikr);
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    paramikt.b(b);
    paramikt.b(d);
    c.a(paramikt, null, paramBoolean);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = a;
    localStringBuffer.append(12 + i + " ");
    i = b;
    localStringBuffer.append(12 + i + " ");
    i = d;
    localStringBuffer.append(12 + i + " ");
    localStringBuffer.append(c);
    return localStringBuffer.toString();
  }
  
  public final imj c()
  {
    return c;
  }
}

/* Location:
 * Qualified Name:     ing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */