import java.util.List;
import java.util.RandomAccess;

final class hci
  extends hcn
  implements RandomAccess
{
  hci(K paramK, List<V> paramList, hcl paramhcl)
  {
    super(paramK, paramList, paramhcl, localhcl);
  }
}

/* Location:
 * Qualified Name:     hci
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */