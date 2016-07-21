import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.net.Uri;

public final class bnw
{
  final ContentProviderOperation a;
  final ContentProviderOperation.Builder b;
  final String c;
  final int d;
  boolean e = false;
  final String[] f = { "???", "Ins", "Upd", "Del", "Assert" };
  
  bnw(ContentProviderOperation.Builder paramBuilder)
  {
    a = null;
    b = paramBuilder;
    c = null;
    d = 0;
  }
  
  bnw(ContentProviderOperation.Builder paramBuilder, String paramString, int paramInt)
  {
    a = null;
    b = paramBuilder;
    c = paramString;
    d = paramInt;
  }
  
  bnw(ContentProviderOperation paramContentProviderOperation)
  {
    a = paramContentProviderOperation;
    b = null;
    c = null;
    d = 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Op: ");
    if (a != null) {}
    for (Object localObject = a;; localObject = ((ContentProviderOperation.Builder)localObject).build())
    {
      localStringBuilder.append(f[0]);
      localObject = ((ContentProviderOperation)localObject).getUri();
      localStringBuilder.append(' ');
      localStringBuilder.append(((Uri)localObject).getPath());
      if (c != null) {
        localStringBuilder.append("Back value of ").append(c).append(": ").append(d);
      }
      return localStringBuilder.toString();
      if (b == null) {
        throw new IllegalArgumentException("Operation must have CPO.Builder");
      }
      localObject = b;
      if (c != null) {
        ((ContentProviderOperation.Builder)localObject).withValueBackReference(c, d + 0);
      }
    }
  }
}

/* Location:
 * Qualified Name:     bnw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */