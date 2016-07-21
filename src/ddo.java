import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public final class ddo
  extends HttpEntityWrapper
{
  final String a;
  final int b;
  final long c;
  final long d;
  final long e;
  final long f;
  
  public ddo(HttpEntity paramHttpEntity, String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    super(paramHttpEntity);
    a = paramString;
    b = paramInt;
    c = paramLong1;
    d = paramLong2;
    e = paramLong3;
    f = paramLong4;
  }
  
  public final InputStream getContent()
  {
    return new ddp(this, super.getContent());
  }
}

/* Location:
 * Qualified Name:     ddo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */