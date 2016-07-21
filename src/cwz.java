import android.os.SystemClock;
import java.util.ArrayList;

public final class cwz
{
  private static final String d = cvl.a;
  public ArrayList<Long> a;
  public ArrayList<String> b;
  ArrayList<String> c;
  private String e;
  
  public cwz(String paramString)
  {
    e = paramString;
    if (a == null)
    {
      a = new ArrayList();
      b = new ArrayList();
      c = new ArrayList();
    }
    for (;;)
    {
      a(null, null);
      return;
      a.clear();
      b.clear();
      c.clear();
    }
  }
  
  public final void a()
  {
    cvm.b(d, "%s: begin", new Object[] { e });
    long l2 = ((Long)a.get(0)).longValue();
    int i = 1;
    long l1 = l2;
    if (i < a.size())
    {
      long l3 = ((Long)a.get(i)).longValue();
      String str1 = (String)c.get(i);
      String str2 = (String)b.get(i);
      if (str1 == null) {
        cvm.b(d, "%s :    %d ms %s", new Object[] { e, Long.valueOf(l3 - l1), str2 });
      }
      for (;;)
      {
        i += 1;
        l1 = l3;
        break;
        cvm.b(d, "%s (%s):    %d ms %s", new Object[] { e, str1, Long.valueOf(l3 - l1), str2 });
      }
    }
    cvm.b(d, "%s : end %d ms ", new Object[] { e, Long.valueOf(l1 - l2) });
  }
  
  public final void a(String paramString1, String paramString2)
  {
    long l = SystemClock.elapsedRealtime();
    a.add(Long.valueOf(l));
    b.add(paramString1);
    c.add(paramString2);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long l1 = ((Long)a.get(0)).longValue();
    int i = 1;
    while (i < a.size())
    {
      if (i > 1) {
        localStringBuilder.append(", ");
      }
      long l2 = ((Long)a.get(i)).longValue();
      String str1 = (String)b.get(i);
      String str2 = (String)c.get(i);
      localStringBuilder.append(str1);
      if (str2 != null) {
        localStringBuilder.append(" (").append(str2).append(")");
      }
      localStringBuilder.append(": ").append(l2 - l1);
      i += 1;
      l1 = l2;
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     cwz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */