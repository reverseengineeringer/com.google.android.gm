import android.content.Loader;
import android.os.Looper;
import com.google.android.gm.provider.GmailProvider;
import java.util.Map;
import java.util.WeakHashMap;

public final class dqp
  extends cvp
{
  private final String b;
  private final long c;
  
  public dqp(GmailProvider paramGmailProvider, String paramString, long paramLong, String[] paramArrayOfString, int paramInt)
  {
    super(paramArrayOfString, paramInt);
    b = paramString;
    c = paramLong;
  }
  
  public final void close()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      dri.e("Gmail", "AttachmentCursor: close() called on thread: %s. There may be issues if you do not call close() on the main thread.", new Object[] { Thread.currentThread() });
    }
    for (;;)
    {
      Object localObject1;
      int i;
      synchronized (GmailProvider.e)
      {
        localObject1 = (dvj)GmailProvider.e.get(b);
        if (localObject1 != null)
        {
          localObject1 = ((dvj)localObject1).a(c);
          if (localObject1 != null) {
            synchronized (b)
            {
              b.remove(this);
              if (b.size() == 0)
              {
                i = 1;
                if (i == 0) {}
              }
            }
          }
        }
      }
      synchronized (d)
      {
        if (c != null)
        {
          dri.b(dvk.a, "attachment cursor closed, and stopping loader", new Object[0]);
          dpf localdpf = c;
          if (j)
          {
            dri.b(dpf.a, "ASL stop for conversation %d", new Object[] { Long.valueOf(c) });
            j = false;
            e.stopLoading();
            e.reset();
            f.stopLoading();
            f.reset();
            i = null;
          }
          c = null;
        }
        super.close();
        return;
        i = 0;
        continue;
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
    }
  }
}

/* Location:
 * Qualified Name:     dqp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */