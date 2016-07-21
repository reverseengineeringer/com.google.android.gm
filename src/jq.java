import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

final class jq
  extends jp
{
  public final Cursor a(ContentResolver paramContentResolver, Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, mb parammb)
  {
    if (parammb != null) {}
    for (;;)
    {
      try
      {
        parammb = parammb.b();
        paramContentResolver = paramContentResolver.query(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, (CancellationSignal)parammb);
        return paramContentResolver;
      }
      catch (Exception paramContentResolver)
      {
        if (!(paramContentResolver instanceof OperationCanceledException)) {
          continue;
        }
        throw new mf();
        throw paramContentResolver;
      }
      parammb = null;
    }
  }
}

/* Location:
 * Qualified Name:     jq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */