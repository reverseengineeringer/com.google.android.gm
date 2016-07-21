import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;

final class cyn
  implements Runnable
{
  cyn(cym paramcym) {}
  
  public final void run()
  {
    Object localObject = a.b.peekDecorView();
    if (localObject != null)
    {
      a.d.a((View)localObject);
      return;
    }
    localObject = a;
    c -= 1;
    if (a.c >= 0)
    {
      a.a.post(a.e);
      return;
    }
    localObject = String.valueOf(a.b);
    Log.w("SystemBarHelper", String.valueOf(localObject).length() + 33 + "Cannot get decor view of window: " + (String)localObject);
  }
}

/* Location:
 * Qualified Name:     cyn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */