import android.content.Context;
import android.os.SystemClock;
import com.android.email.service.AttachmentService;
import com.android.emailcommon.provider.Attachment;

public final class bag
{
  public final int a;
  public final long b;
  public final long c;
  public final long d;
  public final long e;
  public boolean f = false;
  public int g;
  public int h;
  public long i;
  public long j;
  public long k;
  public long l;
  
  public bag(Context paramContext, Attachment paramAttachment)
  {
    c = D;
    paramContext = beb.a(paramContext, o);
    if (paramContext != null)
    {
      e = V;
      d = D;
    }
    for (;;)
    {
      a = AttachmentService.a(paramAttachment);
      b = SystemClock.elapsedRealtime();
      return;
      d = -1L;
      e = -1L;
    }
  }
  
  public bag(bag parambag, long paramLong)
  {
    a = a;
    c = c;
    d = d;
    e = e;
    b = paramLong;
    f = f;
    g = g;
    h = h;
    i = i;
    j = j;
    k = k;
    l = l;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof bag)) {}
    while (c != c) {
      return false;
    }
    return true;
  }
  
  public final int hashCode()
  {
    return (int)c;
  }
}

/* Location:
 * Qualified Name:     bag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */