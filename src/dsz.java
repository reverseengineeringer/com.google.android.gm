import android.os.Bundle;

abstract class dsz
  implements Runnable
{
  public volatile Thread m;
  public final Object n = new Object();
  public volatile boolean o;
  public volatile int p;
  final long q;
  String[] r = null;
  
  public dsz(drp paramdrp)
  {
    long l = drp.ab;
    drp.ab = 1L + l;
    q = l;
    m = null;
    o = false;
    p = 0;
  }
  
  public Bundle a(int paramInt)
  {
    if (o) {
      paramInt = 3;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("status", paramInt);
      localBundle.putInt("error", p);
      return localBundle;
      if (d()) {
        paramInt = 2;
      } else if ((paramInt & 0x8) != 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public Bundle a(Bundle paramBundle)
  {
    for (;;)
    {
      Bundle localBundle;
      try
      {
        String str = paramBundle.getString("command");
        localBundle = new Bundle();
        if (!"retry".equals(str)) {
          break label140;
        }
        boolean bool = paramBundle.getBoolean("force_refresh", false);
        if ((!o) && (!bool))
        {
          dri.c(drp.b, "Mail cursor told to retry, but not in error state", new Object[0]);
          localBundle.putString("commandResponse", "ok");
          return localBundle;
        }
        if (m != null)
        {
          dri.c(drp.b, "Mail cursor told to retry, but already fetching", new Object[0]);
          continue;
        }
        dri.c(drp.b, "Mail cursor told to retry, retrying", new Object[0]);
      }
      finally {}
      o = false;
      p = 0;
      l();
      s.b(false);
      continue;
      label140:
      localBundle.putString("commandResponse", "unknownCommand");
    }
  }
  
  public String[] b()
  {
    return r;
  }
  
  public boolean d()
  {
    return false;
  }
  
  protected abstract void h();
  
  public boolean k()
  {
    return false;
  }
  
  /* Error */
  protected final boolean l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	dsz:m	Ljava/lang/Thread;
    //   4: ifnonnull +115 -> 119
    //   7: aload_0
    //   8: getfield 29	dsz:n	Ljava/lang/Object;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 40	dsz:m	Ljava/lang/Thread;
    //   18: ifnonnull +71 -> 89
    //   21: aload_0
    //   22: getfield 24	dsz:s	Ldrp;
    //   25: getfield 121	drp:P	Z
    //   28: ifne +61 -> 89
    //   31: aload_0
    //   32: new 123	java/lang/Thread
    //   35: dup
    //   36: aload_0
    //   37: ldc 125
    //   39: invokespecial 128	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   42: putfield 40	dsz:m	Ljava/lang/Thread;
    //   45: aload_0
    //   46: getfield 40	dsz:m	Ljava/lang/Thread;
    //   49: invokevirtual 131	java/lang/Thread:start	()V
    //   52: aload_1
    //   53: monitorexit
    //   54: getstatic 135	drp:Q	Ljava/util/Set;
    //   57: astore_1
    //   58: aload_1
    //   59: monitorenter
    //   60: aload_0
    //   61: getfield 40	dsz:m	Ljava/lang/Thread;
    //   64: ifnull +16 -> 80
    //   67: getstatic 135	drp:Q	Ljava/util/Set;
    //   70: aload_0
    //   71: getfield 40	dsz:m	Ljava/lang/Thread;
    //   74: invokeinterface 140 2 0
    //   79: pop
    //   80: aload_1
    //   81: monitorexit
    //   82: iconst_1
    //   83: ireturn
    //   84: astore_2
    //   85: aload_1
    //   86: monitorexit
    //   87: aload_2
    //   88: athrow
    //   89: aload_1
    //   90: monitorexit
    //   91: getstatic 135	drp:Q	Ljava/util/Set;
    //   94: astore_1
    //   95: aload_1
    //   96: monitorenter
    //   97: aload_0
    //   98: getfield 40	dsz:m	Ljava/lang/Thread;
    //   101: ifnull +16 -> 117
    //   104: getstatic 135	drp:Q	Ljava/util/Set;
    //   107: aload_0
    //   108: getfield 40	dsz:m	Ljava/lang/Thread;
    //   111: invokeinterface 140 2 0
    //   116: pop
    //   117: aload_1
    //   118: monitorexit
    //   119: iconst_0
    //   120: ireturn
    //   121: astore_2
    //   122: aload_1
    //   123: monitorexit
    //   124: aload_2
    //   125: athrow
    //   126: astore_2
    //   127: getstatic 135	drp:Q	Ljava/util/Set;
    //   130: astore_1
    //   131: aload_1
    //   132: monitorenter
    //   133: aload_0
    //   134: getfield 40	dsz:m	Ljava/lang/Thread;
    //   137: ifnull +16 -> 153
    //   140: getstatic 135	drp:Q	Ljava/util/Set;
    //   143: aload_0
    //   144: getfield 40	dsz:m	Ljava/lang/Thread;
    //   147: invokeinterface 140 2 0
    //   152: pop
    //   153: aload_1
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: aload_1
    //   159: monitorexit
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: aload_1
    //   164: monitorexit
    //   165: aload_2
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	dsz
    //   84	4	2	localObject2	Object
    //   121	4	2	localObject3	Object
    //   126	30	2	localObject4	Object
    //   157	4	2	localObject5	Object
    //   162	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   60	80	84	finally
    //   80	82	84	finally
    //   85	87	84	finally
    //   14	54	121	finally
    //   89	91	121	finally
    //   122	124	121	finally
    //   7	14	126	finally
    //   124	126	126	finally
    //   97	117	157	finally
    //   117	119	157	finally
    //   158	160	157	finally
    //   133	153	162	finally
    //   153	155	162	finally
    //   163	165	162	finally
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 153	dsz:h	()V
    //   4: aload_0
    //   5: iconst_0
    //   6: putfield 42	dsz:o	Z
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 44	dsz:p	I
    //   14: aload_0
    //   15: getfield 24	dsz:s	Ldrp;
    //   18: iconst_0
    //   19: iconst_0
    //   20: invokevirtual 156	drp:a	(II)V
    //   23: getstatic 135	drp:Q	Ljava/util/Set;
    //   26: astore_1
    //   27: aload_1
    //   28: monitorenter
    //   29: aload_0
    //   30: getfield 40	dsz:m	Ljava/lang/Thread;
    //   33: ifnull +16 -> 49
    //   36: getstatic 135	drp:Q	Ljava/util/Set;
    //   39: aload_0
    //   40: getfield 40	dsz:m	Ljava/lang/Thread;
    //   43: invokeinterface 159 2 0
    //   48: pop
    //   49: aload_1
    //   50: monitorexit
    //   51: aload_0
    //   52: getfield 24	dsz:s	Ldrp;
    //   55: iconst_0
    //   56: invokevirtual 113	drp:b	(Z)V
    //   59: aload_0
    //   60: getfield 29	dsz:n	Ljava/lang/Object;
    //   63: astore_1
    //   64: aload_1
    //   65: monitorenter
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 40	dsz:m	Ljava/lang/Thread;
    //   71: aload_1
    //   72: monitorexit
    //   73: return
    //   74: astore_1
    //   75: getstatic 87	drp:b	Ljava/lang/String;
    //   78: ldc -95
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: aastore
    //   91: invokestatic 95	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   94: pop
    //   95: aload_0
    //   96: iconst_1
    //   97: putfield 42	dsz:o	Z
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield 44	dsz:p	I
    //   105: aload_0
    //   106: getfield 24	dsz:s	Ldrp;
    //   109: iconst_1
    //   110: iconst_0
    //   111: invokevirtual 156	drp:a	(II)V
    //   114: goto -91 -> 23
    //   117: astore_1
    //   118: getstatic 87	drp:b	Ljava/lang/String;
    //   121: ldc -89
    //   123: iconst_1
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload_1
    //   130: invokevirtual 168	dsj:getMessage	()Ljava/lang/String;
    //   133: aastore
    //   134: invokestatic 95	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   137: pop
    //   138: aload_0
    //   139: iconst_1
    //   140: putfield 42	dsz:o	Z
    //   143: aload_0
    //   144: iconst_2
    //   145: putfield 44	dsz:p	I
    //   148: aload_0
    //   149: getfield 24	dsz:s	Ldrp;
    //   152: iconst_2
    //   153: iconst_0
    //   154: invokevirtual 156	drp:a	(II)V
    //   157: goto -134 -> 23
    //   160: astore_1
    //   161: getstatic 87	drp:b	Ljava/lang/String;
    //   164: ldc -86
    //   166: iconst_1
    //   167: anewarray 4	java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_1
    //   173: invokevirtual 171	dty:getMessage	()Ljava/lang/String;
    //   176: aastore
    //   177: invokestatic 95	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   180: pop
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield 42	dsz:o	Z
    //   186: aload_0
    //   187: iconst_3
    //   188: putfield 44	dsz:p	I
    //   191: aload_0
    //   192: getfield 24	dsz:s	Ldrp;
    //   195: bipush 7
    //   197: iconst_3
    //   198: invokevirtual 156	drp:a	(II)V
    //   201: goto -178 -> 23
    //   204: astore_1
    //   205: getstatic 87	drp:b	Ljava/lang/String;
    //   208: ldc -83
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: aload_1
    //   217: invokevirtual 174	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   220: aastore
    //   221: invokestatic 95	dri:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   224: pop
    //   225: aload_0
    //   226: iconst_1
    //   227: putfield 42	dsz:o	Z
    //   230: aload_0
    //   231: iconst_4
    //   232: putfield 44	dsz:p	I
    //   235: aload_0
    //   236: getfield 24	dsz:s	Ldrp;
    //   239: bipush 9
    //   241: iconst_0
    //   242: invokevirtual 156	drp:a	(II)V
    //   245: goto -222 -> 23
    //   248: astore_1
    //   249: getstatic 87	drp:b	Ljava/lang/String;
    //   252: aload_1
    //   253: ldc -80
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 179	dri:c	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   262: pop
    //   263: aload_0
    //   264: iconst_1
    //   265: putfield 42	dsz:o	Z
    //   268: aload_0
    //   269: iconst_5
    //   270: putfield 44	dsz:p	I
    //   273: aload_0
    //   274: getfield 24	dsz:s	Ldrp;
    //   277: iconst_3
    //   278: iconst_0
    //   279: invokevirtual 156	drp:a	(II)V
    //   282: goto -259 -> 23
    //   285: astore_2
    //   286: aload_1
    //   287: monitorexit
    //   288: aload_2
    //   289: athrow
    //   290: astore_2
    //   291: aload_1
    //   292: monitorexit
    //   293: aload_2
    //   294: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	dsz
    //   74	13	1	localIOException	java.io.IOException
    //   117	13	1	localdsj	dsj
    //   160	13	1	localdty	dty
    //   204	13	1	localSQLiteException	android.database.sqlite.SQLiteException
    //   248	44	1	localdsl	dsl
    //   285	4	2	localObject2	Object
    //   290	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	74	java/io/IOException
    //   0	23	117	dsj
    //   0	23	160	dty
    //   0	23	204	android/database/sqlite/SQLiteException
    //   0	23	248	dsl
    //   29	49	285	finally
    //   49	51	285	finally
    //   286	288	285	finally
    //   66	73	290	finally
    //   291	293	290	finally
  }
}

/* Location:
 * Qualified Name:     dsz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */