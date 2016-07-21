import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

final class dl
  implements Drawable.Callback
{
  dl(dk paramdk) {}
  
  public final void invalidateDrawable(Drawable paramDrawable)
  {
    a.invalidateSelf();
  }
  
  public final void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    a.scheduleSelf(paramRunnable, paramLong);
  }
  
  public final void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    a.unscheduleSelf(paramRunnable);
  }
}

/* Location:
 * Qualified Name:     dl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */