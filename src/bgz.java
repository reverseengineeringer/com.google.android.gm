import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;

public final class bgz
{
  public static long a(Uri paramUri, String paramString)
  {
    paramUri = paramUri.getQueryParameter(paramString);
    if (!TextUtils.isEmpty(paramUri)) {
      try
      {
        long l = Long.parseLong(paramUri);
        return l;
      }
      catch (NumberFormatException paramUri) {}
    }
    return -1L;
  }
  
  public static void a(Uri.Builder paramBuilder, long paramLong)
  {
    if (paramLong != -1L) {
      paramBuilder.appendQueryParameter("ACCOUNT_ID", Long.toString(paramLong));
    }
  }
}

/* Location:
 * Qualified Name:     bgz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */