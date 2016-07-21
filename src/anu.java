public final class anu
{
  public int a = 1;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public final long a()
  {
    return a * 1000 * (604800 * b + 86400 * c + d * 3600 + e * 60 + f);
  }
  
  public final void a(String paramString)
  {
    int i = 1;
    a = 1;
    b = 0;
    c = 0;
    d = 0;
    e = 0;
    f = 0;
    int m = paramString.length();
    if (m <= 0) {}
    for (;;)
    {
      return;
      j = paramString.charAt(0);
      if (j == 45) {
        a = -1;
      }
      while (m >= i)
      {
        if (paramString.charAt(i) == 'P') {
          break label137;
        }
        throw new ant(String.valueOf(paramString).length() + 56 + "Duration.parse(str='" + paramString + "') expected 'P' at index=" + i);
        if (j != 43) {
          i = 0;
        }
      }
    }
    label137:
    int j = i + 1;
    i = j;
    if (paramString.charAt(j) == 'T') {
      i = j + 1;
    }
    int k = 0;
    j = i;
    i = k;
    label170:
    char c1;
    if (j < m)
    {
      c1 = paramString.charAt(j);
      if ((c1 < '0') || (c1 > '9')) {
        break label215;
      }
      i = i * 10 + (c1 - '0');
    }
    label215:
    label295:
    do
    {
      for (;;)
      {
        j += 1;
        break label170;
        break;
        if (c1 == 'W')
        {
          b = i;
          i = 0;
        }
        else if (c1 == 'H')
        {
          d = i;
          i = 0;
        }
        else if (c1 == 'M')
        {
          e = i;
          i = 0;
        }
        else if (c1 == 'S')
        {
          f = i;
          i = 0;
        }
        else
        {
          if (c1 != 'D') {
            break label295;
          }
          c = i;
          i = 0;
        }
      }
    } while (c1 == 'T');
    throw new ant(String.valueOf(paramString).length() + 63 + "Duration.parse(str='" + paramString + "') unexpected char '" + c1 + "' at index=" + j);
  }
}

/* Location:
 * Qualified Name:     anu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */