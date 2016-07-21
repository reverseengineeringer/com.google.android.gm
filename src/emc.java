import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class emc
{
  public final Account a;
  public final Set<Scope> b;
  public final Set<Scope> c;
  public final Map<eip<?>, emd> d;
  public final String e;
  final String f;
  public final gcd g;
  public Integer h;
  private final int i;
  private final View j;
  
  public emc(Account paramAccount, Set<Scope> paramSet, Map<eip<?>, emd> paramMap, int paramInt, View paramView, String paramString1, String paramString2, gcd paramgcd)
  {
    a = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      b = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      d = paramAccount;
      j = paramView;
      i = paramInt;
      e = paramString1;
      f = paramString2;
      g = paramgcd;
      paramAccount = new HashSet(b);
      paramSet = d.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(nexta);
      }
    }
    c = Collections.unmodifiableSet(paramAccount);
  }
}

/* Location:
 * Qualified Name:     emc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */