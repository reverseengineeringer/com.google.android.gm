import android.util.Base64;
import com.google.android.gm.provider.Advertisement;
import java.io.UnsupportedEncodingException;

public final class dou
  implements hav<String, String>
{
  public final String apply(String paramString)
  {
    try
    {
      String str = Base64.encodeToString(paramString.getBytes("UTF-8"), 0);
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      dri.e(Advertisement.a, "Could not escape adClientDedupId: %s", new Object[] { paramString });
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     dou
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */