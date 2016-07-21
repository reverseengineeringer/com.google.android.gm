import com.android.setupwizardlib.view.BottomScrollView;
import com.android.setupwizardlib.view.NavigationBar;

public final class cyj
  extends cyf
  implements cyr
{
  private final BottomScrollView d;
  
  public cyj(NavigationBar paramNavigationBar, BottomScrollView paramBottomScrollView)
  {
    super(paramNavigationBar);
    d = paramBottomScrollView;
  }
  
  public final void a()
  {
    super.a();
    d.a = this;
  }
  
  protected final void b()
  {
    d.pageScroll(130);
  }
  
  public final void c()
  {
    if (b)
    {
      a.post(new cyg(this));
      b = false;
      c = true;
    }
  }
  
  public final void d()
  {
    if ((!b) && (!c))
    {
      a.post(new cyh(this));
      b = true;
    }
  }
}

/* Location:
 * Qualified Name:     cyj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */