import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

final class dwo
  extends Filter
{
  dwo(dwj paramdwj) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    List localList = null;
    if (a.j == null) {
      return null;
    }
    String str = paramCharSequence.toString();
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    localdwq = new dwq();
    values = localdwq;
    if (TextUtils.isEmpty(paramCharSequence))
    {
      a = true;
      b = a.a.a(str, null);
      return localFilterResults;
    }
    cvm.a(a.c, "Issuing suggestion request for '%s'", new Object[] { str });
    a.k = SystemClock.elapsedRealtime();
    for (;;)
    {
      try
      {
        l1 = SystemClock.elapsedRealtime();
        paramCharSequence = a;
        cwv.b();
        if (j != null) {
          continue;
        }
        paramCharSequence = null;
        if (a.g != null) {
          a.g.a(SystemClock.elapsedRealtime() - l1);
        }
        localObject = a.a;
        if (paramCharSequence != null) {
          localList = suggestions;
        }
        b = ((dwp)localObject).a(str, localList);
        a = true;
        if (a.g != null) {
          a.g.a(false);
        }
      }
      catch (IOException paramCharSequence)
      {
        long l1;
        Object localObject;
        long l2;
        if (a.g == null) {
          continue;
        }
        if (!(paramCharSequence instanceof SocketTimeoutException)) {
          continue;
        }
        a.g.a(true);
        a.g.a(paramCharSequence);
        cvm.e(a.c, "Exception caught while querying for ASFE suggestions: %s\n%s", new Object[] { paramCharSequence.getClass(), paramCharSequence.getMessage() });
        continue;
        paramCharSequence = b;
        continue;
      }
      l1 = SystemClock.elapsedRealtime();
      l2 = a.k;
      if ((b == null) || (!(b instanceof Collection))) {
        continue;
      }
      paramCharSequence = Integer.toString(((Collection)b).size());
      cvm.a(a.c, "Suggestion req '%s' finished in %d ms: success: %b, suggestions: %s", new Object[] { str, Long.valueOf(l1 - l2), Boolean.valueOf(a), paramCharSequence });
      return localFilterResults;
      localObject = new gvx();
      client = b;
      query = str;
      paramCharSequence = (gvy)new gvt(j, (gvx)localObject).c();
    }
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    dwp localdwp = a.a;
    if (paramFilterResults != null) {}
    for (paramFilterResults = (dwq)values;; paramFilterResults = null)
    {
      localdwp.a(paramCharSequence, paramFilterResults);
      paramFilterResults = (dws)a.h.poll();
      int i = paramCharSequence.hashCode();
      for (paramCharSequence = paramFilterResults; (paramCharSequence != null) && (a != i); paramCharSequence = (dws)a.h.poll()) {}
    }
    if (paramCharSequence != null) {
      a.g.b(SystemClock.elapsedRealtime() - b);
    }
  }
}

/* Location:
 * Qualified Name:     dwo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */