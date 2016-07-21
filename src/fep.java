import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.internal.OnDriveIdResponse;
import com.google.android.gms.drive.internal.OnMetadataResponse;

final class fep
  extends fdx
{
  private final ejr<fal> a;
  
  public fep(ejr<fal> paramejr)
  {
    a = paramejr;
  }
  
  public final void a(Status paramStatus)
  {
    a.a(new feq(paramStatus, null));
  }
  
  public final void a(OnDriveIdResponse paramOnDriveIdResponse)
  {
    a.a(new feq(Status.a, b));
  }
  
  public final void a(OnMetadataResponse paramOnMetadataResponse)
  {
    a.a(new feq(Status.a, (DriveId)new feh(b).a(fnw.a)));
  }
}

/* Location:
 * Qualified Name:     fep
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */