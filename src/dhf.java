import android.database.sqlite.SQLiteDatabase;
import com.android.mail.providers.Account;
import com.google.android.gm.ads.AdTeaserView;
import com.google.android.gm.provider.Advertisement;

public final class dhf
  extends doz
{
  public dhf(AdTeaserView paramAdTeaserView) {}
  
  public final void run()
  {
    dos localdos = dos.a(a.getContext(), a.e.c);
    Advertisement localAdvertisement = b;
    String str;
    String[] arrayOfString;
    if (localAdvertisement == null)
    {
      str = "_id NOT IN (SELECT MAX(_id) FROM ads WHERE expiration >= ? GROUP BY tab)";
      arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(System.currentTimeMillis());
    }
    for (;;)
    {
      if (d.delete("ads", str, arrayOfString) > 0) {
        dos.a(b, c);
      }
      return;
      str = "_id NOT IN (SELECT MAX(_id) FROM ads WHERE expiration >= ? GROUP BY tab) AND event_id <> ?";
      arrayOfString = new String[2];
      arrayOfString[0] = Long.toString(System.currentTimeMillis());
      arrayOfString[1] = e;
    }
  }
}

/* Location:
 * Qualified Name:     dhf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */