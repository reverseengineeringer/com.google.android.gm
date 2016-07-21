import android.app.Application;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

final class glj
  implements gli
{
  final gna a;
  final Application b;
  final gmk c;
  final glx d;
  final gmh e;
  final glq f;
  final gly g;
  final glz h;
  final glw i;
  
  static
  {
    gol.a(Integer.valueOf(gmj.a));
  }
  
  glj(Application paramApplication, gna paramgna, glo paramglo, gmk paramgmk)
  {
    gol.a(paramglo);
    a = ((gna)gol.a(paramgna));
    b = ((Application)gol.a(paramApplication));
    d = a;
    e = b;
    f = c;
    g = d;
    h = e;
    i = f;
    c = ((gmk)gol.a(paramgmk));
    if (!d()) {}
    for (;;)
    {
      return;
      try
      {
        if ((e.compareAndSet(false, true)) && (paramgmk.a(paramApplication, "primes::shutdown_primes"))) {
          paramgmk.a();
        }
        if (c) {
          continue;
        }
        paramApplication = b;
        if (glc.a == null)
        {
          gol.a(paramApplication);
          glc.a = new glc(paramApplication);
        }
        paramApplication = glr.c;
        glr.a().submit(new glk(this));
        return;
      }
      finally {}
    }
  }
  
  static glj a(Application paramApplication, gnf paramgnf, glo paramglo)
  {
    gll localgll = new gll();
    Object localObject1 = new glm();
    Object localObject2 = glr.c;
    localObject2 = glr.a();
    localObject1 = new gnh(1000, (gne)localObject1);
    ((ScheduledExecutorService)localObject2).schedule(new gnc(paramgnf, (gnh)localObject1, localgll), 100L, TimeUnit.MILLISECONDS);
    return new glj(paramApplication, (gna)localObject1, paramglo, gmk.a);
  }
  
  private static boolean d()
  {
    if (Build.VERSION.SDK_INT < 16)
    {
      Log.w("Primes", "Primes calls will be ignored. API's < 16 are not supported.");
      return false;
    }
    return true;
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 184	glj:c	()Z
    //   6: ifeq +15 -> 21
    //   9: aload_0
    //   10: getfield 61	glj:d	Lglx;
    //   13: invokevirtual 188	glx:a	()Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: invokestatic 189	glx:c	()Z
    //   27: pop
    //   28: aload_0
    //   29: getfield 51	glj:a	Lgna;
    //   32: aload_0
    //   33: getfield 55	glj:b	Landroid/app/Application;
    //   36: aload_0
    //   37: getfield 61	glj:d	Lglx;
    //   40: invokestatic 194	gkp:a	(Lgna;Landroid/app/Application;Lgks;)Lgkp;
    //   43: invokevirtual 195	gkp:a	()V
    //   46: goto -25 -> 21
    //   49: astore_2
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	glj
    //   16	2	1	bool	boolean
    //   49	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	49	finally
    //   24	46	49	finally
  }
  
  public final void a(gmn paramgmn, String paramString)
  {
    try
    {
      if (c()) {
        paramgmn = e;
      }
      return;
    }
    finally
    {
      paramgmn = finally;
      throw paramgmn;
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      if (c()) {
        paramString = e;
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    try
    {
      if (c()) {
        paramString1 = e;
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final gmn b()
  {
    try
    {
      if (c()) {
        localObject1 = e;
      }
      Object localObject1 = gmn.c;
      return (gmn)localObject1;
    }
    finally {}
  }
  
  public final void b(String paramString)
  {
    try
    {
      a(paramString, null);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean c()
  {
    return (!c.c) && (d());
  }
}

/* Location:
 * Qualified Name:     glj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */