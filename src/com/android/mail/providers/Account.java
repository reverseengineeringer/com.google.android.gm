package com.android.mail.providers;

import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.text.TextUtils;
import ccx;
import ccy;
import cfu;
import cfv;
import cfw;
import cha;
import cvl;
import cvm;
import cxa;
import hbc;
import hbw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Account
  implements Parcelable
{
  public static final Parcelable.ClassLoaderCreator<Account> CREATOR = new cfu();
  public static final ccx<Account> S = new cfv();
  private static final String T = cvl.a;
  private static Class<? extends cfw> W;
  private static cfw X;
  public final Uri A;
  public final Uri B;
  public final Uri C;
  public final Uri D;
  public final Uri E;
  public final int F;
  public final String G;
  public final Uri H;
  public final String I;
  public final int J;
  public final String K;
  public final Uri L;
  public final Uri M;
  public final Uri N;
  public final String O;
  public final String P;
  public final String Q;
  public final Uri R;
  private android.accounts.Account U;
  private transient List<cha> V;
  public final String a;
  public final String b;
  public final String c;
  public String d;
  public final String e;
  public final int f;
  public final Uri g;
  public final long h;
  public final Uri i;
  public Uri j;
  public Uri k;
  public final Uri l;
  public final Uri m;
  public String n;
  public final Uri o;
  public final Uri p;
  public final Uri q;
  public final Uri r;
  public final Uri s;
  public final Uri t;
  public final int u;
  public final Uri v;
  public final String w;
  public final Uri x;
  public final Uri y;
  public final Settings z;
  
  public Account(Cursor paramCursor)
  {
    a = paramCursor.getString(paramCursor.getColumnIndex("name"));
    b = paramCursor.getString(paramCursor.getColumnIndex("senderName"));
    e = paramCursor.getString(paramCursor.getColumnIndex("type"));
    c = paramCursor.getString(paramCursor.getColumnIndex("accountManagerName"));
    d = paramCursor.getString(paramCursor.getColumnIndex("accountId"));
    n = hbw.a(paramCursor.getString(paramCursor.getColumnIndex("accountFromAddresses")));
    int i2 = paramCursor.getColumnIndex("capabilities");
    if (i2 != -1)
    {
      h = paramCursor.getLong(i2);
      f = paramCursor.getInt(paramCursor.getColumnIndex("providerVersion"));
      g = Uri.parse(paramCursor.getString(paramCursor.getColumnIndex("accountUri")));
      i = Uri.parse(paramCursor.getString(paramCursor.getColumnIndex("folderListUri")));
      j = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("fullFolderListUri")));
      k = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("allFolderListUri")));
      l = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("searchUri")));
      m = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("searchMessageGenericUri")));
      o = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("expungeMessageUri")));
      p = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("undoUri")));
      q = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("accountSettingsIntentUri")));
      r = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("helpIntentUri")));
      s = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("sendFeedbackIntentUri")));
      t = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("reauthenticationUri")));
      u = paramCursor.getInt(paramCursor.getColumnIndex("syncStatus"));
      v = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("composeUri")));
      w = paramCursor.getString(paramCursor.getColumnIndex("mimeType"));
      x = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("recentFolderListUri")));
      y = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("defaultRecentFolderListUri")));
      A = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("manualSyncUri")));
      B = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("viewProxyUri")));
      C = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("accountCookieUri")));
      D = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("accountOAuthTokenUri")));
      E = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("updateSettingsUri")));
      F = paramCursor.getInt(paramCursor.getColumnIndex("enableMessageTransforms"));
      G = paramCursor.getString(paramCursor.getColumnIndex("syncAuthority"));
      if (TextUtils.isEmpty(G)) {
        cvm.e(T, "Unexpected empty syncAuthority from cursor", new Object[0]);
      }
      H = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("quickResponseUri")));
      I = paramCursor.getString(paramCursor.getColumnIndex("settingsFragmentClass"));
      if (paramCursor.getColumnIndex("securityHold") >= 0) {
        i1 = paramCursor.getInt(paramCursor.getColumnIndex("securityHold"));
      }
      J = i1;
      i1 = paramCursor.getColumnIndex("accountSecurityUri");
      if (i1 < 0) {
        break label945;
      }
    }
    label945:
    for (String str = paramCursor.getString(i1);; str = "")
    {
      K = str;
      L = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("settingsSnapshotUri")));
      M = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("vacationResponderSettingsUri")));
      N = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("driveUri")));
      O = paramCursor.getString(paramCursor.getColumnIndex("drawerAddress"));
      P = paramCursor.getString(paramCursor.getColumnIndex("providerHostname"));
      Q = paramCursor.getString(paramCursor.getColumnIndex("providerPathname"));
      R = cxa.f(paramCursor.getString(paramCursor.getColumnIndex("domainTlsPredictionUri")));
      z = new Settings(paramCursor);
      return;
      h = 0L;
      break;
    }
  }
  
  public Account(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    a = paramParcel.readString();
    b = paramParcel.readString();
    e = paramParcel.readString();
    c = paramParcel.readString();
    f = paramParcel.readInt();
    g = ((Uri)paramParcel.readParcelable(null));
    h = paramParcel.readLong();
    i = ((Uri)paramParcel.readParcelable(null));
    j = ((Uri)paramParcel.readParcelable(null));
    k = ((Uri)paramParcel.readParcelable(null));
    l = ((Uri)paramParcel.readParcelable(null));
    m = ((Uri)paramParcel.readParcelable(null));
    n = paramParcel.readString();
    o = ((Uri)paramParcel.readParcelable(null));
    p = ((Uri)paramParcel.readParcelable(null));
    q = ((Uri)paramParcel.readParcelable(null));
    r = ((Uri)paramParcel.readParcelable(null));
    s = ((Uri)paramParcel.readParcelable(null));
    t = ((Uri)paramParcel.readParcelable(null));
    u = paramParcel.readInt();
    v = ((Uri)paramParcel.readParcelable(null));
    w = paramParcel.readString();
    x = ((Uri)paramParcel.readParcelable(null));
    y = ((Uri)paramParcel.readParcelable(null));
    A = ((Uri)paramParcel.readParcelable(null));
    B = ((Uri)paramParcel.readParcelable(null));
    C = ((Uri)paramParcel.readParcelable(null));
    D = ((Uri)paramParcel.readParcelable(null));
    E = ((Uri)paramParcel.readParcelable(null));
    F = paramParcel.readInt();
    G = paramParcel.readString();
    if (TextUtils.isEmpty(G)) {
      cvm.e(T, "Unexpected empty syncAuthority from Parcel", new Object[0]);
    }
    H = ((Uri)paramParcel.readParcelable(null));
    I = paramParcel.readString();
    J = paramParcel.readInt();
    K = paramParcel.readString();
    L = ((Uri)paramParcel.readParcelable(null));
    M = ((Uri)paramParcel.readParcelable(null));
    N = ((Uri)paramParcel.readParcelable(null));
    if (paramParcel.readInt() == 0) {
      cvm.e(T, new Throwable(), "Unexpected null settings from Parcel", new Object[0]);
    }
    for (z = Settings.a;; z = ((Settings)paramParcel.readParcelable(paramClassLoader)))
    {
      d = paramParcel.readString();
      O = paramParcel.readString();
      P = paramParcel.readString();
      Q = paramParcel.readString();
      R = ((Uri)paramParcel.readParcelable(null));
      return;
    }
  }
  
  private Account(JSONObject paramJSONObject)
  {
    a = ((String)paramJSONObject.get("name"));
    e = ((String)paramJSONObject.get("type"));
    b = paramJSONObject.optString("senderName", null);
    String str = paramJSONObject.optString("accountManagerName");
    if (TextUtils.isEmpty(str)) {}
    for (c = a;; c = str)
    {
      d = paramJSONObject.optString("accountId", c);
      f = paramJSONObject.getInt("providerVersion");
      g = Uri.parse(paramJSONObject.optString("accountUri"));
      h = paramJSONObject.getLong("capabilities");
      i = cxa.f(paramJSONObject.optString("folderListUri"));
      j = cxa.f(paramJSONObject.optString("fullFolderListUri"));
      k = cxa.f(paramJSONObject.optString("allFolderListUri"));
      l = cxa.f(paramJSONObject.optString("searchUri"));
      m = cxa.f(paramJSONObject.optString("searchMessageGenericUri"));
      n = paramJSONObject.optString("accountFromAddresses", "");
      o = cxa.f(paramJSONObject.optString("expungeMessageUri"));
      p = cxa.f(paramJSONObject.optString("undoUri"));
      q = cxa.f(paramJSONObject.optString("accountSettingsIntentUri"));
      r = cxa.f(paramJSONObject.optString("helpIntentUri"));
      s = cxa.f(paramJSONObject.optString("sendFeedbackIntentUri"));
      t = cxa.f(paramJSONObject.optString("reauthenticationUri"));
      u = paramJSONObject.optInt("syncStatus");
      v = cxa.f(paramJSONObject.optString("composeUri"));
      w = paramJSONObject.optString("mimeType");
      x = cxa.f(paramJSONObject.optString("recentFolderListUri"));
      y = cxa.f(paramJSONObject.optString("defaultRecentFolderListUri"));
      A = cxa.f(paramJSONObject.optString("manualSyncUri"));
      B = cxa.f(paramJSONObject.optString("viewProxyUri"));
      C = cxa.f(paramJSONObject.optString("accountCookieUri"));
      D = cxa.f(paramJSONObject.optString("accountOAuthTokenUri"));
      E = cxa.f(paramJSONObject.optString("updateSettingsUri"));
      F = paramJSONObject.optInt("enableMessageTransforms");
      G = paramJSONObject.optString("syncAuthority");
      H = cxa.f(paramJSONObject.optString("quickResponseUri"));
      I = paramJSONObject.optString("settingsFragmentClass", "");
      J = paramJSONObject.optInt("securityHold");
      K = paramJSONObject.optString("accountSecurityUri");
      L = cxa.f(paramJSONObject.optString("settingsSnapshotUri"));
      M = cxa.f(paramJSONObject.optString("vacationResponderSettingsUri"));
      N = cxa.f(paramJSONObject.optString("driveUri"));
      O = paramJSONObject.optString("drawerAddress");
      P = paramJSONObject.optString("providerHostname");
      Q = paramJSONObject.optString("providerPathname");
      R = cxa.f(paramJSONObject.optString("domainTlsPredictionUri"));
      paramJSONObject = Settings.a(paramJSONObject.optJSONObject("settings"));
      if (paramJSONObject == null) {
        break;
      }
      z = paramJSONObject;
      return;
    }
    cvm.e(T, new Throwable(), "Unexpected null settings in Account", new Object[0]);
    z = Settings.a;
  }
  
  public static Account a(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      b();
      localObject = new Account((JSONObject)localObject);
      return (Account)localObject;
    }
    catch (JSONException localJSONException)
    {
      cvm.d(T, localJSONException, "Could not create an account from this input: \"%s\"", new Object[] { paramString });
    }
    return null;
  }
  
  public static Account[] a(ccy<Account> paramccy)
  {
    int i1 = paramccy.getCount();
    if ((i1 <= 0) || (!paramccy.moveToFirst())) {
      return new Account[0];
    }
    Account[] arrayOfAccount = new Account[i1];
    i1 = 0;
    for (;;)
    {
      arrayOfAccount[i1] = ((Account)paramccy.f());
      if (!paramccy.moveToNext()) {
        return arrayOfAccount;
      }
      i1 += 1;
    }
  }
  
  /* Error */
  public static cfw b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 422	com/android/mail/providers/Account:W	Ljava/lang/Class;
    //   6: ifnonnull +9 -> 15
    //   9: ldc_w 424
    //   12: putstatic 422	com/android/mail/providers/Account:W	Ljava/lang/Class;
    //   15: getstatic 426	com/android/mail/providers/Account:X	Lcfw;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +15 -> 35
    //   23: getstatic 422	com/android/mail/providers/Account:W	Ljava/lang/Class;
    //   26: invokevirtual 431	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: checkcast 424	cfw
    //   32: putstatic 426	com/android/mail/providers/Account:X	Lcfw;
    //   35: getstatic 426	com/android/mail/providers/Account:X	Lcfw;
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: getstatic 432	cvm:a	Ljava/lang/String;
    //   48: aload_0
    //   49: ldc_w 434
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 398	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   59: pop
    //   60: new 424	cfw
    //   63: dup
    //   64: invokespecial 435	cfw:<init>	()V
    //   67: putstatic 426	com/android/mail/providers/Account:X	Lcfw;
    //   70: goto -35 -> 35
    //   73: astore_0
    //   74: ldc 2
    //   76: monitorexit
    //   77: aload_0
    //   78: athrow
    //   79: astore_0
    //   80: goto -35 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   18	25	0	localcfw	cfw
    //   44	5	0	localInstantiationException	InstantiationException
    //   73	5	0	localObject	Object
    //   79	1	0	localIllegalAccessException	IllegalAccessException
    // Exception table:
    //   from	to	target	type
    //   23	35	44	java/lang/InstantiationException
    //   3	15	73	finally
    //   15	19	73	finally
    //   23	35	73	finally
    //   35	39	73	finally
    //   45	70	73	finally
    //   23	35	79	java/lang/IllegalAccessException
  }
  
  /* Error */
  public final String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 352	org/json/JSONObject
    //   5: dup
    //   6: invokespecial 436	org/json/JSONObject:<init>	()V
    //   9: astore_1
    //   10: aload_1
    //   11: ldc 95
    //   13: aload_0
    //   14: getfield 106	com/android/mail/providers/Account:a	Ljava/lang/String;
    //   17: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload_1
    //   22: ldc 112
    //   24: aload_0
    //   25: getfield 114	com/android/mail/providers/Account:e	Ljava/lang/String;
    //   28: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   31: pop
    //   32: aload_1
    //   33: ldc 108
    //   35: aload_0
    //   36: getfield 110	com/android/mail/providers/Account:b	Ljava/lang/String;
    //   39: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   42: pop
    //   43: aload_1
    //   44: ldc 116
    //   46: aload_0
    //   47: getfield 118	com/android/mail/providers/Account:c	Ljava/lang/String;
    //   50: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   53: pop
    //   54: aload_1
    //   55: ldc 120
    //   57: aload_0
    //   58: getfield 122	com/android/mail/providers/Account:d	Ljava/lang/String;
    //   61: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   64: pop
    //   65: aload_1
    //   66: ldc -115
    //   68: aload_0
    //   69: getfield 147	com/android/mail/providers/Account:f	I
    //   72: invokevirtual 443	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   75: pop
    //   76: aload_1
    //   77: ldc -107
    //   79: aload_0
    //   80: getfield 157	com/android/mail/providers/Account:g	Landroid/net/Uri;
    //   83: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   86: pop
    //   87: aload_1
    //   88: ldc -123
    //   90: aload_0
    //   91: getfield 139	com/android/mail/providers/Account:h	J
    //   94: invokevirtual 446	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   97: pop
    //   98: aload_1
    //   99: ldc -97
    //   101: aload_0
    //   102: getfield 161	com/android/mail/providers/Account:i	Landroid/net/Uri;
    //   105: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   108: pop
    //   109: aload_1
    //   110: ldc -93
    //   112: aload_0
    //   113: getfield 169	com/android/mail/providers/Account:j	Landroid/net/Uri;
    //   116: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   119: pop
    //   120: aload_1
    //   121: ldc -85
    //   123: aload_0
    //   124: getfield 173	com/android/mail/providers/Account:k	Landroid/net/Uri;
    //   127: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload_1
    //   132: ldc -81
    //   134: aload_0
    //   135: getfield 177	com/android/mail/providers/Account:l	Landroid/net/Uri;
    //   138: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   141: pop
    //   142: aload_1
    //   143: ldc -77
    //   145: aload_0
    //   146: getfield 181	com/android/mail/providers/Account:m	Landroid/net/Uri;
    //   149: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   152: pop
    //   153: aload_1
    //   154: ldc 124
    //   156: aload_0
    //   157: getfield 131	com/android/mail/providers/Account:n	Ljava/lang/String;
    //   160: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   163: pop
    //   164: aload_1
    //   165: ldc -73
    //   167: aload_0
    //   168: getfield 185	com/android/mail/providers/Account:o	Landroid/net/Uri;
    //   171: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   174: pop
    //   175: aload_1
    //   176: ldc -69
    //   178: aload_0
    //   179: getfield 189	com/android/mail/providers/Account:p	Landroid/net/Uri;
    //   182: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   185: pop
    //   186: aload_1
    //   187: ldc -65
    //   189: aload_0
    //   190: getfield 193	com/android/mail/providers/Account:q	Landroid/net/Uri;
    //   193: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   196: pop
    //   197: aload_1
    //   198: ldc -61
    //   200: aload_0
    //   201: getfield 197	com/android/mail/providers/Account:r	Landroid/net/Uri;
    //   204: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload_1
    //   209: ldc -57
    //   211: aload_0
    //   212: getfield 201	com/android/mail/providers/Account:s	Landroid/net/Uri;
    //   215: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   218: pop
    //   219: aload_1
    //   220: ldc -53
    //   222: aload_0
    //   223: getfield 205	com/android/mail/providers/Account:t	Landroid/net/Uri;
    //   226: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   229: pop
    //   230: aload_1
    //   231: ldc -49
    //   233: aload_0
    //   234: getfield 209	com/android/mail/providers/Account:u	I
    //   237: invokevirtual 443	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   240: pop
    //   241: aload_1
    //   242: ldc -45
    //   244: aload_0
    //   245: getfield 213	com/android/mail/providers/Account:v	Landroid/net/Uri;
    //   248: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   251: pop
    //   252: aload_1
    //   253: ldc -41
    //   255: aload_0
    //   256: getfield 217	com/android/mail/providers/Account:w	Ljava/lang/String;
    //   259: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   262: pop
    //   263: aload_1
    //   264: ldc -37
    //   266: aload_0
    //   267: getfield 221	com/android/mail/providers/Account:x	Landroid/net/Uri;
    //   270: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   273: pop
    //   274: aload_1
    //   275: ldc -33
    //   277: aload_0
    //   278: getfield 225	com/android/mail/providers/Account:y	Landroid/net/Uri;
    //   281: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   284: pop
    //   285: aload_1
    //   286: ldc -29
    //   288: aload_0
    //   289: getfield 229	com/android/mail/providers/Account:A	Landroid/net/Uri;
    //   292: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   295: pop
    //   296: aload_1
    //   297: ldc -25
    //   299: aload_0
    //   300: getfield 233	com/android/mail/providers/Account:B	Landroid/net/Uri;
    //   303: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   306: pop
    //   307: aload_1
    //   308: ldc -21
    //   310: aload_0
    //   311: getfield 237	com/android/mail/providers/Account:C	Landroid/net/Uri;
    //   314: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   317: pop
    //   318: aload_1
    //   319: ldc -17
    //   321: aload_0
    //   322: getfield 241	com/android/mail/providers/Account:D	Landroid/net/Uri;
    //   325: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   328: pop
    //   329: aload_1
    //   330: ldc -13
    //   332: aload_0
    //   333: getfield 245	com/android/mail/providers/Account:E	Landroid/net/Uri;
    //   336: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   339: pop
    //   340: aload_1
    //   341: ldc -9
    //   343: aload_0
    //   344: getfield 249	com/android/mail/providers/Account:F	I
    //   347: invokevirtual 443	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   350: pop
    //   351: aload_1
    //   352: ldc -5
    //   354: aload_0
    //   355: getfield 253	com/android/mail/providers/Account:G	Ljava/lang/String;
    //   358: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   361: pop
    //   362: aload_1
    //   363: ldc_w 268
    //   366: aload_0
    //   367: getfield 270	com/android/mail/providers/Account:H	Landroid/net/Uri;
    //   370: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   373: pop
    //   374: aload_1
    //   375: ldc_w 272
    //   378: aload_0
    //   379: getfield 274	com/android/mail/providers/Account:I	Ljava/lang/String;
    //   382: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   385: pop
    //   386: aload_1
    //   387: ldc_w 276
    //   390: aload_0
    //   391: getfield 278	com/android/mail/providers/Account:J	I
    //   394: invokevirtual 443	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload_1
    //   399: ldc_w 280
    //   402: aload_0
    //   403: getfield 282	com/android/mail/providers/Account:K	Ljava/lang/String;
    //   406: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   409: pop
    //   410: aload_1
    //   411: ldc_w 284
    //   414: aload_0
    //   415: getfield 286	com/android/mail/providers/Account:L	Landroid/net/Uri;
    //   418: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   421: pop
    //   422: aload_1
    //   423: ldc_w 288
    //   426: aload_0
    //   427: getfield 290	com/android/mail/providers/Account:M	Landroid/net/Uri;
    //   430: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   433: pop
    //   434: aload_1
    //   435: ldc_w 292
    //   438: aload_0
    //   439: getfield 294	com/android/mail/providers/Account:N	Landroid/net/Uri;
    //   442: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   445: pop
    //   446: aload_1
    //   447: ldc_w 296
    //   450: aload_0
    //   451: getfield 298	com/android/mail/providers/Account:O	Ljava/lang/String;
    //   454: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   457: pop
    //   458: aload_1
    //   459: ldc_w 300
    //   462: aload_0
    //   463: getfield 302	com/android/mail/providers/Account:P	Ljava/lang/String;
    //   466: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   469: pop
    //   470: aload_1
    //   471: ldc_w 304
    //   474: aload_0
    //   475: getfield 306	com/android/mail/providers/Account:Q	Ljava/lang/String;
    //   478: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   481: pop
    //   482: aload_1
    //   483: ldc_w 308
    //   486: aload_0
    //   487: getfield 310	com/android/mail/providers/Account:R	Landroid/net/Uri;
    //   490: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   493: pop
    //   494: aload_0
    //   495: getfield 316	com/android/mail/providers/Account:z	Lcom/android/mail/providers/Settings;
    //   498: ifnull +18 -> 516
    //   501: aload_1
    //   502: ldc_w 374
    //   505: aload_0
    //   506: getfield 316	com/android/mail/providers/Account:z	Lcom/android/mail/providers/Settings;
    //   509: invokevirtual 449	com/android/mail/providers/Settings:a	()Lorg/json/JSONObject;
    //   512: invokevirtual 440	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   515: pop
    //   516: aload_1
    //   517: invokevirtual 452	org/json/JSONObject:toString	()Ljava/lang/String;
    //   520: astore_1
    //   521: aload_0
    //   522: monitorexit
    //   523: aload_1
    //   524: areturn
    //   525: astore_2
    //   526: getstatic 78	com/android/mail/providers/Account:T	Ljava/lang/String;
    //   529: aload_2
    //   530: ldc_w 454
    //   533: iconst_1
    //   534: anewarray 4	java/lang/Object
    //   537: dup
    //   538: iconst_0
    //   539: aload_0
    //   540: getfield 106	com/android/mail/providers/Account:a	Ljava/lang/String;
    //   543: aastore
    //   544: invokestatic 456	cvm:f	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   547: pop
    //   548: goto -32 -> 516
    //   551: astore_1
    //   552: aload_0
    //   553: monitorexit
    //   554: aload_1
    //   555: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	Account
    //   9	515	1	localObject1	Object
    //   551	4	1	localObject2	Object
    //   525	5	2	localJSONException	JSONException
    // Exception table:
    //   from	to	target	type
    //   10	516	525	org/json/JSONException
    //   2	10	551	finally
    //   10	516	551	finally
    //   516	521	551	finally
    //   526	548	551	finally
  }
  
  public final boolean a(long paramLong)
  {
    return (h & paramLong) != 0L;
  }
  
  public final boolean a(Account paramAccount)
  {
    if (paramAccount == null) {}
    while ((u != u) || (!hbc.a(n, n)) || (!hbc.a(z, z))) {
      return true;
    }
    return false;
  }
  
  public final boolean b(Account paramAccount)
  {
    return (paramAccount != null) && (hbc.a(g, g));
  }
  
  public final boolean b(String paramString)
  {
    Iterator localIterator = g().iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.equals(nextb, paramString)) {
        return true;
      }
    }
    return false;
  }
  
  public final android.accounts.Account c()
  {
    if (U == null) {
      U = new android.accounts.Account(c, e);
    }
    return U;
  }
  
  public final boolean d()
  {
    return (u & 0x8) == 8;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean e()
  {
    return (u & 0x20) == 32;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (Account)paramObject;
    } while ((TextUtils.equals(a, a)) && (TextUtils.equals(b, b)) && (TextUtils.equals(c, c)) && (TextUtils.equals(d, d)) && (TextUtils.equals(e, e)) && (h == h) && (f == f) && (hbc.a(g, g)) && (hbc.a(i, i)) && (hbc.a(j, j)) && (hbc.a(k, k)) && (hbc.a(l, l)) && (hbc.a(m, m)) && (hbc.a(n, n)) && (hbc.a(o, o)) && (hbc.a(p, p)) && (hbc.a(q, q)) && (hbc.a(r, r)) && (hbc.a(s, s)) && (hbc.a(t, t)) && (u == u) && (hbc.a(v, v)) && (TextUtils.equals(w, w)) && (hbc.a(x, x)) && (hbc.a(y, y)) && (hbc.a(B, B)) && (hbc.a(C, C)) && (hbc.a(D, D)) && (hbc.a(E, E)) && (hbc.a(Integer.valueOf(F), Integer.valueOf(F))) && (hbc.a(G, G)) && (hbc.a(H, H)) && (hbc.a(I, I)) && (hbc.a(Integer.valueOf(J), Integer.valueOf(J))) && (hbc.a(K, K)) && (hbc.a(L, L)) && (hbc.a(M, M)) && (hbc.a(N, N)) && (hbc.a(z, z)) && (hbc.a(O, O)) && (TextUtils.equals(P, P)) && (TextUtils.equals(Q, Q)) && (hbc.a(R, R)));
    return false;
  }
  
  public final boolean f()
  {
    return (!e()) && (!d());
  }
  
  public final List<cha> g()
  {
    if (V == null)
    {
      V = new ArrayList();
      if (a(524288L)) {
        return V;
      }
      if (TextUtils.isEmpty(n)) {
        break label227;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONArray(n);
        int i2 = 0;
        i1 = 0;
        Object localObject2;
        int i3;
        String str1;
        String str2;
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          if (i2 < ((JSONArray)localObject1).length())
          {
            localObject2 = cha.a(this, ((JSONArray)localObject1).getJSONObject(i2));
            i3 = i1;
            if (localObject2 != null)
            {
              V.add(localObject2);
              bool = d;
              i3 = i1;
              if (bool) {
                i3 = 1;
              }
            }
            i2 += 1;
            i1 = i3;
            continue;
          }
          localObject1 = V;
          localObject2 = c;
          str1 = b;
          str2 = c;
          if (i1 != 0) {
            break label216;
          }
          bool = true;
          ((List)localObject1).add(0, new cha(this, (String)localObject2, str1, str2, bool, false));
          return V;
        }
        catch (JSONException localJSONException2)
        {
          boolean bool;
          for (;;) {}
        }
        localJSONException1 = localJSONException1;
        i1 = 0;
      }
      tmp202_199[0] = a;
      cvm.e(T, localJSONException1, "Unable to parse accountFromAddresses. name=%s", tmp202_199);
      continue;
      label216:
      bool = false;
      continue;
      label227:
      int i1 = 0;
    }
  }
  
  public final String h()
  {
    cvm.a(cvm.a, "getAccountId=%s for email %s", new Object[] { d, c });
    return d;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(new Object[] { a, b, c, e, Long.valueOf(h), Integer.valueOf(f), g, i, j, k, l, m, n, o, p, q, r, s, t, Integer.valueOf(u), v, w, x, y, B, C, D, E, Integer.valueOf(F), G, H, Integer.valueOf(J), K, L, M, N, O, P, Q, R });
  }
  
  public final String i()
  {
    if (!TextUtils.isEmpty(O)) {
      return O;
    }
    return c;
  }
  
  public String toString()
  {
    return a();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(a);
    paramParcel.writeString(b);
    paramParcel.writeString(e);
    paramParcel.writeString(c);
    paramParcel.writeInt(f);
    paramParcel.writeParcelable(g, 0);
    paramParcel.writeLong(h);
    paramParcel.writeParcelable(i, 0);
    paramParcel.writeParcelable(j, 0);
    paramParcel.writeParcelable(k, 0);
    paramParcel.writeParcelable(l, 0);
    paramParcel.writeParcelable(m, 0);
    paramParcel.writeString(n);
    paramParcel.writeParcelable(o, 0);
    paramParcel.writeParcelable(p, 0);
    paramParcel.writeParcelable(q, 0);
    paramParcel.writeParcelable(r, 0);
    paramParcel.writeParcelable(s, 0);
    paramParcel.writeParcelable(t, 0);
    paramParcel.writeInt(u);
    paramParcel.writeParcelable(v, 0);
    paramParcel.writeString(w);
    paramParcel.writeParcelable(x, 0);
    paramParcel.writeParcelable(y, 0);
    paramParcel.writeParcelable(A, 0);
    paramParcel.writeParcelable(B, 0);
    paramParcel.writeParcelable(C, 0);
    paramParcel.writeParcelable(D, 0);
    paramParcel.writeParcelable(E, 0);
    paramParcel.writeInt(F);
    paramParcel.writeString(G);
    paramParcel.writeParcelable(H, 0);
    paramParcel.writeString(I);
    paramParcel.writeInt(J);
    paramParcel.writeString(K);
    paramParcel.writeParcelable(L, 0);
    paramParcel.writeParcelable(M, 0);
    paramParcel.writeParcelable(N, 0);
    if (z == null)
    {
      cvm.e(T, "unexpected null settings object in writeToParcel", new Object[0]);
      paramParcel.writeInt(0);
    }
    for (;;)
    {
      paramParcel.writeString(d);
      paramParcel.writeString(O);
      paramParcel.writeString(P);
      paramParcel.writeString(Q);
      paramParcel.writeParcelable(R, 0);
      return;
      paramParcel.writeInt(1);
      paramParcel.writeParcelable(z, 0);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.providers.Account
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */