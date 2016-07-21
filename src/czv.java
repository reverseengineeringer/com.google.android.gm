import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;

public final class czv
  implements dbi
{
  static final Object a = new Object();
  private static czv m;
  int b = 1800;
  boolean c = true;
  Handler d;
  boolean e = false;
  private Context f;
  private czh g;
  private volatile czj h;
  private boolean i = true;
  private boolean j = true;
  private czi k = new czw(this);
  private czu l;
  
  public static czv a()
  {
    if (m == null) {
      m = new czv();
    }
    return m;
  }
  
  /* Error */
  public final void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	czv:d	Landroid/os/Handler;
    //   6: ifnonnull +17 -> 23
    //   9: ldc 63
    //   11: invokestatic 68	dav:f	(Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: iload_1
    //   17: putfield 39	czv:b	I
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: getstatic 73	dam:a	Ldam;
    //   26: getstatic 79	dan:T	Ldan;
    //   29: invokevirtual 82	dam:a	(Ldan;)V
    //   32: aload_0
    //   33: getfield 54	czv:e	Z
    //   36: ifne +28 -> 64
    //   39: aload_0
    //   40: getfield 43	czv:c	Z
    //   43: ifeq +21 -> 64
    //   46: aload_0
    //   47: getfield 39	czv:b	I
    //   50: ifle +14 -> 64
    //   53: aload_0
    //   54: getfield 61	czv:d	Landroid/os/Handler;
    //   57: iconst_1
    //   58: getstatic 36	czv:a	Ljava/lang/Object;
    //   61: invokevirtual 88	android/os/Handler:removeMessages	(ILjava/lang/Object;)V
    //   64: aload_0
    //   65: iload_1
    //   66: putfield 39	czv:b	I
    //   69: iload_1
    //   70: ifle -50 -> 20
    //   73: aload_0
    //   74: getfield 54	czv:e	Z
    //   77: ifne -57 -> 20
    //   80: aload_0
    //   81: getfield 43	czv:c	Z
    //   84: ifeq -64 -> 20
    //   87: aload_0
    //   88: getfield 61	czv:d	Landroid/os/Handler;
    //   91: aload_0
    //   92: getfield 61	czv:d	Landroid/os/Handler;
    //   95: iconst_1
    //   96: getstatic 36	czv:a	Ljava/lang/Object;
    //   99: invokevirtual 92	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   102: iload_1
    //   103: sipush 1000
    //   106: imul
    //   107: i2l
    //   108: invokevirtual 96	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   111: pop
    //   112: goto -92 -> 20
    //   115: astore_2
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_2
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	czv
    //   0	120	1	paramInt	int
    //   115	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	115	finally
    //   23	64	115	finally
    //   64	69	115	finally
    //   73	112	115	finally
  }
  
  /* Error */
  final void a(Context paramContext, czj paramczj)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	czv:f	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 105	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 99	czv:f	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 107	czv:h	Lczj;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 107	czv:h	Lczj;
    //   34: aload_0
    //   35: getfield 41	czv:i	Z
    //   38: ifeq -27 -> 11
    //   41: aload_2
    //   42: invokeinterface 111 1 0
    //   47: goto -36 -> 11
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	czv
    //   0	55	1	paramContext	Context
    //   0	55	2	paramczj	czj
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	50	finally
    //   14	47	50	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    try
    {
      a(e, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (e == paramBoolean1)
        {
          boolean bool = c;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (b > 0)) {
          d.removeMessages(1, a);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (b > 0)) {
          d.sendMessageDelayed(d.obtainMessage(1, a), b * 1000);
        }
        localStringBuilder = new StringBuilder("PowerSaveMode ");
        if (paramBoolean1) {
          break label155;
        }
        if (paramBoolean2) {
          break label148;
        }
      }
      finally {}
      dav.d(str1);
      e = paramBoolean1;
      c = paramBoolean2;
      continue;
      label148:
      String str2 = "terminated.";
      continue;
      label155:
      str2 = "initiated.";
    }
  }
  
  final czh b()
  {
    try
    {
      if (g != null) {
        break label50;
      }
      if (f == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    g = new dbe(k, f);
    label50:
    if (d == null)
    {
      d = new Handler(f.getMainLooper(), new czx(this));
      if (b > 0) {
        d.sendMessageDelayed(d.obtainMessage(1, a), b * 1000);
      }
    }
    if ((l == null) && (j))
    {
      l = new czu(this);
      localObject2 = new IntentFilter();
      ((IntentFilter)localObject2).addAction("android.net.conn.CONNECTIVITY_CHANGE");
      f.registerReceiver(l, (IntentFilter)localObject2);
    }
    Object localObject2 = g;
    return (czh)localObject2;
  }
  
  /* Error */
  public final void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 107	czv:h	Lczj;
    //   6: ifnonnull +17 -> 23
    //   9: ldc -76
    //   11: invokestatic 68	dav:f	(Ljava/lang/String;)I
    //   14: pop
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 41	czv:i	Z
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: getstatic 73	dam:a	Ldam;
    //   26: getstatic 183	dan:S	Ldan;
    //   29: invokevirtual 82	dam:a	(Ldan;)V
    //   32: aload_0
    //   33: getfield 107	czv:h	Lczj;
    //   36: invokeinterface 111 1 0
    //   41: goto -21 -> 20
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	czv
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	44	finally
    //   23	41	44	finally
  }
}

/* Location:
 * Qualified Name:     czv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */