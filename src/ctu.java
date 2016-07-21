import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.net.Uri;

public final class ctu
  extends ctt
{
  public final void a(ContentResolver paramContentResolver, Uri paramUri)
  {
    ContentProviderOperation localContentProviderOperation = ContentProviderOperation.newDelete(paramUri).withSelection(null, null).build();
    super.a(paramContentResolver, paramUri.getAuthority(), hgd.a(new ContentProviderOperation[] { localContentProviderOperation }));
  }
}

/* Location:
 * Qualified Name:     ctu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */