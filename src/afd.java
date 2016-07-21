import android.support.v7.widget.ActionMenuPresenter;
import android.view.View;

public final class afd
  implements Runnable
{
  private afg b;
  
  public afd(ActionMenuPresenter paramActionMenuPresenter, afg paramafg)
  {
    b = paramafg;
  }
  
  public final void run()
  {
    Object localObject = a.c;
    if (b != null) {
      b.a((adu)localObject);
    }
    localObject = (View)a.g;
    if ((localObject != null) && (((View)localObject).getWindowToken() != null) && (b.e())) {
      a.m = b;
    }
    a.o = null;
  }
}

/* Location:
 * Qualified Name:     afd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */