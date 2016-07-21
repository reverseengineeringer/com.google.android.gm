import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentQueryMap;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.DefaultDatabaseErrorHandler;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.net.Uri.Builder;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.StringSplitter;
import android.util.Pair;
import android.util.TimingLogger;
import com.android.mail.providers.Attachment;
import com.android.mail.providers.Conversation;
import com.android.mail.providers.Folder;
import com.google.android.gm.ConversationInfo;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.MailIndexerService;
import com.google.android.gm.provider.MailProvider;
import com.google.android.gm.provider.PublicContentProvider;
import com.google.android.gm.provider.SearchQuery;
import com.google.android.gm.provider.uiprovider.GmailAttachment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.herrevad.NetworkQualityReport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HttpContext;

public final class drp
  implements cgf, dpe
{
  public static final Set<Thread> Q;
  public static final Map<String, dsr> R;
  static final Map<String, String> T;
  static final Map<String, String> U;
  static boolean V;
  private static long aB;
  private static final Object aC;
  private static Handler aD;
  private static final String[][] aF;
  private static cws aG;
  static long ab = 1L;
  public static dso ac = null;
  private static final String[] ag;
  private static final String[] ah;
  private static final String[] ai;
  private static final String[] aj;
  private static final String[] ak;
  private static dsq al;
  private static dtb am;
  private static HandlerThread ax;
  public static final String b = cvl.a;
  static final String[] c = { "conversation_fts_table", "message_fts_table" };
  static final String[] d = { "toAddresses", "ccAddresses", "bccAddresses" };
  static final String[] e = { "fromAddress" };
  static final String[] f;
  public final dqv A;
  volatile boolean B;
  boolean C = false;
  List<Pair<Handler, dss>> D;
  final Object E = new Object();
  volatile boolean F;
  final Object G = new Object();
  long H = 0L;
  boolean I = false;
  public final Object J = new Object();
  public Thread K = null;
  public int L = 0;
  public final Runnable M = new drz(this);
  public final int N;
  final int O;
  public volatile boolean P = false;
  PowerManager.WakeLock S = null;
  public final Handler W;
  public dqc X = null;
  String Y = null;
  String Z = null;
  dqu a;
  private final long aA;
  private final Map<String, Long> aE = new HashMap();
  private final PendingIntent aH;
  private boolean aI = false;
  private volatile boolean aJ = false;
  private final Object aK = new Object();
  dsn aa = null;
  final Map<Long, dsw> ad = new HashMap();
  final Object ae = new Object();
  public boolean af;
  private final ddy an;
  private final dve ao;
  private final BitSet ap = new BitSet();
  private dsq aq;
  private dqk ar;
  private final Object as = new Object();
  private dvd at;
  private int au = 0;
  private long av = SystemClock.elapsedRealtime();
  private final Observer aw = new drq(this);
  private final dsp ay;
  private final long az;
  public final Object g = new Object();
  public volatile boolean h = false;
  public Thread i = null;
  boolean j = false;
  public final Context k;
  public android.accounts.Account l;
  public dtn m;
  public duf n;
  public drj o;
  public SQLiteDatabase p;
  public SQLiteDatabase q;
  public final duy r;
  public final Object s = new Object();
  final Object t = new Object();
  public volatile int u = 0;
  public dth v;
  public final dpa w;
  final dtb x;
  final Map<Long, Boolean> y = new ConcurrentHashMap();
  public final CookieStore z;
  
  static
  {
    ag = new String[] { "messageId", "conversation" };
    ah = new String[] { "value" };
    ai = new String[] { "synced" };
    f = new String[] { "event_id" };
    aj = new String[] { "SELECTION_ARGUMENT_DO_NOT_BECOME_ACTIVE_NETWORK_CURSOR" };
    ak = new String[] { "^^cached", "^^out", "^imi", "^imn", "^im", "^io_ns", "^^important", "^^unimportant", "^^sending", "^^failed" };
    aB = 0L;
    aC = new Object();
    Q = new HashSet();
    R = new HashMap();
    aD = null;
    Object localObject = { "conversation", "messages.conversation" };
    String[] arrayOfString1 = { "body", "CASE WHEN bodyCompressed IS NULL THEN '0' || messages.body ELSE '1' || bodyCompressed END" };
    String[] arrayOfString2 = { "isLateReclassified", "SUM(CASE labels.canonicalName WHEN '^lcs' THEN 1 ELSE 0 END)" };
    aF = new String[][] { { "clientCreated" }, { "synced" }, { "queryId" }, { "_id", "messages._id" }, localObject, { "subject", "messages.subject" }, { "snippet", "messages.snippet" }, { "fromAddress", "messages.fromAddress" }, { "toAddresses", "messages.toAddresses" }, { "ccAddresses", "messages.ccAddresses" }, { "bccAddresses", "messages.bccAddresses" }, arrayOfString1, { "stylesheet", "messages.stylesheet" }, { "stylesheetRestrictor", "messages.stylesheetRestrictor" }, { "labelIds", "group_concat(labels_id, ' ')" }, { "labelCount", "COUNT(*)" }, { "messageLabels", "group_concat((labels._id || '^*^' || labels.canonicalName || '^*^' || (CASE labels.canonicalName  WHEN '^f' THEN ?  WHEN '^^out' THEN ?  WHEN '^i' THEN ?  WHEN '^r' THEN ?  WHEN '^b' THEN ?  WHEN '^all' THEN ?  WHEN '^u' THEN ?  WHEN '^k' THEN ?  WHEN '^s' THEN ?  WHEN '^t' THEN ?  WHEN '^g' THEN ?  WHEN '^io_im' THEN ?  WHEN '^iim' THEN ?  WHEN '^sq_ig_i_personal' THEN ?  WHEN '^sq_ig_i_social' THEN ?  WHEN '^sq_ig_i_promo' THEN ?  WHEN '^sq_ig_i_notification' THEN ?  WHEN '^sq_ig_i_group' THEN ?  ELSE labels.name END)  || '^*^' || labels.color || '^*^' || labels.hidden), '^**^')" }, { "isStarred", "SUM(CASE labels.canonicalName WHEN '^t' THEN 1 ELSE 0 END)" }, { "isDraft", "SUM(CASE labels.canonicalName WHEN '^r' THEN 1 ELSE 0 END)" }, { "isInOutbox", "SUM(CASE labels.canonicalName WHEN '^^out' THEN 1 ELSE 0 END)" }, { "isInSending", "SUM(CASE labels.canonicalName WHEN '^^sending' THEN 1 ELSE 0 END)" }, { "isInFailed", "SUM(CASE labels.canonicalName WHEN '^^failed' THEN 1 ELSE 0 END)" }, { "isUnread", "SUM(CASE labels.canonicalName WHEN '^u' THEN 1 ELSE 0 END)" }, { "isSenderUnsubscribed", "SUM(CASE WHEN unsubscribed_senders.senderIdentifier IS NULL THEN 0 ELSE 1 END)" }, { "showUnauthWarning", "SUM(CASE labels.canonicalName WHEN '^sua' THEN 1 ELSE 0 END)" }, arrayOfString2 };
    T = dulasaaFa;
    U = dulata"name""(CASE labels.canonicalName  WHEN '^f' THEN ?  WHEN '^^out' THEN ?  WHEN '^i' THEN ?  WHEN '^r' THEN ?  WHEN '^b' THEN ?  WHEN '^all' THEN ?  WHEN '^u' THEN ?  WHEN '^k' THEN ?  WHEN '^s' THEN ?  WHEN '^t' THEN ?  WHEN '^g' THEN ?  WHEN '^io_im' THEN ?  WHEN '^iim' THEN ?  WHEN '^sq_ig_i_personal' THEN ?  WHEN '^sq_ig_i_social' THEN ?  WHEN '^sq_ig_i_promo' THEN ?  WHEN '^sq_ig_i_notification' THEN ?  WHEN '^sq_ig_i_group' THEN ?  ELSE labels.name END) "a"sortOrder""CASE labels.systemLabel WHEN 0 THEN labels.canonicalName ELSE labels.systemLabelOrder END"a;
    V = false;
    localObject = new dsa();
    aG = (cws)localObject;
    cwr.a((cws)localObject);
  }
  
  private drp(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = new HandlerThread("Background tasks", 10);
    ((HandlerThread)localObject).start();
    dmt.a();
    W = new Handler(((HandlerThread)localObject).getLooper());
    for (;;)
    {
      try
      {
        k = paramContext;
        an = new ddy(paramContext);
        l = new android.accounts.Account(paramString1, "com.google");
        at = new dvd(paramContext, new dor(paramContext, l));
        localObject = k;
        String str = g(paramString2);
        dmt.a();
        q = ((Context)localObject).openOrCreateDatabase(str, 0, null, new DefaultDatabaseErrorHandler());
        q.beginTransactionNonExclusive();
        int i1;
        try
        {
          i1 = q.getVersion();
          localObject = new dqy(this);
          if (i1 == 0)
          {
            ((dpv)localObject).a();
            if (q.getVersion() == 2) {
              break;
            }
            throw new IllegalStateException(69 + "Failed to upgrade internal db from version " + i1 + " to 2");
          }
        }
        finally
        {
          q.endTransaction();
        }
        if (i1 == 2) {
          continue;
        }
      }
      catch (SQLException paramContext)
      {
        if (p != null) {
          p.close();
        }
        if (q != null) {
          q.close();
        }
        if (ar != null) {
          ar.a.close();
        }
        throw paramContext;
      }
      ((dpv)localObject).a(2);
    }
    q.setTransactionSuccessful();
    q.endTransaction();
    dmt.b();
    localObject = k;
    paramString2 = f(paramString2);
    dmt.a();
    paramString2 = new dsv(this, (Context)localObject, paramString2);
    p = paramString2.getWritableDatabase();
    dmt.b();
    r = new duy(p);
    r.a();
    A = new dqv(paramContext, this, paramString1);
    for (;;)
    {
      try
      {
        O();
        r.c();
        r.d();
        paramString2 = paramString2.a(p);
        if (b.isReadOnly())
        {
          dri.e(b, "Trying to setup search with read-only database reference", new Object[0]);
          z = new BasicCookieStore();
          if (al != null) {
            break label1167;
          }
          aq = new dta();
          if (am != null) {
            break label1177;
          }
          x = dmv.j(k);
          a(new dsf(this, paramContext));
          a(new dsi(this, paramContext));
          w = new dpa(k, l, p, at, this, o);
          if (bgr.b(k)) {
            break label1203;
          }
        }
        bool1 = bgr.b(a.k);
      }
      finally
      {
        try
        {
          paramContext = new Intent(k, MailIndexerService.class);
          paramContext.setAction("com.google.android.gm.intent.provider.INDEX_MESSAGE_CONTENT");
          paramContext.setData(dpy.a(paramString1).buildUpon().appendPath("indexer").build());
          paramContext.putExtra("account", paramString1);
          paramContext = PendingIntent.getService(k, 0, paramContext, 134217728);
          aH = paramContext;
          paramContext = k.getResources();
          ay = new dsp(k, l, paramContext.getInteger(dfz.h));
          ao = new dve(o);
          ao.a();
          N = paramContext.getInteger(dfz.f);
          O = (paramContext.getInteger(dfz.g) * 1000 / N);
          az = ghz.a(k.getContentResolver(), "gmail_min_time_per_reporting_window_start_millis", 8640000L);
          aA = ghz.a(k.getContentResolver(), "gmail_latency_reporting_window_millis", 900000L);
          return;
        }
        catch (UnsupportedOperationException paramContext)
        {
          boolean bool1;
          boolean bool2;
          dri.e(b, paramContext, "UOE while creating pending intent.  Probably running tests", new Object[0]);
        }
        paramContext = finally;
        r.d();
      }
      bool2 = paramString2.b();
      a.d(true);
      if ((!bool1) || (!bool2)) {}
      for (;;)
      {
        try
        {
          dri.c(b, "Setting up for AppDataSearch", new Object[0]);
          MailIndexerService.a(b);
          paramString2.d();
          paramString2.a(true);
          a.r.c();
          a.r.d();
          break;
        }
        finally
        {
          a.r.d();
        }
        if (bool2)
        {
          dri.c(b, "Setting up for FTS search", new Object[0]);
          paramString2.c();
          MailIndexerService.b(b);
          paramString2.a(false);
        }
        else
        {
          MailIndexerService.c(b);
        }
      }
      label1167:
      aq = al;
      continue;
      label1177:
      x = am;
      continue;
      label1203:
      paramContext = null;
    }
  }
  
  static Looper L()
  {
    try
    {
      if (ax == null)
      {
        localObject1 = new HandlerThread("Dataset changed notifier", 10);
        ax = (HandlerThread)localObject1;
        ((HandlerThread)localObject1).start();
      }
      Object localObject1 = ax.getLooper();
      return (Looper)localObject1;
    }
    finally {}
  }
  
  private static Handler N()
  {
    try
    {
      if (aD == null)
      {
        localObject1 = new HandlerThread("MailEngine creation");
        ((HandlerThread)localObject1).start();
        aD = new Handler(((HandlerThread)localObject1).getLooper());
      }
      Object localObject1 = aD;
      return (Handler)localObject1;
    }
    finally {}
  }
  
  /* Error */
  private final void O()
  {
    // Byte code:
    //   0: invokestatic 478	dmt:a	()V
    //   3: new 844	drr
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 845	drr:<init>	(Ldrp;)V
    //   11: astore_1
    //   12: aload_0
    //   13: new 847	duf
    //   16: dup
    //   17: aload_0
    //   18: getfield 491	drp:k	Landroid/content/Context;
    //   21: aload_0
    //   22: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   25: invokespecial 850	duf:<init>	(Landroid/content/Context;Landroid/database/sqlite/SQLiteDatabase;)V
    //   28: putfield 852	drp:n	Lduf;
    //   31: aload_0
    //   32: new 854	drj
    //   35: dup
    //   36: aload_0
    //   37: getfield 491	drp:k	Landroid/content/Context;
    //   40: aload_0
    //   41: getfield 507	drp:l	Landroid/accounts/Account;
    //   44: aload_0
    //   45: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   48: aload_0
    //   49: getfield 852	drp:n	Lduf;
    //   52: aload_1
    //   53: invokespecial 857	drj:<init>	(Landroid/content/Context;Landroid/accounts/Account;Landroid/database/sqlite/SQLiteDatabase;Lduf;Ldrl;)V
    //   56: putfield 684	drp:o	Ldrj;
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 684	drp:o	Ldrj;
    //   64: getfield 859	drj:i	Ldqc;
    //   67: putfield 450	drp:X	Ldqc;
    //   70: aload_0
    //   71: getfield 450	drp:X	Ldqc;
    //   74: aload_0
    //   75: getfield 433	drp:aw	Ljava/util/Observer;
    //   78: invokevirtual 865	dqc:addObserver	(Ljava/util/Observer;)V
    //   81: aload_0
    //   82: new 867	dtc
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 868	dtc:<init>	(Ldrp;)V
    //   90: putfield 870	drp:v	Ldth;
    //   93: new 228	java/util/HashMap
    //   96: dup
    //   97: invokespecial 229	java/util/HashMap:<init>	()V
    //   100: astore_3
    //   101: aload_0
    //   102: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   105: ldc_w 872
    //   108: iconst_2
    //   109: anewarray 152	java/lang/String
    //   112: dup
    //   113: iconst_0
    //   114: ldc_w 343
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: ldc -78
    //   122: aastore
    //   123: aconst_null
    //   124: aconst_null
    //   125: aconst_null
    //   126: aconst_null
    //   127: aconst_null
    //   128: invokevirtual 876	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   131: astore_2
    //   132: aload_2
    //   133: invokeinterface 881 1 0
    //   138: ifeq +36 -> 174
    //   141: aload_3
    //   142: aload_2
    //   143: iconst_0
    //   144: invokeinterface 885 2 0
    //   149: aload_2
    //   150: iconst_1
    //   151: invokeinterface 885 2 0
    //   156: invokeinterface 891 3 0
    //   161: pop
    //   162: goto -30 -> 132
    //   165: astore_1
    //   166: aload_2
    //   167: invokeinterface 892 1 0
    //   172: aload_1
    //   173: athrow
    //   174: aload_2
    //   175: invokeinterface 892 1 0
    //   180: aload_0
    //   181: getfield 533	drp:q	Landroid/database/sqlite/SQLiteDatabase;
    //   184: invokevirtual 538	android/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   187: aload_0
    //   188: getfield 533	drp:q	Landroid/database/sqlite/SQLiteDatabase;
    //   191: ldc_w 894
    //   194: iconst_2
    //   195: anewarray 152	java/lang/String
    //   198: dup
    //   199: iconst_0
    //   200: ldc_w 343
    //   203: aastore
    //   204: dup
    //   205: iconst_1
    //   206: ldc -78
    //   208: aastore
    //   209: aconst_null
    //   210: aconst_null
    //   211: aconst_null
    //   212: aconst_null
    //   213: aconst_null
    //   214: invokevirtual 876	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   217: astore_1
    //   218: aload_1
    //   219: invokeinterface 881 1 0
    //   224: ifeq +47 -> 271
    //   227: aload_3
    //   228: aload_1
    //   229: iconst_0
    //   230: invokeinterface 885 2 0
    //   235: aload_1
    //   236: iconst_1
    //   237: invokeinterface 885 2 0
    //   242: invokeinterface 891 3 0
    //   247: pop
    //   248: goto -30 -> 218
    //   251: astore_3
    //   252: aload_1
    //   253: astore_2
    //   254: aload_3
    //   255: astore_1
    //   256: aload_2
    //   257: invokeinterface 892 1 0
    //   262: aload_0
    //   263: getfield 533	drp:q	Landroid/database/sqlite/SQLiteDatabase;
    //   266: invokevirtual 576	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   269: aload_1
    //   270: athrow
    //   271: aload_0
    //   272: getfield 533	drp:q	Landroid/database/sqlite/SQLiteDatabase;
    //   275: invokevirtual 596	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   278: aload_1
    //   279: invokeinterface 892 1 0
    //   284: aload_0
    //   285: getfield 533	drp:q	Landroid/database/sqlite/SQLiteDatabase;
    //   288: invokevirtual 576	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   291: aload_0
    //   292: new 896	dtn
    //   295: dup
    //   296: aload_0
    //   297: getfield 870	drp:v	Ldth;
    //   300: aload_0
    //   301: getfield 519	drp:at	Ldvd;
    //   304: aload_3
    //   305: aload_0
    //   306: getfield 491	drp:k	Landroid/content/Context;
    //   309: aload_0
    //   310: getfield 384	drp:j	Z
    //   313: invokespecial 899	dtn:<init>	(Ldth;Ldvd;Ljava/util/Map;Landroid/content/Context;Z)V
    //   316: putfield 901	drp:m	Ldtn;
    //   319: aload_0
    //   320: getfield 684	drp:o	Ldrj;
    //   323: aload_0
    //   324: getfield 901	drp:m	Ldtn;
    //   327: ldc_w 903
    //   330: invokevirtual 906	dtn:a	(Ljava/lang/String;)J
    //   333: putfield 908	drj:d	J
    //   336: aload_0
    //   337: invokevirtual 910	drp:m	()V
    //   340: aload_0
    //   341: getfield 901	drp:m	Ldtn;
    //   344: invokevirtual 912	dtn:g	()V
    //   347: invokestatic 598	dmt:b	()V
    //   350: return
    //   351: astore_1
    //   352: goto -96 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	drp
    //   11	42	1	localdrr	drr
    //   165	8	1	localObject1	Object
    //   217	62	1	localObject2	Object
    //   351	1	1	localObject3	Object
    //   131	126	2	localObject4	Object
    //   100	128	3	localHashMap	HashMap
    //   251	54	3	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   132	162	165	finally
    //   218	248	251	finally
    //   271	278	251	finally
    //   187	218	351	finally
  }
  
  private final boolean P()
  {
    synchronized (aC)
    {
      long l1 = SystemClock.elapsedRealtime();
      if (l1 > aB + az)
      {
        aB = l1;
        return true;
      }
      if (l1 < aB + aA) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean Q()
  {
    ConditionVariable localConditionVariable = new ConditionVariable();
    a(N(), new drs(this, localConditionVariable));
    return localConditionVariable.block(10000L);
  }
  
  private final Bundle a(long paramLong1, long paramLong2, boolean paramBoolean, TimingLogger paramTimingLogger)
  {
    Object localObject;
    int i1;
    label47:
    int i2;
    label62:
    int i3;
    label78:
    int i4;
    if (paramBoolean)
    {
      localObject = "messageSaved";
      l(paramLong1);
      paramTimingLogger.addSplit("delete operations");
      ContentResolver localContentResolver = k.getContentResolver();
      if (ghz.a(localContentResolver, "gmail_send_immediately", 1) == 0) {
        break label222;
      }
      i1 = 1;
      if (ghz.a(localContentResolver, "gmail_send_without_sync", 1) == 0) {
        break label228;
      }
      i2 = 1;
      if ((!ContentResolver.getMasterSyncAutomatically()) || (!j())) {
        break label234;
      }
      i3 = 1;
      if ((paramBoolean) || (i1 == 0) || (i2 == 0) || (i3 != 0)) {
        break label240;
      }
      i4 = 1;
      label101:
      if (i4 == 0) {
        break label246;
      }
      localObject = new dug((String)localObject, paramLong1, paramLong2);
      n.a((dug)localObject);
    }
    for (;;)
    {
      paramTimingLogger.addSplit("update operations");
      if ((paramBoolean) || (i1 == 0)) {
        break label261;
      }
      paramTimingLogger = new Bundle();
      paramTimingLogger.putBoolean("expedited", true);
      if ((i2 != 0) && (i3 == 0))
      {
        paramTimingLogger.putBoolean("force", true);
        paramTimingLogger.putBoolean("sendwithoutsync", true);
        paramTimingLogger.putLong("sendwithoutsyncMessageId", paramLong1);
        paramTimingLogger.putLong("sendwithoutsyncConversationId", paramLong2);
      }
      return paramTimingLogger;
      localObject = "messageSent";
      break;
      label222:
      i1 = 0;
      break label47;
      label228:
      i2 = 0;
      break label62;
      label234:
      i3 = 0;
      break label78;
      label240:
      i4 = 0;
      break label101;
      label246:
      n.a(paramLong2, paramLong1, (String)localObject);
    }
    label261:
    return null;
  }
  
  public static ParcelFileDescriptor a(GmailAttachment paramGmailAttachment)
  {
    Object localObject2 = null;
    Object localObject1;
    if (!TextUtils.isEmpty(v)) {
      localObject1 = v;
    }
    long l1;
    while (localObject1 != null)
    {
      paramGmailAttachment = dpa.a((String)localObject1);
      l1 = Binder.clearCallingIdentity();
      try
      {
        dri.b(b, "Opening attachment %s", new Object[] { paramGmailAttachment });
        paramGmailAttachment = ParcelFileDescriptor.open(new File(paramGmailAttachment), 268435456);
        return paramGmailAttachment;
      }
      finally
      {
        Binder.restoreCallingIdentity(l1);
      }
      localObject1 = localObject2;
      if (r == 1)
      {
        localObject1 = localObject2;
        if (!cxa.b(i)) {
          localObject1 = i.toString();
        }
      }
    }
    throw new FileNotFoundException("Missing local attachment.");
  }
  
  public static drp a(Context paramContext, String paramString)
  {
    i2 = 0;
    int i3 = 0;
    int i5 = 0;
    int i4 = 0;
    dri.b(b, "getOrMakeMailEngine for %s", new Object[] { dri.a(paramString) });
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    Context localContext = paramContext.getApplicationContext();
    paramContext = deg.a(localContext);
    i1 = i5;
    try
    {
      String str = paramContext.a(paramString);
      i1 = i5;
      Object localObject1 = (dsr)R.get(str);
      Object localObject2;
      if (localObject1 == null)
      {
        i1 = i5;
        localObject2 = R;
        i1 = i5;
        i2 = i3;
      }
      for (;;)
      {
        try
        {
          localObject1 = (dsr)R.get(str);
          paramContext = (Context)localObject1;
          i1 = i4;
          if (localObject1 == null)
          {
            i2 = i3;
            paramContext = new dsr();
            i2 = i3;
            R.put(str, paramContext);
            i1 = 1;
          }
          i2 = i1;
          R.put(paramString, paramContext);
          i2 = i1;
          localObject1 = paramContext;
          i2 = i1;
          i1 = i2;
          localObject2 = a;
          paramContext = (Context)localObject2;
          if (localObject2 == null)
          {
            i1 = i2;
            localObject3 = b;
            i1 = i2;
          }
          paramContext = finally;
        }
        finally
        {
          try
          {
            localObject2 = a;
            paramContext = (Context)localObject2;
            if (localObject2 == null)
            {
              paramString = new drp(localContext, paramString, str);
              a = paramString;
              paramContext = paramString;
              if (m.a("clientId") == 0L)
              {
                paramString.k();
                paramContext = paramString;
              }
            }
            return paramContext;
          }
          finally
          {
            Object localObject3;
            i1 = i2;
          }
          paramContext = finally;
          i1 = i2;
        }
      }
    }
    finally
    {
      if (i1 != 0) {
        GmailProvider.a(localContext);
      }
    }
  }
  
  public static drp a(String paramString)
  {
    synchronized (R)
    {
      paramString = (dsr)R.get(paramString);
      if (paramString == null)
      {
        paramString = null;
        return paramString;
      }
      paramString = a;
    }
  }
  
  private final Integer a(String paramString, Integer paramInteger)
  {
    paramString = h(paramString);
    try
    {
      boolean bool = paramString.moveToNext();
      if (!bool) {
        return paramInteger;
      }
      int i1 = paramString.getInt(paramString.getColumnIndexOrThrow("value"));
      return Integer.valueOf(i1);
    }
    finally
    {
      paramString.close();
    }
  }
  
  private final Long a(String paramString, Long paramLong)
  {
    paramString = h(paramString);
    try
    {
      boolean bool = paramString.moveToNext();
      if (!bool) {
        return paramLong;
      }
      long l1 = paramString.getLong(paramString.getColumnIndexOrThrow("value"));
      return Long.valueOf(l1);
    }
    finally
    {
      paramString.close();
    }
  }
  
  private static String a(Cursor paramCursor, String paramString)
  {
    paramCursor = paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString));
    if (paramCursor != null) {
      return paramCursor;
    }
    return "";
  }
  
  public static List<drp> a(Context paramContext, android.accounts.Account[] paramArrayOfAccount)
  {
    paramContext = deg.a(paramContext);
    synchronized (R)
    {
      localObject3 = hfd.a(R.values());
      ??? = new hfe();
      if (paramArrayOfAccount != null)
      {
        int i2 = paramArrayOfAccount.length;
        i1 = 0;
        if (i1 < i2)
        {
          localObject2 = paramArrayOfAccount[i1];
          if ((localObject2 != null) && (!TextUtils.isEmpty(name)))
          {
            dri.b(dri.a, "getMailEngines from valid account: %s", new Object[] { name });
            ((hfe)???).c(paramContext.a(name));
          }
          i1 += 1;
        }
      }
    }
    Object localObject2 = ((hfe)???).a();
    ??? = new ArrayList();
    Object localObject3 = ((Set)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (dsr)((Iterator)localObject3).next();
      synchronized (b)
      {
        localObject4 = a;
        if (localObject4 != null)
        {
          ??? = l.name;
          String str1 = paramContext.b((String)???);
          String str2 = paramContext.a((String)???);
          dri.b(dri.a, "getMailEngines check engine name: %s %s", new Object[] { ???, str1 });
          if (!((String)???).equals(str1)) {
            ((drp)localObject4).b(str1);
          }
          if (((Set)localObject2).contains(str2)) {
            ((List)???).add(localObject4);
          }
        }
      }
    }
    paramContext = new String[paramArrayOfAccount.length];
    int i1 = 0;
    while (i1 < paramArrayOfAccount.length)
    {
      paramContext[i1] = name;
      i1 += 1;
    }
    Collections.sort((List)???, new cwn(paramContext, new dsb()));
    return (List<drp>)???;
  }
  
  private final HttpResponse a(HttpUriRequest paramHttpUriRequest, boolean paramBoolean)
  {
    String str = "gx";
    boolean bool;
    if (paramBoolean)
    {
      localObject1 = "sync_second_try";
      bool = dms.a(o);
      if (!bool) {
        break label199;
      }
      str = "oauth2";
    }
    long l2;
    long l1;
    long l3;
    for (Object localObject2 = str;; localObject2 = localObject4)
    {
      try
      {
        localObject3 = ddy.a(null, z);
        localObject2 = str;
        localObject4 = an.a(l, dms.a(k), "MailEngine");
        localObject2 = str;
        paramHttpUriRequest.setHeader("Authorization", cwh.a((String)localObject4));
        localObject2 = localObject4;
        l2 = 0L;
        l1 = l2;
        if ((paramHttpUriRequest instanceof HttpEntityEnclosingRequestBase))
        {
          localObject4 = ((HttpEntityEnclosingRequestBase)paramHttpUriRequest).getEntity();
          l1 = l2;
          if (localObject4 != null) {
            l1 = ((HttpEntity)localObject4).getContentLength();
          }
        }
        l2 = SystemClock.elapsedRealtime();
        paramHttpUriRequest = aq.a(p(), paramHttpUriRequest, (HttpContext)localObject3);
        l3 = SystemClock.elapsedRealtime();
        if (!aJ) {
          break label317;
        }
        a(paramHttpUriRequest);
        aJ = false;
        throw new IOException("Fake io exception");
      }
      catch (dsj localdsj)
      {
        Object localObject4;
        label199:
        Object localObject3 = buo.a();
        paramHttpUriRequest = String.valueOf(localObject2);
        if (paramHttpUriRequest.length() == 0) {
          break label303;
        }
        for (paramHttpUriRequest = "fail_".concat(paramHttpUriRequest);; paramHttpUriRequest = new String("fail_"))
        {
          ((but)localObject3).a("gmail_auth", (String)localObject1, paramHttpUriRequest, 0L);
          dri.c(b, "Authentication exception, secondTry=%b", new Object[] { Boolean.valueOf(paramBoolean) });
          throw localdsj;
        }
        if (!ddy.a(paramHttpUriRequest.getStatusLine().getStatusCode())) {
          break label416;
        }
        dri.c(b, "Response has an authentication error, secondTry=%b", new Object[] { Boolean.valueOf(paramBoolean) });
        a(paramHttpUriRequest);
        AccountManager.get(k).invalidateAuthToken("com.google", (String)localObject2);
        if (bool) {
          break label388;
        }
        z.clear();
        buo.a().a("gmail_auth", "sync_invalidate", localdsj, 0L);
        throw new dsj("authtoken is invalid");
        if (grz.a(paramHttpUriRequest.getStatusLine().getStatusCode())) {
          break label477;
        }
        dri.d(b, "Response returned statusCode=%d during=%s authentication=%b", new Object[] { Integer.valueOf(paramHttpUriRequest.getStatusLine().getStatusCode()), localObject1, Boolean.valueOf(bool) });
        localObject2 = buo.a();
        i1 = paramHttpUriRequest.getStatusLine().getStatusCode();
        ((but)localObject2).a("gmail_auth", (String)localObject1, String.valueOf(localdsj).length() + 19 + "status_" + i1 + "_" + localdsj, 0L);
        if (bhk.a()) {
          break label655;
        }
      }
      localObject1 = "sync_first_try";
      break;
      localObject2 = str;
      localObject4 = a("mail", "MailEngine");
      localObject2 = str;
      localObject3 = ddy.a((String)localObject4, z);
    }
    label303:
    label317:
    label388:
    label416:
    label477:
    int i1 = 0;
    Object localObject1 = k.getContentResolver();
    int i4 = ghz.a((ContentResolver)localObject1, "gmail_max_bytes_for_latency_report", 1000);
    int i2 = ghz.a((ContentResolver)localObject1, "gmail_min_bytes_for_upload_report", 10000);
    int i3 = (int)((l3 - l2) * 1000L);
    localObject1 = new NetworkQualityReport();
    e = l1;
    if (l1 <= i4)
    {
      b = i3;
      if (P()) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0) {
        a((NetworkQualityReport)localObject1);
      }
      label655:
      return paramHttpUriRequest;
      if (l1 >= i2)
      {
        c = i3;
        i1 = 1;
      }
    }
  }
  
  private final void a(long paramLong, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    o.k.a(paramLong, paramInt, paramBoolean1, paramBoolean2);
    if (!paramBoolean3) {
      A.a(paramLong);
    }
  }
  
  static void a(ContentValues paramContentValues, String paramString, ContentResolver paramContentResolver)
  {
    List localList = GmailAttachment.a(paramContentValues.getAsString("joinedAttachmentInfos"), paramContentResolver);
    Object localObject = GmailAttachment.a(paramString, paramContentResolver);
    paramContentResolver = new HashMap();
    localObject = ((List)localObject).iterator();
    GmailAttachment localGmailAttachment1;
    while (((Iterator)localObject).hasNext())
    {
      localGmailAttachment1 = (GmailAttachment)((Iterator)localObject).next();
      if ((localGmailAttachment1 != null) && (!TextUtils.isEmpty(v))) {
        paramContentResolver.put(Integer.valueOf(Arrays.hashCode(new Object[] { c, localGmailAttachment1.l(), Integer.valueOf(d) })), localGmailAttachment1);
      }
    }
    localObject = localList.iterator();
    int i1 = 0;
    if (((Iterator)localObject).hasNext())
    {
      localGmailAttachment1 = (GmailAttachment)((Iterator)localObject).next();
      if (localGmailAttachment1 == null) {
        break label271;
      }
      GmailAttachment localGmailAttachment2 = (GmailAttachment)paramContentResolver.get(Integer.valueOf(Arrays.hashCode(new Object[] { c, localGmailAttachment1.l(), Integer.valueOf(d) })));
      if (localGmailAttachment2 == null) {
        break label271;
      }
      v = v;
      i1 = 1;
    }
    label271:
    for (;;)
    {
      break;
      if (i1 != 0)
      {
        paramContentResolver = GmailAttachment.a(localList);
        paramContentValues.put("joinedAttachmentInfos", paramContentResolver);
        dri.b(b, "Updated attachments string from %s to %s", new Object[] { paramString, paramContentResolver });
      }
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, dst paramdst)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("account is empty");
    }
    Handler localHandler = N();
    localHandler.post(new dsc(paramContext, paramString, localHandler, new Handler(), paramdst));
  }
  
  static void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", paramString1);
    localContentValues.put("value", paramString2);
    paramSQLiteDatabase.replace("sync_settings", null, localContentValues);
  }
  
  private final void a(Bundle paramBundle)
  {
    ContentResolver.requestSync(l, "gmail-ls", paramBundle);
  }
  
  private final void a(NetworkQualityReport paramNetworkQualityReport)
  {
    Object localObject = null;
    try
    {
      eiz localeiz = new eja(getContext()).a(flk.c).a();
      localObject = localeiz;
      if (localeiz.a(2L, TimeUnit.SECONDS).b())
      {
        localObject = localeiz;
        flk.d.a(localeiz, paramNetworkQualityReport).a(2L, TimeUnit.SECONDS);
      }
      if (localeiz != null) {
        localeiz.d();
      }
      return;
    }
    finally
    {
      if (localObject != null) {
        ((eiz)localObject).d();
      }
    }
  }
  
  private final void a(Exception paramException)
  {
    buo.a().a("sync", "run_sync_loop_exception", dyu.a(paramException), 0L);
    paramException = o.a();
    if (paramException != null)
    {
      r.a(A);
      try
      {
        paramException = paramException.iterator();
        while (paramException.hasNext()) {
          h(((Long)paramException.next()).longValue());
        }
      }
      finally
      {
        r.d();
      }
      r.d();
    }
  }
  
  static void a(String paramString, ContentResolver paramContentResolver)
  {
    paramString = GmailAttachment.a(paramString, paramContentResolver).iterator();
    while (paramString.hasNext())
    {
      paramContentResolver = (GmailAttachment)paramString.next();
      if (!hbw.b(v))
      {
        dri.b(b, "Cleaning up cached attachment: %s", new Object[] { v });
        new File(v).delete();
      }
    }
  }
  
  static void a(HttpResponse paramHttpResponse)
  {
    paramHttpResponse = paramHttpResponse.getEntity();
    if (paramHttpResponse != null) {
      paramHttpResponse.consumeContent();
    }
  }
  
  private final boolean a(dtd paramdtd, dsu paramdsu, ArrayList<dtq> paramArrayList)
  {
    Object localObject = m.a(paramdtd, new ArrayList());
    if ((localObject != null) && (a != null)) {}
    for (boolean bool1 = a(a, paramdsu, paramdtd);; bool1 = false)
    {
      int i2 = paramArrayList.size();
      dri.c(b, "Fetching conversations one by one: %d", new Object[] { Integer.valueOf(i2) });
      int i1 = 0;
      if (i1 < i2)
      {
        if (F) {
          dri.c(b, "Sync canceled. Aborting.", new Object[0]);
        }
      }
      else {
        return bool1;
      }
      localObject = (dtq)paramArrayList.get(i1);
      long l1 = a;
      dri.c(b, "Fetching conversation %d", new Object[] { Long.valueOf(l1) });
      localObject = m.a(paramdtd, hgd.a(new dtq[] { localObject }));
      if ((localObject != null) && (a != null)) {}
      for (;;)
      {
        try
        {
          boolean bool2 = a(a, paramdsu, paramdtd);
          bool1 = bool2 | bool1;
          i1 += 1;
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          dri.d(b, localSocketTimeoutException, "Exception while fetching conversation %d", new Object[] { Long.valueOf(l1) });
          v.h(l1);
        }
      }
    }
  }
  
  private static boolean a(Collection<String> paramCollection, String paramString)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (paramString.equals(dpy.h((String)paramCollection.next()))) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean a(HttpUriRequest paramHttpUriRequest, dsu paramdsu, dtd paramdtd)
  {
    return a(paramHttpUriRequest, paramdsu, paramdtd, null, null);
  }
  
  private final boolean a(HttpUriRequest paramHttpUriRequest, dsu paramdsu, dtd paramdtd, dqu paramdqu, duv paramduv)
  {
    boolean bool = false;
    paramHttpUriRequest = a(paramHttpUriRequest);
    try
    {
      dtn localdtn = m;
      localdtn.a(6);
      paramdsu = localdtn.a(paramHttpUriRequest, paramdsu, 0L, paramdtd, paramdqu);
      if (paramduv != null) {
        b = paramdsu;
      }
      if (G()) {
        bool = true;
      }
      if (!m.b("moreForwardSyncNeeded")) {
        b(false);
      }
      System.gc();
      return bool;
    }
    finally
    {
      a(paramHttpUriRequest);
    }
  }
  
  public static drp b(Context paramContext, String paramString)
  {
    cwv.b();
    return a(paramContext, paramString);
  }
  
  private final List<GmailAttachment> b(String paramString, long paramLong)
  {
    List localList = GmailAttachment.a(paramString, k.getContentResolver());
    Object localObject2 = new HashMap();
    Object localObject1 = new HashSet();
    if (paramLong != 0L)
    {
      localObject3 = p.query("messages", new String[] { "joinedAttachmentInfos" }, "_id=?", new String[] { String.valueOf(paramLong) }, null, null, null);
      try
      {
        if (((Cursor)localObject3).moveToFirst()) {}
        for (paramString = ((Cursor)localObject3).getString(0);; paramString = null)
        {
          ((Cursor)localObject3).close();
          paramString = GmailAttachment.a(paramString, k.getContentResolver()).iterator();
          while (paramString.hasNext())
          {
            localObject3 = (GmailAttachment)paramString.next();
            dri.a(b, "Found attachment %s", new Object[] { localObject3 });
            if (v != null)
            {
              ((Set)localObject1).add(v);
              if (r == 1) {
                ((Map)localObject2).put(i, v);
              }
            }
          }
          dri.d(b, "No row found for message _id %d though one was expected", new Object[] { Long.valueOf(paramLong) });
        }
        paramString = new HashSet();
      }
      finally
      {
        ((Cursor)localObject3).close();
      }
    }
    Object localObject3 = localList.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      GmailAttachment localGmailAttachment = (GmailAttachment)((Iterator)localObject3).next();
      String str = (String)((Map)localObject2).get(i);
      if (str != null)
      {
        dri.b(b, "Attachment Content %s is already cached as %s", new Object[] { i, str });
        v = str;
        paramString.add(str);
      }
      else if ((!TextUtils.isEmpty(v)) && (((Set)localObject1).contains(v)))
      {
        paramString.add(v);
      }
    }
    localObject2 = ((Set)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (paramString.contains(localObject3))
      {
        dri.b(b, "Cached file %s is safe from cleaning", new Object[] { localObject3 });
        ((Iterator)localObject2).remove();
      }
      else
      {
        dri.b(b, "Cached file %s will be cleaned", new Object[] { localObject3 });
      }
    }
    paramString = ((Set)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (String)paramString.next();
      dri.b(b, "Cleaning up unused cached file %s", new Object[] { localObject1 });
      new File((String)localObject1).delete();
    }
    return localList;
  }
  
  static void b(Handler paramHandler, dss paramdss)
  {
    paramHandler.post(new dsh(paramdss));
  }
  
  private final void b(String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", paramString1);
    localContentValues.put("value", paramString2);
    p.replace("engine_settings", null, localContentValues);
  }
  
  public static boolean b(Context paramContext, android.accounts.Account[] paramArrayOfAccount)
  {
    HashSet localHashSet = new HashSet(paramArrayOfAccount.length * 2);
    int i2 = paramArrayOfAccount.length;
    int i1 = 0;
    Object localObject;
    while (i1 < i2)
    {
      localObject = paramArrayOfAccount[i1];
      localObject = deg.a(paramContext).a(name);
      localHashSet.add(f((String)localObject));
      localHashSet.add(g((String)localObject));
      i1 += 1;
    }
    paramArrayOfAccount = null;
    String[] arrayOfString = paramContext.databaseList();
    i2 = arrayOfString.length;
    i1 = 0;
    boolean bool2 = false;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      localObject = paramArrayOfAccount;
      boolean bool1 = bool2;
      if (!localHashSet.contains(str))
      {
        localObject = paramArrayOfAccount;
        bool1 = bool2;
        if (str.endsWith(".db"))
        {
          boolean bool3 = str.startsWith("mailstore");
          if (!bool3)
          {
            localObject = paramArrayOfAccount;
            bool1 = bool2;
            if (!str.startsWith("internal")) {}
          }
          else
          {
            if (!paramContext.deleteDatabase(str)) {
              break label306;
            }
            dri.c(b, "Database deleted: No account for db [%s]", new Object[] { str });
            label201:
            bool1 = bool2;
            if (!bool2)
            {
              bool1 = bool2;
              if (bool3) {
                if (a(str.substring(10, str.lastIndexOf(".db"))) == null) {
                  break label328;
                }
              }
            }
          }
        }
      }
      label306:
      label328:
      for (bool1 = true;; bool1 = false)
      {
        str = str.substring(str.indexOf('.') + 1, str.length() - 3);
        localObject = paramArrayOfAccount;
        if (paramArrayOfAccount == null) {
          localObject = new HashSet();
        }
        ((Set)localObject).add(str);
        i1 += 1;
        paramArrayOfAccount = (android.accounts.Account[])localObject;
        bool2 = bool1;
        break;
        dri.e(b, "No account for db [%s]: deleting. Delete FAILED", new Object[] { str });
        break label201;
      }
    }
    return bool2;
  }
  
  private final void c(long paramLong, boolean paramBoolean)
  {
    but localbut = buo.a();
    if ((ar != null) && ((ar.c) || (localbut.a("sync_timeout_analytics", 1)))) {
      if (!paramBoolean) {
        break label112;
      }
    }
    label112:
    for (String str = "no_exception";; str = "caught_exception")
    {
      paramLong = SystemClock.elapsedRealtime() - paramLong;
      localbut.a("timeout_experiment_connect", paramLong, Integer.toString(q()), str);
      localbut.a("timeout_experiment_socket", paramLong, Integer.toString(r()), str);
      localbut.a("timeout_experiment_cm", paramLong, Long.toString(s()), str);
      return;
    }
  }
  
  private static String f(String paramString)
  {
    String str1 = String.valueOf("mailstore.");
    String str2 = String.valueOf(".db");
    return String.valueOf(str1).length() + 0 + String.valueOf(paramString).length() + String.valueOf(str2).length() + str1 + paramString + str2;
  }
  
  private static String g(String paramString)
  {
    String str1 = String.valueOf("internal.");
    String str2 = String.valueOf(".db");
    return String.valueOf(str1).length() + 0 + String.valueOf(paramString).length() + String.valueOf(str2).length() + str1 + paramString + str2;
  }
  
  private final Cursor h(String paramString)
  {
    return p.query("engine_settings", ah, "name=?", new String[] { paramString }, null, null, null);
  }
  
  private final dsx i(long paramLong)
  {
    Object localObject1 = Long.toString(paramLong);
    localObject1 = p.query("messages", ag, "_id=?", new String[] { localObject1 }, null, null, null);
    try
    {
      int i1 = ((Cursor)localObject1).getCount();
      if (i1 == 0) {
        return null;
      }
      ((Cursor)localObject1).moveToNext();
      dsx localdsx = new dsx(this);
      a = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("messageId"));
      b = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndexOrThrow("conversation"));
      return localdsx;
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  /* Error */
  private final boolean j(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: invokestatic 1709	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   10: ldc_w 1607
    //   13: getstatic 184	drp:ai	[Ljava/lang/String;
    //   16: ldc_w 1609
    //   19: iconst_1
    //   20: anewarray 152	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: aload 5
    //   27: aastore
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: invokevirtual 876	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore 5
    //   36: aload 5
    //   38: invokeinterface 1721 1 0
    //   43: istore_3
    //   44: iload_3
    //   45: ifne +12 -> 57
    //   48: aload 5
    //   50: invokeinterface 892 1 0
    //   55: iconst_0
    //   56: ireturn
    //   57: aload 5
    //   59: invokeinterface 881 1 0
    //   64: pop
    //   65: aload 5
    //   67: aload 5
    //   69: ldc -74
    //   71: invokeinterface 1095 2 0
    //   76: invokeinterface 1098 2 0
    //   81: istore_3
    //   82: iload_3
    //   83: iconst_1
    //   84: if_icmpne +16 -> 100
    //   87: iconst_1
    //   88: istore 4
    //   90: aload 5
    //   92: invokeinterface 892 1 0
    //   97: iload 4
    //   99: ireturn
    //   100: iconst_0
    //   101: istore 4
    //   103: goto -13 -> 90
    //   106: astore 6
    //   108: aload 5
    //   110: invokeinterface 892 1 0
    //   115: aload 6
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	drp
    //   0	118	1	paramLong	long
    //   43	42	3	i1	int
    //   88	14	4	bool	boolean
    //   4	105	5	localObject1	Object
    //   106	10	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   36	44	106	finally
    //   57	82	106	finally
  }
  
  /* Error */
  private final int k(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   4: invokevirtual 1731	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   7: ifne +14 -> 21
    //   10: new 550	java/lang/IllegalStateException
    //   13: dup
    //   14: ldc_w 1733
    //   17: invokespecial 573	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: aload_0
    //   22: iconst_4
    //   23: anewarray 152	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: ldc -84
    //   30: aastore
    //   31: dup
    //   32: iconst_1
    //   33: ldc -82
    //   35: aastore
    //   36: dup
    //   37: iconst_2
    //   38: ldc_w 1376
    //   41: aastore
    //   42: dup
    //   43: iconst_3
    //   44: ldc_w 294
    //   47: aastore
    //   48: lload_1
    //   49: invokevirtual 1736	drp:a	([Ljava/lang/String;J)Landroid/database/Cursor;
    //   52: astore 9
    //   54: aload 9
    //   56: invokeinterface 1721 1 0
    //   61: ifle +192 -> 253
    //   64: aload 9
    //   66: invokeinterface 881 1 0
    //   71: pop
    //   72: aload 9
    //   74: aload 9
    //   76: ldc -84
    //   78: invokeinterface 1095 2 0
    //   83: invokeinterface 1109 2 0
    //   88: lstore 6
    //   90: aload 9
    //   92: aload 9
    //   94: ldc -82
    //   96: invokeinterface 1095 2 0
    //   101: invokeinterface 1109 2 0
    //   106: lstore 4
    //   108: aload 9
    //   110: aload 9
    //   112: ldc_w 1376
    //   115: invokeinterface 1095 2 0
    //   120: invokeinterface 885 2 0
    //   125: astore 8
    //   127: aload 9
    //   129: aload 9
    //   131: ldc_w 294
    //   134: invokeinterface 1095 2 0
    //   139: invokeinterface 1098 2 0
    //   144: istore_3
    //   145: iload_3
    //   146: ifeq +88 -> 234
    //   149: iconst_1
    //   150: istore_3
    //   151: aload 9
    //   153: invokeinterface 892 1 0
    //   158: lload 6
    //   160: ldc2_w 1737
    //   163: lcmp
    //   164: ifeq +87 -> 251
    //   167: aload_0
    //   168: getfield 684	drp:o	Ldrj;
    //   171: iconst_1
    //   172: anewarray 1111	java/lang/Long
    //   175: dup
    //   176: iconst_0
    //   177: lload 6
    //   179: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: aastore
    //   183: invokestatic 1557	hgd:a	([Ljava/lang/Object;)Ljava/util/ArrayList;
    //   186: invokevirtual 1741	drj:a	(Ljava/util/List;)V
    //   189: aload_0
    //   190: lload 4
    //   192: invokevirtual 1501	drp:h	(J)V
    //   195: aload_0
    //   196: getfield 852	drp:n	Lduf;
    //   199: lload 4
    //   201: lload 6
    //   203: ldc_w 1743
    //   206: invokevirtual 994	duf:a	(JJLjava/lang/String;)J
    //   209: pop2
    //   210: aload 8
    //   212: aload_0
    //   213: getfield 491	drp:k	Landroid/content/Context;
    //   216: invokevirtual 788	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   219: invokestatic 1745	drp:a	(Ljava/lang/String;Landroid/content/ContentResolver;)V
    //   222: iload_3
    //   223: ifeq +9 -> 232
    //   226: aload_0
    //   227: lload_1
    //   228: invokestatic 1750	cge:a	(Lcgf;J)I
    //   231: pop
    //   232: iconst_1
    //   233: ireturn
    //   234: iconst_0
    //   235: istore_3
    //   236: goto -85 -> 151
    //   239: astore 8
    //   241: aload 9
    //   243: invokeinterface 892 1 0
    //   248: aload 8
    //   250: athrow
    //   251: iconst_0
    //   252: ireturn
    //   253: aconst_null
    //   254: astore 8
    //   256: ldc2_w 1737
    //   259: lstore 4
    //   261: ldc2_w 1737
    //   264: lstore 6
    //   266: iconst_0
    //   267: istore_3
    //   268: goto -117 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	drp
    //   0	271	1	paramLong	long
    //   144	124	3	i1	int
    //   106	154	4	l1	long
    //   88	177	6	l2	long
    //   125	86	8	str	String
    //   239	10	8	localObject1	Object
    //   254	1	8	localObject2	Object
    //   52	190	9	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   54	145	239	finally
  }
  
  private final void l(long paramLong)
  {
    n.a(paramLong);
  }
  
  private final dsw m(long paramLong)
  {
    synchronized (ae)
    {
      dsw localdsw2 = (dsw)ad.get(Long.valueOf(paramLong));
      dsw localdsw1 = localdsw2;
      if (localdsw2 == null)
      {
        localdsw1 = new dsw(this, paramLong);
        ad.put(Long.valueOf(paramLong), localdsw1);
      }
      return localdsw1;
    }
  }
  
  public final boolean A()
  {
    synchronized (t)
    {
      boolean bool = ap.get(4);
      return bool;
    }
  }
  
  public final int B()
  {
    synchronized (t)
    {
      int i1 = u;
      return i1;
    }
  }
  
  final boolean C()
  {
    for (;;)
    {
      int i1;
      try
      {
        android.accounts.Account[] arrayOfAccount = (android.accounts.Account[])AccountManager.get(k).getAccountsByTypeAndFeatures("com.google", ddy.b, null, null).getResult();
        int i2 = arrayOfAccount.length;
        i1 = 0;
        if (i1 < i2)
        {
          android.accounts.Account localAccount = arrayOfAccount[i1];
          if (l.equals(localAccount)) {
            return true;
          }
        }
        else
        {
          dri.b(b, "Account doesn't support mail %s", new Object[] { l });
          return false;
        }
      }
      catch (AuthenticatorException localAuthenticatorException)
      {
        throw new IOException(localAuthenticatorException.getMessage());
      }
      i1 += 1;
    }
  }
  
  public final void D()
  {
    F = true;
    m.f = true;
  }
  
  public final dos E()
  {
    return new dos(getContext(), l, p, n, this);
  }
  
  public final Cursor F()
  {
    int i1 = 1;
    synchronized (t)
    {
      if (z()) {
        i1 = 2;
      }
      while (y())
      {
        int i2 = i1;
        if (X.a()) {
          i2 = i1 | 0x10;
        }
        i1 = i2;
        if (X.b()) {
          i1 = i2 | 0x20;
        }
        cvp localcvp = new cvp(dpy.v, 1);
        MatrixCursor.RowBuilder localRowBuilder = localcvp.newRow();
        localRowBuilder.add(Integer.valueOf(i1));
        localRowBuilder.add(l.name);
        return localcvp;
      }
      i1 = 0;
    }
  }
  
  final boolean G()
  {
    if (p.inTransaction()) {
      throw new IllegalStateException("Must not be in transaction");
    }
    if (!F) {
      r.a(A);
    }
    for (boolean bool = false;; bool = false) {
      try
      {
        while (H())
        {
          p.yieldIfContendedSafely();
          bool = true;
        }
        r.c();
        r.d();
        if (bool)
        {
          b(false);
          I = true;
        }
        return bool;
      }
      finally
      {
        r.d();
      }
    }
  }
  
  final boolean H()
  {
    Object localObject1 = m;
    long l1;
    boolean bool;
    label82:
    int i1;
    if (j.containsKey("lowestMessageIdInDuration"))
    {
      l1 = ((dtn)localObject1).a("lowestMessageIdInDuration");
      dri.a(b, "Starting purging messages. Oldest message id in duration: %d", new Object[] { Long.valueOf(l1) });
      localObject1 = Long.toString(l1);
      bool = false;
      localObject1 = p.rawQuery("SELECT _id FROM conversations\nWHERE\n  (syncRationale = '2'\nOR (syncRationale = '1'  AND syncRationaleMessageId < ?)) AND queryId = 0 LIMIT 100", new String[] { localObject1 });
      try
      {
        if (((Cursor)localObject1).moveToNext())
        {
          l1 = ((Cursor)localObject1).getLong(0);
          int i2 = 0;
          Object localObject2 = n.c;
          Object localObject4 = duf.f;
          if (0L == DatabaseUtils.longForQuery((SQLiteDatabase)localObject2, String.valueOf(localObject4).length() + 65 + "SELECT COUNT(*) FROM operations WHERE ACTION IN (" + (String)localObject4 + ") AND value2 = ?", new String[] { Long.toString(l1) })) {
            break label427;
          }
          i1 = 1;
          label178:
          if (i1 != 0)
          {
            dri.a(b, " Conversation ID %d has unacked send or save operations.", new Object[] { Long.valueOf(l1) });
            i1 = i2;
          }
          else
          {
            localObject2 = o;
            localObject4 = new String[1];
            localObject4[0] = Long.toString(l1);
            b.delete("conversation_labels", "conversation_id = ? AND queryId = 0", (String[])localObject4);
            b.delete("conversations", "_id = ? AND queryId = 0", (String[])localObject4);
            b.delete("message_labels", "message_conversation = ?", (String[])localObject4);
            i1 = b.delete("messages", "conversation = ? AND queryId = 0", (String[])localObject4);
            dri.a(drj.a, "Purged %d messages in conversation %d", new Object[] { Integer.valueOf(i1), Long.valueOf(l1) });
            ContentValues localContentValues = new ContentValues();
            localContentValues.put("status", Integer.valueOf(-1));
            b.update("attachments", localContentValues, "messages_conversation = ?", (String[])localObject4);
            if (i1 == 0) {
              break label432;
            }
            i1 = 1;
          }
        }
        else
        {
          dri.a(b, "Finished purging messages ", new Object[0]);
          return bool;
        }
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
    }
    label427:
    label432:
    label435:
    for (;;)
    {
      for (;;)
      {
        if (i1 == 0) {
          break label435;
        }
        bool = true;
        break label82;
        l1 = 0L;
        break;
        i1 = 0;
        break label178;
        i1 = 0;
      }
    }
  }
  
  public final void I()
  {
    o.g.remove("ShouldShowSectionedInboxOOBE");
  }
  
  final void J()
  {
    if (!X.a())
    {
      dri.c(b, "calculateUnknownSyncRationalesAndPurgeInBackground: exiting (labelMap not synced", new Object[0]);
      return;
    }
    dri.c(b, "calculateUnknownSyncRationalesAndPurgeInBackground: queueing", new Object[0]);
    a(new dry(this));
  }
  
  public final Set<String> K()
  {
    HashSet localHashSet = new HashSet();
    Cursor localCursor = c(dpy.u);
    try
    {
      dqg localdqg = dpy.a(k, localCursor);
      if (localCursor != null) {
        localCursor.close();
      }
      localHashSet.addAll(localdqg.c());
      localHashSet.addAll(localdqg.d());
      return localHashSet;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  public final dve M()
  {
    ao.a();
    return ao;
  }
  
  public final int a(drk paramdrk1, drk paramdrk2)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(a);
    p.delete("message_labels", "labels_id=?", arrayOfString);
    int i1 = p.delete("conversation_labels", "labels_id=?", arrayOfString);
    o.a(paramdrk2, 0, 0, 0, Integer.MAX_VALUE, "SHOW");
    a(false);
    if (dmv.a().a(getContext(), null, "notification-requires-us", false))
    {
      paramdrk2 = String.valueOf(b);
      if (paramdrk2.length() == 0) {
        break label145;
      }
    }
    label145:
    for (paramdrk2 = "label:".concat(paramdrk2);; paramdrk2 = new String("label:"))
    {
      a(m.a("messageSequenceNumber"), paramdrk2, b, Long.valueOf(a), false);
      l();
      return i1;
    }
  }
  
  public final int a(List<Long> paramList)
  {
    int i4 = 0;
    int i1 = 0;
    r.a(A);
    int i3 = i4;
    for (;;)
    {
      int i2;
      try
      {
        paramList = paramList.iterator();
        i2 = 0;
        i3 = i4;
        if (paramList.hasNext())
        {
          i3 = i4;
          i2 = k(((Long)paramList.next()).longValue()) + i2;
          continue;
          i3 = i1;
          r.c();
          return i2;
        }
      }
      finally
      {
        r.d();
        if (i3 != 0) {
          b(true);
        }
      }
      if (i2 > 0) {
        i1 = 1;
      }
    }
  }
  
  /* Error */
  public final long a(long paramLong1, boolean paramBoolean, long paramLong2, ContentValues paramContentValues, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 941	android/util/TimingLogger
    //   3: dup
    //   4: getstatic 150	drp:b	Ljava/lang/String;
    //   7: ldc_w 1959
    //   10: invokespecial 1960	android/util/TimingLogger:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore 20
    //   15: aload_0
    //   16: aload 6
    //   18: ldc_w 1376
    //   21: invokevirtual 1963	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   24: checkcast 152	java/lang/String
    //   27: lload_1
    //   28: invokespecial 1965	drp:b	(Ljava/lang/String;J)Ljava/util/List;
    //   31: astore 21
    //   33: aload 21
    //   35: invokeinterface 1385 1 0
    //   40: astore 22
    //   42: aload 22
    //   44: invokeinterface 1155 1 0
    //   49: ifeq +100 -> 149
    //   52: aload 22
    //   54: invokeinterface 1159 1 0
    //   59: checkcast 997	com/google/android/gm/provider/uiprovider/GmailAttachment
    //   62: astore 23
    //   64: aload 23
    //   66: getfield 1031	com/google/android/gm/provider/uiprovider/GmailAttachment:r	I
    //   69: iconst_1
    //   70: if_icmpne -28 -> 42
    //   73: aload 23
    //   75: getfield 999	com/google/android/gm/provider/uiprovider/GmailAttachment:v	Ljava/lang/String;
    //   78: invokestatic 1507	hbw:b	(Ljava/lang/String;)Z
    //   81: ifeq -39 -> 42
    //   84: aload_0
    //   85: getfield 491	drp:k	Landroid/content/Context;
    //   88: aload 23
    //   90: aload 7
    //   92: invokestatic 1970	ctr:a	(Landroid/content/Context;Lcom/android/mail/providers/Attachment;Landroid/os/Bundle;)Ljava/lang/String;
    //   95: astore 24
    //   97: aload 24
    //   99: ifnull +10 -> 109
    //   102: aload 23
    //   104: aload 24
    //   106: putfield 999	com/google/android/gm/provider/uiprovider/GmailAttachment:v	Ljava/lang/String;
    //   109: aload 24
    //   111: ifnull +32 -> 143
    //   114: iconst_1
    //   115: istore 8
    //   117: iload 8
    //   119: ifne -77 -> 42
    //   122: invokestatic 1267	buo:a	()Lbut;
    //   125: ldc_w 1972
    //   128: ldc_w 1974
    //   131: ldc_w 1976
    //   134: lconst_0
    //   135: invokeinterface 1285 6 0
    //   140: goto -98 -> 42
    //   143: iconst_0
    //   144: istore 8
    //   146: goto -29 -> 117
    //   149: aload 21
    //   151: invokestatic 1402	com/google/android/gm/provider/uiprovider/GmailAttachment:a	(Ljava/util/List;)Ljava/lang/String;
    //   154: astore 7
    //   156: aload 20
    //   158: ldc_w 1978
    //   161: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   164: aload 20
    //   166: ldc_w 1979
    //   169: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield 616	drp:r	Lduy;
    //   176: aload_0
    //   177: getfield 624	drp:A	Ldqv;
    //   180: invokevirtual 1496	duy:a	(Ldvb;)V
    //   183: lload_1
    //   184: lconst_0
    //   185: lcmp
    //   186: ifeq +11 -> 197
    //   189: lload_1
    //   190: ldc2_w 1737
    //   193: lcmp
    //   194: ifne +517 -> 711
    //   197: iconst_1
    //   198: istore 8
    //   200: aload_0
    //   201: lload_1
    //   202: invokespecial 1981	drp:i	(J)Ldsx;
    //   205: astore 21
    //   207: iload 8
    //   209: ifne +941 -> 1150
    //   212: aload 21
    //   214: ifnonnull +503 -> 717
    //   217: goto +933 -> 1150
    //   220: invokestatic 1984	java/lang/System:currentTimeMillis	()J
    //   223: lstore 18
    //   225: new 1378	android/content/ContentValues
    //   228: dup
    //   229: aload 6
    //   231: invokespecial 1987	android/content/ContentValues:<init>	(Landroid/content/ContentValues;)V
    //   234: astore 6
    //   236: aload 20
    //   238: ldc_w 1989
    //   241: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   244: iload 8
    //   246: ifne +8 -> 254
    //   249: aload 21
    //   251: ifnonnull +533 -> 784
    //   254: lload 18
    //   256: bipush 20
    //   258: lshl
    //   259: lstore 10
    //   261: aload 6
    //   263: ldc -84
    //   265: lload 10
    //   267: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   270: invokevirtual 1992	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   273: lload 4
    //   275: lconst_0
    //   276: lcmp
    //   277: ifeq +879 -> 1156
    //   280: lload_1
    //   281: ldc2_w 1737
    //   284: lcmp
    //   285: ifne +442 -> 727
    //   288: goto +868 -> 1156
    //   291: aload 20
    //   293: ldc_w 1994
    //   296: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   299: aload 6
    //   301: ldc -82
    //   303: lload 10
    //   305: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   308: invokevirtual 1992	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   311: aload 6
    //   313: ldc -8
    //   315: iconst_0
    //   316: invokestatic 1104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   319: invokevirtual 1877	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   322: aload 6
    //   324: ldc -74
    //   326: iconst_1
    //   327: invokestatic 1104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: invokevirtual 1877	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   333: aload 6
    //   335: ldc_w 1996
    //   338: lload 18
    //   340: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   343: invokevirtual 1992	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   346: aload 6
    //   348: ldc_w 1998
    //   351: lload 18
    //   353: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   356: invokevirtual 1992	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   359: aload 6
    //   361: ldc_w 2000
    //   364: iconst_m1
    //   365: invokestatic 1104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: invokevirtual 1877	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   371: aload 6
    //   373: ldc -19
    //   375: invokevirtual 1963	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   378: checkcast 152	java/lang/String
    //   381: astore 21
    //   383: aload 21
    //   385: ifnull +69 -> 454
    //   388: aload 6
    //   390: ldc_w 2002
    //   393: invokevirtual 2005	android/content/ContentValues:putNull	(Ljava/lang/String;)V
    //   396: aload 6
    //   398: ldc_w 258
    //   401: invokevirtual 1963	android/content/ContentValues:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   404: checkcast 152	java/lang/String
    //   407: invokestatic 1005	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   410: ifeq +44 -> 454
    //   413: aload 21
    //   415: invokestatic 2006	cxa:b	(Ljava/lang/String;)Ljava/lang/String;
    //   418: astore 21
    //   420: aload 21
    //   422: invokevirtual 1273	java/lang/String:length	()I
    //   425: sipush 200
    //   428: if_icmpge +746 -> 1174
    //   431: aload 21
    //   433: invokevirtual 1273	java/lang/String:length	()I
    //   436: istore 9
    //   438: aload 6
    //   440: ldc_w 258
    //   443: aload 21
    //   445: iconst_0
    //   446: iload 9
    //   448: invokevirtual 1671	java/lang/String:substring	(II)Ljava/lang/String;
    //   451: invokevirtual 1404	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload 6
    //   456: ldc_w 2008
    //   459: ldc_w 1117
    //   462: invokevirtual 1404	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload 6
    //   467: ldc -10
    //   469: iconst_1
    //   470: invokestatic 1104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   473: invokevirtual 1877	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   476: lload 4
    //   478: lconst_0
    //   479: lcmp
    //   480: ifeq +16 -> 496
    //   483: aload 6
    //   485: ldc_w 2010
    //   488: lload 4
    //   490: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   493: invokevirtual 1992	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   496: aload 20
    //   498: ldc_w 2012
    //   501: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   504: getstatic 150	drp:b	Ljava/lang/String;
    //   507: ldc_w 2014
    //   510: iconst_3
    //   511: anewarray 4	java/lang/Object
    //   514: dup
    //   515: iconst_0
    //   516: lload 14
    //   518: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   521: aastore
    //   522: dup
    //   523: iconst_1
    //   524: lload 4
    //   526: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   529: aastore
    //   530: dup
    //   531: iconst_2
    //   532: lload 10
    //   534: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   537: aastore
    //   538: invokestatic 1016	dri:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   541: pop
    //   542: aload_0
    //   543: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   546: ldc_w 1865
    //   549: ldc_w 2016
    //   552: iconst_1
    //   553: anewarray 152	java/lang/String
    //   556: dup
    //   557: iconst_0
    //   558: lload 14
    //   560: invokestatic 1709	java/lang/Long:toString	(J)Ljava/lang/String;
    //   563: aastore
    //   564: invokevirtual 1859	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   567: pop
    //   568: aload 20
    //   570: ldc_w 2018
    //   573: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   576: aload 6
    //   578: ldc_w 1376
    //   581: aload 7
    //   583: invokevirtual 1404	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: iload 8
    //   588: ifeq +216 -> 804
    //   591: aload_0
    //   592: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   595: ldc_w 1607
    //   598: aconst_null
    //   599: aload 6
    //   601: invokevirtual 2021	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   604: lstore 4
    //   606: lload 4
    //   608: lstore_1
    //   609: lload 4
    //   611: ldc2_w 1737
    //   614: lcmp
    //   615: ifne +216 -> 831
    //   618: aload 6
    //   620: invokestatic 1270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   623: astore 6
    //   625: new 550	java/lang/IllegalStateException
    //   628: dup
    //   629: new 552	java/lang/StringBuilder
    //   632: dup
    //   633: aload 6
    //   635: invokestatic 1270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   638: invokevirtual 1273	java/lang/String:length	()I
    //   641: bipush 43
    //   643: iadd
    //   644: invokespecial 555	java/lang/StringBuilder:<init>	(I)V
    //   647: ldc_w 2023
    //   650: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: aload 6
    //   655: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokespecial 573	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   664: athrow
    //   665: astore 6
    //   667: iconst_0
    //   668: istore 8
    //   670: aload_0
    //   671: getfield 616	drp:r	Lduy;
    //   674: invokevirtual 630	duy:d	()V
    //   677: aload 20
    //   679: ldc_w 2025
    //   682: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   685: iload 8
    //   687: ifeq +16 -> 703
    //   690: aload_0
    //   691: iconst_1
    //   692: invokevirtual 1594	drp:b	(Z)V
    //   695: aload 20
    //   697: ldc_w 2027
    //   700: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   703: aload 20
    //   705: invokevirtual 2030	android/util/TimingLogger:dumpToLog	()V
    //   708: aload 6
    //   710: athrow
    //   711: iconst_0
    //   712: istore 8
    //   714: goto -514 -> 200
    //   717: aload 21
    //   719: getfield 1727	dsx:b	J
    //   722: lstore 12
    //   724: goto -504 -> 220
    //   727: aload_0
    //   728: lload 4
    //   730: iconst_0
    //   731: invokevirtual 2033	drp:a	(JZ)Ldtu;
    //   734: astore 21
    //   736: aload 21
    //   738: ifnonnull +21 -> 759
    //   741: lconst_0
    //   742: lstore 4
    //   744: lload 10
    //   746: lstore 16
    //   748: lload 10
    //   750: lstore 14
    //   752: lload 16
    //   754: lstore 10
    //   756: goto -465 -> 291
    //   759: aload 21
    //   761: getfield 2036	dtu:d	J
    //   764: lstore 16
    //   766: aload 21
    //   768: getfield 2037	dtu:c	J
    //   771: lstore 4
    //   773: lload 10
    //   775: lstore 14
    //   777: lload 16
    //   779: lstore 10
    //   781: goto -490 -> 291
    //   784: aload 21
    //   786: getfield 1727	dsx:b	J
    //   789: lstore 10
    //   791: aload 21
    //   793: getfield 1725	dsx:a	J
    //   796: lstore 14
    //   798: lconst_0
    //   799: lstore 4
    //   801: goto -510 -> 291
    //   804: aload_0
    //   805: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   808: ldc_w 1607
    //   811: aload 6
    //   813: ldc_w 1609
    //   816: iconst_1
    //   817: anewarray 152	java/lang/String
    //   820: dup
    //   821: iconst_0
    //   822: lload_1
    //   823: invokestatic 1709	java/lang/Long:toString	(J)Ljava/lang/String;
    //   826: aastore
    //   827: invokevirtual 1885	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   830: pop
    //   831: aload 20
    //   833: ldc_w 2039
    //   836: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   839: iload_3
    //   840: ifeq +148 -> 988
    //   843: aload_0
    //   844: getfield 684	drp:o	Ldrj;
    //   847: lload 14
    //   849: aload_0
    //   850: getfield 684	drp:o	Ldrj;
    //   853: ldc_w 2041
    //   856: invokevirtual 2044	drj:b	(Ljava/lang/String;)Ldrk;
    //   859: iconst_1
    //   860: iconst_0
    //   861: invokevirtual 2047	drj:a	(JLdrk;ZI)V
    //   864: aload 20
    //   866: ldc_w 2049
    //   869: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   872: aload_0
    //   873: lload 14
    //   875: lload 10
    //   877: iload_3
    //   878: aload 20
    //   880: invokespecial 2051	drp:a	(JJZLandroid/util/TimingLogger;)Landroid/os/Bundle;
    //   883: astore 6
    //   885: lload 10
    //   887: lload 12
    //   889: lcmp
    //   890: ifeq +16 -> 906
    //   893: lload 12
    //   895: lconst_0
    //   896: lcmp
    //   897: ifeq +9 -> 906
    //   900: aload_0
    //   901: lload 12
    //   903: invokevirtual 1501	drp:h	(J)V
    //   906: aload 20
    //   908: ldc_w 2053
    //   911: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   914: aload_0
    //   915: lload 10
    //   917: iconst_4
    //   918: iconst_1
    //   919: iconst_0
    //   920: iconst_0
    //   921: invokespecial 1480	drp:a	(JIZZZ)V
    //   924: aload 20
    //   926: ldc_w 2055
    //   929: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   932: aload 6
    //   934: ifnull +9 -> 943
    //   937: aload_0
    //   938: aload 6
    //   940: invokespecial 2057	drp:a	(Landroid/os/Bundle;)V
    //   943: iconst_1
    //   944: istore 8
    //   946: aload_0
    //   947: getfield 616	drp:r	Lduy;
    //   950: invokevirtual 628	duy:c	()V
    //   953: aload_0
    //   954: getfield 616	drp:r	Lduy;
    //   957: invokevirtual 630	duy:d	()V
    //   960: aload 20
    //   962: ldc_w 2025
    //   965: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   968: aload_0
    //   969: iconst_1
    //   970: invokevirtual 1594	drp:b	(Z)V
    //   973: aload 20
    //   975: ldc_w 2027
    //   978: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   981: aload 20
    //   983: invokevirtual 2030	android/util/TimingLogger:dumpToLog	()V
    //   986: lload_1
    //   987: lreturn
    //   988: iconst_0
    //   989: istore 8
    //   991: aload_0
    //   992: lload 14
    //   994: iconst_0
    //   995: invokevirtual 2059	drp:b	(JZ)Ldtu;
    //   998: astore 6
    //   1000: aload 6
    //   1002: ifnull +76 -> 1078
    //   1005: aload 6
    //   1007: getfield 2061	dtu:g	Ljava/util/List;
    //   1010: aload_0
    //   1011: getfield 507	drp:l	Landroid/accounts/Account;
    //   1014: getfield 1132	android/accounts/Account:name	Ljava/lang/String;
    //   1017: invokestatic 2063	drp:a	(Ljava/util/Collection;Ljava/lang/String;)Z
    //   1020: ifeq +107 -> 1127
    //   1023: iconst_1
    //   1024: istore 8
    //   1026: iload 8
    //   1028: ifne +154 -> 1182
    //   1031: aload 6
    //   1033: getfield 2065	dtu:h	Ljava/util/List;
    //   1036: aload_0
    //   1037: getfield 507	drp:l	Landroid/accounts/Account;
    //   1040: getfield 1132	android/accounts/Account:name	Ljava/lang/String;
    //   1043: invokestatic 2063	drp:a	(Ljava/util/Collection;Ljava/lang/String;)Z
    //   1046: ifeq +87 -> 1133
    //   1049: goto +133 -> 1182
    //   1052: iload 8
    //   1054: ifne +134 -> 1188
    //   1057: aload 6
    //   1059: getfield 2067	dtu:i	Ljava/util/List;
    //   1062: aload_0
    //   1063: getfield 507	drp:l	Landroid/accounts/Account;
    //   1066: getfield 1132	android/accounts/Account:name	Ljava/lang/String;
    //   1069: invokestatic 2063	drp:a	(Ljava/util/Collection;Ljava/lang/String;)Z
    //   1072: ifeq +67 -> 1139
    //   1075: goto +113 -> 1188
    //   1078: iload 8
    //   1080: ifeq +24 -> 1104
    //   1083: aload_0
    //   1084: getfield 684	drp:o	Ldrj;
    //   1087: lload 14
    //   1089: aload_0
    //   1090: getfield 684	drp:o	Ldrj;
    //   1093: ldc_w 2069
    //   1096: invokevirtual 2044	drj:b	(Ljava/lang/String;)Ldrk;
    //   1099: iconst_1
    //   1100: iconst_0
    //   1101: invokevirtual 2047	drj:a	(JLdrk;ZI)V
    //   1104: aload_0
    //   1105: getfield 684	drp:o	Ldrj;
    //   1108: lload 14
    //   1110: aload_0
    //   1111: getfield 684	drp:o	Ldrj;
    //   1114: ldc -60
    //   1116: invokevirtual 2044	drj:b	(Ljava/lang/String;)Ldrk;
    //   1119: iconst_1
    //   1120: iconst_0
    //   1121: invokevirtual 2047	drj:a	(JLdrk;ZI)V
    //   1124: goto -260 -> 864
    //   1127: iconst_0
    //   1128: istore 8
    //   1130: goto -104 -> 1026
    //   1133: iconst_0
    //   1134: istore 8
    //   1136: goto -84 -> 1052
    //   1139: iconst_0
    //   1140: istore 8
    //   1142: goto -64 -> 1078
    //   1145: astore 6
    //   1147: goto -477 -> 670
    //   1150: lconst_0
    //   1151: lstore 12
    //   1153: goto -933 -> 220
    //   1156: lconst_0
    //   1157: lstore 4
    //   1159: lload 10
    //   1161: lstore 16
    //   1163: lload 10
    //   1165: lstore 14
    //   1167: lload 16
    //   1169: lstore 10
    //   1171: goto -880 -> 291
    //   1174: sipush 200
    //   1177: istore 9
    //   1179: goto -741 -> 438
    //   1182: iconst_1
    //   1183: istore 8
    //   1185: goto -133 -> 1052
    //   1188: iconst_1
    //   1189: istore 8
    //   1191: goto -113 -> 1078
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1194	0	this	drp
    //   0	1194	1	paramLong1	long
    //   0	1194	3	paramBoolean	boolean
    //   0	1194	4	paramLong2	long
    //   0	1194	6	paramContentValues	ContentValues
    //   0	1194	7	paramBundle	Bundle
    //   115	1075	8	i1	int
    //   436	742	9	i2	int
    //   259	911	10	l1	long
    //   722	430	12	l2	long
    //   516	43	14	localObject1	Object
    //   750	416	14	l3	long
    //   746	422	16	l4	long
    //   223	129	18	l5	long
    //   13	969	20	localTimingLogger	TimingLogger
    //   31	761	21	localObject2	Object
    //   40	13	22	localIterator	Iterator
    //   62	41	23	localGmailAttachment	GmailAttachment
    //   95	15	24	str	String
    // Exception table:
    //   from	to	target	type
    //   200	207	665	finally
    //   220	244	665	finally
    //   261	273	665	finally
    //   291	383	665	finally
    //   388	438	665	finally
    //   438	454	665	finally
    //   454	476	665	finally
    //   483	496	665	finally
    //   496	586	665	finally
    //   591	606	665	finally
    //   618	665	665	finally
    //   717	724	665	finally
    //   727	736	665	finally
    //   759	773	665	finally
    //   784	798	665	finally
    //   804	831	665	finally
    //   831	839	665	finally
    //   843	864	665	finally
    //   864	885	665	finally
    //   900	906	665	finally
    //   906	932	665	finally
    //   937	943	665	finally
    //   991	1000	665	finally
    //   1005	1023	665	finally
    //   1031	1049	665	finally
    //   1057	1075	665	finally
    //   1083	1104	665	finally
    //   1104	1124	665	finally
    //   946	953	1145	finally
  }
  
  public final long a(dtp paramdtp, long paramLong, drk paramdrk)
  {
    Object localObject = new ContentValues();
    r.a(A);
    for (;;)
    {
      long l2;
      String str;
      long l1;
      try
      {
        l2 = a;
        str = String.valueOf(l2);
        if (paramLong == 0L)
        {
          l1 = DatabaseUtils.longForQuery(p, "SELECT COALESCE(MAX(messageId), 0) FROM messages where conversation = ? AND queryId = 0", new String[] { str });
          if (paramLong != 0L) {
            break label745;
          }
          localMap = new dpu(p, o).a(l2, paramLong);
          ((ContentValues)localObject).put("_id", Long.valueOf(l2));
          ((ContentValues)localObject).put("queryId", Long.valueOf(paramLong));
          ((ContentValues)localObject).put("subject", h);
          ((ContentValues)localObject).put("snippet", i);
          ((ContentValues)localObject).put("fromCompactV2", f);
          ((ContentValues)localObject).put("personalLevel", Integer.valueOf(j));
          ((ContentValues)localObject).put("forceAllUnread", Integer.valueOf(0));
          ((ContentValues)localObject).put("promoteCalendar", Integer.valueOf(o));
          n.add(Long.valueOf(X.l()));
          if (paramdrk != null) {
            n.add(Long.valueOf(a));
          }
          ((ContentValues)localObject).put("labelIds", dpy.a(n));
          ((ContentValues)localObject).put("numMessages", Integer.valueOf(d));
          ((ContentValues)localObject).put("maxMessageId", Long.valueOf(l1));
          ((ContentValues)localObject).put("hasAttachments", Boolean.valueOf(k));
          ((ContentValues)localObject).put("unsubscribeSenderName", l);
          ((ContentValues)localObject).put("unsubscribeSenderIdentifier", m);
          ((ContentValues)localObject).put("hasCalendarInvite", Boolean.valueOf(p));
          long l3 = p.replace("conversations", null, (ContentValues)localObject);
          if (paramLong == 0L) {
            I = true;
          }
          if (l3 == -1L) {
            dri.d(b, "Failed to insert conversation", new Object[0]);
          }
          if (paramLong != 0L) {
            break label532;
          }
          paramdrk = new HashMap();
          localObject = n.iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label468;
          }
          paramdrk.put((Long)((Iterator)localObject).next(), new drg(b, g, false));
          continue;
        }
        l1 = c;
      }
      finally
      {
        r.d();
      }
      continue;
      label468:
      localObject = new dux(p, o);
      ((dux)localObject).a(l2, 1, localMap, paramdrk, l1, null, null);
      ((dux)localObject).a(l2, 0L, paramdrk);
      r.c();
      paramLong = b;
      r.d();
      return paramLong;
      label532:
      ((ContentValues)localObject).clear();
      if (paramdrk != null) {
        ((ContentValues)localObject).put("labels_id", Long.valueOf(a));
      }
      for (;;)
      {
        ((ContentValues)localObject).put("queryId", Long.valueOf(paramLong));
        ((ContentValues)localObject).put("isZombie", Integer.valueOf(0));
        ((ContentValues)localObject).put("sortMessageId", Long.valueOf(b));
        ((ContentValues)localObject).put("date", Long.valueOf(g));
        ((ContentValues)localObject).put("conversation_id", Long.valueOf(l2));
        p.delete("conversation_labels", "queryId=? AND conversation_id=?", new String[] { String.valueOf(paramLong), str });
        paramdrk = n.iterator();
        while (paramdrk.hasNext())
        {
          ((ContentValues)localObject).put("labels_id", (Long)paramdrk.next());
          if (p.insert("conversation_labels", null, (ContentValues)localObject) == -1L) {
            dri.d(b, "Failed to insert conversation label", new Object[0]);
          }
        }
        break;
        ((ContentValues)localObject).put("labels_id", Integer.valueOf(0));
      }
      label745:
      Map localMap = null;
    }
  }
  
  final Cursor a(String paramString, String[] paramArrayOfString)
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("server_preferences");
    return localSQLiteQueryBuilder.query(p, null, paramString, paramArrayOfString, null, null, null);
  }
  
  public final Cursor a(String paramString, String[] paramArrayOfString, Integer paramInteger, boolean paramBoolean)
  {
    return a(paramString, paramArrayOfString, paramInteger, paramBoolean, null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString, Integer paramInteger, boolean paramBoolean, String paramString2)
  {
    if ((p == null) || (!p.isOpen())) {
      return null;
    }
    dmt.a();
    Object localObject1 = aK;
    boolean bool1 = true;
    boolean bool2 = true;
    int i1;
    Object localObject2;
    if (paramArrayOfString != null) {
      try
      {
        int i2 = paramArrayOfString.length;
        i1 = 0;
        bool1 = bool2;
        while (i1 < i2)
        {
          localObject2 = paramArrayOfString[i1];
          if ("SELECTION_ARGUMENT_DO_NOT_BECOME_ACTIVE_NETWORK_CURSOR".equals(localObject2))
          {
            bool1 = false;
            i1 += 1;
          }
          else
          {
            throw new IllegalArgumentException(String.valueOf(localObject2).length() + 30 + "Selection Argument '" + (String)localObject2 + "' unknown.");
          }
        }
      }
      finally {}
    }
    if (TextUtils.equals(paramString1, Y))
    {
      if (TextUtils.equals(paramString2, Z)) {
        break label763;
      }
      break label744;
      if (!bool2)
      {
        paramArrayOfString = new dsn(this, paramString1, paramString2, bool1, paramInteger, MailProvider.a(), paramBoolean);
        dri.b("CursorLogic", "IN query: label=%s logic=%s reuse=%s becomeNetwork=%s, query=%s lastQuery=%s", new Object[] { d, paramArrayOfString, Boolean.valueOf(bool2), Boolean.valueOf(bool1), paramString1, Y });
        paramInteger = new drt(this, paramArrayOfString);
        paramString2 = p;
        if (!i) {
          break label491;
        }
      }
      for (paramString1 = "SELECT conversation_labels.*, conversations.*, conversations.queryId = 0 AS synced, (SELECT group_concat((labels._id || '^*^' || labels.canonicalName || '^*^' || \n(CASE labels.canonicalName  WHEN '^f' THEN ?  WHEN '^^out' THEN ?  WHEN '^i' THEN ?  WHEN '^r' THEN ?  WHEN '^b' THEN ?  WHEN '^all' THEN ?  WHEN '^u' THEN ?  WHEN '^k' THEN ?  WHEN '^s' THEN ?  WHEN '^t' THEN ?  WHEN '^g' THEN ?  WHEN '^io_im' THEN ?  WHEN '^iim' THEN ?  WHEN '^sq_ig_i_personal' THEN ?  WHEN '^sq_ig_i_social' THEN ?  WHEN '^sq_ig_i_promo' THEN ?  WHEN '^sq_ig_i_notification' THEN ?  WHEN '^sq_ig_i_group' THEN ?  ELSE labels.name END)  || '^*^' || labels.color || '^*^' || labels.hidden), '^**^') FROM labels JOIN conversation_labels  ON conversation_labels.labels_id=labels._id  AND conversation_labels.conversation_id=conversations._id AND conversation_labels.isZombie=0) AS conversationLabels, (CASE WHEN unsubscribed_senders.senderIdentifier IS NULL THEN 0 ELSE 1 END) AS isSenderUnsubscribed FROM conversation_labels LEFT OUTER JOIN conversations ON conversation_labels.conversation_id=conversations._id AND conversation_labels.queryId = conversations.queryId LEFT OUTER JOIN unsubscribed_senders ON conversations.unsubscribeSenderIdentifier = unsubscribed_senders.senderIdentifier\n WHERE 0=1";; paramString1 = f)
      {
        label270:
        paramString1 = (dsm)paramString2.rawQueryWithFactory(paramInteger, paramString1, paramArrayOfString.b(), null);
        k = m.a("messageSequenceNumber");
        if (bool2) {
          break label608;
        }
        paramArrayOfString.a(paramString1.getPosition(), paramString1);
        if ((paramArrayOfString.c()) && (!bhk.b()) && (ContentResolver.isSyncPending(l.l, "gmail-ls")))
        {
          i1 = ghz.a(l.k.getContentResolver(), "gmail-sync-thread-interval", 1800000);
          if (SystemClock.elapsedRealtime() - l.H > i1)
          {
            l.H = SystemClock.elapsedRealtime();
            paramArrayOfString.e();
          }
        }
        if (j)
        {
          j = false;
          if (ac != null) {
            ac.cancel(false);
          }
          ac = new dso(paramArrayOfString, q);
          ac.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
        }
        label453:
        paramString1.a(8);
        dmt.b();
        if (e != null) {
          break label732;
        }
        label469:
        return paramString1;
        paramArrayOfString = aa;
        paramArrayOfString.a(paramInteger);
        paramArrayOfString.a();
        break;
        label491:
        i1 = f.indexOf("%s");
        if (i1 >= 0) {
          break label516;
        }
      }
      label516:
      if (e == null) {
        break label775;
      }
    }
    label608:
    label732:
    label744:
    label763:
    label769:
    label775:
    for (paramString1 = e.a(g);; paramString1 = null)
    {
      localObject2 = new StringBuilder(f.length() + paramString1.length());
      ((StringBuilder)localObject2).append(f, 0, i1);
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append(f, i1 + 2, f.length());
      paramString1 = ((StringBuilder)localObject2).toString();
      break label270;
      paramInteger = paramString1.c();
      if (paramInteger == null) {
        break label453;
      }
      paramBoolean = a;
      long l2 = l.m.a(d);
      if (b != l2)
      {
        long l1 = l2;
        if (b < l2) {
          l1 = b;
        }
        b = l1;
        r = paramInteger.a(l.k, d, b, q, g);
      }
      if (paramBoolean) {
        paramInteger.j();
      }
      paramInteger = paramInteger.b();
      if (paramInteger == null) {
        break label453;
      }
      paramString1.setSelectionArguments(paramInteger);
      break label453;
      paramString1 = e.a(paramString1);
      break label469;
      for (i1 = 1;; i1 = 0)
      {
        if ((i1 != 0) || (!bool1)) {
          break label769;
        }
        bool2 = true;
        break;
      }
      bool2 = false;
      break;
    }
  }
  
  public final Cursor a(String[] paramArrayOfString, long paramLong)
  {
    dmt.a();
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("messages LEFT OUTER JOIN message_labels \nON messages.messageId = message_labels.message_messageId \nLEFT OUTER JOIN labels \nON message_labels.labels_id=labels._id LEFT OUTER JOIN unsubscribed_senders \nON messages.unsubscribeSenderIdentifier = unsubscribed_senders.senderIdentifier ");
    localSQLiteQueryBuilder.appendWhere("messages._id=?");
    localSQLiteQueryBuilder.setProjectionMap(T);
    String[] arrayOfString = a(paramArrayOfString, "messageLabels", new String[] { Long.toString(paramLong) });
    paramArrayOfString = localSQLiteQueryBuilder.query(p, paramArrayOfString, null, arrayOfString, "messages.messageId", null, null);
    dmt.b();
    return new dpq(paramArrayOfString, "body");
  }
  
  public final Cursor a(String[] paramArrayOfString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    dmt.a();
    Object localObject = m(paramLong);
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("messages LEFT OUTER JOIN message_labels \nON messages.messageId = message_labels.message_messageId \nLEFT OUTER JOIN labels \nON message_labels.labels_id=labels._id LEFT OUTER JOIN unsubscribed_senders \nON messages.unsubscribeSenderIdentifier = unsubscribed_senders.senderIdentifier ");
    localSQLiteQueryBuilder.appendWhere("messages.conversation = ? AND (queryId = 0 OR queryId = ?)");
    localSQLiteQueryBuilder.setProjectionMap(T);
    localSQLiteQueryBuilder.setCursorFactory(new dru(this, (dsw)localObject));
    String[] arrayOfString = a(paramArrayOfString, "messageLabels", new String[] { Long.toString(paramLong), Long.toString(q) });
    paramArrayOfString = (dsk)localSQLiteQueryBuilder.query(p, paramArrayOfString, null, arrayOfString, "messages.messageId", null, "messages.messageId");
    int i1;
    if ((!b) || (!paramBoolean1))
    {
      i1 = ((dsw)localObject).a(paramLong, paramArrayOfString, paramBoolean1);
      if (!paramBoolean2) {
        break label185;
      }
      localObject = (dsy)paramArrayOfString.clone();
      paramArrayOfString.close();
      paramArrayOfString = (String[])localObject;
    }
    label185:
    for (;;)
    {
      paramArrayOfString.a(i1);
      dmt.b();
      return new dpq(paramArrayOfString, "body");
      i1 = 0;
      break;
    }
  }
  
  public final Uri a(String paramString, long paramLong)
  {
    Object localObject2 = null;
    List localList1 = null;
    Object localObject1 = b(dpy.t).a(false);
    b.setTables("labels, conversation_labels");
    ((drf)localObject1).a("labels._id = conversation_labels.labels_id AND\n        conversation_labels.isZombie = 0 AND\n        conversation_labels.queryId = 0 AND\n        conversation_labels.conversation_id = ?");
    a.add(Long.toString(paramLong));
    localObject1 = ((drf)localObject1).a();
    Cursor localCursor = GmailProvider.a(this, paramString, chh.i, (Cursor)localObject1, null);
    localObject1 = localList1;
    if (localCursor != null)
    {
      if (!localCursor.moveToFirst()) {
        localObject1 = localList1;
      }
    }
    else {
      return (Uri)localObject1;
    }
    paramString = dpy.a(getContext(), paramString);
    localList1 = paramString.c();
    List localList2 = paramString.d();
    localObject1 = null;
    paramString = (String)localObject2;
    for (;;)
    {
      try
      {
        localObject2 = new Folder(localCursor);
        String str = GmailProvider.a((Folder)localObject2);
        if (((Folder)localObject2).d(16))
        {
          localObject2 = c.b;
          paramString = (String)localObject1;
          localObject1 = localObject2;
          boolean bool = localCursor.moveToNext();
          if (bool) {
            break label333;
          }
          if (paramString != null)
          {
            localObject1 = paramString;
            return paramString;
          }
        }
        else
        {
          if (((Folder)localObject2).d(4))
          {
            localObject2 = c.b;
            localObject1 = paramString;
            paramString = (String)localObject2;
            continue;
          }
          if ((!localList1.contains(str)) && (!localList2.contains(str))) {
            break label320;
          }
          paramString = c.b;
          localObject1 = paramString;
          return paramString;
        }
        paramString = (String)localObject1;
        continue;
        localObject2 = paramString;
      }
      finally
      {
        if (!localCursor.isClosed()) {
          localCursor.close();
        }
      }
      label320:
      paramString = (String)localObject1;
      localObject1 = localObject2;
      continue;
      label333:
      localObject2 = paramString;
      paramString = (String)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public final com.android.mail.providers.Account a(Uri paramUri)
  {
    return ctl.a(k, l.name);
  }
  
  public final Conversation a(Context paramContext, com.android.mail.providers.Account paramAccount, String paramString)
  {
    Object localObject = null;
    paramContext = duo.a(paramContext, new String[] { String.format(Locale.US, ghz.a(paramContext.getContentResolver(), "gmail_permalink_pattern", "%%plid=%s%%"), new Object[] { paramString }) });
    paramString = p.rawQuery("SELECT conversation_labels.*, conversations.*, conversations.queryId = 0 AS synced, (SELECT group_concat((labels._id || '^*^' || labels.canonicalName || '^*^' || \n(CASE labels.canonicalName  WHEN '^f' THEN ?  WHEN '^^out' THEN ?  WHEN '^i' THEN ?  WHEN '^r' THEN ?  WHEN '^b' THEN ?  WHEN '^all' THEN ?  WHEN '^u' THEN ?  WHEN '^k' THEN ?  WHEN '^s' THEN ?  WHEN '^t' THEN ?  WHEN '^g' THEN ?  WHEN '^io_im' THEN ?  WHEN '^iim' THEN ?  WHEN '^sq_ig_i_personal' THEN ?  WHEN '^sq_ig_i_social' THEN ?  WHEN '^sq_ig_i_promo' THEN ?  WHEN '^sq_ig_i_notification' THEN ?  WHEN '^sq_ig_i_group' THEN ?  ELSE labels.name END)  || '^*^' || labels.color || '^*^' || labels.hidden), '^**^') FROM labels JOIN conversation_labels  ON conversation_labels.labels_id=labels._id  AND conversation_labels.conversation_id=conversations._id AND conversation_labels.isZombie=0) AS conversationLabels, (CASE WHEN unsubscribed_senders.senderIdentifier IS NULL THEN 0 ELSE 1 END) AS isSenderUnsubscribed FROM conversation_labels LEFT OUTER JOIN conversations ON conversation_labels.conversation_id=conversations._id AND conversation_labels.queryId = conversations.queryId LEFT OUTER JOIN unsubscribed_senders ON conversations.unsubscribeSenderIdentifier = unsubscribed_senders.senderIdentifier\n WHERE\n (conversations.permalink LIKE ? ) AND isZombie=0 AND conversations.queryId=0\n GROUP BY conversations._id", paramContext);
    paramContext = (Context)localObject;
    if (paramString != null)
    {
      paramContext = (Context)localObject;
      if (paramString.getCount() == 1)
      {
        if (paramString.moveToFirst()) {
          break label88;
        }
        paramContext = (Context)localObject;
      }
    }
    label86:
    return paramContext;
    try
    {
      label88:
      paramAccount = new dvp(paramString, c, g.toString(), chh.k);
    }
    finally
    {
      try
      {
        paramString = new Conversation(paramAccount);
        paramContext = paramString;
        if (paramAccount.isClosed()) {
          break label86;
        }
        paramAccount.close();
        return paramString;
      }
      finally {}
      paramContext = finally;
      paramAccount = null;
    }
    if ((paramAccount != null) && (!paramAccount.isClosed())) {
      paramAccount.close();
    }
    throw paramContext;
  }
  
  public final ConversationInfo a(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("conversations");
    localSQLiteQueryBuilder.appendWhere("conversations._id=?");
    paramString1 = localSQLiteQueryBuilder.query(p, paramArrayOfString, null, new String[] { paramString1 }, null, null, null);
    paramArrayOfString = (String[])localObject2;
    if (paramString1 != null) {}
    try
    {
      paramString1 = new dqb(paramString2, paramString1);
      if (paramString1 == null) {
        break label103;
      }
    }
    finally
    {
      try
      {
        paramString1.d();
        paramArrayOfString = ConversationInfo.a(paramString1, X);
        paramString1.e();
        return paramArrayOfString;
      }
      finally {}
      paramArrayOfString = finally;
      paramString1 = (String)localObject1;
    }
    paramString1.e();
    label103:
    throw paramArrayOfString;
  }
  
  final drk a(long paramLong)
  {
    return a(o.c(paramLong));
  }
  
  final drk a(drk paramdrk)
  {
    paramdrk = dpy.k(drj.a(paramdrk));
    return o.a(paramdrk);
  }
  
  public final dtu a(long paramLong, boolean paramBoolean)
  {
    Cursor localCursor = a(null, paramLong);
    try
    {
      localCursor.moveToNext();
      dtu localdtu = a(localCursor, paramBoolean);
      return localdtu;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  final dtu a(Cursor paramCursor, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramCursor.isAfterLast()) {
      return null;
    }
    dtu localdtu = new dtu();
    long l1 = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
    long l2 = paramCursor.getLong(paramCursor.getColumnIndex("messageId"));
    a = l.name;
    b = l1;
    c = l2;
    d = paramCursor.getLong(paramCursor.getColumnIndexOrThrow("conversation"));
    e = paramCursor.getLong(paramCursor.getColumnIndexOrThrow("refMessageId"));
    H = paramCursor.getString(paramCursor.getColumnIndexOrThrow("refAdEventId"));
    f = a(paramCursor, "fromAddress");
    B = a(paramCursor, "customFromAddress");
    g = hgd.a(TextUtils.split(a(paramCursor, "toAddresses"), dpy.b));
    h = hgd.a(TextUtils.split(a(paramCursor, "ccAddresses"), dpy.b));
    i = hgd.a(TextUtils.split(a(paramCursor, "bccAddresses"), dpy.b));
    j = hgd.a(TextUtils.split(a(paramCursor, "replyToAddresses"), dpy.b));
    k = paramCursor.getLong(paramCursor.getColumnIndex("dateSentMs"));
    l = paramCursor.getLong(paramCursor.getColumnIndex("dateReceivedMs"));
    m = a(paramCursor, "subject");
    n = a(paramCursor, "snippet");
    Object localObject = dpy.a();
    ((TextUtils.StringSplitter)localObject).setString(a(paramCursor, "labelIds"));
    o = dpy.a((TextUtils.StringSplitter)localObject);
    p = a(paramCursor, "listInfo");
    q = dpy.a(paramCursor.getInt(paramCursor.getColumnIndexOrThrow("personalLevel")));
    boolean bool1;
    if (paramCursor.getLong(paramCursor.getColumnIndexOrThrow("forward")) != 0L)
    {
      bool1 = true;
      w = bool1;
      if (paramCursor.getLong(paramCursor.getColumnIndexOrThrow("includeQuotedText")) == 0L) {
        break label967;
      }
      bool1 = true;
      label421:
      x = bool1;
      y = paramCursor.getLong(paramCursor.getColumnIndex("quoteStartPos"));
      if (paramCursor.getLong(paramCursor.getColumnIndexOrThrow("clientCreated")) == 0L) {
        break label972;
      }
      bool1 = true;
      label468:
      z = bool1;
      localObject = paramCursor.getString(paramCursor.getColumnIndexOrThrow("joinedAttachmentInfos"));
      r.addAll(GmailAttachment.a((String)localObject, k.getContentResolver()));
      if (paramBoolean)
      {
        s = paramCursor.getString(paramCursor.getColumnIndexOrThrow("body"));
        t = paramCursor.getString(paramCursor.getColumnIndexOrThrow("stylesheet"));
        u = paramCursor.getString(paramCursor.getColumnIndexOrThrow("stylesheetRestrictor"));
      }
      I = paramCursor.getString(paramCursor.getColumnIndexOrThrow("permalink"));
      J = paramCursor.getInt(paramCursor.getColumnIndexOrThrow("clipped"));
      K = paramCursor.getString(paramCursor.getColumnIndexOrThrow("unsubscribeSenderName"));
      L = paramCursor.getString(paramCursor.getColumnIndexOrThrow("unsubscribeSenderIdentifier"));
      if (paramCursor.getInt(paramCursor.getColumnIndexOrThrow("hasEvent")) == 0) {
        break label982;
      }
      M = new dtv();
      M.a = paramCursor.getString(paramCursor.getColumnIndexOrThrow("eventTitle"));
      M.b = paramCursor.getLong(paramCursor.getColumnIndexOrThrow("startTime"));
      M.c = paramCursor.getLong(paramCursor.getColumnIndexOrThrow("endTime"));
      localObject = M;
      if (paramCursor.getInt(paramCursor.getColumnIndexOrThrow("allDay")) == 0) {
        break label977;
      }
      paramBoolean = bool2;
      label784:
      d = paramBoolean;
      M.e = paramCursor.getString(paramCursor.getColumnIndexOrThrow("location"));
      M.f = a(paramCursor, "organizer");
      M.g = hgd.a(TextUtils.split(a(paramCursor, "attendees"), dpy.b));
      M.h = paramCursor.getInt(paramCursor.getColumnIndexOrThrow("icalMethod"));
      M.i = paramCursor.getString(paramCursor.getColumnIndexOrThrow("eventId"));
      M.j = paramCursor.getString(paramCursor.getColumnIndexOrThrow("calendarId"));
      M.k = a(paramCursor, "responder");
      M.l = paramCursor.getInt(paramCursor.getColumnIndexOrThrow("responseStatus"));
    }
    for (;;)
    {
      return localdtu;
      bool1 = false;
      break;
      label967:
      bool1 = false;
      break label421;
      label972:
      bool1 = false;
      break label468;
      label977:
      paramBoolean = false;
      break label784;
      label982:
      M = null;
    }
  }
  
  public final String a(String paramString1, String paramString2)
  {
    return an.a(l, paramString1, paramString2);
  }
  
  final HttpResponse a(HttpUriRequest paramHttpUriRequest)
  {
    try
    {
      if (ghz.a(getContext().getContentResolver(), "gmail_enable_conscrypt_provider", true)) {
        gcc.a(getContext());
      }
      AndroidHttpClient.modifyRequestToAcceptGzipResponse(paramHttpUriRequest);
      HttpResponse localHttpResponse;
      return a(paramHttpUriRequest, true);
    }
    catch (eij paramHttpUriRequest)
    {
      try
      {
        localHttpResponse = a(paramHttpUriRequest, false);
        return localHttpResponse;
      }
      catch (dsj localdsj)
      {
        dri.b(b, "Authentication error, token invalidated, retrying", new Object[0]);
      }
      paramHttpUriRequest = paramHttpUriRequest;
      dri.e(b, paramHttpUriRequest, "Repairable error from installIfNeeded, in runHttpRequest", new Object[0]);
      eik.a(a, getContext());
      throw new dsl("Error from runHttpRequest", paramHttpUriRequest);
    }
    catch (eii paramHttpUriRequest)
    {
      dri.e(b, paramHttpUriRequest, "Unrecoverable error from installIfNeeded, in runHttpRequest", new Object[0]);
      throw new dsl("Error from runHttpRequest", paramHttpUriRequest);
    }
  }
  
  public final void a()
  {
    r.a();
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    int i1;
    if (A()) {
      i1 = 1;
    }
    synchronized (t)
    {
      for (;;)
      {
        i1 = chh.a(i1, paramInt1);
        if (i1 != u)
        {
          u = i1;
          x();
        }
        String str = chk.a(paramInt1);
        ??? = str;
        if (paramInt2 == 0) {
          break label226;
        }
        str = String.valueOf(str);
        switch (paramInt2)
        {
        default: 
          throw new IllegalArgumentException(42 + "Invalid LastSyncResultDetails: " + paramInt2);
          if (z())
          {
            i1 = 2;
          }
          else
          {
            if (!y()) {
              break label154;
            }
            i1 = 4;
          }
          break;
        }
      }
      label154:
      i1 = 0;
    }
    ??? = "no_details";
    for (;;)
    {
      ??? = String.valueOf(???);
      ??? = String.valueOf(localObject2).length() + 1 + String.valueOf(???).length() + (String)localObject2 + "/" + (String)???;
      label226:
      but localbut = buo.a();
      if ((chh.a(paramInt1)) && (localbut.a())) {
        localbut.a("sync", "all_sync_errors", (String)???, 0L);
      }
      if (localbut.b()) {
        localbut.a("sync", "last_sync_result", (String)???, 0L);
      }
      if ((a != null) && (chh.a(paramInt1))) {
        a.a(paramInt1);
      }
      if ((paramInt1 == 1) && (P()))
      {
        ??? = new NetworkQualityReport();
        h = true;
        a((NetworkQualityReport)???);
      }
      return;
      ??? = "mail_engine_sync";
      continue;
      ??? = "sync_thread";
      continue;
      ??? = "network_cursor_logic";
      continue;
      ??? = "conversation_cursor_logic";
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    synchronized (t)
    {
      if (ap.get(paramInt) != paramBoolean)
      {
        ap.set(paramInt, paramBoolean);
        x();
      }
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    r.a(A);
    try
    {
      h(o.a(paramLong1, paramLong2));
      r.c();
      return;
    }
    finally
    {
      r.d();
    }
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean)
  {
    a(paramLong1, paramLong2, paramString, paramBoolean, 1);
  }
  
  public final void a(long paramLong1, long paramLong2, String paramString, boolean paramBoolean, int paramInt)
  {
    int i1 = 0;
    HashSet localHashSet = new HashSet();
    r.a(A);
    try
    {
      drk localdrk = o.a(paramString);
      if (localdrk != null)
      {
        localHashSet.add(Long.valueOf(a));
        o.a(paramLong1, paramLong2, localdrk, paramBoolean, paramInt);
        h(paramLong1);
        r.c();
        i1 = 1;
      }
      r.d();
      if (i1 != 0)
      {
        b(true);
        a(localHashSet);
      }
      if ((!paramBoolean) && ("^u".equals(paramString))) {
        a(false);
      }
      return;
    }
    finally
    {
      r.d();
    }
  }
  
  public final void a(long paramLong, String paramString)
  {
    int i1 = n.b(paramLong);
    if (i1 != -1) {
      buo.a().a("gmail_send", paramString, Integer.toString(i1), 0L);
    }
    paramString = b(paramLong, false);
    if (paramString != null)
    {
      dqc localdqc = X;
      if ((o.contains(Long.valueOf(localdqc.m()))) && (!o.contains(Long.valueOf(localdqc.p())))) {
        a(paramLong, localdqc.p());
      }
    }
  }
  
  final void a(long paramLong, String paramString1, String paramString2, Long paramLong1, boolean paramBoolean)
  {
    Long localLong = (Long)aE.get(paramString1);
    if ((localLong != null) && (localLong.longValue() >= paramLong)) {
      return;
    }
    aE.put(paramString1, Long.valueOf(paramLong));
    paramString1 = new drv(this, paramString2, paramLong1, paramBoolean, paramString1, paramLong);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramString1.run();
      return;
    }
    new drw(this, paramString1).execute(null);
  }
  
  public final void a(long paramLong, String paramString, boolean paramBoolean)
  {
    Object localObject = i(paramLong);
    if (localObject == null)
    {
      dri.d(b, "setLabelOnLocalMessage returning because message pair does not exist: %d", new Object[] { Long.valueOf(paramLong) });
      return;
    }
    long l1 = a;
    long l2 = b;
    localObject = o.a(paramString);
    if (localObject == null)
    {
      dri.d(b, "setLabelOnLocalMessage returning because label does not exist: %s", new Object[] { paramString });
      return;
    }
    r.a(A);
    try
    {
      o.a(l1, (drk)localObject, paramBoolean, 1);
      a(l2, 4, j(paramLong), true, false);
      r.c();
      return;
    }
    finally
    {
      r.d();
      b(true);
    }
  }
  
  public final void a(Handler paramHandler, dss paramdss)
  {
    synchronized (E)
    {
      if (C)
      {
        b(paramHandler, paramdss);
        return;
      }
      if (D == null) {
        D = new ArrayList();
      }
      D.add(new Pair(paramHandler, paramdss));
    }
  }
  
  public final void a(duh paramduh)
  {
    SQLiteDatabase localSQLiteDatabase = n.c;
    ContentValues localContentValues = new ContentValues(9);
    localContentValues.put("action", "organicEvent");
    localContentValues.put("message_messageId", Integer.valueOf(0));
    localContentValues.put("value1", Long.valueOf(b));
    localContentValues.put("value2", Long.valueOf(c));
    localContentValues.put("value3", Integer.toString(d));
    localContentValues.put("value4", paramduh.a());
    String str;
    if (f == null)
    {
      str = "";
      localContentValues.put("value5", str);
      if (g != null) {
        break label260;
      }
      str = "";
      label130:
      localContentValues.put("value6", str);
      if (h != null) {
        break label274;
      }
      str = "";
      label150:
      localContentValues.put("value7", str);
      localContentValues.put("value8", Integer.toString(i));
      if (j != null) {
        break label288;
      }
      str = "";
      label185:
      localContentValues.put("value9", str);
      if (k != null) {
        break label302;
      }
      str = "";
      label205:
      localContentValues.put("value10", str);
      if (l != null) {
        break label316;
      }
    }
    label260:
    label274:
    label288:
    label302:
    label316:
    for (paramduh = "";; paramduh = l)
    {
      localContentValues.put("value11", paramduh);
      localSQLiteDatabase.insert("operations", null, localContentValues);
      return;
      str = Long.toString(f.longValue());
      break;
      str = Integer.toString(g.intValue());
      break label130;
      str = Boolean.toString(h.booleanValue());
      break label150;
      str = Integer.toString(j.intValue());
      break label185;
      str = Integer.toString(k.intValue());
      break label205;
    }
  }
  
  public final void a(Runnable paramRunnable)
  {
    if ((!P) && (!h)) {
      W.post(paramRunnable);
    }
  }
  
  public final void a(Thread paramThread)
  {
    if (paramThread != null)
    {
      D();
      paramThread.interrupt();
    }
    try
    {
      paramThread.join();
      return;
    }
    catch (InterruptedException paramThread) {}
  }
  
  public final void a(Set<Long> paramSet)
  {
    if ((p != null) && (p.inTransaction()))
    {
      dqv localdqv = A;
      if (!c.inTransaction()) {
        dri.e(dqv.a, "Must already be in a transaction with listener to add label to notify. (ids=%s)", new Object[] { paramSet });
      }
      while (!localdqv.b().addAll(paramSet)) {
        return;
      }
      dri.b(dqv.a, "adding labelIds (%s) to notify", new Object[] { paramSet });
      return;
    }
    b(paramSet);
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((p != null) && (p.inTransaction()))
    {
      localObject1 = A;
      if (!c.inTransaction()) {
        dri.e(dqv.a, "Must already be in a transaction with listener to add send notification intents. (force=%b)", new Object[] { Boolean.valueOf(paramBoolean) });
      }
    }
    while (p == null) {
      for (;;)
      {
        return;
        localObject1 = (dqx)b.get();
        if (paramBoolean) {}
        for (i1 = 2; i1 > e; i1 = 1)
        {
          e = i1;
          return;
        }
      }
    }
    r.a();
    do
    {
      try
      {
        X.a.requery();
        r.c();
        r.d();
        localIterator = new HashSet(y.keySet()).iterator();
      }
      finally
      {
        for (;;)
        {
          try
          {
            Iterator localIterator;
            long l3;
            drk localdrk;
            String str2;
            String str3;
            int i3;
            long l4;
            int i4;
            long l1;
            long l2;
            Intent localIntent;
            Object localObject4 = String.valueOf(b);
            localObject1 = localIntent;
            if (((String)localObject4).length() != 0)
            {
              localObject1 = localIntent;
              localObject4 = "label:".concat((String)localObject4);
              localObject1 = localIntent;
              localObject4 = a((String)localObject4, aj, Integer.valueOf(1), false);
              localObject1 = localObject4;
              if (((Cursor)localObject4).moveToFirst())
              {
                localObject1 = localObject4;
                l1 = ((Cursor)localObject4).getLong(((Cursor)localObject4).getColumnIndex("maxMessageId"));
              }
              l2 = l1;
              if (localObject4 != null)
              {
                ((Cursor)localObject4).close();
                l2 = l1;
              }
              if ((l2 != 0L) && (l2 > l4))
              {
                i2 = 1;
                if ((i3 != i1) || (i2 != 0) || (bool) || (paramBoolean))
                {
                  if ((!paramBoolean) && ((i1 <= 0) || (i2 == 0))) {
                    break label1078;
                  }
                  bool = true;
                  dri.b(b, "sending notification. Adjusted values are label=%d, oldCount=%d, newCount=%d, unseenCount=%d, getAttention=%b", new Object[] { Long.valueOf(l3), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(i4), Boolean.valueOf(bool) });
                  localObject1 = drj.a(o.c(l3));
                  localObject4 = drj.a(localdrk);
                  localIntent = new Intent("com.android.mail.action.update_notification");
                  localIntent.setType("application/gmail-ls");
                  localIntent.putExtra("notification_extra_folder", GmailProvider.a(l.name, (String)localObject1));
                  localIntent.putExtra("notification_extra_account", GmailProvider.b(l.name));
                  localIntent.putExtra("notification_updated_unread_count", i1);
                  localIntent.putExtra("account", l.name);
                  localIntent.putExtra("count", i1);
                  localIntent.putExtra("unseenCount", i4);
                  localIntent.putExtra("getAttention", bool);
                  localIntent.putExtra("tagLabel", (String)localObject4);
                  localIntent.putExtra("notificationLabel", (String)localObject1);
                  dri.b(b, "Sending notification intent: %s / %s", new Object[] { localIntent, localIntent.getExtras() });
                  if (S != null) {
                    S.acquire(2000L);
                  }
                  k.sendOrderedBroadcast(localIntent, null);
                  localObject4 = String.valueOf("content://gmail-ls/unread/");
                  localObject1 = String.valueOf(dri.c((String)localObject1));
                  if (((String)localObject1).length() == 0) {
                    break label1084;
                  }
                  localObject1 = ((String)localObject4).concat((String)localObject1);
                  localObject1 = new Intent("android.intent.action.PROVIDER_CHANGED", Uri.parse((String)localObject1));
                  ((Intent)localObject1).putExtra("count", i1);
                  dri.c(b, "Sending provider changed intent: %s", new Object[] { localObject1 });
                  k.sendBroadcast((Intent)localObject1);
                }
                y.put(Long.valueOf(l3), Boolean.valueOf(false));
                if (i3 != i1) {
                  b(str2, Integer.toString(i1));
                }
                if ((l2 == 0L) || (l2 <= l4)) {
                  continue;
                }
                b(str3, Long.toString(l2));
                continue;
                localObject2 = finally;
                r.d();
                throw ((Throwable)localObject2);
              }
            }
            else
            {
              localObject3 = localIntent;
              localObject4 = new String("label:");
              continue;
            }
            int i2 = 0;
          }
          finally
          {
            if (localObject3 != null) {
              ((Cursor)localObject3).close();
            }
          }
          continue;
          boolean bool = false;
          continue;
          Object localObject3 = new String(str1);
        }
      }
      if (!localIterator.hasNext()) {
        break;
      }
      l3 = ((Long)localIterator.next()).longValue();
      localdrk = a(l3);
    } while (localdrk == null);
    localObject1 = String.valueOf("notificationLabelCount-");
    str2 = String.valueOf(localObject1).length() + 20 + (String)localObject1 + l3;
    localObject1 = String.valueOf("notificationLabelMaxMessageId-");
    str3 = String.valueOf(localObject1).length() + 20 + (String)localObject1 + l3;
    i3 = a(str2, Integer.valueOf(0)).intValue();
    l4 = a(str3, Long.valueOf(0L)).longValue();
    i4 = X.a(a);
    i1 = X.a(l3);
    bool = ((Boolean)y.get(Long.valueOf(l3))).booleanValue();
    dri.a(b, "considering sending notification. label=%d, oldUnreadCount=%d, newUnreadCount=%d, unseenCount=%d, getAttention=%b", new Object[] { Long.valueOf(l3), Integer.valueOf(i3), Integer.valueOf(i1), Integer.valueOf(i4), Boolean.valueOf(bool) });
    if ((i4 == 0) || (i1 == 0))
    {
      bool = false;
      i1 = 0;
      l1 = 0L;
      l2 = l1;
      if (i1 > 0)
      {
        localIntent = null;
        localObject1 = localIntent;
      }
    }
  }
  
  public final void a(ContentValues[] paramArrayOfContentValues, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    int i2 = paramArrayOfContentValues.length;
    int i1 = 0;
    Object localObject3;
    long l1;
    Object localObject2;
    while (i1 < i2)
    {
      localObject3 = paramArrayOfContentValues[i1];
      if (!((ContentValues)localObject3).containsKey("conversation")) {
        throw new IllegalArgumentException("values must have 'conversation'");
      }
      l1 = ((ContentValues)localObject3).getAsLong("conversation").longValue();
      localObject2 = (List)localHashMap.get(Long.valueOf(l1));
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        localHashMap.put(Long.valueOf(l1), localObject1);
      }
      ((List)localObject1).add(localObject3);
      i1 += 1;
    }
    Object localObject1 = new HashSet();
    r.a(A);
    if (paramBoolean) {}
    label607:
    label627:
    label667:
    label673:
    for (;;)
    {
      Object localObject4;
      try
      {
        r.b();
        paramArrayOfContentValues = localHashMap.keySet().iterator();
        if (!paramArrayOfContentValues.hasNext()) {
          break label627;
        }
        localObject2 = (Long)paramArrayOfContentValues.next();
        localObject3 = (List)localHashMap.get(localObject2);
        i1 = 0;
        paramBoolean = false;
        localObject3 = ((List)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label607;
        }
        localObject4 = (ContentValues)((Iterator)localObject3).next();
        if (!((ContentValues)localObject4).containsKey("canonicalName")) {
          throw new IllegalArgumentException("values must have 'canonicalName'");
        }
      }
      finally
      {
        r.d();
        b(true);
        a((Set)localObject1);
      }
      String str = ((ContentValues)localObject4).getAsString("canonicalName");
      if (!((ContentValues)localObject4).containsKey("_id")) {
        throw new IllegalArgumentException("values must have '_id'");
      }
      l1 = ((ContentValues)localObject4).getAsLong("_id").longValue();
      if (!((ContentValues)localObject4).containsKey("messageId")) {
        throw new IllegalArgumentException("values must have 'messageId'");
      }
      long l2 = ((ContentValues)localObject4).getAsLong("messageId").longValue();
      dsx localdsx = i(l1);
      if ((localdsx != null) && (b == ((Long)localObject2).longValue())) {
        if (a != l2) {
          break label667;
        }
      }
      for (;;)
      {
        if (!((ContentValues)localObject4).containsKey("add_label_action")) {
          throw new IllegalArgumentException("values must have 'add_label_action'");
        }
        boolean bool = ((ContentValues)localObject4).getAsBoolean("add_label_action").booleanValue();
        dri.b(b, "MailProvider.insert(): adding or removing label %s to local message %d operation (is add) = %b", new Object[] { str, Long.valueOf(l1), Boolean.valueOf(bool) });
        if (!dpy.j(str))
        {
          paramArrayOfContentValues = String.valueOf(str);
          if (paramArrayOfContentValues.length() != 0) {}
          for (paramArrayOfContentValues = "label is not user-settable: ".concat(paramArrayOfContentValues);; paramArrayOfContentValues = new String("label is not user-settable: ")) {
            throw new IllegalArgumentException(paramArrayOfContentValues);
          }
        }
        localObject4 = o.a(str);
        if (localObject4 != null)
        {
          ((Set)localObject1).add(Long.valueOf(a));
          o.a(l2, (drk)localObject4, bool, 1);
          if (i2 == 0) {
            o.a(((Long)localObject2).longValue(), l2, (drk)localObject4, bool, 0);
          }
          if (!paramBoolean)
          {
            paramBoolean = j(l1);
            i1 = 1;
            break label673;
            if (i1 == 0) {
              break;
            }
            a(((Long)localObject2).longValue(), 4, paramBoolean, true, false);
            break;
            r.c();
            r.d();
            b(true);
            a((Set)localObject1);
            return;
          }
          i1 = 1;
          break label673;
        }
        break label673;
        i2 = 1;
        continue;
        i2 = 0;
      }
    }
  }
  
  public final boolean a(ContentValues paramContentValues)
  {
    Long localLong2 = null;
    dtn localdtn = m;
    String str1;
    String str2;
    if (paramContentValues.containsKey("labelsIncluded"))
    {
      str1 = paramContentValues.getAsString("labelsIncluded");
      if (!paramContentValues.containsKey("labelsPartial")) {
        break label100;
      }
      str2 = paramContentValues.getAsString("labelsPartial");
      label45:
      if (!paramContentValues.containsKey("conversationAgeDays")) {
        break label105;
      }
    }
    label100:
    label105:
    for (Long localLong1 = paramContentValues.getAsLong("conversationAgeDays");; localLong1 = null)
    {
      if (paramContentValues.containsKey("maxAttachmentSize")) {
        localLong2 = paramContentValues.getAsLong("maxAttachmentSize");
      }
      return localdtn.a(str1, str2, localLong1, localLong2);
      str1 = null;
      break;
      str2 = null;
      break label45;
    }
  }
  
  public final boolean a(Folder paramFolder)
  {
    if (paramFolder == null) {}
    do
    {
      return false;
      if ((v.j()) && (Advertisement.b.contains(Integer.valueOf(Advertisement.a(paramFolder))))) {
        return true;
      }
    } while ((!v.i()) || (Advertisement.a(paramFolder) != 0));
    return true;
  }
  
  /* Error */
  final boolean a(dsu paramdsu, dtd paramdtd, android.content.SyncResult paramSyncResult, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 2721	dqu
    //   3: dup
    //   4: aload_0
    //   5: getfield 491	drp:k	Landroid/content/Context;
    //   8: aload_0
    //   9: getfield 507	drp:l	Landroid/accounts/Account;
    //   12: getfield 1132	android/accounts/Account:name	Ljava/lang/String;
    //   15: aload_2
    //   16: iload 4
    //   18: invokespecial 3080	dqu:<init>	(Landroid/content/Context;Ljava/lang/String;Ldtd;Z)V
    //   21: astore 20
    //   23: aload_0
    //   24: getfield 2719	drp:a	Ldqu;
    //   27: ifnull +15 -> 42
    //   30: aload 20
    //   32: aload_0
    //   33: getfield 2719	drp:a	Ldqu;
    //   36: getfield 3084	cgu:n	J
    //   39: putfield 3086	cgu:s	J
    //   42: invokestatic 1937	dmv:a	()Ldmv;
    //   45: aload_0
    //   46: invokevirtual 1435	drp:getContext	()Landroid/content/Context;
    //   49: aconst_null
    //   50: ldc_w 3088
    //   53: ldc2_w 1737
    //   56: invokevirtual 3091	dmv:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;J)J
    //   59: lstore 8
    //   61: lload 8
    //   63: ldc2_w 1737
    //   66: lcmp
    //   67: ifeq +434 -> 501
    //   70: invokestatic 1984	java/lang/System:currentTimeMillis	()J
    //   73: lload 8
    //   75: lsub
    //   76: lstore 8
    //   78: aload_2
    //   79: getfield 3094	dtd:b	Z
    //   82: ifeq +427 -> 509
    //   85: ldc_w 3095
    //   88: istore 5
    //   90: aload_0
    //   91: getfield 507	drp:l	Landroid/accounts/Account;
    //   94: getfield 1132	android/accounts/Account:name	Ljava/lang/String;
    //   97: invokestatic 3099	ddh:a	(Ljava/lang/String;)I
    //   100: iload 5
    //   102: ior
    //   103: invokestatic 3104	android/net/TrafficStats:setThreadStatsTag	(I)V
    //   106: invokestatic 414	android/os/SystemClock:elapsedRealtime	()J
    //   109: lstore 10
    //   111: getstatic 150	drp:b	Ljava/lang/String;
    //   114: ldc_w 3106
    //   117: iconst_1
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: aload_2
    //   124: getfield 3107	dtd:a	Z
    //   127: invokestatic 1292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   130: aastore
    //   131: invokestatic 1619	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   134: pop
    //   135: aload_2
    //   136: getfield 3094	dtd:b	Z
    //   139: ifne +378 -> 517
    //   142: iload 4
    //   144: ifne +373 -> 517
    //   147: iconst_1
    //   148: istore 4
    //   150: aload_2
    //   151: getfield 3107	dtd:a	Z
    //   154: ifeq +375 -> 529
    //   157: iload 4
    //   159: ifeq +370 -> 529
    //   162: aload_0
    //   163: invokevirtual 1435	drp:getContext	()Landroid/content/Context;
    //   166: invokevirtual 788	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   169: ldc_w 3109
    //   172: bipush 100
    //   174: invokestatic 949	ghz:a	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   177: istore 6
    //   179: new 3111	java/util/Random
    //   182: dup
    //   183: invokespecial 3112	java/util/Random:<init>	()V
    //   186: iload 6
    //   188: invokevirtual 3115	java/util/Random:nextInt	(I)I
    //   191: iconst_1
    //   192: iadd
    //   193: iload 6
    //   195: irem
    //   196: ifne +327 -> 523
    //   199: iconst_1
    //   200: istore 6
    //   202: goto +1246 -> 1448
    //   205: aload_0
    //   206: getfield 901	drp:m	Ldtn;
    //   209: iload 4
    //   211: aload_2
    //   212: aconst_null
    //   213: aload_0
    //   214: getfield 2719	drp:a	Ldqu;
    //   217: iload 7
    //   219: invokevirtual 3118	dtn:a	(ZLdtd;Ljava/util/ArrayList;Ldqu;Z)Ldut;
    //   222: astore 19
    //   224: aload 20
    //   226: iload 7
    //   228: putfield 3120	dqu:g	Z
    //   231: aload 19
    //   233: ifnull +302 -> 535
    //   236: aload 19
    //   238: getfield 1531	dut:a	Lorg/apache/http/client/methods/HttpUriRequest;
    //   241: astore 16
    //   243: aload_0
    //   244: aload 20
    //   246: putfield 2719	drp:a	Ldqu;
    //   249: iconst_0
    //   250: istore 7
    //   252: aload_0
    //   253: getfield 491	drp:k	Landroid/content/Context;
    //   256: invokevirtual 788	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   259: ldc_w 3122
    //   262: bipush 50
    //   264: invokestatic 949	ghz:a	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   267: istore 6
    //   269: aload 19
    //   271: astore 17
    //   273: aload 16
    //   275: astore 18
    //   277: iload 7
    //   279: istore 4
    //   281: aload 16
    //   283: ifnull +85 -> 368
    //   286: aload 19
    //   288: astore 17
    //   290: aload 16
    //   292: astore 18
    //   294: iload 7
    //   296: istore 4
    //   298: aload_0
    //   299: invokevirtual 1435	drp:getContext	()Landroid/content/Context;
    //   302: invokevirtual 788	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   305: ldc_w 3124
    //   308: getstatic 3128	cuu:b	Ljava/lang/Boolean;
    //   311: invokevirtual 2866	java/lang/Boolean:booleanValue	()Z
    //   314: invokestatic 2663	ghz:a	(Landroid/content/ContentResolver;Ljava/lang/String;Z)Z
    //   317: ifeq +51 -> 368
    //   320: invokestatic 414	android/os/SystemClock:elapsedRealtime	()J
    //   323: lstore 12
    //   325: aload 16
    //   327: invokeinterface 3132 1 0
    //   332: invokevirtual 3137	java/net/URI:getHost	()Ljava/lang/String;
    //   335: invokestatic 3143	java/net/InetAddress:getByName	(Ljava/lang/String;)Ljava/net/InetAddress;
    //   338: pop
    //   339: invokestatic 414	android/os/SystemClock:elapsedRealtime	()J
    //   342: lstore 14
    //   344: aload_0
    //   345: getfield 2719	drp:a	Ldqu;
    //   348: lload 14
    //   350: lload 12
    //   352: lsub
    //   353: putfield 3145	cgu:t	J
    //   356: iload 7
    //   358: istore 4
    //   360: aload 16
    //   362: astore 18
    //   364: aload 19
    //   366: astore 17
    //   368: aload 18
    //   370: ifnull +334 -> 704
    //   373: aload_0
    //   374: getfield 1541	drp:F	Z
    //   377: ifne +327 -> 704
    //   380: invokestatic 414	android/os/SystemClock:elapsedRealtime	()J
    //   383: aload_0
    //   384: getfield 416	drp:av	J
    //   387: lsub
    //   388: ldc2_w 3146
    //   391: lcmp
    //   392: ifle +15 -> 407
    //   395: aload_0
    //   396: iconst_0
    //   397: putfield 408	drp:au	I
    //   400: aload_0
    //   401: invokestatic 414	android/os/SystemClock:elapsedRealtime	()J
    //   404: putfield 416	drp:av	J
    //   407: aload_0
    //   408: getfield 408	drp:au	I
    //   411: iload 6
    //   413: if_icmple +128 -> 541
    //   416: aload_0
    //   417: iconst_1
    //   418: putfield 1541	drp:F	Z
    //   421: aload_3
    //   422: ifnull +10 -> 432
    //   425: aload_3
    //   426: ldc2_w 3148
    //   429: putfield 3154	android/content/SyncResult:delayUntil	J
    //   432: new 3073	dtf
    //   435: dup
    //   436: aload_0
    //   437: getfield 408	drp:au	I
    //   440: iload 6
    //   442: invokespecial 3156	dtf:<init>	(II)V
    //   445: athrow
    //   446: astore_2
    //   447: aload_0
    //   448: aload_2
    //   449: invokespecial 3158	drp:a	(Ljava/lang/Exception;)V
    //   452: aload 20
    //   454: aload_2
    //   455: putfield 3161	dqu:k	Ljava/lang/Exception;
    //   458: aload_2
    //   459: athrow
    //   460: astore_2
    //   461: aload_1
    //   462: ifnull +12 -> 474
    //   465: iload 5
    //   467: aload_1
    //   468: getfield 3164	dsu:a	I
    //   471: invokestatic 3167	android/net/TrafficStats:incrementOperationCount	(II)V
    //   474: invokestatic 3170	android/net/TrafficStats:clearThreadStatsTag	()V
    //   477: aload_0
    //   478: getfield 901	drp:m	Ldtn;
    //   481: invokevirtual 3171	dtn:e	()V
    //   484: invokestatic 1937	dmv:a	()Ldmv;
    //   487: aload_0
    //   488: invokevirtual 1435	drp:getContext	()Landroid/content/Context;
    //   491: invokevirtual 3173	dmv:k	(Landroid/content/Context;)V
    //   494: aload 20
    //   496: invokevirtual 3174	dqu:d	()V
    //   499: aload_2
    //   500: athrow
    //   501: ldc2_w 1737
    //   504: lstore 8
    //   506: goto -428 -> 78
    //   509: ldc_w 3175
    //   512: istore 5
    //   514: goto -424 -> 90
    //   517: iconst_0
    //   518: istore 4
    //   520: goto -370 -> 150
    //   523: iconst_0
    //   524: istore 6
    //   526: goto +922 -> 1448
    //   529: iconst_0
    //   530: istore 7
    //   532: goto -327 -> 205
    //   535: aconst_null
    //   536: astore 16
    //   538: goto -295 -> 243
    //   541: aload 17
    //   543: getfield 3178	dut:b	Lduv;
    //   546: astore 16
    //   548: aload_0
    //   549: aload 18
    //   551: aload_1
    //   552: aload_2
    //   553: aload 20
    //   555: aload 16
    //   557: invokespecial 1575	drp:a	(Lorg/apache/http/client/methods/HttpUriRequest;Ldsu;Ldtd;Ldqu;Lduv;)Z
    //   560: istore 7
    //   562: iload 4
    //   564: iload 7
    //   566: ior
    //   567: istore 4
    //   569: aload 20
    //   571: getfield 3180	dqu:d	Ljava/util/List;
    //   574: aload 16
    //   576: invokeinterface 1177 2 0
    //   581: pop
    //   582: aload_0
    //   583: getfield 901	drp:m	Ldtn;
    //   586: aload_2
    //   587: aconst_null
    //   588: invokevirtual 1526	dtn:a	(Ldtd;Ljava/util/ArrayList;)Ldut;
    //   591: astore 17
    //   593: aload 17
    //   595: ifnull +103 -> 698
    //   598: aload 17
    //   600: getfield 1531	dut:a	Lorg/apache/http/client/methods/HttpUriRequest;
    //   603: astore 16
    //   605: aload_0
    //   606: aload_0
    //   607: getfield 408	drp:au	I
    //   610: iconst_1
    //   611: iadd
    //   612: putfield 408	drp:au	I
    //   615: aload 16
    //   617: astore 18
    //   619: goto -251 -> 368
    //   622: aload_0
    //   623: getfield 870	drp:v	Ldth;
    //   626: aload_2
    //   627: invokeinterface 3183 2 0
    //   632: astore 17
    //   634: aload 17
    //   636: invokevirtual 1537	java/util/ArrayList:size	()I
    //   639: ifle +35 -> 674
    //   642: getstatic 150	drp:b	Ljava/lang/String;
    //   645: aload 16
    //   647: ldc_w 3185
    //   650: iconst_0
    //   651: anewarray 4	java/lang/Object
    //   654: invokestatic 1561	dri:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   657: pop
    //   658: iload 4
    //   660: aload_0
    //   661: aload_2
    //   662: aload_1
    //   663: aload 17
    //   665: invokespecial 3187	drp:a	(Ldtd;Ldsu;Ljava/util/ArrayList;)Z
    //   668: ior
    //   669: istore 4
    //   671: goto -89 -> 582
    //   674: aload 16
    //   676: athrow
    //   677: astore_2
    //   678: aload_0
    //   679: lload 10
    //   681: iconst_0
    //   682: invokespecial 3189	drp:c	(JZ)V
    //   685: aload_0
    //   686: aload_2
    //   687: invokespecial 3158	drp:a	(Ljava/lang/Exception;)V
    //   690: aload 20
    //   692: aload_2
    //   693: putfield 3161	dqu:k	Ljava/lang/Exception;
    //   696: aload_2
    //   697: athrow
    //   698: aconst_null
    //   699: astore 16
    //   701: goto -96 -> 605
    //   704: aload_0
    //   705: getfield 901	drp:m	Ldtn;
    //   708: ldc_w 1080
    //   711: invokevirtual 906	dtn:a	(Ljava/lang/String;)J
    //   714: lstore 12
    //   716: aload_0
    //   717: getfield 491	drp:k	Landroid/content/Context;
    //   720: invokevirtual 788	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   723: astore_2
    //   724: invokestatic 956	android/content/ContentResolver:getMasterSyncAutomatically	()Z
    //   727: ifeq +10 -> 737
    //   730: aload_0
    //   731: invokevirtual 958	drp:j	()Z
    //   734: ifne +360 -> 1094
    //   737: aload_0
    //   738: getfield 507	drp:l	Landroid/accounts/Account;
    //   741: getfield 1132	android/accounts/Account:name	Ljava/lang/String;
    //   744: astore 16
    //   746: aload_0
    //   747: getfield 507	drp:l	Landroid/accounts/Account;
    //   750: getfield 3192	android/accounts/Account:type	Ljava/lang/String;
    //   753: astore 17
    //   755: aload_2
    //   756: getstatic 3196	gif:a	Landroid/net/Uri;
    //   759: ldc_w 3198
    //   762: iconst_3
    //   763: anewarray 152	java/lang/String
    //   766: dup
    //   767: iconst_0
    //   768: ldc_w 1426
    //   771: aastore
    //   772: dup
    //   773: iconst_1
    //   774: aload 16
    //   776: aastore
    //   777: dup
    //   778: iconst_2
    //   779: aload 17
    //   781: aastore
    //   782: invokevirtual 3201	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   785: pop
    //   786: aload_0
    //   787: invokevirtual 3203	drp:v	()V
    //   790: aload_0
    //   791: getfield 901	drp:m	Ldtn;
    //   794: invokevirtual 912	dtn:g	()V
    //   797: invokestatic 1984	java/lang/System:currentTimeMillis	()J
    //   800: lstore 12
    //   802: lload 12
    //   804: ldc2_w 926
    //   807: lrem
    //   808: lconst_0
    //   809: lcmp
    //   810: ifne +13 -> 823
    //   813: aload_0
    //   814: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   817: ldc_w 3205
    //   820: invokevirtual 3208	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   823: aload_0
    //   824: getfield 491	drp:k	Landroid/content/Context;
    //   827: ldc_w 3210
    //   830: invokevirtual 3213	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   833: checkcast 3215	android/os/PowerManager
    //   836: invokevirtual 3218	android/os/PowerManager:isScreenOn	()Z
    //   839: ifeq +597 -> 1436
    //   842: ldc_w 3220
    //   845: astore_2
    //   846: invokestatic 414	android/os/SystemClock:elapsedRealtime	()J
    //   849: lload 10
    //   851: lsub
    //   852: lstore 12
    //   854: invokestatic 1267	buo:a	()Lbut;
    //   857: astore 16
    //   859: aload 20
    //   861: invokevirtual 3221	dqu:a	()Z
    //   864: ifeq +150 -> 1014
    //   867: aload 16
    //   869: invokeinterface 2715 1 0
    //   874: ifeq +140 -> 1014
    //   877: aload 16
    //   879: ldc_w 1483
    //   882: ldc_w 3223
    //   885: aconst_null
    //   886: lconst_1
    //   887: invokeinterface 1285 6 0
    //   892: aload 16
    //   894: ldc_w 1483
    //   897: lload 12
    //   899: ldc_w 3225
    //   902: aload_2
    //   903: invokeinterface 1699 6 0
    //   908: aload 16
    //   910: ldc_w 1483
    //   913: aload 20
    //   915: invokevirtual 3227	dqu:h	()I
    //   918: i2l
    //   919: ldc_w 3229
    //   922: aload_2
    //   923: invokeinterface 3231 6 0
    //   928: aload 16
    //   930: ldc_w 1483
    //   933: aload 20
    //   935: getfield 3233	cgu:r	J
    //   938: ldc_w 3235
    //   941: aload_2
    //   942: invokeinterface 3231 6 0
    //   947: aload 16
    //   949: ldc_w 1483
    //   952: aload 20
    //   954: getfield 3237	cgu:p	J
    //   957: ldc_w 3239
    //   960: aload_2
    //   961: invokeinterface 1699 6 0
    //   966: lload 8
    //   968: lconst_0
    //   969: lcmp
    //   970: ifle +19 -> 989
    //   973: aload 16
    //   975: ldc_w 1483
    //   978: lload 8
    //   980: ldc_w 3241
    //   983: aload_2
    //   984: invokeinterface 1699 6 0
    //   989: aload 16
    //   991: ldc_w 1280
    //   994: lload 12
    //   996: ldc_w 3225
    //   999: aload_0
    //   1000: getfield 684	drp:o	Ldrj;
    //   1003: invokestatic 1205	dms:a	(Ldrj;)Z
    //   1006: invokestatic 3243	dms:a	(Z)Ljava/lang/String;
    //   1009: invokeinterface 1699 6 0
    //   1014: aload_0
    //   1015: lload 10
    //   1017: iconst_1
    //   1018: invokespecial 3189	drp:c	(JZ)V
    //   1021: aload_3
    //   1022: ifnull +12 -> 1034
    //   1025: aload 20
    //   1027: aload_3
    //   1028: invokevirtual 3244	android/content/SyncResult:toString	()Ljava/lang/String;
    //   1031: putfield 3245	dqu:j	Ljava/lang/String;
    //   1034: aload_1
    //   1035: ifnull +12 -> 1047
    //   1038: iload 5
    //   1040: aload_1
    //   1041: getfield 3164	dsu:a	I
    //   1044: invokestatic 3167	android/net/TrafficStats:incrementOperationCount	(II)V
    //   1047: invokestatic 3170	android/net/TrafficStats:clearThreadStatsTag	()V
    //   1050: aload_0
    //   1051: getfield 901	drp:m	Ldtn;
    //   1054: invokevirtual 3171	dtn:e	()V
    //   1057: invokestatic 1937	dmv:a	()Ldmv;
    //   1060: aload_0
    //   1061: invokevirtual 1435	drp:getContext	()Landroid/content/Context;
    //   1064: invokevirtual 3173	dmv:k	(Landroid/content/Context;)V
    //   1067: aload 20
    //   1069: invokevirtual 3174	dqu:d	()V
    //   1072: iload 4
    //   1074: ireturn
    //   1075: astore_2
    //   1076: getstatic 150	drp:b	Ljava/lang/String;
    //   1079: aload_2
    //   1080: ldc_w 3247
    //   1083: iconst_0
    //   1084: anewarray 4	java/lang/Object
    //   1087: invokestatic 834	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1090: pop
    //   1091: goto -305 -> 786
    //   1094: lload 12
    //   1096: lconst_0
    //   1097: lcmp
    //   1098: ifeq -312 -> 786
    //   1101: aload_0
    //   1102: getfield 519	drp:at	Ldvd;
    //   1105: getfield 3250	dvd:c	Ljava/net/URI;
    //   1108: invokevirtual 3251	java/net/URI:toString	()Ljava/lang/String;
    //   1111: invokestatic 1270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1114: astore 16
    //   1116: ldc_w 3253
    //   1119: invokestatic 1270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1122: astore 17
    //   1124: new 552	java/lang/StringBuilder
    //   1127: dup
    //   1128: aload 16
    //   1130: invokestatic 1270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1133: invokevirtual 1273	java/lang/String:length	()I
    //   1136: bipush 22
    //   1138: iadd
    //   1139: aload 17
    //   1141: invokestatic 1270	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1144: invokevirtual 1273	java/lang/String:length	()I
    //   1147: iadd
    //   1148: invokespecial 555	java/lang/StringBuilder:<init>	(I)V
    //   1151: aload 16
    //   1153: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: ldc_w 3255
    //   1159: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: aload 17
    //   1164: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: ldc_w 3257
    //   1170: invokevirtual 561	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: lload 12
    //   1175: invokevirtual 2927	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1178: invokevirtual 570	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1181: astore 17
    //   1183: iconst_4
    //   1184: anewarray 152	java/lang/String
    //   1187: astore 18
    //   1189: aload 18
    //   1191: iconst_0
    //   1192: ldc_w 1426
    //   1195: aastore
    //   1196: aload 18
    //   1198: iconst_1
    //   1199: aload 17
    //   1201: aastore
    //   1202: aload 18
    //   1204: iconst_2
    //   1205: aload_0
    //   1206: getfield 507	drp:l	Landroid/accounts/Account;
    //   1209: getfield 1132	android/accounts/Account:name	Ljava/lang/String;
    //   1212: aastore
    //   1213: aload 18
    //   1215: iconst_3
    //   1216: aload_0
    //   1217: getfield 507	drp:l	Landroid/accounts/Account;
    //   1220: getfield 3192	android/accounts/Account:type	Ljava/lang/String;
    //   1223: aastore
    //   1224: aload_2
    //   1225: getstatic 3196	gif:a	Landroid/net/Uri;
    //   1228: aconst_null
    //   1229: ldc_w 3259
    //   1232: aload 18
    //   1234: aconst_null
    //   1235: invokevirtual 3262	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1238: astore 16
    //   1240: aload 16
    //   1242: ifnonnull +24 -> 1266
    //   1245: getstatic 150	drp:b	Ljava/lang/String;
    //   1248: ldc_w 3264
    //   1251: iconst_0
    //   1252: anewarray 4	java/lang/Object
    //   1255: invokestatic 648	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1258: pop
    //   1259: goto -473 -> 786
    //   1262: astore_2
    //   1263: goto -585 -> 678
    //   1266: aload 16
    //   1268: invokeinterface 1721 1 0
    //   1273: ifne +104 -> 1377
    //   1276: aload_0
    //   1277: getfield 507	drp:l	Landroid/accounts/Account;
    //   1280: astore 18
    //   1282: new 1378	android/content/ContentValues
    //   1285: dup
    //   1286: invokespecial 1419	android/content/ContentValues:<init>	()V
    //   1289: astore 19
    //   1291: aload 19
    //   1293: ldc_w 3266
    //   1296: aload 17
    //   1298: invokevirtual 1404	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1301: aload 19
    //   1303: ldc_w 3268
    //   1306: aload 18
    //   1308: getfield 1132	android/accounts/Account:name	Ljava/lang/String;
    //   1311: invokevirtual 1404	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1314: aload 19
    //   1316: ldc_w 3270
    //   1319: aload 18
    //   1321: getfield 3192	android/accounts/Account:type	Ljava/lang/String;
    //   1324: invokevirtual 1404	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1327: aload 19
    //   1329: ldc_w 3272
    //   1332: ldc_w 1426
    //   1335: invokevirtual 1404	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1338: aload 19
    //   1340: ldc_w 3274
    //   1343: ldc_w 1259
    //   1346: invokevirtual 1404	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1349: aload_2
    //   1350: getstatic 3196	gif:a	Landroid/net/Uri;
    //   1353: aload 19
    //   1355: invokevirtual 3277	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   1358: pop
    //   1359: aload_0
    //   1360: invokevirtual 1082	drp:k	()V
    //   1363: aload 16
    //   1365: invokeinterface 892 1 0
    //   1370: goto -584 -> 786
    //   1373: astore_2
    //   1374: goto -696 -> 678
    //   1377: aload_2
    //   1378: getstatic 3196	gif:a	Landroid/net/Uri;
    //   1381: ldc_w 3279
    //   1384: aload 18
    //   1386: invokevirtual 3201	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   1389: pop
    //   1390: goto -27 -> 1363
    //   1393: astore_2
    //   1394: aload 16
    //   1396: invokeinterface 892 1 0
    //   1401: aload_2
    //   1402: athrow
    //   1403: astore_2
    //   1404: getstatic 150	drp:b	Ljava/lang/String;
    //   1407: ldc_w 3281
    //   1410: iconst_0
    //   1411: anewarray 4	java/lang/Object
    //   1414: invokestatic 648	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1417: pop
    //   1418: invokestatic 1267	buo:a	()Lbut;
    //   1421: ldc_w 1972
    //   1424: ldc_w 3283
    //   1427: aconst_null
    //   1428: lconst_0
    //   1429: invokeinterface 1285 6 0
    //   1434: aload_2
    //   1435: athrow
    //   1436: ldc_w 3285
    //   1439: astore_2
    //   1440: goto -594 -> 846
    //   1443: astore 16
    //   1445: goto -823 -> 622
    //   1448: iload 6
    //   1450: ifeq -921 -> 529
    //   1453: iconst_1
    //   1454: istore 7
    //   1456: goto -1251 -> 205
    //   1459: astore 16
    //   1461: goto -839 -> 622
    //   1464: astore_2
    //   1465: goto -787 -> 678
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1468	0	this	drp
    //   0	1468	1	paramdsu	dsu
    //   0	1468	2	paramdtd	dtd
    //   0	1468	3	paramSyncResult	android.content.SyncResult
    //   0	1468	4	paramBoolean	boolean
    //   88	951	5	i1	int
    //   177	1272	6	i2	int
    //   217	1238	7	bool	boolean
    //   59	920	8	l1	long
    //   109	907	10	l2	long
    //   323	851	12	l3	long
    //   342	7	14	l4	long
    //   241	1154	16	localObject1	Object
    //   1443	1	16	localSocketTimeoutException1	SocketTimeoutException
    //   1459	1	16	localSocketTimeoutException2	SocketTimeoutException
    //   271	1026	17	localObject2	Object
    //   275	1110	18	localObject3	Object
    //   222	1132	19	localObject4	Object
    //   21	1047	20	localdqu	dqu
    // Exception table:
    //   from	to	target	type
    //   111	142	446	dtf
    //   150	157	446	dtf
    //   162	199	446	dtf
    //   205	231	446	dtf
    //   236	243	446	dtf
    //   243	249	446	dtf
    //   252	269	446	dtf
    //   298	356	446	dtf
    //   373	407	446	dtf
    //   407	421	446	dtf
    //   425	432	446	dtf
    //   432	446	446	dtf
    //   541	562	446	dtf
    //   569	582	446	dtf
    //   582	593	446	dtf
    //   598	605	446	dtf
    //   605	615	446	dtf
    //   622	671	446	dtf
    //   674	677	446	dtf
    //   704	737	446	dtf
    //   737	755	446	dtf
    //   755	786	446	dtf
    //   786	802	446	dtf
    //   813	823	446	dtf
    //   823	842	446	dtf
    //   846	966	446	dtf
    //   973	989	446	dtf
    //   989	1014	446	dtf
    //   1014	1021	446	dtf
    //   1025	1034	446	dtf
    //   1076	1091	446	dtf
    //   1101	1189	446	dtf
    //   1202	1240	446	dtf
    //   1245	1259	446	dtf
    //   1363	1370	446	dtf
    //   1394	1403	446	dtf
    //   1404	1436	446	dtf
    //   111	142	460	finally
    //   150	157	460	finally
    //   162	199	460	finally
    //   205	231	460	finally
    //   236	243	460	finally
    //   243	249	460	finally
    //   252	269	460	finally
    //   298	356	460	finally
    //   373	407	460	finally
    //   407	421	460	finally
    //   425	432	460	finally
    //   432	446	460	finally
    //   447	460	460	finally
    //   541	562	460	finally
    //   569	582	460	finally
    //   582	593	460	finally
    //   598	605	460	finally
    //   605	615	460	finally
    //   622	671	460	finally
    //   674	677	460	finally
    //   678	698	460	finally
    //   704	737	460	finally
    //   737	755	460	finally
    //   755	786	460	finally
    //   786	802	460	finally
    //   813	823	460	finally
    //   823	842	460	finally
    //   846	966	460	finally
    //   973	989	460	finally
    //   989	1014	460	finally
    //   1014	1021	460	finally
    //   1025	1034	460	finally
    //   1076	1091	460	finally
    //   1101	1189	460	finally
    //   1202	1240	460	finally
    //   1245	1259	460	finally
    //   1363	1370	460	finally
    //   1394	1403	460	finally
    //   1404	1436	460	finally
    //   111	142	677	java/io/IOException
    //   150	157	677	java/io/IOException
    //   162	199	677	java/io/IOException
    //   205	231	677	java/io/IOException
    //   236	243	677	java/io/IOException
    //   243	249	677	java/io/IOException
    //   252	269	677	java/io/IOException
    //   298	356	677	java/io/IOException
    //   373	407	677	java/io/IOException
    //   407	421	677	java/io/IOException
    //   425	432	677	java/io/IOException
    //   432	446	677	java/io/IOException
    //   541	562	677	java/io/IOException
    //   569	582	677	java/io/IOException
    //   582	593	677	java/io/IOException
    //   598	605	677	java/io/IOException
    //   605	615	677	java/io/IOException
    //   622	671	677	java/io/IOException
    //   674	677	677	java/io/IOException
    //   704	737	677	java/io/IOException
    //   737	755	677	java/io/IOException
    //   755	786	677	java/io/IOException
    //   786	802	677	java/io/IOException
    //   813	823	677	java/io/IOException
    //   823	842	677	java/io/IOException
    //   846	966	677	java/io/IOException
    //   973	989	677	java/io/IOException
    //   989	1014	677	java/io/IOException
    //   1014	1021	677	java/io/IOException
    //   1025	1034	677	java/io/IOException
    //   1076	1091	677	java/io/IOException
    //   1101	1189	677	java/io/IOException
    //   1202	1240	677	java/io/IOException
    //   1245	1259	677	java/io/IOException
    //   1363	1370	677	java/io/IOException
    //   1394	1403	677	java/io/IOException
    //   1404	1436	677	java/io/IOException
    //   755	786	1075	java/lang/NullPointerException
    //   111	142	1262	dty
    //   150	157	1262	dty
    //   162	199	1262	dty
    //   205	231	1262	dty
    //   236	243	1262	dty
    //   243	249	1262	dty
    //   252	269	1262	dty
    //   298	356	1262	dty
    //   373	407	1262	dty
    //   407	421	1262	dty
    //   425	432	1262	dty
    //   432	446	1262	dty
    //   541	562	1262	dty
    //   569	582	1262	dty
    //   582	593	1262	dty
    //   598	605	1262	dty
    //   605	615	1262	dty
    //   622	671	1262	dty
    //   674	677	1262	dty
    //   704	737	1262	dty
    //   737	755	1262	dty
    //   755	786	1262	dty
    //   786	802	1262	dty
    //   813	823	1262	dty
    //   823	842	1262	dty
    //   846	966	1262	dty
    //   973	989	1262	dty
    //   989	1014	1262	dty
    //   1014	1021	1262	dty
    //   1025	1034	1262	dty
    //   1076	1091	1262	dty
    //   1101	1189	1262	dty
    //   1202	1240	1262	dty
    //   1245	1259	1262	dty
    //   1363	1370	1262	dty
    //   1394	1403	1262	dty
    //   1404	1436	1262	dty
    //   111	142	1373	dsl
    //   150	157	1373	dsl
    //   162	199	1373	dsl
    //   205	231	1373	dsl
    //   236	243	1373	dsl
    //   243	249	1373	dsl
    //   252	269	1373	dsl
    //   298	356	1373	dsl
    //   373	407	1373	dsl
    //   407	421	1373	dsl
    //   425	432	1373	dsl
    //   432	446	1373	dsl
    //   541	562	1373	dsl
    //   569	582	1373	dsl
    //   582	593	1373	dsl
    //   598	605	1373	dsl
    //   605	615	1373	dsl
    //   622	671	1373	dsl
    //   674	677	1373	dsl
    //   704	737	1373	dsl
    //   737	755	1373	dsl
    //   755	786	1373	dsl
    //   786	802	1373	dsl
    //   813	823	1373	dsl
    //   823	842	1373	dsl
    //   846	966	1373	dsl
    //   973	989	1373	dsl
    //   989	1014	1373	dsl
    //   1014	1021	1373	dsl
    //   1025	1034	1373	dsl
    //   1076	1091	1373	dsl
    //   1101	1189	1373	dsl
    //   1202	1240	1373	dsl
    //   1245	1259	1373	dsl
    //   1363	1370	1373	dsl
    //   1394	1403	1373	dsl
    //   1404	1436	1373	dsl
    //   1266	1363	1393	finally
    //   1377	1390	1393	finally
    //   813	823	1403	android/database/SQLException
    //   569	582	1443	java/net/SocketTimeoutException
    //   541	562	1459	java/net/SocketTimeoutException
    //   111	142	1464	dsj
    //   150	157	1464	dsj
    //   162	199	1464	dsj
    //   205	231	1464	dsj
    //   236	243	1464	dsj
    //   243	249	1464	dsj
    //   252	269	1464	dsj
    //   298	356	1464	dsj
    //   373	407	1464	dsj
    //   407	421	1464	dsj
    //   425	432	1464	dsj
    //   432	446	1464	dsj
    //   541	562	1464	dsj
    //   569	582	1464	dsj
    //   582	593	1464	dsj
    //   598	605	1464	dsj
    //   605	615	1464	dsj
    //   622	671	1464	dsj
    //   674	677	1464	dsj
    //   704	737	1464	dsj
    //   737	755	1464	dsj
    //   755	786	1464	dsj
    //   786	802	1464	dsj
    //   813	823	1464	dsj
    //   823	842	1464	dsj
    //   846	966	1464	dsj
    //   973	989	1464	dsj
    //   989	1014	1464	dsj
    //   1014	1021	1464	dsj
    //   1025	1034	1464	dsj
    //   1076	1091	1464	dsj
    //   1101	1189	1464	dsj
    //   1202	1240	1464	dsj
    //   1245	1259	1464	dsj
    //   1363	1370	1464	dsj
    //   1394	1403	1464	dsj
    //   1404	1436	1464	dsj
  }
  
  public final drk[] a(String[] paramArrayOfString)
  {
    drk[] arrayOfdrk = new drk[paramArrayOfString.length];
    int i1 = 0;
    for (;;)
    {
      if (i1 < paramArrayOfString.length) {
        try
        {
          arrayOfdrk[i1] = o.b(paramArrayOfString[i1]);
          i1 += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          for (;;)
          {
            dri.e(b, "Couldn't find label: %s", new Object[] { localIllegalArgumentException.getMessage() });
          }
        }
      }
    }
    return arrayOfdrk;
  }
  
  final String[] a(String[] paramArrayOfString1, String paramString, String... paramVarArgs)
  {
    return duo.a(k, paramArrayOfString1, paramString, paramVarArgs);
  }
  
  public final int b(long paramLong)
  {
    int i2 = 0;
    int i1 = 0;
    r.a(A);
    try
    {
      int i3 = k(paramLong);
      if (i3 > 0) {
        i1 = 1;
      }
      i2 = i1;
      r.c();
      return i3;
    }
    finally
    {
      r.d();
      if (i2 != 0) {
        b(true);
      }
    }
  }
  
  public final int b(long paramLong, String paramString)
  {
    Object localObject = a(paramLong, true);
    if ((!o.contains(Long.valueOf(X.f()))) && (!o.contains(Long.valueOf(X.m())))) {
      return 0;
    }
    localObject = new ContentValues(1);
    ((ContentValues)localObject).put("body", paramString);
    return p.update("messages", (ContentValues)localObject, "_id=?", new String[] { Long.toString(paramLong) });
  }
  
  public final int b(ContentValues paramContentValues)
  {
    return o.a(paramContentValues);
  }
  
  public final Cursor b(String arg1, String[] paramArrayOfString)
  {
    long l1 = 0L;
    int i1 = 1;
    if (!Q()) {
      return null;
    }
    paramArrayOfString = new SearchQuery(???, paramArrayOfString);
    if ((Long.valueOf(c[1]).longValue() > 0L) || (i1 != 0)) {}
    for (;;)
    {
      synchronized (s)
      {
        Object localObject1 = new dtm(this, p);
        if (((dtm)localObject1).b()) {
          a.d(true);
        }
        try
        {
          localObject2 = b.rawQuery("SELECT seqnos_trimmed FROM search_status", null);
          try
          {
            if (((Cursor)localObject2).moveToNext()) {
              l1 = ((Cursor)localObject2).getLong(0);
            }
            ((Cursor)localObject2).close();
            if (l1 == 1L)
            {
              dri.c(dtm.d, "Backfilling search sequence table", new Object[0]);
              MailIndexerService.a(b);
              ((dtm)localObject1).d();
              ((dtm)localObject1).a(true);
            }
            a.r.c();
            a.r.d();
            localObject1 = p;
            localObject2 = new dup(b);
            if (!b.equals("documents")) {
              break label272;
            }
            return ((SQLiteDatabase)localObject1).rawQueryWithFactory((SQLiteDatabase.CursorFactory)localObject2, ???, c, null);
          }
          finally
          {
            ((Cursor)localObject2).close();
          }
          i1 = 0;
          break;
        }
        finally
        {
          Object localObject2;
          a.r.d();
        }
      }
      label272:
      ??? = "SELECT search_sequence._id AS seqno,   CASE search_sequence.action WHEN 0 THEN 'add' WHEN 1 THEN 'del' END AS action,   'content://gmail-ls/account/' || ? || '/conversationId/' ||     search_sequence.conversationId || '/maxServerMessageId/0/labels/msg-' ||     search_sequence.messageId AS uri,   labels.canonicalName AS tag FROM search_sequence INNER JOIN labels ON search_sequence.labelId = labels._id WHERE search_sequence._id > ? AND search_sequence.type = 1 ORDER BY search_sequence._id LIMIT ?;";
    }
  }
  
  public final Cursor b(String[] paramArrayOfString, long paramLong)
  {
    dmt.a();
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("messages LEFT OUTER JOIN message_labels \nON messages.messageId = message_labels.message_messageId \nLEFT OUTER JOIN labels \nON message_labels.labels_id=labels._id LEFT OUTER JOIN unsubscribed_senders \nON messages.unsubscribeSenderIdentifier = unsubscribed_senders.senderIdentifier ");
    localSQLiteQueryBuilder.appendWhere("messages.messageId = ?");
    localSQLiteQueryBuilder.setProjectionMap(T);
    String[] arrayOfString = a(paramArrayOfString, "messageLabels", new String[] { Long.toString(paramLong) });
    paramArrayOfString = localSQLiteQueryBuilder.query(p, paramArrayOfString, null, arrayOfString, "messages.messageId", null, null);
    dmt.b();
    if (paramArrayOfString == null)
    {
      dri.e(b, "null message cursor returned", new Object[0]);
      return null;
    }
    return new dpq(paramArrayOfString, "body");
  }
  
  public final drf b(String[] paramArrayOfString)
  {
    return new drf(k, p, paramArrayOfString);
  }
  
  public final dtu b(long paramLong, boolean paramBoolean)
  {
    Cursor localCursor = b(null, paramLong);
    try
    {
      localCursor.moveToNext();
      dtu localdtu = a(localCursor, paramBoolean);
      return localdtu;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public final void b()
  {
    r.c();
  }
  
  public final void b(String paramString)
  {
    dri.b(b, "setAccount to %s", new Object[] { paramString });
    l = new android.accounts.Account(paramString, "com.google");
  }
  
  final void b(Set<Long> paramSet)
  {
    dri.b(b, "Broadcasting notifications for labels: %s", new Object[] { paramSet });
    if ((paramSet == null) || (paramSet.size() == 0)) {
      return;
    }
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (localLong != null) {
        k.getContentResolver().notifyChange(dqz.a(l.name, localLong), null, false);
      }
    }
    PublicContentProvider.a(k, l.name, paramSet);
    GmailProvider.a(k, X, l.name, paramSet);
  }
  
  public final void b(boolean paramBoolean)
  {
    if ((p != null) && (p.inTransaction()))
    {
      Object localObject = A;
      if (!c.inTransaction()) {
        dri.e(dqv.a, "Must already be in a transaction with listener to enable notifications for account %s.", new Object[] { d });
      }
      do
      {
        return;
        localObject = (dqx)b.get();
        c = true;
      } while ((!paramBoolean) || (d));
      d = true;
      return;
    }
    c(paramBoolean);
  }
  
  public final int c(long paramLong)
  {
    long l1 = X.f();
    Object localObject1 = Long.toString(paramLong);
    Object localObject2 = Long.toString(l1);
    localObject1 = p.query("messages", new String[] { "_id" }, "messageId IN (SELECT message_messageId FROM message_labels where   message_conversation = ? AND labels_id=?)", new String[] { localObject1, localObject2 }, null, null, null);
    localObject2 = new ArrayList();
    try
    {
      if (((Cursor)localObject1).moveToNext()) {
        ((List)localObject2).add(Long.valueOf(((Cursor)localObject1).getLong(0)));
      }
      return a(localList);
    }
    finally
    {
      ((Cursor)localObject1).close();
    }
  }
  
  public final Cursor c(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("select ");
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i1];
      if (i1 != 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append("(select value from internal_sync_settings where name ='");
      localStringBuilder.append(str);
      localStringBuilder.append("') as ");
      localStringBuilder.append(str);
      i1 += 1;
    }
    return q.rawQuery(localStringBuilder.toString(), null);
  }
  
  public final Map<String, dqz> c(Context paramContext, String paramString)
  {
    paramContext = duo.a(paramContext, new String[] { Long.toString(Long.parseLong(paramString)) });
    paramContext = p.rawQuery("SELECT conversation_labels.*, conversations.*, conversations.queryId = 0 AS synced, (SELECT group_concat((labels._id || '^*^' || labels.canonicalName || '^*^' || \n(CASE labels.canonicalName  WHEN '^f' THEN ?  WHEN '^^out' THEN ?  WHEN '^i' THEN ?  WHEN '^r' THEN ?  WHEN '^b' THEN ?  WHEN '^all' THEN ?  WHEN '^u' THEN ?  WHEN '^k' THEN ?  WHEN '^s' THEN ?  WHEN '^t' THEN ?  WHEN '^g' THEN ?  WHEN '^io_im' THEN ?  WHEN '^iim' THEN ?  WHEN '^sq_ig_i_personal' THEN ?  WHEN '^sq_ig_i_social' THEN ?  WHEN '^sq_ig_i_promo' THEN ?  WHEN '^sq_ig_i_notification' THEN ?  WHEN '^sq_ig_i_group' THEN ?  ELSE labels.name END)  || '^*^' || labels.color || '^*^' || labels.hidden), '^**^') FROM labels JOIN conversation_labels  ON conversation_labels.labels_id=labels._id  AND conversation_labels.conversation_id=conversations._id AND conversation_labels.isZombie=0) AS conversationLabels, (CASE WHEN unsubscribed_senders.senderIdentifier IS NULL THEN 0 ELSE 1 END) AS isSenderUnsubscribed FROM conversation_labels LEFT OUTER JOIN conversations ON conversation_labels.conversation_id=conversations._id AND conversation_labels.queryId = conversations.queryId LEFT OUTER JOIN unsubscribed_senders ON conversations.unsubscribeSenderIdentifier = unsubscribed_senders.senderIdentifier\n\nWHERE (conversations._id=?) AND isZombie=0 GROUP BY conversations._id", paramContext);
    if (paramContext != null) {}
    try
    {
      paramString = new dqb(l.name, paramContext);
      if (paramString == null) {
        break label96;
      }
    }
    finally
    {
      try
      {
        if (paramString.d())
        {
          paramContext = paramString.c();
          if (paramContext != null)
          {
            paramString.e();
            return paramContext;
          }
        }
        paramString.e();
        return new HashMap();
      }
      finally {}
      paramContext = finally;
      paramString = null;
    }
    paramString.e();
    label96:
    throw paramContext;
  }
  
  public final void c()
  {
    r.d();
  }
  
  final void c(String paramString)
  {
    for (;;)
    {
      try
      {
        p.setVersion(0);
        q.setVersion(0);
        synchronized (s)
        {
          p.close();
          q.close();
          p = null;
          q = null;
          ??? = new Bundle();
          ((Bundle)???).putBoolean("force", true);
          ContentResolver.requestSync(l, "gmail-ls", (Bundle)???);
          buo.a().a("errors", "wipe_gm_db", paramString, 0L);
          ??? = b;
          paramString = String.valueOf(paramString);
          if (paramString.length() != 0)
          {
            paramString = "Wipe Gmail db: ".concat(paramString);
            dri.e((String)???, new RuntimeException(paramString), "MailEngine", new Object[0]);
            System.exit(-1);
            return;
          }
        }
        paramString = new String("Wipe Gmail db: ");
      }
      finally {}
    }
  }
  
  final void c(boolean paramBoolean)
  {
    k.getContentResolver().notifyChange(dpy.a(l.name), null, paramBoolean);
    ay.a();
  }
  
  public final ContentResolver d()
  {
    return k.getContentResolver();
  }
  
  public final String d(long paramLong)
  {
    return as;
  }
  
  public final void d(boolean paramBoolean)
  {
    r.a(A);
    if (paramBoolean) {}
    try
    {
      r.b();
      return;
    }
    catch (Exception localException)
    {
      dri.e(b, localException, "Exception while attempting to suppress notifications", new Object[0]);
      r.d();
      throw new IllegalStateException("Exception while attempting to suppress notifications", localException);
    }
  }
  
  /* Error */
  public final boolean d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   4: astore 4
    //   6: aload_1
    //   7: getstatic 3410	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   10: invokevirtual 3414	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   13: astore_1
    //   14: aload 4
    //   16: ldc_w 3416
    //   19: iconst_1
    //   20: anewarray 152	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: ldc_w 3418
    //   28: aastore
    //   29: ldc_w 3420
    //   32: iconst_1
    //   33: anewarray 152	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: aload_1
    //   39: aastore
    //   40: aconst_null
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokevirtual 3423	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +40 -> 89
    //   52: aload_1
    //   53: invokeinterface 1721 1 0
    //   58: istore_2
    //   59: iload_2
    //   60: ifeq +13 -> 73
    //   63: iconst_1
    //   64: istore_3
    //   65: aload_1
    //   66: invokeinterface 892 1 0
    //   71: iload_3
    //   72: ireturn
    //   73: iconst_0
    //   74: istore_3
    //   75: goto -10 -> 65
    //   78: astore 4
    //   80: aload_1
    //   81: invokeinterface 892 1 0
    //   86: aload 4
    //   88: athrow
    //   89: iconst_0
    //   90: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	drp
    //   0	91	1	paramString	String
    //   58	2	2	i1	int
    //   64	11	3	bool	boolean
    //   4	11	4	localSQLiteDatabase	SQLiteDatabase
    //   78	9	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	59	78	finally
  }
  
  /* Error */
  public final int e(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: iconst_4
    //   5: anewarray 152	java/lang/String
    //   8: dup
    //   9: iconst_0
    //   10: ldc -84
    //   12: aastore
    //   13: dup
    //   14: iconst_1
    //   15: ldc -82
    //   17: aastore
    //   18: dup
    //   19: iconst_2
    //   20: ldc_w 278
    //   23: aastore
    //   24: dup
    //   25: iconst_3
    //   26: ldc_w 3425
    //   29: aastore
    //   30: lload_1
    //   31: invokevirtual 1736	drp:a	([Ljava/lang/String;J)Landroid/database/Cursor;
    //   34: astore 10
    //   36: invokestatic 2552	dpy:a	()Landroid/text/TextUtils$StringSplitter;
    //   39: astore 11
    //   41: aload 10
    //   43: invokeinterface 1615 1 0
    //   48: istore 9
    //   50: iload 9
    //   52: ifne +14 -> 66
    //   55: aload 10
    //   57: invokeinterface 892 1 0
    //   62: iconst_2
    //   63: istore_3
    //   64: iload_3
    //   65: ireturn
    //   66: aload 10
    //   68: aload 10
    //   70: ldc -84
    //   72: invokeinterface 2518 2 0
    //   77: invokeinterface 1109 2 0
    //   82: lstore 5
    //   84: aload 10
    //   86: aload 10
    //   88: ldc -82
    //   90: invokeinterface 2518 2 0
    //   95: invokeinterface 1109 2 0
    //   100: lstore 7
    //   102: aload 10
    //   104: aload 10
    //   106: ldc_w 3425
    //   109: invokeinterface 2518 2 0
    //   114: invokeinterface 1098 2 0
    //   119: ifeq +225 -> 344
    //   122: iconst_1
    //   123: istore_3
    //   124: aload 11
    //   126: aload 10
    //   128: ldc_w 278
    //   131: invokestatic 2527	drp:a	(Landroid/database/Cursor;Ljava/lang/String;)Ljava/lang/String;
    //   134: invokeinterface 2557 2 0
    //   139: aload 10
    //   141: invokeinterface 892 1 0
    //   146: aload 11
    //   148: invokestatic 2560	dpy:a	(Landroid/text/TextUtils$StringSplitter;)Ljava/util/Set;
    //   151: astore 10
    //   153: aload 10
    //   155: aload_0
    //   156: getfield 450	drp:X	Ldqc;
    //   159: invokevirtual 3295	dqc:f	()J
    //   162: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   165: invokeinterface 1172 2 0
    //   170: ifeq +191 -> 361
    //   173: iconst_1
    //   174: istore 9
    //   176: new 941	android/util/TimingLogger
    //   179: dup
    //   180: getstatic 150	drp:b	Ljava/lang/String;
    //   183: ldc_w 3427
    //   186: invokespecial 1960	android/util/TimingLogger:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   189: astore 10
    //   191: aload_0
    //   192: getfield 616	drp:r	Lduy;
    //   195: aload_0
    //   196: getfield 624	drp:A	Ldqv;
    //   199: invokevirtual 1496	duy:a	(Ldvb;)V
    //   202: aload 10
    //   204: ldc_w 1979
    //   207: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   210: aload_0
    //   211: lload 5
    //   213: lload 7
    //   215: iload 9
    //   217: aload 10
    //   219: invokespecial 2051	drp:a	(JJZLandroid/util/TimingLogger;)Landroid/os/Bundle;
    //   222: astore 11
    //   224: aload 11
    //   226: ifnull +9 -> 235
    //   229: aload_0
    //   230: aload 11
    //   232: invokespecial 2057	drp:a	(Landroid/os/Bundle;)V
    //   235: aload_0
    //   236: getfield 616	drp:r	Lduy;
    //   239: invokevirtual 628	duy:c	()V
    //   242: aload_0
    //   243: getfield 616	drp:r	Lduy;
    //   246: invokevirtual 630	duy:d	()V
    //   249: aload 10
    //   251: ldc_w 2025
    //   254: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   257: aload_0
    //   258: iconst_1
    //   259: invokevirtual 1594	drp:b	(Z)V
    //   262: aload 10
    //   264: ldc_w 2027
    //   267: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   270: aload 10
    //   272: invokevirtual 2030	android/util/TimingLogger:dumpToLog	()V
    //   275: iload_3
    //   276: ifeq +52 -> 328
    //   279: new 1378	android/content/ContentValues
    //   282: dup
    //   283: iconst_1
    //   284: invokespecial 2807	android/content/ContentValues:<init>	(I)V
    //   287: astore 10
    //   289: aload 10
    //   291: ldc_w 3425
    //   294: iconst_0
    //   295: invokestatic 1104	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   298: invokevirtual 1877	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   301: aload_0
    //   302: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   305: ldc_w 1607
    //   308: aload 10
    //   310: ldc_w 1609
    //   313: iconst_1
    //   314: anewarray 152	java/lang/String
    //   317: dup
    //   318: iconst_0
    //   319: lload_1
    //   320: invokestatic 1709	java/lang/Long:toString	(J)Ljava/lang/String;
    //   323: aastore
    //   324: invokevirtual 1885	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   327: pop
    //   328: iload 4
    //   330: istore_3
    //   331: iload 9
    //   333: ifne -269 -> 64
    //   336: aload_0
    //   337: lload_1
    //   338: invokestatic 1750	cge:a	(Lcgf;J)I
    //   341: pop
    //   342: iconst_1
    //   343: ireturn
    //   344: iconst_0
    //   345: istore_3
    //   346: goto -222 -> 124
    //   349: astore 11
    //   351: aload 10
    //   353: invokeinterface 892 1 0
    //   358: aload 11
    //   360: athrow
    //   361: aload 10
    //   363: aload_0
    //   364: getfield 450	drp:X	Ldqc;
    //   367: invokevirtual 2758	dqc:m	()J
    //   370: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   373: invokeinterface 1172 2 0
    //   378: ifeq +9 -> 387
    //   381: iconst_0
    //   382: istore 9
    //   384: goto -208 -> 176
    //   387: iconst_3
    //   388: ireturn
    //   389: astore 11
    //   391: aload_0
    //   392: getfield 616	drp:r	Lduy;
    //   395: invokevirtual 630	duy:d	()V
    //   398: aload 10
    //   400: ldc_w 2025
    //   403: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   406: aload_0
    //   407: iconst_1
    //   408: invokevirtual 1594	drp:b	(Z)V
    //   411: aload 10
    //   413: ldc_w 2027
    //   416: invokevirtual 944	android/util/TimingLogger:addSplit	(Ljava/lang/String;)V
    //   419: aload 10
    //   421: invokevirtual 2030	android/util/TimingLogger:dumpToLog	()V
    //   424: aload 11
    //   426: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	this	drp
    //   0	427	1	paramLong	long
    //   63	283	3	i1	int
    //   1	328	4	i2	int
    //   82	130	5	l1	long
    //   100	114	7	l2	long
    //   48	335	9	bool	boolean
    //   34	386	10	localObject1	Object
    //   39	192	11	localObject2	Object
    //   349	10	11	localObject3	Object
    //   389	36	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   41	50	349	finally
    //   66	122	349	finally
    //   124	139	349	finally
    //   210	224	389	finally
    //   229	235	389	finally
    //   235	242	389	finally
  }
  
  public final SQLiteDatabase e()
  {
    return p;
  }
  
  public final boolean e(String paramString)
  {
    Object localObject = o.i;
    if (!b) {}
    do
    {
      return true;
      if (!((dqc)localObject).b(paramString)) {
        return false;
      }
      localObject = ((dqc)localObject).c(((dqc)localObject).a(paramString));
      if (!((ContentValues)localObject).containsKey("hidden")) {
        break;
      }
    } while (((ContentValues)localObject).getAsInteger("hidden").intValue() == 0);
    return false;
    dri.d("Gmail", "Unknown HIDDEN value for %s", new Object[] { paramString });
    return true;
  }
  
  /* Error */
  public final int f(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 450	drp:X	Ldqc;
    //   4: invokevirtual 2758	dqc:m	()J
    //   7: invokestatic 1709	java/lang/Long:toString	(J)Ljava/lang/String;
    //   10: astore 4
    //   12: aload_0
    //   13: getfield 450	drp:X	Ldqc;
    //   16: invokevirtual 2760	dqc:p	()J
    //   19: invokestatic 1709	java/lang/Long:toString	(J)Ljava/lang/String;
    //   22: astore 5
    //   24: new 1143	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 1144	java/util/ArrayList:<init>	()V
    //   31: astore_3
    //   32: aload_0
    //   33: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   36: astore 6
    //   38: lload_1
    //   39: invokestatic 1709	java/lang/Long:toString	(J)Ljava/lang/String;
    //   42: astore 7
    //   44: aload 6
    //   46: ldc_w 1607
    //   49: iconst_1
    //   50: anewarray 152	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: ldc -6
    //   57: aastore
    //   58: ldc_w 3445
    //   61: iconst_3
    //   62: anewarray 152	java/lang/String
    //   65: dup
    //   66: iconst_0
    //   67: aload 7
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload 4
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: aload 5
    //   79: aastore
    //   80: aconst_null
    //   81: aconst_null
    //   82: aconst_null
    //   83: invokevirtual 876	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore 4
    //   88: aload 4
    //   90: invokeinterface 881 1 0
    //   95: ifeq +34 -> 129
    //   98: aload_3
    //   99: aload 4
    //   101: iconst_0
    //   102: invokeinterface 1109 2 0
    //   107: invokestatic 1114	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   110: invokeinterface 1177 2 0
    //   115: pop
    //   116: goto -28 -> 88
    //   119: astore_3
    //   120: aload 4
    //   122: invokeinterface 892 1 0
    //   127: aload_3
    //   128: athrow
    //   129: aload 4
    //   131: invokeinterface 892 1 0
    //   136: aload_0
    //   137: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   140: invokevirtual 538	android/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   143: aload_3
    //   144: invokeinterface 1385 1 0
    //   149: astore 4
    //   151: aload 4
    //   153: invokeinterface 1155 1 0
    //   158: ifeq +42 -> 200
    //   161: aload 4
    //   163: invokeinterface 1159 1 0
    //   168: checkcast 1111	java/lang/Long
    //   171: astore 5
    //   173: aload_0
    //   174: getfield 870	drp:v	Ldth;
    //   177: aload 5
    //   179: invokevirtual 1499	java/lang/Long:longValue	()J
    //   182: invokeinterface 3447 3 0
    //   187: goto -36 -> 151
    //   190: astore_3
    //   191: aload_0
    //   192: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   195: invokevirtual 576	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   198: aload_3
    //   199: athrow
    //   200: aload_0
    //   201: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   204: invokevirtual 596	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   207: aload_0
    //   208: getfield 578	drp:p	Landroid/database/sqlite/SQLiteDatabase;
    //   211: invokevirtual 576	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   214: aload_0
    //   215: aload_3
    //   216: invokevirtual 3369	drp:a	(Ljava/util/List;)I
    //   219: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	this	drp
    //   0	220	1	paramLong	long
    //   31	68	3	localArrayList	ArrayList
    //   119	25	3	localObject1	Object
    //   190	26	3	localList	List
    //   10	152	4	localObject2	Object
    //   22	156	5	localObject3	Object
    //   36	9	6	localSQLiteDatabase	SQLiteDatabase
    //   42	26	7	str	String
    // Exception table:
    //   from	to	target	type
    //   88	116	119	finally
    //   143	151	190	finally
    //   151	187	190	finally
    //   200	207	190	finally
  }
  
  public final String f()
  {
    return b;
  }
  
  public final int g()
  {
    return m.b();
  }
  
  public final int g(long paramLong)
  {
    Cursor localCursor = a(new String[] { "messageId", "labelIds" }, paramLong);
    TextUtils.StringSplitter localStringSplitter = dpy.a();
    try
    {
      boolean bool = localCursor.moveToFirst();
      if (!bool) {
        return 2;
      }
      paramLong = localCursor.getLong(localCursor.getColumnIndex("messageId"));
      localStringSplitter.setString(a(localCursor, "labelIds"));
      localCursor.close();
      if (!dpy.a(localStringSplitter).contains(Long.valueOf(X.f()))) {
        return 3;
      }
    }
    finally
    {
      localCursor.close();
    }
    l(paramLong);
    return 1;
  }
  
  public final Context getContext()
  {
    return k;
  }
  
  public final void h()
  {
    a(new dsg(this));
  }
  
  public final void h(long paramLong)
  {
    o.k.a(paramLong, 4, false, false);
    A.a(paramLong);
  }
  
  public final CookieStore i()
  {
    return z;
  }
  
  public final boolean j()
  {
    dri.a(dri.a, "isSyncable=%d, isSyncActive=%b, isSyncPending=%b, getSyncAutomatically=%b", new Object[] { Integer.valueOf(ContentResolver.getIsSyncable(l, "gmail-ls")), Boolean.valueOf(ContentResolver.isSyncActive(l, "gmail-ls")), Boolean.valueOf(ContentResolver.isSyncPending(l, "gmail-ls")), Boolean.valueOf(ContentResolver.getSyncAutomatically(l, "gmail-ls")) });
    return ContentResolver.getSyncAutomatically(l, "gmail-ls");
  }
  
  public final void k()
  {
    a(new Bundle(0));
  }
  
  public final void l()
  {
    Bundle localBundle = new Bundle(1);
    localBundle.putBoolean("expedited", true);
    a(localBundle);
  }
  
  final void m()
  {
    if ((!X.a()) || (aI)) {
      return;
    }
    aI = true;
    int i1 = 0;
    while (i1 < ak.length)
    {
      String str = ak[i1];
      if (o.a(str) == null) {
        o.c(str);
      }
      i1 += 1;
    }
    t();
    v.f();
  }
  
  final Cursor n()
  {
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("custom_label_color_prefs");
    return localSQLiteQueryBuilder.query(p, null, null, null, null, null, null);
  }
  
  final Cursor o()
  {
    return a("name = ?", new String[] { dyr.e });
  }
  
  final ddj p()
  {
    if (ar == null) {}
    synchronized (as)
    {
      if (ar == null) {
        ar = new dqj(k, "Android-GmailProvider").a();
      }
      return ar;
    }
  }
  
  public final int q()
  {
    return HttpConnectionParams.getConnectionTimeout(p().getParams());
  }
  
  public final int r()
  {
    return HttpConnectionParams.getSoTimeout(p().getParams());
  }
  
  public final long s()
  {
    return ConnManagerParams.getTimeout(p().getParams());
  }
  
  final void t()
  {
    if (X.a())
    {
      drj localdrj = o;
      drk[] arrayOfdrk2 = a(m.c());
      drk[] arrayOfdrk1 = a(m.d());
      f.clear();
      int i2 = arrayOfdrk2.length;
      int i1 = 0;
      while (i1 < i2)
      {
        drk localdrk = arrayOfdrk2[i1];
        if (localdrk != null) {
          f.put(Long.valueOf(a), Boolean.valueOf(true));
        }
        i1 += 1;
      }
      i2 = arrayOfdrk1.length;
      i1 = 0;
      while (i1 < i2)
      {
        arrayOfdrk2 = arrayOfdrk1[i1];
        if (arrayOfdrk2 != null) {
          f.put(Long.valueOf(a), Boolean.valueOf(false));
        }
        i1 += 1;
      }
    }
  }
  
  public final boolean u()
  {
    return !bgr.b(k);
  }
  
  final void v()
  {
    if (MailProvider.a() != null) {
      MailProvider.a().b(p, l);
    }
    AlarmManager localAlarmManager;
    do
    {
      do
      {
        return;
      } while ((!I) || (!u()));
      localAlarmManager = (AlarmManager)k.getSystemService("alarm");
    } while ((localAlarmManager == null) || (aH == null));
    int i1 = ghz.a(k.getContentResolver(), "gmail_full_text_search_indexer_delay_msec", 300000);
    dri.b(b, "Scheduling index for %s ms from now", new Object[] { Integer.valueOf(i1) });
    long l1 = System.currentTimeMillis();
    localAlarmManager.setInexactRepeating(1, i1 + l1, 900000L, aH);
  }
  
  public final void w()
  {
    AlarmManager localAlarmManager = (AlarmManager)k.getSystemService("alarm");
    if ((localAlarmManager == null) || (aH == null)) {
      return;
    }
    localAlarmManager.cancel(aH);
  }
  
  final void x()
  {
    String str = l.name;
    k.getContentResolver().notifyChange(dpy.e(str), null, false);
    GmailProvider.b(k, str);
  }
  
  public final boolean y()
  {
    synchronized (t)
    {
      boolean bool = ap.get(1);
      return bool;
    }
  }
  
  public final boolean z()
  {
    synchronized (t)
    {
      boolean bool = ap.get(2);
      return bool;
    }
  }
}

/* Location:
 * Qualified Name:     drp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */