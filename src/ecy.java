import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;

public final class ecy
{
  public static final String a;
  public static final String b = "androidPackageName";
  private static final ComponentName c = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
  private static final ComponentName d = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    a = "callerUid";
    i = Build.VERSION.SDK_INT;
  }
  
  /* Error */
  private static Bundle a(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 54	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 6
    //   6: ldc 56
    //   8: invokestatic 61	enz:c	(Ljava/lang/String;)V
    //   11: aload 6
    //   13: invokestatic 64	ecy:a	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +139 -> 156
    //   20: new 66	android/os/Bundle
    //   23: dup
    //   24: invokespecial 68	android/os/Bundle:<init>	()V
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 72	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   32: getfield 77	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   35: astore_0
    //   36: aload_3
    //   37: ldc 79
    //   39: aload_0
    //   40: invokevirtual 82	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_3
    //   44: getstatic 26	ecy:b	Ljava/lang/String;
    //   47: invokevirtual 86	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +11 -> 64
    //   56: aload_3
    //   57: getstatic 26	ecy:b	Ljava/lang/String;
    //   60: aload_0
    //   61: invokevirtual 82	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: new 94	eph
    //   67: dup
    //   68: invokespecial 95	eph:<init>	()V
    //   71: astore_0
    //   72: aload 6
    //   74: invokestatic 100	end:a	(Landroid/content/Context;)Lend;
    //   77: astore 6
    //   79: aload 6
    //   81: getstatic 38	ecy:c	Landroid/content/ComponentName;
    //   84: aload_0
    //   85: ldc 102
    //   87: invokevirtual 105	end:a	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   90: ifeq +366 -> 456
    //   93: aload_0
    //   94: invokevirtual 108	eph:a	()Landroid/os/IBinder;
    //   97: invokestatic 113	fnb:a	(Landroid/os/IBinder;)Lfna;
    //   100: aload_1
    //   101: aload_2
    //   102: aload_3
    //   103: invokeinterface 118 4 0
    //   108: astore_2
    //   109: aload_2
    //   110: ifnonnull +58 -> 168
    //   113: ldc 102
    //   115: ldc 120
    //   117: invokestatic 126	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   120: pop
    //   121: new 128	ecx
    //   124: dup
    //   125: ldc -126
    //   127: invokespecial 132	ecx:<init>	(Ljava/lang/String;)V
    //   130: athrow
    //   131: astore_1
    //   132: new 134	java/io/IOException
    //   135: dup
    //   136: ldc -120
    //   138: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   141: athrow
    //   142: astore_1
    //   143: aload 6
    //   145: getstatic 38	ecy:c	Landroid/content/ComponentName;
    //   148: aload_0
    //   149: ldc 102
    //   151: invokevirtual 140	end:b	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   154: aload_1
    //   155: athrow
    //   156: new 66	android/os/Bundle
    //   159: dup
    //   160: aload_3
    //   161: invokespecial 143	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   164: astore_3
    //   165: goto -137 -> 28
    //   168: aload_2
    //   169: ldc -111
    //   171: invokevirtual 86	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   174: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   177: istore 5
    //   179: iload 5
    //   181: ifne +16 -> 197
    //   184: aload 6
    //   186: getstatic 38	ecy:c	Landroid/content/ComponentName;
    //   189: aload_0
    //   190: ldc 102
    //   192: invokevirtual 140	end:b	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   195: aload_2
    //   196: areturn
    //   197: aload_2
    //   198: ldc -109
    //   200: invokevirtual 86	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   203: astore_1
    //   204: aload_2
    //   205: ldc -107
    //   207: invokevirtual 153	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   210: checkcast 155	android/content/Intent
    //   213: astore_2
    //   214: ldc -99
    //   216: aload_1
    //   217: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   220: ifne +246 -> 466
    //   223: ldc -91
    //   225: aload_1
    //   226: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifne +237 -> 466
    //   232: ldc -89
    //   234: aload_1
    //   235: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifne +228 -> 466
    //   241: ldc -87
    //   243: aload_1
    //   244: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifne +219 -> 466
    //   250: ldc -85
    //   252: aload_1
    //   253: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   256: ifne +210 -> 466
    //   259: ldc -83
    //   261: aload_1
    //   262: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   265: ifne +201 -> 466
    //   268: ldc -81
    //   270: aload_1
    //   271: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   274: ifne +192 -> 466
    //   277: getstatic 181	ego:u	Lego;
    //   280: getfield 184	ego:W	Ljava/lang/String;
    //   283: aload_1
    //   284: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifne +179 -> 466
    //   290: getstatic 187	ego:v	Lego;
    //   293: getfield 184	ego:W	Ljava/lang/String;
    //   296: aload_1
    //   297: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   300: ifne +166 -> 466
    //   303: getstatic 189	ego:w	Lego;
    //   306: getfield 184	ego:W	Ljava/lang/String;
    //   309: aload_1
    //   310: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   313: ifne +153 -> 466
    //   316: getstatic 192	ego:x	Lego;
    //   319: getfield 184	ego:W	Ljava/lang/String;
    //   322: aload_1
    //   323: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifne +140 -> 466
    //   329: getstatic 195	ego:y	Lego;
    //   332: getfield 184	ego:W	Ljava/lang/String;
    //   335: aload_1
    //   336: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: ifne +127 -> 466
    //   342: getstatic 198	ego:z	Lego;
    //   345: getfield 184	ego:W	Ljava/lang/String;
    //   348: aload_1
    //   349: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   352: ifne +114 -> 466
    //   355: getstatic 201	ego:s	Lego;
    //   358: getfield 184	ego:W	Ljava/lang/String;
    //   361: aload_1
    //   362: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   365: ifeq +32 -> 397
    //   368: goto +98 -> 466
    //   371: iload 4
    //   373: ifeq +30 -> 403
    //   376: new 203	ede
    //   379: dup
    //   380: aload_1
    //   381: aload_2
    //   382: invokespecial 206	ede:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   385: athrow
    //   386: astore_1
    //   387: new 128	ecx
    //   390: dup
    //   391: ldc -48
    //   393: invokespecial 132	ecx:<init>	(Ljava/lang/String;)V
    //   396: athrow
    //   397: iconst_0
    //   398: istore 4
    //   400: goto -29 -> 371
    //   403: ldc -46
    //   405: aload_1
    //   406: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   409: ifne +63 -> 472
    //   412: ldc -126
    //   414: aload_1
    //   415: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   418: ifne +54 -> 472
    //   421: ldc -44
    //   423: aload_1
    //   424: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   427: ifeq +51 -> 478
    //   430: goto +42 -> 472
    //   433: iload 4
    //   435: ifeq +12 -> 447
    //   438: new 134	java/io/IOException
    //   441: dup
    //   442: aload_1
    //   443: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   446: athrow
    //   447: new 128	ecx
    //   450: dup
    //   451: aload_1
    //   452: invokespecial 132	ecx:<init>	(Ljava/lang/String;)V
    //   455: athrow
    //   456: new 134	java/io/IOException
    //   459: dup
    //   460: ldc -42
    //   462: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   465: athrow
    //   466: iconst_1
    //   467: istore 4
    //   469: goto -98 -> 371
    //   472: iconst_1
    //   473: istore 4
    //   475: goto -42 -> 433
    //   478: iconst_0
    //   479: istore 4
    //   481: goto -48 -> 433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	paramContext	Context
    //   0	484	1	paramAccount	Account
    //   0	484	2	paramString	String
    //   0	484	3	paramBundle	Bundle
    //   371	109	4	i	int
    //   177	3	5	bool	boolean
    //   4	181	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   93	109	131	android/os/RemoteException
    //   113	131	131	android/os/RemoteException
    //   168	179	131	android/os/RemoteException
    //   197	368	131	android/os/RemoteException
    //   376	386	131	android/os/RemoteException
    //   403	430	131	android/os/RemoteException
    //   438	447	131	android/os/RemoteException
    //   447	456	131	android/os/RemoteException
    //   93	109	142	finally
    //   113	131	142	finally
    //   132	142	142	finally
    //   168	179	142	finally
    //   197	368	142	finally
    //   376	386	142	finally
    //   387	397	142	finally
    //   403	430	142	finally
    //   438	447	142	finally
    //   447	456	142	finally
    //   93	109	386	java/lang/InterruptedException
    //   113	131	386	java/lang/InterruptedException
    //   168	179	386	java/lang/InterruptedException
    //   197	368	386	java/lang/InterruptedException
    //   376	386	386	java/lang/InterruptedException
    //   403	430	386	java/lang/InterruptedException
    //   438	447	386	java/lang/InterruptedException
    //   447	456	386	java/lang/InterruptedException
  }
  
  @Deprecated
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, new Account(paramString1, "com.google"), paramString2, new Bundle()).getString("authtoken");
  }
  
  @Deprecated
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Account(paramString1, "com.google");
    if (TextUtils.isEmpty(paramString3)) {
      throw new IllegalArgumentException("Authority cannot be empty or null.");
    }
    Bundle localBundle1 = new Bundle();
    Bundle localBundle2 = new Bundle();
    ContentResolver.validateSyncExtrasBundle(localBundle2);
    localBundle1.putString("authority", paramString3);
    localBundle1.putBundle("sync_extras", localBundle2);
    localBundle1.putBoolean("handle_notification", true);
    return b(paramContext, paramString1, paramString2, localBundle1).getString("authtoken");
  }
  
  private static void a(Context paramContext)
  {
    try
    {
      eik.b(paramContext);
      return;
    }
    catch (eij paramContext)
    {
      throw new ecz(a, paramContext.getMessage(), new Intent(b));
    }
    catch (eii paramContext)
    {
      throw new ecx(paramContext.getMessage());
    }
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
  
  private static Bundle b(Context paramContext, Account paramAccount, String paramString, Bundle paramBundle)
  {
    try
    {
      paramAccount = a(paramContext, paramAccount, paramString, paramBundle);
      eik.c(paramContext);
      return paramAccount;
    }
    catch (ecz paramAccount)
    {
      eik.a(a, paramContext);
      throw new edf("User intervention required. Notification has been pushed.");
    }
    catch (ede paramAccount)
    {
      eik.c(paramContext);
      throw new edf("User intervention required. Notification has been pushed.");
    }
  }
  
  @Deprecated
  public static String b(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new Account(paramString1, "com.google");
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("handle_notification", true);
    return b(paramContext, paramString1, paramString2, localBundle).getString("authtoken");
  }
  
  /* Error */
  public static java.util.List<com.google.android.gms.auth.AccountChangeEvent> b(int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 303
    //   4: invokestatic 306	enz:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   7: pop
    //   8: ldc 56
    //   10: invokestatic 61	enz:c	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 54	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: astore_2
    //   18: aload_2
    //   19: invokestatic 64	ecy:a	(Landroid/content/Context;)V
    //   22: new 94	eph
    //   25: dup
    //   26: invokespecial 95	eph:<init>	()V
    //   29: astore_0
    //   30: aload_2
    //   31: invokestatic 100	end:a	(Landroid/content/Context;)Lend;
    //   34: astore_2
    //   35: aload_2
    //   36: getstatic 38	ecy:c	Landroid/content/ComponentName;
    //   39: aload_0
    //   40: ldc 102
    //   42: invokevirtual 105	end:a	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)Z
    //   45: ifeq +91 -> 136
    //   48: aload_0
    //   49: invokevirtual 108	eph:a	()Landroid/os/IBinder;
    //   52: invokestatic 113	fnb:a	(Landroid/os/IBinder;)Lfna;
    //   55: astore_3
    //   56: new 308	com/google/android/gms/auth/AccountChangeEventsRequest
    //   59: dup
    //   60: invokespecial 309	com/google/android/gms/auth/AccountChangeEventsRequest:<init>	()V
    //   63: astore 4
    //   65: aload 4
    //   67: aload_1
    //   68: putfield 311	com/google/android/gms/auth/AccountChangeEventsRequest:c	Ljava/lang/String;
    //   71: aload 4
    //   73: iconst_0
    //   74: putfield 313	com/google/android/gms/auth/AccountChangeEventsRequest:b	I
    //   77: aload_3
    //   78: aload 4
    //   80: invokeinterface 316 2 0
    //   85: getfield 321	com/google/android/gms/auth/AccountChangeEventsResponse:b	Ljava/util/List;
    //   88: astore_1
    //   89: aload_2
    //   90: getstatic 38	ecy:c	Landroid/content/ComponentName;
    //   93: aload_0
    //   94: ldc 102
    //   96: invokevirtual 140	end:b	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   99: aload_1
    //   100: areturn
    //   101: astore_1
    //   102: new 134	java/io/IOException
    //   105: dup
    //   106: ldc -120
    //   108: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   111: athrow
    //   112: astore_1
    //   113: aload_2
    //   114: getstatic 38	ecy:c	Landroid/content/ComponentName;
    //   117: aload_0
    //   118: ldc 102
    //   120: invokevirtual 140	end:b	(Landroid/content/ComponentName;Landroid/content/ServiceConnection;Ljava/lang/String;)V
    //   123: aload_1
    //   124: athrow
    //   125: astore_1
    //   126: new 128	ecx
    //   129: dup
    //   130: ldc -48
    //   132: invokespecial 132	ecx:<init>	(Ljava/lang/String;)V
    //   135: athrow
    //   136: new 134	java/io/IOException
    //   139: dup
    //   140: ldc -42
    //   142: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramInt	int
    //   0	100	1	localObject1	Object
    //   101	1	1	localRemoteException	android.os.RemoteException
    //   112	12	1	localObject2	Object
    //   125	1	1	localInterruptedException	InterruptedException
    //   17	97	2	localObject3	Object
    //   55	23	3	localfna	fna
    //   63	16	4	localAccountChangeEventsRequest	com.google.android.gms.auth.AccountChangeEventsRequest
    // Exception table:
    //   from	to	target	type
    //   48	89	101	android/os/RemoteException
    //   48	89	112	finally
    //   102	112	112	finally
    //   126	136	112	finally
    //   48	89	125	java/lang/InterruptedException
  }
  
  public static Account[] c(Context paramContext, String paramString)
  {
    int i = 1;
    eih localeih = eih.b;
    eih.b(paramContext);
    enz.a(paramString);
    if (epf.a(22)) {
      if (!epf.a(23)) {}
    }
    while (i != 0)
    {
      return d(paramContext, paramString);
      switch (Build.VERSION.CODENAME.charAt(0))
      {
      }
      i = 0;
    }
    return AccountManager.get(paramContext).getAccountsByType(paramString);
  }
  
  private static Account[] d(Context paramContext, String paramString)
  {
    int i = 0;
    paramContext = ((Context)enz.a(paramContext)).getContentResolver().acquireContentProviderClient("com.google.android.gms.auth.accounts");
    if (paramContext == null) {
      return new Account[0];
    }
    try
    {
      paramString = paramContext.call("get_accounts", paramString, new Bundle()).getParcelableArray("accounts");
      Account[] arrayOfAccount = new Account[paramString.length];
      while (i < paramString.length)
      {
        arrayOfAccount[i] = ((Account)paramString[i]);
        i += 1;
      }
      return arrayOfAccount;
    }
    finally
    {
      paramContext.release();
    }
  }
}

/* Location:
 * Qualified Name:     ecy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */