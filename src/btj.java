import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class btj
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = String.valueOf(paramString.replace("\"", "'"));
    return String.valueOf(paramString).length() + 2 + "\"" + paramString + "\"";
  }
  
  private final void b(String paramString)
  {
    int i = 0;
    paramString = bhn.a(bhn.a, paramString);
    int m = paramString.length;
    int j = 0;
    while (j < m)
    {
      byte b = paramString[j];
      int k = i;
      if (i > 71)
      {
        k = i;
        if (bhn.a(b))
        {
          a.write(13);
          a.write(10);
          a.write(9);
          k = 1;
        }
      }
      a.write(b);
      j += 1;
      i = k + 1;
    }
    a.write(13);
    a.write(10);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Object localObject;
    if ((!"CALSCALE".equals(paramString1)) && (!"METHOD".equals(paramString1)) && (!"PRODID".equals(paramString1)) && (!"VERSION".equals(paramString1)) && (!"CATEGORIES".equals(paramString1)) && (!"CLASS".equals(paramString1)) && (!"COMMENT".equals(paramString1)) && (!"DESCRIPTION".equals(paramString1)) && (!"LOCATION".equals(paramString1)) && (!"RESOURCES".equals(paramString1)) && (!"STATUS".equals(paramString1)) && (!"SUMMARY".equals(paramString1)) && (!"TRANSP".equals(paramString1)) && (!"TZID".equals(paramString1)) && (!"TZNAME".equals(paramString1)) && (!"CONTACT".equals(paramString1)) && (!"RELATED-TO".equals(paramString1)) && (!"UID".equals(paramString1)) && (!"ACTION".equals(paramString1)) && (!"REQUEST-STATUS".equals(paramString1)))
    {
      localObject = paramString2;
      if (!"X-LIC-LOCATION".equals(paramString1)) {}
    }
    else
    {
      localObject = new StringBuilder(paramString2.length());
      int i = 0;
      if (i < paramString2.length())
      {
        char c = paramString2.charAt(i);
        if (c == '\n') {
          ((StringBuilder)localObject).append("\\n");
        }
        for (;;)
        {
          i += 1;
          break;
          if (c != '\r') {
            if ((c == ',') || (c == ';') || (c == '\\'))
            {
              ((StringBuilder)localObject).append('\\');
              ((StringBuilder)localObject).append(c);
            }
            else
            {
              ((StringBuilder)localObject).append(c);
            }
          }
        }
      }
      localObject = ((StringBuilder)localObject).toString();
    }
    b(String.valueOf(paramString1).length() + 1 + String.valueOf(localObject).length() + paramString1 + ":" + (String)localObject);
  }
  
  public final byte[] a()
  {
    try
    {
      a.flush();
      return a.toByteArray();
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  public final String toString()
  {
    byte[] arrayOfByte = a();
    return bhn.a(bhn.a, arrayOfByte);
  }
}

/* Location:
 * Qualified Name:     btj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */