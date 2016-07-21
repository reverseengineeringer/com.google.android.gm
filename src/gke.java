import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;

final class gke
  implements gmm
{
  private static gke c;
  final gmp a;
  final gmk b;
  private final Application d;
  private final Application.ActivityLifecycleCallbacks e = new gkf(this);
  
  private gke(gmk paramgmk, Application paramApplication, gmp paramgmp, gku paramgku)
  {
    gol.a(paramgku);
    b = ((gmk)gol.a(paramgmk));
    d = ((Application)gol.a(paramApplication));
    a = ((gmp)gol.a(paramgmp));
    a.b = new gki(paramgku);
    paramgmk.a(this);
  }
  
  static gke a(gna paramgna, Application paramApplication)
  {
    try
    {
      if (c == null)
      {
        paramgna = new glb(paramgna, new gkg(), gla.b);
        c = new gke(gmk.a, paramApplication, new gmp(), paramgna);
      }
      paramgna = c;
      return paramgna;
    }
    finally {}
  }
  
  /* Error */
  final void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 37	gke:b	Lgmk;
    //   6: getfield 81	gmk:c	Z
    //   9: ifne +57 -> 66
    //   12: aload_0
    //   13: getfield 37	gke:b	Lgmk;
    //   16: getfield 83	gmk:d	Z
    //   19: ifeq +47 -> 66
    //   22: iconst_1
    //   23: istore_1
    //   24: aload_0
    //   25: getfield 45	gke:a	Lgmp;
    //   28: getfield 85	gmp:a	Z
    //   31: iload_1
    //   32: if_icmpeq +31 -> 63
    //   35: aload_0
    //   36: getfield 45	gke:a	Lgmp;
    //   39: getfield 85	gmp:a	Z
    //   42: ifne +29 -> 71
    //   45: aload_0
    //   46: getfield 45	gke:a	Lgmp;
    //   49: invokevirtual 87	gmp:a	()V
    //   52: aload_0
    //   53: getfield 41	gke:d	Landroid/app/Application;
    //   56: aload_0
    //   57: getfield 28	gke:e	Landroid/app/Application$ActivityLifecycleCallbacks;
    //   60: invokevirtual 91	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: iconst_0
    //   67: istore_1
    //   68: goto -44 -> 24
    //   71: aload_0
    //   72: getfield 41	gke:d	Landroid/app/Application;
    //   75: aload_0
    //   76: getfield 28	gke:e	Landroid/app/Application$ActivityLifecycleCallbacks;
    //   79: invokevirtual 94	android/app/Application:unregisterActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   82: aload_0
    //   83: getfield 45	gke:a	Lgmp;
    //   86: invokevirtual 96	gmp:b	()V
    //   89: goto -26 -> 63
    //   92: astore_2
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_2
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	gke
    //   23	45	1	i	int
    //   92	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	92	finally
    //   24	63	92	finally
    //   71	89	92	finally
  }
  
  public final void a(gmk paramgmk)
  {
    if (c) {
      a.b();
    }
    a();
  }
}

/* Location:
 * Qualified Name:     gke
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */