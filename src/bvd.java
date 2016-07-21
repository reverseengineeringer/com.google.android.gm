import android.content.Context;
import android.os.AsyncTask.Status;
import android.os.Handler;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class bvd
  implements Runnable
{
  static final String a = cvl.a;
  private static final Executor g;
  private static final Executor h;
  public final Context b;
  public final anf c;
  final LinkedHashSet<bvc> d;
  private final Handler e = new Handler();
  private bvf f;
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    g = localThreadPoolExecutor;
    h = localThreadPoolExecutor;
  }
  
  public bvd(Context paramContext, anf paramanf)
  {
    b = paramContext;
    c = paramanf;
    d = new LinkedHashSet();
  }
  
  public bvf a(LinkedHashSet<bvc> paramLinkedHashSet)
  {
    return new bvf(paramLinkedHashSet, b, c, this);
  }
  
  final void a()
  {
    cvm.b(a, "ContactResolver  > batch   %d", new Object[] { Integer.valueOf(d.size()) });
    e.removeCallbacks(this);
    e.post(this);
  }
  
  public final void a(bvb parambvb, bve parambve)
  {
    d.remove(new bvc(parambvb, parambve));
  }
  
  public void run()
  {
    if (d.isEmpty()) {
      return;
    }
    if ((f != null) && (f.getStatus() == AsyncTask.Status.RUNNING))
    {
      cvm.b(a, "ContactResolver << batch skip", new Object[0]);
      return;
    }
    bng.a("ContactResolver run");
    cvm.b(a, "ContactResolver >> batch start", new Object[0]);
    LinkedHashSet localLinkedHashSet = new LinkedHashSet(d);
    if (f != null) {
      f.cancel(true);
    }
    f = a(localLinkedHashSet);
    f.executeOnExecutor(h, new Void[0]);
    bng.a();
  }
}

/* Location:
 * Qualified Name:     bvd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */