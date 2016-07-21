import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;

public final class bvo
  extends CursorLoader
{
  public bvo(Context paramContext, Uri paramUri)
  {
    super(paramContext, paramUri, chh.o, null, null, null);
  }
  
  public final Cursor loadInBackground()
  {
    return new bvp(super.loadInBackground());
  }
}

/* Location:
 * Qualified Name:     bvo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */