package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import emj;
import fgj;
import fgr;

public class OwnedByMeFilter
  extends AbstractFilter
{
  public static final fgr CREATOR = new fgr();
  final int a;
  
  public OwnedByMeFilter()
  {
    this(1);
  }
  
  public OwnedByMeFilter(int paramInt)
  {
    a = paramInt;
  }
  
  public final <F> F a(fgj<F> paramfgj)
  {
    return (F)paramfgj.b();
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
 * Qualified Name:     com.google.android.gms.drive.query.internal.OwnedByMeFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */