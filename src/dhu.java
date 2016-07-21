import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gm.ads.AdWtaTooltipView;

public final class dhu
  implements View.OnClickListener
{
  private final Context b;
  
  public dhu(AdWtaTooltipView paramAdWtaTooltipView, Context paramContext)
  {
    b = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    paramView = (Activity)b;
    dev.a(paramView);
    new dyv().a(paramView, a.b, "about_ads", null);
  }
}

/* Location:
 * Qualified Name:     dhu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */