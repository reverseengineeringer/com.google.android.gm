public final class gpu
{
  public final StringBuilder a = new StringBuilder();
  int b = 0;
  private int c = 2;
  private int d = gpv.a;
  
  private final void a(boolean paramBoolean)
  {
    if ((c > 0) && (b > 0))
    {
      int i = 0;
      while (i < b)
      {
        a.append('>');
        i += 1;
      }
      if (paramBoolean) {
        a.append(' ');
      }
    }
  }
  
  private static boolean a(char paramChar)
  {
    return " \n\r\t\f".indexOf(paramChar) >= 0;
  }
  
  final void a()
  {
    switch (gpq.a[(d - 1)])
    {
    }
    for (;;)
    {
      d = gpv.a;
      return;
      if (c == 0)
      {
        a.append(" ");
        continue;
        while (c <= 0) {
          b();
        }
        while (c < 2) {
          b();
        }
      }
    }
  }
  
  final void a(int paramInt)
  {
    if (paramInt - 1 > d - 1) {
      d = paramInt;
    }
  }
  
  final void a(String paramString)
  {
    if (paramString.length() == 0) {}
    boolean bool2;
    do
    {
      return;
      boolean bool1 = a(paramString.charAt(0));
      bool2 = a(paramString.charAt(paramString.length() - 1));
      paramString = gzx.a(" \n\r\t\f").e(paramString);
      paramString = gzx.a(" \n\r\t\f").b(paramString, ' ');
      if (bool1) {
        a(gpv.b);
      }
      b(paramString);
    } while (!bool2);
    a(gpv.b);
  }
  
  final void b()
  {
    a(false);
    a.append('\n');
    c += 1;
  }
  
  final void b(String paramString)
  {
    if (paramString.length() == 0) {
      return;
    }
    if (paramString.indexOf('\n') < 0) {}
    for (boolean bool = true;; bool = false)
    {
      hbe.a(bool, "text must not contain newlines.");
      a();
      a(true);
      a.append(paramString);
      c = 0;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     gpu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */