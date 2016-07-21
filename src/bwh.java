import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

final class bwh
  implements Runnable
{
  bwh(bwg parambwg, Context paramContext, Uri paramUri) {}
  
  public final void run()
  {
    Cursor localCursor = a.getContentResolver().query(b, chh.r, null, null, null);
    if (localCursor != null) {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     bwh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */