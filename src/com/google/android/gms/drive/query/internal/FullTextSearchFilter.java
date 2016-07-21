package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import emj;
import fgj;
import fgk;

public class FullTextSearchFilter
  extends AbstractFilter
{
  public static final fgk CREATOR = new fgk();
  final String a;
  final int b;
  
  public FullTextSearchFilter(int paramInt, String paramString)
  {
    b = paramInt;
    a = paramString;
  }
  
  public final <F> F a(fgj<F> paramfgj)
  {
    return (F)paramfgj.a(a);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, b);
    emj.a(paramParcel, 1, a, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.query.internal.FullTextSearchFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */