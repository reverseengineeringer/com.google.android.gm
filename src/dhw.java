import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.android.mail.providers.Folder;
import com.google.android.gm.provider.Advertisement;
import com.google.android.gm.provider.Advertisement.AdvertisementOptions;
import java.util.Set;

public final class dhw
{
  public static long a(Advertisement paramAdvertisement, int paramInt)
  {
    if ((paramAdvertisement == null) || (B == null) || (!B.e)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return -1L;
              switch (paramInt)
              {
              case 1: 
              default: 
                return -1L;
              }
            } while (G <= 0L);
            return System.currentTimeMillis() - G;
          } while (H <= 0L);
          return System.currentTimeMillis() - H;
        } while (I <= 0L);
        return System.currentTimeMillis() - I;
      } while ((J <= 0L) || (G <= 0L));
      return J - G;
    } while ((J <= 0L) || (H <= 0L));
    return J - H;
  }
  
  public static Uri a(Context paramContext, Uri paramUri, Advertisement paramAdvertisement, int paramInt)
  {
    if (!B.f) {}
    long l;
    do
    {
      return paramUri;
      l = a(paramAdvertisement, paramInt);
      paramContext = dfh.a(paramContext.getContentResolver());
    } while ((TextUtils.isEmpty(paramContext)) || (l <= 0L));
    return paramUri.buildUpon().appendQueryParameter(paramContext, String.valueOf(l)).build();
  }
  
  public static boolean a(Folder paramFolder)
  {
    if (paramFolder == null) {
      return false;
    }
    return Advertisement.b.contains(Integer.valueOf(Advertisement.a(paramFolder)));
  }
}

/* Location:
 * Qualified Name:     dhw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */