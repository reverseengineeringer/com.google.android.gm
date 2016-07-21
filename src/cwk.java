import android.database.DataSetObservable;

public final class cwk<E>
  extends oj<E>
{
  public final DataSetObservable e = new DataSetObservable();
  
  public final void a(int paramInt, E paramE)
  {
    super.a(paramInt, paramE);
    e.notifyChanged();
  }
  
  public final void b()
  {
    super.b();
    e.notifyChanged();
  }
  
  public final void b(int paramInt)
  {
    super.b(paramInt);
    e.notifyChanged();
  }
  
  public final void c(int paramInt)
  {
    super.c(paramInt);
    e.notifyChanged();
  }
  
  public final void d(int paramInt)
  {
    super.d(paramInt);
    e.notifyChanged();
  }
}

/* Location:
 * Qualified Name:     cwk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */