import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Process;

public abstract class ebe
  extends ContentProvider
{
  private static void a(Context paramContext)
  {
    int i = Binder.getCallingUid();
    if (i == Process.myUid()) {}
    do
    {
      return;
      try
      {
        if (getPackageManagergetApplicationInfo"com.google.android.gms"0uid != i) {
          throw new SecurityException("Calling UID " + i + " is not Google Play Services.");
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        throw new SecurityException("Google Play Services not installed", paramContext);
      }
      i = eik.a(paramContext);
    } while (i == 0);
    throw new SecurityException("Calling package problem: " + eik.a(i));
  }
  
  public abstract Cursor a(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2);
  
  public abstract String a();
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("delete not supported.");
  }
  
  public final String getType(Uri paramUri)
  {
    a(getContext());
    return a();
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    throw new UnsupportedOperationException("insert not supported.");
  }
  
  public boolean onCreate()
  {
    return true;
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    a(getContext());
    return a(paramUri, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2);
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException("update not supported.");
  }
}

/* Location:
 * Qualified Name:     ebe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */