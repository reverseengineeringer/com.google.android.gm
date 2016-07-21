import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader.OnLoadCompleteListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.android.mail.providers.Settings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public abstract class cgr
  extends ContentProvider
  implements Loader.OnLoadCompleteListener<Cursor>
{
  public static cgr b;
  private static final String c = cvl.a;
  private static String h;
  public final LinkedHashMap<Uri, cgt> a = new LinkedHashMap();
  private final Map<Uri, CursorLoader> d = new HashMap();
  private final Map<CursorLoader, Boolean> e = new HashMap();
  private ContentResolver f;
  private Comparator<cgt> g;
  private SharedPreferences i;
  
  private final void a(Uri paramUri)
  {
    try
    {
      CursorLoader localCursorLoader1 = new CursorLoader(getContext(), paramUri, chh.c, null, null, null);
      localCursorLoader1.registerListener(paramUri.hashCode(), this);
      localCursorLoader1.startLoading();
      CursorLoader localCursorLoader2 = (CursorLoader)d.get(paramUri);
      if (localCursorLoader2 != null) {
        localCursorLoader2.stopLoading();
      }
      d.put(paramUri, localCursorLoader1);
      e.put(localCursorLoader1, Boolean.valueOf(false));
      return;
    }
    finally {}
  }
  
  private final void a(Uri paramUri, cgt paramcgt)
  {
    synchronized (a)
    {
      cvm.a(c, "adding account %s", new Object[] { a });
      a.put(paramUri, paramcgt);
      return;
    }
  }
  
  public static Uri b()
  {
    String str = h;
    return Uri.parse(String.valueOf(str).length() + 11 + "content://" + str + "/");
  }
  
  private static void e()
  {
    cgr localcgr = b;
    if (localcgr != null) {
      f.notifyChange(b(), null);
    }
  }
  
  private final void f()
  {
    synchronized (a)
    {
      Object localObject2 = hef.a(a.values());
      ??? = new JSONArray();
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext()) {
        ((JSONArray)???).put(((cgt)((Iterator)localObject2).next()).a());
      }
    }
    SharedPreferences.Editor localEditor = d().edit();
    localEditor.putString("accountList", ((JSONArray)???).toString());
    localEditor.apply();
  }
  
  private final boolean g()
  {
    Iterator localIterator = e.values().iterator();
    while (localIterator.hasNext()) {
      if (!((Boolean)localIterator.next()).booleanValue()) {
        return false;
      }
    }
    return true;
  }
  
  public abstract Intent a(Context paramContext);
  
  public abstract String a();
  
  public final String c()
  {
    return d().getString("lastViewedAccount", null);
  }
  
  public final SharedPreferences d()
  {
    if (i == null) {
      i = getContext().getSharedPreferences("MailAppProvider", 0);
    }
    return i;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return paramUri;
  }
  
  public boolean onCreate()
  {
    int k = 0;
    h = a();
    b = this;
    f = getContext().getContentResolver();
    for (;;)
    {
      try
      {
        localObject = d().getString("accountList", null);
        if (localObject == null) {
          break label303;
        }
        localObject = new JSONArray((String)localObject);
      }
      catch (Exception localException1)
      {
        try
        {
          Object localObject;
          cgt localcgt = new cgt(((JSONArray)localObject).getJSONObject(j));
          if (a.z == null)
          {
            cvm.e(c, "Dropping account that doesn't specify settings", new Object[0]);
            j += 1;
            continue;
            localException1 = localException1;
            cvm.e(c, localException1, "ignoring unparsable accounts cache", new Object[0]);
            arrayOfString = null;
            continue;
          }
          localAccount = a;
          ContentProviderClient localContentProviderClient = f.acquireContentProviderClient(g);
          if (localContentProviderClient != null)
          {
            localContentProviderClient.release();
            a(g, localcgt);
            continue;
          }
        }
        catch (Exception localException2)
        {
          Account localAccount;
          cvm.e(c, localException2, "Unable to create account object from serialized form", new Object[0]);
          continue;
          cvm.e(c, "Dropping account without provider: %s", new Object[] { c });
          continue;
        }
        e();
        arrayOfString = getContext().getResources().getStringArray(btw.b);
        g = new cwn(arrayOfString, new cgs(this));
        int m = arrayOfString.length;
        int j = k;
        if (j >= m) {
          continue;
        }
        a(Uri.parse(arrayOfString[j]));
        j += 1;
        continue;
        return true;
      }
      if (localObject != null)
      {
        j = 0;
        if (j >= ((JSONArray)localObject).length()) {}
      }
      label303:
      String[] arrayOfString = null;
    }
  }
  
  public Cursor query(Uri paramUri, String[] arg2, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    paramUri = chl.a(???, chh.c);
    paramArrayOfString2 = new Bundle();
    int j;
    if (g())
    {
      j = 1;
      paramArrayOfString2.putInt("accounts_loaded", j);
    }
    Object localObject;
    for (;;)
    {
      synchronized (a)
      {
        paramString1 = new ArrayList(a.values());
        Collections.sort(paramString1, g);
        ??? = new cvq(paramUri, paramString1.size(), paramArrayOfString2);
        paramString1 = paramString1.iterator();
        if (!paramString1.hasNext()) {
          break label1529;
        }
        localObject = nexta;
        paramArrayOfString2 = ???.newRow();
        paramString2 = new HashMap();
        paramString2.put("_id", Integer.valueOf(0));
        paramString2.put("name", a);
        paramString2.put("senderName", b);
        paramString2.put("type", e);
        paramString2.put("accountManagerName", c);
        paramString2.put("accountId", d);
        paramString2.put("providerVersion", Integer.valueOf(f));
        paramString2.put("accountUri", g);
        paramString2.put("capabilities", Long.valueOf(h));
        paramString2.put("folderListUri", i);
        paramString2.put("fullFolderListUri", j);
        paramString2.put("allFolderListUri", k);
        paramString2.put("searchUri", l);
        paramString2.put("searchMessageGenericUri", m);
        paramString2.put("accountFromAddresses", n);
        paramString2.put("expungeMessageUri", o);
        paramString2.put("undoUri", p);
        paramString2.put("accountSettingsIntentUri", q);
        paramString2.put("helpIntentUri", r);
        paramString2.put("sendFeedbackIntentUri", s);
        paramString2.put("reauthenticationUri", t);
        paramString2.put("syncStatus", Integer.valueOf(u));
        paramString2.put("composeUri", v);
        paramString2.put("mimeType", w);
        paramString2.put("recentFolderListUri", x);
        paramString2.put("defaultRecentFolderListUri", y);
        paramString2.put("manualSyncUri", A);
        paramString2.put("viewProxyUri", B);
        paramString2.put("accountCookieUri", C);
        paramString2.put("accountOAuthTokenUri", D);
        paramString2.put("updateSettingsUri", E);
        paramString2.put("enableMessageTransforms", Integer.valueOf(F));
        paramString2.put("syncAuthority", G);
        paramString2.put("quickResponseUri", H);
        paramString2.put("settingsFragmentClass", I);
        paramString2.put("securityHold", Integer.valueOf(J));
        paramString2.put("accountSecurityUri", K);
        paramString2.put("settingsSnapshotUri", L);
        paramString2.put("vacationResponderSettingsUri", M);
        paramString2.put("driveUri", N);
        paramString2.put("drawerAddress", O);
        paramString2.put("providerHostname", P);
        paramString2.put("providerPathname", Q);
        paramString2.put("domainTlsPredictionUri", R);
        localObject = z;
        paramString2.put("signature", b);
        paramString2.put("auto_advance", Integer.valueOf(((Settings)localObject).b()));
        paramString2.put("reply_behavior", Integer.valueOf(c));
        paramString2.put("conversation_list_icon", Integer.valueOf(d));
        if (e)
        {
          j = 1;
          paramString2.put("confirm_delete", Integer.valueOf(j));
          if (!f) {
            break label1431;
          }
          j = 1;
          paramString2.put("confirm_archive", Integer.valueOf(j));
          if (!g) {
            break label1437;
          }
          j = 1;
          paramString2.put("confirm_send", Integer.valueOf(j));
          paramString2.put("default_inbox", i);
          paramString2.put("default_inbox_name", j);
          if (!k) {
            break label1443;
          }
          j = 1;
          paramString2.put("force_reply_from_default", Integer.valueOf(j));
          paramString2.put("max_attachment_size", Long.valueOf(l));
          paramString2.put("swipe", Integer.valueOf(m));
          if (!n) {
            break label1449;
          }
          j = 1;
          paramString2.put("importance_markers_enabled", Integer.valueOf(j));
          if (!o) {
            break label1455;
          }
          j = 1;
          paramString2.put("show_chevrons_enabled", Integer.valueOf(j));
          paramString2.put("setup_intent_uri", p);
          paramString2.put("conversation_view_mode", Integer.valueOf(h));
          paramString2.put("move_to_inbox", w);
          paramString2.put("show_images", Integer.valueOf(q));
          paramString2.put("welcome_tour_shown_version", Integer.valueOf(r));
          if (!s) {
            break label1461;
          }
          j = 1;
          paramString2.put("temp_tls_ii", Integer.valueOf(j));
          if (!t) {
            break label1467;
          }
          j = 1;
          paramString2.put("temp_tls_oi", Integer.valueOf(j));
          if (!u) {
            break label1473;
          }
          j = 1;
          paramString2.put("temp_fz_ii", Integer.valueOf(j));
          if (!v) {
            break label1479;
          }
          j = 1;
          paramString2.put("temp_fz_oi", Integer.valueOf(j));
          int k = paramUri.length;
          j = 0;
          if (j < k)
          {
            localObject = paramUri[j];
            if (!paramString2.containsKey(localObject)) {
              break;
            }
            paramArrayOfString2.add(paramString2.get(localObject));
            j += 1;
            continue;
          }
          continue;
          j = 0;
        }
      }
      j = 0;
      continue;
      label1431:
      j = 0;
      continue;
      label1437:
      j = 0;
      continue;
      label1443:
      j = 0;
      continue;
      label1449:
      j = 0;
      continue;
      label1455:
      j = 0;
      continue;
      label1461:
      j = 0;
      continue;
      label1467:
      j = 0;
      continue;
      label1473:
      j = 0;
      continue;
      label1479:
      j = 0;
    }
    paramUri = String.valueOf(localObject);
    if (paramUri.length() != 0) {}
    for (paramUri = "Unexpected column: ".concat(paramUri);; paramUri = new String("Unexpected column: ")) {
      throw new IllegalStateException(paramUri);
    }
    label1529:
    ???.setNotificationUri(f, b());
    return (Cursor)???;
  }
  
  public void shutdown()
  {
    b = null;
    Iterator localIterator = d.values().iterator();
    while (localIterator.hasNext()) {
      ((CursorLoader)localIterator.next()).stopLoading();
    }
    d.clear();
    e.clear();
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     cgr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */