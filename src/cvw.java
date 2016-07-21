import com.android.mail.providers.Folder;
import java.util.Map;

public enum cvw
{
  public static final Map<String, cvw> g;
  public final String e;
  public final boolean f;
  private final int h;
  private final int i;
  private final int j;
  private final int k;
  private final cvy l;
  
  static
  {
    cvw[] arrayOfcvw = values();
    hen localhen = new hen();
    int i1 = arrayOfcvw.length;
    int n = 0;
    while (n < i1)
    {
      cvw localcvw = arrayOfcvw[n];
      localhen.b(e, localcvw);
      n += 1;
    }
    g = localhen.b();
  }
  
  private cvw(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    e = paramString;
    f = paramBoolean;
    h = paramInt1;
    i = -1;
    j = paramInt2;
    k = -1;
    l = null;
  }
  
  private cvw(int paramInt1, int paramInt2)
  {
    e = ???;
    f = true;
    h = paramInt1;
    i = paramInt2;
    int n;
    j = n;
    int i1;
    k = i1;
    cvy localcvy;
    l = localcvy;
  }
  
  public final int a(Folder paramFolder)
  {
    if ((l == null) || (l.a(paramFolder))) {
      return h;
    }
    return i;
  }
  
  public final int b(Folder paramFolder)
  {
    if ((l == null) || (l.a(paramFolder))) {
      return j;
    }
    return k;
  }
}

/* Location:
 * Qualified Name:     cvw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */