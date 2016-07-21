package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import emj;
import fdh;

public class OpenContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<OpenContentsRequest> CREATOR = new fdh();
  final int a;
  final DriveId b;
  final int c;
  final int d;
  
  public OpenContentsRequest(int paramInt1, DriveId paramDriveId, int paramInt2, int paramInt3)
  {
    a = paramInt1;
    b = paramDriveId;
    c = paramInt2;
    d = paramInt3;
  }
  
  public OpenContentsRequest(DriveId paramDriveId, int paramInt)
  {
    this(1, paramDriveId, paramInt, 0);
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
    emj.b(paramParcel, 4, d);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.OpenContentsRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */