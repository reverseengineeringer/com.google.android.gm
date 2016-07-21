import android.content.Context;
import android.os.RemoteException;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Attachment;
import com.android.emailcommon.provider.Policy;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.http.HttpEntity;

public final class bpt
  extends bqc
{
  private final bfb a;
  private final long b;
  private final Policy c;
  private Attachment d;
  private beb e;
  
  public bpt(Context paramContext, Account paramAccount, long paramLong, bfb parambfb)
  {
    super(paramContext, paramAccount);
    a = parambfb;
    b = paramLong;
    if (o != 0L)
    {
      c = Policy.a(f, o);
      return;
    }
    c = null;
  }
  
  public static void a(bfb parambfb, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    if (parambfb != null) {}
    try
    {
      parambfb.a(paramLong1, paramLong2, paramInt1, paramInt2);
      return;
    }
    catch (RemoteException parambfb)
    {
      cvm.e("Exchange", "RemoteException in loadAttachment: %s", new Object[] { parambfb.getMessage() });
    }
  }
  
  private static void a(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      cvm.e("Exchange", "IOException while cleaning up attachment: %s", new Object[] { paramCloseable.getMessage() });
    }
  }
  
  private final boolean a(Attachment paramAttachment, File paramFile)
  {
    try
    {
      paramFile = new FileInputStream(paramFile);
      bgt.a(f, paramFile, paramAttachment);
      a(paramFile);
      return true;
    }
    catch (FileNotFoundException paramAttachment)
    {
      cvm.e("Exchange", "Could not open attachment file: %s", new Object[] { paramAttachment.getMessage() });
    }
    return false;
  }
  
  /* Error */
  protected final int a(bns parambns)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_1
    //   3: invokevirtual 99	bns:e	()Z
    //   6: ifeq +18 -> 24
    //   9: ldc 50
    //   11: ldc 101
    //   13: iconst_0
    //   14: anewarray 54	java/lang/Object
    //   17: invokestatic 63	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   20: pop
    //   21: bipush -4
    //   23: ireturn
    //   24: aload_1
    //   25: getfield 104	bns:b	I
    //   28: sipush 413
    //   31: if_icmpne +54 -> 85
    //   34: iconst_1
    //   35: istore_2
    //   36: iload_2
    //   37: ifeq +53 -> 90
    //   40: ldc 50
    //   42: ldc 106
    //   44: iconst_1
    //   45: anewarray 54	java/lang/Object
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: getfield 23	bpt:b	J
    //   54: invokestatic 112	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   57: aastore
    //   58: invokestatic 114	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   61: pop
    //   62: aload_0
    //   63: getfield 21	bpt:a	Lbfb;
    //   66: aload_0
    //   67: getfield 116	bpt:d	Lcom/android/emailcommon/provider/Attachment;
    //   70: getfield 119	com/android/emailcommon/provider/Attachment:o	J
    //   73: aload_0
    //   74: getfield 23	bpt:b	J
    //   77: bipush 40
    //   79: iconst_0
    //   80: invokestatic 121	bpt:a	(Lbfb;JJII)V
    //   83: iconst_1
    //   84: ireturn
    //   85: iconst_0
    //   86: istore_2
    //   87: goto -51 -> 36
    //   90: ldc 123
    //   92: ldc 125
    //   94: aload_0
    //   95: getfield 32	bpt:f	Landroid/content/Context;
    //   98: invokevirtual 131	android/content/Context:getCacheDir	()Ljava/io/File;
    //   101: invokestatic 137	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   104: astore 7
    //   106: new 139	java/io/FileOutputStream
    //   109: dup
    //   110: aload 7
    //   112: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   115: astore 8
    //   117: aload_1
    //   118: invokevirtual 143	bns:d	()Ljava/io/InputStream;
    //   121: astore 9
    //   123: new 145	bpv
    //   126: dup
    //   127: aload_0
    //   128: getfield 21	bpt:a	Lbfb;
    //   131: aload_0
    //   132: getfield 116	bpt:d	Lcom/android/emailcommon/provider/Attachment;
    //   135: invokespecial 148	bpv:<init>	(Lbfb;Lcom/android/emailcommon/provider/Attachment;)V
    //   138: astore 10
    //   140: aload_0
    //   141: getfield 152	bqc:h	Lbrt;
    //   144: getfield 157	brt:e	D
    //   147: ldc2_w 158
    //   150: dcmpl
    //   151: iflt +131 -> 282
    //   154: new 161	bos
    //   157: dup
    //   158: aload 9
    //   160: aload 8
    //   162: aload_0
    //   163: getfield 116	bpt:d	Lcom/android/emailcommon/provider/Attachment;
    //   166: getfield 164	com/android/emailcommon/provider/Attachment:k	J
    //   169: aload 10
    //   171: invokespecial 167	bos:<init>	(Ljava/io/InputStream;Ljava/io/OutputStream;JLbpv;)V
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 169	bos:d	()Z
    //   179: pop
    //   180: aload_1
    //   181: getfield 171	bos:a	I
    //   184: iconst_1
    //   185: if_icmpne +92 -> 277
    //   188: iload_3
    //   189: istore_2
    //   190: iload_2
    //   191: ifne +337 -> 528
    //   194: ldc 50
    //   196: ldc -83
    //   198: iconst_0
    //   199: anewarray 54	java/lang/Object
    //   202: invokestatic 63	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   205: pop
    //   206: aload 9
    //   208: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   211: aload 8
    //   213: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   216: aload 7
    //   218: invokevirtual 176	java/io/File:delete	()Z
    //   221: pop
    //   222: bipush -104
    //   224: ireturn
    //   225: astore_1
    //   226: ldc 50
    //   228: ldc -78
    //   230: iconst_1
    //   231: anewarray 54	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload_1
    //   237: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   240: aastore
    //   241: invokestatic 63	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   244: pop
    //   245: bipush -4
    //   247: ireturn
    //   248: astore_1
    //   249: ldc 50
    //   251: ldc -76
    //   253: iconst_1
    //   254: anewarray 54	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: aload_1
    //   260: invokevirtual 93	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 63	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   267: pop
    //   268: aload 7
    //   270: invokevirtual 176	java/io/File:delete	()Z
    //   273: pop
    //   274: bipush -103
    //   276: ireturn
    //   277: iconst_0
    //   278: istore_2
    //   279: goto -89 -> 190
    //   282: aload_1
    //   283: getfield 181	bns:a	I
    //   286: istore_2
    //   287: iload_2
    //   288: ifeq +27 -> 315
    //   291: iload_2
    //   292: ifge +229 -> 521
    //   295: aload_0
    //   296: getfield 116	bpt:d	Lcom/android/emailcommon/provider/Attachment;
    //   299: getfield 164	com/android/emailcommon/provider/Attachment:k	J
    //   302: lstore 4
    //   304: aload 9
    //   306: aload 8
    //   308: lload 4
    //   310: aload 10
    //   312: invokestatic 183	bos:a	(Ljava/io/InputStream;Ljava/io/OutputStream;JLbpv;)V
    //   315: ldc -71
    //   317: aload_0
    //   318: getfield 116	bpt:d	Lcom/android/emailcommon/provider/Attachment;
    //   321: getfield 189	com/android/emailcommon/provider/Attachment:j	Ljava/lang/String;
    //   324: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: istore 6
    //   329: iload_3
    //   330: istore_2
    //   331: iload 6
    //   333: ifeq -143 -> 190
    //   336: new 80	java/io/FileInputStream
    //   339: dup
    //   340: aload 7
    //   342: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   345: aload_0
    //   346: getfield 197	bpt:e	Lbeb;
    //   349: invokestatic 202	bpw:a	(Ljava/io/InputStream;Lbeb;)V
    //   352: aload_0
    //   353: getfield 197	bpt:e	Lbeb;
    //   356: astore_1
    //   357: aload_1
    //   358: aload_1
    //   359: getfield 207	beb:v	I
    //   362: bipush 32
    //   364: ior
    //   365: putfield 207	beb:v	I
    //   368: aload_0
    //   369: getfield 197	bpt:e	Lbeb;
    //   372: aload_0
    //   373: getfield 32	bpt:f	Landroid/content/Context;
    //   376: invokevirtual 210	beb:h	(Landroid/content/Context;)Landroid/net/Uri;
    //   379: pop
    //   380: iload_3
    //   381: istore_2
    //   382: aload_0
    //   383: getfield 197	bpt:e	Lbeb;
    //   386: getfield 213	beb:aq	J
    //   389: lconst_0
    //   390: lcmp
    //   391: ifeq -201 -> 190
    //   394: iload_3
    //   395: istore_2
    //   396: aload_0
    //   397: getfield 197	bpt:e	Lbeb;
    //   400: getfield 216	beb:ar	J
    //   403: lconst_0
    //   404: lcmp
    //   405: ifeq -215 -> 190
    //   408: new 218	android/content/ContentValues
    //   411: dup
    //   412: iconst_1
    //   413: invokespecial 221	android/content/ContentValues:<init>	(I)V
    //   416: astore_1
    //   417: aload_1
    //   418: ldc -33
    //   420: aload_0
    //   421: getfield 116	bpt:d	Lcom/android/emailcommon/provider/Attachment;
    //   424: getfield 226	com/android/emailcommon/provider/Attachment:s	I
    //   427: sipush 2048
    //   430: ior
    //   431: invokestatic 231	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   434: invokevirtual 235	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   437: aload_0
    //   438: getfield 116	bpt:d	Lcom/android/emailcommon/provider/Attachment;
    //   441: aload_0
    //   442: getfield 32	bpt:f	Landroid/content/Context;
    //   445: aload_1
    //   446: invokevirtual 238	com/android/emailcommon/provider/Attachment:a	(Landroid/content/Context;Landroid/content/ContentValues;)I
    //   449: pop
    //   450: iload_3
    //   451: istore_2
    //   452: goto -262 -> 190
    //   455: astore_1
    //   456: ldc 50
    //   458: aload_1
    //   459: ldc -16
    //   461: iconst_1
    //   462: anewarray 54	java/lang/Object
    //   465: dup
    //   466: iconst_0
    //   467: aload 7
    //   469: invokevirtual 243	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   472: aastore
    //   473: invokestatic 246	cvm:e	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   476: pop
    //   477: iload_3
    //   478: istore_2
    //   479: goto -289 -> 190
    //   482: astore_1
    //   483: ldc 50
    //   485: ldc -8
    //   487: iconst_1
    //   488: anewarray 54	java/lang/Object
    //   491: dup
    //   492: iconst_0
    //   493: aload_1
    //   494: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   497: aastore
    //   498: invokestatic 63	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   501: pop
    //   502: aload 9
    //   504: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   507: aload 8
    //   509: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   512: aload 7
    //   514: invokevirtual 176	java/io/File:delete	()Z
    //   517: pop
    //   518: bipush -103
    //   520: ireturn
    //   521: iload_2
    //   522: i2l
    //   523: lstore 4
    //   525: goto -221 -> 304
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 116	bpt:d	Lcom/android/emailcommon/provider/Attachment;
    //   533: aload 7
    //   535: invokespecial 250	bpt:a	(Lcom/android/emailcommon/provider/Attachment;Ljava/io/File;)Z
    //   538: ifne +34 -> 572
    //   541: ldc 50
    //   543: ldc -4
    //   545: iconst_0
    //   546: anewarray 54	java/lang/Object
    //   549: invokestatic 63	cvm:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   552: pop
    //   553: aload 9
    //   555: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   558: aload 8
    //   560: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   563: aload 7
    //   565: invokevirtual 176	java/io/File:delete	()Z
    //   568: pop
    //   569: bipush -103
    //   571: ireturn
    //   572: aload 9
    //   574: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   577: aload 8
    //   579: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   582: aload 7
    //   584: invokevirtual 176	java/io/File:delete	()Z
    //   587: pop
    //   588: iconst_0
    //   589: ireturn
    //   590: astore_1
    //   591: aload 9
    //   593: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   596: aload_1
    //   597: athrow
    //   598: astore_1
    //   599: aload 8
    //   601: invokestatic 90	bpt:a	(Ljava/io/Closeable;)V
    //   604: aload_1
    //   605: athrow
    //   606: astore_1
    //   607: aload 7
    //   609: invokevirtual 176	java/io/File:delete	()Z
    //   612: pop
    //   613: aload_1
    //   614: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	this	bpt
    //   0	615	1	parambns	bns
    //   35	487	2	i	int
    //   1	477	3	j	int
    //   302	222	4	l	long
    //   327	5	6	bool	boolean
    //   104	504	7	localFile	File
    //   115	485	8	localFileOutputStream	java.io.FileOutputStream
    //   121	471	9	localInputStream	java.io.InputStream
    //   138	173	10	localbpv	bpv
    // Exception table:
    //   from	to	target	type
    //   90	106	225	java/io/IOException
    //   106	117	248	java/io/FileNotFoundException
    //   336	380	455	java/io/FileNotFoundException
    //   382	394	455	java/io/FileNotFoundException
    //   396	450	455	java/io/FileNotFoundException
    //   123	188	482	java/io/IOException
    //   194	206	482	java/io/IOException
    //   282	287	482	java/io/IOException
    //   295	304	482	java/io/IOException
    //   304	315	482	java/io/IOException
    //   315	329	482	java/io/IOException
    //   336	380	482	java/io/IOException
    //   382	394	482	java/io/IOException
    //   396	450	482	java/io/IOException
    //   456	477	482	java/io/IOException
    //   528	553	482	java/io/IOException
    //   123	188	590	finally
    //   194	206	590	finally
    //   282	287	590	finally
    //   295	304	590	finally
    //   304	315	590	finally
    //   315	329	590	finally
    //   336	380	590	finally
    //   382	394	590	finally
    //   396	450	590	finally
    //   456	477	590	finally
    //   483	502	590	finally
    //   528	553	590	finally
    //   117	123	598	finally
    //   206	211	598	finally
    //   502	507	598	finally
    //   553	558	598	finally
    //   572	577	598	finally
    //   591	598	598	finally
    //   106	117	606	finally
    //   211	216	606	finally
    //   249	268	606	finally
    //   507	512	606	finally
    //   558	563	606	finally
    //   577	582	606	finally
    //   599	606	606	finally
  }
  
  protected final String b()
  {
    if (d == null) {
      cvm.f("Exchange", "Error, mAttachment is null", new Object[0]);
    }
    if (h.e >= 14.0D) {
      return "ItemOperations";
    }
    StringBuilder localStringBuilder;
    if (h.e < 12.0D)
    {
      str = d.p;
      bpu localbpu = new bpu();
      localStringBuilder = new StringBuilder(str.length() + 16);
      localbpu.a(localStringBuilder, str, bti.a);
    }
    for (String str = localStringBuilder.toString();; str = d.p)
    {
      str = String.valueOf(str);
      if (str.length() == 0) {
        break;
      }
      return "GetAttachment&AttachmentName=".concat(str);
    }
    return new String("GetAttachment&AttachmentName=");
  }
  
  protected final HttpEntity c()
  {
    if (d == null) {
      cvm.f("Exchange", "Error, mAttachment is null", new Object[0]);
    }
    bpi localbpi = new bpi();
    if (h.e >= 14.0D)
    {
      localbpi.a(1285).a(1286);
      localbpi.b(1287, "Mailbox");
      localbpi.b(1105, d.p);
      localbpi.b().b().a();
      return a(localbpi);
    }
    return null;
  }
  
  public final int p_()
  {
    d = Attachment.a(f, b);
    if (d == null)
    {
      cvm.e("Exchange", "Could not load attachment %d", new Object[] { Long.valueOf(b) });
      a(a, -1L, b, 17, 0);
      return -100;
    }
    if (d.p == null)
    {
      cvm.e("Exchange", "Attachment %d lacks a location", new Object[] { Long.valueOf(b) });
      a(a, -1L, b, 17, 0);
      return -101;
    }
    if ((c != null) && ((c.n) || ((c.p > 0) && (c.p < d.k))))
    {
      cvm.e("Exchange", "Attachment %d exceeds maximum size", new Object[] { Long.valueOf(b) });
      a(a, d.o, b, 40, 0);
      return 1;
    }
    e = beb.a(f, d.o);
    if (e == null)
    {
      cvm.e("Exchange", "Could not load message %d", new Object[] { Long.valueOf(d.o) });
      a(a, d.o, b, 16, 0);
      return -102;
    }
    a(a, d.o, b, 1, 0);
    int i = super.p_();
    if (i < 0)
    {
      cvm.b("Exchange", "Invoking callback for attachmentId: %d with CONNECTION_ERROR", new Object[] { Long.valueOf(b) });
      a(a, d.o, b, 32, 0);
    }
    for (;;)
    {
      return i;
      cvm.b("Exchange", "Invoking callback for attachmentId: %d with SUCCESS", new Object[] { Long.valueOf(b) });
      a(a, d.o, b, 0, 0);
    }
  }
}

/* Location:
 * Qualified Name:     bpt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */