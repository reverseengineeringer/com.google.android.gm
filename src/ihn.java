import java.util.ArrayList;
import java.util.List;

final class ihn
  implements Iterable<String>
{
  static final int[] e = new int[0];
  static final ihr[] f = new ihr[0];
  static final ihn g;
  static final boolean[] h;
  static final char[] i = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final iho j = new iho(e);
  private static final boolean[] k;
  private static final ijs l;
  public final String a;
  public final iho b;
  final int[] c;
  final ihr[] d;
  
  static
  {
    g = new ihn("", j, e, f);
    k = new boolean[''];
    int m = 48;
    while (m <= 57)
    {
      k[m] = true;
      m += 1;
    }
    m = 65;
    while (m <= 90)
    {
      k[m] = true;
      m += 1;
    }
    m = 97;
    while (m <= 122)
    {
      k[m] = true;
      m += 1;
    }
    k[95] = true;
    k[45] = true;
    l = new ijs(hel.f().b("em", Integer.valueOf(0)).b("ex", Integer.valueOf(0)).b("ch", Integer.valueOf(0)).b("rem", Integer.valueOf(0)).b("vh", Integer.valueOf(0)).b("vw", Integer.valueOf(0)).b("vmin", Integer.valueOf(0)).b("vmax", Integer.valueOf(0)).b("px", Integer.valueOf(0)).b("mm", Integer.valueOf(0)).b("cm", Integer.valueOf(0)).b("in", Integer.valueOf(0)).b("pt", Integer.valueOf(0)).b("pc", Integer.valueOf(0)).b("deg", Integer.valueOf(1)).b("rad", Integer.valueOf(1)).b("grad", Integer.valueOf(1)).b("turn", Integer.valueOf(1)).b("s", Integer.valueOf(2)).b("ms", Integer.valueOf(2)).b("hz", Integer.valueOf(3)).b("khz", Integer.valueOf(3)).b("dpi", Integer.valueOf(4)).b("dpcm", Integer.valueOf(4)).b("dppx", Integer.valueOf(4)).b());
    h = new boolean[''];
    m = 65;
    while (m <= 90)
    {
      h[m] = true;
      m += 1;
    }
    m = 97;
    while (m <= 122)
    {
      h[m] = true;
      m += 1;
    }
    m = 48;
    while (m <= 57)
    {
      h[m] = true;
      m += 1;
    }
    h[45] = true;
    h[46] = true;
    h[95] = true;
    h[126] = true;
    h[58] = true;
    h[47] = true;
    h[63] = true;
    h[35] = true;
    h[91] = true;
    h[93] = true;
    h[64] = true;
    h[33] = true;
    h[36] = true;
    h[38] = true;
    h[43] = true;
    h[44] = true;
    h[59] = true;
    h[61] = true;
    h[37] = true;
  }
  
  private ihn(String paramString, iho paramiho, int[] paramArrayOfInt, ihr[] paramArrayOfihr)
  {
    a = paramString;
    b = paramiho;
    c = paramArrayOfInt;
    d = paramArrayOfihr;
  }
  
  public static ihn a(String paramString)
  {
    ihp localihp = new ihp(paramString);
    localihp.a();
    b.setLength(0);
    Object localObject2;
    int i1;
    label599:
    int n;
    label764:
    Object localObject1;
    if (c != d)
    {
      e = new ArrayList();
      localObject2 = a;
      int i2 = d;
      while (c < i2)
      {
        char c1 = ((String)localObject2).charAt(c);
        int i3 = c;
        i1 = b.length();
        switch (c1)
        {
        default: 
          m = c1 | 0x20;
          if (((97 <= m) && (m <= 122)) || (c1 >= ''))
          {
            paramString = localihp.g();
            if (paramString == null) {
              break;
            }
          }
          break;
        }
        for (;;)
        {
          m = b.length();
          if (m <= i1) {
            break;
          }
          if (paramString != ihr.i) {
            break label1526;
          }
          localihp.a(i1, m);
          break;
          localihp.a();
          paramString = ihr.q;
          continue;
          if (c + 1 < i2) {}
          for (m = ((String)localObject2).charAt(c + 1);; m = 0)
          {
            if ((m != 47) && (m != 42)) {
              break label599;
            }
            localihp.a();
            paramString = ihr.q;
            break;
          }
          localihp.c(c1);
          paramString = ihr.i;
          continue;
          if (localihp.a())
          {
            paramString = ihr.q;
          }
          else
          {
            localihp.c('<');
            paramString = ihr.i;
            continue;
            localihp.b();
            b.append('>');
            paramString = ihr.i;
            c += 1;
            continue;
            m = b.length();
            b.append('@');
            n = c + 1;
            c = n;
            localihp.a(false);
            if (c == n)
            {
              c -= 1;
              b.setLength(m);
            }
            for (m = 0;; m = 1)
            {
              if (m == 0) {
                break label764;
              }
              paramString = ihr.d;
              break;
            }
            localihp.c(c1);
            paramString = ihr.i;
            continue;
            b.append('#');
            localObject1 = localihp.e();
            paramString = (String)localObject1;
            if (localObject1 == null)
            {
              c += 1;
              b.append(' ');
              paramString = ihr.i;
              continue;
              paramString = localihp.d();
              continue;
              if (localihp.f())
              {
                paramString = ihr.n;
              }
              else
              {
                paramString = localihp.g();
                continue;
                paramString = localihp.c();
                continue;
                if (c + 1 < i2)
                {
                  m = ((String)localObject2).charAt(c + 1);
                  label900:
                  if ((48 > m) || (m > 57)) {
                    break label981;
                  }
                  n = 1;
                  label914:
                  if (n == 0)
                  {
                    if ((m != 46) || (c + 2 >= i2)) {
                      break label991;
                    }
                    n = ((String)localObject2).charAt(c + 2);
                    if ((48 > n) || (n > 57)) {
                      break label986;
                    }
                  }
                }
                label981:
                label986:
                for (n = 1;; n = 0)
                {
                  if (n == 0) {
                    break label991;
                  }
                  paramString = localihp.c();
                  break;
                  m = 0;
                  break label900;
                  n = 0;
                  break label914;
                }
                label991:
                if (c1 == '+')
                {
                  localihp.c(c1);
                  paramString = ihr.i;
                }
                else if (c1 == '-')
                {
                  if (localihp.a()) {
                    paramString = ihr.q;
                  } else {
                    paramString = localihp.g();
                  }
                }
                else
                {
                  int i4;
                  if (m >= 128) {
                    if ((Character.isDefined(m)) && (m != 65279)) {
                      i4 = 1;
                    }
                  }
                  for (;;)
                  {
                    if (i4 != 0)
                    {
                      b.append('.');
                      c += 1;
                      localihp.a(false);
                      if (c != i3 + 1)
                      {
                        localObject1 = ihr.b;
                        paramString = (String)localObject1;
                        if (c >= i2) {
                          break;
                        }
                        paramString = (String)localObject1;
                        if ('(' != ((String)localObject2).charAt(c)) {
                          break;
                        }
                        b.append(' ');
                        paramString = (String)localObject1;
                        break;
                        i4 = 0;
                        continue;
                        i4 = k[m];
                        continue;
                      }
                      paramString = ihr.i;
                      b.append(' ');
                      break;
                    }
                  }
                  localihp.c('.');
                  paramString = ihr.i;
                  continue;
                  localihp.c(c1);
                  paramString = ihr.r;
                  continue;
                  localihp.c(c1);
                  paramString = ihr.s;
                  continue;
                  localihp.c(c1);
                  paramString = ihr.t;
                  continue;
                  paramString = localihp.a(c1);
                  c += 1;
                  continue;
                  localihp.b(c1);
                  c += 1;
                  paramString = ihr.i;
                  continue;
                  if (c + 1 < i2) {}
                  for (m = ((String)localObject2).charAt(c + 1);; m = 0)
                  {
                    if (m != 61) {
                      break label1366;
                    }
                    c += 2;
                    b.append(c1).append('=');
                    paramString = ihr.o;
                    break;
                  }
                  label1366:
                  if ((c1 == '|') && (m == 124))
                  {
                    c += 2;
                    b.append("||");
                    paramString = ihr.p;
                  }
                  else
                  {
                    localihp.c(c1);
                    paramString = ihr.i;
                    continue;
                    paramString = localihp.g();
                    continue;
                    localObject1 = localihp.g();
                    paramString = (String)localObject1;
                    if (localObject1 == null)
                    {
                      c += 1;
                      localihp.b();
                      paramString = ihr.q;
                      continue;
                      c += 1;
                      localihp.b();
                      paramString = ihr.q;
                      continue;
                      if (c1 > ' ')
                      {
                        localihp.c(c1);
                        paramString = ihr.i;
                      }
                      else
                      {
                        localihp.a();
                        paramString = ihr.q;
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label1526:
        m = i1;
        if (paramString != ihr.q)
        {
          m = i1;
          if (b.charAt(i1) == ' ')
          {
            localihp.a(ihr.q, i1);
            m = i1 + 1;
          }
        }
        localihp.a(paramString, m);
        if (paramString != ihr.q)
        {
          n = b.length();
          if ((m + 1 < n) && (b.charAt(n - 1) == ' ')) {
            localihp.a(ihr.q, n - 1);
          }
        }
      }
    }
    int m = b.length();
    localihp.a(0);
    localihp.a(m, b.length());
    if (e == null) {
      return g;
    }
    paramString = h;
    m = i;
    String str;
    if (m == 0)
    {
      paramString = e;
      n = b.length();
      m = n;
      if (n > 0)
      {
        m = n;
        if (b.charAt(n - 1) == ' ')
        {
          m = n - 1;
          localObject1 = e;
          n = g - 1;
          g = n;
          ((List)localObject1).remove(n);
        }
      }
      str = b.substring(0, m);
      localObject1 = f;
      m = g;
      n = m + 1;
      i1 = localObject1.length;
      if (i1 < n) {
        break label1925;
      }
      label1797:
      f = ((int[])localObject1);
      localObject1 = f;
      m = g;
      g = (m + 1);
      localObject1[m] = str.length();
      localObject1 = f;
      m = g;
      if (m != 0) {
        break label1959;
      }
      localObject1 = e;
    }
    for (;;)
    {
      localObject2 = (ihr[])e.toArray(f);
      return new ihn(str, new iho(paramString), (int[])localObject1, (ihr[])localObject2);
      if (m == paramString.length) {
        break;
      }
      localObject1 = new int[m];
      System.arraycopy(paramString, 0, localObject1, 0, m);
      paramString = (String)localObject1;
      break;
      label1925:
      localObject2 = new int[Math.max(16, Math.max(n, i1 * 2))];
      System.arraycopy(localObject1, 0, localObject2, 0, m);
      localObject1 = localObject2;
      break label1797;
      label1959:
      if (m != localObject1.length)
      {
        localObject2 = new int[m];
        System.arraycopy(localObject1, 0, localObject2, 0, m);
        localObject1 = localObject2;
      }
    }
  }
  
  static boolean a(char paramChar)
  {
    return (paramChar < ' ') && (('\001' << paramChar & 0x3400) != 0);
  }
  
  static final boolean a(int paramInt)
  {
    if (paramInt >= 128) {
      return (Character.isDefined(paramInt)) && (paramInt != 65279);
    }
    return k[paramInt];
  }
  
  static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return false;
    }
    ijs localijs = l;
    while (paramInt1 < paramInt2)
    {
      char c2 = paramCharSequence.charAt(paramInt1);
      char c1 = c2;
      if ('A' <= c2)
      {
        c1 = c2;
        if (c2 <= 'Z') {
          c1 = (char)(c2 | 0x20);
        }
      }
      localijs = localijs.a(c1);
      if (localijs == null) {
        return false;
      }
      paramInt1 += 1;
    }
    return a;
  }
  
  static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    paramInt2 = paramInt1 + paramInt2;
    int m = paramArrayOfInt.length;
    if (m >= paramInt2) {
      return paramArrayOfInt;
    }
    int[] arrayOfInt = new int[Math.max(16, Math.max(paramInt2, m * 2))];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt1);
    return arrayOfInt;
  }
}

/* Location:
 * Qualified Name:     ihn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */