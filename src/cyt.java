import java.util.Arrays;

final class cyt
{
  final char[] a;
  final int[] b;
  
  cyt(String paramString)
  {
    a = paramString.toCharArray();
    if (paramString.length() != 64)
    {
      i = paramString.length();
      throw new IllegalArgumentException(61 + "alphabet has incorrect length (should be 64, not " + i + ")");
    }
    b = new int[''];
    Arrays.fill(b, -1);
    int i = 0;
    while (i < a.length)
    {
      char c = a[i];
      if (c >= '') {
        throw new IllegalArgumentException(32 + "invalid character in alphabet: " + c);
      }
      b[c] = i;
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     cyt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */