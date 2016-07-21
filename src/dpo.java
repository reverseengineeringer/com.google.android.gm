import android.text.TextUtils;
import android.text.TextUtils.SimpleStringSplitter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public final class dpo
{
  public static final TextUtils.SimpleStringSplitter a = new TextUtils.SimpleStringSplitter(cxa.a.charValue());
  public static final cwi<List<String>> b = new cwi(new dpp());
  final duq c = new duq();
  boolean d = false;
  boolean e = false;
  
  public static gzn a(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (gzn)hlt.a(new gzn(), paramArrayOfByte, paramArrayOfByte.length);
      return paramArrayOfByte;
    }
    catch (IOException paramArrayOfByte)
    {
      dri.e("Gmail", paramArrayOfByte, "Unable to read sender instructions protobuf", new Object[0]);
    }
    return null;
  }
  
  private static String a(String paramString)
  {
    int m = 0;
    Object localObject1 = hbw.a(paramString).trim();
    paramString = (String)localObject1;
    if (((String)localObject1).startsWith("\""))
    {
      paramString = (String)localObject1;
      if (((String)localObject1).endsWith("\""))
      {
        paramString = (String)localObject1;
        if (((String)localObject1).length() >= 2) {
          paramString = ((String)localObject1).substring(1, ((String)localObject1).length() - 1).trim();
        }
      }
    }
    int n = paramString.indexOf(',');
    int j;
    int i;
    if ((n != -1) && (n != paramString.length() - 1))
    {
      localObject1 = TextUtils.split(paramString.substring(0, n), "\\s+");
      int i1 = localObject1.length;
      j = 0;
      int k;
      for (i = 0;; i = k)
      {
        k = i;
        if (j >= i1) {
          break;
        }
        k = i;
        if (!localObject1[j].endsWith("."))
        {
          i += 1;
          k = i;
          if (i >= 2) {
            break;
          }
          k = i;
        }
        j += 1;
      }
      if (k != 1) {}
    }
    for (localObject1 = paramString.substring(n + 1).trim();; localObject1 = paramString)
    {
      Object localObject2 = localObject1;
      if (((String)localObject1).toLowerCase(Locale.ENGLISH).startsWith("the ")) {
        localObject2 = ((String)localObject1).substring(4).trim();
      }
      localObject2 = TextUtils.split((String)localObject2, "\\s+");
      j = localObject2.length;
      i = m;
      for (;;)
      {
        localObject1 = paramString;
        if (i < j)
        {
          localObject1 = localObject2[i];
          if (((String)localObject1).endsWith(".")) {}
        }
        else
        {
          return (String)localObject1;
        }
        i += 1;
      }
    }
  }
  
  public static void a(gzn paramgzn, duq paramduq)
  {
    if (c.length == 1) {}
    Object localObject;
    dur localdur;
    for (int i = 1;; i = 0)
    {
      gzo[] arrayOfgzo = c;
      int m = arrayOfgzo.length;
      int j = 0;
      for (;;)
      {
        if (j >= m) {
          break label288;
        }
        localObject = arrayOfgzo[j];
        localdur = new dur();
        if ((!b) || (i != 0)) {
          break;
        }
        a = e;
        d = 2;
        paramduq.a("e", null, false, false, false, -1, 0);
        j += 1;
      }
    }
    c = c;
    e = d;
    a = e;
    int k;
    label141:
    label176:
    label188:
    String str;
    boolean bool2;
    if ((a & 0x10) != 0)
    {
      k = 1;
      if (k != 0) {
        b = f;
      }
      d = 0;
      if ((a & 0x20) == 0) {
        break label270;
      }
      k = 1;
      if (k == 0) {
        break label276;
      }
      k = g;
      f = k;
      localObject = a;
      str = b;
      bool2 = c;
      if ((a == null) || (a.length() != 0)) {
        break label282;
      }
    }
    label270:
    label276:
    label282:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramduq.a((String)localObject, str, false, bool2, bool1, e, f);
      break;
      k = 0;
      break label141;
      k = 0;
      break label176;
      k = 0;
      break label188;
    }
    label288:
    d = a;
    c = b;
    paramduq.b();
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte, duq paramduq, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: new 186	java/io/DataInputStream
    //   6: dup
    //   7: new 188	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 191	java/io/ByteArrayInputStream:<init>	([B)V
    //   15: invokespecial 194	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   18: astore 9
    //   20: aload_1
    //   21: aload 9
    //   23: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   26: putfield 177	duq:d	I
    //   29: aload_1
    //   30: aload 9
    //   32: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   35: putfield 181	duq:c	I
    //   38: aload 9
    //   40: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   43: istore 5
    //   45: iconst_0
    //   46: istore_3
    //   47: iload_3
    //   48: iload 5
    //   50: if_icmpge +119 -> 169
    //   53: aload 9
    //   55: invokevirtual 201	java/io/DataInputStream:readBoolean	()Z
    //   58: istore 7
    //   60: aload 9
    //   62: invokevirtual 201	java/io/DataInputStream:readBoolean	()Z
    //   65: istore 8
    //   67: aload 9
    //   69: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   72: istore 6
    //   74: aload 9
    //   76: invokevirtual 204	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   79: astore_0
    //   80: aload 9
    //   82: invokevirtual 204	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   85: astore 10
    //   87: iload_2
    //   88: ifeq +182 -> 270
    //   91: aload 9
    //   93: invokevirtual 197	java/io/DataInputStream:readInt	()I
    //   96: istore 4
    //   98: iload 5
    //   100: iconst_1
    //   101: if_icmple +24 -> 125
    //   104: iload 7
    //   106: ifeq +19 -> 125
    //   109: aload_1
    //   110: ldc -102
    //   112: aconst_null
    //   113: iconst_0
    //   114: iconst_0
    //   115: iconst_0
    //   116: iconst_m1
    //   117: iload 4
    //   119: invokevirtual 157	duq:a	(Ljava/lang/String;Ljava/lang/String;ZZZII)V
    //   122: goto +141 -> 263
    //   125: aload_1
    //   126: aload_0
    //   127: aload 10
    //   129: iconst_0
    //   130: iload 8
    //   132: iconst_0
    //   133: iload 6
    //   135: iload 4
    //   137: invokevirtual 157	duq:a	(Ljava/lang/String;Ljava/lang/String;ZZZII)V
    //   140: goto +123 -> 263
    //   143: astore_1
    //   144: aload 9
    //   146: astore_0
    //   147: ldc -50
    //   149: aload_1
    //   150: ldc -48
    //   152: iconst_0
    //   153: anewarray 4	java/lang/Object
    //   156: invokestatic 77	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   159: pop
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 211	java/io/DataInputStream:close	()V
    //   168: return
    //   169: aload_1
    //   170: invokevirtual 183	duq:b	()V
    //   173: aload 9
    //   175: invokevirtual 211	java/io/DataInputStream:close	()V
    //   178: return
    //   179: astore_0
    //   180: ldc -50
    //   182: aload_0
    //   183: ldc -43
    //   185: iconst_0
    //   186: anewarray 4	java/lang/Object
    //   189: invokestatic 77	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   192: pop
    //   193: return
    //   194: astore_0
    //   195: ldc -50
    //   197: aload_0
    //   198: ldc -43
    //   200: iconst_0
    //   201: anewarray 4	java/lang/Object
    //   204: invokestatic 77	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   207: pop
    //   208: return
    //   209: astore_0
    //   210: aconst_null
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull +7 -> 220
    //   216: aload_1
    //   217: invokevirtual 211	java/io/DataInputStream:close	()V
    //   220: aload_0
    //   221: athrow
    //   222: astore_1
    //   223: ldc -50
    //   225: aload_1
    //   226: ldc -43
    //   228: iconst_0
    //   229: anewarray 4	java/lang/Object
    //   232: invokestatic 77	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   235: pop
    //   236: goto -16 -> 220
    //   239: astore_0
    //   240: aload 9
    //   242: astore_1
    //   243: goto -31 -> 212
    //   246: astore 9
    //   248: aload_0
    //   249: astore_1
    //   250: aload 9
    //   252: astore_0
    //   253: goto -41 -> 212
    //   256: astore_1
    //   257: aload 10
    //   259: astore_0
    //   260: goto -113 -> 147
    //   263: iload_3
    //   264: iconst_1
    //   265: iadd
    //   266: istore_3
    //   267: goto -220 -> 47
    //   270: iconst_0
    //   271: istore 4
    //   273: goto -175 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramArrayOfByte	byte[]
    //   0	276	1	paramduq	duq
    //   0	276	2	paramBoolean	boolean
    //   46	221	3	i	int
    //   96	176	4	j	int
    //   43	59	5	k	int
    //   72	62	6	m	int
    //   58	47	7	bool1	boolean
    //   65	66	8	bool2	boolean
    //   18	223	9	localDataInputStream	java.io.DataInputStream
    //   246	5	9	localObject	Object
    //   1	257	10	str	String
    // Exception table:
    //   from	to	target	type
    //   20	45	143	java/io/IOException
    //   53	87	143	java/io/IOException
    //   91	98	143	java/io/IOException
    //   109	122	143	java/io/IOException
    //   125	140	143	java/io/IOException
    //   169	173	143	java/io/IOException
    //   173	178	179	java/io/IOException
    //   164	168	194	java/io/IOException
    //   3	20	209	finally
    //   216	220	222	java/io/IOException
    //   20	45	239	finally
    //   53	87	239	finally
    //   91	98	239	finally
    //   109	122	239	finally
    //   125	140	239	finally
    //   169	173	239	finally
    //   147	160	246	finally
    //   3	20	256	java/io/IOException
  }
  
  /* Error */
  public static byte[] a(duq paramduq)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 183	duq:b	()V
    //   4: new 216	java/io/ByteArrayOutputStream
    //   7: dup
    //   8: invokespecial 217	java/io/ByteArrayOutputStream:<init>	()V
    //   11: astore 6
    //   13: aconst_null
    //   14: astore 5
    //   16: new 219	java/io/DataOutputStream
    //   19: dup
    //   20: aload 6
    //   22: invokespecial 222	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   25: astore 4
    //   27: aload 4
    //   29: aload_0
    //   30: getfield 177	duq:d	I
    //   33: invokevirtual 226	java/io/DataOutputStream:writeInt	(I)V
    //   36: aload 4
    //   38: aload_0
    //   39: getfield 181	duq:c	I
    //   42: invokevirtual 226	java/io/DataOutputStream:writeInt	(I)V
    //   45: aload_0
    //   46: getfield 229	duq:a	Ljava/util/List;
    //   49: astore 8
    //   51: aload_0
    //   52: getfield 230	duq:b	I
    //   55: iconst_1
    //   56: if_icmple +392 -> 448
    //   59: iconst_1
    //   60: istore_2
    //   61: new 232	gpi
    //   64: dup
    //   65: invokespecial 233	gpi:<init>	()V
    //   68: astore 5
    //   70: new 235	gpw
    //   73: dup
    //   74: invokespecial 236	gpw:<init>	()V
    //   77: astore 7
    //   79: aload 8
    //   81: invokeinterface 242 1 0
    //   86: astore_0
    //   87: iconst_0
    //   88: istore_1
    //   89: aload_0
    //   90: invokeinterface 247 1 0
    //   95: ifeq +26 -> 121
    //   98: aload_0
    //   99: invokeinterface 251 1 0
    //   104: checkcast 140	dur
    //   107: getfield 153	dur:d	I
    //   110: iconst_1
    //   111: if_icmpeq +334 -> 445
    //   114: iload_1
    //   115: iconst_1
    //   116: iadd
    //   117: istore_1
    //   118: goto +327 -> 445
    //   121: aload 4
    //   123: iload_1
    //   124: invokevirtual 226	java/io/DataOutputStream:writeInt	(I)V
    //   127: aload 8
    //   129: invokeinterface 242 1 0
    //   134: astore 8
    //   136: aload 8
    //   138: invokeinterface 247 1 0
    //   143: ifeq +199 -> 342
    //   146: aload 8
    //   148: invokeinterface 251 1 0
    //   153: checkcast 140	dur
    //   156: astore 9
    //   158: aload 9
    //   160: getfield 153	dur:d	I
    //   163: iconst_1
    //   164: if_icmpeq -28 -> 136
    //   167: aload 9
    //   169: getfield 153	dur:d	I
    //   172: iconst_2
    //   173: if_icmpne +123 -> 296
    //   176: iconst_1
    //   177: istore_3
    //   178: aload 4
    //   180: iload_3
    //   181: invokevirtual 255	java/io/DataOutputStream:writeBoolean	(Z)V
    //   184: aload 4
    //   186: aload 9
    //   188: getfield 160	dur:c	Z
    //   191: invokevirtual 255	java/io/DataOutputStream:writeBoolean	(Z)V
    //   194: aload 4
    //   196: aload 9
    //   198: getfield 163	dur:e	I
    //   201: invokevirtual 226	java/io/DataOutputStream:writeInt	(I)V
    //   204: aload 9
    //   206: getfield 153	dur:d	I
    //   209: iconst_2
    //   210: if_icmpne +91 -> 301
    //   213: ldc -102
    //   215: astore_0
    //   216: aload 4
    //   218: aload_0
    //   219: invokevirtual 259	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   222: aload 9
    //   224: getfield 170	dur:b	Ljava/lang/String;
    //   227: ifnull +108 -> 335
    //   230: aload 9
    //   232: getfield 170	dur:b	Ljava/lang/String;
    //   235: invokestatic 264	dpy:h	(Ljava/lang/String;)Ljava/lang/String;
    //   238: astore_0
    //   239: aload 4
    //   241: aload_0
    //   242: invokevirtual 259	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   245: aload 4
    //   247: aload 9
    //   249: getfield 175	dur:f	I
    //   252: invokevirtual 226	java/io/DataOutputStream:writeInt	(I)V
    //   255: goto -119 -> 136
    //   258: astore 5
    //   260: aload 4
    //   262: astore_0
    //   263: aload 5
    //   265: astore 4
    //   267: ldc -50
    //   269: aload 4
    //   271: ldc_w 266
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 77	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   281: pop
    //   282: aload_0
    //   283: ifnull +7 -> 290
    //   286: aload_0
    //   287: invokevirtual 267	java/io/DataOutputStream:close	()V
    //   290: aload 6
    //   292: invokevirtual 271	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   295: areturn
    //   296: iconst_0
    //   297: istore_3
    //   298: goto -120 -> 178
    //   301: iload_2
    //   302: ifeq +24 -> 326
    //   305: aload 9
    //   307: getfield 150	dur:a	Ljava/lang/String;
    //   310: invokestatic 272	dpo:a	(Ljava/lang/String;)Ljava/lang/String;
    //   313: astore_0
    //   314: aload_0
    //   315: aload 5
    //   317: aload 7
    //   319: invokestatic 275	cxa:a	(Ljava/lang/String;Lgpi;Lgpw;)Ljava/lang/String;
    //   322: astore_0
    //   323: goto -107 -> 216
    //   326: aload 9
    //   328: getfield 150	dur:a	Ljava/lang/String;
    //   331: astore_0
    //   332: goto -18 -> 314
    //   335: ldc_w 277
    //   338: astore_0
    //   339: goto -100 -> 239
    //   342: aload 4
    //   344: invokevirtual 267	java/io/DataOutputStream:close	()V
    //   347: goto -57 -> 290
    //   350: astore_0
    //   351: ldc -50
    //   353: aload_0
    //   354: ldc_w 279
    //   357: iconst_0
    //   358: anewarray 4	java/lang/Object
    //   361: invokestatic 77	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   364: pop
    //   365: goto -75 -> 290
    //   368: astore_0
    //   369: ldc -50
    //   371: aload_0
    //   372: ldc_w 279
    //   375: iconst_0
    //   376: anewarray 4	java/lang/Object
    //   379: invokestatic 77	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   382: pop
    //   383: goto -93 -> 290
    //   386: astore_0
    //   387: aconst_null
    //   388: astore 4
    //   390: aload 4
    //   392: ifnull +8 -> 400
    //   395: aload 4
    //   397: invokevirtual 267	java/io/DataOutputStream:close	()V
    //   400: aload_0
    //   401: athrow
    //   402: astore 4
    //   404: ldc -50
    //   406: aload 4
    //   408: ldc_w 279
    //   411: iconst_0
    //   412: anewarray 4	java/lang/Object
    //   415: invokestatic 77	dri:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   418: pop
    //   419: goto -19 -> 400
    //   422: astore_0
    //   423: goto -33 -> 390
    //   426: astore 5
    //   428: aload_0
    //   429: astore 4
    //   431: aload 5
    //   433: astore_0
    //   434: goto -44 -> 390
    //   437: astore 4
    //   439: aload 5
    //   441: astore_0
    //   442: goto -175 -> 267
    //   445: goto -356 -> 89
    //   448: iconst_0
    //   449: istore_2
    //   450: goto -389 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramduq	duq
    //   88	36	1	i	int
    //   60	390	2	j	int
    //   177	121	3	bool	boolean
    //   25	371	4	localObject1	Object
    //   402	5	4	localIOException1	IOException
    //   429	1	4	localduq	duq
    //   437	1	4	localIOException2	IOException
    //   14	55	5	localgpi	gpi
    //   258	58	5	localIOException3	IOException
    //   426	14	5	localObject2	Object
    //   11	280	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   77	241	7	localgpw	gpw
    //   49	98	8	localObject3	Object
    //   156	171	9	localdur	dur
    // Exception table:
    //   from	to	target	type
    //   27	59	258	java/io/IOException
    //   61	87	258	java/io/IOException
    //   89	114	258	java/io/IOException
    //   121	136	258	java/io/IOException
    //   136	176	258	java/io/IOException
    //   178	213	258	java/io/IOException
    //   216	239	258	java/io/IOException
    //   239	255	258	java/io/IOException
    //   305	314	258	java/io/IOException
    //   314	323	258	java/io/IOException
    //   326	332	258	java/io/IOException
    //   342	347	350	java/io/IOException
    //   286	290	368	java/io/IOException
    //   16	27	386	finally
    //   395	400	402	java/io/IOException
    //   27	59	422	finally
    //   61	87	422	finally
    //   89	114	422	finally
    //   121	136	422	finally
    //   136	176	422	finally
    //   178	213	422	finally
    //   216	239	422	finally
    //   239	255	422	finally
    //   305	314	422	finally
    //   314	323	422	finally
    //   326	332	422	finally
    //   267	282	426	finally
    //   16	27	437	java/io/IOException
  }
  
  public static byte[] a(gzn paramgzn)
  {
    duq localduq = new duq();
    a(paramgzn, localduq);
    return a(localduq);
  }
}

/* Location:
 * Qualified Name:     dpo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */