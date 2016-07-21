import android.os.Bundle;
import com.google.android.gms.drive.DriveId;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public final class ffv
  extends ffs<DriveId>
  implements ffi<Collection<DriveId>>
{
  public ffv()
  {
    super("parents", Collections.emptySet(), Arrays.asList(new String[] { "parentsExtra", "dbInstanceId", "parentsExtraHolder" }), 4100000);
  }
  
  protected final Collection<DriveId> c(Bundle paramBundle)
  {
    paramBundle = super.c(paramBundle);
    if (paramBundle == null) {
      return null;
    }
    return new HashSet(paramBundle);
  }
}

/* Location:
 * Qualified Name:     ffv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */