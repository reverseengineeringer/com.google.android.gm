import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;

public final class bgy
  extends ThreadSafeClientConnManager
{
  private final bhj a;
  
  public bgy(HttpParams paramHttpParams, SchemeRegistry paramSchemeRegistry, bhj parambhj)
  {
    super(paramHttpParams, paramSchemeRegistry);
    a = parambhj;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    paramString = paramString.toLowerCase();
    Object localObject = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      char c = paramString.charAt(i);
      int j;
      if ((('a' <= c) && (c <= 'z')) || (('A' <= c) && (c <= 'Z')))
      {
        j = 1;
        label57:
        if (j == 0)
        {
          if (('0' > c) || (c > '9')) {
            break label114;
          }
          j = 1;
          label77:
          if ((j == 0) && ('-' != c) && ('.' != c)) {
            break label120;
          }
        }
        ((StringBuilder)localObject).append(c);
      }
      for (;;)
      {
        i += 1;
        break;
        j = 0;
        break label57;
        label114:
        j = 0;
        break label77;
        label120:
        if ('+' == c) {
          ((StringBuilder)localObject).append("++");
        } else {
          ((StringBuilder)localObject).append('+').append(c);
        }
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    if (paramBoolean) {}
    for (paramString = "httpts";; paramString = "https") {
      return String.valueOf(paramString).length() + 12 + String.valueOf(localObject).length() + paramString + "+clientCert+" + (String)localObject;
    }
  }
  
  /* Error */
  public final void a(android.content.Context paramContext, com.android.emailcommon.provider.HostAuth paramHostAuth)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: getfield 69	com/android/emailcommon/provider/HostAuth:i	Ljava/lang/String;
    //   6: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: istore_3
    //   10: iload_3
    //   11: ifeq +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: invokevirtual 79	bgy:getSchemeRegistry	()Lorg/apache/http/conn/scheme/SchemeRegistry;
    //   21: astore 4
    //   23: aload_2
    //   24: getfield 69	com/android/emailcommon/provider/HostAuth:i	Ljava/lang/String;
    //   27: aload_2
    //   28: invokevirtual 83	com/android/emailcommon/provider/HostAuth:l	()Z
    //   31: invokestatic 85	bgy:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   34: astore 5
    //   36: aload 4
    //   38: aload 5
    //   40: invokevirtual 91	org/apache/http/conn/scheme/SchemeRegistry:get	(Ljava/lang/String;)Lorg/apache/http/conn/scheme/Scheme;
    //   43: ifnonnull -29 -> 14
    //   46: aload 4
    //   48: new 93	org/apache/http/conn/scheme/Scheme
    //   51: dup
    //   52: aload 5
    //   54: aload_1
    //   55: aload_2
    //   56: aload_1
    //   57: aload_2
    //   58: getfield 69	com/android/emailcommon/provider/HostAuth:i	Ljava/lang/String;
    //   61: invokestatic 98	bhg:a	(Landroid/content/Context;Ljava/lang/String;)Lbhg;
    //   64: aload_2
    //   65: invokevirtual 83	com/android/emailcommon/provider/HostAuth:l	()Z
    //   68: invokestatic 104	bhe:b	(Landroid/content/Context;Lcom/android/emailcommon/provider/HostAuth;Ljavax/net/ssl/KeyManager;Z)Lbhc;
    //   71: aload_2
    //   72: getfield 108	com/android/emailcommon/provider/HostAuth:d	I
    //   75: invokespecial 111	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   78: invokevirtual 115	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   81: pop
    //   82: goto -68 -> 14
    //   85: astore_1
    //   86: aload_0
    //   87: monitorexit
    //   88: aload_1
    //   89: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	this	bgy
    //   0	90	1	paramContext	android.content.Context
    //   0	90	2	paramHostAuth	com.android.emailcommon.provider.HostAuth
    //   9	2	3	bool	boolean
    //   21	26	4	localSchemeRegistry	SchemeRegistry
    //   34	19	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	10	85	finally
    //   17	82	85	finally
  }
  
  /* Error */
  public final boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 13	bgy:a	Lbhj;
    //   6: getfield 121	bhj:a	J
    //   9: lstore_3
    //   10: lload_3
    //   11: lload_1
    //   12: lcmp
    //   13: iflt +11 -> 24
    //   16: iconst_1
    //   17: istore 5
    //   19: aload_0
    //   20: monitorexit
    //   21: iload 5
    //   23: ireturn
    //   24: iconst_0
    //   25: istore 5
    //   27: goto -8 -> 19
    //   30: astore 6
    //   32: aload_0
    //   33: monitorexit
    //   34: aload 6
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	bgy
    //   0	37	1	paramLong	long
    //   9	2	3	l	long
    //   17	9	5	bool	boolean
    //   30	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	30	finally
  }
}

/* Location:
 * Qualified Name:     bgy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */