package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import ffw;

public class PartialDriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<PartialDriveId> CREATOR = new ffw();
  final int a;
  final String b;
  final long c;
  final int d;
  
  public PartialDriveId(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    a = paramInt1;
    b = paramString;
    c = paramLong;
    d = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = emj.a(paramParcel, 20293);
    emj.b(paramParcel, 1, a);
    emj.a(paramParcel, 2, b, false);
    emj.a(paramParcel, 3, c);
    emj.b(paramParcel, 4, d);
    emj.b(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.PartialDriveId
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */