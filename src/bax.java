import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;

public final class bax
  implements bde
{
  public bax(Context paramContext, bed parambed) {}
  
  public final void a(String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("syncServerId", paramString);
    a.getContentResolver().update(ContentUris.withAppendedId(beb.a, b.d), localContentValues, null, null);
  }
}

/* Location:
 * Qualified Name:     bax
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */