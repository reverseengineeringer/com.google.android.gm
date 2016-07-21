import android.accounts.Account;
import android.content.Context;
import android.text.util.Rfc822Token;
import android.text.util.Rfc822Tokenizer;
import android.util.Log;
import android.widget.Filter;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class ehe
  extends bhx
{
  final eiz r;
  List<bkn> s;
  Set<String> t;
  
  public ehe(Context paramContext, Account paramAccount, eiz parameiz, ehc paramehc)
  {
    super(paramContext);
    d = paramAccount;
    r = parameiz;
    m = paramehc;
  }
  
  protected final void a(bif parambif, boolean paramBoolean)
  {
    if ((s.size() >= e) || (t.contains(b))) {
      return;
    }
    t.add(b);
    parambif = bkn.a(a, i, b, c, d, e, f, g, h, j);
    s.add(parambif);
    m.a(parambif, this);
  }
  
  public final void a(ArrayList<String> paramArrayList, bjm parambjm)
  {
    int j = Math.min(50, paramArrayList.size());
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    if (i < j)
    {
      localObject1 = Rfc822Tokenizer.tokenize(((String)paramArrayList.get(i)).toLowerCase());
      if (localObject1.length > 0) {}
      for (localObject1 = localObject1[0].getAddress();; localObject1 = (String)paramArrayList.get(i))
      {
        localHashSet.add(localObject1);
        i += 1;
        break;
      }
    }
    if (Log.isLoggable("GmsRecipientAdapter", 3))
    {
      paramArrayList = String.valueOf(localHashSet.toString());
      if (paramArrayList.length() == 0) {
        break label401;
      }
      "Doing reverse lookup for ".concat(paramArrayList);
    }
    for (;;)
    {
      paramArrayList = new HashMap();
      localObject1 = d;
      localObject2 = new fqx();
      b = name;
      e = 1;
      h = true;
      localObject2 = ((fqx)localObject2).a();
      Iterator localIterator = localHashSet.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (String)localIterator.next();
        Object localObject4 = (fqy)frm.i.a(r, (String)localObject3, (fqw)localObject2).a(5L, TimeUnit.SECONDS);
        localObject3 = ((fqy)localObject4).a();
        localObject4 = ((fqy)localObject4).c();
        if (Log.isLoggable("GmsRecipientAdapter", 3))
        {
          String str1 = String.valueOf(localObject3);
          String str2 = String.valueOf(localObject4);
          new StringBuilder(String.valueOf(str1).length() + 39 + String.valueOf(str2).length()).append("Autocomplete list loaded: status=").append(str1).append(" list=").append(str2);
        }
        i = g;
        if ((((Status)localObject3).b()) && (localObject4 != null) && (((eli)localObject4).c() > 0))
        {
          localObject3 = (fxz)((eli)localObject4).a(0);
          paramArrayList.put(((fxz)localObject3).i(), new ehh((fxz)localObject3));
        }
        if (localObject4 != null) {
          ((eli)localObject4).d();
        }
      }
      label401:
      new String("Doing reverse lookup for ");
    }
    parambjm.a(paramArrayList);
    Object localObject2 = new HashSet();
    bjk.a(c, paramArrayList, localHashSet, (Account)localObject1, (Set)localObject2, parambjm, o);
    bjk.a((Set)localObject2, parambjm);
  }
  
  public final boolean a()
  {
    return true;
  }
  
  protected final List<bkn> b()
  {
    return s;
  }
  
  public final Filter getFilter()
  {
    return new ehf(this);
  }
}

/* Location:
 * Qualified Name:     ehe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */