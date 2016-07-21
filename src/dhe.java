import android.database.Cursor;
import com.android.mail.providers.Account;
import com.google.android.gm.ads.AdTeaserView;
import com.google.android.gm.provider.Advertisement;

public final class dhe
  implements Runnable
{
  public dhe(AdTeaserView paramAdTeaserView) {}
  
  public final void run()
  {
    boolean bool = false;
    dos localdos = dos.a(a.getContext(), a.e.c);
    Cursor localCursor = localdos.a(dpy.o, a.g.e);
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst())
      {
        Advertisement localAdvertisement = new Advertisement(localCursor);
        if (!p) {
          bool = true;
        }
        localdos.a(localAdvertisement, bool, false);
      }
      return;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
}

/* Location:
 * Qualified Name:     dhe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */