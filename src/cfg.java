import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.android.mail.providers.Account;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class cfg
  extends cfr
{
  private static final Map<String, cfg> a = new HashMap();
  
  public cfg(Context paramContext, String paramString) {}
  
  public static cfg a(Context paramContext, Account paramAccount)
  {
    try
    {
      paramContext = b(paramContext, paramAccount.h());
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static cfg b(Context paramContext, String paramString)
  {
    try
    {
      cfg localcfg2 = (cfg)a.get(paramString);
      cfg localcfg1 = localcfg2;
      if (localcfg2 == null)
      {
        localcfg1 = new cfg(paramContext, paramString);
        a.put(paramString, localcfg1);
      }
      return localcfg1;
    }
    finally {}
  }
  
  protected final void a(int paramInt)
  {
    if (paramInt > 4) {
      throw new IllegalStateException("You appear to have downgraded your app. Please clear app data.");
    }
  }
  
  public final void a(long paramLong)
  {
    d.edit().putLong("calendar-promotion-time", paramLong).commit();
  }
  
  public final void a(boolean paramBoolean)
  {
    e.putBoolean("notifications-enabled", paramBoolean).apply();
    Context localContext = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(localContext.getPackageName());
    localContext.startService(localIntent);
  }
  
  protected final boolean a(String paramString)
  {
    return cfh.a.contains(paramString);
  }
  
  public final Map<String, String> b(String paramString)
  {
    Object localObject = d.getStringSet(paramString, null);
    if (localObject == null) {
      return hid.b;
    }
    paramString = new hen();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      int i = str1.indexOf('=');
      if (i == -1)
      {
        cvm.e(f, "Separator not found in key-value pair: %s", new Object[] { str1 });
      }
      else
      {
        String str2 = str1.substring(0, i);
        String str3 = str1.substring(i + 1);
        try
        {
          paramString.b(URLDecoder.decode(str2, "utf-8"), URLDecoder.decode(str3, "utf-8"));
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          cvm.e(f, localUnsupportedEncodingException, "Error decoding key-value pair: %s", new Object[] { str1 });
        }
      }
    }
    return paramString.b();
  }
  
  public final void b(int paramInt)
  {
    e.putInt("last-seen-outbox-count", paramInt).apply();
  }
  
  public final boolean b()
  {
    return d.getBoolean("notifications-enabled", true);
  }
  
  public final void c()
  {
    if (d.getInt("num-of-dismisses-account-sync-off", 0) != 0) {
      e.putInt("num-of-dismisses-account-sync-off", 0).apply();
    }
  }
  
  public final void c(int paramInt)
  {
    e.putInt("account-inbox-size", paramInt).apply();
  }
  
  public final void c(String paramString)
  {
    int i = 0;
    int j = d.getInt("account-sync-snapshot-index", 0);
    if (j >= 5) {}
    for (;;)
    {
      String str = String.valueOf("account-sync-snapshot");
      str = String.valueOf(str).length() + 11 + str + i;
      e.putString(str, paramString).putInt("account-sync-snapshot-index", i + 1).apply();
      return;
      i = j;
    }
  }
  
  public final List<String> d()
  {
    ArrayList localArrayList = new ArrayList();
    SharedPreferences localSharedPreferences = d;
    int i = 0;
    while (i < 3)
    {
      String str = String.valueOf("account-sync-error");
      str = localSharedPreferences.getString(String.valueOf(str).length() + 11 + str + i, null);
      if (str != null) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public final void d(int paramInt)
  {
    d.edit().putInt("calendar-promotion-count", paramInt).commit();
  }
}

/* Location:
 * Qualified Name:     cfg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */