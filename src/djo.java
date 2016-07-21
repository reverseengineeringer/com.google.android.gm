import android.content.ContentResolver;
import android.content.Context;
import com.android.mail.providers.Attachment;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class djo
  extends dbx<Boolean>
{
  private final Context a;
  private final fam b;
  private final Attachment c;
  private final djp d;
  
  djo(Context paramContext, fam paramfam, Attachment paramAttachment, djp paramdjp)
  {
    a = paramContext;
    b = paramfam;
    c = paramAttachment;
    d = paramdjp;
  }
  
  private final Boolean a()
  {
    cvm.b("DriveUtils", "Starting write task for Drive with %s", new Object[] { c.i });
    localOutputStream = b.b();
    localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localInputStream = a.getContentResolver().openInputStream(c.i);
        localObject1 = localInputStream;
        localObject3 = localInputStream;
        hjy.a(localInputStream, localOutputStream);
      }
      catch (IOException localObject2)
      {
        InputStream localInputStream;
        cvm.e("DriveUtils", localIOException7, "Unable to write attachment for Drive", new Object[0]);
        Boolean localBoolean = Boolean.valueOf(false);
        try
        {
          localOutputStream.close();
          localObject3 = localBoolean;
          if (localIOException2 == null) {
            continue;
          }
          try
          {
            localIOException2.close();
            return localBoolean;
          }
          catch (IOException localIOException3)
          {
            cvm.e("DriveUtils", localIOException3, "Unable to close input of attachment for Drive", new Object[0]);
            return Boolean.valueOf(false);
          }
          localObject2 = finally;
        }
        catch (IOException localIOException4)
        {
          cvm.e("DriveUtils", localIOException4, "Unable to close output of attachment for Drive", new Object[0]);
          return Boolean.valueOf(false);
        }
      }
      finally
      {
        try
        {
          localOutputStream.close();
          if (localObject3 == null) {
            continue;
          }
          return Boolean.valueOf(false);
        }
        catch (IOException localIOException5)
        {
          try
          {
            ((InputStream)localObject3).close();
            throw ((Throwable)localObject2);
          }
          catch (IOException localIOException6)
          {
            cvm.e("DriveUtils", localIOException6, "Unable to close input of attachment for Drive", new Object[0]);
          }
          localIOException5 = localIOException5;
          cvm.e("DriveUtils", localIOException5, "Unable to close output of attachment for Drive", new Object[0]);
          return Boolean.valueOf(false);
        }
      }
      try
      {
        localOutputStream.close();
        if (localInputStream != null) {}
        localIOException7 = localIOException7;
      }
      catch (IOException localIOException1)
      {
        try
        {
          localInputStream.close();
          d.a();
          localObject3 = Boolean.valueOf(true);
          return (Boolean)localObject3;
        }
        catch (IOException localIOException2)
        {
          cvm.e("DriveUtils", localIOException2, "Unable to close input of attachment for Drive", new Object[0]);
          return Boolean.valueOf(false);
        }
        localIOException1 = localIOException1;
        cvm.e("DriveUtils", localIOException1, "Unable to close output of attachment for Drive", new Object[0]);
        return Boolean.valueOf(false);
      }
    }
  }
}

/* Location:
 * Qualified Name:     djo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */