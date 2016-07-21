import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.text.MessageFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class hrp
  implements hrn
{
  Log a = LogFactory.getLog(hrp.class);
  final hrr b = new hrr(this);
  final hru c = new hru(this);
  final hrv d = new hrv(this);
  final hrs e = new hrs(this);
  final hrt f = new hrt(this);
  private final hrq g = new hrq(this);
  
  static int a(StreamTokenizer paramStreamTokenizer, Reader paramReader)
  {
    int j = paramStreamTokenizer.lineno();
    int i = j;
    if (ttype == 10) {
      i = j - 1;
    }
    j = i;
    if ((paramReader instanceof hrz)) {
      j = i + a;
    }
    return j;
  }
  
  private final void a(StreamTokenizer paramStreamTokenizer, Reader paramReader, String paramString, boolean paramBoolean)
  {
    a(paramStreamTokenizer, paramReader, -3);
    if (paramBoolean)
    {
      if (!paramString.equalsIgnoreCase(sval)) {
        throw new hry(MessageFormat.format("Expected [{0}], read [{1}]", new Object[] { paramString, sval }), a(paramStreamTokenizer, paramReader));
      }
    }
    else if (!paramString.equals(sval)) {
      throw new hry(MessageFormat.format("Expected [{0}], read [{1}]", new Object[] { paramString, sval }), a(paramStreamTokenizer, paramReader));
    }
    if (a.isDebugEnabled()) {
      a.debug(String.valueOf(paramString).length() + 2 + "[" + paramString + "]");
    }
  }
  
  static int b(StreamTokenizer paramStreamTokenizer, Reader paramReader)
  {
    int i = paramStreamTokenizer.nextToken();
    if (i == -1) {
      throw new hry("Unexpected end of file", a(paramStreamTokenizer, paramReader));
    }
    return i;
  }
  
  public final void a(Reader paramReader, hrw paramhrw)
  {
    StreamTokenizer localStreamTokenizer = new StreamTokenizer(paramReader);
    try
    {
      localStreamTokenizer.resetSyntax();
      localStreamTokenizer.wordChars(32, 255);
      localStreamTokenizer.whitespaceChars(0, 20);
      localStreamTokenizer.ordinaryChar(58);
      localStreamTokenizer.ordinaryChar(59);
      localStreamTokenizer.ordinaryChar(61);
      localStreamTokenizer.ordinaryChar(9);
      localStreamTokenizer.eolIsSignificant(true);
      localStreamTokenizer.whitespaceChars(0, 0);
      localStreamTokenizer.quoteChar(34);
      a(localStreamTokenizer, paramReader, "BEGIN");
      a(localStreamTokenizer, paramReader, 58);
      a(localStreamTokenizer, paramReader, "VCALENDAR", true);
      a(localStreamTokenizer, paramReader, 10);
      paramhrw.c();
      c.a(localStreamTokenizer, paramReader, paramhrw);
      g.a(localStreamTokenizer, paramReader, paramhrw);
      a(localStreamTokenizer, paramReader, 58);
      a(localStreamTokenizer, paramReader, "VCALENDAR", true);
      return;
    }
    catch (Exception paramhrw)
    {
      if ((paramhrw instanceof IOException)) {
        throw ((IOException)paramhrw);
      }
      if ((paramhrw instanceof hry)) {
        throw ((hry)paramhrw);
      }
      throw new hry(paramhrw.getMessage(), a(localStreamTokenizer, paramReader), paramhrw);
    }
  }
  
  final void a(StreamTokenizer paramStreamTokenizer, Reader paramReader, int paramInt)
  {
    if (b(paramStreamTokenizer, paramReader) != paramInt) {
      throw new hry(MessageFormat.format("Expected [{0}], read [{1}]", new Object[] { new Integer(paramInt), new Integer(ttype) }), a(paramStreamTokenizer, paramReader));
    }
    if (a.isDebugEnabled()) {
      a.debug(13 + "[" + paramInt + "]");
    }
  }
  
  final void a(StreamTokenizer paramStreamTokenizer, Reader paramReader, String paramString)
  {
    a(paramStreamTokenizer, paramReader, paramString, false);
  }
}

/* Location:
 * Qualified Name:     hrp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */