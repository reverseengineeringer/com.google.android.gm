import java.util.BitSet;

public final class imi
  extends imw
{
  private static final long serialVersionUID = -8851454400765507520L;
  private imj a;
  private BitSet b;
  
  final imw a()
  {
    return new imi();
  }
  
  final void a(ikr paramikr)
  {
    a = new imj(paramikr);
    b = new BitSet();
    int k = paramikr.a();
    int i = 0;
    while (i < k)
    {
      int m = paramikr.b();
      int j = 0;
      while (j < 8)
      {
        if ((1 << 7 - j & m) != 0) {
          b.set(i * 8 + j);
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    a.a(paramikt, null, paramBoolean);
    int m = b.length();
    int i = 0;
    int j = 0;
    if (j < m)
    {
      if (b.get(j)) {}
      for (int k = 1 << 7 - j % 8;; k = 0)
      {
        k |= i;
        if (j % 8 != 7)
        {
          i = k;
          if (j != m - 1) {}
        }
        else
        {
          paramikt.a(k);
          i = 0;
        }
        j += 1;
        break;
      }
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a);
    int j = b.length();
    for (int i = 0; i < j; i = (short)(i + 1)) {
      if (b.get(i))
      {
        localStringBuffer.append(" ");
        localStringBuffer.append(inx.a.c(i));
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     imi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */