import android.content.Context;
import android.os.ParcelFileDescriptor;

public final class baa
{
  public static int a(String paramString)
  {
    if (cxd.c()) {
      return ParcelFileDescriptor.parseMode(paramString);
    }
    if ("r".equals(paramString)) {
      return 268435456;
    }
    if (("w".equals(paramString)) || ("wt".equals(paramString))) {
      return 738197504;
    }
    if ("wa".equals(paramString)) {
      return 704643072;
    }
    if ("rw".equals(paramString)) {
      return 939524096;
    }
    if ("rwt".equals(paramString)) {
      return 1006632960;
    }
    throw new IllegalArgumentException(String.valueOf(paramString).length() + 11 + "Bad mode '" + paramString + "'");
  }
  
  /* Error */
  public static void a(Context paramContext, bdg parambdg, com.android.emailcommon.provider.Account paramAccount, com.android.emailcommon.provider.Mailbox paramMailbox, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 85	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: getstatic 90	beb:a	Landroid/net/Uri;
    //   7: getstatic 94	beb:g	[Ljava/lang/String;
    //   10: ldc 96
    //   12: iconst_3
    //   13: anewarray 21	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: aload_2
    //   19: getfield 102	com/android/emailcommon/provider/Account:D	J
    //   22: invokestatic 105	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   25: aastore
    //   26: dup
    //   27: iconst_1
    //   28: aload_3
    //   29: getfield 108	com/android/emailcommon/provider/Mailbox:D	J
    //   32: invokestatic 105	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   35: aastore
    //   36: dup
    //   37: iconst_2
    //   38: aload_1
    //   39: getfield 114	bdg:f	Ljava/lang/String;
    //   42: invokestatic 48	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   45: aastore
    //   46: aconst_null
    //   47: invokevirtual 120	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 6
    //   52: aload 6
    //   54: ifnonnull +16 -> 70
    //   57: aload 6
    //   59: ifnull +10 -> 69
    //   62: aload 6
    //   64: invokeinterface 126 1 0
    //   69: return
    //   70: aload 6
    //   72: invokeinterface 129 1 0
    //   77: ifeq +281 -> 358
    //   80: aload_0
    //   81: aload 6
    //   83: ldc 87
    //   85: invokestatic 134	bdv:a	(Landroid/content/Context;Landroid/database/Cursor;Ljava/lang/Class;)Lbdv;
    //   88: checkcast 87	beb
    //   91: astore 5
    //   93: aload 5
    //   95: aload_3
    //   96: getfield 108	com/android/emailcommon/provider/Mailbox:D	J
    //   99: putfield 137	beb:U	J
    //   102: aload 5
    //   104: aload_2
    //   105: getfield 102	com/android/emailcommon/provider/Account:D	J
    //   108: putfield 140	beb:V	J
    //   111: aload 5
    //   113: getfield 141	beb:D	J
    //   116: ldc2_w 142
    //   119: lcmp
    //   120: ifeq +331 -> 451
    //   123: aload_0
    //   124: aload 5
    //   126: getfield 141	beb:D	J
    //   129: invokestatic 148	bds:a	(Landroid/content/Context;J)Lbds;
    //   132: astore_2
    //   133: aload_2
    //   134: ifnonnull +314 -> 448
    //   137: new 145	bds
    //   140: dup
    //   141: invokespecial 150	bds:<init>	()V
    //   144: astore_2
    //   145: aload 5
    //   147: aload_1
    //   148: aload 5
    //   150: getfield 140	beb:V	J
    //   153: aload 5
    //   155: getfield 137	beb:U	J
    //   158: invokestatic 155	aqt:a	(Lbeb;Lbdg;JJ)Z
    //   161: pop
    //   162: new 157	java/util/ArrayList
    //   165: dup
    //   166: invokespecial 158	java/util/ArrayList:<init>	()V
    //   169: astore_3
    //   170: new 157	java/util/ArrayList
    //   173: dup
    //   174: invokespecial 158	java/util/ArrayList:<init>	()V
    //   177: astore 7
    //   179: aload_1
    //   180: aload_3
    //   181: aload 7
    //   183: invokestatic 163	bco:a	(Lbdn;Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    //   186: aload_3
    //   187: invokestatic 168	bgu:a	(Ljava/util/ArrayList;)Lbgv;
    //   190: astore_1
    //   191: aload 5
    //   193: aload_1
    //   194: getfield 174	bgv:d	Z
    //   197: aload_1
    //   198: getfield 177	bgv:e	Z
    //   201: invokevirtual 180	beb:a	(ZZ)V
    //   204: aload 5
    //   206: aload_1
    //   207: getfield 182	bgv:c	Ljava/lang/String;
    //   210: putfield 185	beb:af	Ljava/lang/String;
    //   213: aload_2
    //   214: aload_1
    //   215: getfield 187	bgv:a	Ljava/lang/String;
    //   218: putfield 189	bds:e	Ljava/lang/String;
    //   221: aload_2
    //   222: aload_1
    //   223: getfield 192	bgv:b	Ljava/lang/String;
    //   226: putfield 194	bds:d	Ljava/lang/String;
    //   229: aload 5
    //   231: aload_0
    //   232: invokestatic 197	baa:a	(Lbdv;Landroid/content/Context;)V
    //   235: aload_2
    //   236: aload 5
    //   238: getfield 141	beb:D	J
    //   241: putfield 199	bds:c	J
    //   244: aload_2
    //   245: aload_0
    //   246: invokestatic 197	baa:a	(Lbdv;Landroid/content/Context;)V
    //   249: iload 4
    //   251: invokestatic 202	beb:a	(I)Z
    //   254: ifne +24 -> 278
    //   257: iload 4
    //   259: iconst_4
    //   260: if_icmpeq +18 -> 278
    //   263: aload_0
    //   264: aload 5
    //   266: aload 7
    //   268: invokestatic 205	aqt:a	(Landroid/content/Context;Lbeb;Ljava/util/ArrayList;)V
    //   271: aload_0
    //   272: aload 5
    //   274: aload_3
    //   275: invokestatic 207	aqt:b	(Landroid/content/Context;Lbeb;Ljava/util/ArrayList;)V
    //   278: aload 5
    //   280: iload 4
    //   282: putfield 210	beb:r	I
    //   285: new 212	android/content/ContentValues
    //   288: dup
    //   289: invokespecial 213	android/content/ContentValues:<init>	()V
    //   292: astore_1
    //   293: aload_1
    //   294: ldc -41
    //   296: aload 5
    //   298: getfield 218	beb:t	Z
    //   301: invokestatic 223	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   304: invokevirtual 227	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   307: aload_1
    //   308: ldc -27
    //   310: aload 5
    //   312: getfield 210	beb:r	I
    //   315: invokestatic 234	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: invokevirtual 237	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   321: getstatic 90	beb:a	Landroid/net/Uri;
    //   324: aload 5
    //   326: getfield 141	beb:D	J
    //   329: invokestatic 243	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   332: astore_2
    //   333: aload_0
    //   334: invokevirtual 85	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   337: aload_2
    //   338: aload_1
    //   339: aconst_null
    //   340: aconst_null
    //   341: invokevirtual 247	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   344: pop
    //   345: aload 6
    //   347: ifnull -278 -> 69
    //   350: aload 6
    //   352: invokeinterface 126 1 0
    //   357: return
    //   358: new 87	beb
    //   361: dup
    //   362: invokespecial 248	beb:<init>	()V
    //   365: astore 5
    //   367: goto -274 -> 93
    //   370: astore_0
    //   371: aload 6
    //   373: astore_1
    //   374: aload_1
    //   375: ifnull +9 -> 384
    //   378: aload_1
    //   379: invokeinterface 126 1 0
    //   384: aload_0
    //   385: athrow
    //   386: astore_0
    //   387: getstatic 251	bbw:a	Ljava/lang/String;
    //   390: aload_0
    //   391: ldc -3
    //   393: iconst_0
    //   394: anewarray 4	java/lang/Object
    //   397: invokestatic 258	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   400: pop
    //   401: goto -56 -> 345
    //   404: astore_0
    //   405: getstatic 251	bbw:a	Ljava/lang/String;
    //   408: aload_0
    //   409: ldc_w 260
    //   412: iconst_0
    //   413: anewarray 4	java/lang/Object
    //   416: invokestatic 258	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   419: pop
    //   420: goto -75 -> 345
    //   423: astore_0
    //   424: getstatic 251	bbw:a	Ljava/lang/String;
    //   427: aload_0
    //   428: ldc_w 262
    //   431: iconst_0
    //   432: anewarray 4	java/lang/Object
    //   435: invokestatic 258	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   438: pop
    //   439: goto -94 -> 345
    //   442: astore_0
    //   443: aconst_null
    //   444: astore_1
    //   445: goto -71 -> 374
    //   448: goto -303 -> 145
    //   451: aconst_null
    //   452: astore_2
    //   453: goto -320 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	paramContext	Context
    //   0	456	1	parambdg	bdg
    //   0	456	2	paramAccount	com.android.emailcommon.provider.Account
    //   0	456	3	paramMailbox	com.android.emailcommon.provider.Mailbox
    //   0	456	4	paramInt	int
    //   91	275	5	localbeb	beb
    //   50	322	6	localCursor	android.database.Cursor
    //   177	90	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   70	93	370	finally
    //   93	111	370	finally
    //   111	133	370	finally
    //   137	145	370	finally
    //   145	257	370	finally
    //   263	278	370	finally
    //   278	345	370	finally
    //   358	367	370	finally
    //   387	401	370	finally
    //   405	420	370	finally
    //   424	439	370	finally
    //   145	257	386	bdi
    //   263	278	386	bdi
    //   278	345	386	bdi
    //   111	133	404	java/lang/RuntimeException
    //   137	145	404	java/lang/RuntimeException
    //   145	257	404	java/lang/RuntimeException
    //   263	278	404	java/lang/RuntimeException
    //   278	345	404	java/lang/RuntimeException
    //   387	401	404	java/lang/RuntimeException
    //   111	133	423	java/io/IOException
    //   137	145	423	java/io/IOException
    //   145	257	423	java/io/IOException
    //   263	278	423	java/io/IOException
    //   278	345	423	java/io/IOException
    //   387	401	423	java/io/IOException
    //   0	52	442	finally
  }
  
  public static void a(bdv parambdv, Context paramContext)
  {
    if (parambdv.h())
    {
      parambdv.a(paramContext, parambdv.e());
      return;
    }
    parambdv.h(paramContext);
  }
}

/* Location:
 * Qualified Name:     baa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */