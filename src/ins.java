import java.util.Date;

public final class ins
  extends imw
{
  private static final long serialVersionUID = -88820909016649306L;
  imj a;
  Date b;
  int c;
  byte[] d;
  int e;
  byte[] f;
  private int k;
  
  ins() {}
  
  public ins(imj paramimj1, imj paramimj2, Date paramDate, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    super(paramimj1, 250, 255, 0L);
    a = a(paramimj2);
    b = paramDate;
    c = a("fudge", paramInt1);
    d = paramArrayOfByte1;
    k = a("originalID", paramInt2);
    e = a("error", paramInt3);
    f = paramArrayOfByte2;
  }
  
  final imw a()
  {
    return new ins();
  }
  
  final void a(ikr paramikr)
  {
    a = new imj(paramikr);
    b = new Date(((paramikr.c() << 32) + paramikr.d()) * 1000L);
    c = paramikr.c();
    d = paramikr.b(paramikr.c());
    k = paramikr.c();
    e = paramikr.c();
    int i = paramikr.c();
    if (i > 0)
    {
      f = paramikr.b(i);
      return;
    }
    f = null;
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    a.a(paramikt, null, paramBoolean);
    long l = b.getTime() / 1000L;
    paramikt.b((int)(l >> 32));
    paramikt.a(l & 0xFFFFFFFF);
    paramikt.b(c);
    paramikt.b(d.length);
    paramikt.a(d);
    paramikt.b(k);
    paramikt.b(e);
    if (f != null)
    {
      paramikt.b(f.length);
      paramikt.a(f);
      return;
    }
    paramikt.b(0);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    localStringBuffer.append(" ");
    if (imn.a("multiline")) {
      localStringBuffer.append("(\n\t");
    }
    localStringBuffer.append(b.getTime() / 1000L);
    localStringBuffer.append(" ");
    localStringBuffer.append(c);
    localStringBuffer.append(" ");
    localStringBuffer.append(d.length);
    if (imn.a("multiline"))
    {
      localStringBuffer.append("\n");
      localStringBuffer.append(ioq.a(d, "\t", false));
      localStringBuffer.append(" ");
      int i = e;
      localStringBuffer.append(imv.b.c(i));
      localStringBuffer.append(" ");
      if (f != null) {
        break label223;
      }
      localStringBuffer.append(0);
    }
    for (;;)
    {
      if (imn.a("multiline")) {
        localStringBuffer.append(" )");
      }
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append(ioq.a(d));
      break;
      label223:
      localStringBuffer.append(f.length);
      if (imn.a("multiline")) {
        localStringBuffer.append("\n\n\n\t");
      }
      for (;;)
      {
        if (e == 18)
        {
          if (f.length != 6)
          {
            localStringBuffer.append("<invalid BADTIME other data>");
            break;
            localStringBuffer.append(" ");
            continue;
          }
          long l1 = f[0] & 0xFF;
          long l2 = f[1] & 0xFF;
          long l3 = (f[2] & 0xFF) << 24;
          long l4 = (f[3] & 0xFF) << 16;
          long l5 = (f[4] & 0xFF) << 8;
          long l6 = f[5] & 0xFF;
          localStringBuffer.append("<server time: ");
          localStringBuffer.append(new Date(((l1 << 40) + (l2 << 32) + l3 + l4 + l5 + l6) * 1000L));
          localStringBuffer.append(">");
          break;
        }
      }
      localStringBuffer.append("<");
      localStringBuffer.append(ioq.a(f));
      localStringBuffer.append(">");
    }
  }
}

/* Location:
 * Qualified Name:     ins
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */