import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.util.Locale;

public final class cuw
{
  private static final String a = cvl.a;
  
  public static Uri a(Context paramContext, Uri paramUri, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("topic must be non-empty");
    }
    Object localObject1 = paramUri;
    if (paramUri.toString().contains("%locale%"))
    {
      paramUri = paramUri.toString();
      Object localObject2 = Locale.getDefault();
      localObject1 = String.valueOf(((Locale)localObject2).getLanguage());
      localObject2 = String.valueOf(((Locale)localObject2).getCountry().toLowerCase());
      localObject1 = Uri.parse(paramUri.replace("%locale%", String.valueOf(localObject1).length() + 1 + String.valueOf(localObject2).length() + (String)localObject1 + "-" + (String)localObject2));
    }
    paramUri = ((Uri)localObject1).buildUpon();
    paramUri.appendQueryParameter("p", paramString);
    paramUri.appendQueryParameter("version", a(paramContext));
    return paramUri.build();
  }
  
  private static String a(Context paramContext)
  {
    String str2 = getApplicationInfopackageName;
    String str1;
    try
    {
      int i = getPackageManagergetPackageInfo0versionCode;
      return String.valueOf(i);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      str1 = a;
      paramContext = String.valueOf(str2);
      if (paramContext.length() == 0) {}
    }
    for (paramContext = "Error finding package name for application".concat(paramContext);; paramContext = new String("Error finding package name for application"))
    {
      cvm.e(str1, paramContext, new Object[0]);
      throw new IllegalStateException("unable to determine package name for application");
    }
  }
}

/* Location:
 * Qualified Name:     cuw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */