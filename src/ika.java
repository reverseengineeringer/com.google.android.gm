public final class ika
  extends imw
{
  private static final long serialVersionUID = 4763014646517016835L;
  private int a;
  private int b;
  private int c;
  private byte[] d;
  
  final imw a()
  {
    return new ika();
  }
  
  final void a(ikr paramikr)
  {
    a = paramikr.c();
    b = paramikr.c();
    c = paramikr.b();
    d = paramikr.e();
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.b(a);
    paramikt.b(b);
    paramikt.a(c);
    paramikt.a(d);
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
        break label91;
      }
      localStringBuffer.append(" (\n");
      localStringBuffer.append(ioq.a(d, "\t", true));
    }
    for (;;)
    {
      return localStringBuffer.toString();
      label91:
      localStringBuffer.append(" ");
      localStringBuffer.append(ioq.a(d));
    }
  }
}

/* Location:
 * Qualified Name:     ika
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */