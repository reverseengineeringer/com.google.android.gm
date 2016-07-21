import android.net.Uri;
import android.net.Uri.Builder;

public final class cus
{
  public static final cus a = new cus(Uri.EMPTY);
  public final Uri b;
  private Uri c = null;
  
  public cus(Uri paramUri)
  {
    b = paramUri;
  }
  
  public final Uri a()
  {
    if (c == null)
    {
      Uri localUri = b;
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme(localUri.getScheme());
      localBuilder.encodedAuthority(localUri.getEncodedAuthority());
      localBuilder.encodedPath(localUri.getEncodedPath());
      c = localBuilder.build();
    }
    return c;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof cus)) {
      return a().equals(((cus)paramObject).a());
    }
    return a().equals(paramObject);
  }
  
  public final int hashCode()
  {
    return a().hashCode();
  }
  
  public final String toString()
  {
    return b.toString();
  }
}

/* Location:
 * Qualified Name:     cus
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */