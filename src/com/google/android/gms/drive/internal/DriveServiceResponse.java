package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fbu;

public class DriveServiceResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveServiceResponse> CREATOR = new fbu();
  final int a;
  public final IBinder b;
  
  public DriveServiceResponse(int paramInt, IBinder paramIBinder)
  {
    a = paramInt;
    b = paramIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.DriveServiceResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */