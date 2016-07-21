package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import emj;
import fds;

public class UnsubscribeResourceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnsubscribeResourceRequest> CREATOR = new fds();
  final int a;
  final DriveId b;
  
  public UnsubscribeResourceRequest(int paramInt, DriveId paramDriveId)
  {
    a = paramInt;
    b = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, paramInt, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.UnsubscribeResourceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */