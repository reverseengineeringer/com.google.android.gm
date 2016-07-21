final class gqj
  implements grm, gsb
{
  boolean a;
  String b;
  
  gqj(gqi paramgqi) {}
  
  public final boolean a(grs paramgrs, grv paramgrv, boolean paramBoolean)
  {
    if ((c == 401) && (!a))
    {
      a = true;
      ecy.a(c.a, b);
      return true;
    }
    return false;
  }
  
  /* Error */
  public final void b(grs paramgrs)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 18	gqj:c	Lgqi;
    //   5: invokevirtual 52	gqi:a	()Ljava/lang/String;
    //   8: putfield 37	gqj:b	Ljava/lang/String;
    //   11: aload_1
    //   12: getfield 57	grs:b	Lgrn;
    //   15: astore_2
    //   16: aload_0
    //   17: getfield 37	gqj:b	Ljava/lang/String;
    //   20: invokestatic 63	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 67	java/lang/String:length	()I
    //   28: ifeq +17 -> 45
    //   31: ldc 69
    //   33: aload_1
    //   34: invokevirtual 73	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_1
    //   38: aload_2
    //   39: aload_1
    //   40: invokevirtual 78	grn:a	(Ljava/lang/String;)Lgrn;
    //   43: pop
    //   44: return
    //   45: new 59	java/lang/String
    //   48: dup
    //   49: ldc 69
    //   51: invokespecial 81	java/lang/String:<init>	(Ljava/lang/String;)V
    //   54: astore_1
    //   55: goto -17 -> 38
    //   58: astore_1
    //   59: new 83	gql
    //   62: dup
    //   63: aload_1
    //   64: invokespecial 86	gql:<init>	(Lecz;)V
    //   67: athrow
    //   68: astore_1
    //   69: new 88	gqm
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 91	gqm:<init>	(Lede;)V
    //   77: athrow
    //   78: astore_1
    //   79: new 93	gqk
    //   82: dup
    //   83: aload_1
    //   84: invokespecial 96	gqk:<init>	(Lecx;)V
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	gqj
    //   0	88	1	paramgrs	grs
    //   15	24	2	localgrn	grn
    // Exception table:
    //   from	to	target	type
    //   0	38	58	ecz
    //   38	44	58	ecz
    //   45	55	58	ecz
    //   0	38	68	ede
    //   38	44	68	ede
    //   45	55	68	ede
    //   0	38	78	ecx
    //   38	44	78	ecx
    //   45	55	78	ecx
  }
}

/* Location:
 * Qualified Name:     gqj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */