import java.util.Arrays;

final class gzz
  extends gzx
{
  private final char[] o;
  
  public gzz(CharSequence paramCharSequence)
  {
    o = paramCharSequence.toString().toCharArray();
    Arrays.sort(o);
  }
  
  public final boolean b(char paramChar)
  {
    return Arrays.binarySearch(o, paramChar) >= 0;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
    char[] arrayOfChar = o;
    int j = arrayOfChar.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(gzx.c(arrayOfChar[i]));
      i += 1;
    }
    localStringBuilder.append("\")");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     gzz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */