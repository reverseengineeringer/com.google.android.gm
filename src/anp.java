import android.util.LruCache;

public class anp
  extends anq<anl, ann>
  implements anf
{
  private static final String d = anp.class.getSimpleName();
  private boolean a = false;
  private final Object b = new Object();
  private LruCache<anl, ano> c = new LruCache(100);
  
  public anp(int paramInt)
  {
    super(paramInt, 0.0F);
  }
  
  private final ann a(anl paramanl, ann paramann)
  {
    if ((c != null) && ((paramann == null) || (paramann == ano.f())))
    {
      c.put(paramanl, ano.f());
      return null;
    }
    return (ann)super.a(paramanl, paramann);
  }
  
  private final ann a(anl paramanl, boolean paramBoolean)
  {
    if ((c != null) && (c.get(paramanl) != null)) {
      return ano.f();
    }
    return (ann)super.a(paramanl, paramBoolean);
  }
  
  private final void a(ann paramann)
  {
    synchronized (b)
    {
      super.b(paramann);
      b.notify();
      return;
    }
  }
  
  private final ann c()
  {
    for (;;)
    {
      synchronized (b)
      {
        ann localann1 = (ann)super.b();
        if ((localann1 == null) && (a)) {
          ans.a("sleep");
        }
      }
      try
      {
        b.wait();
        ans.a();
        continue;
        localann2 = finally;
        throw localann2;
        return localann2;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
      }
    }
  }
}

/* Location:
 * Qualified Name:     anp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */