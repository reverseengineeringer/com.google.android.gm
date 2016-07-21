import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.HashSet;
import java.util.Iterator;

final class aqn
  implements Handler.Callback
{
  private static boolean a(Message paramMessage)
  {
    cvm.b(aql.a, "Delayed notification processing", new Object[0]);
    synchronized (aql.k)
    {
      aql.h = false;
      paramMessage = (Context)obj;
      if (aql.i)
      {
        aql.i = false;
        aql.b(paramMessage);
      }
      Iterator localIterator = aql.j.iterator();
      if (localIterator.hasNext()) {
        aql.a(paramMessage, ((Long)localIterator.next()).longValue());
      }
    }
    aql.j.clear();
    return true;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      return false;
    case 0: 
      return a(paramMessage);
    }
    ((Runnable)obj).run();
    return true;
  }
}

/* Location:
 * Qualified Name:     aqn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */