import android.database.Cursor;
import android.text.TextUtils;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Iterator;

public final class bib
  extends Filter
{
  private final bid b;
  private int c;
  
  public bib(bhx parambhx, bid parambid)
  {
    b = parambid;
  }
  
  private final int a()
  {
    try
    {
      int i = c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(int paramInt)
  {
    try
    {
      c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    CharSequence localCharSequence = null;
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    values = null;
    count = 0;
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        paramCharSequence = a.a(paramCharSequence, a(), Long.valueOf(b.a));
        if (paramCharSequence != null) {
          for (;;)
          {
            localCharSequence = paramCharSequence;
            if (!paramCharSequence.moveToNext()) {
              break;
            }
            localCharSequence = paramCharSequence;
            localArrayList.add(new bif(paramCharSequence, Long.valueOf(b.a)));
          }
        }
        if (paramCharSequence == null) {
          break label126;
        }
      }
      finally
      {
        if (localCharSequence != null) {
          localCharSequence.close();
        }
      }
      paramCharSequence.close();
      label126:
      if (!localArrayList.isEmpty())
      {
        values = localArrayList;
        count = localArrayList.size();
      }
    }
    return localFilterResults;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    a.p.removeMessages(1);
    if (TextUtils.equals(paramCharSequence, a.l))
    {
      if (count > 0)
      {
        paramCharSequence = ((ArrayList)values).iterator();
        if (paramCharSequence.hasNext())
        {
          bif localbif = (bif)paramCharSequence.next();
          bhx localbhx = a;
          if (b.a == 0L) {}
          for (boolean bool = true;; bool = false)
          {
            localbhx.a(localbif, bool);
            break;
          }
        }
      }
      paramCharSequence = a;
      k -= 1;
      if (a.k > 0) {
        a.p.a();
      }
      if ((count > 0) || (a.k == 0)) {
        a.j = null;
      }
    }
    a.a(a.b());
  }
}

/* Location:
 * Qualified Name:     bib
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */