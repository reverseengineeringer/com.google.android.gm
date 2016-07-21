import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cvm
{
  public static final String a = cvl.a;
  private static final Pattern b = Pattern.compile("GMT([-+]\\d{4})$");
  private static Boolean c = null;
  
  public static int a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 2)) {
      return Log.v(paramString1, a(paramString2, paramVarArgs));
    }
    return 0;
  }
  
  public static int a(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 2)) {
      return Log.v(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
    return 0;
  }
  
  public static String a(Uri paramUri)
  {
    return a(a, paramUri);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = String.valueOf("account:");
    paramString = String.valueOf(a(a, paramString));
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
  
  public static String a(String paramString, Uri paramUri)
  {
    paramString = paramUri.getPathSegments();
    paramUri = new Uri.Builder().scheme(paramUri.getScheme()).authority(paramUri.getAuthority()).query(paramUri.getQuery()).fragment(paramUri.getFragment());
    paramUri.appendPath(a((String)paramString.get(0)));
    int i = 1;
    while (i < paramString.size())
    {
      paramUri.appendPath((String)paramString.get(i));
      i += 1;
    }
    return paramUri.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    return String.valueOf(paramString2.hashCode());
  }
  
  private static String a(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs.length > 0) {
      str = String.format(Locale.ENGLISH, paramString, paramVarArgs);
    }
    return str;
  }
  
  public static boolean a(String paramString, int paramInt)
  {
    if (3 > paramInt) {}
    while ((!Log.isLoggable(paramString, paramInt)) && (!Log.isLoggable(a, paramInt))) {
      return false;
    }
    return true;
  }
  
  public static int b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 3)) {
      return Log.d(paramString1, a(paramString2, paramVarArgs));
    }
    return 0;
  }
  
  public static int b(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 3)) {
      return Log.d(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
    return 0;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    return b.matcher(paramString).replaceFirst("$1");
  }
  
  public static int c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 4)) {
      return Log.i(paramString1, a(paramString2, paramVarArgs));
    }
    return 0;
  }
  
  public static int c(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 4)) {
      return Log.i(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
    return 0;
  }
  
  public static int d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 5)) {
      return Log.w(paramString1, a(paramString2, paramVarArgs));
    }
    return 0;
  }
  
  public static int d(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 5)) {
      return Log.w(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
    return 0;
  }
  
  public static int e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 6)) {
      return Log.e(paramString1, a(paramString2, paramVarArgs));
    }
    return 0;
  }
  
  public static int e(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (a(paramString1, 6)) {
      return Log.e(paramString1, a(paramString2, paramVarArgs), paramThrowable);
    }
    return 0;
  }
  
  public static int f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    return Log.wtf(paramString1, a(paramString2, paramVarArgs), new Error());
  }
  
  public static int f(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    return Log.wtf(paramString1, a(paramString2, paramVarArgs), paramThrowable);
  }
}

/* Location:
 * Qualified Name:     cvm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */