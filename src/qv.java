import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class qv
{
  private final DataSetObservable a = new DataSetObservable();
  private DataSetObserver b;
  
  public abstract int a();
  
  public CharSequence a(int paramInt)
  {
    return null;
  }
  
  public Object a(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  public Object a(ViewGroup paramViewGroup, int paramInt)
  {
    return a(paramViewGroup, paramInt);
  }
  
  public final void a(DataSetObserver paramDataSetObserver)
  {
    try
    {
      b = paramDataSetObserver;
      return;
    }
    finally {}
  }
  
  public void a(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public void a(View paramView, int paramInt, Object paramObject)
  {
    throw new UnsupportedOperationException("Required method destroyItem was not overridden");
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    a(paramViewGroup, paramInt, paramObject);
  }
  
  public void a(Object paramObject) {}
  
  public abstract boolean a(View paramView, Object paramObject);
  
  public int b(Object paramObject)
  {
    return -1;
  }
  
  public void b()
  {
    c();
  }
  
  public void b(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    a(paramObject);
  }
  
  public void c() {}
  
  public Parcelable d()
  {
    return null;
  }
  
  public void e()
  {
    try
    {
      if (b != null) {
        b.onChanged();
      }
      a.notifyChanged();
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     qv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */