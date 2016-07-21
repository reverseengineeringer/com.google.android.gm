import java.util.Iterator;
import java.util.List;

public final class ijm
  implements iix
{
  static final hel<String, ijo> c = ijpa.b();
  int a = Integer.MAX_VALUE;
  final List<ijo> b = hgd.a();
  private final iix d;
  
  public ijm(iix paramiix)
  {
    d = paramiix;
  }
  
  private final void a(ijo paramijo)
  {
    int i = b.size();
    Object localObject1;
    Object localObject2;
    if (i != 0)
    {
      localObject1 = (ijo)b.get(i - 1);
      if ((d & c) != 0) {
        break label246;
      }
      localObject2 = f;
      if ((localObject2 == null) || ((d & c) == 0)) {
        break label246;
      }
      d.a(a, hgd.a());
      b.add(localObject2);
      i += 1;
      localObject1 = localObject2;
    }
    label246:
    for (;;)
    {
      localObject2 = null;
      Object localObject3 = localObject1;
      for (localObject1 = localObject2; (d & c) == 0; localObject1 = localObject2)
      {
        if (b.size() < a) {
          d.b(a);
        }
        localObject2 = b;
        i -= 1;
        ((List)localObject2).remove(i);
        localObject2 = localObject1;
        if (b)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = hgd.a();
          }
          ((List)localObject2).add(localObject3);
        }
        localObject1 = localObject2;
        if (i == 0) {
          break;
        }
        localObject3 = (ijo)b.get(i - 1);
      }
      if (localObject1 != null) {
        a((List)localObject1);
      }
      return;
    }
  }
  
  private final void a(List<ijo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ijo localijo = (ijo)paramList.next();
      if (b.size() < a) {
        d.a(a, hgd.a());
      }
      b.add(localijo);
    }
  }
  
  private static boolean c(String paramString)
  {
    return (paramString.length() == 2) && (paramString.charAt(0) == 'h') && (paramString.charAt(1) <= '9');
  }
  
  public final void a()
  {
    d.a();
  }
  
  public final void a(String paramString)
  {
    int k = 0;
    int m = paramString.length();
    int i = 0;
    if (i < m)
    {
      int n = paramString.charAt(i);
      j = k;
      if (n <= 32) {
        if ((0x100003600 & 1L << n) != 0L) {
          break label88;
        }
      }
    }
    for (int j = k;; j = 1)
    {
      if (j == 0) {
        a(ijp.b);
      }
      if (b.size() < a) {
        d.a(paramString);
      }
      return;
      label88:
      i += 1;
      break;
    }
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    Object localObject = iim.a(paramString);
    localObject = (ijo)c.get(localObject);
    if (localObject == null) {
      if (b.size() < a) {
        d.a(paramString, paramList);
      }
    }
    do
    {
      return;
      a((ijo)localObject);
      if (b.size() < a) {
        d.a(a, paramList);
      }
    } while (e);
    b.add(localObject);
  }
  
  public final void b()
  {
    int i = Math.min(a, b.size());
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      d.b(b.get(i)).a);
    }
    b.clear();
    d.b();
  }
  
  public final void b(String paramString)
  {
    Object localObject1 = iim.a(paramString);
    Object localObject2 = (ijo)c.get(localObject1);
    if (localObject2 == null) {
      if (b.size() < a) {
        d.b(paramString);
      }
    }
    label180:
    label334:
    for (;;)
    {
      return;
      int k = b.lastIndexOf(localObject2);
      int i;
      int j;
      if (c((String)localObject1))
      {
        i = b.size();
        do
        {
          j = i - 1;
          if (j < k + 1) {
            break;
          }
          paramString = (ijo)b.get(j);
          i = j;
        } while (!c(a));
        i = j;
        localObject2 = paramString;
      }
      for (;;)
      {
        if (i < 0) {
          break label334;
        }
        k = g;
        j = b.size();
        for (;;)
        {
          j -= 1;
          if (j <= i) {
            break label180;
          }
          if ((b.get(j)).h & k) != 0) {
            break;
          }
        }
        j = b.size();
        for (paramString = null;; paramString = (String)localObject1)
        {
          j -= 1;
          if (j <= i) {
            break;
          }
          ijo localijo = (ijo)b.remove(j);
          if (j + 1 < a) {
            d.b(a);
          }
          localObject1 = paramString;
          if (b)
          {
            localObject1 = paramString;
            if (paramString == null) {
              localObject1 = hgd.a();
            }
            ((List)localObject1).add(localijo);
          }
        }
        if (b.size() < a) {
          d.b(a);
        }
        b.remove(i);
        if (paramString == null) {
          break;
        }
        a(paramString);
        return;
        i = k;
      }
    }
  }
}

/* Location:
 * Qualified Name:     ijm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */