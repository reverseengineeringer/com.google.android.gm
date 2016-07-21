import android.database.sqlite.SQLiteDatabase;

final class dpb
  implements Runnable
{
  dpb(dpa paramdpa) {}
  
  public final void run()
  {
    dpa localdpa = a;
    dri.b(dpa.a, "Purging old attachments.", new Object[0]);
    if (c.isDbLockedByCurrentThread()) {
      throw new IllegalStateException("Db should not be locked");
    }
    localdpa.b();
    localdpa.c();
  }
}

/* Location:
 * Qualified Name:     dpb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */