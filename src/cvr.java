import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.util.List;
import java.util.Set;

public final class cvr
{
  private static final String a = cvl.a;
  private static final Set<String> b = hfd.a("message/rfc822", "application/eml");
  
  public static String a(String paramString1, String paramString2)
  {
    String str = b(paramString1);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return paramString2;
      if (("text/plain".equalsIgnoreCase(paramString2)) || ("application/octet-stream".equalsIgnoreCase(paramString2))) {}
      for (int i = 1;; i = 0)
      {
        paramString1 = null;
        if ((i != 0) || (TextUtils.isEmpty(paramString2))) {
          paramString1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (TextUtils.isEmpty(paramString1)) {
          break;
        }
        return paramString1;
      }
      if ("eml".equals(str)) {
        return "message/rfc822";
      }
      if ("epub".equals(str)) {
        return "application/epub+zip";
      }
    } while (!TextUtils.isEmpty(paramString2));
    return "application/octet-stream";
  }
  
  public static boolean a(Context paramContext, Uri paramUri, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0) || ("null".equals(paramString)))
    {
      cvm.b(a, "Attachment with null content type. '%s", new Object[] { paramUri });
      return false;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setFlags(524289);
    if (paramUri != null) {
      cxa.a(localIntent, paramUri, paramString);
    }
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.queryIntentActivities(localIntent, 65536);
      if (paramContext.size() == 0) {
        cvm.d(a, "Unable to find supporting activity. mime-type: %s, uri: %s, normalized mime-type: %s normalized uri: %s", new Object[] { paramString, paramUri, localIntent.getType(), localIntent.getData() });
      }
      if (paramContext.size() <= 0) {
        break label193;
      }
      return true;
    }
    catch (UnsupportedOperationException paramContext)
    {
      String str;
      return false;
    }
    str = String.valueOf(paramContext.getPackageName());
    if (str.length() != 0) {}
    for (str = "content://".concat(str);; str = new String("content://"))
    {
      cxa.a(localIntent, Uri.parse(str), paramString);
      break;
    }
    label193:
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return "application/vnd.android.package-archive".equals(paramString);
  }
  
  public static String b(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf('.');
      localObject1 = localObject2;
      if (i > 0)
      {
        localObject1 = localObject2;
        if (i < paramString.length() - 1) {
          localObject1 = paramString.substring(i + 1).toLowerCase();
        }
      }
    }
    return (String)localObject1;
  }
  
  public static boolean c(String paramString)
  {
    return b.contains(paramString);
  }
}

/* Location:
 * Qualified Name:     cvr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */