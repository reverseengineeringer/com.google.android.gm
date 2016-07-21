import java.security.PublicKey;

abstract class ill
  extends imw
{
  private static final long serialVersionUID = 3469321722693285454L;
  public int a;
  public int b;
  public int c;
  public byte[] d;
  public int e = -1;
  public PublicKey f = null;
  
  private final int d()
  {
    int j = 0;
    if (e >= 0) {
      return e;
    }
    Object localObject = new ikt((byte)0);
    a((ikt)localObject, null, false);
    localObject = ((ikt)localObject).a();
    if (c == 1) {}
    int k;
    for (int i = ((localObject[(localObject.length - 3)] & 0xFF) << 8) + (localObject[(localObject.length - 2)] & 0xFF);; i = (k >> 16 & 0xFFFF) + k)
    {
      e = (i & 0xFFFF);
      return e;
      i = 0;
      while (j < localObject.length - 1)
      {
        i += ((localObject[j] & 0xFF) << 8) + (localObject[(j + 1)] & 0xFF);
        j += 2;
      }
      k = i;
      if (j < localObject.length) {
        k = i + ((localObject[j] & 0xFF) << 8);
      }
    }
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = paramikr.b();
    c = paramikr.b();
    if (paramikr.a() > 0) {
      d = paramikr.e();
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    paramikt.a(b);
    paramikt.a(c);
    if (d != null) {
      paramikt.a(d);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    localStringBuffer.append(" ");
    localStringBuffer.append(c);
    if (d != null)
    {
      if (!imn.a("multiline")) {
        break label107;
      }
      localStringBuffer.append(" (\n");
      localStringBuffer.append(ioq.a(d, "\t", true));
      localStringBuffer.append(" ; key_tag = ");
      localStringBuffer.append(d());
    }
    for (;;)
    {
      return localStringBuffer.toString();
      label107:
      localStringBuffer.append(" ");
      localStringBuffer.append(ioq.a(d));
    }
  }
}

/* Location:
 * Qualified Name:     ill
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */