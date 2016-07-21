import android.content.Context;

final class dsf
  implements Runnable
{
  dsf(drp paramdrp, Context paramContext) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 14	dsf:b	Ldrp;
    //   4: getfield 29	drp:r	Lduy;
    //   7: aload_0
    //   8: getfield 14	dsf:b	Ldrp;
    //   11: getfield 33	drp:A	Ldqv;
    //   14: invokevirtual 38	duy:a	(Ldvb;)V
    //   17: aload_0
    //   18: getfield 14	dsf:b	Ldrp;
    //   21: getfield 42	drp:o	Ldrj;
    //   24: invokevirtual 47	drj:l	()V
    //   27: aload_0
    //   28: getfield 14	dsf:b	Ldrp;
    //   31: invokevirtual 50	drp:m	()V
    //   34: aload_0
    //   35: getfield 14	dsf:b	Ldrp;
    //   38: getfield 29	drp:r	Lduy;
    //   41: invokevirtual 53	duy:c	()V
    //   44: aload_0
    //   45: getfield 14	dsf:b	Ldrp;
    //   48: getfield 29	drp:r	Lduy;
    //   51: invokevirtual 56	duy:d	()V
    //   54: aload_0
    //   55: getfield 16	dsf:a	Landroid/content/Context;
    //   58: ldc 58
    //   60: invokevirtual 64	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   63: checkcast 66	android/os/PowerManager
    //   66: astore_3
    //   67: aload_3
    //   68: ifnull +28 -> 96
    //   71: aload_0
    //   72: getfield 14	dsf:b	Ldrp;
    //   75: aload_3
    //   76: iconst_1
    //   77: ldc 68
    //   79: invokevirtual 72	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   82: putfield 76	drp:S	Landroid/os/PowerManager$WakeLock;
    //   85: aload_0
    //   86: getfield 14	dsf:b	Ldrp;
    //   89: getfield 76	drp:S	Landroid/os/PowerManager$WakeLock;
    //   92: iconst_0
    //   93: invokevirtual 82	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   96: aload_0
    //   97: getfield 14	dsf:b	Ldrp;
    //   100: invokevirtual 85	drp:J	()V
    //   103: aload_0
    //   104: getfield 14	dsf:b	Ldrp;
    //   107: getfield 88	drp:l	Landroid/accounts/Account;
    //   110: getfield 94	android/accounts/Account:name	Ljava/lang/String;
    //   113: aload_0
    //   114: getfield 14	dsf:b	Ldrp;
    //   117: invokevirtual 98	drp:n	()Landroid/database/Cursor;
    //   120: invokestatic 103	dyx:a	(Ljava/lang/String;Landroid/database/Cursor;)V
    //   123: aload_0
    //   124: getfield 14	dsf:b	Ldrp;
    //   127: getfield 88	drp:l	Landroid/accounts/Account;
    //   130: getfield 94	android/accounts/Account:name	Ljava/lang/String;
    //   133: invokestatic 108	com/google/android/gm/provider/GmailProvider:b	(Ljava/lang/String;)Landroid/net/Uri;
    //   136: astore_3
    //   137: aload_3
    //   138: aload_0
    //   139: getfield 14	dsf:b	Ldrp;
    //   142: getfield 42	drp:o	Ldrj;
    //   145: invokevirtual 110	drj:c	()Landroid/database/Cursor;
    //   148: invokestatic 115	dyr:a	(Landroid/net/Uri;Landroid/database/Cursor;)V
    //   151: aload_3
    //   152: aload_0
    //   153: getfield 14	dsf:b	Ldrp;
    //   156: invokevirtual 117	drp:o	()Landroid/database/Cursor;
    //   159: invokestatic 119	dyr:b	(Landroid/net/Uri;Landroid/database/Cursor;)V
    //   162: aload_0
    //   163: getfield 14	dsf:b	Ldrp;
    //   166: getfield 42	drp:o	Ldrj;
    //   169: invokevirtual 122	drj:d	()Ljava/lang/String;
    //   172: pop
    //   173: aload_0
    //   174: getfield 14	dsf:b	Ldrp;
    //   177: astore_3
    //   178: aload_3
    //   179: getfield 126	drp:E	Ljava/lang/Object;
    //   182: astore 4
    //   184: aload 4
    //   186: monitorenter
    //   187: aload_3
    //   188: iconst_1
    //   189: putfield 130	drp:C	Z
    //   192: aload_3
    //   193: getfield 134	drp:D	Ljava/util/List;
    //   196: ifnull +82 -> 278
    //   199: aload_3
    //   200: getfield 134	drp:D	Ljava/util/List;
    //   203: invokeinterface 140 1 0
    //   208: istore_2
    //   209: iconst_0
    //   210: istore_1
    //   211: iload_1
    //   212: iload_2
    //   213: if_icmpge +60 -> 273
    //   216: aload_3
    //   217: getfield 134	drp:D	Ljava/util/List;
    //   220: iload_1
    //   221: invokeinterface 144 2 0
    //   226: checkcast 146	android/util/Pair
    //   229: astore 5
    //   231: aload 5
    //   233: getfield 149	android/util/Pair:first	Ljava/lang/Object;
    //   236: checkcast 151	android/os/Handler
    //   239: aload 5
    //   241: getfield 154	android/util/Pair:second	Ljava/lang/Object;
    //   244: checkcast 156	dss
    //   247: invokestatic 159	drp:b	(Landroid/os/Handler;Ldss;)V
    //   250: iload_1
    //   251: iconst_1
    //   252: iadd
    //   253: istore_1
    //   254: goto -43 -> 211
    //   257: astore_3
    //   258: aload_0
    //   259: getfield 14	dsf:b	Ldrp;
    //   262: getfield 29	drp:r	Lduy;
    //   265: invokevirtual 56	duy:d	()V
    //   268: aload_3
    //   269: athrow
    //   270: astore_3
    //   271: aload_3
    //   272: athrow
    //   273: aload_3
    //   274: aconst_null
    //   275: putfield 134	drp:D	Ljava/util/List;
    //   278: aload 4
    //   280: monitorexit
    //   281: aload_3
    //   282: invokevirtual 85	drp:J	()V
    //   285: aload_3
    //   286: getfield 88	drp:l	Landroid/accounts/Account;
    //   289: getfield 94	android/accounts/Account:name	Ljava/lang/String;
    //   292: aload_3
    //   293: invokevirtual 98	drp:n	()Landroid/database/Cursor;
    //   296: invokestatic 103	dyx:a	(Ljava/lang/String;Landroid/database/Cursor;)V
    //   299: aload_3
    //   300: getfield 88	drp:l	Landroid/accounts/Account;
    //   303: getfield 94	android/accounts/Account:name	Ljava/lang/String;
    //   306: invokestatic 108	com/google/android/gm/provider/GmailProvider:b	(Ljava/lang/String;)Landroid/net/Uri;
    //   309: astore 4
    //   311: aload 4
    //   313: aload_3
    //   314: getfield 42	drp:o	Ldrj;
    //   317: invokevirtual 110	drj:c	()Landroid/database/Cursor;
    //   320: invokestatic 115	dyr:a	(Landroid/net/Uri;Landroid/database/Cursor;)V
    //   323: aload 4
    //   325: aload_3
    //   326: invokevirtual 117	drp:o	()Landroid/database/Cursor;
    //   329: invokestatic 119	dyr:b	(Landroid/net/Uri;Landroid/database/Cursor;)V
    //   332: aload_3
    //   333: getfield 88	drp:l	Landroid/accounts/Account;
    //   336: getfield 94	android/accounts/Account:name	Ljava/lang/String;
    //   339: aload_3
    //   340: aconst_null
    //   341: aconst_null
    //   342: invokevirtual 162	drp:a	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   345: invokestatic 165	dyy:a	(Ljava/lang/String;Landroid/database/Cursor;)V
    //   348: invokestatic 169	dmt:b	()V
    //   351: return
    //   352: astore_3
    //   353: aload 4
    //   355: monitorexit
    //   356: aload_3
    //   357: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	dsf
    //   210	44	1	i	int
    //   208	6	2	j	int
    //   66	151	3	localObject1	Object
    //   257	12	3	localObject2	Object
    //   270	70	3	localSQLException	android.database.SQLException
    //   352	5	3	localObject3	Object
    //   229	11	5	localPair	android.util.Pair
    // Exception table:
    //   from	to	target	type
    //   17	44	257	finally
    //   0	17	270	android/database/SQLException
    //   44	54	270	android/database/SQLException
    //   258	270	270	android/database/SQLException
    //   187	209	352	finally
    //   216	250	352	finally
    //   273	278	352	finally
    //   278	281	352	finally
    //   353	356	352	finally
  }
}

/* Location:
 * Qualified Name:     dsf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */