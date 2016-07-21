import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import java.util.Iterator;
import java.util.List;

public class gjm
{
  private static final String d = gjm.class.getSimpleName();
  public final String a;
  public final String b;
  public final String c;
  private final String e;
  private final SharedPreferences f;
  
  public gjm(Context paramContext, String paramString)
  {
    e = paramString;
    f = paramContext.getSharedPreferences("com.google.android.libraries.happiness", 0);
    paramString = Uri.parse(e);
    a = paramString.getHost().toLowerCase();
    paramContext = hgd.a(paramString.getPathSegments());
    if (paramContext.size() > 0) {
      paramContext.remove(paramContext.size() - 1);
    }
    paramContext = String.valueOf(haw.a("/").a(paramContext));
    if (paramContext.length() != 0) {}
    for (paramContext = "/".concat(paramContext);; paramContext = new String("/"))
    {
      b = paramContext;
      paramContext = String.valueOf(paramString.getScheme());
      paramString = a;
      String str = b;
      c = (String.valueOf(paramContext).length() + 3 + String.valueOf(paramString).length() + String.valueOf(str).length() + paramContext + "://" + paramString + str);
      return;
    }
  }
  
  public final String a()
  {
    return f.getString("PAIDCONTENT_COOKIE", "");
  }
  
  public final void a(String paramString)
  {
    String str = a();
    boolean bool;
    Object localObject;
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      if ("; ".length() == 0) {
        break label206;
      }
      bool = true;
      hbe.a(bool, "The separator may not be the empty string.");
      if ("; ".length() != 1) {
        break label211;
      }
      localObject = hbo.a(gzx.a("; ".charAt(0)));
      label55:
      localObject = new hbo(c, true, a, d);
      gzx localgzx = gzx.b();
      hbe.a(localgzx);
      localObject = new hbo(c, b, localgzx, d);
      hbe.a(paramString);
      localObject = new hbt((hbo)localObject, paramString).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramString = (String)((Iterator)localObject).next();
      } while (paramString.equals(str));
    }
    for (;;)
    {
      if (!paramString.isEmpty())
      {
        localObject = String.valueOf(paramString);
        if (((String)localObject).length() == 0) {
          break label231;
        }
        "Saving cookie=".concat((String)localObject);
      }
      for (;;)
      {
        f.edit().putString("PAIDCONTENT_COOKIE", paramString).apply();
        return;
        label206:
        bool = false;
        break;
        label211:
        localObject = new hbo(new hbr("; "));
        break label55;
        label231:
        new String("Saving cookie=");
      }
      paramString = str;
    }
  }
}

/* Location:
 * Qualified Name:     gjm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */