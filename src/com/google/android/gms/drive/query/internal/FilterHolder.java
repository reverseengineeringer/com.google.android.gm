package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import emj;
import enz;
import fgh;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new fgh();
  final int a;
  final ComparisonFilter<?> b;
  final FieldOnlyFilter c;
  final LogicalFilter d;
  final NotFilter e;
  final InFilter<?> f;
  final MatchAllFilter g;
  final HasFilter h;
  final FullTextSearchFilter i;
  final OwnedByMeFilter j;
  final Filter k;
  
  public FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter, FullTextSearchFilter paramFullTextSearchFilter, OwnedByMeFilter paramOwnedByMeFilter)
  {
    a = paramInt;
    b = paramComparisonFilter;
    c = paramFieldOnlyFilter;
    d = paramLogicalFilter;
    e = paramNotFilter;
    f = paramInFilter;
    g = paramMatchAllFilter;
    h = paramHasFilter;
    i = paramFullTextSearchFilter;
    j = paramOwnedByMeFilter;
    if (b != null)
    {
      k = b;
      return;
    }
    if (c != null)
    {
      k = c;
      return;
    }
    if (d != null)
    {
      k = d;
      return;
    }
    if (e != null)
    {
      k = e;
      return;
    }
    if (f != null)
    {
      k = f;
      return;
    }
    if (g != null)
    {
      k = g;
      return;
    }
    if (h != null)
    {
      k = h;
      return;
    }
    if (i != null)
    {
      k = i;
      return;
    }
    if (j != null)
    {
      k = j;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    enz.a(paramFilter, "Null filter.");
    a = 2;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)paramFilter;
      b = ((ComparisonFilter)localObject);
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label247;
      }
      localObject = (FieldOnlyFilter)paramFilter;
      label45:
      c = ((FieldOnlyFilter)localObject);
      if (!(paramFilter instanceof LogicalFilter)) {
        break label252;
      }
      localObject = (LogicalFilter)paramFilter;
      label62:
      d = ((LogicalFilter)localObject);
      if (!(paramFilter instanceof NotFilter)) {
        break label257;
      }
      localObject = (NotFilter)paramFilter;
      label79:
      e = ((NotFilter)localObject);
      if (!(paramFilter instanceof InFilter)) {
        break label262;
      }
      localObject = (InFilter)paramFilter;
      label96:
      f = ((InFilter)localObject);
      if (!(paramFilter instanceof MatchAllFilter)) {
        break label267;
      }
      localObject = (MatchAllFilter)paramFilter;
      label113:
      g = ((MatchAllFilter)localObject);
      if (!(paramFilter instanceof HasFilter)) {
        break label272;
      }
      localObject = (HasFilter)paramFilter;
      label130:
      h = ((HasFilter)localObject);
      if (!(paramFilter instanceof FullTextSearchFilter)) {
        break label277;
      }
      localObject = (FullTextSearchFilter)paramFilter;
      label147:
      i = ((FullTextSearchFilter)localObject);
      if (!(paramFilter instanceof OwnedByMeFilter)) {
        break label282;
      }
    }
    label247:
    label252:
    label257:
    label262:
    label267:
    label272:
    label277:
    label282:
    for (Object localObject = (OwnedByMeFilter)paramFilter;; localObject = null)
    {
      j = ((OwnedByMeFilter)localObject);
      if ((b != null) || (c != null) || (d != null) || (e != null) || (f != null) || (g != null) || (h != null) || (i != null) || (j != null)) {
        break label287;
      }
      throw new IllegalArgumentException("Invalid filter type.");
      localObject = null;
      break;
      localObject = null;
      break label45;
      localObject = null;
      break label62;
      localObject = null;
      break label79;
      localObject = null;
      break label96;
      localObject = null;
      break label113;
      localObject = null;
      break label130;
      localObject = null;
      break label147;
    }
    label287:
    k = paramFilter;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format("FilterHolder[%s]", new Object[] { k });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt, false);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c, paramInt, false);
    emj.a(paramParcel, 3, d, paramInt, false);
    emj.a(paramParcel, 4, e, paramInt, false);
    emj.a(paramParcel, 5, f, paramInt, false);
    emj.a(paramParcel, 6, g, paramInt, false);
    emj.a(paramParcel, 7, h, paramInt, false);
    emj.a(paramParcel, 8, i, paramInt, false);
    emj.a(paramParcel, 9, j, paramInt, false);
    emj.b(paramParcel, m);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.FilterHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */