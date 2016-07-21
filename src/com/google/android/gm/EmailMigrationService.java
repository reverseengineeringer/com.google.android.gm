package com.google.android.gm;

import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.IntentService;
import android.app.Notification;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import ayi;
import bam;
import bds;
import bdu;
import bdv;
import beb;
import bgt;
import bhb;
import buo;
import buq;
import but;
import cfm;
import cfr;
import cfw;
import cgr;
import chh;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.Credential;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import cui;
import cvm;
import cxd;
import dgc;
import dge;
import hf;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class EmailMigrationService
  extends IntentService
{
  public static final String[] a;
  public static final String[] b;
  public static final String[] c;
  public static final String[] d;
  public static final String[] e;
  private static final String f;
  private String g;
  private ContentResolver h;
  private String i;
  private String j;
  private Uri k;
  private Uri l;
  private HashSet<Long> m = new HashSet();
  private ArrayList<com.android.emailcommon.provider.Account> n = new ArrayList();
  private int o;
  
  static
  {
    String str = String.valueOf(bdv.F);
    if (str.length() != 0) {}
    for (str = "content://".concat(str);; str = new String("content://"))
    {
      f = str;
      a = new String[] { "_id", "displayName", "emailAddress", "syncKey", "syncLookback", "syncInterval", "hostAuthKeyRecv", "hostAuthKeySend", "flags", "senderName", "ringtoneUri", "protocolVersion", "securitySyncKey", "signature", "policyKey", "pingDuration" };
      b = new String[] { "_id", "displayName", "emailAddress", "syncKey", "syncLookback", "syncInterval", "hostAuthKeyRecv", "hostAuthKeySend", "flags", "senderName", "ringtoneUri", "protocolVersion", "securitySyncKey", "signature", "policyKey", "pingDuration", "maxAttachmentSize" };
      c = new String[] { "_id", "protocol", "address", "port", "flags", "login", "password", "domain", "certAlias" };
      d = new String[] { "_id", "displayName", "timeStamp", "subject", "flagRead", "flagLoaded", "flagFavorite", "flagAttachment", "flags", "syncServerId", "clientId", "messageId", "mailboxKey", "accountKey", "fromList", "toList", "ccList", "bccList", "replyToList", "syncServerTimeStamp", "meetingInfo", "snippet", "protocolSearchInfo", "threadTopic", "syncData", "flagSeen" };
      e = new String[] { "_id", "messageKey", "htmlContent", "textContent", "sourceMessageKey", "quotedTextStartPos" };
      return;
    }
  }
  
  public EmailMigrationService()
  {
    super("EmailMigrationService");
  }
  
  private static int a(Context paramContext, String paramString)
  {
    int i1;
    try
    {
      i1 = getPackageManagergetPackageInfo0versionCode;
      cvm.b(cvm.a, "versionCode: %d", new Object[] { Integer.valueOf(i1) });
      if (i1 < 500058)
      {
        cvm.a("EmailMigration", "Working with %s version of the Email provider", new Object[] { "unsupported" });
        return 0;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      cvm.c(cvm.a, "No Email application installed", new Object[0]);
      return -1;
    }
    if (i1 < 500060)
    {
      cvm.a("EmailMigration", "Working with %s version of the Email provider", new Object[] { "KK" });
      return 1;
    }
    if (i1 < 500064)
    {
      cvm.a("EmailMigration", "Working with %s version of the Email provider", new Object[] { "KK MR1" });
      return 2;
    }
    if (i1 < 6306090)
    {
      cvm.a("EmailMigration", "Working with %s version of the Email provider", new Object[] { "KK MR2" });
      return 3;
    }
    if (i1 < 7000000)
    {
      cvm.a("EmailMigration", "Working with %s version of the Email provider", new Object[] { "Algol" });
      return 4;
    }
    cvm.a("EmailMigration", "Working with %s version of the Email provider", new Object[] { "L" });
    return 5;
  }
  
  /* Error */
  private final bds a(long paramLong)
  {
    // Byte code:
    //   0: ldc -31
    //   2: ldc -2
    //   4: iconst_1
    //   5: anewarray 214	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: lload_1
    //   11: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: aastore
    //   15: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   18: pop
    //   19: aload_0
    //   20: getfield 261	com/google/android/gm/EmailMigrationService:g	Ljava/lang/String;
    //   23: invokestatic 41	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: ldc_w 263
    //   29: invokevirtual 51	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   32: invokestatic 269	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   35: astore 4
    //   37: aload_0
    //   38: getfield 271	com/google/android/gm/EmailMigrationService:o	I
    //   41: iconst_5
    //   42: if_icmpge +98 -> 140
    //   45: ldc -31
    //   47: ldc_w 273
    //   50: iconst_1
    //   51: anewarray 214	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: ldc_w 275
    //   59: aastore
    //   60: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   63: pop
    //   64: getstatic 167	com/google/android/gm/EmailMigrationService:e	[Ljava/lang/String;
    //   67: astore_3
    //   68: aload_0
    //   69: getfield 277	com/google/android/gm/EmailMigrationService:h	Landroid/content/ContentResolver;
    //   72: aload 4
    //   74: aload_3
    //   75: ldc_w 279
    //   78: iconst_1
    //   79: anewarray 37	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: lload_1
    //   85: invokestatic 283	java/lang/Long:toString	(J)Ljava/lang/String;
    //   88: aastore
    //   89: aconst_null
    //   90: invokevirtual 289	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore_3
    //   94: ldc -31
    //   96: ldc_w 291
    //   99: iconst_1
    //   100: anewarray 214	java/lang/Object
    //   103: dup
    //   104: iconst_0
    //   105: lload_1
    //   106: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   109: aastore
    //   110: invokestatic 231	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   113: pop
    //   114: aload_3
    //   115: ifnonnull +51 -> 166
    //   118: ldc -31
    //   120: ldc_w 293
    //   123: iconst_1
    //   124: anewarray 214	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: lload_1
    //   130: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   133: aastore
    //   134: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   137: pop
    //   138: aconst_null
    //   139: areturn
    //   140: ldc -31
    //   142: ldc_w 273
    //   145: iconst_1
    //   146: anewarray 214	java/lang/Object
    //   149: dup
    //   150: iconst_0
    //   151: ldc_w 295
    //   154: aastore
    //   155: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   158: pop
    //   159: getstatic 298	bds:b	[Ljava/lang/String;
    //   162: astore_3
    //   163: goto -95 -> 68
    //   166: new 297	bds
    //   169: dup
    //   170: invokespecial 299	bds:<init>	()V
    //   173: astore 4
    //   175: aload_3
    //   176: invokeinterface 305 1 0
    //   181: ifne +31 -> 212
    //   184: ldc -31
    //   186: ldc_w 307
    //   189: iconst_1
    //   190: anewarray 214	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: lload_1
    //   196: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   199: aastore
    //   200: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   203: pop
    //   204: aload_3
    //   205: invokeinterface 310 1 0
    //   210: aconst_null
    //   211: areturn
    //   212: aload_0
    //   213: getfield 271	com/google/android/gm/EmailMigrationService:o	I
    //   216: iconst_5
    //   217: if_icmpge +100 -> 317
    //   220: aload 4
    //   222: getstatic 312	bds:a	Landroid/net/Uri;
    //   225: putfield 315	bds:C	Landroid/net/Uri;
    //   228: aload 4
    //   230: aload_3
    //   231: iconst_1
    //   232: invokeinterface 319 2 0
    //   237: putfield 322	bds:c	J
    //   240: aload 4
    //   242: aload_3
    //   243: iconst_2
    //   244: invokeinterface 326 2 0
    //   249: putfield 328	bds:d	Ljava/lang/String;
    //   252: aload 4
    //   254: aload_3
    //   255: iconst_3
    //   256: invokeinterface 326 2 0
    //   261: putfield 330	bds:e	Ljava/lang/String;
    //   264: aload 4
    //   266: aload_3
    //   267: iconst_4
    //   268: invokeinterface 319 2 0
    //   273: putfield 332	bds:g	J
    //   276: aload 4
    //   278: aload_3
    //   279: iconst_5
    //   280: invokeinterface 336 2 0
    //   285: putfield 338	bds:f	I
    //   288: aload_3
    //   289: invokeinterface 310 1 0
    //   294: ldc -31
    //   296: ldc_w 340
    //   299: iconst_1
    //   300: anewarray 214	java/lang/Object
    //   303: dup
    //   304: iconst_0
    //   305: lload_1
    //   306: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   309: aastore
    //   310: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   313: pop
    //   314: aload 4
    //   316: areturn
    //   317: aload 4
    //   319: aload_0
    //   320: aload_3
    //   321: invokevirtual 343	bds:a	(Landroid/content/Context;Landroid/database/Cursor;)V
    //   324: goto -36 -> 288
    //   327: astore 4
    //   329: ldc -31
    //   331: aload 4
    //   333: ldc_w 345
    //   336: iconst_1
    //   337: anewarray 214	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: lload_1
    //   343: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   346: aastore
    //   347: invokestatic 348	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   350: pop
    //   351: aload_3
    //   352: invokeinterface 310 1 0
    //   357: aconst_null
    //   358: areturn
    //   359: astore 4
    //   361: aload_3
    //   362: invokeinterface 310 1 0
    //   367: aload 4
    //   369: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	370	0	this	EmailMigrationService
    //   0	370	1	paramLong	long
    //   67	295	3	localObject1	Object
    //   35	283	4	localObject2	Object
    //   327	5	4	localIllegalStateException	IllegalStateException
    //   359	9	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   175	204	327	java/lang/IllegalStateException
    //   212	288	327	java/lang/IllegalStateException
    //   317	324	327	java/lang/IllegalStateException
    //   175	204	359	finally
    //   212	288	359	finally
    //   317	324	359	finally
    //   329	351	359	finally
  }
  
  /* Error */
  private final HostAuth a(Uri paramUri, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 271	com/google/android/gm/EmailMigrationService:o	I
    //   4: iconst_4
    //   5: if_icmpge +73 -> 78
    //   8: ldc -31
    //   10: ldc_w 351
    //   13: iconst_1
    //   14: anewarray 214	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 353
    //   22: aastore
    //   23: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   26: pop
    //   27: getstatic 107	com/google/android/gm/EmailMigrationService:c	[Ljava/lang/String;
    //   30: astore 4
    //   32: aload_1
    //   33: lload_2
    //   34: invokestatic 359	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 277	com/google/android/gm/EmailMigrationService:h	Landroid/content/ContentResolver;
    //   42: aload_1
    //   43: aload 4
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 289	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore_1
    //   52: aload_1
    //   53: ifnonnull +52 -> 105
    //   56: ldc -31
    //   58: ldc_w 361
    //   61: iconst_1
    //   62: anewarray 214	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: lload_2
    //   68: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: aastore
    //   72: invokestatic 363	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   75: pop
    //   76: aconst_null
    //   77: areturn
    //   78: ldc -31
    //   80: ldc_w 351
    //   83: iconst_1
    //   84: anewarray 214	java/lang/Object
    //   87: dup
    //   88: iconst_0
    //   89: ldc_w 295
    //   92: aastore
    //   93: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   96: pop
    //   97: getstatic 367	com/android/emailcommon/provider/HostAuth:m	[Ljava/lang/String;
    //   100: astore 4
    //   102: goto -70 -> 32
    //   105: new 365	com/android/emailcommon/provider/HostAuth
    //   108: dup
    //   109: invokespecial 368	com/android/emailcommon/provider/HostAuth:<init>	()V
    //   112: astore 4
    //   114: aload_1
    //   115: invokeinterface 371 1 0
    //   120: ifne +31 -> 151
    //   123: ldc -31
    //   125: ldc_w 373
    //   128: iconst_1
    //   129: anewarray 214	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: lload_2
    //   135: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   138: aastore
    //   139: invokestatic 363	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   142: pop
    //   143: aload_1
    //   144: invokeinterface 310 1 0
    //   149: aconst_null
    //   150: areturn
    //   151: aload_0
    //   152: getfield 271	com/google/android/gm/EmailMigrationService:o	I
    //   155: iconst_4
    //   156: if_icmpge +158 -> 314
    //   159: ldc -31
    //   161: ldc_w 375
    //   164: iconst_1
    //   165: anewarray 214	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: ldc_w 353
    //   173: aastore
    //   174: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   177: pop
    //   178: aload 4
    //   180: getstatic 376	com/android/emailcommon/provider/HostAuth:a	Landroid/net/Uri;
    //   183: putfield 377	com/android/emailcommon/provider/HostAuth:C	Landroid/net/Uri;
    //   186: aload 4
    //   188: aload_1
    //   189: iconst_0
    //   190: invokeinterface 319 2 0
    //   195: putfield 380	com/android/emailcommon/provider/HostAuth:D	J
    //   198: aload 4
    //   200: aload_1
    //   201: iconst_1
    //   202: invokeinterface 326 2 0
    //   207: putfield 382	com/android/emailcommon/provider/HostAuth:b	Ljava/lang/String;
    //   210: aload 4
    //   212: aload_1
    //   213: iconst_2
    //   214: invokeinterface 326 2 0
    //   219: putfield 384	com/android/emailcommon/provider/HostAuth:c	Ljava/lang/String;
    //   222: aload 4
    //   224: aload_1
    //   225: iconst_3
    //   226: invokeinterface 336 2 0
    //   231: putfield 386	com/android/emailcommon/provider/HostAuth:d	I
    //   234: aload 4
    //   236: aload_1
    //   237: iconst_4
    //   238: invokeinterface 336 2 0
    //   243: putfield 388	com/android/emailcommon/provider/HostAuth:e	I
    //   246: aload 4
    //   248: aload_1
    //   249: iconst_5
    //   250: invokeinterface 326 2 0
    //   255: putfield 389	com/android/emailcommon/provider/HostAuth:f	Ljava/lang/String;
    //   258: aload 4
    //   260: aload_1
    //   261: bipush 6
    //   263: invokeinterface 326 2 0
    //   268: putfield 390	com/android/emailcommon/provider/HostAuth:g	Ljava/lang/String;
    //   271: aload 4
    //   273: aload_1
    //   274: bipush 7
    //   276: invokeinterface 326 2 0
    //   281: putfield 392	com/android/emailcommon/provider/HostAuth:h	Ljava/lang/String;
    //   284: aload 4
    //   286: aload_1
    //   287: bipush 8
    //   289: invokeinterface 326 2 0
    //   294: putfield 394	com/android/emailcommon/provider/HostAuth:i	Ljava/lang/String;
    //   297: aload 4
    //   299: ldc2_w 395
    //   302: putfield 398	com/android/emailcommon/provider/HostAuth:k	J
    //   305: aload_1
    //   306: invokeinterface 310 1 0
    //   311: aload 4
    //   313: areturn
    //   314: ldc -31
    //   316: ldc_w 375
    //   319: iconst_1
    //   320: anewarray 214	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: ldc_w 400
    //   328: aastore
    //   329: invokestatic 222	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   332: pop
    //   333: aload 4
    //   335: aload_1
    //   336: invokevirtual 403	com/android/emailcommon/provider/HostAuth:a	(Landroid/database/Cursor;)V
    //   339: goto -34 -> 305
    //   342: astore 4
    //   344: aload_1
    //   345: invokeinterface 310 1 0
    //   350: aload 4
    //   352: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	this	EmailMigrationService
    //   0	353	1	paramUri	Uri
    //   0	353	2	paramLong	long
    //   30	304	4	localObject1	Object
    //   342	9	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   114	143	342	finally
    //   151	305	342	finally
    //   314	339	342	finally
  }
  
  private final ArrayList<com.android.emailcommon.provider.Account> a(boolean paramBoolean)
  {
    cvm.b("EmailMigration", "Generating list of Accounts needing migration, migrateExchange: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ArrayList localArrayList = new ArrayList();
    Object localObject4 = Uri.parse(String.valueOf(g).concat("/account"));
    if (o < 3) {
      cvm.b("EmailMigration", "Querying Account using %s content projection", new Object[] { "pre-KKMR2" });
    }
    for (Object localObject1 = a;; localObject1 = b)
    {
      localObject4 = h.query((Uri)localObject4, (String[])localObject1, null, null, null);
      if (localObject4 != null) {
        break;
      }
      cvm.b("EmailMigration", "No Accounts to migrate", new Object[0]);
      return localArrayList;
      cvm.b("EmailMigration", "Querying Account using %s content projection", new Object[] { "latest" });
    }
    cvm.b("EmailMigration", "%d Accounts can be migrated", new Object[] { Integer.valueOf(((Cursor)localObject4).getCount()) });
    label737:
    label985:
    label1065:
    label1091:
    label1121:
    label1230:
    label1240:
    for (;;)
    {
      long l1;
      HostAuth localHostAuth;
      try
      {
        if (!((Cursor)localObject4).moveToNext()) {
          break label1230;
        }
        localObject1 = new com.android.emailcommon.provider.Account();
        if (o >= 3) {
          break label737;
        }
        cvm.a("EmailMigration", "Restoring Account with %s content projection", new Object[] { "pre-KKMR2" });
        D = ((Cursor)localObject4).getLong(0);
        C = com.android.emailcommon.provider.Account.a;
        c = ((Cursor)localObject4).getString(1);
        d = ((Cursor)localObject4).getString(2);
        e = ((Cursor)localObject4).getString(3);
        f = ((Cursor)localObject4).getInt(4);
        g = ((Cursor)localObject4).getInt(5);
        h = ((Cursor)localObject4).getLong(6);
        i = ((Cursor)localObject4).getLong(7);
        j = ((Cursor)localObject4).getInt(8);
        k = ((Cursor)localObject4).getString(9);
        l = ((Cursor)localObject4).getString(11);
        m = ((Cursor)localObject4).getString(12);
        n = ((Cursor)localObject4).getString(13);
        o = ((Cursor)localObject4).getLong(14);
        p = ((Cursor)localObject4).getLong(15);
        cvm.b("EmailMigration", "Restored Account with id: %d, HostAuthSend id: %d, HostAuthRecv id: %d", new Object[] { Long.valueOf(D), Long.valueOf(i), Long.valueOf(h) });
        l1 = h;
        if (l1 <= 0L) {
          break label1065;
        }
        localHostAuth = a(k, l1);
        if (localHostAuth != null) {
          break label985;
        }
        cvm.e("EmailMigration", "Error restoring HostAuthRecv with id: %d", new Object[] { Long.valueOf(l1) });
        if (t == null) {
          break label1091;
        }
        cvm.a("EmailMigration", "HostAuthRecv Credential id: %d", new Object[] { Long.valueOf(t.k) });
        a(t);
        if ((t.k > 0L) && (t.l == null)) {
          cvm.e("EmailMigration", "Error loading the OAuth Credentials for %s", new Object[] { "HostAuthRecv" });
        }
        if (u == null) {
          break label1121;
        }
        cvm.a("EmailMigration", "HostAuthSend Credential id: %d", new Object[] { Long.valueOf(u.k) });
        a(u);
        if ((u.k <= 0L) || (u.l != null)) {
          break label1240;
        }
        cvm.e("EmailMigration", "Error loading the OAuth Credentials for %s", new Object[] { "HostAuthSend" });
      }
      finally
      {
        ((Cursor)localObject4).close();
      }
      Object localObject3;
      if (localObject1 == null)
      {
        cvm.d("EmailMigration", "Error restoring an Account, skipping", new Object[0]);
        continue;
        cvm.a("EmailMigration", "Restoring Account with %s content projection", new Object[] { "KKMR2" });
        D = ((Cursor)localObject4).getLong(0);
        C = com.android.emailcommon.provider.Account.a;
        c = ((Cursor)localObject4).getString(1);
        d = ((Cursor)localObject4).getString(2);
        e = ((Cursor)localObject4).getString(3);
        f = ((Cursor)localObject4).getInt(4);
        g = ((Cursor)localObject4).getInt(5);
        h = ((Cursor)localObject4).getLong(6);
        i = ((Cursor)localObject4).getLong(7);
        j = ((Cursor)localObject4).getInt(8);
        k = ((Cursor)localObject4).getString(9);
        l = ((Cursor)localObject4).getString(11);
        m = ((Cursor)localObject4).getString(12);
        n = ((Cursor)localObject4).getString(13);
        o = ((Cursor)localObject4).getLong(14);
        p = ((Cursor)localObject4).getLong(15);
        q = ((Cursor)localObject4).getLong(16);
        continue;
        t = localHostAuth;
        l1 = i;
        if (l1 > 0L)
        {
          localHostAuth = a(k, l1);
          if ((localHostAuth == null) && (!t.b.equals(i)))
          {
            cvm.e("EmailMigration", "Error restoring HostAuthSend with id: %d", new Object[] { Long.valueOf(l1) });
            continue;
            cvm.b("EmailMigration", "HostAuthRecv not defined", new Object[0]);
          }
          else
          {
            u = localHostAuth;
            continue;
            cvm.e("EmailMigration", "Error loading the HostAuthRecv for %s", new Object[] { cvm.a(d) });
            localObject3 = null;
            continue;
            cvm.d("EmailMigration", "Could not load the HostAuthSend for this Account (Exchange?)", new Object[0]);
          }
        }
      }
      else
      {
        int i2 = 1;
        int i1 = i2;
        if (!paramBoolean)
        {
          i1 = i2;
          if (t.b.equals(i))
          {
            cvm.b("EmailMigration", "Not migrating an Exchange Account, id: %d", new Object[] { Long.valueOf(D) });
            i1 = 0;
          }
        }
        if (i1 != 0)
        {
          cvm.a("EmailMigration", "Adding Account to migrate list, id: %d", new Object[] { Long.valueOf(D) });
          localArrayList.add(localObject3);
          continue;
          ((Cursor)localObject4).close();
          return localArrayList;
        }
      }
    }
  }
  
  private final void a()
  {
    Iterator localIterator = n.iterator();
    while (localIterator.hasNext())
    {
      com.android.emailcommon.provider.Account localAccount = (com.android.emailcommon.provider.Account)localIterator.next();
      if (!a(localAccount))
      {
        cvm.b("EmailMigration", "Could not register Gmail Account: %d with the AccountManager", new Object[] { Long.valueOf(D) });
        m.remove(Long.valueOf(D));
      }
      else
      {
        cvm.b("EmailMigration", "Registered Gmail Account: %d with the AccountManager", new Object[] { Long.valueOf(D) });
      }
    }
  }
  
  private final void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    cvm.b("EmailMigration", "Migrating data from Email Account id: %d, to Gmail Account id: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Object localObject1 = Uri.parse(String.valueOf(g).concat("/mailbox"));
    Cursor localCursor1 = h.query((Uri)localObject1, Mailbox.z, "accountKey=?", new String[] { Long.toString(paramLong1) }, null);
    if (localCursor1 == null)
    {
      cvm.f("EmailMigration", "null mailboxCursor", new Object[0]);
      return;
    }
    for (;;)
    {
      long l1;
      long l2;
      Object localObject8;
      Cursor localCursor2;
      try
      {
        if (!localCursor1.moveToNext()) {
          break;
        }
        localObject1 = new Mailbox();
        ((Mailbox)localObject1).a(localCursor1);
        g = paramLong2;
        l1 = D;
        D = -1L;
        r = 8;
        ((Mailbox)localObject1).h(this);
        l2 = D;
        cvm.b("EmailMigration", "Migrated Email Mailbox id: %d, to Gmail Mailbox id: %d for %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), d });
        if (!paramBoolean) {
          continue;
        }
        cvm.a("EmailMigration", "Migrating messages for Email Account id: %d, Mailbox id: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(l1) });
        localObject8 = Uri.parse(String.valueOf(g).concat("/message"));
        if (o < 2)
        {
          cvm.b("EmailMigration", "Querying Message using %s content projection.", new Object[] { "pre-KKMR1" });
          localObject1 = d;
          localCursor2 = h.query((Uri)localObject8, (String[])localObject1, "mailboxKey=?", new String[] { Long.toString(l1) }, null);
          if (localCursor2 != null) {
            break label378;
          }
          cvm.b("EmailMigration", "No messages for Email Mailbox id: %d", new Object[] { Long.valueOf(l1) });
          continue;
        }
      }
      finally
      {
        localCursor1.close();
      }
      tmp360_357[0] = "latest";
      cvm.b("EmailMigration", "Querying Message using %s content projection.", tmp360_357);
      Object localObject3 = beb.g;
      continue;
      for (;;)
      {
        label378:
        Attachment localAttachment;
        try
        {
          if (!localCursor2.moveToNext()) {
            break label1412;
          }
          localObject3 = new beb();
          if (o >= 2) {
            break label1073;
          }
          C = beb.a;
          D = localCursor2.getLong(0);
          m = localCursor2.getString(1);
          n = localCursor2.getLong(2);
          o = localCursor2.getString(3);
          if (localCursor2.getInt(4) == 1)
          {
            bool = true;
            p = bool;
            if (localCursor2.getInt(25) != 1) {
              break label1055;
            }
            bool = true;
            q = bool;
            r = localCursor2.getInt(5);
            if (localCursor2.getInt(6) != 1) {
              break label1061;
            }
            bool = true;
            s = bool;
            if (localCursor2.getInt(7) != 1) {
              break label1067;
            }
            bool = true;
            t = bool;
            u = localCursor2.getInt(8);
            x = localCursor2.getString(9);
            y = localCursor2.getLong(19);
            z = localCursor2.getInt(10);
            P = localCursor2.getString(11);
            U = localCursor2.getLong(12);
            W = 0L;
            V = localCursor2.getLong(13);
            X = localCursor2.getString(14);
            Y = localCursor2.getString(15);
            Z = localCursor2.getString(16);
            aa = localCursor2.getString(17);
            ab = localCursor2.getString(18);
            ac = localCursor2.getString(20);
            af = localCursor2.getString(21);
            ag = localCursor2.getString(22);
            ah = localCursor2.getString(23);
            ai = localCursor2.getString(24);
            V = paramLong2;
            U = l2;
            localObject8 = a(D);
            if (localObject8 != null)
            {
              ay = d;
              ax = e;
              az = g;
              aB = f;
            }
            localObject8 = new ArrayList();
            a((ArrayList)localObject8, D, paramLong2);
            if (((ArrayList)localObject8).size() > 0) {
              aA = ((ArrayList)localObject8);
            }
            D = -1L;
            ((beb)localObject3).h(this);
            if (((ArrayList)localObject8).size() <= 0) {
              continue;
            }
            Iterator localIterator = ((ArrayList)localObject8).iterator();
            if (!localIterator.hasNext()) {
              continue;
            }
            localAttachment = (Attachment)localIterator.next();
            cvm.a("EmailMigration", "Migrating Attachment id: %d for Email Account id: %d", new Object[] { Long.valueOf(D), Long.valueOf(paramLong2) });
            if (v == 3) {
              break label1083;
            }
            cvm.b("EmailMigration", "The Attachment was not downloaded, nothing to migrate id: %d", new Object[] { Long.valueOf(D) });
            continue;
          }
          bool = false;
        }
        finally
        {
          localCursor2.close();
        }
        continue;
        label1055:
        boolean bool = false;
        continue;
        label1061:
        bool = false;
        continue;
        label1067:
        bool = false;
        continue;
        label1073:
        ((beb)localObject4).a(localCursor2);
        continue;
        label1083:
        if (localAttachment.d() == null)
        {
          cvm.b("EmailMigration", "The attachment (id: %d) has no contentUri, nothing to migrate", new Object[] { Long.valueOf(D) });
        }
        else
        {
          Uri localUri = Uri.parse(localAttachment.d());
          Object localObject10 = null;
          InputStream localInputStream = null;
          localObject8 = localInputStream;
          Object localObject5 = localObject10;
          try
          {
            if (w == 1)
            {
              localObject8 = localInputStream;
              localObject5 = localObject10;
              w = 0;
            }
            localObject8 = localInputStream;
            localObject5 = localObject10;
            localInputStream = h.openInputStream(localUri);
            if (localInputStream == null)
            {
              localObject8 = localInputStream;
              localObject5 = localInputStream;
              cvm.d("EmailMigration", "Could not get an input stream to the file and the attachment was not migrated", new Object[0]);
              if (localInputStream != null) {
                try
                {
                  localInputStream.close();
                }
                catch (IOException localIOException1)
                {
                  cvm.e("EmailMigration", localIOException1, "Error closing file stream", new Object[0]);
                }
              }
            }
            else
            {
              localObject8 = localInputStream;
              Object localObject6 = localInputStream;
              bgt.a(this, localInputStream, localAttachment);
              if (localInputStream != null) {}
              try
              {
                localInputStream.close();
                cvm.b("EmailMigration", "Done migrating Attachment id: %d for Email Account id: %d", new Object[] { Long.valueOf(D), Long.valueOf(paramLong2) });
              }
              catch (IOException localIOException2)
              {
                for (;;)
                {
                  cvm.e("EmailMigration", localIOException2, "Error closing file stream", new Object[0]);
                }
              }
            }
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            Object localObject7 = localObject8;
            cvm.e("EmailMigration", localFileNotFoundException, "The Attachment is missing and was not migrated", new Object[0]);
            if (localObject8 != null) {
              try
              {
                ((InputStream)localObject8).close();
              }
              catch (IOException localIOException3)
              {
                cvm.e("EmailMigration", localIOException3, "Error closing file stream", new Object[0]);
              }
            }
          }
          finally
          {
            if (localIOException3 == null) {}
          }
        }
      }
      try
      {
        localIOException3.close();
        throw ((Throwable)localObject9);
      }
      catch (IOException localIOException4)
      {
        for (;;)
        {
          cvm.e("EmailMigration", localIOException4, "Error closing file stream", new Object[0]);
        }
      }
      label1412:
      localCursor2.close();
      cvm.b("EmailMigration", "Done migrating messages for Email Account id: %d, Mailbox id: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(l1) });
    }
    localCursor1.close();
    cvm.b("EmailMigration", "Data migrated from Email Account id: %d, to Gmail Account id: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  private final void a(ArrayList<Attachment> paramArrayList, long paramLong1, long paramLong2)
  {
    cvm.b("EmailMigration", "Getting Attachments for Message id: %d", new Object[] { Long.valueOf(paramLong1) });
    Object localObject = Uri.parse(String.valueOf(g).concat("/attachment"));
    localObject = h.query((Uri)localObject, Attachment.h, "messageKey=?", new String[] { Long.toString(paramLong1) }, null);
    if (localObject == null)
    {
      cvm.b("EmailMigration", "No Attachments for Message id: %d", new Object[] { Long.valueOf(paramLong1) });
      return;
    }
    try
    {
      while (((Cursor)localObject).moveToNext())
      {
        Attachment localAttachment = new Attachment();
        localAttachment.a((Cursor)localObject);
        u = paramLong2;
        paramArrayList.add(localAttachment);
      }
    }
    finally
    {
      ((Cursor)localObject).close();
    }
    tmp162_159[0] = Long.valueOf(paramLong1);
    cvm.b("EmailMigration", "Done getting Attachments for Message id: %d", tmp162_159);
  }
  
  private final boolean a(com.android.emailcommon.provider.Account paramAccount)
  {
    cvm.b("EmailMigration", "Registering migrated Account with the AccountManager", new Object[0]);
    if (TextUtils.equals(paramAccount.f(this), i)) {
      cvm.b("EmailMigration", "This is an Exchange Account, enable calendar and contacts sync", new Object[0]);
    }
    for (boolean bool = true;; bool = false)
    {
      AccountManagerFuture localAccountManagerFuture = bam.a(this, paramAccount, true, bool, bool, t, null);
      try
      {
        localAccountManagerFuture.getResult();
        i1 = 1;
      }
      catch (OperationCanceledException localOperationCanceledException)
      {
        for (;;)
        {
          cvm.e("EmailMigration", localOperationCanceledException, "addAccount was canceled", new Object[0]);
          i1 = 0;
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          cvm.e("EmailMigration", localIOException, "addAccount failed", new Object[0]);
          int i1 = 0;
        }
        cvm.b("EmailMigration", "Successfully added Account to AccountManager, id: %d", new Object[] { Long.valueOf(D) });
        return true;
      }
      catch (AuthenticatorException localAuthenticatorException)
      {
        continue;
      }
      if (i1 == 0)
      {
        cvm.e("EmailMigration", "Failed to add Account to the AccountManager, id: %d", new Object[] { Long.valueOf(D) });
        return false;
      }
    }
  }
  
  private final boolean a(HostAuth paramHostAuth)
  {
    if (paramHostAuth == null) {
      return true;
    }
    long l1 = k;
    Object localObject;
    Credential localCredential;
    if (l1 > 0L)
    {
      localObject = ContentUris.withAppendedId(l, l1);
      localObject = h.query((Uri)localObject, bdu.a, null, null, null);
      if (localObject == null)
      {
        cvm.e("EmailMigration", "Error finding Credential id: %d", new Object[] { Long.valueOf(l1) });
        return false;
      }
      localCredential = new Credential();
    }
    try
    {
      if (!((Cursor)localObject).moveToFirst())
      {
        cvm.e("EmailMigration", "Error finding Credential id: %d, empty cursor", new Object[] { Long.valueOf(l1) });
        return false;
      }
      localCredential.a((Cursor)localObject);
      ((Cursor)localObject).close();
      l = localCredential;
      return true;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  private final boolean a(ArrayList<com.android.emailcommon.provider.Account> paramArrayList)
  {
    cvm.b("EmailMigration", "Migrating accounts", new Object[0]);
    paramArrayList = paramArrayList.iterator();
    boolean bool = false;
    if (paramArrayList.hasNext())
    {
      com.android.emailcommon.provider.Account localAccount = (com.android.emailcommon.provider.Account)paramArrayList.next();
      long l1 = D;
      if (!b(localAccount))
      {
        String str = t.b;
        buo.a().a("email_migration", "protocol", str, 0L);
        str = cui.b(d);
        buo.a().a("email_migration", "domain_name", cui.c(str), 0L);
        cvm.b("EmailMigration", "Migrating Account, id: %d", new Object[] { Long.valueOf(D) });
        D = -1L;
        m = null;
        e = null;
        if (localAccount.h(this) == null) {
          cvm.e("EmailMigration", "Error saving Account after migration, id: %d", new Object[] { Long.valueOf(D) });
        }
        for (int i1 = 0;; i1 = 1)
        {
          if (i1 != 0) {
            break label240;
          }
          cvm.e("EmailMigration", "Could not migrate Email account, id: %d", new Object[] { Long.valueOf(l1) });
          buo.a().a("email_migration", "migration_failure", null, 0L);
          break;
        }
        label240:
        if (j.equals(t.b))
        {
          cvm.b("EmailMigration", "Migrating account data for Email POP account, id: %d", new Object[] { Long.valueOf(l1) });
          a(l1, D, true);
          buo.a().a("email_migration", "feature", "pop_delete", localAccount.d());
          label314:
          bool = true;
          n.add(localAccount);
        }
      }
      for (;;)
      {
        m.add(Long.valueOf(l1));
        break;
        if (!i.equals(t.b)) {
          break label314;
        }
        cvm.b("EmailMigration", "Migrating mailbox data for Email Exchange account, id: %d", new Object[] { Long.valueOf(l1) });
        a(l1, D, false);
        break label314;
        cvm.b("EmailMigration", "Email account id: %d, already exists, skipping", new Object[] { Long.valueOf(l1) });
      }
    }
    return bool;
  }
  
  private final void b()
  {
    cvm.b("EmailMigration", "Deleting migrated Email Accounts", new Object[0]);
    if (cxd.d())
    {
      cvm.b("EmailMigration", "Delete after migration is Enabled", new Object[0]);
      Uri localUri = Uri.parse(String.valueOf(g).concat("/account"));
      Iterator localIterator = m.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Long)localIterator.next();
        cvm.b("EmailMigration", "Deleting Email account, id: %d", new Object[] { Long.valueOf(((Long)localObject).longValue()) });
        localObject = ContentUris.withAppendedId(localUri, ((Long)localObject).longValue());
        h.delete((Uri)localObject, null, null);
      }
    }
    cvm.b("EmailMigration", "Delete after migration is Disabled for pre L device", new Object[0]);
  }
  
  private final boolean b(com.android.emailcommon.provider.Account paramAccount)
  {
    cvm.b("EmailMigration", "Checking to see if Account already exists id: %d", new Object[] { Long.valueOf(D) });
    String str = d;
    paramAccount = h.query(cgr.b(), chh.c, null, null, null);
    if (paramAccount == null) {
      return false;
    }
    try
    {
      while (paramAccount.moveToNext())
      {
        com.android.mail.providers.Account.b();
        if (str.equals(ac))
        {
          cvm.b("EmailMigration", "Found a match, we don't need to migrate this Account", new Object[0]);
          return true;
        }
      }
      paramAccount.close();
      cvm.b("EmailMigration", "Could not find a match, we can migrate this Account", new Object[0]);
      return false;
    }
    finally
    {
      paramAccount.close();
    }
  }
  
  private static void c()
  {
    buo.a().a("email_migration", "migration_done", null, 0L);
    buq.b.a("migration_timer", true, "email_migration", "migration_duration", null);
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      cvm.f("EmailMigration", "intent is null", new Object[0]);
      return;
    }
    paramIntent = getResources();
    if (paramIntent == null)
    {
      cvm.f("EmailMigration", "resources is null", new Object[0]);
      return;
    }
    o = a(this, paramIntent.getString(dge.cg));
    if (o == -1) {
      cvm.c("EmailMigration", "No data to migrate", new Object[0]);
    }
    if (o == 0)
    {
      cvm.d("EmailMigration", "We do not support migrating version %d of the Email provider", new Object[] { Integer.valueOf(o) });
      return;
    }
    h = getContentResolver();
    i = paramIntent.getString(dge.fj);
    j = paramIntent.getString(dge.fk);
    paramIntent = String.valueOf(paramIntent.getString(dge.bC));
    if (paramIntent.length() != 0) {}
    for (paramIntent = "content://".concat(paramIntent);; paramIntent = new String("content://"))
    {
      g = paramIntent;
      k = Uri.parse(String.valueOf(g).concat("/hostauth"));
      l = Uri.parse(String.valueOf(g).concat("/credential"));
      bdv.i(this);
      if (!g.equals(f)) {
        break;
      }
      cvm.b("EmailMigration", "Nothing to migrate, src & dest URIs are the same", new Object[0]);
      return;
    }
    paramIntent = cfm.a(this);
    int i1 = d.getInt("migration-state", 0);
    if (i1 == 2)
    {
      cvm.b("EmailMigration", "Migration already completed", new Object[0]);
      return;
    }
    int i2;
    label307:
    boolean bool2;
    if (i1 == 1)
    {
      i1 = 1;
      if (o != 5) {
        break label375;
      }
      i2 = 1;
      if (i2 == 0) {
        break label380;
      }
      bool2 = bam.c(this, i);
      bool1 = bool2;
      if (!bool2) {
        cvm.d("EmailMigration", "No Exchange migration because Exchange is disabled", new Object[0]);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((i1 == 0) || (bool1)) {
        break label399;
      }
      cvm.b("EmailMigration", "Already migrated IMAP/POP, can't migrate Exchange", new Object[0]);
      return;
      i1 = 0;
      break;
      label375:
      i2 = 0;
      break label307;
      label380:
      cvm.d("EmailMigration", "No Exchange migration, not the right Email provider version", new Object[0]);
    }
    label399:
    if (bool1) {}
    ArrayList localArrayList;
    for (i1 = 2;; i1 = 1)
    {
      localArrayList = a(bool1);
      if (localArrayList.size() > 0) {
        break;
      }
      cvm.b("EmailMigration", "There is no account to migrate", new Object[0]);
      paramIntent.e(i1);
      return;
    }
    buq.b.a("migration_timer");
    try
    {
      Notification localNotification = new hf(this).a(getResources().getString(dge.eq)).b(getResources().getString(dge.ep)).a(dgc.a).a(System.currentTimeMillis()).b();
      flags |= 0x20;
      startForeground(-1, localNotification);
      bhb.a();
      bool1 = a(localArrayList);
      bhb.b();
    }
    finally
    {
      try
      {
        a();
        b();
        paramIntent.e(i1);
        bhb.b();
        if (bool1)
        {
          c();
          cvm.a("EmailMigration", "Forcing account reconcile after migration", new Object[0]);
          ayi.a(this);
        }
        stopForeground(true);
        return;
      }
      finally {}
      paramIntent = finally;
      bool1 = false;
    }
    if (bool1)
    {
      c();
      cvm.a("EmailMigration", "Forcing account reconcile after migration", new Object[0]);
      ayi.a(this);
    }
    stopForeground(true);
    throw paramIntent;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.EmailMigrationService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */