import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Map;

public class ayg
  extends cfg
{
  private static final Map<String, ayg> a = new HashMap();
  
  public ayg(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public static ayg a(Context paramContext, String paramString)
  {
    try
    {
      ayg localayg2 = (ayg)a.get(paramString);
      ayg localayg1 = localayg2;
      if (localayg2 == null)
      {
        localayg1 = new ayg(paramContext, paramString);
        a.put(paramString, localayg1);
      }
      return localayg1;
    }
    finally {}
  }
  
  public final void h_()
  {
    e.putLong("eas-oof-settings-next-sync-time", System.currentTimeMillis() + 259200000L).apply();
  }
}

/* Location:
 * Qualified Name:     ayg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */