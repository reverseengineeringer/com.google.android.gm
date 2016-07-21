package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import ecn;
import emj;

public class StorageStats
  implements SafeParcelable
{
  public static final ecn CREATOR = new ecn();
  final int a;
  public final RegisteredPackageInfo[] b;
  public final long c;
  public final long d;
  public final long e;
  
  public StorageStats(int paramInt, RegisteredPackageInfo[] paramArrayOfRegisteredPackageInfo, long paramLong1, long paramLong2, long paramLong3)
  {
    a = paramInt;
    b = paramArrayOfRegisteredPackageInfo;
    c = paramLong1;
    d = paramLong2;
    e = paramLong3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.a(paramParcel, 1, b, paramInt);
    emj.b(paramParcel, 1000, a);
    emj.a(paramParcel, 2, c);
    emj.a(paramParcel, 3, d);
    emj.a(paramParcel, 4, e);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appdatasearch.StorageStats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */