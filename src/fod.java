import com.google.android.gms.drive.DriveSpace;
import java.util.Arrays;
import java.util.Collections;

public final class fod
  extends ffs<DriveSpace>
{
  public fod()
  {
    super("spaces", Arrays.asList(new String[] { "inDriveSpace", "isAppData", "inGooglePhotosSpace" }), Collections.emptySet(), 7000000);
  }
}

/* Location:
 * Qualified Name:     fod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */