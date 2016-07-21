import android.content.Context;
import android.os.Build.VERSION;
import android.view.GestureDetector.OnGestureListener;

public final class pb
{
  public final pc a;
  
  public pb(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      a = new pf(paramContext, paramOnGestureListener, null);
      return;
    }
    a = new pd(paramContext, paramOnGestureListener, null);
  }
}

/* Location:
 * Qualified Name:     pb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */