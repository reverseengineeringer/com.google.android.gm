package com.google.android.common.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class StringUtil
{
  private static final Set<Character.UnicodeBlock> CJK_BLOCKS;
  private static final CharMatcher CONTROL_MATCHER;
  static final Map<String, Character> ESCAPE_STRINGS;
  private static final CharMatcher FANCY_DOUBLE_QUOTE;
  private static final CharMatcher FANCY_SINGLE_QUOTE;
  private static final char[] HEX_CHARS;
  static final Set<Character> HEX_LETTERS;
  private static final CharEscaper JAVA_ESCAPE;
  private static final Set<Integer> JSON_ESCAPE_CHARS = new UnicodeSetBuilder(null).addCodePoint(Character.codePointAt("\"", 0)).addCodePoint(Character.codePointAt("\\", 0)).addRange(0, 31).create();
  private static final Set<Integer> JS_ESCAPE_CHARS;
  private static final CharEscaper LT_GT_ESCAPE;
  private static final Splitter NEWLINE_SPLITTER = Splitter.on('\n').omitEmptyStrings();
  private static final char[] OCTAL_CHARS;
  private static final CharEscaper REGEX_ESCAPE;
  private static final Splitter TO_WORDS = Splitter.on(CharMatcher.BREAKING_WHITESPACE).omitEmptyStrings();
  private static final Pattern characterReferencePattern;
  private static final Pattern dbSpecPattern;
  private static final Pattern htmlTagPattern;
  
  static
  {
    FANCY_SINGLE_QUOTE = CharMatcher.anyOf("‘’");
    FANCY_DOUBLE_QUOTE = CharMatcher.anyOf("“”");
    ESCAPE_STRINGS = new HashMap(252);
    ESCAPE_STRINGS.put("&nbsp", Character.valueOf(' '));
    ESCAPE_STRINGS.put("&iexcl", Character.valueOf('¡'));
    ESCAPE_STRINGS.put("&cent", Character.valueOf('¢'));
    ESCAPE_STRINGS.put("&pound", Character.valueOf('£'));
    ESCAPE_STRINGS.put("&curren", Character.valueOf('¤'));
    ESCAPE_STRINGS.put("&yen", Character.valueOf('¥'));
    ESCAPE_STRINGS.put("&brvbar", Character.valueOf('¦'));
    ESCAPE_STRINGS.put("&sect", Character.valueOf('§'));
    ESCAPE_STRINGS.put("&uml", Character.valueOf('¨'));
    ESCAPE_STRINGS.put("&copy", Character.valueOf('©'));
    ESCAPE_STRINGS.put("&ordf", Character.valueOf('ª'));
    ESCAPE_STRINGS.put("&laquo", Character.valueOf('«'));
    ESCAPE_STRINGS.put("&not", Character.valueOf('¬'));
    ESCAPE_STRINGS.put("&shy", Character.valueOf('­'));
    ESCAPE_STRINGS.put("&reg", Character.valueOf('®'));
    ESCAPE_STRINGS.put("&macr", Character.valueOf('¯'));
    ESCAPE_STRINGS.put("&deg", Character.valueOf('°'));
    ESCAPE_STRINGS.put("&plusmn", Character.valueOf('±'));
    ESCAPE_STRINGS.put("&sup2", Character.valueOf('²'));
    ESCAPE_STRINGS.put("&sup3", Character.valueOf('³'));
    ESCAPE_STRINGS.put("&acute", Character.valueOf('´'));
    ESCAPE_STRINGS.put("&micro", Character.valueOf('µ'));
    ESCAPE_STRINGS.put("&para", Character.valueOf('¶'));
    ESCAPE_STRINGS.put("&middot", Character.valueOf('·'));
    ESCAPE_STRINGS.put("&cedil", Character.valueOf('¸'));
    ESCAPE_STRINGS.put("&sup1", Character.valueOf('¹'));
    ESCAPE_STRINGS.put("&ordm", Character.valueOf('º'));
    ESCAPE_STRINGS.put("&raquo", Character.valueOf('»'));
    ESCAPE_STRINGS.put("&frac14", Character.valueOf('¼'));
    ESCAPE_STRINGS.put("&frac12", Character.valueOf('½'));
    ESCAPE_STRINGS.put("&frac34", Character.valueOf('¾'));
    ESCAPE_STRINGS.put("&iquest", Character.valueOf('¿'));
    ESCAPE_STRINGS.put("&Agrave", Character.valueOf('À'));
    ESCAPE_STRINGS.put("&Aacute", Character.valueOf('Á'));
    ESCAPE_STRINGS.put("&Acirc", Character.valueOf('Â'));
    ESCAPE_STRINGS.put("&Atilde", Character.valueOf('Ã'));
    ESCAPE_STRINGS.put("&Auml", Character.valueOf('Ä'));
    ESCAPE_STRINGS.put("&Aring", Character.valueOf('Å'));
    ESCAPE_STRINGS.put("&AElig", Character.valueOf('Æ'));
    ESCAPE_STRINGS.put("&Ccedil", Character.valueOf('Ç'));
    ESCAPE_STRINGS.put("&Egrave", Character.valueOf('È'));
    ESCAPE_STRINGS.put("&Eacute", Character.valueOf('É'));
    ESCAPE_STRINGS.put("&Ecirc", Character.valueOf('Ê'));
    ESCAPE_STRINGS.put("&Euml", Character.valueOf('Ë'));
    ESCAPE_STRINGS.put("&Igrave", Character.valueOf('Ì'));
    ESCAPE_STRINGS.put("&Iacute", Character.valueOf('Í'));
    ESCAPE_STRINGS.put("&Icirc", Character.valueOf('Î'));
    ESCAPE_STRINGS.put("&Iuml", Character.valueOf('Ï'));
    ESCAPE_STRINGS.put("&ETH", Character.valueOf('Ð'));
    ESCAPE_STRINGS.put("&Ntilde", Character.valueOf('Ñ'));
    ESCAPE_STRINGS.put("&Ograve", Character.valueOf('Ò'));
    ESCAPE_STRINGS.put("&Oacute", Character.valueOf('Ó'));
    ESCAPE_STRINGS.put("&Ocirc", Character.valueOf('Ô'));
    ESCAPE_STRINGS.put("&Otilde", Character.valueOf('Õ'));
    ESCAPE_STRINGS.put("&Ouml", Character.valueOf('Ö'));
    ESCAPE_STRINGS.put("&times", Character.valueOf('×'));
    ESCAPE_STRINGS.put("&Oslash", Character.valueOf('Ø'));
    ESCAPE_STRINGS.put("&Ugrave", Character.valueOf('Ù'));
    ESCAPE_STRINGS.put("&Uacute", Character.valueOf('Ú'));
    ESCAPE_STRINGS.put("&Ucirc", Character.valueOf('Û'));
    ESCAPE_STRINGS.put("&Uuml", Character.valueOf('Ü'));
    ESCAPE_STRINGS.put("&Yacute", Character.valueOf('Ý'));
    ESCAPE_STRINGS.put("&THORN", Character.valueOf('Þ'));
    ESCAPE_STRINGS.put("&szlig", Character.valueOf('ß'));
    ESCAPE_STRINGS.put("&agrave", Character.valueOf('à'));
    ESCAPE_STRINGS.put("&aacute", Character.valueOf('á'));
    ESCAPE_STRINGS.put("&acirc", Character.valueOf('â'));
    ESCAPE_STRINGS.put("&atilde", Character.valueOf('ã'));
    ESCAPE_STRINGS.put("&auml", Character.valueOf('ä'));
    ESCAPE_STRINGS.put("&aring", Character.valueOf('å'));
    ESCAPE_STRINGS.put("&aelig", Character.valueOf('æ'));
    ESCAPE_STRINGS.put("&ccedil", Character.valueOf('ç'));
    ESCAPE_STRINGS.put("&egrave", Character.valueOf('è'));
    ESCAPE_STRINGS.put("&eacute", Character.valueOf('é'));
    ESCAPE_STRINGS.put("&ecirc", Character.valueOf('ê'));
    ESCAPE_STRINGS.put("&euml", Character.valueOf('ë'));
    ESCAPE_STRINGS.put("&igrave", Character.valueOf('ì'));
    ESCAPE_STRINGS.put("&iacute", Character.valueOf('í'));
    ESCAPE_STRINGS.put("&icirc", Character.valueOf('î'));
    ESCAPE_STRINGS.put("&iuml", Character.valueOf('ï'));
    ESCAPE_STRINGS.put("&eth", Character.valueOf('ð'));
    ESCAPE_STRINGS.put("&ntilde", Character.valueOf('ñ'));
    ESCAPE_STRINGS.put("&ograve", Character.valueOf('ò'));
    ESCAPE_STRINGS.put("&oacute", Character.valueOf('ó'));
    ESCAPE_STRINGS.put("&ocirc", Character.valueOf('ô'));
    ESCAPE_STRINGS.put("&otilde", Character.valueOf('õ'));
    ESCAPE_STRINGS.put("&ouml", Character.valueOf('ö'));
    ESCAPE_STRINGS.put("&divide", Character.valueOf('÷'));
    ESCAPE_STRINGS.put("&oslash", Character.valueOf('ø'));
    ESCAPE_STRINGS.put("&ugrave", Character.valueOf('ù'));
    ESCAPE_STRINGS.put("&uacute", Character.valueOf('ú'));
    ESCAPE_STRINGS.put("&ucirc", Character.valueOf('û'));
    ESCAPE_STRINGS.put("&uuml", Character.valueOf('ü'));
    ESCAPE_STRINGS.put("&yacute", Character.valueOf('ý'));
    ESCAPE_STRINGS.put("&thorn", Character.valueOf('þ'));
    ESCAPE_STRINGS.put("&yuml", Character.valueOf('ÿ'));
    ESCAPE_STRINGS.put("&fnof", Character.valueOf('ƒ'));
    ESCAPE_STRINGS.put("&Alpha", Character.valueOf('Α'));
    ESCAPE_STRINGS.put("&Beta", Character.valueOf('Β'));
    ESCAPE_STRINGS.put("&Gamma", Character.valueOf('Γ'));
    ESCAPE_STRINGS.put("&Delta", Character.valueOf('Δ'));
    ESCAPE_STRINGS.put("&Epsilon", Character.valueOf('Ε'));
    ESCAPE_STRINGS.put("&Zeta", Character.valueOf('Ζ'));
    ESCAPE_STRINGS.put("&Eta", Character.valueOf('Η'));
    ESCAPE_STRINGS.put("&Theta", Character.valueOf('Θ'));
    ESCAPE_STRINGS.put("&Iota", Character.valueOf('Ι'));
    ESCAPE_STRINGS.put("&Kappa", Character.valueOf('Κ'));
    ESCAPE_STRINGS.put("&Lambda", Character.valueOf('Λ'));
    ESCAPE_STRINGS.put("&Mu", Character.valueOf('Μ'));
    ESCAPE_STRINGS.put("&Nu", Character.valueOf('Ν'));
    ESCAPE_STRINGS.put("&Xi", Character.valueOf('Ξ'));
    ESCAPE_STRINGS.put("&Omicron", Character.valueOf('Ο'));
    ESCAPE_STRINGS.put("&Pi", Character.valueOf('Π'));
    ESCAPE_STRINGS.put("&Rho", Character.valueOf('Ρ'));
    ESCAPE_STRINGS.put("&Sigma", Character.valueOf('Σ'));
    ESCAPE_STRINGS.put("&Tau", Character.valueOf('Τ'));
    ESCAPE_STRINGS.put("&Upsilon", Character.valueOf('Υ'));
    ESCAPE_STRINGS.put("&Phi", Character.valueOf('Φ'));
    ESCAPE_STRINGS.put("&Chi", Character.valueOf('Χ'));
    ESCAPE_STRINGS.put("&Psi", Character.valueOf('Ψ'));
    ESCAPE_STRINGS.put("&Omega", Character.valueOf('Ω'));
    ESCAPE_STRINGS.put("&alpha", Character.valueOf('α'));
    ESCAPE_STRINGS.put("&beta", Character.valueOf('β'));
    ESCAPE_STRINGS.put("&gamma", Character.valueOf('γ'));
    ESCAPE_STRINGS.put("&delta", Character.valueOf('δ'));
    ESCAPE_STRINGS.put("&epsilon", Character.valueOf('ε'));
    ESCAPE_STRINGS.put("&zeta", Character.valueOf('ζ'));
    ESCAPE_STRINGS.put("&eta", Character.valueOf('η'));
    ESCAPE_STRINGS.put("&theta", Character.valueOf('θ'));
    ESCAPE_STRINGS.put("&iota", Character.valueOf('ι'));
    ESCAPE_STRINGS.put("&kappa", Character.valueOf('κ'));
    ESCAPE_STRINGS.put("&lambda", Character.valueOf('λ'));
    ESCAPE_STRINGS.put("&mu", Character.valueOf('μ'));
    ESCAPE_STRINGS.put("&nu", Character.valueOf('ν'));
    ESCAPE_STRINGS.put("&xi", Character.valueOf('ξ'));
    ESCAPE_STRINGS.put("&omicron", Character.valueOf('ο'));
    ESCAPE_STRINGS.put("&pi", Character.valueOf('π'));
    ESCAPE_STRINGS.put("&rho", Character.valueOf('ρ'));
    ESCAPE_STRINGS.put("&sigmaf", Character.valueOf('ς'));
    ESCAPE_STRINGS.put("&sigma", Character.valueOf('σ'));
    ESCAPE_STRINGS.put("&tau", Character.valueOf('τ'));
    ESCAPE_STRINGS.put("&upsilon", Character.valueOf('υ'));
    ESCAPE_STRINGS.put("&phi", Character.valueOf('φ'));
    ESCAPE_STRINGS.put("&chi", Character.valueOf('χ'));
    ESCAPE_STRINGS.put("&psi", Character.valueOf('ψ'));
    ESCAPE_STRINGS.put("&omega", Character.valueOf('ω'));
    ESCAPE_STRINGS.put("&thetasym", Character.valueOf('ϑ'));
    ESCAPE_STRINGS.put("&upsih", Character.valueOf('ϒ'));
    ESCAPE_STRINGS.put("&piv", Character.valueOf('ϖ'));
    ESCAPE_STRINGS.put("&bull", Character.valueOf('•'));
    ESCAPE_STRINGS.put("&hellip", Character.valueOf('…'));
    ESCAPE_STRINGS.put("&prime", Character.valueOf('′'));
    ESCAPE_STRINGS.put("&Prime", Character.valueOf('″'));
    ESCAPE_STRINGS.put("&oline", Character.valueOf('‾'));
    ESCAPE_STRINGS.put("&frasl", Character.valueOf('⁄'));
    ESCAPE_STRINGS.put("&weierp", Character.valueOf('℘'));
    ESCAPE_STRINGS.put("&image", Character.valueOf('ℑ'));
    ESCAPE_STRINGS.put("&real", Character.valueOf('ℜ'));
    ESCAPE_STRINGS.put("&trade", Character.valueOf('™'));
    ESCAPE_STRINGS.put("&alefsym", Character.valueOf('ℵ'));
    ESCAPE_STRINGS.put("&larr", Character.valueOf('←'));
    ESCAPE_STRINGS.put("&uarr", Character.valueOf('↑'));
    ESCAPE_STRINGS.put("&rarr", Character.valueOf('→'));
    ESCAPE_STRINGS.put("&darr", Character.valueOf('↓'));
    ESCAPE_STRINGS.put("&harr", Character.valueOf('↔'));
    ESCAPE_STRINGS.put("&crarr", Character.valueOf('↵'));
    ESCAPE_STRINGS.put("&lArr", Character.valueOf('⇐'));
    ESCAPE_STRINGS.put("&uArr", Character.valueOf('⇑'));
    ESCAPE_STRINGS.put("&rArr", Character.valueOf('⇒'));
    ESCAPE_STRINGS.put("&dArr", Character.valueOf('⇓'));
    ESCAPE_STRINGS.put("&hArr", Character.valueOf('⇔'));
    ESCAPE_STRINGS.put("&forall", Character.valueOf('∀'));
    ESCAPE_STRINGS.put("&part", Character.valueOf('∂'));
    ESCAPE_STRINGS.put("&exist", Character.valueOf('∃'));
    ESCAPE_STRINGS.put("&empty", Character.valueOf('∅'));
    ESCAPE_STRINGS.put("&nabla", Character.valueOf('∇'));
    ESCAPE_STRINGS.put("&isin", Character.valueOf('∈'));
    ESCAPE_STRINGS.put("&notin", Character.valueOf('∉'));
    ESCAPE_STRINGS.put("&ni", Character.valueOf('∋'));
    ESCAPE_STRINGS.put("&prod", Character.valueOf('∏'));
    ESCAPE_STRINGS.put("&sum", Character.valueOf('∑'));
    ESCAPE_STRINGS.put("&minus", Character.valueOf('−'));
    ESCAPE_STRINGS.put("&lowast", Character.valueOf('∗'));
    ESCAPE_STRINGS.put("&radic", Character.valueOf('√'));
    ESCAPE_STRINGS.put("&prop", Character.valueOf('∝'));
    ESCAPE_STRINGS.put("&infin", Character.valueOf('∞'));
    ESCAPE_STRINGS.put("&ang", Character.valueOf('∠'));
    ESCAPE_STRINGS.put("&and", Character.valueOf('∧'));
    ESCAPE_STRINGS.put("&or", Character.valueOf('∨'));
    ESCAPE_STRINGS.put("&cap", Character.valueOf('∩'));
    ESCAPE_STRINGS.put("&cup", Character.valueOf('∪'));
    ESCAPE_STRINGS.put("&int", Character.valueOf('∫'));
    ESCAPE_STRINGS.put("&there4", Character.valueOf('∴'));
    ESCAPE_STRINGS.put("&sim", Character.valueOf('∼'));
    ESCAPE_STRINGS.put("&cong", Character.valueOf('≅'));
    ESCAPE_STRINGS.put("&asymp", Character.valueOf('≈'));
    ESCAPE_STRINGS.put("&ne", Character.valueOf('≠'));
    ESCAPE_STRINGS.put("&equiv", Character.valueOf('≡'));
    ESCAPE_STRINGS.put("&le", Character.valueOf('≤'));
    ESCAPE_STRINGS.put("&ge", Character.valueOf('≥'));
    ESCAPE_STRINGS.put("&sub", Character.valueOf('⊂'));
    ESCAPE_STRINGS.put("&sup", Character.valueOf('⊃'));
    ESCAPE_STRINGS.put("&nsub", Character.valueOf('⊄'));
    ESCAPE_STRINGS.put("&sube", Character.valueOf('⊆'));
    ESCAPE_STRINGS.put("&supe", Character.valueOf('⊇'));
    ESCAPE_STRINGS.put("&oplus", Character.valueOf('⊕'));
    ESCAPE_STRINGS.put("&otimes", Character.valueOf('⊗'));
    ESCAPE_STRINGS.put("&perp", Character.valueOf('⊥'));
    ESCAPE_STRINGS.put("&sdot", Character.valueOf('⋅'));
    ESCAPE_STRINGS.put("&lceil", Character.valueOf('⌈'));
    ESCAPE_STRINGS.put("&rceil", Character.valueOf('⌉'));
    ESCAPE_STRINGS.put("&lfloor", Character.valueOf('⌊'));
    ESCAPE_STRINGS.put("&rfloor", Character.valueOf('⌋'));
    ESCAPE_STRINGS.put("&lang", Character.valueOf('〈'));
    ESCAPE_STRINGS.put("&rang", Character.valueOf('〉'));
    ESCAPE_STRINGS.put("&loz", Character.valueOf('◊'));
    ESCAPE_STRINGS.put("&spades", Character.valueOf('♠'));
    ESCAPE_STRINGS.put("&clubs", Character.valueOf('♣'));
    ESCAPE_STRINGS.put("&hearts", Character.valueOf('♥'));
    ESCAPE_STRINGS.put("&diams", Character.valueOf('♦'));
    ESCAPE_STRINGS.put("&quot", Character.valueOf('"'));
    ESCAPE_STRINGS.put("&amp", Character.valueOf('&'));
    ESCAPE_STRINGS.put("&lt", Character.valueOf('<'));
    ESCAPE_STRINGS.put("&gt", Character.valueOf('>'));
    ESCAPE_STRINGS.put("&OElig", Character.valueOf('Œ'));
    ESCAPE_STRINGS.put("&oelig", Character.valueOf('œ'));
    ESCAPE_STRINGS.put("&Scaron", Character.valueOf('Š'));
    ESCAPE_STRINGS.put("&scaron", Character.valueOf('š'));
    ESCAPE_STRINGS.put("&Yuml", Character.valueOf('Ÿ'));
    ESCAPE_STRINGS.put("&circ", Character.valueOf('ˆ'));
    ESCAPE_STRINGS.put("&tilde", Character.valueOf('˜'));
    ESCAPE_STRINGS.put("&ensp", Character.valueOf(' '));
    ESCAPE_STRINGS.put("&emsp", Character.valueOf(' '));
    ESCAPE_STRINGS.put("&thinsp", Character.valueOf(' '));
    ESCAPE_STRINGS.put("&zwnj", Character.valueOf('‌'));
    ESCAPE_STRINGS.put("&zwj", Character.valueOf('‍'));
    ESCAPE_STRINGS.put("&lrm", Character.valueOf('‎'));
    ESCAPE_STRINGS.put("&rlm", Character.valueOf('‏'));
    ESCAPE_STRINGS.put("&ndash", Character.valueOf('–'));
    ESCAPE_STRINGS.put("&mdash", Character.valueOf('—'));
    ESCAPE_STRINGS.put("&lsquo", Character.valueOf('‘'));
    ESCAPE_STRINGS.put("&rsquo", Character.valueOf('’'));
    ESCAPE_STRINGS.put("&sbquo", Character.valueOf('‚'));
    ESCAPE_STRINGS.put("&ldquo", Character.valueOf('“'));
    ESCAPE_STRINGS.put("&rdquo", Character.valueOf('”'));
    ESCAPE_STRINGS.put("&bdquo", Character.valueOf('„'));
    ESCAPE_STRINGS.put("&dagger", Character.valueOf('†'));
    ESCAPE_STRINGS.put("&Dagger", Character.valueOf('‡'));
    ESCAPE_STRINGS.put("&permil", Character.valueOf('‰'));
    ESCAPE_STRINGS.put("&lsaquo", Character.valueOf('‹'));
    ESCAPE_STRINGS.put("&rsaquo", Character.valueOf('›'));
    ESCAPE_STRINGS.put("&euro", Character.valueOf('€'));
    HEX_LETTERS = new HashSet(12);
    HEX_LETTERS.add(Character.valueOf('a'));
    HEX_LETTERS.add(Character.valueOf('A'));
    HEX_LETTERS.add(Character.valueOf('b'));
    HEX_LETTERS.add(Character.valueOf('B'));
    HEX_LETTERS.add(Character.valueOf('c'));
    HEX_LETTERS.add(Character.valueOf('C'));
    HEX_LETTERS.add(Character.valueOf('d'));
    HEX_LETTERS.add(Character.valueOf('D'));
    HEX_LETTERS.add(Character.valueOf('e'));
    HEX_LETTERS.add(Character.valueOf('E'));
    HEX_LETTERS.add(Character.valueOf('f'));
    HEX_LETTERS.add(Character.valueOf('F'));
    LT_GT_ESCAPE = new CharEscaperBuilder().addEscape('<', "&lt;").addEscape('>', "&gt;").toEscaper();
    htmlTagPattern = Pattern.compile("</?[a-zA-Z][^>]*>");
    CONTROL_MATCHER = CharMatcher.anyOf("\000\001\002\003\004\005\006\007\b\013\f\016\017\020\021\022\023\024\025\026\027\030\031\032\033\034\035\036\037￾￿");
    JAVA_ESCAPE = new CharEscaperBuilder().addEscape('\n', "\\n").addEscape('\r', "\\r").addEscape('\t', "\\t").addEscape('\\', "\\\\").addEscape('"', "\\\"").addEscape('&', "&amp;").addEscape('<', "&lt;").addEscape('>', "&gt;").addEscape('\'', "\\'").toEscaper();
    REGEX_ESCAPE = new CharEscaperBuilder().addEscape('(', "\\(").addEscape(')', "\\)").addEscape('|', "\\|").addEscape('*', "\\*").addEscape('+', "\\+").addEscape('?', "\\?").addEscape('.', "\\.").addEscape('{', "\\{").addEscape('}', "\\}").addEscape('[', "\\[").addEscape(']', "\\]").addEscape('$', "\\$").addEscape('^', "\\^").addEscape('\\', "\\\\").toEscaper();
    characterReferencePattern = Pattern.compile("&#?[a-zA-Z0-9]{1,8};");
    HashSet localHashSet = new HashSet();
    localHashSet.add(Character.UnicodeBlock.HANGUL_JAMO);
    localHashSet.add(Character.UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
    localHashSet.add(Character.UnicodeBlock.KANGXI_RADICALS);
    localHashSet.add(Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
    localHashSet.add(Character.UnicodeBlock.HIRAGANA);
    localHashSet.add(Character.UnicodeBlock.KATAKANA);
    localHashSet.add(Character.UnicodeBlock.BOPOMOFO);
    localHashSet.add(Character.UnicodeBlock.HANGUL_COMPATIBILITY_JAMO);
    localHashSet.add(Character.UnicodeBlock.KANBUN);
    localHashSet.add(Character.UnicodeBlock.BOPOMOFO_EXTENDED);
    localHashSet.add(Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
    localHashSet.add(Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS);
    localHashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY);
    localHashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
    localHashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
    localHashSet.add(Character.UnicodeBlock.HANGUL_SYLLABLES);
    localHashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
    localHashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS);
    localHashSet.add(Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
    localHashSet.add(Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
    localHashSet.add(Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
    CJK_BLOCKS = Collections.unmodifiableSet(localHashSet);
    HEX_CHARS = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    OCTAL_CHARS = HEX_CHARS;
    dbSpecPattern = Pattern.compile("(.*)\\{(\\d+),(\\d+)\\}(.*)");
    JS_ESCAPE_CHARS = new UnicodeSetBuilder(null).addCodePoint(173).addRange(1536, 1539).addCodePoint(1757).addCodePoint(1807).addRange(6068, 6069).addRange(8203, 8207).addRange(8234, 8238).addRange(8288, 8292).addRange(8298, 8303).addCodePoint(65279).addRange(65529, 65531).addRange(119155, 119162).addCodePoint(917505).addRange(917536, 917631).addCodePoint(0).addCodePoint(10).addCodePoint(13).addRange(8232, 8233).addCodePoint(133).addCodePoint(Character.codePointAt("'", 0)).addCodePoint(Character.codePointAt("\"", 0)).addCodePoint(Character.codePointAt("&", 0)).addCodePoint(Character.codePointAt("<", 0)).addCodePoint(Character.codePointAt(">", 0)).addCodePoint(Character.codePointAt("=", 0)).addCodePoint(Character.codePointAt("\\", 0)).create();
  }
  
  public static final String unescapeHTML(String paramString)
  {
    return unescapeHTML(paramString, false);
  }
  
  public static final String unescapeHTML(String paramString, boolean paramBoolean)
  {
    int n = paramString.indexOf('&');
    if (n == -1) {
      return paramString;
    }
    char[] arrayOfChar1 = paramString.toCharArray();
    char[] arrayOfChar2 = new char[arrayOfChar1.length];
    System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, n);
    i = n;
    while (n < arrayOfChar1.length) {
      if (arrayOfChar1[n] != '&')
      {
        arrayOfChar2[i] = arrayOfChar1[n];
        n += 1;
        i += 1;
      }
      else
      {
        int j = n + 1;
        m = 0;
        int i1 = m;
        k = j;
        if (j < arrayOfChar1.length)
        {
          i1 = m;
          k = j;
          if (arrayOfChar1[j] == '#')
          {
            k = j + 1;
            i1 = 1;
          }
        }
        int i2 = 0;
        m = i2;
        j = k;
        if (k < arrayOfChar1.length) {
          if (arrayOfChar1[k] != 'x')
          {
            m = i2;
            j = k;
            if (arrayOfChar1[k] != 'X') {}
          }
          else
          {
            j = k + 1;
            m = 1;
          }
        }
        label191:
        char c;
        boolean bool;
        label226:
        int i3;
        long l;
        if (j < arrayOfChar1.length)
        {
          c = arrayOfChar1[j];
          bool = Character.isDigit(c);
          if (i1 == 0) {
            break label518;
          }
          if ((m != 0) || (bool)) {}
        }
        else
        {
          k = 0;
          i4 = 0;
          if ((j > arrayOfChar1.length) || (!paramBoolean))
          {
            i1 = j;
            i2 = i;
            i3 = k;
            if (j < arrayOfChar1.length)
            {
              i1 = j;
              i2 = i;
              i3 = k;
              if (arrayOfChar1[j] != ';') {}
            }
          }
          else
          {
            if ((n + 2 >= arrayOfChar1.length) || (paramString.charAt(n + 1) != '#')) {
              break label574;
            }
            l = 0L;
          }
        }
        for (;;)
        {
          try
          {
            c = paramString.charAt(n + 2);
            if (m == 0) {
              continue;
            }
            l = Long.parseLong(new String(arrayOfChar1, n + 3, j - n - 3), 16);
            k = i;
            m = i4;
            if (l > 0L)
            {
              k = i;
              m = i4;
              if (l < 65536L)
              {
                arrayOfChar2[i] = ((char)(int)l);
                m = 1;
                k = i + 1;
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            label518:
            label574:
            Object localObject;
            k = i;
            m = i4;
            continue;
          }
          i1 = j;
          i2 = k;
          i3 = m;
          if (j < arrayOfChar1.length)
          {
            i1 = j;
            i2 = k;
            i3 = m;
            if (arrayOfChar1[j] == ';')
            {
              i1 = j + 1;
              i3 = m;
              i2 = k;
            }
          }
          i = i2;
          if (i3 == 0)
          {
            System.arraycopy(arrayOfChar1, n, arrayOfChar2, i2, i1 - n);
            i = i2 + (i1 - n);
          }
          n = i1;
          break;
          if ((m != 0) && (!bool) && (!HEX_LETTERS.contains(Character.valueOf(c)))) {
            break label226;
          }
          if ((!bool) && (!Character.isLetter(c))) {
            break label226;
          }
          j += 1;
          break label191;
          if (Character.isDigit(c))
          {
            l = Long.parseLong(new String(arrayOfChar1, n + 2, j - n - 2));
            continue;
            localObject = new String(arrayOfChar1, n, j - n);
            localObject = (Character)ESCAPE_STRINGS.get(localObject);
            k = i;
            m = i4;
            if (localObject != null)
            {
              arrayOfChar2[i] = ((Character)localObject).charValue();
              m = 1;
              k = i + 1;
            }
          }
        }
      }
    }
    return new String(arrayOfChar2, 0, i);
  }
  
  private static class UnicodeSetBuilder
  {
    Set<Integer> codePointSet = new HashSet();
    
    UnicodeSetBuilder addCodePoint(int paramInt)
    {
      codePointSet.add(Integer.valueOf(paramInt));
      return this;
    }
    
    UnicodeSetBuilder addRange(int paramInt1, int paramInt2)
    {
      while (paramInt1 <= paramInt2)
      {
        codePointSet.add(Integer.valueOf(paramInt1));
        paramInt1 += 1;
      }
      return this;
    }
    
    Set<Integer> create()
    {
      return codePointSet;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.base.StringUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */