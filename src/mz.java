final class mz
{
  private static final byte[] f = new byte['܀'];
  final String a;
  final boolean b;
  final int c;
  int d;
  char e;
  
  static
  {
    int i = 0;
    while (i < 1792)
    {
      f[i] = Character.getDirectionality(i);
      i += 1;
    }
  }
  
  mz(String paramString)
  {
    a = paramString;
    b = false;
    c = paramString.length();
  }
  
  static byte a(char paramChar)
  {
    if (paramChar < '܀') {
      return f[paramChar];
    }
    return Character.getDirectionality(paramChar);
  }
  
  final byte a()
  {
    byte b2 = 12;
    e = a.charAt(d - 1);
    int j;
    if (Character.isLowSurrogate(e))
    {
      j = Character.codePointBefore(a, d);
      d -= Character.charCount(j);
      b1 = Character.getDirectionality(j);
      return b1;
    }
    d -= 1;
    byte b1 = a(e);
    if (b)
    {
      label104:
      String str;
      int k;
      if (e == '>')
      {
        j = d;
        for (;;)
        {
          if (d <= 0) {
            break label236;
          }
          str = a;
          k = d - 1;
          d = k;
          e = str.charAt(k);
          b1 = b2;
          if (e == '<') {
            break;
          }
          if (e == '>') {
            break label236;
          }
          if ((e == '"') || (e == '\''))
          {
            k = e;
            if (d > 0)
            {
              str = a;
              int m = d - 1;
              d = m;
              int i = str.charAt(m);
              e = i;
              if (i != k) {
                break label104;
              }
            }
          }
        }
        label236:
        d = j;
        e = '>';
        return 13;
      }
      if (e == ';')
      {
        j = d;
        do
        {
          if (d <= 0) {
            break label324;
          }
          str = a;
          k = d - 1;
          d = k;
          e = str.charAt(k);
          b1 = b2;
          if (e == '&') {
            break;
          }
        } while (e != ';');
        label324:
        d = j;
        e = ';';
        return 13;
      }
    }
    return b1;
  }
}

/* Location:
 * Qualified Name:     mz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */