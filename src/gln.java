import android.app.Application;

public final class gln
  implements gjq
{
  private final Application a;
  private final gna b;
  private final gnf c;
  private final glo d;
  
  public gln(Application paramApplication, gna paramgna, glo paramglo)
  {
    a = ((Application)gol.a(paramApplication));
    b = paramgna;
    c = null;
    d = ((glo)gol.a(paramglo));
  }
  
  public final gli a()
  {
    if (b != null) {
      return new glj(a, b, d, gmk.a);
    }
    if (c != null) {
      return glj.a(a, c, d);
    }
    throw new IllegalStateException("Transmitter or transmitter provider is not defined.");
  }
}

/* Location:
 * Qualified Name:     gln
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */