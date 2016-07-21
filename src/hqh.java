final class hqh
  extends hqi
{
  @Deprecated
  private static final long serialVersionUID = 7316153563782823691L;
  
  /* Error */
  public final void a()
  {
    // Byte code:
    //   0: invokestatic 23	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore 5
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 26	hqh:a	Ljava/lang/Thread;
    //   11: ifnonnull +17 -> 28
    //   14: aload_0
    //   15: aload 5
    //   17: putfield 26	hqh:a	Ljava/lang/Thread;
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 30	hqh:b	I
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload 5
    //   30: aload_0
    //   31: getfield 26	hqh:a	Ljava/lang/Thread;
    //   34: if_acmpne +44 -> 78
    //   37: aload_0
    //   38: getfield 31	hqi:b	I
    //   41: iconst_1
    //   42: iadd
    //   43: istore_1
    //   44: aload_0
    //   45: iload_1
    //   46: putfield 31	hqi:b	I
    //   49: iload_1
    //   50: ifge +20 -> 70
    //   53: new 33	java/lang/Error
    //   56: dup
    //   57: ldc 35
    //   59: invokespecial 38	java/lang/Error:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: astore 5
    //   65: aload_0
    //   66: monitorexit
    //   67: aload 5
    //   69: athrow
    //   70: aload_0
    //   71: iload_1
    //   72: putfield 31	hqi:b	I
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: invokestatic 42	java/lang/Thread:interrupted	()Z
    //   81: istore_2
    //   82: iload_2
    //   83: istore 4
    //   85: aload_0
    //   86: invokevirtual 47	java/lang/Object:wait	()V
    //   89: iload_2
    //   90: istore_3
    //   91: iload_3
    //   92: istore_2
    //   93: iload_3
    //   94: istore 4
    //   96: aload_0
    //   97: getfield 26	hqh:a	Ljava/lang/Thread;
    //   100: ifnonnull -18 -> 82
    //   103: iload_3
    //   104: istore 4
    //   106: aload_0
    //   107: aload 5
    //   109: putfield 26	hqh:a	Ljava/lang/Thread;
    //   112: iload_3
    //   113: istore 4
    //   115: aload_0
    //   116: iconst_1
    //   117: putfield 30	hqh:b	I
    //   120: iload_3
    //   121: ifeq +9 -> 130
    //   124: invokestatic 23	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   127: invokevirtual 50	java/lang/Thread:interrupt	()V
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: astore 5
    //   135: iload 4
    //   137: ifeq +9 -> 146
    //   140: invokestatic 23	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   143: invokevirtual 50	java/lang/Thread:interrupt	()V
    //   146: aload 5
    //   148: athrow
    //   149: astore 6
    //   151: iconst_1
    //   152: istore_3
    //   153: goto -62 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	hqh
    //   43	29	1	i	int
    //   81	12	2	bool1	boolean
    //   90	63	3	bool2	boolean
    //   83	53	4	bool3	boolean
    //   3	26	5	localThread1	Thread
    //   63	45	5	localThread2	Thread
    //   133	14	5	localObject	Object
    //   149	1	6	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   7	27	63	finally
    //   28	49	63	finally
    //   53	63	63	finally
    //   65	67	63	finally
    //   70	77	63	finally
    //   78	82	63	finally
    //   124	130	63	finally
    //   130	132	63	finally
    //   140	146	63	finally
    //   146	149	63	finally
    //   85	89	133	finally
    //   96	103	133	finally
    //   106	112	133	finally
    //   115	120	133	finally
    //   85	89	149	java/lang/InterruptedException
  }
  
  public final void b()
  {
    try
    {
      if (Thread.currentThread() != a) {
        throw new IllegalMonitorStateException("Not owner");
      }
    }
    finally {}
    int i = b - 1;
    b = i;
    if (i == 0)
    {
      a = null;
      notify();
    }
  }
}

/* Location:
 * Qualified Name:     hqh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */