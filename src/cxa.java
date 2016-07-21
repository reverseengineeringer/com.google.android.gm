import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Trace;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.android.emailcommon.mail.Address;
import com.android.mail.providers.Account;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class cxa
{
  public static final Character a = Character.valueOf('\n');
  public static final cey b;
  static final Object c = new Object();
  static int d = -1;
  static String e;
  static String f;
  static String g;
  private static String h = null;
  private static final String i = cvl.a;
  private static cxb j;
  
  static
  {
    cey localcey = new cey((byte)0);
    c = "ConvLoadTimer";
    b = localcey;
  }
  
  public static int a(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static int a(View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      k = leftMargin;
    }
    for (int k = rightMargin + k;; k = 0)
    {
      paramView.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(paramViewGroup.getWidth(), 1073741824), k + (paramViewGroup.getPaddingLeft() + paramViewGroup.getPaddingRight()), -1), View.MeasureSpec.makeMeasureSpec(0, 0));
      return paramView.getMeasuredHeight();
    }
  }
  
  public static int a(Folder paramFolder)
  {
    int k = 0;
    if ((paramFolder == null) || (paramFolder.a(32768))) {
      return 0;
    }
    if ((paramFolder.d(4)) || (paramFolder.d(32)) || (paramFolder.d(8))) {
      k = 1;
    }
    if (k != 0) {
      return l;
    }
    return paramFolder.k;
  }
  
  public static long a(long paramLong, long[] paramArrayOfLong)
  {
    int m = paramArrayOfLong.length;
    int k = 0;
    while (k < m)
    {
      long l = paramArrayOfLong[k];
      if (paramLong < l) {
        return l;
      }
      k += 1;
    }
    return -1L;
  }
  
  public static Intent a(Context paramContext, Uri paramUri, Account paramAccount)
  {
    if ((paramUri == null) || (paramAccount == null))
    {
      cvm.f(i, "Utils.createViewFolderIntent(%s,%s): Bad input", new Object[] { paramUri, paramAccount });
      return null;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268484608);
    localIntent.setDataAndType(a(paramContext, paramUri), w);
    localIntent.putExtra("mail_account", paramAccount.a());
    localIntent.putExtra("folderUri", paramUri);
    return localIntent;
  }
  
  public static Intent a(Context paramContext, Conversation paramConversation, Uri paramUri, Account paramAccount)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268484608);
    localIntent.setDataAndType(a(paramContext, c).buildUpon().appendQueryParameter("folderUri", paramUri.toString()).build(), w);
    localIntent.putExtra("mail_account", paramAccount.a());
    localIntent.putExtra("folderUri", paramUri);
    localIntent.putExtra("conversationUri", paramConversation);
    return localIntent;
  }
  
  public static Intent a(Intent paramIntent, Uri paramUri, String paramString)
  {
    return paramIntent.setDataAndType(a(paramUri), e(paramString));
  }
  
  public static Intent a(Account paramAccount)
  {
    if (paramAccount == null)
    {
      cvm.f(i, "Utils.createViewInboxIntent: Bad input - null account", new Object[0]);
      return null;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(268484608);
    localIntent.setDataAndType(z.i, w);
    localIntent.putExtra("mail_account", paramAccount.a());
    return localIntent;
  }
  
  public static Uri a(Context paramContext, Uri paramUri)
  {
    return paramUri.buildUpon().appendQueryParameter("appVersion", d(paramContext)).build();
  }
  
  public static Uri a(Uri paramUri)
  {
    String str1 = paramUri.getScheme();
    if (str1 == null) {}
    String str2;
    do
    {
      return paramUri;
      str2 = str1.toLowerCase(Locale.US);
    } while (str1.equals(str2));
    return paramUri.buildUpon().scheme(str2).build();
  }
  
  public static Address a(Map<String, Address> paramMap, String paramString)
  {
    try
    {
      Address localAddress2 = (Address)paramMap.get(paramString);
      Address localAddress1 = localAddress2;
      if (localAddress2 == null)
      {
        localAddress2 = Address.c(paramString);
        localAddress1 = localAddress2;
        if (localAddress2 != null)
        {
          paramMap.put(paramString, localAddress2);
          localAddress1 = localAddress2;
        }
      }
      return localAddress1;
    }
    finally {}
  }
  
  public static Folder a(Context paramContext, Uri paramUri, boolean paramBoolean)
  {
    paramUri = paramUri.buildUpon().appendQueryParameter("allowHiddenFolders", Boolean.toString(paramBoolean)).build();
    paramContext = paramContext.getContentResolver().query(paramUri, chh.i, null, null, null);
    if (paramContext == null) {
      return null;
    }
    try
    {
      if (paramContext.moveToFirst())
      {
        paramUri = new Folder(paramContext);
        return paramUri;
      }
      return null;
    }
    finally
    {
      paramContext.close();
    }
  }
  
  public static Object a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (paramBoolean) {
        str = paramString.replace("\"\"", "");
      }
      return TextUtils.htmlEncode(str);
    }
    return "";
  }
  
  public static String a(Fragment paramFragment)
  {
    StringWriter localStringWriter = new StringWriter();
    paramFragment.dump("", new FileDescriptor(), new PrintWriter(localStringWriter), new String[0]);
    return localStringWriter.toString();
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    int k = f(paramContext);
    if (paramInt > k) {
      return String.format(g(paramContext), new Object[] { Integer.valueOf(k) });
    }
    if (paramInt <= 0) {
      return "";
    }
    return String.format("%d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2)
  {
    return String.format(paramContext.getResources().getQuantityText(paramInt1, paramInt2).toString(), new Object[] { Integer.valueOf(paramInt2) });
  }
  
  public static String a(String paramString)
  {
    int k = paramString.length();
    if (k < 7) {
      return paramString;
    }
    int m = Math.min(7, k);
    int n = paramString.lastIndexOf(".");
    String str2 = "…";
    String str1 = str2;
    if (n >= 0)
    {
      str1 = str2;
      if (k - n <= 5)
      {
        str1 = String.valueOf("…");
        str2 = String.valueOf(paramString.substring(n + 1));
        if (str2.length() == 0) {
          break label137;
        }
      }
    }
    label137:
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      m -= str1.length();
      k = m;
      if (m < 0) {
        k = 0;
      }
      paramString = String.valueOf(paramString.substring(0, k));
      str1 = String.valueOf(str1);
      if (str1.length() == 0) {
        break;
      }
      return paramString.concat(str1);
    }
    return new String(paramString);
  }
  
  public static String a(String paramString, gpi paramgpi, gpw paramgpw)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return b(paramString, paramgpi, paramgpw).a();
  }
  
  public static String a(Locale paramLocale)
  {
    String str = paramLocale.getCountry();
    if (TextUtils.isEmpty(str)) {
      return paramLocale.getLanguage();
    }
    paramLocale = String.valueOf(paramLocale.getLanguage());
    return String.valueOf(paramLocale).length() + 1 + String.valueOf(str).length() + paramLocale + "-" + str;
  }
  
  public static void a()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.endSection();
    }
  }
  
  public static void a(Context paramContext, Uri paramUri, String paramString)
  {
    if (d(paramUri)) {
      b(paramContext, cuw.a(paramContext, paramUri, paramString));
    }
  }
  
  public static void a(Context paramContext, Account paramAccount)
  {
    if (paramAccount == null)
    {
      cvm.e(i, "Invalid attempt to show setting screen with null account", new Object[0]);
      return;
    }
    paramAccount = new Intent("android.intent.action.EDIT", q);
    paramAccount.setPackage(paramContext.getPackageName());
    paramAccount.addFlags(524288);
    paramContext.startActivity(paramAccount);
  }
  
  public static void a(Context paramContext, Account paramAccount, Folder paramFolder)
  {
    if (paramAccount == null)
    {
      cvm.e(i, "Invalid attempt to show setting screen with null account", new Object[0]);
      return;
    }
    Intent localIntent = new Intent("android.intent.action.EDIT", a(paramContext, q));
    localIntent.setPackage(paramContext.getPackageName());
    localIntent.putExtra("mail_account", paramAccount);
    if (paramFolder != null) {
      localIntent.putExtra("folderId", b);
    }
    localIntent.addFlags(524288);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, Account paramAccount, String paramString)
  {
    String str;
    if (r != null)
    {
      str = r.toString();
      if (!TextUtils.isEmpty(str)) {
        break label46;
      }
      cvm.e(i, "unable to show help for account: %s", new Object[] { paramAccount });
    }
    label46:
    do
    {
      return;
      str = null;
      break;
      paramAccount = r;
    } while (!d(paramAccount));
    paramAccount = cuw.a(paramContext, paramAccount, paramString);
    if (paramContext.getResources().getBoolean(bty.d))
    {
      b(paramContext, paramAccount);
      return;
    }
    paramString = new Intent(paramContext, coj.class);
    paramString.putExtra("help.url", paramAccount);
    paramContext.startActivity(paramString);
  }
  
  public static void a(Cursor paramCursor, boolean paramBoolean1, boolean paramBoolean2)
  {
    new cxc(paramCursor, paramBoolean1, paramBoolean2).execute(new Void[0]);
  }
  
  public static void a(Menu paramMenu, int paramInt, boolean paramBoolean)
  {
    a(paramMenu.findItem(paramInt), paramBoolean);
  }
  
  public static void a(MenuItem paramMenuItem, boolean paramBoolean)
  {
    if (paramMenuItem == null) {
      return;
    }
    paramMenuItem.setVisible(paramBoolean);
    paramMenuItem.setEnabled(paramBoolean);
  }
  
  public static void a(WebView paramWebView)
  {
    paramWebView = paramWebView.getSettings();
    paramWebView.setSavePassword(false);
    paramWebView.setSaveFormData(false);
    paramWebView.setJavaScriptEnabled(false);
    paramWebView.setSupportZoom(false);
  }
  
  public static void a(WebView paramWebView, Context paramContext)
  {
    paramWebView = paramWebView.getSettings();
    String str1 = d(paramContext);
    String str2 = paramWebView.getUserAgentString();
    paramWebView.setUserAgentString(paramContext.getResources().getString(buj.fu, new Object[] { str2, str1 }));
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = j(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean a(Resources paramResources)
  {
    return paramResources.getBoolean(bty.e);
  }
  
  public static boolean a(Cursor paramCursor, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("uiPositionChange", paramInt);
    return a(paramCursor, localBundle, "uiPositionChange");
  }
  
  static boolean a(Cursor paramCursor, Bundle paramBundle, String paramString)
  {
    return "ok".equals(paramCursor.respond(paramBundle).getString(paramString, "failed"));
  }
  
  public static int b(Context paramContext)
  {
    paramContext = j(paramContext);
    if ((paramContext == null) || (!paramContext.isConnected())) {
      return -1;
    }
    return paramContext.getType();
  }
  
  private static gpo b(String paramString, gpi paramgpi, gpw paramgpw)
  {
    d = paramString;
    e = new LinkedList();
    a = gpm.a;
    c = false;
    int n = paramString.length();
    int i1 = Math.min(b, n);
    int m = 0;
    if ((m < n) && (!c))
    {
      int k;
      switch (gpj.a[(a - 1)])
      {
      default: 
        throw new Error("Unknown state!");
      case 1: 
        k = paramgpi.a(m, i1);
        if ((k > m) || (a != gpm.a))
        {
          bool = true;
          label143:
          hby.a(bool);
          if (k < b) {
            break label388;
          }
        }
        break;
      }
      label250:
      label340:
      label388:
      for (boolean bool = true;; bool = false)
      {
        c = bool;
        m = k;
        break;
        bool = false;
        break label143;
        k = paramgpi.b(m, n);
        if (k > m) {}
        for (bool = true;; bool = false)
        {
          hby.a(bool);
          break;
        }
        hby.a(d.regionMatches(m, "<!--", 0, 4));
        k = d.indexOf("-->", m + 4);
        if (k != -1)
        {
          k += 3;
          if (g) {
            e.add(new goy(d.substring(m, k)));
          }
          a = gpm.a;
          if (k <= m) {
            break label340;
          }
        }
        for (bool = true;; bool = false)
        {
          hby.a(bool);
          break;
          k = d.indexOf('>', m + 4);
          if (k != -1)
          {
            k += 1;
            break label250;
          }
          k = n;
          break label250;
        }
        k = paramgpi.c(m, n);
        if ((k > m) || (a != gpm.d)) {}
        for (bool = true;; bool = false)
        {
          hby.a(bool);
          break;
        }
      }
    }
    e = gpi.a(e);
    paramString = new gow(e);
    e = null;
    paramString.a(paramgpw);
    hby.a(b);
    return a;
  }
  
  public static String b(Context paramContext, int paramInt)
  {
    int k = f(paramContext);
    if (paramInt > k) {
      return String.format(i(paramContext), new Object[] { Integer.valueOf(k) });
    }
    if (paramInt <= 0) {
      return "";
    }
    return String.format(h(paramContext), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return b(paramString, new gpi(), new gpw()).a();
  }
  
  private static void b(Context paramContext, Uri paramUri)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString())))
    {
      cvm.f(i, "invalid url in Utils.openUrl(): %s", new Object[] { paramUri });
      return;
    }
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.putExtra("com.android.browser.application_id", paramContext.getPackageName());
    paramUri.addFlags(524288);
    paramContext.startActivity(paramUri);
  }
  
  public static void b(Context paramContext, Account paramAccount)
  {
    a(paramContext, paramAccount, null);
  }
  
  public static boolean b(Context paramContext, Uri paramUri, Account paramAccount)
  {
    if (TextUtils.equals("mailto", a(paramUri).getScheme()))
    {
      cbk.a(paramContext, paramAccount, paramUri);
      return true;
    }
    return false;
  }
  
  public static boolean b(Uri paramUri)
  {
    return (paramUri == null) || (Uri.EMPTY.equals(paramUri));
  }
  
  public static int c(Context paramContext)
  {
    paramContext = j(paramContext);
    if ((paramContext == null) || (!paramContext.isConnected())) {
      return -1;
    }
    return paramContext.getSubtype();
  }
  
  public static gpo c(String paramString)
  {
    return b(paramString, new gpi(), new gpw());
  }
  
  public static CharSequence c(Context paramContext, int paramInt)
  {
    Object localObject;
    if (!chh.a(paramInt))
    {
      localObject = null;
      return (CharSequence)localObject;
    }
    Resources localResources = paramContext.getResources();
    paramContext = localResources.getStringArray(btw.g);
    switch (paramInt)
    {
    default: 
      if (paramInt < paramContext.length) {
        break;
      }
    }
    for (paramContext = paramContext[6];; paramContext = paramContext[paramInt])
    {
      localObject = paramContext;
      if (paramInt < 6) {
        break;
      }
      return localResources.getString(buj.fc, new Object[] { paramContext, Integer.valueOf(paramInt) });
      return localResources.getString(buj.eK);
      return localResources.getString(buj.eJ);
      return localResources.getString(buj.eL);
    }
  }
  
  public static String c(Uri paramUri)
  {
    if (!"cid".equals(paramUri.getScheme())) {}
    do
    {
      return null;
      paramUri = paramUri.getSchemeSpecificPart();
    } while (TextUtils.isEmpty(paramUri));
    return paramUri;
  }
  
  private static String d(Context paramContext)
  {
    if (h == null) {}
    try
    {
      h = String.valueOf(getPackageManagergetPackageInfogetPackageName0versionCode);
      return h;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        cvm.e(i, "Error finding package %s", new Object[] { getApplicationInfopackageName });
      }
    }
  }
  
  public static String d(String paramString)
  {
    Object localObject2 = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (int k = paramString.lastIndexOf('.');; k = -1)
    {
      Object localObject1 = localObject2;
      if (k >= 0)
      {
        localObject1 = localObject2;
        if (paramString.length() - k <= 5) {
          localObject1 = paramString.substring(k);
        }
      }
      return (String)localObject1;
    }
  }
  
  private static boolean d(Uri paramUri)
  {
    if (paramUri == null) {}
    for (Object localObject = null; TextUtils.isEmpty((CharSequence)localObject); localObject = paramUri.toString())
    {
      cvm.e(i, "Unable to show URI: %s", new Object[] { paramUri });
      return false;
    }
    return true;
  }
  
  public static String e(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    String str;
    int k;
    do
    {
      return paramString;
      str = paramString.trim().toLowerCase(Locale.US);
      k = str.indexOf(';');
      paramString = str;
    } while (k == -1);
    return str.substring(0, k);
  }
  
  private static void e(Context paramContext)
  {
    synchronized (c)
    {
      if (e == null)
      {
        Resources localResources = paramContext.getResources();
        d = localResources.getInteger(bud.s);
        e = localResources.getString(buj.fG);
        f = localResources.getString(buj.fr);
        g = localResources.getString(buj.cM);
        if (j == null)
        {
          j = new cxb();
          paramContext.getApplicationContext().registerComponentCallbacks(j);
        }
      }
      return;
    }
  }
  
  private static int f(Context paramContext)
  {
    synchronized (c)
    {
      e(paramContext);
      int k = d;
      return k;
    }
  }
  
  public static Uri f(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString == JSONObject.NULL)) {
      return Uri.EMPTY;
    }
    return Uri.parse(paramString);
  }
  
  private static String g(Context paramContext)
  {
    synchronized (c)
    {
      e(paramContext);
      paramContext = e;
      return paramContext;
    }
  }
  
  public static void g(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      Trace.beginSection(paramString);
    }
  }
  
  private static String h(Context paramContext)
  {
    synchronized (c)
    {
      e(paramContext);
      paramContext = f;
      return paramContext;
    }
  }
  
  public static String h(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return paramString.toLowerCase(Locale.US);
  }
  
  private static String i(Context paramContext)
  {
    synchronized (c)
    {
      e(paramContext);
      paramContext = g;
      return paramContext;
    }
  }
  
  private static NetworkInfo j(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
}

/* Location:
 * Qualified Name:     cxa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */