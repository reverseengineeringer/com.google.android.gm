import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class dqu
  extends cgu
{
  private static boolean z = false;
  private final boolean A;
  final boolean a;
  final boolean b;
  final dtd c;
  List<duv> d = new ArrayList();
  int e;
  int f;
  boolean g;
  
  public dqu(Context paramContext, String paramString, dtd paramdtd, boolean paramBoolean)
  {
    super(paramContext, paramString);
    c = paramdtd;
    A = paramBoolean;
    if ((!z) && (!buo.b())) {}
    label119:
    label182:
    label188:
    label208:
    for (;;)
    {
      paramContext = this;
      paramBoolean = false;
      b = paramBoolean;
      if (!ghz.a(l.getContentResolver(), "gmail_bypass_android_proxy", cuu.a.booleanValue())) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        a = paramBoolean;
        return;
        int j = k();
        int k = d(j).intValue();
        int i;
        if (d(j).intValue() > 1)
        {
          i = 1;
          if (i == 0) {
            break label188;
          }
          dri.a(h, "Sync metrics sample rate for user type %d: 1/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
          if (dza.a.nextInt(k) != 0) {
            break label182;
          }
        }
        for (paramBoolean = true;; paramBoolean = false)
        {
          b = paramBoolean;
          break;
          i = 0;
          break label119;
        }
        if (k != 1) {
          break label208;
        }
        paramBoolean = true;
        paramContext = this;
        break;
      }
    }
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "sync_config_suggestion";
    case 1: 
      return "sync_config";
    case 2: 
      return "start_sync";
    case 3: 
      return "main_sync";
    case 4: 
      return "conversation_sync";
    case 5: 
      return "uphill_sync";
    case 6: 
      return "query";
    }
    return "ad";
  }
  
  private final Integer d(int paramInt)
  {
    if (paramInt == 0) {}
    for (paramInt = ghz.a(l.getContentResolver(), "snapshot_sample_rate_divisor_googler", 1);; paramInt = ghz.a(l.getContentResolver(), "snapshot_sample_rate_divisor", 200)) {
      return Integer.valueOf(paramInt);
    }
  }
  
  private final int e(int paramInt)
  {
    Iterator localIterator = d.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (nexta != paramInt) {
        break label46;
      }
      i += 1;
    }
    label46:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  protected final boolean a()
  {
    return !d.isEmpty();
  }
  
  protected final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.b()).append(", httpTime: ").append(p).append(", requests: ").append(d).append(", requestCount: ").append(d.size()).append(", messageCount: ").append(e).append(", conversationCount: ").append(f).append(", uploadOnly: ");
    if (A) {}
    for (String str = "yes";; str = "no") {
      return str + ", syncInfo: " + c.toString() + ", isUsingProxy: " + String.valueOf(a);
    }
  }
  
  protected final cfg c()
  {
    return dnm.a(l, m);
  }
  
  public final void c(int paramInt)
  {
    e += paramInt;
  }
  
  public final int[] g()
  {
    int[] arrayOfInt = new int[d.size()];
    int i = 0;
    while (i < d.size())
    {
      arrayOfInt[i] = d.get(i)).a;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public final int h()
  {
    return d.size();
  }
  
  public final int i()
  {
    return e(2);
  }
  
  public final int j()
  {
    return e(3);
  }
  
  public final int k()
  {
    if ((ddh.a(m) & 0x30000000) == 805306368) {}
    for (int i = 1; i != 0; i = 0) {
      return 0;
    }
    if (ddh.b(m)) {
      return 1;
    }
    return 2;
  }
}

/* Location:
 * Qualified Name:     dqu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */