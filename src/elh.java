import com.google.android.gms.common.data.DataHolder;
import java.util.Iterator;

public abstract class elh<T>
  implements eli<T>
{
  public final DataHolder a;
  
  public elh(DataHolder paramDataHolder)
  {
    a = paramDataHolder;
    if (a != null) {
      a.j = this;
    }
  }
  
  public final void b()
  {
    if (a != null) {
      a.c();
    }
  }
  
  public int c()
  {
    if (a == null) {
      return 0;
    }
    return a.h;
  }
  
  @Deprecated
  public final void d()
  {
    b();
  }
  
  public Iterator<T> iterator()
  {
    return new elp(this);
  }
}

/* Location:
 * Qualified Name:     elh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */