import android.text.TextUtils;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class gni
  implements gna
{
  private static final Charset a = Charset.forName("UTF-8");
  
  private static long a(String paramString)
  {
    gol.a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException(String.valueOf("name can not be empty."));
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(a));
      long l = ByteBuffer.wrap(localMessageDigest.digest()).getLong();
      return l;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public final void a(hri paramhri)
  {
    if ((c != null) && (!c.trim().isEmpty()))
    {
      b = Long.valueOf(a(c));
      c = null;
    }
    a_(paramhri);
  }
  
  public abstract void a_(hri paramhri);
}

/* Location:
 * Qualified Name:     gni
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */