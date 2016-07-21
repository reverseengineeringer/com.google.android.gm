import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

public final class bvn
  extends AsyncQueryHandler
{
  public bvn(Context paramContext)
  {
    super(paramContext.getContentResolver());
  }
  
  public final void a(Uri paramUri, ContentValues paramContentValues)
  {
    startUpdate(0, null, paramUri, paramContentValues, null, null);
  }
}

/* Location:
 * Qualified Name:     bvn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */