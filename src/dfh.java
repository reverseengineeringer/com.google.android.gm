import android.accounts.AccountManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.mail.providers.Folder;
import com.google.android.gm.preference.GmailPreferenceActivity;
import com.google.android.gm.preference.InboxSectionsPreferenceFragment;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.GmailProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class dfh
{
  public static dfi a;
  private static final String b = cvl.a;
  private static final ComponentName c = new ComponentName("com.google.android.gm", "com.google.android.gm.CreateShortcutActivityGmail");
  private static final ComponentName d = new ComponentName("com.google.android.gm", "com.google.android.gm.CreateShortcutActivityGoogleMail");
  private static final ComponentName e = new ComponentName("com.google.android.gm", "com.google.android.gm.ConversationListActivityGoogleMail");
  private static final ComponentName f = new ComponentName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
  private static String g = null;
  private static final Map<String, com.android.mail.providers.Account> h = new HashMap();
  private static Map<String, ArrayList<Integer>> i = new ConcurrentHashMap();
  
  /* Error */
  public static Folder a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 71	drp:a	(Ljava/lang/String;)Ldrp;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +67 -> 75
    //   11: aload 4
    //   13: astore_0
    //   14: new 73	dvs
    //   17: dup
    //   18: aload_0
    //   19: getstatic 79	dpy:t	[Ljava/lang/String;
    //   22: invokevirtual 82	drp:b	([Ljava/lang/String;)Ldrf;
    //   25: aload_2
    //   26: invokestatic 88	java/util/Collections:singletonList	(Ljava/lang/Object;)Ljava/util/List;
    //   29: invokevirtual 93	drf:a	(Ljava/util/List;)Ldrf;
    //   32: iload_3
    //   33: invokevirtual 96	drf:a	(Z)Ldrf;
    //   36: invokevirtual 99	drf:a	()Landroid/database/Cursor;
    //   39: aload_0
    //   40: aload_1
    //   41: getstatic 79	dpy:t	[Ljava/lang/String;
    //   44: aconst_null
    //   45: invokespecial 102	dvs:<init>	(Landroid/database/Cursor;Ldrp;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V
    //   48: astore_0
    //   49: aload_0
    //   50: invokeinterface 108 1 0
    //   55: ifeq +29 -> 84
    //   58: new 110	com/android/mail/providers/Folder
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 113	com/android/mail/providers/Folder:<init>	(Landroid/database/Cursor;)V
    //   66: astore_1
    //   67: aload_0
    //   68: invokeinterface 116 1 0
    //   73: aload_1
    //   74: areturn
    //   75: aload_0
    //   76: aload_1
    //   77: invokestatic 119	drp:b	(Landroid/content/Context;Ljava/lang/String;)Ldrp;
    //   80: astore_0
    //   81: goto -67 -> 14
    //   84: iload_3
    //   85: ifne +32 -> 117
    //   88: getstatic 27	dfh:b	Ljava/lang/String;
    //   91: astore_1
    //   92: getstatic 27	dfh:b	Ljava/lang/String;
    //   95: iconst_3
    //   96: invokestatic 124	dri:a	(Ljava/lang/String;I)Z
    //   99: ifeq +26 -> 125
    //   102: aload_1
    //   103: ldc 126
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_2
    //   112: aastore
    //   113: invokestatic 129	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   116: pop
    //   117: aload_0
    //   118: invokeinterface 116 1 0
    //   123: aconst_null
    //   124: areturn
    //   125: ldc -125
    //   127: astore_2
    //   128: goto -26 -> 102
    //   131: astore_1
    //   132: aload_0
    //   133: invokeinterface 116 1 0
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramContext	Context
    //   0	140	1	paramString1	String
    //   0	140	2	paramString2	String
    //   0	140	3	paramBoolean	boolean
    //   4	8	4	localdrp	drp
    // Exception table:
    //   from	to	target	type
    //   49	67	131	finally
    //   88	102	131	finally
    //   102	117	131	finally
  }
  
  public static String a(ContentResolver paramContentResolver)
  {
    if (paramContentResolver == null) {
      return null;
    }
    return ghz.a(paramContentResolver, "gmail-ads-duration-since-last-action-url-parameter", "gm_ccd");
  }
  
  public static String a(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    Object localObject = null;
    try
    {
      paramAccount = paramContext.getContentResolver().query(L, null, null, null, null);
      if ((paramAccount == null) || (paramAccount != null)) {
        paramAccount.close();
      }
    }
    finally
    {
      try
      {
        if (paramAccount.moveToFirst())
        {
          paramContext = paramAccount.getString(0);
          if (paramAccount != null) {
            paramAccount.close();
          }
          return paramContext;
        }
        if (paramAccount != null) {
          paramAccount.close();
        }
        return null;
      }
      finally {}
      paramContext = finally;
      paramAccount = (com.android.mail.providers.Account)localObject;
    }
    throw paramContext;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    int k = 1;
    paramString1 = new dnn(paramContext, paramString1, paramString2, dmv.f(paramContext, paramString1).equals(paramString2));
    if (!paramString1.a()) {
      return null;
    }
    boolean bool = paramString1.c();
    int j;
    if (!paramString1.d())
    {
      j = 1;
      if (TextUtils.isEmpty(paramString1.b())) {
        break label89;
      }
      label57:
      if (k == 0) {
        break label125;
      }
      if ((!bool) || (j == 0)) {
        break label95;
      }
      j = dge.dN;
    }
    for (;;)
    {
      return paramContext.getResources().getString(j);
      j = 0;
      break;
      label89:
      k = 0;
      break label57;
      label95:
      if (bool)
      {
        j = dge.dM;
      }
      else if (j != 0)
      {
        j = dge.dL;
      }
      else
      {
        j = dge.dK;
        continue;
        label125:
        if ((bool) && (j != 0)) {
          j = dge.dR;
        } else if (bool) {
          j = dge.dQ;
        } else if (j != 0) {
          j = dge.dP;
        } else {
          j = dge.dO;
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = String.valueOf(paramString2);
      if (paramString1.length() != 0) {
        return "label:".concat(paramString1);
      }
      return new String("label:");
    }
    return "";
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, Uri.parse(ghz.a(paramContext.getContentResolver(), "gmail-ad-preference-manager-url", "https://www.google.com/settings/ads/preferences")), false);
  }
  
  public static void a(Context paramContext, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, Intent paramIntent)
  {
    hf localhf = new hf(paramContext);
    localhf.a(paramCharSequence1);
    localhf.b(paramCharSequence2);
    localhf.d(paramCharSequence1);
    localhf.a(17301624);
    localhf.a(chq.a());
    if (paramIntent != null)
    {
      if (paramIntent.getComponent() == null) {
        dri.f(b, "For security reason, this click intent must be explicit: %s", new Object[] { paramIntent });
      }
      d = PendingIntent.getActivity(paramContext, -1, paramIntent, 0);
    }
    ((NotificationManager)paramContext.getSystemService("notification")).notify(paramInt, localhf.b());
  }
  
  public static void a(Context paramContext, Advertisement paramAdvertisement)
  {
    if (p) {}
    for (int j = dge.bd;; j = dge.be)
    {
      Toast.makeText(paramContext, j, 0).show();
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString1, CharSequence paramCharSequence, long paramLong, String paramString2)
  {
    int j = Arrays.hashCode(new Object[] { Long.valueOf(paramLong), paramCharSequence });
    Object localObject = b(paramContext, paramString1);
    Folder localFolder = d(paramContext, paramString1, "^^out");
    if ((localFolder == null) || (paramString1 == null)) {
      dri.e(b, "Null account or folder.  account: %s folder: %s", new Object[] { localObject, localFolder });
    }
    for (localObject = null;; localObject = cxa.a(paramContext, c.b, (com.android.mail.providers.Account)localObject))
    {
      a(paramContext, j, paramString2, paramCharSequence, (Intent)localObject);
      paramCharSequence = (ArrayList)i.get(paramString1);
      paramContext = paramCharSequence;
      if (paramCharSequence == null) {
        paramContext = new ArrayList();
      }
      paramContext.add(Integer.valueOf(j));
      i.put(paramString1, paramContext);
      return;
    }
  }
  
  public static void a(Context paramContext, android.accounts.Account[] paramArrayOfAccount)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayOfAccount.length;
    int j = 0;
    while (j < k)
    {
      localArrayList.add(name);
      j += 1;
    }
    dmv.a().b(paramContext, null, "cache-google-accounts-synced", TextUtils.join(" ", localArrayList));
  }
  
  private static boolean a(android.accounts.Account paramAccount, android.accounts.Account[] paramArrayOfAccount)
  {
    boolean bool2 = false;
    int k = paramArrayOfAccount.length;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < k)
      {
        if (paramAccount.equals(paramArrayOfAccount[j])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public static boolean a(Context paramContext, Uri paramUri)
  {
    String str1 = ghz.a(paramContext.getContentResolver(), "gmail-ad-youtube-partial-authority", "youtube.com");
    paramContext = ghz.a(paramContext.getContentResolver(), "gmail-ad-youtube-path", "/watch");
    String str2 = paramUri.getAuthority();
    paramUri = paramUri.getPath();
    return (str2 != null) && (paramUri != null) && (str2.endsWith(str1)) && (paramContext.equals(paramUri));
  }
  
  public static boolean a(Context paramContext, Uri paramUri, boolean paramBoolean)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString())))
    {
      dri.f(b, "invalid url in Utils.openUrl(): %s", new Object[] { paramUri });
      return false;
    }
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.putExtra("com.android.browser.application_id", paramContext.getPackageName());
    paramUri.addFlags(524288);
    if (paramBoolean) {
      paramUri.putExtra("create_new_tab", true);
    }
    try
    {
      paramContext.startActivity(paramUri);
      return true;
    }
    catch (ActivityNotFoundException paramContext)
    {
      dri.e(b, paramContext, "Cannot open Url in browser", new Object[0]);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    paramContext = AccountManager.get(paramContext).getAccountsByType("com.google");
    return a(new android.accounts.Account(paramString, "com.google"), paramContext);
  }
  
  public static Intent b(Context paramContext, Uri paramUri)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString())))
    {
      dri.f(b, "invalid url in Utils.openUrl(): %s", new Object[] { paramUri });
      return null;
    }
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.putExtra("com.android.browser.application_id", paramContext.getPackageName());
    paramUri.addFlags(524288);
    return paramUri;
  }
  
  public static Intent b(Context paramContext, String paramString1, String paramString2)
  {
    com.android.mail.providers.Account localAccount = GmailProvider.a(paramContext, paramString1);
    return cxa.a(paramContext, ac.b, localAccount);
  }
  
  public static com.android.mail.providers.Account b(Context paramContext, String paramString)
  {
    synchronized (h)
    {
      com.android.mail.providers.Account localAccount = (com.android.mail.providers.Account)h.get(paramString);
      Object localObject = localAccount;
      if (localAccount == null)
      {
        localObject = GmailProvider.b(paramString);
        localObject = paramContext.getContentResolver().query((Uri)localObject, chh.c, null, null, null);
        paramContext = localAccount;
      }
      try
      {
        if (((Cursor)localObject).moveToFirst())
        {
          com.android.mail.providers.Account.b();
          paramContext = cfw.a((Cursor)localObject);
          h.put(paramString, paramContext);
        }
        ((Cursor)localObject).close();
        localObject = paramContext;
        return (com.android.mail.providers.Account)localObject;
      }
      finally
      {
        paramContext = finally;
        ((Cursor)localObject).close();
        throw paramContext;
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    a(paramContext, Uri.parse(ghz.a(paramContext.getContentResolver(), "gmail_ads_privacy_policy_url", "https://www.google.com/policies/privacy/")), false);
  }
  
  public static void b(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    Intent localIntent = new Intent(paramContext, GmailPreferenceActivity.class);
    localIntent.putExtra(":android:show_fragment", InboxSectionsPreferenceFragment.class.getName());
    Bundle localBundle = new Bundle(1);
    localBundle.putString("account", c);
    localIntent.putExtra(":android:show_fragment_args", localBundle);
    paramContext.startActivity(localIntent);
  }
  
  public static int c(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getContentResolver() == null)) {
      return 0;
    }
    return ghz.a(paramContext.getContentResolver(), "gmail-number-threads-to-report-in-organic-events", 5);
  }
  
  public static Folder c(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, paramString1, paramString2, false);
  }
  
  public static void c(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    Intent localIntent = new Intent(paramContext, GmailPreferenceActivity.class);
    localIntent.putExtra("mail_account", paramAccount);
    paramContext.startActivity(localIntent);
  }
  
  private static Folder d(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = GmailProvider.a(paramString1, paramString2);
    paramString1 = paramContext.getContentResolver().query(paramString1, chh.i, null, null, null);
    paramContext = (Context)localObject;
    try
    {
      if (paramString1.moveToFirst()) {
        paramContext = new Folder(paramString1);
      }
      return paramContext;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  public static void d(Context paramContext)
  {
    dmv localdmv = dmv.a();
    String str1 = localdmv.b(paramContext);
    android.accounts.Account[] arrayOfAccount = AccountManager.get(paramContext).getAccountsByType("com.google");
    if ((arrayOfAccount.length > 0) && (!g(paramContext)))
    {
      String str2 = 0name;
      Intent localIntent = new Intent();
      localIntent.setClass(paramContext, dgj.class);
      localIntent.putExtra("account-name", str2);
      paramContext.startService(localIntent);
    }
    int k = arrayOfAccount.length;
    int j = 0;
    if (j < k) {
      if (!TextUtils.equals(name, str1)) {}
    }
    while (arrayOfAccount.length <= 0)
    {
      return;
      j += 1;
      break;
    }
    localdmv.b(paramContext, null, "active-account", 0name);
  }
  
  public static boolean d(Context paramContext, com.android.mail.providers.Account paramAccount)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int k;
    int j;
    if (paramAccount != null)
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType("com.google");
      paramAccount = c;
      k = paramContext.length;
      j = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (j < k)
      {
        if (paramAccount.equals(name)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public static void e(Context paramContext)
  {
    boolean bool = h(paramContext);
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (bool)
    {
      paramContext = d;
      if (!bool) {
        break label48;
      }
    }
    label48:
    for (ComponentName localComponentName = c;; localComponentName = d)
    {
      localPackageManager.setComponentEnabledSetting(localComponentName, 2, 1);
      localPackageManager.setComponentEnabledSetting(paramContext, 1, 1);
      return;
      paramContext = c;
      break;
    }
  }
  
  public static void f(Context paramContext)
  {
    paramContext.getPackageManager().setComponentEnabledSetting(f, 1, 1);
  }
  
  public static boolean g(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    return (paramContext.getComponentEnabledSetting(d) == 1) || (paramContext.getComponentEnabledSetting(c) == 1);
  }
  
  public static boolean h(Context paramContext)
  {
    return paramContext.getPackageManager().getComponentEnabledSetting(e) == 1;
  }
  
  public static String i(Context paramContext)
  {
    if (g == null) {}
    try
    {
      g = String.valueOf(getPackageManagergetPackageInfogetPackageName0versionCode);
      return g;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        dri.e(b, "Error finding package %s", new Object[] { getApplicationInfopackageName });
      }
    }
  }
}

/* Location:
 * Qualified Name:     dfh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */