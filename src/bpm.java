import android.content.Context;
import com.android.emailcommon.provider.HostAuth;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

public final class bpm
{
  private static final ConnPerRoute c = new bpn();
  private static bpm d = null;
  private final nx<bgy> a = new nx();
  private final nx<Long> b = new nx();
  
  public static bgy a(Context paramContext, HostAuth paramHostAuth)
  {
    cvm.b("Exchange", "Creating new connection manager for HostAuth %d", new Object[] { Long.valueOf(D) });
    Object localObject1 = new BasicHttpParams();
    ((HttpParams)localObject1).setIntParameter("http.conn-manager.max-total", 25);
    ((HttpParams)localObject1).setParameter("http.conn-manager.max-per-route", c);
    bhj localbhj = new bhj();
    boolean bool = paramHostAuth.k();
    int i = d;
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    Object localObject2 = PlainSocketFactory.getSocketFactory();
    int j;
    if (bool)
    {
      j = 80;
      localSchemeRegistry.register(new Scheme("http", (SocketFactory)localObject2, j));
      localObject2 = bhe.b(paramContext, paramHostAuth, localbhj, false);
      if (!bool) {
        break label214;
      }
      j = i;
      label133:
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject2, j));
      localObject2 = bhe.b(paramContext, paramHostAuth, localbhj, true);
      if (!bool) {
        break label221;
      }
    }
    for (;;)
    {
      localSchemeRegistry.register(new Scheme("httpts", (SocketFactory)localObject2, i));
      localObject1 = new bgy((HttpParams)localObject1, localSchemeRegistry, localbhj);
      ((bgy)localObject1).a(paramContext, paramHostAuth);
      return (bgy)localObject1;
      j = i;
      break;
      label214:
      j = 443;
      break label133;
      label221:
      i = 443;
    }
  }
  
  public static bpm a()
  {
    if (d == null) {
      d = new bpm();
    }
    return d;
  }
  
  private final void a(long paramLong)
  {
    try
    {
      cvm.b("Exchange", "Uncaching connection manager for HostAuth %d", new Object[] { Long.valueOf(paramLong) });
      bgy localbgy = (bgy)a.a(paramLong, null);
      if (localbgy != null) {
        localbgy.shutdown();
      }
      a.a(paramLong);
      b.a(paramLong);
      return;
    }
    finally {}
  }
  
  public final void a(HostAuth paramHostAuth)
  {
    a(D);
  }
  
  /* Error */
  public final bgy b(Context paramContext, HostAuth paramHostAuth)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	bpm:a	Lnx;
    //   6: aload_2
    //   7: getfield 44	com/android/emailcommon/provider/HostAuth:D	J
    //   10: aconst_null
    //   11: invokevirtual 127	nx:a	(JLjava/lang/Object;)Ljava/lang/Object;
    //   14: checkcast 113	bgy
    //   17: astore 6
    //   19: invokestatic 140	java/lang/System:currentTimeMillis	()J
    //   22: lstore_3
    //   23: aload 6
    //   25: astore 5
    //   27: aload 6
    //   29: ifnull +64 -> 93
    //   32: aload 6
    //   34: astore 5
    //   36: lload_3
    //   37: aload_0
    //   38: getfield 33	bpm:b	Lnx;
    //   41: aload_2
    //   42: getfield 44	com/android/emailcommon/provider/HostAuth:D	J
    //   45: aconst_null
    //   46: invokevirtual 127	nx:a	(JLjava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 46	java/lang/Long
    //   52: invokevirtual 143	java/lang/Long:longValue	()J
    //   55: lsub
    //   56: ldc2_w 144
    //   59: lcmp
    //   60: ifle +33 -> 93
    //   63: ldc 36
    //   65: ldc -109
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_2
    //   74: getfield 44	com/android/emailcommon/provider/HostAuth:D	J
    //   77: invokestatic 50	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   80: aastore
    //   81: invokestatic 55	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   84: pop
    //   85: aload_0
    //   86: aload_2
    //   87: invokevirtual 149	bpm:a	(Lcom/android/emailcommon/provider/HostAuth;)V
    //   90: aconst_null
    //   91: astore 5
    //   93: aload 5
    //   95: ifnonnull +43 -> 138
    //   98: aload_1
    //   99: aload_2
    //   100: invokestatic 151	bpm:a	(Landroid/content/Context;Lcom/android/emailcommon/provider/HostAuth;)Lbgy;
    //   103: astore 5
    //   105: aload_0
    //   106: getfield 31	bpm:a	Lnx;
    //   109: aload_2
    //   110: getfield 44	com/android/emailcommon/provider/HostAuth:D	J
    //   113: aload 5
    //   115: invokevirtual 154	nx:b	(JLjava/lang/Object;)V
    //   118: aload_0
    //   119: getfield 33	bpm:b	Lnx;
    //   122: aload_2
    //   123: getfield 44	com/android/emailcommon/provider/HostAuth:D	J
    //   126: lload_3
    //   127: invokestatic 50	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   130: invokevirtual 154	nx:b	(JLjava/lang/Object;)V
    //   133: aload_0
    //   134: monitorexit
    //   135: aload 5
    //   137: areturn
    //   138: ldc 36
    //   140: ldc -100
    //   142: iconst_1
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_2
    //   149: getfield 44	com/android/emailcommon/provider/HostAuth:D	J
    //   152: invokestatic 50	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: aastore
    //   156: invokestatic 55	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   159: pop
    //   160: goto -27 -> 133
    //   163: astore_1
    //   164: aload_0
    //   165: monitorexit
    //   166: aload_1
    //   167: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	bpm
    //   0	168	1	paramContext	Context
    //   0	168	2	paramHostAuth	HostAuth
    //   22	105	3	l	long
    //   25	111	5	localbgy1	bgy
    //   17	16	6	localbgy2	bgy
    // Exception table:
    //   from	to	target	type
    //   2	23	163	finally
    //   36	90	163	finally
    //   98	133	163	finally
    //   138	160	163	finally
  }
  
  public final void b()
  {
    int i = 0;
    try
    {
      while (i < a.a())
      {
        a(a.b(i));
        i += 1;
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
 * Qualified Name:     bpm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */