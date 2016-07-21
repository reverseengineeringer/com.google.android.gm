import com.android.mail.providers.Account;
import com.google.android.gm.ads.AdTeaserView;
import com.google.android.gm.provider.Advertisement;

public final class dhi
  implements Runnable
{
  public dhi(AdTeaserView paramAdTeaserView) {}
  
  public final void run()
  {
    dos localdos = dos.a(a.getContext(), a.e.c);
    Advertisement localAdvertisement;
    if ((a.n) && (a.g != null))
    {
      a.g.F = a.m;
      localAdvertisement = a.g;
      if (localAdvertisement != null) {
        if (F < 0) {
          break label99;
        }
      }
    }
    label99:
    for (int i = 15;; i = 16)
    {
      localdos.a(localAdvertisement, i);
      localdos.a(a.g, false);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     dhi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */