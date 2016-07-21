import java.util.Date;

public final class ino
  extends imw
{
  private static final long serialVersionUID = 8828458121926391756L;
  private imj a;
  private Date b;
  private Date c;
  private int d;
  private int e;
  private byte[] f;
  private byte[] k;
  
  final imw a()
  {
    return new ino();
  }
  
  final void a(ikr paramikr)
  {
    a = new imj(paramikr);
    b = new Date(paramikr.d() * 1000L);
    c = new Date(paramikr.d() * 1000L);
    d = paramikr.c();
    e = paramikr.c();
    int i = paramikr.c();
    if (i > 0) {}
    for (f = paramikr.b(i);; f = null)
    {
      i = paramikr.c();
      if (i <= 0) {
        break;
      }
      k = paramikr.b(i);
      return;
    }
    k = null;
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    a.a(paramikt, null, paramBoolean);
    paramikt.a(b.getTime() / 1000L);
    paramikt.a(c.getTime() / 1000L);
    paramikt.b(d);
    paramikt.b(e);
    if (f != null)
    {
      paramikt.b(f.length);
      paramikt.a(f);
    }
    while (k != null)
    {
      paramikt.b(k.length);
      paramikt.a(k);
      return;
      paramikt.b(0);
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
    localStringBuffer.append(ilb.a(b));
    localStringBuffer.append(" ");
    localStringBuffer.append(ilb.a(c));
    localStringBuffer.append(" ");
    String str;
    switch (d)
    {
    default: 
      str = Integer.toString(d);
      localStringBuffer.append(str);
      localStringBuffer.append(" ");
      int i = e;
      localStringBuffer.append(imv.b.c(i));
      if (imn.a("multiline"))
      {
        localStringBuffer.append("\n");
        if (f != null)
        {
          localStringBuffer.append(ioq.a(f, "\t", false));
          localStringBuffer.append("\n");
        }
        if (k != null) {
          localStringBuffer.append(ioq.a(k, "\t", false));
        }
        localStringBuffer.append(" )");
      }
      break;
    }
    for (;;)
    {
      return localStringBuffer.toString();
      str = "SERVERASSIGNED";
      break;
      str = "DIFFIEHELLMAN";
      break;
      str = "GSSAPI";
      break;
      str = "RESOLVERASSIGNED";
      break;
      str = "DELETE";
      break;
      localStringBuffer.append(" ");
      if (f != null)
      {
        localStringBuffer.append(ioq.a(f));
        localStringBuffer.append(" ");
      }
      if (k != null) {
        localStringBuffer.append(ioq.a(k));
      }
    }
  }
}

/* Location:
 * Qualified Name:     ino
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */