import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gm.provider.Promotion;
import com.google.android.gm.ui.teasers.PromoTeaserView;

public final class dyf
  implements Runnable
{
  public dyf(PromoTeaserView paramPromoTeaserView, int paramInt) {}
  
  public final void run()
  {
    drp localdrp = b.o;
    long l = b.q.a;
    int i = a;
    duf localduf = n;
    ContentValues localContentValues = new ContentValues(3);
    localContentValues.put("action", "promoEvent");
    localContentValues.put("value1", Long.valueOf(l));
    localContentValues.put("value2", Integer.valueOf(i));
    c.insert("operations", null, localContentValues);
    if ((i == 2) || (i == 3) || (i == 4)) {
      dun.a(p, l);
    }
  }
}

/* Location:
 * Qualified Name:     dyf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */