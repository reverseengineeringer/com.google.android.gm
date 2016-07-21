import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.mail.providers.Account;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class djv
  extends dbx<djw>
{
  private static final Pattern a = Pattern.compile("(\\d+) (.+)");
  
  private static int a(Context paramContext, String paramString, ContentValues paramContentValues)
  {
    cwv.b();
    Object localObject = a.matcher(paramString);
    int i;
    Account localAccount;
    if (((Matcher)localObject).matches())
    {
      Account[] arrayOfAccount = ctl.b(paramContext);
      String str = ((Matcher)localObject).group(2);
      int j = arrayOfAccount.length;
      i = 0;
      if (i < j)
      {
        localAccount = arrayOfAccount[i];
        if (!TextUtils.equals(str, cvm.a(c))) {}
      }
    }
    for (localObject = cgy.a(localAccount, "/saveTo/save", Long.parseLong(((Matcher)localObject).group(1)));; localObject = null)
    {
      if (localObject != null) {
        break label123;
      }
      cvm.d("DriveUtils", "Can't find account for tag %s", new Object[] { paramString });
      return 0;
      i += 1;
      break;
    }
    label123:
    return paramContext.getContentResolver().update((Uri)localObject, paramContentValues, null, null);
  }
  
  private static long a(String paramString)
  {
    return Long.parseLong(paramString.split(" ")[0]);
  }
  
  public static Bundle a(String paramString1, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle(3);
    localBundle.putString("account", paramString1);
    localBundle.putString("message", paramString2);
    localBundle.putString("attachment", paramString3);
    return localBundle;
  }
  
  public static String a(String paramString, long paramLong)
  {
    return String.format(Locale.US, "%d %s", new Object[] { Long.valueOf(paramLong), cvm.a(paramString) });
  }
  
  public static void a(Context paramContext, String paramString)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("uploaded", Integer.valueOf(1));
    if (a(paramContext, paramString, localContentValues) > 0)
    {
      cvm.c("DriveUtils", "Updated save upload state for tag %s", new Object[] { paramString });
      return;
    }
    cvm.d("DriveUtils", "Save upload state was not updated for tag %s", new Object[] { paramString });
  }
  
  public static void a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramString = cgy.a(paramContext, paramBundle.getString("account"), a(paramString));
    if (paramString != null) {
      paramContext.getContentResolver().delete(paramString, null, null);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("resourceId", paramString2);
    if (a(paramContext, paramString1, localContentValues) > 0)
    {
      cvm.c("DriveUtils", "Save updated with resource ID for tag %s", new Object[] { paramString1 });
      return;
    }
    cvm.d("DriveUtils", "Resource ID was not updated for tag %s", new Object[] { paramString1 });
  }
  
  public static boolean a(ContentResolver paramContentResolver, Account paramAccount, long paramLong, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("save", Long.valueOf(paramLong));
    localContentValues.put("message", paramString1);
    localContentValues.put("attachment", paramString2);
    return paramContentResolver.insert(cgy.a(paramAccount, "/operation"), localContentValues) != null;
  }
  
  public static int b(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramString = cgy.a(paramContext, paramBundle.getString("account"), a(paramString));
    if (paramString != null)
    {
      paramContext = paramContext.getContentResolver().query(paramString, null, null, null, null);
      if (paramContext == null) {}
    }
    try
    {
      if (paramContext.moveToFirst())
      {
        int i = paramContext.getInt(paramContext.getColumnIndex("retries"));
        return i;
      }
      return -1;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static djw b(Context paramContext, Bundle paramBundle)
  {
    Object localObject2 = paramBundle.getString("account");
    Object localObject1 = paramBundle.getString("message");
    String str = paramBundle.getString("attachment");
    paramBundle = new djw();
    c = SystemClock.uptimeMillis();
    a = ((String)localObject2);
    try
    {
      paramContext = a(paramContext, (String)localObject2, "oauth2:https://www.googleapis.com/auth/drive https://www.googleapis.com/auth/gmail.readonly", dpy.a(paramContext.getContentResolver()));
      localObject2 = new gvk();
      messageId = Long.toHexString(Long.parseLong((String)localObject1));
      localObject1 = new GmailAttachment();
      m = str;
      ((GmailAttachment)localObject1).q();
      partId = b;
      b = ((gvk)new gve(new gvd(paramContext), (gvk)localObject2).c());
      return paramBundle;
    }
    catch (Exception paramContext)
    {
      cvm.e("DriveUtils", paramContext, "Problem inserting attachment into Drive", new Object[0]);
    }
    return paramBundle;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues(2);
    localContentValues.put("resourceId", paramString2);
    localContentValues.put("uploaded", Integer.valueOf(1));
    if (a(paramContext, paramString1, localContentValues) > 0)
    {
      cvm.c("DriveUtils", "Updated save for tag %s", new Object[] { paramString1 });
      return;
    }
    cvm.d("DriveUtils", "Save was not updated for tag %s", new Object[] { paramString1 });
  }
  
  public static boolean c(Context paramContext, String paramString, Bundle paramBundle)
  {
    boolean bool2 = false;
    paramString = cgy.a(paramContext, paramBundle.getString("account"), a(paramString));
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramContext.getContentResolver().update(paramString, null, null, null) > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     djv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */