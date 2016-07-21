import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

abstract class ems
  extends emu<Boolean>
{
  public final int a;
  public final Bundle b;
  
  protected ems(emr paramemr, int paramInt, Bundle paramBundle)
  {
    super(paramemr, Boolean.valueOf(true));
    a = paramInt;
    b = paramBundle;
  }
  
  protected abstract void a(ConnectionResult paramConnectionResult);
  
  protected abstract boolean a();
}

/* Location:
 * Qualified Name:     ems
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */