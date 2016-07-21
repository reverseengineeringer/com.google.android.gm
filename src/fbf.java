import android.os.Binder;
import com.google.android.gms.drive.internal.OnEventResponse;

final class fbf
  extends fcj
{
  fbf(fbc paramfbc) {}
  
  public final void a(OnEventResponse paramOnEventResponse)
  {
    for (;;)
    {
      synchronized (a)
      {
        ffg.a("DriveEventService", "onEvent: " + paramOnEventResponse);
        fbc localfbc2 = a;
        int i = Binder.getCallingUid();
        if (i != f)
        {
          if (eik.a(localfbc2, i)) {
            f = i;
          }
        }
        else
        {
          if (a.d == null) {
            break label115;
          }
          paramOnEventResponse = a.d.obtainMessage(1, paramOnEventResponse);
          a.d.sendMessage(paramOnEventResponse);
          return;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
      }
      label115:
      ffg.c("DriveEventService", "Receiving event before initialize is completed.");
    }
  }
}

/* Location:
 * Qualified Name:     fbf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */