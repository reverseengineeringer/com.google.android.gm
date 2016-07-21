final class iij
  extends ihd
{
  private final String a;
  private int b;
  private boolean c;
  private boolean d;
  private String e = null;
  private ijc f;
  private ijd g = null;
  
  public iij(String paramString)
  {
    a = paramString;
  }
  
  static ijd a(ijd paramijd, int paramInt)
  {
    return ijd.a(a, b, paramInt);
  }
  
  private final String a(int paramInt1, int paramInt2)
  {
    return iim.a(a.substring(paramInt1, paramInt2));
  }
  
  protected final ijd c()
  {
    boolean bool2 = false;
    int i2 = b;
    int i3 = a.length();
    Object localObject1;
    int j;
    char c1;
    int i;
    label72:
    int m;
    int k;
    label598:
    label613:
    int n;
    if (i2 == i3)
    {
      localObject1 = null;
      if (localObject1 == null) {
        return null;
      }
    }
    else
    {
      j = i2 + 1;
      c1 = a.charAt(i2);
      if (c) {
        if ('>' == c1)
        {
          i = ije.i;
          c = false;
        }
      }
      for (;;)
      {
        m = i;
        k = j;
        if (i != 0) {
          break label1677;
        }
        while ((j < i3) && ('<' != a.charAt(j))) {
          j += 1;
        }
        if ('/' == c1)
        {
          if ((j != i3) && ('>' == a.charAt(j)))
          {
            i = ije.i;
            c = false;
            j += 1;
          }
          else
          {
            i = ije.j;
          }
        }
        else if ('=' == c1)
        {
          i = ije.j;
        }
        else
        {
          if (('"' == c1) || ('\'' == c1))
          {
            m = ije.g;
            k = j;
            for (;;)
            {
              i = m;
              j = k;
              if (k >= i3) {
                break;
              }
              if (a.charAt(k) == c1)
              {
                j = k + 1;
                i = m;
                break;
              }
              k += 1;
            }
          }
          if (!Character.isWhitespace(c1))
          {
            m = ije.j;
            k = j;
            for (;;)
            {
              i = m;
              j = k;
              if (k >= i3) {
                break;
              }
              c1 = a.charAt(k);
              if (((g == null) || (!g.a(a, "="))) && ('/' == c1) && (k + 1 < i3))
              {
                i = m;
                j = k;
                if ('>' == a.charAt(k + 1)) {
                  break;
                }
              }
              i = m;
              j = k;
              if ('>' == c1) {
                break;
              }
              i = m;
              j = k;
              if ('=' == c1) {
                break;
              }
              i = m;
              j = k;
              if (Character.isWhitespace(c1)) {
                break;
              }
              if ((('"' == c1) || ('\'' == c1)) && (k + 1 < i3))
              {
                c1 = a.charAt(k + 1);
                if ((Character.isWhitespace(c1)) || (c1 == '>') || (c1 == '/'))
                {
                  j = k + 1;
                  i = m;
                  break;
                }
              }
              k += 1;
            }
          }
          m = ije.k;
          k = j;
          for (;;)
          {
            i = m;
            j = k;
            if (k >= i3) {
              break;
            }
            i = m;
            j = k;
            if (!Character.isWhitespace(a.charAt(k))) {
              break;
            }
            k += 1;
          }
          if (c1 != '<') {
            break label1664;
          }
          if (j != i3) {
            break;
          }
          i = ije.j;
        }
      }
      k = a.charAt(j);
      switch (k)
      {
      default: 
        if ((k >= 65) && (k <= 122) && ((k <= 90) || (k >= 97)))
        {
          i = 1;
          if ((i == 0) || (d)) {
            break label1012;
          }
        }
        break;
      case 47: 
        for (i = iil.a;; i = iil.b)
        {
          m = j + 1;
          k = 0;
          n = i;
          i = k;
          j = m;
          if (n == 0) {
            break;
          }
          i = k;
          j = n;
          k = m;
          n = i;
          m = j;
          int i1;
          do
          {
            i = m;
            j = n;
            i1 = k;
            if (k >= i3) {
              break;
            }
            c1 = a.charAt(k);
            switch (iik.b[(m - 1)])
            {
            default: 
              j = n;
              i = m;
              i1 = k + 1;
              m = i;
              n = j;
              k = i1;
            }
          } while (iil.i != i);
          k = i1;
          n = i;
          m = j;
          i = m;
          j = k;
          if (k != i3) {
            break;
          }
          i = m;
          j = k;
          switch (iik.b[(n - 1)])
          {
          case 17: 
          case 2: 
          case 3: 
          case 4: 
          case 12: 
          case 13: 
          case 14: 
          case 15: 
          case 16: 
          default: 
            i = ije.j;
            j = k;
            break label72;
          }
        }
      case 33: 
        label624:
        label774:
        label807:
        if (!d) {
          i = iil.c;
        }
        break;
      }
    }
    for (;;)
    {
      m = j + 1;
      k = 0;
      n = i;
      break label624;
      if (ijc.b(e))
      {
        i = iil.m;
        continue;
        if (!d) {}
        for (i = iil.j;; i = 0)
        {
          m = j + 1;
          k = 0;
          n = i;
          break label624;
          i = iil.k;
          break label613;
          i = 0;
          break label598;
          label1012:
          if (60 == k)
          {
            k = ije.j;
            n = 0;
            m = j;
            break label624;
            if ((!Character.isWhitespace(c1)) && ('>' != c1) && ('/' != c1))
            {
              i = m;
              j = n;
              if ('<' != c1) {
                break label774;
              }
            }
            if ((d) && ('/' == a.charAt(i2 + 1)) && (f != ijc.e) && (a(i2 + 2, k).equals(e)))
            {
              d = false;
              e = null;
              f = null;
            }
            m = ije.h;
            if (!d) {}
            for (boolean bool1 = true;; bool1 = false)
            {
              c = bool1;
              n = iil.i;
              break;
            }
            if (Character.isLetter(c1))
            {
              i = iil.a;
              j = n;
              break label774;
            }
            if ('<' == c1)
            {
              i = ije.j;
              n = m;
              m = i;
              break label807;
            }
            k += 1;
            i = m;
            m = n;
            n = i;
            break label807;
            if ('-' == c1)
            {
              i = iil.d;
              j = n;
              break label774;
            }
            i = iil.h;
            j = n;
            break label774;
            if ('-' == c1)
            {
              i = iil.e;
              j = n;
              break label774;
            }
            i = iil.h;
            j = n;
            break label774;
            i = m;
            j = n;
            if ('-' != c1) {
              break label774;
            }
            i = iil.f;
            j = n;
            break label774;
            if ('-' == c1)
            {
              i = iil.g;
              j = n;
              break label774;
            }
            i = iil.f;
            j = n;
            break label774;
            if ('>' == c1)
            {
              i = iil.i;
              j = ije.d;
              break label774;
            }
            if ('-' == c1)
            {
              i = iil.g;
              j = n;
              break label774;
            }
            i = iil.f;
            j = n;
            break label774;
            i = m;
            j = n;
            if ('>' != c1) {
              break label774;
            }
            j = ije.e;
            i = iil.i;
            break label774;
            i = m;
            j = n;
            if ('>' != c1) {
              break label774;
            }
            j = ije.c;
            i = iil.i;
            break label774;
            i = m;
            j = n;
            if ('%' != c1) {
              break label774;
            }
            i = iil.l;
            j = n;
            break label774;
            if ('>' == c1)
            {
              j = ije.l;
              i = iil.i;
              break label774;
            }
            i = m;
            j = n;
            if ('%' == c1) {
              break label774;
            }
            i = iil.k;
            j = n;
            break label774;
            if ('-' == c1)
            {
              i = iil.n;
              j = n;
              break label774;
            }
            j = ije.j;
            i = iil.i;
            break label774;
            if ('-' == c1)
            {
              i = iil.q;
              j = n;
              break label774;
            }
            j = ije.j;
            i = iil.i;
            break label774;
            i = m;
            j = n;
            if ('-' != c1) {
              break label774;
            }
            i = iil.p;
            j = n;
            break label774;
            if ('-' == c1)
            {
              i = iil.q;
              j = n;
              break label774;
            }
            i = iil.o;
            j = n;
            break label774;
            if ('>' == c1)
            {
              j = ije.j;
              i = iil.i;
              break label774;
            }
            i = m;
            j = n;
            if ('-' == c1) {
              break label774;
            }
            i = iil.o;
            j = n;
            break label774;
            throw new AssertionError("Unexpectedly DONE while lexing HTML token stream");
            i = ije.c;
            j = k;
            break label72;
            i = ije.d;
            j = k;
            break label72;
            i = ije.l;
            j = k;
            break label72;
            i = ije.h;
            j = k;
            break label72;
            label1664:
            i = 0;
            break label72;
            m = ije.j;
            k = j;
            label1677:
            b = k;
            Object localObject2 = ijd.a(i2, k, m);
            localObject1 = localObject2;
            if (m == ije.k) {
              break;
            }
            g = ((ijd)localObject2);
            localObject1 = localObject2;
            break;
            if (d)
            {
              if (c != ije.l)
              {
                if (f == ijc.d) {}
                for (i = ije.j;; i = ije.f) {
                  return a((ijd)localObject1, i);
                }
              }
            }
            else {
              switch (iik.a[(c - 1)])
              {
              }
            }
            for (;;)
            {
              return (ijd)localObject1;
              localObject2 = a(a + 1, b);
              if (ijc.c((String)localObject2))
              {
                e = ((String)localObject2);
                f = ijc.a((String)localObject2);
                return (ijd)localObject1;
                bool1 = bool2;
                if (e != null) {
                  bool1 = true;
                }
                d = bool1;
              }
            }
          }
          i = 0;
          break label613;
        }
      }
      else
      {
        i = 0;
      }
    }
  }
}

/* Location:
 * Qualified Name:     iij
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */