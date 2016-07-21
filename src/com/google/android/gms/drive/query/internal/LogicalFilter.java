package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import emj;
import fgj;
import fgn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new fgn();
  final Operator a;
  final List<FilterHolder> b;
  final int c;
  
  public LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    c = paramInt;
    a = paramOperator;
    b = paramList;
  }
  
  public final <T> T a(fgj<T> paramfgj)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(nextk.a(paramfgj));
    }
    return (T)paramfgj.a(a, localArrayList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, c);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.b(paramParcel, 2, b, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.LogicalFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */