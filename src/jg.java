import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

public final class jg
  implements Iterable<Intent>
{
  private static final ji c = new jj();
  public final ArrayList<Intent> a = new ArrayList();
  public final Context b;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      c = new jk();
      return;
    }
  }
  
  private jg(Context paramContext)
  {
    b = paramContext;
  }
  
  public static jg a(Context paramContext)
  {
    return new jg(paramContext);
  }
  
  public final PendingIntent a(int paramInt)
  {
    if (a.isEmpty()) {
      throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
    }
    Intent[] arrayOfIntent = (Intent[])a.toArray(new Intent[a.size()]);
    arrayOfIntent[0] = new Intent(arrayOfIntent[0]).addFlags(268484608);
    return c.a(b, arrayOfIntent, paramInt, 134217728);
  }
  
  public final jg a(ComponentName paramComponentName)
  {
    int i = a.size();
    try
    {
      for (paramComponentName = gs.a(b, paramComponentName); paramComponentName != null; paramComponentName = gs.a(b, paramComponentName.getComponent())) {
        a.add(i, paramComponentName);
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
      throw new IllegalArgumentException(paramComponentName);
    }
  }
  
  public final jg a(Intent paramIntent)
  {
    a.add(paramIntent);
    return this;
  }
  
  public final Iterator<Intent> iterator()
  {
    return a.iterator();
  }
}

/* Location:
 * Qualified Name:     jg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */