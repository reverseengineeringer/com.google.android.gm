import android.accounts.Account;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class ehf
  extends Filter
{
  public ehf(ehe paramehe) {}
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    if (Log.isLoggable("GmsRecipientAdapter", 3))
    {
      localObject1 = String.valueOf(paramCharSequence);
      localObject2 = String.valueOf(Thread.currentThread());
      new StringBuilder(String.valueOf(localObject1).length() + 38 + String.valueOf(localObject2).length()).append("start filtering. constraint: ").append((String)localObject1).append(", thread:").append((String)localObject2);
    }
    Object localObject1 = new Filter.FilterResults();
    if ((!a.r.e()) || (TextUtils.isEmpty(paramCharSequence)))
    {
      a.j = null;
      return (Filter.FilterResults)localObject1;
    }
    if (!big.a(a.c, a.o))
    {
      a.j = null;
      if (!a.n) {
        return (Filter.FilterResults)localObject1;
      }
      paramCharSequence = bkn.a(big.a);
      values = new ehg(a, Collections.singletonList(paramCharSequence), Collections.emptySet(), null);
      count = 1;
      return (Filter.FilterResults)localObject1;
    }
    Object localObject2 = new fqx();
    b = a.d.name;
    h = true;
    localObject2 = ((fqx)localObject2).a();
    paramCharSequence = (fqy)frm.i.a(a.r, paramCharSequence.toString(), (fqw)localObject2).a(5L, TimeUnit.SECONDS);
    localObject2 = paramCharSequence.a();
    int i = g;
    paramCharSequence = paramCharSequence.c();
    Object localObject3;
    Object localObject4;
    try
    {
      if (Log.isLoggable("GmsRecipientAdapter", 3))
      {
        localObject3 = String.valueOf(localObject2);
        localObject4 = String.valueOf(paramCharSequence);
        new StringBuilder(String.valueOf(localObject3).length() + 39 + String.valueOf(localObject4).length()).append("Autocomplete list loaded: status=").append((String)localObject3).append(" list=").append((String)localObject4);
      }
      if ((!((Status)localObject2).b()) || (paramCharSequence == null))
      {
        a.j = null;
        return (Filter.FilterResults)localObject1;
      }
      localObject2 = new ArrayList();
      localObject3 = new HashSet();
      localObject4 = a.m;
      Iterator localIterator = paramCharSequence.iterator();
      while (localIterator.hasNext())
      {
        Object localObject5 = (fxz)localIterator.next();
        String str = ((fxz)localObject5).i();
        if (!((Set)localObject3).contains(str))
        {
          ((Set)localObject3).add(str);
          localObject5 = new ehh((fxz)localObject5);
          ((List)localObject2).add(localObject5);
          ((biv)localObject4).a((bkn)localObject5, a);
        }
      }
      localObject4 = a.a((Set)localObject3);
    }
    finally
    {
      if (paramCharSequence != null) {
        paramCharSequence.d();
      }
    }
    values = new ehg(a, (List)localObject2, (Set)localObject3, (List)localObject4);
    count = ((List)localObject2).size();
    if (paramCharSequence != null) {
      paramCharSequence.d();
    }
    return localFilterResults;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    a.l = paramCharSequence;
    a.j = null;
    if (values != null)
    {
      paramFilterResults = (ehg)values;
      a.s = a;
      a.t = b;
      ehe localehe = a;
      int j = a.size();
      if (c == null) {}
      for (int i = 0;; i = c.size())
      {
        localehe.a(j, i);
        a.a(a);
        if (c != null)
        {
          i = a.e;
          j = b.size();
          a.a(paramCharSequence, c, i - j);
        }
        return;
      }
    }
    a.a(Collections.emptyList());
  }
}

/* Location:
 * Qualified Name:     ehf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */