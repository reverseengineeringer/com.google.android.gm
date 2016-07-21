package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import emj;
import fcb;
import java.util.List;

public class GetPermissionsResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetPermissionsResponse> CREATOR = new fcb();
  final int a;
  final List<Permission> b;
  final int c;
  
  public GetPermissionsResponse(int paramInt1, List<Permission> paramList, int paramInt2)
  {
    a = paramInt1;
    b = paramList;
    c = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.b(paramParcel, 2, b, false);
    emj.b(paramParcel, 3, c);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.internal.GetPermissionsResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */