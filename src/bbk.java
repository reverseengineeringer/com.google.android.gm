import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class bbk
  extends cgu
{
  public boolean a;
  public boolean b;
  public boolean c;
  public Map<Long, bbl> d = new HashMap();
  public List<cwz> e = new ArrayList();
  public int f;
  public int g;
  
  public bbk(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public final void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3, bdk parambdk, String paramString)
  {
    if (d.containsKey(Long.valueOf(paramLong))) {
      cvm.d(h, "Duplicate mailbox sync id found", new Object[0]);
    }
    d.put(Long.valueOf(paramLong), new bbl(paramLong, paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramInt3, parambdk, paramString));
    r += c;
    q += b;
    f += d;
    g += e;
  }
  
  protected final boolean a()
  {
    return d.size() > 0;
  }
  
  protected final String b()
  {
    return String.format("%s, isUpdate %b, uiRefresh %b, mailboxSyncs: %s", new Object[] { super.b(), Boolean.valueOf(a), Boolean.valueOf(b), d });
  }
  
  protected final cfg c()
  {
    return cfg.b(l, m);
  }
}

/* Location:
 * Qualified Name:     bbk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */