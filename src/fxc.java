import java.util.regex.Pattern;

public final class fxc
{
  public static final fxc a = new fxc();
  private Pattern[] b = new Pattern[0];
  private String[] c = new String[0];
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 34	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +11 -> 19
    //   11: aconst_null
    //   12: astore 4
    //   14: aload_0
    //   15: monitorexit
    //   16: aload 4
    //   18: areturn
    //   19: iconst_0
    //   20: istore_2
    //   21: aload_1
    //   22: astore 4
    //   24: iload_2
    //   25: aload_0
    //   26: getfield 23	fxc:b	[Ljava/util/regex/Pattern;
    //   29: arraylength
    //   30: if_icmpge -16 -> 14
    //   33: aload_0
    //   34: getfield 23	fxc:b	[Ljava/util/regex/Pattern;
    //   37: iload_2
    //   38: aaload
    //   39: aload_1
    //   40: invokevirtual 38	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   43: aload_0
    //   44: getfield 27	fxc:c	[Ljava/lang/String;
    //   47: iload_2
    //   48: aaload
    //   49: invokevirtual 43	java/util/regex/Matcher:replaceAll	(Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_1
    //   53: iload_2
    //   54: iconst_1
    //   55: iadd
    //   56: istore_2
    //   57: goto -36 -> 21
    //   60: astore_1
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_1
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	fxc
    //   0	65	1	paramString	String
    //   20	37	2	i	int
    //   6	2	3	bool	boolean
    //   12	11	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	7	60	finally
    //   24	53	60	finally
  }
  
  public final void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = 0;
    try
    {
      if (paramArrayOfString1.length == paramArrayOfString2.length) {}
      for (boolean bool = true;; bool = false)
      {
        enz.b(bool);
        b = new Pattern[paramArrayOfString1.length];
        c = paramArrayOfString2;
        while (i < paramArrayOfString1.length)
        {
          b[i] = Pattern.compile(paramArrayOfString1[i]);
          i += 1;
        }
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     fxc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */