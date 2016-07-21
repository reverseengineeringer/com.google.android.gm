import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

final class bik
  extends AsyncTask<Void, Void, byte[]>
{
  bik(bij parambij, Uri paramUri, bkn parambkn, biw parambiw) {}
  
  private final byte[] a()
  {
    byte[] arrayOfByte1 = null;
    Object localObject3 = d.a.query(a, bil.a, null, null, null);
    if (localObject3 != null) {}
    for (;;)
    {
      try
      {
        if (((Cursor)localObject3).moveToFirst())
        {
          arrayOfByte1 = ((Cursor)localObject3).getBlob(0);
          return arrayOfByte1;
        }
        return null;
      }
      finally
      {
        ((Cursor)localObject3).close();
      }
      try
      {
        localObject3 = d.a.openInputStream(a);
        if (localObject3 != null)
        {
          byte[] arrayOfByte2 = new byte['䀀'];
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          try
          {
            for (;;)
            {
              int i = ((InputStream)localObject3).read(arrayOfByte2);
              if (i == -1) {
                break;
              }
              localByteArrayOutputStream.write(arrayOfByte2, 0, i);
            }
          }
          finally
          {
            ((InputStream)localObject3).close();
          }
          byte[] arrayOfByte3 = localByteArrayOutputStream.toByteArray();
          return arrayOfByte3;
        }
      }
      catch (IOException localIOException) {}
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     bik
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */