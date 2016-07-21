public final class ijy
  extends imw
{
  private static final long serialVersionUID = -2172609200849142323L;
  private int a;
  
  final imw a()
  {
    return new ijy();
  }
  
  final void a(ikr paramikr)
  {
    paramikr = paramikr.b(4);
    int i = paramikr[0];
    int j = paramikr[1];
    int k = paramikr[2];
    a = (paramikr[3] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8);
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a & 0xFFFFFFFF);
  }
  
  final String b()
  {
    int i = a;
    return ijz.a(new byte[] { (byte)(i >>> 24 & 0xFF), (byte)(i >>> 16 & 0xFF), (byte)(i >>> 8 & 0xFF), (byte)(i & 0xFF) });
  }
}

/* Location:
 * Qualified Name:     ijy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */