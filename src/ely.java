import android.net.Uri;
import java.util.Arrays;

public final class ely
{
  public final Uri a;
  
  public ely(Uri paramUri)
  {
    a = paramUri;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ely)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    return enx.a(a, a);
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { a });
  }
}

/* Location:
 * Qualified Name:     ely
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */