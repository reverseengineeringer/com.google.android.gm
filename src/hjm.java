public abstract class hjm
  extends hjn
{
  private static char[] a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  public String a(String paramString)
  {
    hbe.a(paramString);
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (i < j)
      {
        if (a(paramString.charAt(i)) != null) {
          str = a(paramString, i);
        }
      }
      else {
        return str;
      }
      i += 1;
    }
  }
  
  protected final String a(String paramString, int paramInt)
  {
    int i2 = paramString.length();
    Object localObject1 = (char[])hjt.a.get();
    int i = localObject1.length;
    int j = 0;
    int m = 0;
    int k = paramInt;
    paramInt = j;
    char[] arrayOfChar;
    int i1;
    int n;
    Object localObject2;
    if (k < i2)
    {
      arrayOfChar = a(paramString.charAt(k));
      i1 = m;
      n = paramInt;
      j = i;
      localObject2 = localObject1;
      if (arrayOfChar != null)
      {
        n = arrayOfChar.length;
        i1 = k - m;
        int i3 = paramInt + i1 + n;
        j = i;
        localObject2 = localObject1;
        if (i < i3)
        {
          j = (i2 - k) * 2 + i3;
          localObject2 = a((char[])localObject1, paramInt, j);
        }
        if (i1 <= 0) {
          break label272;
        }
        paramString.getChars(m, k, (char[])localObject2, paramInt);
        paramInt += i1;
      }
    }
    label272:
    for (;;)
    {
      i = paramInt;
      if (n > 0)
      {
        System.arraycopy(arrayOfChar, 0, localObject2, paramInt, n);
        i = paramInt + n;
      }
      i1 = k + 1;
      n = i;
      k += 1;
      m = i1;
      paramInt = n;
      i = j;
      localObject1 = localObject2;
      break;
      k = i2 - m;
      j = paramInt;
      localObject2 = localObject1;
      if (k > 0)
      {
        j = k + paramInt;
        localObject2 = localObject1;
        if (i < j) {
          localObject2 = a((char[])localObject1, paramInt, j);
        }
        paramString.getChars(m, i2, (char[])localObject2, paramInt);
      }
      return new String((char[])localObject2, 0, j);
    }
  }
  
  protected abstract char[] a(char paramChar);
}

/* Location:
 * Qualified Name:     hjm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */