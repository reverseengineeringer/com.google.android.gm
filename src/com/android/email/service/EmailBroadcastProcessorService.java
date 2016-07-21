package com.android.email.service;

import android.accounts.AccountManager;
import android.app.IntentService;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.PeriodicSync;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import arh;
import ayi;
import bam;
import ban;
import bdv;
import hhk;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EmailBroadcastProcessorService
  extends IntentService
{
  private static final String[] a = { "emailAddress", "syncInterval" };
  
  public EmailBroadcastProcessorService()
  {
    super(EmailBroadcastProcessorService.class.getName());
    setIntentRedelivery(true);
  }
  
  private final Map<String, Integer> a()
  {
    Cursor localCursor = getContentResolver().query(com.android.emailcommon.provider.Account.a, a, null, null, null);
    if (localCursor != null)
    {
      HashMap localHashMap = hhk.a(localCursor.getCount());
      try
      {
        if (localCursor.moveToNext()) {
          localHashMap.put(localCursor.getString(0), Integer.valueOf(localCursor.getInt(1)));
        }
        return localMap;
      }
      finally
      {
        localCursor.close();
      }
    }
    return Collections.emptyMap();
  }
  
  private static void a(android.accounts.Account paramAccount, String paramString)
  {
    Iterator localIterator = ContentResolver.getPeriodicSyncs(paramAccount, paramString).iterator();
    while (localIterator.hasNext()) {
      ContentResolver.removePeriodicSync(paramAccount, paramString, nextextras);
    }
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, EmailBroadcastProcessorService.class);
    localIntent.setAction("com.android.mail.action.UPGRADE_BROADCAST");
    paramContext.startService(localIntent);
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, EmailBroadcastProcessorService.class);
    localIntent.setAction("com.android.email.DEVICE_POLICY_ADMIN");
    localIntent.putExtra("message_code", paramInt);
    paramContext.startService(localIntent);
  }
  
  private final void a(Class<?> paramClass)
  {
    getPackageManager().setComponentEnabledSetting(new ComponentName(this, paramClass), 2, 1);
  }
  
  private final void a(String paramString, Map<String, String> paramMap)
  {
    paramString = AccountManager.get(this).getAccountsByType(paramString);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      bam.a(this, paramString[i], paramMap);
      i += 1;
    }
  }
  
  private static void a(Map<String, String> paramMap)
  {
    Iterator localIterator = new HashSet(paramMap.keySet()).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (TextUtils.equals(str, (CharSequence)paramMap.get(str))) {
        paramMap.remove(str);
      }
    }
  }
  
  private final void b()
  {
    if (getPackageManager().getComponentEnabledSetting(new ComponentName(this, EmailUpgradeBroadcastReceiver.class)) == 2) {}
    for (int i = 1; i != 0; i = 0) {
      return;
    }
    Object localObject = hhk.a(4);
    ((Map)localObject).put("imap", getString(arh.cm));
    ((Map)localObject).put("pop3", getString(arh.cn));
    a((Map)localObject);
    if (!((Map)localObject).isEmpty())
    {
      ((Map)localObject).put("imap_type", getString(arh.j));
      ((Map)localObject).put("pop3_type", getString(arh.k));
      a("com.android.email", (Map)localObject);
    }
    ((Map)localObject).clear();
    ((Map)localObject).put("eas", getString(arh.ck));
    a((Map)localObject);
    if (!((Map)localObject).isEmpty())
    {
      ((Map)localObject).put("eas_type", getString(arh.i));
      a("com.android.exchange", (Map)localObject);
    }
    a(LegacyEmailAuthenticatorService.class);
    a(LegacyEasAuthenticatorService.class);
    localObject = a();
    Iterator localIterator = bam.c(this).iterator();
    while (localIterator.hasNext()) {
      b(nextc, (Map)localObject);
    }
    a(EmailUpgradeBroadcastReceiver.class);
  }
  
  private final void b(String paramString, Map<String, Integer> paramMap)
  {
    paramString = AccountManager.get(this).getAccountsByType(paramString);
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      android.accounts.Account localAccount = paramString[i];
      a(localAccount, bdv.F);
      a(localAccount, "com.android.calendar");
      a(localAccount, "com.android.contacts");
      Integer localInteger = (Integer)paramMap.get(name);
      if ((localInteger != null) && (localInteger.intValue() > 0)) {
        ContentResolver.addPeriodicSync(localAccount, bdv.F, Bundle.EMPTY, localInteger.intValue() * 60000L / 1000L);
      }
      i += 1;
    }
  }
  
  private final void c()
  {
    b();
    ayi.a(this);
    bam.a(this);
  }
  
  /* Error */
  private final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 36	com/android/email/service/EmailBroadcastProcessorService:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 41	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   7: getstatic 332	com/android/emailcommon/provider/Account:y	[Ljava/lang/String;
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokevirtual 47	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +14 -> 32
    //   21: aload_1
    //   22: ifnull +9 -> 31
    //   25: aload_1
    //   26: invokeinterface 85 1 0
    //   31: return
    //   32: aload_1
    //   33: invokeinterface 62 1 0
    //   38: ifeq +164 -> 202
    //   41: new 38	com/android/emailcommon/provider/Account
    //   44: dup
    //   45: invokespecial 334	com/android/emailcommon/provider/Account:<init>	()V
    //   48: astore_3
    //   49: aload_3
    //   50: aload_1
    //   51: invokevirtual 337	com/android/emailcommon/provider/Account:a	(Landroid/database/Cursor;)V
    //   54: aload_0
    //   55: invokevirtual 36	com/android/email/service/EmailBroadcastProcessorService:getContentResolver	()Landroid/content/ContentResolver;
    //   58: getstatic 340	com/android/emailcommon/provider/Mailbox:a	Landroid/net/Uri;
    //   61: getstatic 343	com/android/emailcommon/provider/Mailbox:z	[Ljava/lang/String;
    //   64: ldc_w 345
    //   67: iconst_2
    //   68: anewarray 10	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_3
    //   74: getfield 349	com/android/emailcommon/provider/Account:D	J
    //   77: invokestatic 352	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: ldc_w 354
    //   86: aastore
    //   87: aconst_null
    //   88: invokevirtual 47	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   91: astore_2
    //   92: aload_2
    //   93: ifnull +12 -> 105
    //   96: aload_2
    //   97: invokeinterface 53 1 0
    //   102: ifne +32 -> 134
    //   105: getstatic 358	bbw:a	Ljava/lang/String;
    //   108: ldc_w 360
    //   111: iconst_1
    //   112: anewarray 362	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: aload_3
    //   118: getfield 349	com/android/emailcommon/provider/Account:D	J
    //   121: invokestatic 367	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: aastore
    //   125: invokestatic 372	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   128: pop
    //   129: aload_0
    //   130: aload_3
    //   131: invokestatic 375	bam:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;)V
    //   134: aload_2
    //   135: ifnull -103 -> 32
    //   138: aload_2
    //   139: invokeinterface 85 1 0
    //   144: goto -112 -> 32
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokeinterface 85 1 0
    //   158: aload_2
    //   159: athrow
    //   160: astore_3
    //   161: getstatic 358	bbw:a	Ljava/lang/String;
    //   164: aload_3
    //   165: ldc_w 377
    //   168: iconst_0
    //   169: anewarray 362	java/lang/Object
    //   172: invokestatic 381	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   175: pop
    //   176: aload_2
    //   177: ifnull -145 -> 32
    //   180: aload_2
    //   181: invokeinterface 85 1 0
    //   186: goto -154 -> 32
    //   189: astore_3
    //   190: aload_2
    //   191: ifnull +9 -> 200
    //   194: aload_2
    //   195: invokeinterface 85 1 0
    //   200: aload_3
    //   201: athrow
    //   202: aload_1
    //   203: ifnull -172 -> 31
    //   206: aload_1
    //   207: invokeinterface 85 1 0
    //   212: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	EmailBroadcastProcessorService
    //   16	191	1	localCursor1	Cursor
    //   91	48	2	localCursor2	Cursor
    //   147	48	2	localObject1	Object
    //   48	83	3	localAccount	com.android.emailcommon.provider.Account
    //   160	5	3	localRemoteException	android.os.RemoteException
    //   189	12	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   32	92	147	finally
    //   138	144	147	finally
    //   180	186	147	finally
    //   194	200	147	finally
    //   200	202	147	finally
    //   96	105	160	android/os/RemoteException
    //   105	134	160	android/os/RemoteException
    //   96	105	189	finally
    //   105	134	189	finally
    //   161	176	189	finally
  }
  
  /* Error */
  protected void onHandleIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 386	android/content/Intent:getAction	()Ljava/lang/String;
    //   4: astore 8
    //   6: iconst_m1
    //   7: istore_2
    //   8: aload 8
    //   10: invokevirtual 389	java/lang/String:hashCode	()I
    //   13: lookupswitch	default:+35->48, -1310960556:+64->77, -655482899:+80->93, 1030080209:+95->108
    //   48: iload_2
    //   49: tableswitch	default:+27->76, 0:+74->123, 1:+697->746, 2:+904->953
    //   76: return
    //   77: aload 8
    //   79: ldc_w 391
    //   82: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq -37 -> 48
    //   88: iconst_0
    //   89: istore_2
    //   90: goto -42 -> 48
    //   93: aload 8
    //   95: ldc -113
    //   97: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: ifeq -52 -> 48
    //   103: iconst_1
    //   104: istore_2
    //   105: goto -57 -> 48
    //   108: aload 8
    //   110: ldc -126
    //   112: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifeq -67 -> 48
    //   118: iconst_2
    //   119: istore_2
    //   120: goto -72 -> 48
    //   123: aload_1
    //   124: ldc_w 396
    //   127: invokevirtual 400	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   130: checkcast 125	android/content/Intent
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 386	android/content/Intent:getAction	()Ljava/lang/String;
    //   138: astore 8
    //   140: iconst_m1
    //   141: istore_2
    //   142: aload 8
    //   144: invokevirtual 389	java/lang/String:hashCode	()I
    //   147: lookupswitch	default:+57->204, -1967537494:+385->532, -1949199094:+369->516, -853753606:+321->468, -19011148:+337->484, 798292259:+305->452, 1552785556:+353->500
    //   204: iload_2
    //   205: tableswitch	default:+39->244, 0:+40->245, 1:+404->609, 2:+432->637, 3:+432->637, 4:+448->653, 5:+491->696
    //   244: return
    //   245: aload_0
    //   246: invokestatic 405	aqv:a	(Landroid/content/Context;)Laqv;
    //   249: astore 8
    //   251: aload 8
    //   253: getfield 408	aqv:a	Landroid/content/SharedPreferences;
    //   256: ldc_w 410
    //   259: iconst_0
    //   260: invokeinterface 415 3 0
    //   265: istore 4
    //   267: iload 4
    //   269: ifgt +689 -> 958
    //   272: getstatic 358	bbw:a	Ljava/lang/String;
    //   275: ldc_w 417
    //   278: iconst_0
    //   279: anewarray 362	java/lang/Object
    //   282: invokestatic 419	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   285: pop
    //   286: iconst_1
    //   287: istore_2
    //   288: aload_0
    //   289: invokestatic 421	bam:d	(Landroid/content/Context;)V
    //   292: iload_2
    //   293: istore_3
    //   294: iload_2
    //   295: iconst_2
    //   296: if_icmpge +260 -> 556
    //   299: getstatic 358	bbw:a	Ljava/lang/String;
    //   302: ldc_w 423
    //   305: iconst_0
    //   306: anewarray 362	java/lang/Object
    //   309: invokestatic 419	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   312: pop
    //   313: aload_0
    //   314: invokevirtual 424	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   317: astore 9
    //   319: aload 9
    //   321: getstatic 41	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   324: getstatic 332	com/android/emailcommon/provider/Account:y	[Ljava/lang/String;
    //   327: aconst_null
    //   328: aconst_null
    //   329: aconst_null
    //   330: invokevirtual 47	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   333: astore_1
    //   334: aload_1
    //   335: invokeinterface 62 1 0
    //   340: ifeq +208 -> 548
    //   343: aload_0
    //   344: aload_1
    //   345: bipush 6
    //   347: invokeinterface 428 2 0
    //   352: invokestatic 433	com/android/emailcommon/provider/HostAuth:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/HostAuth;
    //   355: astore 10
    //   357: aload_0
    //   358: getstatic 224	arh:cm	I
    //   361: invokevirtual 434	android/content/Context:getString	(I)Ljava/lang/String;
    //   364: aload 10
    //   366: getfield 436	com/android/emailcommon/provider/HostAuth:b	Ljava/lang/String;
    //   369: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   372: ifeq -38 -> 334
    //   375: aload_1
    //   376: bipush 8
    //   378: invokeinterface 70 2 0
    //   383: istore_2
    //   384: new 438	android/content/ContentValues
    //   387: dup
    //   388: invokespecial 439	android/content/ContentValues:<init>	()V
    //   391: astore 10
    //   393: aload 10
    //   395: ldc_w 441
    //   398: iload_2
    //   399: bipush -13
    //   401: iand
    //   402: bipush 8
    //   404: ior
    //   405: invokestatic 76	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   408: invokevirtual 444	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   411: aload_1
    //   412: iconst_0
    //   413: invokeinterface 428 2 0
    //   418: lstore 5
    //   420: aload 9
    //   422: getstatic 41	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   425: lload 5
    //   427: invokestatic 450	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   430: aload 10
    //   432: aconst_null
    //   433: aconst_null
    //   434: invokevirtual 454	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   437: pop
    //   438: goto -104 -> 334
    //   441: astore 8
    //   443: aload_1
    //   444: invokeinterface 85 1 0
    //   449: aload 8
    //   451: athrow
    //   452: aload 8
    //   454: ldc_w 456
    //   457: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   460: ifeq -256 -> 204
    //   463: iconst_0
    //   464: istore_2
    //   465: goto -261 -> 204
    //   468: aload 8
    //   470: ldc_w 458
    //   473: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   476: ifeq -272 -> 204
    //   479: iconst_1
    //   480: istore_2
    //   481: goto -277 -> 204
    //   484: aload 8
    //   486: ldc_w 460
    //   489: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   492: ifeq -288 -> 204
    //   495: iconst_2
    //   496: istore_2
    //   497: goto -293 -> 204
    //   500: aload 8
    //   502: ldc_w 462
    //   505: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   508: ifeq -304 -> 204
    //   511: iconst_3
    //   512: istore_2
    //   513: goto -309 -> 204
    //   516: aload 8
    //   518: ldc_w 464
    //   521: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   524: ifeq -320 -> 204
    //   527: iconst_4
    //   528: istore_2
    //   529: goto -325 -> 204
    //   532: aload 8
    //   534: ldc_w 466
    //   537: invokevirtual 394	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   540: ifeq -336 -> 204
    //   543: iconst_5
    //   544: istore_2
    //   545: goto -341 -> 204
    //   548: aload_1
    //   549: invokeinterface 85 1 0
    //   554: iconst_2
    //   555: istore_3
    //   556: iload_3
    //   557: iload 4
    //   559: if_icmpeq +41 -> 600
    //   562: aload 8
    //   564: getfield 408	aqv:a	Landroid/content/SharedPreferences;
    //   567: invokeinterface 470 1 0
    //   572: ldc_w 410
    //   575: iload_3
    //   576: invokeinterface 476 3 0
    //   581: invokeinterface 479 1 0
    //   586: getstatic 358	bbw:a	Ljava/lang/String;
    //   589: ldc_w 481
    //   592: iconst_0
    //   593: anewarray 362	java/lang/Object
    //   596: invokestatic 419	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   599: pop
    //   600: aload_0
    //   601: invokespecial 483	com/android/email/service/EmailBroadcastProcessorService:c	()V
    //   604: aload_0
    //   605: invokespecial 485	com/android/email/service/EmailBroadcastProcessorService:d	()V
    //   608: return
    //   609: getstatic 358	bbw:a	Ljava/lang/String;
    //   612: ldc_w 487
    //   615: iconst_0
    //   616: anewarray 362	java/lang/Object
    //   619: invokestatic 419	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   622: pop
    //   623: aload_0
    //   624: invokespecial 483	com/android/email/service/EmailBroadcastProcessorService:c	()V
    //   627: aload_0
    //   628: invokevirtual 491	com/android/email/service/EmailBroadcastProcessorService:getApplicationContext	()Landroid/content/Context;
    //   631: aconst_null
    //   632: aconst_null
    //   633: invokestatic 496	com/android/mail/utils/NotificationActionUtils:a	(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    //   636: return
    //   637: aload_1
    //   638: aload_0
    //   639: ldc_w 498
    //   642: invokevirtual 502	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   645: pop
    //   646: aload_0
    //   647: aload_1
    //   648: invokevirtual 503	com/android/email/service/EmailBroadcastProcessorService:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   651: pop
    //   652: return
    //   653: aload_1
    //   654: invokevirtual 507	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   657: ldc_w 509
    //   660: invokevirtual 512	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   663: invokestatic 518	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   666: istore 7
    //   668: aload_0
    //   669: invokestatic 405	aqv:a	(Landroid/content/Context;)Laqv;
    //   672: getfield 408	aqv:a	Landroid/content/SharedPreferences;
    //   675: invokeinterface 470 1 0
    //   680: ldc_w 520
    //   683: iload 7
    //   685: invokeinterface 524 3 0
    //   690: invokeinterface 479 1 0
    //   695: return
    //   696: aload_1
    //   697: ldc_w 526
    //   700: lconst_0
    //   701: invokevirtual 530	android/content/Intent:getLongExtra	(Ljava/lang/String;J)J
    //   704: lstore 5
    //   706: aload_1
    //   707: ldc_w 532
    //   710: iconst_1
    //   711: invokevirtual 536	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   714: istore 7
    //   716: aload_0
    //   717: invokestatic 541	bbz:a	(Landroid/content/Context;)Lbbx;
    //   720: astore_1
    //   721: iload 7
    //   723: ifeq +13 -> 736
    //   726: aload_1
    //   727: lload 5
    //   729: iconst_1
    //   730: invokeinterface 546 4 0
    //   735: return
    //   736: aload_1
    //   737: lload 5
    //   739: iconst_1
    //   740: invokeinterface 548 4 0
    //   745: return
    //   746: aload_1
    //   747: ldc -111
    //   749: iconst_m1
    //   750: invokevirtual 551	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   753: istore_2
    //   754: aload_0
    //   755: invokestatic 556	com/android/email/SecurityPolicy:a	(Landroid/content/Context;)Lcom/android/email/SecurityPolicy;
    //   758: astore 8
    //   760: iload_2
    //   761: tableswitch	default:+31->792, 1:+32->793, 2:+39->800, 3:+46->807, 4:+60->821
    //   792: return
    //   793: aload 8
    //   795: iconst_1
    //   796: invokevirtual 558	com/android/email/SecurityPolicy:a	(Z)V
    //   799: return
    //   800: aload 8
    //   802: iconst_0
    //   803: invokevirtual 558	com/android/email/SecurityPolicy:a	(Z)V
    //   806: return
    //   807: aload_0
    //   808: invokestatic 561	com/android/emailcommon/provider/Account:g	(Landroid/content/Context;)V
    //   811: aload_0
    //   812: invokestatic 541	bbz:a	(Landroid/content/Context;)Lbbx;
    //   815: invokeinterface 562 1 0
    //   820: return
    //   821: aload 8
    //   823: getfield 565	com/android/email/SecurityPolicy:a	Landroid/content/Context;
    //   826: astore_1
    //   827: aload_1
    //   828: getstatic 568	com/android/emailcommon/provider/Policy:a	Landroid/net/Uri;
    //   831: getstatic 571	com/android/emailcommon/provider/Policy:B	[Ljava/lang/String;
    //   834: ldc_w 573
    //   837: aconst_null
    //   838: ldc_w 575
    //   841: ldc2_w 576
    //   844: invokestatic 367	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   847: invokestatic 582	bhn:a	(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;
    //   850: invokevirtual 586	java/lang/Long:longValue	()J
    //   853: lstore 5
    //   855: lload 5
    //   857: lconst_0
    //   858: lcmp
    //   859: ifge +61 -> 920
    //   862: ldc2_w 576
    //   865: lstore 5
    //   867: lload 5
    //   869: ldc2_w 576
    //   872: lcmp
    //   873: ifeq -797 -> 76
    //   876: aload 8
    //   878: invokevirtual 589	com/android/email/SecurityPolicy:a	()Landroid/app/admin/DevicePolicyManager;
    //   881: aload 8
    //   883: getfield 592	com/android/email/SecurityPolicy:b	Landroid/content/ComponentName;
    //   886: invokevirtual 598	android/app/admin/DevicePolicyManager:getPasswordExpiration	(Landroid/content/ComponentName;)J
    //   889: invokestatic 603	java/lang/System:currentTimeMillis	()J
    //   892: lsub
    //   893: lconst_0
    //   894: lcmp
    //   895: ifge +36 -> 931
    //   898: iconst_1
    //   899: istore_2
    //   900: aload_1
    //   901: invokestatic 541	bbz:a	(Landroid/content/Context;)Lbbx;
    //   904: astore 8
    //   906: iload_2
    //   907: ifne +29 -> 936
    //   910: aload 8
    //   912: lload 5
    //   914: invokeinterface 606 3 0
    //   919: return
    //   920: aload_1
    //   921: lload 5
    //   923: invokestatic 609	com/android/emailcommon/provider/Policy:b	(Landroid/content/Context;J)J
    //   926: lstore 5
    //   928: goto -61 -> 867
    //   931: iconst_0
    //   932: istore_2
    //   933: goto -33 -> 900
    //   936: aload_1
    //   937: invokestatic 612	com/android/email/SecurityPolicy:b	(Landroid/content/Context;)Z
    //   940: ifeq -864 -> 76
    //   943: aload 8
    //   945: lload 5
    //   947: invokeinterface 614 3 0
    //   952: return
    //   953: aload_0
    //   954: invokespecial 321	com/android/email/service/EmailBroadcastProcessorService:b	()V
    //   957: return
    //   958: iload 4
    //   960: istore_2
    //   961: goto -669 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	964	0	this	EmailBroadcastProcessorService
    //   0	964	1	paramIntent	Intent
    //   7	954	2	i	int
    //   293	283	3	j	int
    //   265	694	4	k	int
    //   418	528	5	l	long
    //   666	56	7	bool	boolean
    //   4	248	8	localObject1	Object
    //   441	122	8	localObject2	Object
    //   758	186	8	localObject3	Object
    //   317	104	9	localContentResolver	ContentResolver
    //   355	76	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   334	438	441	finally
  }
}

/* Location:
 * Qualified Name:     com.android.email.service.EmailBroadcastProcessorService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */