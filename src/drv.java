import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gm.provider.GmailProvider;

final class drv
  implements Runnable
{
  drv(drp paramdrp, String paramString1, Long paramLong, boolean paramBoolean, String paramString2, long paramLong1) {}
  
  public final void run()
  {
    ContentValues localContentValues;
    if ((a != null) && (b != null))
    {
      dri.b(drp.b, "Resetting local unseen count for %s", new Object[] { a });
      localObject1 = f.o;
      l = b.longValue();
      localContentValues = new ContentValues(1);
      localContentValues.put("numUnseenConversations", Integer.valueOf(0));
      b.beginTransactionNonExclusive();
    }
    try
    {
      b.update("labels", localContentValues, "_id = ?", new String[] { Long.toString(l) });
      b.setTransactionSuccessful();
      ((drj)localObject1).l();
      b.endTransaction();
      if (c) {
        GmailProvider.a(f.k, f.l.name, hfd.b(a));
      }
      localObject1 = f.v.e("ix_awtsv");
      if ((localObject1 == null) || (Integer.parseInt((String)localObject1) < 0))
      {
        dri.b(drp.b, "Not resetting unseen count until WelcomeTour is complete", new Object[0]);
        return;
      }
    }
    finally
    {
      b.endTransaction();
    }
    dri.b(drp.b, "Resetting server unseen count for %s", new Object[] { d });
    Object localObject1 = f.n;
    long l = e;
    String str = d;
    c.delete("operations", "action = ? AND message_messageId < ? AND value3 = ?", new String[] { "resetUnseenCount", Long.toString(l), str });
    ((duf)localObject1).a("resetUnseenCount", 0L, l, 0L, str, null, null, null, 0L, 0, 0L);
    f.k.getContentResolver().notifyChange(dpy.a(f.l.name), null, true);
  }
}

/* Location:
 * Qualified Name:     drv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */