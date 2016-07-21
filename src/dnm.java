import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.format.DateUtils;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class dnm
  extends cfg
{
  private static final Map<String, dnm> a = new HashMap();
  
  private dnm(Context paramContext, String paramString)
  {
    super(paramContext, deg.a(paramContext).a(paramString));
  }
  
  public static dnm a(Context paramContext, String paramString)
  {
    try
    {
      String str = deg.a(paramContext).a(paramString);
      dnm localdnm = (dnm)a.get(str);
      paramString = localdnm;
      if (localdnm == null)
      {
        paramString = new dnm(paramContext, str);
        a.put(str, paramString);
      }
      return paramString;
    }
    finally {}
  }
  
  public final void a(String paramString1, int paramInt, long paramLong, String paramString2, boolean paramBoolean, String paramString3)
  {
    SharedPreferences.Editor localEditor = d.edit();
    localEditor.putString("g6y-address", paramString1);
    localEditor.putInt("g6y-syncStatus", paramInt);
    localEditor.putLong("g6y-lastSyncTimeMs", paramLong);
    localEditor.putString("g6y-errorUrl", paramString2);
    localEditor.putBoolean("g6y-errorUrlOpenAuthenticated", paramBoolean);
    localEditor.putString("g6y-errorUrl-whitelist", paramString3);
    localEditor.apply();
    if (cvm.a(f, 3)) {
      cvm.b(f, "g6y: Save sync status=%1$d email=%2$s lastSync=%3$tF %3$tT errorUrl=%4$s", new Object[] { Integer.valueOf(paramInt), cvm.a(paramString1), new Date(paramLong), paramString2 });
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    e.putBoolean("g6y-welcome-teaser-enabled", paramBoolean).apply();
  }
  
  public final void d(String paramString)
  {
    a(paramString, 0, 0L, "", false, "");
  }
  
  public final String e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return b.getString(dge.cJ);
    case 0: 
      return b.getString(dge.cK);
    case 1: 
      return DateUtils.formatDateTime(b, d.getLong("g6y-lastSyncTimeMs", 0L), 262165);
    case 2: 
      return b.getString(dge.cL, new Object[] { cui.b(g()) });
    }
    return b.getString(dge.cI);
  }
  
  public final void e()
  {
    e.remove("hats-survey-start-timestamp").remove("hats-survey-additional-params").apply();
    dmv.a().b(b, null, "hats-survey-last-shown-timestamp", Calendar.getInstance().getTimeInMillis());
  }
  
  public final void f()
  {
    SharedPreferences.Editor localEditor = d.edit();
    localEditor.remove("g6y-address");
    localEditor.remove("g6y-syncStatus");
    localEditor.remove("g6y-lastSyncTimeMs");
    localEditor.remove("g6y-errorUrl");
    localEditor.remove("g6y-errorUrlOpenAuthenticated");
    localEditor.remove("g6y-errorUrl-whitelist");
    localEditor.apply();
  }
  
  public final String g()
  {
    return d.getString("g6y-address", "");
  }
}

/* Location:
 * Qualified Name:     dnm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */