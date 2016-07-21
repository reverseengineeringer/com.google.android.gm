import android.content.ContentResolver;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class bnc
  extends bnb
{
  private byte[] c;
  
  public bnc(ContentResolver paramContentResolver, Uri paramUri)
  {
    super(paramContentResolver, paramUri);
  }
  
  private static byte[] a(Uri paramUri)
  {
    paramUri = paramUri.getSchemeSpecificPart();
    try
    {
      if (paramUri.startsWith("base64,")) {
        return Base64.decode(paramUri.substring(7), 8);
      }
      if (bna.a.matcher(paramUri).matches())
      {
        paramUri = Base64.decode(paramUri.substring(paramUri.indexOf("base64,") + 7), 0);
        return paramUri;
      }
    }
    catch (IllegalArgumentException paramUri)
    {
      paramUri = String.valueOf(paramUri);
      Log.e("ImageUtils", String.valueOf(paramUri).length() + 21 + "Mailformed data URI: " + paramUri);
    }
    return null;
  }
  
  public final InputStream a()
  {
    if (c == null)
    {
      c = a(b);
      if (c == null) {
        return super.a();
      }
    }
    return new ByteArrayInputStream(c);
  }
}

/* Location:
 * Qualified Name:     bnc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */