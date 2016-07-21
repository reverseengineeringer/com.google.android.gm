import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.Toast;

public final class bsr
  extends bet
{
  private static String a;
  private static int b;
  private static int c = 0;
  
  public static void a(Context paramContext)
  {
    if (cuh.a()) {}
    do
    {
      do
      {
        return;
        if (a == null)
        {
          a = paramContext.getString(bnu.c);
          b = Integer.parseInt(paramContext.getString(bnu.d));
        }
      } while (c >= b);
      Object localObject2 = null;
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(a, 0);
        localObject1 = localObject2;
        if (localPackageInfo != null)
        {
          c = versionCode;
          localObject1 = localObject2;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          Object localObject1;
          String str = String.format("ExchangeGoogle requires %s, and the dependent APK was not found!", new Object[] { a });
        }
      }
      if (c < b) {
        localObject1 = String.format("ExchangeGoogle (ver: %d) requires %s version %d, current version %d", new Object[] { Integer.valueOf(7), a, Integer.valueOf(b), Integer.valueOf(c) });
      }
    } while (localObject1 == null);
    Toast.makeText(paramContext, (CharSequence)localObject1, 1).show();
  }
}

/* Location:
 * Qualified Name:     bsr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */