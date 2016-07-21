package com.google.android.gms.search.administration;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fyo;

public class GetStorageStatsCall$PackageStats
  implements SafeParcelable
{
  public static final fyo CREATOR = new fyo();
  public String a;
  public long b;
  public boolean c;
  public long d;
  final int e;
  
  public GetStorageStatsCall$PackageStats()
  {
    e = 1;
  }
  
  public GetStorageStatsCall$PackageStats(int paramInt, String paramString, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    e = paramInt;
    a = paramString;
    b = paramLong1;
    c = paramBoolean;
    d = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, e);
    emj.a(paramParcel, 1, a, false);
    emj.a(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.administration.GetStorageStatsCall.PackageStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */