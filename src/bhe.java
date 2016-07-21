import android.content.Context;
import com.android.emailcommon.provider.HostAuth;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocketFactory;

public final class bhe
{
  public static bhf a;
  private static SSLSocketFactory b;
  
  /* Error */
  public static SSLSocketFactory a(Context paramContext, HostAuth paramHostAuth, KeyManager paramKeyManager, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 15	bhe:a	Lbhf;
    //   6: ifnull +10 -> 16
    //   9: getstatic 15	bhe:a	Lbhf;
    //   12: aload_0
    //   13: invokevirtual 20	bhf:a	(Landroid/content/Context;)V
    //   16: aload_2
    //   17: ifnonnull +63 -> 80
    //   20: aconst_null
    //   21: astore_2
    //   22: iload_3
    //   23: ifeq +93 -> 116
    //   26: new 22	bhh
    //   29: dup
    //   30: aload_0
    //   31: aload_1
    //   32: invokespecial 26	bhh:<init>	(Landroid/content/Context;Lcom/android/emailcommon/provider/HostAuth;)V
    //   35: astore_0
    //   36: ldc 28
    //   38: invokestatic 34	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   41: astore_1
    //   42: aload_1
    //   43: aload_2
    //   44: iconst_1
    //   45: anewarray 36	javax/net/ssl/TrustManager
    //   48: dup
    //   49: iconst_0
    //   50: aload_0
    //   51: aastore
    //   52: aconst_null
    //   53: invokevirtual 40	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   56: new 42	bhd
    //   59: dup
    //   60: aload_1
    //   61: invokevirtual 46	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   64: iconst_0
    //   65: sipush 30000
    //   68: invokespecial 49	bhd:<init>	(Ljavax/net/ssl/SSLSocketFactory;ZI)V
    //   71: checkcast 42	bhd
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: areturn
    //   80: iconst_1
    //   81: anewarray 51	javax/net/ssl/KeyManager
    //   84: astore 4
    //   86: aload 4
    //   88: iconst_0
    //   89: aload_2
    //   90: aastore
    //   91: aload 4
    //   93: astore_2
    //   94: goto -72 -> 22
    //   97: astore_0
    //   98: ldc 53
    //   100: aload_0
    //   101: ldc 55
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 61	cvm:f	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   110: pop
    //   111: aconst_null
    //   112: astore_0
    //   113: goto -38 -> 75
    //   116: getstatic 63	bhe:b	Ljavax/net/ssl/SSLSocketFactory;
    //   119: ifnonnull +37 -> 156
    //   122: ldc 28
    //   124: invokestatic 34	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   127: astore_0
    //   128: aload_0
    //   129: aload_2
    //   130: aconst_null
    //   131: aconst_null
    //   132: invokevirtual 40	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   135: new 42	bhd
    //   138: dup
    //   139: aload_0
    //   140: invokevirtual 46	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   143: iconst_1
    //   144: sipush 30000
    //   147: invokespecial 49	bhd:<init>	(Ljavax/net/ssl/SSLSocketFactory;ZI)V
    //   150: checkcast 42	bhd
    //   153: putstatic 63	bhe:b	Ljavax/net/ssl/SSLSocketFactory;
    //   156: getstatic 63	bhe:b	Ljavax/net/ssl/SSLSocketFactory;
    //   159: astore_0
    //   160: goto -85 -> 75
    //   163: astore_0
    //   164: ldc 2
    //   166: monitorexit
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: goto -72 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramContext	Context
    //   0	173	1	paramHostAuth	HostAuth
    //   0	173	2	paramKeyManager	KeyManager
    //   0	173	3	paramBoolean	boolean
    //   84	8	4	arrayOfKeyManager	KeyManager[]
    // Exception table:
    //   from	to	target	type
    //   26	75	97	java/security/NoSuchAlgorithmException
    //   80	86	97	java/security/NoSuchAlgorithmException
    //   116	156	97	java/security/NoSuchAlgorithmException
    //   156	160	97	java/security/NoSuchAlgorithmException
    //   3	16	163	finally
    //   26	75	163	finally
    //   80	86	163	finally
    //   98	111	163	finally
    //   116	156	163	finally
    //   156	160	163	finally
    //   26	75	169	java/security/KeyManagementException
    //   80	86	169	java/security/KeyManagementException
    //   116	156	169	java/security/KeyManagementException
    //   156	160	169	java/security/KeyManagementException
  }
  
  public static bhc b(Context paramContext, HostAuth paramHostAuth, KeyManager paramKeyManager, boolean paramBoolean)
  {
    paramContext = new bhc(a(paramContext, paramHostAuth, paramKeyManager, paramBoolean));
    if (paramBoolean)
    {
      paramHostAuth = bhc.a;
      if (paramHostAuth == null) {
        throw new IllegalArgumentException("Hostname verifier may not be null");
      }
      d = paramHostAuth;
    }
    return paramContext;
  }
}

/* Location:
 * Qualified Name:     bhe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */