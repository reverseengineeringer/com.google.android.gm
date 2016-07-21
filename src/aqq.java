import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import java.util.HashSet;

final class aqq
  extends ContentObserver
{
  private final Context a;
  private final long b;
  
  public aqq(Handler paramHandler, Context paramContext, long paramLong)
  {
    super(paramHandler);
    a = paramContext;
    b = paramLong;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    Context localContext = a;
    long l = b;
    synchronized (aql.k)
    {
      if (aql.h)
      {
        aql.j.add(Long.valueOf(l));
        return;
      }
      aql.b();
      aql.b.sendMessageDelayed(Message.obtain(aql.b, 0, localContext), 15000L);
      aql.h = true;
      aql.a(localContext, l);
    }
  }
}

/* Location:
 * Qualified Name:     aqq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */