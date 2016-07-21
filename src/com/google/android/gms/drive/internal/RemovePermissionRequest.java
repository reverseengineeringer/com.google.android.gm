package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import emj;
import fdm;

public class RemovePermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemovePermissionRequest> CREATOR = new fdm();
  final int a;
  final DriveId b;
  final String c;
  final boolean d;
  final String e;
  
  public RemovePermissionRequest(int paramInt, DriveId paramDriveId, String paramString1, boolean paramBoolean, String paramString2)
  {
    a = paramInt;
    b = paramDriveId;
    c = paramString1;
    d = paramBoolean;
    e = paramString2;
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
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.RemovePermissionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */