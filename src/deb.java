import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.app.PendingIntent;
import android.os.Bundle;

final class deb
  implements AccountManagerCallback<Bundle>
{
  deb(dee paramdee, PendingIntent paramPendingIntent, Activity paramActivity) {}
  
  /* Error */
  public final void run(android.accounts.AccountManagerFuture<Bundle> paramAccountManagerFuture)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokeinterface 39 1 0
    //   8: ifeq +28 -> 36
    //   11: aload_0
    //   12: getfield 17	deb:a	Ldee;
    //   15: ifnull +13 -> 28
    //   18: aload_0
    //   19: getfield 17	deb:a	Ldee;
    //   22: aconst_null
    //   23: invokeinterface 44 2 0
    //   28: aload_0
    //   29: getfield 19	deb:b	Landroid/app/PendingIntent;
    //   32: invokevirtual 49	android/app/PendingIntent:cancel	()V
    //   35: return
    //   36: aload_1
    //   37: invokeinterface 53 1 0
    //   42: checkcast 55	android/os/Bundle
    //   45: astore 4
    //   47: aload 4
    //   49: ldc 57
    //   51: invokevirtual 61	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_1
    //   55: aload 4
    //   57: ldc 63
    //   59: invokevirtual 61	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   62: astore 4
    //   64: aload_1
    //   65: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   68: ifne +184 -> 252
    //   71: aload 4
    //   73: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne +176 -> 252
    //   79: new 71	android/accounts/Account
    //   82: dup
    //   83: aload_1
    //   84: aload 4
    //   86: invokespecial 74	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore_1
    //   90: aload_1
    //   91: ldc 76
    //   93: invokestatic 82	android/content/ContentResolver:getIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;)I
    //   96: istore_2
    //   97: getstatic 87	ddy:a	Ljava/lang/String;
    //   100: ldc 89
    //   102: iconst_1
    //   103: anewarray 5	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: iload_2
    //   109: invokestatic 95	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   112: aastore
    //   113: invokestatic 100	dri:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   116: pop
    //   117: iload_2
    //   118: ifeq +10 -> 128
    //   121: aload_1
    //   122: ldc 76
    //   124: iconst_1
    //   125: invokestatic 104	android/content/ContentResolver:setSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;Z)V
    //   128: aload_0
    //   129: getfield 21	deb:c	Landroid/app/Activity;
    //   132: invokevirtual 110	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   135: invokestatic 115	com/google/android/gm/provider/GmailProvider:a	(Landroid/content/Context;)V
    //   138: aload_0
    //   139: getfield 17	deb:a	Ldee;
    //   142: ifnull +13 -> 155
    //   145: aload_0
    //   146: getfield 17	deb:a	Ldee;
    //   149: aload_1
    //   150: invokeinterface 44 2 0
    //   155: aload_0
    //   156: getfield 19	deb:b	Landroid/app/PendingIntent;
    //   159: invokevirtual 49	android/app/PendingIntent:cancel	()V
    //   162: return
    //   163: astore_1
    //   164: aconst_null
    //   165: astore_1
    //   166: aload_0
    //   167: getfield 17	deb:a	Ldee;
    //   170: ifnull +13 -> 183
    //   173: aload_0
    //   174: getfield 17	deb:a	Ldee;
    //   177: aload_1
    //   178: invokeinterface 44 2 0
    //   183: aload_0
    //   184: getfield 19	deb:b	Landroid/app/PendingIntent;
    //   187: invokevirtual 49	android/app/PendingIntent:cancel	()V
    //   190: return
    //   191: astore 4
    //   193: aload_3
    //   194: astore_1
    //   195: aload 4
    //   197: astore_3
    //   198: aload_0
    //   199: getfield 17	deb:a	Ldee;
    //   202: ifnull +13 -> 215
    //   205: aload_0
    //   206: getfield 17	deb:a	Ldee;
    //   209: aload_1
    //   210: invokeinterface 44 2 0
    //   215: aload_0
    //   216: getfield 19	deb:b	Landroid/app/PendingIntent;
    //   219: invokevirtual 49	android/app/PendingIntent:cancel	()V
    //   222: aload_3
    //   223: athrow
    //   224: astore_3
    //   225: goto -27 -> 198
    //   228: astore_3
    //   229: goto -63 -> 166
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_1
    //   235: goto -69 -> 166
    //   238: astore_3
    //   239: goto -73 -> 166
    //   242: astore_1
    //   243: aconst_null
    //   244: astore_1
    //   245: goto -79 -> 166
    //   248: astore_3
    //   249: goto -83 -> 166
    //   252: aconst_null
    //   253: astore_1
    //   254: goto -116 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	257	0	this	deb
    //   0	257	1	paramAccountManagerFuture	android.accounts.AccountManagerFuture<Bundle>
    //   96	22	2	i	int
    //   1	222	3	localObject1	Object
    //   224	1	3	localObject2	Object
    //   228	1	3	localAuthenticatorException	android.accounts.AuthenticatorException
    //   238	1	3	localOperationCanceledException	android.accounts.OperationCanceledException
    //   248	1	3	localIOException	java.io.IOException
    //   45	40	4	localObject3	Object
    //   191	5	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	90	163	android/accounts/AuthenticatorException
    //   36	90	191	finally
    //   90	117	224	finally
    //   121	128	224	finally
    //   128	138	224	finally
    //   90	117	228	android/accounts/AuthenticatorException
    //   121	128	228	android/accounts/AuthenticatorException
    //   128	138	228	android/accounts/AuthenticatorException
    //   36	90	232	android/accounts/OperationCanceledException
    //   90	117	238	android/accounts/OperationCanceledException
    //   121	128	238	android/accounts/OperationCanceledException
    //   128	138	238	android/accounts/OperationCanceledException
    //   36	90	242	java/io/IOException
    //   90	117	248	java/io/IOException
    //   121	128	248	java/io/IOException
    //   128	138	248	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     deb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */