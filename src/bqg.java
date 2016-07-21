import java.io.FileInputStream;
import java.io.OutputStream;
import org.apache.http.entity.InputStreamEntity;

final class bqg
  extends InputStreamEntity
{
  private final FileInputStream a;
  private final long b;
  private final int c;
  private final beb d;
  private final bqh e;
  
  public bqg(FileInputStream paramFileInputStream, long paramLong, int paramInt, beb parambeb, bqh parambqh)
  {
    super(paramFileInputStream, paramLong);
    a = paramFileInputStream;
    b = paramLong;
    c = paramInt;
    d = parambeb;
    e = parambqh;
  }
  
  private final void a(OutputStream paramOutputStream, boolean paramBoolean)
  {
    if (paramOutputStream == null) {
      throw new IllegalArgumentException("Output stream may not be null");
    }
    paramOutputStream = new bpi(paramOutputStream);
    paramOutputStream.a(c);
    long l = System.nanoTime();
    paramOutputStream.b(1361, 29 + "SendMail-" + l);
    paramOutputStream.b(1352);
    if ((c != 1349) && (e != null))
    {
      paramOutputStream.a(1355);
      if (d.ag != null)
      {
        paramOutputStream.b(1358, d.ag);
        paramOutputStream.b();
      }
    }
    else
    {
      paramOutputStream.a(1360);
      if (!paramBoolean) {
        break label198;
      }
      paramOutputStream.a(a, (int)b);
    }
    for (;;)
    {
      paramOutputStream.b().b().a();
      return;
      paramOutputStream.b(1357, e.a);
      paramOutputStream.b(1356, e.b);
      break;
      label198:
      paramOutputStream.c((int)b);
    }
  }
  
  /* Error */
  public final long getContentLength()
  {
    // Byte code:
    //   0: new 103	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 105	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aload_0
    //   10: aload 5
    //   12: iconst_0
    //   13: invokespecial 107	bqg:a	(Ljava/io/OutputStream;Z)V
    //   16: aload 5
    //   18: invokevirtual 111	java/io/ByteArrayOutputStream:size	()I
    //   21: i2l
    //   22: lstore_1
    //   23: aload_0
    //   24: getfield 23	bqg:b	J
    //   27: lstore_3
    //   28: lload_1
    //   29: lload_3
    //   30: ladd
    //   31: lstore_1
    //   32: aload 5
    //   34: invokevirtual 114	java/io/ByteArrayOutputStream:close	()V
    //   37: lload_1
    //   38: lreturn
    //   39: astore 6
    //   41: aload 5
    //   43: invokevirtual 114	java/io/ByteArrayOutputStream:close	()V
    //   46: ldc2_w 115
    //   49: lreturn
    //   50: astore 6
    //   52: aload 5
    //   54: invokevirtual 114	java/io/ByteArrayOutputStream:close	()V
    //   57: aload 6
    //   59: athrow
    //   60: astore 5
    //   62: lload_1
    //   63: lreturn
    //   64: astore 5
    //   66: goto -20 -> 46
    //   69: astore 5
    //   71: goto -14 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bqg
    //   22	41	1	l1	long
    //   27	3	3	l2	long
    //   7	46	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   60	1	5	localIOException1	java.io.IOException
    //   64	1	5	localIOException2	java.io.IOException
    //   69	1	5	localIOException3	java.io.IOException
    //   39	1	6	localIOException4	java.io.IOException
    //   50	8	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	28	39	java/io/IOException
    //   9	28	50	finally
    //   32	37	60	java/io/IOException
    //   41	46	64	java/io/IOException
    //   52	57	69	java/io/IOException
  }
  
  public final void writeTo(OutputStream paramOutputStream)
  {
    a(paramOutputStream, true);
  }
}

/* Location:
 * Qualified Name:     bqg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */