import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

final class inz
  implements Serializable
{
  private static final long serialVersionUID = -125354057735389003L;
  TreeSet a = new TreeSet();
  
  private inz() {}
  
  public inz(ikr paramikr)
  {
    this();
    while (paramikr.a() > 0)
    {
      if (paramikr.a() < 2) {
        throw new iog("invalid bitmap descriptor");
      }
      int k = paramikr.b();
      if (k < -1) {
        throw new iog("invalid ordering");
      }
      int m = paramikr.b();
      if (m > paramikr.a()) {
        throw new iog("invalid bitmap");
      }
      int i = 0;
      while (i < m)
      {
        int n = paramikr.b();
        if (n != 0)
        {
          int j = 0;
          while (j < 8)
          {
            if ((1 << 7 - j & n) != 0) {
              a.add(ily.b(k * 256 + i * 8 + j));
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  private static void a(ikt paramikt, TreeSet paramTreeSet, int paramInt)
  {
    int i = (((Integer)paramTreeSet.last()).intValue() & 0xFF) / 8 + 1;
    int[] arrayOfInt = new int[i];
    paramikt.a(paramInt);
    paramikt.a(i);
    paramTreeSet = paramTreeSet.iterator();
    while (paramTreeSet.hasNext())
    {
      paramInt = ((Integer)paramTreeSet.next()).intValue();
      int j = (paramInt & 0xFF) / 8;
      arrayOfInt[j] = (1 << 7 - paramInt % 8 | arrayOfInt[j]);
    }
    paramInt = 0;
    while (paramInt < i)
    {
      paramikt.a(arrayOfInt[paramInt]);
      paramInt += 1;
    }
  }
  
  public final void a(ikt paramikt)
  {
    if (a.size() == 0) {
      return;
    }
    TreeSet localTreeSet = new TreeSet();
    Iterator localIterator = a.iterator();
    int i = -1;
    int m;
    int k;
    if (localIterator.hasNext())
    {
      m = ((Integer)localIterator.next()).intValue();
      k = m >> 8;
      if (k == i) {
        break label123;
      }
      j = k;
      if (localTreeSet.size() > 0)
      {
        a(paramikt, localTreeSet, i);
        localTreeSet.clear();
      }
    }
    label123:
    for (int j = k;; j = i)
    {
      localTreeSet.add(new Integer(m));
      i = j;
      break;
      a(paramikt, localTreeSet, i);
      return;
    }
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      localStringBuffer.append(inx.a.c(i));
      if (localIterator.hasNext()) {
        localStringBuffer.append(' ');
      }
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     inz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */