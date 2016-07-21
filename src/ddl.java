import java.net.Socket;
import org.apache.http.conn.scheme.LayeredSocketFactory;

final class ddl
  extends ddm
  implements LayeredSocketFactory
{
  private LayeredSocketFactory c;
  
  ddl(ddj paramddj, LayeredSocketFactory paramLayeredSocketFactory)
  {
    super(paramddj, paramLayeredSocketFactory);
    c = paramLayeredSocketFactory;
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return c.createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}

/* Location:
 * Qualified Name:     ddl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */