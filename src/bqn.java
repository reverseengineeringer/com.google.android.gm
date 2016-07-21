import android.content.Context;
import com.android.emailcommon.provider.Account;
import com.android.exchange.provider.GalResult;
import java.io.InputStream;

public final class bqn
  extends bqc
{
  public GalResult a;
  private final String b;
  private final int c;
  
  public bqn(Context paramContext, Account paramAccount, String paramString, int paramInt)
  {
    super(paramContext, paramAccount);
    b = paramString;
    c = paramInt;
  }
  
  protected final int a(bns parambns)
  {
    int i = b;
    if (i == 200)
    {
      parambns = parambns.d();
      try
      {
        bor localbor = new bor(parambns);
        if (localbor.d()) {
          a = a;
        }
        for (;;)
        {
          return 0;
          cvm.f("Exchange", "Failure to parse GalResult", new Object[0]);
        }
      }
      finally
      {
        parambns.close();
      }
    }
    tmp77_74[0] = Integer.valueOf(i);
    cvm.b("Exchange", "GAL lookup returned %d", tmp77_74);
    return -99;
  }
  
  protected final String b()
  {
    return "Search";
  }
  
  /* Error */
  protected final org.apache.http.HttpEntity c()
  {
    // Byte code:
    //   0: new 80	bpi
    //   3: dup
    //   4: invokespecial 82	bpi:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: sipush 965
    //   12: invokevirtual 85	bpi:a	(I)Lbpi;
    //   15: sipush 967
    //   18: invokevirtual 85	bpi:a	(I)Lbpi;
    //   21: pop
    //   22: aload_2
    //   23: sipush 968
    //   26: ldc 87
    //   28: invokevirtual 90	bpi:b	(ILjava/lang/String;)Lbpi;
    //   31: sipush 969
    //   34: aload_0
    //   35: getfield 17	bqn:b	Ljava/lang/String;
    //   38: invokevirtual 90	bpi:b	(ILjava/lang/String;)Lbpi;
    //   41: pop
    //   42: aload_2
    //   43: sipush 970
    //   46: invokevirtual 85	bpi:a	(I)Lbpi;
    //   49: pop
    //   50: aload_0
    //   51: getfield 19	bqn:c	I
    //   54: iconst_1
    //   55: isub
    //   56: invokestatic 94	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   59: invokestatic 99	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 103	java/lang/String:length	()I
    //   67: ifeq +37 -> 104
    //   70: ldc 105
    //   72: aload_1
    //   73: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_1
    //   77: aload_2
    //   78: sipush 971
    //   81: aload_1
    //   82: invokevirtual 90	bpi:b	(ILjava/lang/String;)Lbpi;
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 112	bpi:b	()Lbpi;
    //   90: invokevirtual 112	bpi:b	()Lbpi;
    //   93: invokevirtual 112	bpi:b	()Lbpi;
    //   96: invokevirtual 114	bpi:a	()V
    //   99: aload_2
    //   100: invokestatic 117	bqn:a	(Lbpi;)Lorg/apache/http/HttpEntity;
    //   103: areturn
    //   104: new 96	java/lang/String
    //   107: dup
    //   108: ldc 105
    //   110: invokespecial 120	java/lang/String:<init>	(Ljava/lang/String;)V
    //   113: astore_1
    //   114: goto -37 -> 77
    //   117: astore_1
    //   118: aconst_null
    //   119: areturn
    //   120: astore_1
    //   121: goto -3 -> 118
    //   124: astore_1
    //   125: goto -7 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	bqn
    //   62	52	1	str	String
    //   117	1	1	localIOException	java.io.IOException
    //   120	1	1	localIllegalStateException	IllegalStateException
    //   124	1	1	localIllegalArgumentException	IllegalArgumentException
    //   7	93	2	localbpi	bpi
    // Exception table:
    //   from	to	target	type
    //   0	77	117	java/io/IOException
    //   77	104	117	java/io/IOException
    //   104	114	117	java/io/IOException
    //   0	77	120	java/lang/IllegalStateException
    //   77	104	120	java/lang/IllegalStateException
    //   104	114	120	java/lang/IllegalStateException
    //   0	77	124	java/lang/IllegalArgumentException
    //   77	104	124	java/lang/IllegalArgumentException
    //   104	114	124	java/lang/IllegalArgumentException
  }
}

/* Location:
 * Qualified Name:     bqn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */