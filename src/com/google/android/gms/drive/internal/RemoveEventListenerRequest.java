package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import emj;
import fdl;

public class RemoveEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new fdl();
  final int a;
  final DriveId b;
  final int c;
  
  public RemoveEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    a = paramInt1;
    b = paramDriveId;
    c = paramInt2;
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
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.RemoveEventListenerRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */