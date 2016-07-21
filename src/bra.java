import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class bra
{
  public SharedPreferences a;
  
  public bra(Context paramContext, long paramLong)
  {
    a = paramContext.getSharedPreferences(String.format("EasOptionsPrefs-%d", new Object[] { Long.valueOf(paramLong) }), 0);
  }
  
  public final boolean a()
  {
    return a.getBoolean("IsOptionsNeeded", true);
  }
  
  public final boolean b()
  {
    return a.getBoolean("IsEventTimezoneRefreshNeeded", true);
  }
  
  public final void c()
  {
    a.edit().putBoolean("IsEventTimezoneRefreshNeeded", false).apply();
  }
}

/* Location:
 * Qualified Name:     bra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */