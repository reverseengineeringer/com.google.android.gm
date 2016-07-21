import java.util.ArrayList;
import java.util.Iterator;

public final class crj
{
  private static final String[] c = { "Unknown", "Conversation", "Conversation list", "Search results list", "Search results conversation", "Waiting for sync", "Ad", "Warm welcome" };
  public int a = 0;
  private final ArrayList<crk> b = new ArrayList();
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 3);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 4);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4);
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == 5;
  }
  
  public static boolean e(int paramInt)
  {
    return paramInt == 6;
  }
  
  private final void g(int paramInt)
  {
    Iterator localIterator = new ArrayList(b).iterator();
    while (localIterator.hasNext()) {
      ((crk)localIterator.next()).a(paramInt, a);
    }
  }
  
  public final String a()
  {
    return c[a];
  }
  
  public final void a(crk paramcrk)
  {
    b.add(paramcrk);
  }
  
  public final void b(crk paramcrk)
  {
    b.remove(paramcrk);
  }
  
  public final boolean f(int paramInt)
  {
    if (a == paramInt)
    {
      if (cvm.a("ViewMode", 3))
      {
        cvm.b("ViewMode", new Error(), "ViewMode: debouncing change attempt mode=%s", new Object[] { Integer.valueOf(paramInt) });
        return false;
      }
      cvm.c("ViewMode", "ViewMode: debouncing change attempt mode=%s", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    but localbut;
    if (cvm.a("ViewMode", 3))
    {
      cvm.b("ViewMode", new Error(), "ViewMode: executing change old=%s new=%s", new Object[] { Integer.valueOf(a), Integer.valueOf(paramInt) });
      int i = a;
      a = paramInt;
      g(i);
      localbut = buo.a();
      str = String.valueOf(toString());
      if (str.length() == 0) {
        break label195;
      }
    }
    label195:
    for (String str = "ViewMode".concat(str);; str = new String("ViewMode"))
    {
      localbut.a(str);
      return true;
      cvm.c("ViewMode", "ViewMode: executing change old=%s new=%s", new Object[] { Integer.valueOf(a), Integer.valueOf(paramInt) });
      break;
    }
  }
  
  public final String toString()
  {
    String str = String.valueOf(c[a]);
    return String.valueOf(str).length() + 7 + "[mode=" + str + "]";
  }
}

/* Location:
 * Qualified Name:     crj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */