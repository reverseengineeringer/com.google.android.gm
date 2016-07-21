import java.util.ArrayList;

public final class ayc
{
  public final StringBuilder a = new StringBuilder(100);
  private final int b = 64;
  private String[] c;
  private int d;
  
  public ayc()
  {
    c();
  }
  
  private final void c()
  {
    c = new String[b];
  }
  
  private final String[] d()
  {
    a();
    ArrayList localArrayList = new ArrayList();
    int k = d;
    int i = d;
    int j;
    do
    {
      localObject = c[i];
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      j = (i + 1) % b;
      i = j;
    } while (j != k);
    Object localObject = new String[localArrayList.size()];
    localArrayList.toArray((Object[])localObject);
    return (String[])localObject;
  }
  
  public final void a()
  {
    if (a.length() > 0)
    {
      a(a.toString());
      a.delete(0, Integer.MAX_VALUE);
    }
  }
  
  public final void a(String paramString)
  {
    c[d] = paramString;
    d += 1;
    if (d >= b) {
      d = 0;
    }
  }
  
  public final void b()
  {
    if (d().length == 0) {
      return;
    }
    cvm.d(bbw.a, "Last network activities:", new Object[0]);
    String[] arrayOfString = d();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      cvm.d(bbw.a, "%s", new Object[] { str });
      i += 1;
    }
    c();
  }
}

/* Location:
 * Qualified Name:     ayc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */