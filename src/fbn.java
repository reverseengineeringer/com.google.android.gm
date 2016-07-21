import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.Set;

public class fbn
  implements fat
{
  public final DriveId a;
  
  protected fbn(DriveId paramDriveId)
  {
    a = paramDriveId;
  }
  
  public final DriveId a()
  {
    return a;
  }
  
  public final ejh<Status> a(eiz parameiz, Set<DriveId> paramSet)
  {
    if (paramSet == null) {
      throw new IllegalArgumentException("ParentIds must be provided.");
    }
    return parameiz.b(new fbp(this, parameiz, new ArrayList(paramSet)));
  }
  
  public final ejh<fau> b(eiz parameiz)
  {
    return parameiz.a(new fbo(this, parameiz, false));
  }
}

/* Location:
 * Qualified Name:     fbn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */