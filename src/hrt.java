import java.io.Reader;
import java.io.StreamTokenizer;
import org.apache.commons.logging.Log;

final class hrt
{
  hrt(hrp paramhrp) {}
  
  final void a(StreamTokenizer paramStreamTokenizer, Reader paramReader, hrw paramhrw)
  {
    a.a(paramStreamTokenizer, paramReader, -3);
    String str = sval;
    if (a.a.isDebugEnabled()) {
      a.a.debug(String.valueOf(str).length() + 12 + "Parameter [" + str + "]");
    }
    a.a(paramStreamTokenizer, paramReader, 61);
    StringBuffer localStringBuffer = new StringBuffer();
    if (hrp.b(paramStreamTokenizer, paramReader) == 34)
    {
      localStringBuffer.append('"');
      localStringBuffer.append(sval);
      localStringBuffer.append('"');
    }
    for (;;)
    {
      try
      {
        paramhrw.a(str, localStringBuffer.toString());
        return;
      }
      catch (ClassCastException paramhrw)
      {
        int i;
        throw new hry("Error parsing parameter", hrp.a(paramStreamTokenizer, paramReader), paramhrw);
      }
      if (sval != null)
      {
        localStringBuffer.append(sval);
        i = hrp.b(paramStreamTokenizer, paramReader);
        if ((i != 59) && (i != 58) && (i != 44))
        {
          if (ttype == -3)
          {
            localStringBuffer.append(sval);
            i = hrp.b(paramStreamTokenizer, paramReader);
          }
          else
          {
            localStringBuffer.append((char)ttype);
          }
        }
        else {
          paramStreamTokenizer.pushBack();
        }
      }
      else if (sval == null)
      {
        paramStreamTokenizer.pushBack();
      }
    }
  }
}

/* Location:
 * Qualified Name:     hrt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */