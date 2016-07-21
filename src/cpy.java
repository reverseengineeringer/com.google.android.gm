import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class cpy
  extends cot<String>
{
  private final Context a;
  private final Uri b;
  
  public cpy(Context paramContext, Uri paramUri)
  {
    super(paramContext);
    a = paramContext;
    b = paramUri;
  }
  
  private final String a()
  {
    String str = null;
    Cursor localCursor = a.getContentResolver().query(b, chh.g, null, null, null);
    if (localCursor == null) {
      return null;
    }
    try
    {
      if (localCursor.moveToFirst()) {
        str = localCursor.getString(localCursor.getColumnIndex("oauthToken"));
      }
      return str;
    }
    finally
    {
      localCursor.close();
    }
  }
}

/* Location:
 * Qualified Name:     cpy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */