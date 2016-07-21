import android.content.Context;
import com.google.android.gms.analytics.internal.Command;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

final class dah
  extends Thread
  implements czj
{
  static dah f;
  volatile boolean a;
  volatile List<Command> b;
  volatile daw c;
  volatile String d;
  volatile String e;
  volatile dbj g;
  final Context h;
  private final LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue();
  private volatile boolean j = false;
  private volatile boolean k = false;
  
  dah(Context paramContext)
  {
    super("GAThread");
    if (paramContext != null) {}
    for (h = paramContext.getApplicationContext();; h = paramContext)
    {
      start();
      return;
    }
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      localObject = paramContext.openFileInput("gaInstallData");
      arrayOfByte = new byte[' '];
      m = ((FileInputStream)localObject).read(arrayOfByte, 0, 8192);
      if (((FileInputStream)localObject).available() > 0)
      {
        dav.b("Too much campaign data, ignoring it.");
        ((FileInputStream)localObject).close();
        paramContext.deleteFile("gaInstallData");
        return null;
      }
      ((FileInputStream)localObject).close();
      paramContext.deleteFile("gaInstallData");
      if (m <= 0)
      {
        dav.f("Campaign file is empty.");
        return null;
      }
    }
    catch (FileNotFoundException paramContext)
    {
      byte[] arrayOfByte;
      int m;
      dav.c("No campaign data found.");
      return null;
      Object localObject = new String(arrayOfByte, 0, m);
      dav.c("Campaign found: " + (String)localObject);
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      dav.b("Error reading campaign data.");
      paramContext.deleteFile("gaInstallData");
    }
    return null;
  }
  
  private static String a(Throwable paramThrowable)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream localPrintStream = new PrintStream(localByteArrayOutputStream);
    paramThrowable.printStackTrace(localPrintStream);
    localPrintStream.flush();
    return new String(localByteArrayOutputStream.toByteArray());
  }
  
  private final void a(Runnable paramRunnable)
  {
    i.add(paramRunnable);
  }
  
  static void a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if (!paramMap.containsKey(paramString1)) {
      paramMap.put(paramString1, paramString2);
    }
  }
  
  private final boolean a(String paramString)
  {
    try
    {
      FileOutputStream localFileOutputStream = h.openFileOutput("gaClientId", 0);
      localFileOutputStream.write(paramString.getBytes());
      localFileOutputStream.close();
      return true;
    }
    catch (FileNotFoundException paramString)
    {
      dav.b("Error creating clientId file.");
      return false;
    }
    catch (IOException paramString)
    {
      dav.b("Error writing to clientId file.");
    }
    return false;
  }
  
  /* Error */
  private final String d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 53	dah:h	Landroid/content/Context;
    //   12: ldc -92
    //   14: invokevirtual 68	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   17: astore 6
    //   19: sipush 128
    //   22: newarray <illegal type>
    //   24: astore_2
    //   25: aload 6
    //   27: aload_2
    //   28: iconst_0
    //   29: sipush 128
    //   32: invokevirtual 74	java/io/FileInputStream:read	([BII)I
    //   35: istore_1
    //   36: aload 6
    //   38: invokevirtual 78	java/io/FileInputStream:available	()I
    //   41: ifle +24 -> 65
    //   44: ldc -71
    //   46: invokestatic 85	dav:b	(Ljava/lang/String;)I
    //   49: pop
    //   50: aload 6
    //   52: invokevirtual 88	java/io/FileInputStream:close	()V
    //   55: aload_0
    //   56: getfield 53	dah:h	Landroid/content/Context;
    //   59: ldc 64
    //   61: invokevirtual 92	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   64: pop
    //   65: iload_1
    //   66: ifgt +57 -> 123
    //   69: ldc -69
    //   71: invokestatic 85	dav:b	(Ljava/lang/String;)I
    //   74: pop
    //   75: aload 6
    //   77: invokevirtual 88	java/io/FileInputStream:close	()V
    //   80: aload_0
    //   81: getfield 53	dah:h	Landroid/content/Context;
    //   84: ldc 64
    //   86: invokevirtual 92	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   89: pop
    //   90: aload_3
    //   91: astore_2
    //   92: aload_2
    //   93: astore_3
    //   94: aload_2
    //   95: ifnonnull +26 -> 121
    //   98: invokestatic 193	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   101: invokevirtual 194	java/util/UUID:toString	()Ljava/lang/String;
    //   104: invokevirtual 197	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: astore_3
    //   110: aload_0
    //   111: aload_2
    //   112: invokespecial 199	dah:a	(Ljava/lang/String;)Z
    //   115: ifne +6 -> 121
    //   118: ldc -55
    //   120: astore_3
    //   121: aload_3
    //   122: areturn
    //   123: new 102	java/lang/String
    //   126: dup
    //   127: aload_2
    //   128: iconst_0
    //   129: iload_1
    //   130: invokespecial 105	java/lang/String:<init>	([BII)V
    //   133: astore_2
    //   134: aload 6
    //   136: invokevirtual 88	java/io/FileInputStream:close	()V
    //   139: goto -47 -> 92
    //   142: astore_2
    //   143: aload 4
    //   145: astore_2
    //   146: ldc -53
    //   148: invokestatic 85	dav:b	(Ljava/lang/String;)I
    //   151: pop
    //   152: aload_0
    //   153: getfield 53	dah:h	Landroid/content/Context;
    //   156: ldc 64
    //   158: invokevirtual 92	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   161: pop
    //   162: goto -70 -> 92
    //   165: astore_2
    //   166: aload 5
    //   168: astore_2
    //   169: ldc -51
    //   171: invokestatic 85	dav:b	(Ljava/lang/String;)I
    //   174: pop
    //   175: aload_0
    //   176: getfield 53	dah:h	Landroid/content/Context;
    //   179: ldc 64
    //   181: invokevirtual 92	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   184: pop
    //   185: goto -93 -> 92
    //   188: astore_3
    //   189: goto -20 -> 169
    //   192: astore_3
    //   193: goto -47 -> 146
    //   196: astore_2
    //   197: aload_3
    //   198: astore_2
    //   199: goto -107 -> 92
    //   202: astore_3
    //   203: goto -111 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	dah
    //   35	95	1	m	int
    //   24	110	2	localObject1	Object
    //   142	1	2	localIOException1	IOException
    //   145	1	2	localObject2	Object
    //   165	1	2	localNumberFormatException1	NumberFormatException
    //   168	1	2	localObject3	Object
    //   196	1	2	localFileNotFoundException1	FileNotFoundException
    //   198	1	2	localIOException2	IOException
    //   7	115	3	localObject4	Object
    //   188	1	3	localNumberFormatException2	NumberFormatException
    //   192	6	3	localIOException3	IOException
    //   202	1	3	localFileNotFoundException2	FileNotFoundException
    //   1	143	4	localObject5	Object
    //   4	163	5	localObject6	Object
    //   17	118	6	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   8	65	142	java/io/IOException
    //   69	90	142	java/io/IOException
    //   123	134	142	java/io/IOException
    //   8	65	165	java/lang/NumberFormatException
    //   69	90	165	java/lang/NumberFormatException
    //   123	134	165	java/lang/NumberFormatException
    //   134	139	188	java/lang/NumberFormatException
    //   134	139	192	java/io/IOException
    //   8	65	196	java/io/FileNotFoundException
    //   69	90	196	java/io/FileNotFoundException
    //   123	134	196	java/io/FileNotFoundException
    //   134	139	202	java/io/FileNotFoundException
  }
  
  public final void a()
  {
    a(new daj(this));
  }
  
  public final void a(czk paramczk)
  {
    a(new dal(this, paramczk));
  }
  
  public final void a(dar paramdar)
  {
    a(new dak(this, paramdar));
  }
  
  public final void a(Map<String, String> paramMap)
  {
    paramMap = new HashMap(paramMap);
    long l = System.currentTimeMillis();
    paramMap.put("hitTime", Long.toString(l));
    a(new dai(this, paramMap, l));
  }
  
  public final LinkedBlockingQueue<Runnable> b()
  {
    return i;
  }
  
  public final Thread c()
  {
    return this;
  }
  
  public final void run()
  {
    try
    {
      Thread.sleep(5000L);
      for (;;)
      {
        try
        {
          if (g == null) {
            g = new czy(h, this, (byte)0);
          }
          g.d();
          b = new ArrayList();
          b.add(new Command("appendVersion", "_v", "ma1b6"));
          b.add(new Command("appendQueueTime", "qt", null));
          b.add(new Command("appendCacheBuster", "z", null));
          c = new daw();
          daz.a(c);
          a = h.getFileStreamPath("gaOptOut").exists();
          e = d();
          d = a(h);
        }
        catch (Throwable localThrowable2)
        {
          dav.b("Error initializing the GAThread: " + a(localThrowable2));
          dav.b("Google Analytics will not start up.");
          j = true;
          continue;
        }
        if (k) {
          return;
        }
        try
        {
          Runnable localRunnable = (Runnable)i.take();
          if (!j) {
            localRunnable.run();
          }
        }
        catch (InterruptedException localInterruptedException1)
        {
          dav.c(localInterruptedException1.toString());
        }
        catch (Throwable localThrowable1)
        {
          dav.b("Error on GAThread: " + a(localThrowable1));
          dav.b("Google Analytics is shutting down.");
          j = true;
        }
      }
    }
    catch (InterruptedException localInterruptedException2)
    {
      for (;;)
      {
        dav.f("sleep interrupted in GAThread initialize");
      }
    }
  }
}

/* Location:
 * Qualified Name:     dah
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */