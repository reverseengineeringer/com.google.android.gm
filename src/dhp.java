import android.content.Context;
import android.net.Uri;
import com.android.mail.providers.Account;
import com.google.android.gm.provider.Advertisement;

final class dhp
  implements Runnable
{
  Uri a;
  
  dhp(dhn paramdhn) {}
  
  public final void run()
  {
    if (b.ad == null)
    {
      cvm.e(dhn.ac, "AdClicked, but mAd is null", new Object[0]);
      return;
    }
    Object localObject = b.j;
    dos localdos = dos.a((Context)localObject, b.f.c);
    if ((a != null) && (dfh.a((Context)localObject, a)))
    {
      localdos.a(b.ad, 7, a.toString());
      return;
    }
    Advertisement localAdvertisement = b.ad;
    if (a == null) {}
    for (localObject = "";; localObject = a.toString())
    {
      localdos.a(localAdvertisement, 6, (String)localObject);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dhp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */