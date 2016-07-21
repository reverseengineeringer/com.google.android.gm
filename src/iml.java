import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class iml
  extends imw
{
  private static final long serialVersionUID = -6254521894809367938L;
  private List a;
  
  final imw a()
  {
    return new iml();
  }
  
  final void a(ikr paramikr)
  {
    if (paramikr.a() > 0) {
      a = new ArrayList();
    }
    while (paramikr.a() > 0)
    {
      int i = paramikr.c();
      int j = paramikr.c();
      if (paramikr.a() < j) {
        throw new iog("truncated option");
      }
      int k = c;
      paramikr.a(j);
      Object localObject;
      switch (i)
      {
      default: 
        localObject = new ild(i);
      }
      for (;;)
      {
        ((ikv)localObject).a(paramikr);
        if (k <= a.length) {
          break;
        }
        throw new IllegalArgumentException("cannot set active region past end of input");
        localObject = new imf();
        continue;
        localObject = new iki();
        continue;
        localObject = new ikj();
      }
      c = k;
      a.add(localObject);
    }
  }
  
  final void a(ikt paramikt, ikk paramikk, boolean paramBoolean)
  {
    if (a == null) {}
    for (;;)
    {
      return;
      paramikk = a.iterator();
      while (paramikk.hasNext())
      {
        ikv localikv = (ikv)paramikk.next();
        paramikt.b(e);
        int i = a;
        paramikt.b(0);
        localikv.a(paramikt);
        paramikt.a(a - i - 2, i);
      }
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (a != null)
    {
      localStringBuffer.append(a);
      localStringBuffer.append(" ");
    }
    localStringBuffer.append(" ; payload ");
    localStringBuffer.append(i);
    localStringBuffer.append(", xrcode ");
    localStringBuffer.append(d());
    localStringBuffer.append(", version ");
    localStringBuffer.append((int)(j >>> 16 & 0xFF));
    localStringBuffer.append(", flags ");
    localStringBuffer.append((int)(j & 0xFFFF));
    return localStringBuffer.toString();
  }
  
  public final int d()
  {
    return (int)(j >>> 24);
  }
  
  public final boolean equals(Object paramObject)
  {
    return (super.equals(paramObject)) && (j == j);
  }
}

/* Location:
 * Qualified Name:     iml
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */