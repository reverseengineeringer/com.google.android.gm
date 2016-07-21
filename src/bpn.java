import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;

final class bpn
  implements ConnPerRoute
{
  public final int getMaxForRoute(HttpRoute paramHttpRoute)
  {
    return 8;
  }
}

/* Location:
 * Qualified Name:     bpn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */