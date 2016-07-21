import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public final class dxs
  implements Comparator<cdi>
{
  private final hia<Iterable<String>> a;
  private final dxt b;
  
  public dxs(Locale paramLocale, dxt paramdxt)
  {
    paramLocale = Collator.getInstance(paramLocale);
    paramLocale.setStrength(3);
    a = new hgc(hia.a(paramLocale));
    b = paramdxt;
  }
}

/* Location:
 * Qualified Name:     dxs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */