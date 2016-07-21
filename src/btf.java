import android.os.Environment;
import java.io.FileWriter;
import java.io.IOException;

public final class btf
{
  public static String a;
  private static btf b = null;
  private static FileWriter c = null;
  
  static
  {
    String str = String.valueOf(Environment.getExternalStorageDirectory());
    a = String.valueOf(str).length() + 13 + str + "/emaillog.txt";
  }
  
  private btf()
  {
    try
    {
      c = new FileWriter(a, true);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	btf:b	Lbtf;
    //   6: ifnonnull +20 -> 26
    //   9: new 2	btf
    //   12: dup
    //   13: invokespecial 64	btf:<init>	()V
    //   16: putstatic 14	btf:b	Lbtf;
    //   19: ldc 66
    //   21: ldc 68
    //   23: invokestatic 70	btf:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: new 72	java/util/Date
    //   29: dup
    //   30: invokespecial 73	java/util/Date:<init>	()V
    //   33: astore 5
    //   35: aload 5
    //   37: invokevirtual 76	java/util/Date:getHours	()I
    //   40: istore_2
    //   41: aload 5
    //   43: invokevirtual 79	java/util/Date:getMinutes	()I
    //   46: istore_3
    //   47: aload 5
    //   49: invokevirtual 82	java/util/Date:getSeconds	()I
    //   52: istore 4
    //   54: new 30	java/lang/StringBuilder
    //   57: dup
    //   58: sipush 256
    //   61: invokespecial 38	java/lang/StringBuilder:<init>	(I)V
    //   64: astore 5
    //   66: aload 5
    //   68: bipush 91
    //   70: invokevirtual 85	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 5
    //   76: iload_2
    //   77: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 5
    //   83: bipush 58
    //   85: invokevirtual 85	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: iload_3
    //   90: bipush 10
    //   92: if_icmpge +11 -> 103
    //   95: aload 5
    //   97: bipush 48
    //   99: invokevirtual 85	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 5
    //   105: iload_3
    //   106: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 5
    //   112: bipush 58
    //   114: invokevirtual 85	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: iload 4
    //   120: bipush 10
    //   122: if_icmpge +11 -> 133
    //   125: aload 5
    //   127: bipush 48
    //   129: invokevirtual 85	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: iload 4
    //   137: invokevirtual 88	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: ldc 90
    //   145: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_0
    //   150: ifnull +18 -> 168
    //   153: aload 5
    //   155: aload_0
    //   156: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 5
    //   162: ldc 92
    //   164: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 5
    //   170: aload_1
    //   171: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload 5
    //   177: ldc 94
    //   179: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 5
    //   185: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: astore 5
    //   190: getstatic 16	btf:c	Ljava/io/FileWriter;
    //   193: astore 6
    //   195: aload 6
    //   197: ifnull +17 -> 214
    //   200: getstatic 16	btf:c	Ljava/io/FileWriter;
    //   203: aload 5
    //   205: invokevirtual 98	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   208: getstatic 16	btf:c	Ljava/io/FileWriter;
    //   211: invokevirtual 101	java/io/FileWriter:flush	()V
    //   214: ldc 2
    //   216: monitorexit
    //   217: return
    //   218: astore 5
    //   220: ldc 103
    //   222: invokestatic 106	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   225: invokevirtual 110	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifeq -14 -> 214
    //   231: new 2	btf
    //   234: dup
    //   235: invokespecial 64	btf:<init>	()V
    //   238: putstatic 14	btf:b	Lbtf;
    //   241: getstatic 16	btf:c	Ljava/io/FileWriter;
    //   244: astore 5
    //   246: aload 5
    //   248: ifnull -34 -> 214
    //   251: ldc 112
    //   253: ldc 114
    //   255: invokestatic 70	btf:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: aload_1
    //   260: invokestatic 70	btf:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -49 -> 214
    //   266: astore_0
    //   267: goto -53 -> 214
    //   270: astore_0
    //   271: ldc 2
    //   273: monitorexit
    //   274: aload_0
    //   275: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString1	String
    //   0	276	1	paramString2	String
    //   40	37	2	i	int
    //   46	60	3	j	int
    //   52	84	4	k	int
    //   33	171	5	localObject	Object
    //   218	1	5	localIOException	IOException
    //   244	3	5	localFileWriter1	FileWriter
    //   193	3	6	localFileWriter2	FileWriter
    // Exception table:
    //   from	to	target	type
    //   200	214	218	java/io/IOException
    //   251	263	266	java/lang/Exception
    //   3	26	270	finally
    //   26	89	270	finally
    //   95	103	270	finally
    //   103	118	270	finally
    //   125	133	270	finally
    //   133	149	270	finally
    //   153	168	270	finally
    //   168	195	270	finally
    //   200	214	270	finally
    //   220	246	270	finally
    //   251	263	270	finally
  }
}

/* Location:
 * Qualified Name:     btf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */