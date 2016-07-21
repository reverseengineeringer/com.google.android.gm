import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

public final class ick
  extends icl
{
  public final ics a(hyw paramhyw)
  {
    if (hyw.e.equals(paramhyw)) {
      return new icz();
    }
    if (hyw.f.equals(paramhyw)) {
      return new icw();
    }
    throw new UnsupportedEncodingException(MessageFormat.format("Encoder not available for encoding [{0}]", new Object[] { paramhyw }));
  }
}

/* Location:
 * Qualified Name:     ick
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */