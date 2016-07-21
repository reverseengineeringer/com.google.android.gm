package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;
import emj;
import fcy;

public class AddPermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddPermissionRequest> CREATOR = new fcy();
  final int a;
  final DriveId b;
  final Permission c;
  final boolean d;
  final String e;
  final boolean f;
  final String g;
  
  public AddPermissionRequest(int paramInt, DriveId paramDriveId, Permission paramPermission, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    a = paramInt;
    b = paramDriveId;
    c = paramPermission;
    d = paramBoolean1;
    e = paramString1;
    f = paramBoolean2;
    g = paramString2;
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
    emj.a(paramParcel, 3, c, paramInt, false);
    emj.a(paramParcel, 4, d);
    emj.a(paramParcel, 5, e, false);
    emj.a(paramParcel, 6, f);
    emj.a(paramParcel, 7, g, false);
    emj.b(paramParcel, i);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.AddPermissionRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */