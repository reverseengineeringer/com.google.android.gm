import com.android.mail.providers.Account;
import com.google.android.gm.provider.Advertisement;

final class dht
  implements Runnable
{
  private final int b;
  private final Advertisement c;
  
  dht(dhn paramdhn, Advertisement paramAdvertisement, int paramInt)
  {
    c = paramAdvertisement;
    b = paramInt;
  }
  
  public final void run()
  {
    if (c == null)
    {
      cvm.e(dhn.ac, "Ad action reported, but mAdvertisement is null", new Object[0]);
      return;
    }
    dos.a(a.j, a.f.c).a(c, b);
  }
}

/* Location:
 * Qualified Name:     dht
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */