import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public final class drd
{
  static final Set<String> a = hfd.a("^^out", "^r");
  static final Set<String> b = hfd.b("^f");
  static final Set<String> c = hfd.a("^^out", "^r", "^f");
  private static final Pattern d = Pattern.compile("\\^\\*\\*\\^");
  private static final Map<String, dqz> e = new ConcurrentHashMap();
  
  public static dqz a(Context paramContext, String paramString1, String paramString2)
  {
    String str = String.valueOf(paramString1);
    Object localObject = String.valueOf(paramString2);
    if (((String)localObject).length() != 0) {}
    dqz localdqz;
    for (str = str.concat((String)localObject);; str = new String(str))
    {
      localdqz = (dqz)e.get(str);
      localObject = localdqz;
      if (localdqz == null)
      {
        paramContext = new dra(paramContext, paramString1, Uri.withAppendedPath(Uri.withAppendedPath(dpy.b(paramString1), Uri.encode(paramString2)), "1"), true);
        if (a.size() <= 0) {
          break;
        }
        localObject = paramContext.a(0);
        e.put(str, localObject);
      }
      return (dqz)localObject;
    }
    dri.e("Gmail.LabelManager", "Unable to get label %s for account %s", new Object[] { dri.c(paramString2), dri.a(paramString1) });
    return localdqz;
  }
  
  public static dra a(List<String> paramList)
  {
    ;
    Uri.Builder localBuilder = dpy.b(str1).buildUpon();
    boolean bool;
    if (bool) {}
    for (String str2 = "1";; str2 = "0") {
      return new dra(paramList, str1, localBuilder.appendEncodedPath(str2).build(), bool);
    }
  }
  
  public static Map<String, dqz> a(String paramString1, String paramString2)
  {
    dri.b("Gmail.LabelManager", "label query result: %s", new Object[] { paramString2 });
    HashMap localHashMap = new HashMap();
    a(paramString1, paramString2, localHashMap, null);
    return localHashMap;
  }
  
  public static void a(String paramString1, String paramString2, Map<String, dqz> paramMap1, Map<String, dqz> paramMap2)
  {
    int i = 0;
    dri.b("Gmail.LabelManager", "label query result: %s", new Object[] { paramString2 });
    paramMap1.clear();
    if (paramString2 != null)
    {
      paramString2 = TextUtils.split(paramString2, d);
      int j = paramString2.length;
      while (i < j)
      {
        dqz localdqz = dqz.a(paramString1, paramString2[i], paramMap2);
        if (localdqz != null) {
          paramMap1.put(localdqz.b(), localdqz);
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     drd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */