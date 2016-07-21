import android.content.Context;
import android.content.pm.PackageManager;
import java.util.regex.Pattern;

public final class eoz
{
  private static Pattern a = null;
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
  }
}

/* Location:
 * Qualified Name:     eoz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */