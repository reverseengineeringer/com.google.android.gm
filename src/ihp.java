import java.util.List;

final class ihp
{
  final String a;
  final StringBuilder b;
  int c = 0;
  final int d;
  List<ihr> e = null;
  int[] f = new int[''];
  int g = 0;
  int[] h = ihn.e;
  int i = 0;
  private int[] j = ihn.e;
  private int k = 0;
  
  ihp(String paramString)
  {
    a = paramString;
    b = new StringBuilder();
    d = paramString.length();
  }
  
  private final int h()
  {
    int n = -1;
    String str = a;
    int i7 = d;
    if (c + 1 >= i7) {}
    char c1;
    do
    {
      return n;
      c1 = str.charAt(c + 1);
    } while (ihn.a(c1));
    int i2 = c1 | 0x20;
    if ((('0' <= c1) && (c1 <= '9')) || ((97 <= i2) && (i2 <= 102)))
    {
      int m = c;
      int i8 = Math.min(c + 7, i7);
      n = 0;
      char c2 = c1;
      m += 1;
      label106:
      int i1;
      if (c2 <= '9') {
        c2 -= '0';
      }
      for (;;)
      {
        int i3 = i1 | n << 4;
        int i4 = m + 1;
        if (i4 != i8)
        {
          int i5 = str.charAt(i4);
          int i6 = i5 | 0x20;
          if (48 <= i5)
          {
            n = i3;
            m = i4;
            i2 = i6;
            i1 = i5;
            if (i5 <= 57) {
              break label106;
            }
          }
          if (97 <= i6)
          {
            n = i3;
            m = i4;
            i2 = i6;
            i1 = i5;
            if (i6 <= 102) {
              break label106;
            }
          }
        }
        m = i3;
        if (!Character.isDefined(i3)) {
          m = 65533;
        }
        c = i4;
        n = m;
        if (c >= i7) {
          break;
        }
        c1 = str.charAt(c);
        if ((c1 != ' ') && (c1 != '\t'))
        {
          n = m;
          if (!ihn.a(c1)) {
            break;
          }
        }
        c += 1;
        return m;
        i1 = i2 - 87;
      }
    }
    c += 2;
    return c1;
  }
  
  private final int i()
  {
    String str = a;
    int m = str.charAt(c);
    int i1 = m;
    int i2;
    if (Character.isHighSurrogate(m))
    {
      i1 = m;
      if (c + 1 < d)
      {
        int n = str.charAt(c + 1);
        i1 = m;
        if (Character.isLowSurrogate(n))
        {
          c += 1;
          i2 = (m - 55296 << 10 | n - 56320) + 65536;
        }
      }
    }
    return i2;
  }
  
  final ihr a(char paramChar)
  {
    int m;
    ihr localihr;
    switch (paramChar)
    {
    default: 
      throw new AssertionError("Invalid open bracket " + paramChar);
    case '(': 
      m = 41;
      localihr = ihr.w;
    }
    for (;;)
    {
      h = ihn.a(h, i, 2);
      j = ihn.a(j, k, 2);
      int[] arrayOfInt = j;
      int n = k;
      k = (n + 1);
      arrayOfInt[n] = i;
      arrayOfInt = j;
      n = k;
      k = (n + 1);
      arrayOfInt[n] = m;
      arrayOfInt = h;
      m = i;
      i = (m + 1);
      arrayOfInt[m] = g;
      arrayOfInt = h;
      m = i;
      i = (m + 1);
      arrayOfInt[m] = -1;
      b.append(paramChar);
      return localihr;
      m = 93;
      localihr = ihr.u;
      continue;
      m = 125;
      localihr = ihr.y;
    }
  }
  
  final void a(int paramInt)
  {
    int m = k;
    h = ihn.a(h, i, m - paramInt);
    m = g;
    while (k > paramInt)
    {
      int[] arrayOfInt = j;
      int n = k - 1;
      k = n;
      n = arrayOfInt[n];
      arrayOfInt = j;
      int i1 = k - 1;
      k = i1;
      int i2 = arrayOfInt[i1];
      i1 = h[i2];
      h[(i2 + 1)] = m;
      arrayOfInt = h;
      i2 = i;
      i = (i2 + 1);
      arrayOfInt[i2] = m;
      arrayOfInt = h;
      i2 = i;
      i = (i2 + 1);
      arrayOfInt[i2] = i1;
      b.appendCodePoint(n);
      m += 1;
    }
  }
  
  final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      ihr localihr;
      switch (b.charAt(paramInt1))
      {
      default: 
        localihr = ihr.i;
      }
      for (;;)
      {
        a(localihr, paramInt1);
        paramInt1 += 1;
        break;
        localihr = ihr.q;
        continue;
        localihr = ihr.z;
        continue;
        localihr = ihr.x;
        continue;
        localihr = ihr.v;
      }
    }
  }
  
  final void a(ihr paramihr, int paramInt)
  {
    if ((g == 0) || (f[(g - 1)] != paramInt))
    {
      f = ihn.a(f, g, 1);
      int[] arrayOfInt = f;
      int m = g;
      g = (m + 1);
      arrayOfInt[m] = paramInt;
      e.add(paramihr);
    }
  }
  
  final void a(boolean paramBoolean)
  {
    int i2 = d;
    int n = 0;
    int i3 = b.length();
    int i4 = c;
    int i5;
    int m;
    for (int i1 = -1;; i1 = m)
    {
      if (c < i2)
      {
        i5 = c;
        m = i();
        if (m != 92) {
          break label118;
        }
        m = h();
      }
      for (;;)
      {
        if ((m < 0) || (!ihn.a(m))) {
          break label150;
        }
        if ((paramBoolean) || (n >= 2) || (48 > m) || (m > 57) || ((i1 != 45) && (i1 != -1))) {
          break;
        }
        c = i4;
        b.setLength(i3);
        return;
        label118:
        c += 1;
      }
      b.appendCodePoint(m);
      n += 1;
    }
    label150:
    c = i5;
  }
  
  final boolean a()
  {
    String str = a;
    int m = d;
    int n = c;
    for (;;)
    {
      if (c >= m) {
        break label391;
      }
      int i1 = str.charAt(c);
      if ((i1 <= 32) || (i1 == 65279))
      {
        c += 1;
      }
      else
      {
        if (c + 1 == m) {
          break label391;
        }
        if (i1 == 47)
        {
          i1 = str.charAt(c + 1);
          if (i1 == 42)
          {
            c += 2;
            if (c >= m) {
              continue;
            }
            i1 = str.indexOf('*', c);
            if (i1 < 0)
            {
              c = m;
              continue;
            }
            for (c = (i1 + 1); (c < m) && (str.charAt(c) == '*'); c += 1) {}
            if ((c >= m) || (str.charAt(c) != '/')) {
              break;
            }
            c += 1;
            continue;
          }
          if (i1 != 47) {
            break label391;
          }
          do
          {
            i1 = c + 1;
            c = i1;
            if (i1 >= m) {
              break;
            }
          } while (!ihn.a(str.charAt(c)));
          continue;
        }
        if (i1 == 60)
        {
          if ((c + 3 >= m) || ('!' != str.charAt(c + 1)) || ('-' != str.charAt(c + 2)) || ('-' != str.charAt(c + 3))) {
            break label391;
          }
          c += 4;
        }
        else
        {
          if ((i1 != 45) || (c + 2 >= m) || ('-' != str.charAt(c + 1)) || ('>' != str.charAt(c + 2))) {
            break label391;
          }
          c += 3;
        }
      }
    }
    label391:
    if (c == n) {
      return false;
    }
    b();
    return true;
  }
  
  final void b()
  {
    int m = b.length() - 1;
    if ((m >= 0) && (b.charAt(m) != ' ')) {
      b.append(' ');
    }
  }
  
  final void b(char paramChar)
  {
    int m = k;
    int n;
    do
    {
      if (m == 0)
      {
        b();
        return;
      }
      n = m - 2;
      m = n;
    } while (paramChar != j[(n + 1)]);
    a(n);
  }
  
  final ihr c()
  {
    String str = a;
    int i7 = d;
    int m = 1;
    int n = c;
    int i1 = n;
    int i2;
    if (n < i7)
    {
      i2 = str.charAt(n);
      if (i2 != 45)
      {
        i1 = n;
        if (i2 != 43) {}
      }
      else
      {
        i1 = n + 1;
      }
    }
    int i3 = i1;
    while (i3 < i7)
    {
      n = str.charAt(i3);
      if ((48 > n) || (n > 57)) {
        break;
      }
      if (n != 48) {
        m = 0;
      }
      i3 += 1;
    }
    int i6;
    if ((i3 < i7) && ('.' == str.charAt(i3)))
    {
      n = i3 + 1;
      while (n < i7)
      {
        i2 = str.charAt(n);
        if ((48 > i2) || (i2 > 57)) {
          break;
        }
        if (i2 != 48) {
          m = 0;
        }
        n += 1;
      }
      i6 = m;
    }
    for (m = n;; m = n)
    {
      int i4 = 1;
      int i5 = 1;
      if ((m < i7) && ('e' == (str.charAt(m) | 0x20)))
      {
        i2 = m + 1;
        n = i2;
        if (i2 < i7)
        {
          i4 = str.charAt(i2);
          if (i4 != 43)
          {
            n = i2;
            if (i4 != 45) {}
          }
          else
          {
            n = i2 + 1;
          }
        }
        i2 = n;
        while (i2 < i7)
        {
          i4 = str.charAt(i2);
          if ((48 > i4) || (i4 > 57)) {
            break;
          }
          if (i4 != 48) {
            i5 = 0;
          }
          i2 += 1;
        }
        if (i2 == n)
        {
          i5 = 1;
          n = m;
          i2 = m;
        }
      }
      for (;;)
      {
        i4 = n;
        while (i4 < i7)
        {
          char c1 = str.charAt(i4);
          if ((c1 != ' ') && (!ihn.a(c1))) {
            break;
          }
          i4 += 1;
        }
        if ((b.length() != 0) && (ihn.a(b.charAt(b.length() - 1)))) {
          b.append(' ');
        }
        if ((i1 != c) && ('-' == str.charAt(c)) && (i6 == 0)) {
          b.append('-');
        }
        ihr localihr;
        if (i6 != 0)
        {
          b.append('0');
          if ((i4 >= i7) || ('%' != str.charAt(i4))) {
            break label744;
          }
          n = i4 + 1;
          localihr = ihr.k;
          b.append('%');
        }
        for (;;)
        {
          c = n;
          if ((localihr != ihr.k) && (c < i7) && (str.charAt(c) == '.')) {
            b.append(' ');
          }
          return localihr;
          for (;;)
          {
            i6 = m;
            if (i1 >= i3) {
              break;
            }
            i6 = m;
            if (str.charAt(i1) != '0') {
              break;
            }
            i1 += 1;
          }
          while ((i6 > i3) && (str.charAt(i6 - 1) == '0')) {
            i6 -= 1;
          }
          if (i1 == i3) {
            b.append('0');
          }
          for (;;)
          {
            if (i6 > i3 + 1) {
              b.append(str, i3, i6);
            }
            if (i5 != 0) {
              break;
            }
            b.append('e');
            m = i2;
            if ('-' == str.charAt(i2 - 1))
            {
              b.append('-');
              m = i2;
            }
            while ((m < n) && (str.charAt(m) == '0')) {
              m += 1;
            }
            b.append(str, i1, i3);
          }
          b.append(str, m, n);
          break;
          label744:
          m = b.length();
          c = i4;
          a(false);
          i1 = b.length();
          boolean bool = ihn.a(b, m, i1);
          if ((i4 == n) || (bool))
          {
            n = c;
            while (m < i1)
            {
              i2 = b.charAt(m);
              if ((65 <= i2) && (i2 <= 90)) {
                b.setCharAt(m, (char)(i2 | 0x20));
              }
              m += 1;
            }
          }
          for (;;)
          {
            if (i4 != n) {
              break label879;
            }
            localihr = ihr.j;
            break;
            b.setLength(m);
            i4 = n;
          }
          label879:
          if (bool) {
            localihr = ihr.l;
          } else {
            localihr = ihr.m;
          }
        }
        i4 = n;
        n = i2;
        i2 = i4;
        continue;
        n = m;
        i2 = m;
        i5 = i4;
      }
      n = i3;
      i6 = m;
    }
  }
  
  final void c(char paramChar)
  {
    b.append(paramChar);
    switch (paramChar)
    {
    }
    for (;;)
    {
      c += 1;
      return;
      b.append(' ');
    }
  }
  
  final ihr d()
  {
    String str = a;
    int i4 = d;
    int i5 = str.charAt(c);
    c += 1;
    int i3 = b.length();
    b.append('\'');
    int i1 = -1;
    int m;
    int n;
    if (c < i4)
    {
      m = str.charAt(c);
      if (m == i5)
      {
        c += 1;
        n = 1;
      }
    }
    for (;;)
    {
      if (n != 0)
      {
        b.append('\'');
        return ihr.g;
        if (ihn.a(m)) {
          break label607;
        }
        if (m == 92)
        {
          if ((c + 1 < i4) && (ihn.a(str.charAt(c + 1))))
          {
            if ((c + 2 < i4) && (str.charAt(c + 1) == '\r') && (str.charAt(c + 2) == '\n'))
            {
              c += 3;
              break;
            }
            c += 2;
            break;
          }
          int i2 = h();
          n = i2;
          if (i2 >= 0) {
            break label250;
          }
          n = 0;
          continue;
        }
        c += 1;
        n = m;
        switch (n)
        {
        default: 
          label250:
          if ((i1 < 0) || (i1 >= 63) || (0L == (1L << i1 & 0x500000C400003401))) {
            break;
          }
        }
        for (i1 = 1;; i1 = 0)
        {
          if ((i1 != 0) && ((n == 32) || (n == 9) || ((48 <= n) && (n <= 57)) || ((97 <= (n | 0x20)) && ((n | 0x20) <= 102)))) {
            b.append(' ');
          }
          b.appendCodePoint(n);
          for (;;)
          {
            i1 = n;
            break;
            b.append("\\\\");
            continue;
            b.append("\\0");
            continue;
            b.append("\\a");
            continue;
            b.append("\\c");
            continue;
            b.append("\\d");
            continue;
            b.append("\\22");
            continue;
            b.append("\\26");
            continue;
            b.append("\\27");
            continue;
            b.append("\\3c");
            continue;
            b.append("\\3e");
            continue;
            b.append('-');
          }
        }
      }
      b.setLength(i3);
      b();
      return ihr.q;
      label607:
      n = 0;
    }
  }
  
  final ihr e()
  {
    c += 1;
    int n = c;
    a(true);
    int m = n;
    if (c == n)
    {
      c = (n - 1);
      return null;
    }
    do
    {
      m += 1;
      if (m >= c) {
        break;
      }
      n = (char)(a.charAt(m) | 0x20);
    } while (((48 <= n) && (n <= 57)) || ((97 <= n) && (n <= 102)));
    return ihr.e;
    return ihr.f;
  }
  
  final boolean f()
  {
    int i1 = 0;
    String str = a;
    int i3 = d;
    int i4 = c;
    int i5 = b.length();
    c += 1;
    char c1;
    try
    {
      if (c != i3)
      {
        m = str.charAt(c);
        if (m == 43) {}
      }
      else
      {
        return false;
      }
      c += 1;
      b.append("U+");
      m = 0;
      while ((c < i3) && (m < 6))
      {
        c1 = (char)(str.charAt(c) | 0x20);
        if (('0' > c1) || (c1 > '9')) {
          break label462;
        }
        b.append(c1);
        m += 1;
        c += 1;
      }
      if (m != 0) {
        break label215;
      }
    }
    finally
    {
      c = i4;
      b.setLength(i5);
    }
    label194:
    c = i4;
    b.setLength(i5);
    return false;
    label215:
    int i2 = 0;
    int n = m;
    for (int m = i2; (c < i3) && (n < 6) && (((String)localObject).charAt(c) == '?'); m = 1)
    {
      b.append('?');
      c += 1;
      n += 1;
    }
    if (n == 0)
    {
      c = i4;
      b.setLength(i5);
      return false;
    }
    if ((c < i3) && (((String)localObject).charAt(c) == '-'))
    {
      if (m == 0)
      {
        c += 1;
        b.append('-');
        m = i1;
        label352:
        if ((c < i3) && (m < 6))
        {
          c1 = (char)(((String)localObject).charAt(c) | 0x20);
          if (('0' > c1) || (c1 > '9')) {
            break label477;
          }
        }
      }
      for (;;)
      {
        m += 1;
        c += 1;
        b.append(c1);
        break label352;
        label462:
        label477:
        do
        {
          if (m != 0) {
            break label492;
          }
          c -= 1;
          b.append(' ');
          break label492;
          b.append(' ');
          break label492;
          if (('a' > c1) || (c1 > 'f')) {
            break label194;
          }
          break;
        } while (('a' > c1) || (c1 > 'f'));
      }
    }
    label492:
    return true;
  }
  
  final ihr g()
  {
    int i1 = 0;
    int i3 = b.length();
    int m = c;
    a(false);
    if (c == m) {
      return null;
    }
    String str;
    int i4;
    int n;
    if ((c < d) && (a.charAt(c) == '('))
    {
      m = 1;
      if ((b.length() - i3 != 3) || ('u' != (b.charAt(i3) | 0x20)) || ('r' != (b.charAt(i3 + 1) | 0x20)) || ('l' != (b.charAt(i3 + 2) | 0x20))) {
        break label1051;
      }
      if (m == 0) {
        break label1034;
      }
      str = a;
      i4 = d;
      n = i1;
      if (c != i4)
      {
        if (str.charAt(c) == '(') {
          break label225;
        }
        n = i1;
      }
    }
    for (;;)
    {
      if (n == 0) {
        break label1034;
      }
      b.setCharAt(i3, 'u');
      b.setCharAt(i3 + 1, 'r');
      b.setCharAt(i3 + 2, 'l');
      return ihr.h;
      m = 0;
      break;
      label225:
      char c1;
      for (c += 1; c < i4; c += 1)
      {
        c1 = str.charAt(c);
        if ((c1 != ' ') && (!ihn.a(c1))) {
          break;
        }
      }
      n = i1;
      if (c < i4)
      {
        if (c < i4)
        {
          m = str.charAt(c);
          if ((m != 34) && (m != 39)) {
            break label426;
          }
          c += 1;
          label333:
          b.append("('");
        }
        for (;;)
        {
          if (c < i4)
          {
            n = i();
            if (m == 0) {
              break label431;
            }
            if (n != m) {
              break label443;
            }
            c += 1;
          }
          label426:
          label431:
          while ((n <= 32) || (n == 41))
          {
            while (c < i4)
            {
              c1 = str.charAt(c);
              if ((c1 != ' ') && (!ihn.a(c1))) {
                break;
              }
              c += 1;
            }
            m = 0;
            break;
            m = 0;
            break label333;
          }
          label443:
          int i2;
          if (n == 92)
          {
            i2 = h();
            n = i1;
            if (i2 < 0) {
              break;
            }
            n = i2;
          }
          for (;;)
          {
            if ((n >= ihn.h.length) || (ihn.h[n] == 0)) {
              break label507;
            }
            b.appendCodePoint(n);
            break;
            c += 1;
          }
          label507:
          if (n < 128)
          {
            b.append('%').append(ihn.i[(n >>> 4 & 0xF)]).append(ihn.i[(n >>> 0 & 0xF)]);
          }
          else if (n < 2048)
          {
            i2 = n >>> 6 & 0x1F | 0xC0;
            n = n & 0x3F | 0x80;
            b.append('%').append(ihn.i[(i2 >>> 4 & 0xF)]).append(ihn.i[(i2 >>> 0 & 0xF)]).append('%').append(ihn.i[(n >>> 4 & 0xF)]).append(ihn.i[(n >>> 0 & 0xF)]);
          }
          else
          {
            int i5;
            if (n < 65536)
            {
              i2 = n >>> 12 & 0xF | 0xE0;
              i5 = n >>> 6 & 0x3F | 0x80;
              n = n & 0x3F | 0x80;
              b.append('%').append(ihn.i[(i2 >>> 4 & 0xF)]).append(ihn.i[(i2 >>> 0 & 0xF)]).append('%').append(ihn.i[(i5 >>> 4 & 0xF)]).append(ihn.i[(i5 >>> 0 & 0xF)]).append('%').append(ihn.i[(n >>> 4 & 0xF)]).append(ihn.i[(n >>> 0 & 0xF)]);
            }
            else
            {
              i2 = n >>> 18 & 0x7 | 0xF0;
              i5 = n >>> 12 & 0x3F | 0x80;
              int i6 = n >>> 6 & 0x3F | 0x80;
              n = n & 0x3F | 0x80;
              b.append('%').append(ihn.i[(i2 >>> 4 & 0xF)]).append(ihn.i[(i2 >>> 0 & 0xF)]).append('%').append(ihn.i[(i5 >>> 4 & 0xF)]).append(ihn.i[(i5 >>> 0 & 0xF)]).append('%').append(ihn.i[(i6 >>> 4 & 0xF)]).append(ihn.i[(i6 >>> 0 & 0xF)]).append('%').append(ihn.i[(n >>> 4 & 0xF)]).append(ihn.i[(n >>> 0 & 0xF)]);
            }
          }
        }
        if ((c < i4) && (str.charAt(c) == ')')) {
          c += 1;
        }
        b.append("')");
        n = 1;
      }
    }
    label1034:
    b.setLength(i3);
    b();
    return ihr.q;
    label1051:
    if (m != 0)
    {
      a('(');
      c += 1;
      return ihr.c;
    }
    if ((c + 1 < d) && ('.' == a.charAt(c)))
    {
      m = a.charAt(c + 1);
      if ((48 <= m) && (m <= 57)) {
        b.append(' ');
      }
    }
    return ihr.a;
  }
}

/* Location:
 * Qualified Name:     ihp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */