import java.util.List;

final class ijl
  implements ihk
{
  ihm a = ihl.a;
  List<ihm> b = null;
  int c = 0;
  boolean d;
  boolean e;
  
  ijl(ijk paramijk, StringBuilder paramStringBuilder) {}
  
  private final void d()
  {
    if (e)
    {
      f.append('\'');
      e = false;
    }
  }
  
  private final void h(String paramString)
  {
    d();
    if (d) {
      f.append(' ');
    }
    f.append(paramString);
    d = true;
  }
  
  public final void a()
  {
    d();
  }
  
  public final void a(String paramString)
  {
    if (b != null) {
      b.clear();
    }
    a = g.c.a(paramString);
    d = false;
    c = f.length();
    if (f.length() != 0) {
      f.append(';');
    }
    f.append(paramString).append(':');
  }
  
  public final void b()
  {
    if (a != ihl.a) {
      h(")");
    }
    a = ((ihm)b.remove(b.size() - 1));
  }
  
  public final void b(String paramString)
  {
    if (paramString.startsWith("-")) {}
    for (int i = 4;; i = 1)
    {
      if (((i & a.a) != 0) || (a.b.contains(paramString))) {
        h(paramString);
      }
      return;
    }
  }
  
  public final void c()
  {
    if (!d)
    {
      f.setLength(c);
      return;
    }
    d();
  }
  
  public final void c(String paramString)
  {
    paramString = ijj.a(paramString);
    if (a.b.contains(paramString)) {
      h(paramString);
    }
    while ((a.a & 0x48) != 72) {
      return;
    }
    if (!e)
    {
      e = true;
      if (d) {
        f.append(' ');
      }
      f.append('\'');
      d = true;
    }
    for (;;)
    {
      f.append(ijj.a(paramString));
      return;
      f.append(' ');
    }
  }
  
  public final void d(String paramString)
  {
    d();
    if ((a.a & 0x2) != 0) {
      h(ijj.a(paramString));
    }
  }
  
  public final void e(String paramString)
  {
    d();
    int i = a.a & 0x50;
    if (((i - 1 & i) == 0) && (i == 64) && (paramString.length() > 2) && (ijk.a(paramString, paramString.length() - 1))) {
      h(ijj.a(paramString));
    }
  }
  
  public final void f(String paramString)
  {
    d();
    if (a.b.contains(paramString)) {
      h(paramString);
    }
  }
  
  public final void g(String paramString)
  {
    d();
    if (b == null) {
      b = hgd.a();
    }
    b.add(a);
    String str = ijj.a(paramString);
    paramString = (String)a.c.get(str);
    if (paramString != null) {}
    for (paramString = g.c.a(paramString);; paramString = ihl.a)
    {
      a = paramString;
      if (a != ihl.a) {
        h(str);
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     ijl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */