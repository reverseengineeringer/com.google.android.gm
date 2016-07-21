import android.net.Uri;
import com.google.android.gms.wearable.PutDataRequest;

public final class ghn
  implements gdn
{
  public final ejh<gdv> a(eiz parameiz, Uri paramUri)
  {
    return a(parameiz, paramUri, 0);
  }
  
  public final ejh<gdv> a(eiz parameiz, Uri paramUri, int paramInt)
  {
    return parameiz.a(new ghp(this, parameiz, paramUri, paramInt));
  }
  
  public final ejh<gdo> a(eiz parameiz, PutDataRequest paramPutDataRequest)
  {
    return parameiz.a(new gho(this, parameiz, paramPutDataRequest));
  }
  
  public final ejh<gdq> b(eiz parameiz, Uri paramUri)
  {
    return b(parameiz, paramUri, 0);
  }
  
  public final ejh<gdq> b(eiz parameiz, Uri paramUri, int paramInt)
  {
    return parameiz.a(new ghq(this, parameiz, paramUri, paramInt));
  }
}

/* Location:
 * Qualified Name:     ghn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */