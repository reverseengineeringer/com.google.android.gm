import android.text.TextUtils;
import java.util.Arrays;
import java.util.Locale;

public final class dns
{
  public final String a;
  public final Integer b;
  public final String c;
  
  public dns(String paramString)
  {
    this(paramString, null, null);
  }
  
  public dns(String paramString, Integer paramInteger)
  {
    this(paramString, paramInteger, null);
  }
  
  public dns(String paramString1, Integer paramInteger, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("Key can't be null or empty");
    }
    a = paramString1;
    b = paramInteger;
    c = paramString2;
  }
  
  public dns(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof dns))
    {
      paramObject = (dns)paramObject;
      bool1 = bool2;
      if (hbc.a(a, a))
      {
        bool1 = bool2;
        if (hbc.a(b, b))
        {
          bool1 = bool2;
          if (hbc.a(c, c)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(new Object[] { a, b, c });
  }
  
  public final String toString()
  {
    return String.format(Locale.ENGLISH, "key: %s, value: %s, extraData: %s", new Object[] { a, b, c });
  }
}

/* Location:
 * Qualified Name:     dns
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */