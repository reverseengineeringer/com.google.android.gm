import java.util.Locale;

public final class mx
{
  static nh a = ni.c;
  static final mx b = new mx(false, 2, a);
  static final mx c = new mx(true, 2, a);
  private static final String e = Character.toString('‎');
  private static final String f = Character.toString('‏');
  public final nh d;
  private final boolean g;
  private final int h;
  
  private mx(boolean paramBoolean, int paramInt, nh paramnh)
  {
    g = paramBoolean;
    h = paramInt;
    d = paramnh;
  }
  
  public static mx a()
  {
    my localmy = new my();
    if ((b == 2) && (c == a))
    {
      if (a) {
        return c;
      }
      return b;
    }
    return new mx(a, b, c);
  }
  
  static boolean a(Locale paramLocale)
  {
    return np.a.a(paramLocale) == 1;
  }
  
  private static int b(String paramString)
  {
    int m = 0;
    paramString = new mz(paramString);
    d = c;
    int j = 0;
    int i = 0;
    for (;;)
    {
      int k = m;
      if (d > 0) {}
      switch (paramString.a())
      {
      case 9: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        if (j == 0) {
          j = i;
        }
        break;
      case 0: 
        if (i == 0)
        {
          k = -1;
          return k;
        }
        if (j == 0) {
          j = i;
        }
        break;
      case 14: 
      case 15: 
        if (j == i) {
          return -1;
        }
        i -= 1;
        break;
      case 1: 
      case 2: 
        if (i == 0) {
          return 1;
        }
        if (j == 0) {
          j = i;
        }
        break;
      case 16: 
      case 17: 
        if (j == i) {
          return 1;
        }
        i -= 1;
        break;
      case 18: 
        i += 1;
      }
    }
  }
  
  private static int c(String paramString)
  {
    paramString = new mz(paramString);
    d = 0;
    int m = 0;
    int n = 0;
    int j = 0;
    label22:
    while ((d < c) && (m == 0))
    {
      e = a.charAt(d);
      int k;
      if (Character.isHighSurrogate(e))
      {
        k = Character.codePointAt(a, d);
        d += Character.charCount(k);
        k = Character.getDirectionality(k);
      }
      for (;;)
      {
        switch (k)
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          m = j;
          break label22;
          d += 1;
          int i1 = mz.a(e);
          k = i1;
          if (b)
          {
            String str;
            int i;
            if (e == '<')
            {
              k = d;
              for (;;)
              {
                if (d >= c) {
                  break label367;
                }
                str = a;
                i1 = d;
                d = (i1 + 1);
                e = str.charAt(i1);
                if (e == '>')
                {
                  k = 12;
                  break;
                }
                if ((e == '"') || (e == '\''))
                {
                  i1 = e;
                  do
                  {
                    if (d >= c) {
                      break;
                    }
                    str = a;
                    int i2 = d;
                    d = (i2 + 1);
                    i = str.charAt(i2);
                    e = i;
                  } while (i != i1);
                }
              }
              label367:
              d = k;
              e = '<';
              k = 13;
            }
            else
            {
              k = i1;
              if (e == '&')
              {
                do
                {
                  if (d >= c) {
                    break;
                  }
                  str = a;
                  k = d;
                  d = (k + 1);
                  i = str.charAt(k);
                  e = i;
                } while (i != 59);
                k = 12;
              }
            }
          }
          break;
        }
      }
      j += 1;
      n = -1;
      continue;
      j += 1;
      n = 1;
      continue;
      j -= 1;
      n = 0;
      continue;
      if (j == 0) {
        return -1;
      }
      m = j;
      continue;
      if (j == 0) {
        return 1;
      }
      m = j;
    }
    if (m != 0)
    {
      if (n != 0) {
        return n;
      }
      for (;;)
      {
        if (d <= 0) {
          break label598;
        }
        switch (paramString.a())
        {
        default: 
          break;
        case 14: 
        case 15: 
          if (m == j) {
            break;
          }
          j -= 1;
          break;
        case 16: 
        case 17: 
          if (m == j) {
            return 1;
          }
          j -= 1;
          break;
        case 18: 
          j += 1;
        }
      }
    }
    label598:
    return 0;
  }
  
  public final String a(String paramString)
  {
    Object localObject = d;
    if (paramString == null) {
      return null;
    }
    boolean bool1 = ((nh)localObject).a(paramString, paramString.length());
    StringBuilder localStringBuilder = new StringBuilder();
    int i;
    label60:
    boolean bool2;
    label99:
    char c1;
    if ((h & 0x2) != 0)
    {
      i = 1;
      if (i != 0)
      {
        if (!bool1) {
          break label214;
        }
        localObject = ni.b;
        bool2 = ((nh)localObject).a(paramString, paramString.length());
        if ((g) || ((!bool2) && (c(paramString) != 1))) {
          break label222;
        }
        localObject = e;
        localStringBuilder.append((String)localObject);
      }
      if (bool1 == g) {
        break label264;
      }
      if (!bool1) {
        break label257;
      }
      c1 = '‫';
      label125:
      localStringBuilder.append(c1);
      localStringBuilder.append(paramString);
      localStringBuilder.append('‬');
      label148:
      if (!bool1) {
        break label274;
      }
      localObject = ni.b;
      label158:
      bool1 = ((nh)localObject).a(paramString, paramString.length());
      if ((g) || ((!bool1) && (b(paramString) != 1))) {
        break label282;
      }
      paramString = e;
    }
    for (;;)
    {
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
      i = 0;
      break;
      label214:
      localObject = ni.a;
      break label60;
      label222:
      if ((g) && ((!bool2) || (c(paramString) == -1)))
      {
        localObject = f;
        break label99;
      }
      localObject = "";
      break label99;
      label257:
      c1 = '‪';
      break label125;
      label264:
      localStringBuilder.append(paramString);
      break label148;
      label274:
      localObject = ni.a;
      break label158;
      label282:
      if ((g) && ((!bool1) || (b(paramString) == -1))) {
        paramString = f;
      } else {
        paramString = "";
      }
    }
  }
}

/* Location:
 * Qualified Name:     mx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */