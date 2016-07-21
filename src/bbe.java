import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import com.android.email.SecurityPolicy;
import com.android.email.SecurityPolicy.PolicyAdmin;
import com.android.email.service.PolicyService;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Policy;

public final class bbe
  extends bff
{
  public bbe(PolicyService paramPolicyService) {}
  
  public final void a()
  {
    try
    {
      SecurityPolicy localSecurityPolicy = a.b;
      DevicePolicyManager localDevicePolicyManager = localSecurityPolicy.a();
      if (localDevicePolicyManager.isAdminActive(b))
      {
        localDevicePolicyManager.wipeData(1);
        return;
      }
      cvm.b(bbw.a, "Could not remote wipe because not device admin.", new Object[0]);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      cvm.e(PolicyService.a, localRuntimeException, "Exception thrown during call to SecurityPolicy#remoteWipe", new Object[0]);
      throw localRuntimeException;
    }
  }
  
  public final void a(long paramLong, Policy paramPolicy, String paramString)
  {
    a(paramLong, paramPolicy, paramString, true);
  }
  
  /* Error */
  public final void a(long paramLong, Policy paramPolicy, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	bbe:a	Lcom/android/email/service/PolicyService;
    //   4: getfield 22	com/android/email/service/PolicyService:b	Lcom/android/email/SecurityPolicy;
    //   7: astore 10
    //   9: aload 10
    //   11: getfield 72	com/android/email/SecurityPolicy:a	Landroid/content/Context;
    //   14: lload_1
    //   15: invokestatic 77	com/android/emailcommon/provider/Account:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Account;
    //   18: astore 11
    //   20: aload 11
    //   22: ifnull +695 -> 717
    //   25: aconst_null
    //   26: astore 9
    //   28: aload 11
    //   30: getfield 81	com/android/emailcommon/provider/Account:o	J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +18 -> 53
    //   38: aload 10
    //   40: getfield 72	com/android/email/SecurityPolicy:a	Landroid/content/Context;
    //   43: aload 11
    //   45: getfield 81	com/android/emailcommon/provider/Account:o	J
    //   48: invokestatic 86	com/android/emailcommon/provider/Policy:a	(Landroid/content/Context;J)Lcom/android/emailcommon/provider/Policy;
    //   51: astore 9
    //   53: aload 9
    //   55: ifnull +43 -> 98
    //   58: aload 4
    //   60: ifnull +38 -> 98
    //   63: aload 9
    //   65: getfield 90	com/android/emailcommon/provider/Policy:n	Z
    //   68: aload_3
    //   69: getfield 90	com/android/emailcommon/provider/Policy:n	Z
    //   72: if_icmpne +15 -> 87
    //   75: aload 9
    //   77: getfield 94	com/android/emailcommon/provider/Policy:p	I
    //   80: aload_3
    //   81: getfield 94	com/android/emailcommon/provider/Policy:p	I
    //   84: if_icmpeq +14 -> 98
    //   87: aload 10
    //   89: getfield 72	com/android/email/SecurityPolicy:a	Landroid/content/Context;
    //   92: aload 11
    //   94: aload_3
    //   95: invokestatic 97	com/android/emailcommon/provider/Policy:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;Lcom/android/emailcommon/provider/Policy;)V
    //   98: aload 9
    //   100: ifnull +611 -> 711
    //   103: aload 9
    //   105: aload_3
    //   106: invokevirtual 101	com/android/emailcommon/provider/Policy:equals	(Ljava/lang/Object;)Z
    //   109: ifne +609 -> 718
    //   112: goto +599 -> 711
    //   115: iload 6
    //   117: ifne +160 -> 277
    //   120: aload 4
    //   122: aload 11
    //   124: getfield 104	com/android/emailcommon/provider/Account:m	Ljava/lang/String;
    //   127: invokestatic 109	bhl:b	(Ljava/lang/String;Ljava/lang/String;)Z
    //   130: ifeq +147 -> 277
    //   133: getstatic 45	bbw:a	Ljava/lang/String;
    //   136: ldc 111
    //   138: iconst_0
    //   139: anewarray 49	java/lang/Object
    //   142: invokestatic 54	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   145: pop
    //   146: iconst_0
    //   147: istore 8
    //   149: aload 10
    //   151: getfield 72	com/android/email/SecurityPolicy:a	Landroid/content/Context;
    //   154: invokestatic 116	bbz:a	(Landroid/content/Context;)Lbbx;
    //   157: astore 4
    //   159: aload_3
    //   160: getfield 119	com/android/emailcommon/provider/Policy:w	Ljava/lang/String;
    //   163: ifnull +335 -> 498
    //   166: getstatic 45	bbw:a	Ljava/lang/String;
    //   169: astore_3
    //   170: aload 11
    //   172: getfield 122	com/android/emailcommon/provider/Account:c	Ljava/lang/String;
    //   175: invokestatic 128	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   178: astore 9
    //   180: aload_3
    //   181: new 130	java/lang/StringBuilder
    //   184: dup
    //   185: aload 9
    //   187: invokestatic 128	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   190: invokevirtual 134	java/lang/String:length	()I
    //   193: bipush 35
    //   195: iadd
    //   196: invokespecial 136	java/lang/StringBuilder:<init>	(I)V
    //   199: ldc -118
    //   201: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 9
    //   206: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc -112
    //   211: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: iconst_0
    //   218: anewarray 49	java/lang/Object
    //   221: invokestatic 54	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   224: pop
    //   225: iconst_1
    //   226: istore 7
    //   228: iload 5
    //   230: ifeq +12 -> 242
    //   233: aload 4
    //   235: aload 11
    //   237: invokeinterface 154 2 0
    //   242: ldc -100
    //   244: lload_1
    //   245: invokestatic 161	com/android/email/provider/EmailProvider:a	(Ljava/lang/String;J)Landroid/net/Uri;
    //   248: astore_3
    //   249: aload 10
    //   251: getfield 72	com/android/email/SecurityPolicy:a	Landroid/content/Context;
    //   254: invokevirtual 167	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   257: aload_3
    //   258: aconst_null
    //   259: aconst_null
    //   260: invokevirtual 173	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   263: pop
    //   264: aload 10
    //   266: getfield 72	com/android/email/SecurityPolicy:a	Landroid/content/Context;
    //   269: aload 11
    //   271: iload 7
    //   273: invokestatic 176	com/android/email/SecurityPolicy:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;Z)V
    //   276: return
    //   277: aload 10
    //   279: getfield 72	com/android/email/SecurityPolicy:a	Landroid/content/Context;
    //   282: astore 9
    //   284: new 178	java/util/ArrayList
    //   287: dup
    //   288: invokespecial 179	java/util/ArrayList:<init>	()V
    //   291: astore 12
    //   293: aload_3
    //   294: ifnull +151 -> 445
    //   297: aload_3
    //   298: invokevirtual 181	com/android/emailcommon/provider/Policy:d	()V
    //   301: aload 12
    //   303: getstatic 184	com/android/emailcommon/provider/Policy:a	Landroid/net/Uri;
    //   306: invokestatic 190	android/content/ContentProviderOperation:newInsert	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   309: aload_3
    //   310: invokevirtual 193	com/android/emailcommon/provider/Policy:e	()Landroid/content/ContentValues;
    //   313: invokevirtual 199	android/content/ContentProviderOperation$Builder:withValues	(Landroid/content/ContentValues;)Landroid/content/ContentProviderOperation$Builder;
    //   316: invokevirtual 203	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   319: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload 12
    //   325: getstatic 207	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   328: aload 11
    //   330: getfield 210	com/android/emailcommon/provider/Account:D	J
    //   333: invokestatic 216	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   336: invokestatic 219	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   339: ldc -35
    //   341: iconst_0
    //   342: invokevirtual 225	android/content/ContentProviderOperation$Builder:withValueBackReference	(Ljava/lang/String;I)Landroid/content/ContentProviderOperation$Builder;
    //   345: ldc -29
    //   347: aload 4
    //   349: invokevirtual 231	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   352: invokevirtual 203	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   355: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   358: pop
    //   359: aload 11
    //   361: getfield 81	com/android/emailcommon/provider/Account:o	J
    //   364: lconst_0
    //   365: lcmp
    //   366: ifle +26 -> 392
    //   369: aload 12
    //   371: getstatic 184	com/android/emailcommon/provider/Policy:a	Landroid/net/Uri;
    //   374: aload 11
    //   376: getfield 81	com/android/emailcommon/provider/Account:o	J
    //   379: invokestatic 216	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   382: invokestatic 234	android/content/ContentProviderOperation:newDelete	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   385: invokevirtual 203	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   388: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   391: pop
    //   392: aload 9
    //   394: invokevirtual 167	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   397: getstatic 239	bdv:F	Ljava/lang/String;
    //   400: aload 12
    //   402: invokevirtual 243	android/content/ContentResolver:applyBatch	(Ljava/lang/String;Ljava/util/ArrayList;)[Landroid/content/ContentProviderResult;
    //   405: pop
    //   406: aload 11
    //   408: aload 9
    //   410: invokevirtual 246	com/android/emailcommon/provider/Account:b	(Landroid/content/Context;)V
    //   413: aload 9
    //   415: aload 11
    //   417: invokestatic 249	com/android/email/SecurityPolicy:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/Account;)V
    //   420: aload 10
    //   422: invokevirtual 251	com/android/email/SecurityPolicy:b	()V
    //   425: goto -279 -> 146
    //   428: astore_3
    //   429: getstatic 55	com/android/email/service/PolicyService:a	Ljava/lang/String;
    //   432: aload_3
    //   433: ldc -3
    //   435: iconst_0
    //   436: anewarray 49	java/lang/Object
    //   439: invokestatic 61	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   442: pop
    //   443: aload_3
    //   444: athrow
    //   445: aload 12
    //   447: getstatic 207	com/android/emailcommon/provider/Account:a	Landroid/net/Uri;
    //   450: aload 11
    //   452: getfield 210	com/android/emailcommon/provider/Account:D	J
    //   455: invokestatic 216	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   458: invokestatic 219	android/content/ContentProviderOperation:newUpdate	(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;
    //   461: ldc -29
    //   463: aconst_null
    //   464: invokevirtual 231	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   467: ldc -35
    //   469: iconst_0
    //   470: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   473: invokevirtual 231	android/content/ContentProviderOperation$Builder:withValue	(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;
    //   476: invokevirtual 203	android/content/ContentProviderOperation$Builder:build	()Landroid/content/ContentProviderOperation;
    //   479: invokevirtual 206	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   482: pop
    //   483: goto -124 -> 359
    //   486: astore_3
    //   487: new 260	java/lang/IllegalStateException
    //   490: dup
    //   491: ldc_w 262
    //   494: invokespecial 265	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   497: athrow
    //   498: aload 10
    //   500: aload_3
    //   501: invokevirtual 268	com/android/email/SecurityPolicy:a	(Lcom/android/emailcommon/provider/Policy;)Z
    //   504: ifeq +114 -> 618
    //   507: iload 6
    //   509: ifeq +88 -> 597
    //   512: getstatic 45	bbw:a	Ljava/lang/String;
    //   515: astore_3
    //   516: aload 11
    //   518: getfield 122	com/android/emailcommon/provider/Account:c	Ljava/lang/String;
    //   521: invokestatic 128	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   524: astore 9
    //   526: aload_3
    //   527: new 130	java/lang/StringBuilder
    //   530: dup
    //   531: aload 9
    //   533: invokestatic 128	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   536: invokevirtual 134	java/lang/String:length	()I
    //   539: bipush 29
    //   541: iadd
    //   542: invokespecial 136	java/lang/StringBuilder:<init>	(I)V
    //   545: ldc -118
    //   547: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: aload 9
    //   552: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: ldc_w 270
    //   558: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: iconst_0
    //   565: anewarray 49	java/lang/Object
    //   568: invokestatic 54	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   571: pop
    //   572: iload 8
    //   574: istore 7
    //   576: iload 5
    //   578: ifeq -314 -> 264
    //   581: aload 4
    //   583: aload 11
    //   585: invokeinterface 272 2 0
    //   590: iload 8
    //   592: istore 7
    //   594: goto -330 -> 264
    //   597: getstatic 45	bbw:a	Ljava/lang/String;
    //   600: ldc_w 274
    //   603: iconst_0
    //   604: anewarray 49	java/lang/Object
    //   607: invokestatic 54	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   610: pop
    //   611: iload 8
    //   613: istore 7
    //   615: goto -351 -> 264
    //   618: iconst_1
    //   619: istore 8
    //   621: getstatic 45	bbw:a	Ljava/lang/String;
    //   624: astore_3
    //   625: aload 11
    //   627: getfield 122	com/android/emailcommon/provider/Account:c	Ljava/lang/String;
    //   630: invokestatic 128	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   633: astore 9
    //   635: aload_3
    //   636: new 130	java/lang/StringBuilder
    //   639: dup
    //   640: aload 9
    //   642: invokestatic 128	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   645: invokevirtual 134	java/lang/String:length	()I
    //   648: bipush 44
    //   650: iadd
    //   651: invokespecial 136	java/lang/StringBuilder:<init>	(I)V
    //   654: ldc -118
    //   656: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload 9
    //   661: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 276
    //   667: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: iconst_0
    //   674: anewarray 49	java/lang/Object
    //   677: invokestatic 54	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   680: pop
    //   681: iload 8
    //   683: istore 7
    //   685: iload 5
    //   687: ifeq -423 -> 264
    //   690: aload 4
    //   692: aload 11
    //   694: invokeinterface 278 2 0
    //   699: iload 8
    //   701: istore 7
    //   703: goto -439 -> 264
    //   706: astore 4
    //   708: goto -288 -> 420
    //   711: iconst_1
    //   712: istore 6
    //   714: goto -599 -> 115
    //   717: return
    //   718: iconst_0
    //   719: istore 6
    //   721: goto -606 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	this	bbe
    //   0	724	1	paramLong	long
    //   0	724	3	paramPolicy	Policy
    //   0	724	4	paramString	String
    //   0	724	5	paramBoolean	boolean
    //   115	605	6	i	int
    //   226	476	7	bool1	boolean
    //   147	553	8	bool2	boolean
    //   26	634	9	localObject	Object
    //   7	492	10	localSecurityPolicy	SecurityPolicy
    //   18	675	11	localAccount	Account
    //   291	155	12	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   0	20	428	java/lang/RuntimeException
    //   28	53	428	java/lang/RuntimeException
    //   63	87	428	java/lang/RuntimeException
    //   87	98	428	java/lang/RuntimeException
    //   103	112	428	java/lang/RuntimeException
    //   120	146	428	java/lang/RuntimeException
    //   149	225	428	java/lang/RuntimeException
    //   233	242	428	java/lang/RuntimeException
    //   242	264	428	java/lang/RuntimeException
    //   264	276	428	java/lang/RuntimeException
    //   277	293	428	java/lang/RuntimeException
    //   297	359	428	java/lang/RuntimeException
    //   359	392	428	java/lang/RuntimeException
    //   392	420	428	java/lang/RuntimeException
    //   420	425	428	java/lang/RuntimeException
    //   445	483	428	java/lang/RuntimeException
    //   487	498	428	java/lang/RuntimeException
    //   498	507	428	java/lang/RuntimeException
    //   512	572	428	java/lang/RuntimeException
    //   581	590	428	java/lang/RuntimeException
    //   597	611	428	java/lang/RuntimeException
    //   621	681	428	java/lang/RuntimeException
    //   690	699	428	java/lang/RuntimeException
    //   392	420	486	android/os/RemoteException
    //   392	420	706	android/content/OperationApplicationException
  }
  
  public final void a(long paramLong, boolean paramBoolean)
  {
    Context localContext = a.c;
    Account localAccount = Account.a(localContext, paramLong);
    if (localAccount != null)
    {
      SecurityPolicy.a(localContext, localAccount, paramBoolean);
      if (paramBoolean) {
        bbz.a(localContext).b(localAccount);
      }
    }
  }
  
  public final boolean a(Policy paramPolicy)
  {
    try
    {
      boolean bool = a.b.a(paramPolicy);
      return bool;
    }
    catch (RuntimeException paramPolicy)
    {
      cvm.e(PolicyService.a, paramPolicy, "Exception thrown during call to SecurityPolicy#isActive", new Object[0]);
      throw paramPolicy;
    }
  }
  
  public final boolean b()
  {
    DevicePolicyManager localDevicePolicyManager = (DevicePolicyManager)a.c.getSystemService("device_policy");
    ComponentName localComponentName = new ComponentName(a.c, SecurityPolicy.PolicyAdmin.class);
    if (localDevicePolicyManager.getCameraDisabled(localComponentName)) {
      return true;
    }
    try
    {
      localDevicePolicyManager.setCameraDisabled(localComponentName, true);
      localDevicePolicyManager.setCameraDisabled(localComponentName, false);
      return true;
    }
    catch (SecurityException localSecurityException)
    {
      cvm.d(PolicyService.a, "SecurityException checking camera disabling.", new Object[0]);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bbe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */