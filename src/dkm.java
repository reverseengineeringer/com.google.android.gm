import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class dkm
  extends ayg
{
  public dkm(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    cvm.a(f, "g6y: Availability=%b", new Object[] { Boolean.valueOf(paramBoolean1) });
    e.putBoolean(b.getString(dge.cz), paramBoolean1).apply();
    e.putBoolean(b.getString(dge.cy), paramBoolean2).apply();
  }
  
  public final int e()
  {
    String str = b.getString(dge.cz);
    if (!d.contains(str)) {
      return 0;
    }
    if (d.getBoolean(str, false)) {
      return 1;
    }
    return 2;
  }
  
  public final int f()
  {
    int i = e();
    if (i != 1) {
      return i;
    }
    String str = b.getString(dge.cy);
    if (d.getBoolean(str, false)) {
      return 1;
    }
    return 2;
  }
  
  public final long g()
  {
    if (dkn.a())
    {
      String str = b.getString(dge.cB);
      return d.getLong(str, chq.a());
    }
    return 0L;
  }
  
  public final void h()
  {
    e.putBoolean(b.getString(dge.cA), true).apply();
  }
}

/* Location:
 * Qualified Name:     dkm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */