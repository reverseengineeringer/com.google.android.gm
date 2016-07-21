import android.content.Context;
import android.os.Build.VERSION;
import android.view.Menu;
import android.view.MenuItem;

public final class aen
{
  public static Menu a(Context paramContext, lk paramlk)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return new aeo(paramContext, paramlk);
    }
    throw new UnsupportedOperationException();
  }
  
  public static MenuItem a(Context paramContext, ll paramll)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return new aef(paramContext, paramll);
    }
    if (Build.VERSION.SDK_INT >= 14) {
      return new aea(paramContext, paramll);
    }
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     aen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */