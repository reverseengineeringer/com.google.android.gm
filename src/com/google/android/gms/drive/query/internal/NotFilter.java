package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import emj;
import fgj;
import fgp;

public class NotFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<NotFilter> CREATOR = new fgp();
  final FilterHolder a;
  final int b;
  
  public NotFilter(int paramInt, FilterHolder paramFilterHolder)
  {
    b = paramInt;
    a = paramFilterHolder;
  }
  
  public final <T> T a(fgj<T> paramfgj)
  {
    return (T)paramfgj.a(a.k.a(paramfgj));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, b);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.NotFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */