public final class ijj
{
  private static final char[] a;
  private static final char[] b;
  
  static
  {
    int k = 97;
    int n = 65;
    int m = 0;
    a = new char[91];
    b = new char[123];
    int j = 0;
    int i;
    for (;;)
    {
      i = n;
      if (j >= 65) {
        break;
      }
      a[j] = ((char)j);
      j += 1;
    }
    for (;;)
    {
      j = m;
      if (i > 90) {
        break;
      }
      a[i] = ((char)(i | 0x20));
      i += 1;
    }
    for (;;)
    {
      i = k;
      if (j >= 97) {
        break;
      }
      b[j] = ((char)j);
      j += 1;
    }
    while (i <= 122)
    {
      b[i] = ((char)(i & 0xFFFFFFDF));
      i += 1;
    }
  }
  
  public static String a(String paramString)
  {
    int i = paramString.length();
    int j;
    int k;
    do
    {
      do
      {
        j = i - 1;
        str = paramString;
        if (j < 0) {
          break;
        }
        k = paramString.charAt(j);
        i = j;
      } while (k > 90);
      i = j;
    } while (k < 65);
    paramString = paramString.toCharArray();
    paramString[j] = a[k];
    for (;;)
    {
      i = j - 1;
      if (i < 0) {
        break;
      }
      k = paramString[i];
      j = i;
      if (k <= 90)
      {
        paramString[i] = a[k];
        j = i;
      }
    }
    String str = String.valueOf(paramString);
    return str;
  }
  
  public static boolean a(CharSequence paramCharSequence1, int paramInt1, CharSequence paramCharSequence2, int paramInt2)
  {
    int i;
    if (paramInt1 + paramInt2 <= paramCharSequence1.length())
    {
      i = paramInt2;
      if (paramInt2 + 0 <= paramCharSequence2.length()) {}
    }
    else
    {
      return false;
    }
    int j;
    do
    {
      int k;
      int m;
      do
      {
        k = i - 1;
        if (k < 0) {
          break;
        }
        j = paramCharSequence1.charAt(paramInt1 + k);
        m = paramCharSequence2.charAt(k + 0);
        i = k;
      } while (j == m);
      if ((j > 122) || (j < 65)) {
        break;
      }
      paramInt2 = j;
      if (j <= 90) {
        paramInt2 = (char)(j | 0x20);
      }
      j = m;
      if (m <= 90)
      {
        j = m;
        if (m >= 65) {
          j = (char)(m | 0x20);
        }
      }
      i = k;
    } while (paramInt2 == j);
    return false;
    return true;
  }
}

/* Location:
 * Qualified Name:     ijj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */