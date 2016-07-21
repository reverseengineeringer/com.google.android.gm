import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;

public final class bmw
  extends js
{
  private final Uri w;
  private final String[] x;
  
  public bmw(Context paramContext, Uri paramUri, String[] paramArrayOfString)
  {
    super(paramContext);
    w = paramUri;
    if (paramArrayOfString != null) {}
    for (;;)
    {
      x = paramArrayOfString;
      return;
      paramArrayOfString = bmy.a;
    }
  }
  
  public final Cursor f()
  {
    g = w.buildUpon().appendQueryParameter("contentType", "image/").build();
    h = x;
    return super.f();
  }
}

/* Location:
 * Qualified Name:     bmw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */