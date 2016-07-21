import java.util.Locale;

public class dtf
  extends Exception
{
  public dtf(int paramInt1, int paramInt2)
  {
    super(String.format(Locale.ENGLISH, "Sync count (%d) exceeds limit (%d syncs per %d seconds", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(120) }));
    dri.d(drp.b, this, "Too many sync loops, sync will be silently cancelled", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     dtf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */