import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class dbp
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  private static int a(char paramChar)
  {
    char c = paramChar - '0';
    paramChar = c;
    if (c > '\t') {
      paramChar = c - '\007';
    }
    return paramChar;
  }
  
  static String a(String paramString, int paramInt)
  {
    return paramString + "*" + paramInt;
  }
  
  static String a(Locale paramLocale)
  {
    if (paramLocale == null) {}
    while (TextUtils.isEmpty(paramLocale.getLanguage())) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLocale.getLanguage().toLowerCase());
    if (!TextUtils.isEmpty(paramLocale.getCountry())) {
      localStringBuilder.append("-").append(paramLocale.getCountry().toLowerCase());
    }
    return localStringBuilder.toString();
  }
  
  public static Map<String, String> a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length > 1) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((arrayOfString.length == 1) && (arrayOfString[0].length() != 0)) {
          localHashMap.put(arrayOfString[0], null);
        }
      }
    }
    return localHashMap;
  }
  
  public static double b(String paramString)
  {
    if (paramString == null) {
      return 0.0D;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return 0.0D;
  }
  
  public static boolean c(String paramString)
  {
    return Boolean.parseBoolean(paramString);
  }
  
  public static String d(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (paramString.contains("?")) {
      localObject = paramString.split("[\\?]")[1];
    }
    if (((String)localObject).contains("%3D")) {}
    try
    {
      paramString = URLDecoder.decode((String)localObject, "UTF-8");
      StringBuilder localStringBuilder;
      do
      {
        paramString = a(paramString);
        localObject = new String[9];
        localObject[0] = "dclid";
        localObject[1] = "utm_source";
        localObject[2] = "gclid";
        localObject[3] = "utm_campaign";
        localObject[4] = "utm_medium";
        localObject[5] = "utm_term";
        localObject[6] = "utm_content";
        localObject[7] = "utm_id";
        localObject[8] = "gmob_t";
        localStringBuilder = new StringBuilder();
        while (i < 9)
        {
          if (!TextUtils.isEmpty((CharSequence)paramString.get(localObject[i])))
          {
            if (localStringBuilder.length() > 0) {
              localStringBuilder.append("&");
            }
            localStringBuilder.append(localObject[i]).append("=").append((String)paramString.get(localObject[i]));
          }
          i += 1;
        }
        paramString = (String)localObject;
      } while (((String)localObject).contains("="));
      return null;
      return localStringBuilder.toString();
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
  
  static byte[] e(String paramString)
  {
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(a(paramString.charAt(i * 2)) << 4 | a(paramString.charAt(i * 2 + 1))));
      i += 1;
    }
    return arrayOfByte;
  }
}

/* Location:
 * Qualified Name:     dbp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */