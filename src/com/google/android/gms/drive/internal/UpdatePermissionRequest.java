package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import emj;
import fdv;

public class UpdatePermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UpdatePermissionRequest> CREATOR = new fdv();
  final int a;
  final DriveId b;
  final String c;
  final int d;
  final boolean e;
  final String f;
  
  public UpdatePermissionRequest(int paramInt1, DriveId paramDriveId, String paramString1, int paramInt2, boolean paramBoolean, String paramString2)
  {
    a = paramInt1;
    b = paramDriveId;
    c = paramString1;
    d = paramInt2;
    e = paramBoolean;
    f = paramString2;
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
    emj.a(paramParcel, 3, c, false);
    emj.b(paramParcel, 4, d);
    emj.a(paramParcel, 5, e);
    emj.a(paramParcel, 6, f, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.UpdatePermissionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */