import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.List;

abstract class cyx
  extends Charset
{
  private static final List a = Arrays.asList(new String[] { "US-ASCII", "ISO-8859-1", "UTF-8", "UTF-16", "UTF-16LE", "UTF-16BE" });
  final boolean b;
  cyt c;
  
  protected cyx(String paramString1, String[] paramArrayOfString, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramArrayOfString);
    c = new cyt(paramString2);
    b = paramBoolean;
  }
  
  abstract byte a();
  
  abstract boolean a(char paramChar);
  
  abstract byte b();
  
  public boolean contains(Charset paramCharset)
  {
    return a.contains(paramCharset.name());
  }
  
  public CharsetDecoder newDecoder()
  {
    return new cyy(this, c, b);
  }
  
  public CharsetEncoder newEncoder()
  {
    return new cyz(this, c, b);
  }
}

/* Location:
 * Qualified Name:     cyx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */