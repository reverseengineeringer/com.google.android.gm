import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

public final class icj
  extends ici
{
  public final icr a(hyw paramhyw)
  {
    if (hyw.e.equals(paramhyw)) {
      return new icz();
    }
    if (hyw.f.equals(paramhyw)) {
      return new icw();
    }
    throw new UnsupportedEncodingException(MessageFormat.format("Decoder not available for encoding [{0}]", new Object[] { paramhyw }));
  }
}

/* Location:
 * Qualified Name:     icj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */