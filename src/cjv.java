import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

final class cjv
  extends AsyncTask<Bundle, Void, Void>
{
  final Uri a;
  final ContentResolver b;
  
  public cjv(cjs paramcjs, Uri paramUri, ContentResolver paramContentResolver)
  {
    a = paramUri;
    b = paramContentResolver;
  }
}

/* Location:
 * Qualified Name:     cjv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */