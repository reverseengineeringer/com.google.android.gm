package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import emj;
import fgs;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new fgs();
  final LogicalFilter a;
  final String b;
  final SortOrder c;
  final List<String> d;
  final boolean e;
  final List<DriveSpace> f;
  final int g;
  private final Set<DriveSpace> h;
  
  public Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean, List<DriveSpace> paramList1) {}
  
  private Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean, List<DriveSpace> paramList1, Set<DriveSpace> paramSet)
  {
    g = paramInt;
    a = paramLogicalFilter;
    b = paramString;
    c = paramSortOrder;
    d = paramList;
    e = paramBoolean;
    f = paramList1;
    h = paramSet;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[] { a, c, b, f });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, g);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.a(paramParcel, 3, b, false);
    emj.a(paramParcel, 4, c, paramInt, false);
    emj.a(paramParcel, 5, d, false);
    emj.a(paramParcel, 6, e);
    emj.b(paramParcel, 7, f, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.Query
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */