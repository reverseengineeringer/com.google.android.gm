import android.util.Base64;
import com.google.android.gm.provider.Advertisement;
import java.io.UnsupportedEncodingException;

public final class dov
  implements hav<String, String>
{
  public dov(Advertisement paramAdvertisement) {}
  
  public final String apply(String paramString)
  {
    if (paramString == null)
    {
      dri.e(Advertisement.a, "Null escaped AdClientDedupId", new Object[0]);
      return null;
    }
    try
    {
      String str = new String(Base64.decode(paramString.getBytes(), 0), "UTF-8");
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      dri.e(Advertisement.a, "Invalid escaped AdClientDedupId: %s", new Object[] { paramString });
      return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     dov
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */