import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.android.mail.providers.Account;
import com.google.android.gm.ads.AdTeaserView;
import com.google.android.gm.provider.Advertisement;
import java.util.Collections;

public final class dhd
  implements Runnable
{
  public dhd(AdTeaserView paramAdTeaserView) {}
  
  public final void run()
  {
    dos localdos = dos.a(a.getContext(), a.e.c);
    Advertisement localAdvertisement = a.g;
    if (localAdvertisement != null)
    {
      q = 2;
      localdos.a(localAdvertisement, 2);
      String str = e;
      ContentValues localContentValues = new ContentValues(2);
      localContentValues.put("view_status", Integer.valueOf(q));
      localContentValues.put("last_clicked_timestamp", Long.valueOf(H));
      d.update("ads", localContentValues, "event_id = ?", new String[] { str });
      localdos.a(Collections.singleton(str));
    }
  }
}

/* Location:
 * Qualified Name:     dhd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */