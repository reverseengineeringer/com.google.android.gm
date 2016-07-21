public class ild
  extends ikv
{
  private byte[] a;
  
  ild(int paramInt)
  {
    super(paramInt);
  }
  
  final String a()
  {
    String str = ioo.a(a);
    return String.valueOf(str).length() + 2 + "<" + str + ">";
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.e();
  }
  
  final void a(ikt paramikt)
  {
    paramikt.a(a);
  }
}

/* Location:
 * Qualified Name:     ild
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */