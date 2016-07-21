import android.os.IInterface;
import com.google.android.gms.search.global.GetCurrentExperimentIdsCall.Response;
import com.google.android.gms.search.global.GetGlobalSearchSourcesCall.Response;
import com.google.android.gms.search.global.GetPendingExperimentIdsCall.Response;
import com.google.android.gms.search.global.SetExperimentIdsCall.Response;
import com.google.android.gms.search.global.SetIncludeInGlobalSearchCall.Response;

public abstract interface gaa
  extends IInterface
{
  public abstract void a(GetCurrentExperimentIdsCall.Response paramResponse);
  
  public abstract void a(GetGlobalSearchSourcesCall.Response paramResponse);
  
  public abstract void a(GetPendingExperimentIdsCall.Response paramResponse);
  
  public abstract void a(SetExperimentIdsCall.Response paramResponse);
  
  public abstract void a(SetIncludeInGlobalSearchCall.Response paramResponse);
}

/* Location:
 * Qualified Name:     gaa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */