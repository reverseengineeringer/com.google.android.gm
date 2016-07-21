import android.text.TextUtils;

final class bkt
  implements bkp
{
  final CharSequence a;
  final long b;
  final Long c;
  final String d;
  final long e;
  final bkn f;
  boolean g = false;
  private final CharSequence h;
  private CharSequence i;
  
  public bkt(bkn parambkn)
  {
    h = c;
    a = d.trim();
    b = g;
    c = h;
    d = n;
    e = i;
    f = parambkn;
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      i = paramString;
      return;
    }
    i = paramString.trim();
  }
  
  public final boolean a()
  {
    return g;
  }
  
  public final CharSequence b()
  {
    return a;
  }
  
  public final long c()
  {
    return b;
  }
  
  public final Long d()
  {
    return c;
  }
  
  public final String e()
  {
    return d;
  }
  
  public final long f()
  {
    return e;
  }
  
  public final bkn g()
  {
    return f;
  }
  
  public final CharSequence h()
  {
    if (!TextUtils.isEmpty(i)) {
      return i;
    }
    return f.d;
  }
  
  public final String toString()
  {
    String str1 = String.valueOf(h);
    String str2 = String.valueOf(a);
    return String.valueOf(str1).length() + 3 + String.valueOf(str2).length() + str1 + " <" + str2 + ">";
  }
}

/* Location:
 * Qualified Name:     bkt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */