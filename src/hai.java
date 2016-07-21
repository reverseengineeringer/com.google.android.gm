final class hai
  extends han
{
  static final hai o = new hai();
  
  private hai()
  {
    super("CharMatcher.javaIsoControl()");
  }
  
  public final boolean b(char paramChar)
  {
    return (paramChar <= '\037') || ((paramChar >= '') && (paramChar <= ''));
  }
}

/* Location:
 * Qualified Name:     hai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */