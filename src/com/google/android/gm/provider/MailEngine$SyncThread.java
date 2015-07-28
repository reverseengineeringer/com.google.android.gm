package com.google.android.gm.provider;

class MailEngine$SyncThread
  implements Runnable
{
  public MailEngine$SyncThread(MailEngine paramMailEngine) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   4: invokestatic 30	com/google/android/gm/provider/MailEngine:access$3000	(Lcom/google/android/gm/provider/MailEngine;)Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   15: invokevirtual 34	com/google/android/gm/provider/MailEngine:isHandlingUserRefresh	()Z
    //   18: ifeq +191 -> 209
    //   21: ldc 36
    //   23: iconst_3
    //   24: invokestatic 42	com/google/android/gm/provider/LogUtils:isLoggable	(Ljava/lang/String;I)Z
    //   27: ifeq +190 -> 217
    //   30: invokestatic 48	android/os/SystemClock:elapsedRealtime	()J
    //   33: lstore_1
    //   34: aload_0
    //   35: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   38: invokestatic 52	com/google/android/gm/provider/MailEngine:access$3100	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Thread;
    //   41: ifnull +171 -> 212
    //   44: iconst_1
    //   45: istore_3
    //   46: aload_0
    //   47: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   50: invokestatic 56	com/google/android/gm/provider/MailEngine:access$3200	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    //   53: astore 4
    //   55: aload 4
    //   57: monitorenter
    //   58: ldc 36
    //   60: iconst_3
    //   61: invokestatic 42	com/google/android/gm/provider/LogUtils:isLoggable	(Ljava/lang/String;I)Z
    //   64: ifeq +43 -> 107
    //   67: invokestatic 48	android/os/SystemClock:elapsedRealtime	()J
    //   70: lload_1
    //   71: lsub
    //   72: lstore_1
    //   73: lload_1
    //   74: ldc2_w 57
    //   77: lcmp
    //   78: ifle +29 -> 107
    //   81: ldc 36
    //   83: ldc 60
    //   85: iconst_2
    //   86: anewarray 4	java/lang/Object
    //   89: dup
    //   90: iconst_0
    //   91: lload_1
    //   92: invokestatic 66	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   95: aastore
    //   96: dup
    //   97: iconst_1
    //   98: iload_3
    //   99: invokestatic 71	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   102: aastore
    //   103: invokestatic 75	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   106: pop
    //   107: aload_0
    //   108: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   111: iconst_1
    //   112: invokestatic 79	com/google/android/gm/provider/MailEngine:access$3002	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   115: pop
    //   116: aload_0
    //   117: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   120: aconst_null
    //   121: iconst_0
    //   122: new 81	com/google/android/gm/provider/MailEngine$SyncInfo
    //   125: dup
    //   126: invokespecial 82	com/google/android/gm/provider/MailEngine$SyncInfo:<init>	()V
    //   129: aconst_null
    //   130: aconst_null
    //   131: invokestatic 86	com/google/android/gm/provider/MailEngine:access$3300	(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;ZLcom/google/android/gm/provider/MailEngine$SyncInfo;Landroid/content/SyncResult;Landroid/os/Bundle;)Z
    //   134: pop
    //   135: ldc 36
    //   137: ldc 88
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 91	com/google/android/gm/provider/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   146: pop
    //   147: aload 4
    //   149: monitorexit
    //   150: aload_0
    //   151: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   154: iconst_0
    //   155: invokestatic 95	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   158: aload_0
    //   159: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   162: iconst_0
    //   163: invokestatic 79	com/google/android/gm/provider/MailEngine:access$3002	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   166: pop
    //   167: aload_0
    //   168: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   171: iconst_1
    //   172: invokestatic 98	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   175: pop
    //   176: aload_0
    //   177: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   180: invokestatic 101	com/google/android/gm/provider/MailEngine:access$3400	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    //   183: astore 4
    //   185: aload 4
    //   187: monitorenter
    //   188: aload_0
    //   189: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   192: aconst_null
    //   193: invokestatic 105	com/google/android/gm/provider/MailEngine:access$3102	(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/Thread;)Ljava/lang/Thread;
    //   196: pop
    //   197: aload 4
    //   199: monitorexit
    //   200: return
    //   201: astore 5
    //   203: aload 4
    //   205: monitorexit
    //   206: aload 5
    //   208: athrow
    //   209: goto -188 -> 21
    //   212: iconst_0
    //   213: istore_3
    //   214: goto -168 -> 46
    //   217: lconst_0
    //   218: lstore_1
    //   219: iconst_0
    //   220: istore_3
    //   221: goto -175 -> 46
    //   224: astore 5
    //   226: aload 4
    //   228: monitorexit
    //   229: aload 5
    //   231: athrow
    //   232: astore 4
    //   234: ldc 36
    //   236: ldc 107
    //   238: iconst_1
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload 4
    //   246: invokevirtual 111	java/io/IOException:getMessage	()Ljava/lang/String;
    //   249: aastore
    //   250: invokestatic 114	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   253: pop
    //   254: aload_0
    //   255: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   258: iconst_1
    //   259: invokestatic 95	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   262: aload_0
    //   263: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   266: iconst_0
    //   267: invokestatic 79	com/google/android/gm/provider/MailEngine:access$3002	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   270: pop
    //   271: aload_0
    //   272: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   275: iconst_1
    //   276: invokestatic 98	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   279: pop
    //   280: aload_0
    //   281: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   284: invokestatic 101	com/google/android/gm/provider/MailEngine:access$3400	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    //   287: astore 4
    //   289: aload 4
    //   291: monitorenter
    //   292: aload_0
    //   293: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   296: aconst_null
    //   297: invokestatic 105	com/google/android/gm/provider/MailEngine:access$3102	(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/Thread;)Ljava/lang/Thread;
    //   300: pop
    //   301: aload 4
    //   303: monitorexit
    //   304: return
    //   305: astore 5
    //   307: aload 4
    //   309: monitorexit
    //   310: aload 5
    //   312: athrow
    //   313: astore 4
    //   315: ldc 36
    //   317: ldc 116
    //   319: iconst_1
    //   320: anewarray 4	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: aload 4
    //   327: invokevirtual 117	com/google/android/gm/provider/MailEngine$AuthenticationException:getMessage	()Ljava/lang/String;
    //   330: aastore
    //   331: invokestatic 114	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   334: pop
    //   335: aload_0
    //   336: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   339: iconst_2
    //   340: invokestatic 95	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   343: aload_0
    //   344: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   347: iconst_0
    //   348: invokestatic 79	com/google/android/gm/provider/MailEngine:access$3002	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   351: pop
    //   352: aload_0
    //   353: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   356: iconst_1
    //   357: invokestatic 98	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   360: pop
    //   361: aload_0
    //   362: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   365: invokestatic 101	com/google/android/gm/provider/MailEngine:access$3400	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    //   368: astore 4
    //   370: aload 4
    //   372: monitorenter
    //   373: aload_0
    //   374: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   377: aconst_null
    //   378: invokestatic 105	com/google/android/gm/provider/MailEngine:access$3102	(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/Thread;)Ljava/lang/Thread;
    //   381: pop
    //   382: aload 4
    //   384: monitorexit
    //   385: return
    //   386: astore 5
    //   388: aload 4
    //   390: monitorexit
    //   391: aload 5
    //   393: athrow
    //   394: astore 4
    //   396: ldc 36
    //   398: ldc 119
    //   400: iconst_1
    //   401: anewarray 4	java/lang/Object
    //   404: dup
    //   405: iconst_0
    //   406: aload 4
    //   408: invokevirtual 120	com/google/android/gm/provider/MailSync$ResponseParseException:getMessage	()Ljava/lang/String;
    //   411: aastore
    //   412: invokestatic 114	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   415: pop
    //   416: aload_0
    //   417: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   420: iconst_5
    //   421: invokestatic 95	com/google/android/gm/provider/MailEngine:access$300	(Lcom/google/android/gm/provider/MailEngine;I)V
    //   424: aload_0
    //   425: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   428: iconst_0
    //   429: invokestatic 79	com/google/android/gm/provider/MailEngine:access$3002	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   432: pop
    //   433: aload_0
    //   434: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   437: iconst_1
    //   438: invokestatic 98	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   441: pop
    //   442: aload_0
    //   443: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   446: invokestatic 101	com/google/android/gm/provider/MailEngine:access$3400	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    //   449: astore 4
    //   451: aload 4
    //   453: monitorenter
    //   454: aload_0
    //   455: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   458: aconst_null
    //   459: invokestatic 105	com/google/android/gm/provider/MailEngine:access$3102	(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/Thread;)Ljava/lang/Thread;
    //   462: pop
    //   463: aload 4
    //   465: monitorexit
    //   466: return
    //   467: astore 5
    //   469: aload 4
    //   471: monitorexit
    //   472: aload 5
    //   474: athrow
    //   475: astore 5
    //   477: aload_0
    //   478: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   481: iconst_0
    //   482: invokestatic 79	com/google/android/gm/provider/MailEngine:access$3002	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   485: pop
    //   486: aload_0
    //   487: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   490: iconst_1
    //   491: invokestatic 98	com/google/android/gm/provider/MailEngine:access$202	(Lcom/google/android/gm/provider/MailEngine;Z)Z
    //   494: pop
    //   495: aload_0
    //   496: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   499: invokestatic 101	com/google/android/gm/provider/MailEngine:access$3400	(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;
    //   502: astore 4
    //   504: aload 4
    //   506: monitorenter
    //   507: aload_0
    //   508: getfield 15	com/google/android/gm/provider/MailEngine$SyncThread:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   511: aconst_null
    //   512: invokestatic 105	com/google/android/gm/provider/MailEngine:access$3102	(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/Thread;)Ljava/lang/Thread;
    //   515: pop
    //   516: aload 4
    //   518: monitorexit
    //   519: aload 5
    //   521: athrow
    //   522: astore 5
    //   524: aload 4
    //   526: monitorexit
    //   527: aload 5
    //   529: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	SyncThread
    //   33	186	1	l	long
    //   45	176	3	bool	boolean
    //   232	13	4	localIOException	java.io.IOException
    //   313	13	4	localAuthenticationException	MailEngine.AuthenticationException
    //   394	13	4	localResponseParseException	MailSync.ResponseParseException
    //   201	6	5	localObject5	Object
    //   224	6	5	localObject6	Object
    //   305	6	5	localObject7	Object
    //   386	6	5	localObject8	Object
    //   467	6	5	localObject9	Object
    //   475	45	5	localObject10	Object
    //   522	6	5	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   188	200	201	finally
    //   203	206	201	finally
    //   58	73	224	finally
    //   81	107	224	finally
    //   107	150	224	finally
    //   226	229	224	finally
    //   21	44	232	java/io/IOException
    //   46	58	232	java/io/IOException
    //   150	158	232	java/io/IOException
    //   229	232	232	java/io/IOException
    //   292	304	305	finally
    //   307	310	305	finally
    //   21	44	313	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   46	58	313	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   150	158	313	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   229	232	313	com/google/android/gm/provider/MailEngine$AuthenticationException
    //   373	385	386	finally
    //   388	391	386	finally
    //   21	44	394	com/google/android/gm/provider/MailSync$ResponseParseException
    //   46	58	394	com/google/android/gm/provider/MailSync$ResponseParseException
    //   150	158	394	com/google/android/gm/provider/MailSync$ResponseParseException
    //   229	232	394	com/google/android/gm/provider/MailSync$ResponseParseException
    //   454	466	467	finally
    //   469	472	467	finally
    //   21	44	475	finally
    //   46	58	475	finally
    //   150	158	475	finally
    //   229	232	475	finally
    //   234	262	475	finally
    //   315	343	475	finally
    //   396	424	475	finally
    //   507	519	522	finally
    //   524	527	522	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.SyncThread
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */