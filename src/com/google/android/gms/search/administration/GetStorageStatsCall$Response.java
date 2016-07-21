package com.google.android.gms.search.administration;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ejk;
import emj;
import fyq;

public class GetStorageStatsCall$Response
  implements SafeParcelable, ejk
{
  public static final fyq CREATOR = new fyq();
  public Status a;
  public GetStorageStatsCall.PackageStats[] b;
  public long c;
  public long d;
  public long e;
  final int f;
  
  public GetStorageStatsCall$Response()
  {
    f = 1;
  }
  
  public GetStorageStatsCall$Response(int paramInt, Status paramStatus, GetStorageStatsCall.PackageStats[] paramArrayOfPackageStats, long paramLong1, long paramLong2, long paramLong3)
  {
    f = paramInt;
    a = paramStatus;
    b = paramArrayOfPackageStats;
    c = paramLong1;
    d = paramLong2;
    e = paramLong3;
  }
  
  public final Status a()
  {
    return a;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1000, f);
    emj.a(paramParcel, 1, a, paramInt, false);
    emj.a(paramParcel, 2, b, paramInt);
    emj.a(paramParcel, 3, c);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.search.administration.GetStorageStatsCall.Response
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */