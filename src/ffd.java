import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.internal.OnDriveIdResponse;

final class ffd
  extends fdx
{
  private final ejr<far> a;
  
  public ffd(ejr<far> paramejr)
  {
    a = paramejr;
  }
  
  public final void a(Status paramStatus)
  {
    a.a(new ffe(paramStatus, null));
  }
  
  public final void a(OnDriveIdResponse paramOnDriveIdResponse)
  {
    a.a(new ffe(Status.a, new fey(b)));
  }
}

/* Location:
 * Qualified Name:     ffd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */