import java.util.Arrays;

final class gzy
  extends han
{
  static final gzy o = new gzy();
  
  private gzy()
  {
    super("CharMatcher.any()");
  }
  
  public final int a(CharSequence paramCharSequence, int paramInt)
  {
    int j = paramCharSequence.length();
    if ((paramInt < 0) || (paramInt > j)) {
      throw new IndexOutOfBoundsException(hbe.a(paramInt, j, "index"));
    }
    int i = paramInt;
    if (paramInt == j) {
      i = -1;
    }
    return i;
  }
  
  public final String a(CharSequence paramCharSequence, char paramChar)
  {
    paramCharSequence = new char[paramCharSequence.length()];
    Arrays.fill(paramCharSequence, paramChar);
    return new String(paramCharSequence);
  }
  
  public final String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence1.length() * paramCharSequence2.length());
    int i = 0;
    while (i < paramCharSequence1.length())
    {
      localStringBuilder.append(paramCharSequence2);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public final String b(CharSequence paramCharSequence, char paramChar)
  {
    if (paramCharSequence.length() == 0) {
      return "";
    }
    return " ";
  }
  
  public final boolean b(char paramChar)
  {
    return true;
  }
  
  public final boolean b(CharSequence paramCharSequence)
  {
    return paramCharSequence.length() == 0;
  }
  
  public final int c(CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() == 0) {
      return -1;
    }
    return 0;
  }
  
  public final String d(CharSequence paramCharSequence)
  {
    hbe.a(paramCharSequence);
    return "";
  }
  
  public final String e(CharSequence paramCharSequence)
  {
    hbe.a(paramCharSequence);
    return "";
  }
}

/* Location:
 * Qualified Name:     gzy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */