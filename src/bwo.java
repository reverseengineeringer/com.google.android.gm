import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;

final class bwo
  implements Runnable
{
  final int a = 1;
  final Uri b;
  final ContentValues c;
  final ContentResolver d;
  
  bwo(ContentResolver paramContentResolver, Uri paramUri, ContentValues paramContentValues)
  {
    b = bwg.a(paramUri);
    c = paramContentValues;
    d = paramContentResolver;
  }
  
  public final Object a()
  {
    switch (a)
    {
    default: 
      return null;
    case 0: 
      return Integer.valueOf(d.delete(b, null, null));
    case 1: 
      return d.insert(b, c);
    }
    return Integer.valueOf(d.update(b, c, null, null));
  }
  
  public final void run()
  {
    a();
  }
}

/* Location:
 * Qualified Name:     bwo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */