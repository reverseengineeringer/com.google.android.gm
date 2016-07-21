import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.email.service.EasAuthenticatorService;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

public final class bam
{
  public static final String a = cvm.a;
  private static final Configuration b = new Configuration();
  private static Map<String, ban> c = null;
  private static final Object d = new Object();
  
  public static int a(bdi parambdi)
  {
    int i = 21;
    String str;
    switch (d)
    {
    case 0: 
    case 6: 
    case 15: 
    default: 
      str = cvl.a;
      parambdi = String.valueOf(parambdi.a());
      if (parambdi.length() == 0) {
        break;
      }
    }
    for (parambdi = "convertToEmailServiceStatus sees unlikely value: ".concat(parambdi);; parambdi = new String("convertToEmailServiceStatus sees unlikely value: "))
    {
      cvm.d(str, parambdi, new Object[0]);
      i = 39;
      return i;
      return 0;
      return 34;
      return 37;
      return 32;
      return 22;
      return 23;
      return 22;
    }
  }
  
  public static AccountManagerFuture<Bundle> a(AccountManagerCallback<Bundle> paramAccountManagerCallback)
  {
    com.android.emailcommon.provider.Account localAccount;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    return a(paramAccountManagerCallback, localAccount, bool1, bool2, bool3, HostAuth.a(paramAccountManagerCallback, h), null);
  }
  
  public static AccountManagerFuture<Bundle> a(Context paramContext, com.android.emailcommon.provider.Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, HostAuth paramHostAuth, AccountManagerCallback<Bundle> paramAccountManagerCallback)
  {
    if (paramHostAuth == null) {
      return null;
    }
    paramAccountManagerCallback = new Bundle(5);
    paramAccountManagerCallback.putString("username", d);
    paramAccountManagerCallback.putString("password", g);
    paramAccountManagerCallback.putBoolean("contacts", paramBoolean3);
    paramAccountManagerCallback.putBoolean("calendar", paramBoolean2);
    paramAccountManagerCallback.putBoolean("email", paramBoolean1);
    paramAccount = e(paramContext, b);
    return AccountManager.get(paramContext).addAccount(c, null, null, paramAccountManagerCallback, null, null, null);
  }
  
  private static Intent a(Context paramContext, ban paramban)
  {
    if (TextUtils.equals(b, paramContext.getString(arh.bj)))
    {
      if (cuh.a())
      {
        paramban = new Intent();
        paramban.setClassName(paramContext, paramContext.getString(arh.bc));
        return paramban;
      }
      paramContext = new Intent(e);
      paramContext.setPackage(f);
      return paramContext;
    }
    if (F) {
      return null;
    }
    paramContext = String.valueOf(paramban);
    throw new IllegalArgumentException(String.valueOf(paramContext).length() + 17 + "unknown service: " + paramContext);
  }
  
  private static Uri a(Uri paramUri, String paramString1, String paramString2)
  {
    return paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", paramString1).appendQueryParameter("account_type", paramString2).build();
  }
  
  public static ber a(Context paramContext, long paramLong)
  {
    return d(paramContext, com.android.emailcommon.provider.Account.c(paramContext, paramLong));
  }
  
  private static void a(AccountManagerFuture<?> paramAccountManagerFuture)
  {
    try
    {
      paramAccountManagerFuture.getResult();
      return;
    }
    catch (OperationCanceledException paramAccountManagerFuture)
    {
      cvm.d(a, paramAccountManagerFuture, "finishAccountManagerBlocker", new Object[0]);
      return;
    }
    catch (AuthenticatorException paramAccountManagerFuture)
    {
      for (;;) {}
    }
    catch (IOException paramAccountManagerFuture)
    {
      for (;;) {}
    }
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = c(paramContext).iterator();
    while (localIterator.hasNext())
    {
      ban localban = (ban)localIterator.next();
      if (e != null) {
        paramContext.startService(a(paramContext, localban));
      }
    }
  }
  
  /* Error */
  public static void a(Context paramContext, android.accounts.Account paramAccount, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 278	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 10
    //   6: aload 10
    //   8: getstatic 281	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   11: getstatic 285	com/android/emailcommon/provider/Account:y	[Ljava/lang/String;
    //   14: ldc_w 287
    //   17: iconst_1
    //   18: anewarray 47	java/lang/String
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: getfield 292	android/accounts/Account:name	Ljava/lang/String;
    //   27: aastore
    //   28: aconst_null
    //   29: invokevirtual 298	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   32: astore 9
    //   34: aload 9
    //   36: ifnonnull +4 -> 40
    //   39: return
    //   40: aload 9
    //   42: invokeinterface 303 1 0
    //   47: ifeq +869 -> 916
    //   50: new 70	com/android/emailcommon/provider/Account
    //   53: dup
    //   54: invokespecial 304	com/android/emailcommon/provider/Account:<init>	()V
    //   57: astore 15
    //   59: aload 15
    //   61: aload 9
    //   63: invokevirtual 307	com/android/emailcommon/provider/Account:a	(Landroid/database/Cursor;)V
    //   66: aload_0
    //   67: aload 15
    //   69: getfield 74	com/android/emailcommon/provider/Account:h	J
    //   72: invokestatic 79	com/android/emailcommon/provider/HostAuth:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/HostAuth;
    //   75: astore 16
    //   77: aload 16
    //   79: ifnonnull +11 -> 90
    //   82: aload 9
    //   84: invokeinterface 310 1 0
    //   89: return
    //   90: aload_2
    //   91: aload 16
    //   93: getfield 114	com/android/emailcommon/provider/HostAuth:b	Ljava/lang/String;
    //   96: invokeinterface 315 2 0
    //   101: checkcast 47	java/lang/String
    //   104: astore 7
    //   106: aload 7
    //   108: ifnonnull +11 -> 119
    //   111: aload 9
    //   113: invokeinterface 310 1 0
    //   118: return
    //   119: getstatic 20	bam:a	Ljava/lang/String;
    //   122: ldc_w 317
    //   125: iconst_2
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_1
    //   132: getfield 292	android/accounts/Account:name	Ljava/lang/String;
    //   135: aastore
    //   136: dup
    //   137: iconst_1
    //   138: aload 7
    //   140: aastore
    //   141: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   144: pop
    //   145: new 319	android/content/ContentValues
    //   148: dup
    //   149: invokespecial 320	android/content/ContentValues:<init>	()V
    //   152: astore 11
    //   154: aload 15
    //   156: getfield 323	com/android/emailcommon/provider/Account:j	I
    //   159: istore_3
    //   160: aload 15
    //   162: aload 15
    //   164: getfield 323	com/android/emailcommon/provider/Account:j	I
    //   167: bipush 16
    //   169: ior
    //   170: putfield 323	com/android/emailcommon/provider/Account:j	I
    //   173: aload 11
    //   175: ldc_w 325
    //   178: aload 15
    //   180: getfield 323	com/android/emailcommon/provider/Account:j	I
    //   183: invokestatic 330	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   189: getstatic 281	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   192: aload 15
    //   194: getfield 337	com/android/emailcommon/provider/Account:D	J
    //   197: invokestatic 343	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   200: astore 12
    //   202: aload 10
    //   204: aload 12
    //   206: aload 11
    //   208: aconst_null
    //   209: aconst_null
    //   210: invokevirtual 347	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   213: pop
    //   214: new 319	android/content/ContentValues
    //   217: dup
    //   218: invokespecial 320	android/content/ContentValues:<init>	()V
    //   221: astore 8
    //   223: aload 8
    //   225: ldc_w 349
    //   228: aload 7
    //   230: invokevirtual 351	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload 10
    //   235: getstatic 352	com/android/emailcommon/provider/HostAuth:a	Landroid/net/Uri;
    //   238: aload 16
    //   240: getfield 353	com/android/emailcommon/provider/HostAuth:D	J
    //   243: invokestatic 343	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   246: aload 8
    //   248: aconst_null
    //   249: aconst_null
    //   250: invokevirtual 347	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   253: pop
    //   254: getstatic 20	bam:a	Ljava/lang/String;
    //   257: ldc_w 355
    //   260: iconst_0
    //   261: anewarray 4	java/lang/Object
    //   264: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   267: pop
    //   268: aload_1
    //   269: getstatic 359	bdv:F	Ljava/lang/String;
    //   272: invokestatic 363	android/content/ContentResolver:getSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;)Z
    //   275: istore 4
    //   277: iload 4
    //   279: ifne +820 -> 1099
    //   282: aload_1
    //   283: ldc_w 365
    //   286: invokestatic 363	android/content/ContentResolver:getSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;)Z
    //   289: istore 4
    //   291: aload_1
    //   292: ldc_w 367
    //   295: invokestatic 363	android/content/ContentResolver:getSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;)Z
    //   298: istore 5
    //   300: aload_1
    //   301: ldc_w 369
    //   304: invokestatic 363	android/content/ContentResolver:getSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;)Z
    //   307: istore 6
    //   309: getstatic 20	bam:a	Ljava/lang/String;
    //   312: ldc_w 371
    //   315: iconst_3
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: iload 4
    //   323: invokestatic 376	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   326: aastore
    //   327: dup
    //   328: iconst_1
    //   329: iload 5
    //   331: invokestatic 376	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   334: aastore
    //   335: dup
    //   336: iconst_2
    //   337: iload 6
    //   339: invokestatic 376	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   342: aastore
    //   343: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   346: pop
    //   347: aload_1
    //   348: getfield 292	android/accounts/Account:name	Ljava/lang/String;
    //   351: astore 13
    //   353: aload_1
    //   354: getfield 379	android/accounts/Account:type	Ljava/lang/String;
    //   357: astore 14
    //   359: aload_0
    //   360: invokevirtual 278	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   363: getstatic 384	android/provider/CalendarContract:CONTENT_URI	Landroid/net/Uri;
    //   366: invokevirtual 388	android/content/ContentResolver:acquireContentProviderClient	(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    //   369: astore 8
    //   371: aload 8
    //   373: getstatic 391	android/provider/CalendarContract$SyncState:CONTENT_URI	Landroid/net/Uri;
    //   376: aload 13
    //   378: aload 14
    //   380: invokestatic 393	bam:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   383: new 289	android/accounts/Account
    //   386: dup
    //   387: aload 13
    //   389: aload 14
    //   391: invokespecial 395	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: invokestatic 400	android/provider/SyncStateContract$Helpers:get	(Landroid/content/ContentProviderClient;Landroid/net/Uri;Landroid/accounts/Account;)[B
    //   397: astore 7
    //   399: aload 8
    //   401: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   404: pop
    //   405: aload_0
    //   406: invokevirtual 278	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   409: getstatic 410	android/provider/ContactsContract:AUTHORITY_URI	Landroid/net/Uri;
    //   412: invokevirtual 388	android/content/ContentResolver:acquireContentProviderClient	(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    //   415: astore 17
    //   417: aload 17
    //   419: getstatic 413	android/provider/ContactsContract$SyncState:CONTENT_URI	Landroid/net/Uri;
    //   422: new 289	android/accounts/Account
    //   425: dup
    //   426: aload 13
    //   428: aload 14
    //   430: invokespecial 395	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: invokestatic 400	android/provider/SyncStateContract$Helpers:get	(Landroid/content/ContentProviderClient;Landroid/net/Uri;Landroid/accounts/Account;)[B
    //   436: astore 8
    //   438: aload 17
    //   440: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   443: pop
    //   444: aload 7
    //   446: ifnull +29 -> 475
    //   449: getstatic 20	bam:a	Ljava/lang/String;
    //   452: ldc_w 415
    //   455: iconst_1
    //   456: anewarray 4	java/lang/Object
    //   459: dup
    //   460: iconst_0
    //   461: new 47	java/lang/String
    //   464: dup
    //   465: aload 7
    //   467: invokespecial 418	java/lang/String:<init>	([B)V
    //   470: aastore
    //   471: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   474: pop
    //   475: aload 8
    //   477: ifnull +29 -> 506
    //   480: getstatic 20	bam:a	Ljava/lang/String;
    //   483: ldc_w 420
    //   486: iconst_1
    //   487: anewarray 4	java/lang/Object
    //   490: dup
    //   491: iconst_0
    //   492: new 47	java/lang/String
    //   495: dup
    //   496: aload 8
    //   498: invokespecial 418	java/lang/String:<init>	([B)V
    //   501: aastore
    //   502: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   505: pop
    //   506: aload_0
    //   507: aload 15
    //   509: iload 4
    //   511: iload 6
    //   513: iload 5
    //   515: invokestatic 422	bam:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;ZZZ)Landroid/accounts/AccountManagerFuture;
    //   518: invokestatic 424	bam:a	(Landroid/accounts/AccountManagerFuture;)V
    //   521: getstatic 20	bam:a	Ljava/lang/String;
    //   524: ldc_w 426
    //   527: iconst_0
    //   528: anewarray 4	java/lang/Object
    //   531: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   534: pop
    //   535: aload_2
    //   536: aload 16
    //   538: getfield 114	com/android/emailcommon/provider/HostAuth:b	Ljava/lang/String;
    //   541: invokestatic 51	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   544: ldc_w 428
    //   547: invokevirtual 61	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   550: invokeinterface 315 2 0
    //   555: checkcast 47	java/lang/String
    //   558: astore_2
    //   559: aload_0
    //   560: invokevirtual 278	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   563: astore 15
    //   565: getstatic 431	android/provider/CalendarContract$Calendars:CONTENT_URI	Landroid/net/Uri;
    //   568: invokevirtual 203	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   571: ldc -51
    //   573: ldc -49
    //   575: invokevirtual 213	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   578: ldc -41
    //   580: aload 13
    //   582: invokevirtual 213	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   585: ldc -39
    //   587: aload 14
    //   589: invokevirtual 213	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   592: invokevirtual 221	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   595: astore 16
    //   597: new 319	android/content/ContentValues
    //   600: dup
    //   601: invokespecial 320	android/content/ContentValues:<init>	()V
    //   604: astore 17
    //   606: aload 17
    //   608: ldc -39
    //   610: aload_2
    //   611: invokevirtual 351	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload 15
    //   616: aload 16
    //   618: aload 17
    //   620: ldc_w 433
    //   623: iconst_2
    //   624: anewarray 47	java/lang/String
    //   627: dup
    //   628: iconst_0
    //   629: aload 13
    //   631: aastore
    //   632: dup
    //   633: iconst_1
    //   634: aload 14
    //   636: aastore
    //   637: invokevirtual 347	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   640: pop
    //   641: aload_0
    //   642: invokevirtual 278	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   645: astore 15
    //   647: getstatic 436	android/provider/ContactsContract$RawContacts:CONTENT_URI	Landroid/net/Uri;
    //   650: invokevirtual 203	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   653: ldc -51
    //   655: ldc -49
    //   657: invokevirtual 213	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   660: ldc -41
    //   662: aload 13
    //   664: invokevirtual 213	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   667: ldc -39
    //   669: aload 14
    //   671: invokevirtual 213	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   674: invokevirtual 221	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   677: astore 14
    //   679: new 319	android/content/ContentValues
    //   682: dup
    //   683: invokespecial 320	android/content/ContentValues:<init>	()V
    //   686: astore 16
    //   688: aload 16
    //   690: ldc -39
    //   692: aload_2
    //   693: invokevirtual 351	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   696: aload 15
    //   698: aload 14
    //   700: aload 16
    //   702: aconst_null
    //   703: aconst_null
    //   704: invokevirtual 347	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   707: pop
    //   708: aload_0
    //   709: invokestatic 124	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
    //   712: aload_1
    //   713: aconst_null
    //   714: aconst_null
    //   715: invokevirtual 440	android/accounts/AccountManager:removeAccount	(Landroid/accounts/Account;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;
    //   718: invokestatic 424	bam:a	(Landroid/accounts/AccountManagerFuture;)V
    //   721: getstatic 20	bam:a	Ljava/lang/String;
    //   724: ldc_w 442
    //   727: iconst_0
    //   728: anewarray 4	java/lang/Object
    //   731: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   734: pop
    //   735: aload_2
    //   736: ifnull +69 -> 805
    //   739: aload 7
    //   741: ifnull +64 -> 805
    //   744: aload 7
    //   746: arraylength
    //   747: ifeq +58 -> 805
    //   750: aload_0
    //   751: invokevirtual 278	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   754: getstatic 384	android/provider/CalendarContract:CONTENT_URI	Landroid/net/Uri;
    //   757: invokevirtual 388	android/content/ContentResolver:acquireContentProviderClient	(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    //   760: astore_1
    //   761: aload_1
    //   762: getstatic 391	android/provider/CalendarContract$SyncState:CONTENT_URI	Landroid/net/Uri;
    //   765: aload 13
    //   767: aload_2
    //   768: invokestatic 393	bam:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   771: new 289	android/accounts/Account
    //   774: dup
    //   775: aload 13
    //   777: aload_2
    //   778: invokespecial 395	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   781: aload 7
    //   783: invokestatic 446	android/provider/SyncStateContract$Helpers:set	(Landroid/content/ContentProviderClient;Landroid/net/Uri;Landroid/accounts/Account;[B)V
    //   786: getstatic 20	bam:a	Ljava/lang/String;
    //   789: ldc_w 448
    //   792: iconst_0
    //   793: anewarray 4	java/lang/Object
    //   796: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   799: pop
    //   800: aload_1
    //   801: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   804: pop
    //   805: aload_2
    //   806: ifnull +58 -> 864
    //   809: aload 8
    //   811: ifnull +53 -> 864
    //   814: aload 8
    //   816: arraylength
    //   817: ifeq +47 -> 864
    //   820: aload_0
    //   821: invokevirtual 278	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   824: getstatic 410	android/provider/ContactsContract:AUTHORITY_URI	Landroid/net/Uri;
    //   827: invokevirtual 388	android/content/ContentResolver:acquireContentProviderClient	(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    //   830: astore_0
    //   831: aload_0
    //   832: getstatic 413	android/provider/ContactsContract$SyncState:CONTENT_URI	Landroid/net/Uri;
    //   835: new 289	android/accounts/Account
    //   838: dup
    //   839: aload 13
    //   841: aload_2
    //   842: invokespecial 395	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   845: aload 8
    //   847: invokestatic 446	android/provider/SyncStateContract$Helpers:set	(Landroid/content/ContentProviderClient;Landroid/net/Uri;Landroid/accounts/Account;[B)V
    //   850: getstatic 20	bam:a	Ljava/lang/String;
    //   853: ldc_w 450
    //   856: iconst_0
    //   857: anewarray 4	java/lang/Object
    //   860: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   863: pop
    //   864: getstatic 20	bam:a	Ljava/lang/String;
    //   867: ldc_w 452
    //   870: iconst_0
    //   871: anewarray 4	java/lang/Object
    //   874: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   877: pop
    //   878: aload 11
    //   880: ldc_w 325
    //   883: iload_3
    //   884: invokestatic 330	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   887: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   890: aload 10
    //   892: aload 12
    //   894: aload 11
    //   896: aconst_null
    //   897: aconst_null
    //   898: invokevirtual 347	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   901: pop
    //   902: getstatic 20	bam:a	Ljava/lang/String;
    //   905: ldc_w 454
    //   908: iconst_0
    //   909: anewarray 4	java/lang/Object
    //   912: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   915: pop
    //   916: aload 9
    //   918: invokeinterface 310 1 0
    //   923: return
    //   924: astore 7
    //   926: getstatic 20	bam:a	Ljava/lang/String;
    //   929: ldc_w 456
    //   932: iconst_0
    //   933: anewarray 4	java/lang/Object
    //   936: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   939: pop
    //   940: aload 8
    //   942: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   945: pop
    //   946: aconst_null
    //   947: astore 7
    //   949: goto -544 -> 405
    //   952: astore_0
    //   953: aload 8
    //   955: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   958: pop
    //   959: aload_0
    //   960: athrow
    //   961: astore_0
    //   962: aload 11
    //   964: ldc_w 325
    //   967: iload_3
    //   968: invokestatic 330	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   971: invokevirtual 334	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   974: aload 10
    //   976: aload 12
    //   978: aload 11
    //   980: aconst_null
    //   981: aconst_null
    //   982: invokevirtual 347	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   985: pop
    //   986: getstatic 20	bam:a	Ljava/lang/String;
    //   989: ldc_w 454
    //   992: iconst_0
    //   993: anewarray 4	java/lang/Object
    //   996: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   999: pop
    //   1000: aload_0
    //   1001: athrow
    //   1002: astore_0
    //   1003: aload 9
    //   1005: invokeinterface 310 1 0
    //   1010: aload_0
    //   1011: athrow
    //   1012: astore 8
    //   1014: getstatic 20	bam:a	Ljava/lang/String;
    //   1017: ldc_w 458
    //   1020: iconst_0
    //   1021: anewarray 4	java/lang/Object
    //   1024: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1027: pop
    //   1028: aload 17
    //   1030: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   1033: pop
    //   1034: aconst_null
    //   1035: astore 8
    //   1037: goto -593 -> 444
    //   1040: astore_0
    //   1041: aload 17
    //   1043: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   1046: pop
    //   1047: aload_0
    //   1048: athrow
    //   1049: astore 7
    //   1051: getstatic 20	bam:a	Ljava/lang/String;
    //   1054: ldc_w 460
    //   1057: iconst_0
    //   1058: anewarray 4	java/lang/Object
    //   1061: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1064: pop
    //   1065: aload_1
    //   1066: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   1069: pop
    //   1070: goto -265 -> 805
    //   1073: astore_0
    //   1074: aload_1
    //   1075: invokevirtual 405	android/content/ContentProviderClient:release	()Z
    //   1078: pop
    //   1079: aload_0
    //   1080: athrow
    //   1081: astore_0
    //   1082: getstatic 20	bam:a	Ljava/lang/String;
    //   1085: ldc_w 462
    //   1088: iconst_0
    //   1089: anewarray 4	java/lang/Object
    //   1092: invokestatic 64	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   1095: pop
    //   1096: goto -232 -> 864
    //   1099: goto -808 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1102	0	paramContext	Context
    //   0	1102	1	paramAccount	android.accounts.Account
    //   0	1102	2	paramMap	Map<String, String>
    //   159	809	3	i	int
    //   275	235	4	bool1	boolean
    //   298	216	5	bool2	boolean
    //   307	205	6	bool3	boolean
    //   104	678	7	localObject1	Object
    //   924	1	7	localRemoteException1	android.os.RemoteException
    //   947	1	7	localObject2	Object
    //   1049	1	7	localRemoteException2	android.os.RemoteException
    //   221	733	8	localObject3	Object
    //   1012	1	8	localRemoteException3	android.os.RemoteException
    //   1035	1	8	localObject4	Object
    //   32	972	9	localCursor	android.database.Cursor
    //   4	971	10	localContentResolver	ContentResolver
    //   152	827	11	localContentValues	android.content.ContentValues
    //   200	777	12	localUri	Uri
    //   351	489	13	str	String
    //   357	342	14	localObject5	Object
    //   57	640	15	localObject6	Object
    //   75	626	16	localObject7	Object
    //   415	627	17	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   371	399	924	android/os/RemoteException
    //   371	399	952	finally
    //   926	940	952	finally
    //   268	277	961	finally
    //   282	291	961	finally
    //   291	371	961	finally
    //   399	405	961	finally
    //   405	417	961	finally
    //   438	444	961	finally
    //   449	475	961	finally
    //   480	506	961	finally
    //   506	735	961	finally
    //   744	761	961	finally
    //   800	805	961	finally
    //   814	831	961	finally
    //   831	864	961	finally
    //   864	878	961	finally
    //   940	946	961	finally
    //   953	961	961	finally
    //   1028	1034	961	finally
    //   1041	1049	961	finally
    //   1065	1070	961	finally
    //   1074	1081	961	finally
    //   1082	1096	961	finally
    //   40	77	1002	finally
    //   90	106	1002	finally
    //   119	268	1002	finally
    //   878	916	1002	finally
    //   962	1002	1002	finally
    //   417	438	1012	android/os/RemoteException
    //   417	438	1040	finally
    //   1014	1028	1040	finally
    //   761	800	1049	android/os/RemoteException
    //   761	800	1073	finally
    //   1051	1065	1073	finally
    //   831	864	1081	android/os/RemoteException
  }
  
  public static void a(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    HostAuth localHostAuth = paramAccount.d(paramContext);
    Object localObject = d(paramContext, b);
    paramContext = e(paramContext, b);
    if (paramContext == null)
    {
      cvm.d(a, "Could not find service info for account %d", new Object[] { Long.valueOf(D) });
      return;
    }
    paramContext = paramAccount.a(c);
    ((ber)localObject).a(D);
    localObject = new Bundle(3);
    ((Bundle)localObject).putBoolean("force", true);
    ((Bundle)localObject).putBoolean("do_not_retry", true);
    ((Bundle)localObject).putBoolean("expedited", true);
    cvm.d(a, "requesting sync for account %d", new Object[] { Long.valueOf(D) });
    ContentResolver.requestSync(paramContext, bdv.F, (Bundle)localObject);
  }
  
  public static void a(Context paramContext, Class<?> paramClass, boolean paramBoolean)
  {
    paramClass = new ComponentName(paramContext, paramClass.getName());
    paramContext = paramContext.getPackageManager();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      paramContext.setComponentEnabledSetting(paramClass, i, 1);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramString = e(paramContext, paramString);
    if ((paramString != null) && (e != null))
    {
      paramString = a(paramContext, paramString);
      paramString.putExtra("ServiceProxy.FORCE_SHUTDOWN", true);
      paramContext.startService(paramString);
    }
  }
  
  public static ban b(Context paramContext, long paramLong)
  {
    return e(paramContext, com.android.emailcommon.provider.Account.c(paramContext, paramLong));
  }
  
  public static void b(Context paramContext)
  {
    Iterator localIterator = c(paramContext).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ban)localIterator.next();
      if (e != null)
      {
        localObject = a(paramContext, (ban)localObject);
        paramContext.stopService((Intent)localObject);
        paramContext.startService((Intent)localObject);
      }
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    paramString = e(paramContext, paramString);
    if ((paramString != null) && (e != null)) {
      paramContext.startService(a(paramContext, paramString));
    }
  }
  
  public static Collection<ban> c(Context paramContext)
  {
    return e(paramContext).values();
  }
  
  public static void c(Context paramContext, long paramLong)
  {
    Object localObject = Mailbox.a(paramContext, paramLong);
    if (localObject == null) {}
    do
    {
      return;
      localObject = com.android.emailcommon.provider.Account.a(paramContext, g);
    } while (localObject == null);
    paramContext = b(paramContext, D);
    paramContext = new android.accounts.Account(d, c);
    localObject = Mailbox.a(paramLong);
    ((Bundle)localObject).putBoolean("force", true);
    ((Bundle)localObject).putBoolean("do_not_retry", true);
    ((Bundle)localObject).putBoolean("expedited", true);
    ContentResolver.requestSync(paramContext, bdv.F, (Bundle)localObject);
    cvm.c(bbw.a, "requestSync startSync mailbox: %d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramContext.getString(arh.ck))) && (!cxd.b())) {}
    do
    {
      return false;
      paramString = e(paramContext, paramString);
    } while (paramString == null);
    if ((d != null) || (F)) {
      return true;
    }
    paramString = a(paramContext, paramString);
    boolean bool = new bfn(paramContext, paramString).d();
    if (!bool) {
      cvm.c("EasBundling", "unable to resolve service for intent=%s", new Object[] { paramString });
    }
    return bool;
  }
  
  public static ber d(Context paramContext, String paramString)
  {
    if (paramString != null) {}
    for (ban localban = e(paramContext, paramString);; localban = null)
    {
      if (localban == null)
      {
        cvm.d(a, "Returning NullService for %s", new Object[] { paramString });
        return new bfn(paramContext, bao.class);
      }
      if (H)
      {
        if (d != null) {
          return new bfn(paramContext, d);
        }
        return new bfn(paramContext, a(paramContext, localban));
      }
      if (TextUtils.equals(b, paramContext.getString(arh.bp)))
      {
        if (d != null) {
          return new bba(paramContext, d);
        }
        return new bba(paramContext, a(paramContext, localban));
      }
      if (TextUtils.equals(b, paramContext.getString(arh.ci)))
      {
        if (d != null) {
          return new bbh(paramContext, d);
        }
        return new bbh(paramContext, a(paramContext, localban));
      }
      throw new IllegalArgumentException("Invalid EmailServiceInfo");
    }
  }
  
  public static void d(Context paramContext)
  {
    cvm.b(a, "Enabling EAS authenticator", new Object[0]);
    a(paramContext, EasAuthenticatorService.class, true);
  }
  
  public static ban e(Context paramContext, String paramString)
  {
    return (ban)e(paramContext).get(paramString);
  }
  
  private static Map<String, ban> e(Context paramContext)
  {
    int i;
    hen localhen;
    synchronized (d)
    {
      if (c == null) {
        b.setTo(paramContext.getResources().getConfiguration());
      }
      i = b.updateFrom(paramContext.getResources().getConfiguration());
      if ((c != null) && (!Configuration.needNewResources(i, 4)))
      {
        paramContext = c;
        return paramContext;
      }
      localhen = new hen();
      if (!paramContext.getResources().getBoolean(ara.a))
      {
        cvm.b(a, "Empty service map in Tombstone", new Object[0]);
        paramContext = localhen.b();
        c = paramContext;
        return paramContext;
      }
    }
    try
    {
      Resources localResources = paramContext.getResources();
      XmlResourceParser localXmlResourceParser = localResources.getXml(arj.f);
      do
      {
        i = localXmlResourceParser.next();
        if (i == 1) {
          break;
        }
      } while ((i != 2) || (!"emailservice".equals(localXmlResourceParser.getName())));
      localban = new ban();
      TypedArray localTypedArray = localResources.obtainAttributes(localXmlResourceParser, ari.D);
      a = localTypedArray.getString(ari.ac);
      c = localTypedArray.getString(ari.E);
      b = localTypedArray.getString(ari.P);
      E = localTypedArray.getBoolean(ari.J, false);
      paramContext = localTypedArray.getString(ari.ae);
      e = localTypedArray.getString(ari.L);
      f = localTypedArray.getString(ari.M);
      i = localTypedArray.getBoolean(ari.H, false);
      g = localTypedArray.getInteger(ari.aa, 0);
      h = localTypedArray.getInteger(ari.ab, 0);
      j = localTypedArray.getBoolean(ari.Z, false);
      k = localTypedArray.getBoolean(ari.R, false);
      l = localTypedArray.getBoolean(ari.X, false);
      n = localTypedArray.getBoolean(ari.U, false);
      o = localTypedArray.getInteger(ari.F, 2);
      p = localTypedArray.getBoolean(ari.Y, false);
      m = localTypedArray.getBoolean(ari.al, false);
      q = localTypedArray.getBoolean(ari.ak, false);
      r = localTypedArray.getBoolean(ari.V, false);
      s = localTypedArray.getInteger(ari.G, 2);
      t = localTypedArray.getBoolean(ari.ag, false);
      u = localTypedArray.getBoolean(ari.ah, false);
      v = localTypedArray.getBoolean(ari.af, false);
      w = localTypedArray.getBoolean(ari.Q, false);
      x = localTypedArray.getTextArray(ari.ai);
      y = localTypedArray.getTextArray(ari.aj);
      z = localTypedArray.getInteger(ari.I, 15);
      A = localTypedArray.getString(ari.K);
      B = localTypedArray.getBoolean(ari.T, false);
      C = localTypedArray.getBoolean(ari.W, false);
      D = localTypedArray.getBoolean(ari.ad, false);
      F = localTypedArray.getBoolean(ari.N, false);
      G = localTypedArray.getBoolean(ari.S, false);
      H = localTypedArray.getBoolean(ari.O, false);
      if (paramContext == null) {}
    }
    catch (XmlPullParserException paramContext)
    {
      for (;;)
      {
        try
        {
          d = Class.forName(paramContext);
          if ((d != null) || (e != null) || (F)) {
            continue;
          }
          throw new IllegalStateException("No class or intent action specified in service descriptor");
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          ban localban;
          paramContext = String.valueOf(paramContext);
          if (paramContext.length() == 0) {
            continue;
          }
          paramContext = "Class not found in service descriptor: ".concat(paramContext);
          throw new IllegalStateException(paramContext);
          paramContext = new String("Class not found in service descriptor: ");
          continue;
          if ((d == null) || (e == null)) {
            continue;
          }
          throw new IllegalStateException("Both class and intent action specified in service descriptor");
          localhen.b(a, localban);
        }
        paramContext = paramContext;
        c = localhen.b();
        cvm.c(a, "Initiated Service map for: %s", new Object[] { Arrays.toString(c.keySet().toArray(new String[c.size()])) });
        paramContext = c;
        return paramContext;
      }
    }
    catch (IOException paramContext)
    {
      for (;;) {}
    }
  }
  
  public static String f(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ban localban;
    do
    {
      return null;
      Iterator localIterator = e(paramContext).values().iterator();
      paramContext = null;
      if (!localIterator.hasNext()) {
        break;
      }
      localban = (ban)localIterator.next();
      if (!TextUtils.equals(paramString, c)) {
        break label84;
      }
    } while ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.equals(paramContext, a)));
    paramContext = a;
    label84:
    for (;;)
    {
      break;
      return paramContext;
    }
  }
}

/* Location:
 * Qualified Name:     bam
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */