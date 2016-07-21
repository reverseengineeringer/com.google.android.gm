import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncTask;

public final class bij
  implements biv
{
  final ContentResolver a;
  final ny<Uri, byte[]> b;
  
  public bij(ContentResolver paramContentResolver)
  {
    a = paramContentResolver;
    b = new ny(20);
  }
  
  public final void a(bkn parambkn, biw parambiw)
  {
    Uri localUri = j;
    if (localUri != null)
    {
      arrayOfByte = (byte[])b.a(localUri);
      if (arrayOfByte != null)
      {
        parambkn.a(arrayOfByte);
        if (parambiw != null) {
          parambiw.c();
        }
      }
    }
    while (parambiw == null)
    {
      byte[] arrayOfByte;
      return;
      new bik(this, localUri, parambkn, parambiw).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
      return;
    }
    parambiw.e();
  }
}

/* Location:
 * Qualified Name:     bij
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */