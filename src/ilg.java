import java.net.InetAddress;

public final class ilg
  extends imw
{
  private static final long serialVersionUID = 3050449702765909687L;
  private int a;
  private int b;
  private int c;
  private Object d;
  private byte[] e;
  
  final imw a()
  {
    return new ilg();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.b();
    b = paramikr.b();
    c = paramikr.b();
    switch (b)
    {
    default: 
      throw new iog("invalid gateway type");
    case 0: 
      d = null;
    }
    for (;;)
    {
      if (paramikr.a() > 0) {
        e = paramikr.e();
      }
      return;
      d = InetAddress.getByAddress(paramikr.b(4));
      continue;
      d = InetAddress.getByAddress(paramikr.b(16));
      continue;
      d = new imj(paramikr);
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a);
    paramikt.a(b);
    paramikt.a(c);
    switch (b)
    {
    }
    for (;;)
    {
      if (e != null) {
        paramikt.a(e);
      }
      return;
      paramikt.a(((InetAddress)d).getAddress());
      continue;
      ((imj)d).a(paramikt, null, paramBoolean);
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
    localStringBuffer.append(" ");
    switch (b)
    {
    }
    for (;;)
    {
      if (e != null)
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(ioq.a(e));
      }
      return localStringBuffer.toString();
      localStringBuffer.append(".");
      continue;
      localStringBuffer.append(((InetAddress)d).getHostAddress());
      continue;
      localStringBuffer.append(d);
    }
  }
}

/* Location:
 * Qualified Name:     ilg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */