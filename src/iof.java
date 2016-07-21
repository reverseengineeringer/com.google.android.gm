import java.util.ArrayList;
import java.util.List;

public final class iof
  extends imw
{
  private static final long serialVersionUID = -9104259763909119805L;
  private byte[] a;
  private int b;
  private int[] c;
  
  final imw a()
  {
    return new iof();
  }
  
  final void a(ikr paramikr)
  {
    int k = 0;
    a = paramikr.b(4);
    b = paramikr.b();
    paramikr = paramikr.e();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramikr.length)
    {
      int j = 0;
      while (j < 8)
      {
        if ((paramikr[i] & 0xFF & 1 << 7 - j) != 0) {
          localArrayList.add(new Integer(i * 8 + j));
        }
        j += 1;
      }
      i += 1;
    }
    c = new int[localArrayList.size()];
    i = k;
    while (i < localArrayList.size())
    {
      c[i] = ((Integer)localArrayList.get(i)).intValue();
      i += 1;
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    paramikt.a(a);
    paramikt.a(b);
    paramikk = new byte[c[(c.length - 1)] / 8 + 1];
    int i = 0;
    while (i < c.length)
    {
      int j = c[i];
      int k = j / 8;
      paramikk[k] = ((byte)(1 << 7 - j % 8 | paramikk[k]));
      i += 1;
    }
    paramikt.a(paramikk);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(ijz.a(a));
    localStringBuffer.append(" ");
    localStringBuffer.append(b);
    int i = 0;
    while (i < c.length)
    {
      int j = c[i];
      localStringBuffer.append(12 + " " + j);
      i += 1;
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     iof
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */