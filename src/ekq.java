import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.lang.ref.WeakReference;

final class ekq
  extends BroadcastReceiver
{
  private WeakReference<ekj> a;
  
  ekq(ekj paramekj)
  {
    a = new WeakReference(paramekj);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getSchemeSpecificPart();
    }
    if ((paramContext == null) || (!paramContext.equals("com.google.android.gms"))) {}
    do
    {
      return;
      paramContext = (ekj)a.get();
    } while (paramContext == null);
    ekj.a(paramContext);
  }
}

/* Location:
 * Qualified Name:     ekq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */