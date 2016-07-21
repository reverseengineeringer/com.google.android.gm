import android.text.TextUtils;
import java.util.Iterator;
import java.util.Set;

public final class dri
  extends cvm
{
  public static String a(Set<String> paramSet)
  {
    if (paramSet == null)
    {
      if (paramSet != null) {
        return paramSet.toString();
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder("[");
    paramSet = paramSet.iterator();
    int i = 0;
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(c(str));
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      str = paramString;
    } while (dpy.f(paramString));
    String str = String.valueOf("userlabel:");
    paramString = String.valueOf(String.valueOf(paramString.hashCode()));
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
}

/* Location:
 * Qualified Name:     dri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */