import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

class jp
  implements jo
{
  public Cursor a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, mb parammb)
  {
    if ((parammb != null) && (parammb.a())) {
      throw new mf();
    }
    return paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
}

/* Location:
 * Qualified Name:     jp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */