import android.support.v7.widget.ActionMenuPresenter;
import android.view.MenuItem;

public final class afh
  implements aek
{
  public afh(ActionMenuPresenter paramActionMenuPresenter) {}
  
  public final void a(adu paramadu, boolean paramBoolean)
  {
    if ((paramadu instanceof aep)) {
      m.b(false);
    }
    aek localaek = a.f;
    if (localaek != null) {
      localaek.a(paramadu, paramBoolean);
    }
  }
  
  public final boolean a_(adu paramadu)
  {
    if (paramadu == null) {
      return false;
    }
    a.q = ((aep)paramadu).getItem().getItemId();
    aek localaek = a.f;
    if (localaek != null) {
      return localaek.a_(paramadu);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     afh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */