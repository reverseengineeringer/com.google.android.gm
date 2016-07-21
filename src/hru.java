import java.io.Reader;
import java.io.StreamTokenizer;
import java.text.MessageFormat;
import java.text.ParseException;
import org.apache.commons.logging.Log;

final class hru
{
  hru(hrp paramhrp) {}
  
  public final void a(StreamTokenizer paramStreamTokenizer, Reader paramReader, hrw paramhrw)
  {
    a.a(paramStreamTokenizer, paramReader, -3);
    while (!"END".equals(sval))
    {
      Object localObject1;
      Object localObject2;
      if ("BEGIN".equals(sval))
      {
        localObject1 = a.b;
        a.a(paramStreamTokenizer, paramReader, 58);
        a.a(paramStreamTokenizer, paramReader, -3);
        localObject2 = sval;
        paramhrw.b((String)localObject2);
        a.a(paramStreamTokenizer, paramReader, 10);
        a.c.a(paramStreamTokenizer, paramReader, paramhrw);
        a.a(paramStreamTokenizer, paramReader, 58);
        a.a(paramStreamTokenizer, paramReader, (String)localObject2);
        a.a(paramStreamTokenizer, paramReader, 10);
        paramhrw.a();
      }
      for (;;)
      {
        localObject1 = a;
        while (hrp.b(paramStreamTokenizer, paramReader) == 10) {
          if (a.isTraceEnabled())
          {
            a.trace("Absorbing extra whitespace..");
            continue;
            localObject2 = a.d;
            localObject1 = sval;
            if (a.a.isDebugEnabled()) {
              a.a.debug(MessageFormat.format("Property [{0}]", new Object[] { localObject1 }));
            }
            paramhrw.c((String)localObject1);
            localObject2 = a.e;
            while (hrp.b(paramStreamTokenizer, paramReader) == 59) {
              a.f.a(paramStreamTokenizer, paramReader, paramhrw);
            }
            localObject2 = new StringBuffer();
            paramStreamTokenizer.ordinaryChar(34);
            int i = hrp.b(paramStreamTokenizer, paramReader);
            if (i != 10)
            {
              if (ttype == -3) {
                ((StringBuffer)localObject2).append(sval);
              }
              for (;;)
              {
                i = hrp.b(paramStreamTokenizer, paramReader);
                break;
                ((StringBuffer)localObject2).append((char)ttype);
              }
            }
            paramStreamTokenizer.quoteChar(34);
            try
            {
              paramhrw.a(((StringBuffer)localObject2).toString());
              paramhrw.b();
            }
            catch (ParseException paramStreamTokenizer)
            {
              paramReader = String.valueOf(paramStreamTokenizer.getMessage());
              paramReader = new ParseException(String.valueOf(localObject1).length() + 3 + String.valueOf(paramReader).length() + "[" + (String)localObject1 + "] " + paramReader, paramStreamTokenizer.getErrorOffset());
              paramReader.initCause(paramStreamTokenizer);
              throw paramReader;
            }
          }
        }
      }
      if (a.isTraceEnabled()) {
        a.trace("Aborting: absorbing extra whitespace complete");
      }
    }
  }
}

/* Location:
 * Qualified Name:     hru
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */