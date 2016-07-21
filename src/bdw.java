import android.database.ContentObserver;
import java.lang.ref.WeakReference;

final class bdw
  extends ContentObserver
{
  WeakReference<bdv> a;
  
  public bdw(bdv parambdv)
  {
    super(null);
    a = new WeakReference(parambdv);
  }
  
  public final boolean deliverSelfNotifications()
  {
    return false;
  }
  
  public final void onChange(boolean paramBoolean)
  {
    bdv localbdv = (bdv)a.get();
    if (localbdv != null) {
      localbdv.i();
    }
  }
}

/* Location:
 * Qualified Name:     bdw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */