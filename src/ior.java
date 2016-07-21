public final class ior
{
  private static final char[] a = "0123456789ABCDEF".toCharArray();
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(12 + k + "b");
    if (paramString != null) {
      localStringBuffer.append(String.valueOf(paramString).length() + 3 + " (" + paramString + ")");
    }
    localStringBuffer.append(':');
    int m = localStringBuffer.toString().length() + 8 & 0xFFFFFFF8;
    localStringBuffer.append('\t');
    int n = (80 - m) / 3;
    int i = 0;
    while (i < k)
    {
      if ((i != 0) && (i % n == 0))
      {
        localStringBuffer.append('\n');
        j = 0;
        while (j < m / 8)
        {
          localStringBuffer.append('\t');
          j += 1;
        }
      }
      int j = paramArrayOfByte[(i + 0)] & 0xFF;
      localStringBuffer.append(a[(j >> 4)]);
      localStringBuffer.append(a[(j & 0xF)]);
      localStringBuffer.append(' ');
      i += 1;
    }
    localStringBuffer.append('\n');
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     ior
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */