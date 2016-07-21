import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import com.android.mail.providers.Account;
import com.android.mail.ui.MailActivity;
import com.google.android.gm.preference.GmailPreferenceActivity;
import com.google.android.gm.ui.MailActivityGmail;
import java.util.Random;

public class dev
  extends Application
  implements btr, gon, goo
{
  static final Random a = new Random();
  public static boolean b;
  public static boolean c;
  public static Class<avj> d;
  private static final gmn g = new gmn();
  private static final long h = SystemClock.elapsedRealtime();
  public dmo e;
  public dmr f;
  
  static
  {
    b = true;
    c = false;
    cvl.a = "Gmail";
    cqs.a = "gmail-ls";
    cfo.a = new dew();
    byj.a = new dex();
    bvk.a(new dii());
    com.android.mail.ui.settings.PublicPreferenceActivity.a = GmailPreferenceActivity.class;
  }
  
  public static dev a(Activity paramActivity)
  {
    return (dev)paramActivity.getApplication();
  }
  
  public final cuo a()
  {
    return new dyv();
  }
  
  public final boolean a(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramContext instanceof MailActivityGmail))
    {
      paramContext = (MailActivityGmail)paramContext;
      localObject1 = localObject2;
      if (cxf.a(paramContext)) {
        localObject1 = l.a().c;
      }
    }
    f.a(false, (String)localObject1);
    return true;
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
  }
  
  public final String b()
  {
    return dev.class.getCanonicalName();
  }
  
  public final boolean b(Context paramContext)
  {
    String str = null;
    if ((paramContext instanceof MailActivityGmail)) {
      str = cxf.a();
    }
    f.a(true, str);
    return true;
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 154	android/app/Application:onCreate	()V
    //   4: aload_0
    //   5: invokevirtual 158	dev:getContentResolver	()Landroid/content/ContentResolver;
    //   8: ldc -96
    //   10: iconst_0
    //   11: invokestatic 165	ghz:a	(Landroid/content/ContentResolver;Ljava/lang/String;Z)Z
    //   14: istore_3
    //   15: ldc 54
    //   17: ldc -89
    //   19: iconst_1
    //   20: anewarray 169	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: iload_3
    //   26: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   29: aastore
    //   30: invokestatic 180	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   33: pop
    //   34: ldc 54
    //   36: ldc -74
    //   38: iconst_1
    //   39: anewarray 169	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: iconst_0
    //   45: invokestatic 175	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   48: aastore
    //   49: invokestatic 180	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   52: pop
    //   53: iload_3
    //   54: ifeq +205 -> 259
    //   57: new 184	glp
    //   60: dup
    //   61: invokespecial 185	glp:<init>	()V
    //   64: astore 5
    //   66: iload_3
    //   67: ifeq +15 -> 82
    //   70: aload 5
    //   72: new 187	dfb
    //   75: dup
    //   76: invokespecial 188	dfb:<init>	()V
    //   79: putfield 191	glp:a	Lglx;
    //   82: new 193	dfc
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 196	dfc:<init>	(Landroid/app/Application;)V
    //   90: astore 4
    //   92: aload 5
    //   94: getfield 191	glp:a	Lglx;
    //   97: ifnonnull +11 -> 108
    //   100: aload 5
    //   102: getstatic 199	glx:a	Lglx;
    //   105: putfield 191	glp:a	Lglx;
    //   108: aload 5
    //   110: getfield 202	glp:b	Lgmh;
    //   113: ifnonnull +11 -> 124
    //   116: aload 5
    //   118: getstatic 206	gmh:a	Lgmh;
    //   121: putfield 202	glp:b	Lgmh;
    //   124: aload 5
    //   126: getfield 209	glp:c	Lglq;
    //   129: ifnonnull +11 -> 140
    //   132: aload 5
    //   134: getstatic 213	glq:a	Lglq;
    //   137: putfield 209	glp:c	Lglq;
    //   140: aload 5
    //   142: getfield 216	glp:d	Lgly;
    //   145: ifnonnull +11 -> 156
    //   148: aload 5
    //   150: getstatic 220	gly:a	Lgly;
    //   153: putfield 216	glp:d	Lgly;
    //   156: aload 5
    //   158: getfield 223	glp:e	Lglz;
    //   161: ifnonnull +11 -> 172
    //   164: aload 5
    //   166: getstatic 227	glz:a	Lglz;
    //   169: putfield 223	glp:e	Lglz;
    //   172: aload 5
    //   174: getfield 230	glp:f	Lglw;
    //   177: ifnonnull +11 -> 188
    //   180: aload 5
    //   182: getstatic 234	glw:a	Lglw;
    //   185: putfield 230	glp:f	Lglw;
    //   188: new 236	glo
    //   191: dup
    //   192: aload 5
    //   194: getfield 191	glp:a	Lglx;
    //   197: aload 5
    //   199: getfield 202	glp:b	Lgmh;
    //   202: aload 5
    //   204: getfield 209	glp:c	Lglq;
    //   207: aload 5
    //   209: getfield 216	glp:d	Lgly;
    //   212: aload 5
    //   214: getfield 223	glp:e	Lglz;
    //   217: aload 5
    //   219: getfield 230	glp:f	Lglw;
    //   222: invokespecial 239	glo:<init>	(Lglx;Lgmh;Lglq;Lgly;Lglz;Lglw;)V
    //   225: astore 5
    //   227: aload 4
    //   229: invokestatic 244	gol:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   232: pop
    //   233: new 246	gln
    //   236: dup
    //   237: aload_0
    //   238: aload 4
    //   240: aload 5
    //   242: invokespecial 249	gln:<init>	(Landroid/app/Application;Lgna;Lglo;)V
    //   245: invokestatic 254	glh:a	(Lgjq;)Lglh;
    //   248: pop
    //   249: iload_3
    //   250: ifeq +9 -> 259
    //   253: getstatic 257	glh:a	Lglh;
    //   256: invokevirtual 259	glh:a	()V
    //   259: aload_0
    //   260: ldc_w 261
    //   263: invokevirtual 264	java/lang/Class:getName	()Ljava/lang/String;
    //   266: invokestatic 269	cuh:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   269: aload_0
    //   270: invokevirtual 158	dev:getContentResolver	()Landroid/content/ContentResolver;
    //   273: ldc_w 271
    //   276: ldc_w 273
    //   279: invokestatic 276	ghz:a	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   282: invokestatic 282	java/lang/Double:parseDouble	(Ljava/lang/String;)D
    //   285: dstore_1
    //   286: invokestatic 287	buo:b	()Z
    //   289: ifeq +52 -> 341
    //   292: new 289	dfj
    //   295: dup
    //   296: invokespecial 290	dfj:<init>	()V
    //   299: astore 4
    //   301: ldc_w 284
    //   304: monitorenter
    //   305: aload 4
    //   307: putstatic 293	buo:a	Lbut;
    //   310: ldc_w 284
    //   313: monitorexit
    //   314: invokestatic 296	buo:a	()Lbut;
    //   317: checkcast 289	dfj
    //   320: aload_0
    //   321: invokevirtual 302	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   324: putfield 305	dfj:a	Landroid/content/Context;
    //   327: invokestatic 310	czn:a	()Lczn;
    //   330: aload_0
    //   331: invokevirtual 312	czn:a	(Landroid/content/Context;)V
    //   334: invokestatic 315	czn:b	()Ldbm;
    //   337: dload_1
    //   338: invokevirtual 320	dbm:a	(D)V
    //   341: invokestatic 325	dmv:a	()Ldmv;
    //   344: pop
    //   345: aload_0
    //   346: invokestatic 327	dmv:b	()Ljava/lang/String;
    //   349: iconst_0
    //   350: getstatic 332	dgh:a	I
    //   353: iconst_0
    //   354: invokestatic 338	android/preference/PreferenceManager:setDefaultValues	(Landroid/content/Context;Ljava/lang/String;IIZ)V
    //   357: invokestatic 325	dmv:a	()Ldmv;
    //   360: pop
    //   361: aload_0
    //   362: invokestatic 327	dmv:b	()Ljava/lang/String;
    //   365: iconst_0
    //   366: getstatic 340	dgh:c	I
    //   369: iconst_0
    //   370: invokestatic 338	android/preference/PreferenceManager:setDefaultValues	(Landroid/content/Context;Ljava/lang/String;IIZ)V
    //   373: invokestatic 325	dmv:a	()Ldmv;
    //   376: pop
    //   377: aload_0
    //   378: invokestatic 327	dmv:b	()Ljava/lang/String;
    //   381: iconst_0
    //   382: getstatic 342	dgh:d	I
    //   385: iconst_0
    //   386: invokestatic 338	android/preference/PreferenceManager:setDefaultValues	(Landroid/content/Context;Ljava/lang/String;IIZ)V
    //   389: new 344	dey
    //   392: dup
    //   393: aload_0
    //   394: invokespecial 347	dey:<init>	(Ldev;)V
    //   397: astore 4
    //   399: new 349	god
    //   402: dup
    //   403: invokespecial 350	god:<init>	()V
    //   406: astore 5
    //   408: new 352	gof
    //   411: dup
    //   412: aload_0
    //   413: invokestatic 358	java/lang/Thread:getDefaultUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   416: aload 5
    //   418: getfield 361	god:a	Ljava/util/concurrent/atomic/AtomicReference;
    //   421: aload 4
    //   423: invokespecial 364	gof:<init>	(Landroid/content/Context;Ljava/lang/Thread$UncaughtExceptionHandler;Ljava/util/concurrent/atomic/AtomicReference;Lgoh;)V
    //   426: invokestatic 368	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   429: new 370	gog
    //   432: dup
    //   433: aload_0
    //   434: invokestatic 374	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   437: invokevirtual 377	java/lang/Thread:getUncaughtExceptionHandler	()Ljava/lang/Thread$UncaughtExceptionHandler;
    //   440: aload 5
    //   442: getfield 361	god:a	Ljava/util/concurrent/atomic/AtomicReference;
    //   445: aload 4
    //   447: invokespecial 378	gog:<init>	(Landroid/content/Context;Ljava/lang/Thread$UncaughtExceptionHandler;Ljava/util/concurrent/atomic/AtomicReference;Lgoh;)V
    //   450: astore 4
    //   452: invokestatic 374	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   455: aload 4
    //   457: invokevirtual 381	java/lang/Thread:setUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   460: new 383	java/io/File
    //   463: dup
    //   464: aload_0
    //   465: invokevirtual 387	dev:getCacheDir	()Ljava/io/File;
    //   468: ldc_w 389
    //   471: invokespecial 392	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   474: ldc2_w 393
    //   477: invokestatic 400	android/net/http/HttpResponseCache:install	(Ljava/io/File;J)Landroid/net/http/HttpResponseCache;
    //   480: pop
    //   481: aload_0
    //   482: invokestatic 405	cfm:a	(Landroid/content/Context;)Lcfm;
    //   485: astore 4
    //   487: aload_0
    //   488: invokevirtual 158	dev:getContentResolver	()Landroid/content/ContentResolver;
    //   491: ldc_w 407
    //   494: ldc_w 409
    //   497: invokestatic 276	ghz:a	(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   500: ldc_w 409
    //   503: invokevirtual 415	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   506: ifne +22 -> 528
    //   509: aload 4
    //   511: getfield 420	cfr:e	Landroid/content/SharedPreferences$Editor;
    //   514: ldc_w 422
    //   517: iconst_1
    //   518: invokeinterface 428 3 0
    //   523: invokeinterface 431 1 0
    //   528: invokestatic 436	dwf:a	()Ldwf;
    //   531: astore 4
    //   533: aload 4
    //   535: ifnull +12 -> 547
    //   538: aload_0
    //   539: aload 4
    //   541: getfield 439	dwf:a	Landroid/app/Application$ActivityLifecycleCallbacks;
    //   544: invokevirtual 443	dev:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   547: aload_0
    //   548: new 445	dmo
    //   551: dup
    //   552: aload_0
    //   553: invokespecial 447	dmo:<init>	(Landroid/content/Context;)V
    //   556: putfield 449	dev:e	Ldmo;
    //   559: aload_0
    //   560: new 134	dmr
    //   563: dup
    //   564: aload_0
    //   565: getfield 449	dev:e	Ldmo;
    //   568: invokespecial 452	dmr:<init>	(Ldmo;)V
    //   571: putfield 132	dev:f	Ldmr;
    //   574: new 454	gop
    //   577: dup
    //   578: aload_0
    //   579: new 456	dfa
    //   582: dup
    //   583: aload_0
    //   584: invokespecial 457	dfa:<init>	(Ldev;)V
    //   587: new 459	dez
    //   590: dup
    //   591: aload_0
    //   592: invokespecial 460	dez:<init>	(Ldev;)V
    //   595: invokespecial 463	gop:<init>	(Landroid/app/Application;Lhqj;Lhqj;)V
    //   598: astore 4
    //   600: aload 4
    //   602: getfield 466	gop:a	Landroid/app/Application;
    //   605: aload 4
    //   607: invokevirtual 469	android/app/Application:unregisterActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   610: aload 4
    //   612: getfield 466	gop:a	Landroid/app/Application;
    //   615: aload 4
    //   617: invokevirtual 470	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   620: invokestatic 296	buo:a	()Lbut;
    //   623: ldc_w 472
    //   626: invokestatic 46	android/os/SystemClock:elapsedRealtime	()J
    //   629: getstatic 48	dev:h	J
    //   632: lsub
    //   633: ldc_w 474
    //   636: aconst_null
    //   637: invokeinterface 479 6 0
    //   642: getstatic 257	glh:a	Lglh;
    //   645: getstatic 40	dev:g	Lgmn;
    //   648: ldc_w 481
    //   651: invokevirtual 484	glh:a	(Lgmn;Ljava/lang/String;)V
    //   654: return
    //   655: astore 4
    //   657: ldc_w 284
    //   660: monitorexit
    //   661: aload 4
    //   663: athrow
    //   664: astore 4
    //   666: ldc 54
    //   668: aload 4
    //   670: ldc_w 486
    //   673: iconst_0
    //   674: anewarray 169	java/lang/Object
    //   677: invokestatic 489	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   680: pop
    //   681: goto -200 -> 481
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	684	0	this	dev
    //   285	53	1	d1	double
    //   14	236	3	bool	boolean
    //   90	526	4	localObject1	Object
    //   655	7	4	localObject2	Object
    //   664	5	4	localIOException	java.io.IOException
    //   64	377	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   305	314	655	finally
    //   657	661	655	finally
    //   460	481	664	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     dev
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */