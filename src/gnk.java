import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandomSpi;

public final class gnk
  extends SecureRandomSpi
{
  private static final File a = new File("/dev/urandom");
  private static final Object b = new Object();
  private static DataInputStream c;
  private static OutputStream d;
  private boolean e;
  
  private static DataInputStream a()
  {
    synchronized (b)
    {
      DataInputStream localDataInputStream = c;
      if (localDataInputStream == null) {}
      try
      {
        c = new DataInputStream(new FileInputStream(a));
        localDataInputStream = c;
        return localDataInputStream;
      }
      catch (IOException localIOException)
      {
        String str = String.valueOf(a);
        throw new SecurityException(String.valueOf(str).length() + 27 + "Failed to open " + str + " for reading", localIOException);
      }
    }
  }
  
  private static OutputStream b()
  {
    synchronized (b)
    {
      if (d == null) {
        d = new FileOutputStream(a);
      }
      OutputStream localOutputStream = d;
      return localOutputStream;
    }
  }
  
  protected final byte[] engineGenerateSeed(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    engineNextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  /* Error */
  protected final void engineNextBytes(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 95	gnk:e	Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: invokestatic 100	gnj:a	()[B
    //   11: invokevirtual 103	gnk:engineSetSeed	([B)V
    //   14: getstatic 32	gnk:b	Ljava/lang/Object;
    //   17: astore_2
    //   18: aload_2
    //   19: monitorenter
    //   20: invokestatic 105	gnk:a	()Ljava/io/DataInputStream;
    //   23: astore_3
    //   24: aload_2
    //   25: monitorexit
    //   26: aload_3
    //   27: monitorenter
    //   28: aload_3
    //   29: aload_1
    //   30: invokevirtual 108	java/io/DataInputStream:readFully	([B)V
    //   33: aload_3
    //   34: monitorexit
    //   35: return
    //   36: astore_1
    //   37: aload_2
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    //   41: astore_1
    //   42: getstatic 26	gnk:a	Ljava/io/File;
    //   45: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: astore_2
    //   49: new 57	java/lang/SecurityException
    //   52: dup
    //   53: new 59	java/lang/StringBuilder
    //   56: dup
    //   57: aload_2
    //   58: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokevirtual 63	java/lang/String:length	()I
    //   64: bipush 20
    //   66: iadd
    //   67: invokespecial 66	java/lang/StringBuilder:<init>	(I)V
    //   70: ldc 110
    //   72: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_2
    //   76: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: aload_1
    //   83: invokespecial 81	java/lang/SecurityException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   86: athrow
    //   87: astore_1
    //   88: aload_3
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	gnk
    //   0	92	1	paramArrayOfByte	byte[]
    //   23	66	3	localDataInputStream	DataInputStream
    // Exception table:
    //   from	to	target	type
    //   20	26	36	finally
    //   37	39	36	finally
    //   14	20	41	java/io/IOException
    //   26	28	41	java/io/IOException
    //   39	41	41	java/io/IOException
    //   90	92	41	java/io/IOException
    //   28	35	87	finally
    //   88	90	87	finally
  }
  
  /* Error */
  protected final void engineSetSeed(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: getstatic 32	gnk:b	Ljava/lang/Object;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: invokestatic 112	gnk:b	()Ljava/io/OutputStream;
    //   9: astore_3
    //   10: aload_2
    //   11: monitorexit
    //   12: aload_3
    //   13: aload_1
    //   14: invokevirtual 117	java/io/OutputStream:write	([B)V
    //   17: aload_3
    //   18: invokevirtual 120	java/io/OutputStream:flush	()V
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 95	gnk:e	Z
    //   26: return
    //   27: astore_1
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_1
    //   31: athrow
    //   32: astore_1
    //   33: getstatic 26	gnk:a	Ljava/io/File;
    //   36: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   39: astore_1
    //   40: ldc 122
    //   42: new 59	java/lang/StringBuilder
    //   45: dup
    //   46: aload_1
    //   47: invokestatic 55	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   50: invokevirtual 63	java/lang/String:length	()I
    //   53: bipush 24
    //   55: iadd
    //   56: invokespecial 66	java/lang/StringBuilder:<init>	(I)V
    //   59: ldc 124
    //   61: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 130	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: aload_0
    //   76: iconst_1
    //   77: putfield 95	gnk:e	Z
    //   80: return
    //   81: astore_1
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 95	gnk:e	Z
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	gnk
    //   0	89	1	paramArrayOfByte	byte[]
    //   9	9	3	localOutputStream	OutputStream
    // Exception table:
    //   from	to	target	type
    //   6	12	27	finally
    //   28	30	27	finally
    //   0	6	32	java/io/IOException
    //   12	21	32	java/io/IOException
    //   30	32	32	java/io/IOException
    //   0	6	81	finally
    //   12	21	81	finally
    //   30	32	81	finally
    //   33	75	81	finally
  }
}

/* Location:
 * Qualified Name:     gnk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */