import android.support.v4.widget.ContentLoadingProgressBar;

public final class wg
  implements Runnable
{
  public wg(ContentLoadingProgressBar paramContentLoadingProgressBar) {}
  
  public final void run()
  {
    a.c = false;
    if (!a.d)
    {
      a.a = System.currentTimeMillis();
      a.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     wg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */