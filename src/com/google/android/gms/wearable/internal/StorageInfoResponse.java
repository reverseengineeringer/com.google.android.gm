package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import ggm;
import java.util.List;

public class StorageInfoResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<StorageInfoResponse> CREATOR = new ggm();
  public final int a;
  public final int b;
  public final long c;
  public final List<PackageStorageInfo> d;
  
  public StorageInfoResponse(int paramInt1, int paramInt2, long paramLong, List<PackageStorageInfo> paramList)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramLong;
    d = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, 4, d, false);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.wearable.internal.StorageInfoResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */