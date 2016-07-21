import java.util.Date;
import java.util.List;

public final class inq
{
  public static final imj a;
  public static final imj b;
  public static final imj c = imj.b("hmac-sha1.");
  public static final imj d = imj.b("hmac-sha224.");
  public static final imj e = imj.b("hmac-sha256.");
  public static final imj f = imj.b("hmac-sha384.");
  public static final imj g = imj.b("hmac-sha512.");
  imj h;
  imj i;
  String j;
  int k;
  byte[] l;
  
  static
  {
    imj localimj = imj.b("HMAC-MD5.SIG-ALG.REG.INT.");
    a = localimj;
    b = localimj;
  }
  
  static String a(inq paraminq)
  {
    return j;
  }
  
  static int b(inq paraminq)
  {
    return k;
  }
  
  static byte[] c(inq paraminq)
  {
    return l;
  }
  
  static imj d(inq paraminq)
  {
    return h;
  }
  
  static imj e(inq paraminq)
  {
    return i;
  }
  
  public final ins a(ilx paramilx, byte[] paramArrayOfByte, int paramInt, ins paramins)
  {
    Date localDate;
    ion localion;
    int m;
    long l1;
    if (paramInt != 18)
    {
      localDate = new Date();
      localion = null;
      if ((paramInt == 0) || (paramInt == 18)) {
        localion = new ion(j, k, l);
      }
      int n = imn.b("tsigfudge");
      if (n >= 0)
      {
        m = n;
        if (n <= 32767) {}
      }
      else
      {
        m = 300;
      }
      if (paramins != null)
      {
        ikt localikt = new ikt((byte)0);
        localikt.b(d.length);
        if (localion != null)
        {
          localion.a(localikt.a());
          localion.a(d);
        }
      }
      if (localion != null) {
        localion.a(paramArrayOfByte);
      }
      paramArrayOfByte = new ikt((byte)0);
      h.a(paramArrayOfByte);
      paramArrayOfByte.b(255);
      paramArrayOfByte.a(0L);
      i.a(paramArrayOfByte);
      l1 = localDate.getTime() / 1000L;
      paramArrayOfByte.b((int)(l1 >> 32));
      paramArrayOfByte.a(l1 & 0xFFFFFFFF);
      paramArrayOfByte.b(m);
      paramArrayOfByte.b(paramInt);
      paramArrayOfByte.b(0);
      if (localion != null) {
        localion.a(paramArrayOfByte.a());
      }
      if (localion == null) {
        break label354;
      }
    }
    label354:
    for (paramArrayOfByte = localion.a();; paramArrayOfByte = new byte[0])
    {
      paramins = null;
      if (paramInt == 18)
      {
        paramins = new ikt((byte)0);
        l1 = new Date().getTime() / 1000L;
        paramins.b((int)(l1 >> 32));
        paramins.a(l1 & 0xFFFFFFFF);
        paramins = paramins.a();
      }
      return new ins(h, i, localDate, m, paramArrayOfByte, a.b(), paramInt, paramins);
      localDate = b;
      break;
    }
  }
  
  public final void apply(ilx paramilx, int paramInt, ins paramins)
  {
    ikt localikt = new ikt((byte)0);
    a.a(localikt);
    ikk localikk = new ikk();
    int m = 0;
    while (m < 4)
    {
      if (b[m] != null)
      {
        int n = 0;
        while (n < b[m].size())
        {
          ((imw)b[m].get(n)).a(localikt, m, localikk);
          n += 1;
        }
      }
      m += 1;
    }
    c = a;
    paramilx.a(a(paramilx, localikt.a(), paramInt, paramins), 3);
    e = 3;
  }
  
  public final void apply(ilx paramilx, ins paramins)
  {
    apply(paramilx, 0, paramins);
  }
}

/* Location:
 * Qualified Name:     inq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */