package com.google.android.common.base;

public final class CharEscapers
{
  private static final CharEscaper ASCII_HTML_ESCAPER;
  private static final Escaper CPP_URI_ESCAPER;
  private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
  private static final CharEscaper JAVASCRIPT_ESCAPER;
  private static final CharEscaper JAVA_CHAR_ESCAPER;
  private static final CharEscaper JAVA_STRING_ESCAPER;
  private static final CharEscaper JAVA_STRING_UNICODE_ESCAPER;
  private static final CharEscaper NULL_ESCAPER = new CharEscaper()
  {
    public String escape(String paramAnonymousString)
    {
      Preconditions.checkNotNull(paramAnonymousString);
      return paramAnonymousString;
    }
    
    protected char[] escape(char paramAnonymousChar)
    {
      return null;
    }
  };
  private static final CharEscaper PYTHON_ESCAPER;
  private static final Escaper URI_ESCAPER;
  private static final Escaper URI_ESCAPER_NO_PLUS;
  private static final Escaper URI_PATH_ESCAPER;
  private static final Escaper URI_QUERY_STRING_ESCAPER;
  private static final Escaper URI_QUERY_STRING_ESCAPER_WITH_PLUS;
  private static final CharEscaper XML_CONTENT_ESCAPER;
  private static final CharEscaper XML_ESCAPER = newBasicXmlEscapeBuilder().addEscape('"', "&quot;").addEscape('\'', "&apos;").toEscaper();
  
  static
  {
    XML_CONTENT_ESCAPER = newBasicXmlEscapeBuilder().toEscaper();
    ASCII_HTML_ESCAPER = new CharEscaperBuilder().addEscape('"', "&quot;").addEscape('\'', "&#39;").addEscape('&', "&amp;").addEscape('<', "&lt;").addEscape('>', "&gt;").toEscaper();
    URI_ESCAPER = new PercentEscaper("-_.*", true);
    URI_ESCAPER_NO_PLUS = new PercentEscaper("-_.*", false);
    URI_PATH_ESCAPER = new PercentEscaper("-_.!~*'()@:$&,;=", false);
    URI_QUERY_STRING_ESCAPER = new PercentEscaper("-_.!~*'()@:$,;/?:", false);
    URI_QUERY_STRING_ESCAPER_WITH_PLUS = new PercentEscaper("-_.!~*'()@:$,;/?:", true);
    CPP_URI_ESCAPER = new PercentEscaper("!()*-._~,/:", true);
    JAVA_STRING_ESCAPER = new JavaCharEscaper(new CharEscaperBuilder().addEscape('\b', "\\b").addEscape('\f', "\\f").addEscape('\n', "\\n").addEscape('\r', "\\r").addEscape('\t', "\\t").addEscape('"', "\\\"").addEscape('\\', "\\\\").toArray());
    JAVA_CHAR_ESCAPER = new JavaCharEscaper(new CharEscaperBuilder().addEscape('\b', "\\b").addEscape('\f', "\\f").addEscape('\n', "\\n").addEscape('\r', "\\r").addEscape('\t', "\\t").addEscape('\'', "\\'").addEscape('"', "\\\"").addEscape('\\', "\\\\").toArray());
    JAVA_STRING_UNICODE_ESCAPER = new CharEscaper()
    {
      protected char[] escape(char paramAnonymousChar)
      {
        if (paramAnonymousChar <= '') {
          return null;
        }
        int i = CharEscapers.HEX_DIGITS[(paramAnonymousChar & 0xF)];
        paramAnonymousChar = (char)(paramAnonymousChar >>> '\004');
        int j = CharEscapers.HEX_DIGITS[(paramAnonymousChar & 0xF)];
        paramAnonymousChar = (char)(paramAnonymousChar >>> '\004');
        int k = CharEscapers.HEX_DIGITS[(paramAnonymousChar & 0xF)];
        paramAnonymousChar = (char)(paramAnonymousChar >>> '\004');
        return new char[] { '\\', 'u', CharEscapers.HEX_DIGITS[(paramAnonymousChar & 0xF)], k, j, i };
      }
    };
    PYTHON_ESCAPER = new CharEscaperBuilder().addEscape('\n', "\\n").addEscape('\r', "\\r").addEscape('\t', "\\t").addEscape('\\', "\\\\").addEscape('"', "\\\"").addEscape('\'', "\\'").toEscaper();
    JAVASCRIPT_ESCAPER = new JavascriptCharEscaper(new CharEscaperBuilder().addEscape('\'', "\\x27").addEscape('"', "\\x22").addEscape('<', "\\x3c").addEscape('=', "\\x3d").addEscape('>', "\\x3e").addEscape('&', "\\x26").addEscape('\b', "\\b").addEscape('\t', "\\t").addEscape('\n', "\\n").addEscape('\f', "\\f").addEscape('\r', "\\r").addEscape('\\', "\\\\").toArray());
  }
  
  public static CharEscaper asciiHtmlEscaper()
  {
    return ASCII_HTML_ESCAPER;
  }
  
  private static CharEscaperBuilder newBasicXmlEscapeBuilder()
  {
    return new CharEscaperBuilder().addEscape('&', "&amp;").addEscape('<', "&lt;").addEscape('>', "&gt;").addEscapes(new char[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 }, "");
  }
  
  private static abstract class FastCharEscaper
    extends CharEscaper
  {
    protected final int replacementLength;
    protected final char[][] replacements;
    protected final char safeMax;
    protected final char safeMin;
    
    public FastCharEscaper(char[][] paramArrayOfChar, char paramChar1, char paramChar2)
    {
      replacements = paramArrayOfChar;
      replacementLength = paramArrayOfChar.length;
      safeMin = paramChar1;
      safeMax = paramChar2;
    }
    
    public String escape(String paramString)
    {
      int j = paramString.length();
      int i = 0;
      for (;;)
      {
        String str = paramString;
        if (i < j)
        {
          int k = paramString.charAt(i);
          if (((k < replacementLength) && (replacements[k] != null)) || (k < safeMin) || (k > safeMax)) {
            str = escapeSlow(paramString, i);
          }
        }
        else
        {
          return str;
        }
        i += 1;
      }
    }
  }
  
  private static class JavaCharEscaper
    extends CharEscapers.FastCharEscaper
  {
    public JavaCharEscaper(char[][] paramArrayOfChar)
    {
      super(' ', '~');
    }
    
    protected char[] escape(char paramChar)
    {
      if (paramChar < replacementLength)
      {
        char[] arrayOfChar = replacements[paramChar];
        if (arrayOfChar != null) {
          return arrayOfChar;
        }
      }
      if ((safeMin <= paramChar) && (paramChar <= safeMax)) {
        return null;
      }
      if (paramChar <= 'ÿ')
      {
        i = CharEscapers.HEX_DIGITS[(paramChar & 0x7)];
        paramChar = (char)(paramChar >>> '\003');
        j = CharEscapers.HEX_DIGITS[(paramChar & 0x7)];
        paramChar = (char)(paramChar >>> '\003');
        return new char[] { '\\', CharEscapers.HEX_DIGITS[(paramChar & 0x7)], j, i };
      }
      int i = CharEscapers.HEX_DIGITS[(paramChar & 0xF)];
      paramChar = (char)(paramChar >>> '\004');
      int j = CharEscapers.HEX_DIGITS[(paramChar & 0xF)];
      paramChar = (char)(paramChar >>> '\004');
      int k = CharEscapers.HEX_DIGITS[(paramChar & 0xF)];
      paramChar = (char)(paramChar >>> '\004');
      return new char[] { '\\', 'u', CharEscapers.HEX_DIGITS[(paramChar & 0xF)], k, j, i };
    }
  }
  
  private static class JavascriptCharEscaper
    extends CharEscapers.FastCharEscaper
  {
    public JavascriptCharEscaper(char[][] paramArrayOfChar)
    {
      super(' ', '~');
    }
    
    protected char[] escape(char paramChar)
    {
      if (paramChar < replacementLength)
      {
        char[] arrayOfChar = replacements[paramChar];
        if (arrayOfChar != null) {
          return arrayOfChar;
        }
      }
      if ((safeMin <= paramChar) && (paramChar <= safeMax)) {
        return null;
      }
      if (paramChar < 'Ā')
      {
        i = CharEscapers.HEX_DIGITS[(paramChar & 0xF)];
        paramChar = (char)(paramChar >>> '\004');
        return new char[] { '\\', 'x', CharEscapers.HEX_DIGITS[(paramChar & 0xF)], i };
      }
      int i = CharEscapers.HEX_DIGITS[(paramChar & 0xF)];
      paramChar = (char)(paramChar >>> '\004');
      int j = CharEscapers.HEX_DIGITS[(paramChar & 0xF)];
      paramChar = (char)(paramChar >>> '\004');
      int k = CharEscapers.HEX_DIGITS[(paramChar & 0xF)];
      paramChar = (char)(paramChar >>> '\004');
      return new char[] { '\\', 'u', CharEscapers.HEX_DIGITS[(paramChar & 0xF)], k, j, i };
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.CharEscapers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */