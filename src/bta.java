import android.content.Context;
import android.telephony.TelephonyManager;

public final class bta
{
  public TelephonyManager a;
  private btb b;
  private final String c = "US";
  
  public bta(Context paramContext)
  {
    this((TelephonyManager)paramContext.getSystemService("phone"), new btb());
  }
  
  private bta(TelephonyManager paramTelephonyManager, btb parambtb)
  {
    a = paramTelephonyManager;
    b = parambtb;
  }
}

/* Location:
 * Qualified Name:     bta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */