import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import java.util.List;
import java.util.Locale;

public final class dor
{
  private Context a;
  private ConnectivityManager b;
  private Account c;
  
  public dor(Context paramContext, Account paramAccount)
  {
    a = paramContext;
    c = paramAccount;
    b = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
  }
  
  public final gxf a()
  {
    boolean bool = false;
    gxf localgxf = new gxf();
    if (!dpy.b(a.getContentResolver()))
    {
      localgxf.a(false);
      return localgxf;
    }
    localgxf.a(true);
    h = new gwj();
    Object localObject = h;
    b = true;
    a |= 0x1;
    c = true;
    a |= 0x2;
    f = true;
    a |= 0x10;
    e = true;
    a |= 0x8;
    d = true;
    a |= 0x4;
    g = true;
    a |= 0x20;
    h = true;
    a |= 0x40;
    i = 2;
    a |= 0x80;
    j = true;
    a |= 0x100;
    k = true;
    a |= 0x200;
    l = true;
    a |= 0x400;
    m = true;
    a |= 0x800;
    n = true;
    a |= 0x1000;
    if (b != null)
    {
      localObject = b.getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected())) {
        switch (((NetworkInfo)localObject).getType())
        {
        default: 
          localgxf.a(0);
        }
      }
    }
    for (;;)
    {
      b = ((NetworkInfo)localObject).isRoaming();
      a |= 0x4;
      c = ContentResolver.isSyncActive(c, "gmail-ls");
      a |= 0x8;
      localObject = dpy.a(a, c.name);
      if ((((dqg)localObject).c().contains("^sq_ig_i_promo")) || (((dqg)localObject).d().contains("^sq_ig_i_promo"))) {
        bool = true;
      }
      d = bool;
      a |= 0x10;
      e = dmv.j(a).a(c.name);
      a |= 0x20;
      localObject = Locale.getDefault().toString();
      if (localObject != null) {
        break;
      }
      throw new NullPointerException();
      localgxf.a(2);
      continue;
      localgxf.a(1);
    }
    f = ((String)localObject);
    a |= 0x40;
    localObject = a.getResources().getDisplayMetrics();
    g = Math.min(Math.round(widthPixels / density), Math.round(heightPixels / density));
    a |= 0x80;
    localObject = Build.VERSION.RELEASE;
    if (localObject == null) {
      throw new NullPointerException();
    }
    i = ((String)localObject);
    a |= 0x400;
    localObject = Build.MODEL;
    if (localObject == null) {
      throw new NullPointerException();
    }
    j = ((String)localObject);
    a |= 0x800;
    return localgxf;
  }
}

/* Location:
 * Qualified Name:     dor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */