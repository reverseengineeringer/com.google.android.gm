import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import com.google.android.gm.provider.GmailProvider;
import com.google.android.gm.provider.MailIndexerService;
import java.util.Iterator;
import java.util.Set;

final class dqv
  implements dvb
{
  static final String a = drp.b;
  final ThreadLocal<dqx> b;
  final SQLiteDatabase c;
  final String d;
  private final Context e;
  private final drp f;
  private SQLiteTransactionListener g;
  
  public dqv(Context paramContext, drp paramdrp, String paramString)
  {
    e = paramContext;
    d = paramString;
    f = paramdrp;
    c = f.p;
    b = new dqw(this);
  }
  
  private final Set<Long> c()
  {
    return b.get()).a;
  }
  
  public final void a()
  {
    if (!c.inTransaction())
    {
      Set localSet = c();
      if (!localSet.isEmpty()) {
        dri.b(a, "Rolled back outermost conversation commit, NOT notifying on: %s", new Object[] { localSet });
      }
      localSet.clear();
      localSet = b();
      if (!localSet.isEmpty()) {
        dri.b(a, "Rolled back outermost label commit, NOT notifying on: %s", new Object[] { localSet });
      }
      localSet.clear();
    }
  }
  
  public final void a(long paramLong)
  {
    if (!c.inTransaction()) {
      dri.e(a, "Must already be in a transaction with listener to add conversation to notify. (id=%d)", new Object[] { Long.valueOf(paramLong) });
    }
    while (!c().add(Long.valueOf(paramLong))) {
      return;
    }
    dri.b(a, "adding convId (%d) to notify", new Object[] { Long.valueOf(paramLong) });
  }
  
  public final void a(boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject1;
    Object localObject2;
    if (!c.inTransaction())
    {
      localObject1 = c();
      if (!paramBoolean)
      {
        if (!((Set)localObject1).isEmpty())
        {
          dri.b(a, "Outermost commit complete, notifying on conversations: %s", new Object[] { localObject1 });
          localObject2 = ((Set)localObject1).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Long localLong = (Long)((Iterator)localObject2).next();
            GmailProvider.a(e, d, localLong.longValue());
          }
        }
        GmailProvider.c(e, d);
      }
      ((Set)localObject1).clear();
      localObject1 = b();
      f.b((Set)localObject1);
      ((Set)localObject1).clear();
      localObject1 = (dqx)b.get();
      if (c) {
        f.c(d);
      }
      c = false;
      d = false;
      int i = e;
      if (i != 0)
      {
        localObject2 = f;
        if (i != 2) {
          break label220;
        }
      }
    }
    label220:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((drp)localObject2).a(paramBoolean);
      e = 0;
      return;
    }
  }
  
  final Set<Long> b()
  {
    return b.get()).b;
  }
  
  public final void onBegin()
  {
    MailIndexerService.a(d);
    if (g != null) {
      g.onBegin();
    }
  }
  
  public final void onCommit()
  {
    if (g != null) {
      g.onCommit();
    }
  }
  
  public final void onRollback()
  {
    if (g != null) {
      g.onRollback();
    }
  }
}

/* Location:
 * Qualified Name:     dqv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */