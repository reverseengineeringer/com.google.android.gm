import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.mail.providers.Account;

public abstract class cdk
  extends cdi
  implements View.OnClickListener
{
  private final cnp f;
  private final int g;
  private final int h;
  
  cdk(ckv paramckv, Account paramAccount, cnp paramcnp, int paramInt1, int paramInt2)
  {
    super(paramckv, null, 0, paramAccount);
    f = paramcnp;
    g = paramInt1;
    h = paramInt2;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null) {}
    for (paramView = (ViewGroup)paramView;; paramView = (ViewGroup)d.inflate(bue.B, paramViewGroup, false))
    {
      ((TextView)paramView.findViewById(buc.bj)).setText(h);
      ((ImageView)paramView.findViewById(buc.bi)).setImageResource(g);
      return paramView;
    }
  }
  
  public abstract void c();
  
  protected final String d()
  {
    String str = String.valueOf(c.v_().a());
    if (str.length() != 0) {
      return "drawer_footer/".concat(str);
    }
    return new String("drawer_footer/");
  }
  
  public final void onClick(View paramView)
  {
    if (c.p().a())
    {
      c.n().a(false, null, null);
      f.a = this;
      return;
    }
    c();
  }
}

/* Location:
 * Qualified Name:     cdk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */