import java.util.ArrayList;

final class do
{
  private static int a(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((((i - 65) * (i - 90) > 0) && ((i - 97) * (i - 122) > 0)) || (i == 101) || (i == 69)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  private static void a(ArrayList<dq> paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new dq(paramChar, paramArrayOfFloat));
  }
  
  static float[] a(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    if (paramInt2 < 0) {
      throw new IllegalArgumentException();
    }
    paramInt1 = paramArrayOfFloat.length;
    if (paramInt1 < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 += 0;
    paramInt1 = Math.min(paramInt2, paramInt1 + 0);
    float[] arrayOfFloat = new float[paramInt2];
    System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, paramInt1);
    return arrayOfFloat;
  }
  
  public static dq[] a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 1;
    int i = 0;
    while (j < paramString.length())
    {
      j = a(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = b(str);
        a(localArrayList, str.charAt(0), arrayOfFloat);
      }
      int k = j + 1;
      i = j;
      j = k;
    }
    if ((j - i == 1) && (i < paramString.length())) {
      a(localArrayList, paramString.charAt(i), new float[0]);
    }
    return (dq[])localArrayList.toArray(new dq[localArrayList.size()]);
  }
  
  public static dq[] a(dq[] paramArrayOfdq)
  {
    if (paramArrayOfdq == null) {
      return null;
    }
    dq[] arrayOfdq = new dq[paramArrayOfdq.length];
    int i = 0;
    while (i < paramArrayOfdq.length)
    {
      arrayOfdq[i] = new dq(paramArrayOfdq[i]);
      i += 1;
    }
    return arrayOfdq;
  }
  
  private static float[] b(String paramString)
  {
    int i;
    if (paramString.charAt(0) == 'z')
    {
      i = 1;
      if (paramString.charAt(0) != 'Z') {
        break label39;
      }
    }
    label39:
    for (int j = 1;; j = 0)
    {
      if ((i | j) == 0) {
        break label44;
      }
      return new float[0];
      i = 0;
      break;
    }
    for (;;)
    {
      label44:
      int i1;
      try
      {
        float[] arrayOfFloat = new float[paramString.length()];
        dp localdp = new dp();
        int i3 = paramString.length();
        n = 1;
        m = 0;
        if (n < i3)
        {
          b = false;
          k = 0;
          i = 0;
          j = 0;
          i1 = n;
          if (i1 >= paramString.length()) {}
        }
        switch (paramString.charAt(i1))
        {
        case '-': 
          if ((i1 == n) || (k != 0)) {
            break label317;
          }
          b = true;
          j = i;
          k = 1;
          i = 0;
          break label327;
          label194:
          b = true;
          j = i;
          k = 1;
          i = 0;
          break label327;
          a = i1;
          j = a;
          if (n < j)
          {
            i = m + 1;
            arrayOfFloat[m] = Float.parseFloat(paramString.substring(n, j));
            if (!b) {
              break label385;
            }
            n = j;
            m = i;
            continue;
            arrayOfFloat = a(arrayOfFloat, 0, m);
            return arrayOfFloat;
          }
          break;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new RuntimeException("error in parsing \"" + paramString + "\"", localNumberFormatException);
      }
      i = m;
      continue;
      label317:
      int i2 = 0;
      int k = j;
      j = i;
      i = i2;
      for (;;)
      {
        label327:
        if (k != 0) {
          break label383;
        }
        i2 = i1 + 1;
        i1 = i;
        i = j;
        j = k;
        k = i1;
        i1 = i2;
        break;
        j = i;
        k = 1;
        i = 0;
        continue;
        if (i != 0) {
          break label194;
        }
        i = 0;
        k = j;
        j = 1;
        continue;
        k = j;
        j = i;
        i = 1;
      }
      label383:
      continue;
      label385:
      int n = j + 1;
      int m = i;
    }
  }
}

/* Location:
 * Qualified Name:     do
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */