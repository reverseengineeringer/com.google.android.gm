public final class glh
{
  public static volatile glh a;
  private static final glh b;
  private final gli c;
  
  static
  {
    glh localglh = new glh(new gld());
    b = localglh;
    a = localglh;
  }
  
  private glh(gli paramgli)
  {
    c = ((gli)gol.a(paramgli));
  }
  
  /* Error */
  public static glh a(gjq paramgjq)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 23	glh:a	Lglh;
    //   6: getstatic 21	glh:b	Lglh;
    //   9: if_acmpeq +18 -> 27
    //   12: iconst_1
    //   13: istore_1
    //   14: iload_1
    //   15: ifeq +17 -> 32
    //   18: getstatic 23	glh:a	Lglh;
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -15 -> 14
    //   32: new 2	glh
    //   35: dup
    //   36: aload_0
    //   37: invokeinterface 40 1 0
    //   42: invokespecial 19	glh:<init>	(Lgli;)V
    //   45: astore_0
    //   46: aload_0
    //   47: putstatic 23	glh:a	Lglh;
    //   50: goto -28 -> 22
    //   53: astore_0
    //   54: aload_0
    //   55: athrow
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	paramgjq	gjq
    //   13	16	1	i	int
    // Exception table:
    //   from	to	target	type
    //   32	50	53	finally
    //   3	12	56	finally
    //   18	22	56	finally
    //   54	56	56	finally
  }
  
  public final void a()
  {
    try
    {
      c.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(gmn paramgmn, String paramString)
  {
    try
    {
      c.a(paramgmn, paramString);
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
      c.a(paramString);
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
      c.a(paramString1, paramString2);
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
      gmn localgmn = c.b();
      return localgmn;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(String paramString)
  {
    try
    {
      c.b(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}

/* Location:
 * Qualified Name:     glh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */