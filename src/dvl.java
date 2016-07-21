import android.content.Loader;

public final class dvl
  implements Runnable
{
  public dvl(dvk paramdvk) {}
  
  public final void run()
  {
    synchronized (a.d)
    {
      if (a.c == null) {
        a.c = new dpf(a.e, a.f, a.g, a.i);
      }
      dri.b(dvk.a, "starting attachment loader for conversation %d", new Object[] { Long.valueOf(a.g) });
      dpf localdpf = a.c;
      i = a;
      if (!j)
      {
        dri.b(dpf.a, "ASL start for conversation %d", new Object[] { Long.valueOf(c) });
        e.startLoading();
        j = true;
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dvl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */