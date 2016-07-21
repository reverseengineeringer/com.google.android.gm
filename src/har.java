final class har
  extends han
{
  static final int o = Integer.numberOfLeadingZeros(31);
  static final har p = new har();
  
  har()
  {
    super("CharMatcher.whitespace()");
  }
  
  public final boolean b(char paramChar)
  {
    return " 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(1682554634 * paramChar >>> o) == paramChar;
  }
}

/* Location:
 * Qualified Name:     har
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */