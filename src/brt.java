import android.content.ContentUris;
import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import com.android.emailcommon.provider.Mailbox;
import java.security.cert.CertificateException;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

public final class brt
{
  public static String a = null;
  private static final String[] h = { "securitySyncKey" };
  private static String i = null;
  public final Context b;
  public final HostAuth c;
  public final Account d;
  public double e = 0.0D;
  public boolean f = false;
  public HttpClient g;
  private final long j;
  private HttpUriRequest k = null;
  private boolean l = false;
  private int m = 0;
  private bgy n;
  
  public brt(Context paramContext, Account paramAccount, HostAuth paramHostAuth)
  {
    b = paramContext;
    c = paramHostAuth;
    d = paramAccount;
    j = D;
    a(l);
    cvm.b(cvm.a, "connecting to server version %s", new Object[] { l });
  }
  
  public static HttpGet b(String paramString)
  {
    return new HttpGet(paramString);
  }
  
  private final bgy f()
  {
    Object localObject = bpm.a();
    Context localContext = b;
    HostAuth localHostAuth = c;
    if (localHostAuth.h()) {}
    for (localObject = ((bpm)localObject).b(localContext, localHostAuth);; localObject = bpm.a(localContext, localHostAuth))
    {
      if (n != localObject)
      {
        n = ((bgy)localObject);
        g = null;
      }
      return (bgy)localObject;
    }
  }
  
  /* Error */
  public final bns a(HttpUriRequest paramHttpUriRequest, long paramLong)
  {
    // Byte code:
    //   0: ldc 111
    //   2: ldc 113
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: invokeinterface 119 1 0
    //   16: aastore
    //   17: invokestatic 82	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   20: pop
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 51	brt:l	Z
    //   27: ifeq +23 -> 50
    //   30: aload_0
    //   31: iconst_0
    //   32: putfield 51	brt:l	Z
    //   35: new 121	java/io/IOException
    //   38: dup
    //   39: ldc 123
    //   41: invokespecial 124	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   44: athrow
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    //   50: aload_0
    //   51: aload_1
    //   52: putfield 49	brt:k	Lorg/apache/http/client/methods/HttpUriRequest;
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_0
    //   58: invokespecial 126	brt:f	()Lbgy;
    //   61: astore 4
    //   63: aload_0
    //   64: getfield 106	brt:g	Lorg/apache/http/client/HttpClient;
    //   67: ifnonnull +53 -> 120
    //   70: new 128	org/apache/http/params/BasicHttpParams
    //   73: dup
    //   74: invokespecial 129	org/apache/http/params/BasicHttpParams:<init>	()V
    //   77: astore 5
    //   79: aload 5
    //   81: sipush 20000
    //   84: invokestatic 135	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   87: aload 5
    //   89: lload_2
    //   90: l2i
    //   91: invokestatic 138	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   94: aload 5
    //   96: sipush 8192
    //   99: invokestatic 141	org/apache/http/params/HttpConnectionParams:setSocketBufferSize	(Lorg/apache/http/params/HttpParams;I)V
    //   102: aload_0
    //   103: new 143	bru
    //   106: dup
    //   107: aload_0
    //   108: aload_0
    //   109: invokespecial 126	brt:f	()Lbgy;
    //   112: aload 5
    //   114: invokespecial 146	bru:<init>	(Lbrt;Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   117: putfield 106	brt:g	Lorg/apache/http/client/HttpClient;
    //   120: aload_0
    //   121: getfield 106	brt:g	Lorg/apache/http/client/HttpClient;
    //   124: astore 5
    //   126: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   129: lstore_2
    //   130: new 154	bns
    //   133: dup
    //   134: aload 5
    //   136: aload_1
    //   137: invokeinterface 160 2 0
    //   142: aload 4
    //   144: lload_2
    //   145: invokespecial 163	bns:<init>	(Lorg/apache/http/HttpResponse;Lbgy;J)V
    //   148: astore_1
    //   149: aload_0
    //   150: monitorenter
    //   151: aload_0
    //   152: aconst_null
    //   153: putfield 49	brt:k	Lorg/apache/http/client/methods/HttpUriRequest;
    //   156: aload_0
    //   157: iconst_0
    //   158: putfield 53	brt:m	I
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: areturn
    //   165: astore_1
    //   166: aload_0
    //   167: monitorexit
    //   168: aload_1
    //   169: athrow
    //   170: astore_1
    //   171: aload_0
    //   172: monitorenter
    //   173: aload_0
    //   174: aconst_null
    //   175: putfield 49	brt:k	Lorg/apache/http/client/methods/HttpUriRequest;
    //   178: aload_0
    //   179: monitorexit
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: aload_0
    //   184: monitorexit
    //   185: aload_1
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	brt
    //   0	187	1	paramHttpUriRequest	HttpUriRequest
    //   0	187	2	paramLong	long
    //   61	82	4	localbgy	bgy
    //   77	58	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	45	45	finally
    //   46	48	45	finally
    //   50	57	45	finally
    //   151	163	165	finally
    //   166	168	165	finally
    //   57	120	170	finally
    //   120	149	170	finally
    //   173	180	182	finally
    //   183	185	182	finally
  }
  
  public final String a()
  {
    String str1 = String.valueOf(c.f);
    String str2 = String.valueOf(c.g);
    str1 = String.valueOf(Base64.encodeToString((String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + ":" + str2).getBytes(), 2));
    if (str1.length() != 0) {
      return "Basic ".concat(str1);
    }
    return new String("Basic ");
  }
  
  public final HttpPost a(String paramString1, HttpEntity paramHttpEntity, String paramString2, boolean paramBoolean)
  {
    Object localObject = null;
    HttpPost localHttpPost = new HttpPost(paramString1);
    localHttpPost.setHeader("Authorization", a());
    localHttpPost.setHeader("MS-ASProtocolVersion", String.valueOf(e));
    localHttpPost.setHeader("User-Agent", c());
    localHttpPost.setHeader("Accept-Encoding", "gzip");
    if ((paramString2 != null) && (paramHttpEntity != null)) {
      localHttpPost.setHeader("Content-Type", paramString2);
    }
    if (paramBoolean)
    {
      if (j != -1L) {
        break label117;
      }
      paramString1 = (String)localObject;
      if (TextUtils.isEmpty(paramString1)) {
        break label143;
      }
    }
    for (;;)
    {
      localHttpPost.setHeader("X-MS-PolicyKey", paramString1);
      localHttpPost.setEntity(paramHttpEntity);
      return localHttpPost;
      label117:
      paramString1 = bhn.b(b, ContentUris.withAppendedId(Account.a, j), h, null, null);
      break;
      label143:
      paramString1 = "0";
    }
  }
  
  /* Error */
  public final void a(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: iload_1
    //   5: ifle +67 -> 72
    //   8: iload_1
    //   9: iconst_2
    //   10: if_icmpgt +62 -> 72
    //   13: aload_0
    //   14: getfield 49	brt:k	Lorg/apache/http/client/methods/HttpUriRequest;
    //   17: ifnull +5 -> 22
    //   20: iconst_1
    //   21: istore_2
    //   22: iload_2
    //   23: ifeq +52 -> 75
    //   26: ldc_w 266
    //   29: astore_3
    //   30: ldc 111
    //   32: ldc_w 268
    //   35: iconst_2
    //   36: anewarray 4	java/lang/Object
    //   39: dup
    //   40: iconst_0
    //   41: aload_3
    //   42: aastore
    //   43: dup
    //   44: iconst_1
    //   45: iload_1
    //   46: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   49: aastore
    //   50: invokestatic 275	cvm:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   53: pop
    //   54: aload_0
    //   55: iload_1
    //   56: putfield 53	brt:m	I
    //   59: iload_2
    //   60: ifeq +22 -> 82
    //   63: aload_0
    //   64: getfield 49	brt:k	Lorg/apache/http/client/methods/HttpUriRequest;
    //   67: invokeinterface 278 1 0
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: ldc_w 280
    //   78: astore_3
    //   79: goto -49 -> 30
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 51	brt:l	Z
    //   87: goto -15 -> 72
    //   90: astore_3
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_3
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	brt
    //   0	95	1	paramInt	int
    //   1	59	2	i1	int
    //   29	50	3	str	String
    //   90	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	90	finally
    //   30	59	90	finally
    //   63	72	90	finally
    //   82	87	90	finally
  }
  
  public final boolean a(String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      f = bool;
      String str = paramString;
      if (paramString == null) {
        str = "2.5";
      }
      double d1 = e;
      e = bnq.a(str).doubleValue();
      Mailbox.a(bnq.d(str));
      if (d1 == e) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public final String b()
  {
    boolean bool1 = c.k();
    boolean bool2 = c.l();
    String str1 = c.i;
    if (!TextUtils.isEmpty(str1)) {
      str1 = bgy.a(str1, bool2);
    }
    for (;;)
    {
      str1 = String.valueOf(str1);
      String str2 = String.valueOf(c.c);
      return String.valueOf(str1).length() + 31 + String.valueOf(str2).length() + str1 + "://" + str2 + "/Microsoft-Server-ActiveSync";
      if (bool1)
      {
        if (bool2) {
          str1 = "httpts";
        } else {
          str1 = "https";
        }
      }
      else {
        str1 = "http";
      }
    }
  }
  
  /* Error */
  public final String c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 42	brt:i	Ljava/lang/String;
    //   5: ifnonnull +38 -> 43
    //   8: ldc_w 324
    //   11: invokestatic 170	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 59	brt:b	Landroid/content/Context;
    //   19: invokestatic 329	cxd:a	(Landroid/content/Context;)Ljava/lang/String;
    //   22: invokestatic 170	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   25: astore_2
    //   26: aload_2
    //   27: invokevirtual 178	java/lang/String:length	()I
    //   30: ifeq +21 -> 51
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 206	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   38: astore_1
    //   39: aload_1
    //   40: putstatic 42	brt:i	Ljava/lang/String;
    //   43: getstatic 42	brt:i	Ljava/lang/String;
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: new 34	java/lang/String
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 207	java/lang/String:<init>	(Ljava/lang/String;)V
    //   59: astore_1
    //   60: goto -21 -> 39
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	brt
    //   14	46	1	str1	String
    //   63	4	1	localObject	Object
    //   25	10	2	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	39	63	finally
    //   39	43	63	finally
    //   43	47	63	finally
    //   51	60	63	finally
  }
  
  public final int d()
  {
    try
    {
      int i1 = m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean e()
  {
    if (c.i != null) {}
    try
    {
      f().a(b, c);
      return true;
    }
    catch (CertificateException localCertificateException) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     brt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */