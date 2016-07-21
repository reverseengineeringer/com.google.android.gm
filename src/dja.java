import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.drive.DriveId;

final class dja
  extends dyz
{
  dja(diz paramdiz, Activity paramActivity, Bundle paramBundle1, String paramString1, String paramString2, Bundle paramBundle2)
  {
    super(paramActivity, paramBundle1, 257, paramString1, paramString2);
  }
  
  public final eiz a()
  {
    return null;
  }
  
  public final void a(int paramInt)
  {
    super.a(paramInt);
    if (b.b) {
      buq.b.a("drive-client", false, "drive-client", "suspended");
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    Object localObject = null;
    super.a(paramBundle);
    if (b.b) {
      buq.b.a("drive-client", true, "drive-client", "connected");
    }
    if (b.e != null)
    {
      b.e.a();
      b.e = null;
    }
    paramBundle = (Bundle)localObject;
    if (a != null) {
      paramBundle = (DriveId)a.getParcelable("drive_file_key");
    }
    if (paramBundle != null) {
      b.f = fae.h.a(f, paramBundle);
    }
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    if (!ActivityManager.isRunningInTestHarness()) {
      super.a(paramConnectionResult);
    }
    if (b.b)
    {
      buq.b.a("drive-client", true, "drive-client", "failed");
      buo.a().a("drive-client", "failed", String.valueOf(c), 0L);
    }
  }
  
  public final void b()
  {
    super.b();
    if (b.b) {
      buq.b.a("drive-client");
    }
  }
  
  public final void c()
  {
    super.c();
    if (b.b) {
      buq.b.b("drive-client");
    }
  }
}

/* Location:
 * Qualified Name:     dja
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */