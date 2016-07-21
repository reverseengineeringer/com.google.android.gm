import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.libraries.social.silentfeedback.nobinder.SilentFeedbackService;

public final class gok
  implements eje
{
  public gok(SilentFeedbackService paramSilentFeedbackService) {}
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    int i = c;
    Log.e("SilentFeedbackService", 74 + "GoogleApiClient silent feedback connection failed with result: " + i);
    a.a();
  }
}

/* Location:
 * Qualified Name:     gok
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */