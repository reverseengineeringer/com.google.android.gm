import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.provider.CalendarContract.Events;
import com.android.mail.browse.calendar.ProposedNewTimeHeaderView;
import com.android.mail.providers.Message;

public final class cay
  implements Runnable
{
  public cay(ProposedNewTimeHeaderView paramProposedNewTimeHeaderView) {}
  
  public final void run()
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("dtstart", Long.valueOf(a.n.aa));
    localContentValues.put("dtend", Long.valueOf(a.n.ab));
    int i = a.getContext().getContentResolver().update(ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, a.q), localContentValues, null, null);
    cvm.b(ProposedNewTimeHeaderView.a, "Rows updated: %d", new Object[] { Integer.valueOf(i) });
  }
}

/* Location:
 * Qualified Name:     cay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */