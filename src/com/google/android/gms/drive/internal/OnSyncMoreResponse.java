package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import emj;
import fdg;

public class OnSyncMoreResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnSyncMoreResponse> CREATOR = new fdg();
  final int a;
  final boolean b;
  
  public OnSyncMoreResponse(int paramInt, boolean paramBoolean)
  {
    a = paramInt;
    b = paramBoolean;
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
 * Qualified Name:     com.google.android.gms.drive.internal.OnSyncMoreResponse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */