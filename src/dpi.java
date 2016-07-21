import java.util.Locale;

final class dpi
{
  final long a;
  final long b;
  final int c;
  final int d;
  
  dpi(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    a = paramLong1;
    b = paramLong2;
    c = paramInt1;
    d = paramInt2;
  }
  
  public final String toString()
  {
    return String.format(Locale.ENGLISH, "id: %d, status: %d, size: %d", new Object[] { Long.valueOf(a), Integer.valueOf(c), Long.valueOf(b) });
  }
}

/* Location:
 * Qualified Name:     dpi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */