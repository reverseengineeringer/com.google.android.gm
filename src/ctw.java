import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

public class ctw
  extends ctt
{
  public final void a(ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    paramContentValues = ContentProviderOperation.newUpdate(paramUri).withValues(paramContentValues).withSelection(paramString, paramArrayOfString).build();
    super.a(paramContentResolver, paramUri.getAuthority(), hgd.a(new ContentProviderOperation[] { paramContentValues }));
  }
}

/* Location:
 * Qualified Name:     ctw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */