import android.text.TextUtils;
import java.util.Locale;

public final class cdr
  extends cdy
{
  final String a;
  public long b;
  
  cdr(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    super(null, paramString1, null, paramString2, paramString3);
    a = paramString4;
    b = paramLong;
  }
  
  public final String a(cdx paramcdx)
  {
    if (a())
    {
      String str = String.format(Locale.US, "rel=\"%s %d\"", new Object[] { a, Long.valueOf(b) });
      paramcdx.c();
      paramcdx.a(c, str, d, e);
      return paramcdx.a();
    }
    return super.a(paramcdx);
  }
  
  public final boolean a()
  {
    return b != -1L;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof cdr)) {}
    do
    {
      return false;
      paramObject = (cdr)paramObject;
    } while ((!TextUtils.equals(c, c)) || (!TextUtils.equals(d, d)) || (!TextUtils.equals(e, e)) || (!TextUtils.equals(f, f)) || (!TextUtils.equals(g, g)) || (!TextUtils.equals(a, a)) || (b != b));
    return true;
  }
  
  public final String toString()
  {
    if (a()) {
      return String.format(Locale.US, "[PlaceholderDriveChip:%s,%s,%s,%d]", new Object[] { c, d, a, Long.valueOf(b) });
    }
    return super.toString();
  }
}

/* Location:
 * Qualified Name:     cdr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */