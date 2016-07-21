import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.android.mail.providers.Account;
import com.google.android.gm.ads.AdTeaserView;
import com.google.android.gm.provider.Advertisement;
import java.util.Collections;

public final class dhg
  extends doz
{
  public dhg(AdTeaserView paramAdTeaserView) {}
  
  public final void run()
  {
    dos localdos;
    Advertisement localAdvertisement;
    if (!a.p)
    {
      localdos = dos.a(a.getContext(), a.e.c);
      localAdvertisement = b;
      if (localAdvertisement != null)
      {
        if (q != 0) {
          break label168;
        }
        q = 1;
      }
    }
    label168:
    for (int i = 1;; i = 0)
    {
      localdos.a(localAdvertisement, 1);
      String str = e;
      if (i != 0) {}
      for (int j = 2;; j = 1)
      {
        ContentValues localContentValues = new ContentValues(j);
        if (i != 0) {
          localContentValues.put("view_status", Integer.valueOf(q));
        }
        localContentValues.put("last_shown_timestamp", Long.valueOf(G));
        d.update("ads", localContentValues, "event_id = ?", new String[] { str });
        localdos.a(Collections.singleton(str));
        a.p = true;
        return;
      }
    }
  }
}

/* Location:
 * Qualified Name:     dhg
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */