import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

public final class cav
  extends AsyncQueryHandler
{
  public static final String a = cvl.a;
  
  public cav(Context paramContext)
  {
    super(paramContext.getContentResolver());
  }
  
  public final void a(Uri paramUri, int paramInt)
  {
    ContentValues localContentValues = new ContentValues(1);
    cvm.b(a, "SENDING INVITE COMMAND, VALUE=%s", new Object[] { Integer.valueOf(paramInt) });
    localContentValues.put("respond", Integer.valueOf(paramInt));
    startUpdate(0, null, paramUri, localContentValues, null, null);
  }
}

/* Location:
 * Qualified Name:     cav
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */