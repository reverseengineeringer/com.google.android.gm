import java.util.ArrayList;

public abstract class emu<TListener>
{
  TListener d;
  boolean e;
  
  public emu(TListener paramTListener)
  {
    Object localObject;
    d = localObject;
    e = false;
  }
  
  protected abstract void a(TListener paramTListener);
  
  public final void b()
  {
    c();
    synchronized (emr.c(f))
    {
      emr.c(f).remove(this);
      return;
    }
  }
  
  public final void c()
  {
    try
    {
      d = null;
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     emu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */