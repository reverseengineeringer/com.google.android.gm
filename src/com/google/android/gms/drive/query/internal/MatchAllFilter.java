package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import emj;
import fgj;
import fgo;

public class MatchAllFilter
  extends AbstractFilter
{
  public static final fgo CREATOR = new fgo();
  final int a;
  
  public MatchAllFilter()
  {
    this(1);
  }
  
  public MatchAllFilter(int paramInt)
  {
    a = paramInt;
  }
  
  public final <F> F a(fgj<F> paramfgj)
  {
    return (F)paramfgj.a();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, a);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.MatchAllFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */