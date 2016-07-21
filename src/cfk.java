import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.Settings.System;
import com.android.mail.providers.Folder;
import java.util.HashMap;
import java.util.Map;

public class cfk
  extends cfr
{
  private static final Map<String, cfk> g = new HashMap();
  public final Folder a;
  private final String h;
  private final boolean i;
  
  private cfk(Context paramContext, String paramString1, Folder paramFolder, String paramString2, boolean paramBoolean)
  {
    super(paramContext, String.valueOf(str).length() + 1 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + str + paramString1 + "-" + paramString2);
    a = paramFolder;
    h = paramString2;
    i = paramBoolean;
  }
  
  public cfk(Context paramContext, String paramString, Folder paramFolder, boolean paramBoolean)
  {
    this(paramContext, paramString, paramFolder, b, paramBoolean);
  }
  
  public cfk(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramContext, paramString1, null, paramString2, paramBoolean);
  }
  
  public static cfk a(Context paramContext, String paramString, Folder paramFolder)
  {
    try
    {
      Object localObject = b;
      String str = String.valueOf(paramString).length() + 1 + String.valueOf(localObject).length() + paramString + "-" + (String)localObject;
      cfk localcfk = (cfk)g.get(str);
      localObject = localcfk;
      if (localcfk == null)
      {
        localObject = new cfk(paramContext, paramString, paramFolder, true);
        g.put(str, localObject);
      }
      return (cfk)localObject;
    }
    finally {}
  }
  
  private final String c(String paramString)
  {
    if (paramString.length() == 0) {}
    while (RingtoneManager.isDefault(Uri.parse(paramString))) {
      return paramString;
    }
    Object localObject = new RingtoneManager(b);
    ((RingtoneManager)localObject).setType(2);
    localObject = ((RingtoneManager)localObject).getCursor();
    try
    {
      while (((Cursor)localObject).moveToNext()) {
        if (ContentUris.withAppendedId(Uri.parse(((Cursor)localObject).getString(2)), ((Cursor)localObject).getLong(0)).toString().equals(paramString))
        {
          String str = ((Cursor)localObject).getString(1);
          boolean bool = hbw.b(str);
          if (!bool) {
            return str;
          }
        }
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  private final String d(String paramString)
  {
    if ((paramString.length() == 0) || (RingtoneManager.isDefault(Uri.parse(paramString)))) {
      return paramString;
    }
    Object localObject = new RingtoneManager(b);
    ((RingtoneManager)localObject).setType(2);
    localObject = ((RingtoneManager)localObject).getCursor();
    try
    {
      while (((Cursor)localObject).moveToNext()) {
        if (paramString.equals(((Cursor)localObject).getString(1)))
        {
          paramString = ContentUris.withAppendedId(Uri.parse(((Cursor)localObject).getString(2)), ((Cursor)localObject).getLong(0)).toString();
          return paramString;
        }
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  protected final Object a(String paramString, Object paramObject)
  {
    if ("notification-ringtone".equals(paramString)) {
      return c((String)paramObject);
    }
    return super.a(paramString, paramObject);
  }
  
  protected final void a(int paramInt)
  {
    if (paramInt > 4) {
      throw new IllegalStateException("You appear to have downgraded your app. Please clear app data.");
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    e.putBoolean("notifications-enabled", paramBoolean).apply();
    Context localContext = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(localContext.getPackageName());
    localContext.startService(localIntent);
  }
  
  public final boolean a()
  {
    return d.getBoolean("notifications-enabled", i);
  }
  
  protected final boolean a(String paramString)
  {
    if (h == null) {
      return false;
    }
    return cfl.a.contains(paramString);
  }
  
  protected final Object b(String paramString, Object paramObject)
  {
    if ("notification-ringtone".equals(paramString)) {
      return d((String)paramObject);
    }
    return super.a(paramString, paramObject);
  }
  
  public final String b()
  {
    return d.getString("notification-ringtone", Settings.System.DEFAULT_NOTIFICATION_URI.toString());
  }
  
  public final void b(String paramString)
  {
    e.putString("notification-ringtone", paramString).apply();
    paramString = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(paramString.getPackageName());
    paramString.startService(localIntent);
  }
  
  public final void b(boolean paramBoolean)
  {
    e.putBoolean("notification-vibrate", paramBoolean).apply();
    Context localContext = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(localContext.getPackageName());
    localContext.startService(localIntent);
  }
  
  public final void c(boolean paramBoolean)
  {
    e.putBoolean("notification-notify-every-message", paramBoolean).apply();
    Context localContext = b;
    Intent localIntent = new Intent("com.android.mail.action.BACKUP_DATA_CHANGED");
    localIntent.setPackage(localContext.getPackageName());
    localContext.startService(localIntent);
  }
  
  public final boolean c()
  {
    return d.getBoolean("notification-vibrate", false);
  }
  
  public final void d(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = e;
    if (paramBoolean)
    {
      localEditor.remove("inbox-sync-off").apply();
      return;
    }
    localEditor.putLong("inbox-sync-off", System.currentTimeMillis() + 86400000L).apply();
  }
  
  public final boolean d()
  {
    return d.getBoolean("notification-notify-every-message", false);
  }
}

/* Location:
 * Qualified Name:     cfk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */