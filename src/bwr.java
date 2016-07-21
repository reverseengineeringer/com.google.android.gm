import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class bwr
  extends cda
  implements cuf
{
  bws a;
  int b;
  final bwt c;
  boolean d = false;
  final Map<String, Integer> e;
  public final Map<Long, Integer> f;
  final List<bwu> g;
  boolean h = false;
  private int i = 1;
  private boolean j;
  
  public bwr(Cursor paramCursor, boolean paramBoolean)
  {
    super(paramCursor);
    j = paramBoolean;
    c = new bwt(this, new Handler(Looper.getMainLooper()));
    if (paramCursor != null)
    {
      paramCursor.registerContentObserver(c);
      d = true;
    }
    long l1 = SystemClock.uptimeMillis();
    cxa.g("blockingCaching");
    int k;
    HashMap localHashMap2;
    HashMap localHashMap1;
    if (super.moveToFirst())
    {
      int m = super.getCount();
      paramCursor = new bwu[m];
      k = 0;
      localHashMap2 = new HashMap(m);
      localHashMap1 = new HashMap(m);
      int n;
      do
      {
        String str = super.getString(1);
        long l2 = super.getLong(0);
        if (localHashMap2.containsKey(str)) {
          cvm.e("ConversationCursor", "Inserting duplicate conversation uri key: %s. Cursor position: %d, iteration: %d map position: %d", new Object[] { str, Integer.valueOf(getPosition()), Integer.valueOf(k), localHashMap2.get(str) });
        }
        if (localHashMap1.containsKey(Long.valueOf(l2))) {
          cvm.e("ConversationCursor", "Inserting duplicate conversation id key: %d. Cursor position: %d, iteration: %d map position: %d", new Object[] { Long.valueOf(l2), Integer.valueOf(getPosition()), Integer.valueOf(k), localHashMap1.get(Long.valueOf(l2)) });
        }
        localHashMap2.put(str, Integer.valueOf(k));
        localHashMap1.put(Long.valueOf(l2), Integer.valueOf(k));
        paramCursor[k] = new bwu(str);
        n = k + 1;
        k = n;
      } while (super.moveToPosition(n));
      if ((localHashMap2.size() != m) || (localHashMap1.size() != m))
      {
        k = localHashMap2.size();
        n = localHashMap1.size();
        throw new IllegalStateException(74 + "Unexpected map sizes: cursorN=" + m + " uriN=" + k + " idN=" + n);
      }
      k = m;
    }
    for (;;)
    {
      e = Collections.unmodifiableMap(localHashMap2);
      f = Collections.unmodifiableMap(localHashMap1);
      g = Collections.unmodifiableList(Arrays.asList(paramCursor));
      cvm.c("ConversationCursor", "ConversationCursor pre-loading took %sms n=%s", new Object[] { Long.valueOf(SystemClock.uptimeMillis() - l1), Integer.valueOf(k) });
      cxa.a();
      b = 0;
      return;
      k = 0;
      paramCursor = new bwu[0];
      localHashMap2 = new HashMap();
      localHashMap1 = new HashMap();
    }
  }
  
  private final void d()
  {
    if (a != null)
    {
      cvm.c("ConversationCursor", "Cancelling caching startPos=%s pos=%s", new Object[] { Integer.valueOf(a.a), Integer.valueOf(b) });
      a.cancel(false);
      a = null;
    }
  }
  
  public final int a(long paramLong)
  {
    Integer localInteger = (Integer)f.get(Long.valueOf(paramLong));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return -1;
  }
  
  public final void a()
  {
    d();
    j = false;
  }
  
  public final void a(cue paramcue, int paramInt)
  {
    int k = i;
    i = paramInt;
    if (k != paramInt)
    {
      if (paramInt != 0) {
        break label158;
      }
      if (a != null)
      {
        paramcue = String.valueOf(a);
        throw new IllegalStateException(String.valueOf(paramcue).length() + 26 + "unexpected existing task: " + paramcue);
      }
      if ((!j) || (b >= getCount())) {
        break label153;
      }
      a = new bws(this, b);
      a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
    label153:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        cvm.c("ConversationCursor", "Resuming caching, pos=%s idler=%s", new Object[] { Integer.valueOf(b), paramcue });
      }
      return;
    }
    label158:
    d();
  }
  
  public final String b()
  {
    return g.get(getPosition())).a;
  }
  
  public final void c()
  {
    if (d)
    {
      getWrappedCursor().unregisterContentObserver(c);
      d = false;
    }
  }
  
  public final void close()
  {
    a();
    c();
    super.close();
  }
}

/* Location:
 * Qualified Name:     bwr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */