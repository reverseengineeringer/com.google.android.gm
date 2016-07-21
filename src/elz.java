import java.lang.ref.WeakReference;
import java.util.Arrays;

public final class elz
  extends elx
{
  private WeakReference<elt> d;
  
  protected final void a()
  {
    d.get();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof elz)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (elz)paramObject;
    elt localelt1 = (elt)d.get();
    elt localelt2 = (elt)d.get();
    return (localelt2 != null) && (localelt1 != null) && (enx.a(localelt2, localelt1)) && (enx.a(a, a));
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { a });
  }
}

/* Location:
 * Qualified Name:     elz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */