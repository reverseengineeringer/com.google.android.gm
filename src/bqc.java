import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;

public abstract class bqc
{
  private String a;
  public final Context f;
  public final com.android.emailcommon.provider.Account g;
  public brt h;
  public bra i;
  public int j = 200;
  
  protected bqc(Context paramContext, com.android.emailcommon.provider.Account paramAccount)
  {
    this(paramContext, paramAccount, paramAccount.d(paramContext));
  }
  
  private bqc(Context paramContext, com.android.emailcommon.provider.Account paramAccount, brt parambrt)
  {
    f = paramContext;
    g = paramAccount;
    h = parambrt;
    if (paramAccount == null) {
      throw new IllegalStateException("Null account in EasOperation");
    }
    i = new bra(paramContext, g.D);
  }
  
  protected bqc(Context paramContext, com.android.emailcommon.provider.Account paramAccount, HostAuth paramHostAuth)
  {
    this(paramContext, paramAccount, new brt(paramContext, paramAccount, paramHostAuth));
  }
  
  protected bqc(bqc parambqc)
  {
    f = f;
    g = g;
    h = h;
    i = i;
  }
  
  protected static HttpEntity a(bpi parambpi)
  {
    return new ByteArrayEntity(parambpi.c());
  }
  
  public static void a(android.accounts.Account paramAccount, long paramLong)
  {
    Bundle localBundle = Mailbox.a(paramLong);
    ContentResolver.requestSync(paramAccount, bdv.F, localBundle);
    cvm.c("Exchange", "requestSync EasOperation requestSyncForMailbox %s, %s", new Object[] { paramAccount.toString(), localBundle.toString() });
  }
  
  protected static void a(android.accounts.Account paramAccount, String paramString, ArrayList<Long> paramArrayList)
  {
    if ((paramArrayList.size() > 0) && (ContentResolver.getSyncAutomatically(paramAccount, paramString)))
    {
      paramArrayList = Mailbox.a(paramArrayList);
      ContentResolver.requestSync(paramAccount, paramString, paramArrayList);
      cvm.c("Exchange", "EasOperation requestSyncForMailboxes  %s, %s", new Object[] { paramAccount.toString(), paramArrayList.toString() });
    }
  }
  
  protected static void a(bpi parambpi, Context paramContext, String paramString)
  {
    Object localObject1 = paramContext.getPackageManager();
    Object localObject2;
    String str;
    Object localObject3;
    if ((!cuh.a()) && (((PackageManager)localObject1).checkPermission("android.permission.READ_PHONE_STATE", paramContext.getPackageName()) == 0))
    {
      localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
      bus.a("phone_device_info", "enabled");
      if (localObject2 == null) {
        break label361;
      }
      localObject1 = ((TelephonyManager)localObject2).getDeviceId();
      str = ((TelephonyManager)localObject2).getLine1Number();
      localObject3 = ((TelephonyManager)localObject2).getNetworkOperatorName();
      localObject2 = ((TelephonyManager)localObject2).getNetworkOperator();
      if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label331;
      }
      localObject3 = String.valueOf(localObject3).length() + 3 + String.valueOf(localObject2).length() + (String)localObject3 + " (" + (String)localObject2 + ")";
      localObject2 = localObject1;
      localObject1 = localObject3;
      label147:
      parambpi.a(1174).a(1160);
      parambpi.b(1175, Build.MODEL);
      if (localObject2 != null) {
        parambpi.b(1176, (String)localObject2);
      }
      paramContext = paramContext.getContentResolver().call(bdv.H, "deviceFriendlyName", null, null);
      if (paramContext != null)
      {
        paramContext = paramContext.getString("deviceFriendlyName");
        if (!TextUtils.isEmpty(paramContext)) {
          parambpi.b(1177, paramContext);
        }
      }
      paramContext = String.valueOf(Build.VERSION.RELEASE);
      if (paramContext.length() == 0) {
        break label372;
      }
    }
    label331:
    label361:
    label372:
    for (paramContext = "Android ".concat(paramContext);; paramContext = new String("Android "))
    {
      parambpi.b(1178, paramContext);
      if (str != null) {
        parambpi.b(1180, str);
      }
      parambpi.b(1184, paramString);
      if (localObject1 != null) {
        parambpi.b(1186, (String)localObject1);
      }
      parambpi.b().b();
      return;
      cvm.b("Exchange", "Not granted permission READ_PHONE_STATE", new Object[0]);
      bus.a("phone_device_info", "disabled");
      localObject2 = null;
      break;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label147;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      break label147;
      localObject1 = null;
      str = null;
      localObject2 = null;
      break label147;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt <= -100;
  }
  
  public static int b(int paramInt)
  {
    if (paramInt >= 0) {}
    for (int k = 1; k != 0; k = 0) {
      return 0;
    }
    if (a(paramInt)) {
      return 18;
    }
    switch (paramInt)
    {
    default: 
      cvm.d("Exchange", "Unexpected EAS error %d", new Object[] { Integer.valueOf(paramInt) });
      return 6;
    case -3: 
      return 10;
    case -4: 
      return 1;
    case -8: 
    case -7: 
    case -6: 
    case -5: 
      return 2;
    case -9: 
      return 5;
    case -11: 
    case -10: 
      return 11;
    case -12: 
      return 3;
    case -99: 
    case -2: 
    case -1: 
      return 18;
    }
    return 5;
  }
  
  /* Error */
  private final int j()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: ldc_w 283
    //   7: putfield 285	bqc:a	Ljava/lang/String;
    //   10: iconst_0
    //   11: istore_2
    //   12: aload_0
    //   13: getfield 40	bqc:h	Lbrt;
    //   16: aload_0
    //   17: invokevirtual 289	bqc:e	()Lorg/apache/http/client/methods/HttpUriRequest;
    //   20: aload_0
    //   21: invokevirtual 293	bqc:p	()J
    //   24: invokevirtual 296	brt:a	(Lorg/apache/http/client/methods/HttpUriRequest;J)Lbns;
    //   27: astore 7
    //   29: aload_0
    //   30: aload 7
    //   32: getfield 300	bns:b	I
    //   35: invokestatic 303	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   38: putfield 285	bqc:a	Ljava/lang/String;
    //   41: aload_0
    //   42: invokevirtual 306	bqc:m	()V
    //   45: ldc 95
    //   47: ldc_w 308
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_0
    //   57: invokevirtual 310	bqc:b	()Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 257	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   64: pop
    //   65: aload 7
    //   67: getfield 300	bns:b	I
    //   70: istore_1
    //   71: iload_1
    //   72: sipush 200
    //   75: if_icmpne +242 -> 317
    //   78: iconst_1
    //   79: istore_1
    //   80: iload_1
    //   81: ifeq +407 -> 488
    //   84: aload_0
    //   85: aload 7
    //   87: invokevirtual 313	bqc:a	(Lbns;)I
    //   90: istore_1
    //   91: iload_1
    //   92: iflt +828 -> 920
    //   95: iconst_1
    //   96: istore_3
    //   97: iload_3
    //   98: ifne +14 -> 112
    //   101: iload_1
    //   102: invokestatic 264	bqc:a	(I)Z
    //   105: istore 5
    //   107: iload 5
    //   109: ifeq +389 -> 498
    //   112: aload 7
    //   114: invokevirtual 315	bns:f	()V
    //   117: iload_1
    //   118: ireturn
    //   119: astore 6
    //   121: aload_0
    //   122: invokevirtual 306	bqc:m	()V
    //   125: aload 6
    //   127: athrow
    //   128: astore 6
    //   130: ldc 95
    //   132: aload 6
    //   134: ldc_w 317
    //   137: iconst_0
    //   138: anewarray 4	java/lang/Object
    //   141: invokestatic 320	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   144: pop
    //   145: aload_0
    //   146: getfield 36	bqc:f	Landroid/content/Context;
    //   149: ldc_w 322
    //   152: invokevirtual 158	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   155: checkcast 324	android/net/ConnectivityManager
    //   158: invokevirtual 328	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   161: astore 7
    //   163: iload 4
    //   165: istore_1
    //   166: aload 7
    //   168: ifnull +14 -> 182
    //   171: aload 7
    //   173: invokevirtual 333	android/net/NetworkInfo:isConnected	()Z
    //   176: ifne +13 -> 189
    //   179: iload 4
    //   181: istore_1
    //   182: iload_1
    //   183: ifeq +11 -> 194
    //   186: bipush -4
    //   188: ireturn
    //   189: iconst_0
    //   190: istore_1
    //   191: goto -9 -> 182
    //   194: aload_0
    //   195: getfield 40	bqc:h	Lbrt;
    //   198: invokevirtual 335	brt:d	()I
    //   201: tableswitch	default:+23->224, 1:+49->250, 2:+51->252
    //   224: aload 6
    //   226: instanceof 337
    //   229: ifeq +26 -> 255
    //   232: ldc 95
    //   234: aload 6
    //   236: ldc_w 339
    //   239: iconst_0
    //   240: anewarray 4	java/lang/Object
    //   243: invokestatic 341	cvm:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   246: pop
    //   247: bipush -12
    //   249: ireturn
    //   250: iconst_m1
    //   251: ireturn
    //   252: bipush -2
    //   254: ireturn
    //   255: bipush -4
    //   257: ireturn
    //   258: astore 6
    //   260: ldc 95
    //   262: aload 6
    //   264: ldc_w 343
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 341	cvm:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   274: pop
    //   275: bipush -8
    //   277: ireturn
    //   278: astore 6
    //   280: ldc 95
    //   282: aload 6
    //   284: ldc_w 345
    //   287: iconst_0
    //   288: anewarray 4	java/lang/Object
    //   291: invokestatic 347	cvm:b	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   294: pop
    //   295: iconst_1
    //   296: ireturn
    //   297: astore 6
    //   299: ldc 95
    //   301: aload 6
    //   303: ldc_w 345
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokestatic 349	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   313: pop
    //   314: bipush -11
    //   316: ireturn
    //   317: iconst_0
    //   318: istore_1
    //   319: goto -239 -> 80
    //   322: astore 6
    //   324: aload 6
    //   326: instanceof 337
    //   329: ifeq +29 -> 358
    //   332: ldc 95
    //   334: ldc_w 351
    //   337: iconst_1
    //   338: anewarray 4	java/lang/Object
    //   341: dup
    //   342: iconst_0
    //   343: aload 6
    //   345: aastore
    //   346: invokestatic 111	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   349: pop
    //   350: aload 7
    //   352: invokevirtual 315	bns:f	()V
    //   355: bipush -12
    //   357: ireturn
    //   358: ldc 95
    //   360: aload 6
    //   362: ldc_w 353
    //   365: iconst_0
    //   366: anewarray 4	java/lang/Object
    //   369: invokestatic 349	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   372: pop
    //   373: aload 7
    //   375: invokevirtual 315	bns:f	()V
    //   378: bipush -4
    //   380: ireturn
    //   381: astore 6
    //   383: aload 6
    //   385: getfield 355	bno:a	I
    //   388: istore_3
    //   389: ldc 95
    //   391: ldc_w 357
    //   394: iconst_2
    //   395: anewarray 4	java/lang/Object
    //   398: dup
    //   399: iconst_0
    //   400: aload_0
    //   401: invokevirtual 310	bqc:b	()Ljava/lang/String;
    //   404: aastore
    //   405: dup
    //   406: iconst_1
    //   407: iload_3
    //   408: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   411: aastore
    //   412: invokestatic 359	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   415: pop
    //   416: iload_3
    //   417: invokestatic 362	bnp:a	(I)Z
    //   420: ifeq +55 -> 475
    //   423: bipush -6
    //   425: istore_1
    //   426: invokestatic 367	buo:a	()Lbut;
    //   429: ldc_w 369
    //   432: ldc_w 371
    //   435: new 189	java/lang/StringBuilder
    //   438: dup
    //   439: bipush 23
    //   441: invokespecial 201	java/lang/StringBuilder:<init>	(I)V
    //   444: iload_3
    //   445: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: ldc_w 376
    //   451: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: iload_1
    //   455: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: lconst_0
    //   462: invokeinterface 381 6 0
    //   467: aload_0
    //   468: iload_3
    //   469: putfield 34	bqc:j	I
    //   472: goto -381 -> 91
    //   475: iload_3
    //   476: invokestatic 383	bnp:c	(I)Z
    //   479: ifeq +435 -> 914
    //   482: bipush -5
    //   484: istore_1
    //   485: goto -59 -> 426
    //   488: aload_0
    //   489: aload 7
    //   491: invokevirtual 385	bqc:b	(Lbns;)I
    //   494: istore_1
    //   495: goto -404 -> 91
    //   498: iload_1
    //   499: bipush -5
    //   501: if_icmpeq +18 -> 519
    //   504: aload 7
    //   506: invokevirtual 386	bns:a	()Z
    //   509: ifeq +31 -> 540
    //   512: aload_0
    //   513: invokevirtual 388	bqc:g	()Z
    //   516: ifeq +24 -> 540
    //   519: ldc 95
    //   521: ldc_w 390
    //   524: iconst_0
    //   525: anewarray 4	java/lang/Object
    //   528: invokestatic 359	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   531: pop
    //   532: aload 7
    //   534: invokevirtual 315	bns:f	()V
    //   537: bipush -5
    //   539: ireturn
    //   540: iload_1
    //   541: bipush -6
    //   543: if_icmpeq +25 -> 568
    //   546: aload 7
    //   548: getfield 300	bns:b	I
    //   551: sipush 449
    //   554: if_icmpeq +371 -> 925
    //   557: aload 7
    //   559: invokevirtual 386	bns:a	()Z
    //   562: ifeq +61 -> 623
    //   565: goto +360 -> 925
    //   568: aload_0
    //   569: invokevirtual 392	bqc:h	()Z
    //   572: ifeq +56 -> 628
    //   575: ldc 95
    //   577: ldc_w 394
    //   580: iconst_1
    //   581: anewarray 4	java/lang/Object
    //   584: dup
    //   585: iconst_0
    //   586: aload_0
    //   587: invokevirtual 310	bqc:b	()Ljava/lang/String;
    //   590: aastore
    //   591: invokestatic 257	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   594: pop
    //   595: aload 7
    //   597: invokevirtual 315	bns:f	()V
    //   600: iload_2
    //   601: istore_1
    //   602: iload_1
    //   603: iconst_3
    //   604: if_icmplt +305 -> 909
    //   607: ldc 95
    //   609: ldc_w 396
    //   612: iconst_0
    //   613: anewarray 4	java/lang/Object
    //   616: invokestatic 359	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   619: pop
    //   620: bipush -3
    //   622: ireturn
    //   623: iconst_0
    //   624: istore_3
    //   625: goto +302 -> 927
    //   628: aload 7
    //   630: invokevirtual 315	bns:f	()V
    //   633: bipush -6
    //   635: ireturn
    //   636: aload 7
    //   638: invokevirtual 398	bns:b	()Z
    //   641: ifeq +44 -> 685
    //   644: ldc 95
    //   646: ldc_w 400
    //   649: iconst_0
    //   650: anewarray 4	java/lang/Object
    //   653: invokestatic 359	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   656: pop
    //   657: aload 7
    //   659: getfield 403	bns:c	Z
    //   662: istore 5
    //   664: iload 5
    //   666: ifeq +11 -> 677
    //   669: aload 7
    //   671: invokevirtual 315	bns:f	()V
    //   674: bipush -8
    //   676: ireturn
    //   677: aload 7
    //   679: invokevirtual 315	bns:f	()V
    //   682: bipush -7
    //   684: ireturn
    //   685: aload 7
    //   687: getfield 300	bns:b	I
    //   690: sipush 451
    //   693: if_icmpne +131 -> 824
    //   696: iconst_1
    //   697: istore_3
    //   698: iload_3
    //   699: ifeq +136 -> 835
    //   702: iload_2
    //   703: iconst_1
    //   704: iadd
    //   705: istore_1
    //   706: aload_0
    //   707: getfield 40	bqc:h	Lbrt;
    //   710: astore 8
    //   712: aload 7
    //   714: ldc_w 405
    //   717: invokevirtual 408	bns:a	(Ljava/lang/String;)Lorg/apache/http/Header;
    //   720: astore 6
    //   722: aload 6
    //   724: ifnull +105 -> 829
    //   727: aload 6
    //   729: invokeinterface 413 1 0
    //   734: invokestatic 419	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   737: invokevirtual 422	android/net/Uri:getHost	()Ljava/lang/String;
    //   740: astore 6
    //   742: aload 8
    //   744: aconst_null
    //   745: putfield 425	brt:g	Lorg/apache/http/client/HttpClient;
    //   748: aload 8
    //   750: getfield 428	brt:c	Lcom/android/emailcommon/provider/HostAuth;
    //   753: aload 6
    //   755: putfield 432	com/android/emailcommon/provider/HostAuth:c	Ljava/lang/String;
    //   758: aload 8
    //   760: getfield 428	brt:c	Lcom/android/emailcommon/provider/HostAuth;
    //   763: invokevirtual 433	com/android/emailcommon/provider/HostAuth:h	()Z
    //   766: ifeq +50 -> 816
    //   769: invokestatic 438	bpm:a	()Lbpm;
    //   772: aload 8
    //   774: getfield 428	brt:c	Lcom/android/emailcommon/provider/HostAuth;
    //   777: invokevirtual 441	bpm:a	(Lcom/android/emailcommon/provider/HostAuth;)V
    //   780: new 443	android/content/ContentValues
    //   783: dup
    //   784: iconst_1
    //   785: invokespecial 444	android/content/ContentValues:<init>	(I)V
    //   788: astore 9
    //   790: aload 9
    //   792: ldc_w 446
    //   795: aload 6
    //   797: invokevirtual 449	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   800: aload 8
    //   802: getfield 428	brt:c	Lcom/android/emailcommon/provider/HostAuth;
    //   805: aload 8
    //   807: getfield 451	brt:b	Landroid/content/Context;
    //   810: aload 9
    //   812: invokevirtual 454	com/android/emailcommon/provider/HostAuth:a	(Landroid/content/Context;Landroid/content/ContentValues;)I
    //   815: pop
    //   816: aload 7
    //   818: invokevirtual 315	bns:f	()V
    //   821: goto -219 -> 602
    //   824: iconst_0
    //   825: istore_3
    //   826: goto -128 -> 698
    //   829: aconst_null
    //   830: astore 6
    //   832: goto -90 -> 742
    //   835: ldc 95
    //   837: ldc_w 456
    //   840: iconst_3
    //   841: anewarray 4	java/lang/Object
    //   844: dup
    //   845: iconst_0
    //   846: aload_0
    //   847: invokevirtual 310	bqc:b	()Ljava/lang/String;
    //   850: aastore
    //   851: dup
    //   852: iconst_1
    //   853: aload 7
    //   855: getfield 300	bns:b	I
    //   858: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   861: aastore
    //   862: dup
    //   863: iconst_2
    //   864: iload_1
    //   865: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: aastore
    //   869: invokestatic 359	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   872: pop
    //   873: iload_1
    //   874: invokestatic 264	bqc:a	(I)Z
    //   877: istore 5
    //   879: iload 5
    //   881: ifeq +10 -> 891
    //   884: aload 7
    //   886: invokevirtual 315	bns:f	()V
    //   889: iload_1
    //   890: ireturn
    //   891: aload 7
    //   893: invokevirtual 315	bns:f	()V
    //   896: bipush -99
    //   898: ireturn
    //   899: astore 6
    //   901: aload 7
    //   903: invokevirtual 315	bns:f	()V
    //   906: aload 6
    //   908: athrow
    //   909: iload_1
    //   910: istore_2
    //   911: goto -899 -> 12
    //   914: bipush -99
    //   916: istore_1
    //   917: goto -491 -> 426
    //   920: iconst_0
    //   921: istore_3
    //   922: goto -825 -> 97
    //   925: iconst_1
    //   926: istore_3
    //   927: iload_3
    //   928: ifeq -292 -> 636
    //   931: goto -363 -> 568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	934	0	this	bqc
    //   70	847	1	k	int
    //   11	900	2	m	int
    //   96	832	3	n	int
    //   1	179	4	i1	int
    //   105	775	5	bool	boolean
    //   119	7	6	localObject1	Object
    //   128	107	6	localIOException1	java.io.IOException
    //   258	5	6	localCertificateException	java.security.cert.CertificateException
    //   278	5	6	localbqd	bqd
    //   297	5	6	localIllegalStateException	IllegalStateException
    //   322	39	6	localIOException2	java.io.IOException
    //   381	3	6	localbno	bno
    //   720	111	6	localObject2	Object
    //   899	8	6	localObject3	Object
    //   27	875	7	localObject4	Object
    //   710	96	8	localbrt	brt
    //   788	23	9	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   12	41	119	finally
    //   41	45	128	java/io/IOException
    //   121	128	128	java/io/IOException
    //   41	45	258	java/security/cert/CertificateException
    //   121	128	258	java/security/cert/CertificateException
    //   41	45	278	bqd
    //   121	128	278	bqd
    //   41	45	297	java/lang/IllegalStateException
    //   121	128	297	java/lang/IllegalStateException
    //   84	91	322	java/io/IOException
    //   84	91	381	bno
    //   65	71	899	finally
    //   84	91	899	finally
    //   101	107	899	finally
    //   324	350	899	finally
    //   358	373	899	finally
    //   383	423	899	finally
    //   426	472	899	finally
    //   475	482	899	finally
    //   488	495	899	finally
    //   504	519	899	finally
    //   519	532	899	finally
    //   546	565	899	finally
    //   568	595	899	finally
    //   636	664	899	finally
    //   685	696	899	finally
    //   706	722	899	finally
    //   727	742	899	finally
    //   742	816	899	finally
    //   835	879	899	finally
  }
  
  protected abstract int a(bns parambns);
  
  protected String a()
  {
    Object localObject = h;
    String str3 = b();
    String str2 = ((brt)localObject).b();
    String str1 = str2;
    if (str3 != null)
    {
      str1 = String.valueOf(str2);
      if (brt.a == null)
      {
        brt.a = new ben(b).a();
        if (brt.a == null)
        {
          cvm.e("Exchange", "Could not get device id, defaulting to '0'", new Object[0]);
          brt.a = "0";
        }
      }
      str2 = String.valueOf(Uri.encode(c.f));
      localObject = brt.a;
      String str4 = String.valueOf("Android");
      str2 = String.valueOf(String.valueOf(str2).length() + 28 + String.valueOf(localObject).length() + String.valueOf(str4).length() + "&User=" + str2 + "&DeviceId=" + (String)localObject + "&DeviceType=" + str4);
      str1 = String.valueOf(str1).length() + 5 + String.valueOf(str3).length() + String.valueOf(str2).length() + str1 + "?Cmd=" + str3 + str2;
    }
    return str1;
  }
  
  protected int b(bns parambns)
  {
    switch (b)
    {
    default: 
      return -99;
    case 401: 
      bpm.a().b();
      return -7;
    }
    return -13;
  }
  
  protected abstract String b();
  
  protected abstract HttpEntity c();
  
  protected final void c(String paramString)
  {
    long l = g.D;
    if ((h.a(paramString)) && (l != -1L))
    {
      Uri localUri = ContentUris.withAppendedId(com.android.emailcommon.provider.Account.a, l);
      ContentValues localContentValues = new ContentValues(2);
      double d = h.e;
      if (d >= 12.0D)
      {
        int n = bhn.a(f, localUri, com.android.emailcommon.provider.Account.z, 1, Integer.valueOf(0)).intValue();
        int m = n | 0x1000 | 0x800 | 0x80;
        int k = m;
        if (d >= 16.0D) {
          k = m | 0x8000;
        }
        if (n != k) {
          localContentValues.put("flags", Integer.valueOf(k));
        }
      }
      localContentValues.put("protocolVersion", paramString);
      f.getContentResolver().update(localUri, localContentValues, null, null);
      i.a.edit().putBoolean("IsOptionsNeeded", false).apply();
    }
  }
  
  protected String d()
  {
    return "application/vnd.ms-sync.wbxml";
  }
  
  protected HttpUriRequest e()
  {
    String str = a();
    return h.a(str, c(), d(), o());
  }
  
  protected boolean g()
  {
    return false;
  }
  
  protected boolean h()
  {
    Object localObject = new bqj(this);
    int k = ((bqj)localObject).j();
    long l = g.D;
    if (k < 0)
    {
      cvm.d("Exchange", "EasProvision can't perform initial request: %d", new Object[] { Integer.valueOf(k) });
      return false;
    }
    if (k == 3)
    {
      c = 2;
      ((bqj)localObject).p_();
      cvm.c("Exchange", "EasProvision is executing remote wipe", new Object[0]);
      localObject = f;
      try
      {
        new bfh((Context)localObject).a();
        return false;
      }
      catch (RemoteException localRemoteException)
      {
        throw new IllegalStateException("PolicyService transaction failed");
      }
    }
    if (a != null) {
      a.w = null;
    }
    bfh.a(f, l, a, null);
    if (!bfh.a(f, a))
    {
      cvm.d("Exchange", "EasProvision can't find active policy", new Object[0]);
      return false;
    }
    if (k == 2) {}
    for (boolean bool = true; localRemoteException.a(bool) == 2; bool = false)
    {
      cvm.d("Exchange", "EasProvision can't perform ACK request due to unsupported policy", new Object[0]);
      return false;
    }
    bfh.a(f, l, a, b);
    double d = h.e;
    if ((d == 12.1D) || (d == 14.0D)) {
      new bqr(localRemoteException).p_();
    }
    return true;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public boolean k()
  {
    return true;
  }
  
  public final void l()
  {
    h.a(1);
  }
  
  protected void m() {}
  
  protected void n() {}
  
  protected boolean o()
  {
    return true;
  }
  
  protected long p()
  {
    return 30000L;
  }
  
  /* Error */
  public int p_()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 628	bqc:k	()Z
    //   4: ifne +39 -> 43
    //   7: ldc 95
    //   9: ldc_w 630
    //   12: iconst_2
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload_0
    //   19: getfield 38	bqc:g	Lcom/android/emailcommon/provider/Account;
    //   22: getfield 53	com/android/emailcommon/provider/Account:D	J
    //   25: invokestatic 635	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: aload_0
    //   32: invokevirtual 310	bqc:b	()Ljava/lang/String;
    //   35: aastore
    //   36: invokestatic 111	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   39: pop
    //   40: bipush -10
    //   42: ireturn
    //   43: aload_0
    //   44: invokespecial 636	bqc:j	()I
    //   47: istore_2
    //   48: invokestatic 367	buo:a	()Lbut;
    //   51: astore_3
    //   52: aload_0
    //   53: invokevirtual 640	java/lang/Object:getClass	()Ljava/lang/Class;
    //   56: invokevirtual 645	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   59: astore 4
    //   61: aload_0
    //   62: getfield 285	bqc:a	Ljava/lang/String;
    //   65: astore 5
    //   67: aload_3
    //   68: ldc_w 369
    //   71: aload 4
    //   73: new 189	java/lang/StringBuilder
    //   76: dup
    //   77: aload 5
    //   79: invokestatic 195	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 198	java/lang/String:length	()I
    //   85: bipush 12
    //   87: iadd
    //   88: invokespecial 201	java/lang/StringBuilder:<init>	(I)V
    //   91: aload 5
    //   93: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc_w 376
    //   99: invokevirtual 205	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_2
    //   103: invokevirtual 374	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   106: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: lconst_0
    //   110: invokeinterface 381 6 0
    //   115: iload_2
    //   116: ifge +35 -> 151
    //   119: iconst_1
    //   120: istore_1
    //   121: iload_1
    //   122: ifeq +23 -> 145
    //   125: ldc 95
    //   127: ldc_w 647
    //   130: iconst_1
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: iload_2
    //   137: invokestatic 271	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   140: aastore
    //   141: invokestatic 273	cvm:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   144: pop
    //   145: aload_0
    //   146: invokevirtual 649	bqc:n	()V
    //   149: iload_2
    //   150: ireturn
    //   151: iconst_0
    //   152: istore_1
    //   153: goto -32 -> 121
    //   156: astore_3
    //   157: aload_0
    //   158: invokevirtual 649	bqc:n	()V
    //   161: aload_3
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	bqc
    //   120	33	1	k	int
    //   47	103	2	m	int
    //   51	17	3	localbut	but
    //   156	6	3	localObject	Object
    //   59	13	4	str1	String
    //   65	27	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   43	115	156	finally
    //   125	145	156	finally
  }
}

/* Location:
 * Qualified Name:     bqc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */