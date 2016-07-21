import android.text.TextUtils;
import java.util.Locale;

public class cdy
{
  final String c;
  final String d;
  final String e;
  public String f;
  String g;
  
  cdy(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    f = paramString1;
    g = paramString3;
    c = paramString2;
    d = paramString4;
    e = paramString5;
  }
  
  public String a(cdx paramcdx)
  {
    String str = String.format(Locale.US, "href=\"%s\"", new Object[] { g });
    paramcdx.c();
    paramcdx.a(c, str, d, e);
    return paramcdx.a();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof cdy)) {}
    do
    {
      return false;
      paramObject = (cdy)paramObject;
    } while ((!TextUtils.equals(c, c)) || (!TextUtils.equals(d, d)) || (!TextUtils.equals(e, e)) || (!TextUtils.equals(f, f)) || (!TextUtils.equals(g, g)));
    return true;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "[DriveChip:%s,%s,%s,%s,%s]", new Object[] { c, d, e, f, g });
  }
}

/* Location:
 * Qualified Name:     cdy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */