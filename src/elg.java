import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.ConnectionResult;
import java.util.List;

final class elg
  implements Runnable
{
  private final int b;
  private final ConnectionResult c;
  
  public elg(eld parameld, int paramInt, ConnectionResult paramConnectionResult)
  {
    b = paramInt;
    c = paramConnectionResult;
  }
  
  public final void run()
  {
    if (c.a()) {
      try
      {
        int i = a.f().a_().d().indexOf(a);
        c.a(a.f(), (i + 1 << 16) + 1);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        eld.a(a);
        return;
      }
    }
    if (eik.c(c.c))
    {
      eik.a(c.c, a.f(), a, 2, a);
      return;
    }
    eld.a(a, b, c);
  }
}

/* Location:
 * Qualified Name:     elg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */