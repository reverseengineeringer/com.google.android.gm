import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public final class bhl
{
  static final String a;
  static final String[] b;
  static final Map<String, Character> c;
  
  static
  {
    Object localObject = String.valueOf(Integer.toHexString(16776960));
    a = String.valueOf(localObject).length() + 1 + "#" + (String)localObject;
    b = new String[] { "title", "script", "style", "applet", "head" };
    localObject = new HashMap(252);
    c = (Map)localObject;
    ((Map)localObject).put("&nbsp", Character.valueOf(' '));
    c.put("&iexcl", Character.valueOf('¡'));
    c.put("&cent", Character.valueOf('¢'));
    c.put("&pound", Character.valueOf('£'));
    c.put("&curren", Character.valueOf('¤'));
    c.put("&yen", Character.valueOf('¥'));
    c.put("&brvbar", Character.valueOf('¦'));
    c.put("&sect", Character.valueOf('§'));
    c.put("&uml", Character.valueOf('¨'));
    c.put("&copy", Character.valueOf('©'));
    c.put("&ordf", Character.valueOf('ª'));
    c.put("&laquo", Character.valueOf('«'));
    c.put("&not", Character.valueOf('¬'));
    c.put("&shy", Character.valueOf('­'));
    c.put("&reg", Character.valueOf('®'));
    c.put("&macr", Character.valueOf('¯'));
    c.put("&deg", Character.valueOf('°'));
    c.put("&plusmn", Character.valueOf('±'));
    c.put("&sup2", Character.valueOf('²'));
    c.put("&sup3", Character.valueOf('³'));
    c.put("&acute", Character.valueOf('´'));
    c.put("&micro", Character.valueOf('µ'));
    c.put("&para", Character.valueOf('¶'));
    c.put("&middot", Character.valueOf('·'));
    c.put("&cedil", Character.valueOf('¸'));
    c.put("&sup1", Character.valueOf('¹'));
    c.put("&ordm", Character.valueOf('º'));
    c.put("&raquo", Character.valueOf('»'));
    c.put("&frac14", Character.valueOf('¼'));
    c.put("&frac12", Character.valueOf('½'));
    c.put("&frac34", Character.valueOf('¾'));
    c.put("&iquest", Character.valueOf('¿'));
    c.put("&Agrave", Character.valueOf('À'));
    c.put("&Aacute", Character.valueOf('Á'));
    c.put("&Acirc", Character.valueOf('Â'));
    c.put("&Atilde", Character.valueOf('Ã'));
    c.put("&Auml", Character.valueOf('Ä'));
    c.put("&Aring", Character.valueOf('Å'));
    c.put("&AElig", Character.valueOf('Æ'));
    c.put("&Ccedil", Character.valueOf('Ç'));
    c.put("&Egrave", Character.valueOf('È'));
    c.put("&Eacute", Character.valueOf('É'));
    c.put("&Ecirc", Character.valueOf('Ê'));
    c.put("&Euml", Character.valueOf('Ë'));
    c.put("&Igrave", Character.valueOf('Ì'));
    c.put("&Iacute", Character.valueOf('Í'));
    c.put("&Icirc", Character.valueOf('Î'));
    c.put("&Iuml", Character.valueOf('Ï'));
    c.put("&ETH", Character.valueOf('Ð'));
    c.put("&Ntilde", Character.valueOf('Ñ'));
    c.put("&Ograve", Character.valueOf('Ò'));
    c.put("&Oacute", Character.valueOf('Ó'));
    c.put("&Ocirc", Character.valueOf('Ô'));
    c.put("&Otilde", Character.valueOf('Õ'));
    c.put("&Ouml", Character.valueOf('Ö'));
    c.put("&times", Character.valueOf('×'));
    c.put("&Oslash", Character.valueOf('Ø'));
    c.put("&Ugrave", Character.valueOf('Ù'));
    c.put("&Uacute", Character.valueOf('Ú'));
    c.put("&Ucirc", Character.valueOf('Û'));
    c.put("&Uuml", Character.valueOf('Ü'));
    c.put("&Yacute", Character.valueOf('Ý'));
    c.put("&THORN", Character.valueOf('Þ'));
    c.put("&szlig", Character.valueOf('ß'));
    c.put("&agrave", Character.valueOf('à'));
    c.put("&aacute", Character.valueOf('á'));
    c.put("&acirc", Character.valueOf('â'));
    c.put("&atilde", Character.valueOf('ã'));
    c.put("&auml", Character.valueOf('ä'));
    c.put("&aring", Character.valueOf('å'));
    c.put("&aelig", Character.valueOf('æ'));
    c.put("&ccedil", Character.valueOf('ç'));
    c.put("&egrave", Character.valueOf('è'));
    c.put("&eacute", Character.valueOf('é'));
    c.put("&ecirc", Character.valueOf('ê'));
    c.put("&euml", Character.valueOf('ë'));
    c.put("&igrave", Character.valueOf('ì'));
    c.put("&iacute", Character.valueOf('í'));
    c.put("&icirc", Character.valueOf('î'));
    c.put("&iuml", Character.valueOf('ï'));
    c.put("&eth", Character.valueOf('ð'));
    c.put("&ntilde", Character.valueOf('ñ'));
    c.put("&ograve", Character.valueOf('ò'));
    c.put("&oacute", Character.valueOf('ó'));
    c.put("&ocirc", Character.valueOf('ô'));
    c.put("&otilde", Character.valueOf('õ'));
    c.put("&ouml", Character.valueOf('ö'));
    c.put("&divide", Character.valueOf('÷'));
    c.put("&oslash", Character.valueOf('ø'));
    c.put("&ugrave", Character.valueOf('ù'));
    c.put("&uacute", Character.valueOf('ú'));
    c.put("&ucirc", Character.valueOf('û'));
    c.put("&uuml", Character.valueOf('ü'));
    c.put("&yacute", Character.valueOf('ý'));
    c.put("&thorn", Character.valueOf('þ'));
    c.put("&yuml", Character.valueOf('ÿ'));
    c.put("&fnof", Character.valueOf('ƒ'));
    c.put("&Alpha", Character.valueOf('Α'));
    c.put("&Beta", Character.valueOf('Β'));
    c.put("&Gamma", Character.valueOf('Γ'));
    c.put("&Delta", Character.valueOf('Δ'));
    c.put("&Epsilon", Character.valueOf('Ε'));
    c.put("&Zeta", Character.valueOf('Ζ'));
    c.put("&Eta", Character.valueOf('Η'));
    c.put("&Theta", Character.valueOf('Θ'));
    c.put("&Iota", Character.valueOf('Ι'));
    c.put("&Kappa", Character.valueOf('Κ'));
    c.put("&Lambda", Character.valueOf('Λ'));
    c.put("&Mu", Character.valueOf('Μ'));
    c.put("&Nu", Character.valueOf('Ν'));
    c.put("&Xi", Character.valueOf('Ξ'));
    c.put("&Omicron", Character.valueOf('Ο'));
    c.put("&Pi", Character.valueOf('Π'));
    c.put("&Rho", Character.valueOf('Ρ'));
    c.put("&Sigma", Character.valueOf('Σ'));
    c.put("&Tau", Character.valueOf('Τ'));
    c.put("&Upsilon", Character.valueOf('Υ'));
    c.put("&Phi", Character.valueOf('Φ'));
    c.put("&Chi", Character.valueOf('Χ'));
    c.put("&Psi", Character.valueOf('Ψ'));
    c.put("&Omega", Character.valueOf('Ω'));
    c.put("&alpha", Character.valueOf('α'));
    c.put("&beta", Character.valueOf('β'));
    c.put("&gamma", Character.valueOf('γ'));
    c.put("&delta", Character.valueOf('δ'));
    c.put("&epsilon", Character.valueOf('ε'));
    c.put("&zeta", Character.valueOf('ζ'));
    c.put("&eta", Character.valueOf('η'));
    c.put("&theta", Character.valueOf('θ'));
    c.put("&iota", Character.valueOf('ι'));
    c.put("&kappa", Character.valueOf('κ'));
    c.put("&lambda", Character.valueOf('λ'));
    c.put("&mu", Character.valueOf('μ'));
    c.put("&nu", Character.valueOf('ν'));
    c.put("&xi", Character.valueOf('ξ'));
    c.put("&omicron", Character.valueOf('ο'));
    c.put("&pi", Character.valueOf('π'));
    c.put("&rho", Character.valueOf('ρ'));
    c.put("&sigmaf", Character.valueOf('ς'));
    c.put("&sigma", Character.valueOf('σ'));
    c.put("&tau", Character.valueOf('τ'));
    c.put("&upsilon", Character.valueOf('υ'));
    c.put("&phi", Character.valueOf('φ'));
    c.put("&chi", Character.valueOf('χ'));
    c.put("&psi", Character.valueOf('ψ'));
    c.put("&omega", Character.valueOf('ω'));
    c.put("&thetasym", Character.valueOf('ϑ'));
    c.put("&upsih", Character.valueOf('ϒ'));
    c.put("&piv", Character.valueOf('ϖ'));
    c.put("&bull", Character.valueOf('•'));
    c.put("&hellip", Character.valueOf('…'));
    c.put("&prime", Character.valueOf('′'));
    c.put("&Prime", Character.valueOf('″'));
    c.put("&oline", Character.valueOf('‾'));
    c.put("&frasl", Character.valueOf('⁄'));
    c.put("&weierp", Character.valueOf('℘'));
    c.put("&image", Character.valueOf('ℑ'));
    c.put("&real", Character.valueOf('ℜ'));
    c.put("&trade", Character.valueOf('™'));
    c.put("&alefsym", Character.valueOf('ℵ'));
    c.put("&larr", Character.valueOf('←'));
    c.put("&uarr", Character.valueOf('↑'));
    c.put("&rarr", Character.valueOf('→'));
    c.put("&darr", Character.valueOf('↓'));
    c.put("&harr", Character.valueOf('↔'));
    c.put("&crarr", Character.valueOf('↵'));
    c.put("&lArr", Character.valueOf('⇐'));
    c.put("&uArr", Character.valueOf('⇑'));
    c.put("&rArr", Character.valueOf('⇒'));
    c.put("&dArr", Character.valueOf('⇓'));
    c.put("&hArr", Character.valueOf('⇔'));
    c.put("&forall", Character.valueOf('∀'));
    c.put("&part", Character.valueOf('∂'));
    c.put("&exist", Character.valueOf('∃'));
    c.put("&empty", Character.valueOf('∅'));
    c.put("&nabla", Character.valueOf('∇'));
    c.put("&isin", Character.valueOf('∈'));
    c.put("&notin", Character.valueOf('∉'));
    c.put("&ni", Character.valueOf('∋'));
    c.put("&prod", Character.valueOf('∏'));
    c.put("&sum", Character.valueOf('∑'));
    c.put("&minus", Character.valueOf('−'));
    c.put("&lowast", Character.valueOf('∗'));
    c.put("&radic", Character.valueOf('√'));
    c.put("&prop", Character.valueOf('∝'));
    c.put("&infin", Character.valueOf('∞'));
    c.put("&ang", Character.valueOf('∠'));
    c.put("&and", Character.valueOf('∧'));
    c.put("&or", Character.valueOf('∨'));
    c.put("&cap", Character.valueOf('∩'));
    c.put("&cup", Character.valueOf('∪'));
    c.put("&int", Character.valueOf('∫'));
    c.put("&there4", Character.valueOf('∴'));
    c.put("&sim", Character.valueOf('∼'));
    c.put("&cong", Character.valueOf('≅'));
    c.put("&asymp", Character.valueOf('≈'));
    c.put("&ne", Character.valueOf('≠'));
    c.put("&equiv", Character.valueOf('≡'));
    c.put("&le", Character.valueOf('≤'));
    c.put("&ge", Character.valueOf('≥'));
    c.put("&sub", Character.valueOf('⊂'));
    c.put("&sup", Character.valueOf('⊃'));
    c.put("&nsub", Character.valueOf('⊄'));
    c.put("&sube", Character.valueOf('⊆'));
    c.put("&supe", Character.valueOf('⊇'));
    c.put("&oplus", Character.valueOf('⊕'));
    c.put("&otimes", Character.valueOf('⊗'));
    c.put("&perp", Character.valueOf('⊥'));
    c.put("&sdot", Character.valueOf('⋅'));
    c.put("&lceil", Character.valueOf('⌈'));
    c.put("&rceil", Character.valueOf('⌉'));
    c.put("&lfloor", Character.valueOf('⌊'));
    c.put("&rfloor", Character.valueOf('⌋'));
    c.put("&lang", Character.valueOf('〈'));
    c.put("&rang", Character.valueOf('〉'));
    c.put("&loz", Character.valueOf('◊'));
    c.put("&spades", Character.valueOf('♠'));
    c.put("&clubs", Character.valueOf('♣'));
    c.put("&hearts", Character.valueOf('♥'));
    c.put("&diams", Character.valueOf('♦'));
    c.put("&quot", Character.valueOf('"'));
    c.put("&amp", Character.valueOf('&'));
    c.put("&lt", Character.valueOf('<'));
    c.put("&gt", Character.valueOf('>'));
    c.put("&OElig", Character.valueOf('Œ'));
    c.put("&oelig", Character.valueOf('œ'));
    c.put("&Scaron", Character.valueOf('Š'));
    c.put("&scaron", Character.valueOf('š'));
    c.put("&Yuml", Character.valueOf('Ÿ'));
    c.put("&circ", Character.valueOf('ˆ'));
    c.put("&tilde", Character.valueOf('˜'));
    c.put("&ensp", Character.valueOf(' '));
    c.put("&emsp", Character.valueOf(' '));
    c.put("&thinsp", Character.valueOf(' '));
    c.put("&zwnj", Character.valueOf('‌'));
    c.put("&zwj", Character.valueOf('‍'));
    c.put("&lrm", Character.valueOf('‎'));
    c.put("&rlm", Character.valueOf('‏'));
    c.put("&ndash", Character.valueOf('–'));
    c.put("&mdash", Character.valueOf('—'));
    c.put("&lsquo", Character.valueOf('‘'));
    c.put("&rsquo", Character.valueOf('’'));
    c.put("&sbquo", Character.valueOf('‚'));
    c.put("&ldquo", Character.valueOf('“'));
    c.put("&rdquo", Character.valueOf('”'));
    c.put("&bdquo", Character.valueOf('„'));
    c.put("&dagger", Character.valueOf('†'));
    c.put("&Dagger", Character.valueOf('‡'));
    c.put("&permil", Character.valueOf('‰'));
    c.put("&lsaquo", Character.valueOf('‹'));
    c.put("&rsaquo", Character.valueOf('›'));
    c.put("&euro", Character.valueOf('€'));
  }
  
  private static char a(String paramString, int paramInt, int[] paramArrayOfInt)
  {
    int j = paramString.length();
    paramArrayOfInt[0] = 0;
    int i = paramInt;
    if ((i < j) && (i < paramInt + 10)) {
      if (paramString.charAt(i) != ';') {}
    }
    for (paramString = paramString.substring(paramInt, i);; paramString = null)
    {
      if (paramString == null)
      {
        return '&';
        i += 1;
        break;
      }
      Character localCharacter = (Character)c.get(paramString);
      i = paramString.length();
      if (localCharacter != null)
      {
        paramArrayOfInt[0] = i;
        return localCharacter.charValue();
      }
      if ((i > 2) && (paramString.charAt(1) == '#'))
      {
        char c1 = '?';
        for (;;)
        {
          try
          {
            if ((paramString.charAt(2) != 'x') || (i <= 3)) {
              continue;
            }
            paramInt = Integer.parseInt(paramString.substring(3), 16);
            c1 = (char)paramInt;
          }
          catch (NumberFormatException paramString)
          {
            continue;
          }
          paramArrayOfInt[0] = i;
          return c1;
          paramInt = Integer.parseInt(paramString.substring(2));
        }
      }
      return '&';
    }
  }
  
  private static int a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString2;
    if (paramString2.endsWith(" ")) {
      str = paramString2.substring(0, paramString2.length() - 1);
    }
    int m = paramString1.length();
    int j = 0;
    int i = paramInt;
    while (i < m)
    {
      int k = paramString1.charAt(i);
      if (k == 62)
      {
        if (j != 47) {
          break;
        }
        return i - 1;
      }
      i += 1;
      j = k;
    }
    paramString2 = String.valueOf(str);
    if (paramString2.length() != 0) {}
    for (paramString2 = "/".concat(paramString2);; paramString2 = new String("/")) {
      return paramString1.indexOf(paramString2, paramInt);
    }
  }
  
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt)
  {
    paramCharSequence2 = new SpannableString(paramCharSequence2);
    paramCharSequence2.setSpan(new TextAppearanceSpan(paramContext, paramInt), 0, paramCharSequence2.length(), 33);
    return new SpannableStringBuilder(paramCharSequence1).append("\n").append(paramCharSequence2);
  }
  
  public static String a(String paramString)
  {
    return a(paramString, true);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    label900:
    label909:
    label926:
    label939:
    label960:
    label974:
    for (;;)
    {
      int j;
      char c2;
      int n;
      try
      {
        if (TextUtils.isEmpty(paramString1))
        {
          paramString2 = "";
          return paramString2.toString();
        }
        int i2 = paramString1.length();
        ArrayList localArrayList = new ArrayList();
        if (paramString2 != null)
        {
          paramString2 = new StringTokenizer(paramString2);
          if (paramString2.hasMoreTokens())
          {
            localArrayList.add(new bhm(paramString2.nextToken()));
            continue;
          }
        }
        StringBuilder localStringBuilder = new StringBuilder();
        k = 0;
        j = -1;
        i = 0;
        int i1;
        Object localObject2;
        Object localObject3;
        if (i < i2)
        {
          c1 = paramString1.charAt(i);
          if ((k != 0) || (c1 != '<')) {
            break label939;
          }
          if (i >= i2 - 1) {
            continue;
          }
          char c3 = paramString1.charAt(i + 1);
          if ((c3 != '!') && (c3 != '-') && (c3 != '/'))
          {
            c2 = c1;
            m = i;
            if (!Character.isLetter(c3)) {
              break label909;
            }
          }
          i1 = 1;
          c2 = c1;
          m = i;
          k = i1;
          if (i >= i2 - 8) {
            break label909;
          }
          localObject1 = paramString1.substring(i + 1, i + 6 + 1);
          localObject2 = ((String)localObject1).toLowerCase();
          m = 0;
          localObject3 = b;
          i3 = localObject3.length;
          k = 0;
          n = m;
          paramString2 = (String)localObject1;
          if (k < i3)
          {
            paramString2 = localObject3[k];
            if (!((String)localObject2).startsWith(paramString2)) {
              break label900;
            }
            n = 1;
            paramString2 = ((String)localObject1).substring(0, paramString2.length());
          }
          c2 = c1;
          m = i;
          k = i1;
          if (n == 0) {
            break label909;
          }
          k = a(paramString1, paramString2, i);
          if (k < 0) {
            localStringBuilder.append(paramString1.substring(i));
          }
        }
        else
        {
          paramString2 = (CharSequence)localStringBuilder;
          continue;
        }
        localStringBuilder.append(paramString1.substring(i, k - 1));
        m = k - 1;
        c2 = paramString1.charAt(m);
        k = i1;
        break label909;
        if (m != 0)
        {
          localStringBuilder.append(c1);
          break label926;
        }
        int i3 = Character.toLowerCase(c1);
        i = 1;
        Object localObject1 = localArrayList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bhm)((Iterator)localObject1).next();
          if (i3 == b.charAt(d))
          {
            i = d;
            d = (i + 1);
            if (i == 0) {
              e = k;
            }
            if (d != c) {
              continue;
            }
            paramString2 = paramString1.substring(e, e + c);
            if (e <= j) {
              paramString2 = paramString1.substring(j + 1, k + 1);
            }
            if (paramString2.length() != 0)
            {
              localObject3 = a;
              localStringBuilder.append(String.valueOf(localObject3).length() + 33 + "<span style=\"background-color: " + (String)localObject3 + "\">");
              localStringBuilder.append(paramString2);
              localStringBuilder.append("</span>");
            }
            i = e;
            j = c;
            d = 0;
            e = -1;
            i = i + j - 1;
            break label960;
          }
          if (e >= 0)
          {
            n = -1;
            paramString2 = localArrayList.iterator();
            if (paramString2.hasNext())
            {
              localObject3 = (bhm)paramString2.next();
              if ((localObject3 == localObject2) || (e < 0) || ((n >= 0) && (e > n))) {
                continue;
              }
              n = e;
              break label974;
            }
            i1 = e + d;
            if ((n < 0) || (n > i1))
            {
              if (e > j)
              {
                localStringBuilder.append(paramString1.substring(e, i1));
                j = i1;
                d = 0;
                e = -1;
              }
            }
            else if (n != e)
            {
              if (n < e)
              {
                i = 0;
                continue;
              }
              if (e > j)
              {
                localStringBuilder.append(paramString1.substring(e, n));
                j = n;
                continue;
              }
            }
          }
        }
        else
        {
          if (i == 0) {
            break label926;
          }
          localStringBuilder.append(c1);
          j = k;
          break label926;
        }
        continue;
        break label974;
        i = j;
        break label960;
        m = k;
        k = i;
        continue;
        k += 1;
      }
      catch (IOException paramString2)
      {
        return paramString1;
      }
      continue;
      char c1 = c2;
      int i = k;
      int k = m;
      int m = i;
      continue;
      i = k + 1;
      k = m;
      continue;
      if ((k != 0) && (c1 == '>'))
      {
        m = 0;
        k = i;
        continue;
        n = 0;
        j = i;
        i = n;
      }
    }
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i5 = paramString.length();
    char[] arrayOfChar = new char['È'];
    int[] arrayOfInt = new int[1];
    int k = 0;
    int n = 32;
    int i1 = 0;
    int m = 0;
    int i;
    int j;
    int i2;
    label193:
    int i3;
    if ((m < i5) && (k < 200))
    {
      i = paramString.charAt(m);
      if ((paramBoolean) && (i1 == 0) && (i == 60))
      {
        if (m >= i5 - 1) {
          break label535;
        }
        j = paramString.charAt(m + 1);
        if ((j != 33) && (j != 45) && (j != 47) && (j != 63))
        {
          i2 = m;
          if (!Character.isLetter(j)) {}
        }
        else
        {
          int i4 = 1;
          i2 = m;
          i1 = i4;
          if (m < i5 - 8)
          {
            String str2 = paramString.substring(m + 1, m + 6 + 1);
            String str3 = str2.toLowerCase();
            i2 = 0;
            String[] arrayOfString = b;
            int i6 = arrayOfString.length;
            i1 = 0;
            i3 = i2;
            String str1 = str2;
            if (i1 < i6)
            {
              str1 = arrayOfString[i1];
              if (!str3.startsWith(str1)) {
                break label398;
              }
              i3 = 1;
              str1 = str2.substring(0, str1.length());
            }
            i2 = m;
            i1 = i4;
            if (i3 != 0)
            {
              i2 = a(paramString, str1, m);
              if (i2 < 0) {
                break label493;
              }
              i1 = i4;
            }
          }
        }
        m = i1;
        i1 = i2;
      }
    }
    for (;;)
    {
      i2 = i1;
      if (m == 0)
      {
        if ((!paramBoolean) || (i != 38)) {
          break label532;
        }
        i = a(paramString, i1, arrayOfInt);
        i1 += arrayOfInt[0];
      }
      label346:
      label398:
      label470:
      label493:
      label532:
      for (;;)
      {
        if ((Character.isWhitespace(i)) || (i == 160))
        {
          i2 = i1;
          if (n == 32) {
            break label470;
          }
          j = 32;
          arrayOfChar[k] = j;
          n = k + 1;
          i2 = j;
          k = m;
          m = i2;
        }
        for (;;)
        {
          i2 = m;
          i3 = n;
          m = i1 + 1;
          i1 = k;
          n = i2;
          k = i3;
          break;
          i1 += 1;
          break label193;
          if ((!paramBoolean) || (i1 == 0) || (i != 62)) {
            break label535;
          }
          i2 = k;
          k = 0;
          i1 = m;
          m = n;
          n = i2;
          continue;
          if (i != 45)
          {
            j = i;
            if (i != 61) {
              break label346;
            }
          }
          j = i;
          if (n != i) {
            break label346;
          }
          i2 = i1;
          i1 = m;
          m = n;
          n = k;
          k = i1;
          i1 = i2;
        }
        m = k;
        if (k > 0)
        {
          m = k;
          if (n == 32) {
            m = k - 1;
          }
        }
        return new String(arrayOfChar, 0, m);
      }
      label535:
      i2 = i1;
      i1 = m;
      m = i2;
    }
  }
  
  public static String b(String paramString)
  {
    return a(paramString, false);
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {}
    while ((paramString1 != null) && (paramString2 != null) && (paramString1.equals(paramString2))) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     bhl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */