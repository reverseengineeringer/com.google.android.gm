import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.people.internal.ParcelableLoadImageOptions;
import com.google.android.gms.people.model.AvatarReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class fxd
  extends emr<fww>
{
  private static volatile Bundle j;
  private static volatile Bundle k;
  public final String f;
  public final String g;
  public final Context h;
  public final HashMap<frl, fxl> i = new HashMap();
  private Long l = null;
  
  public fxd(Context paramContext, Looper paramLooper, ejc paramejc, eje parameje, String paramString, emc paramemc)
  {
    super(paramContext.getApplicationContext(), paramLooper, 5, paramemc, paramejc, parameje);
    h = paramContext;
    f = paramString;
    g = e;
  }
  
  private final void a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      try
      {
        fwp.a = paramBundle.getBoolean("use_contactables_api", true);
        fxc.a.a(paramBundle.getStringArray("config.url_uncompress.patterns"), paramBundle.getStringArray("config.url_uncompress.replacements"));
        j = paramBundle.getBundle("config.email_type_map");
        k = paramBundle.getBundle("config.phone_type_map");
      }
      finally {}
    }
  }
  
  public final enk a(ejr<frh> paramejr, AvatarReference paramAvatarReference, frf paramfrf)
  {
    super.j();
    paramejr = new fxf(paramejr);
    try
    {
      paramAvatarReference = ((fww)super.k()).a(paramejr, paramAvatarReference, ParcelableLoadImageOptions.a(paramfrf));
      return paramAvatarReference;
    }
    catch (RemoteException paramAvatarReference)
    {
      paramejr.a(8, null, null, null);
    }
    return null;
  }
  
  public final enk a()
  {
    Object localObject1 = new fxf((ejr)localObject1);
    try
    {
      String str;
      Object localObject2 = ((fww)super.k()).c((fwt)localObject1, (String)localObject2, str, 0);
      return (enk)localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      ((fxf)localObject1).a(8, null, null, null);
    }
    return null;
  }
  
  public final enk a(ejr<frh> paramejr, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramejr = new fxf(paramejr);
    try
    {
      paramString1 = ((fww)super.k()).b(paramejr, paramString1, paramString2, paramInt1, paramInt2);
      return paramString1;
    }
    catch (RemoteException paramString1)
    {
      paramejr.a(8, null, null, null);
    }
    return null;
  }
  
  public final fxl a(eiz parameiz, frl paramfrl)
  {
    synchronized (i)
    {
      if (i.containsKey(paramfrl))
      {
        parameiz = (fxl)i.get(paramfrl);
        return parameiz;
      }
      parameiz = new fxl(parameiz.a(paramfrl));
      i.put(paramfrl, parameiz);
      return parameiz;
    }
  }
  
  protected final String a()
  {
    return "com.google.android.gms.people.service.START";
  }
  
  protected final void a(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramBundle != null)) {
      a(paramBundle.getBundle("post_init_configuration"));
    }
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getBundle("post_init_resolution"))
    {
      super.a(paramInt1, paramIBinder, paramBundle, paramInt2);
      return;
    }
  }
  
  protected final String b()
  {
    return "com.google.android.gms.people.internal.IPeopleService";
  }
  
  public final void c()
  {
    for (;;)
    {
      fxl localfxl;
      synchronized (i)
      {
        if (!d()) {
          break;
        }
        Iterator localIterator = i.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localfxl = (fxl)localIterator.next();
        a.a = null;
      }
      try
      {
        ((fww)super.k()).a(localfxl, false, null, null, 0);
      }
      catch (RemoteException localRemoteException)
      {
        fxo.a("PeopleClient", "Failed to unregister listener", localRemoteException);
        continue;
        localObject = finally;
        throw ((Throwable)localObject);
      }
      catch (IllegalStateException localIllegalStateException)
      {
        fxo.a("PeopleClient", "PeopleService is in unexpected state", localIllegalStateException);
      }
    }
    i.clear();
    super.c();
  }
  
  protected final Bundle i()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("social_client_application_id", f);
    localBundle.putString("real_client_package_name", g);
    localBundle.putBoolean("support_new_image_callback", true);
    return localBundle;
  }
  
  public final fww m()
  {
    return (fww)super.k();
  }
  
  public final void n()
  {
    super.j();
  }
}

/* Location:
 * Qualified Name:     fxd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */