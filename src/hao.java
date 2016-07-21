final class hao
  extends han
{
  static final hao o = new hao();
  
  private hao()
  {
    super("CharMatcher.none()");
  }
  
  public final int a(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramCharSequence.length();
    if ((paramInt < 0) || (paramInt > i)) {
      throw new IndexOutOfBoundsException(hbe.a(paramInt, i, "index"));
    }
    return -1;
  }
  
  public final String a(CharSequence paramCharSequence, char paramChar)
  {
    return paramCharSequence.toString();
  }
  
  public final String a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    hbe.a(paramCharSequence2);
    return paramCharSequence1.toString();
  }
  
  public final String b(CharSequence paramCharSequence, char paramChar)
  {
    return paramCharSequence.toString();
  }
  
  public final boolean b(char paramChar)
  {
    return false;
  }
  
  public final boolean b(CharSequence paramCharSequence)
  {
    hbe.a(paramCharSequence);
    return true;
  }
  
  public final int c(CharSequence paramCharSequence)
  {
    hbe.a(paramCharSequence);
    return -1;
  }
  
  public final String d(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString();
  }
  
  public final String e(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString();
  }
}

/* Location:
 * Qualified Name:     hao
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */