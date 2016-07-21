import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.TreeSet;

public class ieh
{
  private static idy a = new idy();
  
  public static String a(String paramString)
  {
    if (paramString.indexOf("=?") == -1) {}
    StringBuilder localStringBuilder;
    int j;
    label134:
    label177:
    do
    {
      return paramString;
      localStringBuilder = new StringBuilder();
      int i = 0;
      j = 0;
      int m = paramString.indexOf("=?", j);
      if (m != -1)
      {
        int k = paramString.indexOf('?', m + 2);
        if (k != -1)
        {
          k = paramString.indexOf('?', k + 1);
          if (k != -1)
          {
            k = paramString.indexOf("?=", k + 1);
            if (k != -1)
            {
              k += 2;
              String str1 = paramString.substring(j, m);
              String str2 = a(paramString, m, k);
              if (str2 == null)
              {
                localStringBuilder.append(str1);
                localStringBuilder.append(paramString.substring(m, k));
                if (str2 == null) {
                  break label177;
                }
              }
              for (i = 1;; i = 0)
              {
                j = k;
                break;
                if ((i == 0) || (!ihb.a(str1))) {
                  localStringBuilder.append(str1);
                }
                localStringBuilder.append(str2);
                break label134;
              }
            }
          }
        }
      }
    } while (j == 0);
    localStringBuilder.append(paramString.substring(j));
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString, int paramInt1, int paramInt2)
  {
    int i = paramString.indexOf('?', paramInt1 + 2);
    if ((i == -1) || (i == paramInt2 - 2)) {}
    int j;
    do
    {
      return null;
      j = paramString.indexOf('?', i + 1);
    } while ((j == -1) || (j == paramInt2 - 2));
    String str1 = paramString.substring(paramInt1 + 2, i);
    String str3 = paramString.substring(i + 1, j);
    String str4 = paramString.substring(j + 1, paramInt2 - 2);
    String str2 = ihb.b(str1);
    if (str2 == null)
    {
      idy.b();
      paramString = String.valueOf(paramString.substring(paramInt1, paramInt2));
      idy.a(String.valueOf(str1).length() + 76 + String.valueOf(paramString).length() + "MIME charset '" + str1 + "' in encoded word '" + paramString + "' doesn't have a corresponding Java charset");
      return null;
    }
    if (!ihb.a.contains(str2.toLowerCase(Locale.US)))
    {
      idy.b();
      paramString = String.valueOf(paramString.substring(paramInt1, paramInt2));
      idy.a(String.valueOf(str2).length() + 87 + String.valueOf(str1).length() + String.valueOf(paramString).length() + "Current JDK doesn't support decoding of charset '" + str2 + "' (MIME charset '" + str1 + "' in encoded word '" + paramString + "')");
      return null;
    }
    if (str4.length() == 0)
    {
      idy.b();
      paramString = String.valueOf(paramString.substring(paramInt1, paramInt2));
      idy.a(String.valueOf(paramString).length() + 40 + "Missing encoded text in encoded word: '" + paramString + "'");
      return null;
    }
    try
    {
      if (str3.equalsIgnoreCase("Q")) {
        return a(str4, str2);
      }
      if (str3.equalsIgnoreCase("B")) {
        return new String(c(str4), str2);
      }
      idy.b();
      str1 = String.valueOf(paramString.substring(paramInt1, paramInt2));
      idy.a(String.valueOf(str1).length() + 44 + "Warning: Unknown encoding in encoded word '" + str1 + "'");
      return null;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      idy.b();
      paramString = String.valueOf(paramString.substring(paramInt1, paramInt2));
      idy.a(String.valueOf(paramString).length() + 39 + "Unsupported encoding in encoded word '" + paramString + "'", localUnsupportedEncodingException);
      return null;
    }
    catch (RuntimeException localRuntimeException)
    {
      idy.b();
      paramString = String.valueOf(paramString.substring(paramInt1, paramInt2));
      idy.a(String.valueOf(paramString).length() + 32 + "Could not decode encoded word '" + paramString + "'", localRuntimeException);
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString1.length())
    {
      char c = paramString1.charAt(i);
      if (c == '_') {
        localStringBuffer.append("=20");
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(c);
      }
    }
    return new String(b(localStringBuffer.toString()), paramString2);
  }
  
  private static byte[] b(String paramString)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramString = new iei(new ByteArrayInputStream(paramString.getBytes("US-ASCII")));
      for (;;)
      {
        int i = paramString.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      idy.b(paramString);
    }
  }
  
  private static byte[] c(String paramString)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramString = new ief(new ByteArrayInputStream(paramString.getBytes("US-ASCII")));
      for (;;)
      {
        int i = paramString.read();
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(i);
      }
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException paramString)
    {
      idy.b(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     ieh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */