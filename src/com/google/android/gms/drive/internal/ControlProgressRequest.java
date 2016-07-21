package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import emj;
import fec;

public class ControlProgressRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ControlProgressRequest> CREATOR = new fec();
  final int a;
  final int b;
  final int c;
  final DriveId d;
  
  public ControlProgressRequest(int paramInt1, int paramInt2, int paramInt3, DriveId paramDriveId)
  {
    a = paramInt1;
    b = paramInt2;
    c = paramInt3;
    d = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b);
    emj.b(paramParcel, 3, c);
    emj.a(paramParcel, 4, d, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.ControlProgressRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */