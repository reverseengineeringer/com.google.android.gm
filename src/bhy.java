import android.database.Cursor;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

final class bhy
  extends Filter
{
  bhy(bhx parambhx) {}
  
  public final CharSequence convertResultToString(Object paramObject)
  {
    Object localObject = (bkn)paramObject;
    paramObject = c;
    localObject = d;
    if ((TextUtils.isEmpty((CharSequence)paramObject)) || (TextUtils.equals((CharSequence)paramObject, (CharSequence)localObject))) {
      return (CharSequence)localObject;
    }
    return new Rfc822Token((String)paramObject, (String)localObject, null).toString();
  }
  
  protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    localArrayList = null;
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (TextUtils.isEmpty(paramCharSequence))
    {
      a.j = null;
      return localFilterResults;
    }
    if (!big.a(a.c, a.o))
    {
      a.j = null;
      if (!a.n) {
        return localFilterResults;
      }
      paramCharSequence = bkn.a(big.a);
      values = new bhz(Collections.singletonList(paramCharSequence), new LinkedHashMap(), Collections.singletonList(paramCharSequence), Collections.emptySet(), null);
      count = 1;
      return localFilterResults;
    }
    try
    {
      localObject = a.a(paramCharSequence, a.e, null);
      if (localObject == null) {
        break label255;
      }
      try
      {
        paramCharSequence = new LinkedHashMap();
        localArrayList = new ArrayList();
        localHashSet = new HashSet();
        while (((Cursor)localObject).moveToNext()) {
          bhx.a(new bif((Cursor)localObject, null), true, paramCharSequence, localArrayList, localHashSet);
        }
        if (localObject == null) {
          break label203;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        HashSet localHashSet;
        List localList;
        Object localObject = localArrayList;
      }
    }
    ((Cursor)localObject).close();
    label203:
    throw paramCharSequence;
    localList = a.a(paramCharSequence, localArrayList);
    values = new bhz(localList, paramCharSequence, localArrayList, localHashSet, a.a(localHashSet));
    count = localList.size();
    label255:
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    return localFilterResults;
  }
  
  protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    a.l = paramCharSequence;
    a.j = null;
    if (values != null)
    {
      paramFilterResults = (bhz)values;
      a.g = b;
      a.h = c;
      a.i = d;
      bhx localbhx = a;
      int j = a.size();
      if (e == null) {}
      for (int i = 0;; i = e.size())
      {
        localbhx.a(j, i);
        a.a(a);
        if (e != null)
        {
          i = a.e;
          j = d.size();
          a.a(paramCharSequence, e, i - j);
        }
        return;
      }
    }
    a.a(Collections.emptyList());
  }
}

/* Location:
 * Qualified Name:     bhy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */