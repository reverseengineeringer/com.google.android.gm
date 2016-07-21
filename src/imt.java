import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class imt
  implements Serializable
{
  private static final long serialVersionUID = -3270249290171239695L;
  private List a;
  private short b;
  private short c;
  
  public imt()
  {
    a = new ArrayList(1);
    b = 0;
    c = 0;
  }
  
  public imt(imt paramimt)
  {
    try
    {
      a = ((List)((ArrayList)a).clone());
      b = b;
      c = c;
      return;
    }
    finally {}
  }
  
  public imt(imw paramimw)
  {
    this();
    b(paramimw);
  }
  
  private static String a(Iterator paramIterator)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    while (paramIterator.hasNext())
    {
      imw localimw = (imw)paramIterator.next();
      localStringBuffer.append("[");
      localStringBuffer.append(localimw.b());
      localStringBuffer.append("]");
      if (paramIterator.hasNext()) {
        localStringBuffer.append(" ");
      }
    }
    return localStringBuffer.toString();
  }
  
  private final Iterator a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    for (;;)
    {
      int k;
      try
      {
        k = a.size();
        int j;
        Object localObject1;
        if (paramBoolean1)
        {
          j = k - b;
          if (j == 0)
          {
            localObject1 = Collections.EMPTY_LIST.iterator();
            return (Iterator)localObject1;
          }
        }
        else
        {
          j = b;
          continue;
          localObject1 = new ArrayList(j);
          if (paramBoolean1)
          {
            ((List)localObject1).addAll(a.subList(i, j));
            if (i != 0) {
              ((List)localObject1).addAll(a.subList(0, i));
            }
            label115:
            localObject1 = ((List)localObject1).iterator();
            continue;
            if (c >= j) {
              c = 0;
            }
            i = c;
            c = ((short)(i + 1));
            continue;
            i = k - b;
          }
        }
      }
      finally {}
      do
      {
        break;
        ((List)localObject2).addAll(a.subList(i, k));
        break label115;
      } while (!paramBoolean1);
      if (paramBoolean2) {}
    }
  }
  
  private final void b(imw paramimw)
  {
    if (!(paramimw instanceof ims))
    {
      if (b == 0)
      {
        a.add(paramimw);
        return;
      }
      a.add(a.size() - b, paramimw);
      return;
    }
    a.add(paramimw);
    b = ((short)(b + 1));
  }
  
  public final void a(imw paramimw)
  {
    int i;
    label93:
    imw localimw1;
    for (;;)
    {
      imw localimw2;
      try
      {
        if (a.size() == 0)
        {
          b(paramimw);
          return;
        }
        localimw2 = e();
        if ((paramimw.e() == localimw2.e()) && (i == i) && (g.equals(g)))
        {
          i = 1;
          if (i != 0) {
            break label93;
          }
          throw new IllegalArgumentException("record does not match rrset");
        }
      }
      finally {}
      i = 0;
      continue;
      localimw1 = paramimw;
      if (j != j)
      {
        if (j <= j) {
          break;
        }
        localimw1 = paramimw.f();
        j = j;
      }
      if (!a.contains(localimw1)) {
        b(localimw1);
      }
    }
    for (;;)
    {
      localimw1 = paramimw;
      if (i >= a.size()) {
        break;
      }
      localimw1 = ((imw)a.get(i)).f();
      j = j;
      a.set(i, localimw1);
      i += 1;
      continue;
      i = 0;
    }
  }
  
  public final int b()
  {
    return e().e();
  }
  
  public final Iterator c()
  {
    try
    {
      Iterator localIterator = a(true, true);
      return localIterator;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long d()
  {
    try
    {
      long l = ej;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final imw e()
  {
    try
    {
      if (a.size() == 0) {
        throw new IllegalStateException("rrset is empty");
      }
    }
    finally {}
    imw localimw = (imw)a.get(0);
    return localimw;
  }
  
  public String toString()
  {
    if (a.size() == 0) {
      return "{empty}";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{ ");
    String str = String.valueOf(eg);
    localStringBuffer.append(String.valueOf(str).length() + 1 + str + " ");
    long l = d();
    localStringBuffer.append(21 + l + " ");
    int i = ei;
    localStringBuffer.append(String.valueOf(ikm.a.c(i)).concat(" "));
    i = e().e();
    localStringBuffer.append(String.valueOf(inx.a.c(i)).concat(" "));
    localStringBuffer.append(a(a(true, false)));
    if (b > 0)
    {
      localStringBuffer.append(" sigs: ");
      localStringBuffer.append(a(a(false, false)));
    }
    localStringBuffer.append(" }");
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     imt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */