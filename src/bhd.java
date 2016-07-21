import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class bhd
  extends SSLSocketFactory
{
  private final SSLSocketFactory a;
  private final boolean b;
  private final int c;
  private final String[] d;
  private final String[] e = { "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_RSA_WITH_3DES_EDE_CBC_SHA", "SSL_RSA_WITH_RC4_128_MD5", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", "SSL_RSA_EXPORT_WITH_RC4_40_MD5", "SSL_DHE_DSS_WITH_DES_CBC_SHA", "SSL_DHE_RSA_WITH_DES_CBC_SHA", "SSL_RSA_WITH_DES_CBC_SHA" };
  
  bhd(SSLSocketFactory paramSSLSocketFactory, boolean paramBoolean, int paramInt)
  {
    a = paramSSLSocketFactory;
    b = paramBoolean;
    c = 30000;
    a.getDefaultCipherSuites();
    paramSSLSocketFactory = new ArrayList(Arrays.asList(a.getDefaultCipherSuites()));
    HashSet localHashSet1 = new HashSet(paramSSLSocketFactory);
    a.getSupportedCipherSuites();
    HashSet localHashSet2 = new HashSet(Arrays.asList(a.getSupportedCipherSuites()));
    String[] arrayOfString = e;
    int i = arrayOfString.length;
    while (paramInt < i)
    {
      String str = arrayOfString[paramInt];
      if ((localHashSet2.contains(str)) && (!localHashSet1.contains(str))) {
        paramSSLSocketFactory.add(str);
      }
      paramInt += 1;
    }
    d = new String[paramSSLSocketFactory.size()];
    paramSSLSocketFactory.toArray(d);
  }
  
  private static void a(Socket paramSocket, String paramString)
  {
    if (!(paramSocket instanceof SSLSocket)) {
      throw new IllegalArgumentException("Attempt to verify non-SSL socket");
    }
    paramSocket = (SSLSocket)paramSocket;
    paramSocket.startHandshake();
    paramSocket = paramSocket.getSession();
    if (paramSocket == null) {
      throw new SSLException("Cannot verify SSL socket without session");
    }
    cvm.b(cvm.a, "using cipherSuite %s", new Object[] { paramSocket.getCipherSuite() });
    if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(paramString, paramSocket))
    {
      paramSocket = String.valueOf(paramString);
      if (paramSocket.length() != 0) {}
      for (paramSocket = "Cannot verify hostname: ".concat(paramSocket);; paramSocket = new String("Cannot verify hostname: ")) {
        throw new SSLPeerUnverifiedException(paramSocket);
      }
    }
  }
  
  private static void a(SSLSocket paramSSLSocket, int paramInt)
  {
    try
    {
      paramSSLSocket.getClass().getMethod("setHandshakeTimeout", new Class[] { Integer.TYPE }).invoke(paramSSLSocket, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSSLSocket)
    {
      cvm.d(cvm.a, paramSSLSocket, "unable to set handshake timeout", new Object[0]);
    }
  }
  
  public final Socket createSocket()
  {
    return a.createSocket();
  }
  
  public final Socket createSocket(String paramString, int paramInt)
  {
    SSLSocket localSSLSocket = (SSLSocket)a.createSocket(paramString, paramInt);
    a(localSSLSocket, c);
    localSSLSocket.setEnabledCipherSuites(d);
    if (b) {
      a(localSSLSocket, paramString);
    }
    return localSSLSocket;
  }
  
  public final Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    paramInetAddress = (SSLSocket)a.createSocket(paramString, paramInt1, paramInetAddress, paramInt2);
    a(paramInetAddress, c);
    paramInetAddress.setEnabledCipherSuites(d);
    if (b) {
      a(paramInetAddress, paramString);
    }
    return paramInetAddress;
  }
  
  public final Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    paramInetAddress = (SSLSocket)a.createSocket(paramInetAddress, paramInt);
    a(paramInetAddress, c);
    paramInetAddress.setEnabledCipherSuites(d);
    return paramInetAddress;
  }
  
  public final Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    paramInetAddress1 = (SSLSocket)a.createSocket(paramInetAddress1, paramInt1, paramInetAddress2, paramInt2);
    a(paramInetAddress1, c);
    paramInetAddress1.setEnabledCipherSuites(d);
    return paramInetAddress1;
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = (SSLSocket)a.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    a(paramSocket, c);
    paramSocket.setEnabledCipherSuites(d);
    if (b) {
      a(paramSocket, paramString);
    }
    return paramSocket;
  }
  
  public final String[] getDefaultCipherSuites()
  {
    return (String[])d.clone();
  }
  
  public final String[] getSupportedCipherSuites()
  {
    return a.getSupportedCipherSuites();
  }
}

/* Location:
 * Qualified Name:     bhd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */