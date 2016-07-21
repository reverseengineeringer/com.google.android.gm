import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;
import java.util.TreeSet;

public class ihb
{
  public static TreeSet<String> a;
  public static HashMap<String, ihc> b;
  public static final Charset c;
  public static final Charset d;
  public static final Charset e;
  private static idy f = new idy();
  private static ihc[] g = { new ihc("ISO8859_1", "ISO-8859-1", new String[] { "ISO_8859-1:1987", "iso-ir-100", "ISO_8859-1", "latin1", "l1", "IBM819", "CP819", "csISOLatin1", "8859_1", "819", "IBM-819", "ISO8859-1", "ISO_8859_1" }), new ihc("ISO8859_2", "ISO-8859-2", new String[] { "ISO_8859-2:1987", "iso-ir-101", "ISO_8859-2", "latin2", "l2", "csISOLatin2", "8859_2", "iso8859_2" }), new ihc("ISO8859_3", "ISO-8859-3", new String[] { "ISO_8859-3:1988", "iso-ir-109", "ISO_8859-3", "latin3", "l3", "csISOLatin3", "8859_3" }), new ihc("ISO8859_4", "ISO-8859-4", new String[] { "ISO_8859-4:1988", "iso-ir-110", "ISO_8859-4", "latin4", "l4", "csISOLatin4", "8859_4" }), new ihc("ISO8859_5", "ISO-8859-5", new String[] { "ISO_8859-5:1988", "iso-ir-144", "ISO_8859-5", "cyrillic", "csISOLatinCyrillic", "8859_5" }), new ihc("ISO8859_6", "ISO-8859-6", new String[] { "ISO_8859-6:1987", "iso-ir-127", "ISO_8859-6", "ECMA-114", "ASMO-708", "arabic", "csISOLatinArabic", "8859_6" }), new ihc("ISO8859_7", "ISO-8859-7", new String[] { "ISO_8859-7:1987", "iso-ir-126", "ISO_8859-7", "ELOT_928", "ECMA-118", "greek", "greek8", "csISOLatinGreek", "8859_7", "sun_eu_greek" }), new ihc("ISO8859_8", "ISO-8859-8", new String[] { "ISO_8859-8:1988", "iso-ir-138", "ISO_8859-8", "hebrew", "csISOLatinHebrew", "8859_8" }), new ihc("ISO8859_9", "ISO-8859-9", new String[] { "ISO_8859-9:1989", "iso-ir-148", "ISO_8859-9", "latin5", "l5", "csISOLatin5", "8859_9" }), new ihc("ISO8859_13", "ISO-8859-13", new String[0]), new ihc("ISO8859_15", "ISO-8859-15", new String[] { "ISO_8859-15", "Latin-9", "8859_15", "csISOlatin9", "IBM923", "cp923", "923", "L9", "IBM-923", "ISO8859-15", "LATIN9", "LATIN0", "csISOlatin0", "ISO8859_15_FDIS" }), new ihc("KOI8_R", "KOI8-R", new String[] { "csKOI8R", "koi8" }), new ihc("ASCII", "US-ASCII", new String[] { "ANSI_X3.4-1968", "iso-ir-6", "ANSI_X3.4-1986", "ISO_646.irv:1991", "ISO646-US", "us", "IBM367", "cp367", "csASCII", "ascii7", "646", "iso_646.irv:1983" }), new ihc("UTF8", "UTF-8", new String[0]), new ihc("UTF-16", "UTF-16", new String[] { "UTF_16" }), new ihc("UnicodeBigUnmarked", "UTF-16BE", new String[] { "X-UTF-16BE", "UTF_16BE", "ISO-10646-UCS-2" }), new ihc("UnicodeLittleUnmarked", "UTF-16LE", new String[] { "UTF_16LE", "X-UTF-16LE" }), new ihc("Big5", "Big5", new String[] { "csBig5", "CN-Big5", "BIG-FIVE", "BIGFIVE" }), new ihc("Big5_HKSCS", "Big5-HKSCS", new String[] { "big5hkscs" }), new ihc("EUC_JP", "EUC-JP", new String[] { "csEUCPkdFmtJapanese", "Extended_UNIX_Code_Packed_Format_for_Japanese", "eucjis", "x-eucjp", "eucjp", "x-euc-jp" }), new ihc("EUC_KR", "EUC-KR", new String[] { "csEUCKR", "ksc5601", "5601", "ksc5601_1987", "ksc_5601", "ksc5601-1987", "ks_c_5601-1987", "euckr" }), new ihc("GB18030", "GB18030", new String[] { "gb18030-2000" }), new ihc("EUC_CN", "GB2312", new String[] { "x-EUC-CN", "csGB2312", "euccn", "euc-cn", "gb2312-80", "gb2312-1980", "CN-GB", "CN-GB-ISOIR165" }), new ihc("GBK", "windows-936", new String[] { "CP936", "MS936", "ms_936", "x-mswin-936" }), new ihc("Cp037", "IBM037", new String[] { "ebcdic-cp-us", "ebcdic-cp-ca", "ebcdic-cp-wt", "ebcdic-cp-nl", "csIBM037" }), new ihc("Cp273", "IBM273", new String[] { "csIBM273" }), new ihc("Cp277", "IBM277", new String[] { "EBCDIC-CP-DK", "EBCDIC-CP-NO", "csIBM277" }), new ihc("Cp278", "IBM278", new String[] { "CP278", "ebcdic-cp-fi", "ebcdic-cp-se", "csIBM278" }), new ihc("Cp280", "IBM280", new String[] { "ebcdic-cp-it", "csIBM280" }), new ihc("Cp284", "IBM284", new String[] { "ebcdic-cp-es", "csIBM284" }), new ihc("Cp285", "IBM285", new String[] { "ebcdic-cp-gb", "csIBM285" }), new ihc("Cp297", "IBM297", new String[] { "ebcdic-cp-fr", "csIBM297" }), new ihc("Cp420", "IBM420", new String[] { "ebcdic-cp-ar1", "csIBM420" }), new ihc("Cp424", "IBM424", new String[] { "ebcdic-cp-he", "csIBM424" }), new ihc("Cp437", "IBM437", new String[] { "437", "csPC8CodePage437" }), new ihc("Cp500", "IBM500", new String[] { "ebcdic-cp-be", "ebcdic-cp-ch", "csIBM500" }), new ihc("Cp775", "IBM775", new String[] { "csPC775Baltic" }), new ihc("Cp838", "IBM-Thai", new String[0]), new ihc("Cp850", "IBM850", new String[] { "850", "csPC850Multilingual" }), new ihc("Cp852", "IBM852", new String[] { "852", "csPCp852" }), new ihc("Cp855", "IBM855", new String[] { "855", "csIBM855" }), new ihc("Cp857", "IBM857", new String[] { "857", "csIBM857" }), new ihc("Cp858", "IBM00858", new String[] { "CCSID00858", "CP00858", "PC-Multilingual-850+euro" }), new ihc("Cp860", "IBM860", new String[] { "860", "csIBM860" }), new ihc("Cp861", "IBM861", new String[] { "861", "cp-is", "csIBM861" }), new ihc("Cp862", "IBM862", new String[] { "862", "csPC862LatinHebrew" }), new ihc("Cp863", "IBM863", new String[] { "863", "csIBM863" }), new ihc("Cp864", "IBM864", new String[] { "cp864", "csIBM864" }), new ihc("Cp865", "IBM865", new String[] { "865", "csIBM865" }), new ihc("Cp866", "IBM866", new String[] { "866", "csIBM866" }), new ihc("Cp868", "IBM868", new String[] { "cp-ar", "csIBM868" }), new ihc("Cp869", "IBM869", new String[] { "cp-gr", "csIBM869" }), new ihc("Cp870", "IBM870", new String[] { "ebcdic-cp-roece", "ebcdic-cp-yu", "csIBM870" }), new ihc("Cp871", "IBM871", new String[] { "ebcdic-cp-is", "csIBM871" }), new ihc("Cp918", "IBM918", new String[] { "ebcdic-cp-ar2", "csIBM918" }), new ihc("Cp1026", "IBM1026", new String[] { "csIBM1026" }), new ihc("Cp1047", "IBM1047", new String[] { "IBM-1047" }), new ihc("Cp1140", "IBM01140", new String[] { "CCSID01140", "CP01140", "ebcdic-us-37+euro" }), new ihc("Cp1141", "IBM01141", new String[] { "CCSID01141", "CP01141", "ebcdic-de-273+euro" }), new ihc("Cp1142", "IBM01142", new String[] { "CCSID01142", "CP01142", "ebcdic-dk-277+euro", "ebcdic-no-277+euro" }), new ihc("Cp1143", "IBM01143", new String[] { "CCSID01143", "CP01143", "ebcdic-fi-278+euro", "ebcdic-se-278+euro" }), new ihc("Cp1144", "IBM01144", new String[] { "CCSID01144", "CP01144", "ebcdic-it-280+euro" }), new ihc("Cp1145", "IBM01145", new String[] { "CCSID01145", "CP01145", "ebcdic-es-284+euro" }), new ihc("Cp1146", "IBM01146", new String[] { "CCSID01146", "CP01146", "ebcdic-gb-285+euro" }), new ihc("Cp1147", "IBM01147", new String[] { "CCSID01147", "CP01147", "ebcdic-fr-297+euro" }), new ihc("Cp1148", "IBM01148", new String[] { "CCSID01148", "CP01148", "ebcdic-international-500+euro" }), new ihc("Cp1149", "IBM01149", new String[] { "CCSID01149", "CP01149", "ebcdic-is-871+euro" }), new ihc("Cp1250", "windows-1250", new String[0]), new ihc("Cp1251", "windows-1251", new String[0]), new ihc("Cp1252", "windows-1252", new String[0]), new ihc("Cp1253", "windows-1253", new String[0]), new ihc("Cp1254", "windows-1254", new String[0]), new ihc("Cp1255", "windows-1255", new String[0]), new ihc("Cp1256", "windows-1256", new String[0]), new ihc("Cp1257", "windows-1257", new String[0]), new ihc("Cp1258", "windows-1258", new String[0]), new ihc("ISO2022CN", "ISO-2022-CN", new String[0]), new ihc("ISO2022JP", "ISO-2022-JP", new String[] { "csISO2022JP", "JIS", "jis_encoding", "csjisencoding" }), new ihc("ISO2022KR", "ISO-2022-KR", new String[] { "csISO2022KR" }), new ihc("JIS_X0201", "JIS_X0201", new String[] { "X0201", "JIS0201", "csHalfWidthKatakana" }), new ihc("JIS_X0212-1990", "JIS_X0212-1990", new String[] { "iso-ir-159", "x0212", "JIS0212", "csISO159JISX02121990" }), new ihc("JIS_C6626-1983", "JIS_C6626-1983", new String[] { "x-JIS0208", "JIS0208", "csISO87JISX0208", "x0208", "JIS_X0208-1983", "iso-ir-87" }), new ihc("SJIS", "Shift_JIS", new String[] { "MS_Kanji", "csShiftJIS", "shift-jis", "x-sjis", "pck" }), new ihc("TIS620", "TIS-620", new String[0]), new ihc("MS932", "Windows-31J", new String[] { "windows-932", "csWindows31J", "x-ms-cp932" }), new ihc("EUC_TW", "EUC-TW", new String[] { "x-EUC-TW", "cns11643", "euctw" }), new ihc("x-Johab", "johab", new String[] { "johab", "cp1361", "ms1361", "ksc5601-1992", "ksc5601_1992" }), new ihc("MS950_HKSCS", "", new String[0]), new ihc("MS874", "windows-874", new String[] { "cp874" }), new ihc("MS949", "windows-949", new String[] { "windows949", "ms_949", "x-windows-949" }), new ihc("MS950", "windows-950", new String[] { "x-windows-950" }), new ihc("Cp737", null, new String[0]), new ihc("Cp856", null, new String[0]), new ihc("Cp875", null, new String[0]), new ihc("Cp921", null, new String[0]), new ihc("Cp922", null, new String[0]), new ihc("Cp930", null, new String[0]), new ihc("Cp933", null, new String[0]), new ihc("Cp935", null, new String[0]), new ihc("Cp937", null, new String[0]), new ihc("Cp939", null, new String[0]), new ihc("Cp942", null, new String[0]), new ihc("Cp942C", null, new String[0]), new ihc("Cp943", null, new String[0]), new ihc("Cp943C", null, new String[0]), new ihc("Cp948", null, new String[0]), new ihc("Cp949", null, new String[0]), new ihc("Cp949C", null, new String[0]), new ihc("Cp950", null, new String[0]), new ihc("Cp964", null, new String[0]), new ihc("Cp970", null, new String[0]), new ihc("Cp1006", null, new String[0]), new ihc("Cp1025", null, new String[0]), new ihc("Cp1046", null, new String[0]), new ihc("Cp1097", null, new String[0]), new ihc("Cp1098", null, new String[0]), new ihc("Cp1112", null, new String[0]), new ihc("Cp1122", null, new String[0]), new ihc("Cp1123", null, new String[0]), new ihc("Cp1124", null, new String[0]), new ihc("Cp1381", null, new String[0]), new ihc("Cp1383", null, new String[0]), new ihc("Cp33722", null, new String[0]), new ihc("Big5_Solaris", null, new String[0]), new ihc("EUC_JP_LINUX", null, new String[0]), new ihc("EUC_JP_Solaris", null, new String[0]), new ihc("ISCII91", null, new String[] { "x-ISCII91", "iscii" }), new ihc("ISO2022_CN_CNS", null, new String[0]), new ihc("ISO2022_CN_GB", null, new String[0]), new ihc("x-iso-8859-11", null, new String[0]), new ihc("JISAutoDetect", null, new String[0]), new ihc("MacArabic", null, new String[0]), new ihc("MacCentralEurope", null, new String[0]), new ihc("MacCroatian", null, new String[0]), new ihc("MacCyrillic", null, new String[0]), new ihc("MacDingbat", null, new String[0]), new ihc("MacGreek", "MacGreek", new String[0]), new ihc("MacHebrew", null, new String[0]), new ihc("MacIceland", null, new String[0]), new ihc("MacRoman", "MacRoman", new String[] { "Macintosh", "MAC", "csMacintosh" }), new ihc("MacRomania", null, new String[0]), new ihc("MacSymbol", null, new String[0]), new ihc("MacThai", null, new String[0]), new ihc("MacTurkish", null, new String[0]), new ihc("MacUkraine", null, new String[0]), new ihc("UnicodeBig", null, new String[0]), new ihc("UnicodeLittle", null, new String[0]) };
  private static TreeSet<String> h;
  
  static
  {
    a = null;
    h = null;
    b = null;
    a = new TreeSet();
    h = new TreeSet();
    int i = 0;
    for (;;)
    {
      if (i < g.length) {}
      try
      {
        Object localObject = ga;
        new String(new byte[] { 100, 117, 109, 109, 121 }, (String)localObject);
        a.add(ga.toLowerCase(Locale.US));
        try
        {
          "dummy".getBytes(ga);
          h.add(ga.toLowerCase(Locale.US));
          i += 1;
          continue;
          b = new HashMap();
          i = 0;
          while (i < g.length)
          {
            localObject = g[i];
            b.put(a.toLowerCase(Locale.US), localObject);
            if (b != null) {
              b.put(b.toLowerCase(Locale.US), localObject);
            }
            if (c != null)
            {
              int j = 0;
              while (j < c.length)
              {
                b.put(c[j].toLowerCase(Locale.US), localObject);
                j += 1;
              }
            }
            i += 1;
          }
          idy.a();
          c = Charset.forName("US-ASCII");
          d = Charset.forName("ISO-8859-1");
          e = Charset.forName("UTF-8");
          return;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException1)
        {
          for (;;) {}
        }
        catch (UnsupportedOperationException localUnsupportedOperationException1)
        {
          for (;;) {}
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        for (;;) {}
      }
      catch (UnsupportedOperationException localUnsupportedOperationException2)
      {
        for (;;) {}
      }
    }
  }
  
  public static boolean a(char paramChar)
  {
    return (paramChar == ' ') || (paramChar == '\t') || (paramChar == '\r') || (paramChar == '\n');
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("String may not be null");
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!a(paramString.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    paramString = (ihc)b.get(paramString.toLowerCase(Locale.US));
    if (paramString != null) {
      return a;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     ihb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */