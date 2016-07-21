import android.os.Build.VERSION;
import android.view.KeyEvent;

public final class pl
{
  public static final pp a = new pm();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new po();
      return;
    }
  }
  
  public static boolean a(KeyEvent paramKeyEvent, int paramInt)
  {
    return a.a(paramKeyEvent.getMetaState(), paramInt);
  }
}

/* Location:
 * Qualified Name:     pl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */