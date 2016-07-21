import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.administration.BundleResponse;
import com.google.android.gms.search.administration.GetStorageStatsCall.Response;

public abstract interface fqh
  extends IInterface
{
  public abstract void a(Status paramStatus);
  
  public abstract void a(BundleResponse paramBundleResponse);
  
  public abstract void a(GetStorageStatsCall.Response paramResponse);
}

/* Location:
 * Qualified Name:     fqh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */