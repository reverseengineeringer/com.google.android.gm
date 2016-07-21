import android.os.AsyncTask;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

final class cbr
  extends AsyncTask<Void, Void, Bundle>
{
  cbr(List paramList1, List paramList2, List paramList3, cbk paramcbk) {}
  
  private final Bundle a()
  {
    ??? = new ArrayList();
    if (a != null) {
      ((List)???).addAll(a);
    }
    if (b != null) {
      ((List)???).addAll(b);
    }
    if (c != null) {
      ((List)???).addAll(c);
    }
    if (((List)???).size() == 0) {
      return null;
    }
    Iterator localIterator = ((List)???).iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = cui.b(str1);
      if (d.W.c(str2)) {
        synchronized (d.W)
        {
          d.W.a(str2, str1);
          buo.a().a("gmail_tls", "prediction_request_cache", "hit", 0L);
        }
      }
      d.X.add(str1);
    }
    return d.v();
  }
}

/* Location:
 * Qualified Name:     cbr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */