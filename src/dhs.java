import android.app.Activity;
import android.webkit.WebView.HitTestResult;

final class dhs
  extends cah
{
  public dhs(dhn paramdhn, Activity paramActivity, byh parambyh)
  {
    super(paramActivity, parambyh);
  }
  
  protected final boolean a(WebView.HitTestResult paramHitTestResult)
  {
    if ((paramHitTestResult != null) && (paramHitTestResult.getExtra() != null)) {
      return !dhn.a(c.getActivity(), paramHitTestResult.getExtra(), c.ad);
    }
    return super.a(paramHitTestResult);
  }
}

/* Location:
 * Qualified Name:     dhs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */