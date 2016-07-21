abstract class bsq<T>
{
  private bsq(brw parambrw) {}
  
  public abstract T a();
  
  /* Error */
  public final T b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 11	bsq:g	Lbrw;
    //   4: getfield 27	brw:c	Landroid/content/Context;
    //   7: invokestatic 32	bgq:a	(Landroid/content/Context;)V
    //   10: invokestatic 37	cuh:a	()Z
    //   13: ifeq +24 -> 37
    //   16: invokestatic 43	android/os/Binder:clearCallingIdentity	()J
    //   19: lstore_1
    //   20: aload_0
    //   21: invokevirtual 45	bsq:a	()Ljava/lang/Object;
    //   24: astore_3
    //   25: invokestatic 37	cuh:a	()Z
    //   28: ifeq +7 -> 35
    //   31: lload_1
    //   32: invokestatic 49	android/os/Binder:restoreCallingIdentity	(J)V
    //   35: aload_3
    //   36: areturn
    //   37: lconst_0
    //   38: lstore_1
    //   39: goto -19 -> 20
    //   42: astore_3
    //   43: invokestatic 37	cuh:a	()Z
    //   46: ifeq +7 -> 53
    //   49: lload_1
    //   50: invokestatic 49	android/os/Binder:restoreCallingIdentity	(J)V
    //   53: aload_3
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	bsq
    //   19	31	1	l	long
    //   24	12	3	localObject1	Object
    //   42	12	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	42	finally
  }
}

/* Location:
 * Qualified Name:     bsq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */