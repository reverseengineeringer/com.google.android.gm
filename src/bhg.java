import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public final class bhg
  extends bhi
{
  private final String a;
  private final X509Certificate[] b;
  private final PrivateKey c;
  
  private bhg(String paramString, X509Certificate[] paramArrayOfX509Certificate, PrivateKey paramPrivateKey)
  {
    super((byte)0);
    a = paramString;
    b = paramArrayOfX509Certificate;
    c = paramPrivateKey;
  }
  
  /* Error */
  public static bhg a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 33	android/security/KeyChain:getCertificateChain	(Landroid/content/Context;Ljava/lang/String;)[Ljava/security/cert/X509Certificate;
    //   5: astore_2
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 37	android/security/KeyChain:getPrivateKey	(Landroid/content/Context;Ljava/lang/String;)Ljava/security/PrivateKey;
    //   11: astore_0
    //   12: aload_2
    //   13: ifnull +7 -> 20
    //   16: aload_0
    //   17: ifnonnull +45 -> 62
    //   20: new 39	java/security/cert/CertificateException
    //   23: dup
    //   24: ldc 41
    //   26: invokespecial 44	java/security/cert/CertificateException:<init>	(Ljava/lang/String;)V
    //   29: athrow
    //   30: astore_0
    //   31: ldc 46
    //   33: aload_0
    //   34: invokestatic 49	bhg:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   37: new 39	java/security/cert/CertificateException
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 52	java/security/cert/CertificateException:<init>	(Ljava/lang/Throwable;)V
    //   45: athrow
    //   46: astore_0
    //   47: ldc 54
    //   49: aload_0
    //   50: invokestatic 49	bhg:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   53: new 39	java/security/cert/CertificateException
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 52	java/security/cert/CertificateException:<init>	(Ljava/lang/Throwable;)V
    //   61: athrow
    //   62: new 2	bhg
    //   65: dup
    //   66: aload_1
    //   67: aload_2
    //   68: aload_0
    //   69: invokespecial 56	bhg:<init>	(Ljava/lang/String;[Ljava/security/cert/X509Certificate;Ljava/security/PrivateKey;)V
    //   72: areturn
    //   73: astore_0
    //   74: goto -43 -> 31
    //   77: astore_0
    //   78: goto -31 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramContext	android.content.Context
    //   0	81	1	paramString	String
    //   5	63	2	arrayOfX509Certificate	X509Certificate[]
    // Exception table:
    //   from	to	target	type
    //   0	6	30	android/security/KeyChainException
    //   6	12	46	android/security/KeyChainException
    //   0	6	73	java/lang/InterruptedException
    //   6	12	77	java/lang/InterruptedException
  }
  
  private static void a(String paramString, Exception paramException)
  {
    paramException = String.valueOf(paramException);
    cvm.e("Email.Ssl", String.valueOf(paramString).length() + 27 + String.valueOf(paramException).length() + "Unable to retrieve " + paramString + " due to " + paramException, new Object[0]);
  }
  
  public final String chooseClientAlias(String[] paramArrayOfString, Principal[] paramArrayOfPrincipal, Socket paramSocket)
  {
    return a;
  }
  
  public final X509Certificate[] getCertificateChain(String paramString)
  {
    return b;
  }
  
  public final PrivateKey getPrivateKey(String paramString)
  {
    return c;
  }
}

/* Location:
 * Qualified Name:     bhg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */