final class ihz
{
  static final String[] a;
  private static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static boolean[] c;
  
  static
  {
    a = new String[''];
    int i = 0;
    while (i < 32)
    {
      if ((i != 9) && (i != 10) && (i != 13)) {
        a[i] = "";
      }
      i += 1;
    }
    a[34] = "&#34;";
    a[38] = "&amp;";
    a[39] = "&#39;";
    a[43] = "&#43;";
    a[60] = "&lt;";
    a[61] = "&#61;";
    a[62] = "&gt;";
    a[64] = "&#64;";
    a[96] = "&#96;";
    c = new boolean[32];
    i = 0;
    if (i < c.length)
    {
      boolean[] arrayOfBoolean = c;
      if ((i != 9) && (i != 10) && (i != 13)) {}
      for (int j = 1;; j = 0)
      {
        arrayOfBoolean[i] = j;
        i += 1;
        break;
      }
    }
  }
  
  static String a(String paramString)
  {
    int i = paramString.indexOf('&');
    int m = c(paramString);
    if ((i & m) < 0) {
      return paramString;
    }
    int i1 = paramString.length();
    StringBuilder localStringBuilder = new StringBuilder(i1);
    int k = 0;
    int j = i;
    while (j >= 0)
    {
      long l = iii.a(paramString, j, i1);
      int n = (int)(l >>> 32);
      int i2 = (int)l;
      localStringBuilder.append(paramString, k, j).appendCodePoint(i2);
      j = paramString.indexOf('&', n);
      k = n;
    }
    localStringBuilder.append(paramString, k, i1);
    if (i < 0) {
      i = m;
    }
    for (;;)
    {
      a(localStringBuilder, i);
      return localStringBuilder.toString();
      if (m >= 0) {
        i = Math.min(i, m);
      }
    }
  }
  
  private static void a(int paramInt, Appendable paramAppendable)
  {
    paramAppendable.append("&#");
    if (paramInt < 100)
    {
      if (paramInt < 10) {
        paramAppendable.append((char)(paramInt + 48));
      }
      for (;;)
      {
        paramAppendable.append(";");
        return;
        paramAppendable.append((char)(paramInt / 10 + 48));
        paramAppendable.append((char)(paramInt % 10 + 48));
      }
    }
    int i;
    if (paramInt < 4096) {
      if (paramInt < 256) {
        i = 2;
      }
    }
    for (;;)
    {
      paramAppendable.append('x');
      for (;;)
      {
        i -= 1;
        if (i < 0) {
          break;
        }
        paramAppendable.append(b[(paramInt >>> (i << 2) & 0xF)]);
      }
      i = 3;
      continue;
      if (paramInt < 65536) {
        i = 4;
      } else if (paramInt < 1048576) {
        i = 5;
      } else {
        i = 6;
      }
    }
  }
  
  static void a(String paramString, Appendable paramAppendable)
  {
    a(paramString, paramAppendable, "{​");
  }
  
  private static void a(String paramString1, Appendable paramAppendable, String paramString2)
  {
    int j = 0;
    int n = paramString1.length();
    int k = 0;
    int i;
    int m;
    if (j < n)
    {
      i = paramString1.charAt(j);
      if (i < a.length)
      {
        String str2 = a[i];
        String str1 = str2;
        if (i == 123)
        {
          str1 = str2;
          if (str2 == null) {
            if (j + 1 != n)
            {
              str1 = str2;
              if (paramString1.charAt(j + 1) != '{') {}
            }
            else
            {
              str1 = paramString2;
            }
          }
        }
        m = k;
        if (str1 != null)
        {
          paramAppendable.append(paramString1, k, j).append(str1);
          m = j + 1;
        }
        k = j;
        j = m;
      }
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = m;
      break;
      if (55296 <= i)
      {
        if (i <= 57343)
        {
          if (j + 1 < n)
          {
            char c1 = paramString1.charAt(j + 1);
            if (Character.isSurrogatePair(i, c1))
            {
              m = Character.toCodePoint(i, c1);
              paramAppendable.append(paramString1, k, j);
              a(m, paramAppendable);
              k = j + 1;
              j = k + 1;
              continue;
            }
          }
          paramAppendable.append(paramString1, k, j);
          m = j + 1;
          k = j;
          j = m;
          continue;
        }
        m = k;
        if (65120 <= i)
        {
          paramAppendable.append(paramString1, k, j);
          k = j + 1;
          m = k;
          if ((i & 0xFFFE) != 65534)
          {
            a(i, paramAppendable);
            m = k;
            k = j;
            j = m;
          }
        }
      }
      else
      {
        m = k;
        if (i == 8175)
        {
          paramAppendable.append(paramString1, k, j).append("&#8175;");
          m = j + 1;
          k = j;
          j = m;
          continue;
          paramAppendable.append(paramString1, k, n);
          return;
        }
      }
      k = j;
      j = m;
    }
  }
  
  static void a(StringBuilder paramStringBuilder)
  {
    a(paramStringBuilder, 0);
  }
  
  private static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int n = paramStringBuilder.length();
    int j = paramInt;
    int k = paramInt;
    paramInt = j;
    if (paramInt < n)
    {
      int i = paramStringBuilder.charAt(paramInt);
      int m;
      if (i < 32)
      {
        if (c[i] == 0) {
          break label160;
        }
        j = k;
        m = paramInt;
      }
      for (;;)
      {
        paramInt = m + 1;
        k = j;
        break;
        if (55296 <= i)
        {
          if (i <= 57343)
          {
            m = paramInt;
            j = k;
            if (paramInt + 1 < n)
            {
              char c1 = paramStringBuilder.charAt(paramInt + 1);
              m = paramInt;
              j = k;
              if (Character.isSurrogatePair(i, c1))
              {
                m = k + 1;
                paramStringBuilder.setCharAt(k, i);
                j = m + 1;
                paramStringBuilder.setCharAt(m, c1);
                m = paramInt + 1;
              }
            }
          }
          else
          {
            m = paramInt;
            j = k;
            if ((i & 0xFFFE) == 65534) {}
          }
        }
        else
        {
          label160:
          paramStringBuilder.setCharAt(k, i);
          j = k + 1;
          m = paramInt;
        }
      }
    }
    paramStringBuilder.setLength(k);
  }
  
  static String b(String paramString)
  {
    int i = c(paramString);
    if (i < 0) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    a(paramString, i);
    return paramString.toString();
  }
  
  static void b(String paramString, Appendable paramAppendable)
  {
    a(paramString, paramAppendable, "{<!-- -->");
  }
  
  private static int c(String paramString)
  {
    int m = paramString.length();
    int j = 0;
    if (j < m)
    {
      int i = paramString.charAt(j);
      int k;
      if (i < 32)
      {
        k = j;
        if (c[i] == 0) {}
      }
      else
      {
        do
        {
          return j;
          k = j;
          if (55296 > i) {
            break;
          }
          if (i > 57343) {
            break label85;
          }
        } while ((j + 1 >= m) || (!Character.isSurrogatePair(i, paramString.charAt(j + 1))));
        k = j + 1;
      }
      label85:
      do
      {
        j = k + 1;
        break;
        k = j;
      } while ((i & 0xFFFE) != 65534);
      return j;
    }
    return -1;
  }
  
  static void c(String paramString, Appendable paramAppendable)
  {
    a(paramString, paramAppendable, "{​");
  }
}

/* Location:
 * Qualified Name:     ihz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */