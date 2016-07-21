import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class hku
{
  private static final byte[] a;
  
  static
  {
    int k = 0;
    byte[] arrayOfByte = new byte[''];
    Arrays.fill(arrayOfByte, (byte)-1);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i > 9) {
        break;
      }
      arrayOfByte[(i + 48)] = ((byte)i);
      i += 1;
    }
    while (j <= 26)
    {
      arrayOfByte[(j + 65)] = ((byte)(j + 10));
      arrayOfByte[(j + 97)] = ((byte)(j + 10));
      j += 1;
    }
    a = arrayOfByte;
  }
  
  public static int a(long paramLong)
  {
    return (int)(paramLong >>> 32 ^ paramLong);
  }
  
  static int a(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      if (paramArrayOfLong[paramInt2] == paramLong) {
        return paramInt2;
      }
      paramInt2 -= 1;
    }
    return -1;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 8) {}
    for (int i = 1;; i = 0)
    {
      j = paramArrayOfByte.length;
      if (i != 0) {
        break;
      }
      throw new IllegalArgumentException(hbe.a("array too small: %s < %s", new Object[] { Integer.valueOf(j), Integer.valueOf(8) }));
    }
    i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    int m = paramArrayOfByte[3];
    int n = paramArrayOfByte[4];
    int i1 = paramArrayOfByte[5];
    int i2 = paramArrayOfByte[6];
    int i3 = paramArrayOfByte[7];
    long l = i;
    return (j & 0xFF) << 48 | (l & 0xFF) << 56 | (k & 0xFF) << 40 | (m & 0xFF) << 32 | (n & 0xFF) << 24 | (i1 & 0xFF) << 16 | (i2 & 0xFF) << 8 | i3 & 0xFF;
  }
  
  public static String a(String paramString, long... paramVarArgs)
  {
    hbe.a(paramString);
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 10);
    localStringBuilder.append(paramVarArgs[0]);
    int i = 1;
    while (i < paramVarArgs.length)
    {
      localStringBuilder.append(paramString).append(paramVarArgs[i]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static List<Long> a(long... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return Collections.emptyList();
    }
    return new hkv(paramVarArgs);
  }
  
  public static long[] a(Collection<? extends Number> paramCollection)
  {
    int i = 0;
    if ((paramCollection instanceof hkv))
    {
      paramCollection = (hkv)paramCollection;
      i = paramCollection.size();
      arrayOfLong = new long[i];
      System.arraycopy(a, b, arrayOfLong, 0, i);
      return arrayOfLong;
    }
    paramCollection = paramCollection.toArray();
    int j = paramCollection.length;
    long[] arrayOfLong = new long[j];
    while (i < j)
    {
      arrayOfLong[i] = ((Number)hbe.a(paramCollection[i])).longValue();
      i += 1;
    }
    return arrayOfLong;
  }
  
  private static int c(long[] paramArrayOfLong, long paramLong, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramArrayOfLong[paramInt1] == paramLong) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
}

/* Location:
 * Qualified Name:     hku
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */