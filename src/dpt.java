import java.util.HashSet;
import java.util.Set;

public final class dpt
{
  final Set<Long> a = new HashSet();
  final Set<Long> b = new HashSet();
  
  public final boolean a(boolean paramBoolean, Long paramLong)
  {
    if (paramBoolean) {
      return a.add(paramLong);
    }
    return b.add(paramLong);
  }
}

/* Location:
 * Qualified Name:     dpt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */