public final class ima
  extends imw
{
  private static final long serialVersionUID = -1037209403185658593L;
  private byte[] a;
  
  final imw a()
  {
    return new ima();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.e();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a);
  }
  
  final String b()
  {
    String str = String.valueOf(ioo.a(a));
    if (str.length() != 0) {
      return "0x".concat(str);
    }
    return new String("0x");
  }
}

/* Location:
 * Qualified Name:     ima
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */