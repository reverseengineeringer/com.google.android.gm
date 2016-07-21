import android.view.View;
import android.view.View.OnClickListener;
import com.android.mail.ui.CustomViewToolbar;

public final class cmv
  implements View.OnClickListener
{
  public cmv(CustomViewToolbar paramCustomViewToolbar) {}
  
  public final void onClick(View paramView)
  {
    but localbut = buo.a();
    paramView = String.valueOf(a.v.a());
    if (paramView.length() != 0) {}
    for (paramView = "action_bar/".concat(paramView);; paramView = new String("action_bar/"))
    {
      localbut.a("menu_item", "search", paramView, 0L);
      a.u.W();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cmv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */