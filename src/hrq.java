import java.io.Reader;
import java.io.StreamTokenizer;
import org.apache.commons.logging.Log;

final class hrq
{
  hrq(hrp paramhrp) {}
  
  final void a(StreamTokenizer paramStreamTokenizer, Reader paramReader, hrw paramhrw)
  {
    while ("BEGIN".equals(sval))
    {
      Object localObject = a.b;
      a.a(paramStreamTokenizer, paramReader, 58);
      a.a(paramStreamTokenizer, paramReader, -3);
      String str = sval;
      paramhrw.b(str);
      a.a(paramStreamTokenizer, paramReader, 10);
      a.c.a(paramStreamTokenizer, paramReader, paramhrw);
      a.a(paramStreamTokenizer, paramReader, 58);
      a.a(paramStreamTokenizer, paramReader, str);
      a.a(paramStreamTokenizer, paramReader, 10);
      paramhrw.a();
      localObject = a;
      while (hrp.b(paramStreamTokenizer, paramReader) == 10) {
        if (a.isTraceEnabled()) {
          a.trace("Absorbing extra whitespace..");
        }
      }
      if (a.isTraceEnabled()) {
        a.trace("Aborting: absorbing extra whitespace complete");
      }
    }
  }
}

/* Location:
 * Qualified Name:     hrq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */