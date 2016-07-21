import android.content.Context;
import com.google.android.gms.analytics.internal.Command;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class czy
  implements czf, czg, dbj
{
  volatile long a;
  volatile int b;
  final Queue<daf> c = new ConcurrentLinkedQueue();
  volatile Timer d;
  czl e;
  long f = 300000L;
  private volatile czc g;
  private czh h;
  private czh i = null;
  private final czj j;
  private final Context k;
  private volatile int l;
  private volatile Timer m;
  private volatile Timer n;
  private boolean o;
  private boolean p;
  
  private czy(Context paramContext, czj paramczj)
  {
    k = paramContext;
    j = paramczj;
    e = new czz(this);
    l = 0;
    b = dac.g;
  }
  
  czy(Context paramContext, czj paramczj, byte paramByte)
  {
    this(paramContext, paramczj);
  }
  
  private static Timer a(Timer paramTimer)
  {
    if (paramTimer != null) {
      paramTimer.cancel();
    }
    return null;
  }
  
  private final void i()
  {
    m = a(m);
    n = a(n);
    d = a(d);
  }
  
  private final void j()
  {
    h.b();
    o = false;
  }
  
  private final void k()
  {
    m = a(m);
    m = new Timer("Service Reconnect");
    m.schedule(new dag(this), 5000L);
  }
  
  public final void a()
  {
    try
    {
      n = a(n);
      l = 0;
      dav.d("Connected to service");
      b = dac.b;
      e();
      d = a(d);
      d = new Timer("disconnect check");
      d.schedule(new dad(this), f);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic 130	dac:e	I
    //   6: putfield 72	czy:b	I
    //   9: aload_0
    //   10: getfield 66	czy:l	I
    //   13: iconst_2
    //   14: if_icmpge +35 -> 49
    //   17: new 132	java/lang/StringBuilder
    //   20: dup
    //   21: ldc -122
    //   23: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: iload_1
    //   27: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: ldc -115
    //   32: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 150	dav:f	(Ljava/lang/String;)I
    //   41: pop
    //   42: aload_0
    //   43: invokespecial 152	czy:k	()V
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: new 132	java/lang/StringBuilder
    //   52: dup
    //   53: ldc -122
    //   55: invokespecial 135	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   58: iload_1
    //   59: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc -102
    //   64: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 150	dav:f	(Ljava/lang/String;)I
    //   73: pop
    //   74: aload_0
    //   75: invokevirtual 156	czy:f	()V
    //   78: goto -32 -> 46
    //   81: astore_2
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	czy
    //   0	86	1	paramInt	int
    //   81	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	46	81	finally
    //   49	78	81	finally
  }
  
  public final void a(Map<String, String> paramMap, long paramLong, String paramString, List<Command> paramList)
  {
    dav.d("putHit called");
    c.add(new daf(paramMap, paramLong, paramString, paramList));
    e();
  }
  
  public final void b()
  {
    for (;;)
    {
      try
      {
        if (b == dac.f)
        {
          dav.d("Disconnected from service");
          i();
          b = dac.g;
          return;
        }
        dav.d("Unexpected disconnect.");
        b = dac.e;
        if (l < 2) {
          k();
        } else {
          f();
        }
      }
      finally {}
    }
  }
  
  public final void c()
  {
    switch (dab.a[(b - 1)])
    {
    default: 
      o = true;
    case 2: 
      return;
    }
    j();
  }
  
  public final void d()
  {
    if (g != null) {
      return;
    }
    g = new czd(k, this, this);
    g();
  }
  
  final void e()
  {
    for (;;)
    {
      try
      {
        if (!Thread.currentThread().equals(j.c()))
        {
          j.b().add(new daa(this));
          return;
        }
        if (p)
        {
          dav.d("clearHits called");
          c.clear();
        }
        switch (dab.a[(b - 1)])
        {
        case 1: 
          p = true;
          switch (dab.a[(b - 1)])
          {
          case 1: 
            if (c.isEmpty()) {
              break label238;
            }
            daf localdaf1 = (daf)c.poll();
            dav.d("Sending hit to store");
            h.a(a, b, c, d);
            continue;
            h.a();
          }
          break;
        }
      }
      finally {}
      p = false;
      continue;
      g.a();
      p = false;
      continue;
      label238:
      if (o)
      {
        j();
        continue;
        while (!c.isEmpty())
        {
          daf localdaf2 = (daf)c.peek();
          dav.d("Sending hit to service");
          g.a(a, b, c, d);
          c.poll();
        }
        a = e.a();
        continue;
        dav.d("Need to reconnect");
        if (!c.isEmpty())
        {
          g();
          continue;
        }
      }
    }
  }
  
  final void f()
  {
    for (;;)
    {
      try
      {
        int i1 = b;
        int i2 = dac.c;
        if (i1 == i2) {
          return;
        }
        i();
        dav.d("falling back to local store");
        if (i != null)
        {
          h = i;
          b = dac.c;
          e();
          continue;
        }
        localczv = czv.a();
      }
      finally {}
      czv localczv;
      localczv.a(k, j);
      h = localczv.b();
    }
  }
  
  final void g()
  {
    for (;;)
    {
      try
      {
        if (g != null)
        {
          int i1 = b;
          int i2 = dac.c;
          if (i1 != i2) {
            try
            {
              l += 1;
              a(n);
              b = dac.a;
              n = new Timer("Failed Connect");
              n.schedule(new dae(this), 3000L);
              dav.d("connecting to Analytics service");
              g.b();
              return;
            }
            catch (SecurityException localSecurityException)
            {
              dav.f("security exception on connectToService");
              f();
              continue;
            }
          }
        }
        dav.f("client not initialized.");
      }
      finally {}
      f();
    }
  }
  
  final void h()
  {
    try
    {
      if ((g != null) && (b == dac.b))
      {
        b = dac.f;
        g.c();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     czy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */