import android.app.Application;

final class gkp
  implements gmm
{
  private static gkp c;
  final gku a;
  final gkj b;
  private final gkk d;
  private final gmk e;
  private boolean f;
  
  private gkp(gna paramgna, Application paramApplication, gks paramgks, gmk paramgmk)
  {
    gol.a(paramgna);
    gol.a(paramApplication);
    b = new gkj(paramApplication);
    a = new glb(paramgna, paramgks, gla.b);
    d = new gkk(new gkq(this), paramApplication);
    e = ((gmk)gol.a(paramgmk));
    paramgmk.a(this);
  }
  
  static gkp a(gna paramgna, Application paramApplication, gks paramgks)
  {
    try
    {
      if (c == null) {
        c = new gkp(paramgna, paramApplication, paramgks, gmk.a);
      }
      paramgna = c;
      return paramgna;
    }
    finally {}
  }
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 63	gkp:e	Lgmk;
    //   6: getfield 76	gmk:c	Z
    //   9: ifne +39 -> 48
    //   12: aload_0
    //   13: getfield 78	gkp:f	Z
    //   16: ifne +32 -> 48
    //   19: aload_0
    //   20: getfield 59	gkp:d	Lgkk;
    //   23: astore_1
    //   24: aload_1
    //   25: getfield 81	gkk:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   28: iconst_1
    //   29: invokevirtual 87	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   32: ifeq +19 -> 51
    //   35: ldc 89
    //   37: ldc 91
    //   39: invokestatic 97	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   42: pop
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 78	gkp:f	Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: aload_1
    //   52: getfield 100	gkk:e	Lgkb;
    //   55: aload_1
    //   56: getfield 103	gkk:f	Lgjz;
    //   59: invokevirtual 108	gkb:a	(Lgjr;)V
    //   62: aload_1
    //   63: getfield 100	gkk:e	Lgkb;
    //   66: aload_1
    //   67: getfield 112	gkk:g	Lgka;
    //   70: invokevirtual 108	gkb:a	(Lgjr;)V
    //   73: goto -30 -> 43
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	gkp
    //   23	44	1	localgkk	gkk
    //   76	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	43	76	finally
    //   43	48	76	finally
    //   51	73	76	finally
  }
  
  public final void a(gmk paramgmk)
  {
    try
    {
      if ((c) && (f))
      {
        paramgmk = d;
        e.b(f);
        e.b(g);
        f = false;
      }
      return;
    }
    finally
    {
      paramgmk = finally;
      throw paramgmk;
    }
  }
}

/* Location:
 * Qualified Name:     gkp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */