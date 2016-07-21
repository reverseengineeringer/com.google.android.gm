import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.conn.scheme.HostNameResolver;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class bhc
  implements LayeredSocketFactory
{
  public static final X509HostnameVerifier a = new AllowAllHostnameVerifier();
  public static final X509HostnameVerifier b = new BrowserCompatHostnameVerifier();
  public static final X509HostnameVerifier c = new StrictHostnameVerifier();
  private static final bhc e = new bhc();
  X509HostnameVerifier d = b;
  private final SSLContext f = null;
  private final SSLSocketFactory g;
  private final HostNameResolver h;
  
  private bhc()
  {
    g = HttpsURLConnection.getDefaultSSLSocketFactory();
    h = null;
  }
  
  public bhc(SSLSocketFactory paramSSLSocketFactory)
  {
    g = paramSSLSocketFactory;
    h = null;
  }
  
  public final Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Target host may not be null.");
    }
    if (paramHttpParams == null) {
      throw new IllegalArgumentException("Parameters may not be null.");
    }
    SSLSocket localSSLSocket;
    int i;
    if (paramSocket != null)
    {
      localSSLSocket = (SSLSocket)paramSocket;
      if ((paramInetAddress != null) || (paramInt2 > 0))
      {
        i = paramInt2;
        if (paramInt2 < 0) {
          i = 0;
        }
        localSSLSocket.bind(new InetSocketAddress(paramInetAddress, i));
      }
      paramInt2 = HttpConnectionParams.getConnectionTimeout(paramHttpParams);
      i = HttpConnectionParams.getSoTimeout(paramHttpParams);
      if (h == null) {
        break label160;
      }
    }
    label160:
    for (paramSocket = new InetSocketAddress(h.resolve(paramString), paramInt1);; paramSocket = new InetSocketAddress(paramString, paramInt1))
    {
      localSSLSocket.connect(paramSocket, paramInt2);
      localSSLSocket.setSoTimeout(i);
      try
      {
        localSSLSocket.startHandshake();
        d.verify(paramString, localSSLSocket);
        return localSSLSocket;
      }
      catch (IOException paramSocket) {}
      paramSocket = createSocket();
      break;
    }
    try
    {
      localSSLSocket.close();
      throw paramSocket;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  public final Socket createSocket()
  {
    return g.createSocket();
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = (SSLSocket)g.createSocket(paramSocket, paramString, paramInt, paramBoolean);
    paramSocket.startHandshake();
    d.verify(paramString, paramSocket);
    return paramSocket;
  }
  
  public final boolean isSecure(Socket paramSocket)
  {
    if (paramSocket == null) {
      throw new IllegalArgumentException("Socket may not be null.");
    }
    if (!(paramSocket instanceof SSLSocket)) {
      throw new IllegalArgumentException("Socket not created by this factory.");
    }
    if (paramSocket.isClosed()) {
      throw new IllegalArgumentException("Socket is closed.");
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     bhc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */