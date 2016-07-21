final class hac
  extends hap
{
  static final hac o = new hac();
  
  private hac()
  {
    super("CharMatcher.digit()", "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray(), e());
  }
  
  private static char[] e()
  {
    char[] arrayOfChar = new char[31];
    int i = 0;
    while (i < 31)
    {
      arrayOfChar[i] = ((char)("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i) + '\t'));
      i += 1;
    }
    return arrayOfChar;
  }
}

/* Location:
 * Qualified Name:     hac
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */