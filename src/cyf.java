import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.android.setupwizardlib.view.NavigationBar;

public abstract class cyf
  implements View.OnClickListener
{
  final NavigationBar a;
  boolean b;
  boolean c = false;
  
  protected cyf(NavigationBar paramNavigationBar)
  {
    a = paramNavigationBar;
  }
  
  protected void a()
  {
    a.b.setOnClickListener(this);
  }
  
  protected abstract void b();
  
  public void onClick(View paramView)
  {
    b();
  }
}

/* Location:
 * Qualified Name:     cyf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */