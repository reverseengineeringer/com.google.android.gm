import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.android.email.activity.RequestSyncPermissionsActivity;
import com.android.email.activity.setup.AccountSecurity;
import com.android.email.provider.EmailProvider;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import com.android.mail.providers.Folder;
import com.android.mail.providers.Settings;
import com.android.mail.utils.NotificationActionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class aql
  implements bbx
{
  static final String a = cvl.a;
  static Handler b;
  static aql c;
  static boolean h;
  static boolean i;
  static final HashSet<Long> j = new HashSet();
  static final Object k = new Object();
  private static aqr l;
  final Context d;
  final NotificationManager e;
  final Map<Long, ContentObserver> f = new HashMap();
  ContentObserver g;
  
  private aql(Context paramContext)
  {
    d = paramContext.getApplicationContext();
    bdv.i(paramContext);
    e = ((NotificationManager)paramContext.getSystemService("notification"));
  }
  
  public static aql a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new aql(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  private final hf a(long paramLong, String paramString1, CharSequence paramCharSequence, String paramString2, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject = null;
    if (paramIntent != null) {
      localObject = PendingIntent.getActivity(d, 0, paramIntent, 134217728);
    }
    paramCharSequence = new hf(d).a(paramCharSequence).b(paramString2);
    d = ((PendingIntent)localObject);
    i = 0;
    paramIntent = paramCharSequence.a(ard.p).a(chq.a()).d(paramString1);
    paramIntent.a(2, paramBoolean);
    if (-1L != paramLong) {}
    for (paramString2 = com.android.emailcommon.provider.Account.a(d, paramLong);; paramString2 = null)
    {
      paramString1 = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
      paramCharSequence = null;
      if (paramString2 != null) {
        localObject = d.getContentResolver().query(EmailProvider.a("uiaccount", D), chh.c, null, null, null);
      }
      for (;;)
      {
        try
        {
          if (!((Cursor)localObject).moveToFirst()) {
            break label440;
          }
          com.android.mail.providers.Account.b();
          paramCharSequence = cfw.a((Cursor)localObject);
          ((Cursor)localObject).close();
          if (paramCharSequence == null) {
            break label397;
          }
          localObject = d.getContentResolver().query(z.i, chh.i, null, null, null);
          if (localObject == null)
          {
            cvm.d(a, "Null folder cursor for mailbox %s", new Object[] { z.i });
            paramBoolean = false;
            int m = 4;
            if (paramBoolean) {
              m = 6;
            }
            if (!TextUtils.isEmpty(paramString1)) {
              break label432;
            }
            paramString1 = null;
            paramIntent.a(paramString1).b(m);
            return paramIntent;
          }
        }
        finally
        {
          ((Cursor)localObject).close();
        }
        paramString2 = null;
        try
        {
          if (((Cursor)localObject).moveToFirst()) {
            paramString2 = new Folder((Cursor)localObject);
          }
          ((Cursor)localObject).close();
          if (paramString2 != null)
          {
            paramCharSequence = new cfk(d, c, paramString2, true);
            paramString1 = paramCharSequence.b();
            paramBoolean = paramCharSequence.c();
          }
        }
        finally
        {
          ((Cursor)localObject).close();
        }
        tmp376_373[0] = z.i;
        cvm.e(a, "Null folder for mailbox %s", tmp376_373);
        paramBoolean = false;
        continue;
        label397:
        if (paramString2 != null) {
          cvm.e(a, "Null uiAccount for account id %d", new Object[] { Long.valueOf(D) });
        }
        paramBoolean = false;
        continue;
        label432:
        paramString1 = Uri.parse(paramString1);
        continue;
        label440:
        paramCharSequence = null;
      }
    }
  }
  
  private final void a(long paramLong, String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt)
  {
    if ((0xF0000000 & paramInt) == 805306368) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1 = a(paramLong, paramString1, paramString2, paramString3, paramIntent, bool);
      e.notify("EmailNotification", paramInt, paramString1.b());
      return;
    }
  }
  
  static void a(Context paramContext, long paramLong)
  {
    Uri localUri1 = EmailProvider.a("uiaccount", paramLong);
    Cursor localCursor = paramContext.getContentResolver().query(ContentUris.withAppendedId(bdv.L, paramLong), null, null, null, null);
    for (;;)
    {
      try
      {
        if (!localCursor.moveToNext()) {
          break;
        }
        long l1 = localCursor.getLong(0);
        if (l1 != 0L)
        {
          int n = localCursor.getInt(2);
          int m;
          if (n == 0)
          {
            m = 0;
            Uri localUri2 = EmailProvider.a("uifolder", l1);
            cvm.b(a, 121 + "Changes to account " + paramLong + ", folder: " + l1 + ", unreadCount: " + m + ", unseenCount: " + n, new Object[0]);
            Intent localIntent = new Intent("com.android.mail.action.update_notification");
            localIntent.setPackage(paramContext.getPackageName());
            localIntent.setType(EmailProvider.b);
            localIntent.putExtra("notification_extra_account", localUri1);
            localIntent.putExtra("notification_extra_folder", localUri2);
            localIntent.putExtra("notification_updated_unread_count", m);
            localIntent.putExtra("notification_updated_unseen_count", n);
            paramContext.sendOrderedBroadcast(localIntent, null);
          }
          else
          {
            m = localCursor.getInt(1);
          }
        }
      }
      finally
      {
        localCursor.close();
      }
    }
    localCursor.close();
  }
  
  static void b()
  {
    try
    {
      if (l == null)
      {
        l = new aqr();
        b = new Handler(la, new aqn());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static void b(Context paramContext)
  {
    NotificationActionUtils.a(paramContext, null, null);
  }
  
  private static int c(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {
      return 536870912 + (int)paramLong;
    }
    return 1342177280 + (int)paramLong;
  }
  
  public final void a()
  {
    b();
    b.post(new aqm(this));
  }
  
  /* Error */
  final void a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	aql:d	Landroid/content/Context;
    //   4: invokevirtual 148	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_3
    //   8: lload_1
    //   9: ldc2_w 389
    //   12: lcmp
    //   13: ifne +58 -> 71
    //   16: aload_3
    //   17: getstatic 392	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   20: getstatic 395	bdv:B	[Ljava/lang/String;
    //   23: aconst_null
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 170	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_3
    //   30: aload_3
    //   31: invokeinterface 276 1 0
    //   36: ifeq +28 -> 64
    //   39: aload_0
    //   40: aload_3
    //   41: iconst_0
    //   42: invokeinterface 280 2 0
    //   47: invokevirtual 397	aql:a	(J)V
    //   50: goto -20 -> 30
    //   53: astore 4
    //   55: aload_3
    //   56: invokeinterface 189 1 0
    //   61: aload 4
    //   63: athrow
    //   64: aload_3
    //   65: invokeinterface 189 1 0
    //   70: return
    //   71: aload_0
    //   72: getfield 55	aql:f	Ljava/util/Map;
    //   75: lload_1
    //   76: invokestatic 245	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: invokeinterface 403 2 0
    //   84: checkcast 405	android/database/ContentObserver
    //   87: ifnonnull -17 -> 70
    //   90: getstatic 38	aql:a	Ljava/lang/String;
    //   93: new 288	java/lang/StringBuilder
    //   96: dup
    //   97: bipush 62
    //   99: invokespecial 291	java/lang/StringBuilder:<init>	(I)V
    //   102: ldc_w 407
    //   105: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: lload_1
    //   109: invokevirtual 300	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   112: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: iconst_0
    //   116: anewarray 4	java/lang/Object
    //   119: invokestatic 409	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   122: pop
    //   123: new 411	aqq
    //   126: dup
    //   127: getstatic 368	aql:b	Landroid/os/Handler;
    //   130: aload_0
    //   131: getfield 63	aql:d	Landroid/content/Context;
    //   134: lload_1
    //   135: invokespecial 414	aqq:<init>	(Landroid/os/Handler;Landroid/content/Context;J)V
    //   138: astore 4
    //   140: aload_3
    //   141: getstatic 418	beb:f	Landroid/net/Uri;
    //   144: iconst_1
    //   145: aload 4
    //   147: invokevirtual 422	android/content/ContentResolver:registerContentObserver	(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
    //   150: aload_0
    //   151: getfield 55	aql:f	Ljava/util/Map;
    //   154: lload_1
    //   155: invokestatic 245	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   158: aload 4
    //   160: invokeinterface 426 3 0
    //   165: pop
    //   166: aload 4
    //   168: iconst_1
    //   169: invokevirtual 430	android/database/ContentObserver:onChange	(Z)V
    //   172: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	aql
    //   0	173	1	paramLong	long
    //   7	134	3	localObject1	Object
    //   53	9	4	localObject2	Object
    //   138	29	4	localaqq	aqq
    // Exception table:
    //   from	to	target	type
    //   30	50	53	finally
  }
  
  public final void a(long paramLong, Set<String> paramSet)
  {
    com.android.emailcommon.provider.Account localAccount = com.android.emailcommon.provider.Account.a(d, paramLong);
    int m;
    if ((paramSet.contains("android.permission.READ_CALENDAR")) && (paramSet.contains("android.permission.READ_CONTACTS"))) {
      m = arh.ce;
    }
    for (;;)
    {
      String str = d.getString(arh.cg, new Object[] { d.getString(m), d });
      Intent localIntent = new Intent(d, RequestSyncPermissionsActivity.class);
      localIntent.putStringArrayListExtra("permissions", new ArrayList(paramSet));
      localIntent.putExtra("account", localAccount);
      paramSet = a(D, str, d.getString(arh.ch, new Object[] { d.getString(m) }), str, localIntent, false);
      paramSet.a(new he().a(str));
      paramSet.a();
      e.notify("EmailNotification", 6, paramSet.b());
      return;
      if (paramSet.contains("android.permission.READ_CALENDAR"))
      {
        m = arh.cd;
      }
      else
      {
        if (!paramSet.contains("android.permission.READ_CONTACTS")) {
          break;
        }
        m = arh.cf;
      }
    }
    paramSet = String.valueOf(paramSet);
    throw new IllegalArgumentException(String.valueOf(paramSet).length() + 21 + "invalid permissions: " + paramSet);
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    com.android.emailcommon.provider.Account localAccount = com.android.emailcommon.provider.Account.a(d, paramLong);
    if (localAccount == null) {}
    Mailbox localMailbox;
    do
    {
      return;
      localMailbox = Mailbox.b(d, paramLong, 0);
    } while (localMailbox == null);
    Intent localIntent;
    HostAuth localHostAuth;
    but localbut;
    if (paramBoolean)
    {
      localIntent = new Intent("android.intent.action.VIEW", EmailProvider.c(paramLong));
      localHostAuth = localAccount.d(d);
      localbut = buo.a();
      localbut.b(d);
      if (localHostAuth.a(d) == null) {
        break label203;
      }
    }
    label203:
    for (String str = "oauth";; str = "password")
    {
      localbut.a("auth_error_type", str, c, 0L);
      a(g, d.getString(arh.bv, new Object[] { c }), d.getString(arh.bw), c, localIntent, c(paramLong, paramBoolean));
      return;
      localIntent = new Intent("android.intent.action.VIEW", EmailProvider.a(paramLong, "outgoing"));
      localHostAuth = localAccount.c(d);
      break;
    }
  }
  
  public final void a(Context paramContext, Intent paramIntent)
  {
    Object localObject = (Uri)paramIntent.getParcelableExtra("notification_extra_account");
    Uri localUri = (Uri)paramIntent.getParcelableExtra("notification_extra_folder");
    int m = paramIntent.getIntExtra("notification_updated_unread_count", 0);
    int n = paramIntent.getIntExtra("notification_updated_unseen_count", 0);
    ContentResolver localContentResolver = paramContext.getContentResolver();
    Cursor localCursor = localContentResolver.query((Uri)localObject, chh.c, null, null, null);
    if (localCursor == null)
    {
      paramContext = a;
      paramIntent = String.valueOf(localObject);
      cvm.e(paramContext, String.valueOf(paramIntent).length() + 32 + "Null account cursor for account " + paramIntent, new Object[0]);
      return;
    }
    for (;;)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          break label441;
        }
        com.android.mail.providers.Account.b();
        paramIntent = cfw.a(localCursor);
        localCursor.close();
        if (paramIntent == null)
        {
          paramContext = a;
          paramIntent = String.valueOf(localObject);
          cvm.b(paramContext, String.valueOf(paramIntent).length() + 53 + "Tried to create a notification for a missing account " + paramIntent, new Object[0]);
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      localCursor = localContentResolver.query(localUri, chh.i, null, null, null);
      if (localCursor == null)
      {
        paramContext = a;
        paramIntent = String.valueOf(localObject);
        localObject = String.valueOf(localUri);
        cvm.e(paramContext, String.valueOf(paramIntent).length() + 41 + String.valueOf(localObject).length() + "Null folder cursor for account " + paramIntent + ", mailbox " + (String)localObject, new Object[0]);
        return;
      }
      try
      {
        if (localCursor.moveToFirst())
        {
          localObject = new Folder(localCursor);
          localCursor.close();
          cvz.a(paramContext, m, n, paramIntent, (Folder)localObject, true);
          return;
        }
        paramContext = a;
        paramIntent = String.valueOf(localObject);
        localObject = String.valueOf(localUri);
        cvm.e(paramContext, String.valueOf(paramIntent).length() + 42 + String.valueOf(localObject).length() + "Empty folder cursor for account " + paramIntent + ", mailbox " + (String)localObject, new Object[0]);
        return;
      }
      finally
      {
        localCursor.close();
      }
      label441:
      paramIntent = null;
    }
  }
  
  public final void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    ban localban = bam.b(paramContext, D);
    if (localban == null)
    {
      cvm.b(a, "Can't cancel notification for missing account %d", new Object[] { Long.valueOf(D) });
      return;
    }
    cvz.a(paramContext, paramAccount.a(c));
    paramContext = ae;
    paramContext.cancel("EmailNotification", (int)(536870912L + D));
    paramContext.cancel("EmailNotification", (int)(805306368L + D));
    paramContext.cancel("EmailNotification", (int)(1073741824L + D));
    paramContext.cancel("EmailNotification", (int)(1342177280L + D));
  }
  
  public final void a(com.android.emailcommon.provider.Account paramAccount)
  {
    String str1 = c;
    String str2 = d.getString(arh.bx, new Object[] { str1 });
    String str3 = d.getString(arh.by);
    a(D, str2, str3, str1, null, (int)(1610612736L + D));
  }
  
  public final void a(Attachment paramAttachment)
  {
    beb localbeb = beb.a(d, o);
    if (localbeb == null) {
      return;
    }
    a(ad, U).g, d.getString(arh.bl), d.getString(arh.bm), i, null, 3);
  }
  
  final void b(long paramLong)
  {
    ContentResolver localContentResolver = d.getContentResolver();
    Object localObject;
    if (paramLong == 1152921504606846976L)
    {
      cvm.c(a, "Unregistering notifications for all accounts", new Object[0]);
      localObject = f.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localContentResolver.unregisterContentObserver((ContentObserver)((Iterator)localObject).next());
      }
      f.clear();
    }
    do
    {
      return;
      cvm.c(a, 60 + "Unregistering notifications for account " + paramLong, new Object[0]);
      localObject = (ContentObserver)f.remove(Long.valueOf(paramLong));
    } while (localObject == null);
    localContentResolver.unregisterContentObserver((ContentObserver)localObject);
  }
  
  public final void b(long paramLong, boolean paramBoolean)
  {
    e.cancel("EmailNotification", c(paramLong, paramBoolean));
  }
  
  public final void b(com.android.emailcommon.provider.Account paramAccount)
  {
    Intent localIntent = AccountSecurity.a(d, D, true);
    String str1 = c;
    String str2 = d.getString(arh.cr, new Object[] { str1 });
    String str3 = d.getString(arh.cu);
    a(D, str2, str3, str1, localIntent, (int)(805306368L + D));
  }
  
  public final void c()
  {
    e.cancel("EmailNotification", 4);
    e.cancel("EmailNotification", 5);
  }
  
  public final void c(long paramLong)
  {
    Object localObject = com.android.emailcommon.provider.Account.a(d, paramLong);
    if (localObject == null) {
      return;
    }
    Intent localIntent = AccountSecurity.b(d, paramLong, false);
    localObject = c;
    a(paramLong, d.getString(arh.bX, new Object[] { localObject }), d.getString(arh.bU), (String)localObject, localIntent, 4);
  }
  
  public final void c(com.android.emailcommon.provider.Account paramAccount)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", EmailProvider.c(D));
    String str1 = c;
    String str2 = d.getString(arh.cq, new Object[] { str1 });
    String str3 = d.getString(arh.cs);
    a(D, str2, str3, str1, localIntent, (int)(1073741824L + D));
  }
  
  public final void d()
  {
    e.cancel("EmailNotification", 6);
  }
  
  public final void d(long paramLong)
  {
    Object localObject = com.android.emailcommon.provider.Account.a(d, paramLong);
    if (localObject == null) {
      return;
    }
    Intent localIntent = AccountSecurity.b(d, paramLong, true);
    localObject = c;
    a(paramLong, d.getString(arh.cb), d.getString(arh.bY), (String)localObject, localIntent, 5);
  }
  
  public final void d(com.android.emailcommon.provider.Account paramAccount)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", EmailProvider.c(D));
    String str1 = c;
    String str2 = d.getString(arh.cv, new Object[] { str1 });
    String str3 = d.getString(arh.ct);
    a(D, str2, str3, str1, localIntent, (int)(805306368L + D));
  }
  
  public final void e()
  {
    
    if (!b.hasMessages(1))
    {
      aqo localaqo = new aqo(this);
      Message.obtain(b, 1, localaqo).sendToTarget();
    }
  }
}

/* Location:
 * Qualified Name:     aql
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */