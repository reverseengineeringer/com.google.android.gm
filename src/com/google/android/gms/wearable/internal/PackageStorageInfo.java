package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import ggg;

public class PackageStorageInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<PackageStorageInfo> CREATOR = new ggg();
  public final int a;
  public final String b;
  public final String c;
  public final long d;
  
  public PackageStorageInfo(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    a = paramInt;
    b = paramString1;
    c = paramString2;
    d = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c, false);
    emj.a(paramParcel, 4, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.PackageStorageInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */