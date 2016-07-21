import android.text.TextUtils;
import java.util.Map;

public final class cui
{
  private static final Map<String, String> a = new hen().b("gmail.com", "gmail").b("googlemail.com", "gmail").b("hotmail.com", "hotmail").b("hotmail.co.uk", "hotmail").b("hotmail.com.br", "hotmail").b("msn.com", "hotmail").b("live.co.uk", "hotmail").b("windowslive.com", "hotmail").b("outlook.com", "hotmail").b("yahoo.com", "yahoo").b("yahoo.co.in", "yahoo").b("yahoo.com.br", "yahoo").b("ymail.com", "yahoo").b("aol.com", "aol").b("aim.com", "aol").b("me.com", "apple").b("mac.com", "apple").b("icloud.com", "apple").b("mail.ru", "mail.ru").b("inbox.ru", "mail.ru").b("qq.com", "qq.com").b("comcast.com", "comcast").b("comcast.net", "comcast").b("rediffmail.com", "rediffmail").b("docomo.ne.jp", "docomo").b("bol.com.br", "bol.com.br").b("163.com", "163.com").b("ig.com.br", "ig.com.br").b("terra.com.br", "terra.com.br").b("verizon.net", "verizon").b("uol.com.br", "uol.com.br").b("orange.fr", "orange").b("orange.co.uk", "orange").b("wanadoo.fr", "orange").b("sfr.fr", "sfr").b("neuf.fr", "sfr").b("club-internet.fr", "sfr").b("cegetel.net", "sfr").b("yandex.ru", "yandex").b();
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
      return paramString;
    }
    String str2 = (String)a.get(paramString);
    String str1 = str2;
    int i;
    if (str2 == null)
    {
      paramString = paramString.substring(0, paramString.lastIndexOf('.'));
      i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label164:
          str1 = "other";
        }
        break;
      }
    }
    for (;;)
    {
      paramString = str1;
      if (str1 != null) {
        break;
      }
      return "other";
      if (!paramString.equals("yahoo")) {
        break label164;
      }
      i = 0;
      break label164;
      if (!paramString.equals("yahoo.co")) {
        break label164;
      }
      i = 1;
      break label164;
      if (!paramString.equals("yahoo.com")) {
        break label164;
      }
      i = 2;
      break label164;
      if (!paramString.equals("hotmail")) {
        break label164;
      }
      i = 3;
      break label164;
      if (!paramString.equals("hotmail.co")) {
        break label164;
      }
      i = 4;
      break label164;
      if (!paramString.equals("hotmail.com")) {
        break label164;
      }
      i = 5;
      break label164;
      if (!paramString.equals("live")) {
        break label164;
      }
      i = 6;
      break label164;
      if (!paramString.equals("live.co")) {
        break label164;
      }
      i = 7;
      break label164;
      if (!paramString.equals("live.com")) {
        break label164;
      }
      i = 8;
      break label164;
      if (!paramString.equals("livemail.com")) {
        break label164;
      }
      i = 9;
      break label164;
      if (!paramString.equals("outlook")) {
        break label164;
      }
      i = 10;
      break label164;
      if (!paramString.equals("outlook.co")) {
        break label164;
      }
      i = 11;
      break label164;
      if (!paramString.equals("outlook.com")) {
        break label164;
      }
      i = 12;
      break label164;
      str1 = "yahoo";
      continue;
      str1 = "hotmail";
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('@');
    if (i >= 0) {
      return paramString.substring(i + 1).toLowerCase();
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (!"other".equals(a(paramString)));
    return "other";
  }
  
  public static String d(String paramString)
  {
    return c(b(paramString));
  }
  
  public static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('@');
    if (i >= 0)
    {
      String str = paramString.substring(0, i);
      paramString = paramString.substring(i + 1).toLowerCase();
      str = String.valueOf(String.valueOf(str.hashCode()));
      paramString = String.valueOf(c(paramString));
      return String.valueOf(str).length() + 1 + String.valueOf(paramString).length() + str + "@" + paramString;
    }
    return String.valueOf(paramString.hashCode());
  }
  
  public static boolean f(String paramString)
  {
    return "gmail".equals(a(b(paramString)));
  }
}

/* Location:
 * Qualified Name:     cui
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */