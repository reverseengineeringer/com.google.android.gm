import android.text.TextUtils;
import java.util.regex.Pattern;

public final class ddt
  implements Comparable<ddt>
{
  public static final ddt a = new ddt();
  private static final Pattern f = Pattern.compile(" +");
  public final String b;
  public final String c;
  public final String d;
  public final String e;
  
  private ddt()
  {
    b = "DEFAULT";
    c = "rewrite";
    d = "";
    e = null;
  }
  
  private ddt(String paramString1, String paramString2)
  {
    b = paramString1;
    paramString1 = f.split(paramString2);
    if (paramString1.length < 2) {
      throw new ddu(paramString2);
    }
    d = paramString1[0];
    c = paramString1[1];
    String str = c;
    switch (str.hashCode())
    {
    default: 
      label84:
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new ddu(paramString2);
        if (!str.equals("rewrite")) {
          break label84;
        }
        continue;
        if (!str.equals("block")) {
          break label84;
        }
        i = 1;
      }
    }
    if (paramString1.length < 3) {
      throw new ddu(paramString2);
    }
    e = paramString1[2];
    return;
    e = null;
  }
  
  public static ddt a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return a;
    }
    return new ddt(paramString1, paramString2);
  }
  
  public final String apply(String paramString)
  {
    String str = c;
    int i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalStateException("Bad rule type");
        if (str.equals("block"))
        {
          i = 0;
          continue;
          if (str.equals("rewrite")) {
            i = 1;
          }
        }
        break;
      }
    }
    str = null;
    do
    {
      return str;
      str = paramString;
    } while (e == null);
    str = String.valueOf(e);
    paramString = String.valueOf(paramString.substring(d.length()));
    if (paramString.length() != 0) {
      return str.concat(paramString);
    }
    return new String(str);
  }
}

/* Location:
 * Qualified Name:     ddt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */