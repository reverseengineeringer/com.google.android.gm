public final class gmp
{
  public boolean a = false;
  public gmo b;
  private final gmr c;
  private gmq d;
  
  public gmp()
  {
    this(new gmr());
  }
  
  private gmp(gmr paramgmr)
  {
    c = ((gmr)gol.a(paramgmr));
  }
  
  public final void a()
  {
    try
    {
      a = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void a(Object paramObject, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 25	gmp:a	Z
    //   6: ifeq +119 -> 125
    //   9: aload_0
    //   10: getfield 35	gmp:d	Lgmq;
    //   13: ifnonnull +41 -> 54
    //   16: aload_0
    //   17: getfield 37	gmp:b	Lgmo;
    //   20: astore_3
    //   21: aload_0
    //   22: new 39	gmq
    //   25: dup
    //   26: new 41	java/lang/ref/ReferenceQueue
    //   29: dup
    //   30: invokespecial 42	java/lang/ref/ReferenceQueue:<init>	()V
    //   33: new 44	gms
    //   36: dup
    //   37: invokespecial 45	gms:<init>	()V
    //   40: aload_3
    //   41: invokespecial 48	gmq:<init>	(Ljava/lang/ref/ReferenceQueue;Lgmt;Lgmo;)V
    //   44: putfield 35	gmp:d	Lgmq;
    //   47: aload_0
    //   48: getfield 35	gmp:d	Lgmq;
    //   51: invokevirtual 51	gmq:start	()V
    //   54: aload_0
    //   55: getfield 35	gmp:d	Lgmq;
    //   58: astore_3
    //   59: aload_2
    //   60: invokestatic 30	gol:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   63: pop
    //   64: aload_1
    //   65: invokestatic 30	gol:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: ldc 53
    //   71: iconst_3
    //   72: invokestatic 59	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   75: ifeq +25 -> 100
    //   78: aload_2
    //   79: invokestatic 65	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: astore 4
    //   84: aload 4
    //   86: invokevirtual 69	java/lang/String:length	()I
    //   89: ifeq +39 -> 128
    //   92: ldc 71
    //   94: aload 4
    //   96: invokevirtual 75	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   99: pop
    //   100: aload_3
    //   101: getfield 78	gmq:c	Ljava/util/concurrent/ConcurrentMap;
    //   104: aload_3
    //   105: getfield 81	gmq:b	Lgmt;
    //   108: aload_1
    //   109: aload_3
    //   110: getfield 84	gmq:a	Ljava/lang/ref/ReferenceQueue;
    //   113: invokeinterface 89 3 0
    //   118: aload_2
    //   119: invokeinterface 95 3 0
    //   124: pop
    //   125: aload_0
    //   126: monitorexit
    //   127: return
    //   128: new 61	java/lang/String
    //   131: dup
    //   132: ldc 71
    //   134: invokespecial 98	java/lang/String:<init>	(Ljava/lang/String;)V
    //   137: pop
    //   138: goto -38 -> 100
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	gmp
    //   0	146	1	paramObject	Object
    //   0	146	2	paramString	String
    //   20	90	3	localObject	Object
    //   82	13	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	54	141	finally
    //   54	100	141	finally
    //   100	125	141	finally
    //   128	138	141	finally
  }
  
  public final void b()
  {
    try
    {
      if (a)
      {
        a = false;
        if (d != null)
        {
          d.interrupt();
          d = null;
        }
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
 * Qualified Name:     gmp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */