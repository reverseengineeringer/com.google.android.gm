import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class cfm
  extends cfr
{
  private static cfm a;
  private static final Set<String> g;
  
  static
  {
    HashSet localHashSet = new HashSet();
    g = localHashSet;
    localHashSet.add("enableAllInboxes");
    g.add("enableWebViewCompose");
    g.add("enableAccountSetupLogoLanding");
  }
  
  private cfm(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public static cfm a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new cfm(paramContext, "UnifiedEmail");
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public static void a(Context paramContext, SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    paramContext.getSharedPreferences("UnifiedEmail", 0).registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public static void b(Context paramContext, SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    paramContext.getSharedPreferences("UnifiedEmail", 0).unregisterOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  private final Set<String> o()
  {
    return d.getStringSet("display_images", Collections.emptySet());
  }
  
  public final String a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return "delete";
    }
    SharedPreferences localSharedPreferences = d;
    if (TextUtils.equals(localSharedPreferences.getString("removal-action", null), "archive-and-delete")) {
      return "archive";
    }
    return localSharedPreferences.getString("removal-action", "archive");
  }
  
  protected final void a(int paramInt)
  {
    if (paramInt > 4) {
      throw new IllegalStateException("You appear to have downgraded your app. Please clear app data.");
    }
    if (paramInt == 4) {}
  }
  
  public final void a(String paramString, List<Pattern> paramList)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return;
        if (paramList == null) {
          break;
        }
        Iterator localIterator = paramList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramList = (Pattern)localIterator.next();
        } while (!paramList.matcher(paramString).matches());
        paramString = d.getStringSet("display_sender_images_patterns_set", Collections.emptySet());
        paramList = paramList.pattern();
      } while (paramString.contains(paramList));
      paramString = new HashSet(paramString);
      paramString.add(paramList);
      b(paramString);
      return;
      paramList = o();
    } while (paramList.contains(paramString));
    paramList = new HashSet(paramList);
    paramList.add(paramString);
    a(paramList);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    e.putBoolean(paramString, paramBoolean).apply();
  }
  
  public final void a(Set<String> paramSet)
  {
    e.putStringSet("display_images", paramSet).apply();
    paramSet = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(paramSet.getPackageName());
    paramSet.startService(localIntent);
  }
  
  protected final boolean a(String paramString)
  {
    return cfn.a.contains(paramString);
  }
  
  public final int b(boolean paramBoolean)
  {
    boolean bool = d();
    int i;
    if (!"delete".equals(a(paramBoolean))) {
      i = 1;
    }
    while (bool) {
      if (i != 0)
      {
        return 0;
        i = 0;
      }
      else
      {
        return 1;
      }
    }
    return 2;
  }
  
  public final void b(String paramString)
  {
    e.putString("removal-action", paramString).apply();
    paramString = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(paramString.getPackageName());
    paramString.startService(localIntent);
  }
  
  public final void b(Set<String> paramSet)
  {
    e.putStringSet("display_sender_images_patterns_set", paramSet).apply();
    paramSet = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(paramSet.getPackageName());
    paramSet.startService(localIntent);
  }
  
  public final boolean b(int paramInt)
  {
    SharedPreferences localSharedPreferences = d;
    String str = String.valueOf("widget-account-");
    return localSharedPreferences.contains(String.valueOf(str).length() + 11 + str + paramInt);
  }
  
  public final String c(int paramInt)
  {
    SharedPreferences localSharedPreferences = d;
    String str = String.valueOf("widget-account-");
    return localSharedPreferences.getString(String.valueOf(str).length() + 11 + str + paramInt, null);
  }
  
  public final void c(boolean paramBoolean)
  {
    e.putBoolean("mail-enable-threading", paramBoolean).apply();
  }
  
  public final boolean c()
  {
    return d.getBoolean("default-reply-all", false);
  }
  
  public final boolean c(String paramString)
  {
    boolean bool2 = o().contains(paramString);
    boolean bool1 = bool2;
    if (!bool2)
    {
      Iterator localIterator = d.getStringSet("display_sender_images_patterns_set", Collections.emptySet()).iterator();
      bool1 = bool2;
      while (localIterator.hasNext())
      {
        bool2 = Pattern.compile((String)localIterator.next()).matcher(paramString).matches();
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  public final void d(int paramInt)
  {
    e.putInt("auto-advance-mode", paramInt).apply();
    Context localContext = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(localContext.getPackageName());
    localContext.startService(localIntent);
  }
  
  public final void d(boolean paramBoolean)
  {
    e.putBoolean("conversation-overview-mode", paramBoolean).apply();
  }
  
  public final boolean d()
  {
    return d.getBoolean("conversation-list-swipe", true);
  }
  
  public final boolean d(String paramString)
  {
    return d.getBoolean(paramString, g.contains(paramString));
  }
  
  public final void e(int paramInt)
  {
    e.putInt("migration-state", paramInt).apply();
  }
  
  public final boolean e()
  {
    return d.getBoolean("conversation-list-sender-image", true);
  }
  
  public final boolean e(String paramString)
  {
    SharedPreferences localSharedPreferences = d;
    String str = String.valueOf("requested-permissions-");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = str.concat(paramString);; paramString = new String(str)) {
      return localSharedPreferences.getBoolean(paramString, false);
    }
  }
  
  public final void f(String paramString)
  {
    SharedPreferences.Editor localEditor = e;
    String str = String.valueOf("requested-permissions-");
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {}
    for (paramString = str.concat(paramString);; paramString = new String(str))
    {
      localEditor.putBoolean(paramString, true).apply();
      return;
    }
  }
  
  public final boolean f()
  {
    return d.getBoolean("confirm-delete", false);
  }
  
  public final boolean g()
  {
    return d.getBoolean("confirm-send", false);
  }
  
  public final boolean h()
  {
    return d.getBoolean("mail-enable-threading", false);
  }
  
  public final int i()
  {
    return d.getInt("auto-advance-mode", 3);
  }
  
  protected final void i_()
  {
    e.putInt("migrated-version", 4).commit();
  }
  
  public final int j()
  {
    int i = 1;
    if (d.contains("conversation-overview-mode"))
    {
      if (d.getBoolean("conversation-overview-mode", true)) {
        i = 0;
      }
      return i;
    }
    return -1;
  }
  
  public final void k()
  {
    e.putBoolean("eas-promo-dismissed", true).apply();
  }
  
  protected final boolean r_()
  {
    boolean bool = false;
    if (d.getInt("migrated-version", 0) >= 4) {
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     cfm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */