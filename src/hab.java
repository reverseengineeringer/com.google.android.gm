final class hab
  extends gzx
{
  static final gzx o = new hab();
  
  public final boolean b(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      if ((paramChar < ' ') || (paramChar > ' ')) {
        break;
      }
    case '\t': 
    case '\n': 
    case '\013': 
    case '\f': 
    case '\r': 
    case ' ': 
    case '': 
    case ' ': 
    case ' ': 
    case ' ': 
    case ' ': 
    case '　': 
      return true;
    case ' ': 
      return false;
    }
    return false;
  }
  
  public final String toString()
  {
    return "CharMatcher.breakingWhitespace()";
  }
}

/* Location:
 * Qualified Name:     hab
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */