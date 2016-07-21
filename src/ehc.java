import android.content.ContentResolver;
import android.os.AsyncTask;
import android.util.Log;

public final class ehc
  implements biv
{
  final eiz a;
  final ny<String, byte[]> b;
  final egv c;
  public boolean d = false;
  private final bij e;
  
  public ehc(eiz parameiz, ContentResolver paramContentResolver)
  {
    this(parameiz, paramContentResolver, (byte)0);
  }
  
  private ehc(eiz parameiz, ContentResolver paramContentResolver, byte paramByte)
  {
    a = parameiz;
    b = new ny(20);
    e = new bij(paramContentResolver);
    c = null;
  }
  
  /* Error */
  private static byte[] a(egv paramegv)
  {
    // Byte code:
    //   0: new 51	egy
    //   3: dup
    //   4: invokespecial 52	egy:<init>	()V
    //   7: pop
    //   8: aload_0
    //   9: invokeinterface 57 1 0
    //   14: ldc2_w 58
    //   17: getstatic 65	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   20: invokeinterface 70 4 0
    //   25: checkcast 72	egz
    //   28: astore_2
    //   29: aload_2
    //   30: getfield 75	egz:b	Landroid/os/ParcelFileDescriptor;
    //   33: astore_0
    //   34: aload_2
    //   35: getfield 78	egz:a	Lcom/google/android/gms/common/api/Status;
    //   38: astore_2
    //   39: aload_2
    //   40: getfield 84	com/google/android/gms/common/api/Status:g	I
    //   43: istore_1
    //   44: aload_2
    //   45: invokevirtual 87	com/google/android/gms/common/api/Status:b	()Z
    //   48: ifeq +7 -> 55
    //   51: aload_0
    //   52: ifnonnull +68 -> 120
    //   55: ldc 89
    //   57: iconst_3
    //   58: invokestatic 95	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   61: ifeq +57 -> 118
    //   64: aload_2
    //   65: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: astore_2
    //   69: aload_0
    //   70: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   73: astore_0
    //   74: new 103	java/lang/StringBuilder
    //   77: dup
    //   78: aload_2
    //   79: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 107	java/lang/String:length	()I
    //   85: bipush 27
    //   87: iadd
    //   88: aload_0
    //   89: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   92: invokevirtual 107	java/lang/String:length	()I
    //   95: iadd
    //   96: invokespecial 108	java/lang/StringBuilder:<init>	(I)V
    //   99: ldc 110
    //   101: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_2
    //   105: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 116
    //   110: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aconst_null
    //   119: areturn
    //   120: new 118	java/io/FileInputStream
    //   123: dup
    //   124: aload_0
    //   125: invokevirtual 124	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   128: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   131: astore 4
    //   133: sipush 16384
    //   136: newarray <illegal type>
    //   138: astore_3
    //   139: new 129	java/io/ByteArrayOutputStream
    //   142: dup
    //   143: invokespecial 130	java/io/ByteArrayOutputStream:<init>	()V
    //   146: astore_2
    //   147: aload_2
    //   148: astore_0
    //   149: aload 4
    //   151: aload_3
    //   152: invokevirtual 134	java/io/FileInputStream:read	([B)I
    //   155: istore_1
    //   156: iload_1
    //   157: iconst_m1
    //   158: if_icmpeq +42 -> 200
    //   161: aload_2
    //   162: astore_0
    //   163: aload_2
    //   164: aload_3
    //   165: iconst_0
    //   166: iload_1
    //   167: invokevirtual 138	java/io/ByteArrayOutputStream:write	([BII)V
    //   170: goto -23 -> 147
    //   173: astore_3
    //   174: aload_2
    //   175: astore_0
    //   176: ldc 89
    //   178: ldc -116
    //   180: aload_3
    //   181: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   184: pop
    //   185: aload 4
    //   187: invokevirtual 146	java/io/FileInputStream:close	()V
    //   190: aload_2
    //   191: ifnull +131 -> 322
    //   194: aload_2
    //   195: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   198: aconst_null
    //   199: areturn
    //   200: aload_2
    //   201: astore_0
    //   202: aload_2
    //   203: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   206: astore_3
    //   207: aload 4
    //   209: invokevirtual 146	java/io/FileInputStream:close	()V
    //   212: aload_2
    //   213: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   216: aload_3
    //   217: areturn
    //   218: astore_0
    //   219: ldc 89
    //   221: ldc -103
    //   223: aload_0
    //   224: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   227: pop
    //   228: aload_3
    //   229: areturn
    //   230: astore_0
    //   231: ldc 89
    //   233: ldc -101
    //   235: aload_0
    //   236: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   239: pop
    //   240: goto -28 -> 212
    //   243: astore_0
    //   244: ldc 89
    //   246: ldc -101
    //   248: aload_0
    //   249: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   252: pop
    //   253: goto -63 -> 190
    //   256: astore_0
    //   257: ldc 89
    //   259: ldc -103
    //   261: aload_0
    //   262: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   265: pop
    //   266: aconst_null
    //   267: areturn
    //   268: astore_2
    //   269: aconst_null
    //   270: astore_0
    //   271: aload 4
    //   273: invokevirtual 146	java/io/FileInputStream:close	()V
    //   276: aload_0
    //   277: ifnull +7 -> 284
    //   280: aload_0
    //   281: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   284: aload_2
    //   285: athrow
    //   286: astore_3
    //   287: ldc 89
    //   289: ldc -101
    //   291: aload_3
    //   292: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   295: pop
    //   296: goto -20 -> 276
    //   299: astore_0
    //   300: ldc 89
    //   302: ldc -103
    //   304: aload_0
    //   305: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   308: pop
    //   309: goto -25 -> 284
    //   312: astore_2
    //   313: goto -42 -> 271
    //   316: astore_3
    //   317: aconst_null
    //   318: astore_2
    //   319: goto -145 -> 174
    //   322: aconst_null
    //   323: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	paramegv	egv
    //   43	124	1	i	int
    //   28	185	2	localObject1	Object
    //   268	17	2	localObject2	Object
    //   312	1	2	localObject3	Object
    //   318	1	2	localObject4	Object
    //   138	27	3	arrayOfByte1	byte[]
    //   173	8	3	localIOException1	java.io.IOException
    //   206	23	3	arrayOfByte2	byte[]
    //   286	6	3	localIOException2	java.io.IOException
    //   316	1	3	localIOException3	java.io.IOException
    //   131	141	4	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   149	156	173	java/io/IOException
    //   163	170	173	java/io/IOException
    //   202	207	173	java/io/IOException
    //   212	216	218	java/io/IOException
    //   207	212	230	java/io/IOException
    //   185	190	243	java/io/IOException
    //   194	198	256	java/io/IOException
    //   133	147	268	finally
    //   271	276	286	java/io/IOException
    //   280	284	299	java/io/IOException
    //   149	156	312	finally
    //   163	170	312	finally
    //   176	185	312	finally
    //   202	207	312	finally
    //   133	147	316	java/io/IOException
  }
  
  /* Error */
  static byte[] a(eiz parameiz, egv paramegv, ehh paramehh)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 161 1 0
    //   6: ifne +14 -> 20
    //   9: aload_0
    //   10: invokeinterface 163 1 0
    //   15: ifne +5 -> 20
    //   18: aconst_null
    //   19: areturn
    //   20: aload_2
    //   21: getfield 169	ehh:q	Lcom/google/android/gms/people/model/AvatarReference;
    //   24: ifnonnull +15 -> 39
    //   27: aload_2
    //   28: getfield 173	ehh:r	Legw;
    //   31: ifnull -13 -> 18
    //   34: aload_1
    //   35: invokestatic 175	ehc:a	(Legv;)[B
    //   38: areturn
    //   39: new 177	frg
    //   42: dup
    //   43: invokespecial 178	frg:<init>	()V
    //   46: astore_1
    //   47: aload_1
    //   48: iconst_1
    //   49: putfield 180	frg:a	I
    //   52: aload_1
    //   53: iconst_1
    //   54: putfield 182	frg:b	I
    //   57: aload_1
    //   58: invokevirtual 185	frg:a	()Lfrf;
    //   61: astore_1
    //   62: getstatic 190	frm:g	Lfre;
    //   65: aload_0
    //   66: aload_2
    //   67: getfield 169	ehh:q	Lcom/google/android/gms/people/model/AvatarReference;
    //   70: aload_1
    //   71: invokeinterface 195 4 0
    //   76: ldc2_w 58
    //   79: getstatic 65	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   82: invokeinterface 70 4 0
    //   87: checkcast 197	frh
    //   90: astore_1
    //   91: aload_1
    //   92: invokeinterface 200 1 0
    //   97: astore_0
    //   98: aload_1
    //   99: invokeinterface 203 1 0
    //   104: astore_1
    //   105: aload_1
    //   106: getfield 84	com/google/android/gms/common/api/Status:g	I
    //   109: istore_3
    //   110: aload_1
    //   111: invokevirtual 87	com/google/android/gms/common/api/Status:b	()Z
    //   114: ifeq +7 -> 121
    //   117: aload_0
    //   118: ifnonnull +68 -> 186
    //   121: ldc 89
    //   123: iconst_3
    //   124: invokestatic 95	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   127: ifeq -109 -> 18
    //   130: aload_1
    //   131: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   134: astore_1
    //   135: aload_0
    //   136: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   139: astore_0
    //   140: new 103	java/lang/StringBuilder
    //   143: dup
    //   144: aload_1
    //   145: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   148: invokevirtual 107	java/lang/String:length	()I
    //   151: bipush 27
    //   153: iadd
    //   154: aload_0
    //   155: invokestatic 101	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokevirtual 107	java/lang/String:length	()I
    //   161: iadd
    //   162: invokespecial 108	java/lang/StringBuilder:<init>	(I)V
    //   165: ldc 110
    //   167: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: aload_1
    //   171: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 116
    //   176: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload_0
    //   180: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aconst_null
    //   185: areturn
    //   186: new 118	java/io/FileInputStream
    //   189: dup
    //   190: aload_0
    //   191: invokevirtual 124	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   194: invokespecial 127	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   197: astore 4
    //   199: sipush 16384
    //   202: newarray <illegal type>
    //   204: astore_2
    //   205: new 129	java/io/ByteArrayOutputStream
    //   208: dup
    //   209: invokespecial 130	java/io/ByteArrayOutputStream:<init>	()V
    //   212: astore_1
    //   213: aload_1
    //   214: astore_0
    //   215: aload 4
    //   217: aload_2
    //   218: invokevirtual 134	java/io/FileInputStream:read	([B)I
    //   221: istore_3
    //   222: iload_3
    //   223: iconst_m1
    //   224: if_icmpeq +44 -> 268
    //   227: aload_1
    //   228: astore_0
    //   229: aload_1
    //   230: aload_2
    //   231: iconst_0
    //   232: iload_3
    //   233: invokevirtual 138	java/io/ByteArrayOutputStream:write	([BII)V
    //   236: goto -23 -> 213
    //   239: astore_2
    //   240: aload_1
    //   241: astore_0
    //   242: ldc 89
    //   244: ldc -116
    //   246: aload_2
    //   247: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   250: pop
    //   251: aload 4
    //   253: invokevirtual 146	java/io/FileInputStream:close	()V
    //   256: aload_1
    //   257: ifnull +140 -> 397
    //   260: aload_1
    //   261: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   264: aconst_null
    //   265: astore_0
    //   266: aload_0
    //   267: areturn
    //   268: aload_1
    //   269: astore_0
    //   270: aload_1
    //   271: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   274: astore_2
    //   275: aload_2
    //   276: astore_0
    //   277: aload 4
    //   279: invokevirtual 146	java/io/FileInputStream:close	()V
    //   282: aload_1
    //   283: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   286: goto -20 -> 266
    //   289: astore_1
    //   290: ldc 89
    //   292: ldc -103
    //   294: aload_1
    //   295: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   298: pop
    //   299: goto -33 -> 266
    //   302: astore_2
    //   303: ldc 89
    //   305: ldc -101
    //   307: aload_2
    //   308: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   311: pop
    //   312: goto -30 -> 282
    //   315: astore_0
    //   316: ldc 89
    //   318: ldc -101
    //   320: aload_0
    //   321: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   324: pop
    //   325: goto -69 -> 256
    //   328: astore_0
    //   329: ldc 89
    //   331: ldc -103
    //   333: aload_0
    //   334: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   337: pop
    //   338: aconst_null
    //   339: astore_0
    //   340: goto -74 -> 266
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_0
    //   346: aload 4
    //   348: invokevirtual 146	java/io/FileInputStream:close	()V
    //   351: aload_0
    //   352: ifnull +7 -> 359
    //   355: aload_0
    //   356: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   359: aload_1
    //   360: athrow
    //   361: astore_2
    //   362: ldc 89
    //   364: ldc -101
    //   366: aload_2
    //   367: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   370: pop
    //   371: goto -20 -> 351
    //   374: astore_0
    //   375: ldc 89
    //   377: ldc -103
    //   379: aload_0
    //   380: invokestatic 143	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   383: pop
    //   384: goto -25 -> 359
    //   387: astore_1
    //   388: goto -42 -> 346
    //   391: astore_2
    //   392: aconst_null
    //   393: astore_1
    //   394: goto -154 -> 240
    //   397: aconst_null
    //   398: astore_0
    //   399: goto -133 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	402	0	parameiz	eiz
    //   0	402	1	paramegv	egv
    //   0	402	2	paramehh	ehh
    //   109	124	3	i	int
    //   197	150	4	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   215	222	239	java/io/IOException
    //   229	236	239	java/io/IOException
    //   270	275	239	java/io/IOException
    //   282	286	289	java/io/IOException
    //   277	282	302	java/io/IOException
    //   251	256	315	java/io/IOException
    //   260	264	328	java/io/IOException
    //   199	213	343	finally
    //   346	351	361	java/io/IOException
    //   355	359	374	java/io/IOException
    //   215	222	387	finally
    //   229	236	387	finally
    //   242	251	387	finally
    //   270	275	387	finally
    //   199	213	391	java/io/IOException
  }
  
  public final void a(bkn parambkn, biw parambiw)
  {
    if ((parambkn != null) && (!(parambkn instanceof ehh))) {
      e.a(parambkn, parambiw);
    }
    do
    {
      return;
      parambkn = (ehh)parambkn;
      if (parambkn != null) {
        break;
      }
      Log.wtf("GmsPhotoManager", "GmsRecipientEntry is null", new Error());
    } while (parambiw == null);
    parambiw.e();
    return;
    int i;
    if (d) {
      i = 1;
    }
    Object localObject;
    for (;;)
    {
      if (i == 0) {
        break label146;
      }
      if (parambiw == null) {
        break;
      }
      parambiw.c();
      return;
      localObject = p;
      if (localObject == null)
      {
        Log.wtf("GmsPhotoManager", "GmsRecipientEntry has no person key", new Error());
        i = 1;
      }
      else
      {
        localObject = (byte[])b.a(localObject);
        if (localObject != null)
        {
          parambkn.a((byte[])localObject);
          i = 1;
        }
        else
        {
          i = 0;
        }
      }
    }
    label146:
    if (Log.isLoggable("GmsPhotoManager", 3))
    {
      localObject = String.valueOf(c);
      new StringBuilder(String.valueOf(localObject).length() + 45).append("No photo cache for ").append((String)localObject).append(". Fetch one asynchronously");
    }
    new ehd(this, parambkn, parambiw).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
  }
}

/* Location:
 * Qualified Name:     ehc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */