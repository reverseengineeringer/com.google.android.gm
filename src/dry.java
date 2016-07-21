import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

final class dry
  implements Runnable
{
  dry(drp paramdrp) {}
  
  public final void run()
  {
    dri.c(drp.b, "calculateUnknownSyncRationalesAndPurgeInBackground: running", new Object[0]);
    a.r.a(a.A);
    int i = 0;
    for (;;)
    {
      try
      {
        long l = DatabaseUtils.longForQuery(a.p, "SELECT IFNULL((SELECT _id FROM conversations WHERE syncRationale='UNKNOWN'), 0)", null);
        if (l != 0L)
        {
          drp.a(a, l, 3, false);
          a.p.yieldIfContendedSafely();
          if (!a.H()) {
            if (i == 0) {
              break label142;
            }
          }
        }
        else
        {
          a.r.c();
          a.r.d();
          if (i != 0) {
            a.v();
          }
          return;
        }
      }
      finally
      {
        a.r.d();
      }
      i = 1;
      continue;
      label142:
      i = 0;
    }
  }
}

/* Location:
 * Qualified Name:     dry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */