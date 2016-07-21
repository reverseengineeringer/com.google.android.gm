import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

class ddm
  implements SocketFactory
{
  private SocketFactory a;
  
  ddm(ddj paramddj, SocketFactory paramSocketFactory)
  {
    a = paramSocketFactory;
  }
  
  public final Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
  {
    b.b.set(Boolean.valueOf(true));
    return a.connectSocket(paramSocket, paramString, paramInt1, paramInetAddress, paramInt2, paramHttpParams);
  }
  
  public final Socket createSocket()
  {
    return a.createSocket();
  }
  
  public final boolean isSecure(Socket paramSocket)
  {
    return a.isSecure(paramSocket);
  }
}

/* Location:
 * Qualified Name:     ddm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */