import android.app.Notification.Action;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.app.RemoteInput;

final class hu
{
  static Notification.Action a(hz paramhz)
  {
    Notification.Action.Builder localBuilder = new Notification.Action.Builder(paramhz.a(), paramhz.b(), paramhz.c()).addExtras(paramhz.d());
    paramhz = paramhz.e();
    if (paramhz != null)
    {
      paramhz = iz.a(paramhz);
      int j = paramhz.length;
      int i = 0;
      while (i < j)
      {
        localBuilder.addRemoteInput(paramhz[i]);
        i += 1;
      }
    }
    return localBuilder.build();
  }
  
  public static void a(Notification.Builder paramBuilder, hz paramhz)
  {
    Notification.Action.Builder localBuilder = new Notification.Action.Builder(paramhz.a(), paramhz.b(), paramhz.c());
    if (paramhz.e() != null)
    {
      RemoteInput[] arrayOfRemoteInput = iz.a(paramhz.e());
      int j = arrayOfRemoteInput.length;
      int i = 0;
      while (i < j)
      {
        localBuilder.addRemoteInput(arrayOfRemoteInput[i]);
        i += 1;
      }
    }
    if (paramhz.d() != null) {
      localBuilder.addExtras(paramhz.d());
    }
    paramBuilder.addAction(localBuilder.build());
  }
}

/* Location:
 * Qualified Name:     hu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */