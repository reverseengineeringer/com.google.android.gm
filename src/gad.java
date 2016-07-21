import android.os.IInterface;
import com.google.android.gms.search.global.GetCurrentExperimentIdsCall.Request;
import com.google.android.gms.search.global.GetGlobalSearchSourcesCall.Request;
import com.google.android.gms.search.global.GetPendingExperimentIdsCall.Request;
import com.google.android.gms.search.global.SetExperimentIdsCall.Request;
import com.google.android.gms.search.global.SetIncludeInGlobalSearchCall.Request;

public abstract interface gad
  extends IInterface
{
  public abstract void a(GetCurrentExperimentIdsCall.Request paramRequest, gaa paramgaa);
  
  public abstract void a(GetGlobalSearchSourcesCall.Request paramRequest, gaa paramgaa);
  
  public abstract void a(GetPendingExperimentIdsCall.Request paramRequest, gaa paramgaa);
  
  public abstract void a(SetExperimentIdsCall.Request paramRequest, gaa paramgaa);
  
  public abstract void a(SetIncludeInGlobalSearchCall.Request paramRequest, gaa paramgaa);
}

/* Location:
 * Qualified Name:     gad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */