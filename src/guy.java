public final class guy
  extends gvb
{
  private static final char[] a = { '+' };
  private static final char[] b = "0123456789ABCDEF".toCharArray();
  private final boolean c;
  private final boolean[] d;
  
  public guy(String paramString, boolean paramBoolean)
  {
    if (paramString.matches(".*[0-9A-Za-z].*")) {
      throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }
    if ((paramBoolean) && (paramString.contains(" "))) {
      throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
    }
    if (paramString.contains("%")) {
      throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
    }
    c = paramBoolean;
    d = b(paramString);
  }
  
  private static boolean[] b(String paramString)
  {
    int k = 0;
    paramString = paramString.toCharArray();
    int m = paramString.length;
    int i = 0;
    int j = 122;
    while (i < m)
    {
      j = Math.max(paramString[i], j);
      i += 1;
    }
    boolean[] arrayOfBoolean = new boolean[j + 1];
    i = 48;
    while (i <= 57)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    i = 97;
    while (i <= 122)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    j = paramString.length;
    i = k;
    while (i < j)
    {
      arrayOfBoolean[paramString[i]] = true;
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  protected final int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      int i = paramCharSequence.charAt(paramInt1);
      if ((i >= d.length) || (d[i] == 0)) {
        break;
      }
      paramInt1 += 1;
    }
    return paramInt1;
  }
  
  public final String a(String paramString)
  {
    int k = paramString.length();
    int j = 0;
    Object localObject1 = paramString;
    int m;
    int i2;
    int n;
    label78:
    int i1;
    label140:
    label234:
    label294:
    label313:
    Object localObject2;
    if (j < k)
    {
      m = paramString.charAt(j);
      if ((m < d.length) && (d[m] != 0)) {
        break label541;
      }
      i2 = paramString.length();
      localObject1 = (char[])guz.a.get();
      k = 0;
      m = 0;
      n = j;
      j = m;
      if (n < i2)
      {
        if (n < i2)
        {
          i1 = n + 1;
          int i = paramString.charAt(n);
          m = i;
          if (i >= 55296)
          {
            if (i <= 57343) {
              break label140;
            }
            m = i;
          }
          char c1;
          for (;;)
          {
            if (m >= 0) {
              break label294;
            }
            throw new IllegalArgumentException("Trailing high surrogate at end of input");
            if (i > 56319) {
              break label234;
            }
            if (i1 == i2)
            {
              m = -i;
            }
            else
            {
              c1 = paramString.charAt(i1);
              if (!Character.isLowSurrogate(c1)) {
                break;
              }
              m = Character.toCodePoint(i, c1);
            }
          }
          throw new IllegalArgumentException(83 + "Expected low surrogate but got char '" + c1 + "' with value " + c1 + " at index " + i1);
          throw new IllegalArgumentException(82 + "Unexpected low surrogate character '" + i + "' with value " + i + " at index " + (i1 - 1));
        }
        throw new IndexOutOfBoundsException("Index exceeds specified range");
        char[] arrayOfChar = a(m);
        if (Character.isSupplementaryCodePoint(m))
        {
          m = 2;
          i1 = m + n;
          if (arrayOfChar == null) {
            break label550;
          }
          int i3 = n - k;
          m = j + i3 + arrayOfChar.length;
          localObject2 = localObject1;
          if (localObject1.length < m) {
            localObject2 = gvb.a((char[])localObject1, j, m + i2 - n + 32);
          }
          m = j;
          if (i3 > 0)
          {
            paramString.getChars(k, n, (char[])localObject2, j);
            m = j + i3;
          }
          j = m;
          if (arrayOfChar.length > 0)
          {
            System.arraycopy(arrayOfChar, 0, localObject2, m, arrayOfChar.length);
            j = m + arrayOfChar.length;
          }
          k = i1;
          localObject1 = localObject2;
        }
      }
    }
    label541:
    label550:
    for (;;)
    {
      n = a(paramString, i1, i2);
      break label78;
      m = 1;
      break label313;
      n = i2 - k;
      m = j;
      localObject2 = localObject1;
      if (n > 0)
      {
        m = n + j;
        localObject2 = localObject1;
        if (localObject1.length < m) {
          localObject2 = gvb.a((char[])localObject1, j, m);
        }
        paramString.getChars(k, i2, (char[])localObject2, j);
      }
      localObject1 = new String((char[])localObject2, 0, m);
      return (String)localObject1;
      j += 1;
      break;
    }
  }
  
  protected final char[] a(int paramInt)
  {
    if ((paramInt < d.length) && (d[paramInt] != 0)) {
      return null;
    }
    if ((paramInt == 32) && (c)) {
      return a;
    }
    int i;
    if (paramInt <= 127)
    {
      i = b[(paramInt & 0xF)];
      return new char[] { '%', b[(paramInt >>> 4)], i };
    }
    int j;
    int k;
    if (paramInt <= 2047)
    {
      i = b[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = b[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = b[(paramInt & 0xF)];
      return new char[] { '%', b[(paramInt >>> 4 | 0xC)], k, '%', j, i };
    }
    int m;
    if (paramInt <= 65535)
    {
      i = b[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = b[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = b[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = b[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'E', b[(paramInt >>> 2)], '%', m, k, '%', j, i };
    }
    if (paramInt <= 1114111)
    {
      i = b[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = b[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = b[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = b[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      int n = b[(paramInt & 0xF)];
      paramInt >>>= 4;
      int i1 = b[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'F', b[(paramInt >>> 2 & 0x7)], '%', i1, n, '%', m, k, '%', j, i };
    }
    throw new IllegalArgumentException(43 + "Invalid unicode character value " + paramInt);
  }
}

/* Location:
 * Qualified Name:     guy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */