import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class gkd
  implements gjx, gjy
{
  final List<gka> a = new CopyOnWriteArrayList();
  final List<gjz> b = new CopyOnWriteArrayList();
  private final Application c;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private int f = 0;
  
  gkd(Application paramApplication)
  {
    c = ((Application)gol.a(paramApplication));
    if (paramApplication.getResources() != null) {
      f = getResourcesgetConfigurationorientation;
    }
  }
  
  private final boolean a()
  {
    boolean bool = false;
    int i = c.getResources().getConfiguration().orientation;
    if (f != i)
    {
      bool = true;
      f = i;
    }
    return bool;
  }
  
  private final void c(Activity paramActivity)
  {
    if (!gmy.a(paramActivity.getApplicationContext()))
    {
      if (d)
      {
        d = false;
        paramActivity = b.iterator();
        while (paramActivity.hasNext()) {
          ((gjz)paramActivity.next()).a();
        }
      }
    }
    else if (!d)
    {
      d = true;
      paramActivity = a.iterator();
      while (paramActivity.hasNext()) {
        ((gka)paramActivity.next()).a();
      }
    }
  }
  
  public final void a(Activity paramActivity)
  {
    if (!e)
    {
      c(paramActivity);
      return;
    }
    e = a();
  }
  
  public final void b(Activity paramActivity)
  {
    e = a();
    if (!e) {
      c(paramActivity);
    }
  }
}

/* Location:
 * Qualified Name:     gkd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */